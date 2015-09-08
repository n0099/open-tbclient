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
    private boolean awR;
    private FragmentTabWidget bQC;
    private FragmentTabIndicator bQD;
    private LinearLayoutDetectsSoftKeyboard bQE;
    private FrameLayout bQF;
    private FrameLayout bQG;
    private EditText bQH;
    private TextView bQI;
    private TextView bQJ;
    private ImageView bQK;
    private View bQL;
    private View bQM;
    private ListView bQN;
    private com.baidu.tieba.mainentrance.b bQO;
    private LinearLayout bQP;
    private PbListView bQQ;
    private BdListView bQR;
    private com.baidu.tieba.mainentrance.a bQS;
    private com.baidu.tieba.postsearch.v bQT;
    private d bQU;
    private ForumSuggestModel bQV;
    private com.baidu.tieba.postsearch.j bQW;
    private a bQX;
    private b bQY;
    private String bQZ;
    private List<com.baidu.tieba.mainentrance.c> bQu;
    private String bRa;
    private String bRb;
    private String bRc;
    private boolean bRf;
    private boolean bRh;
    private boolean bRj;
    private SearchPageFocusBar bRk;
    private ScrollView bRl;
    private SearchPageFocusBar bRm;
    private View bRn;
    private TextView bRo;
    private View bRp;
    private View bRr;
    private TextView bRs;
    private View bRt;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.u mNoDataView;
    private int mMode = 0;
    private int bRd = 0;
    private int bRe = -1;
    private boolean asX = true;
    private boolean bRg = true;
    private boolean bRi = false;
    private List<View> bRq = new ArrayList();
    private Runnable bRu = new j(this);
    private final View.OnClickListener bRv = new u(this);
    private final com.baidu.adp.framework.listener.e bRw = new ag(this, 301001, true);
    private final HttpMessageListener bRx = new ah(this, CmdConfigHttp.FRS_HTTP_CMD, true);
    private CustomMessageListener bRy = new ai(this, CmdConfigCustom.CMD_READ_SEARCHPERSON_HISTORY);
    private CustomMessageListener bRz = new aj(this, CmdConfigCustom.CMD_WRITE_SEARCHPERSON_HISTORY);
    private HttpMessageListener bRA = new ak(this, CmdConfigHttp.SEARCH_FRIEND_CMD);
    private final Runnable bRB = new al(this);
    private CustomMessageListener bRC = new am(this, CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA);
    private CustomMessageListener bRD = new k(this, CmdConfigCustom.GET_ALL_SEARCH_POST_DATA);
    private CustomMessageListener bRE = new l(this, CmdConfigCustom.CMD_ENTER_FORUM_INFO);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponsedMessage<?> responsedMessage, boolean z) {
        int error = responsedMessage.getError();
        String string = StringUtils.isNull(responsedMessage.getErrorString()) ? getResources().getString(i.h.neterror) : responsedMessage.getErrorString();
        boolean z2 = error < -13 || error > -10;
        if (error == 0) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createFlagCfg(this.bRc, FrsActivityConfig.FRS_FROM_SEARCH, 1)));
        } else if (z2 && z && error == 3) {
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(i.h.login_to_use), true, 11013)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), this.bRc)));
            }
        } else {
            showToast(string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ge(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SEARCH_FRIEND_CMD);
        httpMessage.addParam("search_key", str);
        sendMessage(httpMessage);
    }

    private void GE() {
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
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), this.bRc)));
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
        GE();
        registerListener(this.bRy);
        registerListener(this.bRz);
        registerListener(this.bRC);
        registerListener(this.bRD);
        registerListener(this.bRA);
        registerListener(this.bRw);
        registerListener(this.bRx);
        registerListener(this.bRE);
        this.bRj = com.baidu.tbadk.core.sharedPref.b.tx().getBoolean("search_post_show_dropmenu", true);
        if (SquareSearchActivityConfig.IS_SHOW_RECOMMEND_FORUM) {
            this.bQU = new d(this, this);
            this.bQU.ZU();
            this.bQU.ZT();
        }
        this.bRf = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.asX = true;
        if (this.bRg) {
            this.mHandler.post(this.bRu);
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
        hideLoadingView(this.bQF);
        this.mHandler.removeCallbacks(this.bRu);
        ZV();
    }

    public void ZV() {
        this.mHandler.removeCallbacks(this.bRB);
        if (this.bQX != null) {
            this.bQX.cancel();
            this.bQX = null;
        }
        if (this.bQY != null) {
            this.bQY.cancel();
            this.bQY = null;
        }
    }

    private void init() {
        this.bQE = (LinearLayoutDetectsSoftKeyboard) findViewById(i.f.parent);
        this.bQE.setOnSoftKeyBoardShownListener(new m(this));
        this.bQE.setOnTouchListener(new n(this));
        Ok();
        Oj();
        this.bQF = (FrameLayout) findViewById(i.f.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(i.d.ds80)), null, null);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            this.bRl = (ScrollView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(i.g.home_searchbar_nodataview, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) this.bRl.findViewById(i.f.focusbar_nodata_root);
            this.bRm = (SearchPageFocusBar) linearLayout.findViewById(i.f.no_data_focusbar);
            linearLayout.addView(this.mNoDataView, 0);
            this.bRl.setOnTouchListener(new o(this));
            this.bQF.addView(this.bRl, this.bQF.getChildCount());
        } else {
            this.bQF.addView(this.mNoDataView);
        }
        this.bQG = (FrameLayout) findViewById(i.f.home_search_list);
        ZW();
        ZX();
        this.bQL = findViewById(i.f.empty_search_result);
        this.bRr = this.bQL.findViewById(i.f.empty_result_divider_1);
        this.bRs = (TextView) this.bQL.findViewById(i.f.create_bar_guide);
        this.bRt = this.bQL.findViewById(i.f.empty_result_divider_2);
        ZY();
        this.bQH.setText("");
        this.bQH.requestFocus();
        ShowSoftKeyPadDelay(this.bQH, 200);
        if (TbadkSettings.getInst().loadBoolean("search_mode", true)) {
            hT(0);
        } else {
            hT(1);
        }
    }

    private void Oj() {
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new p(this));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, i.g.square_search_navigation_view, (View.OnClickListener) null);
        this.bQK = (ImageView) addCustomView.findViewById(i.f.search_bar_icon);
        this.bQH = (EditText) addCustomView.findViewById(i.f.home_et_search);
        this.bQI = (TextView) addCustomView.findViewById(i.f.home_bt_search_del);
        this.bQJ = (TextView) addCustomView.findViewById(i.f.home_bt_search_s);
        this.bQH.setOnFocusChangeListener(new q(this));
        this.bQJ.setText(getPageContext().getString(i.h.enter_forum));
        this.bQJ.setOnClickListener(this.bRv);
        this.bQH.setOnEditorActionListener(new r(this));
        this.bQI.setOnClickListener(new s(this));
        this.bQH.addTextChangedListener(new t(this));
    }

    private void Ok() {
        this.bQC = (FragmentTabWidget) findViewById(i.f.square_search_tab_widget);
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(i.d.ds32));
        fragmentTabIndicator.setGravity(17);
        fragmentTabIndicator.awo = i.c.main_bottom_button_color;
        fragmentTabIndicator.setText(getResources().getString(i.h.search_bar_text));
        this.bQD = new FragmentTabIndicator(getPageContext().getPageActivity());
        this.bQD.awo = i.c.main_bottom_button_color;
        this.bQD.setTextSize(0, getResources().getDimension(i.d.ds32));
        this.bQD.setGravity(17);
        this.bQD.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_down);
        this.bQD.setText(getResources().getString(i.h.search_post_text));
        FragmentTabIndicator fragmentTabIndicator2 = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator2.awo = i.c.main_bottom_button_color;
        fragmentTabIndicator2.setTextSize(0, getResources().getDimension(i.d.ds32));
        fragmentTabIndicator2.setGravity(17);
        fragmentTabIndicator2.setText(getResources().getString(i.h.search_person));
        this.bQC.addView(fragmentTabIndicator);
        this.bQC.addView(this.bQD);
        this.bQC.addView(fragmentTabIndicator2);
        this.bQC.d(0, true);
        this.bQC.setTabSelectionListener(new v(this));
    }

    private void ZW() {
        this.bQN = (ListView) findViewById(i.f.home_lv_search_history);
        if (this.bQP == null) {
            this.bQP = new LinearLayout(getPageContext().getPageActivity());
            this.bQP.setOrientation(1);
            this.bQP.setBackgroundColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_bg_line_d));
        }
        this.bQN.addFooterView(this.bQP);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            aao();
        }
        this.bQO = new com.baidu.tieba.mainentrance.b(this);
        this.bQN.setAdapter((ListAdapter) this.bQO);
        this.bQN.setOnItemClickListener(new w(this));
    }

    private void ZX() {
        this.bQR = (BdListView) findViewById(i.f.home_lv_search_suggest);
        this.bQS = new com.baidu.tieba.mainentrance.a(this, null);
        this.bQT = new com.baidu.tieba.postsearch.v(getPageContext());
        this.bQR.setOnItemClickListener(new x(this));
        y yVar = new y(this);
        this.bQR.setOnScrollListener(yVar);
        this.bQN.setOnScrollListener(yVar);
        this.bQR.setOnSrollToBottomListener(this);
    }

    private void ZY() {
        this.bQM = findViewById(i.f.search_dropmenu);
        TextView textView = (TextView) this.bQM.findViewById(i.f.dropmenu_all_text);
        textView.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_link_tip_a));
        ImageView imageView = (ImageView) this.bQM.findViewById(i.f.dropmenu_all_icon);
        imageView.setImageDrawable(com.baidu.tbadk.core.util.al.getDrawable(i.e.chx_tips_list_ok));
        imageView.setVisibility(0);
        TextView textView2 = (TextView) this.bQM.findViewById(i.f.dropmenu_thread_text);
        textView2.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_c));
        ImageView imageView2 = (ImageView) this.bQM.findViewById(i.f.dropmenu_thread_icon);
        imageView2.setImageDrawable(com.baidu.tbadk.core.util.al.getDrawable(i.e.chx_tips_list_ok));
        imageView2.setVisibility(8);
        this.bQM.findViewById(i.f.dropmenu_all_layout).setOnClickListener(new z(this, textView, imageView, textView2, imageView2));
        this.bQM.findViewById(i.f.dropmenu_thread_layout).setOnClickListener(new aa(this, textView, imageView, textView2, imageView2));
        this.bQM.findViewById(i.f.dropmenu_lower_part).setOnClickListener(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZZ() {
        if (this.bQG.getVisibility() == 8 && this.mNoDataView.getVisibility() == 8 && this.bQL.getVisibility() == 8) {
            P(this.bRl);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cJ(i.h.text_no_search_record));
        }
    }

    public void hT(int i) {
        switch (i) {
            case 0:
                if (this.mMode != 0) {
                    this.mMode = 0;
                    this.bQJ.setText(getPageContext().getString(i.h.enter_forum));
                    this.bQH.setHint(i.h.search_bar);
                    ZV();
                    aag();
                    if (this.bQZ.trim().length() > 0) {
                        aaf();
                        return;
                    } else {
                        aab();
                        return;
                    }
                }
                return;
            case 1:
                if (this.mMode != 1) {
                    this.mMode = 1;
                    this.bQJ.setText(getPageContext().getString(i.h.search));
                    this.bQH.setHint(i.h.search_post_hint);
                    ZV();
                    aag();
                    if (this.bQZ.trim().length() > 0) {
                        this.bQR.setVisibility(8);
                        E(1, this.bQZ);
                        return;
                    }
                    aac();
                    return;
                }
                return;
            case 2:
            default:
                return;
            case 3:
                if (this.mMode != 3) {
                    this.mMode = 3;
                    this.bQR.setVisibility(8);
                    this.bQL.setVisibility(8);
                    this.bQM.setVisibility(8);
                    this.bQJ.setText(i.h.search);
                    this.bQH.setHint(i.h.search_friend_tip);
                    aag();
                    ZV();
                    aad();
                    return;
                }
                return;
        }
    }

    public void aaa() {
        String trim = this.bQH.getText().toString().trim();
        if (!TextUtils.isEmpty(trim)) {
            if (com.baidu.adp.lib.util.i.iL()) {
                this.bRc = trim;
                this.asX = false;
                sendMessage(iK(trim));
                return;
            }
            showToast(i.h.neterror);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aab() {
        this.bQR.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA));
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            dL(true);
            Q(this.bRm);
            Q(this.bRl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aac() {
        this.bQR.setVisibility(8);
        Q(this.bRk);
        Q(this.bRm);
        Q(this.bRl);
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aad() {
        this.bQR.setVisibility(8);
        Q(this.bRk);
        Q(this.bRm);
        Q(this.bRl);
        if (!this.awR) {
            sendMessage(new RequestSearchPersonHistoryReadMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ArrayList<String> arrayList) {
        if (b(i, arrayList) || c(i, arrayList) || d(i, arrayList)) {
            aak();
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cJ(i.h.text_no_search_record));
            return;
        }
        aaj();
        List<com.baidu.tieba.mainentrance.c> arrayList2 = new ArrayList<>();
        if (i == 4) {
            arrayList2 = this.bQu;
        }
        a(i, arrayList, (this.bQu == null ? 0 : arrayList2.size()) != 0);
        this.bQO.aP(arrayList2);
        this.bQO.notifyDataSetChanged();
    }

    private void a(int i, ArrayList<String> arrayList, boolean z) {
        if (this.bQP != null) {
            this.bQP.removeAllViews();
            if (arrayList != null && !arrayList.isEmpty() && getActivity() != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                if (z) {
                    this.bRn = new View(pageActivity);
                    this.bRn.setBackgroundColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_bg_line_b));
                    layoutParams.height = com.baidu.adp.lib.util.k.d(pageActivity, i.d.ds20);
                    this.bQP.addView(this.bRn, layoutParams);
                }
                this.bRo = (TextView) LayoutInflater.from(pageActivity).inflate(i.g.search_history_title, (ViewGroup) null);
                this.bRo.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_c));
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.leftMargin = com.baidu.adp.lib.util.k.d(pageActivity, i.d.ds30);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.d(pageActivity, i.d.ds36);
                layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.d(pageActivity, i.d.ds10);
                this.bQP.addView(this.bRo, layoutParams2);
                int size = arrayList.size();
                this.bRq.clear();
                for (int i2 = 0; i2 < size; i2++) {
                    String str = arrayList.get(i2);
                    if (!TextUtils.isEmpty(str)) {
                        View inflate = LayoutInflater.from(pageActivity).inflate(i.g.home_dialog_search_item, (ViewGroup) null);
                        ((TextView) inflate.findViewById(i.f.home_lv_search_forum)).setText(str);
                        com.baidu.tbadk.core.util.al.b((TextView) inflate.findViewById(i.f.home_lv_search_forum), i.c.cp_cont_b, 1);
                        inflate.findViewById(i.f.home_dialog_lv_search_forum_divider).setBackgroundColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_bg_line_b));
                        com.baidu.tbadk.core.util.al.h(inflate, i.e.addresslist_item_bg);
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                        inflate.setOnClickListener(new c(str));
                        this.bRq.add(inflate);
                        this.bQP.addView(inflate, layoutParams3);
                    }
                }
                this.bRp = LayoutInflater.from(pageActivity).inflate(i.g.home_dialog_search_footer, (ViewGroup) null);
                ((TextView) this.bRp.findViewById(i.f.home_bt_search_footer)).setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_link_tip_a));
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                this.bRp.setOnClickListener(new ab(this));
                this.bQP.addView(this.bRp, layoutParams4);
            }
        }
    }

    private boolean b(int i, ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && (this.bQu == null || this.bQu.isEmpty()) && 4 == i && this.mMode == 0;
    }

    private boolean c(int i, ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && i == 5 && this.mMode != 5;
    }

    private boolean d(int i, ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && i == 6 && this.mMode != 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aae() {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).ct(getPageContext().getString(i.h.alert_clean_history)).a(getPageContext().getString(i.h.clear_all_text), new ac(this)).b(getPageContext().getString(i.h.alert_no_button), new ae(this)).b(getPageContext()).sU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaf() {
        this.bQG.setVisibility(8);
        if (this.bQZ != null) {
            if (this.bQZ.equals(this.bRa)) {
                refresh();
                return;
            }
            Q(this.bRk);
            Q(this.bRm);
            Q(this.bRl);
            this.mHandler.removeCallbacks(this.bRB);
            this.mHandler.postDelayed(this.bRB, 500L);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v5 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void E(int i, String str) {
        this.bQN.setVisibility(8);
        if (str != null && str.trim().length() > 0) {
            int i2 = this.bRh ? 1 : 0;
            if (str.equals(this.bRb) && i == this.bRd && this.bRe == i2) {
                refresh();
                return;
            }
            this.bRe = i2;
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append(TbConfig.SERVER_ADDRESS);
            stringBuffer.append(TbConfig.POST_SEARCH_URL);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("word", str));
            arrayList.add(new BasicNameValuePair("pn", String.valueOf(i)));
            arrayList.add(new BasicNameValuePair("rn", String.valueOf(50)));
            arrayList.add(new BasicNameValuePair("only_thread", new StringBuilder().append(i2).toString()));
            arrayList.add(new BasicNameValuePair("st_type", "search_post"));
            ZV();
            this.bQY = new b(stringBuffer.toString(), arrayList);
            this.bQY.setPriority(3);
            this.bQY.execute(new Object[0]);
            this.bRi = true;
        }
    }

    private FRSPageRequestMessage iK(String str) {
        FRSPageRequestMessage fRSPageRequestMessage = new FRSPageRequestMessage();
        fRSPageRequestMessage.setKw(str);
        fRSPageRequestMessage.setPn(1);
        if (com.baidu.tbadk.core.m.rb().rf()) {
            fRSPageRequestMessage.setRn(35);
        } else {
            fRSPageRequestMessage.setRn(50);
        }
        fRSPageRequestMessage.setWithGroup(1);
        int K = com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity());
        int L = com.baidu.adp.lib.util.k.L(getPageContext().getPageActivity());
        float f = K / 320.0f;
        int i = ar.uK().uM() ? 2 : 1;
        fRSPageRequestMessage.setScrW(K);
        fRSPageRequestMessage.setScrH(L);
        fRSPageRequestMessage.setScrDip(f);
        fRSPageRequestMessage.setqType(i);
        return fRSPageRequestMessage;
    }

    private void aag() {
        if (this.bQR != null) {
            this.bQR.setNextPage(null);
        }
        if (this.bQT != null) {
            this.bQT.clear();
            this.bQT.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        int i;
        int i2 = 0;
        try {
            if (this.mMode == 0) {
                if (this.bQV != null) {
                    if (this.bQV.forum_list != null && this.bQV.forum_list.size() > 0) {
                        aai();
                        this.bQR.setAdapter((ListAdapter) this.bQS);
                        this.bQS.iI(this.bQZ);
                        this.bQS.I(this.bQV.forum_list);
                        this.bQS.notifyDataSetInvalidated();
                        return;
                    }
                    Q(this.bRl);
                    aam();
                    aah();
                }
            } else if (this.bQW != null) {
                List<j.a> list = this.bQW.cnV;
                if (list != null && list.size() > 0) {
                    aai();
                    if (this.bQW.getCurrentPage() == 1) {
                        this.bQR.setVisibility(0);
                        this.bQT.clear();
                        this.bQR.setAdapter((ListAdapter) this.bQT);
                        this.bQR.setNextPage(aan());
                    }
                    if (!this.bQW.isHasMore()) {
                        aan().setText(getResources().getString(i.h.list_no_more));
                        aan().vG();
                    }
                    int bi = this.bQT.bi(list);
                    if (bi > 0) {
                        i = this.bQR.getFirstVisiblePosition() - bi;
                        View childAt = this.bQR.getChildAt(0);
                        if (childAt != null) {
                            i2 = childAt.getTop();
                        }
                    } else {
                        i = 0;
                    }
                    this.bQT.notifyDataSetChanged();
                    if (bi > 0) {
                        this.bQR.setSelectionFromTop(i, i2);
                    }
                    if (this.bRj) {
                        this.bQM.setVisibility(0);
                        this.bRj = false;
                        com.baidu.tbadk.core.sharedPref.b.tx().putBoolean("search_post_show_dropmenu", false);
                    }
                } else if (this.mNoDataView.getVisibility() != 0) {
                    aak();
                    Q(this.bRm);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cJ(i.h.text_no_suggest));
                }
            } else if (this.mNoDataView.getVisibility() != 0) {
                aak();
                Q(this.bRm);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.cJ(i.h.text_no_suggest));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void aah() {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_h));
        TextView textView = (TextView) this.bQL.findViewById(i.f.no_bar_found);
        textView.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_c));
        TextView textView2 = (TextView) this.bQL.findViewById(i.f.create_bar_guide);
        textView2.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_b));
        String str = "";
        if (this.bQZ != null) {
            str = this.bQZ.length() > 6 ? String.valueOf(this.bQZ.substring(0, 6)) + "..." : this.bQZ;
        }
        String format = String.format(getPageContext().getString(i.h.empty_search_result_format), str);
        String format2 = String.format(getPageContext().getString(i.h.create_bar_guide_format), str);
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

    private void aai() {
        this.bQG.setVisibility(0);
        this.bQR.setVisibility(0);
        this.bQN.setVisibility(8);
        Q(this.bRl);
        this.mNoDataView.setVisibility(8);
        this.bQM.setVisibility(8);
        this.bQD.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_down);
        this.bQD.cO(TbadkCoreApplication.m411getInst().getSkinType());
        this.bQL.setVisibility(8);
    }

    private void aaj() {
        this.bQG.setVisibility(0);
        this.bQN.setVisibility(0);
        if (this.mMode == 0) {
            P(this.bRk);
        } else {
            Q(this.bRk);
        }
        this.bQR.setVisibility(8);
        Q(this.bRl);
        this.mNoDataView.setVisibility(8);
        this.bQM.setVisibility(8);
        this.bQD.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_down);
        this.bQD.cO(TbadkCoreApplication.m411getInst().getSkinType());
        this.bQL.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aak() {
        this.bQG.setVisibility(8);
        this.bQR.setVisibility(8);
        this.bQN.setVisibility(8);
        P(this.bRl);
        this.mNoDataView.setVisibility(0);
        if (this.mMode == 0) {
            P(this.bRm);
        }
        this.bQM.setVisibility(8);
        this.bQD.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_down);
        this.bQD.cO(TbadkCoreApplication.m411getInst().getSkinType());
        this.bQL.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aal() {
        Q(this.bRl);
        this.mNoDataView.setVisibility(8);
        this.bQM.setVisibility(0);
    }

    private void aam() {
        this.bQG.setVisibility(8);
        this.bQR.setVisibility(8);
        this.bQN.setVisibility(8);
        Q(this.bRl);
        this.mNoDataView.setVisibility(8);
        this.bQM.setVisibility(8);
        this.bQD.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_down);
        this.bQD.cO(TbadkCoreApplication.m411getInst().getSkinType());
        this.bQL.setVisibility(0);
        if (CreateBarActivityConfig.IS_SUPPORT_CREATE_BAR && this.bQZ != null && this.bQZ.length() <= 30) {
            dK(true);
        } else {
            dK(false);
        }
    }

    private void dK(boolean z) {
        if (!z) {
            this.bRr.setVisibility(8);
            this.bRs.setVisibility(8);
            this.bRt.setVisibility(8);
            return;
        }
        this.bRr.setVisibility(0);
        this.bRs.setVisibility(0);
        this.bRt.setVisibility(0);
    }

    private PbListView aan() {
        if (this.bQQ == null) {
            this.bQQ = new PbListView(getPageContext().getPageActivity());
            this.bQQ.nn();
        }
        return this.bQQ;
    }

    @Override // com.baidu.tieba.mainentrance.d.a
    public void iJ(String str) {
        this.bRf = true;
        this.bQu = new ArrayList();
        aab();
    }

    @Override // com.baidu.tieba.mainentrance.d.a
    public void aQ(List<com.baidu.tieba.mainentrance.c> list) {
        this.bRf = true;
        hideLoadingView(this.bQF);
        if (list == null || list.isEmpty()) {
            this.bQu = new ArrayList();
        } else {
            this.bQu = list;
        }
        aab();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bQC.onChangeSkinType(i);
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.bQE);
        getLayoutMode().k(this.bQL);
        com.baidu.tbadk.core.util.al.e(this.bQE, i);
        if (this.bQS != null) {
            this.bQS.notifyDataSetChanged();
        }
        if (this.bQT != null) {
            this.bQT.notifyDataSetChanged();
        }
        if (this.bQO != null) {
            this.bQO.notifyDataSetChanged();
        }
        com.baidu.tbadk.core.util.al.h(this.bQF, i.c.cp_bg_line_d);
        com.baidu.tbadk.core.util.al.c(this.bQK, i.e.icon_search_ba);
        com.baidu.tbadk.core.util.al.b(this.bQJ, i.c.cp_cont_i, 1);
        try {
            hU(i);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    private void hU(int i) {
        if (this.bQP != null) {
            this.bQP.setBackgroundColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_bg_line_d));
        }
        if (this.bRn != null) {
            this.bRn.setBackgroundColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_bg_line_b));
        }
        if (this.bRo != null) {
            this.bRo.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_c));
        }
        if (this.bRp != null) {
            ((TextView) this.bRp.findViewById(i.f.home_bt_search_footer)).setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_link_tip_a));
        }
        if (this.bRq != null) {
            for (View view : this.bRq) {
                com.baidu.tbadk.core.util.al.b((TextView) view.findViewById(i.f.home_lv_search_forum), i.c.cp_cont_b, 1);
                view.findViewById(i.f.home_dialog_lv_search_forum_divider).setBackgroundColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_bg_line_b));
                com.baidu.tbadk.core.util.al.h(view, i.e.addresslist_item_bg);
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
                        SquareSearchActivity.this.ge(this.mName);
                        return;
                    }
                    SquareSearchActivity.this.E(1, this.mName);
                    SquareSearchActivity.this.bQH.setText(this.mName);
                    SquareSearchActivity.this.bQH.requestFocus();
                    Selection.setSelection(SquareSearchActivity.this.bQH.getText(), this.mName.length());
                    return;
                }
                com.baidu.tieba.tbadkCore.util.k.lf(this.mName);
                SquareSearchActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(SquareSearchActivity.this.getActivity()).createNormalCfg(this.mName, FrsActivityConfig.FRS_FROM_SEARCH)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
        private com.baidu.tbadk.core.util.v afT = null;
        private BasicNameValuePair bRL;
        private String mUrl;

        public a(String str, BasicNameValuePair basicNameValuePair, boolean z) {
            this.mUrl = null;
            this.bRL = null;
            this.mUrl = str;
            this.bRL = basicNameValuePair;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.bQF, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(i.d.ds320));
            SquareSearchActivity.this.bQG.setVisibility(8);
            SquareSearchActivity.this.mNoDataView.setVisibility(8);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public ForumSuggestModel doInBackground(Object... objArr) {
            ForumSuggestModel forumSuggestModel = null;
            try {
                this.afT = new com.baidu.tbadk.core.util.v(this.mUrl);
                this.afT.a(this.bRL);
                String tI = this.afT.tI();
                if (tI == null) {
                    return null;
                }
                forumSuggestModel = ForumSuggestModel.parserJson(tI);
                SquareSearchActivity.this.bRa = this.bRL.getValue();
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
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.bQF);
            if (forumSuggestModel != null) {
                SquareSearchActivity.this.bQV = forumSuggestModel;
                SquareSearchActivity.this.refresh();
            }
            SquareSearchActivity.this.bQX = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afT != null) {
                this.afT.gJ();
                this.afT = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.bQF);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Object, Integer, com.baidu.tieba.postsearch.j> {
        private com.baidu.tbadk.core.util.v afT = null;
        private ArrayList<BasicNameValuePair> bRM;
        private String mUrl;

        public b(String str, ArrayList<BasicNameValuePair> arrayList) {
            this.mUrl = null;
            this.bRM = null;
            this.mUrl = str;
            this.bRM = arrayList;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.bQF, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(i.d.ds320));
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
                this.afT = new com.baidu.tbadk.core.util.v(this.mUrl);
                Iterator<BasicNameValuePair> it = this.bRM.iterator();
                while (it.hasNext()) {
                    this.afT.a(it.next());
                }
                String tI = this.afT.tI();
                if (!this.afT.uj().va().um() || tI == null) {
                    return null;
                }
                com.baidu.tieba.postsearch.j jVar2 = new com.baidu.tieba.postsearch.j();
                try {
                    jVar2.parseJson(tI);
                    if (tI != null && this.afT != null && this.afT.uj().va().qZ()) {
                        Iterator<BasicNameValuePair> it2 = this.bRM.iterator();
                        while (it2.hasNext()) {
                            BasicNameValuePair next = it2.next();
                            if ("word".equals(next.getName())) {
                                SquareSearchActivity.this.bRb = next.getValue();
                            }
                            if ("pn".equals(next.getName())) {
                                SquareSearchActivity.this.bRd = Integer.valueOf(next.getValue()).intValue();
                            }
                        }
                    }
                    if (this.afT.uj().va().qZ()) {
                        com.baidu.tieba.tbadkCore.util.k.lg(SquareSearchActivity.this.bQZ);
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
            SquareSearchActivity.this.bRi = false;
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.bQF);
            SquareSearchActivity.this.bQT.notifyDataSetChanged();
            if (jVar == null || this.afT == null || !this.afT.uj().va().um()) {
                SquareSearchActivity.this.showToast(SquareSearchActivity.this.getPageContext().getString(i.h.neterror));
            } else if (this.afT.uj().va().qZ()) {
                SquareSearchActivity.this.bQW = jVar;
                SquareSearchActivity.this.refresh();
            } else {
                SquareSearchActivity.this.refresh();
            }
            SquareSearchActivity.this.bQY = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            SquareSearchActivity.this.bQT.notifyDataSetChanged();
            if (this.afT != null) {
                this.afT.gJ();
                this.afT = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.bQF);
            SquareSearchActivity.this.bQY = null;
            super.onCancelled();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!this.bRi && this.bQW != null && this.bQW.isHasMore()) {
            E(this.bQW.getCurrentPage() + 1, this.bQZ);
            aan().startLoadData();
        }
    }

    private void dL(boolean z) {
        if (TbadkCoreApplication.isLogin()) {
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(CmdConfigCustom.CMD_REQUEST_ENTER_FORUM_MESSAGE, true));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(CmdConfigCustom.CMD_REQUEST_ENTER_FORUM_MESSAGE, false));
        }
    }

    private void aao() {
        this.bRk = new SearchPageFocusBar(getPageContext().getPageActivity());
        this.bRk.setVisibility(8);
        this.bQN.addFooterView(this.bRk, null, false);
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
