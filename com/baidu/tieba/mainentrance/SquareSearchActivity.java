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
import com.baidu.tbadk.util.BdListViewHelper;
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
    private FragmentTabWidget aXd;
    private boolean avp;
    private List<com.baidu.tieba.mainentrance.c> cLA;
    private FragmentTabIndicator cLK;
    private LinearLayoutDetectsSoftKeyboard cLL;
    private FrameLayout cLM;
    private FrameLayout cLN;
    private EditText cLO;
    private TextView cLP;
    private TextView cLQ;
    private ImageView cLR;
    private View cLS;
    private View cLT;
    private ListView cLU;
    private com.baidu.tieba.mainentrance.b cLV;
    private List<g> cLW;
    private l cLX;
    private LinearLayout cLY;
    private PbListView cLZ;
    private View cMB;
    private TextView cMC;
    private View cMD;
    private BdListView cMa;
    private com.baidu.tieba.mainentrance.a cMb;
    private com.baidu.tieba.postsearch.w cMc;
    private d cMd;
    private ForumSuggestModel cMe;
    private com.baidu.tieba.postsearch.k cMf;
    private a cMg;
    private b cMh;
    private String cMj;
    private String cMk;
    private String cMl;
    private String cMm;
    private boolean cMp;
    private boolean cMr;
    private boolean cMt;
    private SearchPageFocusBar cMu;
    private ScrollView cMv;
    private SearchPageFocusBar cMw;
    private View cMx;
    private View cMy;
    private View cMz;
    private f mHotSearchInfo;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.q mNoDataView;
    private String mTopicInfoTitle;
    private boolean cMi = false;
    private int mMode = 0;
    private int cMn = 0;
    private int cMo = -1;
    private boolean aqS = true;
    private boolean cMq = true;
    private boolean cMs = false;
    private List<View> cMA = new ArrayList();
    private Runnable cME = new m(this);
    private final View.OnClickListener cMF = new x(this);
    private final com.baidu.adp.framework.listener.e cMG = new ai(this, 301001, true);
    private final HttpMessageListener cMH = new an(this, CmdConfigHttp.FRS_HTTP_CMD, true);
    private CustomMessageListener cMI = new ao(this, CmdConfigCustom.CMD_READ_SEARCHPERSON_HISTORY);
    private CustomMessageListener cMJ = new ap(this, CmdConfigCustom.CMD_WRITE_SEARCHPERSON_HISTORY);
    private HttpMessageListener cMK = new aq(this, CmdConfigHttp.SEARCH_FRIEND_CMD);
    private final Runnable cML = new ar(this);
    private CustomMessageListener cMM = new as(this, CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA);
    private CustomMessageListener cMN = new n(this, CmdConfigCustom.GET_ALL_SEARCH_POST_DATA);
    private View.OnClickListener cMO = new o(this);
    private CustomMessageListener cMP = new p(this, CmdConfigCustom.CMD_ENTER_FORUM_INFO);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponsedMessage<?> responsedMessage, boolean z) {
        int error = responsedMessage.getError();
        String string = StringUtils.isNull(responsedMessage.getErrorString()) ? getResources().getString(t.j.neterror) : responsedMessage.getErrorString();
        boolean z2 = error < -13 || error > -10;
        if (error == 0) {
            this.cMi = true;
            sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createFlagCfg(this.cMm, FrsActivityConfig.FRS_FROM_SEARCH, 1)));
        } else if (z2 && z && error == 3) {
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.m11getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(t.j.login_to_use), true, 11013)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), this.cMm)));
            }
        } else {
            showToast(string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aoC() {
        if (this.mMode == 0 && this.mHotSearchInfo != null) {
            if (this.mHotSearchInfo.Ml() == 0) {
                kD(this.mHotSearchInfo.getName());
            } else if (this.mHotSearchInfo.Ml() == 1 && !com.baidu.tbadk.plugins.a.f(getPageContext())) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "")));
            }
            TiebaStatic.log(new aw("c10355").ac("obj_name", this.mHotSearchInfo.getName()).s("obj_type", this.mHotSearchInfo.Ml() == 0 ? 2 : 1));
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gN(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SEARCH_FRIEND_CMD);
        httpMessage.addParam("search_key", str);
        sendMessage(httpMessage);
    }

    private void ID() {
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
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), this.cMm)));
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
        ID();
        registerListener(this.cMI);
        registerListener(this.cMJ);
        registerListener(this.cMM);
        registerListener(this.cMN);
        registerListener(this.cMK);
        registerListener(this.cMG);
        registerListener(this.cMH);
        registerListener(this.cMP);
        this.cMt = com.baidu.tbadk.core.sharedPref.b.sR().getBoolean("search_post_show_dropmenu", true);
        if (SquareSearchActivityConfig.IS_SHOW_RECOMMEND_FORUM) {
            this.cMd = new d(this, this);
            this.cMd.aoB();
            this.cMd.aoA();
        }
        this.cMp = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mMode == 0 && this.cMi) {
            this.cMi = false;
            if (this.cMe != null && this.cMe.forum_list != null && this.cMe.forum_list.size() > 0) {
                aoT();
                this.cMa.setAdapter((ListAdapter) this.cMb);
                this.cMb.kA(this.cMj);
                this.cMb.O(this.cMe.forum_list);
                this.cMb.notifyDataSetInvalidated();
            }
        } else if (this.mMode == 3) {
            aoO();
        }
        this.aqS = true;
        if (this.cMq) {
            this.mHandler.post(this.cME);
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
        hideLoadingView(this.cLM);
        this.mHandler.removeCallbacks(this.cME);
        aoD();
    }

    public void aoD() {
        this.mHandler.removeCallbacks(this.cML);
        if (this.cMg != null) {
            this.cMg.cancel();
            this.cMg = null;
        }
        if (this.cMh != null) {
            this.cMh.cancel();
            this.cMh = null;
        }
    }

    private void init() {
        this.cLL = (LinearLayoutDetectsSoftKeyboard) findViewById(t.g.parent);
        this.cLL.setOnSoftKeyBoardShownListener(new q(this));
        this.cLL.setOnTouchListener(new r(this));
        Mv();
        Ux();
        this.cLM = (FrameLayout) findViewById(t.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(t.e.ds320)), null, null);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            this.cMv = (ScrollView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(t.h.home_searchbar_nodataview, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) this.cMv.findViewById(t.g.focusbar_nodata_root);
            this.cMw = (SearchPageFocusBar) linearLayout.findViewById(t.g.no_data_focusbar);
            linearLayout.addView(this.mNoDataView, 0);
            this.cMv.setOnTouchListener(new s(this));
            this.cLM.addView(this.cMv, this.cLM.getChildCount());
        } else {
            this.cLM.addView(this.mNoDataView, 0);
        }
        this.cLN = (FrameLayout) findViewById(t.g.home_search_list);
        aoK();
        aoE();
        aoF();
        aoG();
        this.cLS = findViewById(t.g.empty_search_result);
        this.cMB = this.cLS.findViewById(t.g.empty_result_divider_1);
        this.cMB.setBackgroundColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_bg_line_b));
        this.cMC = (TextView) this.cLS.findViewById(t.g.create_bar_guide);
        this.cMC.setBackgroundDrawable(com.baidu.tbadk.core.util.at.getDrawable(t.f.addresslist_item_bg));
        this.cMD = this.cLS.findViewById(t.g.empty_result_divider_2);
        this.cMD.setBackgroundColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_bg_line_b));
        aoH();
        this.cLO.setText("");
        this.cLO.requestFocus();
        ShowSoftKeyPadDelay(this.cLO, 200);
        if (TbadkSettings.getInst().loadBoolean("search_mode", true)) {
            kx(0);
            aoJ();
            return;
        }
        kx(1);
    }

    private void Ux() {
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new t(this));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, t.h.square_search_navigation_view, (View.OnClickListener) null);
        this.cLR = (ImageView) addCustomView.findViewById(t.g.search_bar_icon);
        this.cLO = (EditText) addCustomView.findViewById(t.g.home_et_search);
        this.cLP = (TextView) addCustomView.findViewById(t.g.home_bt_search_del);
        this.cLQ = (TextView) addCustomView.findViewById(t.g.home_bt_search_s);
        this.cLO.setOnFocusChangeListener(new u(this));
        this.cLQ.setText(getPageContext().getString(t.j.forward));
        this.cLQ.setOnClickListener(this.cMF);
        this.cLO.setOnEditorActionListener(new v(this));
        this.cLP.setOnClickListener(new w(this));
        this.cLO.addTextChangedListener(new y(this));
    }

    private void Mv() {
        this.aXd = (FragmentTabWidget) findViewById(t.g.square_search_tab_widget);
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(t.e.ds32));
        fragmentTabIndicator.setGravity(17);
        fragmentTabIndicator.auL = t.d.s_actionbar_text_color;
        fragmentTabIndicator.setText(getResources().getString(t.j.search_bar_text));
        this.cLK = new FragmentTabIndicator(getPageContext().getPageActivity());
        this.cLK.auL = t.d.s_actionbar_text_color;
        this.cLK.setTextSize(0, getResources().getDimension(t.e.ds32));
        this.cLK.setGravity(17);
        this.cLK.setCompoundDrawablesRightResId(t.f.icon_toolbar_arrow_down);
        this.cLK.setCompoundDrawablePadding(getResources().getDimensionPixelSize(t.e.ds10));
        this.cLK.setText(getResources().getString(t.j.search_post_text));
        this.cLK.Df();
        FragmentTabIndicator fragmentTabIndicator2 = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator2.auL = t.d.s_actionbar_text_color;
        fragmentTabIndicator2.setTextSize(0, getResources().getDimension(t.e.ds32));
        fragmentTabIndicator2.setGravity(17);
        fragmentTabIndicator2.setText(getResources().getString(t.j.search_person));
        this.aXd.addView(fragmentTabIndicator);
        this.aXd.addView(this.cLK);
        this.aXd.addView(fragmentTabIndicator2);
        this.aXd.f(0, true);
        this.aXd.setTabSelectionListener(new z(this));
    }

    private void aoE() {
        this.cLU = (ListView) findViewById(t.g.home_lv_search_history);
        if (this.cLY == null) {
            this.cLY = new LinearLayout(getPageContext().getPageActivity());
            this.cLY.setOrientation(1);
            this.cLY.setBackgroundColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_bg_line_d));
        }
        this.cLU.addFooterView(this.cLY);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            apa();
        }
        this.cLV = new com.baidu.tieba.mainentrance.b(this);
        this.cLU.setAdapter((ListAdapter) this.cLV);
        this.cLV.u(new aa(this));
    }

    private void aoF() {
        if (this.cLX == null) {
            this.cLX = new l(getPageContext());
            this.cLU.addHeaderView(this.cLX.jn());
        }
    }

    private void aoG() {
        this.cMa = (BdListView) findViewById(t.g.home_lv_search_suggest);
        BdListViewHelper.a(getActivity(), this.cMa, BdListViewHelper.HeadType.HASTAB);
        this.cMb = new com.baidu.tieba.mainentrance.a(this, null);
        this.cMc = new com.baidu.tieba.postsearch.w(getPageContext());
        this.cMa.setOnItemClickListener(new ab(this));
        ac acVar = new ac(this);
        this.cMa.setOnScrollListener(acVar);
        this.cLU.setOnScrollListener(acVar);
        this.cMa.setOnSrollToBottomListener(this);
    }

    private void aoH() {
        this.cLT = findViewById(t.g.search_dropmenu);
        TextView textView = (TextView) this.cLT.findViewById(t.g.dropmenu_all_text);
        textView.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_link_tip_a));
        ImageView imageView = (ImageView) this.cLT.findViewById(t.g.dropmenu_all_icon);
        imageView.setImageDrawable(com.baidu.tbadk.core.util.at.getDrawable(t.f.chx_tips_list_ok));
        imageView.setVisibility(0);
        TextView textView2 = (TextView) this.cLT.findViewById(t.g.dropmenu_thread_text);
        textView2.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_c));
        ImageView imageView2 = (ImageView) this.cLT.findViewById(t.g.dropmenu_thread_icon);
        imageView2.setImageDrawable(com.baidu.tbadk.core.util.at.getDrawable(t.f.chx_tips_list_ok));
        imageView2.setVisibility(8);
        this.cLT.findViewById(t.g.dropmenu_all_layout).setBackgroundColor(com.baidu.tbadk.core.util.at.getColor(t.d.search_dropmenu_bg));
        this.cLT.findViewById(t.g.dropmenu_divider).setBackgroundColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_bg_line_b));
        this.cLT.findViewById(t.g.dropmenu_thread_layout).setBackgroundColor(com.baidu.tbadk.core.util.at.getColor(t.d.search_dropmenu_bg));
        this.cLT.findViewById(t.g.dropmenu_lower_part).setBackgroundColor(com.baidu.tbadk.core.util.at.getColor(t.d.black_alpha40));
        this.cLT.findViewById(t.g.dropmenu_all_layout).setOnClickListener(new ad(this, textView, imageView, textView2, imageView2));
        this.cLT.findViewById(t.g.dropmenu_thread_layout).setOnClickListener(new ae(this, textView, imageView, textView2, imageView2));
        this.cLT.findViewById(t.g.dropmenu_lower_part).setOnClickListener(new af(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoI() {
        if (this.cLN.getVisibility() == 8 && this.mNoDataView.getVisibility() == 8 && this.cLS.getVisibility() == 8) {
            aI(this.cMv);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cO(t.j.text_no_search_record));
        }
    }

    public void kx(int i) {
        switch (i) {
            case 0:
                if (this.mMode != 0) {
                    this.mMode = 0;
                    this.cLQ.setText(getPageContext().getString(t.j.forward));
                    aoJ();
                    aoD();
                    aoR();
                    if (this.cMj.trim().length() > 0) {
                        aoQ();
                        return;
                    } else {
                        aoM();
                        return;
                    }
                }
                return;
            case 1:
                if (this.mMode != 1) {
                    this.mMode = 1;
                    this.cLQ.setText(getPageContext().getString(t.j.search));
                    this.cLO.setHint(t.j.search_post_hint);
                    aoD();
                    aoR();
                    if (this.cMj.trim().length() > 0) {
                        this.cMa.setVisibility(8);
                        C(1, this.cMj);
                        return;
                    }
                    aoN();
                    return;
                }
                return;
            case 2:
            default:
                return;
            case 3:
                if (this.mMode != 3) {
                    this.mMode = 3;
                    this.cMa.setVisibility(8);
                    this.cLS.setVisibility(8);
                    this.cLT.setVisibility(8);
                    this.cLQ.setText(t.j.search);
                    this.cLO.setHint(t.j.search_friend_tip);
                    aoR();
                    aoD();
                    aoO();
                    return;
                }
                return;
        }
    }

    private void aoJ() {
        if (this.mHotSearchInfo == null) {
            this.cLO.setHint(t.j.search_bar);
        } else {
            this.cLO.setHint(UtilHelper.getFixedText(this.mHotSearchInfo.Mk(), 12));
        }
    }

    private void aoK() {
        long j = com.baidu.tbadk.core.sharedPref.b.sR().getLong("hot_search_id", 0L);
        if (j != 0) {
            this.mHotSearchInfo = new f();
            this.mHotSearchInfo.setId(j);
            this.mHotSearchInfo.setName(com.baidu.tbadk.core.sharedPref.b.sR().getString("hot_search_name", ""));
            this.mHotSearchInfo.kC(com.baidu.tbadk.core.sharedPref.b.sR().getString("hot_search_title", ""));
            this.mHotSearchInfo.bq(com.baidu.tbadk.core.sharedPref.b.sR().getLong("hot_search_type", 0L));
        }
    }

    public void aoL() {
        kD(this.cLO.getText().toString().trim());
    }

    private void kD(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (com.baidu.adp.lib.util.i.fq()) {
                this.cMm = str;
                this.aqS = false;
                sendMessage(kE(str));
                return;
            }
            showToast(t.j.neterror);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoM() {
        this.cMa.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA));
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            fv(true);
            aJ(this.cMw);
            aJ(this.cMv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoN() {
        this.cMa.setVisibility(8);
        aJ(this.cMu);
        aJ(this.cMw);
        aJ(this.cMv);
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoO() {
        this.cMa.setVisibility(8);
        aJ(this.cMu);
        aJ(this.cMw);
        aJ(this.cMv);
        if (!this.avp) {
            sendMessage(new RequestSearchPersonHistoryReadMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ArrayList<String> arrayList) {
        NoDataViewFactory.d cO;
        boolean z = false;
        if (b(i, arrayList) || c(i, arrayList) || d(i, arrayList)) {
            aoV();
            if (com.baidu.adp.lib.util.i.fq()) {
                cO = NoDataViewFactory.d.cO(t.j.text_no_search_record);
            } else {
                cO = NoDataViewFactory.d.cO(t.j.neterror);
            }
            this.mNoDataView.setTextOption(cO);
            return;
        }
        aoU();
        List arrayList2 = new ArrayList();
        if (i == 4) {
            arrayList2 = this.cLW;
        }
        a(i, arrayList, (this.cLW == null ? 0 : arrayList2.size()) >= 1);
        boolean z2 = i == 4;
        if (arrayList == null || arrayList.size() == 0) {
            z = true;
        }
        p(z2, z);
        if (i == 4) {
            aoJ();
        }
    }

    private void a(int i, ArrayList<String> arrayList, boolean z) {
        if (this.cLY != null) {
            this.cLY.removeAllViews();
            if (arrayList != null && !arrayList.isEmpty() && getActivity() != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                if (z) {
                    this.cMx = new View(pageActivity);
                    this.cMx.setBackgroundColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_bg_line_b));
                    layoutParams.height = com.baidu.adp.lib.util.k.c(pageActivity, t.e.ds12);
                    layoutParams.topMargin = com.baidu.adp.lib.util.k.c(pageActivity, t.e.ds14);
                    this.cLY.addView(this.cMx, layoutParams);
                }
                this.cMy = LayoutInflater.from(pageActivity).inflate(t.h.square_search_recommand_fourm_header, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                getLayoutMode().x(this.cMy);
                this.cLY.addView(this.cMy, layoutParams2);
                int size = arrayList.size();
                this.cMA.clear();
                for (int i2 = 0; i2 < size; i2++) {
                    String str = arrayList.get(i2);
                    if (!TextUtils.isEmpty(str)) {
                        View inflate = LayoutInflater.from(pageActivity).inflate(t.h.home_dialog_search_item, (ViewGroup) null);
                        ((TextView) inflate.findViewById(t.g.home_lv_search_forum)).setText(str);
                        com.baidu.tbadk.core.util.at.c((TextView) inflate.findViewById(t.g.home_lv_search_forum), t.d.cp_cont_b, 1);
                        inflate.findViewById(t.g.home_dialog_lv_search_forum_divider).setVisibility(8);
                        com.baidu.tbadk.core.util.at.k(inflate, t.f.square_search_item_bg);
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                        inflate.setOnClickListener(new c(str));
                        this.cMA.add(inflate);
                        this.cLY.addView(inflate, layoutParams3);
                    }
                }
                this.cMz = LayoutInflater.from(pageActivity).inflate(t.h.home_dialog_search_footer, (ViewGroup) null);
                ((TextView) this.cMz.findViewById(t.g.home_bt_search_footer)).setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.s_actionbar_text_line_color_s));
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                this.cMz.setOnClickListener(new ag(this));
                this.cLY.addView(this.cMz, layoutParams4);
            }
        }
    }

    private void p(boolean z, boolean z2) {
        if (this.cLX != null) {
            this.cLX.clear();
            if (this.cLW != null && !this.cLW.isEmpty() && z) {
                this.cLX.setTitleText(this.mTopicInfoTitle);
                int size = this.cLW.size();
                if (size >= 1) {
                    int i = size <= 7 ? size : 7;
                    int i2 = i % 2 == 0 ? i - 1 : i;
                    for (int i3 = 0; i3 < i2; i3++) {
                        g gVar = (g) com.baidu.tbadk.core.util.y.c(this.cLW, i3);
                        if (gVar != null) {
                            this.cLX.a(gVar, i3).setOnClickListener(this.cMO);
                        }
                    }
                    this.cLX.a(null, i2).setOnClickListener(new ah(this));
                    this.cLX.show();
                }
            }
        }
    }

    private boolean b(int i, ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && (this.cLA == null || this.cLA.size() <= 2) && 4 == i && this.mMode == 0 && (this.cLW == null || this.cLW.size() <= 2);
    }

    private boolean c(int i, ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && i == 5 && this.mMode != 5;
    }

    private boolean d(int i, ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && i == 6 && this.mMode != 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoP() {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).cA(getPageContext().getString(t.j.alert_clean_history)).a(getPageContext().getString(t.j.clear_all_text), new aj(this)).b(getPageContext().getString(t.j.alert_no_button), new al(this)).b(getPageContext()).rV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoQ() {
        this.cLN.setVisibility(8);
        if (this.cMj != null) {
            if (this.cMj.equals(this.cMk)) {
                refresh();
                return;
            }
            aJ(this.cMu);
            aJ(this.cMw);
            aJ(this.cMv);
            this.mHandler.removeCallbacks(this.cML);
            this.mHandler.postDelayed(this.cML, 500L);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v6 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void C(int i, String str) {
        if (!aoZ()) {
            this.cLU.setVisibility(8);
            if (str != null && str.trim().length() > 0) {
                int i2 = this.cMr ? 1 : 0;
                if (str.equals(this.cMl) && i == this.cMn && this.cMo == i2) {
                    refresh();
                    return;
                }
                this.cMo = i2;
                StringBuffer stringBuffer = new StringBuffer(30);
                stringBuffer.append(TbConfig.SERVER_ADDRESS);
                stringBuffer.append(TbConfig.POST_SEARCH_URL);
                ArrayList arrayList = new ArrayList();
                arrayList.add(new BasicNameValuePair("word", str));
                arrayList.add(new BasicNameValuePair("pn", String.valueOf(i)));
                arrayList.add(new BasicNameValuePair(LegoListActivityConfig.RN, String.valueOf(50)));
                arrayList.add(new BasicNameValuePair("only_thread", new StringBuilder().append(i2).toString()));
                arrayList.add(new BasicNameValuePair("st_type", "search_post"));
                aoD();
                this.cMh = new b(stringBuffer.toString(), arrayList);
                this.cMh.setPriority(3);
                this.cMh.execute(new Object[0]);
                this.cMs = true;
            }
        }
    }

    private FRSPageRequestMessage kE(String str) {
        FRSPageRequestMessage fRSPageRequestMessage = new FRSPageRequestMessage();
        fRSPageRequestMessage.setKw(str);
        fRSPageRequestMessage.setPn(1);
        if (com.baidu.tbadk.core.l.ob().oh()) {
            fRSPageRequestMessage.setRn(35);
        } else {
            fRSPageRequestMessage.setRn(50);
        }
        fRSPageRequestMessage.setWithGroup(1);
        int B = com.baidu.adp.lib.util.k.B(getPageContext().getPageActivity());
        int C = com.baidu.adp.lib.util.k.C(getPageContext().getPageActivity());
        float f = B / 320.0f;
        int i = az.ug().ui() ? 2 : 1;
        fRSPageRequestMessage.setScrW(B);
        fRSPageRequestMessage.setScrH(C);
        fRSPageRequestMessage.setScrDip(f);
        fRSPageRequestMessage.setqType(i);
        return fRSPageRequestMessage;
    }

    private void aoR() {
        if (this.cMa != null) {
            this.cMa.setNextPage(null);
        }
        if (this.cMc != null) {
            this.cMc.clear();
            this.cMc.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        int i;
        int i2 = 0;
        try {
            if (this.mMode == 0) {
                if (this.cMe != null) {
                    if (this.cMe.forum_list != null && this.cMe.forum_list.size() > 0) {
                        aoT();
                        this.cMa.setAdapter((ListAdapter) this.cMb);
                        this.cMb.kA(this.cMj);
                        this.cMb.O(this.cMe.forum_list);
                        this.cMb.notifyDataSetInvalidated();
                        return;
                    }
                    aJ(this.cMv);
                    aoX();
                    aoS();
                }
            } else if (this.cMf != null) {
                List<k.a> list = this.cMf.dyd;
                if (list != null && list.size() > 0) {
                    aoT();
                    if (this.cMf.lk() == 1) {
                        this.cMa.setVisibility(0);
                        this.cMc.clear();
                        this.cMa.setAdapter((ListAdapter) this.cMc);
                        this.cMa.setNextPage(aoY());
                    }
                    if (!this.cMf.isHasMore()) {
                        aoY().setText(getResources().getString(t.j.list_no_more));
                        aoY().vi();
                    }
                    int cf = this.cMc.cf(list);
                    if (cf > 0) {
                        i = this.cMa.getFirstVisiblePosition() - cf;
                        View childAt = this.cMa.getChildAt(0);
                        if (childAt != null) {
                            i2 = childAt.getTop();
                        }
                    } else {
                        i = 0;
                    }
                    this.cMc.notifyDataSetChanged();
                    if (cf > 0) {
                        this.cMa.setSelectionFromTop(i, i2);
                    }
                    if (this.cMt) {
                        this.cLT.setVisibility(0);
                        this.cMt = false;
                        com.baidu.tbadk.core.sharedPref.b.sR().putBoolean("search_post_show_dropmenu", false);
                    }
                } else if (this.mNoDataView.getVisibility() != 0) {
                    aoV();
                    aJ(this.cMw);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cO(t.j.text_no_suggest));
                }
            } else if (this.mNoDataView.getVisibility() != 0) {
                aoV();
                aJ(this.cMw);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.cO(t.j.text_no_suggest));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void aoS() {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_h));
        TextView textView = (TextView) this.cLS.findViewById(t.g.no_bar_found);
        textView.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_c));
        TextView textView2 = (TextView) this.cLS.findViewById(t.g.create_bar_guide);
        textView2.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_b));
        String str = "";
        if (this.cMj != null) {
            str = this.cMj.length() > 6 ? String.valueOf(this.cMj.substring(0, 6)) + "..." : this.cMj;
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

    private void aoT() {
        this.cLN.setVisibility(0);
        this.cMa.setVisibility(0);
        this.cLU.setVisibility(8);
        aJ(this.cMv);
        this.mNoDataView.setVisibility(8);
        this.cLT.setVisibility(8);
        this.cLS.setVisibility(8);
    }

    private void aoU() {
        this.cLN.setVisibility(0);
        this.cLU.setVisibility(0);
        if (this.mMode == 0) {
            aI(this.cMu);
        } else {
            aJ(this.cMu);
        }
        this.cMa.setVisibility(8);
        aJ(this.cMv);
        this.mNoDataView.setVisibility(8);
        this.cLT.setVisibility(8);
        this.cLS.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoV() {
        this.cLN.setVisibility(8);
        this.cMa.setVisibility(8);
        this.cLU.setVisibility(8);
        aI(this.cMv);
        this.mNoDataView.setVisibility(0);
        if (this.mMode == 0) {
            aI(this.cMw);
        }
        this.cLT.setVisibility(8);
        this.cLS.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoW() {
        aJ(this.cMv);
        this.cLT.setVisibility(0);
    }

    private void aoX() {
        this.cLN.setVisibility(8);
        this.cMa.setVisibility(8);
        this.cLU.setVisibility(8);
        aJ(this.cMv);
        this.mNoDataView.setVisibility(8);
        this.cLT.setVisibility(8);
        this.cLS.setVisibility(0);
        if (CreateBarActivityConfig.IS_SUPPORT_CREATE_BAR && this.cMj != null && this.cMj.length() <= 30) {
            fu(true);
        } else {
            fu(false);
        }
    }

    private void fu(boolean z) {
        if (!z) {
            this.cMB.setVisibility(8);
            this.cMC.setVisibility(8);
            this.cMD.setVisibility(8);
            return;
        }
        this.cMB.setVisibility(0);
        this.cMC.setVisibility(0);
        this.cMD.setVisibility(0);
    }

    private PbListView aoY() {
        if (this.cLZ == null) {
            this.cLZ = new PbListView(getPageContext().getPageActivity());
            this.cLZ.jn();
        }
        return this.cLZ;
    }

    @Override // com.baidu.tieba.mainentrance.d.a
    public void kB(String str) {
        this.cMp = true;
        this.cLA = new ArrayList();
        this.cLW = new ArrayList();
        aoM();
    }

    @Override // com.baidu.tieba.mainentrance.d.a
    public void a(List<com.baidu.tieba.mainentrance.c> list, List<g> list2, f fVar, String str) {
        this.cMp = true;
        hideLoadingView(this.cLM);
        if (list == null || list.isEmpty()) {
            this.cLA = new ArrayList();
        } else {
            this.cLA = list;
        }
        if (list2 == null) {
            this.cLW = new ArrayList();
        } else {
            this.cLW = list2;
        }
        if (!StringUtils.isNULL(str)) {
            this.mTopicInfoTitle = str;
        } else {
            this.mTopicInfoTitle = "";
        }
        a(fVar);
        this.mHotSearchInfo = fVar;
        aoM();
    }

    private void a(f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.sharedPref.b.sR().putLong("hot_search_id", fVar.getId());
            com.baidu.tbadk.core.sharedPref.b.sR().putString("hot_search_name", fVar.getName());
            com.baidu.tbadk.core.sharedPref.b.sR().putString("hot_search_title", fVar.Mk());
            com.baidu.tbadk.core.sharedPref.b.sR().putLong("hot_search_type", fVar.Ml());
            return;
        }
        com.baidu.tbadk.core.sharedPref.b.sR().putLong("hot_search_id", 0L);
        com.baidu.tbadk.core.sharedPref.b.sR().putString("hot_search_name", "");
        com.baidu.tbadk.core.sharedPref.b.sR().putString("hot_search_title", "");
        com.baidu.tbadk.core.sharedPref.b.sR().putLong("hot_search_type", 0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aXd.onChangeSkinType(i);
        getLayoutMode().ae(i == 1);
        getLayoutMode().x(this.cLL);
        getLayoutMode().x(this.cLS);
        com.baidu.tbadk.core.util.at.g(this.cLL, i);
        if (this.cMb != null) {
            this.cMb.notifyDataSetChanged();
        }
        if (this.cMc != null) {
            this.cMc.notifyDataSetChanged();
        }
        if (this.cLV != null) {
            this.cLV.notifyDataSetChanged();
        }
        if (i == 2) {
            this.cLO.setHintTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.s_navbar_title_color));
            this.cLP.setBackgroundDrawable(com.baidu.tbadk.core.util.at.getDrawable(t.f.search_del_btn));
        } else {
            this.cLO.setHintTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_e));
            this.cLP.setBackgroundDrawable(com.baidu.tbadk.core.util.at.getDrawable(t.f.search_del_btn_s));
        }
        com.baidu.tbadk.core.util.at.b(this.cLO, t.d.cp_cont_b, t.d.s_navbar_title_color);
        com.baidu.tbadk.core.util.at.a(this.cLR, t.f.icon_search_ba, t.f.icon_search_ba_w, t.f.icon_search_ba, i);
        com.baidu.tbadk.core.util.at.k(this.cLM, t.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.at.c(this.cLQ, t.d.cp_cont_i, 1);
        if (this.cLX != null) {
            this.cLX.onChangeSkinType(i);
        }
        ky(i);
    }

    private void ky(int i) {
        if (this.cLY != null) {
            this.cLY.setBackgroundColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_bg_line_d));
        }
        if (this.cMx != null) {
            this.cMx.setBackgroundColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_bg_line_b));
        }
        if (this.cMy != null) {
            getLayoutMode().x(this.cMy);
        }
        if (this.cMz != null) {
            ((TextView) this.cMz.findViewById(t.g.home_bt_search_footer)).setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.s_actionbar_text_line_color_s));
        }
        if (this.cMA != null) {
            for (View view : this.cMA) {
                com.baidu.tbadk.core.util.at.c((TextView) view.findViewById(t.g.home_lv_search_forum), t.d.cp_cont_b, 1);
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
            com.baidu.tbadk.core.e.b.d(getPageContext().getPageActivity(), 1);
        } else {
            com.baidu.tbadk.core.e.b.d(getPageContext().getPageActivity(), 2);
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
                        SquareSearchActivity.this.gN(this.mName);
                        return;
                    }
                    SquareSearchActivity.this.C(1, this.mName);
                    SquareSearchActivity.this.cLO.setText(this.mName);
                    SquareSearchActivity.this.cLO.requestFocus();
                    Selection.setSelection(SquareSearchActivity.this.cLO.getText(), this.mName.length());
                    return;
                }
                com.baidu.tieba.tbadkCore.util.m.nX(this.mName);
                SquareSearchActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(SquareSearchActivity.this.getActivity()).createNormalCfg(this.mName, FrsActivityConfig.FRS_FROM_SEARCH)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aoZ() {
        if (!com.baidu.adp.lib.util.i.fq()) {
            aI(this.mNoDataView);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cO(t.j.neterror));
            return true;
        }
        aJ(this.mNoDataView);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
        private com.baidu.tbadk.core.util.ab aeI = null;
        private BasicNameValuePair cMW;
        private String mUrl;

        public a(String str, BasicNameValuePair basicNameValuePair, boolean z) {
            this.mUrl = null;
            this.cMW = null;
            this.mUrl = str;
            this.cMW = basicNameValuePair;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (SquareSearchActivity.this.aoZ()) {
                return;
            }
            SquareSearchActivity.this.aJ(SquareSearchActivity.this.mNoDataView);
            SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.cLM, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(t.e.ds320));
            SquareSearchActivity.this.cLN.setVisibility(8);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: w */
        public ForumSuggestModel doInBackground(Object... objArr) {
            ForumSuggestModel forumSuggestModel = null;
            if (com.baidu.adp.lib.util.i.fq()) {
                try {
                    this.aeI = new com.baidu.tbadk.core.util.ab(this.mUrl);
                    this.aeI.a(this.cMW);
                    String td = this.aeI.td();
                    if (td != null) {
                        forumSuggestModel = ForumSuggestModel.parserJson(td);
                        SquareSearchActivity.this.cMk = this.cMW.getValue();
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
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.cLM);
            if (forumSuggestModel == null) {
                SquareSearchActivity.this.aI(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.cO(t.j.text_no_search_record));
            } else {
                SquareSearchActivity.this.aJ(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.cMe = forumSuggestModel;
                SquareSearchActivity.this.refresh();
            }
            SquareSearchActivity.this.cMg = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aeI != null) {
                this.aeI.dl();
                this.aeI = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.cLM);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Object, Integer, com.baidu.tieba.postsearch.k> {
        private com.baidu.tbadk.core.util.ab aeI = null;
        private ArrayList<BasicNameValuePair> cMX;
        private String mUrl;

        public b(String str, ArrayList<BasicNameValuePair> arrayList) {
            this.mUrl = null;
            this.cMX = null;
            this.mUrl = str;
            this.cMX = arrayList;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (SquareSearchActivity.this.aoZ()) {
                return;
            }
            SquareSearchActivity.this.aJ(SquareSearchActivity.this.mNoDataView);
            SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.cLM, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(t.e.ds320));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public com.baidu.tieba.postsearch.k doInBackground(Object... objArr) {
            Exception exc;
            com.baidu.tieba.postsearch.k kVar;
            if (com.baidu.adp.lib.util.i.fq()) {
                try {
                    this.aeI = new com.baidu.tbadk.core.util.ab(this.mUrl);
                    Iterator<BasicNameValuePair> it = this.cMX.iterator();
                    while (it.hasNext()) {
                        this.aeI.a(it.next());
                    }
                    String td = this.aeI.td();
                    if (!this.aeI.tB().uw().tE() || td == null) {
                        kVar = null;
                    } else {
                        com.baidu.tieba.postsearch.k kVar2 = new com.baidu.tieba.postsearch.k();
                        try {
                            kVar2.parseJson(td);
                            if (td != null && this.aeI != null && this.aeI.tB().uw().nZ()) {
                                Iterator<BasicNameValuePair> it2 = this.cMX.iterator();
                                while (it2.hasNext()) {
                                    BasicNameValuePair next = it2.next();
                                    if ("word".equals(next.getName())) {
                                        SquareSearchActivity.this.cMl = next.getValue();
                                    }
                                    if ("pn".equals(next.getName())) {
                                        SquareSearchActivity.this.cMn = Integer.valueOf(next.getValue()).intValue();
                                    }
                                }
                            }
                            if (this.aeI.tB().uw().nZ()) {
                                com.baidu.tieba.tbadkCore.util.m.nY(SquareSearchActivity.this.cMj);
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
            SquareSearchActivity.this.cMs = false;
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.cLM);
            SquareSearchActivity.this.cMc.notifyDataSetChanged();
            if (kVar == null) {
                SquareSearchActivity.this.aI(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.cO(t.j.text_no_search_record));
            } else {
                SquareSearchActivity.this.aJ(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.cMf = kVar;
                SquareSearchActivity.this.refresh();
            }
            SquareSearchActivity.this.cMh = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            SquareSearchActivity.this.cMc.notifyDataSetChanged();
            if (this.aeI != null) {
                this.aeI.dl();
                this.aeI = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.cLM);
            SquareSearchActivity.this.cMh = null;
            super.onCancelled();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void jA() {
        if (!this.cMs && this.cMf != null && this.cMf.isHasMore()) {
            C(this.cMf.lk() + 1, this.cMj);
            aoY().vh();
        }
    }

    private void fv(boolean z) {
        if (TbadkCoreApplication.isLogin()) {
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(CmdConfigCustom.CMD_REQUEST_ENTER_FORUM_MESSAGE, true));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(CmdConfigCustom.CMD_REQUEST_ENTER_FORUM_MESSAGE, false));
        }
    }

    private void apa() {
        this.cMu = new SearchPageFocusBar(getPageContext().getPageActivity());
        this.cMu.setVisibility(8);
        this.cLU.addFooterView(this.cMu, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(View view) {
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(View view) {
        if (view != null) {
            view.setVisibility(8);
        }
    }
}
