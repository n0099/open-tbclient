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
    private boolean auf;
    private List<com.baidu.tieba.mainentrance.c> bUJ;
    private FragmentTabWidget bUW;
    private FragmentTabIndicator bUX;
    private LinearLayoutDetectsSoftKeyboard bUY;
    private FrameLayout bUZ;
    private boolean bVC;
    private boolean bVE;
    private boolean bVG;
    private SearchPageFocusBar bVH;
    private ScrollView bVI;
    private SearchPageFocusBar bVJ;
    private View bVK;
    private View bVL;
    private View bVM;
    private View bVO;
    private TextView bVP;
    private View bVQ;
    private FrameLayout bVa;
    private EditText bVb;
    private TextView bVc;
    private TextView bVd;
    private ImageView bVe;
    private View bVf;
    private View bVg;
    private ListView bVh;
    private com.baidu.tieba.mainentrance.b bVi;
    private List<g> bVj;
    private m bVk;
    private h bVl;
    private LinearLayout bVm;
    private PbListView bVn;
    private BdListView bVo;
    private com.baidu.tieba.mainentrance.a bVp;
    private com.baidu.tieba.postsearch.v bVq;
    private d bVr;
    private ForumSuggestModel bVs;
    private com.baidu.tieba.postsearch.j bVt;
    private a bVu;
    private b bVv;
    private String bVw;
    private String bVx;
    private String bVy;
    private String bVz;
    private f mHotSearchInfo;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.m mNoDataView;
    private int mMode = 0;
    private int bVA = 0;
    private int bVB = -1;
    private boolean aqa = true;
    private boolean bVD = true;
    private boolean bVF = false;
    private List<View> bVN = new ArrayList();
    private Runnable bVR = new n(this);
    private final View.OnClickListener bVS = new y(this);
    private final com.baidu.adp.framework.listener.e bVT = new ak(this, 301001, true);
    private final HttpMessageListener bVU = new an(this, CmdConfigHttp.FRS_HTTP_CMD, true);
    private CustomMessageListener bVV = new ao(this, CmdConfigCustom.CMD_READ_SEARCHPERSON_HISTORY);
    private CustomMessageListener bVW = new ap(this, CmdConfigCustom.CMD_WRITE_SEARCHPERSON_HISTORY);
    private HttpMessageListener bVX = new aq(this, CmdConfigHttp.SEARCH_FRIEND_CMD);
    private final Runnable bVY = new ar(this);
    private CustomMessageListener bVZ = new as(this, CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA);
    private CustomMessageListener bWa = new o(this, CmdConfigCustom.GET_ALL_SEARCH_POST_DATA);
    private View.OnClickListener bWb = new p(this);
    private CustomMessageListener bWc = new q(this, CmdConfigCustom.CMD_ENTER_FORUM_INFO);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponsedMessage<?> responsedMessage, boolean z) {
        int error = responsedMessage.getError();
        String string = StringUtils.isNull(responsedMessage.getErrorString()) ? getResources().getString(i.h.neterror) : responsedMessage.getErrorString();
        boolean z2 = error < -13 || error > -10;
        if (error == 0) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createFlagCfg(this.bVz, FrsActivityConfig.FRS_FROM_SEARCH, 1)));
        } else if (z2 && z && error == 3) {
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(i.h.login_to_use), true, 11013)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), this.bVz)));
            }
        } else {
            showToast(string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean abv() {
        if (this.mMode == 0 && this.mHotSearchInfo != null) {
            if (this.mHotSearchInfo.getType() == 0) {
                iY(this.mHotSearchInfo.getName());
            } else if (this.mHotSearchInfo.getType() == 1) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "")));
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10355").ae("obj_name", this.mHotSearchInfo.getName()).r("obj_type", this.mHotSearchInfo.getType() == 0 ? 2 : 1));
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gj(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SEARCH_FRIEND_CMD);
        httpMessage.addParam("search_key", str);
        sendMessage(httpMessage);
    }

    private void Gr() {
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
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), this.bVz)));
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
        Gr();
        registerListener(this.bVV);
        registerListener(this.bVW);
        registerListener(this.bVZ);
        registerListener(this.bWa);
        registerListener(this.bVX);
        registerListener(this.bVT);
        registerListener(this.bVU);
        registerListener(this.bWc);
        this.bVG = com.baidu.tbadk.core.sharedPref.b.tu().getBoolean("search_post_show_dropmenu", true);
        if (SquareSearchActivityConfig.IS_SHOW_RECOMMEND_FORUM) {
            this.bVr = new d(this, this);
            this.bVr.abu();
            this.bVr.abt();
        }
        this.bVC = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aqa = true;
        if (this.bVD) {
            this.mHandler.post(this.bVR);
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
        hideLoadingView(this.bUZ);
        this.mHandler.removeCallbacks(this.bVR);
        abw();
    }

    public void abw() {
        this.mHandler.removeCallbacks(this.bVY);
        if (this.bVu != null) {
            this.bVu.cancel();
            this.bVu = null;
        }
        if (this.bVv != null) {
            this.bVv.cancel();
            this.bVv = null;
        }
    }

    private void init() {
        this.bUY = (LinearLayoutDetectsSoftKeyboard) findViewById(i.f.parent);
        this.bUY.setOnSoftKeyBoardShownListener(new r(this));
        this.bUY.setOnTouchListener(new s(this));
        OD();
        OC();
        this.bUZ = (FrameLayout) findViewById(i.f.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(i.d.ds80)), null, null);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            this.bVI = (ScrollView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(i.g.home_searchbar_nodataview, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) this.bVI.findViewById(i.f.focusbar_nodata_root);
            this.bVJ = (SearchPageFocusBar) linearLayout.findViewById(i.f.no_data_focusbar);
            linearLayout.addView(this.mNoDataView, 0);
            this.bVI.setOnTouchListener(new t(this));
            this.bUZ.addView(this.bVI, this.bUZ.getChildCount());
        } else {
            this.bUZ.addView(this.mNoDataView, 0);
        }
        this.bVa = (FrameLayout) findViewById(i.f.home_search_list);
        abE();
        abx();
        abz();
        aby();
        abA();
        this.bVf = findViewById(i.f.empty_search_result);
        this.bVO = this.bVf.findViewById(i.f.empty_result_divider_1);
        this.bVP = (TextView) this.bVf.findViewById(i.f.create_bar_guide);
        this.bVQ = this.bVf.findViewById(i.f.empty_result_divider_2);
        abB();
        this.bVb.setText("");
        this.bVb.requestFocus();
        ShowSoftKeyPadDelay(this.bVb, 200);
        if (TbadkSettings.getInst().loadBoolean("search_mode", true)) {
            ip(0);
            abD();
            return;
        }
        ip(1);
    }

    private void OC() {
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new u(this));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, i.g.square_search_navigation_view, (View.OnClickListener) null);
        this.bVe = (ImageView) addCustomView.findViewById(i.f.search_bar_icon);
        this.bVb = (EditText) addCustomView.findViewById(i.f.home_et_search);
        this.bVc = (TextView) addCustomView.findViewById(i.f.home_bt_search_del);
        this.bVd = (TextView) addCustomView.findViewById(i.f.home_bt_search_s);
        this.bVb.setOnFocusChangeListener(new v(this));
        this.bVd.setText(getPageContext().getString(i.h.forward));
        this.bVd.setOnClickListener(this.bVS);
        this.bVb.setOnEditorActionListener(new w(this));
        this.bVc.setOnClickListener(new x(this));
        this.bVb.addTextChangedListener(new z(this));
    }

    private void OD() {
        this.bUW = (FragmentTabWidget) findViewById(i.f.square_search_tab_widget);
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(i.d.ds32));
        fragmentTabIndicator.setGravity(17);
        fragmentTabIndicator.atC = i.c.s_actionbar_text_color;
        fragmentTabIndicator.setText(getResources().getString(i.h.search_bar_text));
        this.bUX = new FragmentTabIndicator(getPageContext().getPageActivity());
        this.bUX.atC = i.c.s_actionbar_text_color;
        this.bUX.setTextSize(0, getResources().getDimension(i.d.ds32));
        this.bUX.setGravity(17);
        this.bUX.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_down);
        this.bUX.setCompoundDrawablePadding(getResources().getDimensionPixelSize(i.d.ds10));
        this.bUX.setText(getResources().getString(i.h.search_post_text));
        this.bUX.Co();
        FragmentTabIndicator fragmentTabIndicator2 = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator2.atC = i.c.s_actionbar_text_color;
        fragmentTabIndicator2.setTextSize(0, getResources().getDimension(i.d.ds32));
        fragmentTabIndicator2.setGravity(17);
        fragmentTabIndicator2.setText(getResources().getString(i.h.search_person));
        this.bUW.addView(fragmentTabIndicator);
        this.bUW.addView(this.bUX);
        this.bUW.addView(fragmentTabIndicator2);
        this.bUW.d(0, true);
        this.bUW.setTabSelectionListener(new aa(this));
    }

    private void abx() {
        this.bVh = (ListView) findViewById(i.f.home_lv_search_history);
        if (this.bVm == null) {
            this.bVm = new LinearLayout(getPageContext().getPageActivity());
            this.bVm.setOrientation(1);
            this.bVm.setBackgroundColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_bg_line_d));
        }
        this.bVh.addFooterView(this.bVm);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            abT();
        }
        this.bVi = new com.baidu.tieba.mainentrance.b(this);
        this.bVh.setAdapter((ListAdapter) this.bVi);
        this.bVi.r(new ab(this));
    }

    private void aby() {
        if (this.bVl == null) {
            this.bVl = new h(getPageContext());
            this.bVh.addHeaderView(this.bVl.getView());
        }
    }

    private void abz() {
        if (this.bVk == null) {
            this.bVk = new m(getPageContext());
            this.bVh.addHeaderView(this.bVk.np());
        }
    }

    private void abA() {
        this.bVo = (BdListView) findViewById(i.f.home_lv_search_suggest);
        this.bVp = new com.baidu.tieba.mainentrance.a(this, null);
        this.bVq = new com.baidu.tieba.postsearch.v(getPageContext());
        this.bVo.setOnItemClickListener(new ac(this));
        ad adVar = new ad(this);
        this.bVo.setOnScrollListener(adVar);
        this.bVh.setOnScrollListener(adVar);
        this.bVo.setOnSrollToBottomListener(this);
    }

    private void abB() {
        this.bVg = findViewById(i.f.search_dropmenu);
        TextView textView = (TextView) this.bVg.findViewById(i.f.dropmenu_all_text);
        textView.setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_link_tip_a));
        ImageView imageView = (ImageView) this.bVg.findViewById(i.f.dropmenu_all_icon);
        imageView.setImageDrawable(com.baidu.tbadk.core.util.an.getDrawable(i.e.chx_tips_list_ok));
        imageView.setVisibility(0);
        TextView textView2 = (TextView) this.bVg.findViewById(i.f.dropmenu_thread_text);
        textView2.setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_cont_c));
        ImageView imageView2 = (ImageView) this.bVg.findViewById(i.f.dropmenu_thread_icon);
        imageView2.setImageDrawable(com.baidu.tbadk.core.util.an.getDrawable(i.e.chx_tips_list_ok));
        imageView2.setVisibility(8);
        this.bVg.findViewById(i.f.dropmenu_all_layout).setOnClickListener(new ae(this, textView, imageView, textView2, imageView2));
        this.bVg.findViewById(i.f.dropmenu_thread_layout).setOnClickListener(new af(this, textView, imageView, textView2, imageView2));
        this.bVg.findViewById(i.f.dropmenu_lower_part).setOnClickListener(new ag(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abC() {
        if (this.bVa.getVisibility() == 8 && this.mNoDataView.getVisibility() == 8 && this.bVf.getVisibility() == 8) {
            Q(this.bVI);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.text_no_search_record));
        }
    }

    public void ip(int i) {
        switch (i) {
            case 0:
                if (this.mMode != 0) {
                    this.mMode = 0;
                    this.bVd.setText(getPageContext().getString(i.h.forward));
                    abD();
                    abw();
                    abL();
                    if (this.bVw.trim().length() > 0) {
                        abK();
                        return;
                    } else {
                        abG();
                        return;
                    }
                }
                return;
            case 1:
                if (this.mMode != 1) {
                    this.mMode = 1;
                    this.bVd.setText(getPageContext().getString(i.h.search));
                    this.bVb.setHint(i.h.search_post_hint);
                    abw();
                    abL();
                    if (this.bVw.trim().length() > 0) {
                        this.bVo.setVisibility(8);
                        H(1, this.bVw);
                        return;
                    }
                    abH();
                    return;
                }
                return;
            case 2:
            default:
                return;
            case 3:
                if (this.mMode != 3) {
                    this.mMode = 3;
                    this.bVo.setVisibility(8);
                    this.bVf.setVisibility(8);
                    this.bVg.setVisibility(8);
                    this.bVd.setText(i.h.search);
                    this.bVb.setHint(i.h.search_friend_tip);
                    abL();
                    abw();
                    abI();
                    return;
                }
                return;
        }
    }

    private void abD() {
        if (this.mHotSearchInfo == null) {
            this.bVb.setHint(i.h.search_bar);
        } else {
            this.bVb.setHint(UtilHelper.getFixedText(this.mHotSearchInfo.Im(), 12));
        }
    }

    private void abE() {
        long j = com.baidu.tbadk.core.sharedPref.b.tu().getLong("hot_search_id", 0L);
        if (j != 0) {
            this.mHotSearchInfo = new f();
            this.mHotSearchInfo.setId(j);
            this.mHotSearchInfo.setName(com.baidu.tbadk.core.sharedPref.b.tu().getString("hot_search_name", ""));
            this.mHotSearchInfo.iX(com.baidu.tbadk.core.sharedPref.b.tu().getString("hot_search_title", ""));
            this.mHotSearchInfo.aN(com.baidu.tbadk.core.sharedPref.b.tu().getLong("hot_search_type", 0L));
        }
    }

    public void abF() {
        iY(this.bVb.getText().toString().trim());
    }

    private void iY(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (com.baidu.adp.lib.util.i.iN()) {
                this.bVz = str;
                this.aqa = false;
                sendMessage(iZ(str));
                return;
            }
            showToast(i.h.neterror);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abG() {
        this.bVo.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA));
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            dO(true);
            R(this.bVJ);
            R(this.bVI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abH() {
        this.bVo.setVisibility(8);
        R(this.bVH);
        R(this.bVJ);
        R(this.bVI);
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abI() {
        this.bVo.setVisibility(8);
        R(this.bVH);
        R(this.bVJ);
        R(this.bVI);
        if (!this.auf) {
            sendMessage(new RequestSearchPersonHistoryReadMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ArrayList<String> arrayList) {
        boolean z = false;
        if (b(i, arrayList) || c(i, arrayList) || d(i, arrayList)) {
            abP();
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.text_no_search_record));
            return;
        }
        abO();
        List<com.baidu.tieba.mainentrance.c> arrayList2 = new ArrayList<>();
        if (i == 4) {
            arrayList2 = this.bUJ;
        }
        a(i, arrayList, (this.bUJ == null ? 0 : arrayList2.size()) >= 2);
        boolean z2 = i == 4;
        if (arrayList == null || arrayList.size() == 0) {
            z = true;
        }
        i(z2, z);
        if (i == 4) {
            abD();
        }
        if (i == 4 && this.bUJ.size() >= 2) {
            this.bVl.show();
        } else {
            this.bVl.hide();
        }
        this.bVi.aW(arrayList2);
        this.bVi.notifyDataSetChanged();
    }

    private void a(int i, ArrayList<String> arrayList, boolean z) {
        if (this.bVm != null) {
            this.bVm.removeAllViews();
            if (arrayList != null && !arrayList.isEmpty() && getActivity() != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                if (z) {
                    this.bVK = new View(pageActivity);
                    this.bVK.setBackgroundColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_bg_line_b));
                    layoutParams.height = com.baidu.adp.lib.util.k.d(pageActivity, i.d.ds12);
                    layoutParams.topMargin = com.baidu.adp.lib.util.k.d(pageActivity, i.d.ds14);
                    this.bVm.addView(this.bVK, layoutParams);
                }
                this.bVL = LayoutInflater.from(pageActivity).inflate(i.g.square_search_recommand_fourm_header, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                getLayoutMode().k(this.bVL);
                this.bVm.addView(this.bVL, layoutParams2);
                int size = arrayList.size();
                this.bVN.clear();
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
                        this.bVN.add(inflate);
                        this.bVm.addView(inflate, layoutParams3);
                    }
                }
                this.bVM = LayoutInflater.from(pageActivity).inflate(i.g.home_dialog_search_footer, (ViewGroup) null);
                ((TextView) this.bVM.findViewById(i.f.home_bt_search_footer)).setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.s_actionbar_text_line_color_s));
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                this.bVM.setOnClickListener(new ah(this));
                this.bVm.addView(this.bVM, layoutParams4);
            }
        }
    }

    private void i(boolean z, boolean z2) {
        int size;
        if (this.bVk != null) {
            this.bVk.clear();
            if (this.bVj != null && !this.bVj.isEmpty() && z && (size = this.bVj.size()) >= 2) {
                int i = size <= 4 ? size : 4;
                int i2 = i % 2 != 0 ? i - 1 : i;
                for (int i3 = 0; i3 < i2; i3++) {
                    g gVar = (g) com.baidu.tbadk.core.util.u.b(this.bVj, i3);
                    if (gVar != null) {
                        this.bVk.a(gVar, i3).setOnClickListener(this.bWb);
                    }
                }
                this.bVk.dM(((this.bUJ == null || this.bUJ.size() == 0) && z2) ? false : true);
                this.bVk.show();
            }
        }
    }

    private boolean b(int i, ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && (this.bUJ == null || this.bUJ.size() <= 2) && 4 == i && this.mMode == 0 && (this.bVj == null || this.bVj.size() <= 2);
    }

    private boolean c(int i, ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && i == 5 && this.mMode != 5;
    }

    private boolean d(int i, ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && i == 6 && this.mMode != 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abJ() {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).cu(getPageContext().getString(i.h.alert_clean_history)).a(getPageContext().getString(i.h.clear_all_text), new ai(this)).b(getPageContext().getString(i.h.alert_no_button), new al(this)).b(getPageContext()).sR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abK() {
        this.bVa.setVisibility(8);
        if (this.bVw != null) {
            if (this.bVw.equals(this.bVx)) {
                refresh();
                return;
            }
            R(this.bVH);
            R(this.bVJ);
            R(this.bVI);
            this.mHandler.removeCallbacks(this.bVY);
            this.mHandler.postDelayed(this.bVY, 500L);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v5 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void H(int i, String str) {
        this.bVh.setVisibility(8);
        if (str != null && str.trim().length() > 0) {
            int i2 = this.bVE ? 1 : 0;
            if (str.equals(this.bVy) && i == this.bVA && this.bVB == i2) {
                refresh();
                return;
            }
            this.bVB = i2;
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append(TbConfig.SERVER_ADDRESS);
            stringBuffer.append(TbConfig.POST_SEARCH_URL);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("word", str));
            arrayList.add(new BasicNameValuePair("pn", String.valueOf(i)));
            arrayList.add(new BasicNameValuePair("rn", String.valueOf(50)));
            arrayList.add(new BasicNameValuePair("only_thread", new StringBuilder().append(i2).toString()));
            arrayList.add(new BasicNameValuePair("st_type", "search_post"));
            abw();
            this.bVv = new b(stringBuffer.toString(), arrayList);
            this.bVv.setPriority(3);
            this.bVv.execute(new Object[0]);
            this.bVF = true;
        }
    }

    private FRSPageRequestMessage iZ(String str) {
        FRSPageRequestMessage fRSPageRequestMessage = new FRSPageRequestMessage();
        fRSPageRequestMessage.setKw(str);
        fRSPageRequestMessage.setPn(1);
        if (com.baidu.tbadk.core.m.qV().qZ()) {
            fRSPageRequestMessage.setRn(35);
        } else {
            fRSPageRequestMessage.setRn(50);
        }
        fRSPageRequestMessage.setWithGroup(1);
        int K = com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity());
        int L = com.baidu.adp.lib.util.k.L(getPageContext().getPageActivity());
        float f = K / 320.0f;
        int i = com.baidu.tbadk.core.util.at.uK().uM() ? 2 : 1;
        fRSPageRequestMessage.setScrW(K);
        fRSPageRequestMessage.setScrH(L);
        fRSPageRequestMessage.setScrDip(f);
        fRSPageRequestMessage.setqType(i);
        return fRSPageRequestMessage;
    }

    private void abL() {
        if (this.bVo != null) {
            this.bVo.setNextPage(null);
        }
        if (this.bVq != null) {
            this.bVq.clear();
            this.bVq.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        int i;
        int i2 = 0;
        try {
            if (this.mMode == 0) {
                if (this.bVs != null) {
                    if (this.bVs.forum_list != null && this.bVs.forum_list.size() > 0) {
                        abN();
                        this.bVo.setAdapter((ListAdapter) this.bVp);
                        this.bVp.iV(this.bVw);
                        this.bVp.I(this.bVs.forum_list);
                        this.bVp.notifyDataSetInvalidated();
                        return;
                    }
                    R(this.bVI);
                    abR();
                    abM();
                }
            } else if (this.bVt != null) {
                List<j.a> list = this.bVt.cvj;
                if (list != null && list.size() > 0) {
                    abN();
                    if (this.bVt.getCurrentPage() == 1) {
                        this.bVo.setVisibility(0);
                        this.bVq.clear();
                        this.bVo.setAdapter((ListAdapter) this.bVq);
                        this.bVo.setNextPage(abS());
                    }
                    if (!this.bVt.isHasMore()) {
                        abS().setText(getResources().getString(i.h.list_no_more));
                        abS().vz();
                    }
                    int bn = this.bVq.bn(list);
                    if (bn > 0) {
                        i = this.bVo.getFirstVisiblePosition() - bn;
                        View childAt = this.bVo.getChildAt(0);
                        if (childAt != null) {
                            i2 = childAt.getTop();
                        }
                    } else {
                        i = 0;
                    }
                    this.bVq.notifyDataSetChanged();
                    if (bn > 0) {
                        this.bVo.setSelectionFromTop(i, i2);
                    }
                    if (this.bVG) {
                        this.bVg.setVisibility(0);
                        this.bVG = false;
                        com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("search_post_show_dropmenu", false);
                    }
                } else if (this.mNoDataView.getVisibility() != 0) {
                    abP();
                    R(this.bVJ);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.text_no_suggest));
                }
            } else if (this.mNoDataView.getVisibility() != 0) {
                abP();
                R(this.bVJ);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.text_no_suggest));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void abM() {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.baidu.tbadk.core.util.an.getColor(i.c.cp_cont_h));
        TextView textView = (TextView) this.bVf.findViewById(i.f.no_bar_found);
        textView.setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_cont_c));
        TextView textView2 = (TextView) this.bVf.findViewById(i.f.create_bar_guide);
        textView2.setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_cont_b));
        String str = "";
        if (this.bVw != null) {
            str = this.bVw.length() > 6 ? String.valueOf(this.bVw.substring(0, 6)) + "..." : this.bVw;
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

    private void abN() {
        this.bVa.setVisibility(0);
        this.bVo.setVisibility(0);
        this.bVh.setVisibility(8);
        R(this.bVI);
        this.mNoDataView.setVisibility(8);
        this.bVg.setVisibility(8);
        this.bVf.setVisibility(8);
    }

    private void abO() {
        this.bVa.setVisibility(0);
        this.bVh.setVisibility(0);
        if (this.mMode == 0) {
            Q(this.bVH);
        } else {
            R(this.bVH);
        }
        this.bVo.setVisibility(8);
        R(this.bVI);
        this.mNoDataView.setVisibility(8);
        this.bVg.setVisibility(8);
        this.bVf.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abP() {
        this.bVa.setVisibility(8);
        this.bVo.setVisibility(8);
        this.bVh.setVisibility(8);
        Q(this.bVI);
        this.mNoDataView.setVisibility(0);
        if (this.mMode == 0) {
            Q(this.bVJ);
        }
        this.bVg.setVisibility(8);
        this.bVf.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abQ() {
        R(this.bVI);
        this.bVg.setVisibility(0);
    }

    private void abR() {
        this.bVa.setVisibility(8);
        this.bVo.setVisibility(8);
        this.bVh.setVisibility(8);
        R(this.bVI);
        this.mNoDataView.setVisibility(8);
        this.bVg.setVisibility(8);
        this.bVf.setVisibility(0);
        if (CreateBarActivityConfig.IS_SUPPORT_CREATE_BAR && this.bVw != null && this.bVw.length() <= 30) {
            dN(true);
        } else {
            dN(false);
        }
    }

    private void dN(boolean z) {
        if (!z) {
            this.bVO.setVisibility(8);
            this.bVP.setVisibility(8);
            this.bVQ.setVisibility(8);
            return;
        }
        this.bVO.setVisibility(0);
        this.bVP.setVisibility(0);
        this.bVQ.setVisibility(0);
    }

    private PbListView abS() {
        if (this.bVn == null) {
            this.bVn = new PbListView(getPageContext().getPageActivity());
            this.bVn.np();
        }
        return this.bVn;
    }

    @Override // com.baidu.tieba.mainentrance.d.a
    public void iW(String str) {
        this.bVC = true;
        this.bUJ = new ArrayList();
        abG();
    }

    @Override // com.baidu.tieba.mainentrance.d.a
    public void a(List<com.baidu.tieba.mainentrance.c> list, List<g> list2, f fVar) {
        this.bVC = true;
        hideLoadingView(this.bUZ);
        if (list == null || list.isEmpty()) {
            this.bUJ = new ArrayList();
        } else {
            this.bUJ = list;
        }
        if (list2 == null) {
            this.bVj = new ArrayList();
        } else {
            this.bVj = list2;
        }
        a(fVar);
        this.mHotSearchInfo = fVar;
        abG();
    }

    private void a(f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.sharedPref.b.tu().putLong("hot_search_id", fVar.getId());
            com.baidu.tbadk.core.sharedPref.b.tu().putString("hot_search_name", fVar.getName());
            com.baidu.tbadk.core.sharedPref.b.tu().putString("hot_search_title", fVar.Im());
            com.baidu.tbadk.core.sharedPref.b.tu().putLong("hot_search_type", fVar.getType());
            return;
        }
        com.baidu.tbadk.core.sharedPref.b.tu().putLong("hot_search_id", 0L);
        com.baidu.tbadk.core.sharedPref.b.tu().putString("hot_search_name", "");
        com.baidu.tbadk.core.sharedPref.b.tu().putString("hot_search_title", "");
        com.baidu.tbadk.core.sharedPref.b.tu().putLong("hot_search_type", 0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bUW.onChangeSkinType(i);
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.bUY);
        getLayoutMode().k(this.bVf);
        com.baidu.tbadk.core.util.an.e(this.bUY, i);
        if (this.bVp != null) {
            this.bVp.notifyDataSetChanged();
        }
        if (this.bVq != null) {
            this.bVq.notifyDataSetChanged();
        }
        if (this.bVi != null) {
            this.bVi.notifyDataSetChanged();
        }
        com.baidu.tbadk.core.util.an.i(this.bUZ, i.c.cp_bg_line_d);
        com.baidu.tbadk.core.util.an.c(this.bVe, i.e.icon_search_ba);
        com.baidu.tbadk.core.util.an.b(this.bVd, i.c.cp_cont_i, 1);
        if (this.bVl != null) {
            getLayoutMode().k(this.bVl.getView());
        }
        if (this.bVk != null) {
            this.bVk.onChangeSkinType(i);
        }
        iq(i);
    }

    private void iq(int i) {
        if (this.bVm != null) {
            this.bVm.setBackgroundColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_bg_line_d));
        }
        if (this.bVK != null) {
            this.bVK.setBackgroundColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_bg_line_b));
        }
        if (this.bVL != null) {
            getLayoutMode().k(this.bVL);
        }
        if (this.bVM != null) {
            ((TextView) this.bVM.findViewById(i.f.home_bt_search_footer)).setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.s_actionbar_text_line_color_s));
        }
        if (this.bVN != null) {
            for (View view : this.bVN) {
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
                        SquareSearchActivity.this.gj(this.mName);
                        return;
                    }
                    SquareSearchActivity.this.H(1, this.mName);
                    SquareSearchActivity.this.bVb.setText(this.mName);
                    SquareSearchActivity.this.bVb.requestFocus();
                    Selection.setSelection(SquareSearchActivity.this.bVb.getText(), this.mName.length());
                    return;
                }
                com.baidu.tieba.tbadkCore.util.m.lM(this.mName);
                SquareSearchActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(SquareSearchActivity.this.getActivity()).createNormalCfg(this.mName, FrsActivityConfig.FRS_FROM_SEARCH)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
        private com.baidu.tbadk.core.util.w afm = null;
        private BasicNameValuePair bWj;
        private String mUrl;

        public a(String str, BasicNameValuePair basicNameValuePair, boolean z) {
            this.mUrl = null;
            this.bWj = null;
            this.mUrl = str;
            this.bWj = basicNameValuePair;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.bUZ, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(i.d.ds320));
            SquareSearchActivity.this.bVa.setVisibility(8);
            SquareSearchActivity.this.mNoDataView.setVisibility(8);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public ForumSuggestModel doInBackground(Object... objArr) {
            ForumSuggestModel forumSuggestModel = null;
            try {
                this.afm = new com.baidu.tbadk.core.util.w(this.mUrl);
                this.afm.a(this.bWj);
                String tG = this.afm.tG();
                if (tG == null) {
                    return null;
                }
                forumSuggestModel = ForumSuggestModel.parserJson(tG);
                SquareSearchActivity.this.bVx = this.bWj.getValue();
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
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.bUZ);
            if (forumSuggestModel != null) {
                SquareSearchActivity.this.bVs = forumSuggestModel;
                SquareSearchActivity.this.refresh();
            }
            SquareSearchActivity.this.bVu = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afm != null) {
                this.afm.gJ();
                this.afm = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.bUZ);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Object, Integer, com.baidu.tieba.postsearch.j> {
        private com.baidu.tbadk.core.util.w afm = null;
        private ArrayList<BasicNameValuePair> bWk;
        private String mUrl;

        public b(String str, ArrayList<BasicNameValuePair> arrayList) {
            this.mUrl = null;
            this.bWk = null;
            this.mUrl = str;
            this.bWk = arrayList;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.bUZ, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(i.d.ds320));
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
                this.afm = new com.baidu.tbadk.core.util.w(this.mUrl);
                Iterator<BasicNameValuePair> it = this.bWk.iterator();
                while (it.hasNext()) {
                    this.afm.a(it.next());
                }
                String tG = this.afm.tG();
                if (!this.afm.uh().va().uk() || tG == null) {
                    return null;
                }
                com.baidu.tieba.postsearch.j jVar2 = new com.baidu.tieba.postsearch.j();
                try {
                    jVar2.parseJson(tG);
                    if (tG != null && this.afm != null && this.afm.uh().va().qT()) {
                        Iterator<BasicNameValuePair> it2 = this.bWk.iterator();
                        while (it2.hasNext()) {
                            BasicNameValuePair next = it2.next();
                            if ("word".equals(next.getName())) {
                                SquareSearchActivity.this.bVy = next.getValue();
                            }
                            if ("pn".equals(next.getName())) {
                                SquareSearchActivity.this.bVA = Integer.valueOf(next.getValue()).intValue();
                            }
                        }
                    }
                    if (this.afm.uh().va().qT()) {
                        com.baidu.tieba.tbadkCore.util.m.lN(SquareSearchActivity.this.bVw);
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
            SquareSearchActivity.this.bVF = false;
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.bUZ);
            SquareSearchActivity.this.bVq.notifyDataSetChanged();
            if (jVar == null || this.afm == null || !this.afm.uh().va().uk()) {
                SquareSearchActivity.this.showToast(SquareSearchActivity.this.getPageContext().getString(i.h.neterror));
            } else if (this.afm.uh().va().qT()) {
                SquareSearchActivity.this.bVt = jVar;
                SquareSearchActivity.this.refresh();
            } else {
                SquareSearchActivity.this.refresh();
            }
            SquareSearchActivity.this.bVv = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            SquareSearchActivity.this.bVq.notifyDataSetChanged();
            if (this.afm != null) {
                this.afm.gJ();
                this.afm = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.bUZ);
            SquareSearchActivity.this.bVv = null;
            super.onCancelled();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!this.bVF && this.bVt != null && this.bVt.isHasMore()) {
            H(this.bVt.getCurrentPage() + 1, this.bVw);
            abS().startLoadData();
        }
    }

    private void dO(boolean z) {
        if (TbadkCoreApplication.isLogin()) {
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(CmdConfigCustom.CMD_REQUEST_ENTER_FORUM_MESSAGE, true));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(CmdConfigCustom.CMD_REQUEST_ENTER_FORUM_MESSAGE, false));
        }
    }

    private void abT() {
        this.bVH = new SearchPageFocusBar(getPageContext().getPageActivity());
        this.bVH.setVisibility(8);
        this.bVh.addFooterView(this.bVH, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(View view) {
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private void R(View view) {
        if (view != null) {
            view.setVisibility(8);
        }
    }
}
