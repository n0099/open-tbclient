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
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.RequestEnterForumDataMessage;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.search.ResponseSearchFriendMessage;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.mainentrance.d;
import com.baidu.tieba.postsearch.k;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.FRSPageRequestMessage;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class SquareSearchActivity extends BaseActivity<SquareSearchActivity> implements BdListView.e, d.a {
    private boolean azn;
    private FragmentTabWidget baV;
    private List<com.baidu.tieba.mainentrance.c> cKE;
    private FragmentTabIndicator cKO;
    private LinearLayoutDetectsSoftKeyboard cKP;
    private FrameLayout cKQ;
    private FrameLayout cKR;
    private EditText cKS;
    private TextView cKT;
    private TextView cKU;
    private ImageView cKV;
    private View cKW;
    private View cKX;
    private ListView cKY;
    private com.baidu.tieba.mainentrance.b cKZ;
    private SearchPageFocusBar cLA;
    private View cLB;
    private View cLC;
    private View cLD;
    private View cLF;
    private TextView cLG;
    private View cLH;
    private List<g> cLa;
    private l cLb;
    private LinearLayout cLc;
    private PbListView cLd;
    private BdListView cLe;
    private com.baidu.tieba.mainentrance.a cLf;
    private com.baidu.tieba.postsearch.w cLg;
    private d cLh;
    private ForumSuggestModel cLi;
    private com.baidu.tieba.postsearch.k cLj;
    private a cLk;
    private b cLl;
    private String cLn;
    private String cLo;
    private String cLp;
    private String cLq;
    private boolean cLt;
    private boolean cLv;
    private boolean cLx;
    private SearchPageFocusBar cLy;
    private ScrollView cLz;
    private f mHotSearchInfo;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.p mNoDataView;
    private String mTopicInfoTitle;
    private boolean cLm = false;
    private int mMode = 0;
    private int cLr = 0;
    private int cLs = -1;
    private boolean auT = true;
    private boolean cLu = true;
    private boolean cLw = false;
    private List<View> cLE = new ArrayList();
    private Runnable cLI = new m(this);
    private final View.OnClickListener cLJ = new x(this);
    private final com.baidu.adp.framework.listener.e cLK = new ai(this, 301001, true);
    private final HttpMessageListener cLL = new an(this, CmdConfigHttp.FRS_HTTP_CMD, true);
    private CustomMessageListener cLM = new ao(this, CmdConfigCustom.CMD_READ_SEARCHPERSON_HISTORY);
    private CustomMessageListener cLN = new ap(this, CmdConfigCustom.CMD_WRITE_SEARCHPERSON_HISTORY);
    private HttpMessageListener cLO = new aq(this, CmdConfigHttp.SEARCH_FRIEND_CMD);
    private final Runnable cLP = new ar(this);
    private CustomMessageListener cLQ = new as(this, CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA);
    private CustomMessageListener cLR = new n(this, CmdConfigCustom.GET_ALL_SEARCH_POST_DATA);
    private View.OnClickListener cLS = new o(this);
    private CustomMessageListener cLT = new p(this, CmdConfigCustom.CMD_ENTER_FORUM_INFO);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponsedMessage<?> responsedMessage, boolean z) {
        int error = responsedMessage.getError();
        String string = StringUtils.isNull(responsedMessage.getErrorString()) ? getResources().getString(t.j.neterror) : responsedMessage.getErrorString();
        boolean z2 = error < -13 || error > -10;
        if (error == 0) {
            this.cLm = true;
            sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createFlagCfg(this.cLq, FrsActivityConfig.FRS_FROM_SEARCH, 1)));
        } else if (z2 && z && error == 3) {
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(t.j.login_to_use), true, 11013)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), this.cLq)));
            }
        } else {
            showToast(string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aov() {
        if (this.mMode == 0 && this.mHotSearchInfo != null) {
            if (this.mHotSearchInfo.NA() == 0) {
                kz(this.mHotSearchInfo.getName());
            } else if (this.mHotSearchInfo.NA() == 1) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "")));
            }
            TiebaStatic.log(new aw("c10355").ac("obj_name", this.mHotSearchInfo.getName()).r("obj_type", this.mHotSearchInfo.NA() == 0 ? 2 : 1));
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gM(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SEARCH_FRIEND_CMD);
        httpMessage.addParam("search_key", str);
        sendMessage(httpMessage);
    }

    private void Kk() {
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
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), this.cLq)));
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
        setContentView(t.h.home_dialog_search);
        init();
        getWindow().setSoftInputMode(1);
        Kk();
        registerListener(this.cLM);
        registerListener(this.cLN);
        registerListener(this.cLQ);
        registerListener(this.cLR);
        registerListener(this.cLO);
        registerListener(this.cLK);
        registerListener(this.cLL);
        registerListener(this.cLT);
        this.cLx = com.baidu.tbadk.core.sharedPref.b.vk().getBoolean("search_post_show_dropmenu", true);
        if (SquareSearchActivityConfig.IS_SHOW_RECOMMEND_FORUM) {
            this.cLh = new d(this, this);
            this.cLh.aou();
            this.cLh.aot();
        }
        this.cLt = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mMode == 0 && this.cLm) {
            this.cLm = false;
            if (this.cLi != null && this.cLi.forum_list != null && this.cLi.forum_list.size() > 0) {
                aoM();
                this.cLe.setAdapter((ListAdapter) this.cLf);
                this.cLf.kw(this.cLn);
                this.cLf.N(this.cLi.forum_list);
                this.cLf.notifyDataSetInvalidated();
            }
        } else if (this.mMode == 3) {
            aoH();
        }
        this.auT = true;
        if (this.cLu) {
            this.mHandler.post(this.cLI);
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
        hideLoadingView(this.cKQ);
        this.mHandler.removeCallbacks(this.cLI);
        aow();
    }

    public void aow() {
        this.mHandler.removeCallbacks(this.cLP);
        if (this.cLk != null) {
            this.cLk.cancel();
            this.cLk = null;
        }
        if (this.cLl != null) {
            this.cLl.cancel();
            this.cLl = null;
        }
    }

    private void init() {
        this.cKP = (LinearLayoutDetectsSoftKeyboard) findViewById(t.g.parent);
        this.cKP.setOnSoftKeyBoardShownListener(new q(this));
        this.cKP.setOnTouchListener(new r(this));
        NJ();
        Ux();
        this.cKQ = (FrameLayout) findViewById(t.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(t.e.ds80)), null, null);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            this.cLz = (ScrollView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(t.h.home_searchbar_nodataview, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) this.cLz.findViewById(t.g.focusbar_nodata_root);
            this.cLA = (SearchPageFocusBar) linearLayout.findViewById(t.g.no_data_focusbar);
            linearLayout.addView(this.mNoDataView, 0);
            this.cLz.setOnTouchListener(new s(this));
            this.cKQ.addView(this.cLz, this.cKQ.getChildCount());
        } else {
            this.cKQ.addView(this.mNoDataView, 0);
        }
        this.cKR = (FrameLayout) findViewById(t.g.home_search_list);
        aoD();
        aox();
        aoy();
        aoz();
        this.cKW = findViewById(t.g.empty_search_result);
        this.cLF = this.cKW.findViewById(t.g.empty_result_divider_1);
        this.cLG = (TextView) this.cKW.findViewById(t.g.create_bar_guide);
        this.cLH = this.cKW.findViewById(t.g.empty_result_divider_2);
        aoA();
        this.cKS.setText("");
        this.cKS.requestFocus();
        ShowSoftKeyPadDelay(this.cKS, 200);
        if (TbadkSettings.getInst().loadBoolean("search_mode", true)) {
            kQ(0);
            aoC();
            return;
        }
        kQ(1);
    }

    private void Ux() {
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new t(this));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, t.h.square_search_navigation_view, (View.OnClickListener) null);
        this.cKV = (ImageView) addCustomView.findViewById(t.g.search_bar_icon);
        this.cKS = (EditText) addCustomView.findViewById(t.g.home_et_search);
        this.cKT = (TextView) addCustomView.findViewById(t.g.home_bt_search_del);
        this.cKU = (TextView) addCustomView.findViewById(t.g.home_bt_search_s);
        this.cKS.setOnFocusChangeListener(new u(this));
        this.cKU.setText(getPageContext().getString(t.j.forward));
        this.cKU.setOnClickListener(this.cLJ);
        this.cKS.setOnEditorActionListener(new v(this));
        this.cKT.setOnClickListener(new w(this));
        this.cKS.addTextChangedListener(new y(this));
    }

    private void NJ() {
        this.baV = (FragmentTabWidget) findViewById(t.g.square_search_tab_widget);
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(t.e.ds32));
        fragmentTabIndicator.setGravity(17);
        fragmentTabIndicator.ayK = t.d.s_actionbar_text_color;
        fragmentTabIndicator.setText(getResources().getString(t.j.search_bar_text));
        this.cKO = new FragmentTabIndicator(getPageContext().getPageActivity());
        this.cKO.ayK = t.d.s_actionbar_text_color;
        this.cKO.setTextSize(0, getResources().getDimension(t.e.ds32));
        this.cKO.setGravity(17);
        this.cKO.setCompoundDrawablesRightResId(t.f.icon_toolbar_arrow_down);
        this.cKO.setCompoundDrawablePadding(getResources().getDimensionPixelSize(t.e.ds10));
        this.cKO.setText(getResources().getString(t.j.search_post_text));
        this.cKO.Fm();
        FragmentTabIndicator fragmentTabIndicator2 = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator2.ayK = t.d.s_actionbar_text_color;
        fragmentTabIndicator2.setTextSize(0, getResources().getDimension(t.e.ds32));
        fragmentTabIndicator2.setGravity(17);
        fragmentTabIndicator2.setText(getResources().getString(t.j.search_person));
        this.baV.addView(fragmentTabIndicator);
        this.baV.addView(this.cKO);
        this.baV.addView(fragmentTabIndicator2);
        this.baV.d(0, true);
        this.baV.setTabSelectionListener(new z(this));
    }

    private void aox() {
        this.cKY = (ListView) findViewById(t.g.home_lv_search_history);
        if (this.cLc == null) {
            this.cLc = new LinearLayout(getPageContext().getPageActivity());
            this.cLc.setOrientation(1);
            this.cLc.setBackgroundColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_bg_line_d));
        }
        this.cKY.addFooterView(this.cLc);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            aoS();
        }
        this.cKZ = new com.baidu.tieba.mainentrance.b(this);
        this.cKY.setAdapter((ListAdapter) this.cKZ);
        this.cKZ.y(new aa(this));
    }

    private void aoy() {
        if (this.cLb == null) {
            this.cLb = new l(getPageContext());
            this.cKY.addHeaderView(this.cLb.mZ());
        }
    }

    private void aoz() {
        this.cLe = (BdListView) findViewById(t.g.home_lv_search_suggest);
        this.cLf = new com.baidu.tieba.mainentrance.a(this, null);
        this.cLg = new com.baidu.tieba.postsearch.w(getPageContext());
        this.cLe.setOnItemClickListener(new ab(this));
        ac acVar = new ac(this);
        this.cLe.setOnScrollListener(acVar);
        this.cKY.setOnScrollListener(acVar);
        this.cLe.setOnSrollToBottomListener(this);
    }

    private void aoA() {
        this.cKX = findViewById(t.g.search_dropmenu);
        TextView textView = (TextView) this.cKX.findViewById(t.g.dropmenu_all_text);
        textView.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_link_tip_a));
        ImageView imageView = (ImageView) this.cKX.findViewById(t.g.dropmenu_all_icon);
        imageView.setImageDrawable(com.baidu.tbadk.core.util.at.getDrawable(t.f.chx_tips_list_ok));
        imageView.setVisibility(0);
        TextView textView2 = (TextView) this.cKX.findViewById(t.g.dropmenu_thread_text);
        textView2.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_c));
        ImageView imageView2 = (ImageView) this.cKX.findViewById(t.g.dropmenu_thread_icon);
        imageView2.setImageDrawable(com.baidu.tbadk.core.util.at.getDrawable(t.f.chx_tips_list_ok));
        imageView2.setVisibility(8);
        this.cKX.findViewById(t.g.dropmenu_all_layout).setOnClickListener(new ad(this, textView, imageView, textView2, imageView2));
        this.cKX.findViewById(t.g.dropmenu_thread_layout).setOnClickListener(new ae(this, textView, imageView, textView2, imageView2));
        this.cKX.findViewById(t.g.dropmenu_lower_part).setOnClickListener(new af(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoB() {
        if (this.cKR.getVisibility() == 8 && this.mNoDataView.getVisibility() == 8 && this.cKW.getVisibility() == 8) {
            aE(this.cLz);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dg(t.j.text_no_search_record));
        }
    }

    public void kQ(int i) {
        switch (i) {
            case 0:
                if (this.mMode != 0) {
                    this.mMode = 0;
                    this.cKU.setText(getPageContext().getString(t.j.forward));
                    aoC();
                    aow();
                    aoK();
                    if (this.cLn.trim().length() > 0) {
                        aoJ();
                        return;
                    } else {
                        aoF();
                        return;
                    }
                }
                return;
            case 1:
                if (this.mMode != 1) {
                    this.mMode = 1;
                    this.cKU.setText(getPageContext().getString(t.j.search));
                    this.cKS.setHint(t.j.search_post_hint);
                    aow();
                    aoK();
                    if (this.cLn.trim().length() > 0) {
                        this.cLe.setVisibility(8);
                        D(1, this.cLn);
                        return;
                    }
                    aoG();
                    return;
                }
                return;
            case 2:
            default:
                return;
            case 3:
                if (this.mMode != 3) {
                    this.mMode = 3;
                    this.cLe.setVisibility(8);
                    this.cKW.setVisibility(8);
                    this.cKX.setVisibility(8);
                    this.cKU.setText(t.j.search);
                    this.cKS.setHint(t.j.search_friend_tip);
                    aoK();
                    aow();
                    aoH();
                    return;
                }
                return;
        }
    }

    private void aoC() {
        if (this.mHotSearchInfo == null) {
            this.cKS.setHint(t.j.search_bar);
        } else {
            this.cKS.setHint(UtilHelper.getFixedText(this.mHotSearchInfo.Nz(), 12));
        }
    }

    private void aoD() {
        long j = com.baidu.tbadk.core.sharedPref.b.vk().getLong("hot_search_id", 0L);
        if (j != 0) {
            this.mHotSearchInfo = new f();
            this.mHotSearchInfo.setId(j);
            this.mHotSearchInfo.setName(com.baidu.tbadk.core.sharedPref.b.vk().getString("hot_search_name", ""));
            this.mHotSearchInfo.ky(com.baidu.tbadk.core.sharedPref.b.vk().getString("hot_search_title", ""));
            this.mHotSearchInfo.bq(com.baidu.tbadk.core.sharedPref.b.vk().getLong("hot_search_type", 0L));
        }
    }

    public void aoE() {
        kz(this.cKS.getText().toString().trim());
    }

    private void kz(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (com.baidu.adp.lib.util.i.jf()) {
                this.cLq = str;
                this.auT = false;
                sendMessage(kA(str));
                return;
            }
            showToast(t.j.neterror);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoF() {
        this.cLe.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA));
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            eX(true);
            aF(this.cLA);
            aF(this.cLz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoG() {
        this.cLe.setVisibility(8);
        aF(this.cLy);
        aF(this.cLA);
        aF(this.cLz);
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoH() {
        this.cLe.setVisibility(8);
        aF(this.cLy);
        aF(this.cLA);
        aF(this.cLz);
        if (!this.azn) {
            sendMessage(new RequestSearchPersonHistoryReadMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ArrayList<String> arrayList) {
        boolean z = false;
        if (b(i, arrayList) || c(i, arrayList) || d(i, arrayList)) {
            aoO();
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dg(t.j.text_no_search_record));
            return;
        }
        aoN();
        List arrayList2 = new ArrayList();
        if (i == 4) {
            arrayList2 = this.cLa;
        }
        a(i, arrayList, (this.cLa == null ? 0 : arrayList2.size()) >= 1);
        boolean z2 = i == 4;
        if (arrayList == null || arrayList.size() == 0) {
            z = true;
        }
        p(z2, z);
        if (i == 4) {
            aoC();
        }
    }

    private void a(int i, ArrayList<String> arrayList, boolean z) {
        if (this.cLc != null) {
            this.cLc.removeAllViews();
            if (arrayList != null && !arrayList.isEmpty() && getActivity() != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                if (z) {
                    this.cLB = new View(pageActivity);
                    this.cLB.setBackgroundColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_bg_line_b));
                    layoutParams.height = com.baidu.adp.lib.util.k.c(pageActivity, t.e.ds12);
                    layoutParams.topMargin = com.baidu.adp.lib.util.k.c(pageActivity, t.e.ds14);
                    this.cLc.addView(this.cLB, layoutParams);
                }
                this.cLC = LayoutInflater.from(pageActivity).inflate(t.h.square_search_recommand_fourm_header, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                getLayoutMode().x(this.cLC);
                this.cLc.addView(this.cLC, layoutParams2);
                int size = arrayList.size();
                this.cLE.clear();
                for (int i2 = 0; i2 < size; i2++) {
                    String str = arrayList.get(i2);
                    if (!TextUtils.isEmpty(str)) {
                        View inflate = LayoutInflater.from(pageActivity).inflate(t.h.home_dialog_search_item, (ViewGroup) null);
                        ((TextView) inflate.findViewById(t.g.home_lv_search_forum)).setText(str);
                        com.baidu.tbadk.core.util.at.b((TextView) inflate.findViewById(t.g.home_lv_search_forum), t.d.cp_cont_b, 1);
                        inflate.findViewById(t.g.home_dialog_lv_search_forum_divider).setVisibility(8);
                        com.baidu.tbadk.core.util.at.k(inflate, t.f.square_search_item_bg);
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                        inflate.setOnClickListener(new c(str));
                        this.cLE.add(inflate);
                        this.cLc.addView(inflate, layoutParams3);
                    }
                }
                this.cLD = LayoutInflater.from(pageActivity).inflate(t.h.home_dialog_search_footer, (ViewGroup) null);
                ((TextView) this.cLD.findViewById(t.g.home_bt_search_footer)).setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.s_actionbar_text_line_color_s));
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                this.cLD.setOnClickListener(new ag(this));
                this.cLc.addView(this.cLD, layoutParams4);
            }
        }
    }

    private void p(boolean z, boolean z2) {
        if (this.cLb != null) {
            this.cLb.clear();
            if (this.cLa != null && !this.cLa.isEmpty() && z) {
                this.cLb.setTitleText(this.mTopicInfoTitle);
                int size = this.cLa.size();
                if (size >= 1) {
                    int i = size <= 7 ? size : 7;
                    int i2 = i % 2 == 0 ? i - 1 : i;
                    for (int i3 = 0; i3 < i2; i3++) {
                        g gVar = (g) com.baidu.tbadk.core.util.y.b(this.cLa, i3);
                        if (gVar != null) {
                            this.cLb.a(gVar, i3).setOnClickListener(this.cLS);
                        }
                    }
                    this.cLb.a(null, i2).setOnClickListener(new ah(this));
                    this.cLb.show();
                }
            }
        }
    }

    private boolean b(int i, ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && (this.cKE == null || this.cKE.size() <= 2) && 4 == i && this.mMode == 0 && (this.cLa == null || this.cLa.size() <= 2);
    }

    private boolean c(int i, ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && i == 5 && this.mMode != 5;
    }

    private boolean d(int i, ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && i == 6 && this.mMode != 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoI() {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).cC(getPageContext().getString(t.j.alert_clean_history)).a(getPageContext().getString(t.j.clear_all_text), new aj(this)).b(getPageContext().getString(t.j.alert_no_button), new al(this)).b(getPageContext()).up();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoJ() {
        this.cKR.setVisibility(8);
        if (this.cLn != null) {
            if (this.cLn.equals(this.cLo)) {
                refresh();
                return;
            }
            aF(this.cLy);
            aF(this.cLA);
            aF(this.cLz);
            this.mHandler.removeCallbacks(this.cLP);
            this.mHandler.postDelayed(this.cLP, 500L);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v5 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void D(int i, String str) {
        this.cKY.setVisibility(8);
        if (str != null && str.trim().length() > 0) {
            int i2 = this.cLv ? 1 : 0;
            if (str.equals(this.cLp) && i == this.cLr && this.cLs == i2) {
                refresh();
                return;
            }
            this.cLs = i2;
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append(TbConfig.SERVER_ADDRESS);
            stringBuffer.append(TbConfig.POST_SEARCH_URL);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("word", str));
            arrayList.add(new BasicNameValuePair("pn", String.valueOf(i)));
            arrayList.add(new BasicNameValuePair(LegoListActivityConfig.RN, String.valueOf(50)));
            arrayList.add(new BasicNameValuePair("only_thread", new StringBuilder().append(i2).toString()));
            arrayList.add(new BasicNameValuePair("st_type", "search_post"));
            aow();
            this.cLl = new b(stringBuffer.toString(), arrayList);
            this.cLl.setPriority(3);
            this.cLl.execute(new Object[0]);
            this.cLw = true;
        }
    }

    private FRSPageRequestMessage kA(String str) {
        FRSPageRequestMessage fRSPageRequestMessage = new FRSPageRequestMessage();
        fRSPageRequestMessage.setKw(str);
        fRSPageRequestMessage.setPn(1);
        if (com.baidu.tbadk.core.l.qE().qK()) {
            fRSPageRequestMessage.setRn(35);
        } else {
            fRSPageRequestMessage.setRn(50);
        }
        fRSPageRequestMessage.setWithGroup(1);
        int B = com.baidu.adp.lib.util.k.B(getPageContext().getPageActivity());
        int C = com.baidu.adp.lib.util.k.C(getPageContext().getPageActivity());
        float f = B / 320.0f;
        int i = az.wz().wB() ? 2 : 1;
        fRSPageRequestMessage.setScrW(B);
        fRSPageRequestMessage.setScrH(C);
        fRSPageRequestMessage.setScrDip(f);
        fRSPageRequestMessage.setqType(i);
        return fRSPageRequestMessage;
    }

    private void aoK() {
        if (this.cLe != null) {
            this.cLe.setNextPage(null);
        }
        if (this.cLg != null) {
            this.cLg.clear();
            this.cLg.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        int i;
        int i2 = 0;
        try {
            if (this.mMode == 0) {
                if (this.cLi != null) {
                    if (this.cLi.forum_list != null && this.cLi.forum_list.size() > 0) {
                        aoM();
                        this.cLe.setAdapter((ListAdapter) this.cLf);
                        this.cLf.kw(this.cLn);
                        this.cLf.N(this.cLi.forum_list);
                        this.cLf.notifyDataSetInvalidated();
                        return;
                    }
                    aF(this.cLz);
                    aoQ();
                    aoL();
                }
            } else if (this.cLj != null) {
                List<k.a> list = this.cLj.dvh;
                if (list != null && list.size() > 0) {
                    aoM();
                    if (this.cLj.oX() == 1) {
                        this.cLe.setVisibility(0);
                        this.cLg.clear();
                        this.cLe.setAdapter((ListAdapter) this.cLg);
                        this.cLe.setNextPage(aoR());
                    }
                    if (!this.cLj.isHasMore()) {
                        aoR().setText(getResources().getString(t.j.list_no_more));
                        aoR().xv();
                    }
                    int cd = this.cLg.cd(list);
                    if (cd > 0) {
                        i = this.cLe.getFirstVisiblePosition() - cd;
                        View childAt = this.cLe.getChildAt(0);
                        if (childAt != null) {
                            i2 = childAt.getTop();
                        }
                    } else {
                        i = 0;
                    }
                    this.cLg.notifyDataSetChanged();
                    if (cd > 0) {
                        this.cLe.setSelectionFromTop(i, i2);
                    }
                    if (this.cLx) {
                        this.cKX.setVisibility(0);
                        this.cLx = false;
                        com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("search_post_show_dropmenu", false);
                    }
                } else if (this.mNoDataView.getVisibility() != 0) {
                    aoO();
                    aF(this.cLA);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dg(t.j.text_no_suggest));
                }
            } else if (this.mNoDataView.getVisibility() != 0) {
                aoO();
                aF(this.cLA);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dg(t.j.text_no_suggest));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void aoL() {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_h));
        TextView textView = (TextView) this.cKW.findViewById(t.g.no_bar_found);
        textView.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_c));
        TextView textView2 = (TextView) this.cKW.findViewById(t.g.create_bar_guide);
        textView2.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_b));
        String str = "";
        if (this.cLn != null) {
            str = this.cLn.length() > 6 ? String.valueOf(this.cLn.substring(0, 6)) + "..." : this.cLn;
        }
        String format = String.format(getPageContext().getString(t.j.empty_search_result_format), str);
        String format2 = String.format(getPageContext().getString(t.j.create_bar_guide_format), str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
        spannableStringBuilder.setSpan(foregroundColorSpan, 4, format.length() - 2, 33);
        textView.setText(spannableStringBuilder);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(format2);
        spannableStringBuilder2.setSpan(foregroundColorSpan, 5, format2.length() - 5, 33);
        textView2.setText(spannableStringBuilder2);
        Drawable drawable = com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_search_list_add);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        textView2.setCompoundDrawablePadding(com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), t.e.ds10));
        textView2.setCompoundDrawables(drawable, null, null, null);
        textView2.setOnClickListener(new am(this));
    }

    private void aoM() {
        this.cKR.setVisibility(0);
        this.cLe.setVisibility(0);
        this.cKY.setVisibility(8);
        aF(this.cLz);
        this.mNoDataView.setVisibility(8);
        this.cKX.setVisibility(8);
        this.cKW.setVisibility(8);
    }

    private void aoN() {
        this.cKR.setVisibility(0);
        this.cKY.setVisibility(0);
        if (this.mMode == 0) {
            aE(this.cLy);
        } else {
            aF(this.cLy);
        }
        this.cLe.setVisibility(8);
        aF(this.cLz);
        this.mNoDataView.setVisibility(8);
        this.cKX.setVisibility(8);
        this.cKW.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoO() {
        this.cKR.setVisibility(8);
        this.cLe.setVisibility(8);
        this.cKY.setVisibility(8);
        aE(this.cLz);
        this.mNoDataView.setVisibility(0);
        if (this.mMode == 0) {
            aE(this.cLA);
        }
        this.cKX.setVisibility(8);
        this.cKW.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoP() {
        aF(this.cLz);
        this.cKX.setVisibility(0);
    }

    private void aoQ() {
        this.cKR.setVisibility(8);
        this.cLe.setVisibility(8);
        this.cKY.setVisibility(8);
        aF(this.cLz);
        this.mNoDataView.setVisibility(8);
        this.cKX.setVisibility(8);
        this.cKW.setVisibility(0);
        if (CreateBarActivityConfig.IS_SUPPORT_CREATE_BAR && this.cLn != null && this.cLn.length() <= 30) {
            eW(true);
        } else {
            eW(false);
        }
    }

    private void eW(boolean z) {
        if (!z) {
            this.cLF.setVisibility(8);
            this.cLG.setVisibility(8);
            this.cLH.setVisibility(8);
            return;
        }
        this.cLF.setVisibility(0);
        this.cLG.setVisibility(0);
        this.cLH.setVisibility(0);
    }

    private PbListView aoR() {
        if (this.cLd == null) {
            this.cLd = new PbListView(getPageContext().getPageActivity());
            this.cLd.mZ();
        }
        return this.cLd;
    }

    @Override // com.baidu.tieba.mainentrance.d.a
    public void kx(String str) {
        this.cLt = true;
        this.cKE = new ArrayList();
        this.cLa = new ArrayList();
        aoF();
    }

    @Override // com.baidu.tieba.mainentrance.d.a
    public void a(List<com.baidu.tieba.mainentrance.c> list, List<g> list2, f fVar, String str) {
        this.cLt = true;
        hideLoadingView(this.cKQ);
        if (list == null || list.isEmpty()) {
            this.cKE = new ArrayList();
        } else {
            this.cKE = list;
        }
        if (list2 == null) {
            this.cLa = new ArrayList();
        } else {
            this.cLa = list2;
        }
        if (!StringUtils.isNULL(str)) {
            this.mTopicInfoTitle = str;
        } else {
            this.mTopicInfoTitle = "";
        }
        a(fVar);
        this.mHotSearchInfo = fVar;
        aoF();
    }

    private void a(f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.sharedPref.b.vk().putLong("hot_search_id", fVar.getId());
            com.baidu.tbadk.core.sharedPref.b.vk().putString("hot_search_name", fVar.getName());
            com.baidu.tbadk.core.sharedPref.b.vk().putString("hot_search_title", fVar.Nz());
            com.baidu.tbadk.core.sharedPref.b.vk().putLong("hot_search_type", fVar.NA());
            return;
        }
        com.baidu.tbadk.core.sharedPref.b.vk().putLong("hot_search_id", 0L);
        com.baidu.tbadk.core.sharedPref.b.vk().putString("hot_search_name", "");
        com.baidu.tbadk.core.sharedPref.b.vk().putString("hot_search_title", "");
        com.baidu.tbadk.core.sharedPref.b.vk().putLong("hot_search_type", 0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.baV.onChangeSkinType(i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().x(this.cKP);
        getLayoutMode().x(this.cKW);
        com.baidu.tbadk.core.util.at.g(this.cKP, i);
        if (this.cLf != null) {
            this.cLf.notifyDataSetChanged();
        }
        if (this.cLg != null) {
            this.cLg.notifyDataSetChanged();
        }
        if (this.cKZ != null) {
            this.cKZ.notifyDataSetChanged();
        }
        com.baidu.tbadk.core.util.at.k(this.cKQ, t.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.at.c(this.cKV, t.f.icon_search_ba);
        com.baidu.tbadk.core.util.at.b(this.cKU, t.d.cp_cont_i, 1);
        if (this.cLb != null) {
            this.cLb.onChangeSkinType(i);
        }
        kR(i);
    }

    private void kR(int i) {
        if (this.cLc != null) {
            this.cLc.setBackgroundColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_bg_line_d));
        }
        if (this.cLB != null) {
            this.cLB.setBackgroundColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_bg_line_b));
        }
        if (this.cLC != null) {
            getLayoutMode().x(this.cLC);
        }
        if (this.cLD != null) {
            ((TextView) this.cLD.findViewById(t.g.home_bt_search_footer)).setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.s_actionbar_text_line_color_s));
        }
        if (this.cLE != null) {
            for (View view : this.cLE) {
                com.baidu.tbadk.core.util.at.b((TextView) view.findViewById(t.g.home_lv_search_forum), t.d.cp_cont_b, 1);
                view.findViewById(t.g.home_dialog_lv_search_forum_divider).setBackgroundColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_bg_line_b));
                com.baidu.tbadk.core.util.at.k(view, t.f.addresslist_item_bg);
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
            com.baidu.tbadk.core.d.b.d(getPageContext().getPageActivity(), 1);
        } else {
            com.baidu.tbadk.core.d.b.d(getPageContext().getPageActivity(), 2);
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
                        SquareSearchActivity.this.gM(this.mName);
                        return;
                    }
                    SquareSearchActivity.this.D(1, this.mName);
                    SquareSearchActivity.this.cKS.setText(this.mName);
                    SquareSearchActivity.this.cKS.requestFocus();
                    Selection.setSelection(SquareSearchActivity.this.cKS.getText(), this.mName.length());
                    return;
                }
                com.baidu.tieba.tbadkCore.util.m.oa(this.mName);
                SquareSearchActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(SquareSearchActivity.this.getActivity()).createNormalCfg(this.mName, FrsActivityConfig.FRS_FROM_SEARCH)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
        private com.baidu.tbadk.core.util.ab aiW = null;
        private BasicNameValuePair cMa;
        private String mUrl;

        public a(String str, BasicNameValuePair basicNameValuePair, boolean z) {
            this.mUrl = null;
            this.cMa = null;
            this.mUrl = str;
            this.cMa = basicNameValuePair;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!com.baidu.adp.lib.util.i.jf()) {
                SquareSearchActivity.this.aE(SquareSearchActivity.this.mNoDataView);
                return;
            }
            SquareSearchActivity.this.aF(SquareSearchActivity.this.mNoDataView);
            SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.cKQ, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(t.e.ds320));
            SquareSearchActivity.this.cKR.setVisibility(8);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: u */
        public ForumSuggestModel doInBackground(Object... objArr) {
            ForumSuggestModel forumSuggestModel = null;
            if (com.baidu.adp.lib.util.i.jf()) {
                try {
                    this.aiW = new com.baidu.tbadk.core.util.ab(this.mUrl);
                    this.aiW.a(this.cMa);
                    String vw = this.aiW.vw();
                    if (vw != null) {
                        forumSuggestModel = ForumSuggestModel.parserJson(vw);
                        SquareSearchActivity.this.cLo = this.cMa.getValue();
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
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.cKQ);
            if (forumSuggestModel == null) {
                SquareSearchActivity.this.aE(SquareSearchActivity.this.mNoDataView);
            } else {
                SquareSearchActivity.this.aF(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.cLi = forumSuggestModel;
                SquareSearchActivity.this.refresh();
            }
            SquareSearchActivity.this.cLk = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiW != null) {
                this.aiW.gX();
                this.aiW = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.cKQ);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Object, Integer, com.baidu.tieba.postsearch.k> {
        private com.baidu.tbadk.core.util.ab aiW = null;
        private ArrayList<BasicNameValuePair> cMb;
        private String mUrl;

        public b(String str, ArrayList<BasicNameValuePair> arrayList) {
            this.mUrl = null;
            this.cMb = null;
            this.mUrl = str;
            this.cMb = arrayList;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!com.baidu.adp.lib.util.i.jf()) {
                SquareSearchActivity.this.aE(SquareSearchActivity.this.mNoDataView);
                return;
            }
            SquareSearchActivity.this.aF(SquareSearchActivity.this.mNoDataView);
            SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.cKQ, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(t.e.ds320));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: v */
        public com.baidu.tieba.postsearch.k doInBackground(Object... objArr) {
            Exception exc;
            com.baidu.tieba.postsearch.k kVar;
            if (com.baidu.adp.lib.util.i.jf()) {
                try {
                    this.aiW = new com.baidu.tbadk.core.util.ab(this.mUrl);
                    Iterator<BasicNameValuePair> it = this.cMb.iterator();
                    while (it.hasNext()) {
                        this.aiW.a(it.next());
                    }
                    String vw = this.aiW.vw();
                    if (!this.aiW.vU().wP().vX() || vw == null) {
                        kVar = null;
                    } else {
                        com.baidu.tieba.postsearch.k kVar2 = new com.baidu.tieba.postsearch.k();
                        try {
                            kVar2.parseJson(vw);
                            if (vw != null && this.aiW != null && this.aiW.vU().wP().qC()) {
                                Iterator<BasicNameValuePair> it2 = this.cMb.iterator();
                                while (it2.hasNext()) {
                                    BasicNameValuePair next = it2.next();
                                    if ("word".equals(next.getName())) {
                                        SquareSearchActivity.this.cLp = next.getValue();
                                    }
                                    if ("pn".equals(next.getName())) {
                                        SquareSearchActivity.this.cLr = Integer.valueOf(next.getValue()).intValue();
                                    }
                                }
                            }
                            if (this.aiW.vU().wP().qC()) {
                                com.baidu.tieba.tbadkCore.util.m.ob(SquareSearchActivity.this.cLn);
                                kVar = kVar2;
                            } else {
                                kVar = kVar2;
                            }
                        } catch (Exception e) {
                            kVar = kVar2;
                            exc = e;
                            BdLog.e(exc.getMessage());
                            return kVar;
                        }
                    }
                } catch (Exception e2) {
                    exc = e2;
                    kVar = null;
                }
                return kVar;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.postsearch.k kVar) {
            SquareSearchActivity.this.cLw = false;
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.cKQ);
            SquareSearchActivity.this.cLg.notifyDataSetChanged();
            if (kVar == null) {
                SquareSearchActivity.this.aE(SquareSearchActivity.this.mNoDataView);
            } else {
                SquareSearchActivity.this.aF(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.cLj = kVar;
                SquareSearchActivity.this.refresh();
            }
            SquareSearchActivity.this.cLl = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            SquareSearchActivity.this.cLg.notifyDataSetChanged();
            if (this.aiW != null) {
                this.aiW.gX();
                this.aiW = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.cKQ);
            SquareSearchActivity.this.cLl = null;
            super.onCancelled();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void nm() {
        if (!this.cLw && this.cLj != null && this.cLj.isHasMore()) {
            D(this.cLj.oX() + 1, this.cLn);
            aoR().xu();
        }
    }

    private void eX(boolean z) {
        if (TbadkCoreApplication.isLogin()) {
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(CmdConfigCustom.CMD_REQUEST_ENTER_FORUM_MESSAGE, true));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(CmdConfigCustom.CMD_REQUEST_ENTER_FORUM_MESSAGE, false));
        }
    }

    private void aoS() {
        this.cLy = new SearchPageFocusBar(getPageContext().getPageActivity());
        this.cLy.setVisibility(8);
        this.cKY.addFooterView(this.cLy, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(View view) {
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF(View view) {
        if (view != null) {
            view.setVisibility(8);
        }
    }
}
