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
import com.baidu.tbadk.core.util.ba;
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
    private com.baidu.tbadk.core.view.o ahX;
    private String bmJ;
    private FragmentTabWidget bmZ;
    private NavigationBar mNavigationBar;
    private EditText bmv = null;
    private Button bmw = null;
    private TextView bmx = null;
    private FrameLayout bmy = null;
    private LinearLayoutDetectsSoftKeyboard bmz = null;
    ImageView bmA = null;
    private FrameLayout bmB = null;
    private ListView bmC = null;
    private a bmD = null;
    private ListView bmE = null;
    private a bmF = null;
    private al bmG = null;
    private e bmH = null;
    private ProgressBar mProgress = null;
    private Button bmI = null;
    private View aWq = null;
    private BarSuggestModel bmK = null;
    private SearchPostModel bmL = null;
    private aj bmM = null;
    private ak bmN = null;
    private String bmO = null;
    private int mMode = 0;
    private String bmP = null;
    private String bmQ = null;
    private int bmR = 0;
    private boolean XM = false;
    private boolean bmS = true;
    final View.OnClickListener bmT = new s(this);
    private final com.baidu.adp.framework.listener.e aBo = new ac(this, 301001, true);
    private final HttpMessageListener aBp = new ad(this, CmdConfigHttp.FRS_HTTP_CMD, true);
    private CustomMessageListener bmU = new ae(this, 2001195);
    private CustomMessageListener bmV = new af(this, 2001194);
    private HttpMessageListener bmW = new ag(this, CmdConfigHttp.SEARCH_FRIEND_CMD);
    private final Handler mHandler = new Handler();
    private final Runnable bmX = new ah(this);
    private boolean bmY = true;
    private CustomMessageListener bna = new ai(this, 2009002);
    private CustomMessageListener bnb = new i(this, 2009001);

    static {
        SE();
        SF();
        CustomMessageTask customMessageTask = new CustomMessageTask(2015002, new h());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        com.baidu.tieba.ai.b(2001194, d.class);
        com.baidu.tieba.ai.b(2001195, c.class);
    }

    private static void SE() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2009002, new j());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void SF() {
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
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this).createFlagCfg(this.bmJ, FrsActivityConfig.FRS_FROM_SEARCH, 1)));
        } else if (z2 && z && error == 3) {
            if (TextUtils.isEmpty(TbadkApplication.getCurrentAccount())) {
                LoginActivity.a((Activity) this, getString(com.baidu.tieba.y.login_to_use), true, 11013);
            } else {
                sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(this, this.bmJ)));
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

    private void Rx() {
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
                    sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(this, this.bmJ)));
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
        if (!xh()) {
            setContentView(com.baidu.tieba.w.home_dialog_search);
            init();
            getWindow().setSoftInputMode(1);
            Rx();
            registerListener(this.bmU);
            registerListener(this.bmV);
            registerListener(this.bna);
            registerListener(this.bnb);
            registerListener(this.bmW);
            registerListener(this.aBo);
            registerListener(this.aBp);
        }
    }

    private boolean xh() {
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
        this.bmS = true;
        if (this.bmY) {
            this.mHandler.post(new l(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mMode = 0;
        if (this.mMode == 0) {
            com.baidu.tieba.aj.wm().aP(true);
        } else {
            com.baidu.tieba.aj.wm().aP(false);
        }
        SB();
        oo();
    }

    public void oo() {
        this.mHandler.removeCallbacks(this.bmX);
        if (this.bmM != null) {
            this.bmM.cancel();
            this.bmM = null;
        }
        if (this.bmN != null) {
            this.bmN.cancel();
            this.bmN = null;
        }
    }

    private void init() {
        Hi();
        Hh();
        this.aWq = com.baidu.adp.lib.g.b.ek().inflate(this, com.baidu.tieba.w.home_dialog_search_footer, null);
        this.bmv.setOnFocusChangeListener(new m(this));
        this.bmx.setText(getString(com.baidu.tieba.y.enter_forum));
        this.bmx.setOnClickListener(this.bmT);
        this.bmy = (FrameLayout) findViewById(com.baidu.tieba.v.frame_layout);
        this.bmz = (LinearLayoutDetectsSoftKeyboard) findViewById(com.baidu.tieba.v.parent);
        this.bmz.setOnSoftKeyBoardShownListener(new n(this));
        this.bmz.setOnTouchListener(new o(this));
        this.ahX = NoDataViewFactory.a(this, null, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.t.ds80)), null, null);
        this.bmy.addView(this.ahX);
        this.bmv.setOnEditorActionListener(new p(this));
        this.bmw.setOnClickListener(new q(this));
        this.bmv.addTextChangedListener(new r(this));
        this.bmB = (FrameLayout) findViewById(com.baidu.tieba.v.home_search_list);
        this.bmC = (ListView) findViewById(com.baidu.tieba.v.home_lv_search);
        this.bmI = (Button) this.aWq.findViewById(com.baidu.tieba.v.home_bt_search_footer);
        this.bmI.setOnClickListener(new t(this));
        this.bmC.addFooterView(this.aWq, null, true);
        this.bmG = new al(this, null);
        this.bmD = new a(this, null);
        this.bmC.setAdapter((ListAdapter) this.bmD);
        this.bmC.setOnItemClickListener(new x(this));
        this.bmE = (ListView) findViewById(com.baidu.tieba.v.home_lv_suggest);
        this.bmF = new a(this, null);
        this.bmH = new e(this);
        this.bmE.setAdapter((ListAdapter) this.bmF);
        this.bmE.setOnItemClickListener(new y(this));
        z zVar = new z(this);
        this.bmE.setOnScrollListener(zVar);
        this.bmC.setOnScrollListener(zVar);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.v.home_progress_search);
        this.mProgress.setVisibility(8);
        this.bmv.setText("");
        this.bmv.requestFocus();
        SG();
        ShowSoftKeyPadDelay(this.bmv, 150);
        if (com.baidu.tieba.aj.wm().wv()) {
            gt(0);
        } else {
            gt(1);
        }
    }

    private void Hh() {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new aa(this));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.w.square_search_navigation_view, (View.OnClickListener) null);
        this.bmA = (ImageView) addCustomView.findViewById(com.baidu.tieba.v.search_bar_icon);
        this.bmv = (EditText) addCustomView.findViewById(com.baidu.tieba.v.home_et_search);
        this.bmw = (Button) addCustomView.findViewById(com.baidu.tieba.v.home_bt_search_del);
        this.bmx = (TextView) addCustomView.findViewById(com.baidu.tieba.v.home_bt_search_s);
    }

    private void Hi() {
        this.bmZ = (FragmentTabWidget) findViewById(com.baidu.tieba.v.square_search_tab_widget);
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this);
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(com.baidu.tieba.t.ds32));
        fragmentTabIndicator.setGravity(17);
        fragmentTabIndicator.VR = com.baidu.tieba.s.main_bottom_button_color;
        fragmentTabIndicator.setText(getResources().getString(com.baidu.tieba.y.search_bar_text));
        FragmentTabIndicator fragmentTabIndicator2 = new FragmentTabIndicator(this);
        fragmentTabIndicator2.VR = com.baidu.tieba.s.main_bottom_button_color;
        fragmentTabIndicator2.setTextSize(0, getResources().getDimension(com.baidu.tieba.t.ds32));
        fragmentTabIndicator2.setGravity(17);
        fragmentTabIndicator2.setText(getResources().getString(com.baidu.tieba.y.search_post_text));
        FragmentTabIndicator fragmentTabIndicator3 = new FragmentTabIndicator(this);
        fragmentTabIndicator3.VR = com.baidu.tieba.s.main_bottom_button_color;
        fragmentTabIndicator3.setTextSize(0, getResources().getDimension(com.baidu.tieba.t.ds32));
        fragmentTabIndicator3.setGravity(17);
        fragmentTabIndicator3.setText(getResources().getString(com.baidu.tieba.y.search_person));
        FragmentTabIndicator fragmentTabIndicator4 = new FragmentTabIndicator(this);
        fragmentTabIndicator4.VR = com.baidu.tieba.s.main_bottom_button_color;
        fragmentTabIndicator4.setTextSize(0, getResources().getDimension(com.baidu.tieba.t.ds32));
        fragmentTabIndicator4.setGravity(17);
        fragmentTabIndicator4.setText(getResources().getString(com.baidu.tieba.y.search_in_baidu_text));
        this.bmZ.addView(fragmentTabIndicator);
        this.bmZ.addView(fragmentTabIndicator2);
        this.bmZ.addView(fragmentTabIndicator3);
        this.bmZ.addView(fragmentTabIndicator4);
        this.bmZ.d(0, true);
        this.bmZ.setTabSelectionListener(new ab(this));
    }

    public void SB() {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.bmH != null) {
            this.bmH.SB();
        }
    }

    public void gt(int i) {
        switch (i) {
            case 0:
                if (this.mMode != 0) {
                    this.mMode = 0;
                    this.bmx.setText(getString(com.baidu.tieba.y.enter_forum));
                    this.bmv.setHint(com.baidu.tieba.y.search_bar);
                    oo();
                    if (this.bmO.trim().length() > 0) {
                        SJ();
                        return;
                    } else {
                        SG();
                        return;
                    }
                }
                return;
            case 1:
                if (this.mMode != 1) {
                    this.mMode = 1;
                    this.bmx.setText(getString(com.baidu.tieba.y.search));
                    this.bmv.setHint(com.baidu.tieba.y.search_post_hint);
                    oo();
                    if (this.bmO.trim().length() > 0) {
                        this.bmE.setVisibility(8);
                        o(1, this.bmO);
                        return;
                    }
                    SH();
                    return;
                }
                return;
            case 2:
            default:
                return;
            case 3:
                if (this.mMode != 3) {
                    this.mMode = 3;
                    this.bmE.setVisibility(8);
                    this.bmx.setText(com.baidu.tieba.y.search);
                    this.bmv.setHint(com.baidu.tieba.y.search_friend_tip);
                    oo();
                    if (this.bmO.trim().length() <= 0) {
                        SI();
                        return;
                    }
                    return;
                }
                return;
        }
    }

    public void startSearch() {
        String trim = this.bmv.getText().toString().trim();
        if (UtilHelper.isNetOk()) {
            this.bmJ = trim;
            this.bmS = false;
            sendMessage(gM(trim));
            return;
        }
        showToast(com.baidu.tieba.y.neterror);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SG() {
        this.bmE.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009002));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SH() {
        this.bmE.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009001));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SI() {
        this.bmE.setVisibility(8);
        if (!this.XM) {
            sendMessage(new RequestSearchPersonHistoryReadMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() < 1 || ((4 == i && this.mMode != 0) || ((5 == i && this.mMode != 1) || (6 == i && this.mMode != 3)))) {
            this.bmB.setVisibility(8);
            this.ahX.setVisibility(0);
            this.ahX.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.text_no_search_record));
            return;
        }
        this.bmB.setVisibility(0);
        this.bmC.setVisibility(0);
        this.bmE.setVisibility(8);
        this.ahX.setVisibility(8);
        this.bmD.setData(arrayList);
        this.bmD.dy(4 == i);
        this.bmD.notifyDataSetInvalidated();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SJ() {
        this.bmB.setVisibility(8);
        if (this.bmO != null) {
            if (this.bmO.equals(this.bmP)) {
                refresh();
                return;
            }
            this.mHandler.removeCallbacks(this.bmX);
            this.mHandler.postDelayed(this.bmX, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i, String str) {
        this.bmC.setVisibility(8);
        if (str != null) {
            try {
                if (str.trim().length() > 0) {
                    if (str.equals(this.bmQ) && i == this.bmR) {
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
                        this.bmN = new ak(this, stringBuffer.toString(), arrayList);
                        this.bmN.setPriority(3);
                        this.bmN.execute(new Object[0]);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.bmH.setRefreshing(0);
                this.bmH.notifyDataSetChanged();
            }
        }
    }

    private FRSPageRequestMessage gM(String str) {
        FRSPageRequestMessage fRSPageRequestMessage = new FRSPageRequestMessage();
        fRSPageRequestMessage.setKw(str);
        fRSPageRequestMessage.setPn(1);
        fRSPageRequestMessage.setForumModel(new com.baidu.tieba.frs.b());
        if (com.baidu.tbadk.core.l.js().jw()) {
            fRSPageRequestMessage.setRn(35);
        } else {
            fRSPageRequestMessage.setRn(50);
        }
        fRSPageRequestMessage.setWithGroup(1);
        int n = com.baidu.adp.lib.util.m.n(this);
        int o = com.baidu.adp.lib.util.m.o(this);
        float f = n / 320.0f;
        int i = ba.mD().mF() ? 2 : 1;
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
                if (this.bmK != null) {
                    if (this.bmK.forum_list != null && this.bmK.forum_list.size() > 0) {
                        this.bmB.setVisibility(0);
                        this.bmC.setVisibility(8);
                        this.bmE.setVisibility(0);
                        this.ahX.setVisibility(8);
                        this.bmE.setAdapter((ListAdapter) this.bmG);
                        this.bmG.y(this.bmK.forum_list);
                        this.bmG.notifyDataSetInvalidated();
                    } else {
                        this.bmB.setVisibility(8);
                        this.ahX.setVisibility(0);
                        this.ahX.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.text_no_suggest));
                    }
                }
            } else if (this.bmL != null) {
                ArrayList<aq> data = this.bmL.getData();
                if (data != null && data.size() > 0) {
                    this.bmB.setVisibility(0);
                    this.bmC.setVisibility(8);
                    this.bmE.setVisibility(0);
                    this.ahX.setVisibility(8);
                    this.bmE.setAdapter((ListAdapter) this.bmH);
                    this.bmH.a(this.bmL);
                    this.bmH.notifyDataSetInvalidated();
                    if (this.bmL.hasPre()) {
                        this.bmE.setSelection(1);
                    }
                } else {
                    this.bmB.setVisibility(8);
                    this.ahX.setVisibility(0);
                    this.ahX.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.text_no_suggest));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ahX != null) {
            this.ahX.onChangeSkinType(i);
        }
        this.mNavigationBar.onChangeSkinType(i);
        this.bmZ.onChangeSkinType(i);
        getLayoutMode().L(i == 1);
        getLayoutMode().h(this.bmz);
        aw.d(this.bmz, i);
        if (this.bmD != null) {
            this.bmD.notifyDataSetChanged();
        }
        if (this.bmF != null) {
            this.bmF.notifyDataSetChanged();
        }
        if (this.bmG != null) {
            this.bmG.notifyDataSetChanged();
        }
        if (this.bmH != null) {
            this.bmH.notifyDataSetChanged();
        }
        aw.h(this.bmy, com.baidu.tieba.s.square_listview_bg);
        aw.h(this.aWq, com.baidu.tieba.s.square_listview_bg);
        aw.c(this.bmA, com.baidu.tieba.u.icon_search_ba);
        aw.b(this.bmx, com.baidu.tieba.s.common_new_page_title, 1);
        aw.b(this.bmI, com.baidu.tieba.s.no_data_search_text_content, 3);
        aw.h((View) this.bmI, com.baidu.tieba.u.clear_search_btn_drawable);
        if (i == 1) {
            this.bmv.setTextColor(-6574132);
            this.bmv.setHintTextColor(-11643034);
            return;
        }
        this.bmv.setTextColor(-2300171);
        this.bmv.setHintTextColor(-10195067);
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
        if (this.ahX != null) {
            this.ahX.onActivityStop();
        }
    }
}
