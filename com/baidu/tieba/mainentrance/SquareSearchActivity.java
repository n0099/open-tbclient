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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ae;
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
    private ImageView gEO;
    private ImageView hQY;
    private TextView hQZ;
    private String iFd;
    private EditText itS;
    private HotForumModel kLZ;
    private String kMA;
    private boolean kMB;
    private ScrollView kMD;
    private SearchPageFocusBar kME;
    private View kMF;
    private View kMG;
    private String kMK;
    private LinearLayoutDetectsSoftKeyboard kMm;
    private FrameLayout kMn;
    private FrameLayout kMo;
    private BaseWebView kMp;
    private ScrollView kMq;
    private LinearLayout kMr;
    private List<c> kMs;
    private g kMt;
    private LinearLayout kMu;
    private BdListView kMv;
    private com.baidu.tieba.mainentrance.a kMw;
    private com.baidu.tieba.mainentrance.searchSuggestList.b kMx;
    private ForumSuggestModel kMy;
    private a kMz;
    private HotSearchInfoData mHotSearchInfo;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mTopicInfoTitle;
    private boolean kMC = true;
    private List<View> kMH = new ArrayList();
    private boolean kLX = false;
    private boolean kMI = true;
    private boolean kMJ = true;
    private Runnable kML = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.1
        @Override // java.lang.Runnable
        public void run() {
            SquareSearchActivity.this.itS.requestFocus();
            l.showSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.itS);
        }
    };
    private final Runnable kMM = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.12
        @Override // java.lang.Runnable
        public void run() {
            if (!SquareSearchActivity.this.dbA()) {
                try {
                    if (SquareSearchActivity.this.iFd != null && SquareSearchActivity.this.iFd.length() > 0) {
                        StringBuffer stringBuffer = new StringBuffer(30);
                        stringBuffer.append(TbConfig.SERVER_ADDRESS);
                        stringBuffer.append(Config.SUGGEST_BAR_ADDRESS);
                        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", SquareSearchActivity.this.iFd.trim());
                        SquareSearchActivity.this.dbk();
                        SquareSearchActivity.this.kMz = new a(stringBuffer.toString(), basicNameValuePair, true);
                        SquareSearchActivity.this.kMz.setPriority(3);
                        SquareSearchActivity.this.kMz.execute(stringBuffer.toString(), basicNameValuePair);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a kMN = new com.baidu.adp.framework.listener.a(1003196, CmdConfigSocket.CMD_SEARCH_LIST) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.22
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = ((responsedMessage instanceof SearchListHttpResMessage) || (responsedMessage instanceof SearchListSocketResMessage)) ? false : true;
            if (responsedMessage == null || z || responsedMessage.getError() != 0 || responsedMessage.hasError()) {
                if (j.isNetWorkAvailable() || !SquareSearchActivity.this.kLX) {
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(R.string.neterror));
                }
                if (!j.isNetWorkAvailable()) {
                    SquareSearchActivity.this.kLX = true;
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
            if (SquareSearchActivity.this.kMI && responsedMessage.getError() != 0) {
                SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(R.string.neterror));
                return;
            }
            if (list != null && list.size() > 0) {
                SquareSearchActivity.this.kMI = false;
            }
            SquareSearchActivity.this.dbx();
            SquareSearchActivity.this.kMv.setAdapter((ListAdapter) SquareSearchActivity.this.kMx);
            SquareSearchActivity.this.kMx.NW(SquareSearchActivity.this.iFd.trim());
            SquareSearchActivity.this.kMx.setData(list);
            SquareSearchActivity.this.kMx.notifyDataSetInvalidated();
        }
    };
    private CustomMessageListener kMc = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_CREATE_BAR) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                SquareSearchActivity.this.NZ(customResponsedMessage.getData().toString());
            }
        }
    };
    private CustomMessageListener kMO = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof ArrayList) {
                    SquareSearchActivity.this.aO((ArrayList) data);
                }
            }
        }
    };
    private View.OnClickListener kMP = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.itS);
            if (view.getTag() instanceof c) {
                c cVar = (c) view.getTag();
                TiebaStatic.log(new aq("c10363").dR("obj_name", cVar.getName()));
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
                if (SquareSearchActivity.this.kMp.getUrl() != null && SquareSearchActivity.this.kMp.getUrl().contains(str)) {
                    SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.kMn);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dbj() {
        if (this.mHotSearchInfo == null) {
            return false;
        }
        if (this.mHotSearchInfo.getType() == 0) {
            aT(this.mHotSearchInfo.getName(), false);
        } else if (this.mHotSearchInfo.getType() == 1 && !com.baidu.tbadk.plugins.b.k(getPageContext())) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new aq("c10355").dR("obj_name", this.mHotSearchInfo.getName()).al("obj_type", this.mHotSearchInfo.getType() == 0 ? 2 : 1));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.home_dialog_search);
        init();
        getWindow().setSoftInputMode(1);
        registerListener(this.kMO);
        registerListener(this.kMN);
        registerListener(this.kMc);
        registerListener(this.htmlLoadMessageListener);
        if (SquareSearchActivityConfig.IS_SHOW_RECOMMEND_FORUM) {
            this.kLZ = new HotForumModel(getPageContext(), this);
            this.kLZ.dbg();
        }
        this.kMB = false;
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
        hideLoadingView(this.kMn);
        this.mHandler.removeCallbacks(this.kML);
        dbk();
    }

    public void dbk() {
        this.mHandler.removeCallbacks(this.kMM);
        if (this.kMz != null) {
            this.kMz.cancel();
            this.kMz = null;
        }
    }

    private void init() {
        this.kMm = (LinearLayoutDetectsSoftKeyboard) findViewById(R.id.parent);
        this.kMm.setOnSoftKeyBoardShownListener(new LinearLayoutDetectsSoftKeyboard.a() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.24
            @Override // com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard.a
            public void cL(boolean z) {
                SquareSearchActivity.this.kMC = z;
            }
        });
        this.kMm.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.25
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    SquareSearchActivity.this.kMm.setFocusable(true);
                    SquareSearchActivity.this.kMm.setFocusableInTouchMode(true);
                    if (SquareSearchActivity.this.itS.hasFocus()) {
                        l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.itS);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        bCV();
        this.kMn = (FrameLayout) findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), null, null);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            this.kMD = (ScrollView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.home_searchbar_nodataview, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) this.kMD.findViewById(R.id.focusbar_nodata_root);
            this.kME = (SearchPageFocusBar) linearLayout.findViewById(R.id.no_data_focusbar);
            linearLayout.addView(this.mNoDataView, 0);
            this.kMD.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.26
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.kMD);
                    return false;
                }
            });
            this.kMn.addView(this.kMD, this.kMn.getChildCount());
        } else {
            this.kMn.addView(this.mNoDataView, 0);
        }
        this.kMo = (FrameLayout) findViewById(R.id.home_search_list);
        dbr();
        dbm();
        dbn();
        dbo();
        this.kMp = (BaseWebView) findViewById(R.id.search_result_webview);
        this.kMp.initCommonJsBridge(getPageContext().getPageActivity());
        this.kMp.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.27
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
                if (SquareSearchActivity.this.isProgressBarShown()) {
                    SquareSearchActivity.this.hideProgressBar();
                }
            }
        });
        this.kMp.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.28
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedError", 0, "", "requesturl", str2, "receiveerror", Integer.valueOf(i), "description", str);
            }
        });
        this.kMp.setOnReceivedSslErrorListener(new BaseWebView.g() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.g
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                if (sslError != null) {
                    com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedSslError", 0, "", "requesturl", sslError.getUrl(), "receiveerror", sslError.toString());
                }
            }
        });
        this.kMp.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.3
            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.mainentrance.SquareSearchActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return be.brr().a(SquareSearchActivity.this.getPageContext(), new String[]{str}) != 3;
            }
        });
        this.itS.setText("");
        this.itS.requestFocus();
        ShowSoftKeyPadDelay(this.itS, 200);
        dbp();
        dbq();
    }

    private void bCV() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.gEO = (ImageView) addCustomView.findViewById(R.id.search_bar_icon);
        this.itS = (EditText) addCustomView.findViewById(R.id.home_et_search);
        this.hQY = (ImageView) addCustomView.findViewById(R.id.home_bt_search_del);
        this.hQZ = (TextView) addCustomView.findViewById(R.id.home_bt_search_cancel_s);
        this.itS.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    SquareSearchActivity.this.dbl();
                } else {
                    l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.itS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.dbl();
            }
        });
        this.hQZ.setText(getPageContext().getString(R.string.cancel));
        this.hQZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.itS);
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SquareSearchActivity.this.finish();
                    }
                }, 200L);
            }
        });
        this.itS.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.7
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (SquareSearchActivity.this.iFd == null || SquareSearchActivity.this.iFd.trim().length() < 1) {
                        l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.itS);
                        if (SquareSearchActivity.this.dbj()) {
                            return true;
                        }
                        SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(R.string.write_keyword));
                        return true;
                    }
                    String trim = SquareSearchActivity.this.itS.getText().toString().trim();
                    if (!StringUtils.isNull(trim)) {
                        SquareSearchActivity.this.aT(trim, false);
                        return true;
                    }
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(R.string.write_keyword));
                    return true;
                }
                return false;
            }
        });
        this.hQY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.itS.setText("");
            }
        });
        this.itS.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.9
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SquareSearchActivity.this.kMJ) {
                    SquareSearchActivity.this.iFd = editable.toString();
                    if (StringUtils.isNull(SquareSearchActivity.this.iFd)) {
                        SquareSearchActivity.this.kMI = true;
                    }
                    SquareSearchActivity.this.dbu();
                }
                if (editable.toString().trim().length() == 0) {
                    SquareSearchActivity.this.hQY.setVisibility(8);
                } else {
                    SquareSearchActivity.this.hQY.setVisibility(0);
                }
                ap.setViewTextColor(SquareSearchActivity.this.hQZ, R.color.cp_link_tip_a, 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbl() {
        if (StringUtils.isNull(this.itS.getText().toString())) {
            if (this.kMq.getVisibility() != 0) {
                dbs();
            }
        } else if (this.kMv.getVisibility() != 0) {
            dbu();
        }
    }

    private void dbm() {
        this.kMq = (ScrollView) findViewById(R.id.search_history_scrollview);
        this.kMr = (LinearLayout) findViewById(R.id.search_history_linearlayout);
        if (this.kMu == null) {
            this.kMu = new LinearLayout(getPageContext().getPageActivity());
            this.kMu.setOrientation(1);
            this.kMu.setBackgroundColor(ap.getColor(R.color.cp_bg_line_d));
        }
        this.kMr.addView(this.kMu);
    }

    private void dbn() {
        if (this.kMt == null) {
            this.kMt = new g(getPageContext());
            this.kMr.addView(this.kMt.createView());
        }
    }

    private void dbo() {
        this.kMv = (BdListView) findViewById(R.id.home_lv_search_suggest);
        this.kMw = new com.baidu.tieba.mainentrance.a(this, null);
        this.kMx = new com.baidu.tieba.mainentrance.searchSuggestList.b(getPageContext().getPageActivity(), null);
        this.kMv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.10
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ListAdapter adapter;
                ListView listView = (ListView) adapterView;
                if (listView != null && (adapter = listView.getAdapter()) != null && adapter.getCount() != 0 && i < adapter.getCount()) {
                    Object item = adapter.getItem(i);
                    if (item instanceof String) {
                        SquareSearchActivity.this.aT((String) item, true);
                        TiebaStatic.eventStat(SquareSearchActivity.this.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
                    }
                }
            }
        });
        this.kMv.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.11
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

    public void dbp() {
        this.hQZ.setText(getPageContext().getString(R.string.cancel));
        dbq();
        dbk();
        dbv();
        if (this.iFd.trim().length() > 0) {
            dbu();
        } else {
            dbs();
        }
    }

    private void dbq() {
        if (this.mHotSearchInfo == null) {
            this.itS.setHint(R.string.search_bar);
        } else {
            this.itS.setHint(" " + UtilHelper.getFixedText(this.mHotSearchInfo.cra(), 15));
        }
    }

    private void dbr() {
        HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.bqh().getString(SharedPrefConfig.HOT_SEARCH_INFO, ""), HotSearchInfoData.class);
        if (hotSearchInfoData != null && hotSearchInfoData.getId() != 0) {
            this.mHotSearchInfo = hotSearchInfoData;
        }
    }

    private void dbs() {
        this.kMp.setVisibility(8);
        this.kMv.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA));
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            ta(true);
            dd(this.kME);
            dd(this.kMD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO(ArrayList<String> arrayList) {
        NoDataViewFactory.d pQ;
        if (aQ(arrayList)) {
            dbz();
            if (j.isNetWorkAvailable()) {
                pQ = NoDataViewFactory.d.pQ(R.string.text_no_search_record);
            } else {
                pQ = NoDataViewFactory.d.pQ(R.string.neterror);
            }
            this.mNoDataView.setTextOption(pQ);
            return;
        }
        dby();
        aP(arrayList);
        ak(true, arrayList == null || arrayList.size() == 0);
        dbq();
    }

    private void aP(final ArrayList<String> arrayList) {
        if (this.kMu != null) {
            this.kMu.removeAllViews();
            if (arrayList != null && !arrayList.isEmpty() && getActivity() != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                this.kMF = LayoutInflater.from(pageActivity).inflate(R.layout.square_search_recommand_fourm_header, (ViewGroup) null);
                this.kMF.findViewById(R.id.titleTopDivider).setVisibility(8);
                getLayoutMode().onModeChanged(this.kMF);
                this.kMu.addView(this.kMF, layoutParams);
                int size = arrayList.size();
                this.kMH.clear();
                for (int i = 0; i < size; i++) {
                    final String str = arrayList.get(i);
                    if (!TextUtils.isEmpty(str)) {
                        final View inflate = LayoutInflater.from(pageActivity).inflate(R.layout.home_dialog_search_item, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.home_lv_search_forum)).setText(str);
                        ap.setViewTextColor((TextView) inflate.findViewById(R.id.home_lv_search_forum), R.color.cp_cont_b, 1);
                        inflate.findViewById(R.id.home_dialog_lv_search_forum_divider).setVisibility(8);
                        ap.setBackgroundResource(inflate, R.drawable.square_search_item_bg);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        inflate.setOnClickListener(new b(str));
                        ImageView imageView = (ImageView) inflate.findViewById(R.id.del_search_history_btn);
                        ap.setImageResource(imageView, R.drawable.icn_shop_order_close);
                        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                ae.a(new ad<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // com.baidu.tbadk.util.ad
                                    public Boolean doInBackground() {
                                        com.baidu.tieba.tbadkCore.util.a.SX(str);
                                        return true;
                                    }
                                }, new m<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.2
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.tbadk.util.m
                                    public void onReturnDataInUI(Boolean bool) {
                                        SquareSearchActivity.this.kMu.removeView(inflate);
                                        arrayList.remove(str);
                                        if (arrayList.size() <= 0) {
                                            SquareSearchActivity.this.aO(null);
                                        }
                                    }
                                });
                            }
                        });
                        this.kMH.add(inflate);
                        this.kMu.addView(inflate, layoutParams2);
                    }
                }
                this.kMG = LayoutInflater.from(pageActivity).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
                ((TextView) this.kMG.findViewById(R.id.home_bt_search_footer)).setTextColor(ap.getColor(R.color.cp_link_tip_a));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                this.kMG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SquareSearchActivity.this.dbt();
                    }
                });
                this.kMu.addView(this.kMG, layoutParams3);
            }
        }
    }

    private void ak(boolean z, boolean z2) {
        if (this.kMt != null) {
            this.kMt.clear();
            if (this.kMs != null && !this.kMs.isEmpty() && z) {
                this.kMt.sZ(!z2);
                this.kMt.setTitleText(this.mTopicInfoTitle);
                int size = this.kMs.size();
                if (size >= 1) {
                    if (size > 7) {
                        size = 7;
                    }
                    int i = size % 2 == 0 ? size - 1 : size;
                    for (int i2 = 0; i2 < i; i2++) {
                        c cVar = (c) y.getItem(this.kMs, i2);
                        if (cVar != null) {
                            this.kMt.a(cVar, i2).setOnClickListener(this.kMP);
                        }
                    }
                    this.kMt.a(null, i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.16
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.itS);
                            if (!com.baidu.tbadk.plugins.b.k(SquareSearchActivity.this.getPageContext())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all")));
                            }
                        }
                    });
                    this.kMt.show();
                }
            }
        }
    }

    private boolean aQ(ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && (this.kMs == null || this.kMs.size() <= 2) && this.kMB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbt() {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).Bo(getPageContext().getString(R.string.alert_clean_history)).a(getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                h.mZ().submitTask(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.dKQ();
                    }
                });
                if (SquareSearchActivity.this.kMs == null || SquareSearchActivity.this.kMs.size() < 2) {
                    SquareSearchActivity.this.dc(SquareSearchActivity.this.kMD);
                    SquareSearchActivity.this.dc(SquareSearchActivity.this.kME);
                    SquareSearchActivity.this.kMo.setVisibility(8);
                    SquareSearchActivity.this.mNoDataView.setVisibility(0);
                    SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.pQ(R.string.text_no_search_record));
                    return;
                }
                SquareSearchActivity.this.aO(null);
            }
        }).b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.17
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        }).b(getPageContext()).bpc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbu() {
        if (this.iFd.trim().length() > 0) {
            dbw();
            return;
        }
        dbk();
        dbs();
    }

    private void dbv() {
        if (this.kMv != null) {
            this.kMv.setNextPage(null);
        }
    }

    private void dbw() {
        if (!StringUtils.isNull(this.iFd)) {
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.iFd.trim();
            sendMessage(searchListNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        try {
            if (this.kMy != null) {
                if (this.kMy.forum_list != null && this.kMy.forum_list.size() > 0) {
                    dbx();
                    this.kMv.setAdapter((ListAdapter) this.kMw);
                    this.kMw.NW(this.iFd);
                    this.kMw.aN(this.kMy.forum_list);
                    this.kMw.notifyDataSetInvalidated();
                } else {
                    dd(this.kMD);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbx() {
        this.kMo.setVisibility(0);
        this.kMv.setVisibility(0);
        this.kMq.setVisibility(8);
        this.kMp.setVisibility(8);
        dd(this.kMD);
        this.mNoDataView.setVisibility(8);
    }

    private void dby() {
        this.kMo.setVisibility(0);
        this.kMq.setVisibility(0);
        this.kMv.setVisibility(8);
        this.kMp.setVisibility(8);
        dd(this.kMD);
        this.mNoDataView.setVisibility(8);
    }

    private void dbz() {
        this.kMo.setVisibility(8);
        this.kMv.setVisibility(8);
        this.kMq.setVisibility(8);
        this.kMp.setVisibility(8);
        dc(this.kMD);
        this.mNoDataView.setVisibility(0);
        dc(this.kME);
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void NX(String str) {
        this.kMB = true;
        this.kMs = new ArrayList();
        dbs();
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void a(List<com.baidu.tieba.mainentrance.b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str) {
        this.kMB = true;
        hideLoadingView(this.kMn);
        if (list2 == null) {
            this.kMs = new ArrayList();
        } else {
            this.kMs = list2;
        }
        if (!StringUtils.isNULL(str)) {
            this.mTopicInfoTitle = str;
        } else {
            this.mTopicInfoTitle = "";
        }
        a(hotSearchInfoData);
        this.mHotSearchInfo = hotSearchInfoData;
        dbs();
    }

    private void a(HotSearchInfoData hotSearchInfoData) {
        if (hotSearchInfoData != null) {
            com.baidu.tbadk.core.sharedPref.b.bqh().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData));
            return;
        }
        HotSearchInfoData hotSearchInfoData2 = new HotSearchInfoData();
        hotSearchInfoData2.setId(0L);
        hotSearchInfoData2.setName("");
        hotSearchInfoData2.NY("");
        hotSearchInfoData2.setType(0L);
        com.baidu.tbadk.core.sharedPref.b.bqh().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData2));
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
        getLayoutMode().onModeChanged(this.kMm);
        ap.setBgColor(this.kMm, i);
        if (this.kMw != null) {
            this.kMw.notifyDataSetChanged();
        }
        if (i == 2) {
            this.itS.setHintTextColor(ap.getColor(R.color.s_navbar_title_color));
        } else {
            this.itS.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        }
        SvgManager.brn().a(this.hQY, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setNavbarTitleColor(this.itS, R.color.cp_cont_b, R.color.s_navbar_title_color);
        SvgManager.brn().a(this.gEO, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        ap.setBackgroundResource(this.kMn, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.hQZ, R.color.cp_link_tip_a, 1);
        if (this.kMt != null) {
            this.kMt.onChangeSkinType(i);
        }
        Et(i);
    }

    private void Et(int i) {
        if (this.kMu != null) {
            this.kMu.setBackgroundColor(ap.getColor(R.color.cp_bg_line_d));
        }
        if (this.kMF != null) {
            getLayoutMode().onModeChanged(this.kMF);
        }
        if (this.kMG != null) {
            ((TextView) this.kMG.findViewById(R.id.home_bt_search_footer)).setTextColor(ap.getColor(R.color.cp_link_tip_a));
        }
        if (this.kMH != null) {
            for (View view : this.kMH) {
                ap.setViewTextColor((TextView) view.findViewById(R.id.home_lv_search_forum), R.color.cp_cont_b, 1);
                view.findViewById(R.id.home_dialog_lv_search_forum_divider).setBackgroundColor(ap.getColor(R.color.cp_bg_line_c));
                ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (i == 4 && this.kMp.canGoBack()) {
                this.kMp.goBack();
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
            com.baidu.tbadk.core.e.b.r(getPageContext().getPageActivity(), 1);
        } else {
            com.baidu.tbadk.core.e.b.r(getPageContext().getPageActivity(), 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        setSkinType(3);
        if (this.mNoDataView != null) {
            this.mNoDataView.bso();
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
                SquareSearchActivity.this.iFd = this.mName;
                TiebaStatic.log(new aq("c12034"));
                SquareSearchActivity.this.aT(this.mName, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dbA() {
        if (!j.isNetWorkAvailable()) {
            dc(this.mNoDataView);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.pQ(R.string.neterror));
            return true;
        }
        dd(this.mNoDataView);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class a extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
        private BasicNameValuePair kMX;
        private aa mNetwork = null;
        private String mUrl;

        public a(String str, BasicNameValuePair basicNameValuePair, boolean z) {
            this.mUrl = null;
            this.kMX = null;
            this.mUrl = str;
            this.kMX = basicNameValuePair;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!SquareSearchActivity.this.dbA()) {
                SquareSearchActivity.this.dd(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.kMn, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(R.dimen.ds320));
                SquareSearchActivity.this.kMo.setVisibility(8);
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
                    this.mNetwork.addPostData(this.kMX);
                    String postNetData = this.mNetwork.postNetData();
                    if (postNetData != null) {
                        forumSuggestModel = ForumSuggestModel.parserJson(postNetData);
                        SquareSearchActivity.this.kMA = this.kMX.getValue();
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
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.kMn);
            if (forumSuggestModel != null) {
                SquareSearchActivity.this.dd(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.kMy = forumSuggestModel;
                SquareSearchActivity.this.refresh();
            } else {
                SquareSearchActivity.this.dc(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.pQ(R.string.text_no_search_record));
            }
            SquareSearchActivity.this.kMz = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.kMn);
            super.cancel(true);
        }
    }

    private void ta(boolean z) {
        if (TbadkCoreApplication.isLogin()) {
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(CmdConfigCustom.CMD_REQUEST_ENTER_FORUM_MESSAGE, true));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(CmdConfigCustom.CMD_REQUEST_ENTER_FORUM_MESSAGE, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dc(View view) {
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dd(View view) {
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SEARCH_RESULT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aT(final String str, boolean z) {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.kMJ = false;
                this.itS.setText(str);
                this.itS.setSelection(str.length());
                this.kMJ = true;
            }
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.itS);
            this.kMq.setVisibility(8);
            this.kMv.setVisibility(8);
            this.kMp.setVisibility(0);
            showProgressBarWithOffset(0, 0);
            String str2 = TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + TbConfig.SQUARE_SEARCH_PAGE + str;
            try {
                str2 = TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            this.kMp.loadUrl(str2);
            ae.a(new ad<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ad
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.SV(str);
                    return true;
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NZ(String str) {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (!StringUtils.isNull(str)) {
            this.kMK = str;
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CREATE_BAR)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), str)));
            }
        }
    }
}
