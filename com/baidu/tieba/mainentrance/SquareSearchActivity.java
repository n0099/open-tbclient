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
import com.baidu.ar.util.IoUtils;
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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.mainentrance.HotForumModel;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListHttpResMessage;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListNetMessage;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListSocketResMessage;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import com.tencent.open.SocialConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
@SuppressLint({"ResourceAsColor"})
@Deprecated
/* loaded from: classes3.dex */
public class SquareSearchActivity extends BaseActivity<SquareSearchActivity> implements HotForumModel.a {
    private ImageView bHe;
    private EditText cVJ;
    private String dkL;
    private ImageView dkV;
    private TextView eWA;
    private BaseWebView eWB;
    private ScrollView eWC;
    private LinearLayout eWD;
    private List<c> eWE;
    private g eWF;
    private LinearLayout eWG;
    private BdListView eWH;
    private com.baidu.tieba.mainentrance.a eWI;
    private com.baidu.tieba.mainentrance.searchSuggestList.a eWJ;
    private ForumSuggestModel eWK;
    private a eWL;
    private String eWM;
    private boolean eWN;
    private ScrollView eWP;
    private SearchPageFocusBar eWQ;
    private View eWR;
    private View eWS;
    private String eWW;
    private HotForumModel eWi;
    private LinearLayoutDetectsSoftKeyboard eWx;
    private FrameLayout eWy;
    private FrameLayout eWz;
    private HotSearchInfoData mHotSearchInfo;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mTopicInfoTitle;
    private boolean eWO = true;
    private List<View> eWT = new ArrayList();
    private boolean eWj = false;
    private boolean eWU = true;
    private boolean eWV = true;
    private Runnable eWX = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.1
        @Override // java.lang.Runnable
        public void run() {
            SquareSearchActivity.this.cVJ.requestFocus();
            l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.cVJ);
        }
    };
    private final Runnable eWY = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.12
        @Override // java.lang.Runnable
        public void run() {
            if (!SquareSearchActivity.this.aTl()) {
                try {
                    if (SquareSearchActivity.this.dkL != null && SquareSearchActivity.this.dkL.length() > 0) {
                        StringBuffer stringBuffer = new StringBuffer(30);
                        stringBuffer.append(TbConfig.SERVER_ADDRESS);
                        stringBuffer.append("c/f/forum/search");
                        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", SquareSearchActivity.this.dkL.trim());
                        SquareSearchActivity.this.aSW();
                        SquareSearchActivity.this.eWL = new a(stringBuffer.toString(), basicNameValuePair, true);
                        SquareSearchActivity.this.eWL.setPriority(3);
                        SquareSearchActivity.this.eWL.execute(stringBuffer.toString(), basicNameValuePair);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a eWZ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SEARCH_LIST, 309438) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.22
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = ((responsedMessage instanceof SearchListHttpResMessage) || (responsedMessage instanceof SearchListSocketResMessage)) ? false : true;
            if (responsedMessage == null || z || responsedMessage.getError() != 0 || responsedMessage.hasError()) {
                if (j.jE() || !SquareSearchActivity.this.eWj) {
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(d.j.neterror));
                }
                if (!j.jE()) {
                    SquareSearchActivity.this.eWj = true;
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
            if (SquareSearchActivity.this.eWU && responsedMessage.getError() != 0) {
                SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(d.j.neterror));
                return;
            }
            if (list != null && list.size() > 0) {
                SquareSearchActivity.this.eWU = false;
            }
            SquareSearchActivity.this.aTi();
            SquareSearchActivity.this.eWH.setAdapter((ListAdapter) SquareSearchActivity.this.eWJ);
            SquareSearchActivity.this.eWJ.pA(SquareSearchActivity.this.dkL.trim());
            SquareSearchActivity.this.eWJ.setData(list);
            SquareSearchActivity.this.eWJ.notifyDataSetInvalidated();
        }
    };
    private CustomMessageListener eWn = new CustomMessageListener(2001608) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                SquareSearchActivity.this.pD(customResponsedMessage.getData().toString());
            }
        }
    };
    private CustomMessageListener eXa = new CustomMessageListener(2009002) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.13
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
    private View.OnClickListener eXb = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.cVJ);
            if (view.getTag() instanceof c) {
                c cVar = (c) view.getTag();
                TiebaStatic.log(new an("c10363").af("obj_name", cVar.getName()));
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
                if (SquareSearchActivity.this.eWB.getUrl() != null && SquareSearchActivity.this.eWB.getUrl().contains(str)) {
                    SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.eWy);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aSV() {
        if (this.mHotSearchInfo == null) {
            return false;
        }
        if (this.mHotSearchInfo.aST() == 0) {
            H(this.mHotSearchInfo.getName(), false);
        } else if (this.mHotSearchInfo.aST() == 1 && !com.baidu.tbadk.plugins.b.e(getPageContext())) {
            sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new an("c10355").af("obj_name", this.mHotSearchInfo.getName()).r("obj_type", this.mHotSearchInfo.aST() == 0 ? 2 : 1));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.home_dialog_search);
        init();
        getWindow().setSoftInputMode(1);
        registerListener(this.eXa);
        registerListener(this.eWZ);
        registerListener(this.eWn);
        registerListener(this.htmlLoadMessageListener);
        if (SquareSearchActivityConfig.IS_SHOW_RECOMMEND_FORUM) {
            this.eWi = new HotForumModel(getPageContext(), this);
            this.eWi.aSR();
        }
        this.eWN = false;
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
        hideLoadingView(this.eWy);
        this.mHandler.removeCallbacks(this.eWX);
        aSW();
    }

    public void aSW() {
        this.mHandler.removeCallbacks(this.eWY);
        if (this.eWL != null) {
            this.eWL.cancel();
            this.eWL = null;
        }
    }

    private void init() {
        this.eWx = (LinearLayoutDetectsSoftKeyboard) findViewById(d.g.parent);
        this.eWx.setOnSoftKeyBoardShownListener(new LinearLayoutDetectsSoftKeyboard.a() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.24
            @Override // com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard.a
            public void iB(boolean z) {
                SquareSearchActivity.this.eWO = z;
            }
        });
        this.eWx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.25
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    SquareSearchActivity.this.eWx.setFocusable(true);
                    SquareSearchActivity.this.eWx.setFocusableInTouchMode(true);
                    if (SquareSearchActivity.this.cVJ.hasFocus()) {
                        l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.cVJ);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        asl();
        this.eWy = (FrameLayout) findViewById(d.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds200)), null, null);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            this.eWP = (ScrollView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.h.home_searchbar_nodataview, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) this.eWP.findViewById(d.g.focusbar_nodata_root);
            this.eWQ = (SearchPageFocusBar) linearLayout.findViewById(d.g.no_data_focusbar);
            linearLayout.addView(this.mNoDataView, 0);
            this.eWP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.26
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.eWP);
                    return false;
                }
            });
            this.eWy.addView(this.eWP, this.eWy.getChildCount());
        } else {
            this.eWy.addView(this.mNoDataView, 0);
        }
        this.eWz = (FrameLayout) findViewById(d.g.home_search_list);
        aSU();
        aSY();
        aSZ();
        aTa();
        this.eWB = (BaseWebView) findViewById(d.g.search_result_webview);
        this.eWB.initCommonJsBridge(getPageContext().getPageActivity());
        this.eWB.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.27
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
                if (SquareSearchActivity.this.isProgressBarShown()) {
                    SquareSearchActivity.this.hideProgressBar();
                }
            }
        });
        this.eWB.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.28
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedError", 0, "", "requesturl", str2, "receiveerror", Integer.valueOf(i), SocialConstants.PARAM_COMMENT, str);
            }
        });
        this.eWB.setOnReceivedSslErrorListener(new BaseWebView.g() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.g
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                if (sslError != null) {
                    com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedSslError", 0, "", "requesturl", sslError.getUrl(), "receiveerror", sslError.toString());
                }
            }
        });
        this.eWB.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.3
            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.mainentrance.SquareSearchActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return ay.zK().b(SquareSearchActivity.this.getPageContext(), new String[]{str}) != 3;
            }
        });
        this.cVJ.setText("");
        this.cVJ.requestFocus();
        ShowSoftKeyPadDelay(this.cVJ, 200);
        aTb();
        aTc();
    }

    private void asl() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.h.square_search_navigation_view, (View.OnClickListener) null);
        this.bHe = (ImageView) addCustomView.findViewById(d.g.search_bar_icon);
        this.cVJ = (EditText) addCustomView.findViewById(d.g.home_et_search);
        this.dkV = (ImageView) addCustomView.findViewById(d.g.home_bt_search_del);
        this.eWA = (TextView) addCustomView.findViewById(d.g.home_bt_search_cancel_s);
        this.cVJ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    SquareSearchActivity.this.aSX();
                } else {
                    l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.cVJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.aSX();
            }
        });
        this.eWA.setText(getPageContext().getString(d.j.cancel));
        this.eWA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.cVJ);
                com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SquareSearchActivity.this.finish();
                    }
                }, 200L);
            }
        });
        this.cVJ.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.7
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (SquareSearchActivity.this.dkL == null || SquareSearchActivity.this.dkL.trim().length() < 1) {
                        l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.cVJ);
                        if (SquareSearchActivity.this.aSV()) {
                            return true;
                        }
                        SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(d.j.write_keyword));
                        return true;
                    }
                    String trim = SquareSearchActivity.this.cVJ.getText().toString().trim();
                    if (!StringUtils.isNull(trim)) {
                        SquareSearchActivity.this.H(trim, false);
                        return true;
                    }
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(d.j.write_keyword));
                    return true;
                }
                return false;
            }
        });
        this.dkV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.cVJ.setText("");
            }
        });
        this.cVJ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.9
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SquareSearchActivity.this.eWV) {
                    SquareSearchActivity.this.dkL = editable.toString();
                    if (StringUtils.isNull(SquareSearchActivity.this.dkL)) {
                        SquareSearchActivity.this.eWU = true;
                    }
                    SquareSearchActivity.this.aTf();
                }
                if (editable.toString().trim().length() == 0) {
                    SquareSearchActivity.this.dkV.setVisibility(8);
                } else {
                    SquareSearchActivity.this.dkV.setVisibility(0);
                }
                am.c(SquareSearchActivity.this.eWA, d.C0140d.cp_link_tip_a, 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSX() {
        if (StringUtils.isNull(this.cVJ.getText().toString())) {
            if (this.eWC.getVisibility() != 0) {
                aTd();
            }
        } else if (this.eWH.getVisibility() != 0) {
            aTf();
        }
    }

    private void aSY() {
        this.eWC = (ScrollView) findViewById(d.g.search_history_scrollview);
        this.eWD = (LinearLayout) findViewById(d.g.search_history_linearlayout);
        if (this.eWG == null) {
            this.eWG = new LinearLayout(getPageContext().getPageActivity());
            this.eWG.setOrientation(1);
            this.eWG.setBackgroundColor(am.getColor(d.C0140d.cp_bg_line_d));
        }
        this.eWD.addView(this.eWG);
    }

    private void aSZ() {
        if (this.eWF == null) {
            this.eWF = new g(getPageContext());
            this.eWD.addView(this.eWF.np());
        }
    }

    private void aTa() {
        this.eWH = (BdListView) findViewById(d.g.home_lv_search_suggest);
        this.eWI = new com.baidu.tieba.mainentrance.a(this, null);
        this.eWJ = new com.baidu.tieba.mainentrance.searchSuggestList.a(getPageContext().getPageActivity(), null);
        this.eWH.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.10
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
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
        this.eWH.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.11
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

    public void aTb() {
        this.eWA.setText(getPageContext().getString(d.j.cancel));
        aTc();
        aSW();
        aTg();
        if (this.dkL.trim().length() > 0) {
            aTf();
        } else {
            aTd();
        }
    }

    private void aTc() {
        if (this.mHotSearchInfo == null) {
            this.cVJ.setHint(d.j.search_bar);
        } else {
            this.cVJ.setHint(" " + UtilHelper.getFixedText(this.mHotSearchInfo.aov(), 15));
        }
    }

    private void aSU() {
        HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
        if (hotSearchInfoData != null && hotSearchInfoData.getId() != 0) {
            this.mHotSearchInfo = hotSearchInfoData;
        }
    }

    private void aTd() {
        this.eWB.setVisibility(8);
        this.eWH.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009002));
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            iA(true);
            aW(this.eWQ);
            aW(this.eWP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(ArrayList<String> arrayList) {
        NoDataViewFactory.d du;
        if (af(arrayList)) {
            aTk();
            if (j.jE()) {
                du = NoDataViewFactory.d.du(d.j.text_no_search_record);
            } else {
                du = NoDataViewFactory.d.du(d.j.neterror);
            }
            this.mNoDataView.setTextOption(du);
            return;
        }
        aTj();
        ae(arrayList);
        G(true, arrayList == null || arrayList.size() == 0);
        aTc();
    }

    private void ae(final ArrayList<String> arrayList) {
        if (this.eWG != null) {
            this.eWG.removeAllViews();
            if (arrayList != null && !arrayList.isEmpty() && getActivity() != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                this.eWR = LayoutInflater.from(pageActivity).inflate(d.h.square_search_recommand_fourm_header, (ViewGroup) null);
                this.eWR.findViewById(d.g.titleTopDivider).setVisibility(8);
                getLayoutMode().onModeChanged(this.eWR);
                this.eWG.addView(this.eWR, layoutParams);
                int size = arrayList.size();
                this.eWT.clear();
                for (int i = 0; i < size; i++) {
                    final String str = arrayList.get(i);
                    if (!TextUtils.isEmpty(str)) {
                        final View inflate = LayoutInflater.from(pageActivity).inflate(d.h.home_dialog_search_item, (ViewGroup) null);
                        ((TextView) inflate.findViewById(d.g.home_lv_search_forum)).setText(str);
                        am.c((TextView) inflate.findViewById(d.g.home_lv_search_forum), d.C0140d.cp_cont_b, 1);
                        inflate.findViewById(d.g.home_dialog_lv_search_forum_divider).setVisibility(8);
                        am.i(inflate, d.f.square_search_item_bg);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        inflate.setOnClickListener(new b(str));
                        ImageView imageView = (ImageView) inflate.findViewById(d.g.del_search_history_btn);
                        am.c(imageView, d.f.icn_shop_order_close);
                        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                v.a(new u<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // com.baidu.tbadk.util.u
                                    public Boolean doInBackground() {
                                        com.baidu.tieba.tbadkCore.util.a.tU(str);
                                        return true;
                                    }
                                }, new com.baidu.tbadk.util.g<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.2
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.tbadk.util.g
                                    public void onReturnDataInUI(Boolean bool) {
                                        SquareSearchActivity.this.eWG.removeView(inflate);
                                        arrayList.remove(str);
                                        if (arrayList.size() <= 0) {
                                            SquareSearchActivity.this.ad(null);
                                        }
                                    }
                                });
                            }
                        });
                        this.eWT.add(inflate);
                        this.eWG.addView(inflate, layoutParams2);
                    }
                }
                this.eWS = LayoutInflater.from(pageActivity).inflate(d.h.home_dialog_search_footer, (ViewGroup) null);
                ((TextView) this.eWS.findViewById(d.g.home_bt_search_footer)).setTextColor(am.getColor(d.C0140d.cp_link_tip_a));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                this.eWS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SquareSearchActivity.this.aTe();
                    }
                });
                this.eWG.addView(this.eWS, layoutParams3);
            }
        }
    }

    private void G(boolean z, boolean z2) {
        if (this.eWF != null) {
            this.eWF.clear();
            if (this.eWE != null && !this.eWE.isEmpty() && z) {
                this.eWF.iz(!z2);
                this.eWF.setTitleText(this.mTopicInfoTitle);
                int size = this.eWE.size();
                if (size >= 1) {
                    if (size > 7) {
                        size = 7;
                    }
                    int i = size % 2 == 0 ? size - 1 : size;
                    for (int i2 = 0; i2 < i; i2++) {
                        c cVar = (c) w.d(this.eWE, i2);
                        if (cVar != null) {
                            this.eWF.a(cVar, i2).setOnClickListener(this.eXb);
                        }
                    }
                    this.eWF.a(null, i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.16
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.cVJ);
                            if (!com.baidu.tbadk.plugins.b.e(SquareSearchActivity.this.getPageContext())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all")));
                            }
                        }
                    });
                    this.eWF.show();
                }
            }
        }
    }

    private boolean af(ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && (this.eWE == null || this.eWE.size() <= 2) && this.eWN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTe() {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).dB(getPageContext().getString(d.j.alert_clean_history)).a(getPageContext().getString(d.j.clear_all_text), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                h.io().d(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.bwZ();
                    }
                });
                if (SquareSearchActivity.this.eWE == null || SquareSearchActivity.this.eWE.size() < 2) {
                    SquareSearchActivity.this.aV(SquareSearchActivity.this.eWP);
                    SquareSearchActivity.this.aV(SquareSearchActivity.this.eWQ);
                    SquareSearchActivity.this.eWz.setVisibility(8);
                    SquareSearchActivity.this.mNoDataView.setVisibility(0);
                    SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.du(d.j.text_no_search_record));
                    return;
                }
                SquareSearchActivity.this.ad(null);
            }
        }).b(getPageContext().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.17
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        }).b(getPageContext()).xf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTf() {
        if (this.dkL.trim().length() > 0) {
            aTh();
            return;
        }
        aSW();
        aTd();
    }

    private void aTg() {
        if (this.eWH != null) {
            this.eWH.setNextPage(null);
        }
    }

    private void aTh() {
        if (!StringUtils.isNull(this.dkL)) {
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.dkL.trim();
            sendMessage(searchListNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        try {
            if (this.eWK != null) {
                if (this.eWK.forum_list != null && this.eWK.forum_list.size() > 0) {
                    aTi();
                    this.eWH.setAdapter((ListAdapter) this.eWI);
                    this.eWI.pA(this.dkL);
                    this.eWI.ac(this.eWK.forum_list);
                    this.eWI.notifyDataSetInvalidated();
                } else {
                    aW(this.eWP);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTi() {
        this.eWz.setVisibility(0);
        this.eWH.setVisibility(0);
        this.eWC.setVisibility(8);
        this.eWB.setVisibility(8);
        aW(this.eWP);
        this.mNoDataView.setVisibility(8);
    }

    private void aTj() {
        this.eWz.setVisibility(0);
        this.eWC.setVisibility(0);
        this.eWH.setVisibility(8);
        this.eWB.setVisibility(8);
        aW(this.eWP);
        this.mNoDataView.setVisibility(8);
    }

    private void aTk() {
        this.eWz.setVisibility(8);
        this.eWH.setVisibility(8);
        this.eWC.setVisibility(8);
        this.eWB.setVisibility(8);
        aV(this.eWP);
        this.mNoDataView.setVisibility(0);
        aV(this.eWQ);
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void pB(String str) {
        this.eWN = true;
        this.eWE = new ArrayList();
        aTd();
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void a(List<com.baidu.tieba.mainentrance.b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str) {
        this.eWN = true;
        hideLoadingView(this.eWy);
        if (list2 == null) {
            this.eWE = new ArrayList();
        } else {
            this.eWE = list2;
        }
        if (!StringUtils.isNULL(str)) {
            this.mTopicInfoTitle = str;
        } else {
            this.mTopicInfoTitle = "";
        }
        a(hotSearchInfoData);
        this.mHotSearchInfo = hotSearchInfoData;
        aTd();
    }

    private void a(HotSearchInfoData hotSearchInfoData) {
        if (hotSearchInfoData != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
            return;
        }
        HotSearchInfoData hotSearchInfoData2 = new HotSearchInfoData();
        hotSearchInfoData2.setId(0L);
        hotSearchInfoData2.setName("");
        hotSearchInfoData2.pC("");
        hotSearchInfoData2.cu(0L);
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
        getLayoutMode().onModeChanged(this.eWx);
        am.e(this.eWx, i);
        if (this.eWI != null) {
            this.eWI.notifyDataSetChanged();
        }
        if (i == 2) {
            this.cVJ.setHintTextColor(am.getColor(d.C0140d.s_navbar_title_color));
        } else {
            this.cVJ.setHintTextColor(am.getColor(d.C0140d.cp_cont_e));
        }
        am.c(this.dkV, d.f.del_search_btn);
        am.b(this.cVJ, d.C0140d.cp_cont_b, d.C0140d.s_navbar_title_color);
        am.a(this.bHe, d.f.icon_seach_n, d.f.icon_seach_n, d.f.icon_seach_n, i);
        am.i(this.eWy, d.C0140d.cp_bg_line_d);
        am.c(this.eWA, d.C0140d.cp_link_tip_a, 1);
        if (this.eWF != null) {
            this.eWF.onChangeSkinType(i);
        }
        pt(i);
    }

    private void pt(int i) {
        if (this.eWG != null) {
            this.eWG.setBackgroundColor(am.getColor(d.C0140d.cp_bg_line_d));
        }
        if (this.eWR != null) {
            getLayoutMode().onModeChanged(this.eWR);
        }
        if (this.eWS != null) {
            ((TextView) this.eWS.findViewById(d.g.home_bt_search_footer)).setTextColor(am.getColor(d.C0140d.cp_link_tip_a));
        }
        if (this.eWT != null) {
            for (View view : this.eWT) {
                am.c((TextView) view.findViewById(d.g.home_lv_search_forum), d.C0140d.cp_cont_b, 1);
                view.findViewById(d.g.home_dialog_lv_search_forum_divider).setBackgroundColor(am.getColor(d.C0140d.cp_bg_line_b));
                am.i(view, d.f.addresslist_item_bg);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (i == 4 && this.eWB.canGoBack()) {
                this.eWB.goBack();
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
            com.baidu.tbadk.core.e.b.h(getPageContext().getPageActivity(), 1);
        } else {
            com.baidu.tbadk.core.e.b.h(getPageContext().getPageActivity(), 2);
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
                SquareSearchActivity.this.dkL = this.mName;
                TiebaStatic.log(new an("c12034"));
                SquareSearchActivity.this.H(this.mName, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aTl() {
        if (!j.jE()) {
            aV(this.mNoDataView);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.du(d.j.neterror));
            return true;
        }
        aW(this.mNoDataView);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
        private BasicNameValuePair eXj;
        private y mNetwork = null;
        private String mUrl;

        public a(String str, BasicNameValuePair basicNameValuePair, boolean z) {
            this.mUrl = null;
            this.eXj = null;
            this.mUrl = str;
            this.eXj = basicNameValuePair;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!SquareSearchActivity.this.aTl()) {
                SquareSearchActivity.this.aW(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.eWy, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(d.e.ds320));
                SquareSearchActivity.this.eWz.setVisibility(8);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public ForumSuggestModel doInBackground(Object... objArr) {
            ForumSuggestModel forumSuggestModel = null;
            if (j.jE()) {
                try {
                    this.mNetwork = new y(this.mUrl);
                    this.mNetwork.a(this.eXj);
                    String yq = this.mNetwork.yq();
                    if (yq != null) {
                        forumSuggestModel = ForumSuggestModel.parserJson(yq);
                        SquareSearchActivity.this.eWM = this.eXj.getValue();
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
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.eWy);
            if (forumSuggestModel != null) {
                SquareSearchActivity.this.aW(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.eWK = forumSuggestModel;
                SquareSearchActivity.this.refresh();
            } else {
                SquareSearchActivity.this.aV(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.du(d.j.text_no_search_record));
            }
            SquareSearchActivity.this.eWL = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.hN();
                this.mNetwork = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.eWy);
            super.cancel(true);
        }
    }

    private void iA(boolean z) {
        if (TbadkCoreApplication.isLogin()) {
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(2001323, true));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(2001323, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aV(View view) {
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(View view) {
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a026";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(final String str, boolean z) {
        if (!j.jE()) {
            showToast(d.j.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.eWV = false;
                this.cVJ.setText(str);
                this.cVJ.setSelection(str.length());
                this.eWV = true;
            }
            l.a(getPageContext().getPageActivity(), this.cVJ);
            this.eWC.setVisibility(8);
            this.eWH.setVisibility(8);
            this.eWB.setVisibility(0);
            showProgressBarWithOffset(0, 0);
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, IoUtils.UTF_8);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            this.eWB.loadUrl(str2);
            v.a(new u<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.u
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.tS(str);
                    return true;
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pD(String str) {
        if (!j.jE()) {
            showToast(d.j.neterror);
        } else if (!StringUtils.isNull(str)) {
            this.eWW = str;
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BIND_WIDGET)));
            } else {
                sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), str)));
            }
        }
    }
}
