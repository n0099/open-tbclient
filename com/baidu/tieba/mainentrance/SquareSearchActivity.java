package com.baidu.tieba.mainentrance;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.search.ResponseSearchFriendMessage;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.tbadkCore.FRSPageRequestMessage;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class SquareSearchActivity extends BaseActivity<SquareSearchActivity> implements com.baidu.adp.widget.ListView.x, h {
    private List<e> byM;
    private String bzC;
    private FragmentTabWidget bzQ;
    private TextView bzo;
    private c bzp;
    private PbListView bzq;
    private f bzu;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.s mNoDataView;
    private LinearLayoutDetectsSoftKeyboard bzb = null;
    private FrameLayout bzc = null;
    private FrameLayout bzd = null;
    private EditText bze = null;
    private TextView bzf = null;
    private TextView bzg = null;
    private ImageView bzh = null;
    private ProgressBar mProgress = null;
    private ListView bzi = null;
    private l bzj = null;
    private View bzk = null;
    private TextView bzl = null;
    private View bzm = null;
    private HorizontalListView bzn = null;
    private BdListView bzr = null;
    private a bzs = null;
    private i bzt = null;
    private ForumSuggestModel bzv = null;
    private PostSuggestModel bzw = null;
    private ap bzx = null;
    private aq bzy = null;
    private String bzz = null;
    private String bzA = null;
    private String bzB = null;
    private int mMode = 0;
    private int bzD = 0;
    private boolean bzE = false;
    private boolean bzF = false;
    private boolean bzG = false;
    private boolean amQ = false;
    private boolean bzH = true;
    final View.OnClickListener bzI = new p(this);
    private final com.baidu.adp.framework.listener.e bzJ = new aa(this, 301001, true);
    private final HttpMessageListener bzK = new ai(this, CmdConfigHttp.FRS_HTTP_CMD, true);
    private CustomMessageListener bzL = new aj(this, 2001195);
    private CustomMessageListener bzM = new ak(this, 2001194);
    private HttpMessageListener bzN = new al(this, CmdConfigHttp.SEARCH_FRIEND_CMD);
    private final Handler mHandler = new Handler();
    private final Runnable bzO = new am(this);
    private boolean bzP = true;
    private CustomMessageListener bzR = new an(this, 2009002);
    private CustomMessageListener bzS = new ao(this, 2009001);

    @Override // com.baidu.tieba.mainentrance.h
    public void ht(String str) {
        this.bzE = true;
        this.bzF = false;
        WU();
        this.byM = new ArrayList();
        WX();
    }

    @Override // com.baidu.tieba.mainentrance.h
    public void aN(List<e> list) {
        this.bzE = true;
        WU();
        if (list == null || list.isEmpty()) {
            this.bzF = false;
            this.byM = new ArrayList();
            WX();
            return;
        }
        this.byM = list;
        this.bzF = true;
        this.bzp.setData(this.byM);
        this.bzp.notifyDataSetChanged();
        if (!this.bzG) {
            this.bzi.addHeaderView(this.bzm);
        }
        this.bzG = true;
        WX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponsedMessage<?> responsedMessage, boolean z) {
        int error = responsedMessage.getError();
        String string = StringUtils.isNull(responsedMessage.getErrorString()) ? getResources().getString(com.baidu.tieba.y.neterror) : responsedMessage.getErrorString();
        boolean z2 = error < -13 || error > -10;
        if (error == 0) {
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createFlagCfg(this.bzC, FrsActivityConfig.FRS_FROM_SEARCH, 1)));
        } else if (z2 && z && error == 3) {
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.y.login_to_use), true, 11013)));
            } else {
                sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), this.bzC)));
            }
        } else {
            showToast(string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fj(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SEARCH_FRIEND_CMD);
        httpMessage.addParam("search_key", str);
        sendMessage(httpMessage);
    }

    private void Fk() {
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
                    sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), this.bzC)));
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
        setContentView(com.baidu.tieba.w.home_dialog_search);
        init();
        getWindow().setSoftInputMode(1);
        Fk();
        registerListener(this.bzL);
        registerListener(this.bzM);
        registerListener(this.bzR);
        registerListener(this.bzS);
        registerListener(this.bzN);
        registerListener(this.bzJ);
        registerListener(this.bzK);
        this.bzu = new f(this, this);
        this.bzu.WP();
        this.bzu.WO();
        this.bzE = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bzH = true;
        if (this.bzP) {
            this.mHandler.post(new q(this));
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
        WU();
        EO();
    }

    public void EO() {
        this.mHandler.removeCallbacks(this.bzO);
        if (this.bzx != null) {
            this.bzx.cancel();
            this.bzx = null;
        }
        if (this.bzy != null) {
            this.bzy.cancel();
            this.bzy = null;
        }
    }

    private void init() {
        this.bzb = (LinearLayoutDetectsSoftKeyboard) findViewById(com.baidu.tieba.v.parent);
        this.bzb.setOnSoftKeyBoardShownListener(new r(this));
        this.bzb.setOnTouchListener(new s(this));
        BU();
        LH();
        this.bzc = (FrameLayout) findViewById(com.baidu.tieba.v.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.t.ds80)), null, null);
        this.bzc.addView(this.mNoDataView);
        this.bzd = (FrameLayout) findViewById(com.baidu.tieba.v.home_search_list);
        WS();
        WT();
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.v.home_progress_search);
        this.mProgress.setVisibility(0);
        this.bze.setText("");
        this.bze.requestFocus();
        ShowSoftKeyPadDelay(this.bze, 150);
        if (TbadkSettings.getInst().loadBoolean("search_mode", true)) {
            gP(0);
        } else {
            gP(1);
        }
    }

    private void LH() {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new t(this));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.w.square_search_navigation_view, (View.OnClickListener) null);
        this.bzh = (ImageView) addCustomView.findViewById(com.baidu.tieba.v.search_bar_icon);
        this.bze = (EditText) addCustomView.findViewById(com.baidu.tieba.v.home_et_search);
        this.bzf = (TextView) addCustomView.findViewById(com.baidu.tieba.v.home_bt_search_del);
        this.bzg = (TextView) addCustomView.findViewById(com.baidu.tieba.v.home_bt_search_s);
        this.bze.setOnFocusChangeListener(new u(this));
        this.bzg.setText(getPageContext().getString(com.baidu.tieba.y.enter_forum));
        this.bzg.setOnClickListener(this.bzI);
        this.bze.setOnEditorActionListener(new v(this));
        this.bzf.setOnClickListener(new w(this));
        this.bze.addTextChangedListener(new x(this));
    }

    private void BU() {
        this.bzQ = (FragmentTabWidget) findViewById(com.baidu.tieba.v.square_search_tab_widget);
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(com.baidu.tieba.t.ds32));
        fragmentTabIndicator.setGravity(17);
        fragmentTabIndicator.alT = com.baidu.tieba.s.main_bottom_button_color;
        fragmentTabIndicator.setText(getResources().getString(com.baidu.tieba.y.search_bar_text));
        FragmentTabIndicator fragmentTabIndicator2 = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator2.alT = com.baidu.tieba.s.main_bottom_button_color;
        fragmentTabIndicator2.setTextSize(0, getResources().getDimension(com.baidu.tieba.t.ds32));
        fragmentTabIndicator2.setGravity(17);
        fragmentTabIndicator2.setText(getResources().getString(com.baidu.tieba.y.search_post_text));
        FragmentTabIndicator fragmentTabIndicator3 = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator3.alT = com.baidu.tieba.s.main_bottom_button_color;
        fragmentTabIndicator3.setTextSize(0, getResources().getDimension(com.baidu.tieba.t.ds32));
        fragmentTabIndicator3.setGravity(17);
        fragmentTabIndicator3.setText(getResources().getString(com.baidu.tieba.y.search_person));
        FragmentTabIndicator fragmentTabIndicator4 = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator4.alT = com.baidu.tieba.s.main_bottom_button_color;
        fragmentTabIndicator4.setTextSize(0, getResources().getDimension(com.baidu.tieba.t.ds32));
        fragmentTabIndicator4.setGravity(17);
        fragmentTabIndicator4.setText(getResources().getString(com.baidu.tieba.y.search_in_baidu_text));
        this.bzQ.addView(fragmentTabIndicator);
        this.bzQ.addView(fragmentTabIndicator2);
        this.bzQ.addView(fragmentTabIndicator3);
        this.bzQ.addView(fragmentTabIndicator4);
        this.bzQ.d(0, true);
        this.bzQ.setTabSelectionListener(new y(this));
    }

    private void WS() {
        this.bzi = (ListView) findViewById(com.baidu.tieba.v.home_lv_search_history);
        this.bzm = com.baidu.adp.lib.g.b.hH().inflate(getPageContext().getPageActivity(), com.baidu.tieba.w.search_history_hot_forum_headview, null);
        this.bzn = (HorizontalListView) this.bzm.findViewById(com.baidu.tieba.v.hot_forum_listview);
        this.bzo = (TextView) this.bzm.findViewById(com.baidu.tieba.v.history_title_tv);
        this.bzp = new c(this);
        this.bzn.setAdapter((ListAdapter) this.bzp);
        this.bzn.setOnItemClickListener(new z(this));
        this.bzk = com.baidu.adp.lib.g.b.hH().inflate(getPageContext().getPageActivity(), com.baidu.tieba.w.home_dialog_search_footer, null);
        this.bzl = (TextView) this.bzk.findViewById(com.baidu.tieba.v.home_bt_search_footer);
        this.bzk.setOnClickListener(new ab(this));
        this.bzl.setVisibility(8);
        this.bzi.addFooterView(this.bzk, null, true);
        this.bzj = new l(this, null);
        this.bzi.setAdapter((ListAdapter) this.bzj);
        this.bzi.setOnItemClickListener(new af(this));
    }

    private void WT() {
        this.bzr = (BdListView) findViewById(com.baidu.tieba.v.home_lv_search_suggest);
        this.bzs = new a(this, null);
        this.bzt = new i(getPageContext().getPageActivity());
        this.bzr.setOnItemClickListener(new ag(this));
        ah ahVar = new ah(this);
        this.bzr.setOnScrollListener(ahVar);
        this.bzr.setOnSrollToBottomListener(this);
        this.bzi.setOnScrollListener(ahVar);
    }

    public void WU() {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
    }

    public void gP(int i) {
        switch (i) {
            case 0:
                if (this.mMode != 0) {
                    this.mMode = 0;
                    this.bzg.setText(getPageContext().getString(com.baidu.tieba.y.enter_forum));
                    this.bze.setHint(com.baidu.tieba.y.search_bar);
                    EO();
                    WV();
                    if (this.bzz.trim().length() > 0) {
                        Xa();
                        return;
                    } else {
                        WX();
                        return;
                    }
                }
                return;
            case 1:
                if (this.mMode != 1) {
                    this.mMode = 1;
                    this.bzg.setText(getPageContext().getString(com.baidu.tieba.y.search));
                    this.bze.setHint(com.baidu.tieba.y.search_post_hint);
                    EO();
                    if (this.bzz.trim().length() > 0) {
                        this.bzr.setVisibility(8);
                        y(1, this.bzz);
                        return;
                    }
                    WY();
                    return;
                }
                return;
            case 2:
            default:
                return;
            case 3:
                if (this.mMode != 3) {
                    this.mMode = 3;
                    this.bzr.setVisibility(8);
                    this.bzg.setText(com.baidu.tieba.y.search);
                    this.bze.setHint(com.baidu.tieba.y.search_friend_tip);
                    EO();
                    WV();
                    if (this.bzz.trim().length() <= 0) {
                        WZ();
                        return;
                    }
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WV() {
        this.bzr.setNextPage(null);
        this.bzt.clear();
    }

    public void WW() {
        String trim = this.bze.getText().toString().trim();
        if (!TextUtils.isEmpty(trim)) {
            if (UtilHelper.isNetOk()) {
                this.bzC = trim;
                this.bzH = false;
                sendMessage(hu(trim));
                return;
            }
            showToast(com.baidu.tieba.y.neterror);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WX() {
        this.bzr.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009002));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WY() {
        this.bzr.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009001));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WZ() {
        this.bzr.setVisibility(8);
        if (!this.amQ) {
            sendMessage(new RequestSearchPersonHistoryReadMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ArrayList<String> arrayList) {
        if (i == 4) {
            if (b(i, arrayList)) {
                this.bzd.setVisibility(8);
                this.mNoDataView.setVisibility(0);
                this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.text_no_search_record));
                return;
            }
            if (!this.bzG && this.bzF) {
                this.bzi.addHeaderView(this.bzm);
                this.bzG = true;
            }
            this.bzd.setVisibility(0);
            this.bzi.setVisibility(0);
            this.bzr.setVisibility(8);
            this.mNoDataView.setVisibility(8);
            this.bzj.p(arrayList);
            this.bzj.dq(4 == i);
            this.bzj.notifyDataSetInvalidated();
        } else if (i == 5) {
            if (c(i, arrayList)) {
                this.bzd.setVisibility(8);
                this.mNoDataView.setVisibility(0);
                this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.text_no_search_record));
                return;
            }
            if (this.bzG) {
                this.bzi.removeHeaderView(this.bzm);
                this.bzG = false;
            }
            this.bzd.setVisibility(0);
            this.bzi.setVisibility(0);
            this.bzr.setVisibility(8);
            this.mNoDataView.setVisibility(8);
            this.bzj.p(arrayList);
            this.bzj.dq(4 == i);
            this.bzj.notifyDataSetInvalidated();
        } else if (i == 6) {
            if (d(i, arrayList)) {
                this.bzd.setVisibility(8);
                this.mNoDataView.setVisibility(0);
                this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.text_no_search_record));
                return;
            }
            if (this.bzG) {
                this.bzi.removeHeaderView(this.bzm);
                this.bzG = false;
            }
            this.bzd.setVisibility(0);
            this.bzi.setVisibility(0);
            this.bzr.setVisibility(8);
            this.mNoDataView.setVisibility(8);
            this.bzj.p(arrayList);
            this.bzj.dq(4 == i);
            this.bzj.notifyDataSetInvalidated();
        } else {
            this.bzd.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.text_no_search_record));
        }
        F(arrayList);
    }

    private void F(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() < 1) {
            this.bzl.setVisibility(8);
            this.bzo.setVisibility(8);
            return;
        }
        this.bzl.setVisibility(0);
        this.bzo.setVisibility(0);
    }

    private boolean b(int i, ArrayList<String> arrayList) {
        if ((arrayList == null || arrayList.size() < 1) && !this.bzF) {
            return true;
        }
        return 4 == i && this.mMode != 0;
    }

    private boolean c(int i, ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && i == 5 && this.mMode != 5;
    }

    private boolean d(int i, ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && i == 6 && this.mMode != 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xa() {
        this.bzd.setVisibility(8);
        if (this.bzz != null) {
            if (this.bzz.equals(this.bzA)) {
                refresh();
                return;
            }
            this.mHandler.removeCallbacks(this.bzO);
            this.mHandler.postDelayed(this.bzO, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(int i, String str) {
        this.bzi.setVisibility(8);
        if (str != null) {
            try {
                if (str.trim().length() > 0) {
                    if (str.equals(this.bzB) && i == this.bzD) {
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
                        EO();
                        this.bzy = new aq(this, stringBuffer.toString(), arrayList);
                        this.bzy.setPriority(3);
                        this.bzy.execute(new Object[0]);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private FRSPageRequestMessage hu(String str) {
        FRSPageRequestMessage fRSPageRequestMessage = new FRSPageRequestMessage();
        fRSPageRequestMessage.setKw(str);
        fRSPageRequestMessage.setPn(1);
        if (com.baidu.tbadk.core.n.px().pB()) {
            fRSPageRequestMessage.setRn(35);
        } else {
            fRSPageRequestMessage.setRn(50);
        }
        fRSPageRequestMessage.setWithGroup(1);
        int M = com.baidu.adp.lib.util.n.M(getPageContext().getPageActivity());
        int N = com.baidu.adp.lib.util.n.N(getPageContext().getPageActivity());
        float f = M / 320.0f;
        int i = be.sY().ta() ? 2 : 1;
        fRSPageRequestMessage.setScrW(M);
        fRSPageRequestMessage.setScrH(N);
        fRSPageRequestMessage.setScrDip(f);
        fRSPageRequestMessage.setqType(i);
        return fRSPageRequestMessage;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
    }

    private PbListView Xb() {
        if (this.bzq == null) {
            this.bzq = new PbListView(getPageContext().getPageActivity());
            this.bzq.mN();
        }
        return this.bzq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        int i;
        int i2 = 0;
        try {
            if (this.mMode == 0) {
                if (this.bzv != null) {
                    if (this.bzv.forum_list != null && this.bzv.forum_list.size() > 0) {
                        this.bzd.setVisibility(0);
                        this.bzi.setVisibility(8);
                        this.bzr.setVisibility(0);
                        this.mNoDataView.setVisibility(8);
                        this.bzr.setAdapter((ListAdapter) this.bzs);
                        this.bzs.E(this.bzv.forum_list);
                        this.bzs.notifyDataSetInvalidated();
                    } else if (this.mNoDataView.getVisibility() != 0) {
                        this.bzd.setVisibility(8);
                        this.mNoDataView.setVisibility(0);
                        this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.text_no_suggest));
                    }
                }
            } else if (this.bzw != null) {
                ArrayList<k> data = this.bzw.getData();
                if (data != null && data.size() > 0) {
                    this.bzd.setVisibility(0);
                    this.bzi.setVisibility(8);
                    this.mNoDataView.setVisibility(8);
                    if (this.bzw.getCurrentPage() == 1) {
                        this.bzr.setVisibility(0);
                        this.bzr.setAdapter((ListAdapter) this.bzt);
                        this.bzr.setNextPage(Xb());
                    }
                    if (!this.bzw.hasMore()) {
                        Xb().setText(getResources().getString(com.baidu.tieba.y.list_no_more));
                        Xb().tO();
                    }
                    int aO = this.bzt.aO(data);
                    if (aO > 0) {
                        i = this.bzr.getFirstVisiblePosition() - aO;
                        View childAt = this.bzr.getChildAt(0);
                        if (childAt != null) {
                            i2 = childAt.getTop();
                        }
                    } else {
                        i = 0;
                    }
                    this.bzt.notifyDataSetChanged();
                    if (aO > 0) {
                        this.bzr.setSelectionFromTop(i, i2);
                    }
                } else if (this.mNoDataView.getVisibility() != 0) {
                    this.bzd.setVisibility(8);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.text_no_suggest));
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
        this.bzQ.onChangeSkinType(i);
        getLayoutMode().X(i == 1);
        getLayoutMode().h(this.bzb);
        getLayoutMode().h(this.bzm);
        ba.e(this.bzb, i);
        if (this.bzj != null) {
            this.bzj.notifyDataSetChanged();
        }
        if (this.bzs != null) {
            this.bzs.notifyDataSetChanged();
        }
        if (this.bzt != null) {
            this.bzt.notifyDataSetChanged();
        }
        ba.i(this.bzc, com.baidu.tieba.s.cp_bg_line_d);
        ba.i(this.bzk, com.baidu.tieba.s.cp_bg_line_d);
        ba.c(this.bzh, com.baidu.tieba.u.icon_search_ba);
        ba.b(this.bzg, com.baidu.tieba.s.cp_cont_i, 1);
        ba.b(this.bzl, com.baidu.tieba.s.cp_link_tip_a, 1);
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

    @Override // com.baidu.adp.widget.ListView.x
    public void onScrollToBottom() {
        if (this.bzw != null && this.bzw.hasMore()) {
            y(this.bzw.getCurrentPage() + 1, this.bzz);
            Xb().startLoadData();
        }
    }
}
