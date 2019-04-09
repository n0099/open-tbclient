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
    private ImageView dpS;
    private EditText eHN;
    private String eWU;
    private ImageView eXe;
    private HotForumModel gMV;
    private ScrollView gNB;
    private SearchPageFocusBar gNC;
    private View gND;
    private View gNE;
    private String gNI;
    private LinearLayoutDetectsSoftKeyboard gNj;
    private FrameLayout gNk;
    private FrameLayout gNl;
    private TextView gNm;
    private BaseWebView gNn;
    private ScrollView gNo;
    private LinearLayout gNp;
    private List<c> gNq;
    private g gNr;
    private LinearLayout gNs;
    private BdListView gNt;
    private com.baidu.tieba.mainentrance.a gNu;
    private com.baidu.tieba.mainentrance.searchSuggestList.b gNv;
    private ForumSuggestModel gNw;
    private a gNx;
    private String gNy;
    private boolean gNz;
    private HotSearchInfoData mHotSearchInfo;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mTopicInfoTitle;
    private boolean gNA = true;
    private List<View> gNF = new ArrayList();
    private boolean gMW = false;
    private boolean gNG = true;
    private boolean gNH = true;
    private Runnable gNJ = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.1
        @Override // java.lang.Runnable
        public void run() {
            SquareSearchActivity.this.eHN.requestFocus();
            l.c(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.eHN);
        }
    };
    private final Runnable gNK = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.12
        @Override // java.lang.Runnable
        public void run() {
            if (!SquareSearchActivity.this.bBL()) {
                try {
                    if (SquareSearchActivity.this.eWU != null && SquareSearchActivity.this.eWU.length() > 0) {
                        StringBuffer stringBuffer = new StringBuffer(30);
                        stringBuffer.append(TbConfig.SERVER_ADDRESS);
                        stringBuffer.append("c/f/forum/search");
                        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", SquareSearchActivity.this.eWU.trim());
                        SquareSearchActivity.this.bBw();
                        SquareSearchActivity.this.gNx = new a(stringBuffer.toString(), basicNameValuePair, true);
                        SquareSearchActivity.this.gNx.setPriority(3);
                        SquareSearchActivity.this.gNx.execute(stringBuffer.toString(), basicNameValuePair);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a gNL = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SEARCH_LIST, 309438) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.22
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = ((responsedMessage instanceof SearchListHttpResMessage) || (responsedMessage instanceof SearchListSocketResMessage)) ? false : true;
            if (responsedMessage == null || z || responsedMessage.getError() != 0 || responsedMessage.hasError()) {
                if (j.kY() || !SquareSearchActivity.this.gMW) {
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(d.j.neterror));
                }
                if (!j.kY()) {
                    SquareSearchActivity.this.gMW = true;
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
            if (SquareSearchActivity.this.gNG && responsedMessage.getError() != 0) {
                SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(d.j.neterror));
                return;
            }
            if (list != null && list.size() > 0) {
                SquareSearchActivity.this.gNG = false;
            }
            SquareSearchActivity.this.bBI();
            SquareSearchActivity.this.gNt.setAdapter((ListAdapter) SquareSearchActivity.this.gNv);
            SquareSearchActivity.this.gNv.yh(SquareSearchActivity.this.eWU.trim());
            SquareSearchActivity.this.gNv.setData(list);
            SquareSearchActivity.this.gNv.notifyDataSetInvalidated();
        }
    };
    private CustomMessageListener gNa = new CustomMessageListener(2001608) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                SquareSearchActivity.this.yk(customResponsedMessage.getData().toString());
            }
        }
    };
    private CustomMessageListener gNM = new CustomMessageListener(2009002) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.13
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
    private View.OnClickListener gNN = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.eHN);
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
                if (SquareSearchActivity.this.gNn.getUrl() != null && SquareSearchActivity.this.gNn.getUrl().contains(str)) {
                    SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.gNk);
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
        registerListener(this.gNM);
        registerListener(this.gNL);
        registerListener(this.gNa);
        registerListener(this.htmlLoadMessageListener);
        if (SquareSearchActivityConfig.IS_SHOW_RECOMMEND_FORUM) {
            this.gMV = new HotForumModel(getPageContext(), this);
            this.gMV.bBr();
        }
        this.gNz = false;
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
        hideLoadingView(this.gNk);
        this.mHandler.removeCallbacks(this.gNJ);
        bBw();
    }

    public void bBw() {
        this.mHandler.removeCallbacks(this.gNK);
        if (this.gNx != null) {
            this.gNx.cancel();
            this.gNx = null;
        }
    }

    private void init() {
        this.gNj = (LinearLayoutDetectsSoftKeyboard) findViewById(d.g.parent);
        this.gNj.setOnSoftKeyBoardShownListener(new LinearLayoutDetectsSoftKeyboard.a() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.24
            @Override // com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard.a
            public void mi(boolean z) {
                SquareSearchActivity.this.gNA = z;
            }
        });
        this.gNj.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.25
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    SquareSearchActivity.this.gNj.setFocusable(true);
                    SquareSearchActivity.this.gNj.setFocusableInTouchMode(true);
                    if (SquareSearchActivity.this.eHN.hasFocus()) {
                        l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.eHN);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        aBy();
        this.gNk = (FrameLayout) findViewById(d.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds200)), null, null);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            this.gNB = (ScrollView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.h.home_searchbar_nodataview, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) this.gNB.findViewById(d.g.focusbar_nodata_root);
            this.gNC = (SearchPageFocusBar) linearLayout.findViewById(d.g.no_data_focusbar);
            linearLayout.addView(this.mNoDataView, 0);
            this.gNB.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.26
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.gNB);
                    return false;
                }
            });
            this.gNk.addView(this.gNB, this.gNk.getChildCount());
        } else {
            this.gNk.addView(this.mNoDataView, 0);
        }
        this.gNl = (FrameLayout) findViewById(d.g.home_search_list);
        bBu();
        bBy();
        bBz();
        bBA();
        this.gNn = (BaseWebView) findViewById(d.g.search_result_webview);
        this.gNn.initCommonJsBridge(getPageContext().getPageActivity());
        this.gNn.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.27
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
                if (SquareSearchActivity.this.isProgressBarShown()) {
                    SquareSearchActivity.this.hideProgressBar();
                }
            }
        });
        this.gNn.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.28
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedError", 0, "", "requesturl", str2, "receiveerror", Integer.valueOf(i), "description", str);
            }
        });
        this.gNn.setOnReceivedSslErrorListener(new BaseWebView.g() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.g
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                if (sslError != null) {
                    com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedSslError", 0, "", "requesturl", sslError.getUrl(), "receiveerror", sslError.toString());
                }
            }
        });
        this.gNn.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.3
            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.mainentrance.SquareSearchActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return ba.adA().b(SquareSearchActivity.this.getPageContext(), new String[]{str}) != 3;
            }
        });
        this.eHN.setText("");
        this.eHN.requestFocus();
        ShowSoftKeyPadDelay(this.eHN, 200);
        bBB();
        bBC();
    }

    private void aBy() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.h.square_search_navigation_view, (View.OnClickListener) null);
        this.dpS = (ImageView) addCustomView.findViewById(d.g.search_bar_icon);
        this.eHN = (EditText) addCustomView.findViewById(d.g.home_et_search);
        this.eXe = (ImageView) addCustomView.findViewById(d.g.home_bt_search_del);
        this.gNm = (TextView) addCustomView.findViewById(d.g.home_bt_search_cancel_s);
        this.eHN.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    SquareSearchActivity.this.bBx();
                } else {
                    l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.eHN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.bBx();
            }
        });
        this.gNm.setText(getPageContext().getString(d.j.cancel));
        this.gNm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.eHN);
                com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SquareSearchActivity.this.finish();
                    }
                }, 200L);
            }
        });
        this.eHN.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.7
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (SquareSearchActivity.this.eWU == null || SquareSearchActivity.this.eWU.trim().length() < 1) {
                        l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.eHN);
                        if (SquareSearchActivity.this.bBv()) {
                            return true;
                        }
                        SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(d.j.write_keyword));
                        return true;
                    }
                    String trim = SquareSearchActivity.this.eHN.getText().toString().trim();
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
        this.eXe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.eHN.setText("");
            }
        });
        this.eHN.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.9
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SquareSearchActivity.this.gNH) {
                    SquareSearchActivity.this.eWU = editable.toString();
                    if (StringUtils.isNull(SquareSearchActivity.this.eWU)) {
                        SquareSearchActivity.this.gNG = true;
                    }
                    SquareSearchActivity.this.bBF();
                }
                if (editable.toString().trim().length() == 0) {
                    SquareSearchActivity.this.eXe.setVisibility(8);
                } else {
                    SquareSearchActivity.this.eXe.setVisibility(0);
                }
                al.d(SquareSearchActivity.this.gNm, d.C0277d.cp_link_tip_a, 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBx() {
        if (StringUtils.isNull(this.eHN.getText().toString())) {
            if (this.gNo.getVisibility() != 0) {
                bBD();
            }
        } else if (this.gNt.getVisibility() != 0) {
            bBF();
        }
    }

    private void bBy() {
        this.gNo = (ScrollView) findViewById(d.g.search_history_scrollview);
        this.gNp = (LinearLayout) findViewById(d.g.search_history_linearlayout);
        if (this.gNs == null) {
            this.gNs = new LinearLayout(getPageContext().getPageActivity());
            this.gNs.setOrientation(1);
            this.gNs.setBackgroundColor(al.getColor(d.C0277d.cp_bg_line_d));
        }
        this.gNp.addView(this.gNs);
    }

    private void bBz() {
        if (this.gNr == null) {
            this.gNr = new g(getPageContext());
            this.gNp.addView(this.gNr.oM());
        }
    }

    private void bBA() {
        this.gNt = (BdListView) findViewById(d.g.home_lv_search_suggest);
        this.gNu = new com.baidu.tieba.mainentrance.a(this, null);
        this.gNv = new com.baidu.tieba.mainentrance.searchSuggestList.b(getPageContext().getPageActivity(), null);
        this.gNt.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.10
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
        this.gNt.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.11
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
        this.gNm.setText(getPageContext().getString(d.j.cancel));
        bBC();
        bBw();
        bBG();
        if (this.eWU.trim().length() > 0) {
            bBF();
        } else {
            bBD();
        }
    }

    private void bBC() {
        if (this.mHotSearchInfo == null) {
            this.eHN.setHint(d.j.search_bar);
        } else {
            this.eHN.setHint(" " + UtilHelper.getFixedText(this.mHotSearchInfo.aWg(), 15));
        }
    }

    private void bBu() {
        HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
        if (hotSearchInfoData != null && hotSearchInfoData.getId() != 0) {
            this.mHotSearchInfo = hotSearchInfoData;
        }
    }

    private void bBD() {
        this.gNn.setVisibility(8);
        this.gNt.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009002));
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            mh(true);
            ce(this.gNC);
            ce(this.gNB);
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
        if (this.gNs != null) {
            this.gNs.removeAllViews();
            if (arrayList != null && !arrayList.isEmpty() && getActivity() != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                this.gND = LayoutInflater.from(pageActivity).inflate(d.h.square_search_recommand_fourm_header, (ViewGroup) null);
                this.gND.findViewById(d.g.titleTopDivider).setVisibility(8);
                getLayoutMode().onModeChanged(this.gND);
                this.gNs.addView(this.gND, layoutParams);
                int size = arrayList.size();
                this.gNF.clear();
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
                                        SquareSearchActivity.this.gNs.removeView(inflate);
                                        arrayList.remove(str);
                                        if (arrayList.size() <= 0) {
                                            SquareSearchActivity.this.ag(null);
                                        }
                                    }
                                });
                            }
                        });
                        this.gNF.add(inflate);
                        this.gNs.addView(inflate, layoutParams2);
                    }
                }
                this.gNE = LayoutInflater.from(pageActivity).inflate(d.h.home_dialog_search_footer, (ViewGroup) null);
                ((TextView) this.gNE.findViewById(d.g.home_bt_search_footer)).setTextColor(al.getColor(d.C0277d.cp_link_tip_a));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                this.gNE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SquareSearchActivity.this.bBE();
                    }
                });
                this.gNs.addView(this.gNE, layoutParams3);
            }
        }
    }

    private void Q(boolean z, boolean z2) {
        if (this.gNr != null) {
            this.gNr.clear();
            if (this.gNq != null && !this.gNq.isEmpty() && z) {
                this.gNr.mg(!z2);
                this.gNr.setTitleText(this.mTopicInfoTitle);
                int size = this.gNq.size();
                if (size >= 1) {
                    if (size > 7) {
                        size = 7;
                    }
                    int i = size % 2 == 0 ? size - 1 : size;
                    for (int i2 = 0; i2 < i; i2++) {
                        c cVar = (c) v.c(this.gNq, i2);
                        if (cVar != null) {
                            this.gNr.a(cVar, i2).setOnClickListener(this.gNN);
                        }
                    }
                    this.gNr.a(null, i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.16
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.eHN);
                            if (!com.baidu.tbadk.plugins.b.f(SquareSearchActivity.this.getPageContext())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all")));
                            }
                        }
                    });
                    this.gNr.show();
                }
            }
        }
    }

    private boolean ai(ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && (this.gNq == null || this.gNq.size() <= 2) && this.gNz;
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
                if (SquareSearchActivity.this.gNq == null || SquareSearchActivity.this.gNq.size() < 2) {
                    SquareSearchActivity.this.cd(SquareSearchActivity.this.gNB);
                    SquareSearchActivity.this.cd(SquareSearchActivity.this.gNC);
                    SquareSearchActivity.this.gNl.setVisibility(8);
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
        if (this.eWU.trim().length() > 0) {
            bBH();
            return;
        }
        bBw();
        bBD();
    }

    private void bBG() {
        if (this.gNt != null) {
            this.gNt.setNextPage(null);
        }
    }

    private void bBH() {
        if (!StringUtils.isNull(this.eWU)) {
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.eWU.trim();
            sendMessage(searchListNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        try {
            if (this.gNw != null) {
                if (this.gNw.forum_list != null && this.gNw.forum_list.size() > 0) {
                    bBI();
                    this.gNt.setAdapter((ListAdapter) this.gNu);
                    this.gNu.yh(this.eWU);
                    this.gNu.af(this.gNw.forum_list);
                    this.gNu.notifyDataSetInvalidated();
                } else {
                    ce(this.gNB);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBI() {
        this.gNl.setVisibility(0);
        this.gNt.setVisibility(0);
        this.gNo.setVisibility(8);
        this.gNn.setVisibility(8);
        ce(this.gNB);
        this.mNoDataView.setVisibility(8);
    }

    private void bBJ() {
        this.gNl.setVisibility(0);
        this.gNo.setVisibility(0);
        this.gNt.setVisibility(8);
        this.gNn.setVisibility(8);
        ce(this.gNB);
        this.mNoDataView.setVisibility(8);
    }

    private void bBK() {
        this.gNl.setVisibility(8);
        this.gNt.setVisibility(8);
        this.gNo.setVisibility(8);
        this.gNn.setVisibility(8);
        cd(this.gNB);
        this.mNoDataView.setVisibility(0);
        cd(this.gNC);
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void yi(String str) {
        this.gNz = true;
        this.gNq = new ArrayList();
        bBD();
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void a(List<com.baidu.tieba.mainentrance.b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str) {
        this.gNz = true;
        hideLoadingView(this.gNk);
        if (list2 == null) {
            this.gNq = new ArrayList();
        } else {
            this.gNq = list2;
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
        getLayoutMode().onModeChanged(this.gNj);
        al.g(this.gNj, i);
        if (this.gNu != null) {
            this.gNu.notifyDataSetChanged();
        }
        if (i == 2) {
            this.eHN.setHintTextColor(al.getColor(d.C0277d.s_navbar_title_color));
        } else {
            this.eHN.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
        }
        al.c(this.eXe, d.f.del_search_btn);
        al.c(this.eHN, d.C0277d.cp_cont_b, d.C0277d.s_navbar_title_color);
        al.a(this.dpS, d.f.icon_seach_n, d.f.icon_seach_n, d.f.icon_seach_n, i);
        al.k(this.gNk, d.C0277d.cp_bg_line_d);
        al.d(this.gNm, d.C0277d.cp_link_tip_a, 1);
        if (this.gNr != null) {
            this.gNr.onChangeSkinType(i);
        }
        vc(i);
    }

    private void vc(int i) {
        if (this.gNs != null) {
            this.gNs.setBackgroundColor(al.getColor(d.C0277d.cp_bg_line_d));
        }
        if (this.gND != null) {
            getLayoutMode().onModeChanged(this.gND);
        }
        if (this.gNE != null) {
            ((TextView) this.gNE.findViewById(d.g.home_bt_search_footer)).setTextColor(al.getColor(d.C0277d.cp_link_tip_a));
        }
        if (this.gNF != null) {
            for (View view : this.gNF) {
                al.d((TextView) view.findViewById(d.g.home_lv_search_forum), d.C0277d.cp_cont_b, 1);
                view.findViewById(d.g.home_dialog_lv_search_forum_divider).setBackgroundColor(al.getColor(d.C0277d.cp_bg_line_b));
                al.k(view, d.f.addresslist_item_bg);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (i == 4 && this.gNn.canGoBack()) {
                this.gNn.goBack();
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
                SquareSearchActivity.this.eWU = this.mName;
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
        private BasicNameValuePair gNV;
        private x mNetwork = null;
        private String mUrl;

        public a(String str, BasicNameValuePair basicNameValuePair, boolean z) {
            this.mUrl = null;
            this.gNV = null;
            this.mUrl = str;
            this.gNV = basicNameValuePair;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!SquareSearchActivity.this.bBL()) {
                SquareSearchActivity.this.ce(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.gNk, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(d.e.ds320));
                SquareSearchActivity.this.gNl.setVisibility(8);
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
                    this.mNetwork.a(this.gNV);
                    String acg = this.mNetwork.acg();
                    if (acg != null) {
                        forumSuggestModel = ForumSuggestModel.parserJson(acg);
                        SquareSearchActivity.this.gNy = this.gNV.getValue();
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
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.gNk);
            if (forumSuggestModel != null) {
                SquareSearchActivity.this.ce(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.gNw = forumSuggestModel;
                SquareSearchActivity.this.refresh();
            } else {
                SquareSearchActivity.this.cd(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.hT(d.j.text_no_search_record));
            }
            SquareSearchActivity.this.gNx = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.ji();
                this.mNetwork = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.gNk);
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
                this.gNH = false;
                this.eHN.setText(str);
                this.eHN.setSelection(str.length());
                this.gNH = true;
            }
            l.b(getPageContext().getPageActivity(), this.eHN);
            this.gNo.setVisibility(8);
            this.gNt.setVisibility(8);
            this.gNn.setVisibility(0);
            showProgressBarWithOffset(0, 0);
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            this.gNn.loadUrl(str2);
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
            this.gNI = str;
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BIND_WIDGET)));
            } else {
                sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), str)));
            }
        }
    }
}
