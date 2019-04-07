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
import com.baidu.adp.lib.g.h;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.d;
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
/* loaded from: classes6.dex */
public class SquareSearchActivity extends BaseActivity<SquareSearchActivity> implements HotForumModel.a {
    private ImageView dpR;
    private EditText eHM;
    private String eWT;
    private ImageView eXd;
    private HotForumModel gMU;
    private ScrollView gNA;
    private SearchPageFocusBar gNB;
    private View gNC;
    private View gND;
    private String gNH;
    private LinearLayoutDetectsSoftKeyboard gNi;
    private FrameLayout gNj;
    private FrameLayout gNk;
    private TextView gNl;
    private BaseWebView gNm;
    private ScrollView gNn;
    private LinearLayout gNo;
    private List<c> gNp;
    private g gNq;
    private LinearLayout gNr;
    private BdListView gNs;
    private com.baidu.tieba.mainentrance.a gNt;
    private com.baidu.tieba.mainentrance.searchSuggestList.b gNu;
    private ForumSuggestModel gNv;
    private a gNw;
    private String gNx;
    private boolean gNy;
    private HotSearchInfoData mHotSearchInfo;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mTopicInfoTitle;
    private boolean gNz = true;
    private List<View> gNE = new ArrayList();
    private boolean gMV = false;
    private boolean gNF = true;
    private boolean gNG = true;
    private Runnable gNI = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.1
        @Override // java.lang.Runnable
        public void run() {
            SquareSearchActivity.this.eHM.requestFocus();
            l.c(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.eHM);
        }
    };
    private final Runnable gNJ = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.12
        @Override // java.lang.Runnable
        public void run() {
            if (!SquareSearchActivity.this.bBL()) {
                try {
                    if (SquareSearchActivity.this.eWT != null && SquareSearchActivity.this.eWT.length() > 0) {
                        StringBuffer stringBuffer = new StringBuffer(30);
                        stringBuffer.append(TbConfig.SERVER_ADDRESS);
                        stringBuffer.append("c/f/forum/search");
                        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", SquareSearchActivity.this.eWT.trim());
                        SquareSearchActivity.this.bBw();
                        SquareSearchActivity.this.gNw = new a(stringBuffer.toString(), basicNameValuePair, true);
                        SquareSearchActivity.this.gNw.setPriority(3);
                        SquareSearchActivity.this.gNw.execute(stringBuffer.toString(), basicNameValuePair);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a gNK = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SEARCH_LIST, 309438) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.22
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = ((responsedMessage instanceof SearchListHttpResMessage) || (responsedMessage instanceof SearchListSocketResMessage)) ? false : true;
            if (responsedMessage == null || z || responsedMessage.getError() != 0 || responsedMessage.hasError()) {
                if (j.kY() || !SquareSearchActivity.this.gMV) {
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(d.j.neterror));
                }
                if (!j.kY()) {
                    SquareSearchActivity.this.gMV = true;
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
            if (SquareSearchActivity.this.gNF && responsedMessage.getError() != 0) {
                SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(d.j.neterror));
                return;
            }
            if (list != null && list.size() > 0) {
                SquareSearchActivity.this.gNF = false;
            }
            SquareSearchActivity.this.bBI();
            SquareSearchActivity.this.gNs.setAdapter((ListAdapter) SquareSearchActivity.this.gNu);
            SquareSearchActivity.this.gNu.yh(SquareSearchActivity.this.eWT.trim());
            SquareSearchActivity.this.gNu.setData(list);
            SquareSearchActivity.this.gNu.notifyDataSetInvalidated();
        }
    };
    private CustomMessageListener gMZ = new CustomMessageListener(2001608) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                SquareSearchActivity.this.yk(customResponsedMessage.getData().toString());
            }
        }
    };
    private CustomMessageListener gNL = new CustomMessageListener(2009002) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof ArrayList) {
                    SquareSearchActivity.this.ag((ArrayList) data);
                }
            }
        }
    };
    private View.OnClickListener gNM = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.eHM);
            if (view.getTag() instanceof c) {
                c cVar = (c) view.getTag();
                TiebaStatic.log(new am("c10363").bJ("obj_name", cVar.getName()));
                if (!com.baidu.tbadk.plugins.b.f(SquareSearchActivity.this.getPageContext())) {
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
                if (SquareSearchActivity.this.gNm.getUrl() != null && SquareSearchActivity.this.gNm.getUrl().contains(str)) {
                    SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.gNj);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bBv() {
        if (this.mHotSearchInfo == null) {
            return false;
        }
        if (this.mHotSearchInfo.bBt() == 0) {
            ak(this.mHotSearchInfo.getName(), false);
        } else if (this.mHotSearchInfo.bBt() == 1 && !com.baidu.tbadk.plugins.b.f(getPageContext())) {
            sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new am("c10355").bJ("obj_name", this.mHotSearchInfo.getName()).T("obj_type", this.mHotSearchInfo.bBt() == 0 ? 2 : 1));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.home_dialog_search);
        init();
        getWindow().setSoftInputMode(1);
        registerListener(this.gNL);
        registerListener(this.gNK);
        registerListener(this.gMZ);
        registerListener(this.htmlLoadMessageListener);
        if (SquareSearchActivityConfig.IS_SHOW_RECOMMEND_FORUM) {
            this.gMU = new HotForumModel(getPageContext(), this);
            this.gMU.bBr();
        }
        this.gNy = false;
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
        hideLoadingView(this.gNj);
        this.mHandler.removeCallbacks(this.gNI);
        bBw();
    }

    public void bBw() {
        this.mHandler.removeCallbacks(this.gNJ);
        if (this.gNw != null) {
            this.gNw.cancel();
            this.gNw = null;
        }
    }

    private void init() {
        this.gNi = (LinearLayoutDetectsSoftKeyboard) findViewById(d.g.parent);
        this.gNi.setOnSoftKeyBoardShownListener(new LinearLayoutDetectsSoftKeyboard.a() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.24
            @Override // com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard.a
            public void mi(boolean z) {
                SquareSearchActivity.this.gNz = z;
            }
        });
        this.gNi.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.25
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    SquareSearchActivity.this.gNi.setFocusable(true);
                    SquareSearchActivity.this.gNi.setFocusableInTouchMode(true);
                    if (SquareSearchActivity.this.eHM.hasFocus()) {
                        l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.eHM);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        aBy();
        this.gNj = (FrameLayout) findViewById(d.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds200)), null, null);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            this.gNA = (ScrollView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.h.home_searchbar_nodataview, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) this.gNA.findViewById(d.g.focusbar_nodata_root);
            this.gNB = (SearchPageFocusBar) linearLayout.findViewById(d.g.no_data_focusbar);
            linearLayout.addView(this.mNoDataView, 0);
            this.gNA.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.26
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.gNA);
                    return false;
                }
            });
            this.gNj.addView(this.gNA, this.gNj.getChildCount());
        } else {
            this.gNj.addView(this.mNoDataView, 0);
        }
        this.gNk = (FrameLayout) findViewById(d.g.home_search_list);
        bBu();
        bBy();
        bBz();
        bBA();
        this.gNm = (BaseWebView) findViewById(d.g.search_result_webview);
        this.gNm.initCommonJsBridge(getPageContext().getPageActivity());
        this.gNm.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.27
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
                if (SquareSearchActivity.this.isProgressBarShown()) {
                    SquareSearchActivity.this.hideProgressBar();
                }
            }
        });
        this.gNm.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.28
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedError", 0, "", "requesturl", str2, "receiveerror", Integer.valueOf(i), "description", str);
            }
        });
        this.gNm.setOnReceivedSslErrorListener(new BaseWebView.g() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.g
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                if (sslError != null) {
                    com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedSslError", 0, "", "requesturl", sslError.getUrl(), "receiveerror", sslError.toString());
                }
            }
        });
        this.gNm.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.3
            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.mainentrance.SquareSearchActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return ba.adA().b(SquareSearchActivity.this.getPageContext(), new String[]{str}) != 3;
            }
        });
        this.eHM.setText("");
        this.eHM.requestFocus();
        ShowSoftKeyPadDelay(this.eHM, 200);
        bBB();
        bBC();
    }

    private void aBy() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.h.square_search_navigation_view, (View.OnClickListener) null);
        this.dpR = (ImageView) addCustomView.findViewById(d.g.search_bar_icon);
        this.eHM = (EditText) addCustomView.findViewById(d.g.home_et_search);
        this.eXd = (ImageView) addCustomView.findViewById(d.g.home_bt_search_del);
        this.gNl = (TextView) addCustomView.findViewById(d.g.home_bt_search_cancel_s);
        this.eHM.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    SquareSearchActivity.this.bBx();
                } else {
                    l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.eHM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.bBx();
            }
        });
        this.gNl.setText(getPageContext().getString(d.j.cancel));
        this.gNl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.eHM);
                com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SquareSearchActivity.this.finish();
                    }
                }, 200L);
            }
        });
        this.eHM.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.7
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (SquareSearchActivity.this.eWT == null || SquareSearchActivity.this.eWT.trim().length() < 1) {
                        l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.eHM);
                        if (SquareSearchActivity.this.bBv()) {
                            return true;
                        }
                        SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(d.j.write_keyword));
                        return true;
                    }
                    String trim = SquareSearchActivity.this.eHM.getText().toString().trim();
                    if (!StringUtils.isNull(trim)) {
                        SquareSearchActivity.this.ak(trim, false);
                        return true;
                    }
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(d.j.write_keyword));
                    return true;
                }
                return false;
            }
        });
        this.eXd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.eHM.setText("");
            }
        });
        this.eHM.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.9
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SquareSearchActivity.this.gNG) {
                    SquareSearchActivity.this.eWT = editable.toString();
                    if (StringUtils.isNull(SquareSearchActivity.this.eWT)) {
                        SquareSearchActivity.this.gNF = true;
                    }
                    SquareSearchActivity.this.bBF();
                }
                if (editable.toString().trim().length() == 0) {
                    SquareSearchActivity.this.eXd.setVisibility(8);
                } else {
                    SquareSearchActivity.this.eXd.setVisibility(0);
                }
                al.d(SquareSearchActivity.this.gNl, d.C0277d.cp_link_tip_a, 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBx() {
        if (StringUtils.isNull(this.eHM.getText().toString())) {
            if (this.gNn.getVisibility() != 0) {
                bBD();
            }
        } else if (this.gNs.getVisibility() != 0) {
            bBF();
        }
    }

    private void bBy() {
        this.gNn = (ScrollView) findViewById(d.g.search_history_scrollview);
        this.gNo = (LinearLayout) findViewById(d.g.search_history_linearlayout);
        if (this.gNr == null) {
            this.gNr = new LinearLayout(getPageContext().getPageActivity());
            this.gNr.setOrientation(1);
            this.gNr.setBackgroundColor(al.getColor(d.C0277d.cp_bg_line_d));
        }
        this.gNo.addView(this.gNr);
    }

    private void bBz() {
        if (this.gNq == null) {
            this.gNq = new g(getPageContext());
            this.gNo.addView(this.gNq.oM());
        }
    }

    private void bBA() {
        this.gNs = (BdListView) findViewById(d.g.home_lv_search_suggest);
        this.gNt = new com.baidu.tieba.mainentrance.a(this, null);
        this.gNu = new com.baidu.tieba.mainentrance.searchSuggestList.b(getPageContext().getPageActivity(), null);
        this.gNs.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.10
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ListAdapter adapter;
                ListView listView = (ListView) adapterView;
                if (listView != null && (adapter = listView.getAdapter()) != null && adapter.getCount() != 0 && i < adapter.getCount()) {
                    Object item = adapter.getItem(i);
                    if (item instanceof String) {
                        SquareSearchActivity.this.ak((String) item, true);
                        TiebaStatic.eventStat(SquareSearchActivity.this.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
                    }
                }
            }
        });
        this.gNs.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.11
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

    public void bBB() {
        this.gNl.setText(getPageContext().getString(d.j.cancel));
        bBC();
        bBw();
        bBG();
        if (this.eWT.trim().length() > 0) {
            bBF();
        } else {
            bBD();
        }
    }

    private void bBC() {
        if (this.mHotSearchInfo == null) {
            this.eHM.setHint(d.j.search_bar);
        } else {
            this.eHM.setHint(" " + UtilHelper.getFixedText(this.mHotSearchInfo.aWg(), 15));
        }
    }

    private void bBu() {
        HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
        if (hotSearchInfoData != null && hotSearchInfoData.getId() != 0) {
            this.mHotSearchInfo = hotSearchInfoData;
        }
    }

    private void bBD() {
        this.gNm.setVisibility(8);
        this.gNs.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009002));
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            mh(true);
            ce(this.gNB);
            ce(this.gNA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ag(ArrayList<String> arrayList) {
        NoDataViewFactory.d hT;
        if (ai(arrayList)) {
            bBK();
            if (j.kY()) {
                hT = NoDataViewFactory.d.hT(d.j.text_no_search_record);
            } else {
                hT = NoDataViewFactory.d.hT(d.j.neterror);
            }
            this.mNoDataView.setTextOption(hT);
            return;
        }
        bBJ();
        ah(arrayList);
        Q(true, arrayList == null || arrayList.size() == 0);
        bBC();
    }

    private void ah(final ArrayList<String> arrayList) {
        if (this.gNr != null) {
            this.gNr.removeAllViews();
            if (arrayList != null && !arrayList.isEmpty() && getActivity() != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                this.gNC = LayoutInflater.from(pageActivity).inflate(d.h.square_search_recommand_fourm_header, (ViewGroup) null);
                this.gNC.findViewById(d.g.titleTopDivider).setVisibility(8);
                getLayoutMode().onModeChanged(this.gNC);
                this.gNr.addView(this.gNC, layoutParams);
                int size = arrayList.size();
                this.gNE.clear();
                for (int i = 0; i < size; i++) {
                    final String str = arrayList.get(i);
                    if (!TextUtils.isEmpty(str)) {
                        final View inflate = LayoutInflater.from(pageActivity).inflate(d.h.home_dialog_search_item, (ViewGroup) null);
                        ((TextView) inflate.findViewById(d.g.home_lv_search_forum)).setText(str);
                        al.d((TextView) inflate.findViewById(d.g.home_lv_search_forum), d.C0277d.cp_cont_b, 1);
                        inflate.findViewById(d.g.home_dialog_lv_search_forum_divider).setVisibility(8);
                        al.k(inflate, d.f.square_search_item_bg);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        inflate.setOnClickListener(new b(str));
                        ImageView imageView = (ImageView) inflate.findViewById(d.g.del_search_history_btn);
                        al.c(imageView, d.f.icn_shop_order_close);
                        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                aa.a(new z<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // com.baidu.tbadk.util.z
                                    public Boolean doInBackground() {
                                        com.baidu.tieba.tbadkCore.util.a.CI(str);
                                        return true;
                                    }
                                }, new k<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.2
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.tbadk.util.k
                                    public void onReturnDataInUI(Boolean bool) {
                                        SquareSearchActivity.this.gNr.removeView(inflate);
                                        arrayList.remove(str);
                                        if (arrayList.size() <= 0) {
                                            SquareSearchActivity.this.ag(null);
                                        }
                                    }
                                });
                            }
                        });
                        this.gNE.add(inflate);
                        this.gNr.addView(inflate, layoutParams2);
                    }
                }
                this.gND = LayoutInflater.from(pageActivity).inflate(d.h.home_dialog_search_footer, (ViewGroup) null);
                ((TextView) this.gND.findViewById(d.g.home_bt_search_footer)).setTextColor(al.getColor(d.C0277d.cp_link_tip_a));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                this.gND.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SquareSearchActivity.this.bBE();
                    }
                });
                this.gNr.addView(this.gND, layoutParams3);
            }
        }
    }

    private void Q(boolean z, boolean z2) {
        if (this.gNq != null) {
            this.gNq.clear();
            if (this.gNp != null && !this.gNp.isEmpty() && z) {
                this.gNq.mg(!z2);
                this.gNq.setTitleText(this.mTopicInfoTitle);
                int size = this.gNp.size();
                if (size >= 1) {
                    if (size > 7) {
                        size = 7;
                    }
                    int i = size % 2 == 0 ? size - 1 : size;
                    for (int i2 = 0; i2 < i; i2++) {
                        c cVar = (c) v.c(this.gNp, i2);
                        if (cVar != null) {
                            this.gNq.a(cVar, i2).setOnClickListener(this.gNM);
                        }
                    }
                    this.gNq.a(null, i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.16
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.eHM);
                            if (!com.baidu.tbadk.plugins.b.f(SquareSearchActivity.this.getPageContext())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all")));
                            }
                        }
                    });
                    this.gNq.show();
                }
            }
        }
    }

    private boolean ai(ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && (this.gNp == null || this.gNp.size() <= 2) && this.gNy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBE() {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).lz(getPageContext().getString(d.j.alert_clean_history)).a(getPageContext().getString(d.j.clear_all_text), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                h.jI().d(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.cfh();
                    }
                });
                if (SquareSearchActivity.this.gNp == null || SquareSearchActivity.this.gNp.size() < 2) {
                    SquareSearchActivity.this.cd(SquareSearchActivity.this.gNA);
                    SquareSearchActivity.this.cd(SquareSearchActivity.this.gNB);
                    SquareSearchActivity.this.gNk.setVisibility(8);
                    SquareSearchActivity.this.mNoDataView.setVisibility(0);
                    SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.hT(d.j.text_no_search_record));
                    return;
                }
                SquareSearchActivity.this.ag(null);
            }
        }).b(getPageContext().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.17
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        }).b(getPageContext()).aaW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBF() {
        if (this.eWT.trim().length() > 0) {
            bBH();
            return;
        }
        bBw();
        bBD();
    }

    private void bBG() {
        if (this.gNs != null) {
            this.gNs.setNextPage(null);
        }
    }

    private void bBH() {
        if (!StringUtils.isNull(this.eWT)) {
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.eWT.trim();
            sendMessage(searchListNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        try {
            if (this.gNv != null) {
                if (this.gNv.forum_list != null && this.gNv.forum_list.size() > 0) {
                    bBI();
                    this.gNs.setAdapter((ListAdapter) this.gNt);
                    this.gNt.yh(this.eWT);
                    this.gNt.af(this.gNv.forum_list);
                    this.gNt.notifyDataSetInvalidated();
                } else {
                    ce(this.gNA);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBI() {
        this.gNk.setVisibility(0);
        this.gNs.setVisibility(0);
        this.gNn.setVisibility(8);
        this.gNm.setVisibility(8);
        ce(this.gNA);
        this.mNoDataView.setVisibility(8);
    }

    private void bBJ() {
        this.gNk.setVisibility(0);
        this.gNn.setVisibility(0);
        this.gNs.setVisibility(8);
        this.gNm.setVisibility(8);
        ce(this.gNA);
        this.mNoDataView.setVisibility(8);
    }

    private void bBK() {
        this.gNk.setVisibility(8);
        this.gNs.setVisibility(8);
        this.gNn.setVisibility(8);
        this.gNm.setVisibility(8);
        cd(this.gNA);
        this.mNoDataView.setVisibility(0);
        cd(this.gNB);
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void yi(String str) {
        this.gNy = true;
        this.gNp = new ArrayList();
        bBD();
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void a(List<com.baidu.tieba.mainentrance.b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str) {
        this.gNy = true;
        hideLoadingView(this.gNj);
        if (list2 == null) {
            this.gNp = new ArrayList();
        } else {
            this.gNp = list2;
        }
        if (!StringUtils.isNULL(str)) {
            this.mTopicInfoTitle = str;
        } else {
            this.mTopicInfoTitle = "";
        }
        a(hotSearchInfoData);
        this.mHotSearchInfo = hotSearchInfoData;
        bBD();
    }

    private void a(HotSearchInfoData hotSearchInfoData) {
        if (hotSearchInfoData != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
            return;
        }
        HotSearchInfoData hotSearchInfoData2 = new HotSearchInfoData();
        hotSearchInfoData2.setId(0L);
        hotSearchInfoData2.setName("");
        hotSearchInfoData2.yj("");
        hotSearchInfoData2.dr(0L);
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
        getLayoutMode().onModeChanged(this.gNi);
        al.g(this.gNi, i);
        if (this.gNt != null) {
            this.gNt.notifyDataSetChanged();
        }
        if (i == 2) {
            this.eHM.setHintTextColor(al.getColor(d.C0277d.s_navbar_title_color));
        } else {
            this.eHM.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
        }
        al.c(this.eXd, d.f.del_search_btn);
        al.c(this.eHM, d.C0277d.cp_cont_b, d.C0277d.s_navbar_title_color);
        al.a(this.dpR, d.f.icon_seach_n, d.f.icon_seach_n, d.f.icon_seach_n, i);
        al.k(this.gNj, d.C0277d.cp_bg_line_d);
        al.d(this.gNl, d.C0277d.cp_link_tip_a, 1);
        if (this.gNq != null) {
            this.gNq.onChangeSkinType(i);
        }
        vc(i);
    }

    private void vc(int i) {
        if (this.gNr != null) {
            this.gNr.setBackgroundColor(al.getColor(d.C0277d.cp_bg_line_d));
        }
        if (this.gNC != null) {
            getLayoutMode().onModeChanged(this.gNC);
        }
        if (this.gND != null) {
            ((TextView) this.gND.findViewById(d.g.home_bt_search_footer)).setTextColor(al.getColor(d.C0277d.cp_link_tip_a));
        }
        if (this.gNE != null) {
            for (View view : this.gNE) {
                al.d((TextView) view.findViewById(d.g.home_lv_search_forum), d.C0277d.cp_cont_b, 1);
                view.findViewById(d.g.home_dialog_lv_search_forum_divider).setBackgroundColor(al.getColor(d.C0277d.cp_bg_line_b));
                al.k(view, d.f.addresslist_item_bg);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (i == 4 && this.gNm.canGoBack()) {
                this.gNm.goBack();
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
            com.baidu.tbadk.core.e.b.o(getPageContext().getPageActivity(), 1);
        } else {
            com.baidu.tbadk.core.e.b.o(getPageContext().getPageActivity(), 2);
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
    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        private String mName;

        public b(String str) {
            this.mName = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(this.mName)) {
                SquareSearchActivity.this.eWT = this.mName;
                TiebaStatic.log(new am("c12034"));
                SquareSearchActivity.this.ak(this.mName, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bBL() {
        if (!j.kY()) {
            cd(this.mNoDataView);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.hT(d.j.neterror));
            return true;
        }
        ce(this.mNoDataView);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
        private BasicNameValuePair gNU;
        private x mNetwork = null;
        private String mUrl;

        public a(String str, BasicNameValuePair basicNameValuePair, boolean z) {
            this.mUrl = null;
            this.gNU = null;
            this.mUrl = str;
            this.gNU = basicNameValuePair;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!SquareSearchActivity.this.bBL()) {
                SquareSearchActivity.this.ce(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.gNj, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(d.e.ds320));
                SquareSearchActivity.this.gNk.setVisibility(8);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public ForumSuggestModel doInBackground(Object... objArr) {
            ForumSuggestModel forumSuggestModel = null;
            if (j.kY()) {
                try {
                    this.mNetwork = new x(this.mUrl);
                    this.mNetwork.a(this.gNU);
                    String acg = this.mNetwork.acg();
                    if (acg != null) {
                        forumSuggestModel = ForumSuggestModel.parserJson(acg);
                        SquareSearchActivity.this.gNx = this.gNU.getValue();
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
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.gNj);
            if (forumSuggestModel != null) {
                SquareSearchActivity.this.ce(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.gNv = forumSuggestModel;
                SquareSearchActivity.this.refresh();
            } else {
                SquareSearchActivity.this.cd(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.hT(d.j.text_no_search_record));
            }
            SquareSearchActivity.this.gNw = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.ji();
                this.mNetwork = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.gNj);
            super.cancel(true);
        }
    }

    private void mh(boolean z) {
        if (TbadkCoreApplication.isLogin()) {
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(2001323, true));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(2001323, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cd(View view) {
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ce(View view) {
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a026";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(final String str, boolean z) {
        if (!j.kY()) {
            showToast(d.j.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.gNG = false;
                this.eHM.setText(str);
                this.eHM.setSelection(str.length());
                this.gNG = true;
            }
            l.b(getPageContext().getPageActivity(), this.eHM);
            this.gNn.setVisibility(8);
            this.gNs.setVisibility(8);
            this.gNm.setVisibility(0);
            showProgressBarWithOffset(0, 0);
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            this.gNm.loadUrl(str2);
            aa.a(new z<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.z
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.CG(str);
                    return true;
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yk(String str) {
        if (!j.kY()) {
            showToast(d.j.neterror);
        } else if (!StringUtils.isNull(str)) {
            this.gNH = str;
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BIND_WIDGET)));
            } else {
                sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), str)));
            }
        }
    }
}
