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
    private String bsJ;
    private FragmentTabWidget bsY;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private EditText bsw = null;
    private Button bsx = null;
    private TextView bsy = null;
    private FrameLayout bsz = null;
    private LinearLayoutDetectsSoftKeyboard bsA = null;
    ImageView bsB = null;
    private FrameLayout bsC = null;
    private ListView bsD = null;
    private a bsE = null;
    private ListView bsF = null;
    private am bsG = null;
    private e bsH = null;
    private ProgressBar mProgress = null;
    private Button bsI = null;
    private View bcd = null;
    private BarSuggestModel bsK = null;
    private SearchPostModel bsL = null;
    private ak bsM = null;
    private al bsN = null;
    private String bsO = null;
    private int mMode = 0;
    private String bsP = null;
    private String bsQ = null;
    private int bsR = 0;
    private boolean aer = false;
    final View.OnClickListener bsS = new t(this);
    private final com.baidu.adp.framework.listener.e aDQ = new ad(this, 301001, true);
    private final HttpMessageListener aDR = new ae(this, CmdConfigHttp.FRS_HTTP_CMD, true);
    private CustomMessageListener bsT = new af(this, 2001195);
    private CustomMessageListener bsU = new ag(this, 2001194);
    private HttpMessageListener bsV = new ah(this, CmdConfigHttp.SEARCH_FRIEND_CMD);
    private final Handler mHandler = new Handler();
    private final Runnable bsW = new ai(this);
    private boolean bsX = true;
    private CustomMessageListener bsZ = new aj(this, 2009002);
    private CustomMessageListener bta = new j(this, 2009001);

    static {
        Ue();
        Uf();
        CustomMessageTask customMessageTask = new CustomMessageTask(2015002, new i());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        com.baidu.tieba.tbadkCore.a.a.b(2001194, d.class);
        com.baidu.tieba.tbadkCore.a.a.b(2001195, c.class);
    }

    private static void Ue() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2009002, new k());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void Uf() {
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
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createFlagCfg(this.bsJ, FrsActivityConfig.FRS_FROM_SEARCH, 1)));
        } else if (z2 && z && error == 3) {
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.z.login_to_use), true, 11013)));
            } else {
                sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), this.bsJ)));
            }
        } else {
            showToast(errorString);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fW(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SEARCH_FRIEND_CMD);
        httpMessage.addParam("search_key", str);
        sendMessage(httpMessage);
    }

    private void Tg() {
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
                    sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), this.bsJ)));
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
        Tg();
        registerListener(this.bsT);
        registerListener(this.bsU);
        registerListener(this.bsZ);
        registerListener(this.bta);
        registerListener(this.bsV);
        registerListener(this.aDQ);
        registerListener(this.aDR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bsy != null) {
            this.bsy.setClickable(true);
        }
        if (this.bsX) {
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
        Ug();
        rA();
    }

    public void rA() {
        this.mHandler.removeCallbacks(this.bsW);
        if (this.bsM != null) {
            this.bsM.cancel();
            this.bsM = null;
        }
        if (this.bsN != null) {
            this.bsN.cancel();
            this.bsN = null;
        }
    }

    private void init() {
        yG();
        HN();
        this.bcd = com.baidu.adp.lib.g.b.ei().inflate(getPageContext().getPageActivity(), com.baidu.tieba.x.home_dialog_search_footer, null);
        this.bsw.setOnFocusChangeListener(new n(this));
        this.bsy.setText(getPageContext().getString(com.baidu.tieba.z.enter_forum));
        this.bsy.setOnClickListener(this.bsS);
        this.bsz = (FrameLayout) findViewById(com.baidu.tieba.w.frame_layout);
        this.bsA = (LinearLayoutDetectsSoftKeyboard) findViewById(com.baidu.tieba.w.parent);
        this.bsA.setOnSoftKeyBoardShownListener(new o(this));
        this.bsA.setOnTouchListener(new p(this));
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.u.ds80)), null, null);
        this.bsz.addView(this.mNoDataView);
        this.bsw.setOnEditorActionListener(new q(this));
        this.bsx.setOnClickListener(new r(this));
        this.bsw.addTextChangedListener(new s(this));
        this.bsC = (FrameLayout) findViewById(com.baidu.tieba.w.home_search_list);
        this.bsD = (ListView) findViewById(com.baidu.tieba.w.home_lv_search);
        this.bsI = (Button) this.bcd.findViewById(com.baidu.tieba.w.home_bt_search_footer);
        this.bsI.setOnClickListener(new u(this));
        this.bsD.addFooterView(this.bcd, null, true);
        this.bsG = new am(this, null);
        this.bsE = new a(this, null);
        this.bsD.setAdapter((ListAdapter) this.bsE);
        this.bsD.setOnItemClickListener(new y(this));
        this.bsF = (ListView) findViewById(com.baidu.tieba.w.home_lv_suggest);
        this.bsH = new e(getPageContext().getPageActivity());
        this.bsF.setOnItemClickListener(new z(this));
        aa aaVar = new aa(this);
        this.bsF.setOnScrollListener(aaVar);
        this.bsD.setOnScrollListener(aaVar);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.w.home_progress_search);
        this.mProgress.setVisibility(8);
        this.bsw.setText("");
        this.bsw.requestFocus();
        Ui();
        ShowSoftKeyPadDelay(this.bsw, 150);
        if (TbadkSettings.getInst().loadBoolean("search_mode", true)) {
            gN(0);
        } else {
            gN(1);
        }
    }

    private void HN() {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new ab(this));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.x.square_search_navigation_view, (View.OnClickListener) null);
        this.bsB = (ImageView) addCustomView.findViewById(com.baidu.tieba.w.search_bar_icon);
        this.bsw = (EditText) addCustomView.findViewById(com.baidu.tieba.w.home_et_search);
        this.bsx = (Button) addCustomView.findViewById(com.baidu.tieba.w.home_bt_search_del);
        this.bsy = (TextView) addCustomView.findViewById(com.baidu.tieba.w.home_bt_search_s);
    }

    private void yG() {
        this.bsY = (FragmentTabWidget) findViewById(com.baidu.tieba.w.square_search_tab_widget);
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(com.baidu.tieba.u.ds32));
        fragmentTabIndicator.setGravity(17);
        fragmentTabIndicator.aco = com.baidu.tieba.t.main_bottom_button_color;
        fragmentTabIndicator.setText(getResources().getString(com.baidu.tieba.z.search_bar_text));
        FragmentTabIndicator fragmentTabIndicator2 = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator2.aco = com.baidu.tieba.t.main_bottom_button_color;
        fragmentTabIndicator2.setTextSize(0, getResources().getDimension(com.baidu.tieba.u.ds32));
        fragmentTabIndicator2.setGravity(17);
        fragmentTabIndicator2.setText(getResources().getString(com.baidu.tieba.z.search_post_text));
        FragmentTabIndicator fragmentTabIndicator3 = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator3.aco = com.baidu.tieba.t.main_bottom_button_color;
        fragmentTabIndicator3.setTextSize(0, getResources().getDimension(com.baidu.tieba.u.ds32));
        fragmentTabIndicator3.setGravity(17);
        fragmentTabIndicator3.setText(getResources().getString(com.baidu.tieba.z.search_person));
        FragmentTabIndicator fragmentTabIndicator4 = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator4.aco = com.baidu.tieba.t.main_bottom_button_color;
        fragmentTabIndicator4.setTextSize(0, getResources().getDimension(com.baidu.tieba.u.ds32));
        fragmentTabIndicator4.setGravity(17);
        fragmentTabIndicator4.setText(getResources().getString(com.baidu.tieba.z.search_in_baidu_text));
        this.bsY.addView(fragmentTabIndicator);
        this.bsY.addView(fragmentTabIndicator2);
        this.bsY.addView(fragmentTabIndicator3);
        this.bsY.addView(fragmentTabIndicator4);
        this.bsY.d(0, true);
        this.bsY.setTabSelectionListener(new ac(this));
    }

    public void Ug() {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
    }

    public void gN(int i) {
        switch (i) {
            case 0:
                if (this.mMode != 0) {
                    this.mMode = 0;
                    this.bsy.setText(getPageContext().getString(com.baidu.tieba.z.enter_forum));
                    this.bsw.setHint(com.baidu.tieba.z.search_bar);
                    rA();
                    if (this.bsO.trim().length() > 0) {
                        Ul();
                        return;
                    } else {
                        Ui();
                        return;
                    }
                }
                return;
            case 1:
                if (this.mMode != 1) {
                    this.mMode = 1;
                    this.bsy.setText(getPageContext().getString(com.baidu.tieba.z.search));
                    this.bsw.setHint(com.baidu.tieba.z.search_post_hint);
                    rA();
                    if (this.bsO.trim().length() > 0) {
                        this.bsF.setVisibility(8);
                        y(1, this.bsO);
                        return;
                    }
                    Uj();
                    return;
                }
                return;
            case 2:
            default:
                return;
            case 3:
                if (this.mMode != 3) {
                    this.mMode = 3;
                    this.bsF.setVisibility(8);
                    this.bsy.setText(com.baidu.tieba.z.search);
                    this.bsw.setHint(com.baidu.tieba.z.search_friend_tip);
                    rA();
                    if (this.bsO.trim().length() <= 0) {
                        Uk();
                        return;
                    }
                    return;
                }
                return;
        }
    }

    public void Uh() {
        String trim = this.bsw.getText().toString().trim();
        if (!TextUtils.isEmpty(trim)) {
            if (UtilHelper.isNetOk()) {
                this.bsJ = trim;
                if (this.bsy != null) {
                    this.bsy.setClickable(false);
                }
                sendMessage(hw(trim));
                return;
            }
            showToast(com.baidu.tieba.z.neterror);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ui() {
        this.bsF.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009002));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uj() {
        this.bsF.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009001));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uk() {
        this.bsF.setVisibility(8);
        if (!this.aer) {
            sendMessage(new RequestSearchPersonHistoryReadMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() < 1 || ((4 == i && this.mMode != 0) || ((5 == i && this.mMode != 1) || (6 == i && this.mMode != 3)))) {
            this.bsC.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cp(com.baidu.tieba.z.text_no_search_record));
            return;
        }
        this.bsC.setVisibility(0);
        this.bsD.setVisibility(0);
        this.bsF.setVisibility(8);
        this.mNoDataView.setVisibility(8);
        this.bsE.s(arrayList);
        this.bsE.dp(4 == i);
        this.bsE.notifyDataSetInvalidated();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ul() {
        this.bsC.setVisibility(8);
        if (this.bsO != null) {
            if (this.bsO.equals(this.bsP)) {
                refresh();
                return;
            }
            this.mHandler.removeCallbacks(this.bsW);
            this.mHandler.postDelayed(this.bsW, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(int i, String str) {
        this.bsD.setVisibility(8);
        if (str != null) {
            try {
                if (str.trim().length() > 0) {
                    if (str.equals(this.bsQ) && i == this.bsR) {
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
                        rA();
                        this.bsN = new al(this, stringBuffer.toString(), arrayList);
                        this.bsN.setPriority(3);
                        this.bsN.execute(new Object[0]);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.bsH.setRefreshing(0);
                this.bsH.notifyDataSetChanged();
            }
        }
    }

    private FRSPageRequestMessage hw(String str) {
        FRSPageRequestMessage fRSPageRequestMessage = new FRSPageRequestMessage();
        fRSPageRequestMessage.setKw(str);
        fRSPageRequestMessage.setPn(1);
        fRSPageRequestMessage.setForumModel(new com.baidu.tieba.tbadkCore.e());
        if (com.baidu.tbadk.core.l.mc().mg()) {
            fRSPageRequestMessage.setRn(35);
        } else {
            fRSPageRequestMessage.setRn(50);
        }
        fRSPageRequestMessage.setWithGroup(1);
        int M = com.baidu.adp.lib.util.l.M(getPageContext().getPageActivity());
        int N = com.baidu.adp.lib.util.l.N(getPageContext().getPageActivity());
        float f = M / 320.0f;
        int i = bg.pI().pK() ? 2 : 1;
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
                if (this.bsK != null) {
                    if (this.bsK.forum_list != null && this.bsK.forum_list.size() > 0) {
                        this.bsC.setVisibility(0);
                        this.bsD.setVisibility(8);
                        this.bsF.setVisibility(0);
                        this.mNoDataView.setVisibility(8);
                        this.bsF.setAdapter((ListAdapter) this.bsG);
                        this.bsG.G(this.bsK.forum_list);
                        this.bsG.notifyDataSetInvalidated();
                    } else {
                        this.bsC.setVisibility(8);
                        this.mNoDataView.setVisibility(0);
                        this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cp(com.baidu.tieba.z.text_no_suggest));
                    }
                }
            } else if (this.bsL != null) {
                ArrayList<h> data = this.bsL.getData();
                if (data != null && data.size() > 0) {
                    this.bsC.setVisibility(0);
                    this.bsD.setVisibility(8);
                    this.bsF.setVisibility(0);
                    this.mNoDataView.setVisibility(8);
                    this.bsF.setAdapter((ListAdapter) this.bsH);
                    this.bsH.a(this.bsL);
                    this.bsH.notifyDataSetInvalidated();
                    if (this.bsL.hasPre()) {
                        this.bsF.setSelection(1);
                    }
                } else {
                    this.bsC.setVisibility(8);
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
        this.bsY.onChangeSkinType(i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().h(this.bsA);
        bc.e(this.bsA, i);
        if (this.bsE != null) {
            this.bsE.notifyDataSetChanged();
        }
        if (this.bsG != null) {
            this.bsG.notifyDataSetChanged();
        }
        if (this.bsH != null) {
            this.bsH.notifyDataSetChanged();
        }
        bc.i(this.bsz, com.baidu.tieba.t.square_listview_bg);
        bc.i(this.bcd, com.baidu.tieba.t.square_listview_bg);
        bc.c(this.bsB, com.baidu.tieba.v.icon_search_ba);
        bc.b(this.bsy, com.baidu.tieba.t.common_new_page_title, 1);
        bc.b(this.bsI, com.baidu.tieba.t.cp_cont_b, 3);
        bc.i((View) this.bsI, com.baidu.tieba.v.clear_search_btn_drawable);
        if (i == 1) {
            this.bsw.setTextColor(-6574132);
            this.bsw.setHintTextColor(-11643034);
            return;
        }
        this.bsw.setTextColor(-2300171);
        this.bsw.setHintTextColor(-10195067);
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
