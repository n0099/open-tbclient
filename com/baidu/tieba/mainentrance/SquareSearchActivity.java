package com.baidu.tieba.mainentrance;

import android.app.Activity;
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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.CreateBarGuideActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tbadk.coreExtra.search.ResponseSearchFriendMessage;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.data.SearchPostModel;
import com.baidu.tieba.data.aq;
import com.baidu.tieba.frs.FRSPageRequestMessage;
import com.baidu.tieba.model.BarSuggestModel;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class SquareSearchActivity extends BaseActivity {
    private com.baidu.tbadk.core.view.o ahO;
    private FragmentTabWidget bmL;
    private String bmv;
    private NavigationBar mNavigationBar;
    private EditText bmh = null;
    private Button bmi = null;
    private TextView bmj = null;
    private FrameLayout bmk = null;
    private LinearLayoutDetectsSoftKeyboard bml = null;
    ImageView bmm = null;
    private FrameLayout bmn = null;
    private ListView bmo = null;
    private a bmp = null;
    private ListView bmq = null;
    private a bmr = null;
    private al bms = null;
    private e bmt = null;
    private ProgressBar mProgress = null;
    private Button bmu = null;
    private View aWc = null;
    private BarSuggestModel bmw = null;
    private SearchPostModel bmx = null;
    private aj bmy = null;
    private ak bmz = null;
    private String bmA = null;
    private int mMode = 0;
    private String bmB = null;
    private String bmC = null;
    private int bmD = 0;
    private boolean XI = false;
    private boolean bmE = true;
    final View.OnClickListener bmF = new s(this);
    private final com.baidu.adp.framework.listener.e aBe = new ac(this, 301001, true);
    private final HttpMessageListener aBf = new ad(this, CmdConfigHttp.FRS_HTTP_CMD, true);
    private CustomMessageListener bmG = new ae(this, 2001195);
    private CustomMessageListener bmH = new af(this, 2001194);
    private HttpMessageListener bmI = new ag(this, CmdConfigHttp.SEARCH_FRIEND_CMD);
    private final Handler mHandler = new Handler();
    private final Runnable bmJ = new ah(this);
    private boolean bmK = true;
    private CustomMessageListener bmM = new ai(this, 2009002);
    private CustomMessageListener bmN = new i(this, 2009001);

    static {
        SB();
        SC();
        CustomMessageTask customMessageTask = new CustomMessageTask(2015002, new h());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        com.baidu.tieba.ai.b(2001194, d.class);
        com.baidu.tieba.ai.b(2001195, c.class);
    }

    private static void SB() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2009002, new j());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void SC() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2009001, new k());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponsedMessage<?> responsedMessage, boolean z) {
        int error = responsedMessage.getError();
        String errorString = responsedMessage.getErrorString();
        boolean z2 = error < -13 || error > -10;
        if (error == 0) {
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this).createFlagCfg(this.bmv, FrsActivityConfig.FRS_FROM_SEARCH, 1)));
        } else if (z2 && z && error == 3) {
            if (TextUtils.isEmpty(TbadkApplication.getCurrentAccount())) {
                LoginActivity.a((Activity) this, getString(com.baidu.tieba.y.login_to_use), true, 11013);
            } else {
                sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(this, this.bmv)));
            }
        } else {
            showToast(errorString);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fz(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SEARCH_FRIEND_CMD);
        httpMessage.addParam("search_key", str);
        sendMessage(httpMessage);
    }

    private void Ru() {
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
                    sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(this, this.bmv)));
                    finish();
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!xf()) {
            setContentView(com.baidu.tieba.w.home_dialog_search);
            init();
            getWindow().setSoftInputMode(1);
            Ru();
            registerListener(this.bmG);
            registerListener(this.bmH);
            registerListener(this.bmM);
            registerListener(this.bmN);
            registerListener(this.bmI);
            registerListener(this.aBe);
            registerListener(this.aBf);
        }
    }

    private boolean xf() {
        if ("from_hao123".equals(getIntent().getStringExtra("start_from")) && com.baidu.tieba.util.q.l(this)) {
            Intent intent = new Intent();
            intent.putExtra("class", 18);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LogoActivityConfig(this, intent)));
            finish();
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.bmE = true;
        if (this.bmK) {
            this.mHandler.post(new l(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mMode = 0;
        if (this.mMode == 0) {
            com.baidu.tieba.aj.wk().aP(true);
        } else {
            com.baidu.tieba.aj.wk().aP(false);
        }
        Sy();
        oo();
    }

    public void oo() {
        this.mHandler.removeCallbacks(this.bmJ);
        if (this.bmy != null) {
            this.bmy.cancel();
            this.bmy = null;
        }
        if (this.bmz != null) {
            this.bmz.cancel();
            this.bmz = null;
        }
    }

    private void init() {
        Hg();
        Hf();
        this.aWc = com.baidu.adp.lib.g.b.ek().inflate(this, com.baidu.tieba.w.home_dialog_search_footer, null);
        this.bmh.setOnFocusChangeListener(new m(this));
        this.bmj.setText(getString(com.baidu.tieba.y.enter_forum));
        this.bmj.setOnClickListener(this.bmF);
        this.bmk = (FrameLayout) findViewById(com.baidu.tieba.v.frame_layout);
        this.bml = (LinearLayoutDetectsSoftKeyboard) findViewById(com.baidu.tieba.v.parent);
        this.bml.setOnSoftKeyBoardShownListener(new n(this));
        this.bml.setOnTouchListener(new o(this));
        this.ahO = NoDataViewFactory.a(this, null, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.t.ds80)), null, null);
        this.bmk.addView(this.ahO);
        this.bmh.setOnEditorActionListener(new p(this));
        this.bmi.setOnClickListener(new q(this));
        this.bmh.addTextChangedListener(new r(this));
        this.bmn = (FrameLayout) findViewById(com.baidu.tieba.v.home_search_list);
        this.bmo = (ListView) findViewById(com.baidu.tieba.v.home_lv_search);
        this.bmu = (Button) this.aWc.findViewById(com.baidu.tieba.v.home_bt_search_footer);
        this.bmu.setOnClickListener(new t(this));
        this.bmo.addFooterView(this.aWc, null, true);
        this.bms = new al(this, null);
        this.bmp = new a(this, null);
        this.bmo.setAdapter((ListAdapter) this.bmp);
        this.bmo.setOnItemClickListener(new x(this));
        this.bmq = (ListView) findViewById(com.baidu.tieba.v.home_lv_suggest);
        this.bmr = new a(this, null);
        this.bmt = new e(this);
        this.bmq.setAdapter((ListAdapter) this.bmr);
        this.bmq.setOnItemClickListener(new y(this));
        z zVar = new z(this);
        this.bmq.setOnScrollListener(zVar);
        this.bmo.setOnScrollListener(zVar);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.v.home_progress_search);
        this.mProgress.setVisibility(8);
        this.bmh.setText("");
        this.bmh.requestFocus();
        SD();
        ShowSoftKeyPadDelay(this.bmh, 150);
        if (com.baidu.tieba.aj.wk().wt()) {
            gt(0);
        } else {
            gt(1);
        }
    }

    private void Hf() {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new aa(this));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.w.square_search_navigation_view, (View.OnClickListener) null);
        this.bmm = (ImageView) addCustomView.findViewById(com.baidu.tieba.v.search_bar_icon);
        this.bmh = (EditText) addCustomView.findViewById(com.baidu.tieba.v.home_et_search);
        this.bmi = (Button) addCustomView.findViewById(com.baidu.tieba.v.home_bt_search_del);
        this.bmj = (TextView) addCustomView.findViewById(com.baidu.tieba.v.home_bt_search_s);
    }

    private void Hg() {
        this.bmL = (FragmentTabWidget) findViewById(com.baidu.tieba.v.square_search_tab_widget);
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this);
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(com.baidu.tieba.t.ds32));
        fragmentTabIndicator.setGravity(17);
        fragmentTabIndicator.VN = com.baidu.tieba.s.main_bottom_button_color;
        fragmentTabIndicator.setText(getResources().getString(com.baidu.tieba.y.search_bar_text));
        FragmentTabIndicator fragmentTabIndicator2 = new FragmentTabIndicator(this);
        fragmentTabIndicator2.VN = com.baidu.tieba.s.main_bottom_button_color;
        fragmentTabIndicator2.setTextSize(0, getResources().getDimension(com.baidu.tieba.t.ds32));
        fragmentTabIndicator2.setGravity(17);
        fragmentTabIndicator2.setText(getResources().getString(com.baidu.tieba.y.search_post_text));
        FragmentTabIndicator fragmentTabIndicator3 = new FragmentTabIndicator(this);
        fragmentTabIndicator3.VN = com.baidu.tieba.s.main_bottom_button_color;
        fragmentTabIndicator3.setTextSize(0, getResources().getDimension(com.baidu.tieba.t.ds32));
        fragmentTabIndicator3.setGravity(17);
        fragmentTabIndicator3.setText(getResources().getString(com.baidu.tieba.y.search_person));
        FragmentTabIndicator fragmentTabIndicator4 = new FragmentTabIndicator(this);
        fragmentTabIndicator4.VN = com.baidu.tieba.s.main_bottom_button_color;
        fragmentTabIndicator4.setTextSize(0, getResources().getDimension(com.baidu.tieba.t.ds32));
        fragmentTabIndicator4.setGravity(17);
        fragmentTabIndicator4.setText(getResources().getString(com.baidu.tieba.y.search_in_baidu_text));
        this.bmL.addView(fragmentTabIndicator);
        this.bmL.addView(fragmentTabIndicator2);
        this.bmL.addView(fragmentTabIndicator3);
        this.bmL.addView(fragmentTabIndicator4);
        this.bmL.d(0, true);
        this.bmL.setTabSelectionListener(new ab(this));
    }

    public void Sy() {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.bmt != null) {
            this.bmt.Sy();
        }
    }

    public void gt(int i) {
        switch (i) {
            case 0:
                if (this.mMode != 0) {
                    this.mMode = 0;
                    this.bmj.setText(getString(com.baidu.tieba.y.enter_forum));
                    this.bmh.setHint(com.baidu.tieba.y.search_bar);
                    oo();
                    if (this.bmA.trim().length() > 0) {
                        SG();
                        return;
                    } else {
                        SD();
                        return;
                    }
                }
                return;
            case 1:
                if (this.mMode != 1) {
                    this.mMode = 1;
                    this.bmj.setText(getString(com.baidu.tieba.y.search));
                    this.bmh.setHint(com.baidu.tieba.y.search_post_hint);
                    oo();
                    if (this.bmA.trim().length() > 0) {
                        this.bmq.setVisibility(8);
                        o(1, this.bmA);
                        return;
                    }
                    SE();
                    return;
                }
                return;
            case 2:
            default:
                return;
            case 3:
                if (this.mMode != 3) {
                    this.mMode = 3;
                    this.bmq.setVisibility(8);
                    this.bmj.setText(com.baidu.tieba.y.search);
                    this.bmh.setHint(com.baidu.tieba.y.search_friend_tip);
                    oo();
                    if (this.bmA.trim().length() <= 0) {
                        SF();
                        return;
                    }
                    return;
                }
                return;
        }
    }

    public void startSearch() {
        String trim = this.bmh.getText().toString().trim();
        if (UtilHelper.isNetOk()) {
            this.bmv = trim;
            this.bmE = false;
            sendMessage(gM(trim));
            return;
        }
        showToast(com.baidu.tieba.y.neterror);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SD() {
        this.bmq.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009002));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SE() {
        this.bmq.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009001));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SF() {
        this.bmq.setVisibility(8);
        if (!this.XI) {
            sendMessage(new RequestSearchPersonHistoryReadMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() < 1 || ((4 == i && this.mMode != 0) || ((5 == i && this.mMode != 1) || (6 == i && this.mMode != 3)))) {
            this.bmn.setVisibility(8);
            this.ahO.setVisibility(0);
            this.ahO.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.text_no_search_record));
            return;
        }
        this.bmn.setVisibility(0);
        this.bmo.setVisibility(0);
        this.bmq.setVisibility(8);
        this.ahO.setVisibility(8);
        this.bmp.setData(arrayList);
        this.bmp.dy(4 == i);
        this.bmp.notifyDataSetInvalidated();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SG() {
        this.bmn.setVisibility(8);
        if (this.bmA != null) {
            if (this.bmA.equals(this.bmB)) {
                refresh();
                return;
            }
            this.mHandler.removeCallbacks(this.bmJ);
            this.mHandler.postDelayed(this.bmJ, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i, String str) {
        this.bmo.setVisibility(8);
        if (str != null) {
            try {
                if (str.trim().length() > 0) {
                    if (str.equals(this.bmC) && i == this.bmD) {
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
                        oo();
                        this.bmz = new ak(this, stringBuffer.toString(), arrayList);
                        this.bmz.setPriority(3);
                        this.bmz.execute(new Object[0]);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.bmt.setRefreshing(0);
                this.bmt.notifyDataSetChanged();
            }
        }
    }

    private FRSPageRequestMessage gM(String str) {
        FRSPageRequestMessage fRSPageRequestMessage = new FRSPageRequestMessage();
        fRSPageRequestMessage.setKw(str);
        fRSPageRequestMessage.setPn(1);
        fRSPageRequestMessage.setForumModel(new com.baidu.tieba.frs.b());
        if (com.baidu.tbadk.core.k.js().jw()) {
            fRSPageRequestMessage.setRn(35);
        } else {
            fRSPageRequestMessage.setRn(50);
        }
        fRSPageRequestMessage.setWithGroup(1);
        int n = com.baidu.adp.lib.util.m.n(this);
        int o = com.baidu.adp.lib.util.m.o(this);
        float f = n / 320.0f;
        int i = az.mD().mF() ? 2 : 1;
        fRSPageRequestMessage.setScrW(n);
        fRSPageRequestMessage.setScrH(o);
        fRSPageRequestMessage.setScrDip(f);
        fRSPageRequestMessage.setqType(i);
        return fRSPageRequestMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        try {
            if (this.mMode == 0) {
                if (this.bmw != null) {
                    if (this.bmw.forum_list != null && this.bmw.forum_list.size() > 0) {
                        this.bmn.setVisibility(0);
                        this.bmo.setVisibility(8);
                        this.bmq.setVisibility(0);
                        this.ahO.setVisibility(8);
                        this.bmq.setAdapter((ListAdapter) this.bms);
                        this.bms.x(this.bmw.forum_list);
                        this.bms.notifyDataSetInvalidated();
                    } else {
                        this.bmn.setVisibility(8);
                        this.ahO.setVisibility(0);
                        this.ahO.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.text_no_suggest));
                    }
                }
            } else if (this.bmx != null) {
                ArrayList<aq> data = this.bmx.getData();
                if (data != null && data.size() > 0) {
                    this.bmn.setVisibility(0);
                    this.bmo.setVisibility(8);
                    this.bmq.setVisibility(0);
                    this.ahO.setVisibility(8);
                    this.bmq.setAdapter((ListAdapter) this.bmt);
                    this.bmt.a(this.bmx);
                    this.bmt.notifyDataSetInvalidated();
                    if (this.bmx.hasPre()) {
                        this.bmq.setSelection(1);
                    }
                } else {
                    this.bmn.setVisibility(8);
                    this.ahO.setVisibility(0);
                    this.ahO.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.text_no_suggest));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ahO != null) {
            this.ahO.onChangeSkinType(i);
        }
        this.mNavigationBar.onChangeSkinType(i);
        this.bmL.onChangeSkinType(i);
        getLayoutMode().L(i == 1);
        getLayoutMode().h(this.bml);
        aw.d(this.bml, i);
        if (this.bmp != null) {
            this.bmp.notifyDataSetChanged();
        }
        if (this.bmr != null) {
            this.bmr.notifyDataSetChanged();
        }
        if (this.bms != null) {
            this.bms.notifyDataSetChanged();
        }
        if (this.bmt != null) {
            this.bmt.notifyDataSetChanged();
        }
        aw.h(this.bmk, com.baidu.tieba.s.square_listview_bg);
        aw.h(this.aWc, com.baidu.tieba.s.square_listview_bg);
        aw.c(this.bmm, com.baidu.tieba.u.icon_search_ba);
        aw.b(this.bmj, com.baidu.tieba.s.common_new_page_title, 1);
        aw.b(this.bmu, com.baidu.tieba.s.no_data_search_text_content, 3);
        aw.h((View) this.bmu, com.baidu.tieba.u.clear_search_btn_drawable);
        if (i == 1) {
            this.bmh.setTextColor(-6574132);
            this.bmh.setHintTextColor(-11643034);
            return;
        }
        this.bmh.setTextColor(-2300171);
        this.bmh.setHintTextColor(-10195067);
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
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            com.baidu.tbadk.core.b.b.d(this, 1);
        } else {
            com.baidu.tbadk.core.b.b.d(this, 2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onResourceRecycle() {
        super.onResourceRecycle();
        setSkinType(-1);
        if (this.ahO != null) {
            this.ahO.onActivityStop();
        }
    }
}
