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
import com.baidu.tbadk.util.x;
import com.baidu.tbadk.util.y;
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
    private ImageView caP;
    private String dJQ;
    private ImageView dKa;
    private EditText duM;
    private LinearLayout fxA;
    private BdListView fxB;
    private com.baidu.tieba.mainentrance.a fxC;
    private com.baidu.tieba.mainentrance.searchSuggestList.a fxD;
    private ForumSuggestModel fxE;
    private a fxF;
    private String fxG;
    private boolean fxH;
    private ScrollView fxJ;
    private SearchPageFocusBar fxK;
    private View fxL;
    private View fxM;
    private String fxQ;
    private HotForumModel fxd;
    private LinearLayoutDetectsSoftKeyboard fxr;
    private FrameLayout fxs;
    private FrameLayout fxt;
    private TextView fxu;
    private BaseWebView fxv;
    private ScrollView fxw;
    private LinearLayout fxx;
    private List<c> fxy;
    private g fxz;
    private HotSearchInfoData mHotSearchInfo;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mTopicInfoTitle;
    private boolean fxI = true;
    private List<View> fxN = new ArrayList();
    private boolean fxe = false;
    private boolean fxO = true;
    private boolean fxP = true;
    private Runnable fxR = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.1
        @Override // java.lang.Runnable
        public void run() {
            SquareSearchActivity.this.duM.requestFocus();
            l.c(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.duM);
        }
    };
    private final Runnable fxS = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.12
        @Override // java.lang.Runnable
        public void run() {
            if (!SquareSearchActivity.this.bbl()) {
                try {
                    if (SquareSearchActivity.this.dJQ != null && SquareSearchActivity.this.dJQ.length() > 0) {
                        StringBuffer stringBuffer = new StringBuffer(30);
                        stringBuffer.append(TbConfig.SERVER_ADDRESS);
                        stringBuffer.append("c/f/forum/search");
                        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", SquareSearchActivity.this.dJQ.trim());
                        SquareSearchActivity.this.baW();
                        SquareSearchActivity.this.fxF = new a(stringBuffer.toString(), basicNameValuePair, true);
                        SquareSearchActivity.this.fxF.setPriority(3);
                        SquareSearchActivity.this.fxF.execute(stringBuffer.toString(), basicNameValuePair);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a fxT = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SEARCH_LIST, 309438) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.22
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = ((responsedMessage instanceof SearchListHttpResMessage) || (responsedMessage instanceof SearchListSocketResMessage)) ? false : true;
            if (responsedMessage == null || z || responsedMessage.getError() != 0 || responsedMessage.hasError()) {
                if (j.kV() || !SquareSearchActivity.this.fxe) {
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(e.j.neterror));
                }
                if (!j.kV()) {
                    SquareSearchActivity.this.fxe = true;
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
            if (SquareSearchActivity.this.fxO && responsedMessage.getError() != 0) {
                SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(e.j.neterror));
                return;
            }
            if (list != null && list.size() > 0) {
                SquareSearchActivity.this.fxO = false;
            }
            SquareSearchActivity.this.bbi();
            SquareSearchActivity.this.fxB.setAdapter((ListAdapter) SquareSearchActivity.this.fxD);
            SquareSearchActivity.this.fxD.rF(SquareSearchActivity.this.dJQ.trim());
            SquareSearchActivity.this.fxD.setData(list);
            SquareSearchActivity.this.fxD.notifyDataSetInvalidated();
        }
    };
    private CustomMessageListener fxi = new CustomMessageListener(2001608) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                SquareSearchActivity.this.rI(customResponsedMessage.getData().toString());
            }
        }
    };
    private CustomMessageListener fxU = new CustomMessageListener(2009002) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof ArrayList) {
                    SquareSearchActivity.this.ac((ArrayList) data);
                }
            }
        }
    };
    private View.OnClickListener fxV = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.duM);
            if (view.getTag() instanceof c) {
                c cVar = (c) view.getTag();
                TiebaStatic.log(new am("c10363").aB("obj_name", cVar.getName()));
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
                if (SquareSearchActivity.this.fxv.getUrl() != null && SquareSearchActivity.this.fxv.getUrl().contains(str)) {
                    SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.fxs);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean baV() {
        if (this.mHotSearchInfo == null) {
            return false;
        }
        if (this.mHotSearchInfo.baT() == 0) {
            Q(this.mHotSearchInfo.getName(), false);
        } else if (this.mHotSearchInfo.baT() == 1 && !com.baidu.tbadk.plugins.b.e(getPageContext())) {
            sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new am("c10355").aB("obj_name", this.mHotSearchInfo.getName()).y("obj_type", this.mHotSearchInfo.baT() == 0 ? 2 : 1));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.home_dialog_search);
        init();
        getWindow().setSoftInputMode(1);
        registerListener(this.fxU);
        registerListener(this.fxT);
        registerListener(this.fxi);
        registerListener(this.htmlLoadMessageListener);
        if (SquareSearchActivityConfig.IS_SHOW_RECOMMEND_FORUM) {
            this.fxd = new HotForumModel(getPageContext(), this);
            this.fxd.baR();
        }
        this.fxH = false;
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
        hideLoadingView(this.fxs);
        this.mHandler.removeCallbacks(this.fxR);
        baW();
    }

    public void baW() {
        this.mHandler.removeCallbacks(this.fxS);
        if (this.fxF != null) {
            this.fxF.cancel();
            this.fxF = null;
        }
    }

    private void init() {
        this.fxr = (LinearLayoutDetectsSoftKeyboard) findViewById(e.g.parent);
        this.fxr.setOnSoftKeyBoardShownListener(new LinearLayoutDetectsSoftKeyboard.a() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.24
            @Override // com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard.a
            public void jH(boolean z) {
                SquareSearchActivity.this.fxI = z;
            }
        });
        this.fxr.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.25
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    SquareSearchActivity.this.fxr.setFocusable(true);
                    SquareSearchActivity.this.fxr.setFocusableInTouchMode(true);
                    if (SquareSearchActivity.this.duM.hasFocus()) {
                        l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.duM);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        azR();
        this.fxs = (FrameLayout) findViewById(e.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(e.C0210e.ds200)), null, null);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            this.fxJ = (ScrollView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(e.h.home_searchbar_nodataview, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) this.fxJ.findViewById(e.g.focusbar_nodata_root);
            this.fxK = (SearchPageFocusBar) linearLayout.findViewById(e.g.no_data_focusbar);
            linearLayout.addView(this.mNoDataView, 0);
            this.fxJ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.26
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.fxJ);
                    return false;
                }
            });
            this.fxs.addView(this.fxJ, this.fxs.getChildCount());
        } else {
            this.fxs.addView(this.mNoDataView, 0);
        }
        this.fxt = (FrameLayout) findViewById(e.g.home_search_list);
        baU();
        baY();
        baZ();
        bba();
        this.fxv = (BaseWebView) findViewById(e.g.search_result_webview);
        this.fxv.initCommonJsBridge(getPageContext().getPageActivity());
        this.fxv.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.27
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
                if (SquareSearchActivity.this.isProgressBarShown()) {
                    SquareSearchActivity.this.hideProgressBar();
                }
            }
        });
        this.fxv.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.28
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedError", 0, "", "requesturl", str2, "receiveerror", Integer.valueOf(i), "description", str);
            }
        });
        this.fxv.setOnReceivedSslErrorListener(new BaseWebView.g() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.g
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                if (sslError != null) {
                    com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedSslError", 0, "", "requesturl", sslError.getUrl(), "receiveerror", sslError.toString());
                }
            }
        });
        this.fxv.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.3
            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.mainentrance.SquareSearchActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return ay.Es().b(SquareSearchActivity.this.getPageContext(), new String[]{str}) != 3;
            }
        });
        this.duM.setText("");
        this.duM.requestFocus();
        ShowSoftKeyPadDelay(this.duM, 200);
        bbb();
        bbc();
    }

    private void azR() {
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, e.h.square_search_navigation_view, (View.OnClickListener) null);
        this.caP = (ImageView) addCustomView.findViewById(e.g.search_bar_icon);
        this.duM = (EditText) addCustomView.findViewById(e.g.home_et_search);
        this.dKa = (ImageView) addCustomView.findViewById(e.g.home_bt_search_del);
        this.fxu = (TextView) addCustomView.findViewById(e.g.home_bt_search_cancel_s);
        this.duM.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    SquareSearchActivity.this.baX();
                } else {
                    l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.duM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.baX();
            }
        });
        this.fxu.setText(getPageContext().getString(e.j.cancel));
        this.fxu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.duM);
                com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SquareSearchActivity.this.finish();
                    }
                }, 200L);
            }
        });
        this.duM.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.7
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (SquareSearchActivity.this.dJQ == null || SquareSearchActivity.this.dJQ.trim().length() < 1) {
                        l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.duM);
                        if (SquareSearchActivity.this.baV()) {
                            return true;
                        }
                        SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(e.j.write_keyword));
                        return true;
                    }
                    String trim = SquareSearchActivity.this.duM.getText().toString().trim();
                    if (!StringUtils.isNull(trim)) {
                        SquareSearchActivity.this.Q(trim, false);
                        return true;
                    }
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(e.j.write_keyword));
                    return true;
                }
                return false;
            }
        });
        this.dKa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.duM.setText("");
            }
        });
        this.duM.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.9
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SquareSearchActivity.this.fxP) {
                    SquareSearchActivity.this.dJQ = editable.toString();
                    if (StringUtils.isNull(SquareSearchActivity.this.dJQ)) {
                        SquareSearchActivity.this.fxO = true;
                    }
                    SquareSearchActivity.this.bbf();
                }
                if (editable.toString().trim().length() == 0) {
                    SquareSearchActivity.this.dKa.setVisibility(8);
                } else {
                    SquareSearchActivity.this.dKa.setVisibility(0);
                }
                al.c(SquareSearchActivity.this.fxu, e.d.cp_link_tip_a, 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baX() {
        if (StringUtils.isNull(this.duM.getText().toString())) {
            if (this.fxw.getVisibility() != 0) {
                bbd();
            }
        } else if (this.fxB.getVisibility() != 0) {
            bbf();
        }
    }

    private void baY() {
        this.fxw = (ScrollView) findViewById(e.g.search_history_scrollview);
        this.fxx = (LinearLayout) findViewById(e.g.search_history_linearlayout);
        if (this.fxA == null) {
            this.fxA = new LinearLayout(getPageContext().getPageActivity());
            this.fxA.setOrientation(1);
            this.fxA.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
        }
        this.fxx.addView(this.fxA);
    }

    private void baZ() {
        if (this.fxz == null) {
            this.fxz = new g(getPageContext());
            this.fxx.addView(this.fxz.oH());
        }
    }

    private void bba() {
        this.fxB = (BdListView) findViewById(e.g.home_lv_search_suggest);
        this.fxC = new com.baidu.tieba.mainentrance.a(this, null);
        this.fxD = new com.baidu.tieba.mainentrance.searchSuggestList.a(getPageContext().getPageActivity(), null);
        this.fxB.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.10
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ListAdapter adapter;
                ListView listView = (ListView) adapterView;
                if (listView != null && (adapter = listView.getAdapter()) != null && adapter.getCount() != 0 && i < adapter.getCount()) {
                    Object item = adapter.getItem(i);
                    if (item instanceof String) {
                        SquareSearchActivity.this.Q((String) item, true);
                        TiebaStatic.eventStat(SquareSearchActivity.this.getPageContext().getPageActivity(), "search_bar_result_click", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    }
                }
            }
        });
        this.fxB.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.11
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), absListView);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    public void bbb() {
        this.fxu.setText(getPageContext().getString(e.j.cancel));
        bbc();
        baW();
        bbg();
        if (this.dJQ.trim().length() > 0) {
            bbf();
        } else {
            bbd();
        }
    }

    private void bbc() {
        if (this.mHotSearchInfo == null) {
            this.duM.setHint(e.j.search_bar);
        } else {
            this.duM.setHint(" " + UtilHelper.getFixedText(this.mHotSearchInfo.awf(), 15));
        }
    }

    private void baU() {
        HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
        if (hotSearchInfoData != null && hotSearchInfoData.getId() != 0) {
            this.mHotSearchInfo = hotSearchInfoData;
        }
    }

    private void bbd() {
        this.fxv.setVisibility(8);
        this.fxB.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009002));
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            jG(true);
            bp(this.fxK);
            bp(this.fxJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(ArrayList<String> arrayList) {
        NoDataViewFactory.d eq;
        if (ae(arrayList)) {
            bbk();
            if (j.kV()) {
                eq = NoDataViewFactory.d.eq(e.j.text_no_search_record);
            } else {
                eq = NoDataViewFactory.d.eq(e.j.neterror);
            }
            this.mNoDataView.setTextOption(eq);
            return;
        }
        bbj();
        ad(arrayList);
        L(true, arrayList == null || arrayList.size() == 0);
        bbc();
    }

    private void ad(final ArrayList<String> arrayList) {
        if (this.fxA != null) {
            this.fxA.removeAllViews();
            if (arrayList != null && !arrayList.isEmpty() && getActivity() != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                this.fxL = LayoutInflater.from(pageActivity).inflate(e.h.square_search_recommand_fourm_header, (ViewGroup) null);
                this.fxL.findViewById(e.g.titleTopDivider).setVisibility(8);
                getLayoutMode().onModeChanged(this.fxL);
                this.fxA.addView(this.fxL, layoutParams);
                int size = arrayList.size();
                this.fxN.clear();
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
                                y.a(new x<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // com.baidu.tbadk.util.x
                                    public Boolean doInBackground() {
                                        com.baidu.tieba.tbadkCore.util.a.wg(str);
                                        return true;
                                    }
                                }, new h<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.2
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.tbadk.util.h
                                    public void onReturnDataInUI(Boolean bool) {
                                        SquareSearchActivity.this.fxA.removeView(inflate);
                                        arrayList.remove(str);
                                        if (arrayList.size() <= 0) {
                                            SquareSearchActivity.this.ac(null);
                                        }
                                    }
                                });
                            }
                        });
                        this.fxN.add(inflate);
                        this.fxA.addView(inflate, layoutParams2);
                    }
                }
                this.fxM = LayoutInflater.from(pageActivity).inflate(e.h.home_dialog_search_footer, (ViewGroup) null);
                ((TextView) this.fxM.findViewById(e.g.home_bt_search_footer)).setTextColor(al.getColor(e.d.cp_link_tip_a));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                this.fxM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SquareSearchActivity.this.bbe();
                    }
                });
                this.fxA.addView(this.fxM, layoutParams3);
            }
        }
    }

    private void L(boolean z, boolean z2) {
        if (this.fxz != null) {
            this.fxz.clear();
            if (this.fxy != null && !this.fxy.isEmpty() && z) {
                this.fxz.jF(!z2);
                this.fxz.setTitleText(this.mTopicInfoTitle);
                int size = this.fxy.size();
                if (size >= 1) {
                    if (size > 7) {
                        size = 7;
                    }
                    int i = size % 2 == 0 ? size - 1 : size;
                    for (int i2 = 0; i2 < i; i2++) {
                        c cVar = (c) v.d(this.fxy, i2);
                        if (cVar != null) {
                            this.fxz.a(cVar, i2).setOnClickListener(this.fxV);
                        }
                    }
                    this.fxz.a(null, i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.16
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.duM);
                            if (!com.baidu.tbadk.plugins.b.e(SquareSearchActivity.this.getPageContext())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all")));
                            }
                        }
                    });
                    this.fxz.show();
                }
            }
        }
    }

    private boolean ae(ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && (this.fxy == null || this.fxy.size() <= 2) && this.fxH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbe() {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).eK(getPageContext().getString(e.j.alert_clean_history)).a(getPageContext().getString(e.j.clear_all_text), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                com.baidu.adp.lib.g.h.jH().d(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.bFJ();
                    }
                });
                if (SquareSearchActivity.this.fxy == null || SquareSearchActivity.this.fxy.size() < 2) {
                    SquareSearchActivity.this.bo(SquareSearchActivity.this.fxJ);
                    SquareSearchActivity.this.bo(SquareSearchActivity.this.fxK);
                    SquareSearchActivity.this.fxt.setVisibility(8);
                    SquareSearchActivity.this.mNoDataView.setVisibility(0);
                    SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.text_no_search_record));
                    return;
                }
                SquareSearchActivity.this.ac(null);
            }
        }).b(getPageContext().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.17
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        }).b(getPageContext()).BS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbf() {
        if (this.dJQ.trim().length() > 0) {
            bbh();
            return;
        }
        baW();
        bbd();
    }

    private void bbg() {
        if (this.fxB != null) {
            this.fxB.setNextPage(null);
        }
    }

    private void bbh() {
        if (!StringUtils.isNull(this.dJQ)) {
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.dJQ.trim();
            sendMessage(searchListNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        try {
            if (this.fxE != null) {
                if (this.fxE.forum_list != null && this.fxE.forum_list.size() > 0) {
                    bbi();
                    this.fxB.setAdapter((ListAdapter) this.fxC);
                    this.fxC.rF(this.dJQ);
                    this.fxC.ab(this.fxE.forum_list);
                    this.fxC.notifyDataSetInvalidated();
                } else {
                    bp(this.fxJ);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbi() {
        this.fxt.setVisibility(0);
        this.fxB.setVisibility(0);
        this.fxw.setVisibility(8);
        this.fxv.setVisibility(8);
        bp(this.fxJ);
        this.mNoDataView.setVisibility(8);
    }

    private void bbj() {
        this.fxt.setVisibility(0);
        this.fxw.setVisibility(0);
        this.fxB.setVisibility(8);
        this.fxv.setVisibility(8);
        bp(this.fxJ);
        this.mNoDataView.setVisibility(8);
    }

    private void bbk() {
        this.fxt.setVisibility(8);
        this.fxB.setVisibility(8);
        this.fxw.setVisibility(8);
        this.fxv.setVisibility(8);
        bo(this.fxJ);
        this.mNoDataView.setVisibility(0);
        bo(this.fxK);
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void rG(String str) {
        this.fxH = true;
        this.fxy = new ArrayList();
        bbd();
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void a(List<com.baidu.tieba.mainentrance.b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str) {
        this.fxH = true;
        hideLoadingView(this.fxs);
        if (list2 == null) {
            this.fxy = new ArrayList();
        } else {
            this.fxy = list2;
        }
        if (!StringUtils.isNULL(str)) {
            this.mTopicInfoTitle = str;
        } else {
            this.mTopicInfoTitle = "";
        }
        a(hotSearchInfoData);
        this.mHotSearchInfo = hotSearchInfoData;
        bbd();
    }

    private void a(HotSearchInfoData hotSearchInfoData) {
        if (hotSearchInfoData != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
            return;
        }
        HotSearchInfoData hotSearchInfoData2 = new HotSearchInfoData();
        hotSearchInfoData2.setId(0L);
        hotSearchInfoData2.setName("");
        hotSearchInfoData2.rH("");
        hotSearchInfoData2.cM(0L);
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
        getLayoutMode().onModeChanged(this.fxr);
        al.e(this.fxr, i);
        if (this.fxC != null) {
            this.fxC.notifyDataSetChanged();
        }
        if (i == 2) {
            this.duM.setHintTextColor(al.getColor(e.d.s_navbar_title_color));
        } else {
            this.duM.setHintTextColor(al.getColor(e.d.cp_cont_e));
        }
        al.c(this.dKa, e.f.del_search_btn);
        al.b(this.duM, e.d.cp_cont_b, e.d.s_navbar_title_color);
        al.a(this.caP, e.f.icon_seach_n, e.f.icon_seach_n, e.f.icon_seach_n, i);
        al.i(this.fxs, e.d.cp_bg_line_d);
        al.c(this.fxu, e.d.cp_link_tip_a, 1);
        if (this.fxz != null) {
            this.fxz.onChangeSkinType(i);
        }
        rx(i);
    }

    private void rx(int i) {
        if (this.fxA != null) {
            this.fxA.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
        }
        if (this.fxL != null) {
            getLayoutMode().onModeChanged(this.fxL);
        }
        if (this.fxM != null) {
            ((TextView) this.fxM.findViewById(e.g.home_bt_search_footer)).setTextColor(al.getColor(e.d.cp_link_tip_a));
        }
        if (this.fxN != null) {
            for (View view : this.fxN) {
                al.c((TextView) view.findViewById(e.g.home_lv_search_forum), e.d.cp_cont_b, 1);
                view.findViewById(e.g.home_dialog_lv_search_forum_divider).setBackgroundColor(al.getColor(e.d.cp_bg_line_b));
                al.i(view, e.f.addresslist_item_bg);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (i == 4 && this.fxv.canGoBack()) {
                this.fxv.goBack();
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
                SquareSearchActivity.this.dJQ = this.mName;
                TiebaStatic.log(new am("c12034"));
                SquareSearchActivity.this.Q(this.mName, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bbl() {
        if (!j.kV()) {
            bo(this.mNoDataView);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.neterror));
            return true;
        }
        bp(this.mNoDataView);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
        private BasicNameValuePair fyd;
        private com.baidu.tbadk.core.util.x mNetwork = null;
        private String mUrl;

        public a(String str, BasicNameValuePair basicNameValuePair, boolean z) {
            this.mUrl = null;
            this.fyd = null;
            this.mUrl = str;
            this.fyd = basicNameValuePair;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!SquareSearchActivity.this.bbl()) {
                SquareSearchActivity.this.bp(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.fxs, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(e.C0210e.ds320));
                SquareSearchActivity.this.fxt.setVisibility(8);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public ForumSuggestModel doInBackground(Object... objArr) {
            ForumSuggestModel forumSuggestModel = null;
            if (j.kV()) {
                try {
                    this.mNetwork = new com.baidu.tbadk.core.util.x(this.mUrl);
                    this.mNetwork.a(this.fyd);
                    String CY = this.mNetwork.CY();
                    if (CY != null) {
                        forumSuggestModel = ForumSuggestModel.parserJson(CY);
                        SquareSearchActivity.this.fxG = this.fyd.getValue();
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
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.fxs);
            if (forumSuggestModel != null) {
                SquareSearchActivity.this.bp(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.fxE = forumSuggestModel;
                SquareSearchActivity.this.refresh();
            } else {
                SquareSearchActivity.this.bo(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.text_no_search_record));
            }
            SquareSearchActivity.this.fxF = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.jg();
                this.mNetwork = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.fxs);
            super.cancel(true);
        }
    }

    private void jG(boolean z) {
        if (TbadkCoreApplication.isLogin()) {
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(2001323, true));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(2001323, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bo(View view) {
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(View view) {
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a026";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(final String str, boolean z) {
        if (!j.kV()) {
            showToast(e.j.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.fxP = false;
                this.duM.setText(str);
                this.duM.setSelection(str.length());
                this.fxP = true;
            }
            l.b(getPageContext().getPageActivity(), this.duM);
            this.fxw.setVisibility(8);
            this.fxB.setVisibility(8);
            this.fxv.setVisibility(0);
            showProgressBarWithOffset(0, 0);
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, IoUtils.UTF_8);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            this.fxv.loadUrl(str2);
            y.a(new x<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.x
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.we(str);
                    return true;
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rI(String str) {
        if (!j.kV()) {
            showToast(e.j.neterror);
        } else if (!StringUtils.isNull(str)) {
            this.fxQ = str;
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BIND_WIDGET)));
            } else {
                sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), str)));
            }
        }
    }
}
