package com.baidu.tieba.mainentrance;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateBarGuideActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.search.ResponseSearchFriendMessage;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.tbadkCore.FRSPageRequestMessage;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class SquareSearchActivity extends BaseActivity<SquareSearchActivity> {
    private String bsI;
    private FragmentTabWidget bsX;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private EditText bsv = null;
    private Button bsw = null;
    private TextView bsx = null;
    private FrameLayout bsy = null;
    private LinearLayoutDetectsSoftKeyboard bsz = null;
    ImageView bsA = null;
    private FrameLayout bsB = null;
    private ListView bsC = null;
    private a bsD = null;
    private ListView bsE = null;
    private am bsF = null;
    private e bsG = null;
    private ProgressBar mProgress = null;
    private Button bsH = null;
    private View bcc = null;
    private BarSuggestModel bsJ = null;
    private SearchPostModel bsK = null;
    private ak bsL = null;
    private al bsM = null;
    private String bsN = null;
    private int mMode = 0;
    private String bsO = null;
    private String bsP = null;
    private int bsQ = 0;
    private boolean aeo = false;
    final View.OnClickListener bsR = new t(this);
    private final com.baidu.adp.framework.listener.e aDN = new ad(this, 301001, true);
    private final HttpMessageListener aDO = new ae(this, CmdConfigHttp.FRS_HTTP_CMD, true);
    private CustomMessageListener bsS = new af(this, 2001195);
    private CustomMessageListener bsT = new ag(this, 2001194);
    private HttpMessageListener bsU = new ah(this, CmdConfigHttp.SEARCH_FRIEND_CMD);
    private final Handler mHandler = new Handler();
    private final Runnable bsV = new ai(this);
    private boolean bsW = true;
    private CustomMessageListener bsY = new aj(this, 2009002);
    private CustomMessageListener bsZ = new j(this, 2009001);

    static {
        TZ();
        Ua();
        CustomMessageTask customMessageTask = new CustomMessageTask(2015002, new i());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        com.baidu.tieba.tbadkCore.a.a.b(2001194, d.class);
        com.baidu.tieba.tbadkCore.a.a.b(2001195, c.class);
    }

    private static void TZ() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2009002, new k());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void Ua() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2009001, new l());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponsedMessage<?> responsedMessage, boolean z) {
        int error = responsedMessage.getError();
        String errorString = responsedMessage.getErrorString();
        boolean z2 = error < -13 || error > -10;
        if (error == 0) {
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createFlagCfg(this.bsI, FrsActivityConfig.FRS_FROM_SEARCH, 1)));
        } else if (z2 && z && error == 3) {
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.z.login_to_use), true, 11013)));
            } else {
                sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), this.bsI)));
            }
        } else {
            showToast(errorString);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fT(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SEARCH_FRIEND_CMD);
        httpMessage.addParam("search_key", str);
        sendMessage(httpMessage);
    }

    private void Tb() {
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
                    sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), this.bsI)));
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
        setContentView(com.baidu.tieba.x.home_dialog_search);
        init();
        getWindow().setSoftInputMode(1);
        Tb();
        registerListener(this.bsS);
        registerListener(this.bsT);
        registerListener(this.bsY);
        registerListener(this.bsZ);
        registerListener(this.bsU);
        registerListener(this.aDN);
        registerListener(this.aDO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bsx != null) {
            this.bsx.setClickable(true);
        }
        if (this.bsW) {
            this.mHandler.post(new m(this));
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
        Ub();
        ru();
    }

    public void ru() {
        this.mHandler.removeCallbacks(this.bsV);
        if (this.bsL != null) {
            this.bsL.cancel();
            this.bsL = null;
        }
        if (this.bsM != null) {
            this.bsM.cancel();
            this.bsM = null;
        }
    }

    private void init() {
        yA();
        HH();
        this.bcc = com.baidu.adp.lib.g.b.ei().inflate(getPageContext().getPageActivity(), com.baidu.tieba.x.home_dialog_search_footer, null);
        this.bsv.setOnFocusChangeListener(new n(this));
        this.bsx.setText(getPageContext().getString(com.baidu.tieba.z.enter_forum));
        this.bsx.setOnClickListener(this.bsR);
        this.bsy = (FrameLayout) findViewById(com.baidu.tieba.w.frame_layout);
        this.bsz = (LinearLayoutDetectsSoftKeyboard) findViewById(com.baidu.tieba.w.parent);
        this.bsz.setOnSoftKeyBoardShownListener(new o(this));
        this.bsz.setOnTouchListener(new p(this));
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.u.ds80)), null, null);
        this.bsy.addView(this.mNoDataView);
        this.bsv.setOnEditorActionListener(new q(this));
        this.bsw.setOnClickListener(new r(this));
        this.bsv.addTextChangedListener(new s(this));
        this.bsB = (FrameLayout) findViewById(com.baidu.tieba.w.home_search_list);
        this.bsC = (ListView) findViewById(com.baidu.tieba.w.home_lv_search);
        this.bsH = (Button) this.bcc.findViewById(com.baidu.tieba.w.home_bt_search_footer);
        this.bsH.setOnClickListener(new u(this));
        this.bsC.addFooterView(this.bcc, null, true);
        this.bsF = new am(this, null);
        this.bsD = new a(this, null);
        this.bsC.setAdapter((ListAdapter) this.bsD);
        this.bsC.setOnItemClickListener(new y(this));
        this.bsE = (ListView) findViewById(com.baidu.tieba.w.home_lv_suggest);
        this.bsG = new e(getPageContext().getPageActivity());
        this.bsE.setOnItemClickListener(new z(this));
        aa aaVar = new aa(this);
        this.bsE.setOnScrollListener(aaVar);
        this.bsC.setOnScrollListener(aaVar);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.w.home_progress_search);
        this.mProgress.setVisibility(8);
        this.bsv.setText("");
        this.bsv.requestFocus();
        Ud();
        ShowSoftKeyPadDelay(this.bsv, 150);
        if (TbadkSettings.getInst().loadBoolean("search_mode", true)) {
            gN(0);
        } else {
            gN(1);
        }
    }

    private void HH() {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new ab(this));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.x.square_search_navigation_view, (View.OnClickListener) null);
        this.bsA = (ImageView) addCustomView.findViewById(com.baidu.tieba.w.search_bar_icon);
        this.bsv = (EditText) addCustomView.findViewById(com.baidu.tieba.w.home_et_search);
        this.bsw = (Button) addCustomView.findViewById(com.baidu.tieba.w.home_bt_search_del);
        this.bsx = (TextView) addCustomView.findViewById(com.baidu.tieba.w.home_bt_search_s);
    }

    private void yA() {
        this.bsX = (FragmentTabWidget) findViewById(com.baidu.tieba.w.square_search_tab_widget);
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(com.baidu.tieba.u.ds32));
        fragmentTabIndicator.setGravity(17);
        fragmentTabIndicator.acl = com.baidu.tieba.t.main_bottom_button_color;
        fragmentTabIndicator.setText(getResources().getString(com.baidu.tieba.z.search_bar_text));
        FragmentTabIndicator fragmentTabIndicator2 = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator2.acl = com.baidu.tieba.t.main_bottom_button_color;
        fragmentTabIndicator2.setTextSize(0, getResources().getDimension(com.baidu.tieba.u.ds32));
        fragmentTabIndicator2.setGravity(17);
        fragmentTabIndicator2.setText(getResources().getString(com.baidu.tieba.z.search_post_text));
        FragmentTabIndicator fragmentTabIndicator3 = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator3.acl = com.baidu.tieba.t.main_bottom_button_color;
        fragmentTabIndicator3.setTextSize(0, getResources().getDimension(com.baidu.tieba.u.ds32));
        fragmentTabIndicator3.setGravity(17);
        fragmentTabIndicator3.setText(getResources().getString(com.baidu.tieba.z.search_person));
        FragmentTabIndicator fragmentTabIndicator4 = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator4.acl = com.baidu.tieba.t.main_bottom_button_color;
        fragmentTabIndicator4.setTextSize(0, getResources().getDimension(com.baidu.tieba.u.ds32));
        fragmentTabIndicator4.setGravity(17);
        fragmentTabIndicator4.setText(getResources().getString(com.baidu.tieba.z.search_in_baidu_text));
        this.bsX.addView(fragmentTabIndicator);
        this.bsX.addView(fragmentTabIndicator2);
        this.bsX.addView(fragmentTabIndicator3);
        this.bsX.addView(fragmentTabIndicator4);
        this.bsX.d(0, true);
        this.bsX.setTabSelectionListener(new ac(this));
    }

    public void Ub() {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
    }

    public void gN(int i) {
        switch (i) {
            case 0:
                if (this.mMode != 0) {
                    this.mMode = 0;
                    this.bsx.setText(getPageContext().getString(com.baidu.tieba.z.enter_forum));
                    this.bsv.setHint(com.baidu.tieba.z.search_bar);
                    ru();
                    if (this.bsN.trim().length() > 0) {
                        Ug();
                        return;
                    } else {
                        Ud();
                        return;
                    }
                }
                return;
            case 1:
                if (this.mMode != 1) {
                    this.mMode = 1;
                    this.bsx.setText(getPageContext().getString(com.baidu.tieba.z.search));
                    this.bsv.setHint(com.baidu.tieba.z.search_post_hint);
                    ru();
                    if (this.bsN.trim().length() > 0) {
                        this.bsE.setVisibility(8);
                        y(1, this.bsN);
                        return;
                    }
                    Ue();
                    return;
                }
                return;
            case 2:
            default:
                return;
            case 3:
                if (this.mMode != 3) {
                    this.mMode = 3;
                    this.bsE.setVisibility(8);
                    this.bsx.setText(com.baidu.tieba.z.search);
                    this.bsv.setHint(com.baidu.tieba.z.search_friend_tip);
                    ru();
                    if (this.bsN.trim().length() <= 0) {
                        Uf();
                        return;
                    }
                    return;
                }
                return;
        }
    }

    public void Uc() {
        String trim = this.bsv.getText().toString().trim();
        if (!TextUtils.isEmpty(trim)) {
            if (UtilHelper.isNetOk()) {
                this.bsI = trim;
                if (this.bsx != null) {
                    this.bsx.setClickable(false);
                }
                sendMessage(ht(trim));
                return;
            }
            showToast(com.baidu.tieba.z.neterror);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ud() {
        this.bsE.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009002));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ue() {
        this.bsE.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009001));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uf() {
        this.bsE.setVisibility(8);
        if (!this.aeo) {
            sendMessage(new RequestSearchPersonHistoryReadMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() < 1 || ((4 == i && this.mMode != 0) || ((5 == i && this.mMode != 1) || (6 == i && this.mMode != 3)))) {
            this.bsB.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cp(com.baidu.tieba.z.text_no_search_record));
            return;
        }
        this.bsB.setVisibility(0);
        this.bsC.setVisibility(0);
        this.bsE.setVisibility(8);
        this.mNoDataView.setVisibility(8);
        this.bsD.s(arrayList);
        this.bsD.dp(4 == i);
        this.bsD.notifyDataSetInvalidated();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ug() {
        this.bsB.setVisibility(8);
        if (this.bsN != null) {
            if (this.bsN.equals(this.bsO)) {
                refresh();
                return;
            }
            this.mHandler.removeCallbacks(this.bsV);
            this.mHandler.postDelayed(this.bsV, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(int i, String str) {
        this.bsC.setVisibility(8);
        if (str != null) {
            try {
                if (str.trim().length() > 0) {
                    if (str.equals(this.bsP) && i == this.bsQ) {
                        refresh();
                    } else {
                        StringBuffer stringBuffer = new StringBuffer(30);
                        stringBuffer.append(TbConfig.SERVER_ADDRESS);
                        stringBuffer.append("c/s/searchpost");
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(new BasicNameValuePair("word", str));
                        arrayList.add(new BasicNameValuePair("pn", String.valueOf(i)));
                        arrayList.add(new BasicNameValuePair("rn", String.valueOf(50)));
                        arrayList.add(new BasicNameValuePair("st_type", "search_post"));
                        ru();
                        this.bsM = new al(this, stringBuffer.toString(), arrayList);
                        this.bsM.setPriority(3);
                        this.bsM.execute(new Object[0]);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.bsG.setRefreshing(0);
                this.bsG.notifyDataSetChanged();
            }
        }
    }

    private FRSPageRequestMessage ht(String str) {
        FRSPageRequestMessage fRSPageRequestMessage = new FRSPageRequestMessage();
        fRSPageRequestMessage.setKw(str);
        fRSPageRequestMessage.setPn(1);
        fRSPageRequestMessage.setForumModel(new com.baidu.tieba.tbadkCore.e());
        if (com.baidu.tbadk.core.l.lV().lZ()) {
            fRSPageRequestMessage.setRn(35);
        } else {
            fRSPageRequestMessage.setRn(50);
        }
        fRSPageRequestMessage.setWithGroup(1);
        int M = com.baidu.adp.lib.util.l.M(getPageContext().getPageActivity());
        int N = com.baidu.adp.lib.util.l.N(getPageContext().getPageActivity());
        float f = M / 320.0f;
        int i = bg.pB().pD() ? 2 : 1;
        fRSPageRequestMessage.setScrW(M);
        fRSPageRequestMessage.setScrH(N);
        fRSPageRequestMessage.setScrDip(f);
        fRSPageRequestMessage.setqType(i);
        return fRSPageRequestMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        try {
            if (this.mMode == 0) {
                if (this.bsJ != null) {
                    if (this.bsJ.forum_list != null && this.bsJ.forum_list.size() > 0) {
                        this.bsB.setVisibility(0);
                        this.bsC.setVisibility(8);
                        this.bsE.setVisibility(0);
                        this.mNoDataView.setVisibility(8);
                        this.bsE.setAdapter((ListAdapter) this.bsF);
                        this.bsF.G(this.bsJ.forum_list);
                        this.bsF.notifyDataSetInvalidated();
                    } else {
                        this.bsB.setVisibility(8);
                        this.mNoDataView.setVisibility(0);
                        this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cp(com.baidu.tieba.z.text_no_suggest));
                    }
                }
            } else if (this.bsK != null) {
                ArrayList<h> data = this.bsK.getData();
                if (data != null && data.size() > 0) {
                    this.bsB.setVisibility(0);
                    this.bsC.setVisibility(8);
                    this.bsE.setVisibility(0);
                    this.mNoDataView.setVisibility(8);
                    this.bsE.setAdapter((ListAdapter) this.bsG);
                    this.bsG.a(this.bsK);
                    this.bsG.notifyDataSetInvalidated();
                    if (this.bsK.hasPre()) {
                        this.bsE.setSelection(1);
                    }
                } else {
                    this.bsB.setVisibility(8);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cp(com.baidu.tieba.z.text_no_suggest));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bsX.onChangeSkinType(i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().h(this.bsz);
        bc.e(this.bsz, i);
        if (this.bsD != null) {
            this.bsD.notifyDataSetChanged();
        }
        if (this.bsF != null) {
            this.bsF.notifyDataSetChanged();
        }
        if (this.bsG != null) {
            this.bsG.notifyDataSetChanged();
        }
        bc.i(this.bsy, com.baidu.tieba.t.square_listview_bg);
        bc.i(this.bcc, com.baidu.tieba.t.square_listview_bg);
        bc.c(this.bsA, com.baidu.tieba.v.icon_search_ba);
        bc.b(this.bsx, com.baidu.tieba.t.common_new_page_title, 1);
        bc.b(this.bsH, com.baidu.tieba.t.cp_cont_b, 3);
        bc.i((View) this.bsH, com.baidu.tieba.v.clear_search_btn_drawable);
        if (i == 1) {
            this.bsv.setTextColor(-6574132);
            this.bsv.setHintTextColor(-11643034);
            return;
        }
        this.bsv.setTextColor(-2300171);
        this.bsv.setHintTextColor(-10195067);
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
            com.baidu.tbadk.core.b.b.e(getPageContext().getPageActivity(), 1);
        } else {
            com.baidu.tbadk.core.b.b.e(getPageContext().getPageActivity(), 2);
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
}
