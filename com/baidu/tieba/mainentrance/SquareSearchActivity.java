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
import com.baidu.adp.lib.f.h;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.data.Config;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateBarGuideActivityConfig;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.message.RequestEnterForumDataMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
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
/* loaded from: classes24.dex */
public class SquareSearchActivity extends BaseActivity<SquareSearchActivity> implements HotForumModel.a {
    private ImageView eZs;
    private ImageView gNu;
    private EditText iFA;
    private String iQL;
    private TextView icu;
    private HotForumModel kZH;
    private LinearLayoutDetectsSoftKeyboard kZU;
    private FrameLayout kZV;
    private FrameLayout kZW;
    private BaseWebView kZX;
    private ScrollView kZY;
    private LinearLayout kZZ;
    private List<c> laa;
    private g lab;
    private LinearLayout lac;
    private BdListView lad;
    private com.baidu.tieba.mainentrance.a lae;
    private com.baidu.tieba.mainentrance.searchSuggestList.b laf;
    private ForumSuggestModel lag;
    private a lah;
    private String lai;
    private boolean laj;
    private ScrollView lal;
    private SearchPageFocusBar lam;
    private View lan;
    private View lao;
    private String las;
    private HotSearchInfoData mHotSearchInfo;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mTopicInfoTitle;
    private boolean lak = true;
    private List<View> lap = new ArrayList();
    private boolean kZF = false;
    private boolean laq = true;
    private boolean lar = true;
    private Runnable lau = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.1
        @Override // java.lang.Runnable
        public void run() {
            SquareSearchActivity.this.iFA.requestFocus();
            l.showSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.iFA);
        }
    };
    private final Runnable lav = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.12
        @Override // java.lang.Runnable
        public void run() {
            if (!SquareSearchActivity.this.dgk()) {
                try {
                    if (SquareSearchActivity.this.iQL != null && SquareSearchActivity.this.iQL.length() > 0) {
                        StringBuffer stringBuffer = new StringBuffer(30);
                        stringBuffer.append(TbConfig.SERVER_ADDRESS);
                        stringBuffer.append(Config.SUGGEST_BAR_ADDRESS);
                        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", SquareSearchActivity.this.iQL.trim());
                        SquareSearchActivity.this.dfU();
                        SquareSearchActivity.this.lah = new a(stringBuffer.toString(), basicNameValuePair, true);
                        SquareSearchActivity.this.lah.setPriority(3);
                        SquareSearchActivity.this.lah.execute(stringBuffer.toString(), basicNameValuePair);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a law = new com.baidu.adp.framework.listener.a(1003196, CmdConfigSocket.CMD_SEARCH_LIST) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.22
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = ((responsedMessage instanceof SearchListHttpResMessage) || (responsedMessage instanceof SearchListSocketResMessage)) ? false : true;
            if (responsedMessage == null || z || responsedMessage.getError() != 0 || responsedMessage.hasError()) {
                if (j.isNetWorkAvailable() || !SquareSearchActivity.this.kZF) {
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(R.string.neterror));
                }
                if (!j.isNetWorkAvailable()) {
                    SquareSearchActivity.this.kZF = true;
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
            if (SquareSearchActivity.this.laq && responsedMessage.getError() != 0) {
                SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(R.string.neterror));
                return;
            }
            if (list != null && list.size() > 0) {
                SquareSearchActivity.this.laq = false;
            }
            SquareSearchActivity.this.dgh();
            SquareSearchActivity.this.lad.setAdapter((ListAdapter) SquareSearchActivity.this.laf);
            SquareSearchActivity.this.laf.OB(SquareSearchActivity.this.iQL.trim());
            SquareSearchActivity.this.laf.setData(list);
            SquareSearchActivity.this.laf.notifyDataSetInvalidated();
        }
    };
    private CustomMessageListener kZK = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_CREATE_BAR) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                SquareSearchActivity.this.OE(customResponsedMessage.getData().toString());
            }
        }
    };
    private CustomMessageListener lax = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof ArrayList) {
                    SquareSearchActivity.this.aR((ArrayList) data);
                }
            }
        }
    };
    private View.OnClickListener lay = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.iFA);
            if (view.getTag() instanceof c) {
                c cVar = (c) view.getTag();
                TiebaStatic.log(new ar("c10363").dY("obj_name", cVar.getName()));
                if (!com.baidu.tbadk.plugins.b.k(SquareSearchActivity.this.getPageContext())) {
                    SquareSearchActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(SquareSearchActivity.this.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(cVar.getId()), cVar.getName(), "4")));
                }
            }
        }
    };
    CustomMessageListener htmlLoadMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_HTML_LOADED) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921023 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (SquareSearchActivity.this.kZX.getUrl() != null && SquareSearchActivity.this.kZX.getUrl().contains(str)) {
                    SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.kZV);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dfT() {
        if (this.mHotSearchInfo == null) {
            return false;
        }
        if (this.mHotSearchInfo.getType() == 0) {
            aU(this.mHotSearchInfo.getName(), false);
        } else if (this.mHotSearchInfo.getType() == 1 && !com.baidu.tbadk.plugins.b.k(getPageContext())) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new ar("c10355").dY("obj_name", this.mHotSearchInfo.getName()).al("obj_type", this.mHotSearchInfo.getType() == 0 ? 2 : 1));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.home_dialog_search);
        init();
        getWindow().setSoftInputMode(1);
        registerListener(this.lax);
        registerListener(this.law);
        registerListener(this.kZK);
        registerListener(this.htmlLoadMessageListener);
        if (SquareSearchActivityConfig.IS_SHOW_RECOMMEND_FORUM) {
            this.kZH = new HotForumModel(getPageContext(), this);
            this.kZH.dfQ();
        }
        this.laj = false;
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
        hideLoadingView(this.kZV);
        this.mHandler.removeCallbacks(this.lau);
        dfU();
    }

    public void dfU() {
        this.mHandler.removeCallbacks(this.lav);
        if (this.lah != null) {
            this.lah.cancel();
            this.lah = null;
        }
    }

    private void init() {
        this.kZU = (LinearLayoutDetectsSoftKeyboard) findViewById(R.id.parent);
        this.kZU.setOnSoftKeyBoardShownListener(new LinearLayoutDetectsSoftKeyboard.a() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.24
            @Override // com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard.a
            public void db(boolean z) {
                SquareSearchActivity.this.lak = z;
            }
        });
        this.kZU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.25
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    SquareSearchActivity.this.kZU.setFocusable(true);
                    SquareSearchActivity.this.kZU.setFocusableInTouchMode(true);
                    if (SquareSearchActivity.this.iFA.hasFocus()) {
                        l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.iFA);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        bFP();
        this.kZV = (FrameLayout) findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), null, null);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            this.lal = (ScrollView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.home_searchbar_nodataview, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) this.lal.findViewById(R.id.focusbar_nodata_root);
            this.lam = (SearchPageFocusBar) linearLayout.findViewById(R.id.no_data_focusbar);
            linearLayout.addView(this.mNoDataView, 0);
            this.lal.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.26
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.lal);
                    return false;
                }
            });
            this.kZV.addView(this.lal, this.kZV.getChildCount());
        } else {
            this.kZV.addView(this.mNoDataView, 0);
        }
        this.kZW = (FrameLayout) findViewById(R.id.home_search_list);
        dgb();
        dfW();
        dfX();
        dfY();
        this.kZX = (BaseWebView) findViewById(R.id.search_result_webview);
        this.kZX.initCommonJsBridge(getPageContext().getPageActivity());
        this.kZX.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.27
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
                if (SquareSearchActivity.this.isProgressBarShown()) {
                    SquareSearchActivity.this.hideProgressBar();
                }
            }
        });
        this.kZX.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.28
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedError", 0, "", "requesturl", str2, "receiveerror", Integer.valueOf(i), "description", str);
            }
        });
        this.kZX.setOnReceivedSslErrorListener(new BaseWebView.g() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.g
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                if (sslError != null) {
                    com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedSslError", 0, "", "requesturl", sslError.getUrl(), "receiveerror", sslError.toString());
                }
            }
        });
        this.kZX.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.3
            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.mainentrance.SquareSearchActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return bf.bua().a(SquareSearchActivity.this.getPageContext(), new String[]{str}) != 3;
            }
        });
        this.iFA.setText("");
        this.iFA.requestFocus();
        ShowSoftKeyPadDelay(this.iFA, 200);
        dfZ();
        dga();
    }

    private void bFP() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.gNu = (ImageView) addCustomView.findViewById(R.id.search_bar_icon);
        this.iFA = (EditText) addCustomView.findViewById(R.id.home_et_search);
        this.eZs = (ImageView) addCustomView.findViewById(R.id.home_bt_search_del);
        this.icu = (TextView) addCustomView.findViewById(R.id.home_bt_search_cancel_s);
        this.iFA.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    SquareSearchActivity.this.dfV();
                } else {
                    l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.iFA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.dfV();
            }
        });
        this.icu.setText(getPageContext().getString(R.string.cancel));
        this.icu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.iFA);
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SquareSearchActivity.this.finish();
                    }
                }, 200L);
            }
        });
        this.iFA.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.7
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (SquareSearchActivity.this.iQL == null || SquareSearchActivity.this.iQL.trim().length() < 1) {
                        l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.iFA);
                        if (SquareSearchActivity.this.dfT()) {
                            return true;
                        }
                        SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(R.string.write_keyword));
                        return true;
                    }
                    String trim = SquareSearchActivity.this.iFA.getText().toString().trim();
                    if (!StringUtils.isNull(trim)) {
                        SquareSearchActivity.this.aU(trim, false);
                        return true;
                    }
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(R.string.write_keyword));
                    return true;
                }
                return false;
            }
        });
        this.eZs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.iFA.setText("");
            }
        });
        this.iFA.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.9
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SquareSearchActivity.this.lar) {
                    SquareSearchActivity.this.iQL = editable.toString();
                    if (StringUtils.isNull(SquareSearchActivity.this.iQL)) {
                        SquareSearchActivity.this.laq = true;
                    }
                    SquareSearchActivity.this.dge();
                }
                if (editable.toString().trim().length() == 0) {
                    SquareSearchActivity.this.eZs.setVisibility(8);
                } else {
                    SquareSearchActivity.this.eZs.setVisibility(0);
                }
                ap.setViewTextColor(SquareSearchActivity.this.icu, R.color.CAM_X0302, 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfV() {
        if (StringUtils.isNull(this.iFA.getText().toString())) {
            if (this.kZY.getVisibility() != 0) {
                dgc();
            }
        } else if (this.lad.getVisibility() != 0) {
            dge();
        }
    }

    private void dfW() {
        this.kZY = (ScrollView) findViewById(R.id.search_history_scrollview);
        this.kZZ = (LinearLayout) findViewById(R.id.search_history_linearlayout);
        if (this.lac == null) {
            this.lac = new LinearLayout(getPageContext().getPageActivity());
            this.lac.setOrientation(1);
            this.lac.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
        }
        this.kZZ.addView(this.lac);
    }

    private void dfX() {
        if (this.lab == null) {
            this.lab = new g(getPageContext());
            this.kZZ.addView(this.lab.createView());
        }
    }

    private void dfY() {
        this.lad = (BdListView) findViewById(R.id.home_lv_search_suggest);
        this.lae = new com.baidu.tieba.mainentrance.a(this, null);
        this.laf = new com.baidu.tieba.mainentrance.searchSuggestList.b(getPageContext().getPageActivity(), null);
        this.lad.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.10
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ListAdapter adapter;
                ListView listView = (ListView) adapterView;
                if (listView != null && (adapter = listView.getAdapter()) != null && adapter.getCount() != 0 && i < adapter.getCount()) {
                    Object item = adapter.getItem(i);
                    if (item instanceof String) {
                        SquareSearchActivity.this.aU((String) item, true);
                        TiebaStatic.eventStat(SquareSearchActivity.this.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
                    }
                }
            }
        });
        this.lad.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.11
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), absListView);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    public void dfZ() {
        this.icu.setText(getPageContext().getString(R.string.cancel));
        dga();
        dfU();
        dgf();
        if (this.iQL.trim().length() > 0) {
            dge();
        } else {
            dgc();
        }
    }

    private void dga() {
        if (this.mHotSearchInfo == null) {
            this.iFA.setHint(R.string.search_bar);
        } else {
            this.iFA.setHint(" " + UtilHelper.getFixedText(this.mHotSearchInfo.cuS(), 15));
        }
    }

    private void dgb() {
        HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.bsO().getString(SharedPrefConfig.HOT_SEARCH_INFO, ""), HotSearchInfoData.class);
        if (hotSearchInfoData != null && hotSearchInfoData.getId() != 0) {
            this.mHotSearchInfo = hotSearchInfoData;
        }
    }

    private void dgc() {
        this.kZX.setVisibility(8);
        this.lad.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA));
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            tF(true);
            m39do(this.lam);
            m39do(this.lal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(ArrayList<String> arrayList) {
        NoDataViewFactory.d qP;
        if (aT(arrayList)) {
            dgj();
            if (j.isNetWorkAvailable()) {
                qP = NoDataViewFactory.d.qP(R.string.text_no_search_record);
            } else {
                qP = NoDataViewFactory.d.qP(R.string.neterror);
            }
            this.mNoDataView.setTextOption(qP);
            return;
        }
        dgi();
        aS(arrayList);
        ak(true, arrayList == null || arrayList.size() == 0);
        dga();
    }

    private void aS(final ArrayList<String> arrayList) {
        if (this.lac != null) {
            this.lac.removeAllViews();
            if (arrayList != null && !arrayList.isEmpty() && getActivity() != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                this.lan = LayoutInflater.from(pageActivity).inflate(R.layout.square_search_recommand_fourm_header, (ViewGroup) null);
                this.lan.findViewById(R.id.titleTopDivider).setVisibility(8);
                getLayoutMode().onModeChanged(this.lan);
                this.lac.addView(this.lan, layoutParams);
                int size = arrayList.size();
                this.lap.clear();
                for (int i = 0; i < size; i++) {
                    final String str = arrayList.get(i);
                    if (!TextUtils.isEmpty(str)) {
                        final View inflate = LayoutInflater.from(pageActivity).inflate(R.layout.home_dialog_search_item, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.home_lv_search_forum)).setText(str);
                        ap.setViewTextColor((TextView) inflate.findViewById(R.id.home_lv_search_forum), R.color.CAM_X0105, 1);
                        inflate.findViewById(R.id.home_dialog_lv_search_forum_divider).setVisibility(8);
                        ap.setBackgroundResource(inflate, R.drawable.square_search_item_bg);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        inflate.setOnClickListener(new b(str));
                        ImageView imageView = (ImageView) inflate.findViewById(R.id.del_search_history_btn);
                        ap.setImageResource(imageView, R.drawable.icn_shop_order_close);
                        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                ad.a(new ac<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // com.baidu.tbadk.util.ac
                                    public Boolean doInBackground() {
                                        com.baidu.tieba.tbadkCore.util.a.TX(str);
                                        return true;
                                    }
                                }, new m<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.2
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.tbadk.util.m
                                    public void onReturnDataInUI(Boolean bool) {
                                        SquareSearchActivity.this.lac.removeView(inflate);
                                        arrayList.remove(str);
                                        if (arrayList.size() <= 0) {
                                            SquareSearchActivity.this.aR(null);
                                        }
                                    }
                                });
                            }
                        });
                        this.lap.add(inflate);
                        this.lac.addView(inflate, layoutParams2);
                    }
                }
                this.lao = LayoutInflater.from(pageActivity).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
                ((TextView) this.lao.findViewById(R.id.home_bt_search_footer)).setTextColor(ap.getColor(R.color.CAM_X0302));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                this.lao.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SquareSearchActivity.this.dgd();
                    }
                });
                this.lac.addView(this.lao, layoutParams3);
            }
        }
    }

    private void ak(boolean z, boolean z2) {
        if (this.lab != null) {
            this.lab.clear();
            if (this.laa != null && !this.laa.isEmpty() && z) {
                this.lab.tE(!z2);
                this.lab.setTitleText(this.mTopicInfoTitle);
                int size = this.laa.size();
                if (size >= 1) {
                    if (size > 7) {
                        size = 7;
                    }
                    int i = size % 2 == 0 ? size - 1 : size;
                    for (int i2 = 0; i2 < i; i2++) {
                        c cVar = (c) y.getItem(this.laa, i2);
                        if (cVar != null) {
                            this.lab.a(cVar, i2).setOnClickListener(this.lay);
                        }
                    }
                    this.lab.a(null, i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.16
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.iFA);
                            if (!com.baidu.tbadk.plugins.b.k(SquareSearchActivity.this.getPageContext())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all")));
                            }
                        }
                    });
                    this.lab.show();
                }
            }
        }
    }

    private boolean aT(ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && (this.laa == null || this.laa.size() <= 2) && this.laj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgd() {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).Bq(getPageContext().getString(R.string.alert_clean_history)).a(getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                h.mZ().submitTask(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.dQi();
                    }
                });
                if (SquareSearchActivity.this.laa == null || SquareSearchActivity.this.laa.size() < 2) {
                    SquareSearchActivity.this.dn(SquareSearchActivity.this.lal);
                    SquareSearchActivity.this.dn(SquareSearchActivity.this.lam);
                    SquareSearchActivity.this.kZW.setVisibility(8);
                    SquareSearchActivity.this.mNoDataView.setVisibility(0);
                    SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.qP(R.string.text_no_search_record));
                    return;
                }
                SquareSearchActivity.this.aR(null);
            }
        }).b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.17
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        }).b(getPageContext()).brv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dge() {
        if (this.iQL.trim().length() > 0) {
            dgg();
            return;
        }
        dfU();
        dgc();
    }

    private void dgf() {
        if (this.lad != null) {
            this.lad.setNextPage(null);
        }
    }

    private void dgg() {
        if (!StringUtils.isNull(this.iQL)) {
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.iQL.trim();
            sendMessage(searchListNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        try {
            if (this.lag != null) {
                if (this.lag.forum_list != null && this.lag.forum_list.size() > 0) {
                    dgh();
                    this.lad.setAdapter((ListAdapter) this.lae);
                    this.lae.OB(this.iQL);
                    this.lae.aQ(this.lag.forum_list);
                    this.lae.notifyDataSetInvalidated();
                } else {
                    m39do(this.lal);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgh() {
        this.kZW.setVisibility(0);
        this.lad.setVisibility(0);
        this.kZY.setVisibility(8);
        this.kZX.setVisibility(8);
        m39do(this.lal);
        this.mNoDataView.setVisibility(8);
    }

    private void dgi() {
        this.kZW.setVisibility(0);
        this.kZY.setVisibility(0);
        this.lad.setVisibility(8);
        this.kZX.setVisibility(8);
        m39do(this.lal);
        this.mNoDataView.setVisibility(8);
    }

    private void dgj() {
        this.kZW.setVisibility(8);
        this.lad.setVisibility(8);
        this.kZY.setVisibility(8);
        this.kZX.setVisibility(8);
        dn(this.lal);
        this.mNoDataView.setVisibility(0);
        dn(this.lam);
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void OC(String str) {
        this.laj = true;
        this.laa = new ArrayList();
        dgc();
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void a(List<com.baidu.tieba.mainentrance.b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str) {
        this.laj = true;
        hideLoadingView(this.kZV);
        if (list2 == null) {
            this.laa = new ArrayList();
        } else {
            this.laa = list2;
        }
        if (!StringUtils.isNULL(str)) {
            this.mTopicInfoTitle = str;
        } else {
            this.mTopicInfoTitle = "";
        }
        a(hotSearchInfoData);
        this.mHotSearchInfo = hotSearchInfoData;
        dgc();
    }

    private void a(HotSearchInfoData hotSearchInfoData) {
        if (hotSearchInfoData != null) {
            com.baidu.tbadk.core.sharedPref.b.bsO().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData));
            return;
        }
        HotSearchInfoData hotSearchInfoData2 = new HotSearchInfoData();
        hotSearchInfoData2.setId(0L);
        hotSearchInfoData2.setName("");
        hotSearchInfoData2.OD("");
        hotSearchInfoData2.setType(0L);
        com.baidu.tbadk.core.sharedPref.b.bsO().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData2));
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
        getLayoutMode().onModeChanged(this.kZU);
        ap.setBgColor(this.kZU, i);
        if (this.lae != null) {
            this.lae.notifyDataSetChanged();
        }
        if (i == 2) {
            this.iFA.setHintTextColor(ap.getColor(R.color.s_navbar_title_color));
        } else {
            this.iFA.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        }
        SvgManager.btW().a(this.eZs, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setNavbarTitleColor(this.iFA, R.color.CAM_X0105, R.color.s_navbar_title_color);
        SvgManager.btW().a(this.gNu, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        ap.setBackgroundResource(this.kZV, R.color.CAM_X0201);
        ap.setViewTextColor(this.icu, R.color.CAM_X0302, 1);
        if (this.lab != null) {
            this.lab.onChangeSkinType(i);
        }
        FG(i);
    }

    private void FG(int i) {
        if (this.lac != null) {
            this.lac.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
        }
        if (this.lan != null) {
            getLayoutMode().onModeChanged(this.lan);
        }
        if (this.lao != null) {
            ((TextView) this.lao.findViewById(R.id.home_bt_search_footer)).setTextColor(ap.getColor(R.color.CAM_X0302));
        }
        if (this.lap != null) {
            for (View view : this.lap) {
                ap.setViewTextColor((TextView) view.findViewById(R.id.home_lv_search_forum), R.color.CAM_X0105, 1);
                view.findViewById(R.id.home_dialog_lv_search_forum_divider).setBackgroundColor(ap.getColor(R.color.CAM_X0204));
                ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (i == 4 && this.kZX.canGoBack()) {
                this.kZX.goBack();
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
            com.baidu.tbadk.core.e.b.A(getPageContext().getPageActivity(), 1);
        } else {
            com.baidu.tbadk.core.e.b.A(getPageContext().getPageActivity(), 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        setSkinType(3);
        if (this.mNoDataView != null) {
            this.mNoDataView.bvb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class b implements View.OnClickListener {
        private String mName;

        public b(String str) {
            this.mName = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(this.mName)) {
                SquareSearchActivity.this.iQL = this.mName;
                TiebaStatic.log(new ar("c12034"));
                SquareSearchActivity.this.aU(this.mName, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dgk() {
        if (!j.isNetWorkAvailable()) {
            dn(this.mNoDataView);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.qP(R.string.neterror));
            return true;
        }
        m39do(this.mNoDataView);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class a extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
        private BasicNameValuePair laG;
        private aa mNetwork = null;
        private String mUrl;

        public a(String str, BasicNameValuePair basicNameValuePair, boolean z) {
            this.mUrl = null;
            this.laG = null;
            this.mUrl = str;
            this.laG = basicNameValuePair;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!SquareSearchActivity.this.dgk()) {
                SquareSearchActivity.this.m39do(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.kZV, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(R.dimen.ds320));
                SquareSearchActivity.this.kZW.setVisibility(8);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public ForumSuggestModel doInBackground(Object... objArr) {
            ForumSuggestModel forumSuggestModel = null;
            if (j.isNetWorkAvailable()) {
                try {
                    this.mNetwork = new aa(this.mUrl);
                    this.mNetwork.addPostData(this.laG);
                    String postNetData = this.mNetwork.postNetData();
                    if (postNetData != null) {
                        forumSuggestModel = ForumSuggestModel.parserJson(postNetData);
                        SquareSearchActivity.this.lai = this.laG.getValue();
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
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.kZV);
            if (forumSuggestModel != null) {
                SquareSearchActivity.this.m39do(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.lag = forumSuggestModel;
                SquareSearchActivity.this.refresh();
            } else {
                SquareSearchActivity.this.dn(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.qP(R.string.text_no_search_record));
            }
            SquareSearchActivity.this.lah = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.kZV);
            super.cancel(true);
        }
    }

    private void tF(boolean z) {
        if (TbadkCoreApplication.isLogin()) {
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(CmdConfigCustom.CMD_REQUEST_ENTER_FORUM_MESSAGE, true));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(CmdConfigCustom.CMD_REQUEST_ENTER_FORUM_MESSAGE, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dn(View view) {
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public void m39do(View view) {
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SEARCH_RESULT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aU(final String str, boolean z) {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.lar = false;
                this.iFA.setText(str);
                this.iFA.setSelection(str.length());
                this.lar = true;
            }
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.iFA);
            this.kZY.setVisibility(8);
            this.lad.setVisibility(8);
            this.kZX.setVisibility(0);
            showProgressBarWithOffset(0, 0);
            String str2 = TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + TbConfig.SQUARE_SEARCH_PAGE + str;
            try {
                str2 = TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            this.kZX.loadUrl(str2);
            ad.a(new ac<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ac
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.TV(str);
                    return true;
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OE(String str) {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (!StringUtils.isNull(str)) {
            this.las = str;
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CREATE_BAR)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), str)));
            }
        }
    }
}
