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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.f;
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
    private EditText cVF;
    private String dkJ;
    private ImageView dkT;
    private LinearLayout eWA;
    private BdListView eWB;
    private com.baidu.tieba.mainentrance.a eWC;
    private com.baidu.tieba.mainentrance.searchSuggestList.a eWD;
    private ForumSuggestModel eWE;
    private a eWF;
    private String eWG;
    private boolean eWH;
    private ScrollView eWJ;
    private SearchPageFocusBar eWK;
    private View eWL;
    private View eWM;
    private String eWQ;
    private HotForumModel eWd;
    private LinearLayoutDetectsSoftKeyboard eWr;
    private FrameLayout eWs;
    private FrameLayout eWt;
    private TextView eWu;
    private BaseWebView eWv;
    private ScrollView eWw;
    private LinearLayout eWx;
    private List<c> eWy;
    private g eWz;
    private HotSearchInfoData mHotSearchInfo;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mTopicInfoTitle;
    private boolean eWI = true;
    private List<View> eWN = new ArrayList();
    private boolean eWe = false;
    private boolean eWO = true;
    private boolean eWP = true;
    private Runnable eWR = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.1
        @Override // java.lang.Runnable
        public void run() {
            SquareSearchActivity.this.cVF.requestFocus();
            l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.cVF);
        }
    };
    private final Runnable eWS = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.12
        @Override // java.lang.Runnable
        public void run() {
            if (!SquareSearchActivity.this.aTi()) {
                try {
                    if (SquareSearchActivity.this.dkJ != null && SquareSearchActivity.this.dkJ.length() > 0) {
                        StringBuffer stringBuffer = new StringBuffer(30);
                        stringBuffer.append(TbConfig.SERVER_ADDRESS);
                        stringBuffer.append("c/f/forum/search");
                        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", SquareSearchActivity.this.dkJ.trim());
                        SquareSearchActivity.this.aST();
                        SquareSearchActivity.this.eWF = new a(stringBuffer.toString(), basicNameValuePair, true);
                        SquareSearchActivity.this.eWF.setPriority(3);
                        SquareSearchActivity.this.eWF.execute(stringBuffer.toString(), basicNameValuePair);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a eWT = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SEARCH_LIST, 309438) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.22
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = ((responsedMessage instanceof SearchListHttpResMessage) || (responsedMessage instanceof SearchListSocketResMessage)) ? false : true;
            if (responsedMessage == null || z || responsedMessage.getError() != 0 || responsedMessage.hasError()) {
                if (j.jE() || !SquareSearchActivity.this.eWe) {
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(f.j.neterror));
                }
                if (!j.jE()) {
                    SquareSearchActivity.this.eWe = true;
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
            if (SquareSearchActivity.this.eWO && responsedMessage.getError() != 0) {
                SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(f.j.neterror));
                return;
            }
            if (list != null && list.size() > 0) {
                SquareSearchActivity.this.eWO = false;
            }
            SquareSearchActivity.this.aTf();
            SquareSearchActivity.this.eWB.setAdapter((ListAdapter) SquareSearchActivity.this.eWD);
            SquareSearchActivity.this.eWD.pC(SquareSearchActivity.this.dkJ.trim());
            SquareSearchActivity.this.eWD.setData(list);
            SquareSearchActivity.this.eWD.notifyDataSetInvalidated();
        }
    };
    private CustomMessageListener eWi = new CustomMessageListener(2001608) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                SquareSearchActivity.this.pF(customResponsedMessage.getData().toString());
            }
        }
    };
    private CustomMessageListener eWU = new CustomMessageListener(2009002) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.13
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
    private View.OnClickListener eWV = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.cVF);
            if (view.getTag() instanceof c) {
                c cVar = (c) view.getTag();
                TiebaStatic.log(new an("c10363").ae("obj_name", cVar.getName()));
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
                if (SquareSearchActivity.this.eWv.getUrl() != null && SquareSearchActivity.this.eWv.getUrl().contains(str)) {
                    SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.eWs);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aSS() {
        if (this.mHotSearchInfo == null) {
            return false;
        }
        if (this.mHotSearchInfo.aSQ() == 0) {
            H(this.mHotSearchInfo.getName(), false);
        } else if (this.mHotSearchInfo.aSQ() == 1 && !com.baidu.tbadk.plugins.b.e(getPageContext())) {
            sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new an("c10355").ae("obj_name", this.mHotSearchInfo.getName()).r("obj_type", this.mHotSearchInfo.aSQ() == 0 ? 2 : 1));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(f.h.home_dialog_search);
        init();
        getWindow().setSoftInputMode(1);
        registerListener(this.eWU);
        registerListener(this.eWT);
        registerListener(this.eWi);
        registerListener(this.htmlLoadMessageListener);
        if (SquareSearchActivityConfig.IS_SHOW_RECOMMEND_FORUM) {
            this.eWd = new HotForumModel(getPageContext(), this);
            this.eWd.aSO();
        }
        this.eWH = false;
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
        hideLoadingView(this.eWs);
        this.mHandler.removeCallbacks(this.eWR);
        aST();
    }

    public void aST() {
        this.mHandler.removeCallbacks(this.eWS);
        if (this.eWF != null) {
            this.eWF.cancel();
            this.eWF = null;
        }
    }

    private void init() {
        this.eWr = (LinearLayoutDetectsSoftKeyboard) findViewById(f.g.parent);
        this.eWr.setOnSoftKeyBoardShownListener(new LinearLayoutDetectsSoftKeyboard.a() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.24
            @Override // com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard.a
            public void iB(boolean z) {
                SquareSearchActivity.this.eWI = z;
            }
        });
        this.eWr.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.25
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    SquareSearchActivity.this.eWr.setFocusable(true);
                    SquareSearchActivity.this.eWr.setFocusableInTouchMode(true);
                    if (SquareSearchActivity.this.cVF.hasFocus()) {
                        l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.cVF);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        asl();
        this.eWs = (FrameLayout) findViewById(f.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(f.e.ds200)), null, null);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            this.eWJ = (ScrollView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(f.h.home_searchbar_nodataview, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) this.eWJ.findViewById(f.g.focusbar_nodata_root);
            this.eWK = (SearchPageFocusBar) linearLayout.findViewById(f.g.no_data_focusbar);
            linearLayout.addView(this.mNoDataView, 0);
            this.eWJ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.26
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.eWJ);
                    return false;
                }
            });
            this.eWs.addView(this.eWJ, this.eWs.getChildCount());
        } else {
            this.eWs.addView(this.mNoDataView, 0);
        }
        this.eWt = (FrameLayout) findViewById(f.g.home_search_list);
        aSR();
        aSV();
        aSW();
        aSX();
        this.eWv = (BaseWebView) findViewById(f.g.search_result_webview);
        this.eWv.initCommonJsBridge(getPageContext().getPageActivity());
        this.eWv.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.27
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
                if (SquareSearchActivity.this.isProgressBarShown()) {
                    SquareSearchActivity.this.hideProgressBar();
                }
            }
        });
        this.eWv.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.28
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedError", 0, "", "requesturl", str2, "receiveerror", Integer.valueOf(i), SocialConstants.PARAM_COMMENT, str);
            }
        });
        this.eWv.setOnReceivedSslErrorListener(new BaseWebView.g() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.g
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                if (sslError != null) {
                    com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedSslError", 0, "", "requesturl", sslError.getUrl(), "receiveerror", sslError.toString());
                }
            }
        });
        this.eWv.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.3
            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.mainentrance.SquareSearchActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return az.zI().b(SquareSearchActivity.this.getPageContext(), new String[]{str}) != 3;
            }
        });
        this.cVF.setText("");
        this.cVF.requestFocus();
        ShowSoftKeyPadDelay(this.cVF, 200);
        aSY();
        aSZ();
    }

    private void asl() {
        this.mNavigationBar = (NavigationBar) findViewById(f.g.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, f.h.square_search_navigation_view, (View.OnClickListener) null);
        this.bHe = (ImageView) addCustomView.findViewById(f.g.search_bar_icon);
        this.cVF = (EditText) addCustomView.findViewById(f.g.home_et_search);
        this.dkT = (ImageView) addCustomView.findViewById(f.g.home_bt_search_del);
        this.eWu = (TextView) addCustomView.findViewById(f.g.home_bt_search_cancel_s);
        this.cVF.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    SquareSearchActivity.this.aSU();
                } else {
                    l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.cVF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.aSU();
            }
        });
        this.eWu.setText(getPageContext().getString(f.j.cancel));
        this.eWu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.cVF);
                com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SquareSearchActivity.this.finish();
                    }
                }, 200L);
            }
        });
        this.cVF.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.7
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (SquareSearchActivity.this.dkJ == null || SquareSearchActivity.this.dkJ.trim().length() < 1) {
                        l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.cVF);
                        if (SquareSearchActivity.this.aSS()) {
                            return true;
                        }
                        SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(f.j.write_keyword));
                        return true;
                    }
                    String trim = SquareSearchActivity.this.cVF.getText().toString().trim();
                    if (!StringUtils.isNull(trim)) {
                        SquareSearchActivity.this.H(trim, false);
                        return true;
                    }
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(f.j.write_keyword));
                    return true;
                }
                return false;
            }
        });
        this.dkT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.cVF.setText("");
            }
        });
        this.cVF.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.9
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SquareSearchActivity.this.eWP) {
                    SquareSearchActivity.this.dkJ = editable.toString();
                    if (StringUtils.isNull(SquareSearchActivity.this.dkJ)) {
                        SquareSearchActivity.this.eWO = true;
                    }
                    SquareSearchActivity.this.aTc();
                }
                if (editable.toString().trim().length() == 0) {
                    SquareSearchActivity.this.dkT.setVisibility(8);
                } else {
                    SquareSearchActivity.this.dkT.setVisibility(0);
                }
                am.c(SquareSearchActivity.this.eWu, f.d.cp_link_tip_a, 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSU() {
        if (StringUtils.isNull(this.cVF.getText().toString())) {
            if (this.eWw.getVisibility() != 0) {
                aTa();
            }
        } else if (this.eWB.getVisibility() != 0) {
            aTc();
        }
    }

    private void aSV() {
        this.eWw = (ScrollView) findViewById(f.g.search_history_scrollview);
        this.eWx = (LinearLayout) findViewById(f.g.search_history_linearlayout);
        if (this.eWA == null) {
            this.eWA = new LinearLayout(getPageContext().getPageActivity());
            this.eWA.setOrientation(1);
            this.eWA.setBackgroundColor(am.getColor(f.d.cp_bg_line_d));
        }
        this.eWx.addView(this.eWA);
    }

    private void aSW() {
        if (this.eWz == null) {
            this.eWz = new g(getPageContext());
            this.eWx.addView(this.eWz.np());
        }
    }

    private void aSX() {
        this.eWB = (BdListView) findViewById(f.g.home_lv_search_suggest);
        this.eWC = new com.baidu.tieba.mainentrance.a(this, null);
        this.eWD = new com.baidu.tieba.mainentrance.searchSuggestList.a(getPageContext().getPageActivity(), null);
        this.eWB.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.10
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
        this.eWB.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.11
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

    public void aSY() {
        this.eWu.setText(getPageContext().getString(f.j.cancel));
        aSZ();
        aST();
        aTd();
        if (this.dkJ.trim().length() > 0) {
            aTc();
        } else {
            aTa();
        }
    }

    private void aSZ() {
        if (this.mHotSearchInfo == null) {
            this.cVF.setHint(f.j.search_bar);
        } else {
            this.cVF.setHint(" " + UtilHelper.getFixedText(this.mHotSearchInfo.aov(), 15));
        }
    }

    private void aSR() {
        HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
        if (hotSearchInfoData != null && hotSearchInfoData.getId() != 0) {
            this.mHotSearchInfo = hotSearchInfoData;
        }
    }

    private void aTa() {
        this.eWv.setVisibility(8);
        this.eWB.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009002));
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            iA(true);
            aW(this.eWK);
            aW(this.eWJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(ArrayList<String> arrayList) {
        NoDataViewFactory.d dt;
        if (af(arrayList)) {
            aTh();
            if (j.jE()) {
                dt = NoDataViewFactory.d.dt(f.j.text_no_search_record);
            } else {
                dt = NoDataViewFactory.d.dt(f.j.neterror);
            }
            this.mNoDataView.setTextOption(dt);
            return;
        }
        aTg();
        ae(arrayList);
        G(true, arrayList == null || arrayList.size() == 0);
        aSZ();
    }

    private void ae(final ArrayList<String> arrayList) {
        if (this.eWA != null) {
            this.eWA.removeAllViews();
            if (arrayList != null && !arrayList.isEmpty() && getActivity() != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                this.eWL = LayoutInflater.from(pageActivity).inflate(f.h.square_search_recommand_fourm_header, (ViewGroup) null);
                this.eWL.findViewById(f.g.titleTopDivider).setVisibility(8);
                getLayoutMode().onModeChanged(this.eWL);
                this.eWA.addView(this.eWL, layoutParams);
                int size = arrayList.size();
                this.eWN.clear();
                for (int i = 0; i < size; i++) {
                    final String str = arrayList.get(i);
                    if (!TextUtils.isEmpty(str)) {
                        final View inflate = LayoutInflater.from(pageActivity).inflate(f.h.home_dialog_search_item, (ViewGroup) null);
                        ((TextView) inflate.findViewById(f.g.home_lv_search_forum)).setText(str);
                        am.c((TextView) inflate.findViewById(f.g.home_lv_search_forum), f.d.cp_cont_b, 1);
                        inflate.findViewById(f.g.home_dialog_lv_search_forum_divider).setVisibility(8);
                        am.i(inflate, f.C0146f.square_search_item_bg);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        inflate.setOnClickListener(new b(str));
                        ImageView imageView = (ImageView) inflate.findViewById(f.g.del_search_history_btn);
                        am.c(imageView, f.C0146f.icn_shop_order_close);
                        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                v.a(new u<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // com.baidu.tbadk.util.u
                                    public Boolean doInBackground() {
                                        com.baidu.tieba.tbadkCore.util.a.tY(str);
                                        return true;
                                    }
                                }, new com.baidu.tbadk.util.g<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.2
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.tbadk.util.g
                                    public void onReturnDataInUI(Boolean bool) {
                                        SquareSearchActivity.this.eWA.removeView(inflate);
                                        arrayList.remove(str);
                                        if (arrayList.size() <= 0) {
                                            SquareSearchActivity.this.ad(null);
                                        }
                                    }
                                });
                            }
                        });
                        this.eWN.add(inflate);
                        this.eWA.addView(inflate, layoutParams2);
                    }
                }
                this.eWM = LayoutInflater.from(pageActivity).inflate(f.h.home_dialog_search_footer, (ViewGroup) null);
                ((TextView) this.eWM.findViewById(f.g.home_bt_search_footer)).setTextColor(am.getColor(f.d.cp_link_tip_a));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                this.eWM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SquareSearchActivity.this.aTb();
                    }
                });
                this.eWA.addView(this.eWM, layoutParams3);
            }
        }
    }

    private void G(boolean z, boolean z2) {
        if (this.eWz != null) {
            this.eWz.clear();
            if (this.eWy != null && !this.eWy.isEmpty() && z) {
                this.eWz.iz(!z2);
                this.eWz.setTitleText(this.mTopicInfoTitle);
                int size = this.eWy.size();
                if (size >= 1) {
                    if (size > 7) {
                        size = 7;
                    }
                    int i = size % 2 == 0 ? size - 1 : size;
                    for (int i2 = 0; i2 < i; i2++) {
                        c cVar = (c) w.d(this.eWy, i2);
                        if (cVar != null) {
                            this.eWz.a(cVar, i2).setOnClickListener(this.eWV);
                        }
                    }
                    this.eWz.a(null, i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.16
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.cVF);
                            if (!com.baidu.tbadk.plugins.b.e(SquareSearchActivity.this.getPageContext())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all")));
                            }
                        }
                    });
                    this.eWz.show();
                }
            }
        }
    }

    private boolean af(ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && (this.eWy == null || this.eWy.size() <= 2) && this.eWH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTb() {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).dB(getPageContext().getString(f.j.alert_clean_history)).a(getPageContext().getString(f.j.clear_all_text), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                h.io().d(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.bxa();
                    }
                });
                if (SquareSearchActivity.this.eWy == null || SquareSearchActivity.this.eWy.size() < 2) {
                    SquareSearchActivity.this.aV(SquareSearchActivity.this.eWJ);
                    SquareSearchActivity.this.aV(SquareSearchActivity.this.eWK);
                    SquareSearchActivity.this.eWt.setVisibility(8);
                    SquareSearchActivity.this.mNoDataView.setVisibility(0);
                    SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.dt(f.j.text_no_search_record));
                    return;
                }
                SquareSearchActivity.this.ad(null);
            }
        }).b(getPageContext().getString(f.j.cancel), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.17
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        }).b(getPageContext()).xe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTc() {
        if (this.dkJ.trim().length() > 0) {
            aTe();
            return;
        }
        aST();
        aTa();
    }

    private void aTd() {
        if (this.eWB != null) {
            this.eWB.setNextPage(null);
        }
    }

    private void aTe() {
        if (!StringUtils.isNull(this.dkJ)) {
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.dkJ.trim();
            sendMessage(searchListNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        try {
            if (this.eWE != null) {
                if (this.eWE.forum_list != null && this.eWE.forum_list.size() > 0) {
                    aTf();
                    this.eWB.setAdapter((ListAdapter) this.eWC);
                    this.eWC.pC(this.dkJ);
                    this.eWC.ac(this.eWE.forum_list);
                    this.eWC.notifyDataSetInvalidated();
                } else {
                    aW(this.eWJ);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTf() {
        this.eWt.setVisibility(0);
        this.eWB.setVisibility(0);
        this.eWw.setVisibility(8);
        this.eWv.setVisibility(8);
        aW(this.eWJ);
        this.mNoDataView.setVisibility(8);
    }

    private void aTg() {
        this.eWt.setVisibility(0);
        this.eWw.setVisibility(0);
        this.eWB.setVisibility(8);
        this.eWv.setVisibility(8);
        aW(this.eWJ);
        this.mNoDataView.setVisibility(8);
    }

    private void aTh() {
        this.eWt.setVisibility(8);
        this.eWB.setVisibility(8);
        this.eWw.setVisibility(8);
        this.eWv.setVisibility(8);
        aV(this.eWJ);
        this.mNoDataView.setVisibility(0);
        aV(this.eWK);
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void pD(String str) {
        this.eWH = true;
        this.eWy = new ArrayList();
        aTa();
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void a(List<com.baidu.tieba.mainentrance.b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str) {
        this.eWH = true;
        hideLoadingView(this.eWs);
        if (list2 == null) {
            this.eWy = new ArrayList();
        } else {
            this.eWy = list2;
        }
        if (!StringUtils.isNULL(str)) {
            this.mTopicInfoTitle = str;
        } else {
            this.mTopicInfoTitle = "";
        }
        a(hotSearchInfoData);
        this.mHotSearchInfo = hotSearchInfoData;
        aTa();
    }

    private void a(HotSearchInfoData hotSearchInfoData) {
        if (hotSearchInfoData != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
            return;
        }
        HotSearchInfoData hotSearchInfoData2 = new HotSearchInfoData();
        hotSearchInfoData2.setId(0L);
        hotSearchInfoData2.setName("");
        hotSearchInfoData2.pE("");
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
        getLayoutMode().onModeChanged(this.eWr);
        am.e(this.eWr, i);
        if (this.eWC != null) {
            this.eWC.notifyDataSetChanged();
        }
        if (i == 2) {
            this.cVF.setHintTextColor(am.getColor(f.d.s_navbar_title_color));
        } else {
            this.cVF.setHintTextColor(am.getColor(f.d.cp_cont_e));
        }
        am.c(this.dkT, f.C0146f.del_search_btn);
        am.b(this.cVF, f.d.cp_cont_b, f.d.s_navbar_title_color);
        am.a(this.bHe, f.C0146f.icon_seach_n, f.C0146f.icon_seach_n, f.C0146f.icon_seach_n, i);
        am.i(this.eWs, f.d.cp_bg_line_d);
        am.c(this.eWu, f.d.cp_link_tip_a, 1);
        if (this.eWz != null) {
            this.eWz.onChangeSkinType(i);
        }
        pt(i);
    }

    private void pt(int i) {
        if (this.eWA != null) {
            this.eWA.setBackgroundColor(am.getColor(f.d.cp_bg_line_d));
        }
        if (this.eWL != null) {
            getLayoutMode().onModeChanged(this.eWL);
        }
        if (this.eWM != null) {
            ((TextView) this.eWM.findViewById(f.g.home_bt_search_footer)).setTextColor(am.getColor(f.d.cp_link_tip_a));
        }
        if (this.eWN != null) {
            for (View view : this.eWN) {
                am.c((TextView) view.findViewById(f.g.home_lv_search_forum), f.d.cp_cont_b, 1);
                view.findViewById(f.g.home_dialog_lv_search_forum_divider).setBackgroundColor(am.getColor(f.d.cp_bg_line_b));
                am.i(view, f.C0146f.addresslist_item_bg);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (i == 4 && this.eWv.canGoBack()) {
                this.eWv.goBack();
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
                SquareSearchActivity.this.dkJ = this.mName;
                TiebaStatic.log(new an("c12034"));
                SquareSearchActivity.this.H(this.mName, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aTi() {
        if (!j.jE()) {
            aV(this.mNoDataView);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dt(f.j.neterror));
            return true;
        }
        aW(this.mNoDataView);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
        private BasicNameValuePair eXd;
        private y mNetwork = null;
        private String mUrl;

        public a(String str, BasicNameValuePair basicNameValuePair, boolean z) {
            this.mUrl = null;
            this.eXd = null;
            this.mUrl = str;
            this.eXd = basicNameValuePair;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!SquareSearchActivity.this.aTi()) {
                SquareSearchActivity.this.aW(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.eWs, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(f.e.ds320));
                SquareSearchActivity.this.eWt.setVisibility(8);
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
                    this.mNetwork.a(this.eXd);
                    String yo = this.mNetwork.yo();
                    if (yo != null) {
                        forumSuggestModel = ForumSuggestModel.parserJson(yo);
                        SquareSearchActivity.this.eWG = this.eXd.getValue();
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
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.eWs);
            if (forumSuggestModel != null) {
                SquareSearchActivity.this.aW(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.eWE = forumSuggestModel;
                SquareSearchActivity.this.refresh();
            } else {
                SquareSearchActivity.this.aV(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.dt(f.j.text_no_search_record));
            }
            SquareSearchActivity.this.eWF = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.hN();
                this.mNetwork = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.eWs);
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
            showToast(f.j.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.eWP = false;
                this.cVF.setText(str);
                this.cVF.setSelection(str.length());
                this.eWP = true;
            }
            l.a(getPageContext().getPageActivity(), this.cVF);
            this.eWw.setVisibility(8);
            this.eWB.setVisibility(8);
            this.eWv.setVisibility(0);
            showProgressBarWithOffset(0, 0);
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, IoUtils.UTF_8);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            this.eWv.loadUrl(str2);
            v.a(new u<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.u
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.tW(str);
                    return true;
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pF(String str) {
        if (!j.jE()) {
            showToast(f.j.neterror);
        } else if (!StringUtils.isNull(str)) {
            this.eWQ = str;
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BIND_WIDGET)));
            } else {
                sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), str)));
            }
        }
    }
}
