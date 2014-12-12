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
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bb;
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
    private FragmentTabWidget brC;
    private String brm;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private EditText bqY = null;
    private Button bqZ = null;
    private TextView bra = null;
    private FrameLayout brb = null;
    private LinearLayoutDetectsSoftKeyboard brc = null;
    ImageView brd = null;
    private FrameLayout bre = null;
    private ListView brf = null;
    private a brg = null;
    private ListView brh = null;
    private a bri = null;
    private am brj = null;
    private e brk = null;
    private ProgressBar mProgress = null;
    private Button brl = null;
    private View baI = null;
    private BarSuggestModel brn = null;
    private SearchPostModel bro = null;
    private ak brp = null;
    private al brq = null;
    private String brr = null;
    private int mMode = 0;
    private String brs = null;
    private String brt = null;
    private int bru = 0;
    private boolean adU = false;
    private boolean brv = true;
    final View.OnClickListener brw = new t(this);
    private final com.baidu.adp.framework.listener.e aCP = new ad(this, 301001, true);
    private final HttpMessageListener aCQ = new ae(this, CmdConfigHttp.FRS_HTTP_CMD, true);
    private CustomMessageListener brx = new af(this, 2001195);
    private CustomMessageListener bry = new ag(this, 2001194);
    private HttpMessageListener brz = new ah(this, CmdConfigHttp.SEARCH_FRIEND_CMD);
    private final Handler mHandler = new Handler();
    private final Runnable brA = new ai(this);
    private boolean brB = true;
    private CustomMessageListener brD = new aj(this, 2009002);
    private CustomMessageListener brE = new j(this, 2009001);

    static {
        TI();
        TJ();
        CustomMessageTask customMessageTask = new CustomMessageTask(2015002, new i());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        com.baidu.tieba.tbadkCore.a.a.b(2001194, d.class);
        com.baidu.tieba.tbadkCore.a.a.b(2001195, c.class);
    }

    private static void TI() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2009002, new k());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void TJ() {
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
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createFlagCfg(this.brm, FrsActivityConfig.FRS_FROM_SEARCH, 1)));
        } else if (z2 && z && error == 3) {
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.z.login_to_use), true, 11013)));
            } else {
                sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), this.brm)));
            }
        } else {
            showToast(errorString);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fR(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SEARCH_FRIEND_CMD);
        httpMessage.addParam("search_key", str);
        sendMessage(httpMessage);
    }

    private void SK() {
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
                    sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), this.brm)));
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
        if (!AA()) {
            setContentView(com.baidu.tieba.x.home_dialog_search);
            init();
            getWindow().setSoftInputMode(1);
            SK();
            registerListener(this.brx);
            registerListener(this.bry);
            registerListener(this.brD);
            registerListener(this.brE);
            registerListener(this.brz);
            registerListener(this.aCP);
            registerListener(this.aCQ);
        }
    }

    private boolean AA() {
        if ("from_hao123".equals(getIntent().getStringExtra("start_from")) && UtilHelper.FirstStartActivity(getPageContext().getPageActivity())) {
            Intent intent = new Intent();
            intent.putExtra("class", 18);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LogoActivityConfig(getPageContext().getPageActivity(), intent)));
            finish();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.brv = true;
        if (this.brB) {
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
        TK();
        rp();
    }

    public void rp() {
        this.mHandler.removeCallbacks(this.brA);
        if (this.brp != null) {
            this.brp.cancel();
            this.brp = null;
        }
        if (this.brq != null) {
            this.brq.cancel();
            this.brq = null;
        }
    }

    private void init() {
        yq();
        Hp();
        this.baI = com.baidu.adp.lib.g.b.ek().inflate(getPageContext().getPageActivity(), com.baidu.tieba.x.home_dialog_search_footer, null);
        this.bqY.setOnFocusChangeListener(new n(this));
        this.bra.setText(getPageContext().getString(com.baidu.tieba.z.enter_forum));
        this.bra.setOnClickListener(this.brw);
        this.brb = (FrameLayout) findViewById(com.baidu.tieba.w.frame_layout);
        this.brc = (LinearLayoutDetectsSoftKeyboard) findViewById(com.baidu.tieba.w.parent);
        this.brc.setOnSoftKeyBoardShownListener(new o(this));
        this.brc.setOnTouchListener(new p(this));
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.u.ds80)), null, null);
        this.brb.addView(this.mNoDataView);
        this.bqY.setOnEditorActionListener(new q(this));
        this.bqZ.setOnClickListener(new r(this));
        this.bqY.addTextChangedListener(new s(this));
        this.bre = (FrameLayout) findViewById(com.baidu.tieba.w.home_search_list);
        this.brf = (ListView) findViewById(com.baidu.tieba.w.home_lv_search);
        this.brl = (Button) this.baI.findViewById(com.baidu.tieba.w.home_bt_search_footer);
        this.brl.setOnClickListener(new u(this));
        this.brf.addFooterView(this.baI, null, true);
        this.brj = new am(this, null);
        this.brg = new a(this, null);
        this.brf.setAdapter((ListAdapter) this.brg);
        this.brf.setOnItemClickListener(new y(this));
        this.brh = (ListView) findViewById(com.baidu.tieba.w.home_lv_suggest);
        this.bri = new a(this, null);
        this.brk = new e(getPageContext().getPageActivity());
        this.brh.setAdapter((ListAdapter) this.bri);
        this.brh.setOnItemClickListener(new z(this));
        aa aaVar = new aa(this);
        this.brh.setOnScrollListener(aaVar);
        this.brf.setOnScrollListener(aaVar);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.w.home_progress_search);
        this.mProgress.setVisibility(8);
        this.bqY.setText("");
        this.bqY.requestFocus();
        TL();
        ShowSoftKeyPadDelay(this.bqY, 150);
        if (TbadkSettings.getInst().loadBoolean("search_mode", true)) {
            gE(0);
        } else {
            gE(1);
        }
    }

    private void Hp() {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new ab(this));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.x.square_search_navigation_view, (View.OnClickListener) null);
        this.brd = (ImageView) addCustomView.findViewById(com.baidu.tieba.w.search_bar_icon);
        this.bqY = (EditText) addCustomView.findViewById(com.baidu.tieba.w.home_et_search);
        this.bqZ = (Button) addCustomView.findViewById(com.baidu.tieba.w.home_bt_search_del);
        this.bra = (TextView) addCustomView.findViewById(com.baidu.tieba.w.home_bt_search_s);
    }

    private void yq() {
        this.brC = (FragmentTabWidget) findViewById(com.baidu.tieba.w.square_search_tab_widget);
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(com.baidu.tieba.u.ds32));
        fragmentTabIndicator.setGravity(17);
        fragmentTabIndicator.abR = com.baidu.tieba.t.main_bottom_button_color;
        fragmentTabIndicator.setText(getResources().getString(com.baidu.tieba.z.search_bar_text));
        FragmentTabIndicator fragmentTabIndicator2 = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator2.abR = com.baidu.tieba.t.main_bottom_button_color;
        fragmentTabIndicator2.setTextSize(0, getResources().getDimension(com.baidu.tieba.u.ds32));
        fragmentTabIndicator2.setGravity(17);
        fragmentTabIndicator2.setText(getResources().getString(com.baidu.tieba.z.search_post_text));
        FragmentTabIndicator fragmentTabIndicator3 = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator3.abR = com.baidu.tieba.t.main_bottom_button_color;
        fragmentTabIndicator3.setTextSize(0, getResources().getDimension(com.baidu.tieba.u.ds32));
        fragmentTabIndicator3.setGravity(17);
        fragmentTabIndicator3.setText(getResources().getString(com.baidu.tieba.z.search_person));
        FragmentTabIndicator fragmentTabIndicator4 = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator4.abR = com.baidu.tieba.t.main_bottom_button_color;
        fragmentTabIndicator4.setTextSize(0, getResources().getDimension(com.baidu.tieba.u.ds32));
        fragmentTabIndicator4.setGravity(17);
        fragmentTabIndicator4.setText(getResources().getString(com.baidu.tieba.z.search_in_baidu_text));
        this.brC.addView(fragmentTabIndicator);
        this.brC.addView(fragmentTabIndicator2);
        this.brC.addView(fragmentTabIndicator3);
        this.brC.addView(fragmentTabIndicator4);
        this.brC.d(0, true);
        this.brC.setTabSelectionListener(new ac(this));
    }

    public void TK() {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
    }

    public void gE(int i) {
        switch (i) {
            case 0:
                if (this.mMode != 0) {
                    this.mMode = 0;
                    this.bra.setText(getPageContext().getString(com.baidu.tieba.z.enter_forum));
                    this.bqY.setHint(com.baidu.tieba.z.search_bar);
                    rp();
                    if (this.brr.trim().length() > 0) {
                        TO();
                        return;
                    } else {
                        TL();
                        return;
                    }
                }
                return;
            case 1:
                if (this.mMode != 1) {
                    this.mMode = 1;
                    this.bra.setText(getPageContext().getString(com.baidu.tieba.z.search));
                    this.bqY.setHint(com.baidu.tieba.z.search_post_hint);
                    rp();
                    if (this.brr.trim().length() > 0) {
                        this.brh.setVisibility(8);
                        y(1, this.brr);
                        return;
                    }
                    TM();
                    return;
                }
                return;
            case 2:
            default:
                return;
            case 3:
                if (this.mMode != 3) {
                    this.mMode = 3;
                    this.brh.setVisibility(8);
                    this.bra.setText(com.baidu.tieba.z.search);
                    this.bqY.setHint(com.baidu.tieba.z.search_friend_tip);
                    rp();
                    if (this.brr.trim().length() <= 0) {
                        TN();
                        return;
                    }
                    return;
                }
                return;
        }
    }

    public void startSearch() {
        String trim = this.bqY.getText().toString().trim();
        if (!TextUtils.isEmpty(trim)) {
            if (UtilHelper.isNetOk()) {
                this.brm = trim;
                this.brv = false;
                sendMessage(hp(trim));
                return;
            }
            showToast(com.baidu.tieba.z.neterror);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TL() {
        this.brh.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009002));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TM() {
        this.brh.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009001));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TN() {
        this.brh.setVisibility(8);
        if (!this.adU) {
            sendMessage(new RequestSearchPersonHistoryReadMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() < 1 || ((4 == i && this.mMode != 0) || ((5 == i && this.mMode != 1) || (6 == i && this.mMode != 3)))) {
            this.bre.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.ci(com.baidu.tieba.z.text_no_search_record));
            return;
        }
        this.bre.setVisibility(0);
        this.brf.setVisibility(0);
        this.brh.setVisibility(8);
        this.mNoDataView.setVisibility(8);
        this.brg.r(arrayList);
        this.brg.dj(4 == i);
        this.brg.notifyDataSetInvalidated();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TO() {
        this.bre.setVisibility(8);
        if (this.brr != null) {
            if (this.brr.equals(this.brs)) {
                refresh();
                return;
            }
            this.mHandler.removeCallbacks(this.brA);
            this.mHandler.postDelayed(this.brA, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(int i, String str) {
        this.brf.setVisibility(8);
        if (str != null) {
            try {
                if (str.trim().length() > 0) {
                    if (str.equals(this.brt) && i == this.bru) {
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
                        rp();
                        this.brq = new al(this, stringBuffer.toString(), arrayList);
                        this.brq.setPriority(3);
                        this.brq.execute(new Object[0]);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.brk.setRefreshing(0);
                this.brk.notifyDataSetChanged();
            }
        }
    }

    private FRSPageRequestMessage hp(String str) {
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
        int i = bb.px().pz() ? 2 : 1;
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
                if (this.brn != null) {
                    if (this.brn.forum_list != null && this.brn.forum_list.size() > 0) {
                        this.bre.setVisibility(0);
                        this.brf.setVisibility(8);
                        this.brh.setVisibility(0);
                        this.mNoDataView.setVisibility(8);
                        this.brh.setAdapter((ListAdapter) this.brj);
                        this.brj.F(this.brn.forum_list);
                        this.brj.notifyDataSetInvalidated();
                    } else {
                        this.bre.setVisibility(8);
                        this.mNoDataView.setVisibility(0);
                        this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.ci(com.baidu.tieba.z.text_no_suggest));
                    }
                }
            } else if (this.bro != null) {
                ArrayList<h> data = this.bro.getData();
                if (data != null && data.size() > 0) {
                    this.bre.setVisibility(0);
                    this.brf.setVisibility(8);
                    this.brh.setVisibility(0);
                    this.mNoDataView.setVisibility(8);
                    this.brh.setAdapter((ListAdapter) this.brk);
                    this.brk.a(this.bro);
                    this.brk.notifyDataSetInvalidated();
                    if (this.bro.hasPre()) {
                        this.brh.setSelection(1);
                    }
                } else {
                    this.bre.setVisibility(8);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.ci(com.baidu.tieba.z.text_no_suggest));
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
        this.brC.onChangeSkinType(i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().h(this.brc);
        ax.e(this.brc, i);
        if (this.brg != null) {
            this.brg.notifyDataSetChanged();
        }
        if (this.bri != null) {
            this.bri.notifyDataSetChanged();
        }
        if (this.brj != null) {
            this.brj.notifyDataSetChanged();
        }
        if (this.brk != null) {
            this.brk.notifyDataSetChanged();
        }
        ax.i(this.brb, com.baidu.tieba.t.square_listview_bg);
        ax.i(this.baI, com.baidu.tieba.t.square_listview_bg);
        ax.c(this.brd, com.baidu.tieba.v.icon_search_ba);
        ax.b(this.bra, com.baidu.tieba.t.common_new_page_title, 1);
        ax.b(this.brl, com.baidu.tieba.t.cp_cont_b, 3);
        ax.i((View) this.brl, com.baidu.tieba.v.clear_search_btn_drawable);
        if (i == 1) {
            this.bqY.setTextColor(-6574132);
            this.bqY.setHintTextColor(-11643034);
            return;
        }
        this.bqY.setTextColor(-2300171);
        this.bqY.setHintTextColor(-10195067);
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
