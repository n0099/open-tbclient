package com.baidu.tieba.mainentrance;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
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
/* loaded from: classes3.dex */
public class SquareSearchActivity extends BaseActivity<SquareSearchActivity> implements HotForumModel.a {
    private ImageView bvG;
    private EditText cKK;
    private String cVN;
    private ImageView cVX;
    private HotForumModel eBX;
    private a eCA;
    private String eCB;
    private boolean eCC;
    private ScrollView eCE;
    private SearchPageFocusBar eCF;
    private View eCG;
    private View eCH;
    private String eCL;
    private LinearLayoutDetectsSoftKeyboard eCm;
    private FrameLayout eCn;
    private FrameLayout eCo;
    private TextView eCp;
    private BaseWebView eCq;
    private ScrollView eCr;
    private LinearLayout eCs;
    private List<c> eCt;
    private g eCu;
    private LinearLayout eCv;
    private BdListView eCw;
    private com.baidu.tieba.mainentrance.a eCx;
    private com.baidu.tieba.mainentrance.searchSuggestList.a eCy;
    private ForumSuggestModel eCz;
    private HotSearchInfoData mHotSearchInfo;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mTopicInfoTitle;
    private boolean eCD = true;
    private List<View> eCI = new ArrayList();
    private boolean eBY = false;
    private boolean eCJ = true;
    private boolean eCK = true;
    private Runnable eCM = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.1
        @Override // java.lang.Runnable
        public void run() {
            SquareSearchActivity.this.cKK.requestFocus();
            l.c(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.cKK);
        }
    };
    private final Runnable eCN = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.12
        @Override // java.lang.Runnable
        public void run() {
            if (!SquareSearchActivity.this.aMH()) {
                try {
                    if (SquareSearchActivity.this.cVN != null && SquareSearchActivity.this.cVN.length() > 0) {
                        StringBuffer stringBuffer = new StringBuffer(30);
                        stringBuffer.append(TbConfig.SERVER_ADDRESS);
                        stringBuffer.append("c/f/forum/search");
                        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", SquareSearchActivity.this.cVN.trim());
                        SquareSearchActivity.this.aMs();
                        SquareSearchActivity.this.eCA = new a(stringBuffer.toString(), basicNameValuePair, true);
                        SquareSearchActivity.this.eCA.setPriority(3);
                        SquareSearchActivity.this.eCA.execute(stringBuffer.toString(), basicNameValuePair);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a eCO = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SEARCH_LIST, 309438) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.22
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = ((responsedMessage instanceof SearchListHttpResMessage) || (responsedMessage instanceof SearchListSocketResMessage)) ? false : true;
            if (responsedMessage == null || z || responsedMessage.getError() != 0 || responsedMessage.hasError()) {
                if (j.gP() || !SquareSearchActivity.this.eBY) {
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(d.k.neterror));
                }
                if (!j.gP()) {
                    SquareSearchActivity.this.eBY = true;
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
            if (SquareSearchActivity.this.eCJ && responsedMessage.getError() != 0) {
                SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(d.k.neterror));
                return;
            }
            if (list != null && list.size() > 0) {
                SquareSearchActivity.this.eCJ = false;
            }
            SquareSearchActivity.this.aME();
            SquareSearchActivity.this.eCw.setAdapter((ListAdapter) SquareSearchActivity.this.eCy);
            SquareSearchActivity.this.eCy.oH(SquareSearchActivity.this.cVN.trim());
            SquareSearchActivity.this.eCy.setData(list);
            SquareSearchActivity.this.eCy.notifyDataSetInvalidated();
        }
    };
    private CustomMessageListener eCc = new CustomMessageListener(2001608) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                SquareSearchActivity.this.oK(customResponsedMessage.getData().toString());
            }
        }
    };
    private CustomMessageListener eCP = new CustomMessageListener(2009002) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof ArrayList) {
                    SquareSearchActivity.this.Z((ArrayList) data);
                }
            }
        }
    };
    private View.OnClickListener eCQ = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.cKK);
            if (view2.getTag() instanceof c) {
                c cVar = (c) view2.getTag();
                TiebaStatic.log(new al("c10363").ac("obj_name", cVar.getName()));
                if (!com.baidu.tbadk.plugins.b.e(SquareSearchActivity.this.getPageContext())) {
                    SquareSearchActivity.this.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(SquareSearchActivity.this.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(cVar.getId()), cVar.getName(), "")));
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
                if (SquareSearchActivity.this.eCq.getUrl() != null && SquareSearchActivity.this.eCq.getUrl().contains(str)) {
                    SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.eCn);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aMr() {
        if (this.mHotSearchInfo == null) {
            return false;
        }
        if (this.mHotSearchInfo.aMp() == 0) {
            H(this.mHotSearchInfo.getName(), false);
        } else if (this.mHotSearchInfo.aMp() == 1 && !com.baidu.tbadk.plugins.b.e(getPageContext())) {
            sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "")));
        }
        TiebaStatic.log(new al("c10355").ac("obj_name", this.mHotSearchInfo.getName()).r("obj_type", this.mHotSearchInfo.aMp() == 0 ? 2 : 1));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.home_dialog_search);
        init();
        getWindow().setSoftInputMode(1);
        registerListener(this.eCP);
        registerListener(this.eCO);
        registerListener(this.eCc);
        registerListener(this.htmlLoadMessageListener);
        if (SquareSearchActivityConfig.IS_SHOW_RECOMMEND_FORUM) {
            this.eBX = new HotForumModel(getPageContext(), this);
            this.eBX.aMn();
        }
        this.eCC = false;
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
        hideLoadingView(this.eCn);
        this.mHandler.removeCallbacks(this.eCM);
        aMs();
    }

    public void aMs() {
        this.mHandler.removeCallbacks(this.eCN);
        if (this.eCA != null) {
            this.eCA.cancel();
            this.eCA = null;
        }
    }

    private void init() {
        this.eCm = (LinearLayoutDetectsSoftKeyboard) findViewById(d.g.parent);
        this.eCm.setOnSoftKeyBoardShownListener(new LinearLayoutDetectsSoftKeyboard.a() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.24
            @Override // com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard.a
            public void ig(boolean z) {
                SquareSearchActivity.this.eCD = z;
            }
        });
        this.eCm.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.25
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    SquareSearchActivity.this.eCm.setFocusable(true);
                    SquareSearchActivity.this.eCm.setFocusableInTouchMode(true);
                    if (SquareSearchActivity.this.cKK.hasFocus()) {
                        l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.cKK);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        are();
        this.eCn = (FrameLayout) findViewById(d.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds200)), null, null);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            this.eCE = (ScrollView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.i.home_searchbar_nodataview, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) this.eCE.findViewById(d.g.focusbar_nodata_root);
            this.eCF = (SearchPageFocusBar) linearLayout.findViewById(d.g.no_data_focusbar);
            linearLayout.addView(this.mNoDataView, 0);
            this.eCE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.26
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.eCE);
                    return false;
                }
            });
            this.eCn.addView(this.eCE, this.eCn.getChildCount());
        } else {
            this.eCn.addView(this.mNoDataView, 0);
        }
        this.eCo = (FrameLayout) findViewById(d.g.home_search_list);
        aMq();
        aMu();
        aMv();
        aMw();
        this.eCq = (BaseWebView) findViewById(d.g.search_result_webview);
        this.eCq.initCommonJsBridge(getPageContext().getPageActivity());
        this.eCq.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.27
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
                if (SquareSearchActivity.this.isProgressBarShown()) {
                    SquareSearchActivity.this.hideProgressBar();
                }
            }
        });
        this.eCq.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.28
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedError", 0, "", "requesturl", str2, "receiveerror", Integer.valueOf(i), "description", str);
            }
        });
        this.eCq.setOnReceivedSslErrorListener(new BaseWebView.g() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.g
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                if (sslError != null) {
                    com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedSslError", 0, "", "requesturl", sslError.getUrl(), "receiveerror", sslError.toString());
                }
            }
        });
        this.eCq.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.3
            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.mainentrance.SquareSearchActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return ax.wg().b(SquareSearchActivity.this.getPageContext(), new String[]{str}) != 3;
            }
        });
        this.cKK.setText("");
        this.cKK.requestFocus();
        ShowSoftKeyPadDelay(this.cKK, 200);
        aMx();
        aMy();
    }

    private void are() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.i.square_search_navigation_view, (View.OnClickListener) null);
        this.bvG = (ImageView) addCustomView.findViewById(d.g.search_bar_icon);
        this.cKK = (EditText) addCustomView.findViewById(d.g.home_et_search);
        this.cVX = (ImageView) addCustomView.findViewById(d.g.home_bt_search_del);
        this.eCp = (TextView) addCustomView.findViewById(d.g.home_bt_search_cancel_s);
        this.cKK.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (z) {
                    SquareSearchActivity.this.aMt();
                } else {
                    l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), view2);
                }
            }
        });
        this.cKK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                SquareSearchActivity.this.aMt();
            }
        });
        this.eCp.setText(getPageContext().getString(d.k.cancel));
        this.eCp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.cKK);
                com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SquareSearchActivity.this.finish();
                    }
                }, 200L);
            }
        });
        this.cKK.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.7
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (SquareSearchActivity.this.cVN == null || SquareSearchActivity.this.cVN.trim().length() < 1) {
                        l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.cKK);
                        if (SquareSearchActivity.this.aMr()) {
                            return true;
                        }
                        SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(d.k.write_keyword));
                        return true;
                    }
                    String trim = SquareSearchActivity.this.cKK.getText().toString().trim();
                    if (!StringUtils.isNull(trim)) {
                        SquareSearchActivity.this.H(trim, false);
                        return true;
                    }
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(d.k.write_keyword));
                    return true;
                }
                return false;
            }
        });
        this.cVX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                SquareSearchActivity.this.cKK.setText("");
            }
        });
        this.cKK.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.9
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SquareSearchActivity.this.eCK) {
                    SquareSearchActivity.this.cVN = editable.toString();
                    if (StringUtils.isNull(SquareSearchActivity.this.cVN)) {
                        SquareSearchActivity.this.eCJ = true;
                    }
                    SquareSearchActivity.this.aMB();
                }
                if (editable.toString().trim().length() == 0) {
                    SquareSearchActivity.this.cVX.setVisibility(8);
                } else {
                    SquareSearchActivity.this.cVX.setVisibility(0);
                }
                ak.c(SquareSearchActivity.this.eCp, d.C0126d.cp_link_tip_a, 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMt() {
        if (StringUtils.isNull(this.cKK.getText().toString())) {
            if (this.eCr.getVisibility() != 0) {
                aMz();
            }
        } else if (this.eCw.getVisibility() != 0) {
            aMB();
        }
    }

    private void aMu() {
        this.eCr = (ScrollView) findViewById(d.g.search_history_scrollview);
        this.eCs = (LinearLayout) findViewById(d.g.search_history_linearlayout);
        if (this.eCv == null) {
            this.eCv = new LinearLayout(getPageContext().getPageActivity());
            this.eCv.setOrientation(1);
            this.eCv.setBackgroundColor(ak.getColor(d.C0126d.cp_bg_line_d));
        }
        this.eCs.addView(this.eCv);
    }

    private void aMv() {
        if (this.eCu == null) {
            this.eCu = new g(getPageContext());
            this.eCs.addView(this.eCu.kA());
        }
    }

    private void aMw() {
        this.eCw = (BdListView) findViewById(d.g.home_lv_search_suggest);
        this.eCx = new com.baidu.tieba.mainentrance.a(this, null);
        this.eCy = new com.baidu.tieba.mainentrance.searchSuggestList.a(getPageContext().getPageActivity(), null);
        this.eCw.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.10
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                ListAdapter adapter;
                ListView listView = (ListView) adapterView;
                if (listView != null && (adapter = listView.getAdapter()) != null && adapter.getCount() != 0 && i < adapter.getCount()) {
                    Object item = adapter.getItem(i);
                    if (item instanceof String) {
                        SquareSearchActivity.this.H((String) item, true);
                        TiebaStatic.eventStat(SquareSearchActivity.this.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
                    }
                }
            }
        });
        this.eCw.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.11
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

    public void aMx() {
        this.eCp.setText(getPageContext().getString(d.k.cancel));
        aMy();
        aMs();
        aMC();
        if (this.cVN.trim().length() > 0) {
            aMB();
        } else {
            aMz();
        }
    }

    private void aMy() {
        if (this.mHotSearchInfo == null) {
            this.cKK.setHint(d.k.search_bar);
        } else {
            this.cKK.setHint(" " + UtilHelper.getFixedText(this.mHotSearchInfo.akw(), 15));
        }
    }

    private void aMq() {
        HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
        if (hotSearchInfoData != null && hotSearchInfoData.getId() != 0) {
            this.mHotSearchInfo = hotSearchInfoData;
        }
    }

    private void aMz() {
        this.eCq.setVisibility(8);
        this.eCw.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009002));
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            m18if(true);
            aP(this.eCF);
            aP(this.eCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(ArrayList<String> arrayList) {
        NoDataViewFactory.d m16do;
        if (ab(arrayList)) {
            aMG();
            if (j.gP()) {
                m16do = NoDataViewFactory.d.m16do(d.k.text_no_search_record);
            } else {
                m16do = NoDataViewFactory.d.m16do(d.k.neterror);
            }
            this.mNoDataView.setTextOption(m16do);
            return;
        }
        aMF();
        aa(arrayList);
        D(true, arrayList == null || arrayList.size() == 0);
        aMy();
    }

    private void aa(final ArrayList<String> arrayList) {
        if (this.eCv != null) {
            this.eCv.removeAllViews();
            if (arrayList != null && !arrayList.isEmpty() && getActivity() != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                this.eCG = LayoutInflater.from(pageActivity).inflate(d.i.square_search_recommand_fourm_header, (ViewGroup) null);
                this.eCG.findViewById(d.g.titleTopDivider).setVisibility(8);
                getLayoutMode().u(this.eCG);
                this.eCv.addView(this.eCG, layoutParams);
                int size = arrayList.size();
                this.eCI.clear();
                for (int i = 0; i < size; i++) {
                    final String str = arrayList.get(i);
                    if (!TextUtils.isEmpty(str)) {
                        final View inflate = LayoutInflater.from(pageActivity).inflate(d.i.home_dialog_search_item, (ViewGroup) null);
                        ((TextView) inflate.findViewById(d.g.home_lv_search_forum)).setText(str);
                        ak.c((TextView) inflate.findViewById(d.g.home_lv_search_forum), d.C0126d.cp_cont_b, 1);
                        inflate.findViewById(d.g.home_dialog_lv_search_forum_divider).setVisibility(8);
                        ak.i(inflate, d.f.square_search_item_bg);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        inflate.setOnClickListener(new b(str));
                        ImageView imageView = (ImageView) inflate.findViewById(d.g.del_search_history_btn);
                        ak.c(imageView, d.f.icn_shop_order_close);
                        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                v.a(new u<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // com.baidu.tbadk.util.u
                                    public Boolean doInBackground() {
                                        com.baidu.tieba.tbadkCore.util.a.sZ(str);
                                        return true;
                                    }
                                }, new h<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.2
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.tbadk.util.h
                                    public void onReturnDataInUI(Boolean bool) {
                                        SquareSearchActivity.this.eCv.removeView(inflate);
                                        arrayList.remove(str);
                                        if (arrayList.size() <= 0) {
                                            SquareSearchActivity.this.Z(null);
                                        }
                                    }
                                });
                            }
                        });
                        this.eCI.add(inflate);
                        this.eCv.addView(inflate, layoutParams2);
                    }
                }
                this.eCH = LayoutInflater.from(pageActivity).inflate(d.i.home_dialog_search_footer, (ViewGroup) null);
                ((TextView) this.eCH.findViewById(d.g.home_bt_search_footer)).setTextColor(ak.getColor(d.C0126d.cp_link_tip_a));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                this.eCH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        SquareSearchActivity.this.aMA();
                    }
                });
                this.eCv.addView(this.eCH, layoutParams3);
            }
        }
    }

    private void D(boolean z, boolean z2) {
        if (this.eCu != null) {
            this.eCu.clear();
            if (this.eCt != null && !this.eCt.isEmpty() && z) {
                this.eCu.ie(!z2);
                this.eCu.setTitleText(this.mTopicInfoTitle);
                int size = this.eCt.size();
                if (size >= 1) {
                    if (size > 7) {
                        size = 7;
                    }
                    int i = size % 2 == 0 ? size - 1 : size;
                    for (int i2 = 0; i2 < i; i2++) {
                        c cVar = (c) com.baidu.tbadk.core.util.v.c(this.eCt, i2);
                        if (cVar != null) {
                            this.eCu.a(cVar, i2).setOnClickListener(this.eCQ);
                        }
                    }
                    this.eCu.a(null, i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.16
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.cKK);
                            if (!com.baidu.tbadk.plugins.b.e(SquareSearchActivity.this.getPageContext())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(view2.getContext()).createNormalConfig("hotforum", "all")));
                            }
                        }
                    });
                    this.eCu.show();
                }
            }
        }
    }

    private boolean ab(ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && (this.eCt == null || this.eCt.size() <= 2) && this.eCC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMA() {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).dc(getPageContext().getString(d.k.alert_clean_history)).a(getPageContext().getString(d.k.clear_all_text), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                com.baidu.adp.lib.g.h.fx().d(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.bsP();
                    }
                });
                if (SquareSearchActivity.this.eCt == null || SquareSearchActivity.this.eCt.size() < 2) {
                    SquareSearchActivity.this.aO(SquareSearchActivity.this.eCE);
                    SquareSearchActivity.this.aO(SquareSearchActivity.this.eCF);
                    SquareSearchActivity.this.eCo.setVisibility(8);
                    SquareSearchActivity.this.mNoDataView.setVisibility(0);
                    SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.m16do(d.k.text_no_search_record));
                    return;
                }
                SquareSearchActivity.this.Z(null);
            }
        }).b(getPageContext().getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.17
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        }).b(getPageContext()).tD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMB() {
        if (this.cVN.trim().length() > 0) {
            aMD();
            return;
        }
        aMs();
        aMz();
    }

    private void aMC() {
        if (this.eCw != null) {
            this.eCw.setNextPage(null);
        }
    }

    private void aMD() {
        if (!StringUtils.isNull(this.cVN)) {
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.cVN.trim();
            sendMessage(searchListNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        try {
            if (this.eCz != null) {
                if (this.eCz.forum_list != null && this.eCz.forum_list.size() > 0) {
                    aME();
                    this.eCw.setAdapter((ListAdapter) this.eCx);
                    this.eCx.oH(this.cVN);
                    this.eCx.Y(this.eCz.forum_list);
                    this.eCx.notifyDataSetInvalidated();
                } else {
                    aP(this.eCE);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aME() {
        this.eCo.setVisibility(0);
        this.eCw.setVisibility(0);
        this.eCr.setVisibility(8);
        this.eCq.setVisibility(8);
        aP(this.eCE);
        this.mNoDataView.setVisibility(8);
    }

    private void aMF() {
        this.eCo.setVisibility(0);
        this.eCr.setVisibility(0);
        this.eCw.setVisibility(8);
        this.eCq.setVisibility(8);
        aP(this.eCE);
        this.mNoDataView.setVisibility(8);
    }

    private void aMG() {
        this.eCo.setVisibility(8);
        this.eCw.setVisibility(8);
        this.eCr.setVisibility(8);
        this.eCq.setVisibility(8);
        aO(this.eCE);
        this.mNoDataView.setVisibility(0);
        aO(this.eCF);
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void oI(String str) {
        this.eCC = true;
        this.eCt = new ArrayList();
        aMz();
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void a(List<com.baidu.tieba.mainentrance.b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str) {
        this.eCC = true;
        hideLoadingView(this.eCn);
        if (list2 == null) {
            this.eCt = new ArrayList();
        } else {
            this.eCt = list2;
        }
        if (!StringUtils.isNULL(str)) {
            this.mTopicInfoTitle = str;
        } else {
            this.mTopicInfoTitle = "";
        }
        a(hotSearchInfoData);
        this.mHotSearchInfo = hotSearchInfoData;
        aMz();
    }

    private void a(HotSearchInfoData hotSearchInfoData) {
        if (hotSearchInfoData != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
            return;
        }
        HotSearchInfoData hotSearchInfoData2 = new HotSearchInfoData();
        hotSearchInfoData2.setId(0L);
        hotSearchInfoData2.setName("");
        hotSearchInfoData2.oJ("");
        hotSearchInfoData2.cn(0L);
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
        getLayoutMode().u(this.eCm);
        ak.e(this.eCm, i);
        if (this.eCx != null) {
            this.eCx.notifyDataSetChanged();
        }
        if (i == 2) {
            this.cKK.setHintTextColor(ak.getColor(d.C0126d.s_navbar_title_color));
        } else {
            this.cKK.setHintTextColor(ak.getColor(d.C0126d.cp_cont_e));
        }
        ak.c(this.cVX, d.f.del_search_btn);
        ak.b(this.cKK, d.C0126d.cp_cont_b, d.C0126d.s_navbar_title_color);
        ak.a(this.bvG, d.f.icon_seach_n, d.f.icon_seach_n, d.f.icon_seach_n, i);
        ak.i(this.eCn, d.C0126d.cp_bg_line_d);
        ak.c(this.eCp, d.C0126d.cp_link_tip_a, 1);
        if (this.eCu != null) {
            this.eCu.onChangeSkinType(i);
        }
        oM(i);
    }

    private void oM(int i) {
        if (this.eCv != null) {
            this.eCv.setBackgroundColor(ak.getColor(d.C0126d.cp_bg_line_d));
        }
        if (this.eCG != null) {
            getLayoutMode().u(this.eCG);
        }
        if (this.eCH != null) {
            ((TextView) this.eCH.findViewById(d.g.home_bt_search_footer)).setTextColor(ak.getColor(d.C0126d.cp_link_tip_a));
        }
        if (this.eCI != null) {
            for (View view2 : this.eCI) {
                ak.c((TextView) view2.findViewById(d.g.home_lv_search_forum), d.C0126d.cp_cont_b, 1);
                view2.findViewById(d.g.home_dialog_lv_search_forum_divider).setBackgroundColor(ak.getColor(d.C0126d.cp_bg_line_b));
                ak.i(view2, d.f.addresslist_item_bg);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (i == 4 && this.eCq.canGoBack()) {
                this.eCq.goBack();
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
            com.baidu.tbadk.core.e.b.g(getPageContext().getPageActivity(), 1);
        } else {
            com.baidu.tbadk.core.e.b.g(getPageContext().getPageActivity(), 2);
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
        public void onClick(View view2) {
            if (!TextUtils.isEmpty(this.mName)) {
                SquareSearchActivity.this.cVN = this.mName;
                TiebaStatic.log(new al("c12034"));
                SquareSearchActivity.this.H(this.mName, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aMH() {
        if (!j.gP()) {
            aO(this.mNoDataView);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.m16do(d.k.neterror));
            return true;
        }
        aP(this.mNoDataView);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
        private BasicNameValuePair eCY;
        private x mNetwork = null;
        private String mUrl;

        public a(String str, BasicNameValuePair basicNameValuePair, boolean z) {
            this.mUrl = null;
            this.eCY = null;
            this.mUrl = str;
            this.eCY = basicNameValuePair;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!SquareSearchActivity.this.aMH()) {
                SquareSearchActivity.this.aP(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.eCn, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(d.e.ds320));
                SquareSearchActivity.this.eCo.setVisibility(8);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public ForumSuggestModel doInBackground(Object... objArr) {
            ForumSuggestModel forumSuggestModel = null;
            if (j.gP()) {
                try {
                    this.mNetwork = new x(this.mUrl);
                    this.mNetwork.a(this.eCY);
                    String uL = this.mNetwork.uL();
                    if (uL != null) {
                        forumSuggestModel = ForumSuggestModel.parserJson(uL);
                        SquareSearchActivity.this.eCB = this.eCY.getValue();
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
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.eCn);
            if (forumSuggestModel != null) {
                SquareSearchActivity.this.aP(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.eCz = forumSuggestModel;
                SquareSearchActivity.this.refresh();
            } else {
                SquareSearchActivity.this.aO(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.m16do(d.k.text_no_search_record));
            }
            SquareSearchActivity.this.eCA = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.eW();
                this.mNetwork = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.eCn);
            super.cancel(true);
        }
    }

    /* renamed from: if  reason: not valid java name */
    private void m18if(boolean z) {
        if (TbadkCoreApplication.isLogin()) {
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(2001323, true));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(2001323, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO(View view2) {
        if (view2 != null) {
            view2.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP(View view2) {
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a026";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(final String str, boolean z) {
        if (!j.gP()) {
            showToast(d.k.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.eCK = false;
                this.cKK.setText(str);
                this.cKK.setSelection(str.length());
                this.eCK = true;
            }
            l.b(getPageContext().getPageActivity(), this.cKK);
            this.eCr.setVisibility(8);
            this.eCw.setVisibility(8);
            this.eCq.setVisibility(0);
            showProgressBarWithOffset(0, 0);
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            this.eCq.loadUrl(str2);
            v.a(new u<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.u
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.sX(str);
                    return true;
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oK(String str) {
        if (!j.gP()) {
            showToast(d.k.neterror);
        } else if (!StringUtils.isNull(str)) {
            this.eCL = str;
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.k.login_to_use), true, (int) IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BIND_WIDGET)));
            } else {
                sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), str)));
            }
        }
    }
}
