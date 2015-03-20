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
import com.baidu.tbadk.coreExtra.search.ResponseSearchFriendMessage;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.tbadkCore.FRSPageRequestMessage;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class SquareSearchActivity extends BaseActivity<SquareSearchActivity> implements h {
    private List<e> byw;
    private FragmentTabWidget bzD;
    private TextView bzc;
    private c bzd;
    private f bzh;
    private String bzp;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.s mNoDataView;
    private LinearLayoutDetectsSoftKeyboard byP = null;
    private FrameLayout byQ = null;
    private FrameLayout byR = null;
    private EditText byS = null;
    private TextView byT = null;
    private TextView byU = null;
    private ImageView byV = null;
    private ProgressBar mProgress = null;
    private ListView byW = null;
    private m byX = null;
    private View byY = null;
    private TextView byZ = null;
    private View bza = null;
    private HorizontalListView bzb = null;
    private ListView bze = null;
    private a bzf = null;
    private i bzg = null;
    private ForumSuggestModel bzi = null;
    private PostSuggestModel bzj = null;
    private aq bzk = null;
    private ar bzl = null;
    private String bzm = null;
    private String bzn = null;
    private String bzo = null;
    private int mMode = 0;
    private int bzq = 0;
    private boolean bzr = false;
    private boolean bzs = false;
    private boolean bzt = false;
    private boolean amI = false;
    private boolean bzu = true;
    final View.OnClickListener bzv = new q(this);
    private final com.baidu.adp.framework.listener.e bzw = new ab(this, 301001, true);
    private final HttpMessageListener bzx = new aj(this, CmdConfigHttp.FRS_HTTP_CMD, true);
    private CustomMessageListener bzy = new ak(this, 2001195);
    private CustomMessageListener bzz = new al(this, 2001194);
    private HttpMessageListener bzA = new am(this, CmdConfigHttp.SEARCH_FRIEND_CMD);
    private final Handler mHandler = new Handler();
    private final Runnable bzB = new an(this);
    private boolean bzC = true;
    private CustomMessageListener bzE = new ao(this, 2009002);
    private CustomMessageListener bzF = new ap(this, 2009001);

    @Override // com.baidu.tieba.mainentrance.h
    public void hq(String str) {
        this.bzr = true;
        this.bzs = false;
        WK();
        this.byw = new ArrayList();
        WM();
    }

    @Override // com.baidu.tieba.mainentrance.h
    public void aL(List<e> list) {
        this.bzr = true;
        WK();
        if (list == null || list.isEmpty()) {
            this.bzs = false;
            this.byw = new ArrayList();
            WM();
            return;
        }
        this.byw = list;
        this.bzs = true;
        this.bzd.setData(this.byw);
        this.bzd.notifyDataSetChanged();
        if (!this.bzt) {
            this.byW.addHeaderView(this.bza);
        }
        this.bzt = true;
        WM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponsedMessage<?> responsedMessage, boolean z) {
        int error = responsedMessage.getError();
        String string = StringUtils.isNull(responsedMessage.getErrorString()) ? getResources().getString(com.baidu.tieba.y.neterror) : responsedMessage.getErrorString();
        boolean z2 = error < -13 || error > -10;
        if (error == 0) {
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createFlagCfg(this.bzp, FrsActivityConfig.FRS_FROM_SEARCH, 1)));
        } else if (z2 && z && error == 3) {
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.y.login_to_use), true, 11013)));
            } else {
                sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), this.bzp)));
            }
        } else {
            showToast(string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fg(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SEARCH_FRIEND_CMD);
        httpMessage.addParam("search_key", str);
        sendMessage(httpMessage);
    }

    private void Fe() {
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
                    sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), this.bzp)));
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
        Fe();
        registerListener(this.bzy);
        registerListener(this.bzz);
        registerListener(this.bzE);
        registerListener(this.bzF);
        registerListener(this.bzA);
        registerListener(this.bzw);
        registerListener(this.bzx);
        this.bzh = new f(this, this);
        this.bzh.WC();
        this.bzh.WB();
        this.bzr = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bzu = true;
        if (this.bzC) {
            this.mHandler.post(new r(this));
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
        WK();
        EI();
    }

    public void EI() {
        this.mHandler.removeCallbacks(this.bzB);
        if (this.bzk != null) {
            this.bzk.cancel();
            this.bzk = null;
        }
        if (this.bzl != null) {
            this.bzl.cancel();
            this.bzl = null;
        }
    }

    private void init() {
        this.byP = (LinearLayoutDetectsSoftKeyboard) findViewById(com.baidu.tieba.v.parent);
        this.byP.setOnSoftKeyBoardShownListener(new s(this));
        this.byP.setOnTouchListener(new t(this));
        BO();
        Lv();
        this.byQ = (FrameLayout) findViewById(com.baidu.tieba.v.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.t.ds80)), null, null);
        this.byQ.addView(this.mNoDataView);
        this.byR = (FrameLayout) findViewById(com.baidu.tieba.v.home_search_list);
        WI();
        WJ();
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.v.home_progress_search);
        this.mProgress.setVisibility(0);
        this.byS.setText("");
        this.byS.requestFocus();
        ShowSoftKeyPadDelay(this.byS, 150);
        if (TbadkSettings.getInst().loadBoolean("search_mode", true)) {
            gN(0);
        } else {
            gN(1);
        }
    }

    private void Lv() {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new u(this));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.w.square_search_navigation_view, (View.OnClickListener) null);
        this.byV = (ImageView) addCustomView.findViewById(com.baidu.tieba.v.search_bar_icon);
        this.byS = (EditText) addCustomView.findViewById(com.baidu.tieba.v.home_et_search);
        this.byT = (TextView) addCustomView.findViewById(com.baidu.tieba.v.home_bt_search_del);
        this.byU = (TextView) addCustomView.findViewById(com.baidu.tieba.v.home_bt_search_s);
        this.byS.setOnFocusChangeListener(new v(this));
        this.byU.setText(getPageContext().getString(com.baidu.tieba.y.enter_forum));
        this.byU.setOnClickListener(this.bzv);
        this.byS.setOnEditorActionListener(new w(this));
        this.byT.setOnClickListener(new x(this));
        this.byS.addTextChangedListener(new y(this));
    }

    private void BO() {
        this.bzD = (FragmentTabWidget) findViewById(com.baidu.tieba.v.square_search_tab_widget);
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(com.baidu.tieba.t.ds32));
        fragmentTabIndicator.setGravity(17);
        fragmentTabIndicator.alL = com.baidu.tieba.s.main_bottom_button_color;
        fragmentTabIndicator.setText(getResources().getString(com.baidu.tieba.y.search_bar_text));
        FragmentTabIndicator fragmentTabIndicator2 = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator2.alL = com.baidu.tieba.s.main_bottom_button_color;
        fragmentTabIndicator2.setTextSize(0, getResources().getDimension(com.baidu.tieba.t.ds32));
        fragmentTabIndicator2.setGravity(17);
        fragmentTabIndicator2.setText(getResources().getString(com.baidu.tieba.y.search_post_text));
        FragmentTabIndicator fragmentTabIndicator3 = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator3.alL = com.baidu.tieba.s.main_bottom_button_color;
        fragmentTabIndicator3.setTextSize(0, getResources().getDimension(com.baidu.tieba.t.ds32));
        fragmentTabIndicator3.setGravity(17);
        fragmentTabIndicator3.setText(getResources().getString(com.baidu.tieba.y.search_person));
        FragmentTabIndicator fragmentTabIndicator4 = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator4.alL = com.baidu.tieba.s.main_bottom_button_color;
        fragmentTabIndicator4.setTextSize(0, getResources().getDimension(com.baidu.tieba.t.ds32));
        fragmentTabIndicator4.setGravity(17);
        fragmentTabIndicator4.setText(getResources().getString(com.baidu.tieba.y.search_in_baidu_text));
        this.bzD.addView(fragmentTabIndicator);
        this.bzD.addView(fragmentTabIndicator2);
        this.bzD.addView(fragmentTabIndicator3);
        this.bzD.addView(fragmentTabIndicator4);
        this.bzD.d(0, true);
        this.bzD.setTabSelectionListener(new z(this));
    }

    private void WI() {
        this.byW = (ListView) findViewById(com.baidu.tieba.v.home_lv_search_history);
        this.bza = com.baidu.adp.lib.g.b.hH().inflate(getPageContext().getPageActivity(), com.baidu.tieba.w.search_history_hot_forum_headview, null);
        this.bzb = (HorizontalListView) this.bza.findViewById(com.baidu.tieba.v.hot_forum_listview);
        this.bzc = (TextView) this.bza.findViewById(com.baidu.tieba.v.history_title_tv);
        this.bzd = new c(this);
        this.bzb.setAdapter((ListAdapter) this.bzd);
        this.bzb.setOnItemClickListener(new aa(this));
        this.byY = com.baidu.adp.lib.g.b.hH().inflate(getPageContext().getPageActivity(), com.baidu.tieba.w.home_dialog_search_footer, null);
        this.byZ = (TextView) this.byY.findViewById(com.baidu.tieba.v.home_bt_search_footer);
        this.byY.setOnClickListener(new ac(this));
        this.byZ.setVisibility(8);
        this.byW.addFooterView(this.byY, null, true);
        this.byX = new m(this, null);
        this.byW.setAdapter((ListAdapter) this.byX);
        this.byW.setOnItemClickListener(new ag(this));
    }

    private void WJ() {
        this.bze = (ListView) findViewById(com.baidu.tieba.v.home_lv_search_suggest);
        this.bzf = new a(this, null);
        this.bzg = new i(getPageContext().getPageActivity());
        this.bze.setOnItemClickListener(new ah(this));
        ai aiVar = new ai(this);
        this.bze.setOnScrollListener(aiVar);
        this.byW.setOnScrollListener(aiVar);
    }

    public void WK() {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
    }

    public void gN(int i) {
        switch (i) {
            case 0:
                if (this.mMode != 0) {
                    this.mMode = 0;
                    this.byU.setText(getPageContext().getString(com.baidu.tieba.y.enter_forum));
                    this.byS.setHint(com.baidu.tieba.y.search_bar);
                    EI();
                    if (this.bzm.trim().length() > 0) {
                        WP();
                        return;
                    } else {
                        WM();
                        return;
                    }
                }
                return;
            case 1:
                if (this.mMode != 1) {
                    this.mMode = 1;
                    this.byU.setText(getPageContext().getString(com.baidu.tieba.y.search));
                    this.byS.setHint(com.baidu.tieba.y.search_post_hint);
                    EI();
                    if (this.bzm.trim().length() > 0) {
                        this.bze.setVisibility(8);
                        y(1, this.bzm);
                        return;
                    }
                    WN();
                    return;
                }
                return;
            case 2:
            default:
                return;
            case 3:
                if (this.mMode != 3) {
                    this.mMode = 3;
                    this.bze.setVisibility(8);
                    this.byU.setText(com.baidu.tieba.y.search);
                    this.byS.setHint(com.baidu.tieba.y.search_friend_tip);
                    EI();
                    if (this.bzm.trim().length() <= 0) {
                        WO();
                        return;
                    }
                    return;
                }
                return;
        }
    }

    public void WL() {
        String trim = this.byS.getText().toString().trim();
        if (!TextUtils.isEmpty(trim)) {
            if (UtilHelper.isNetOk()) {
                this.bzp = trim;
                this.bzu = false;
                sendMessage(hr(trim));
                return;
            }
            showToast(com.baidu.tieba.y.neterror);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WM() {
        this.bze.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009002));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WN() {
        this.bze.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009001));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WO() {
        this.bze.setVisibility(8);
        if (!this.amI) {
            sendMessage(new RequestSearchPersonHistoryReadMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ArrayList<String> arrayList) {
        if (i == 4) {
            if (b(i, arrayList)) {
                this.byR.setVisibility(8);
                this.mNoDataView.setVisibility(0);
                this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.text_no_search_record));
                return;
            }
            if (!this.bzt && this.bzs) {
                this.byW.addHeaderView(this.bza);
                this.bzt = true;
            }
            this.byR.setVisibility(0);
            this.byW.setVisibility(0);
            this.bze.setVisibility(8);
            this.mNoDataView.setVisibility(8);
            this.byX.p(arrayList);
            this.byX.ds(4 == i);
            this.byX.notifyDataSetInvalidated();
        } else if (i == 5) {
            if (c(i, arrayList)) {
                this.byR.setVisibility(8);
                this.mNoDataView.setVisibility(0);
                this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.text_no_search_record));
                return;
            }
            if (this.bzt) {
                this.byW.removeHeaderView(this.bza);
                this.bzt = false;
            }
            this.byR.setVisibility(0);
            this.byW.setVisibility(0);
            this.bze.setVisibility(8);
            this.mNoDataView.setVisibility(8);
            this.byX.p(arrayList);
            this.byX.ds(4 == i);
            this.byX.notifyDataSetInvalidated();
        } else if (i == 6) {
            if (d(i, arrayList)) {
                this.byR.setVisibility(8);
                this.mNoDataView.setVisibility(0);
                this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.text_no_search_record));
                return;
            }
            if (this.bzt) {
                this.byW.removeHeaderView(this.bza);
                this.bzt = false;
            }
            this.byR.setVisibility(0);
            this.byW.setVisibility(0);
            this.bze.setVisibility(8);
            this.mNoDataView.setVisibility(8);
            this.byX.p(arrayList);
            this.byX.ds(4 == i);
            this.byX.notifyDataSetInvalidated();
        } else {
            this.byR.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.text_no_search_record));
        }
        E(arrayList);
    }

    private void E(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() < 1) {
            this.byZ.setVisibility(8);
            this.bzc.setVisibility(8);
            return;
        }
        this.byZ.setVisibility(0);
        this.bzc.setVisibility(0);
    }

    private boolean b(int i, ArrayList<String> arrayList) {
        if ((arrayList == null || arrayList.size() < 1) && !this.bzs) {
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
    public void WP() {
        this.byR.setVisibility(8);
        if (this.bzm != null) {
            if (this.bzm.equals(this.bzn)) {
                refresh();
                return;
            }
            this.mHandler.removeCallbacks(this.bzB);
            this.mHandler.postDelayed(this.bzB, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(int i, String str) {
        this.byW.setVisibility(8);
        if (str != null) {
            try {
                if (str.trim().length() > 0) {
                    if (str.equals(this.bzo) && i == this.bzq) {
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
                        EI();
                        this.bzl = new ar(this, stringBuffer.toString(), arrayList);
                        this.bzl.setPriority(3);
                        this.bzl.execute(new Object[0]);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.bzg.setRefreshing(0);
                this.bzg.notifyDataSetChanged();
            }
        }
    }

    private FRSPageRequestMessage hr(String str) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        try {
            if (this.mMode == 0) {
                if (this.bzi != null) {
                    if (this.bzi.forum_list != null && this.bzi.forum_list.size() > 0) {
                        this.byR.setVisibility(0);
                        this.byW.setVisibility(8);
                        this.bze.setVisibility(0);
                        this.mNoDataView.setVisibility(8);
                        this.bze.setAdapter((ListAdapter) this.bzf);
                        this.bzf.D(this.bzi.forum_list);
                        this.bzf.notifyDataSetInvalidated();
                    } else if (this.mNoDataView.getVisibility() != 0) {
                        this.byR.setVisibility(8);
                        this.mNoDataView.setVisibility(0);
                        this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.text_no_suggest));
                    }
                }
            } else if (this.bzj != null) {
                ArrayList<l> data = this.bzj.getData();
                if (data != null && data.size() > 0) {
                    this.byR.setVisibility(0);
                    this.byW.setVisibility(8);
                    this.bze.setVisibility(0);
                    this.mNoDataView.setVisibility(8);
                    this.bze.setAdapter((ListAdapter) this.bzg);
                    this.bzg.a(this.bzj);
                    this.bzg.notifyDataSetInvalidated();
                    if (this.bzj.hasPre()) {
                        this.bze.setSelection(1);
                    }
                } else if (this.mNoDataView.getVisibility() != 0) {
                    this.byR.setVisibility(8);
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
        this.bzD.onChangeSkinType(i);
        getLayoutMode().X(i == 1);
        getLayoutMode().h(this.byP);
        getLayoutMode().h(this.bza);
        ba.e(this.byP, i);
        if (this.byX != null) {
            this.byX.notifyDataSetChanged();
        }
        if (this.bzf != null) {
            this.bzf.notifyDataSetChanged();
        }
        if (this.bzg != null) {
            this.bzg.notifyDataSetChanged();
        }
        ba.i(this.byQ, com.baidu.tieba.s.cp_bg_line_d);
        ba.i(this.byY, com.baidu.tieba.s.cp_bg_line_d);
        ba.c(this.byV, com.baidu.tieba.u.icon_search_ba);
        ba.b(this.byU, com.baidu.tieba.s.cp_cont_i, 1);
        ba.b(this.byZ, com.baidu.tieba.s.cp_link_tip_a, 1);
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
}
