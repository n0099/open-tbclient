package com.baidu.tieba.mainentrance;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateBarActivityConfig;
import com.baidu.tbadk.core.atomData.CreateBarGuideActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.RequestEnterForumDataMessage;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.search.ResponseSearchFriendMessage;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.mainentrance.d;
import com.baidu.tieba.n;
import com.baidu.tieba.postsearch.j;
import com.baidu.tieba.tbadkCore.FRSPageRequestMessage;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class SquareSearchActivity extends BaseActivity<SquareSearchActivity> implements BdListView.e, d.a {
    private FragmentTabWidget aQn;
    private boolean awj;
    private List<com.baidu.tieba.mainentrance.c> ckW;
    private BdListView clA;
    private com.baidu.tieba.mainentrance.a clB;
    private com.baidu.tieba.postsearch.v clC;
    private d clD;
    private ForumSuggestModel clE;
    private com.baidu.tieba.postsearch.j clF;
    private a clG;
    private b clH;
    private String clJ;
    private String clK;
    private String clL;
    private String clM;
    private boolean clP;
    private boolean clR;
    private boolean clT;
    private SearchPageFocusBar clU;
    private ScrollView clV;
    private SearchPageFocusBar clW;
    private View clX;
    private View clY;
    private View clZ;
    private FragmentTabIndicator clj;
    private LinearLayoutDetectsSoftKeyboard clk;
    private FrameLayout cll;
    private FrameLayout clm;
    private EditText cln;
    private TextView clo;
    private TextView clp;
    private ImageView clq;
    private View clr;
    private View cls;
    private ListView clt;
    private com.baidu.tieba.mainentrance.b clu;
    private List<g> clv;
    private m clw;
    private h clx;
    private LinearLayout cly;
    private PbListView clz;
    private View cmb;
    private TextView cmc;
    private View cme;
    private f mHotSearchInfo;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.n mNoDataView;
    private boolean clI = false;
    private int mMode = 0;
    private int clN = 0;
    private int clO = -1;
    private boolean arX = true;
    private boolean clQ = true;
    private boolean clS = false;
    private List<View> cma = new ArrayList();
    private Runnable cmf = new n(this);
    private final View.OnClickListener cmg = new y(this);
    private final com.baidu.adp.framework.listener.e cmh = new ak(this, 301001, true);
    private final HttpMessageListener cmi = new an(this, CmdConfigHttp.FRS_HTTP_CMD, true);
    private CustomMessageListener cmj = new ao(this, CmdConfigCustom.CMD_READ_SEARCHPERSON_HISTORY);
    private CustomMessageListener cmk = new ap(this, CmdConfigCustom.CMD_WRITE_SEARCHPERSON_HISTORY);
    private HttpMessageListener cml = new aq(this, CmdConfigHttp.SEARCH_FRIEND_CMD);
    private final Runnable cmm = new ar(this);
    private CustomMessageListener cmn = new as(this, CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA);
    private CustomMessageListener cmo = new o(this, CmdConfigCustom.GET_ALL_SEARCH_POST_DATA);
    private View.OnClickListener cmp = new p(this);
    private CustomMessageListener cmq = new q(this, CmdConfigCustom.CMD_ENTER_FORUM_INFO);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponsedMessage<?> responsedMessage, boolean z) {
        int error = responsedMessage.getError();
        String string = StringUtils.isNull(responsedMessage.getErrorString()) ? getResources().getString(n.i.neterror) : responsedMessage.getErrorString();
        boolean z2 = error < -13 || error > -10;
        if (error == 0) {
            this.clI = true;
            sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createFlagCfg(this.clM, FrsActivityConfig.FRS_FROM_SEARCH, 1)));
        } else if (z2 && z && error == 3) {
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(n.i.login_to_use), true, 11013)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), this.clM)));
            }
        } else {
            showToast(string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean afb() {
        if (this.mMode == 0 && this.mHotSearchInfo != null) {
            if (this.mHotSearchInfo.getType() == 0) {
                jt(this.mHotSearchInfo.getName());
            } else if (this.mHotSearchInfo.getType() == 1) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "")));
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10355").ab("obj_name", this.mHotSearchInfo.getName()).r("obj_type", this.mHotSearchInfo.getType() == 0 ? 2 : 1));
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gw(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SEARCH_FRIEND_CMD);
        httpMessage.addParam("search_key", str);
        sendMessage(httpMessage);
    }

    private void Hy() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SEARCH_FRIEND_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SEARCH_FRIEND);
        tbHttpMessageTask.setResponsedClass(ResponseSearchFriendMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 11013:
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), this.clM)));
                    finish();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.g.home_dialog_search);
        init();
        getWindow().setSoftInputMode(1);
        Hy();
        registerListener(this.cmj);
        registerListener(this.cmk);
        registerListener(this.cmn);
        registerListener(this.cmo);
        registerListener(this.cml);
        registerListener(this.cmh);
        registerListener(this.cmi);
        registerListener(this.cmq);
        this.clT = com.baidu.tbadk.core.sharedPref.b.tZ().getBoolean("search_post_show_dropmenu", true);
        if (SquareSearchActivityConfig.IS_SHOW_RECOMMEND_FORUM) {
            this.clD = new d(this, this);
            this.clD.afa();
            this.clD.aeZ();
        }
        this.clP = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mMode == 0 && this.clI) {
            this.clI = false;
            if (this.clE != null && this.clE.forum_list != null && this.clE.forum_list.size() > 0) {
                aft();
                this.clA.setAdapter((ListAdapter) this.clB);
                this.clB.jq(this.clJ);
                this.clB.O(this.clE.forum_list);
                this.clB.notifyDataSetInvalidated();
            }
        }
        this.arX = true;
        if (this.clQ) {
            this.mHandler.post(this.cmf);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mMode = 0;
        if (this.mMode == 0) {
            TbadkSettings.getInst().saveBoolean("search_mode", true);
        } else {
            TbadkSettings.getInst().saveBoolean("search_mode", false);
        }
        hideLoadingView(this.cll);
        this.mHandler.removeCallbacks(this.cmf);
        afc();
    }

    public void afc() {
        this.mHandler.removeCallbacks(this.cmm);
        if (this.clG != null) {
            this.clG.cancel();
            this.clG = null;
        }
        if (this.clH != null) {
            this.clH.cancel();
            this.clH = null;
        }
    }

    private void init() {
        this.clk = (LinearLayoutDetectsSoftKeyboard) findViewById(n.f.parent);
        this.clk.setOnSoftKeyBoardShownListener(new r(this));
        this.clk.setOnTouchListener(new s(this));
        Qi();
        Qh();
        this.cll = (FrameLayout) findViewById(n.f.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(n.d.ds80)), null, null);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            this.clV = (ScrollView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(n.g.home_searchbar_nodataview, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) this.clV.findViewById(n.f.focusbar_nodata_root);
            this.clW = (SearchPageFocusBar) linearLayout.findViewById(n.f.no_data_focusbar);
            linearLayout.addView(this.mNoDataView, 0);
            this.clV.setOnTouchListener(new t(this));
            this.cll.addView(this.clV, this.cll.getChildCount());
        } else {
            this.cll.addView(this.mNoDataView, 0);
        }
        this.clm = (FrameLayout) findViewById(n.f.home_search_list);
        afk();
        afd();
        aff();
        afe();
        afg();
        this.clr = findViewById(n.f.empty_search_result);
        this.cmb = this.clr.findViewById(n.f.empty_result_divider_1);
        this.cmc = (TextView) this.clr.findViewById(n.f.create_bar_guide);
        this.cme = this.clr.findViewById(n.f.empty_result_divider_2);
        afh();
        this.cln.setText("");
        this.cln.requestFocus();
        ShowSoftKeyPadDelay(this.cln, 200);
        if (TbadkSettings.getInst().loadBoolean("search_mode", true)) {
            jj(0);
            afj();
            return;
        }
        jj(1);
    }

    private void Qh() {
        this.mNavigationBar = (NavigationBar) findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new u(this));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, n.g.square_search_navigation_view, (View.OnClickListener) null);
        this.clq = (ImageView) addCustomView.findViewById(n.f.search_bar_icon);
        this.cln = (EditText) addCustomView.findViewById(n.f.home_et_search);
        this.clo = (TextView) addCustomView.findViewById(n.f.home_bt_search_del);
        this.clp = (TextView) addCustomView.findViewById(n.f.home_bt_search_s);
        this.cln.setOnFocusChangeListener(new v(this));
        this.clp.setText(getPageContext().getString(n.i.forward));
        this.clp.setOnClickListener(this.cmg);
        this.cln.setOnEditorActionListener(new w(this));
        this.clo.setOnClickListener(new x(this));
        this.cln.addTextChangedListener(new z(this));
    }

    private void Qi() {
        this.aQn = (FragmentTabWidget) findViewById(n.f.square_search_tab_widget);
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(n.d.ds32));
        fragmentTabIndicator.setGravity(17);
        fragmentTabIndicator.avG = n.c.s_actionbar_text_color;
        fragmentTabIndicator.setText(getResources().getString(n.i.search_bar_text));
        this.clj = new FragmentTabIndicator(getPageContext().getPageActivity());
        this.clj.avG = n.c.s_actionbar_text_color;
        this.clj.setTextSize(0, getResources().getDimension(n.d.ds32));
        this.clj.setGravity(17);
        this.clj.setCompoundDrawablesRightResId(n.e.icon_toolbar_arrow_down);
        this.clj.setCompoundDrawablePadding(getResources().getDimensionPixelSize(n.d.ds10));
        this.clj.setText(getResources().getString(n.i.search_post_text));
        this.clj.Dp();
        FragmentTabIndicator fragmentTabIndicator2 = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator2.avG = n.c.s_actionbar_text_color;
        fragmentTabIndicator2.setTextSize(0, getResources().getDimension(n.d.ds32));
        fragmentTabIndicator2.setGravity(17);
        fragmentTabIndicator2.setText(getResources().getString(n.i.search_person));
        this.aQn.addView(fragmentTabIndicator);
        this.aQn.addView(this.clj);
        this.aQn.addView(fragmentTabIndicator2);
        this.aQn.d(0, true);
        this.aQn.setTabSelectionListener(new aa(this));
    }

    private void afd() {
        this.clt = (ListView) findViewById(n.f.home_lv_search_history);
        if (this.cly == null) {
            this.cly = new LinearLayout(getPageContext().getPageActivity());
            this.cly.setOrientation(1);
            this.cly.setBackgroundColor(com.baidu.tbadk.core.util.as.getColor(n.c.cp_bg_line_d));
        }
        this.clt.addFooterView(this.cly);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            afz();
        }
        this.clu = new com.baidu.tieba.mainentrance.b(this);
        this.clt.setAdapter((ListAdapter) this.clu);
        this.clu.r(new ab(this));
    }

    private void afe() {
        if (this.clx == null) {
            this.clx = new h(getPageContext());
            this.clt.addHeaderView(this.clx.getView());
        }
    }

    private void aff() {
        if (this.clw == null) {
            this.clw = new m(getPageContext());
            this.clt.addHeaderView(this.clw.nv());
        }
    }

    private void afg() {
        this.clA = (BdListView) findViewById(n.f.home_lv_search_suggest);
        this.clB = new com.baidu.tieba.mainentrance.a(this, null);
        this.clC = new com.baidu.tieba.postsearch.v(getPageContext());
        this.clA.setOnItemClickListener(new ac(this));
        ad adVar = new ad(this);
        this.clA.setOnScrollListener(adVar);
        this.clt.setOnScrollListener(adVar);
        this.clA.setOnSrollToBottomListener(this);
    }

    private void afh() {
        this.cls = findViewById(n.f.search_dropmenu);
        TextView textView = (TextView) this.cls.findViewById(n.f.dropmenu_all_text);
        textView.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.c.cp_link_tip_a));
        ImageView imageView = (ImageView) this.cls.findViewById(n.f.dropmenu_all_icon);
        imageView.setImageDrawable(com.baidu.tbadk.core.util.as.getDrawable(n.e.chx_tips_list_ok));
        imageView.setVisibility(0);
        TextView textView2 = (TextView) this.cls.findViewById(n.f.dropmenu_thread_text);
        textView2.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.c.cp_cont_c));
        ImageView imageView2 = (ImageView) this.cls.findViewById(n.f.dropmenu_thread_icon);
        imageView2.setImageDrawable(com.baidu.tbadk.core.util.as.getDrawable(n.e.chx_tips_list_ok));
        imageView2.setVisibility(8);
        this.cls.findViewById(n.f.dropmenu_all_layout).setOnClickListener(new ae(this, textView, imageView, textView2, imageView2));
        this.cls.findViewById(n.f.dropmenu_thread_layout).setOnClickListener(new af(this, textView, imageView, textView2, imageView2));
        this.cls.findViewById(n.f.dropmenu_lower_part).setOnClickListener(new ag(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afi() {
        if (this.clm.getVisibility() == 8 && this.mNoDataView.getVisibility() == 8 && this.clr.getVisibility() == 8) {
            X(this.clV);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cS(n.i.text_no_search_record));
        }
    }

    public void jj(int i) {
        switch (i) {
            case 0:
                if (this.mMode != 0) {
                    this.mMode = 0;
                    this.clp.setText(getPageContext().getString(n.i.forward));
                    afj();
                    afc();
                    afr();
                    if (this.clJ.trim().length() > 0) {
                        afq();
                        return;
                    } else {
                        afm();
                        return;
                    }
                }
                return;
            case 1:
                if (this.mMode != 1) {
                    this.mMode = 1;
                    this.clp.setText(getPageContext().getString(n.i.search));
                    this.cln.setHint(n.i.search_post_hint);
                    afc();
                    afr();
                    if (this.clJ.trim().length() > 0) {
                        this.clA.setVisibility(8);
                        I(1, this.clJ);
                        return;
                    }
                    afn();
                    return;
                }
                return;
            case 2:
            default:
                return;
            case 3:
                if (this.mMode != 3) {
                    this.mMode = 3;
                    this.clA.setVisibility(8);
                    this.clr.setVisibility(8);
                    this.cls.setVisibility(8);
                    this.clp.setText(n.i.search);
                    this.cln.setHint(n.i.search_friend_tip);
                    afr();
                    afc();
                    afo();
                    return;
                }
                return;
        }
    }

    private void afj() {
        if (this.mHotSearchInfo == null) {
            this.cln.setHint(n.i.search_bar);
        } else {
            this.cln.setHint(UtilHelper.getFixedText(this.mHotSearchInfo.JE(), 12));
        }
    }

    private void afk() {
        long j = com.baidu.tbadk.core.sharedPref.b.tZ().getLong("hot_search_id", 0L);
        if (j != 0) {
            this.mHotSearchInfo = new f();
            this.mHotSearchInfo.setId(j);
            this.mHotSearchInfo.setName(com.baidu.tbadk.core.sharedPref.b.tZ().getString("hot_search_name", ""));
            this.mHotSearchInfo.js(com.baidu.tbadk.core.sharedPref.b.tZ().getString("hot_search_title", ""));
            this.mHotSearchInfo.bb(com.baidu.tbadk.core.sharedPref.b.tZ().getLong("hot_search_type", 0L));
        }
    }

    public void afl() {
        jt(this.cln.getText().toString().trim());
    }

    private void jt(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (com.baidu.adp.lib.util.i.iP()) {
                this.clM = str;
                this.arX = false;
                sendMessage(ju(str));
                return;
            }
            showToast(n.i.neterror);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afm() {
        this.clA.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA));
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            en(true);
            Y(this.clW);
            Y(this.clV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afn() {
        this.clA.setVisibility(8);
        Y(this.clU);
        Y(this.clW);
        Y(this.clV);
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afo() {
        this.clA.setVisibility(8);
        Y(this.clU);
        Y(this.clW);
        Y(this.clV);
        if (!this.awj) {
            sendMessage(new RequestSearchPersonHistoryReadMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ArrayList<String> arrayList) {
        boolean z = false;
        if (b(i, arrayList) || c(i, arrayList) || d(i, arrayList)) {
            afv();
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cS(n.i.text_no_search_record));
            return;
        }
        afu();
        List<com.baidu.tieba.mainentrance.c> arrayList2 = new ArrayList<>();
        if (i == 4) {
            arrayList2 = this.ckW;
        }
        a(i, arrayList, (this.ckW == null ? 0 : arrayList2.size()) >= 2);
        boolean z2 = i == 4;
        if (arrayList == null || arrayList.size() == 0) {
            z = true;
        }
        j(z2, z);
        if (i == 4) {
            afj();
        }
        if (i == 4 && this.ckW.size() >= 2) {
            this.clx.show();
        } else {
            this.clx.hide();
        }
        this.clu.bh(arrayList2);
        this.clu.notifyDataSetChanged();
    }

    private void a(int i, ArrayList<String> arrayList, boolean z) {
        if (this.cly != null) {
            this.cly.removeAllViews();
            if (arrayList != null && !arrayList.isEmpty() && getActivity() != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                if (z) {
                    this.clX = new View(pageActivity);
                    this.clX.setBackgroundColor(com.baidu.tbadk.core.util.as.getColor(n.c.cp_bg_line_b));
                    layoutParams.height = com.baidu.adp.lib.util.k.d(pageActivity, n.d.ds12);
                    layoutParams.topMargin = com.baidu.adp.lib.util.k.d(pageActivity, n.d.ds14);
                    this.cly.addView(this.clX, layoutParams);
                }
                this.clY = LayoutInflater.from(pageActivity).inflate(n.g.square_search_recommand_fourm_header, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                getLayoutMode().k(this.clY);
                this.cly.addView(this.clY, layoutParams2);
                int size = arrayList.size();
                this.cma.clear();
                for (int i2 = 0; i2 < size; i2++) {
                    String str = arrayList.get(i2);
                    if (!TextUtils.isEmpty(str)) {
                        View inflate = LayoutInflater.from(pageActivity).inflate(n.g.home_dialog_search_item, (ViewGroup) null);
                        ((TextView) inflate.findViewById(n.f.home_lv_search_forum)).setText(str);
                        com.baidu.tbadk.core.util.as.b((TextView) inflate.findViewById(n.f.home_lv_search_forum), n.c.cp_cont_b, 1);
                        inflate.findViewById(n.f.home_dialog_lv_search_forum_divider).setVisibility(8);
                        com.baidu.tbadk.core.util.as.i(inflate, n.e.square_search_item_bg);
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                        inflate.setOnClickListener(new c(str));
                        this.cma.add(inflate);
                        this.cly.addView(inflate, layoutParams3);
                    }
                }
                this.clZ = LayoutInflater.from(pageActivity).inflate(n.g.home_dialog_search_footer, (ViewGroup) null);
                ((TextView) this.clZ.findViewById(n.f.home_bt_search_footer)).setTextColor(com.baidu.tbadk.core.util.as.getColor(n.c.s_actionbar_text_line_color_s));
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                this.clZ.setOnClickListener(new ah(this));
                this.cly.addView(this.clZ, layoutParams4);
            }
        }
    }

    private void j(boolean z, boolean z2) {
        int size;
        if (this.clw != null) {
            this.clw.clear();
            if (this.clv != null && !this.clv.isEmpty() && z && (size = this.clv.size()) >= 2) {
                int i = size <= 4 ? size : 4;
                int i2 = i % 2 != 0 ? i - 1 : i;
                for (int i3 = 0; i3 < i2; i3++) {
                    g gVar = (g) com.baidu.tbadk.core.util.y.b(this.clv, i3);
                    if (gVar != null) {
                        this.clw.a(gVar, i3).setOnClickListener(this.cmp);
                    }
                }
                this.clw.el(((this.ckW == null || this.ckW.size() == 0) && z2) ? false : true);
                this.clw.show();
            }
        }
    }

    private boolean b(int i, ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && (this.ckW == null || this.ckW.size() <= 2) && 4 == i && this.mMode == 0 && (this.clv == null || this.clv.size() <= 2);
    }

    private boolean c(int i, ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && i == 5 && this.mMode != 5;
    }

    private boolean d(int i, ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && i == 6 && this.mMode != 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afp() {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).cC(getPageContext().getString(n.i.alert_clean_history)).a(getPageContext().getString(n.i.clear_all_text), new ai(this)).b(getPageContext().getString(n.i.alert_no_button), new al(this)).b(getPageContext()).tv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afq() {
        this.clm.setVisibility(8);
        if (this.clJ != null) {
            if (this.clJ.equals(this.clK)) {
                refresh();
                return;
            }
            Y(this.clU);
            Y(this.clW);
            Y(this.clV);
            this.mHandler.removeCallbacks(this.cmm);
            this.mHandler.postDelayed(this.cmm, 500L);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v5 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void I(int i, String str) {
        this.clt.setVisibility(8);
        if (str != null && str.trim().length() > 0) {
            int i2 = this.clR ? 1 : 0;
            if (str.equals(this.clL) && i == this.clN && this.clO == i2) {
                refresh();
                return;
            }
            this.clO = i2;
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append(TbConfig.SERVER_ADDRESS);
            stringBuffer.append(TbConfig.POST_SEARCH_URL);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("word", str));
            arrayList.add(new BasicNameValuePair("pn", String.valueOf(i)));
            arrayList.add(new BasicNameValuePair("rn", String.valueOf(50)));
            arrayList.add(new BasicNameValuePair("only_thread", new StringBuilder().append(i2).toString()));
            arrayList.add(new BasicNameValuePair("st_type", "search_post"));
            afc();
            this.clH = new b(stringBuffer.toString(), arrayList);
            this.clH.setPriority(3);
            this.clH.execute(new Object[0]);
            this.clS = true;
        }
    }

    private FRSPageRequestMessage ju(String str) {
        FRSPageRequestMessage fRSPageRequestMessage = new FRSPageRequestMessage();
        fRSPageRequestMessage.setKw(str);
        fRSPageRequestMessage.setPn(1);
        if (com.baidu.tbadk.core.m.rh().rn()) {
            fRSPageRequestMessage.setRn(35);
        } else {
            fRSPageRequestMessage.setRn(50);
        }
        fRSPageRequestMessage.setWithGroup(1);
        int K = com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity());
        int L = com.baidu.adp.lib.util.k.L(getPageContext().getPageActivity());
        float f = K / 320.0f;
        int i = ay.vq().vs() ? 2 : 1;
        fRSPageRequestMessage.setScrW(K);
        fRSPageRequestMessage.setScrH(L);
        fRSPageRequestMessage.setScrDip(f);
        fRSPageRequestMessage.setqType(i);
        return fRSPageRequestMessage;
    }

    private void afr() {
        if (this.clA != null) {
            this.clA.setNextPage(null);
        }
        if (this.clC != null) {
            this.clC.clear();
            this.clC.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        int i;
        int i2 = 0;
        try {
            if (this.mMode == 0) {
                if (this.clE != null) {
                    if (this.clE.forum_list != null && this.clE.forum_list.size() > 0) {
                        aft();
                        this.clA.setAdapter((ListAdapter) this.clB);
                        this.clB.jq(this.clJ);
                        this.clB.O(this.clE.forum_list);
                        this.clB.notifyDataSetInvalidated();
                        return;
                    }
                    Y(this.clV);
                    afx();
                    afs();
                }
            } else if (this.clF != null) {
                List<j.a> list = this.clF.cME;
                if (list != null && list.size() > 0) {
                    aft();
                    if (this.clF.getCurrentPage() == 1) {
                        this.clA.setVisibility(0);
                        this.clC.clear();
                        this.clA.setAdapter((ListAdapter) this.clC);
                        this.clA.setNextPage(afy());
                    }
                    if (!this.clF.isHasMore()) {
                        afy().setText(getResources().getString(n.i.list_no_more));
                        afy().wf();
                    }
                    int bz = this.clC.bz(list);
                    if (bz > 0) {
                        i = this.clA.getFirstVisiblePosition() - bz;
                        View childAt = this.clA.getChildAt(0);
                        if (childAt != null) {
                            i2 = childAt.getTop();
                        }
                    } else {
                        i = 0;
                    }
                    this.clC.notifyDataSetChanged();
                    if (bz > 0) {
                        this.clA.setSelectionFromTop(i, i2);
                    }
                    if (this.clT) {
                        this.cls.setVisibility(0);
                        this.clT = false;
                        com.baidu.tbadk.core.sharedPref.b.tZ().putBoolean("search_post_show_dropmenu", false);
                    }
                } else if (this.mNoDataView.getVisibility() != 0) {
                    afv();
                    Y(this.clW);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cS(n.i.text_no_suggest));
                }
            } else if (this.mNoDataView.getVisibility() != 0) {
                afv();
                Y(this.clW);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.cS(n.i.text_no_suggest));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void afs() {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.baidu.tbadk.core.util.as.getColor(n.c.cp_cont_h));
        TextView textView = (TextView) this.clr.findViewById(n.f.no_bar_found);
        textView.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.c.cp_cont_c));
        TextView textView2 = (TextView) this.clr.findViewById(n.f.create_bar_guide);
        textView2.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.c.cp_cont_b));
        String str = "";
        if (this.clJ != null) {
            str = this.clJ.length() > 6 ? String.valueOf(this.clJ.substring(0, 6)) + "..." : this.clJ;
        }
        String format = String.format(getPageContext().getString(n.i.empty_search_result_format), str);
        String format2 = String.format(getPageContext().getString(n.i.create_bar_guide_format), str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
        spannableStringBuilder.setSpan(foregroundColorSpan, 4, format.length() - 2, 33);
        textView.setText(spannableStringBuilder);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(format2);
        spannableStringBuilder2.setSpan(foregroundColorSpan, 5, format2.length() - 5, 33);
        textView2.setText(spannableStringBuilder2);
        Drawable drawable = com.baidu.tbadk.core.util.as.getDrawable(n.e.icon_search_list_add);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        textView2.setCompoundDrawablePadding(com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), n.d.ds10));
        textView2.setCompoundDrawables(drawable, null, null, null);
        textView2.setOnClickListener(new am(this));
    }

    private void aft() {
        this.clm.setVisibility(0);
        this.clA.setVisibility(0);
        this.clt.setVisibility(8);
        Y(this.clV);
        this.mNoDataView.setVisibility(8);
        this.cls.setVisibility(8);
        this.clr.setVisibility(8);
    }

    private void afu() {
        this.clm.setVisibility(0);
        this.clt.setVisibility(0);
        if (this.mMode == 0) {
            X(this.clU);
        } else {
            Y(this.clU);
        }
        this.clA.setVisibility(8);
        Y(this.clV);
        this.mNoDataView.setVisibility(8);
        this.cls.setVisibility(8);
        this.clr.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afv() {
        this.clm.setVisibility(8);
        this.clA.setVisibility(8);
        this.clt.setVisibility(8);
        X(this.clV);
        this.mNoDataView.setVisibility(0);
        if (this.mMode == 0) {
            X(this.clW);
        }
        this.cls.setVisibility(8);
        this.clr.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afw() {
        Y(this.clV);
        this.cls.setVisibility(0);
    }

    private void afx() {
        this.clm.setVisibility(8);
        this.clA.setVisibility(8);
        this.clt.setVisibility(8);
        Y(this.clV);
        this.mNoDataView.setVisibility(8);
        this.cls.setVisibility(8);
        this.clr.setVisibility(0);
        if (CreateBarActivityConfig.IS_SUPPORT_CREATE_BAR && this.clJ != null && this.clJ.length() <= 30) {
            em(true);
        } else {
            em(false);
        }
    }

    private void em(boolean z) {
        if (!z) {
            this.cmb.setVisibility(8);
            this.cmc.setVisibility(8);
            this.cme.setVisibility(8);
            return;
        }
        this.cmb.setVisibility(0);
        this.cmc.setVisibility(0);
        this.cme.setVisibility(0);
    }

    private PbListView afy() {
        if (this.clz == null) {
            this.clz = new PbListView(getPageContext().getPageActivity());
            this.clz.nv();
        }
        return this.clz;
    }

    @Override // com.baidu.tieba.mainentrance.d.a
    public void jr(String str) {
        this.clP = true;
        this.ckW = new ArrayList();
        afm();
    }

    @Override // com.baidu.tieba.mainentrance.d.a
    public void a(List<com.baidu.tieba.mainentrance.c> list, List<g> list2, f fVar) {
        this.clP = true;
        hideLoadingView(this.cll);
        if (list == null || list.isEmpty()) {
            this.ckW = new ArrayList();
        } else {
            this.ckW = list;
        }
        if (list2 == null) {
            this.clv = new ArrayList();
        } else {
            this.clv = list2;
        }
        a(fVar);
        this.mHotSearchInfo = fVar;
        afm();
    }

    private void a(f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.sharedPref.b.tZ().putLong("hot_search_id", fVar.getId());
            com.baidu.tbadk.core.sharedPref.b.tZ().putString("hot_search_name", fVar.getName());
            com.baidu.tbadk.core.sharedPref.b.tZ().putString("hot_search_title", fVar.JE());
            com.baidu.tbadk.core.sharedPref.b.tZ().putLong("hot_search_type", fVar.getType());
            return;
        }
        com.baidu.tbadk.core.sharedPref.b.tZ().putLong("hot_search_id", 0L);
        com.baidu.tbadk.core.sharedPref.b.tZ().putString("hot_search_name", "");
        com.baidu.tbadk.core.sharedPref.b.tZ().putString("hot_search_title", "");
        com.baidu.tbadk.core.sharedPref.b.tZ().putLong("hot_search_type", 0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aQn.onChangeSkinType(i);
        getLayoutMode().af(i == 1);
        getLayoutMode().k(this.clk);
        getLayoutMode().k(this.clr);
        com.baidu.tbadk.core.util.as.e(this.clk, i);
        if (this.clB != null) {
            this.clB.notifyDataSetChanged();
        }
        if (this.clC != null) {
            this.clC.notifyDataSetChanged();
        }
        if (this.clu != null) {
            this.clu.notifyDataSetChanged();
        }
        com.baidu.tbadk.core.util.as.i(this.cll, n.c.cp_bg_line_d);
        com.baidu.tbadk.core.util.as.c(this.clq, n.e.icon_search_ba);
        com.baidu.tbadk.core.util.as.b(this.clp, n.c.cp_cont_i, 1);
        if (this.clx != null) {
            getLayoutMode().k(this.clx.getView());
        }
        if (this.clw != null) {
            this.clw.onChangeSkinType(i);
        }
        jk(i);
    }

    private void jk(int i) {
        if (this.cly != null) {
            this.cly.setBackgroundColor(com.baidu.tbadk.core.util.as.getColor(n.c.cp_bg_line_d));
        }
        if (this.clX != null) {
            this.clX.setBackgroundColor(com.baidu.tbadk.core.util.as.getColor(n.c.cp_bg_line_b));
        }
        if (this.clY != null) {
            getLayoutMode().k(this.clY);
        }
        if (this.clZ != null) {
            ((TextView) this.clZ.findViewById(n.f.home_bt_search_footer)).setTextColor(com.baidu.tbadk.core.util.as.getColor(n.c.s_actionbar_text_line_color_s));
        }
        if (this.cma != null) {
            for (View view : this.cma) {
                com.baidu.tbadk.core.util.as.b((TextView) view.findViewById(n.f.home_lv_search_forum), n.c.cp_cont_b, 1);
                view.findViewById(n.f.home_dialog_lv_search_forum_divider).setBackgroundColor(com.baidu.tbadk.core.util.as.getColor(n.c.cp_bg_line_b));
                com.baidu.tbadk.core.util.as.i(view, n.e.addresslist_item_bg);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeActivity();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        if (!getIntent().getBooleanExtra("back_special", false)) {
            finish();
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            com.baidu.tbadk.core.c.b.e(getPageContext().getPageActivity(), 1);
        } else {
            com.baidu.tbadk.core.c.b.e(getPageContext().getPageActivity(), 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        setSkinType(3);
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        private String mName;

        public c(String str) {
            this.mName = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(this.mName)) {
                if (SquareSearchActivity.this.mMode != 0) {
                    if (SquareSearchActivity.this.mMode == 3) {
                        SquareSearchActivity.this.gw(this.mName);
                        return;
                    }
                    SquareSearchActivity.this.I(1, this.mName);
                    SquareSearchActivity.this.cln.setText(this.mName);
                    SquareSearchActivity.this.cln.requestFocus();
                    Selection.setSelection(SquareSearchActivity.this.cln.getText(), this.mName.length());
                    return;
                }
                com.baidu.tieba.tbadkCore.util.m.mA(this.mName);
                SquareSearchActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(SquareSearchActivity.this.getActivity()).createNormalCfg(this.mName, FrsActivityConfig.FRS_FROM_SEARCH)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
        private com.baidu.tbadk.core.util.ab agS = null;
        private BasicNameValuePair cmx;
        private String mUrl;

        public a(String str, BasicNameValuePair basicNameValuePair, boolean z) {
            this.mUrl = null;
            this.cmx = null;
            this.mUrl = str;
            this.cmx = basicNameValuePair;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!com.baidu.adp.lib.util.i.iP()) {
                SquareSearchActivity.this.X(SquareSearchActivity.this.mNoDataView);
                return;
            }
            SquareSearchActivity.this.Y(SquareSearchActivity.this.mNoDataView);
            SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.cll, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(n.d.ds320));
            SquareSearchActivity.this.clm.setVisibility(8);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public ForumSuggestModel doInBackground(Object... objArr) {
            ForumSuggestModel forumSuggestModel = null;
            if (com.baidu.adp.lib.util.i.iP()) {
                try {
                    this.agS = new com.baidu.tbadk.core.util.ab(this.mUrl);
                    this.agS.a(this.cmx);
                    String ul = this.agS.ul();
                    if (ul != null) {
                        forumSuggestModel = ForumSuggestModel.parserJson(ul);
                        SquareSearchActivity.this.clK = this.cmx.getValue();
                        return forumSuggestModel;
                    }
                    return null;
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    return forumSuggestModel;
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ForumSuggestModel forumSuggestModel) {
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.cll);
            if (forumSuggestModel == null) {
                SquareSearchActivity.this.X(SquareSearchActivity.this.mNoDataView);
            } else {
                SquareSearchActivity.this.Y(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.clE = forumSuggestModel;
                SquareSearchActivity.this.refresh();
            }
            SquareSearchActivity.this.clG = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.agS != null) {
                this.agS.gL();
                this.agS = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.cll);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Object, Integer, com.baidu.tieba.postsearch.j> {
        private com.baidu.tbadk.core.util.ab agS = null;
        private ArrayList<BasicNameValuePair> cmy;
        private String mUrl;

        public b(String str, ArrayList<BasicNameValuePair> arrayList) {
            this.mUrl = null;
            this.cmy = null;
            this.mUrl = str;
            this.cmy = arrayList;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!com.baidu.adp.lib.util.i.iP()) {
                SquareSearchActivity.this.X(SquareSearchActivity.this.mNoDataView);
                return;
            }
            SquareSearchActivity.this.Y(SquareSearchActivity.this.mNoDataView);
            SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.cll, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(n.d.ds320));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: z */
        public com.baidu.tieba.postsearch.j doInBackground(Object... objArr) {
            Exception exc;
            com.baidu.tieba.postsearch.j jVar;
            if (com.baidu.adp.lib.util.i.iP()) {
                try {
                    this.agS = new com.baidu.tbadk.core.util.ab(this.mUrl);
                    Iterator<BasicNameValuePair> it = this.cmy.iterator();
                    while (it.hasNext()) {
                        this.agS.a(it.next());
                    }
                    String ul = this.agS.ul();
                    if (!this.agS.uM().vG().uP() || ul == null) {
                        jVar = null;
                    } else {
                        com.baidu.tieba.postsearch.j jVar2 = new com.baidu.tieba.postsearch.j();
                        try {
                            jVar2.parseJson(ul);
                            if (ul != null && this.agS != null && this.agS.uM().vG().rf()) {
                                Iterator<BasicNameValuePair> it2 = this.cmy.iterator();
                                while (it2.hasNext()) {
                                    BasicNameValuePair next = it2.next();
                                    if ("word".equals(next.getName())) {
                                        SquareSearchActivity.this.clL = next.getValue();
                                    }
                                    if ("pn".equals(next.getName())) {
                                        SquareSearchActivity.this.clN = Integer.valueOf(next.getValue()).intValue();
                                    }
                                }
                            }
                            if (this.agS.uM().vG().rf()) {
                                com.baidu.tieba.tbadkCore.util.m.mB(SquareSearchActivity.this.clJ);
                                jVar = jVar2;
                            } else {
                                jVar = jVar2;
                            }
                        } catch (Exception e) {
                            jVar = jVar2;
                            exc = e;
                            BdLog.e(exc.getMessage());
                            return jVar;
                        }
                    }
                } catch (Exception e2) {
                    exc = e2;
                    jVar = null;
                }
                return jVar;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.postsearch.j jVar) {
            SquareSearchActivity.this.clS = false;
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.cll);
            SquareSearchActivity.this.clC.notifyDataSetChanged();
            if (jVar == null) {
                SquareSearchActivity.this.X(SquareSearchActivity.this.mNoDataView);
            } else {
                SquareSearchActivity.this.Y(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.clF = jVar;
                SquareSearchActivity.this.refresh();
            }
            SquareSearchActivity.this.clH = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            SquareSearchActivity.this.clC.notifyDataSetChanged();
            if (this.agS != null) {
                this.agS.gL();
                this.agS = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.cll);
            SquareSearchActivity.this.clH = null;
            super.onCancelled();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!this.clS && this.clF != null && this.clF.isHasMore()) {
            I(this.clF.getCurrentPage() + 1, this.clJ);
            afy().startLoadData();
        }
    }

    private void en(boolean z) {
        if (TbadkCoreApplication.isLogin()) {
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(CmdConfigCustom.CMD_REQUEST_ENTER_FORUM_MESSAGE, true));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(CmdConfigCustom.CMD_REQUEST_ENTER_FORUM_MESSAGE, false));
        }
    }

    private void afz() {
        this.clU = new SearchPageFocusBar(getPageContext().getPageActivity());
        this.clU.setVisibility(8);
        this.clt.addFooterView(this.clU, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(View view) {
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(View view) {
        if (view != null) {
            view.setVisibility(8);
        }
    }
}
