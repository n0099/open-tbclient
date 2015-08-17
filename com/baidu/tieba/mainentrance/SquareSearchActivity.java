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
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.RequestEnterForumDataMessage;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.ar;
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
    private boolean avj;
    private List<com.baidu.tieba.mainentrance.c> bPO;
    private FragmentTabWidget bPW;
    private FragmentTabIndicator bPX;
    private LinearLayoutDetectsSoftKeyboard bPY;
    private FrameLayout bPZ;
    private boolean bQB;
    private boolean bQD;
    private SearchPageFocusBar bQE;
    private ScrollView bQF;
    private SearchPageFocusBar bQG;
    private View bQH;
    private TextView bQI;
    private View bQJ;
    private View bQL;
    private TextView bQM;
    private View bQN;
    private FrameLayout bQa;
    private EditText bQb;
    private TextView bQc;
    private TextView bQd;
    private ImageView bQe;
    private View bQf;
    private View bQg;
    private ListView bQh;
    private com.baidu.tieba.mainentrance.b bQi;
    private LinearLayout bQj;
    private PbListView bQk;
    private BdListView bQl;
    private com.baidu.tieba.mainentrance.a bQm;
    private com.baidu.tieba.postsearch.v bQn;
    private d bQo;
    private ForumSuggestModel bQp;
    private com.baidu.tieba.postsearch.j bQq;
    private a bQr;
    private b bQs;
    private String bQt;
    private String bQu;
    private String bQv;
    private String bQw;
    private boolean bQz;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.u mNoDataView;
    private int mMode = 0;
    private int bQx = 0;
    private int bQy = -1;
    private boolean arn = true;
    private boolean bQA = true;
    private boolean bQC = false;
    private List<View> bQK = new ArrayList();
    private Runnable bQO = new j(this);
    private final View.OnClickListener bQP = new u(this);
    private final com.baidu.adp.framework.listener.e bQQ = new ag(this, 301001, true);
    private final HttpMessageListener bQR = new ah(this, CmdConfigHttp.FRS_HTTP_CMD, true);
    private CustomMessageListener bQS = new ai(this, CmdConfigCustom.CMD_READ_SEARCHPERSON_HISTORY);
    private CustomMessageListener bQT = new aj(this, CmdConfigCustom.CMD_WRITE_SEARCHPERSON_HISTORY);
    private HttpMessageListener bQU = new ak(this, CmdConfigHttp.SEARCH_FRIEND_CMD);
    private final Runnable bQV = new al(this);
    private CustomMessageListener bQW = new am(this, CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA);
    private CustomMessageListener bQX = new k(this, CmdConfigCustom.GET_ALL_SEARCH_POST_DATA);
    private CustomMessageListener bQY = new l(this, CmdConfigCustom.CMD_ENTER_FORUM_INFO);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponsedMessage<?> responsedMessage, boolean z) {
        int error = responsedMessage.getError();
        String string = StringUtils.isNull(responsedMessage.getErrorString()) ? getResources().getString(i.C0057i.neterror) : responsedMessage.getErrorString();
        boolean z2 = error < -13 || error > -10;
        if (error == 0) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createFlagCfg(this.bQw, FrsActivityConfig.FRS_FROM_SEARCH, 1)));
        } else if (z2 && z && error == 3) {
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(i.C0057i.login_to_use), true, 11013)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), this.bQw)));
            }
        } else {
            showToast(string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fX(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SEARCH_FRIEND_CMD);
        httpMessage.addParam("search_key", str);
        sendMessage(httpMessage);
    }

    private void GQ() {
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
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), this.bQw)));
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
        GQ();
        registerListener(this.bQS);
        registerListener(this.bQT);
        registerListener(this.bQW);
        registerListener(this.bQX);
        registerListener(this.bQU);
        registerListener(this.bQQ);
        registerListener(this.bQR);
        registerListener(this.bQY);
        this.bQD = com.baidu.tbadk.core.sharedPref.b.ts().getBoolean("search_post_show_dropmenu", true);
        if (SquareSearchActivityConfig.IS_SHOW_RECOMMEND_FORUM) {
            this.bQo = new d(this, this);
            this.bQo.ZQ();
            this.bQo.ZP();
        }
        this.bQz = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.arn = true;
        if (this.bQA) {
            this.mHandler.post(this.bQO);
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
        hideLoadingView(this.bPZ);
        this.mHandler.removeCallbacks(this.bQO);
        Gt();
    }

    public void Gt() {
        this.mHandler.removeCallbacks(this.bQV);
        if (this.bQr != null) {
            this.bQr.cancel();
            this.bQr = null;
        }
        if (this.bQs != null) {
            this.bQs.cancel();
            this.bQs = null;
        }
    }

    private void init() {
        this.bPY = (LinearLayoutDetectsSoftKeyboard) findViewById(i.f.parent);
        this.bPY.setOnSoftKeyBoardShownListener(new m(this));
        this.bPY.setOnTouchListener(new n(this));
        Oj();
        Oi();
        this.bPZ = (FrameLayout) findViewById(i.f.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(i.d.ds80)), null, null);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            this.bQF = (ScrollView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(i.g.home_searchbar_nodataview, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) this.bQF.findViewById(i.f.focusbar_nodata_root);
            this.bQG = (SearchPageFocusBar) linearLayout.findViewById(i.f.no_data_focusbar);
            linearLayout.addView(this.mNoDataView, 0);
            this.bQF.setOnTouchListener(new o(this));
            this.bPZ.addView(this.bQF, this.bPZ.getChildCount());
        } else {
            this.bPZ.addView(this.mNoDataView);
        }
        this.bQa = (FrameLayout) findViewById(i.f.home_search_list);
        ZR();
        ZS();
        this.bQf = findViewById(i.f.empty_search_result);
        this.bQL = this.bQf.findViewById(i.f.empty_result_divider_1);
        this.bQM = (TextView) this.bQf.findViewById(i.f.create_bar_guide);
        this.bQN = this.bQf.findViewById(i.f.empty_result_divider_2);
        ZT();
        this.bQb.setText("");
        this.bQb.requestFocus();
        ShowSoftKeyPadDelay(this.bQb, 200);
        if (TbadkSettings.getInst().loadBoolean("search_mode", true)) {
            hJ(0);
        } else {
            hJ(1);
        }
    }

    private void Oi() {
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new p(this));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, i.g.square_search_navigation_view, (View.OnClickListener) null);
        this.bQe = (ImageView) addCustomView.findViewById(i.f.search_bar_icon);
        this.bQb = (EditText) addCustomView.findViewById(i.f.home_et_search);
        this.bQc = (TextView) addCustomView.findViewById(i.f.home_bt_search_del);
        this.bQd = (TextView) addCustomView.findViewById(i.f.home_bt_search_s);
        this.bQb.setOnFocusChangeListener(new q(this));
        this.bQd.setText(getPageContext().getString(i.C0057i.enter_forum));
        this.bQd.setOnClickListener(this.bQP);
        this.bQb.setOnEditorActionListener(new r(this));
        this.bQc.setOnClickListener(new s(this));
        this.bQb.addTextChangedListener(new t(this));
    }

    private void Oj() {
        this.bPW = (FragmentTabWidget) findViewById(i.f.square_search_tab_widget);
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(i.d.ds32));
        fragmentTabIndicator.setGravity(17);
        fragmentTabIndicator.auG = i.c.main_bottom_button_color;
        fragmentTabIndicator.setText(getResources().getString(i.C0057i.search_bar_text));
        this.bPX = new FragmentTabIndicator(getPageContext().getPageActivity());
        this.bPX.auG = i.c.main_bottom_button_color;
        this.bPX.setTextSize(0, getResources().getDimension(i.d.ds32));
        this.bPX.setGravity(17);
        this.bPX.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_down);
        this.bPX.setText(getResources().getString(i.C0057i.search_post_text));
        FragmentTabIndicator fragmentTabIndicator2 = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator2.auG = i.c.main_bottom_button_color;
        fragmentTabIndicator2.setTextSize(0, getResources().getDimension(i.d.ds32));
        fragmentTabIndicator2.setGravity(17);
        fragmentTabIndicator2.setText(getResources().getString(i.C0057i.search_person));
        this.bPW.addView(fragmentTabIndicator);
        this.bPW.addView(this.bPX);
        this.bPW.addView(fragmentTabIndicator2);
        this.bPW.d(0, true);
        this.bPW.setTabSelectionListener(new v(this));
    }

    private void ZR() {
        this.bQh = (ListView) findViewById(i.f.home_lv_search_history);
        if (this.bQj == null) {
            this.bQj = new LinearLayout(getPageContext().getPageActivity());
            this.bQj.setOrientation(1);
            this.bQj.setBackgroundColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_bg_line_d));
        }
        this.bQh.addFooterView(this.bQj);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            aaj();
        }
        this.bQi = new com.baidu.tieba.mainentrance.b(this);
        this.bQh.setAdapter((ListAdapter) this.bQi);
        this.bQh.setOnItemClickListener(new w(this));
    }

    private void ZS() {
        this.bQl = (BdListView) findViewById(i.f.home_lv_search_suggest);
        this.bQm = new com.baidu.tieba.mainentrance.a(this, null);
        this.bQn = new com.baidu.tieba.postsearch.v(getPageContext());
        this.bQl.setOnItemClickListener(new x(this));
        y yVar = new y(this);
        this.bQl.setOnScrollListener(yVar);
        this.bQh.setOnScrollListener(yVar);
        this.bQl.setOnSrollToBottomListener(this);
    }

    private void ZT() {
        this.bQg = findViewById(i.f.search_dropmenu);
        TextView textView = (TextView) this.bQg.findViewById(i.f.dropmenu_all_text);
        textView.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_link_tip_a));
        ImageView imageView = (ImageView) this.bQg.findViewById(i.f.dropmenu_all_icon);
        imageView.setImageDrawable(com.baidu.tbadk.core.util.al.getDrawable(i.e.chx_tips_list_ok));
        imageView.setVisibility(0);
        TextView textView2 = (TextView) this.bQg.findViewById(i.f.dropmenu_thread_text);
        textView2.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_c));
        ImageView imageView2 = (ImageView) this.bQg.findViewById(i.f.dropmenu_thread_icon);
        imageView2.setImageDrawable(com.baidu.tbadk.core.util.al.getDrawable(i.e.chx_tips_list_ok));
        imageView2.setVisibility(8);
        this.bQg.findViewById(i.f.dropmenu_all_layout).setOnClickListener(new z(this, textView, imageView, textView2, imageView2));
        this.bQg.findViewById(i.f.dropmenu_thread_layout).setOnClickListener(new aa(this, textView, imageView, textView2, imageView2));
        this.bQg.findViewById(i.f.dropmenu_lower_part).setOnClickListener(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZU() {
        if (this.bQa.getVisibility() == 8 && this.mNoDataView.getVisibility() == 8 && this.bQf.getVisibility() == 8) {
            P(this.bQF);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cD(i.C0057i.text_no_search_record));
        }
    }

    public void hJ(int i) {
        switch (i) {
            case 0:
                if (this.mMode != 0) {
                    this.mMode = 0;
                    this.bQd.setText(getPageContext().getString(i.C0057i.enter_forum));
                    this.bQb.setHint(i.C0057i.search_bar);
                    Gt();
                    aab();
                    if (this.bQt.trim().length() > 0) {
                        aaa();
                        return;
                    } else {
                        ZW();
                        return;
                    }
                }
                return;
            case 1:
                if (this.mMode != 1) {
                    this.mMode = 1;
                    this.bQd.setText(getPageContext().getString(i.C0057i.search));
                    this.bQb.setHint(i.C0057i.search_post_hint);
                    Gt();
                    aab();
                    if (this.bQt.trim().length() > 0) {
                        this.bQl.setVisibility(8);
                        G(1, this.bQt);
                        return;
                    }
                    ZX();
                    return;
                }
                return;
            case 2:
            default:
                return;
            case 3:
                if (this.mMode != 3) {
                    this.mMode = 3;
                    this.bQl.setVisibility(8);
                    this.bQf.setVisibility(8);
                    this.bQg.setVisibility(8);
                    this.bQd.setText(i.C0057i.search);
                    this.bQb.setHint(i.C0057i.search_friend_tip);
                    aab();
                    Gt();
                    ZY();
                    return;
                }
                return;
        }
    }

    public void ZV() {
        String trim = this.bQb.getText().toString().trim();
        if (!TextUtils.isEmpty(trim)) {
            if (com.baidu.adp.lib.util.i.iO()) {
                this.bQw = trim;
                this.arn = false;
                sendMessage(iB(trim));
                return;
            }
            showToast(i.C0057i.neterror);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZW() {
        this.bQl.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA));
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            dG(true);
            Q(this.bQG);
            Q(this.bQF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZX() {
        this.bQl.setVisibility(8);
        Q(this.bQE);
        Q(this.bQG);
        Q(this.bQF);
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZY() {
        this.bQl.setVisibility(8);
        Q(this.bQE);
        Q(this.bQG);
        Q(this.bQF);
        if (!this.avj) {
            sendMessage(new RequestSearchPersonHistoryReadMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ArrayList<String> arrayList) {
        if (b(i, arrayList) || c(i, arrayList) || d(i, arrayList)) {
            aaf();
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cD(i.C0057i.text_no_search_record));
            return;
        }
        aae();
        List<com.baidu.tieba.mainentrance.c> arrayList2 = new ArrayList<>();
        if (i == 4) {
            arrayList2 = this.bPO;
        }
        a(i, arrayList, (this.bPO == null ? 0 : arrayList2.size()) != 0);
        this.bQi.aP(arrayList2);
        this.bQi.notifyDataSetChanged();
    }

    private void a(int i, ArrayList<String> arrayList, boolean z) {
        if (this.bQj != null) {
            this.bQj.removeAllViews();
            if (arrayList != null && !arrayList.isEmpty() && getActivity() != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                if (z) {
                    this.bQH = new View(pageActivity);
                    this.bQH.setBackgroundColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_bg_line_b));
                    layoutParams.height = com.baidu.adp.lib.util.k.d(pageActivity, i.d.ds20);
                    this.bQj.addView(this.bQH, layoutParams);
                }
                this.bQI = (TextView) LayoutInflater.from(pageActivity).inflate(i.g.search_history_title, (ViewGroup) null);
                this.bQI.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_c));
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.leftMargin = com.baidu.adp.lib.util.k.d(pageActivity, i.d.ds30);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.d(pageActivity, i.d.ds36);
                layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.d(pageActivity, i.d.ds10);
                this.bQj.addView(this.bQI, layoutParams2);
                int size = arrayList.size();
                this.bQK.clear();
                for (int i2 = 0; i2 < size; i2++) {
                    String str = arrayList.get(i2);
                    if (!TextUtils.isEmpty(str)) {
                        View inflate = LayoutInflater.from(pageActivity).inflate(i.g.home_dialog_search_item, (ViewGroup) null);
                        ((TextView) inflate.findViewById(i.f.home_lv_search_forum)).setText(str);
                        com.baidu.tbadk.core.util.al.b((TextView) inflate.findViewById(i.f.home_lv_search_forum), i.c.cp_cont_b, 1);
                        inflate.findViewById(i.f.home_dialog_lv_search_forum_divider).setBackgroundColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_bg_line_b));
                        com.baidu.tbadk.core.util.al.i(inflate, i.e.addresslist_item_bg);
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                        inflate.setOnClickListener(new c(str));
                        this.bQK.add(inflate);
                        this.bQj.addView(inflate, layoutParams3);
                    }
                }
                this.bQJ = LayoutInflater.from(pageActivity).inflate(i.g.home_dialog_search_footer, (ViewGroup) null);
                ((TextView) this.bQJ.findViewById(i.f.home_bt_search_footer)).setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_link_tip_a));
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                this.bQJ.setOnClickListener(new ab(this));
                this.bQj.addView(this.bQJ, layoutParams4);
            }
        }
    }

    private boolean b(int i, ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && (this.bPO == null || this.bPO.isEmpty()) && 4 == i && this.mMode == 0;
    }

    private boolean c(int i, ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && i == 5 && this.mMode != 5;
    }

    private boolean d(int i, ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && i == 6 && this.mMode != 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZZ() {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).cn(getPageContext().getString(i.C0057i.alert_clean_history)).a(getPageContext().getString(i.C0057i.clear_all_text), new ac(this)).b(getPageContext().getString(i.C0057i.alert_no_button), new ae(this)).b(getPageContext()).sP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaa() {
        this.bQa.setVisibility(8);
        if (this.bQt != null) {
            if (this.bQt.equals(this.bQu)) {
                refresh();
                return;
            }
            Q(this.bQE);
            Q(this.bQG);
            Q(this.bQF);
            this.mHandler.removeCallbacks(this.bQV);
            this.mHandler.postDelayed(this.bQV, 500L);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v5 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void G(int i, String str) {
        this.bQh.setVisibility(8);
        if (str != null && str.trim().length() > 0) {
            int i2 = this.bQB ? 1 : 0;
            if (str.equals(this.bQv) && i == this.bQx && this.bQy == i2) {
                refresh();
                return;
            }
            this.bQy = i2;
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append(TbConfig.SERVER_ADDRESS);
            stringBuffer.append(TbConfig.POST_SEARCH_URL);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("word", str));
            arrayList.add(new BasicNameValuePair("pn", String.valueOf(i)));
            arrayList.add(new BasicNameValuePair("rn", String.valueOf(50)));
            arrayList.add(new BasicNameValuePair("only_thread", new StringBuilder().append(i2).toString()));
            arrayList.add(new BasicNameValuePair("st_type", "search_post"));
            Gt();
            this.bQs = new b(stringBuffer.toString(), arrayList);
            this.bQs.setPriority(3);
            this.bQs.execute(new Object[0]);
            this.bQC = true;
        }
    }

    private FRSPageRequestMessage iB(String str) {
        FRSPageRequestMessage fRSPageRequestMessage = new FRSPageRequestMessage();
        fRSPageRequestMessage.setKw(str);
        fRSPageRequestMessage.setPn(1);
        if (com.baidu.tbadk.core.m.rd().rh()) {
            fRSPageRequestMessage.setRn(35);
        } else {
            fRSPageRequestMessage.setRn(50);
        }
        fRSPageRequestMessage.setWithGroup(1);
        int K = com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity());
        int L = com.baidu.adp.lib.util.k.L(getPageContext().getPageActivity());
        float f = K / 320.0f;
        int i = ar.uE().uG() ? 2 : 1;
        fRSPageRequestMessage.setScrW(K);
        fRSPageRequestMessage.setScrH(L);
        fRSPageRequestMessage.setScrDip(f);
        fRSPageRequestMessage.setqType(i);
        return fRSPageRequestMessage;
    }

    private void aab() {
        if (this.bQl != null) {
            this.bQl.setNextPage(null);
        }
        if (this.bQn != null) {
            this.bQn.clear();
            this.bQn.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        int i;
        int i2 = 0;
        try {
            if (this.mMode == 0) {
                if (this.bQp != null) {
                    if (this.bQp.forum_list != null && this.bQp.forum_list.size() > 0) {
                        aad();
                        this.bQl.setAdapter((ListAdapter) this.bQm);
                        this.bQm.iz(this.bQt);
                        this.bQm.J(this.bQp.forum_list);
                        this.bQm.notifyDataSetInvalidated();
                        return;
                    }
                    Q(this.bQF);
                    aah();
                    aac();
                }
            } else if (this.bQq != null) {
                List<j.a> list = this.bQq.cmT;
                if (list != null && list.size() > 0) {
                    aad();
                    if (this.bQq.getCurrentPage() == 1) {
                        this.bQl.setVisibility(0);
                        this.bQn.clear();
                        this.bQl.setAdapter((ListAdapter) this.bQn);
                        this.bQl.setNextPage(aai());
                    }
                    if (!this.bQq.isHasMore()) {
                        aai().setText(getResources().getString(i.C0057i.list_no_more));
                        aai().vB();
                    }
                    int ba = this.bQn.ba(list);
                    if (ba > 0) {
                        i = this.bQl.getFirstVisiblePosition() - ba;
                        View childAt = this.bQl.getChildAt(0);
                        if (childAt != null) {
                            i2 = childAt.getTop();
                        }
                    } else {
                        i = 0;
                    }
                    this.bQn.notifyDataSetChanged();
                    if (ba > 0) {
                        this.bQl.setSelectionFromTop(i, i2);
                    }
                    if (this.bQD) {
                        this.bQg.setVisibility(0);
                        this.bQD = false;
                        com.baidu.tbadk.core.sharedPref.b.ts().putBoolean("search_post_show_dropmenu", false);
                    }
                } else if (this.mNoDataView.getVisibility() != 0) {
                    aaf();
                    Q(this.bQG);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cD(i.C0057i.text_no_suggest));
                }
            } else if (this.mNoDataView.getVisibility() != 0) {
                aaf();
                Q(this.bQG);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.cD(i.C0057i.text_no_suggest));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void aac() {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_h));
        TextView textView = (TextView) this.bQf.findViewById(i.f.no_bar_found);
        textView.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_c));
        TextView textView2 = (TextView) this.bQf.findViewById(i.f.create_bar_guide);
        textView2.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_b));
        String str = "";
        if (this.bQt != null) {
            str = this.bQt.length() > 6 ? String.valueOf(this.bQt.substring(0, 6)) + "..." : this.bQt;
        }
        String format = String.format(getPageContext().getString(i.C0057i.empty_search_result_format), str);
        String format2 = String.format(getPageContext().getString(i.C0057i.create_bar_guide_format), str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
        spannableStringBuilder.setSpan(foregroundColorSpan, 4, format.length() - 2, 33);
        textView.setText(spannableStringBuilder);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(format2);
        spannableStringBuilder2.setSpan(foregroundColorSpan, 5, format2.length() - 5, 33);
        textView2.setText(spannableStringBuilder2);
        Drawable drawable = com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_search_list_add);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        textView2.setCompoundDrawablePadding(com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), i.d.ds10));
        textView2.setCompoundDrawables(drawable, null, null, null);
        textView2.setOnClickListener(new af(this));
    }

    private void aad() {
        this.bQa.setVisibility(0);
        this.bQl.setVisibility(0);
        this.bQh.setVisibility(8);
        Q(this.bQF);
        this.mNoDataView.setVisibility(8);
        this.bQg.setVisibility(8);
        this.bPX.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_down);
        this.bPX.cI(TbadkCoreApplication.m411getInst().getSkinType());
        this.bQf.setVisibility(8);
    }

    private void aae() {
        this.bQa.setVisibility(0);
        this.bQh.setVisibility(0);
        if (this.mMode == 0) {
            P(this.bQE);
        } else {
            Q(this.bQE);
        }
        this.bQl.setVisibility(8);
        Q(this.bQF);
        this.mNoDataView.setVisibility(8);
        this.bQg.setVisibility(8);
        this.bPX.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_down);
        this.bPX.cI(TbadkCoreApplication.m411getInst().getSkinType());
        this.bQf.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaf() {
        this.bQa.setVisibility(8);
        this.bQl.setVisibility(8);
        this.bQh.setVisibility(8);
        P(this.bQF);
        this.mNoDataView.setVisibility(0);
        if (this.mMode == 0) {
            P(this.bQG);
        }
        this.bQg.setVisibility(8);
        this.bPX.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_down);
        this.bPX.cI(TbadkCoreApplication.m411getInst().getSkinType());
        this.bQf.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aag() {
        Q(this.bQF);
        this.mNoDataView.setVisibility(8);
        this.bQg.setVisibility(0);
    }

    private void aah() {
        this.bQa.setVisibility(8);
        this.bQl.setVisibility(8);
        this.bQh.setVisibility(8);
        Q(this.bQF);
        this.mNoDataView.setVisibility(8);
        this.bQg.setVisibility(8);
        this.bPX.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_down);
        this.bPX.cI(TbadkCoreApplication.m411getInst().getSkinType());
        this.bQf.setVisibility(0);
        if (CreateBarActivityConfig.IS_SUPPORT_CREATE_BAR && this.bQt != null && this.bQt.length() <= 30) {
            dF(true);
        } else {
            dF(false);
        }
    }

    private void dF(boolean z) {
        if (!z) {
            this.bQL.setVisibility(8);
            this.bQM.setVisibility(8);
            this.bQN.setVisibility(8);
            return;
        }
        this.bQL.setVisibility(0);
        this.bQM.setVisibility(0);
        this.bQN.setVisibility(0);
    }

    private PbListView aai() {
        if (this.bQk == null) {
            this.bQk = new PbListView(getPageContext().getPageActivity());
            this.bQk.nq();
        }
        return this.bQk;
    }

    @Override // com.baidu.tieba.mainentrance.d.a
    public void iA(String str) {
        this.bQz = true;
        this.bPO = new ArrayList();
        ZW();
    }

    @Override // com.baidu.tieba.mainentrance.d.a
    public void aQ(List<com.baidu.tieba.mainentrance.c> list) {
        this.bQz = true;
        hideLoadingView(this.bPZ);
        if (list == null || list.isEmpty()) {
            this.bPO = new ArrayList();
        } else {
            this.bPO = list;
        }
        ZW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bPW.onChangeSkinType(i);
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.bPY);
        getLayoutMode().k(this.bQf);
        com.baidu.tbadk.core.util.al.e(this.bPY, i);
        if (this.bQm != null) {
            this.bQm.notifyDataSetChanged();
        }
        if (this.bQn != null) {
            this.bQn.notifyDataSetChanged();
        }
        if (this.bQi != null) {
            this.bQi.notifyDataSetChanged();
        }
        com.baidu.tbadk.core.util.al.i(this.bPZ, i.c.cp_bg_line_d);
        com.baidu.tbadk.core.util.al.c(this.bQe, i.e.icon_search_ba);
        com.baidu.tbadk.core.util.al.b(this.bQd, i.c.cp_cont_i, 1);
        try {
            hK(i);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    private void hK(int i) {
        if (this.bQj != null) {
            this.bQj.setBackgroundColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_bg_line_d));
        }
        if (this.bQH != null) {
            this.bQH.setBackgroundColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_bg_line_b));
        }
        if (this.bQI != null) {
            this.bQI.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_c));
        }
        if (this.bQJ != null) {
            ((TextView) this.bQJ.findViewById(i.f.home_bt_search_footer)).setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_link_tip_a));
        }
        if (this.bQK != null) {
            for (View view : this.bQK) {
                com.baidu.tbadk.core.util.al.b((TextView) view.findViewById(i.f.home_lv_search_forum), i.c.cp_cont_b, 1);
                view.findViewById(i.f.home_dialog_lv_search_forum_divider).setBackgroundColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_bg_line_b));
                com.baidu.tbadk.core.util.al.i(view, i.e.addresslist_item_bg);
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
        setSkinType(-1);
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
                        SquareSearchActivity.this.fX(this.mName);
                        return;
                    }
                    SquareSearchActivity.this.G(1, this.mName);
                    SquareSearchActivity.this.bQb.setText(this.mName);
                    SquareSearchActivity.this.bQb.requestFocus();
                    Selection.setSelection(SquareSearchActivity.this.bQb.getText(), this.mName.length());
                    return;
                }
                com.baidu.tieba.tbadkCore.util.k.kA(this.mName);
                SquareSearchActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(SquareSearchActivity.this.getActivity()).createNormalCfg(this.mName, FrsActivityConfig.FRS_FROM_SEARCH)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
        private com.baidu.tbadk.core.util.v afJ = null;
        private BasicNameValuePair bRf;
        private String mUrl;

        public a(String str, BasicNameValuePair basicNameValuePair, boolean z) {
            this.mUrl = null;
            this.bRf = null;
            this.mUrl = str;
            this.bRf = basicNameValuePair;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.bPZ, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(i.d.ds320));
            SquareSearchActivity.this.bQa.setVisibility(8);
            SquareSearchActivity.this.mNoDataView.setVisibility(8);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: z */
        public ForumSuggestModel doInBackground(Object... objArr) {
            ForumSuggestModel forumSuggestModel = null;
            try {
                this.afJ = new com.baidu.tbadk.core.util.v(this.mUrl);
                this.afJ.a(this.bRf);
                String tD = this.afJ.tD();
                if (tD == null) {
                    return null;
                }
                forumSuggestModel = ForumSuggestModel.parserJson(tD);
                SquareSearchActivity.this.bQu = this.bRf.getValue();
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
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.bPZ);
            if (forumSuggestModel != null) {
                SquareSearchActivity.this.bQp = forumSuggestModel;
                SquareSearchActivity.this.refresh();
            }
            SquareSearchActivity.this.bQr = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afJ != null) {
                this.afJ.gM();
                this.afJ = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.bPZ);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Object, Integer, com.baidu.tieba.postsearch.j> {
        private com.baidu.tbadk.core.util.v afJ = null;
        private ArrayList<BasicNameValuePair> bRg;
        private String mUrl;

        public b(String str, ArrayList<BasicNameValuePair> arrayList) {
            this.mUrl = null;
            this.bRg = null;
            this.mUrl = str;
            this.bRg = arrayList;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.bPZ, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(i.d.ds320));
            SquareSearchActivity.this.mNoDataView.setVisibility(8);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public com.baidu.tieba.postsearch.j doInBackground(Object... objArr) {
            Exception exc;
            com.baidu.tieba.postsearch.j jVar;
            try {
                this.afJ = new com.baidu.tbadk.core.util.v(this.mUrl);
                Iterator<BasicNameValuePair> it = this.bRg.iterator();
                while (it.hasNext()) {
                    this.afJ.a(it.next());
                }
                String tD = this.afJ.tD();
                if (!this.afJ.ue().uW().uh() || tD == null) {
                    return null;
                }
                com.baidu.tieba.postsearch.j jVar2 = new com.baidu.tieba.postsearch.j();
                try {
                    jVar2.parseJson(tD);
                    if (tD != null && this.afJ != null && this.afJ.ue().uW().rb()) {
                        Iterator<BasicNameValuePair> it2 = this.bRg.iterator();
                        while (it2.hasNext()) {
                            BasicNameValuePair next = it2.next();
                            if ("word".equals(next.getName())) {
                                SquareSearchActivity.this.bQv = next.getValue();
                            }
                            if ("pn".equals(next.getName())) {
                                SquareSearchActivity.this.bQx = Integer.valueOf(next.getValue()).intValue();
                            }
                        }
                    }
                    if (this.afJ.ue().uW().rb()) {
                        com.baidu.tieba.tbadkCore.util.k.kB(SquareSearchActivity.this.bQt);
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
            SquareSearchActivity.this.bQC = false;
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.bPZ);
            SquareSearchActivity.this.bQn.notifyDataSetChanged();
            if (jVar == null || this.afJ == null || !this.afJ.ue().uW().uh()) {
                SquareSearchActivity.this.showToast(SquareSearchActivity.this.getPageContext().getString(i.C0057i.neterror));
            } else if (this.afJ.ue().uW().rb()) {
                SquareSearchActivity.this.bQq = jVar;
                SquareSearchActivity.this.refresh();
            } else {
                SquareSearchActivity.this.refresh();
            }
            SquareSearchActivity.this.bQs = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            SquareSearchActivity.this.bQn.notifyDataSetChanged();
            if (this.afJ != null) {
                this.afJ.gM();
                this.afJ = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.bPZ);
            SquareSearchActivity.this.bQs = null;
            super.onCancelled();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!this.bQC && this.bQq != null && this.bQq.isHasMore()) {
            G(this.bQq.getCurrentPage() + 1, this.bQt);
            aai().startLoadData();
        }
    }

    private void dG(boolean z) {
        if (TbadkCoreApplication.isLogin()) {
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(CmdConfigCustom.CMD_REQUEST_ENTER_FORUM_MESSAGE, true));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(CmdConfigCustom.CMD_REQUEST_ENTER_FORUM_MESSAGE, false));
        }
    }

    private void aaj() {
        this.bQE = new SearchPageFocusBar(getPageContext().getPageActivity());
        this.bQE.setVisibility(8);
        this.bQh.addFooterView(this.bQE, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(View view) {
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private void Q(View view) {
        if (view != null) {
            view.setVisibility(8);
        }
    }
}
