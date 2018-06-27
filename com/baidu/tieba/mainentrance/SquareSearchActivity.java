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
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.util.w;
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
    private ImageView bGp;
    private EditText cSW;
    private String dhV;
    private ImageView dif;
    private LinearLayoutDetectsSoftKeyboard eSC;
    private FrameLayout eSD;
    private FrameLayout eSE;
    private TextView eSF;
    private BaseWebView eSG;
    private ScrollView eSH;
    private LinearLayout eSI;
    private List<c> eSJ;
    private g eSK;
    private LinearLayout eSL;
    private BdListView eSM;
    private com.baidu.tieba.mainentrance.a eSN;
    private com.baidu.tieba.mainentrance.searchSuggestList.a eSO;
    private ForumSuggestModel eSP;
    private a eSQ;
    private String eSR;
    private boolean eSS;
    private ScrollView eSU;
    private SearchPageFocusBar eSV;
    private View eSW;
    private View eSX;
    private HotForumModel eSn;
    private String eTb;
    private HotSearchInfoData mHotSearchInfo;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mTopicInfoTitle;
    private boolean eST = true;
    private List<View> eSY = new ArrayList();
    private boolean eSo = false;
    private boolean eSZ = true;
    private boolean eTa = true;
    private Runnable eTc = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.1
        @Override // java.lang.Runnable
        public void run() {
            SquareSearchActivity.this.cSW.requestFocus();
            l.c(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.cSW);
        }
    };
    private final Runnable eTd = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.12
        @Override // java.lang.Runnable
        public void run() {
            if (!SquareSearchActivity.this.aSj()) {
                try {
                    if (SquareSearchActivity.this.dhV != null && SquareSearchActivity.this.dhV.length() > 0) {
                        StringBuffer stringBuffer = new StringBuffer(30);
                        stringBuffer.append(TbConfig.SERVER_ADDRESS);
                        stringBuffer.append("c/f/forum/search");
                        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", SquareSearchActivity.this.dhV.trim());
                        SquareSearchActivity.this.aRU();
                        SquareSearchActivity.this.eSQ = new a(stringBuffer.toString(), basicNameValuePair, true);
                        SquareSearchActivity.this.eSQ.setPriority(3);
                        SquareSearchActivity.this.eSQ.execute(stringBuffer.toString(), basicNameValuePair);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a eTe = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SEARCH_LIST, 309438) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.22
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = ((responsedMessage instanceof SearchListHttpResMessage) || (responsedMessage instanceof SearchListSocketResMessage)) ? false : true;
            if (responsedMessage == null || z || responsedMessage.getError() != 0 || responsedMessage.hasError()) {
                if (j.jD() || !SquareSearchActivity.this.eSo) {
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(d.k.neterror));
                }
                if (!j.jD()) {
                    SquareSearchActivity.this.eSo = true;
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
            if (SquareSearchActivity.this.eSZ && responsedMessage.getError() != 0) {
                SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(d.k.neterror));
                return;
            }
            if (list != null && list.size() > 0) {
                SquareSearchActivity.this.eSZ = false;
            }
            SquareSearchActivity.this.aSg();
            SquareSearchActivity.this.eSM.setAdapter((ListAdapter) SquareSearchActivity.this.eSO);
            SquareSearchActivity.this.eSO.pz(SquareSearchActivity.this.dhV.trim());
            SquareSearchActivity.this.eSO.setData(list);
            SquareSearchActivity.this.eSO.notifyDataSetInvalidated();
        }
    };
    private CustomMessageListener eSs = new CustomMessageListener(2001608) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                SquareSearchActivity.this.pC(customResponsedMessage.getData().toString());
            }
        }
    };
    private CustomMessageListener eTf = new CustomMessageListener(2009002) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.13
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
    private View.OnClickListener eTg = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.cSW);
            if (view.getTag() instanceof c) {
                c cVar = (c) view.getTag();
                TiebaStatic.log(new an("c10363").ah("obj_name", cVar.getName()));
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
                if (SquareSearchActivity.this.eSG.getUrl() != null && SquareSearchActivity.this.eSG.getUrl().contains(str)) {
                    SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.eSD);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aRT() {
        if (this.mHotSearchInfo == null) {
            return false;
        }
        if (this.mHotSearchInfo.aRR() == 0) {
            I(this.mHotSearchInfo.getName(), false);
        } else if (this.mHotSearchInfo.aRR() == 1 && !com.baidu.tbadk.plugins.b.e(getPageContext())) {
            sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new an("c10355").ah("obj_name", this.mHotSearchInfo.getName()).r("obj_type", this.mHotSearchInfo.aRR() == 0 ? 2 : 1));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.home_dialog_search);
        init();
        getWindow().setSoftInputMode(1);
        registerListener(this.eTf);
        registerListener(this.eTe);
        registerListener(this.eSs);
        registerListener(this.htmlLoadMessageListener);
        if (SquareSearchActivityConfig.IS_SHOW_RECOMMEND_FORUM) {
            this.eSn = new HotForumModel(getPageContext(), this);
            this.eSn.aRP();
        }
        this.eSS = false;
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
        hideLoadingView(this.eSD);
        this.mHandler.removeCallbacks(this.eTc);
        aRU();
    }

    public void aRU() {
        this.mHandler.removeCallbacks(this.eTd);
        if (this.eSQ != null) {
            this.eSQ.cancel();
            this.eSQ = null;
        }
    }

    private void init() {
        this.eSC = (LinearLayoutDetectsSoftKeyboard) findViewById(d.g.parent);
        this.eSC.setOnSoftKeyBoardShownListener(new LinearLayoutDetectsSoftKeyboard.a() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.24
            @Override // com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard.a
            public void ix(boolean z) {
                SquareSearchActivity.this.eST = z;
            }
        });
        this.eSC.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.25
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    SquareSearchActivity.this.eSC.setFocusable(true);
                    SquareSearchActivity.this.eSC.setFocusableInTouchMode(true);
                    if (SquareSearchActivity.this.cSW.hasFocus()) {
                        l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.cSW);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        arI();
        this.eSD = (FrameLayout) findViewById(d.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds200)), null, null);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            this.eSU = (ScrollView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.i.home_searchbar_nodataview, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) this.eSU.findViewById(d.g.focusbar_nodata_root);
            this.eSV = (SearchPageFocusBar) linearLayout.findViewById(d.g.no_data_focusbar);
            linearLayout.addView(this.mNoDataView, 0);
            this.eSU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.26
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.eSU);
                    return false;
                }
            });
            this.eSD.addView(this.eSU, this.eSD.getChildCount());
        } else {
            this.eSD.addView(this.mNoDataView, 0);
        }
        this.eSE = (FrameLayout) findViewById(d.g.home_search_list);
        aRS();
        aRW();
        aRX();
        aRY();
        this.eSG = (BaseWebView) findViewById(d.g.search_result_webview);
        this.eSG.initCommonJsBridge(getPageContext().getPageActivity());
        this.eSG.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.27
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
                if (SquareSearchActivity.this.isProgressBarShown()) {
                    SquareSearchActivity.this.hideProgressBar();
                }
            }
        });
        this.eSG.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.28
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedError", 0, "", "requesturl", str2, "receiveerror", Integer.valueOf(i), SocialConstants.PARAM_COMMENT, str);
            }
        });
        this.eSG.setOnReceivedSslErrorListener(new BaseWebView.g() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.g
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                if (sslError != null) {
                    com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedSslError", 0, "", "requesturl", sslError.getUrl(), "receiveerror", sslError.toString());
                }
            }
        });
        this.eSG.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.3
            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.mainentrance.SquareSearchActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return az.zV().b(SquareSearchActivity.this.getPageContext(), new String[]{str}) != 3;
            }
        });
        this.cSW.setText("");
        this.cSW.requestFocus();
        ShowSoftKeyPadDelay(this.cSW, 200);
        aRZ();
        aSa();
    }

    private void arI() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.i.square_search_navigation_view, (View.OnClickListener) null);
        this.bGp = (ImageView) addCustomView.findViewById(d.g.search_bar_icon);
        this.cSW = (EditText) addCustomView.findViewById(d.g.home_et_search);
        this.dif = (ImageView) addCustomView.findViewById(d.g.home_bt_search_del);
        this.eSF = (TextView) addCustomView.findViewById(d.g.home_bt_search_cancel_s);
        this.cSW.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    SquareSearchActivity.this.aRV();
                } else {
                    l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.cSW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.aRV();
            }
        });
        this.eSF.setText(getPageContext().getString(d.k.cancel));
        this.eSF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.cSW);
                com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SquareSearchActivity.this.finish();
                    }
                }, 200L);
            }
        });
        this.cSW.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.7
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (SquareSearchActivity.this.dhV == null || SquareSearchActivity.this.dhV.trim().length() < 1) {
                        l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.cSW);
                        if (SquareSearchActivity.this.aRT()) {
                            return true;
                        }
                        SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(d.k.write_keyword));
                        return true;
                    }
                    String trim = SquareSearchActivity.this.cSW.getText().toString().trim();
                    if (!StringUtils.isNull(trim)) {
                        SquareSearchActivity.this.I(trim, false);
                        return true;
                    }
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(d.k.write_keyword));
                    return true;
                }
                return false;
            }
        });
        this.dif.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.cSW.setText("");
            }
        });
        this.cSW.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.9
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SquareSearchActivity.this.eTa) {
                    SquareSearchActivity.this.dhV = editable.toString();
                    if (StringUtils.isNull(SquareSearchActivity.this.dhV)) {
                        SquareSearchActivity.this.eSZ = true;
                    }
                    SquareSearchActivity.this.aSd();
                }
                if (editable.toString().trim().length() == 0) {
                    SquareSearchActivity.this.dif.setVisibility(8);
                } else {
                    SquareSearchActivity.this.dif.setVisibility(0);
                }
                am.c(SquareSearchActivity.this.eSF, d.C0142d.cp_link_tip_a, 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRV() {
        if (StringUtils.isNull(this.cSW.getText().toString())) {
            if (this.eSH.getVisibility() != 0) {
                aSb();
            }
        } else if (this.eSM.getVisibility() != 0) {
            aSd();
        }
    }

    private void aRW() {
        this.eSH = (ScrollView) findViewById(d.g.search_history_scrollview);
        this.eSI = (LinearLayout) findViewById(d.g.search_history_linearlayout);
        if (this.eSL == null) {
            this.eSL = new LinearLayout(getPageContext().getPageActivity());
            this.eSL.setOrientation(1);
            this.eSL.setBackgroundColor(am.getColor(d.C0142d.cp_bg_line_d));
        }
        this.eSI.addView(this.eSL);
    }

    private void aRX() {
        if (this.eSK == null) {
            this.eSK = new g(getPageContext());
            this.eSI.addView(this.eSK.nn());
        }
    }

    private void aRY() {
        this.eSM = (BdListView) findViewById(d.g.home_lv_search_suggest);
        this.eSN = new com.baidu.tieba.mainentrance.a(this, null);
        this.eSO = new com.baidu.tieba.mainentrance.searchSuggestList.a(getPageContext().getPageActivity(), null);
        this.eSM.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.10
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ListAdapter adapter;
                ListView listView = (ListView) adapterView;
                if (listView != null && (adapter = listView.getAdapter()) != null && adapter.getCount() != 0 && i < adapter.getCount()) {
                    Object item = adapter.getItem(i);
                    if (item instanceof String) {
                        SquareSearchActivity.this.I((String) item, true);
                        TiebaStatic.eventStat(SquareSearchActivity.this.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
                    }
                }
            }
        });
        this.eSM.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.11
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

    public void aRZ() {
        this.eSF.setText(getPageContext().getString(d.k.cancel));
        aSa();
        aRU();
        aSe();
        if (this.dhV.trim().length() > 0) {
            aSd();
        } else {
            aSb();
        }
    }

    private void aSa() {
        if (this.mHotSearchInfo == null) {
            this.cSW.setHint(d.k.search_bar);
        } else {
            this.cSW.setHint(" " + UtilHelper.getFixedText(this.mHotSearchInfo.anW(), 15));
        }
    }

    private void aRS() {
        HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
        if (hotSearchInfoData != null && hotSearchInfoData.getId() != 0) {
            this.mHotSearchInfo = hotSearchInfoData;
        }
    }

    private void aSb() {
        this.eSG.setVisibility(8);
        this.eSM.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009002));
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            iw(true);
            aT(this.eSV);
            aT(this.eSU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(ArrayList<String> arrayList) {
        NoDataViewFactory.d ds;
        if (af(arrayList)) {
            aSi();
            if (j.jD()) {
                ds = NoDataViewFactory.d.ds(d.k.text_no_search_record);
            } else {
                ds = NoDataViewFactory.d.ds(d.k.neterror);
            }
            this.mNoDataView.setTextOption(ds);
            return;
        }
        aSh();
        ae(arrayList);
        G(true, arrayList == null || arrayList.size() == 0);
        aSa();
    }

    private void ae(final ArrayList<String> arrayList) {
        if (this.eSL != null) {
            this.eSL.removeAllViews();
            if (arrayList != null && !arrayList.isEmpty() && getActivity() != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                this.eSW = LayoutInflater.from(pageActivity).inflate(d.i.square_search_recommand_fourm_header, (ViewGroup) null);
                this.eSW.findViewById(d.g.titleTopDivider).setVisibility(8);
                getLayoutMode().onModeChanged(this.eSW);
                this.eSL.addView(this.eSW, layoutParams);
                int size = arrayList.size();
                this.eSY.clear();
                for (int i = 0; i < size; i++) {
                    final String str = arrayList.get(i);
                    if (!TextUtils.isEmpty(str)) {
                        final View inflate = LayoutInflater.from(pageActivity).inflate(d.i.home_dialog_search_item, (ViewGroup) null);
                        ((TextView) inflate.findViewById(d.g.home_lv_search_forum)).setText(str);
                        am.c((TextView) inflate.findViewById(d.g.home_lv_search_forum), d.C0142d.cp_cont_b, 1);
                        inflate.findViewById(d.g.home_dialog_lv_search_forum_divider).setVisibility(8);
                        am.i(inflate, d.f.square_search_item_bg);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        inflate.setOnClickListener(new b(str));
                        ImageView imageView = (ImageView) inflate.findViewById(d.g.del_search_history_btn);
                        am.c(imageView, d.f.icn_shop_order_close);
                        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                w.a(new v<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // com.baidu.tbadk.util.v
                                    public Boolean doInBackground() {
                                        com.baidu.tieba.tbadkCore.util.a.tW(str);
                                        return true;
                                    }
                                }, new h<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.2
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.tbadk.util.h
                                    public void onReturnDataInUI(Boolean bool) {
                                        SquareSearchActivity.this.eSL.removeView(inflate);
                                        arrayList.remove(str);
                                        if (arrayList.size() <= 0) {
                                            SquareSearchActivity.this.ad(null);
                                        }
                                    }
                                });
                            }
                        });
                        this.eSY.add(inflate);
                        this.eSL.addView(inflate, layoutParams2);
                    }
                }
                this.eSX = LayoutInflater.from(pageActivity).inflate(d.i.home_dialog_search_footer, (ViewGroup) null);
                ((TextView) this.eSX.findViewById(d.g.home_bt_search_footer)).setTextColor(am.getColor(d.C0142d.cp_link_tip_a));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                this.eSX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SquareSearchActivity.this.aSc();
                    }
                });
                this.eSL.addView(this.eSX, layoutParams3);
            }
        }
    }

    private void G(boolean z, boolean z2) {
        if (this.eSK != null) {
            this.eSK.clear();
            if (this.eSJ != null && !this.eSJ.isEmpty() && z) {
                this.eSK.iv(!z2);
                this.eSK.setTitleText(this.mTopicInfoTitle);
                int size = this.eSJ.size();
                if (size >= 1) {
                    if (size > 7) {
                        size = 7;
                    }
                    int i = size % 2 == 0 ? size - 1 : size;
                    for (int i2 = 0; i2 < i; i2++) {
                        c cVar = (c) com.baidu.tbadk.core.util.w.d(this.eSJ, i2);
                        if (cVar != null) {
                            this.eSK.a(cVar, i2).setOnClickListener(this.eTg);
                        }
                    }
                    this.eSK.a(null, i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.16
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.cSW);
                            if (!com.baidu.tbadk.plugins.b.e(SquareSearchActivity.this.getPageContext())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all")));
                            }
                        }
                    });
                    this.eSK.show();
                }
            }
        }
    }

    private boolean af(ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && (this.eSJ == null || this.eSJ.size() <= 2) && this.eSS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSc() {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).dE(getPageContext().getString(d.k.alert_clean_history)).a(getPageContext().getString(d.k.clear_all_text), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                com.baidu.adp.lib.g.h.in().d(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.byw();
                    }
                });
                if (SquareSearchActivity.this.eSJ == null || SquareSearchActivity.this.eSJ.size() < 2) {
                    SquareSearchActivity.this.aS(SquareSearchActivity.this.eSU);
                    SquareSearchActivity.this.aS(SquareSearchActivity.this.eSV);
                    SquareSearchActivity.this.eSE.setVisibility(8);
                    SquareSearchActivity.this.mNoDataView.setVisibility(0);
                    SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.ds(d.k.text_no_search_record));
                    return;
                }
                SquareSearchActivity.this.ad(null);
            }
        }).b(getPageContext().getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.17
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        }).b(getPageContext()).xn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSd() {
        if (this.dhV.trim().length() > 0) {
            aSf();
            return;
        }
        aRU();
        aSb();
    }

    private void aSe() {
        if (this.eSM != null) {
            this.eSM.setNextPage(null);
        }
    }

    private void aSf() {
        if (!StringUtils.isNull(this.dhV)) {
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.dhV.trim();
            sendMessage(searchListNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        try {
            if (this.eSP != null) {
                if (this.eSP.forum_list != null && this.eSP.forum_list.size() > 0) {
                    aSg();
                    this.eSM.setAdapter((ListAdapter) this.eSN);
                    this.eSN.pz(this.dhV);
                    this.eSN.ac(this.eSP.forum_list);
                    this.eSN.notifyDataSetInvalidated();
                } else {
                    aT(this.eSU);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSg() {
        this.eSE.setVisibility(0);
        this.eSM.setVisibility(0);
        this.eSH.setVisibility(8);
        this.eSG.setVisibility(8);
        aT(this.eSU);
        this.mNoDataView.setVisibility(8);
    }

    private void aSh() {
        this.eSE.setVisibility(0);
        this.eSH.setVisibility(0);
        this.eSM.setVisibility(8);
        this.eSG.setVisibility(8);
        aT(this.eSU);
        this.mNoDataView.setVisibility(8);
    }

    private void aSi() {
        this.eSE.setVisibility(8);
        this.eSM.setVisibility(8);
        this.eSH.setVisibility(8);
        this.eSG.setVisibility(8);
        aS(this.eSU);
        this.mNoDataView.setVisibility(0);
        aS(this.eSV);
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void pA(String str) {
        this.eSS = true;
        this.eSJ = new ArrayList();
        aSb();
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void a(List<com.baidu.tieba.mainentrance.b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str) {
        this.eSS = true;
        hideLoadingView(this.eSD);
        if (list2 == null) {
            this.eSJ = new ArrayList();
        } else {
            this.eSJ = list2;
        }
        if (!StringUtils.isNULL(str)) {
            this.mTopicInfoTitle = str;
        } else {
            this.mTopicInfoTitle = "";
        }
        a(hotSearchInfoData);
        this.mHotSearchInfo = hotSearchInfoData;
        aSb();
    }

    private void a(HotSearchInfoData hotSearchInfoData) {
        if (hotSearchInfoData != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
            return;
        }
        HotSearchInfoData hotSearchInfoData2 = new HotSearchInfoData();
        hotSearchInfoData2.setId(0L);
        hotSearchInfoData2.setName("");
        hotSearchInfoData2.pB("");
        hotSearchInfoData2.cp(0L);
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
        getLayoutMode().onModeChanged(this.eSC);
        am.e(this.eSC, i);
        if (this.eSN != null) {
            this.eSN.notifyDataSetChanged();
        }
        if (i == 2) {
            this.cSW.setHintTextColor(am.getColor(d.C0142d.s_navbar_title_color));
        } else {
            this.cSW.setHintTextColor(am.getColor(d.C0142d.cp_cont_e));
        }
        am.c(this.dif, d.f.del_search_btn);
        am.b(this.cSW, d.C0142d.cp_cont_b, d.C0142d.s_navbar_title_color);
        am.a(this.bGp, d.f.icon_seach_n, d.f.icon_seach_n, d.f.icon_seach_n, i);
        am.i(this.eSD, d.C0142d.cp_bg_line_d);
        am.c(this.eSF, d.C0142d.cp_link_tip_a, 1);
        if (this.eSK != null) {
            this.eSK.onChangeSkinType(i);
        }
        pe(i);
    }

    private void pe(int i) {
        if (this.eSL != null) {
            this.eSL.setBackgroundColor(am.getColor(d.C0142d.cp_bg_line_d));
        }
        if (this.eSW != null) {
            getLayoutMode().onModeChanged(this.eSW);
        }
        if (this.eSX != null) {
            ((TextView) this.eSX.findViewById(d.g.home_bt_search_footer)).setTextColor(am.getColor(d.C0142d.cp_link_tip_a));
        }
        if (this.eSY != null) {
            for (View view : this.eSY) {
                am.c((TextView) view.findViewById(d.g.home_lv_search_forum), d.C0142d.cp_cont_b, 1);
                view.findViewById(d.g.home_dialog_lv_search_forum_divider).setBackgroundColor(am.getColor(d.C0142d.cp_bg_line_b));
                am.i(view, d.f.addresslist_item_bg);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (i == 4 && this.eSG.canGoBack()) {
                this.eSG.goBack();
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
        public void onClick(View view) {
            if (!TextUtils.isEmpty(this.mName)) {
                SquareSearchActivity.this.dhV = this.mName;
                TiebaStatic.log(new an("c12034"));
                SquareSearchActivity.this.I(this.mName, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aSj() {
        if (!j.jD()) {
            aS(this.mNoDataView);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.ds(d.k.neterror));
            return true;
        }
        aT(this.mNoDataView);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
        private BasicNameValuePair eTo;
        private y mNetwork = null;
        private String mUrl;

        public a(String str, BasicNameValuePair basicNameValuePair, boolean z) {
            this.mUrl = null;
            this.eTo = null;
            this.mUrl = str;
            this.eTo = basicNameValuePair;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!SquareSearchActivity.this.aSj()) {
                SquareSearchActivity.this.aT(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.eSD, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(d.e.ds320));
                SquareSearchActivity.this.eSE.setVisibility(8);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public ForumSuggestModel doInBackground(Object... objArr) {
            ForumSuggestModel forumSuggestModel = null;
            if (j.jD()) {
                try {
                    this.mNetwork = new y(this.mUrl);
                    this.mNetwork.a(this.eTo);
                    String yz = this.mNetwork.yz();
                    if (yz != null) {
                        forumSuggestModel = ForumSuggestModel.parserJson(yz);
                        SquareSearchActivity.this.eSR = this.eTo.getValue();
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
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.eSD);
            if (forumSuggestModel != null) {
                SquareSearchActivity.this.aT(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.eSP = forumSuggestModel;
                SquareSearchActivity.this.refresh();
            } else {
                SquareSearchActivity.this.aS(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.ds(d.k.text_no_search_record));
            }
            SquareSearchActivity.this.eSQ = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.hN();
                this.mNetwork = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.eSD);
            super.cancel(true);
        }
    }

    private void iw(boolean z) {
        if (TbadkCoreApplication.isLogin()) {
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(2001323, true));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(2001323, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(View view) {
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aT(View view) {
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a026";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(final String str, boolean z) {
        if (!j.jD()) {
            showToast(d.k.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.eTa = false;
                this.cSW.setText(str);
                this.cSW.setSelection(str.length());
                this.eTa = true;
            }
            l.b(getPageContext().getPageActivity(), this.cSW);
            this.eSH.setVisibility(8);
            this.eSM.setVisibility(8);
            this.eSG.setVisibility(0);
            showProgressBarWithOffset(0, 0);
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, IoUtils.UTF_8);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            this.eSG.loadUrl(str2);
            w.a(new v<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.v
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.tU(str);
                    return true;
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pC(String str) {
        if (!j.jD()) {
            showToast(d.k.neterror);
        } else if (!StringUtils.isNull(str)) {
            this.eTb = str;
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BIND_WIDGET)));
            } else {
                sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), str)));
            }
        }
    }
}
