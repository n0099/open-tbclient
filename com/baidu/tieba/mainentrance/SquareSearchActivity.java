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
    private boolean avq;
    private List<com.baidu.tieba.mainentrance.c> bTX;
    private LinearLayout bUA;
    private PbListView bUB;
    private BdListView bUC;
    private com.baidu.tieba.mainentrance.a bUD;
    private com.baidu.tieba.postsearch.v bUE;
    private d bUF;
    private ForumSuggestModel bUG;
    private com.baidu.tieba.postsearch.j bUH;
    private a bUI;
    private b bUJ;
    private String bUK;
    private String bUL;
    private String bUM;
    private String bUN;
    private boolean bUQ;
    private boolean bUS;
    private boolean bUU;
    private SearchPageFocusBar bUV;
    private ScrollView bUW;
    private SearchPageFocusBar bUX;
    private View bUY;
    private View bUZ;
    private FragmentTabWidget bUk;
    private FragmentTabIndicator bUl;
    private LinearLayoutDetectsSoftKeyboard bUm;
    private FrameLayout bUn;
    private FrameLayout bUo;
    private EditText bUp;
    private TextView bUq;
    private TextView bUr;
    private ImageView bUs;
    private View bUt;
    private View bUu;
    private ListView bUv;
    private com.baidu.tieba.mainentrance.b bUw;
    private List<g> bUx;
    private m bUy;
    private h bUz;
    private View bVa;
    private View bVc;
    private TextView bVd;
    private View bVe;
    private f mHotSearchInfo;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.m mNoDataView;
    private int mMode = 0;
    private int bUO = 0;
    private int bUP = -1;
    private boolean aru = true;
    private boolean bUR = true;
    private boolean bUT = false;
    private List<View> bVb = new ArrayList();
    private Runnable bVf = new n(this);
    private final View.OnClickListener bVg = new y(this);
    private final com.baidu.adp.framework.listener.e bVh = new ak(this, 301001, true);
    private final HttpMessageListener bVi = new an(this, CmdConfigHttp.FRS_HTTP_CMD, true);
    private CustomMessageListener bVj = new ao(this, CmdConfigCustom.CMD_READ_SEARCHPERSON_HISTORY);
    private CustomMessageListener bVk = new ap(this, CmdConfigCustom.CMD_WRITE_SEARCHPERSON_HISTORY);
    private HttpMessageListener bVl = new aq(this, CmdConfigHttp.SEARCH_FRIEND_CMD);
    private final Runnable bVm = new ar(this);
    private CustomMessageListener bVn = new as(this, CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA);
    private CustomMessageListener bVo = new o(this, CmdConfigCustom.GET_ALL_SEARCH_POST_DATA);
    private View.OnClickListener bVp = new p(this);
    private CustomMessageListener bVq = new q(this, CmdConfigCustom.CMD_ENTER_FORUM_INFO);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponsedMessage<?> responsedMessage, boolean z) {
        int error = responsedMessage.getError();
        String string = StringUtils.isNull(responsedMessage.getErrorString()) ? getResources().getString(i.h.neterror) : responsedMessage.getErrorString();
        boolean z2 = error < -13 || error > -10;
        if (error == 0) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createFlagCfg(this.bUN, FrsActivityConfig.FRS_FROM_SEARCH, 1)));
        } else if (z2 && z && error == 3) {
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(i.h.login_to_use), true, 11013)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), this.bUN)));
            }
        } else {
            showToast(string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean abe() {
        if (this.mMode == 0 && this.mHotSearchInfo != null) {
            if (this.mHotSearchInfo.getType() == 0) {
                iW(this.mHotSearchInfo.getName());
            } else if (this.mHotSearchInfo.getType() == 1) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "")));
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c10355").ae("obj_name", this.mHotSearchInfo.getName()).r("obj_type", this.mHotSearchInfo.getType() == 0 ? 2 : 1));
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

    private void Gy() {
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
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), this.bUN)));
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
        Gy();
        registerListener(this.bVj);
        registerListener(this.bVk);
        registerListener(this.bVn);
        registerListener(this.bVo);
        registerListener(this.bVl);
        registerListener(this.bVh);
        registerListener(this.bVi);
        registerListener(this.bVq);
        this.bUU = com.baidu.tbadk.core.sharedPref.b.tu().getBoolean("search_post_show_dropmenu", true);
        if (SquareSearchActivityConfig.IS_SHOW_RECOMMEND_FORUM) {
            this.bUF = new d(this, this);
            this.bUF.abd();
            this.bUF.abc();
        }
        this.bUQ = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aru = true;
        if (this.bUR) {
            this.mHandler.post(this.bVf);
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
        hideLoadingView(this.bUn);
        this.mHandler.removeCallbacks(this.bVf);
        abf();
    }

    public void abf() {
        this.mHandler.removeCallbacks(this.bVm);
        if (this.bUI != null) {
            this.bUI.cancel();
            this.bUI = null;
        }
        if (this.bUJ != null) {
            this.bUJ.cancel();
            this.bUJ = null;
        }
    }

    private void init() {
        this.bUm = (LinearLayoutDetectsSoftKeyboard) findViewById(i.f.parent);
        this.bUm.setOnSoftKeyBoardShownListener(new r(this));
        this.bUm.setOnTouchListener(new s(this));
        Ol();
        Ok();
        this.bUn = (FrameLayout) findViewById(i.f.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(i.d.ds80)), null, null);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            this.bUW = (ScrollView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(i.g.home_searchbar_nodataview, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) this.bUW.findViewById(i.f.focusbar_nodata_root);
            this.bUX = (SearchPageFocusBar) linearLayout.findViewById(i.f.no_data_focusbar);
            linearLayout.addView(this.mNoDataView, 0);
            this.bUW.setOnTouchListener(new t(this));
            this.bUn.addView(this.bUW, this.bUn.getChildCount());
        } else {
            this.bUn.addView(this.mNoDataView, 0);
        }
        this.bUo = (FrameLayout) findViewById(i.f.home_search_list);
        abn();
        abg();
        abi();
        abh();
        abj();
        this.bUt = findViewById(i.f.empty_search_result);
        this.bVc = this.bUt.findViewById(i.f.empty_result_divider_1);
        this.bVd = (TextView) this.bUt.findViewById(i.f.create_bar_guide);
        this.bVe = this.bUt.findViewById(i.f.empty_result_divider_2);
        abk();
        this.bUp.setText("");
        this.bUp.requestFocus();
        ShowSoftKeyPadDelay(this.bUp, 200);
        if (TbadkSettings.getInst().loadBoolean("search_mode", true)) {
            ib(0);
            abm();
            return;
        }
        ib(1);
    }

    private void Ok() {
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new u(this));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, i.g.square_search_navigation_view, (View.OnClickListener) null);
        this.bUs = (ImageView) addCustomView.findViewById(i.f.search_bar_icon);
        this.bUp = (EditText) addCustomView.findViewById(i.f.home_et_search);
        this.bUq = (TextView) addCustomView.findViewById(i.f.home_bt_search_del);
        this.bUr = (TextView) addCustomView.findViewById(i.f.home_bt_search_s);
        this.bUp.setOnFocusChangeListener(new v(this));
        this.bUr.setText(getPageContext().getString(i.h.forward));
        this.bUr.setOnClickListener(this.bVg);
        this.bUp.setOnEditorActionListener(new w(this));
        this.bUq.setOnClickListener(new x(this));
        this.bUp.addTextChangedListener(new z(this));
    }

    private void Ol() {
        this.bUk = (FragmentTabWidget) findViewById(i.f.square_search_tab_widget);
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(i.d.ds32));
        fragmentTabIndicator.setGravity(17);
        fragmentTabIndicator.auN = i.c.s_actionbar_text_color;
        fragmentTabIndicator.setText(getResources().getString(i.h.search_bar_text));
        this.bUl = new FragmentTabIndicator(getPageContext().getPageActivity());
        this.bUl.auN = i.c.s_actionbar_text_color;
        this.bUl.setTextSize(0, getResources().getDimension(i.d.ds32));
        this.bUl.setGravity(17);
        this.bUl.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_down);
        this.bUl.setCompoundDrawablePadding(getResources().getDimensionPixelSize(i.d.ds10));
        this.bUl.setText(getResources().getString(i.h.search_post_text));
        this.bUl.Cy();
        FragmentTabIndicator fragmentTabIndicator2 = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator2.auN = i.c.s_actionbar_text_color;
        fragmentTabIndicator2.setTextSize(0, getResources().getDimension(i.d.ds32));
        fragmentTabIndicator2.setGravity(17);
        fragmentTabIndicator2.setText(getResources().getString(i.h.search_person));
        this.bUk.addView(fragmentTabIndicator);
        this.bUk.addView(this.bUl);
        this.bUk.addView(fragmentTabIndicator2);
        this.bUk.d(0, true);
        this.bUk.setTabSelectionListener(new aa(this));
    }

    private void abg() {
        this.bUv = (ListView) findViewById(i.f.home_lv_search_history);
        if (this.bUA == null) {
            this.bUA = new LinearLayout(getPageContext().getPageActivity());
            this.bUA.setOrientation(1);
            this.bUA.setBackgroundColor(com.baidu.tbadk.core.util.am.getColor(i.c.cp_bg_line_d));
        }
        this.bUv.addFooterView(this.bUA);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            abC();
        }
        this.bUw = new com.baidu.tieba.mainentrance.b(this);
        this.bUv.setAdapter((ListAdapter) this.bUw);
        this.bUw.r(new ab(this));
    }

    private void abh() {
        if (this.bUz == null) {
            this.bUz = new h(getPageContext());
            this.bUv.addHeaderView(this.bUz.getView());
        }
    }

    private void abi() {
        if (this.bUy == null) {
            this.bUy = new m(getPageContext());
            this.bUv.addHeaderView(this.bUy.no());
        }
    }

    private void abj() {
        this.bUC = (BdListView) findViewById(i.f.home_lv_search_suggest);
        this.bUD = new com.baidu.tieba.mainentrance.a(this, null);
        this.bUE = new com.baidu.tieba.postsearch.v(getPageContext());
        this.bUC.setOnItemClickListener(new ac(this));
        ad adVar = new ad(this);
        this.bUC.setOnScrollListener(adVar);
        this.bUv.setOnScrollListener(adVar);
        this.bUC.setOnSrollToBottomListener(this);
    }

    private void abk() {
        this.bUu = findViewById(i.f.search_dropmenu);
        TextView textView = (TextView) this.bUu.findViewById(i.f.dropmenu_all_text);
        textView.setTextColor(com.baidu.tbadk.core.util.am.getColor(i.c.cp_link_tip_a));
        ImageView imageView = (ImageView) this.bUu.findViewById(i.f.dropmenu_all_icon);
        imageView.setImageDrawable(com.baidu.tbadk.core.util.am.getDrawable(i.e.chx_tips_list_ok));
        imageView.setVisibility(0);
        TextView textView2 = (TextView) this.bUu.findViewById(i.f.dropmenu_thread_text);
        textView2.setTextColor(com.baidu.tbadk.core.util.am.getColor(i.c.cp_cont_c));
        ImageView imageView2 = (ImageView) this.bUu.findViewById(i.f.dropmenu_thread_icon);
        imageView2.setImageDrawable(com.baidu.tbadk.core.util.am.getDrawable(i.e.chx_tips_list_ok));
        imageView2.setVisibility(8);
        this.bUu.findViewById(i.f.dropmenu_all_layout).setOnClickListener(new ae(this, textView, imageView, textView2, imageView2));
        this.bUu.findViewById(i.f.dropmenu_thread_layout).setOnClickListener(new af(this, textView, imageView, textView2, imageView2));
        this.bUu.findViewById(i.f.dropmenu_lower_part).setOnClickListener(new ag(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abl() {
        if (this.bUo.getVisibility() == 8 && this.mNoDataView.getVisibility() == 8 && this.bUt.getVisibility() == 8) {
            R(this.bUW);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.text_no_search_record));
        }
    }

    public void ib(int i) {
        switch (i) {
            case 0:
                if (this.mMode != 0) {
                    this.mMode = 0;
                    this.bUr.setText(getPageContext().getString(i.h.forward));
                    abm();
                    abf();
                    abu();
                    if (this.bUK.trim().length() > 0) {
                        abt();
                        return;
                    } else {
                        abp();
                        return;
                    }
                }
                return;
            case 1:
                if (this.mMode != 1) {
                    this.mMode = 1;
                    this.bUr.setText(getPageContext().getString(i.h.search));
                    this.bUp.setHint(i.h.search_post_hint);
                    abf();
                    abu();
                    if (this.bUK.trim().length() > 0) {
                        this.bUC.setVisibility(8);
                        G(1, this.bUK);
                        return;
                    }
                    abq();
                    return;
                }
                return;
            case 2:
            default:
                return;
            case 3:
                if (this.mMode != 3) {
                    this.mMode = 3;
                    this.bUC.setVisibility(8);
                    this.bUt.setVisibility(8);
                    this.bUu.setVisibility(8);
                    this.bUr.setText(i.h.search);
                    this.bUp.setHint(i.h.search_friend_tip);
                    abu();
                    abf();
                    abr();
                    return;
                }
                return;
        }
    }

    private void abm() {
        if (this.mHotSearchInfo == null) {
            this.bUp.setHint(i.h.search_bar);
        } else {
            this.bUp.setHint(UtilHelper.getFixedText(this.mHotSearchInfo.Ia(), 12));
        }
    }

    private void abn() {
        long j = com.baidu.tbadk.core.sharedPref.b.tu().getLong("hot_search_id", 0L);
        if (j != 0) {
            this.mHotSearchInfo = new f();
            this.mHotSearchInfo.setId(j);
            this.mHotSearchInfo.setName(com.baidu.tbadk.core.sharedPref.b.tu().getString("hot_search_name", ""));
            this.mHotSearchInfo.iV(com.baidu.tbadk.core.sharedPref.b.tu().getString("hot_search_title", ""));
            this.mHotSearchInfo.aF(com.baidu.tbadk.core.sharedPref.b.tu().getLong("hot_search_type", 0L));
        }
    }

    public void abo() {
        iW(this.bUp.getText().toString().trim());
    }

    private void iW(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (com.baidu.adp.lib.util.i.iM()) {
                this.bUN = str;
                this.aru = false;
                sendMessage(iX(str));
                return;
            }
            showToast(i.h.neterror);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abp() {
        this.bUC.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA));
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            dM(true);
            S(this.bUX);
            S(this.bUW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abq() {
        this.bUC.setVisibility(8);
        S(this.bUV);
        S(this.bUX);
        S(this.bUW);
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abr() {
        this.bUC.setVisibility(8);
        S(this.bUV);
        S(this.bUX);
        S(this.bUW);
        if (!this.avq) {
            sendMessage(new RequestSearchPersonHistoryReadMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ArrayList<String> arrayList) {
        boolean z = false;
        if (b(i, arrayList) || c(i, arrayList) || d(i, arrayList)) {
            aby();
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.text_no_search_record));
            return;
        }
        abx();
        List<com.baidu.tieba.mainentrance.c> arrayList2 = new ArrayList<>();
        if (i == 4) {
            arrayList2 = this.bTX;
        }
        a(i, arrayList, (this.bTX == null ? 0 : arrayList2.size()) >= 2);
        boolean z2 = i == 4;
        if (arrayList == null || arrayList.size() == 0) {
            z = true;
        }
        i(z2, z);
        if (i == 4) {
            abm();
        }
        if (i == 4 && this.bTX.size() >= 2) {
            this.bUz.show();
        } else {
            this.bUz.hide();
        }
        this.bUw.aS(arrayList2);
        this.bUw.notifyDataSetChanged();
    }

    private void a(int i, ArrayList<String> arrayList, boolean z) {
        if (this.bUA != null) {
            this.bUA.removeAllViews();
            if (arrayList != null && !arrayList.isEmpty() && getActivity() != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                if (z) {
                    this.bUY = new View(pageActivity);
                    this.bUY.setBackgroundColor(com.baidu.tbadk.core.util.am.getColor(i.c.cp_bg_line_b));
                    layoutParams.height = com.baidu.adp.lib.util.k.d(pageActivity, i.d.ds12);
                    layoutParams.topMargin = com.baidu.adp.lib.util.k.d(pageActivity, i.d.ds14);
                    this.bUA.addView(this.bUY, layoutParams);
                }
                this.bUZ = LayoutInflater.from(pageActivity).inflate(i.g.square_search_recommand_fourm_header, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                getLayoutMode().k(this.bUZ);
                this.bUA.addView(this.bUZ, layoutParams2);
                int size = arrayList.size();
                this.bVb.clear();
                for (int i2 = 0; i2 < size; i2++) {
                    String str = arrayList.get(i2);
                    if (!TextUtils.isEmpty(str)) {
                        View inflate = LayoutInflater.from(pageActivity).inflate(i.g.home_dialog_search_item, (ViewGroup) null);
                        ((TextView) inflate.findViewById(i.f.home_lv_search_forum)).setText(str);
                        com.baidu.tbadk.core.util.am.b((TextView) inflate.findViewById(i.f.home_lv_search_forum), i.c.cp_cont_b, 1);
                        inflate.findViewById(i.f.home_dialog_lv_search_forum_divider).setVisibility(8);
                        com.baidu.tbadk.core.util.am.i(inflate, i.e.square_search_item_bg);
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                        inflate.setOnClickListener(new c(str));
                        this.bVb.add(inflate);
                        this.bUA.addView(inflate, layoutParams3);
                    }
                }
                this.bVa = LayoutInflater.from(pageActivity).inflate(i.g.home_dialog_search_footer, (ViewGroup) null);
                ((TextView) this.bVa.findViewById(i.f.home_bt_search_footer)).setTextColor(com.baidu.tbadk.core.util.am.getColor(i.c.s_actionbar_text_line_color_s));
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                this.bVa.setOnClickListener(new ah(this));
                this.bUA.addView(this.bVa, layoutParams4);
            }
        }
    }

    private void i(boolean z, boolean z2) {
        int size;
        if (this.bUy != null) {
            this.bUy.clear();
            if (this.bUx != null && !this.bUx.isEmpty() && z && (size = this.bUx.size()) >= 2) {
                int i = size <= 4 ? size : 4;
                int i2 = i % 2 != 0 ? i - 1 : i;
                for (int i3 = 0; i3 < i2; i3++) {
                    g gVar = (g) com.baidu.tbadk.core.util.u.b(this.bUx, i3);
                    if (gVar != null) {
                        this.bUy.a(gVar, i3).setOnClickListener(this.bVp);
                    }
                }
                this.bUy.dK(((this.bTX == null || this.bTX.size() == 0) && z2) ? false : true);
                this.bUy.show();
            }
        }
    }

    private boolean b(int i, ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && (this.bTX == null || this.bTX.size() <= 2) && 4 == i && this.mMode == 0 && (this.bUx == null || this.bUx.size() <= 2);
    }

    private boolean c(int i, ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && i == 5 && this.mMode != 5;
    }

    private boolean d(int i, ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && i == 6 && this.mMode != 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abs() {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).ct(getPageContext().getString(i.h.alert_clean_history)).a(getPageContext().getString(i.h.clear_all_text), new ai(this)).b(getPageContext().getString(i.h.alert_no_button), new al(this)).b(getPageContext()).sR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abt() {
        this.bUo.setVisibility(8);
        if (this.bUK != null) {
            if (this.bUK.equals(this.bUL)) {
                refresh();
                return;
            }
            S(this.bUV);
            S(this.bUX);
            S(this.bUW);
            this.mHandler.removeCallbacks(this.bVm);
            this.mHandler.postDelayed(this.bVm, 500L);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v5 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void G(int i, String str) {
        this.bUv.setVisibility(8);
        if (str != null && str.trim().length() > 0) {
            int i2 = this.bUS ? 1 : 0;
            if (str.equals(this.bUM) && i == this.bUO && this.bUP == i2) {
                refresh();
                return;
            }
            this.bUP = i2;
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append(TbConfig.SERVER_ADDRESS);
            stringBuffer.append(TbConfig.POST_SEARCH_URL);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("word", str));
            arrayList.add(new BasicNameValuePair("pn", String.valueOf(i)));
            arrayList.add(new BasicNameValuePair("rn", String.valueOf(50)));
            arrayList.add(new BasicNameValuePair("only_thread", new StringBuilder().append(i2).toString()));
            arrayList.add(new BasicNameValuePair("st_type", "search_post"));
            abf();
            this.bUJ = new b(stringBuffer.toString(), arrayList);
            this.bUJ.setPriority(3);
            this.bUJ.execute(new Object[0]);
            this.bUT = true;
        }
    }

    private FRSPageRequestMessage iX(String str) {
        FRSPageRequestMessage fRSPageRequestMessage = new FRSPageRequestMessage();
        fRSPageRequestMessage.setKw(str);
        fRSPageRequestMessage.setPn(1);
        if (com.baidu.tbadk.core.m.qX().rb()) {
            fRSPageRequestMessage.setRn(35);
        } else {
            fRSPageRequestMessage.setRn(50);
        }
        fRSPageRequestMessage.setWithGroup(1);
        int K = com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity());
        int L = com.baidu.adp.lib.util.k.L(getPageContext().getPageActivity());
        float f = K / 320.0f;
        int i = com.baidu.tbadk.core.util.as.uI().uK() ? 2 : 1;
        fRSPageRequestMessage.setScrW(K);
        fRSPageRequestMessage.setScrH(L);
        fRSPageRequestMessage.setScrDip(f);
        fRSPageRequestMessage.setqType(i);
        return fRSPageRequestMessage;
    }

    private void abu() {
        if (this.bUC != null) {
            this.bUC.setNextPage(null);
        }
        if (this.bUE != null) {
            this.bUE.clear();
            this.bUE.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        int i;
        int i2 = 0;
        try {
            if (this.mMode == 0) {
                if (this.bUG != null) {
                    if (this.bUG.forum_list != null && this.bUG.forum_list.size() > 0) {
                        abw();
                        this.bUC.setAdapter((ListAdapter) this.bUD);
                        this.bUD.iT(this.bUK);
                        this.bUD.I(this.bUG.forum_list);
                        this.bUD.notifyDataSetInvalidated();
                        return;
                    }
                    S(this.bUW);
                    abA();
                    abv();
                }
            } else if (this.bUH != null) {
                List<j.a> list = this.bUH.ctC;
                if (list != null && list.size() > 0) {
                    abw();
                    if (this.bUH.getCurrentPage() == 1) {
                        this.bUC.setVisibility(0);
                        this.bUE.clear();
                        this.bUC.setAdapter((ListAdapter) this.bUE);
                        this.bUC.setNextPage(abB());
                    }
                    if (!this.bUH.isHasMore()) {
                        abB().setText(getResources().getString(i.h.list_no_more));
                        abB().vy();
                    }
                    int bj = this.bUE.bj(list);
                    if (bj > 0) {
                        i = this.bUC.getFirstVisiblePosition() - bj;
                        View childAt = this.bUC.getChildAt(0);
                        if (childAt != null) {
                            i2 = childAt.getTop();
                        }
                    } else {
                        i = 0;
                    }
                    this.bUE.notifyDataSetChanged();
                    if (bj > 0) {
                        this.bUC.setSelectionFromTop(i, i2);
                    }
                    if (this.bUU) {
                        this.bUu.setVisibility(0);
                        this.bUU = false;
                        com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("search_post_show_dropmenu", false);
                    }
                } else if (this.mNoDataView.getVisibility() != 0) {
                    aby();
                    S(this.bUX);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.text_no_suggest));
                }
            } else if (this.mNoDataView.getVisibility() != 0) {
                aby();
                S(this.bUX);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.text_no_suggest));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void abv() {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.baidu.tbadk.core.util.am.getColor(i.c.cp_cont_h));
        TextView textView = (TextView) this.bUt.findViewById(i.f.no_bar_found);
        textView.setTextColor(com.baidu.tbadk.core.util.am.getColor(i.c.cp_cont_c));
        TextView textView2 = (TextView) this.bUt.findViewById(i.f.create_bar_guide);
        textView2.setTextColor(com.baidu.tbadk.core.util.am.getColor(i.c.cp_cont_b));
        String str = "";
        if (this.bUK != null) {
            str = this.bUK.length() > 6 ? String.valueOf(this.bUK.substring(0, 6)) + "..." : this.bUK;
        }
        String format = String.format(getPageContext().getString(i.h.empty_search_result_format), str);
        String format2 = String.format(getPageContext().getString(i.h.create_bar_guide_format), str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
        spannableStringBuilder.setSpan(foregroundColorSpan, 4, format.length() - 2, 33);
        textView.setText(spannableStringBuilder);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(format2);
        spannableStringBuilder2.setSpan(foregroundColorSpan, 5, format2.length() - 5, 33);
        textView2.setText(spannableStringBuilder2);
        Drawable drawable = com.baidu.tbadk.core.util.am.getDrawable(i.e.icon_search_list_add);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        textView2.setCompoundDrawablePadding(com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), i.d.ds10));
        textView2.setCompoundDrawables(drawable, null, null, null);
        textView2.setOnClickListener(new am(this));
    }

    private void abw() {
        this.bUo.setVisibility(0);
        this.bUC.setVisibility(0);
        this.bUv.setVisibility(8);
        S(this.bUW);
        this.mNoDataView.setVisibility(8);
        this.bUu.setVisibility(8);
        this.bUt.setVisibility(8);
    }

    private void abx() {
        this.bUo.setVisibility(0);
        this.bUv.setVisibility(0);
        if (this.mMode == 0) {
            R(this.bUV);
        } else {
            S(this.bUV);
        }
        this.bUC.setVisibility(8);
        S(this.bUW);
        this.mNoDataView.setVisibility(8);
        this.bUu.setVisibility(8);
        this.bUt.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aby() {
        this.bUo.setVisibility(8);
        this.bUC.setVisibility(8);
        this.bUv.setVisibility(8);
        R(this.bUW);
        this.mNoDataView.setVisibility(0);
        if (this.mMode == 0) {
            R(this.bUX);
        }
        this.bUu.setVisibility(8);
        this.bUt.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abz() {
        S(this.bUW);
        this.bUu.setVisibility(0);
    }

    private void abA() {
        this.bUo.setVisibility(8);
        this.bUC.setVisibility(8);
        this.bUv.setVisibility(8);
        S(this.bUW);
        this.mNoDataView.setVisibility(8);
        this.bUu.setVisibility(8);
        this.bUt.setVisibility(0);
        if (CreateBarActivityConfig.IS_SUPPORT_CREATE_BAR && this.bUK != null && this.bUK.length() <= 30) {
            dL(true);
        } else {
            dL(false);
        }
    }

    private void dL(boolean z) {
        if (!z) {
            this.bVc.setVisibility(8);
            this.bVd.setVisibility(8);
            this.bVe.setVisibility(8);
            return;
        }
        this.bVc.setVisibility(0);
        this.bVd.setVisibility(0);
        this.bVe.setVisibility(0);
    }

    private PbListView abB() {
        if (this.bUB == null) {
            this.bUB = new PbListView(getPageContext().getPageActivity());
            this.bUB.no();
        }
        return this.bUB;
    }

    @Override // com.baidu.tieba.mainentrance.d.a
    public void iU(String str) {
        this.bUQ = true;
        this.bTX = new ArrayList();
        abp();
    }

    @Override // com.baidu.tieba.mainentrance.d.a
    public void a(List<com.baidu.tieba.mainentrance.c> list, List<g> list2, f fVar) {
        this.bUQ = true;
        hideLoadingView(this.bUn);
        if (list == null || list.isEmpty()) {
            this.bTX = new ArrayList();
        } else {
            this.bTX = list;
        }
        if (list2 == null) {
            this.bUx = new ArrayList();
        } else {
            this.bUx = list2;
        }
        a(fVar);
        this.mHotSearchInfo = fVar;
        abp();
    }

    private void a(f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.sharedPref.b.tu().putLong("hot_search_id", fVar.getId());
            com.baidu.tbadk.core.sharedPref.b.tu().putString("hot_search_name", fVar.getName());
            com.baidu.tbadk.core.sharedPref.b.tu().putString("hot_search_title", fVar.Ia());
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
        this.bUk.onChangeSkinType(i);
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.bUm);
        getLayoutMode().k(this.bUt);
        com.baidu.tbadk.core.util.am.e(this.bUm, i);
        if (this.bUD != null) {
            this.bUD.notifyDataSetChanged();
        }
        if (this.bUE != null) {
            this.bUE.notifyDataSetChanged();
        }
        if (this.bUw != null) {
            this.bUw.notifyDataSetChanged();
        }
        com.baidu.tbadk.core.util.am.i(this.bUn, i.c.cp_bg_line_d);
        com.baidu.tbadk.core.util.am.c(this.bUs, i.e.icon_search_ba);
        com.baidu.tbadk.core.util.am.b(this.bUr, i.c.cp_cont_i, 1);
        if (this.bUz != null) {
            getLayoutMode().k(this.bUz.getView());
        }
        if (this.bUy != null) {
            this.bUy.onChangeSkinType(i);
        }
        ic(i);
    }

    private void ic(int i) {
        if (this.bUA != null) {
            this.bUA.setBackgroundColor(com.baidu.tbadk.core.util.am.getColor(i.c.cp_bg_line_d));
        }
        if (this.bUY != null) {
            this.bUY.setBackgroundColor(com.baidu.tbadk.core.util.am.getColor(i.c.cp_bg_line_b));
        }
        if (this.bUZ != null) {
            getLayoutMode().k(this.bUZ);
        }
        if (this.bVa != null) {
            ((TextView) this.bVa.findViewById(i.f.home_bt_search_footer)).setTextColor(com.baidu.tbadk.core.util.am.getColor(i.c.s_actionbar_text_line_color_s));
        }
        if (this.bVb != null) {
            for (View view : this.bVb) {
                com.baidu.tbadk.core.util.am.b((TextView) view.findViewById(i.f.home_lv_search_forum), i.c.cp_cont_b, 1);
                view.findViewById(i.f.home_dialog_lv_search_forum_divider).setBackgroundColor(com.baidu.tbadk.core.util.am.getColor(i.c.cp_bg_line_b));
                com.baidu.tbadk.core.util.am.i(view, i.e.addresslist_item_bg);
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
                    SquareSearchActivity.this.bUp.setText(this.mName);
                    SquareSearchActivity.this.bUp.requestFocus();
                    Selection.setSelection(SquareSearchActivity.this.bUp.getText(), this.mName.length());
                    return;
                }
                com.baidu.tieba.tbadkCore.util.m.lD(this.mName);
                SquareSearchActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(SquareSearchActivity.this.getActivity()).createNormalCfg(this.mName, FrsActivityConfig.FRS_FROM_SEARCH)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
        private com.baidu.tbadk.core.util.w afg = null;
        private BasicNameValuePair bVx;
        private String mUrl;

        public a(String str, BasicNameValuePair basicNameValuePair, boolean z) {
            this.mUrl = null;
            this.bVx = null;
            this.mUrl = str;
            this.bVx = basicNameValuePair;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.bUn, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(i.d.ds320));
            SquareSearchActivity.this.bUo.setVisibility(8);
            SquareSearchActivity.this.mNoDataView.setVisibility(8);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public ForumSuggestModel doInBackground(Object... objArr) {
            ForumSuggestModel forumSuggestModel = null;
            try {
                this.afg = new com.baidu.tbadk.core.util.w(this.mUrl);
                this.afg.a(this.bVx);
                String tG = this.afg.tG();
                if (tG == null) {
                    return null;
                }
                forumSuggestModel = ForumSuggestModel.parserJson(tG);
                SquareSearchActivity.this.bUL = this.bVx.getValue();
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
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.bUn);
            if (forumSuggestModel != null) {
                SquareSearchActivity.this.bUG = forumSuggestModel;
                SquareSearchActivity.this.refresh();
            }
            SquareSearchActivity.this.bUI = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afg != null) {
                this.afg.gJ();
                this.afg = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.bUn);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Object, Integer, com.baidu.tieba.postsearch.j> {
        private com.baidu.tbadk.core.util.w afg = null;
        private ArrayList<BasicNameValuePair> bVy;
        private String mUrl;

        public b(String str, ArrayList<BasicNameValuePair> arrayList) {
            this.mUrl = null;
            this.bVy = null;
            this.mUrl = str;
            this.bVy = arrayList;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.bUn, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(i.d.ds320));
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
                this.afg = new com.baidu.tbadk.core.util.w(this.mUrl);
                Iterator<BasicNameValuePair> it = this.bVy.iterator();
                while (it.hasNext()) {
                    this.afg.a(it.next());
                }
                String tG = this.afg.tG();
                if (!this.afg.uh().uY().uk() || tG == null) {
                    return null;
                }
                com.baidu.tieba.postsearch.j jVar2 = new com.baidu.tieba.postsearch.j();
                try {
                    jVar2.parseJson(tG);
                    if (tG != null && this.afg != null && this.afg.uh().uY().qV()) {
                        Iterator<BasicNameValuePair> it2 = this.bVy.iterator();
                        while (it2.hasNext()) {
                            BasicNameValuePair next = it2.next();
                            if ("word".equals(next.getName())) {
                                SquareSearchActivity.this.bUM = next.getValue();
                            }
                            if ("pn".equals(next.getName())) {
                                SquareSearchActivity.this.bUO = Integer.valueOf(next.getValue()).intValue();
                            }
                        }
                    }
                    if (this.afg.uh().uY().qV()) {
                        com.baidu.tieba.tbadkCore.util.m.lE(SquareSearchActivity.this.bUK);
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
            SquareSearchActivity.this.bUT = false;
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.bUn);
            SquareSearchActivity.this.bUE.notifyDataSetChanged();
            if (jVar == null || this.afg == null || !this.afg.uh().uY().uk()) {
                SquareSearchActivity.this.showToast(SquareSearchActivity.this.getPageContext().getString(i.h.neterror));
            } else if (this.afg.uh().uY().qV()) {
                SquareSearchActivity.this.bUH = jVar;
                SquareSearchActivity.this.refresh();
            } else {
                SquareSearchActivity.this.refresh();
            }
            SquareSearchActivity.this.bUJ = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            SquareSearchActivity.this.bUE.notifyDataSetChanged();
            if (this.afg != null) {
                this.afg.gJ();
                this.afg = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.bUn);
            SquareSearchActivity.this.bUJ = null;
            super.onCancelled();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!this.bUT && this.bUH != null && this.bUH.isHasMore()) {
            G(this.bUH.getCurrentPage() + 1, this.bUK);
            abB().startLoadData();
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

    private void abC() {
        this.bUV = new SearchPageFocusBar(getPageContext().getPageActivity());
        this.bUV.setVisibility(8);
        this.bUv.addFooterView(this.bUV, null, false);
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
