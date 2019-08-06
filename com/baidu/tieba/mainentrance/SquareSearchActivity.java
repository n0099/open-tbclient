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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.util.z;
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
/* loaded from: classes6.dex */
public class SquareSearchActivity extends BaseActivity<SquareSearchActivity> implements HotForumModel.a {
    private ImageView dDZ;
    private ImageView evF;
    private TextView evG;
    private EditText fdy;
    private String fsx;
    private HotForumModel hlA;
    private LinearLayoutDetectsSoftKeyboard hlL;
    private FrameLayout hlM;
    private FrameLayout hlN;
    private BaseWebView hlO;
    private ScrollView hlP;
    private LinearLayout hlQ;
    private List<c> hlR;
    private g hlS;
    private LinearLayout hlT;
    private BdListView hlU;
    private com.baidu.tieba.mainentrance.a hlV;
    private com.baidu.tieba.mainentrance.searchSuggestList.b hlW;
    private ForumSuggestModel hlX;
    private a hlY;
    private String hlZ;
    private boolean hma;
    private ScrollView hmc;
    private SearchPageFocusBar hmd;
    private View hme;
    private View hmf;
    private String hmj;
    private HotSearchInfoData mHotSearchInfo;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mTopicInfoTitle;
    private boolean hmb = true;
    private List<View> hmg = new ArrayList();
    private boolean hly = false;
    private boolean hmh = true;
    private boolean hmi = true;
    private Runnable hmk = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.1
        @Override // java.lang.Runnable
        public void run() {
            SquareSearchActivity.this.fdy.requestFocus();
            l.c(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.fdy);
        }
    };
    private final Runnable hml = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.12
        @Override // java.lang.Runnable
        public void run() {
            if (!SquareSearchActivity.this.bMu()) {
                try {
                    if (SquareSearchActivity.this.fsx != null && SquareSearchActivity.this.fsx.length() > 0) {
                        StringBuffer stringBuffer = new StringBuffer(30);
                        stringBuffer.append(TbConfig.SERVER_ADDRESS);
                        stringBuffer.append("c/f/forum/search");
                        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", SquareSearchActivity.this.fsx.trim());
                        SquareSearchActivity.this.bMf();
                        SquareSearchActivity.this.hlY = new a(stringBuffer.toString(), basicNameValuePair, true);
                        SquareSearchActivity.this.hlY.setPriority(3);
                        SquareSearchActivity.this.hlY.execute(stringBuffer.toString(), basicNameValuePair);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a hmm = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SEARCH_LIST, 309438) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.22
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = ((responsedMessage instanceof SearchListHttpResMessage) || (responsedMessage instanceof SearchListSocketResMessage)) ? false : true;
            if (responsedMessage == null || z || responsedMessage.getError() != 0 || responsedMessage.hasError()) {
                if (j.kc() || !SquareSearchActivity.this.hly) {
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(R.string.neterror));
                }
                if (!j.kc()) {
                    SquareSearchActivity.this.hly = true;
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
            if (SquareSearchActivity.this.hmh && responsedMessage.getError() != 0) {
                SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(R.string.neterror));
                return;
            }
            if (list != null && list.size() > 0) {
                SquareSearchActivity.this.hmh = false;
            }
            SquareSearchActivity.this.bMr();
            SquareSearchActivity.this.hlU.setAdapter((ListAdapter) SquareSearchActivity.this.hlW);
            SquareSearchActivity.this.hlW.Al(SquareSearchActivity.this.fsx.trim());
            SquareSearchActivity.this.hlW.setData(list);
            SquareSearchActivity.this.hlW.notifyDataSetInvalidated();
        }
    };
    private CustomMessageListener hlD = new CustomMessageListener(2001608) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                SquareSearchActivity.this.Ao(customResponsedMessage.getData().toString());
            }
        }
    };
    private CustomMessageListener hmn = new CustomMessageListener(2009002) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof ArrayList) {
                    SquareSearchActivity.this.ak((ArrayList) data);
                }
            }
        }
    };
    private View.OnClickListener hmo = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.fdy);
            if (view.getTag() instanceof c) {
                c cVar = (c) view.getTag();
                TiebaStatic.log(new an("c10363").bT("obj_name", cVar.getName()));
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
                if (SquareSearchActivity.this.hlO.getUrl() != null && SquareSearchActivity.this.hlO.getUrl().contains(str)) {
                    SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.hlM);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bMe() {
        if (this.mHotSearchInfo == null) {
            return false;
        }
        if (this.mHotSearchInfo.bMc() == 0) {
            aq(this.mHotSearchInfo.getName(), false);
        } else if (this.mHotSearchInfo.bMc() == 1 && !com.baidu.tbadk.plugins.b.f(getPageContext())) {
            sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new an("c10355").bT("obj_name", this.mHotSearchInfo.getName()).P("obj_type", this.mHotSearchInfo.bMc() == 0 ? 2 : 1));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.home_dialog_search);
        init();
        getWindow().setSoftInputMode(1);
        registerListener(this.hmn);
        registerListener(this.hmm);
        registerListener(this.hlD);
        registerListener(this.htmlLoadMessageListener);
        if (SquareSearchActivityConfig.IS_SHOW_RECOMMEND_FORUM) {
            this.hlA = new HotForumModel(getPageContext(), this);
            this.hlA.bMa();
        }
        this.hma = false;
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
        hideLoadingView(this.hlM);
        this.mHandler.removeCallbacks(this.hmk);
        bMf();
    }

    public void bMf() {
        this.mHandler.removeCallbacks(this.hml);
        if (this.hlY != null) {
            this.hlY.cancel();
            this.hlY = null;
        }
    }

    private void init() {
        this.hlL = (LinearLayoutDetectsSoftKeyboard) findViewById(R.id.parent);
        this.hlL.setOnSoftKeyBoardShownListener(new LinearLayoutDetectsSoftKeyboard.a() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.24
            @Override // com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard.a
            public void nm(boolean z) {
                SquareSearchActivity.this.hmb = z;
            }
        });
        this.hlL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.25
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    SquareSearchActivity.this.hlL.setFocusable(true);
                    SquareSearchActivity.this.hlL.setFocusableInTouchMode(true);
                    if (SquareSearchActivity.this.fdy.hasFocus()) {
                        l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.fdy);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        aJt();
        this.hlM = (FrameLayout) findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), null, null);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            this.hmc = (ScrollView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.home_searchbar_nodataview, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) this.hmc.findViewById(R.id.focusbar_nodata_root);
            this.hmd = (SearchPageFocusBar) linearLayout.findViewById(R.id.no_data_focusbar);
            linearLayout.addView(this.mNoDataView, 0);
            this.hmc.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.26
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.hmc);
                    return false;
                }
            });
            this.hlM.addView(this.hmc, this.hlM.getChildCount());
        } else {
            this.hlM.addView(this.mNoDataView, 0);
        }
        this.hlN = (FrameLayout) findViewById(R.id.home_search_list);
        bMd();
        bMh();
        bMi();
        bMj();
        this.hlO = (BaseWebView) findViewById(R.id.search_result_webview);
        this.hlO.initCommonJsBridge(getPageContext().getPageActivity());
        this.hlO.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.27
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
                if (SquareSearchActivity.this.isProgressBarShown()) {
                    SquareSearchActivity.this.hideProgressBar();
                }
            }
        });
        this.hlO.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.28
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                com.baidu.tbadk.core.e.a.a("search", -1L, 0, "ReceivedError", 0, "", "requesturl", str2, "receiveerror", Integer.valueOf(i), "description", str);
            }
        });
        this.hlO.setOnReceivedSslErrorListener(new BaseWebView.g() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.g
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                if (sslError != null) {
                    com.baidu.tbadk.core.e.a.a("search", -1L, 0, "ReceivedSslError", 0, "", "requesturl", sslError.getUrl(), "receiveerror", sslError.toString());
                }
            }
        });
        this.hlO.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.3
            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.mainentrance.SquareSearchActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return bb.ajE().b(SquareSearchActivity.this.getPageContext(), new String[]{str}) != 3;
            }
        });
        this.fdy.setText("");
        this.fdy.requestFocus();
        ShowSoftKeyPadDelay(this.fdy, 200);
        bMk();
        bMl();
    }

    private void aJt() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.dDZ = (ImageView) addCustomView.findViewById(R.id.search_bar_icon);
        this.fdy = (EditText) addCustomView.findViewById(R.id.home_et_search);
        this.evF = (ImageView) addCustomView.findViewById(R.id.home_bt_search_del);
        this.evG = (TextView) addCustomView.findViewById(R.id.home_bt_search_cancel_s);
        this.fdy.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    SquareSearchActivity.this.bMg();
                } else {
                    l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.fdy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.bMg();
            }
        });
        this.evG.setText(getPageContext().getString(R.string.cancel));
        this.evG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.fdy);
                com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SquareSearchActivity.this.finish();
                    }
                }, 200L);
            }
        });
        this.fdy.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.7
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (SquareSearchActivity.this.fsx == null || SquareSearchActivity.this.fsx.trim().length() < 1) {
                        l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.fdy);
                        if (SquareSearchActivity.this.bMe()) {
                            return true;
                        }
                        SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(R.string.write_keyword));
                        return true;
                    }
                    String trim = SquareSearchActivity.this.fdy.getText().toString().trim();
                    if (!StringUtils.isNull(trim)) {
                        SquareSearchActivity.this.aq(trim, false);
                        return true;
                    }
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(R.string.write_keyword));
                    return true;
                }
                return false;
            }
        });
        this.evF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.fdy.setText("");
            }
        });
        this.fdy.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.9
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SquareSearchActivity.this.hmi) {
                    SquareSearchActivity.this.fsx = editable.toString();
                    if (StringUtils.isNull(SquareSearchActivity.this.fsx)) {
                        SquareSearchActivity.this.hmh = true;
                    }
                    SquareSearchActivity.this.bMo();
                }
                if (editable.toString().trim().length() == 0) {
                    SquareSearchActivity.this.evF.setVisibility(8);
                } else {
                    SquareSearchActivity.this.evF.setVisibility(0);
                }
                am.f(SquareSearchActivity.this.evG, R.color.cp_link_tip_a, 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMg() {
        if (StringUtils.isNull(this.fdy.getText().toString())) {
            if (this.hlP.getVisibility() != 0) {
                bMm();
            }
        } else if (this.hlU.getVisibility() != 0) {
            bMo();
        }
    }

    private void bMh() {
        this.hlP = (ScrollView) findViewById(R.id.search_history_scrollview);
        this.hlQ = (LinearLayout) findViewById(R.id.search_history_linearlayout);
        if (this.hlT == null) {
            this.hlT = new LinearLayout(getPageContext().getPageActivity());
            this.hlT.setOrientation(1);
            this.hlT.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
        }
        this.hlQ.addView(this.hlT);
    }

    private void bMi() {
        if (this.hlS == null) {
            this.hlS = new g(getPageContext());
            this.hlQ.addView(this.hlS.nZ());
        }
    }

    private void bMj() {
        this.hlU = (BdListView) findViewById(R.id.home_lv_search_suggest);
        this.hlV = new com.baidu.tieba.mainentrance.a(this, null);
        this.hlW = new com.baidu.tieba.mainentrance.searchSuggestList.b(getPageContext().getPageActivity(), null);
        this.hlU.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.10
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ListAdapter adapter;
                ListView listView = (ListView) adapterView;
                if (listView != null && (adapter = listView.getAdapter()) != null && adapter.getCount() != 0 && i < adapter.getCount()) {
                    Object item = adapter.getItem(i);
                    if (item instanceof String) {
                        SquareSearchActivity.this.aq((String) item, true);
                        TiebaStatic.eventStat(SquareSearchActivity.this.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
                    }
                }
            }
        });
        this.hlU.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.11
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

    public void bMk() {
        this.evG.setText(getPageContext().getString(R.string.cancel));
        bMl();
        bMf();
        bMp();
        if (this.fsx.trim().length() > 0) {
            bMo();
        } else {
            bMm();
        }
    }

    private void bMl() {
        if (this.mHotSearchInfo == null) {
            this.fdy.setHint(R.string.search_bar);
        } else {
            this.fdy.setHint(" " + UtilHelper.getFixedText(this.mHotSearchInfo.bfp(), 15));
        }
    }

    private void bMd() {
        HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.ahQ().getString("hot_search_info", ""), HotSearchInfoData.class);
        if (hotSearchInfoData != null && hotSearchInfoData.getId() != 0) {
            this.mHotSearchInfo = hotSearchInfoData;
        }
    }

    private void bMm() {
        this.hlO.setVisibility(8);
        this.hlU.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009002));
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            nl(true);
            cq(this.hmd);
            cq(this.hmc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(ArrayList<String> arrayList) {
        NoDataViewFactory.d iN;
        if (am(arrayList)) {
            bMt();
            if (j.kc()) {
                iN = NoDataViewFactory.d.iN(R.string.text_no_search_record);
            } else {
                iN = NoDataViewFactory.d.iN(R.string.neterror);
            }
            this.mNoDataView.setTextOption(iN);
            return;
        }
        bMs();
        al(arrayList);
        U(true, arrayList == null || arrayList.size() == 0);
        bMl();
    }

    private void al(final ArrayList<String> arrayList) {
        if (this.hlT != null) {
            this.hlT.removeAllViews();
            if (arrayList != null && !arrayList.isEmpty() && getActivity() != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                this.hme = LayoutInflater.from(pageActivity).inflate(R.layout.square_search_recommand_fourm_header, (ViewGroup) null);
                this.hme.findViewById(R.id.titleTopDivider).setVisibility(8);
                getLayoutMode().onModeChanged(this.hme);
                this.hlT.addView(this.hme, layoutParams);
                int size = arrayList.size();
                this.hmg.clear();
                for (int i = 0; i < size; i++) {
                    final String str = arrayList.get(i);
                    if (!TextUtils.isEmpty(str)) {
                        final View inflate = LayoutInflater.from(pageActivity).inflate(R.layout.home_dialog_search_item, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.home_lv_search_forum)).setText(str);
                        am.f((TextView) inflate.findViewById(R.id.home_lv_search_forum), R.color.cp_cont_b, 1);
                        inflate.findViewById(R.id.home_dialog_lv_search_forum_divider).setVisibility(8);
                        am.k(inflate, R.drawable.square_search_item_bg);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        inflate.setOnClickListener(new b(str));
                        ImageView imageView = (ImageView) inflate.findViewById(R.id.del_search_history_btn);
                        am.c(imageView, (int) R.drawable.icn_shop_order_close);
                        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                aa.a(new z<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // com.baidu.tbadk.util.z
                                    public Boolean doInBackground() {
                                        com.baidu.tieba.tbadkCore.util.a.EU(str);
                                        return true;
                                    }
                                }, new k<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.2
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.tbadk.util.k
                                    public void onReturnDataInUI(Boolean bool) {
                                        SquareSearchActivity.this.hlT.removeView(inflate);
                                        arrayList.remove(str);
                                        if (arrayList.size() <= 0) {
                                            SquareSearchActivity.this.ak(null);
                                        }
                                    }
                                });
                            }
                        });
                        this.hmg.add(inflate);
                        this.hlT.addView(inflate, layoutParams2);
                    }
                }
                this.hmf = LayoutInflater.from(pageActivity).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
                ((TextView) this.hmf.findViewById(R.id.home_bt_search_footer)).setTextColor(am.getColor(R.color.cp_link_tip_a));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                this.hmf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SquareSearchActivity.this.bMn();
                    }
                });
                this.hlT.addView(this.hmf, layoutParams3);
            }
        }
    }

    private void U(boolean z, boolean z2) {
        if (this.hlS != null) {
            this.hlS.clear();
            if (this.hlR != null && !this.hlR.isEmpty() && z) {
                this.hlS.nk(!z2);
                this.hlS.setTitleText(this.mTopicInfoTitle);
                int size = this.hlR.size();
                if (size >= 1) {
                    if (size > 7) {
                        size = 7;
                    }
                    int i = size % 2 == 0 ? size - 1 : size;
                    for (int i2 = 0; i2 < i; i2++) {
                        c cVar = (c) v.c(this.hlR, i2);
                        if (cVar != null) {
                            this.hlS.a(cVar, i2).setOnClickListener(this.hmo);
                        }
                    }
                    this.hlS.a(null, i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.16
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.fdy);
                            if (!com.baidu.tbadk.plugins.b.f(SquareSearchActivity.this.getPageContext())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all")));
                            }
                        }
                    });
                    this.hlS.show();
                }
            }
        }
    }

    private boolean am(ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && (this.hlR == null || this.hlR.size() <= 2) && this.hma;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMn() {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).mO(getPageContext().getString(R.string.alert_clean_history)).a(getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                h.iL().d(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.cqD();
                    }
                });
                if (SquareSearchActivity.this.hlR == null || SquareSearchActivity.this.hlR.size() < 2) {
                    SquareSearchActivity.this.cp(SquareSearchActivity.this.hmc);
                    SquareSearchActivity.this.cp(SquareSearchActivity.this.hmd);
                    SquareSearchActivity.this.hlN.setVisibility(8);
                    SquareSearchActivity.this.mNoDataView.setVisibility(0);
                    SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(R.string.text_no_search_record));
                    return;
                }
                SquareSearchActivity.this.ak(null);
            }
        }).b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.17
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        }).b(getPageContext()).agK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMo() {
        if (this.fsx.trim().length() > 0) {
            bMq();
            return;
        }
        bMf();
        bMm();
    }

    private void bMp() {
        if (this.hlU != null) {
            this.hlU.setNextPage(null);
        }
    }

    private void bMq() {
        if (!StringUtils.isNull(this.fsx)) {
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.fsx.trim();
            sendMessage(searchListNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        try {
            if (this.hlX != null) {
                if (this.hlX.forum_list != null && this.hlX.forum_list.size() > 0) {
                    bMr();
                    this.hlU.setAdapter((ListAdapter) this.hlV);
                    this.hlV.Al(this.fsx);
                    this.hlV.aj(this.hlX.forum_list);
                    this.hlV.notifyDataSetInvalidated();
                } else {
                    cq(this.hmc);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMr() {
        this.hlN.setVisibility(0);
        this.hlU.setVisibility(0);
        this.hlP.setVisibility(8);
        this.hlO.setVisibility(8);
        cq(this.hmc);
        this.mNoDataView.setVisibility(8);
    }

    private void bMs() {
        this.hlN.setVisibility(0);
        this.hlP.setVisibility(0);
        this.hlU.setVisibility(8);
        this.hlO.setVisibility(8);
        cq(this.hmc);
        this.mNoDataView.setVisibility(8);
    }

    private void bMt() {
        this.hlN.setVisibility(8);
        this.hlU.setVisibility(8);
        this.hlP.setVisibility(8);
        this.hlO.setVisibility(8);
        cp(this.hmc);
        this.mNoDataView.setVisibility(0);
        cp(this.hmd);
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void Am(String str) {
        this.hma = true;
        this.hlR = new ArrayList();
        bMm();
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void a(List<com.baidu.tieba.mainentrance.b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str) {
        this.hma = true;
        hideLoadingView(this.hlM);
        if (list2 == null) {
            this.hlR = new ArrayList();
        } else {
            this.hlR = list2;
        }
        if (!StringUtils.isNULL(str)) {
            this.mTopicInfoTitle = str;
        } else {
            this.mTopicInfoTitle = "";
        }
        a(hotSearchInfoData);
        this.mHotSearchInfo = hotSearchInfoData;
        bMm();
    }

    private void a(HotSearchInfoData hotSearchInfoData) {
        if (hotSearchInfoData != null) {
            com.baidu.tbadk.core.sharedPref.b.ahQ().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
            return;
        }
        HotSearchInfoData hotSearchInfoData2 = new HotSearchInfoData();
        hotSearchInfoData2.setId(0L);
        hotSearchInfoData2.setName("");
        hotSearchInfoData2.An("");
        hotSearchInfoData2.dY(0L);
        com.baidu.tbadk.core.sharedPref.b.ahQ().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData2));
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
        getLayoutMode().onModeChanged(this.hlL);
        am.g(this.hlL, i);
        if (this.hlV != null) {
            this.hlV.notifyDataSetChanged();
        }
        if (i == 2) {
            this.fdy.setHintTextColor(am.getColor(R.color.s_navbar_title_color));
        } else {
            this.fdy.setHintTextColor(am.getColor(R.color.cp_cont_e));
        }
        am.c(this.evF, (int) R.drawable.del_search_btn);
        am.e(this.fdy, R.color.cp_cont_b, R.color.s_navbar_title_color);
        am.a(this.dDZ, (int) R.drawable.icon_seach_n, (int) R.drawable.icon_seach_n, (int) R.drawable.icon_seach_n, i);
        am.k(this.hlM, R.color.cp_bg_line_d);
        am.f(this.evG, R.color.cp_link_tip_a, 1);
        if (this.hlS != null) {
            this.hlS.onChangeSkinType(i);
        }
        wO(i);
    }

    private void wO(int i) {
        if (this.hlT != null) {
            this.hlT.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
        }
        if (this.hme != null) {
            getLayoutMode().onModeChanged(this.hme);
        }
        if (this.hmf != null) {
            ((TextView) this.hmf.findViewById(R.id.home_bt_search_footer)).setTextColor(am.getColor(R.color.cp_link_tip_a));
        }
        if (this.hmg != null) {
            for (View view : this.hmg) {
                am.f((TextView) view.findViewById(R.id.home_lv_search_forum), R.color.cp_cont_b, 1);
                view.findViewById(R.id.home_dialog_lv_search_forum_divider).setBackgroundColor(am.getColor(R.color.cp_bg_line_b));
                am.k(view, R.drawable.addresslist_item_bg);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (i == 4 && this.hlO.canGoBack()) {
                this.hlO.goBack();
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
            com.baidu.tbadk.core.f.b.o(getPageContext().getPageActivity(), 1);
        } else {
            com.baidu.tbadk.core.f.b.o(getPageContext().getPageActivity(), 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        setSkinType(3);
        if (this.mNoDataView != null) {
            this.mNoDataView.akw();
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
                SquareSearchActivity.this.fsx = this.mName;
                TiebaStatic.log(new an("c12034"));
                SquareSearchActivity.this.aq(this.mName, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bMu() {
        if (!j.kc()) {
            cp(this.mNoDataView);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(R.string.neterror));
            return true;
        }
        cq(this.mNoDataView);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
        private BasicNameValuePair hmw;
        private x mNetwork = null;
        private String mUrl;

        public a(String str, BasicNameValuePair basicNameValuePair, boolean z) {
            this.mUrl = null;
            this.hmw = null;
            this.mUrl = str;
            this.hmw = basicNameValuePair;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!SquareSearchActivity.this.bMu()) {
                SquareSearchActivity.this.cq(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.hlM, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(R.dimen.ds320));
                SquareSearchActivity.this.hlN.setVisibility(8);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public ForumSuggestModel doInBackground(Object... objArr) {
            ForumSuggestModel forumSuggestModel = null;
            if (j.kc()) {
                try {
                    this.mNetwork = new x(this.mUrl);
                    this.mNetwork.a(this.hmw);
                    String aii = this.mNetwork.aii();
                    if (aii != null) {
                        forumSuggestModel = ForumSuggestModel.parserJson(aii);
                        SquareSearchActivity.this.hlZ = this.hmw.getValue();
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
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.hlM);
            if (forumSuggestModel != null) {
                SquareSearchActivity.this.cq(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.hlX = forumSuggestModel;
                SquareSearchActivity.this.refresh();
            } else {
                SquareSearchActivity.this.cp(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(R.string.text_no_search_record));
            }
            SquareSearchActivity.this.hlY = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.ik();
                this.mNetwork = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.hlM);
            super.cancel(true);
        }
    }

    private void nl(boolean z) {
        if (TbadkCoreApplication.isLogin()) {
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(2001323, true));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(2001323, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cp(View view) {
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cq(View view) {
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a026";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(final String str, boolean z) {
        if (!j.kc()) {
            showToast(R.string.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.hmi = false;
                this.fdy.setText(str);
                this.fdy.setSelection(str.length());
                this.hmi = true;
            }
            l.b(getPageContext().getPageActivity(), this.fdy);
            this.hlP.setVisibility(8);
            this.hlU.setVisibility(8);
            this.hlO.setVisibility(0);
            showProgressBarWithOffset(0, 0);
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            this.hlO.loadUrl(str2);
            aa.a(new z<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.z
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.ES(str);
                    return true;
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ao(String str) {
        if (!j.kc()) {
            showToast(R.string.neterror);
        } else if (!StringUtils.isNull(str)) {
            this.hmj = str;
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11013)));
            } else {
                sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), str)));
            }
        }
    }
}
