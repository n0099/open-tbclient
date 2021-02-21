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
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.af;
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
/* loaded from: classes8.dex */
public class SquareSearchActivity extends BaseActivity<SquareSearchActivity> implements HotForumModel.a {
    private ImageView fgA;
    private ImageView gXw;
    private EditText iTa;
    private TextView iqh;
    private String jel;
    private HotForumModel liW;
    private ScrollView ljA;
    private SearchPageFocusBar ljB;
    private View ljC;
    private View ljD;
    private String ljH;
    private LinearLayoutDetectsSoftKeyboard ljj;
    private FrameLayout ljk;
    private FrameLayout ljl;
    private BaseWebView ljm;
    private ScrollView ljn;
    private LinearLayout ljo;
    private List<c> ljp;
    private g ljq;
    private LinearLayout ljr;
    private BdListView ljs;
    private com.baidu.tieba.mainentrance.a ljt;
    private com.baidu.tieba.mainentrance.searchSuggestList.b lju;
    private ForumSuggestModel ljv;
    private a ljw;
    private String ljx;
    private boolean ljy;
    private HotSearchInfoData mHotSearchInfo;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mTopicInfoTitle;
    private boolean ljz = true;
    private List<View> ljE = new ArrayList();
    private boolean liU = false;
    private boolean ljF = true;
    private boolean ljG = true;
    private Runnable ljI = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.1
        @Override // java.lang.Runnable
        public void run() {
            SquareSearchActivity.this.iTa.requestFocus();
            l.showSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.iTa);
        }
    };
    private final Runnable ljJ = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.12
        @Override // java.lang.Runnable
        public void run() {
            if (!SquareSearchActivity.this.dek()) {
                try {
                    if (SquareSearchActivity.this.jel != null && SquareSearchActivity.this.jel.length() > 0) {
                        StringBuffer stringBuffer = new StringBuffer(30);
                        stringBuffer.append(TbConfig.SERVER_ADDRESS);
                        stringBuffer.append(Config.SUGGEST_BAR_ADDRESS);
                        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", SquareSearchActivity.this.jel.trim());
                        SquareSearchActivity.this.ddU();
                        SquareSearchActivity.this.ljw = new a(stringBuffer.toString(), basicNameValuePair, true);
                        SquareSearchActivity.this.ljw.setPriority(3);
                        SquareSearchActivity.this.ljw.execute(stringBuffer.toString(), basicNameValuePair);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a ljK = new com.baidu.adp.framework.listener.a(1003196, CmdConfigSocket.CMD_SEARCH_LIST) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.22
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = ((responsedMessage instanceof SearchListHttpResMessage) || (responsedMessage instanceof SearchListSocketResMessage)) ? false : true;
            if (responsedMessage == null || z || responsedMessage.getError() != 0 || responsedMessage.hasError()) {
                if (j.isNetWorkAvailable() || !SquareSearchActivity.this.liU) {
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(R.string.neterror));
                }
                if (!j.isNetWorkAvailable()) {
                    SquareSearchActivity.this.liU = true;
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
            if (SquareSearchActivity.this.ljF && responsedMessage.getError() != 0) {
                SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(R.string.neterror));
                return;
            }
            if (list != null && list.size() > 0) {
                SquareSearchActivity.this.ljF = false;
            }
            SquareSearchActivity.this.deh();
            SquareSearchActivity.this.ljs.setAdapter((ListAdapter) SquareSearchActivity.this.lju);
            SquareSearchActivity.this.lju.NQ(SquareSearchActivity.this.jel.trim());
            SquareSearchActivity.this.lju.setData(list);
            SquareSearchActivity.this.lju.notifyDataSetInvalidated();
        }
    };
    private CustomMessageListener liZ = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_CREATE_BAR) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                SquareSearchActivity.this.NT(customResponsedMessage.getData().toString());
            }
        }
    };
    private CustomMessageListener ljL = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof ArrayList) {
                    SquareSearchActivity.this.aL((ArrayList) data);
                }
            }
        }
    };
    private View.OnClickListener ljM = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.iTa);
            if (view.getTag() instanceof c) {
                c cVar = (c) view.getTag();
                TiebaStatic.log(new ar("c10363").dR("obj_name", cVar.getName()));
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
                if (SquareSearchActivity.this.ljm.getUrl() != null && SquareSearchActivity.this.ljm.getUrl().contains(str)) {
                    SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.ljk);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ddT() {
        if (this.mHotSearchInfo == null) {
            return false;
        }
        if (this.mHotSearchInfo.getType() == 0) {
            aT(this.mHotSearchInfo.getName(), false);
        } else if (this.mHotSearchInfo.getType() == 1 && !com.baidu.tbadk.plugins.b.k(getPageContext())) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new ar("c10355").dR("obj_name", this.mHotSearchInfo.getName()).ap("obj_type", this.mHotSearchInfo.getType() == 0 ? 2 : 1));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.home_dialog_search);
        init();
        getWindow().setSoftInputMode(1);
        registerListener(this.ljL);
        registerListener(this.ljK);
        registerListener(this.liZ);
        registerListener(this.htmlLoadMessageListener);
        if (SquareSearchActivityConfig.IS_SHOW_RECOMMEND_FORUM) {
            this.liW = new HotForumModel(getPageContext(), this);
            this.liW.ddQ();
        }
        this.ljy = false;
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
        hideLoadingView(this.ljk);
        this.mHandler.removeCallbacks(this.ljI);
        ddU();
    }

    public void ddU() {
        this.mHandler.removeCallbacks(this.ljJ);
        if (this.ljw != null) {
            this.ljw.cancel();
            this.ljw = null;
        }
    }

    private void init() {
        this.ljj = (LinearLayoutDetectsSoftKeyboard) findViewById(R.id.parent);
        this.ljj.setOnSoftKeyBoardShownListener(new LinearLayoutDetectsSoftKeyboard.a() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.24
            @Override // com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard.a
            public void di(boolean z) {
                SquareSearchActivity.this.ljz = z;
            }
        });
        this.ljj.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.25
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    SquareSearchActivity.this.ljj.setFocusable(true);
                    SquareSearchActivity.this.ljj.setFocusableInTouchMode(true);
                    if (SquareSearchActivity.this.iTa.hasFocus()) {
                        l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.iTa);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        bEL();
        this.ljk = (FrameLayout) findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), null, null);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            this.ljA = (ScrollView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.home_searchbar_nodataview, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) this.ljA.findViewById(R.id.focusbar_nodata_root);
            this.ljB = (SearchPageFocusBar) linearLayout.findViewById(R.id.no_data_focusbar);
            linearLayout.addView(this.mNoDataView, 0);
            this.ljA.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.26
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.ljA);
                    return false;
                }
            });
            this.ljk.addView(this.ljA, this.ljk.getChildCount());
        } else {
            this.ljk.addView(this.mNoDataView, 0);
        }
        this.ljl = (FrameLayout) findViewById(R.id.home_search_list);
        deb();
        ddW();
        ddX();
        ddY();
        this.ljm = (BaseWebView) findViewById(R.id.search_result_webview);
        this.ljm.initCommonJsBridge(getPageContext().getPageActivity());
        this.ljm.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.27
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
                if (SquareSearchActivity.this.isProgressBarShown()) {
                    SquareSearchActivity.this.hideProgressBar();
                }
            }
        });
        this.ljm.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.28
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedError", 0, "", "requesturl", str2, "receiveerror", Integer.valueOf(i), "description", str);
            }
        });
        this.ljm.setOnReceivedSslErrorListener(new BaseWebView.g() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.g
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                if (sslError != null) {
                    com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedSslError", 0, "", "requesturl", sslError.getUrl(), "receiveerror", sslError.toString());
                }
            }
        });
        this.ljm.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.3
            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.mainentrance.SquareSearchActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return bf.bsV().a(SquareSearchActivity.this.getPageContext(), new String[]{str}) != 3;
            }
        });
        this.iTa.setText("");
        this.iTa.requestFocus();
        ShowSoftKeyPadDelay(this.iTa, 200);
        ddZ();
        dea();
    }

    private void bEL() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.gXw = (ImageView) addCustomView.findViewById(R.id.search_bar_icon);
        this.iTa = (EditText) addCustomView.findViewById(R.id.home_et_search);
        this.fgA = (ImageView) addCustomView.findViewById(R.id.home_bt_search_del);
        this.iqh = (TextView) addCustomView.findViewById(R.id.home_bt_search_cancel_s);
        this.iTa.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    SquareSearchActivity.this.ddV();
                } else {
                    l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.iTa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.ddV();
            }
        });
        this.iqh.setText(getPageContext().getString(R.string.cancel));
        this.iqh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.iTa);
                com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SquareSearchActivity.this.finish();
                    }
                }, 200L);
            }
        });
        this.iTa.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.7
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (SquareSearchActivity.this.jel == null || SquareSearchActivity.this.jel.trim().length() < 1) {
                        l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.iTa);
                        if (SquareSearchActivity.this.ddT()) {
                            return true;
                        }
                        SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(R.string.write_keyword));
                        return true;
                    }
                    String trim = SquareSearchActivity.this.iTa.getText().toString().trim();
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
        this.fgA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.iTa.setText("");
            }
        });
        this.iTa.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.9
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SquareSearchActivity.this.ljG) {
                    SquareSearchActivity.this.jel = editable.toString();
                    if (StringUtils.isNull(SquareSearchActivity.this.jel)) {
                        SquareSearchActivity.this.ljF = true;
                    }
                    SquareSearchActivity.this.dee();
                }
                if (editable.toString().trim().length() == 0) {
                    SquareSearchActivity.this.fgA.setVisibility(8);
                } else {
                    SquareSearchActivity.this.fgA.setVisibility(0);
                }
                ap.setViewTextColor(SquareSearchActivity.this.iqh, R.color.CAM_X0302, 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddV() {
        if (StringUtils.isNull(this.iTa.getText().toString())) {
            if (this.ljn.getVisibility() != 0) {
                dec();
            }
        } else if (this.ljs.getVisibility() != 0) {
            dee();
        }
    }

    private void ddW() {
        this.ljn = (ScrollView) findViewById(R.id.search_history_scrollview);
        this.ljo = (LinearLayout) findViewById(R.id.search_history_linearlayout);
        if (this.ljr == null) {
            this.ljr = new LinearLayout(getPageContext().getPageActivity());
            this.ljr.setOrientation(1);
            this.ljr.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
        }
        this.ljo.addView(this.ljr);
    }

    private void ddX() {
        if (this.ljq == null) {
            this.ljq = new g(getPageContext());
            this.ljo.addView(this.ljq.createView());
        }
    }

    private void ddY() {
        this.ljs = (BdListView) findViewById(R.id.home_lv_search_suggest);
        this.ljt = new com.baidu.tieba.mainentrance.a(this, null);
        this.lju = new com.baidu.tieba.mainentrance.searchSuggestList.b(getPageContext().getPageActivity(), null);
        this.ljs.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.10
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
        this.ljs.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.11
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

    public void ddZ() {
        this.iqh.setText(getPageContext().getString(R.string.cancel));
        dea();
        ddU();
        def();
        if (this.jel.trim().length() > 0) {
            dee();
        } else {
            dec();
        }
    }

    private void dea() {
        if (this.mHotSearchInfo == null) {
            this.iTa.setHint(R.string.search_bar);
        } else {
            this.iTa.setHint(" " + UtilHelper.getFixedText(this.mHotSearchInfo.cvn(), 15));
        }
    }

    private void deb() {
        HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.brQ().getString(SharedPrefConfig.HOT_SEARCH_INFO, ""), HotSearchInfoData.class);
        if (hotSearchInfoData != null && hotSearchInfoData.getId() != 0) {
            this.mHotSearchInfo = hotSearchInfoData;
        }
    }

    private void dec() {
        this.ljm.setVisibility(8);
        this.ljs.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA));
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            tQ(true);
            dw(this.ljB);
            dw(this.ljA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL(ArrayList<String> arrayList) {
        NoDataViewFactory.d pz;
        if (aN(arrayList)) {
            dej();
            if (j.isNetWorkAvailable()) {
                pz = NoDataViewFactory.d.pz(R.string.text_no_search_record);
            } else {
                pz = NoDataViewFactory.d.pz(R.string.neterror);
            }
            this.mNoDataView.setTextOption(pz);
            return;
        }
        dei();
        aM(arrayList);
        am(true, arrayList == null || arrayList.size() == 0);
        dea();
    }

    private void aM(final ArrayList<String> arrayList) {
        if (this.ljr != null) {
            this.ljr.removeAllViews();
            if (arrayList != null && !arrayList.isEmpty() && getActivity() != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                this.ljC = LayoutInflater.from(pageActivity).inflate(R.layout.square_search_recommand_fourm_header, (ViewGroup) null);
                this.ljC.findViewById(R.id.titleTopDivider).setVisibility(8);
                getLayoutMode().onModeChanged(this.ljC);
                this.ljr.addView(this.ljC, layoutParams);
                int size = arrayList.size();
                this.ljE.clear();
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
                                af.a(new ae<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // com.baidu.tbadk.util.ae
                                    public Boolean doInBackground() {
                                        com.baidu.tieba.tbadkCore.util.a.TI(str);
                                        return true;
                                    }
                                }, new m<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.2
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.tbadk.util.m
                                    public void onReturnDataInUI(Boolean bool) {
                                        SquareSearchActivity.this.ljr.removeView(inflate);
                                        arrayList.remove(str);
                                        if (arrayList.size() <= 0) {
                                            SquareSearchActivity.this.aL(null);
                                        }
                                    }
                                });
                            }
                        });
                        this.ljE.add(inflate);
                        this.ljr.addView(inflate, layoutParams2);
                    }
                }
                this.ljD = LayoutInflater.from(pageActivity).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
                ((TextView) this.ljD.findViewById(R.id.home_bt_search_footer)).setTextColor(ap.getColor(R.color.CAM_X0302));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                this.ljD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SquareSearchActivity.this.ded();
                    }
                });
                this.ljr.addView(this.ljD, layoutParams3);
            }
        }
    }

    private void am(boolean z, boolean z2) {
        if (this.ljq != null) {
            this.ljq.clear();
            if (this.ljp != null && !this.ljp.isEmpty() && z) {
                this.ljq.tP(!z2);
                this.ljq.setTitleText(this.mTopicInfoTitle);
                int size = this.ljp.size();
                if (size >= 1) {
                    if (size > 7) {
                        size = 7;
                    }
                    int i = size % 2 == 0 ? size - 1 : size;
                    for (int i2 = 0; i2 < i; i2++) {
                        c cVar = (c) y.getItem(this.ljp, i2);
                        if (cVar != null) {
                            this.ljq.a(cVar, i2).setOnClickListener(this.ljM);
                        }
                    }
                    this.ljq.a(null, i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.16
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.iTa);
                            if (!com.baidu.tbadk.plugins.b.k(SquareSearchActivity.this.getPageContext())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all")));
                            }
                        }
                    });
                    this.ljq.show();
                }
            }
        }
    }

    private boolean aN(ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && (this.ljp == null || this.ljp.size() <= 2) && this.ljy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ded() {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).Au(getPageContext().getString(R.string.alert_clean_history)).a(getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                h.mB().submitTask(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.dOG();
                    }
                });
                if (SquareSearchActivity.this.ljp == null || SquareSearchActivity.this.ljp.size() < 2) {
                    SquareSearchActivity.this.dv(SquareSearchActivity.this.ljA);
                    SquareSearchActivity.this.dv(SquareSearchActivity.this.ljB);
                    SquareSearchActivity.this.ljl.setVisibility(8);
                    SquareSearchActivity.this.mNoDataView.setVisibility(0);
                    SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.pz(R.string.text_no_search_record));
                    return;
                }
                SquareSearchActivity.this.aL(null);
            }
        }).b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.17
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        }).b(getPageContext()).bqx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dee() {
        if (this.jel.trim().length() > 0) {
            deg();
            return;
        }
        ddU();
        dec();
    }

    private void def() {
        if (this.ljs != null) {
            this.ljs.setNextPage(null);
        }
    }

    private void deg() {
        if (!StringUtils.isNull(this.jel)) {
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.jel.trim();
            sendMessage(searchListNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        try {
            if (this.ljv != null) {
                if (this.ljv.forum_list != null && this.ljv.forum_list.size() > 0) {
                    deh();
                    this.ljs.setAdapter((ListAdapter) this.ljt);
                    this.ljt.NQ(this.jel);
                    this.ljt.aK(this.ljv.forum_list);
                    this.ljt.notifyDataSetInvalidated();
                } else {
                    dw(this.ljA);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deh() {
        this.ljl.setVisibility(0);
        this.ljs.setVisibility(0);
        this.ljn.setVisibility(8);
        this.ljm.setVisibility(8);
        dw(this.ljA);
        this.mNoDataView.setVisibility(8);
    }

    private void dei() {
        this.ljl.setVisibility(0);
        this.ljn.setVisibility(0);
        this.ljs.setVisibility(8);
        this.ljm.setVisibility(8);
        dw(this.ljA);
        this.mNoDataView.setVisibility(8);
    }

    private void dej() {
        this.ljl.setVisibility(8);
        this.ljs.setVisibility(8);
        this.ljn.setVisibility(8);
        this.ljm.setVisibility(8);
        dv(this.ljA);
        this.mNoDataView.setVisibility(0);
        dv(this.ljB);
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void NR(String str) {
        this.ljy = true;
        this.ljp = new ArrayList();
        dec();
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void a(List<com.baidu.tieba.mainentrance.b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str) {
        this.ljy = true;
        hideLoadingView(this.ljk);
        if (list2 == null) {
            this.ljp = new ArrayList();
        } else {
            this.ljp = list2;
        }
        if (!StringUtils.isNULL(str)) {
            this.mTopicInfoTitle = str;
        } else {
            this.mTopicInfoTitle = "";
        }
        a(hotSearchInfoData);
        this.mHotSearchInfo = hotSearchInfoData;
        dec();
    }

    private void a(HotSearchInfoData hotSearchInfoData) {
        if (hotSearchInfoData != null) {
            com.baidu.tbadk.core.sharedPref.b.brQ().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData));
            return;
        }
        HotSearchInfoData hotSearchInfoData2 = new HotSearchInfoData();
        hotSearchInfoData2.setId(0L);
        hotSearchInfoData2.setName("");
        hotSearchInfoData2.NS("");
        hotSearchInfoData2.setType(0L);
        com.baidu.tbadk.core.sharedPref.b.brQ().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData2));
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
        getLayoutMode().onModeChanged(this.ljj);
        ap.setBgColor(this.ljj, i);
        if (this.ljt != null) {
            this.ljt.notifyDataSetChanged();
        }
        if (i == 2) {
            this.iTa.setHintTextColor(ap.getColor(R.color.s_navbar_title_color));
        } else {
            this.iTa.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        }
        SvgManager.bsR().a(this.fgA, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setNavbarTitleColor(this.iTa, R.color.CAM_X0105, R.color.s_navbar_title_color);
        SvgManager.bsR().a(this.gXw, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        ap.setBackgroundResource(this.ljk, R.color.CAM_X0201);
        ap.setViewTextColor(this.iqh, R.color.CAM_X0302, 1);
        if (this.ljq != null) {
            this.ljq.onChangeSkinType(i);
        }
        Em(i);
    }

    private void Em(int i) {
        if (this.ljr != null) {
            this.ljr.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
        }
        if (this.ljC != null) {
            getLayoutMode().onModeChanged(this.ljC);
        }
        if (this.ljD != null) {
            ((TextView) this.ljD.findViewById(R.id.home_bt_search_footer)).setTextColor(ap.getColor(R.color.CAM_X0302));
        }
        if (this.ljE != null) {
            for (View view : this.ljE) {
                ap.setViewTextColor((TextView) view.findViewById(R.id.home_lv_search_forum), R.color.CAM_X0105, 1);
                view.findViewById(R.id.home_dialog_lv_search_forum_divider).setBackgroundColor(ap.getColor(R.color.CAM_X0204));
                ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (i == 4 && this.ljm.canGoBack()) {
                this.ljm.goBack();
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
            com.baidu.tbadk.core.e.b.B(getPageContext().getPageActivity(), 1);
        } else {
            com.baidu.tbadk.core.e.b.B(getPageContext().getPageActivity(), 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        setSkinType(3);
        if (this.mNoDataView != null) {
            this.mNoDataView.btX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        private String mName;

        public b(String str) {
            this.mName = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(this.mName)) {
                SquareSearchActivity.this.jel = this.mName;
                TiebaStatic.log(new ar("c12034"));
                SquareSearchActivity.this.aT(this.mName, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dek() {
        if (!j.isNetWorkAvailable()) {
            dv(this.mNoDataView);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.pz(R.string.neterror));
            return true;
        }
        dw(this.mNoDataView);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
        private BasicNameValuePair ljU;
        private aa mNetwork = null;
        private String mUrl;

        public a(String str, BasicNameValuePair basicNameValuePair, boolean z) {
            this.mUrl = null;
            this.ljU = null;
            this.mUrl = str;
            this.ljU = basicNameValuePair;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!SquareSearchActivity.this.dek()) {
                SquareSearchActivity.this.dw(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.ljk, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(R.dimen.ds320));
                SquareSearchActivity.this.ljl.setVisibility(8);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public ForumSuggestModel doInBackground(Object... objArr) {
            ForumSuggestModel forumSuggestModel = null;
            if (j.isNetWorkAvailable()) {
                try {
                    this.mNetwork = new aa(this.mUrl);
                    this.mNetwork.addPostData(this.ljU);
                    String postNetData = this.mNetwork.postNetData();
                    if (postNetData != null) {
                        forumSuggestModel = ForumSuggestModel.parserJson(postNetData);
                        SquareSearchActivity.this.ljx = this.ljU.getValue();
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
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.ljk);
            if (forumSuggestModel != null) {
                SquareSearchActivity.this.dw(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.ljv = forumSuggestModel;
                SquareSearchActivity.this.refresh();
            } else {
                SquareSearchActivity.this.dv(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.pz(R.string.text_no_search_record));
            }
            SquareSearchActivity.this.ljw = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.ljk);
            super.cancel(true);
        }
    }

    private void tQ(boolean z) {
        if (TbadkCoreApplication.isLogin()) {
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(CmdConfigCustom.CMD_REQUEST_ENTER_FORUM_MESSAGE, true));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(CmdConfigCustom.CMD_REQUEST_ENTER_FORUM_MESSAGE, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dv(View view) {
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dw(View view) {
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
                this.ljG = false;
                this.iTa.setText(str);
                this.iTa.setSelection(str.length());
                this.ljG = true;
            }
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.iTa);
            this.ljn.setVisibility(8);
            this.ljs.setVisibility(8);
            this.ljm.setVisibility(0);
            showProgressBarWithOffset(0, 0);
            String str2 = TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + TbConfig.SQUARE_SEARCH_PAGE + str;
            try {
                str2 = TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            this.ljm.loadUrl(str2);
            af.a(new ae<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ae
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.TG(str);
                    return true;
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NT(String str) {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (!StringUtils.isNull(str)) {
            this.ljH = str;
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CREATE_BAR)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), str)));
            }
        }
    }
}
