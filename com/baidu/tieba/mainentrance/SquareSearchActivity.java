package com.baidu.tieba.mainentrance;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.AdapterView;
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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.ar.util.IoUtils;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateBarGuideActivityConfig;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.RequestEnterForumDataMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.e;
import com.baidu.tieba.mainentrance.HotForumModel;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListHttpResMessage;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListNetMessage;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListSocketResMessage;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
@SuppressLint({"ResourceAsColor"})
@Deprecated
/* loaded from: classes3.dex */
public class SquareSearchActivity extends BaseActivity<SquareSearchActivity> implements HotForumModel.a {
    private ImageView bVv;
    private EditText djI;
    private String dyD;
    private ImageView dyN;
    private BaseWebView flA;
    private ScrollView flB;
    private LinearLayout flC;
    private List<c> flD;
    private g flE;
    private LinearLayout flF;
    private BdListView flG;
    private com.baidu.tieba.mainentrance.a flH;
    private com.baidu.tieba.mainentrance.searchSuggestList.a flI;
    private ForumSuggestModel flJ;
    private a flK;
    private String flL;
    private boolean flM;
    private ScrollView flO;
    private SearchPageFocusBar flP;
    private View flQ;
    private View flR;
    private String flV;
    private HotForumModel fli;
    private LinearLayoutDetectsSoftKeyboard flw;
    private FrameLayout flx;
    private FrameLayout fly;
    private TextView flz;
    private HotSearchInfoData mHotSearchInfo;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mTopicInfoTitle;
    private boolean flN = true;
    private List<View> flS = new ArrayList();
    private boolean flj = false;
    private boolean flT = true;
    private boolean flU = true;
    private Runnable flW = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.1
        @Override // java.lang.Runnable
        public void run() {
            SquareSearchActivity.this.djI.requestFocus();
            l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.djI);
        }
    };
    private final Runnable flX = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.12
        @Override // java.lang.Runnable
        public void run() {
            if (!SquareSearchActivity.this.aYJ()) {
                try {
                    if (SquareSearchActivity.this.dyD != null && SquareSearchActivity.this.dyD.length() > 0) {
                        StringBuffer stringBuffer = new StringBuffer(30);
                        stringBuffer.append(TbConfig.SERVER_ADDRESS);
                        stringBuffer.append("c/f/forum/search");
                        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", SquareSearchActivity.this.dyD.trim());
                        SquareSearchActivity.this.aYu();
                        SquareSearchActivity.this.flK = new a(stringBuffer.toString(), basicNameValuePair, true);
                        SquareSearchActivity.this.flK.setPriority(3);
                        SquareSearchActivity.this.flK.execute(stringBuffer.toString(), basicNameValuePair);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a flY = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SEARCH_LIST, 309438) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.22
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = ((responsedMessage instanceof SearchListHttpResMessage) || (responsedMessage instanceof SearchListSocketResMessage)) ? false : true;
            if (responsedMessage == null || z || responsedMessage.getError() != 0 || responsedMessage.hasError()) {
                if (j.kX() || !SquareSearchActivity.this.flj) {
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(e.j.neterror));
                }
                if (!j.kX()) {
                    SquareSearchActivity.this.flj = true;
                    return;
                }
                return;
            }
            List<String> list = null;
            if (responsedMessage instanceof SearchListHttpResMessage) {
                list = ((SearchListHttpResMessage) responsedMessage).suggests;
            } else if (responsedMessage instanceof SearchListSocketResMessage) {
                list = ((SearchListSocketResMessage) responsedMessage).suggests;
            }
            if (SquareSearchActivity.this.flT && responsedMessage.getError() != 0) {
                SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(e.j.neterror));
                return;
            }
            if (list != null && list.size() > 0) {
                SquareSearchActivity.this.flT = false;
            }
            SquareSearchActivity.this.aYG();
            SquareSearchActivity.this.flG.setAdapter((ListAdapter) SquareSearchActivity.this.flI);
            SquareSearchActivity.this.flI.qJ(SquareSearchActivity.this.dyD.trim());
            SquareSearchActivity.this.flI.setData(list);
            SquareSearchActivity.this.flI.notifyDataSetInvalidated();
        }
    };
    private CustomMessageListener fln = new CustomMessageListener(2001608) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                SquareSearchActivity.this.qM(customResponsedMessage.getData().toString());
            }
        }
    };
    private CustomMessageListener flZ = new CustomMessageListener(2009002) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof ArrayList) {
                    SquareSearchActivity.this.ad((ArrayList) data);
                }
            }
        }
    };
    private View.OnClickListener fma = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.djI);
            if (view.getTag() instanceof c) {
                c cVar = (c) view.getTag();
                TiebaStatic.log(new am("c10363").ax("obj_name", cVar.getName()));
                if (!com.baidu.tbadk.plugins.b.e(SquareSearchActivity.this.getPageContext())) {
                    SquareSearchActivity.this.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(SquareSearchActivity.this.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(cVar.getId()), cVar.getName(), "4")));
                }
            }
        }
    };
    CustomMessageListener htmlLoadMessageListener = new CustomMessageListener(2921023) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921023 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (SquareSearchActivity.this.flA.getUrl() != null && SquareSearchActivity.this.flA.getUrl().contains(str)) {
                    SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.flx);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aYt() {
        if (this.mHotSearchInfo == null) {
            return false;
        }
        if (this.mHotSearchInfo.aYr() == 0) {
            P(this.mHotSearchInfo.getName(), false);
        } else if (this.mHotSearchInfo.aYr() == 1 && !com.baidu.tbadk.plugins.b.e(getPageContext())) {
            sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new am("c10355").ax("obj_name", this.mHotSearchInfo.getName()).x("obj_type", this.mHotSearchInfo.aYr() == 0 ? 2 : 1));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.home_dialog_search);
        init();
        getWindow().setSoftInputMode(1);
        registerListener(this.flZ);
        registerListener(this.flY);
        registerListener(this.fln);
        registerListener(this.htmlLoadMessageListener);
        if (SquareSearchActivityConfig.IS_SHOW_RECOMMEND_FORUM) {
            this.fli = new HotForumModel(getPageContext(), this);
            this.fli.aYp();
        }
        this.flM = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        hideLoadingView(this.flx);
        this.mHandler.removeCallbacks(this.flW);
        aYu();
    }

    public void aYu() {
        this.mHandler.removeCallbacks(this.flX);
        if (this.flK != null) {
            this.flK.cancel();
            this.flK = null;
        }
    }

    private void init() {
        this.flw = (LinearLayoutDetectsSoftKeyboard) findViewById(e.g.parent);
        this.flw.setOnSoftKeyBoardShownListener(new LinearLayoutDetectsSoftKeyboard.a() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.24
            @Override // com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard.a
            public void jr(boolean z) {
                SquareSearchActivity.this.flN = z;
            }
        });
        this.flw.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.25
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    SquareSearchActivity.this.flw.setFocusable(true);
                    SquareSearchActivity.this.flw.setFocusableInTouchMode(true);
                    if (SquareSearchActivity.this.djI.hasFocus()) {
                        l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.djI);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        axw();
        this.flx = (FrameLayout) findViewById(e.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(e.C0175e.ds200)), null, null);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            this.flO = (ScrollView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(e.h.home_searchbar_nodataview, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) this.flO.findViewById(e.g.focusbar_nodata_root);
            this.flP = (SearchPageFocusBar) linearLayout.findViewById(e.g.no_data_focusbar);
            linearLayout.addView(this.mNoDataView, 0);
            this.flO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.26
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.flO);
                    return false;
                }
            });
            this.flx.addView(this.flO, this.flx.getChildCount());
        } else {
            this.flx.addView(this.mNoDataView, 0);
        }
        this.fly = (FrameLayout) findViewById(e.g.home_search_list);
        aYs();
        aYw();
        aYx();
        aYy();
        this.flA = (BaseWebView) findViewById(e.g.search_result_webview);
        this.flA.initCommonJsBridge(getPageContext().getPageActivity());
        this.flA.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.27
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
                if (SquareSearchActivity.this.isProgressBarShown()) {
                    SquareSearchActivity.this.hideProgressBar();
                }
            }
        });
        this.flA.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.28
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedError", 0, "", "requesturl", str2, "receiveerror", Integer.valueOf(i), "description", str);
            }
        });
        this.flA.setOnReceivedSslErrorListener(new BaseWebView.g() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.g
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                if (sslError != null) {
                    com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedSslError", 0, "", "requesturl", sslError.getUrl(), "receiveerror", sslError.toString());
                }
            }
        });
        this.flA.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.3
            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.mainentrance.SquareSearchActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return ay.CU().b(SquareSearchActivity.this.getPageContext(), new String[]{str}) != 3;
            }
        });
        this.djI.setText("");
        this.djI.requestFocus();
        ShowSoftKeyPadDelay(this.djI, 200);
        aYz();
        aYA();
    }

    private void axw() {
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, e.h.square_search_navigation_view, (View.OnClickListener) null);
        this.bVv = (ImageView) addCustomView.findViewById(e.g.search_bar_icon);
        this.djI = (EditText) addCustomView.findViewById(e.g.home_et_search);
        this.dyN = (ImageView) addCustomView.findViewById(e.g.home_bt_search_del);
        this.flz = (TextView) addCustomView.findViewById(e.g.home_bt_search_cancel_s);
        this.djI.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    SquareSearchActivity.this.aYv();
                } else {
                    l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.djI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.aYv();
            }
        });
        this.flz.setText(getPageContext().getString(e.j.cancel));
        this.flz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.djI);
                com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SquareSearchActivity.this.finish();
                    }
                }, 200L);
            }
        });
        this.djI.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.7
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (SquareSearchActivity.this.dyD == null || SquareSearchActivity.this.dyD.trim().length() < 1) {
                        l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.djI);
                        if (SquareSearchActivity.this.aYt()) {
                            return true;
                        }
                        SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(e.j.write_keyword));
                        return true;
                    }
                    String trim = SquareSearchActivity.this.djI.getText().toString().trim();
                    if (!StringUtils.isNull(trim)) {
                        SquareSearchActivity.this.P(trim, false);
                        return true;
                    }
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(e.j.write_keyword));
                    return true;
                }
                return false;
            }
        });
        this.dyN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.djI.setText("");
            }
        });
        this.djI.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.9
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SquareSearchActivity.this.flU) {
                    SquareSearchActivity.this.dyD = editable.toString();
                    if (StringUtils.isNull(SquareSearchActivity.this.dyD)) {
                        SquareSearchActivity.this.flT = true;
                    }
                    SquareSearchActivity.this.aYD();
                }
                if (editable.toString().trim().length() == 0) {
                    SquareSearchActivity.this.dyN.setVisibility(8);
                } else {
                    SquareSearchActivity.this.dyN.setVisibility(0);
                }
                al.c(SquareSearchActivity.this.flz, e.d.cp_link_tip_a, 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYv() {
        if (StringUtils.isNull(this.djI.getText().toString())) {
            if (this.flB.getVisibility() != 0) {
                aYB();
            }
        } else if (this.flG.getVisibility() != 0) {
            aYD();
        }
    }

    private void aYw() {
        this.flB = (ScrollView) findViewById(e.g.search_history_scrollview);
        this.flC = (LinearLayout) findViewById(e.g.search_history_linearlayout);
        if (this.flF == null) {
            this.flF = new LinearLayout(getPageContext().getPageActivity());
            this.flF.setOrientation(1);
            this.flF.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
        }
        this.flC.addView(this.flF);
    }

    private void aYx() {
        if (this.flE == null) {
            this.flE = new g(getPageContext());
            this.flC.addView(this.flE.oG());
        }
    }

    private void aYy() {
        this.flG = (BdListView) findViewById(e.g.home_lv_search_suggest);
        this.flH = new com.baidu.tieba.mainentrance.a(this, null);
        this.flI = new com.baidu.tieba.mainentrance.searchSuggestList.a(getPageContext().getPageActivity(), null);
        this.flG.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.10
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ListAdapter adapter;
                ListView listView = (ListView) adapterView;
                if (listView != null && (adapter = listView.getAdapter()) != null && adapter.getCount() != 0 && i < adapter.getCount()) {
                    Object item = adapter.getItem(i);
                    if (item instanceof String) {
                        SquareSearchActivity.this.P((String) item, true);
                        TiebaStatic.eventStat(SquareSearchActivity.this.getPageContext().getPageActivity(), "search_bar_result_click", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    }
                }
            }
        });
        this.flG.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.11
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), absListView);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    public void aYz() {
        this.flz.setText(getPageContext().getString(e.j.cancel));
        aYA();
        aYu();
        aYE();
        if (this.dyD.trim().length() > 0) {
            aYD();
        } else {
            aYB();
        }
    }

    private void aYA() {
        if (this.mHotSearchInfo == null) {
            this.djI.setHint(e.j.search_bar);
        } else {
            this.djI.setHint(" " + UtilHelper.getFixedText(this.mHotSearchInfo.atH(), 15));
        }
    }

    private void aYs() {
        HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
        if (hotSearchInfoData != null && hotSearchInfoData.getId() != 0) {
            this.mHotSearchInfo = hotSearchInfoData;
        }
    }

    private void aYB() {
        this.flA.setVisibility(8);
        this.flG.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009002));
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            jq(true);
            bk(this.flP);
            bk(this.flO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(ArrayList<String> arrayList) {
        NoDataViewFactory.d dO;
        if (af(arrayList)) {
            aYI();
            if (j.kX()) {
                dO = NoDataViewFactory.d.dO(e.j.text_no_search_record);
            } else {
                dO = NoDataViewFactory.d.dO(e.j.neterror);
            }
            this.mNoDataView.setTextOption(dO);
            return;
        }
        aYH();
        ae(arrayList);
        J(true, arrayList == null || arrayList.size() == 0);
        aYA();
    }

    private void ae(final ArrayList<String> arrayList) {
        if (this.flF != null) {
            this.flF.removeAllViews();
            if (arrayList != null && !arrayList.isEmpty() && getActivity() != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                this.flQ = LayoutInflater.from(pageActivity).inflate(e.h.square_search_recommand_fourm_header, (ViewGroup) null);
                this.flQ.findViewById(e.g.titleTopDivider).setVisibility(8);
                getLayoutMode().onModeChanged(this.flQ);
                this.flF.addView(this.flQ, layoutParams);
                int size = arrayList.size();
                this.flS.clear();
                for (int i = 0; i < size; i++) {
                    final String str = arrayList.get(i);
                    if (!TextUtils.isEmpty(str)) {
                        final View inflate = LayoutInflater.from(pageActivity).inflate(e.h.home_dialog_search_item, (ViewGroup) null);
                        ((TextView) inflate.findViewById(e.g.home_lv_search_forum)).setText(str);
                        al.c((TextView) inflate.findViewById(e.g.home_lv_search_forum), e.d.cp_cont_b, 1);
                        inflate.findViewById(e.g.home_dialog_lv_search_forum_divider).setVisibility(8);
                        al.i(inflate, e.f.square_search_item_bg);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        inflate.setOnClickListener(new b(str));
                        ImageView imageView = (ImageView) inflate.findViewById(e.g.del_search_history_btn);
                        al.c(imageView, e.f.icn_shop_order_close);
                        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                x.a(new w<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // com.baidu.tbadk.util.w
                                    public Boolean doInBackground() {
                                        com.baidu.tieba.tbadkCore.util.a.vh(str);
                                        return true;
                                    }
                                }, new h<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.2
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.tbadk.util.h
                                    public void onReturnDataInUI(Boolean bool) {
                                        SquareSearchActivity.this.flF.removeView(inflate);
                                        arrayList.remove(str);
                                        if (arrayList.size() <= 0) {
                                            SquareSearchActivity.this.ad(null);
                                        }
                                    }
                                });
                            }
                        });
                        this.flS.add(inflate);
                        this.flF.addView(inflate, layoutParams2);
                    }
                }
                this.flR = LayoutInflater.from(pageActivity).inflate(e.h.home_dialog_search_footer, (ViewGroup) null);
                ((TextView) this.flR.findViewById(e.g.home_bt_search_footer)).setTextColor(al.getColor(e.d.cp_link_tip_a));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                this.flR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SquareSearchActivity.this.aYC();
                    }
                });
                this.flF.addView(this.flR, layoutParams3);
            }
        }
    }

    private void J(boolean z, boolean z2) {
        if (this.flE != null) {
            this.flE.clear();
            if (this.flD != null && !this.flD.isEmpty() && z) {
                this.flE.jp(!z2);
                this.flE.setTitleText(this.mTopicInfoTitle);
                int size = this.flD.size();
                if (size >= 1) {
                    if (size > 7) {
                        size = 7;
                    }
                    int i = size % 2 == 0 ? size - 1 : size;
                    for (int i2 = 0; i2 < i; i2++) {
                        c cVar = (c) v.d(this.flD, i2);
                        if (cVar != null) {
                            this.flE.a(cVar, i2).setOnClickListener(this.fma);
                        }
                    }
                    this.flE.a(null, i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.16
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.djI);
                            if (!com.baidu.tbadk.plugins.b.e(SquareSearchActivity.this.getPageContext())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all")));
                            }
                        }
                    });
                    this.flE.show();
                }
            }
        }
    }

    private boolean af(ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && (this.flD == null || this.flD.size() <= 2) && this.flM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYC() {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).ej(getPageContext().getString(e.j.alert_clean_history)).a(getPageContext().getString(e.j.clear_all_text), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                com.baidu.adp.lib.g.h.jJ().d(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.bCT();
                    }
                });
                if (SquareSearchActivity.this.flD == null || SquareSearchActivity.this.flD.size() < 2) {
                    SquareSearchActivity.this.bj(SquareSearchActivity.this.flO);
                    SquareSearchActivity.this.bj(SquareSearchActivity.this.flP);
                    SquareSearchActivity.this.fly.setVisibility(8);
                    SquareSearchActivity.this.mNoDataView.setVisibility(0);
                    SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.dO(e.j.text_no_search_record));
                    return;
                }
                SquareSearchActivity.this.ad(null);
            }
        }).b(getPageContext().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.17
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        }).b(getPageContext()).Au();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYD() {
        if (this.dyD.trim().length() > 0) {
            aYF();
            return;
        }
        aYu();
        aYB();
    }

    private void aYE() {
        if (this.flG != null) {
            this.flG.setNextPage(null);
        }
    }

    private void aYF() {
        if (!StringUtils.isNull(this.dyD)) {
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.dyD.trim();
            sendMessage(searchListNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        try {
            if (this.flJ != null) {
                if (this.flJ.forum_list != null && this.flJ.forum_list.size() > 0) {
                    aYG();
                    this.flG.setAdapter((ListAdapter) this.flH);
                    this.flH.qJ(this.dyD);
                    this.flH.ac(this.flJ.forum_list);
                    this.flH.notifyDataSetInvalidated();
                } else {
                    bk(this.flO);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYG() {
        this.fly.setVisibility(0);
        this.flG.setVisibility(0);
        this.flB.setVisibility(8);
        this.flA.setVisibility(8);
        bk(this.flO);
        this.mNoDataView.setVisibility(8);
    }

    private void aYH() {
        this.fly.setVisibility(0);
        this.flB.setVisibility(0);
        this.flG.setVisibility(8);
        this.flA.setVisibility(8);
        bk(this.flO);
        this.mNoDataView.setVisibility(8);
    }

    private void aYI() {
        this.fly.setVisibility(8);
        this.flG.setVisibility(8);
        this.flB.setVisibility(8);
        this.flA.setVisibility(8);
        bj(this.flO);
        this.mNoDataView.setVisibility(0);
        bj(this.flP);
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void qK(String str) {
        this.flM = true;
        this.flD = new ArrayList();
        aYB();
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void a(List<com.baidu.tieba.mainentrance.b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str) {
        this.flM = true;
        hideLoadingView(this.flx);
        if (list2 == null) {
            this.flD = new ArrayList();
        } else {
            this.flD = list2;
        }
        if (!StringUtils.isNULL(str)) {
            this.mTopicInfoTitle = str;
        } else {
            this.mTopicInfoTitle = "";
        }
        a(hotSearchInfoData);
        this.mHotSearchInfo = hotSearchInfoData;
        aYB();
    }

    private void a(HotSearchInfoData hotSearchInfoData) {
        if (hotSearchInfoData != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
            return;
        }
        HotSearchInfoData hotSearchInfoData2 = new HotSearchInfoData();
        hotSearchInfoData2.setId(0L);
        hotSearchInfoData2.setName("");
        hotSearchInfoData2.qL("");
        hotSearchInfoData2.cF(0L);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.flw);
        al.e(this.flw, i);
        if (this.flH != null) {
            this.flH.notifyDataSetChanged();
        }
        if (i == 2) {
            this.djI.setHintTextColor(al.getColor(e.d.s_navbar_title_color));
        } else {
            this.djI.setHintTextColor(al.getColor(e.d.cp_cont_e));
        }
        al.c(this.dyN, e.f.del_search_btn);
        al.b(this.djI, e.d.cp_cont_b, e.d.s_navbar_title_color);
        al.a(this.bVv, e.f.icon_seach_n, e.f.icon_seach_n, e.f.icon_seach_n, i);
        al.i(this.flx, e.d.cp_bg_line_d);
        al.c(this.flz, e.d.cp_link_tip_a, 1);
        if (this.flE != null) {
            this.flE.onChangeSkinType(i);
        }
        qv(i);
    }

    private void qv(int i) {
        if (this.flF != null) {
            this.flF.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
        }
        if (this.flQ != null) {
            getLayoutMode().onModeChanged(this.flQ);
        }
        if (this.flR != null) {
            ((TextView) this.flR.findViewById(e.g.home_bt_search_footer)).setTextColor(al.getColor(e.d.cp_link_tip_a));
        }
        if (this.flS != null) {
            for (View view : this.flS) {
                al.c((TextView) view.findViewById(e.g.home_lv_search_forum), e.d.cp_cont_b, 1);
                view.findViewById(e.g.home_dialog_lv_search_forum_divider).setBackgroundColor(al.getColor(e.d.cp_bg_line_b));
                al.i(view, e.f.addresslist_item_bg);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (i == 4 && this.flA.canGoBack()) {
                this.flA.goBack();
                return true;
            }
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
            com.baidu.tbadk.core.e.b.k(getPageContext().getPageActivity(), 1);
        } else {
            com.baidu.tbadk.core.e.b.k(getPageContext().getPageActivity(), 2);
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
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private String mName;

        public b(String str) {
            this.mName = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(this.mName)) {
                SquareSearchActivity.this.dyD = this.mName;
                TiebaStatic.log(new am("c12034"));
                SquareSearchActivity.this.P(this.mName, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aYJ() {
        if (!j.kX()) {
            bj(this.mNoDataView);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dO(e.j.neterror));
            return true;
        }
        bk(this.mNoDataView);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
        private BasicNameValuePair fmi;
        private com.baidu.tbadk.core.util.x mNetwork = null;
        private String mUrl;

        public a(String str, BasicNameValuePair basicNameValuePair, boolean z) {
            this.mUrl = null;
            this.fmi = null;
            this.mUrl = str;
            this.fmi = basicNameValuePair;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!SquareSearchActivity.this.aYJ()) {
                SquareSearchActivity.this.bk(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.flx, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(e.C0175e.ds320));
                SquareSearchActivity.this.fly.setVisibility(8);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public ForumSuggestModel doInBackground(Object... objArr) {
            ForumSuggestModel forumSuggestModel = null;
            if (j.kX()) {
                try {
                    this.mNetwork = new com.baidu.tbadk.core.util.x(this.mUrl);
                    this.mNetwork.a(this.fmi);
                    String BA = this.mNetwork.BA();
                    if (BA != null) {
                        forumSuggestModel = ForumSuggestModel.parserJson(BA);
                        SquareSearchActivity.this.flL = this.fmi.getValue();
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
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.flx);
            if (forumSuggestModel != null) {
                SquareSearchActivity.this.bk(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.flJ = forumSuggestModel;
                SquareSearchActivity.this.refresh();
            } else {
                SquareSearchActivity.this.bj(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.dO(e.j.text_no_search_record));
            }
            SquareSearchActivity.this.flK = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.ji();
                this.mNetwork = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.flx);
            super.cancel(true);
        }
    }

    private void jq(boolean z) {
        if (TbadkCoreApplication.isLogin()) {
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(2001323, true));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(2001323, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bj(View view) {
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bk(View view) {
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a026";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(final String str, boolean z) {
        if (!j.kX()) {
            showToast(e.j.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.flU = false;
                this.djI.setText(str);
                this.djI.setSelection(str.length());
                this.flU = true;
            }
            l.a(getPageContext().getPageActivity(), this.djI);
            this.flB.setVisibility(8);
            this.flG.setVisibility(8);
            this.flA.setVisibility(0);
            showProgressBarWithOffset(0, 0);
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, IoUtils.UTF_8);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            this.flA.loadUrl(str2);
            x.a(new w<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.w
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.vf(str);
                    return true;
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qM(String str) {
        if (!j.kX()) {
            showToast(e.j.neterror);
        } else if (!StringUtils.isNull(str)) {
            this.flV = str;
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BIND_WIDGET)));
            } else {
                sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), str)));
            }
        }
    }
}
