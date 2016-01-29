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
import com.baidu.tbadk.core.util.ax;
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
    private FragmentTabWidget aWm;
    private boolean ayG;
    private List<com.baidu.tieba.mainentrance.c> cvJ;
    private FragmentTabIndicator cvT;
    private LinearLayoutDetectsSoftKeyboard cvU;
    private FrameLayout cvV;
    private FrameLayout cvW;
    private EditText cvX;
    private TextView cvY;
    private TextView cvZ;
    private boolean cwA;
    private boolean cwC;
    private SearchPageFocusBar cwD;
    private ScrollView cwE;
    private SearchPageFocusBar cwF;
    private View cwG;
    private View cwH;
    private View cwI;
    private View cwK;
    private TextView cwL;
    private View cwM;
    private ImageView cwa;
    private View cwb;
    private View cwc;
    private ListView cwd;
    private com.baidu.tieba.mainentrance.b cwe;
    private List<g> cwf;
    private l cwg;
    private LinearLayout cwh;
    private PbListView cwi;
    private BdListView cwj;
    private com.baidu.tieba.mainentrance.a cwk;
    private com.baidu.tieba.postsearch.w cwl;
    private d cwm;
    private ForumSuggestModel cwn;
    private com.baidu.tieba.postsearch.k cwo;
    private a cwp;
    private b cwq;
    private String cws;
    private String cwt;
    private String cwu;
    private String cwv;
    private boolean cwy;
    private f mHotSearchInfo;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.o mNoDataView;
    private String mTopicInfoTitle;
    private boolean cwr = false;
    private int mMode = 0;
    private int cww = 0;
    private int cwx = -1;
    private boolean aut = true;
    private boolean cwz = true;
    private boolean cwB = false;
    private List<View> cwJ = new ArrayList();
    private Runnable cwN = new m(this);
    private final View.OnClickListener cwO = new x(this);
    private final com.baidu.adp.framework.listener.e cwP = new ai(this, 301001, true);
    private final HttpMessageListener cwQ = new an(this, CmdConfigHttp.FRS_HTTP_CMD, true);
    private CustomMessageListener cwR = new ao(this, CmdConfigCustom.CMD_READ_SEARCHPERSON_HISTORY);
    private CustomMessageListener cwS = new ap(this, CmdConfigCustom.CMD_WRITE_SEARCHPERSON_HISTORY);
    private HttpMessageListener cwT = new aq(this, CmdConfigHttp.SEARCH_FRIEND_CMD);
    private final Runnable cwU = new ar(this);
    private CustomMessageListener cwV = new as(this, CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA);
    private CustomMessageListener cwW = new n(this, CmdConfigCustom.GET_ALL_SEARCH_POST_DATA);
    private View.OnClickListener cwX = new o(this);
    private CustomMessageListener cwY = new p(this, CmdConfigCustom.CMD_ENTER_FORUM_INFO);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponsedMessage<?> responsedMessage, boolean z) {
        int error = responsedMessage.getError();
        String string = StringUtils.isNull(responsedMessage.getErrorString()) ? getResources().getString(t.j.neterror) : responsedMessage.getErrorString();
        boolean z2 = error < -13 || error > -10;
        if (error == 0) {
            this.cwr = true;
            sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createFlagCfg(this.cwv, FrsActivityConfig.FRS_FROM_SEARCH, 1)));
        } else if (z2 && z && error == 3) {
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(t.j.login_to_use), true, 11013)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), this.cwv)));
            }
        } else {
            showToast(string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean akm() {
        if (this.mMode == 0 && this.mHotSearchInfo != null) {
            if (this.mHotSearchInfo.LM() == 0) {
                jM(this.mHotSearchInfo.getName());
            } else if (this.mHotSearchInfo.LM() == 1) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "")));
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10355").aa("obj_name", this.mHotSearchInfo.getName()).r("obj_type", this.mHotSearchInfo.LM() == 0 ? 2 : 1));
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gA(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SEARCH_FRIEND_CMD);
        httpMessage.addParam("search_key", str);
        sendMessage(httpMessage);
    }

    private void IP() {
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
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), this.cwv)));
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
        IP();
        registerListener(this.cwR);
        registerListener(this.cwS);
        registerListener(this.cwV);
        registerListener(this.cwW);
        registerListener(this.cwT);
        registerListener(this.cwP);
        registerListener(this.cwQ);
        registerListener(this.cwY);
        this.cwC = com.baidu.tbadk.core.sharedPref.b.uO().getBoolean("search_post_show_dropmenu", true);
        if (SquareSearchActivityConfig.IS_SHOW_RECOMMEND_FORUM) {
            this.cwm = new d(this, this);
            this.cwm.akl();
            this.cwm.akk();
        }
        this.cwy = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mMode == 0 && this.cwr) {
            this.cwr = false;
            if (this.cwn != null && this.cwn.forum_list != null && this.cwn.forum_list.size() > 0) {
                akD();
                this.cwj.setAdapter((ListAdapter) this.cwk);
                this.cwk.jJ(this.cws);
                this.cwk.O(this.cwn.forum_list);
                this.cwk.notifyDataSetInvalidated();
            }
        } else if (this.mMode == 3) {
            aky();
        }
        this.aut = true;
        if (this.cwz) {
            this.mHandler.post(this.cwN);
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
        hideLoadingView(this.cvV);
        this.mHandler.removeCallbacks(this.cwN);
        akn();
    }

    public void akn() {
        this.mHandler.removeCallbacks(this.cwU);
        if (this.cwp != null) {
            this.cwp.cancel();
            this.cwp = null;
        }
        if (this.cwq != null) {
            this.cwq.cancel();
            this.cwq = null;
        }
    }

    private void init() {
        this.cvU = (LinearLayoutDetectsSoftKeyboard) findViewById(t.g.parent);
        this.cvU.setOnSoftKeyBoardShownListener(new q(this));
        this.cvU.setOnTouchListener(new r(this));
        LV();
        SG();
        this.cvV = (FrameLayout) findViewById(t.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(t.e.ds80)), null, null);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            this.cwE = (ScrollView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(t.h.home_searchbar_nodataview, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) this.cwE.findViewById(t.g.focusbar_nodata_root);
            this.cwF = (SearchPageFocusBar) linearLayout.findViewById(t.g.no_data_focusbar);
            linearLayout.addView(this.mNoDataView, 0);
            this.cwE.setOnTouchListener(new s(this));
            this.cvV.addView(this.cwE, this.cvV.getChildCount());
        } else {
            this.cvV.addView(this.mNoDataView, 0);
        }
        this.cvW = (FrameLayout) findViewById(t.g.home_search_list);
        aku();
        ako();
        akp();
        akq();
        this.cwb = findViewById(t.g.empty_search_result);
        this.cwK = this.cwb.findViewById(t.g.empty_result_divider_1);
        this.cwL = (TextView) this.cwb.findViewById(t.g.create_bar_guide);
        this.cwM = this.cwb.findViewById(t.g.empty_result_divider_2);
        akr();
        this.cvX.setText("");
        this.cvX.requestFocus();
        ShowSoftKeyPadDelay(this.cvX, 200);
        if (TbadkSettings.getInst().loadBoolean("search_mode", true)) {
            kh(0);
            akt();
            return;
        }
        kh(1);
    }

    private void SG() {
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new t(this));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, t.h.square_search_navigation_view, (View.OnClickListener) null);
        this.cwa = (ImageView) addCustomView.findViewById(t.g.search_bar_icon);
        this.cvX = (EditText) addCustomView.findViewById(t.g.home_et_search);
        this.cvY = (TextView) addCustomView.findViewById(t.g.home_bt_search_del);
        this.cvZ = (TextView) addCustomView.findViewById(t.g.home_bt_search_s);
        this.cvX.setOnFocusChangeListener(new u(this));
        this.cvZ.setText(getPageContext().getString(t.j.forward));
        this.cvZ.setOnClickListener(this.cwO);
        this.cvX.setOnEditorActionListener(new v(this));
        this.cvY.setOnClickListener(new w(this));
        this.cvX.addTextChangedListener(new y(this));
    }

    private void LV() {
        this.aWm = (FragmentTabWidget) findViewById(t.g.square_search_tab_widget);
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(t.e.ds32));
        fragmentTabIndicator.setGravity(17);
        fragmentTabIndicator.ayd = t.d.s_actionbar_text_color;
        fragmentTabIndicator.setText(getResources().getString(t.j.search_bar_text));
        this.cvT = new FragmentTabIndicator(getPageContext().getPageActivity());
        this.cvT.ayd = t.d.s_actionbar_text_color;
        this.cvT.setTextSize(0, getResources().getDimension(t.e.ds32));
        this.cvT.setGravity(17);
        this.cvT.setCompoundDrawablesRightResId(t.f.icon_toolbar_arrow_down);
        this.cvT.setCompoundDrawablePadding(getResources().getDimensionPixelSize(t.e.ds10));
        this.cvT.setText(getResources().getString(t.j.search_post_text));
        this.cvT.Ez();
        FragmentTabIndicator fragmentTabIndicator2 = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator2.ayd = t.d.s_actionbar_text_color;
        fragmentTabIndicator2.setTextSize(0, getResources().getDimension(t.e.ds32));
        fragmentTabIndicator2.setGravity(17);
        fragmentTabIndicator2.setText(getResources().getString(t.j.search_person));
        this.aWm.addView(fragmentTabIndicator);
        this.aWm.addView(this.cvT);
        this.aWm.addView(fragmentTabIndicator2);
        this.aWm.d(0, true);
        this.aWm.setTabSelectionListener(new z(this));
    }

    private void ako() {
        this.cwd = (ListView) findViewById(t.g.home_lv_search_history);
        if (this.cwh == null) {
            this.cwh = new LinearLayout(getPageContext().getPageActivity());
            this.cwh.setOrientation(1);
            this.cwh.setBackgroundColor(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_bg_line_d));
        }
        this.cwd.addFooterView(this.cwh);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            akJ();
        }
        this.cwe = new com.baidu.tieba.mainentrance.b(this);
        this.cwd.setAdapter((ListAdapter) this.cwe);
        this.cwe.x(new aa(this));
    }

    private void akp() {
        if (this.cwg == null) {
            this.cwg = new l(getPageContext());
            this.cwd.addHeaderView(this.cwg.ni());
        }
    }

    private void akq() {
        this.cwj = (BdListView) findViewById(t.g.home_lv_search_suggest);
        this.cwk = new com.baidu.tieba.mainentrance.a(this, null);
        this.cwl = new com.baidu.tieba.postsearch.w(getPageContext());
        this.cwj.setOnItemClickListener(new ab(this));
        ac acVar = new ac(this);
        this.cwj.setOnScrollListener(acVar);
        this.cwd.setOnScrollListener(acVar);
        this.cwj.setOnSrollToBottomListener(this);
    }

    private void akr() {
        this.cwc = findViewById(t.g.search_dropmenu);
        TextView textView = (TextView) this.cwc.findViewById(t.g.dropmenu_all_text);
        textView.setTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_link_tip_a));
        ImageView imageView = (ImageView) this.cwc.findViewById(t.g.dropmenu_all_icon);
        imageView.setImageDrawable(com.baidu.tbadk.core.util.ar.getDrawable(t.f.chx_tips_list_ok));
        imageView.setVisibility(0);
        TextView textView2 = (TextView) this.cwc.findViewById(t.g.dropmenu_thread_text);
        textView2.setTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_cont_c));
        ImageView imageView2 = (ImageView) this.cwc.findViewById(t.g.dropmenu_thread_icon);
        imageView2.setImageDrawable(com.baidu.tbadk.core.util.ar.getDrawable(t.f.chx_tips_list_ok));
        imageView2.setVisibility(8);
        this.cwc.findViewById(t.g.dropmenu_all_layout).setOnClickListener(new ad(this, textView, imageView, textView2, imageView2));
        this.cwc.findViewById(t.g.dropmenu_thread_layout).setOnClickListener(new ae(this, textView, imageView, textView2, imageView2));
        this.cwc.findViewById(t.g.dropmenu_lower_part).setOnClickListener(new af(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aks() {
        if (this.cvW.getVisibility() == 8 && this.mNoDataView.getVisibility() == 8 && this.cwb.getVisibility() == 8) {
            av(this.cwE);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dd(t.j.text_no_search_record));
        }
    }

    public void kh(int i) {
        switch (i) {
            case 0:
                if (this.mMode != 0) {
                    this.mMode = 0;
                    this.cvZ.setText(getPageContext().getString(t.j.forward));
                    akt();
                    akn();
                    akB();
                    if (this.cws.trim().length() > 0) {
                        akA();
                        return;
                    } else {
                        akw();
                        return;
                    }
                }
                return;
            case 1:
                if (this.mMode != 1) {
                    this.mMode = 1;
                    this.cvZ.setText(getPageContext().getString(t.j.search));
                    this.cvX.setHint(t.j.search_post_hint);
                    akn();
                    akB();
                    if (this.cws.trim().length() > 0) {
                        this.cwj.setVisibility(8);
                        K(1, this.cws);
                        return;
                    }
                    akx();
                    return;
                }
                return;
            case 2:
            default:
                return;
            case 3:
                if (this.mMode != 3) {
                    this.mMode = 3;
                    this.cwj.setVisibility(8);
                    this.cwb.setVisibility(8);
                    this.cwc.setVisibility(8);
                    this.cvZ.setText(t.j.search);
                    this.cvX.setHint(t.j.search_friend_tip);
                    akB();
                    akn();
                    aky();
                    return;
                }
                return;
        }
    }

    private void akt() {
        if (this.mHotSearchInfo == null) {
            this.cvX.setHint(t.j.search_bar);
        } else {
            this.cvX.setHint(UtilHelper.getFixedText(this.mHotSearchInfo.LL(), 12));
        }
    }

    private void aku() {
        long j = com.baidu.tbadk.core.sharedPref.b.uO().getLong("hot_search_id", 0L);
        if (j != 0) {
            this.mHotSearchInfo = new f();
            this.mHotSearchInfo.setId(j);
            this.mHotSearchInfo.setName(com.baidu.tbadk.core.sharedPref.b.uO().getString("hot_search_name", ""));
            this.mHotSearchInfo.jL(com.baidu.tbadk.core.sharedPref.b.uO().getString("hot_search_title", ""));
            this.mHotSearchInfo.bi(com.baidu.tbadk.core.sharedPref.b.uO().getLong("hot_search_type", 0L));
        }
    }

    public void akv() {
        jM(this.cvX.getText().toString().trim());
    }

    private void jM(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (com.baidu.adp.lib.util.i.iZ()) {
                this.cwv = str;
                this.aut = false;
                sendMessage(jN(str));
                return;
            }
            showToast(t.j.neterror);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akw() {
        this.cwj.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA));
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            eA(true);
            aw(this.cwF);
            aw(this.cwE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akx() {
        this.cwj.setVisibility(8);
        aw(this.cwD);
        aw(this.cwF);
        aw(this.cwE);
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aky() {
        this.cwj.setVisibility(8);
        aw(this.cwD);
        aw(this.cwF);
        aw(this.cwE);
        if (!this.ayG) {
            sendMessage(new RequestSearchPersonHistoryReadMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ArrayList<String> arrayList) {
        boolean z = false;
        if (b(i, arrayList) || c(i, arrayList) || d(i, arrayList)) {
            akF();
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dd(t.j.text_no_search_record));
            return;
        }
        akE();
        List arrayList2 = new ArrayList();
        if (i == 4) {
            arrayList2 = this.cwf;
        }
        a(i, arrayList, (this.cwf == null ? 0 : arrayList2.size()) >= 1);
        boolean z2 = i == 4;
        if (arrayList == null || arrayList.size() == 0) {
            z = true;
        }
        n(z2, z);
        if (i == 4) {
            akt();
        }
    }

    private void a(int i, ArrayList<String> arrayList, boolean z) {
        if (this.cwh != null) {
            this.cwh.removeAllViews();
            if (arrayList != null && !arrayList.isEmpty() && getActivity() != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                if (z) {
                    this.cwG = new View(pageActivity);
                    this.cwG.setBackgroundColor(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_bg_line_b));
                    layoutParams.height = com.baidu.adp.lib.util.k.c(pageActivity, t.e.ds12);
                    layoutParams.topMargin = com.baidu.adp.lib.util.k.c(pageActivity, t.e.ds14);
                    this.cwh.addView(this.cwG, layoutParams);
                }
                this.cwH = LayoutInflater.from(pageActivity).inflate(t.h.square_search_recommand_fourm_header, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                getLayoutMode().x(this.cwH);
                this.cwh.addView(this.cwH, layoutParams2);
                int size = arrayList.size();
                this.cwJ.clear();
                for (int i2 = 0; i2 < size; i2++) {
                    String str = arrayList.get(i2);
                    if (!TextUtils.isEmpty(str)) {
                        View inflate = LayoutInflater.from(pageActivity).inflate(t.h.home_dialog_search_item, (ViewGroup) null);
                        ((TextView) inflate.findViewById(t.g.home_lv_search_forum)).setText(str);
                        com.baidu.tbadk.core.util.ar.b((TextView) inflate.findViewById(t.g.home_lv_search_forum), t.d.cp_cont_b, 1);
                        inflate.findViewById(t.g.home_dialog_lv_search_forum_divider).setVisibility(8);
                        com.baidu.tbadk.core.util.ar.k(inflate, t.f.square_search_item_bg);
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                        inflate.setOnClickListener(new c(str));
                        this.cwJ.add(inflate);
                        this.cwh.addView(inflate, layoutParams3);
                    }
                }
                this.cwI = LayoutInflater.from(pageActivity).inflate(t.h.home_dialog_search_footer, (ViewGroup) null);
                ((TextView) this.cwI.findViewById(t.g.home_bt_search_footer)).setTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.s_actionbar_text_line_color_s));
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                this.cwI.setOnClickListener(new ag(this));
                this.cwh.addView(this.cwI, layoutParams4);
            }
        }
    }

    private void n(boolean z, boolean z2) {
        if (this.cwg != null) {
            this.cwg.clear();
            if (this.cwf != null && !this.cwf.isEmpty() && z) {
                this.cwg.setTitleText(this.mTopicInfoTitle);
                int size = this.cwf.size();
                if (size >= 1) {
                    int i = size <= 7 ? size : 7;
                    int i2 = i % 2 == 0 ? i - 1 : i;
                    for (int i3 = 0; i3 < i2; i3++) {
                        g gVar = (g) com.baidu.tbadk.core.util.x.b(this.cwf, i3);
                        if (gVar != null) {
                            this.cwg.a(gVar, i3).setOnClickListener(this.cwX);
                        }
                    }
                    this.cwg.a(null, i2).setOnClickListener(new ah(this));
                    this.cwg.show();
                }
            }
        }
    }

    private boolean b(int i, ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && (this.cvJ == null || this.cvJ.size() <= 2) && 4 == i && this.mMode == 0 && (this.cwf == null || this.cwf.size() <= 2);
    }

    private boolean c(int i, ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && i == 5 && this.mMode != 5;
    }

    private boolean d(int i, ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && i == 6 && this.mMode != 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akz() {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).cE(getPageContext().getString(t.j.alert_clean_history)).a(getPageContext().getString(t.j.clear_all_text), new aj(this)).b(getPageContext().getString(t.j.alert_no_button), new al(this)).b(getPageContext()).uj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akA() {
        this.cvW.setVisibility(8);
        if (this.cws != null) {
            if (this.cws.equals(this.cwt)) {
                refresh();
                return;
            }
            aw(this.cwD);
            aw(this.cwF);
            aw(this.cwE);
            this.mHandler.removeCallbacks(this.cwU);
            this.mHandler.postDelayed(this.cwU, 500L);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v5 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void K(int i, String str) {
        this.cwd.setVisibility(8);
        if (str != null && str.trim().length() > 0) {
            int i2 = this.cwA ? 1 : 0;
            if (str.equals(this.cwu) && i == this.cww && this.cwx == i2) {
                refresh();
                return;
            }
            this.cwx = i2;
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append(TbConfig.SERVER_ADDRESS);
            stringBuffer.append(TbConfig.POST_SEARCH_URL);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("word", str));
            arrayList.add(new BasicNameValuePair("pn", String.valueOf(i)));
            arrayList.add(new BasicNameValuePair("rn", String.valueOf(50)));
            arrayList.add(new BasicNameValuePair("only_thread", new StringBuilder().append(i2).toString()));
            arrayList.add(new BasicNameValuePair("st_type", "search_post"));
            akn();
            this.cwq = new b(stringBuffer.toString(), arrayList);
            this.cwq.setPriority(3);
            this.cwq.execute(new Object[0]);
            this.cwB = true;
        }
    }

    private FRSPageRequestMessage jN(String str) {
        FRSPageRequestMessage fRSPageRequestMessage = new FRSPageRequestMessage();
        fRSPageRequestMessage.setKw(str);
        fRSPageRequestMessage.setPn(1);
        if (com.baidu.tbadk.core.l.rn().rt()) {
            fRSPageRequestMessage.setRn(35);
        } else {
            fRSPageRequestMessage.setRn(50);
        }
        fRSPageRequestMessage.setWithGroup(1);
        int K = com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity());
        int L = com.baidu.adp.lib.util.k.L(getPageContext().getPageActivity());
        float f = K / 320.0f;
        int i = ax.wg().wi() ? 2 : 1;
        fRSPageRequestMessage.setScrW(K);
        fRSPageRequestMessage.setScrH(L);
        fRSPageRequestMessage.setScrDip(f);
        fRSPageRequestMessage.setqType(i);
        return fRSPageRequestMessage;
    }

    private void akB() {
        if (this.cwj != null) {
            this.cwj.setNextPage(null);
        }
        if (this.cwl != null) {
            this.cwl.clear();
            this.cwl.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        int i;
        int i2 = 0;
        try {
            if (this.mMode == 0) {
                if (this.cwn != null) {
                    if (this.cwn.forum_list != null && this.cwn.forum_list.size() > 0) {
                        akD();
                        this.cwj.setAdapter((ListAdapter) this.cwk);
                        this.cwk.jJ(this.cws);
                        this.cwk.O(this.cwn.forum_list);
                        this.cwk.notifyDataSetInvalidated();
                        return;
                    }
                    aw(this.cwE);
                    akH();
                    akC();
                }
            } else if (this.cwo != null) {
                List<k.a> list = this.cwo.daF;
                if (list != null && list.size() > 0) {
                    akD();
                    if (this.cwo.pf() == 1) {
                        this.cwj.setVisibility(0);
                        this.cwl.clear();
                        this.cwj.setAdapter((ListAdapter) this.cwl);
                        this.cwj.setNextPage(akI());
                    }
                    if (!this.cwo.isHasMore()) {
                        akI().setText(getResources().getString(t.j.list_no_more));
                        akI().xc();
                    }
                    int bH = this.cwl.bH(list);
                    if (bH > 0) {
                        i = this.cwj.getFirstVisiblePosition() - bH;
                        View childAt = this.cwj.getChildAt(0);
                        if (childAt != null) {
                            i2 = childAt.getTop();
                        }
                    } else {
                        i = 0;
                    }
                    this.cwl.notifyDataSetChanged();
                    if (bH > 0) {
                        this.cwj.setSelectionFromTop(i, i2);
                    }
                    if (this.cwC) {
                        this.cwc.setVisibility(0);
                        this.cwC = false;
                        com.baidu.tbadk.core.sharedPref.b.uO().putBoolean("search_post_show_dropmenu", false);
                    }
                } else if (this.mNoDataView.getVisibility() != 0) {
                    akF();
                    aw(this.cwF);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dd(t.j.text_no_suggest));
                }
            } else if (this.mNoDataView.getVisibility() != 0) {
                akF();
                aw(this.cwF);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dd(t.j.text_no_suggest));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void akC() {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_cont_h));
        TextView textView = (TextView) this.cwb.findViewById(t.g.no_bar_found);
        textView.setTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_cont_c));
        TextView textView2 = (TextView) this.cwb.findViewById(t.g.create_bar_guide);
        textView2.setTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_cont_b));
        String str = "";
        if (this.cws != null) {
            str = this.cws.length() > 6 ? String.valueOf(this.cws.substring(0, 6)) + "..." : this.cws;
        }
        String format = String.format(getPageContext().getString(t.j.empty_search_result_format), str);
        String format2 = String.format(getPageContext().getString(t.j.create_bar_guide_format), str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
        spannableStringBuilder.setSpan(foregroundColorSpan, 4, format.length() - 2, 33);
        textView.setText(spannableStringBuilder);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(format2);
        spannableStringBuilder2.setSpan(foregroundColorSpan, 5, format2.length() - 5, 33);
        textView2.setText(spannableStringBuilder2);
        Drawable drawable = com.baidu.tbadk.core.util.ar.getDrawable(t.f.icon_search_list_add);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        textView2.setCompoundDrawablePadding(com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), t.e.ds10));
        textView2.setCompoundDrawables(drawable, null, null, null);
        textView2.setOnClickListener(new am(this));
    }

    private void akD() {
        this.cvW.setVisibility(0);
        this.cwj.setVisibility(0);
        this.cwd.setVisibility(8);
        aw(this.cwE);
        this.mNoDataView.setVisibility(8);
        this.cwc.setVisibility(8);
        this.cwb.setVisibility(8);
    }

    private void akE() {
        this.cvW.setVisibility(0);
        this.cwd.setVisibility(0);
        if (this.mMode == 0) {
            av(this.cwD);
        } else {
            aw(this.cwD);
        }
        this.cwj.setVisibility(8);
        aw(this.cwE);
        this.mNoDataView.setVisibility(8);
        this.cwc.setVisibility(8);
        this.cwb.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akF() {
        this.cvW.setVisibility(8);
        this.cwj.setVisibility(8);
        this.cwd.setVisibility(8);
        av(this.cwE);
        this.mNoDataView.setVisibility(0);
        if (this.mMode == 0) {
            av(this.cwF);
        }
        this.cwc.setVisibility(8);
        this.cwb.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akG() {
        aw(this.cwE);
        this.cwc.setVisibility(0);
    }

    private void akH() {
        this.cvW.setVisibility(8);
        this.cwj.setVisibility(8);
        this.cwd.setVisibility(8);
        aw(this.cwE);
        this.mNoDataView.setVisibility(8);
        this.cwc.setVisibility(8);
        this.cwb.setVisibility(0);
        if (CreateBarActivityConfig.IS_SUPPORT_CREATE_BAR && this.cws != null && this.cws.length() <= 30) {
            ez(true);
        } else {
            ez(false);
        }
    }

    private void ez(boolean z) {
        if (!z) {
            this.cwK.setVisibility(8);
            this.cwL.setVisibility(8);
            this.cwM.setVisibility(8);
            return;
        }
        this.cwK.setVisibility(0);
        this.cwL.setVisibility(0);
        this.cwM.setVisibility(0);
    }

    private PbListView akI() {
        if (this.cwi == null) {
            this.cwi = new PbListView(getPageContext().getPageActivity());
            this.cwi.ni();
        }
        return this.cwi;
    }

    @Override // com.baidu.tieba.mainentrance.d.a
    public void jK(String str) {
        this.cwy = true;
        this.cvJ = new ArrayList();
        this.cwf = new ArrayList();
        akw();
    }

    @Override // com.baidu.tieba.mainentrance.d.a
    public void a(List<com.baidu.tieba.mainentrance.c> list, List<g> list2, f fVar, String str) {
        this.cwy = true;
        hideLoadingView(this.cvV);
        if (list == null || list.isEmpty()) {
            this.cvJ = new ArrayList();
        } else {
            this.cvJ = list;
        }
        if (list2 == null) {
            this.cwf = new ArrayList();
        } else {
            this.cwf = list2;
        }
        if (!StringUtils.isNULL(str)) {
            this.mTopicInfoTitle = str;
        } else {
            this.mTopicInfoTitle = "";
        }
        a(fVar);
        this.mHotSearchInfo = fVar;
        akw();
    }

    private void a(f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.sharedPref.b.uO().putLong("hot_search_id", fVar.getId());
            com.baidu.tbadk.core.sharedPref.b.uO().putString("hot_search_name", fVar.getName());
            com.baidu.tbadk.core.sharedPref.b.uO().putString("hot_search_title", fVar.LL());
            com.baidu.tbadk.core.sharedPref.b.uO().putLong("hot_search_type", fVar.LM());
            return;
        }
        com.baidu.tbadk.core.sharedPref.b.uO().putLong("hot_search_id", 0L);
        com.baidu.tbadk.core.sharedPref.b.uO().putString("hot_search_name", "");
        com.baidu.tbadk.core.sharedPref.b.uO().putString("hot_search_title", "");
        com.baidu.tbadk.core.sharedPref.b.uO().putLong("hot_search_type", 0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aWm.onChangeSkinType(i);
        getLayoutMode().ac(i == 1);
        getLayoutMode().x(this.cvU);
        getLayoutMode().x(this.cwb);
        com.baidu.tbadk.core.util.ar.g(this.cvU, i);
        if (this.cwk != null) {
            this.cwk.notifyDataSetChanged();
        }
        if (this.cwl != null) {
            this.cwl.notifyDataSetChanged();
        }
        if (this.cwe != null) {
            this.cwe.notifyDataSetChanged();
        }
        com.baidu.tbadk.core.util.ar.k(this.cvV, t.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.ar.c(this.cwa, t.f.icon_search_ba);
        com.baidu.tbadk.core.util.ar.b(this.cvZ, t.d.cp_cont_i, 1);
        if (this.cwg != null) {
            this.cwg.onChangeSkinType(i);
        }
        ki(i);
    }

    private void ki(int i) {
        if (this.cwh != null) {
            this.cwh.setBackgroundColor(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_bg_line_d));
        }
        if (this.cwG != null) {
            this.cwG.setBackgroundColor(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_bg_line_b));
        }
        if (this.cwH != null) {
            getLayoutMode().x(this.cwH);
        }
        if (this.cwI != null) {
            ((TextView) this.cwI.findViewById(t.g.home_bt_search_footer)).setTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.s_actionbar_text_line_color_s));
        }
        if (this.cwJ != null) {
            for (View view : this.cwJ) {
                com.baidu.tbadk.core.util.ar.b((TextView) view.findViewById(t.g.home_lv_search_forum), t.d.cp_cont_b, 1);
                view.findViewById(t.g.home_dialog_lv_search_forum_divider).setBackgroundColor(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_bg_line_b));
                com.baidu.tbadk.core.util.ar.k(view, t.f.addresslist_item_bg);
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
            com.baidu.tbadk.core.c.b.d(getPageContext().getPageActivity(), 1);
        } else {
            com.baidu.tbadk.core.c.b.d(getPageContext().getPageActivity(), 2);
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
                        SquareSearchActivity.this.gA(this.mName);
                        return;
                    }
                    SquareSearchActivity.this.K(1, this.mName);
                    SquareSearchActivity.this.cvX.setText(this.mName);
                    SquareSearchActivity.this.cvX.requestFocus();
                    Selection.setSelection(SquareSearchActivity.this.cvX.getText(), this.mName.length());
                    return;
                }
                com.baidu.tieba.tbadkCore.util.m.mO(this.mName);
                SquareSearchActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(SquareSearchActivity.this.getActivity()).createNormalCfg(this.mName, FrsActivityConfig.FRS_FROM_SEARCH)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
        private com.baidu.tbadk.core.util.aa aiG = null;
        private BasicNameValuePair cxf;
        private String mUrl;

        public a(String str, BasicNameValuePair basicNameValuePair, boolean z) {
            this.mUrl = null;
            this.cxf = null;
            this.mUrl = str;
            this.cxf = basicNameValuePair;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!com.baidu.adp.lib.util.i.iZ()) {
                SquareSearchActivity.this.av(SquareSearchActivity.this.mNoDataView);
                return;
            }
            SquareSearchActivity.this.aw(SquareSearchActivity.this.mNoDataView);
            SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.cvV, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(t.e.ds320));
            SquareSearchActivity.this.cvW.setVisibility(8);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: v */
        public ForumSuggestModel doInBackground(Object... objArr) {
            ForumSuggestModel forumSuggestModel = null;
            if (com.baidu.adp.lib.util.i.iZ()) {
                try {
                    this.aiG = new com.baidu.tbadk.core.util.aa(this.mUrl);
                    this.aiG.a(this.cxf);
                    String uZ = this.aiG.uZ();
                    if (uZ != null) {
                        forumSuggestModel = ForumSuggestModel.parserJson(uZ);
                        SquareSearchActivity.this.cwt = this.cxf.getValue();
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
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.cvV);
            if (forumSuggestModel == null) {
                SquareSearchActivity.this.av(SquareSearchActivity.this.mNoDataView);
            } else {
                SquareSearchActivity.this.aw(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.cwn = forumSuggestModel;
                SquareSearchActivity.this.refresh();
            }
            SquareSearchActivity.this.cwp = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiG != null) {
                this.aiG.gT();
                this.aiG = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.cvV);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Object, Integer, com.baidu.tieba.postsearch.k> {
        private com.baidu.tbadk.core.util.aa aiG = null;
        private ArrayList<BasicNameValuePair> cxg;
        private String mUrl;

        public b(String str, ArrayList<BasicNameValuePair> arrayList) {
            this.mUrl = null;
            this.cxg = null;
            this.mUrl = str;
            this.cxg = arrayList;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!com.baidu.adp.lib.util.i.iZ()) {
                SquareSearchActivity.this.av(SquareSearchActivity.this.mNoDataView);
                return;
            }
            SquareSearchActivity.this.aw(SquareSearchActivity.this.mNoDataView);
            SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.cvV, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(t.e.ds320));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: w */
        public com.baidu.tieba.postsearch.k doInBackground(Object... objArr) {
            Exception exc;
            com.baidu.tieba.postsearch.k kVar;
            if (com.baidu.adp.lib.util.i.iZ()) {
                try {
                    this.aiG = new com.baidu.tbadk.core.util.aa(this.mUrl);
                    Iterator<BasicNameValuePair> it = this.cxg.iterator();
                    while (it.hasNext()) {
                        this.aiG.a(it.next());
                    }
                    String uZ = this.aiG.uZ();
                    if (!this.aiG.vB().ww().vE() || uZ == null) {
                        kVar = null;
                    } else {
                        com.baidu.tieba.postsearch.k kVar2 = new com.baidu.tieba.postsearch.k();
                        try {
                            kVar2.parseJson(uZ);
                            if (uZ != null && this.aiG != null && this.aiG.vB().ww().rl()) {
                                Iterator<BasicNameValuePair> it2 = this.cxg.iterator();
                                while (it2.hasNext()) {
                                    BasicNameValuePair next = it2.next();
                                    if ("word".equals(next.getName())) {
                                        SquareSearchActivity.this.cwu = next.getValue();
                                    }
                                    if ("pn".equals(next.getName())) {
                                        SquareSearchActivity.this.cww = Integer.valueOf(next.getValue()).intValue();
                                    }
                                }
                            }
                            if (this.aiG.vB().ww().rl()) {
                                com.baidu.tieba.tbadkCore.util.m.mP(SquareSearchActivity.this.cws);
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
            SquareSearchActivity.this.cwB = false;
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.cvV);
            SquareSearchActivity.this.cwl.notifyDataSetChanged();
            if (kVar == null) {
                SquareSearchActivity.this.av(SquareSearchActivity.this.mNoDataView);
            } else {
                SquareSearchActivity.this.aw(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.cwo = kVar;
                SquareSearchActivity.this.refresh();
            }
            SquareSearchActivity.this.cwq = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            SquareSearchActivity.this.cwl.notifyDataSetChanged();
            if (this.aiG != null) {
                this.aiG.gT();
                this.aiG = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.cvV);
            SquareSearchActivity.this.cwq = null;
            super.onCancelled();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void nv() {
        if (!this.cwB && this.cwo != null && this.cwo.isHasMore()) {
            K(this.cwo.pf() + 1, this.cws);
            akI().xb();
        }
    }

    private void eA(boolean z) {
        if (TbadkCoreApplication.isLogin()) {
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(CmdConfigCustom.CMD_REQUEST_ENTER_FORUM_MESSAGE, true));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(CmdConfigCustom.CMD_REQUEST_ENTER_FORUM_MESSAGE, false));
        }
    }

    private void akJ() {
        this.cwD = new SearchPageFocusBar(getPageContext().getPageActivity());
        this.cwD.setVisibility(8);
        this.cwd.addFooterView(this.cwD, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(View view) {
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aw(View view) {
        if (view != null) {
            view.setVisibility(8);
        }
    }
}
