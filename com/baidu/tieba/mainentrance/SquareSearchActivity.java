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
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.search.ResponseSearchFriendMessage;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.i;
import com.baidu.tieba.mainentrance.d;
import com.baidu.tieba.postsearch.j;
import com.baidu.tieba.tbadkCore.FRSPageRequestMessage;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class SquareSearchActivity extends BaseActivity<SquareSearchActivity> implements BdListView.e, d.a {
    private boolean avr;
    private EditText bUA;
    private TextView bUB;
    private TextView bUC;
    private ImageView bUD;
    private View bUE;
    private View bUF;
    private ListView bUG;
    private com.baidu.tieba.mainentrance.b bUH;
    private List<g> bUI;
    private m bUJ;
    private h bUK;
    private LinearLayout bUL;
    private PbListView bUM;
    private BdListView bUN;
    private com.baidu.tieba.mainentrance.a bUO;
    private com.baidu.tieba.postsearch.v bUP;
    private d bUQ;
    private ForumSuggestModel bUR;
    private com.baidu.tieba.postsearch.j bUS;
    private a bUT;
    private b bUU;
    private String bUV;
    private String bUW;
    private String bUX;
    private String bUY;
    private List<com.baidu.tieba.mainentrance.c> bUi;
    private FragmentTabWidget bUv;
    private FragmentTabIndicator bUw;
    private LinearLayoutDetectsSoftKeyboard bUx;
    private FrameLayout bUy;
    private FrameLayout bUz;
    private boolean bVb;
    private boolean bVd;
    private boolean bVf;
    private SearchPageFocusBar bVg;
    private ScrollView bVh;
    private SearchPageFocusBar bVi;
    private View bVj;
    private View bVk;
    private View bVl;
    private View bVn;
    private TextView bVo;
    private View bVp;
    private f mHotSearchInfo;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.m mNoDataView;
    private int mMode = 0;
    private int bUZ = 0;
    private int bVa = -1;
    private boolean arv = true;
    private boolean bVc = true;
    private boolean bVe = false;
    private List<View> bVm = new ArrayList();
    private Runnable bVq = new n(this);
    private final View.OnClickListener bVr = new y(this);
    private final com.baidu.adp.framework.listener.e bVs = new ak(this, 301001, true);
    private final HttpMessageListener bVt = new an(this, CmdConfigHttp.FRS_HTTP_CMD, true);
    private CustomMessageListener bVu = new ao(this, CmdConfigCustom.CMD_READ_SEARCHPERSON_HISTORY);
    private CustomMessageListener bVv = new ap(this, CmdConfigCustom.CMD_WRITE_SEARCHPERSON_HISTORY);
    private HttpMessageListener bVw = new aq(this, CmdConfigHttp.SEARCH_FRIEND_CMD);
    private final Runnable bVx = new ar(this);
    private CustomMessageListener bVy = new as(this, CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA);
    private CustomMessageListener bVz = new o(this, CmdConfigCustom.GET_ALL_SEARCH_POST_DATA);
    private View.OnClickListener bVA = new p(this);
    private CustomMessageListener bVB = new q(this, CmdConfigCustom.CMD_ENTER_FORUM_INFO);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponsedMessage<?> responsedMessage, boolean z) {
        int error = responsedMessage.getError();
        String string = StringUtils.isNull(responsedMessage.getErrorString()) ? getResources().getString(i.h.neterror) : responsedMessage.getErrorString();
        boolean z2 = error < -13 || error > -10;
        if (error == 0) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createFlagCfg(this.bUY, FrsActivityConfig.FRS_FROM_SEARCH, 1)));
        } else if (z2 && z && error == 3) {
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(i.h.login_to_use), true, 11013)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), this.bUY)));
            }
        } else {
            showToast(string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aba() {
        if (this.mMode == 0 && this.mHotSearchInfo != null) {
            if (this.mHotSearchInfo.getType() == 0) {
                iW(this.mHotSearchInfo.getName());
            } else if (this.mHotSearchInfo.getType() == 1) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "")));
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10355").ae("obj_name", this.mHotSearchInfo.getName()).r("obj_type", this.mHotSearchInfo.getType() == 0 ? 2 : 1));
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gh(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SEARCH_FRIEND_CMD);
        httpMessage.addParam("search_key", str);
        sendMessage(httpMessage);
    }

    private void Gu() {
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
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), this.bUY)));
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
        setContentView(i.g.home_dialog_search);
        init();
        getWindow().setSoftInputMode(1);
        Gu();
        registerListener(this.bVu);
        registerListener(this.bVv);
        registerListener(this.bVy);
        registerListener(this.bVz);
        registerListener(this.bVw);
        registerListener(this.bVs);
        registerListener(this.bVt);
        registerListener(this.bVB);
        this.bVf = com.baidu.tbadk.core.sharedPref.b.tr().getBoolean("search_post_show_dropmenu", true);
        if (SquareSearchActivityConfig.IS_SHOW_RECOMMEND_FORUM) {
            this.bUQ = new d(this, this);
            this.bUQ.aaZ();
            this.bUQ.aaY();
        }
        this.bVb = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.arv = true;
        if (this.bVc) {
            this.mHandler.post(this.bVq);
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
        hideLoadingView(this.bUy);
        this.mHandler.removeCallbacks(this.bVq);
        abb();
    }

    public void abb() {
        this.mHandler.removeCallbacks(this.bVx);
        if (this.bUT != null) {
            this.bUT.cancel();
            this.bUT = null;
        }
        if (this.bUU != null) {
            this.bUU.cancel();
            this.bUU = null;
        }
    }

    private void init() {
        this.bUx = (LinearLayoutDetectsSoftKeyboard) findViewById(i.f.parent);
        this.bUx.setOnSoftKeyBoardShownListener(new r(this));
        this.bUx.setOnTouchListener(new s(this));
        Oh();
        Og();
        this.bUy = (FrameLayout) findViewById(i.f.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(i.d.ds80)), null, null);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            this.bVh = (ScrollView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(i.g.home_searchbar_nodataview, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) this.bVh.findViewById(i.f.focusbar_nodata_root);
            this.bVi = (SearchPageFocusBar) linearLayout.findViewById(i.f.no_data_focusbar);
            linearLayout.addView(this.mNoDataView, 0);
            this.bVh.setOnTouchListener(new t(this));
            this.bUy.addView(this.bVh, this.bUy.getChildCount());
        } else {
            this.bUy.addView(this.mNoDataView, 0);
        }
        this.bUz = (FrameLayout) findViewById(i.f.home_search_list);
        abj();
        abc();
        abe();
        abd();
        abf();
        this.bUE = findViewById(i.f.empty_search_result);
        this.bVn = this.bUE.findViewById(i.f.empty_result_divider_1);
        this.bVo = (TextView) this.bUE.findViewById(i.f.create_bar_guide);
        this.bVp = this.bUE.findViewById(i.f.empty_result_divider_2);
        abg();
        this.bUA.setText("");
        this.bUA.requestFocus();
        ShowSoftKeyPadDelay(this.bUA, 200);
        if (TbadkSettings.getInst().loadBoolean("search_mode", true)) {
            ib(0);
            abi();
            return;
        }
        ib(1);
    }

    private void Og() {
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new u(this));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, i.g.square_search_navigation_view, (View.OnClickListener) null);
        this.bUD = (ImageView) addCustomView.findViewById(i.f.search_bar_icon);
        this.bUA = (EditText) addCustomView.findViewById(i.f.home_et_search);
        this.bUB = (TextView) addCustomView.findViewById(i.f.home_bt_search_del);
        this.bUC = (TextView) addCustomView.findViewById(i.f.home_bt_search_s);
        this.bUA.setOnFocusChangeListener(new v(this));
        this.bUC.setText(getPageContext().getString(i.h.forward));
        this.bUC.setOnClickListener(this.bVr);
        this.bUA.setOnEditorActionListener(new w(this));
        this.bUB.setOnClickListener(new x(this));
        this.bUA.addTextChangedListener(new z(this));
    }

    private void Oh() {
        this.bUv = (FragmentTabWidget) findViewById(i.f.square_search_tab_widget);
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(i.d.ds32));
        fragmentTabIndicator.setGravity(17);
        fragmentTabIndicator.auO = i.c.s_actionbar_text_color;
        fragmentTabIndicator.setText(getResources().getString(i.h.search_bar_text));
        this.bUw = new FragmentTabIndicator(getPageContext().getPageActivity());
        this.bUw.auO = i.c.s_actionbar_text_color;
        this.bUw.setTextSize(0, getResources().getDimension(i.d.ds32));
        this.bUw.setGravity(17);
        this.bUw.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_down);
        this.bUw.setCompoundDrawablePadding(getResources().getDimensionPixelSize(i.d.ds10));
        this.bUw.setText(getResources().getString(i.h.search_post_text));
        this.bUw.Cv();
        FragmentTabIndicator fragmentTabIndicator2 = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator2.auO = i.c.s_actionbar_text_color;
        fragmentTabIndicator2.setTextSize(0, getResources().getDimension(i.d.ds32));
        fragmentTabIndicator2.setGravity(17);
        fragmentTabIndicator2.setText(getResources().getString(i.h.search_person));
        this.bUv.addView(fragmentTabIndicator);
        this.bUv.addView(this.bUw);
        this.bUv.addView(fragmentTabIndicator2);
        this.bUv.d(0, true);
        this.bUv.setTabSelectionListener(new aa(this));
    }

    private void abc() {
        this.bUG = (ListView) findViewById(i.f.home_lv_search_history);
        if (this.bUL == null) {
            this.bUL = new LinearLayout(getPageContext().getPageActivity());
            this.bUL.setOrientation(1);
            this.bUL.setBackgroundColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_bg_line_d));
        }
        this.bUG.addFooterView(this.bUL);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            aby();
        }
        this.bUH = new com.baidu.tieba.mainentrance.b(this);
        this.bUG.setAdapter((ListAdapter) this.bUH);
        this.bUH.r(new ab(this));
    }

    private void abd() {
        if (this.bUK == null) {
            this.bUK = new h(getPageContext());
            this.bUG.addHeaderView(this.bUK.getView());
        }
    }

    private void abe() {
        if (this.bUJ == null) {
            this.bUJ = new m(getPageContext());
            this.bUG.addHeaderView(this.bUJ.no());
        }
    }

    private void abf() {
        this.bUN = (BdListView) findViewById(i.f.home_lv_search_suggest);
        this.bUO = new com.baidu.tieba.mainentrance.a(this, null);
        this.bUP = new com.baidu.tieba.postsearch.v(getPageContext());
        this.bUN.setOnItemClickListener(new ac(this));
        ad adVar = new ad(this);
        this.bUN.setOnScrollListener(adVar);
        this.bUG.setOnScrollListener(adVar);
        this.bUN.setOnSrollToBottomListener(this);
    }

    private void abg() {
        this.bUF = findViewById(i.f.search_dropmenu);
        TextView textView = (TextView) this.bUF.findViewById(i.f.dropmenu_all_text);
        textView.setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_link_tip_a));
        ImageView imageView = (ImageView) this.bUF.findViewById(i.f.dropmenu_all_icon);
        imageView.setImageDrawable(com.baidu.tbadk.core.util.an.getDrawable(i.e.chx_tips_list_ok));
        imageView.setVisibility(0);
        TextView textView2 = (TextView) this.bUF.findViewById(i.f.dropmenu_thread_text);
        textView2.setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_cont_c));
        ImageView imageView2 = (ImageView) this.bUF.findViewById(i.f.dropmenu_thread_icon);
        imageView2.setImageDrawable(com.baidu.tbadk.core.util.an.getDrawable(i.e.chx_tips_list_ok));
        imageView2.setVisibility(8);
        this.bUF.findViewById(i.f.dropmenu_all_layout).setOnClickListener(new ae(this, textView, imageView, textView2, imageView2));
        this.bUF.findViewById(i.f.dropmenu_thread_layout).setOnClickListener(new af(this, textView, imageView, textView2, imageView2));
        this.bUF.findViewById(i.f.dropmenu_lower_part).setOnClickListener(new ag(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abh() {
        if (this.bUz.getVisibility() == 8 && this.mNoDataView.getVisibility() == 8 && this.bUE.getVisibility() == 8) {
            R(this.bVh);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.text_no_search_record));
        }
    }

    public void ib(int i) {
        switch (i) {
            case 0:
                if (this.mMode != 0) {
                    this.mMode = 0;
                    this.bUC.setText(getPageContext().getString(i.h.forward));
                    abi();
                    abb();
                    abq();
                    if (this.bUV.trim().length() > 0) {
                        abp();
                        return;
                    } else {
                        abl();
                        return;
                    }
                }
                return;
            case 1:
                if (this.mMode != 1) {
                    this.mMode = 1;
                    this.bUC.setText(getPageContext().getString(i.h.search));
                    this.bUA.setHint(i.h.search_post_hint);
                    abb();
                    abq();
                    if (this.bUV.trim().length() > 0) {
                        this.bUN.setVisibility(8);
                        G(1, this.bUV);
                        return;
                    }
                    abm();
                    return;
                }
                return;
            case 2:
            default:
                return;
            case 3:
                if (this.mMode != 3) {
                    this.mMode = 3;
                    this.bUN.setVisibility(8);
                    this.bUE.setVisibility(8);
                    this.bUF.setVisibility(8);
                    this.bUC.setText(i.h.search);
                    this.bUA.setHint(i.h.search_friend_tip);
                    abq();
                    abb();
                    abn();
                    return;
                }
                return;
        }
    }

    private void abi() {
        if (this.mHotSearchInfo == null) {
            this.bUA.setHint(i.h.search_bar);
        } else {
            this.bUA.setHint(UtilHelper.getFixedText(this.mHotSearchInfo.HW(), 12));
        }
    }

    private void abj() {
        long j = com.baidu.tbadk.core.sharedPref.b.tr().getLong("hot_search_id", 0L);
        if (j != 0) {
            this.mHotSearchInfo = new f();
            this.mHotSearchInfo.setId(j);
            this.mHotSearchInfo.setName(com.baidu.tbadk.core.sharedPref.b.tr().getString("hot_search_name", ""));
            this.mHotSearchInfo.iV(com.baidu.tbadk.core.sharedPref.b.tr().getString("hot_search_title", ""));
            this.mHotSearchInfo.aN(com.baidu.tbadk.core.sharedPref.b.tr().getLong("hot_search_type", 0L));
        }
    }

    public void abk() {
        iW(this.bUA.getText().toString().trim());
    }

    private void iW(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (com.baidu.adp.lib.util.i.iM()) {
                this.bUY = str;
                this.arv = false;
                sendMessage(iX(str));
                return;
            }
            showToast(i.h.neterror);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abl() {
        this.bUN.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA));
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            dM(true);
            S(this.bVi);
            S(this.bVh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abm() {
        this.bUN.setVisibility(8);
        S(this.bVg);
        S(this.bVi);
        S(this.bVh);
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abn() {
        this.bUN.setVisibility(8);
        S(this.bVg);
        S(this.bVi);
        S(this.bVh);
        if (!this.avr) {
            sendMessage(new RequestSearchPersonHistoryReadMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ArrayList<String> arrayList) {
        boolean z = false;
        if (b(i, arrayList) || c(i, arrayList) || d(i, arrayList)) {
            abu();
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.text_no_search_record));
            return;
        }
        abt();
        List<com.baidu.tieba.mainentrance.c> arrayList2 = new ArrayList<>();
        if (i == 4) {
            arrayList2 = this.bUi;
        }
        a(i, arrayList, (this.bUi == null ? 0 : arrayList2.size()) >= 2);
        boolean z2 = i == 4;
        if (arrayList == null || arrayList.size() == 0) {
            z = true;
        }
        i(z2, z);
        if (i == 4) {
            abi();
        }
        if (i == 4 && this.bUi.size() >= 2) {
            this.bUK.show();
        } else {
            this.bUK.hide();
        }
        this.bUH.aS(arrayList2);
        this.bUH.notifyDataSetChanged();
    }

    private void a(int i, ArrayList<String> arrayList, boolean z) {
        if (this.bUL != null) {
            this.bUL.removeAllViews();
            if (arrayList != null && !arrayList.isEmpty() && getActivity() != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                if (z) {
                    this.bVj = new View(pageActivity);
                    this.bVj.setBackgroundColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_bg_line_b));
                    layoutParams.height = com.baidu.adp.lib.util.k.d(pageActivity, i.d.ds12);
                    layoutParams.topMargin = com.baidu.adp.lib.util.k.d(pageActivity, i.d.ds14);
                    this.bUL.addView(this.bVj, layoutParams);
                }
                this.bVk = LayoutInflater.from(pageActivity).inflate(i.g.square_search_recommand_fourm_header, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                getLayoutMode().k(this.bVk);
                this.bUL.addView(this.bVk, layoutParams2);
                int size = arrayList.size();
                this.bVm.clear();
                for (int i2 = 0; i2 < size; i2++) {
                    String str = arrayList.get(i2);
                    if (!TextUtils.isEmpty(str)) {
                        View inflate = LayoutInflater.from(pageActivity).inflate(i.g.home_dialog_search_item, (ViewGroup) null);
                        ((TextView) inflate.findViewById(i.f.home_lv_search_forum)).setText(str);
                        com.baidu.tbadk.core.util.an.b((TextView) inflate.findViewById(i.f.home_lv_search_forum), i.c.cp_cont_b, 1);
                        inflate.findViewById(i.f.home_dialog_lv_search_forum_divider).setVisibility(8);
                        com.baidu.tbadk.core.util.an.i(inflate, i.e.square_search_item_bg);
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                        inflate.setOnClickListener(new c(str));
                        this.bVm.add(inflate);
                        this.bUL.addView(inflate, layoutParams3);
                    }
                }
                this.bVl = LayoutInflater.from(pageActivity).inflate(i.g.home_dialog_search_footer, (ViewGroup) null);
                ((TextView) this.bVl.findViewById(i.f.home_bt_search_footer)).setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.s_actionbar_text_line_color_s));
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                this.bVl.setOnClickListener(new ah(this));
                this.bUL.addView(this.bVl, layoutParams4);
            }
        }
    }

    private void i(boolean z, boolean z2) {
        int size;
        if (this.bUJ != null) {
            this.bUJ.clear();
            if (this.bUI != null && !this.bUI.isEmpty() && z && (size = this.bUI.size()) >= 2) {
                int i = size <= 4 ? size : 4;
                int i2 = i % 2 != 0 ? i - 1 : i;
                for (int i3 = 0; i3 < i2; i3++) {
                    g gVar = (g) com.baidu.tbadk.core.util.u.b(this.bUI, i3);
                    if (gVar != null) {
                        this.bUJ.a(gVar, i3).setOnClickListener(this.bVA);
                    }
                }
                this.bUJ.dK(((this.bUi == null || this.bUi.size() == 0) && z2) ? false : true);
                this.bUJ.show();
            }
        }
    }

    private boolean b(int i, ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && (this.bUi == null || this.bUi.size() <= 2) && 4 == i && this.mMode == 0 && (this.bUI == null || this.bUI.size() <= 2);
    }

    private boolean c(int i, ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && i == 5 && this.mMode != 5;
    }

    private boolean d(int i, ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && i == 6 && this.mMode != 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abo() {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).cu(getPageContext().getString(i.h.alert_clean_history)).a(getPageContext().getString(i.h.clear_all_text), new ai(this)).b(getPageContext().getString(i.h.alert_no_button), new al(this)).b(getPageContext()).sO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abp() {
        this.bUz.setVisibility(8);
        if (this.bUV != null) {
            if (this.bUV.equals(this.bUW)) {
                refresh();
                return;
            }
            S(this.bVg);
            S(this.bVi);
            S(this.bVh);
            this.mHandler.removeCallbacks(this.bVx);
            this.mHandler.postDelayed(this.bVx, 500L);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v5 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void G(int i, String str) {
        this.bUG.setVisibility(8);
        if (str != null && str.trim().length() > 0) {
            int i2 = this.bVd ? 1 : 0;
            if (str.equals(this.bUX) && i == this.bUZ && this.bVa == i2) {
                refresh();
                return;
            }
            this.bVa = i2;
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append(TbConfig.SERVER_ADDRESS);
            stringBuffer.append(TbConfig.POST_SEARCH_URL);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("word", str));
            arrayList.add(new BasicNameValuePair("pn", String.valueOf(i)));
            arrayList.add(new BasicNameValuePair("rn", String.valueOf(50)));
            arrayList.add(new BasicNameValuePair("only_thread", new StringBuilder().append(i2).toString()));
            arrayList.add(new BasicNameValuePair("st_type", "search_post"));
            abb();
            this.bUU = new b(stringBuffer.toString(), arrayList);
            this.bUU.setPriority(3);
            this.bUU.execute(new Object[0]);
            this.bVe = true;
        }
    }

    private FRSPageRequestMessage iX(String str) {
        FRSPageRequestMessage fRSPageRequestMessage = new FRSPageRequestMessage();
        fRSPageRequestMessage.setKw(str);
        fRSPageRequestMessage.setPn(1);
        if (com.baidu.tbadk.core.m.qU().qY()) {
            fRSPageRequestMessage.setRn(35);
        } else {
            fRSPageRequestMessage.setRn(50);
        }
        fRSPageRequestMessage.setWithGroup(1);
        int K = com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity());
        int L = com.baidu.adp.lib.util.k.L(getPageContext().getPageActivity());
        float f = K / 320.0f;
        int i = com.baidu.tbadk.core.util.at.uG().uI() ? 2 : 1;
        fRSPageRequestMessage.setScrW(K);
        fRSPageRequestMessage.setScrH(L);
        fRSPageRequestMessage.setScrDip(f);
        fRSPageRequestMessage.setqType(i);
        return fRSPageRequestMessage;
    }

    private void abq() {
        if (this.bUN != null) {
            this.bUN.setNextPage(null);
        }
        if (this.bUP != null) {
            this.bUP.clear();
            this.bUP.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        int i;
        int i2 = 0;
        try {
            if (this.mMode == 0) {
                if (this.bUR != null) {
                    if (this.bUR.forum_list != null && this.bUR.forum_list.size() > 0) {
                        abs();
                        this.bUN.setAdapter((ListAdapter) this.bUO);
                        this.bUO.iT(this.bUV);
                        this.bUO.I(this.bUR.forum_list);
                        this.bUO.notifyDataSetInvalidated();
                        return;
                    }
                    S(this.bVh);
                    abw();
                    abr();
                }
            } else if (this.bUS != null) {
                List<j.a> list = this.bUS.ctN;
                if (list != null && list.size() > 0) {
                    abs();
                    if (this.bUS.getCurrentPage() == 1) {
                        this.bUN.setVisibility(0);
                        this.bUP.clear();
                        this.bUN.setAdapter((ListAdapter) this.bUP);
                        this.bUN.setNextPage(abx());
                    }
                    if (!this.bUS.isHasMore()) {
                        abx().setText(getResources().getString(i.h.list_no_more));
                        abx().vv();
                    }
                    int bj = this.bUP.bj(list);
                    if (bj > 0) {
                        i = this.bUN.getFirstVisiblePosition() - bj;
                        View childAt = this.bUN.getChildAt(0);
                        if (childAt != null) {
                            i2 = childAt.getTop();
                        }
                    } else {
                        i = 0;
                    }
                    this.bUP.notifyDataSetChanged();
                    if (bj > 0) {
                        this.bUN.setSelectionFromTop(i, i2);
                    }
                    if (this.bVf) {
                        this.bUF.setVisibility(0);
                        this.bVf = false;
                        com.baidu.tbadk.core.sharedPref.b.tr().putBoolean("search_post_show_dropmenu", false);
                    }
                } else if (this.mNoDataView.getVisibility() != 0) {
                    abu();
                    S(this.bVi);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.text_no_suggest));
                }
            } else if (this.mNoDataView.getVisibility() != 0) {
                abu();
                S(this.bVi);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.text_no_suggest));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void abr() {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.baidu.tbadk.core.util.an.getColor(i.c.cp_cont_h));
        TextView textView = (TextView) this.bUE.findViewById(i.f.no_bar_found);
        textView.setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_cont_c));
        TextView textView2 = (TextView) this.bUE.findViewById(i.f.create_bar_guide);
        textView2.setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_cont_b));
        String str = "";
        if (this.bUV != null) {
            str = this.bUV.length() > 6 ? String.valueOf(this.bUV.substring(0, 6)) + "..." : this.bUV;
        }
        String format = String.format(getPageContext().getString(i.h.empty_search_result_format), str);
        String format2 = String.format(getPageContext().getString(i.h.create_bar_guide_format), str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
        spannableStringBuilder.setSpan(foregroundColorSpan, 4, format.length() - 2, 33);
        textView.setText(spannableStringBuilder);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(format2);
        spannableStringBuilder2.setSpan(foregroundColorSpan, 5, format2.length() - 5, 33);
        textView2.setText(spannableStringBuilder2);
        Drawable drawable = com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_search_list_add);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        textView2.setCompoundDrawablePadding(com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), i.d.ds10));
        textView2.setCompoundDrawables(drawable, null, null, null);
        textView2.setOnClickListener(new am(this));
    }

    private void abs() {
        this.bUz.setVisibility(0);
        this.bUN.setVisibility(0);
        this.bUG.setVisibility(8);
        S(this.bVh);
        this.mNoDataView.setVisibility(8);
        this.bUF.setVisibility(8);
        this.bUE.setVisibility(8);
    }

    private void abt() {
        this.bUz.setVisibility(0);
        this.bUG.setVisibility(0);
        if (this.mMode == 0) {
            R(this.bVg);
        } else {
            S(this.bVg);
        }
        this.bUN.setVisibility(8);
        S(this.bVh);
        this.mNoDataView.setVisibility(8);
        this.bUF.setVisibility(8);
        this.bUE.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abu() {
        this.bUz.setVisibility(8);
        this.bUN.setVisibility(8);
        this.bUG.setVisibility(8);
        R(this.bVh);
        this.mNoDataView.setVisibility(0);
        if (this.mMode == 0) {
            R(this.bVi);
        }
        this.bUF.setVisibility(8);
        this.bUE.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abv() {
        S(this.bVh);
        this.bUF.setVisibility(0);
    }

    private void abw() {
        this.bUz.setVisibility(8);
        this.bUN.setVisibility(8);
        this.bUG.setVisibility(8);
        S(this.bVh);
        this.mNoDataView.setVisibility(8);
        this.bUF.setVisibility(8);
        this.bUE.setVisibility(0);
        if (CreateBarActivityConfig.IS_SUPPORT_CREATE_BAR && this.bUV != null && this.bUV.length() <= 30) {
            dL(true);
        } else {
            dL(false);
        }
    }

    private void dL(boolean z) {
        if (!z) {
            this.bVn.setVisibility(8);
            this.bVo.setVisibility(8);
            this.bVp.setVisibility(8);
            return;
        }
        this.bVn.setVisibility(0);
        this.bVo.setVisibility(0);
        this.bVp.setVisibility(0);
    }

    private PbListView abx() {
        if (this.bUM == null) {
            this.bUM = new PbListView(getPageContext().getPageActivity());
            this.bUM.no();
        }
        return this.bUM;
    }

    @Override // com.baidu.tieba.mainentrance.d.a
    public void iU(String str) {
        this.bVb = true;
        this.bUi = new ArrayList();
        abl();
    }

    @Override // com.baidu.tieba.mainentrance.d.a
    public void a(List<com.baidu.tieba.mainentrance.c> list, List<g> list2, f fVar) {
        this.bVb = true;
        hideLoadingView(this.bUy);
        if (list == null || list.isEmpty()) {
            this.bUi = new ArrayList();
        } else {
            this.bUi = list;
        }
        if (list2 == null) {
            this.bUI = new ArrayList();
        } else {
            this.bUI = list2;
        }
        a(fVar);
        this.mHotSearchInfo = fVar;
        abl();
    }

    private void a(f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.sharedPref.b.tr().putLong("hot_search_id", fVar.getId());
            com.baidu.tbadk.core.sharedPref.b.tr().putString("hot_search_name", fVar.getName());
            com.baidu.tbadk.core.sharedPref.b.tr().putString("hot_search_title", fVar.HW());
            com.baidu.tbadk.core.sharedPref.b.tr().putLong("hot_search_type", fVar.getType());
            return;
        }
        com.baidu.tbadk.core.sharedPref.b.tr().putLong("hot_search_id", 0L);
        com.baidu.tbadk.core.sharedPref.b.tr().putString("hot_search_name", "");
        com.baidu.tbadk.core.sharedPref.b.tr().putString("hot_search_title", "");
        com.baidu.tbadk.core.sharedPref.b.tr().putLong("hot_search_type", 0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bUv.onChangeSkinType(i);
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.bUx);
        getLayoutMode().k(this.bUE);
        com.baidu.tbadk.core.util.an.e(this.bUx, i);
        if (this.bUO != null) {
            this.bUO.notifyDataSetChanged();
        }
        if (this.bUP != null) {
            this.bUP.notifyDataSetChanged();
        }
        if (this.bUH != null) {
            this.bUH.notifyDataSetChanged();
        }
        com.baidu.tbadk.core.util.an.i(this.bUy, i.c.cp_bg_line_d);
        com.baidu.tbadk.core.util.an.c(this.bUD, i.e.icon_search_ba);
        com.baidu.tbadk.core.util.an.b(this.bUC, i.c.cp_cont_i, 1);
        if (this.bUK != null) {
            getLayoutMode().k(this.bUK.getView());
        }
        if (this.bUJ != null) {
            this.bUJ.onChangeSkinType(i);
        }
        ic(i);
    }

    private void ic(int i) {
        if (this.bUL != null) {
            this.bUL.setBackgroundColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_bg_line_d));
        }
        if (this.bVj != null) {
            this.bVj.setBackgroundColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_bg_line_b));
        }
        if (this.bVk != null) {
            getLayoutMode().k(this.bVk);
        }
        if (this.bVl != null) {
            ((TextView) this.bVl.findViewById(i.f.home_bt_search_footer)).setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.s_actionbar_text_line_color_s));
        }
        if (this.bVm != null) {
            for (View view : this.bVm) {
                com.baidu.tbadk.core.util.an.b((TextView) view.findViewById(i.f.home_lv_search_forum), i.c.cp_cont_b, 1);
                view.findViewById(i.f.home_dialog_lv_search_forum_divider).setBackgroundColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_bg_line_b));
                com.baidu.tbadk.core.util.an.i(view, i.e.addresslist_item_bg);
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
                        SquareSearchActivity.this.gh(this.mName);
                        return;
                    }
                    SquareSearchActivity.this.G(1, this.mName);
                    SquareSearchActivity.this.bUA.setText(this.mName);
                    SquareSearchActivity.this.bUA.requestFocus();
                    Selection.setSelection(SquareSearchActivity.this.bUA.getText(), this.mName.length());
                    return;
                }
                com.baidu.tieba.tbadkCore.util.m.lG(this.mName);
                SquareSearchActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(SquareSearchActivity.this.getActivity()).createNormalCfg(this.mName, FrsActivityConfig.FRS_FROM_SEARCH)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
        private com.baidu.tbadk.core.util.w afh = null;
        private BasicNameValuePair bVI;
        private String mUrl;

        public a(String str, BasicNameValuePair basicNameValuePair, boolean z) {
            this.mUrl = null;
            this.bVI = null;
            this.mUrl = str;
            this.bVI = basicNameValuePair;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.bUy, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(i.d.ds320));
            SquareSearchActivity.this.bUz.setVisibility(8);
            SquareSearchActivity.this.mNoDataView.setVisibility(8);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public ForumSuggestModel doInBackground(Object... objArr) {
            ForumSuggestModel forumSuggestModel = null;
            try {
                this.afh = new com.baidu.tbadk.core.util.w(this.mUrl);
                this.afh.a(this.bVI);
                String tD = this.afh.tD();
                if (tD == null) {
                    return null;
                }
                forumSuggestModel = ForumSuggestModel.parserJson(tD);
                SquareSearchActivity.this.bUW = this.bVI.getValue();
                return forumSuggestModel;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return forumSuggestModel;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ForumSuggestModel forumSuggestModel) {
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.bUy);
            if (forumSuggestModel != null) {
                SquareSearchActivity.this.bUR = forumSuggestModel;
                SquareSearchActivity.this.refresh();
            }
            SquareSearchActivity.this.bUT = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afh != null) {
                this.afh.gJ();
                this.afh = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.bUy);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Object, Integer, com.baidu.tieba.postsearch.j> {
        private com.baidu.tbadk.core.util.w afh = null;
        private ArrayList<BasicNameValuePair> bVJ;
        private String mUrl;

        public b(String str, ArrayList<BasicNameValuePair> arrayList) {
            this.mUrl = null;
            this.bVJ = null;
            this.mUrl = str;
            this.bVJ = arrayList;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.bUy, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(i.d.ds320));
            SquareSearchActivity.this.mNoDataView.setVisibility(8);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: z */
        public com.baidu.tieba.postsearch.j doInBackground(Object... objArr) {
            Exception exc;
            com.baidu.tieba.postsearch.j jVar;
            try {
                this.afh = new com.baidu.tbadk.core.util.w(this.mUrl);
                Iterator<BasicNameValuePair> it = this.bVJ.iterator();
                while (it.hasNext()) {
                    this.afh.a(it.next());
                }
                String tD = this.afh.tD();
                if (!this.afh.ue().uW().uh() || tD == null) {
                    return null;
                }
                com.baidu.tieba.postsearch.j jVar2 = new com.baidu.tieba.postsearch.j();
                try {
                    jVar2.parseJson(tD);
                    if (tD != null && this.afh != null && this.afh.ue().uW().qS()) {
                        Iterator<BasicNameValuePair> it2 = this.bVJ.iterator();
                        while (it2.hasNext()) {
                            BasicNameValuePair next = it2.next();
                            if ("word".equals(next.getName())) {
                                SquareSearchActivity.this.bUX = next.getValue();
                            }
                            if ("pn".equals(next.getName())) {
                                SquareSearchActivity.this.bUZ = Integer.valueOf(next.getValue()).intValue();
                            }
                        }
                    }
                    if (this.afh.ue().uW().qS()) {
                        com.baidu.tieba.tbadkCore.util.m.lH(SquareSearchActivity.this.bUV);
                        return jVar2;
                    }
                    return jVar2;
                } catch (Exception e) {
                    jVar = jVar2;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    return jVar;
                }
            } catch (Exception e2) {
                exc = e2;
                jVar = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.postsearch.j jVar) {
            SquareSearchActivity.this.bVe = false;
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.bUy);
            SquareSearchActivity.this.bUP.notifyDataSetChanged();
            if (jVar == null || this.afh == null || !this.afh.ue().uW().uh()) {
                SquareSearchActivity.this.showToast(SquareSearchActivity.this.getPageContext().getString(i.h.neterror));
            } else if (this.afh.ue().uW().qS()) {
                SquareSearchActivity.this.bUS = jVar;
                SquareSearchActivity.this.refresh();
            } else {
                SquareSearchActivity.this.refresh();
            }
            SquareSearchActivity.this.bUU = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            SquareSearchActivity.this.bUP.notifyDataSetChanged();
            if (this.afh != null) {
                this.afh.gJ();
                this.afh = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.bUy);
            SquareSearchActivity.this.bUU = null;
            super.onCancelled();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!this.bVe && this.bUS != null && this.bUS.isHasMore()) {
            G(this.bUS.getCurrentPage() + 1, this.bUV);
            abx().startLoadData();
        }
    }

    private void dM(boolean z) {
        if (TbadkCoreApplication.isLogin()) {
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(CmdConfigCustom.CMD_REQUEST_ENTER_FORUM_MESSAGE, true));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(CmdConfigCustom.CMD_REQUEST_ENTER_FORUM_MESSAGE, false));
        }
    }

    private void aby() {
        this.bVg = new SearchPageFocusBar(getPageContext().getPageActivity());
        this.bVg.setVisibility(8);
        this.bUG.addFooterView(this.bVg, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(View view) {
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private void S(View view) {
        if (view != null) {
            view.setVisibility(8);
        }
    }
}
