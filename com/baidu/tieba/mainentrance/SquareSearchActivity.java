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
import com.baidu.tieba.postsearch.k;
import com.baidu.tieba.tbadkCore.FRSPageRequestMessage;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class SquareSearchActivity extends BaseActivity<SquareSearchActivity> implements BdListView.e, d.a {
    private FragmentTabWidget aUf;
    private boolean axN;
    private m cpA;
    private h cpB;
    private LinearLayout cpC;
    private PbListView cpD;
    private BdListView cpE;
    private com.baidu.tieba.mainentrance.a cpF;
    private com.baidu.tieba.postsearch.w cpG;
    private d cpH;
    private ForumSuggestModel cpI;
    private com.baidu.tieba.postsearch.k cpJ;
    private a cpK;
    private b cpL;
    private String cpN;
    private String cpO;
    private String cpP;
    private String cpQ;
    private boolean cpT;
    private boolean cpV;
    private boolean cpX;
    private SearchPageFocusBar cpY;
    private ScrollView cpZ;
    private List<com.baidu.tieba.mainentrance.c> cpa;
    private FragmentTabIndicator cpn;
    private LinearLayoutDetectsSoftKeyboard cpo;
    private FrameLayout cpp;
    private FrameLayout cpq;
    private EditText cpr;
    private TextView cps;
    private TextView cpt;
    private ImageView cpu;
    private View cpv;
    private View cpw;
    private ListView cpx;
    private com.baidu.tieba.mainentrance.b cpy;
    private List<g> cpz;
    private SearchPageFocusBar cqa;
    private View cqb;
    private View cqc;
    private View cqd;
    private View cqf;
    private TextView cqg;
    private View cqh;
    private f mHotSearchInfo;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.o mNoDataView;
    private boolean cpM = false;
    private int mMode = 0;
    private int cpR = 0;
    private int cpS = -1;
    private boolean atB = true;
    private boolean cpU = true;
    private boolean cpW = false;
    private List<View> cqe = new ArrayList();
    private Runnable cqi = new n(this);
    private final View.OnClickListener cqj = new y(this);
    private final com.baidu.adp.framework.listener.e cqk = new ak(this, 301001, true);
    private final HttpMessageListener cql = new an(this, CmdConfigHttp.FRS_HTTP_CMD, true);
    private CustomMessageListener cqm = new ao(this, CmdConfigCustom.CMD_READ_SEARCHPERSON_HISTORY);
    private CustomMessageListener cqn = new ap(this, CmdConfigCustom.CMD_WRITE_SEARCHPERSON_HISTORY);
    private HttpMessageListener cqo = new aq(this, CmdConfigHttp.SEARCH_FRIEND_CMD);
    private final Runnable cqp = new ar(this);
    private CustomMessageListener cqq = new as(this, CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA);
    private CustomMessageListener cqr = new o(this, CmdConfigCustom.GET_ALL_SEARCH_POST_DATA);
    private View.OnClickListener cqs = new p(this);
    private CustomMessageListener cqt = new q(this, CmdConfigCustom.CMD_ENTER_FORUM_INFO);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponsedMessage<?> responsedMessage, boolean z) {
        int error = responsedMessage.getError();
        String string = StringUtils.isNull(responsedMessage.getErrorString()) ? getResources().getString(n.j.neterror) : responsedMessage.getErrorString();
        boolean z2 = error < -13 || error > -10;
        if (error == 0) {
            this.cpM = true;
            sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createFlagCfg(this.cpQ, FrsActivityConfig.FRS_FROM_SEARCH, 1)));
        } else if (z2 && z && error == 3) {
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(n.j.login_to_use), true, 11013)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), this.cpQ)));
            }
        } else {
            showToast(string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean agk() {
        if (this.mMode == 0 && this.mHotSearchInfo != null) {
            if (this.mHotSearchInfo.getType() == 0) {
                jI(this.mHotSearchInfo.getName());
            } else if (this.mHotSearchInfo.getType() == 1) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "")));
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10355").aa("obj_name", this.mHotSearchInfo.getName()).r("obj_type", this.mHotSearchInfo.getType() == 0 ? 2 : 1));
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gB(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SEARCH_FRIEND_CMD);
        httpMessage.addParam("search_key", str);
        sendMessage(httpMessage);
    }

    private void Hn() {
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
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), this.cpQ)));
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
        setContentView(n.h.home_dialog_search);
        init();
        getWindow().setSoftInputMode(1);
        Hn();
        registerListener(this.cqm);
        registerListener(this.cqn);
        registerListener(this.cqq);
        registerListener(this.cqr);
        registerListener(this.cqo);
        registerListener(this.cqk);
        registerListener(this.cql);
        registerListener(this.cqt);
        this.cpX = com.baidu.tbadk.core.sharedPref.b.tJ().getBoolean("search_post_show_dropmenu", true);
        if (SquareSearchActivityConfig.IS_SHOW_RECOMMEND_FORUM) {
            this.cpH = new d(this, this);
            this.cpH.agj();
            this.cpH.agi();
        }
        this.cpT = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mMode == 0 && this.cpM) {
            this.cpM = false;
            if (this.cpI != null && this.cpI.forum_list != null && this.cpI.forum_list.size() > 0) {
                agC();
                this.cpE.setAdapter((ListAdapter) this.cpF);
                this.cpF.jF(this.cpN);
                this.cpF.N(this.cpI.forum_list);
                this.cpF.notifyDataSetInvalidated();
            }
        }
        this.atB = true;
        if (this.cpU) {
            this.mHandler.post(this.cqi);
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
        hideLoadingView(this.cpp);
        this.mHandler.removeCallbacks(this.cqi);
        agl();
    }

    public void agl() {
        this.mHandler.removeCallbacks(this.cqp);
        if (this.cpK != null) {
            this.cpK.cancel();
            this.cpK = null;
        }
        if (this.cpL != null) {
            this.cpL.cancel();
            this.cpL = null;
        }
    }

    private void init() {
        this.cpo = (LinearLayoutDetectsSoftKeyboard) findViewById(n.g.parent);
        this.cpo.setOnSoftKeyBoardShownListener(new r(this));
        this.cpo.setOnTouchListener(new s(this));
        Kd();
        Qz();
        this.cpp = (FrameLayout) findViewById(n.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(n.e.ds80)), null, null);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            this.cpZ = (ScrollView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(n.h.home_searchbar_nodataview, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) this.cpZ.findViewById(n.g.focusbar_nodata_root);
            this.cqa = (SearchPageFocusBar) linearLayout.findViewById(n.g.no_data_focusbar);
            linearLayout.addView(this.mNoDataView, 0);
            this.cpZ.setOnTouchListener(new t(this));
            this.cpp.addView(this.cpZ, this.cpp.getChildCount());
        } else {
            this.cpp.addView(this.mNoDataView, 0);
        }
        this.cpq = (FrameLayout) findViewById(n.g.home_search_list);
        agt();
        agm();
        ago();
        agn();
        agp();
        this.cpv = findViewById(n.g.empty_search_result);
        this.cqf = this.cpv.findViewById(n.g.empty_result_divider_1);
        this.cqg = (TextView) this.cpv.findViewById(n.g.create_bar_guide);
        this.cqh = this.cpv.findViewById(n.g.empty_result_divider_2);
        agq();
        this.cpr.setText("");
        this.cpr.requestFocus();
        ShowSoftKeyPadDelay(this.cpr, 200);
        if (TbadkSettings.getInst().loadBoolean("search_mode", true)) {
            jH(0);
            ags();
            return;
        }
        jH(1);
    }

    private void Qz() {
        this.mNavigationBar = (NavigationBar) findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new u(this));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, n.h.square_search_navigation_view, (View.OnClickListener) null);
        this.cpu = (ImageView) addCustomView.findViewById(n.g.search_bar_icon);
        this.cpr = (EditText) addCustomView.findViewById(n.g.home_et_search);
        this.cps = (TextView) addCustomView.findViewById(n.g.home_bt_search_del);
        this.cpt = (TextView) addCustomView.findViewById(n.g.home_bt_search_s);
        this.cpr.setOnFocusChangeListener(new v(this));
        this.cpt.setText(getPageContext().getString(n.j.forward));
        this.cpt.setOnClickListener(this.cqj);
        this.cpr.setOnEditorActionListener(new w(this));
        this.cps.setOnClickListener(new x(this));
        this.cpr.addTextChangedListener(new z(this));
    }

    private void Kd() {
        this.aUf = (FragmentTabWidget) findViewById(n.g.square_search_tab_widget);
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(n.e.ds32));
        fragmentTabIndicator.setGravity(17);
        fragmentTabIndicator.axk = n.d.s_actionbar_text_color;
        fragmentTabIndicator.setText(getResources().getString(n.j.search_bar_text));
        this.cpn = new FragmentTabIndicator(getPageContext().getPageActivity());
        this.cpn.axk = n.d.s_actionbar_text_color;
        this.cpn.setTextSize(0, getResources().getDimension(n.e.ds32));
        this.cpn.setGravity(17);
        this.cpn.setCompoundDrawablesRightResId(n.f.icon_toolbar_arrow_down);
        this.cpn.setCompoundDrawablePadding(getResources().getDimensionPixelSize(n.e.ds10));
        this.cpn.setText(getResources().getString(n.j.search_post_text));
        this.cpn.De();
        FragmentTabIndicator fragmentTabIndicator2 = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator2.axk = n.d.s_actionbar_text_color;
        fragmentTabIndicator2.setTextSize(0, getResources().getDimension(n.e.ds32));
        fragmentTabIndicator2.setGravity(17);
        fragmentTabIndicator2.setText(getResources().getString(n.j.search_person));
        this.aUf.addView(fragmentTabIndicator);
        this.aUf.addView(this.cpn);
        this.aUf.addView(fragmentTabIndicator2);
        this.aUf.d(0, true);
        this.aUf.setTabSelectionListener(new aa(this));
    }

    private void agm() {
        this.cpx = (ListView) findViewById(n.g.home_lv_search_history);
        if (this.cpC == null) {
            this.cpC = new LinearLayout(getPageContext().getPageActivity());
            this.cpC.setOrientation(1);
            this.cpC.setBackgroundColor(com.baidu.tbadk.core.util.as.getColor(n.d.cp_bg_line_d));
        }
        this.cpx.addFooterView(this.cpC);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            agI();
        }
        this.cpy = new com.baidu.tieba.mainentrance.b(this);
        this.cpx.setAdapter((ListAdapter) this.cpy);
        this.cpy.r(new ab(this));
    }

    private void agn() {
        if (this.cpB == null) {
            this.cpB = new h(getPageContext());
            this.cpx.addHeaderView(this.cpB.getView());
        }
    }

    private void ago() {
        if (this.cpA == null) {
            this.cpA = new m(getPageContext());
            this.cpx.addHeaderView(this.cpA.mT());
        }
    }

    private void agp() {
        this.cpE = (BdListView) findViewById(n.g.home_lv_search_suggest);
        this.cpF = new com.baidu.tieba.mainentrance.a(this, null);
        this.cpG = new com.baidu.tieba.postsearch.w(getPageContext());
        this.cpE.setOnItemClickListener(new ac(this));
        ad adVar = new ad(this);
        this.cpE.setOnScrollListener(adVar);
        this.cpx.setOnScrollListener(adVar);
        this.cpE.setOnSrollToBottomListener(this);
    }

    private void agq() {
        this.cpw = findViewById(n.g.search_dropmenu);
        TextView textView = (TextView) this.cpw.findViewById(n.g.dropmenu_all_text);
        textView.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.d.cp_link_tip_a));
        ImageView imageView = (ImageView) this.cpw.findViewById(n.g.dropmenu_all_icon);
        imageView.setImageDrawable(com.baidu.tbadk.core.util.as.getDrawable(n.f.chx_tips_list_ok));
        imageView.setVisibility(0);
        TextView textView2 = (TextView) this.cpw.findViewById(n.g.dropmenu_thread_text);
        textView2.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.d.cp_cont_c));
        ImageView imageView2 = (ImageView) this.cpw.findViewById(n.g.dropmenu_thread_icon);
        imageView2.setImageDrawable(com.baidu.tbadk.core.util.as.getDrawable(n.f.chx_tips_list_ok));
        imageView2.setVisibility(8);
        this.cpw.findViewById(n.g.dropmenu_all_layout).setOnClickListener(new ae(this, textView, imageView, textView2, imageView2));
        this.cpw.findViewById(n.g.dropmenu_thread_layout).setOnClickListener(new af(this, textView, imageView, textView2, imageView2));
        this.cpw.findViewById(n.g.dropmenu_lower_part).setOnClickListener(new ag(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agr() {
        if (this.cpq.getVisibility() == 8 && this.mNoDataView.getVisibility() == 8 && this.cpv.getVisibility() == 8) {
            ac(this.cpZ);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cM(n.j.text_no_search_record));
        }
    }

    public void jH(int i) {
        switch (i) {
            case 0:
                if (this.mMode != 0) {
                    this.mMode = 0;
                    this.cpt.setText(getPageContext().getString(n.j.forward));
                    ags();
                    agl();
                    agA();
                    if (this.cpN.trim().length() > 0) {
                        agz();
                        return;
                    } else {
                        agv();
                        return;
                    }
                }
                return;
            case 1:
                if (this.mMode != 1) {
                    this.mMode = 1;
                    this.cpt.setText(getPageContext().getString(n.j.search));
                    this.cpr.setHint(n.j.search_post_hint);
                    agl();
                    agA();
                    if (this.cpN.trim().length() > 0) {
                        this.cpE.setVisibility(8);
                        I(1, this.cpN);
                        return;
                    }
                    agw();
                    return;
                }
                return;
            case 2:
            default:
                return;
            case 3:
                if (this.mMode != 3) {
                    this.mMode = 3;
                    this.cpE.setVisibility(8);
                    this.cpv.setVisibility(8);
                    this.cpw.setVisibility(8);
                    this.cpt.setText(n.j.search);
                    this.cpr.setHint(n.j.search_friend_tip);
                    agA();
                    agl();
                    agx();
                    return;
                }
                return;
        }
    }

    private void ags() {
        if (this.mHotSearchInfo == null) {
            this.cpr.setHint(n.j.search_bar);
        } else {
            this.cpr.setHint(UtilHelper.getFixedText(this.mHotSearchInfo.JV(), 12));
        }
    }

    private void agt() {
        long j = com.baidu.tbadk.core.sharedPref.b.tJ().getLong("hot_search_id", 0L);
        if (j != 0) {
            this.mHotSearchInfo = new f();
            this.mHotSearchInfo.setId(j);
            this.mHotSearchInfo.setName(com.baidu.tbadk.core.sharedPref.b.tJ().getString("hot_search_name", ""));
            this.mHotSearchInfo.jH(com.baidu.tbadk.core.sharedPref.b.tJ().getString("hot_search_title", ""));
            this.mHotSearchInfo.bg(com.baidu.tbadk.core.sharedPref.b.tJ().getLong("hot_search_type", 0L));
        }
    }

    public void agu() {
        jI(this.cpr.getText().toString().trim());
    }

    private void jI(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (com.baidu.adp.lib.util.i.iQ()) {
                this.cpQ = str;
                this.atB = false;
                sendMessage(jJ(str));
                return;
            }
            showToast(n.j.neterror);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agv() {
        this.cpE.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA));
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            en(true);
            ad(this.cqa);
            ad(this.cpZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agw() {
        this.cpE.setVisibility(8);
        ad(this.cpY);
        ad(this.cqa);
        ad(this.cpZ);
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agx() {
        this.cpE.setVisibility(8);
        ad(this.cpY);
        ad(this.cqa);
        ad(this.cpZ);
        if (!this.axN) {
            sendMessage(new RequestSearchPersonHistoryReadMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ArrayList<String> arrayList) {
        boolean z = false;
        if (b(i, arrayList) || c(i, arrayList) || d(i, arrayList)) {
            agE();
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cM(n.j.text_no_search_record));
            return;
        }
        agD();
        List<com.baidu.tieba.mainentrance.c> arrayList2 = new ArrayList<>();
        if (i == 4) {
            arrayList2 = this.cpa;
        }
        a(i, arrayList, (this.cpa == null ? 0 : arrayList2.size()) >= 2);
        boolean z2 = i == 4;
        if (arrayList == null || arrayList.size() == 0) {
            z = true;
        }
        l(z2, z);
        if (i == 4) {
            ags();
        }
        if (i == 4 && this.cpa.size() >= 2) {
            this.cpB.show();
        } else {
            this.cpB.hide();
        }
        this.cpy.be(arrayList2);
        this.cpy.notifyDataSetChanged();
    }

    private void a(int i, ArrayList<String> arrayList, boolean z) {
        if (this.cpC != null) {
            this.cpC.removeAllViews();
            if (arrayList != null && !arrayList.isEmpty() && getActivity() != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                if (z) {
                    this.cqb = new View(pageActivity);
                    this.cqb.setBackgroundColor(com.baidu.tbadk.core.util.as.getColor(n.d.cp_bg_line_b));
                    layoutParams.height = com.baidu.adp.lib.util.k.d(pageActivity, n.e.ds12);
                    layoutParams.topMargin = com.baidu.adp.lib.util.k.d(pageActivity, n.e.ds14);
                    this.cpC.addView(this.cqb, layoutParams);
                }
                this.cqc = LayoutInflater.from(pageActivity).inflate(n.h.square_search_recommand_fourm_header, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                getLayoutMode().k(this.cqc);
                this.cpC.addView(this.cqc, layoutParams2);
                int size = arrayList.size();
                this.cqe.clear();
                for (int i2 = 0; i2 < size; i2++) {
                    String str = arrayList.get(i2);
                    if (!TextUtils.isEmpty(str)) {
                        View inflate = LayoutInflater.from(pageActivity).inflate(n.h.home_dialog_search_item, (ViewGroup) null);
                        ((TextView) inflate.findViewById(n.g.home_lv_search_forum)).setText(str);
                        com.baidu.tbadk.core.util.as.b((TextView) inflate.findViewById(n.g.home_lv_search_forum), n.d.cp_cont_b, 1);
                        inflate.findViewById(n.g.home_dialog_lv_search_forum_divider).setVisibility(8);
                        com.baidu.tbadk.core.util.as.i(inflate, n.f.square_search_item_bg);
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                        inflate.setOnClickListener(new c(str));
                        this.cqe.add(inflate);
                        this.cpC.addView(inflate, layoutParams3);
                    }
                }
                this.cqd = LayoutInflater.from(pageActivity).inflate(n.h.home_dialog_search_footer, (ViewGroup) null);
                ((TextView) this.cqd.findViewById(n.g.home_bt_search_footer)).setTextColor(com.baidu.tbadk.core.util.as.getColor(n.d.s_actionbar_text_line_color_s));
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                this.cqd.setOnClickListener(new ah(this));
                this.cpC.addView(this.cqd, layoutParams4);
            }
        }
    }

    private void l(boolean z, boolean z2) {
        int size;
        if (this.cpA != null) {
            this.cpA.clear();
            if (this.cpz != null && !this.cpz.isEmpty() && z && (size = this.cpz.size()) >= 2) {
                int i = size <= 4 ? size : 4;
                int i2 = i % 2 != 0 ? i - 1 : i;
                for (int i3 = 0; i3 < i2; i3++) {
                    g gVar = (g) com.baidu.tbadk.core.util.y.b(this.cpz, i3);
                    if (gVar != null) {
                        this.cpA.a(gVar, i3).setOnClickListener(this.cqs);
                    }
                }
                this.cpA.el(((this.cpa == null || this.cpa.size() == 0) && z2) ? false : true);
                this.cpA.show();
            }
        }
    }

    private boolean b(int i, ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && (this.cpa == null || this.cpa.size() <= 2) && 4 == i && this.mMode == 0 && (this.cpz == null || this.cpz.size() <= 2);
    }

    private boolean c(int i, ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && i == 5 && this.mMode != 5;
    }

    private boolean d(int i, ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && i == 6 && this.mMode != 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agy() {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).cF(getPageContext().getString(n.j.alert_clean_history)).a(getPageContext().getString(n.j.clear_all_text), new ai(this)).b(getPageContext().getString(n.j.alert_no_button), new al(this)).b(getPageContext()).tf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agz() {
        this.cpq.setVisibility(8);
        if (this.cpN != null) {
            if (this.cpN.equals(this.cpO)) {
                refresh();
                return;
            }
            ad(this.cpY);
            ad(this.cqa);
            ad(this.cpZ);
            this.mHandler.removeCallbacks(this.cqp);
            this.mHandler.postDelayed(this.cqp, 500L);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v5 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void I(int i, String str) {
        this.cpx.setVisibility(8);
        if (str != null && str.trim().length() > 0) {
            int i2 = this.cpV ? 1 : 0;
            if (str.equals(this.cpP) && i == this.cpR && this.cpS == i2) {
                refresh();
                return;
            }
            this.cpS = i2;
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append(TbConfig.SERVER_ADDRESS);
            stringBuffer.append(TbConfig.POST_SEARCH_URL);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("word", str));
            arrayList.add(new BasicNameValuePair("pn", String.valueOf(i)));
            arrayList.add(new BasicNameValuePair("rn", String.valueOf(50)));
            arrayList.add(new BasicNameValuePair("only_thread", new StringBuilder().append(i2).toString()));
            arrayList.add(new BasicNameValuePair("st_type", "search_post"));
            agl();
            this.cpL = new b(stringBuffer.toString(), arrayList);
            this.cpL.setPriority(3);
            this.cpL.execute(new Object[0]);
            this.cpW = true;
        }
    }

    private FRSPageRequestMessage jJ(String str) {
        FRSPageRequestMessage fRSPageRequestMessage = new FRSPageRequestMessage();
        fRSPageRequestMessage.setKw(str);
        fRSPageRequestMessage.setPn(1);
        if (com.baidu.tbadk.core.m.qQ().qW()) {
            fRSPageRequestMessage.setRn(35);
        } else {
            fRSPageRequestMessage.setRn(50);
        }
        fRSPageRequestMessage.setWithGroup(1);
        int K = com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity());
        int L = com.baidu.adp.lib.util.k.L(getPageContext().getPageActivity());
        float f = K / 320.0f;
        int i = ay.va().vc() ? 2 : 1;
        fRSPageRequestMessage.setScrW(K);
        fRSPageRequestMessage.setScrH(L);
        fRSPageRequestMessage.setScrDip(f);
        fRSPageRequestMessage.setqType(i);
        return fRSPageRequestMessage;
    }

    private void agA() {
        if (this.cpE != null) {
            this.cpE.setNextPage(null);
        }
        if (this.cpG != null) {
            this.cpG.clear();
            this.cpG.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        int i;
        int i2 = 0;
        try {
            if (this.mMode == 0) {
                if (this.cpI != null) {
                    if (this.cpI.forum_list != null && this.cpI.forum_list.size() > 0) {
                        agC();
                        this.cpE.setAdapter((ListAdapter) this.cpF);
                        this.cpF.jF(this.cpN);
                        this.cpF.N(this.cpI.forum_list);
                        this.cpF.notifyDataSetInvalidated();
                        return;
                    }
                    ad(this.cpZ);
                    agG();
                    agB();
                }
            } else if (this.cpJ != null) {
                List<k.a> list = this.cpJ.cQY;
                if (list != null && list.size() > 0) {
                    agC();
                    if (this.cpJ.getCurrentPage() == 1) {
                        this.cpE.setVisibility(0);
                        this.cpG.clear();
                        this.cpE.setAdapter((ListAdapter) this.cpG);
                        this.cpE.setNextPage(agH());
                    }
                    if (!this.cpJ.isHasMore()) {
                        agH().setText(getResources().getString(n.j.list_no_more));
                        agH().vP();
                    }
                    int bx = this.cpG.bx(list);
                    if (bx > 0) {
                        i = this.cpE.getFirstVisiblePosition() - bx;
                        View childAt = this.cpE.getChildAt(0);
                        if (childAt != null) {
                            i2 = childAt.getTop();
                        }
                    } else {
                        i = 0;
                    }
                    this.cpG.notifyDataSetChanged();
                    if (bx > 0) {
                        this.cpE.setSelectionFromTop(i, i2);
                    }
                    if (this.cpX) {
                        this.cpw.setVisibility(0);
                        this.cpX = false;
                        com.baidu.tbadk.core.sharedPref.b.tJ().putBoolean("search_post_show_dropmenu", false);
                    }
                } else if (this.mNoDataView.getVisibility() != 0) {
                    agE();
                    ad(this.cqa);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cM(n.j.text_no_suggest));
                }
            } else if (this.mNoDataView.getVisibility() != 0) {
                agE();
                ad(this.cqa);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.cM(n.j.text_no_suggest));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void agB() {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.baidu.tbadk.core.util.as.getColor(n.d.cp_cont_h));
        TextView textView = (TextView) this.cpv.findViewById(n.g.no_bar_found);
        textView.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.d.cp_cont_c));
        TextView textView2 = (TextView) this.cpv.findViewById(n.g.create_bar_guide);
        textView2.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.d.cp_cont_b));
        String str = "";
        if (this.cpN != null) {
            str = this.cpN.length() > 6 ? String.valueOf(this.cpN.substring(0, 6)) + "..." : this.cpN;
        }
        String format = String.format(getPageContext().getString(n.j.empty_search_result_format), str);
        String format2 = String.format(getPageContext().getString(n.j.create_bar_guide_format), str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
        spannableStringBuilder.setSpan(foregroundColorSpan, 4, format.length() - 2, 33);
        textView.setText(spannableStringBuilder);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(format2);
        spannableStringBuilder2.setSpan(foregroundColorSpan, 5, format2.length() - 5, 33);
        textView2.setText(spannableStringBuilder2);
        Drawable drawable = com.baidu.tbadk.core.util.as.getDrawable(n.f.icon_search_list_add);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        textView2.setCompoundDrawablePadding(com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), n.e.ds10));
        textView2.setCompoundDrawables(drawable, null, null, null);
        textView2.setOnClickListener(new am(this));
    }

    private void agC() {
        this.cpq.setVisibility(0);
        this.cpE.setVisibility(0);
        this.cpx.setVisibility(8);
        ad(this.cpZ);
        this.mNoDataView.setVisibility(8);
        this.cpw.setVisibility(8);
        this.cpv.setVisibility(8);
    }

    private void agD() {
        this.cpq.setVisibility(0);
        this.cpx.setVisibility(0);
        if (this.mMode == 0) {
            ac(this.cpY);
        } else {
            ad(this.cpY);
        }
        this.cpE.setVisibility(8);
        ad(this.cpZ);
        this.mNoDataView.setVisibility(8);
        this.cpw.setVisibility(8);
        this.cpv.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agE() {
        this.cpq.setVisibility(8);
        this.cpE.setVisibility(8);
        this.cpx.setVisibility(8);
        ac(this.cpZ);
        this.mNoDataView.setVisibility(0);
        if (this.mMode == 0) {
            ac(this.cqa);
        }
        this.cpw.setVisibility(8);
        this.cpv.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agF() {
        ad(this.cpZ);
        this.cpw.setVisibility(0);
    }

    private void agG() {
        this.cpq.setVisibility(8);
        this.cpE.setVisibility(8);
        this.cpx.setVisibility(8);
        ad(this.cpZ);
        this.mNoDataView.setVisibility(8);
        this.cpw.setVisibility(8);
        this.cpv.setVisibility(0);
        if (CreateBarActivityConfig.IS_SUPPORT_CREATE_BAR && this.cpN != null && this.cpN.length() <= 30) {
            em(true);
        } else {
            em(false);
        }
    }

    private void em(boolean z) {
        if (!z) {
            this.cqf.setVisibility(8);
            this.cqg.setVisibility(8);
            this.cqh.setVisibility(8);
            return;
        }
        this.cqf.setVisibility(0);
        this.cqg.setVisibility(0);
        this.cqh.setVisibility(0);
    }

    private PbListView agH() {
        if (this.cpD == null) {
            this.cpD = new PbListView(getPageContext().getPageActivity());
            this.cpD.mT();
        }
        return this.cpD;
    }

    @Override // com.baidu.tieba.mainentrance.d.a
    public void jG(String str) {
        this.cpT = true;
        this.cpa = new ArrayList();
        agv();
    }

    @Override // com.baidu.tieba.mainentrance.d.a
    public void a(List<com.baidu.tieba.mainentrance.c> list, List<g> list2, f fVar) {
        this.cpT = true;
        hideLoadingView(this.cpp);
        if (list == null || list.isEmpty()) {
            this.cpa = new ArrayList();
        } else {
            this.cpa = list;
        }
        if (list2 == null) {
            this.cpz = new ArrayList();
        } else {
            this.cpz = list2;
        }
        a(fVar);
        this.mHotSearchInfo = fVar;
        agv();
    }

    private void a(f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.sharedPref.b.tJ().putLong("hot_search_id", fVar.getId());
            com.baidu.tbadk.core.sharedPref.b.tJ().putString("hot_search_name", fVar.getName());
            com.baidu.tbadk.core.sharedPref.b.tJ().putString("hot_search_title", fVar.JV());
            com.baidu.tbadk.core.sharedPref.b.tJ().putLong("hot_search_type", fVar.getType());
            return;
        }
        com.baidu.tbadk.core.sharedPref.b.tJ().putLong("hot_search_id", 0L);
        com.baidu.tbadk.core.sharedPref.b.tJ().putString("hot_search_name", "");
        com.baidu.tbadk.core.sharedPref.b.tJ().putString("hot_search_title", "");
        com.baidu.tbadk.core.sharedPref.b.tJ().putLong("hot_search_type", 0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aUf.onChangeSkinType(i);
        getLayoutMode().ac(i == 1);
        getLayoutMode().k(this.cpo);
        getLayoutMode().k(this.cpv);
        com.baidu.tbadk.core.util.as.e(this.cpo, i);
        if (this.cpF != null) {
            this.cpF.notifyDataSetChanged();
        }
        if (this.cpG != null) {
            this.cpG.notifyDataSetChanged();
        }
        if (this.cpy != null) {
            this.cpy.notifyDataSetChanged();
        }
        com.baidu.tbadk.core.util.as.i(this.cpp, n.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.as.c(this.cpu, n.f.icon_search_ba);
        com.baidu.tbadk.core.util.as.b(this.cpt, n.d.cp_cont_i, 1);
        if (this.cpB != null) {
            getLayoutMode().k(this.cpB.getView());
        }
        if (this.cpA != null) {
            this.cpA.onChangeSkinType(i);
        }
        jI(i);
    }

    private void jI(int i) {
        if (this.cpC != null) {
            this.cpC.setBackgroundColor(com.baidu.tbadk.core.util.as.getColor(n.d.cp_bg_line_d));
        }
        if (this.cqb != null) {
            this.cqb.setBackgroundColor(com.baidu.tbadk.core.util.as.getColor(n.d.cp_bg_line_b));
        }
        if (this.cqc != null) {
            getLayoutMode().k(this.cqc);
        }
        if (this.cqd != null) {
            ((TextView) this.cqd.findViewById(n.g.home_bt_search_footer)).setTextColor(com.baidu.tbadk.core.util.as.getColor(n.d.s_actionbar_text_line_color_s));
        }
        if (this.cqe != null) {
            for (View view : this.cqe) {
                com.baidu.tbadk.core.util.as.b((TextView) view.findViewById(n.g.home_lv_search_forum), n.d.cp_cont_b, 1);
                view.findViewById(n.g.home_dialog_lv_search_forum_divider).setBackgroundColor(com.baidu.tbadk.core.util.as.getColor(n.d.cp_bg_line_b));
                com.baidu.tbadk.core.util.as.i(view, n.f.addresslist_item_bg);
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
                        SquareSearchActivity.this.gB(this.mName);
                        return;
                    }
                    SquareSearchActivity.this.I(1, this.mName);
                    SquareSearchActivity.this.cpr.setText(this.mName);
                    SquareSearchActivity.this.cpr.requestFocus();
                    Selection.setSelection(SquareSearchActivity.this.cpr.getText(), this.mName.length());
                    return;
                }
                com.baidu.tieba.tbadkCore.util.m.my(this.mName);
                SquareSearchActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(SquareSearchActivity.this.getActivity()).createNormalCfg(this.mName, FrsActivityConfig.FRS_FROM_SEARCH)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
        private com.baidu.tbadk.core.util.ab ahV = null;
        private BasicNameValuePair cqA;
        private String mUrl;

        public a(String str, BasicNameValuePair basicNameValuePair, boolean z) {
            this.mUrl = null;
            this.cqA = null;
            this.mUrl = str;
            this.cqA = basicNameValuePair;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!com.baidu.adp.lib.util.i.iQ()) {
                SquareSearchActivity.this.ac(SquareSearchActivity.this.mNoDataView);
                return;
            }
            SquareSearchActivity.this.ad(SquareSearchActivity.this.mNoDataView);
            SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.cpp, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(n.e.ds320));
            SquareSearchActivity.this.cpq.setVisibility(8);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public ForumSuggestModel doInBackground(Object... objArr) {
            ForumSuggestModel forumSuggestModel = null;
            if (com.baidu.adp.lib.util.i.iQ()) {
                try {
                    this.ahV = new com.baidu.tbadk.core.util.ab(this.mUrl);
                    this.ahV.a(this.cqA);
                    String tV = this.ahV.tV();
                    if (tV != null) {
                        forumSuggestModel = ForumSuggestModel.parserJson(tV);
                        SquareSearchActivity.this.cpO = this.cqA.getValue();
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
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.cpp);
            if (forumSuggestModel == null) {
                SquareSearchActivity.this.ac(SquareSearchActivity.this.mNoDataView);
            } else {
                SquareSearchActivity.this.ad(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.cpI = forumSuggestModel;
                SquareSearchActivity.this.refresh();
            }
            SquareSearchActivity.this.cpK = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.ahV != null) {
                this.ahV.gL();
                this.ahV = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.cpp);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Object, Integer, com.baidu.tieba.postsearch.k> {
        private com.baidu.tbadk.core.util.ab ahV = null;
        private ArrayList<BasicNameValuePair> cqB;
        private String mUrl;

        public b(String str, ArrayList<BasicNameValuePair> arrayList) {
            this.mUrl = null;
            this.cqB = null;
            this.mUrl = str;
            this.cqB = arrayList;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!com.baidu.adp.lib.util.i.iQ()) {
                SquareSearchActivity.this.ac(SquareSearchActivity.this.mNoDataView);
                return;
            }
            SquareSearchActivity.this.ad(SquareSearchActivity.this.mNoDataView);
            SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.cpp, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(n.e.ds320));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: z */
        public com.baidu.tieba.postsearch.k doInBackground(Object... objArr) {
            Exception exc;
            com.baidu.tieba.postsearch.k kVar;
            if (com.baidu.adp.lib.util.i.iQ()) {
                try {
                    this.ahV = new com.baidu.tbadk.core.util.ab(this.mUrl);
                    Iterator<BasicNameValuePair> it = this.cqB.iterator();
                    while (it.hasNext()) {
                        this.ahV.a(it.next());
                    }
                    String tV = this.ahV.tV();
                    if (!this.ahV.uw().vq().uz() || tV == null) {
                        kVar = null;
                    } else {
                        com.baidu.tieba.postsearch.k kVar2 = new com.baidu.tieba.postsearch.k();
                        try {
                            kVar2.parseJson(tV);
                            if (tV != null && this.ahV != null && this.ahV.uw().vq().qO()) {
                                Iterator<BasicNameValuePair> it2 = this.cqB.iterator();
                                while (it2.hasNext()) {
                                    BasicNameValuePair next = it2.next();
                                    if ("word".equals(next.getName())) {
                                        SquareSearchActivity.this.cpP = next.getValue();
                                    }
                                    if ("pn".equals(next.getName())) {
                                        SquareSearchActivity.this.cpR = Integer.valueOf(next.getValue()).intValue();
                                    }
                                }
                            }
                            if (this.ahV.uw().vq().qO()) {
                                com.baidu.tieba.tbadkCore.util.m.mz(SquareSearchActivity.this.cpN);
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
            SquareSearchActivity.this.cpW = false;
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.cpp);
            SquareSearchActivity.this.cpG.notifyDataSetChanged();
            if (kVar == null) {
                SquareSearchActivity.this.ac(SquareSearchActivity.this.mNoDataView);
            } else {
                SquareSearchActivity.this.ad(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.cpJ = kVar;
                SquareSearchActivity.this.refresh();
            }
            SquareSearchActivity.this.cpL = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            SquareSearchActivity.this.cpG.notifyDataSetChanged();
            if (this.ahV != null) {
                this.ahV.gL();
                this.ahV = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.cpp);
            SquareSearchActivity.this.cpL = null;
            super.onCancelled();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!this.cpW && this.cpJ != null && this.cpJ.isHasMore()) {
            I(this.cpJ.getCurrentPage() + 1, this.cpN);
            agH().startLoadData();
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

    private void agI() {
        this.cpY = new SearchPageFocusBar(getPageContext().getPageActivity());
        this.cpY.setVisibility(8);
        this.cpx.addFooterView(this.cpY, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(View view) {
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(View view) {
        if (view != null) {
            view.setVisibility(8);
        }
    }
}
