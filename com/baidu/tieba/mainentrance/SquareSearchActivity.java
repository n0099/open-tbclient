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
import com.baidu.android.imsdk.utils.HanziToPinyin;
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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.y;
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
    private ImageView dJZ;
    private ImageView eFi;
    private TextView eFj;
    private EditText fhh;
    private String fsG;
    private LinearLayoutDetectsSoftKeyboard hlC;
    private FrameLayout hlD;
    private FrameLayout hlE;
    private BaseWebView hlF;
    private ScrollView hlG;
    private LinearLayout hlH;
    private List<c> hlI;
    private g hlJ;
    private LinearLayout hlK;
    private BdListView hlL;
    private com.baidu.tieba.mainentrance.a hlM;
    private com.baidu.tieba.mainentrance.searchSuggestList.b hlN;
    private ForumSuggestModel hlO;
    private a hlP;
    private String hlQ;
    private boolean hlR;
    private ScrollView hlT;
    private SearchPageFocusBar hlU;
    private View hlV;
    private View hlW;
    private HotForumModel hlq;
    private String hma;
    private HotSearchInfoData mHotSearchInfo;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mTopicInfoTitle;
    private boolean hlS = true;
    private List<View> hlX = new ArrayList();
    private boolean hlo = false;
    private boolean hlY = true;
    private boolean hlZ = true;
    private Runnable hmb = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.1
        @Override // java.lang.Runnable
        public void run() {
            SquareSearchActivity.this.fhh.requestFocus();
            l.showSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.fhh);
        }
    };
    private final Runnable hmc = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.12
        @Override // java.lang.Runnable
        public void run() {
            if (!SquareSearchActivity.this.bKh()) {
                try {
                    if (SquareSearchActivity.this.fsG != null && SquareSearchActivity.this.fsG.length() > 0) {
                        StringBuffer stringBuffer = new StringBuffer(30);
                        stringBuffer.append(TbConfig.SERVER_ADDRESS);
                        stringBuffer.append(Config.SUGGEST_BAR_ADDRESS);
                        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", SquareSearchActivity.this.fsG.trim());
                        SquareSearchActivity.this.bJS();
                        SquareSearchActivity.this.hlP = new a(stringBuffer.toString(), basicNameValuePair, true);
                        SquareSearchActivity.this.hlP.setPriority(3);
                        SquareSearchActivity.this.hlP.execute(stringBuffer.toString(), basicNameValuePair);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a hmd = new com.baidu.adp.framework.listener.a(1003196, CmdConfigSocket.CMD_SEARCH_LIST) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.22
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = ((responsedMessage instanceof SearchListHttpResMessage) || (responsedMessage instanceof SearchListSocketResMessage)) ? false : true;
            if (responsedMessage == null || z || responsedMessage.getError() != 0 || responsedMessage.hasError()) {
                if (j.isNetWorkAvailable() || !SquareSearchActivity.this.hlo) {
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(R.string.neterror));
                }
                if (!j.isNetWorkAvailable()) {
                    SquareSearchActivity.this.hlo = true;
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
            if (SquareSearchActivity.this.hlY && responsedMessage.getError() != 0) {
                SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(R.string.neterror));
                return;
            }
            if (list != null && list.size() > 0) {
                SquareSearchActivity.this.hlY = false;
            }
            SquareSearchActivity.this.bKe();
            SquareSearchActivity.this.hlL.setAdapter((ListAdapter) SquareSearchActivity.this.hlN);
            SquareSearchActivity.this.hlN.ze(SquareSearchActivity.this.fsG.trim());
            SquareSearchActivity.this.hlN.setData(list);
            SquareSearchActivity.this.hlN.notifyDataSetInvalidated();
        }
    };
    private CustomMessageListener hlt = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_CREATE_BAR) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                SquareSearchActivity.this.zh(customResponsedMessage.getData().toString());
            }
        }
    };
    private CustomMessageListener hme = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof ArrayList) {
                    SquareSearchActivity.this.ao((ArrayList) data);
                }
            }
        }
    };
    private View.OnClickListener hmf = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.fhh);
            if (view.getTag() instanceof c) {
                c cVar = (c) view.getTag();
                TiebaStatic.log(new an("c10363").bS("obj_name", cVar.getName()));
                if (!com.baidu.tbadk.plugins.b.f(SquareSearchActivity.this.getPageContext())) {
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
                if (SquareSearchActivity.this.hlF.getUrl() != null && SquareSearchActivity.this.hlF.getUrl().contains(str)) {
                    SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.hlD);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bJR() {
        if (this.mHotSearchInfo == null) {
            return false;
        }
        if (this.mHotSearchInfo.getType() == 0) {
            am(this.mHotSearchInfo.getName(), false);
        } else if (this.mHotSearchInfo.getType() == 1 && !com.baidu.tbadk.plugins.b.f(getPageContext())) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new an("c10355").bS("obj_name", this.mHotSearchInfo.getName()).O("obj_type", this.mHotSearchInfo.getType() == 0 ? 2 : 1));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.home_dialog_search);
        init();
        getWindow().setSoftInputMode(1);
        registerListener(this.hme);
        registerListener(this.hmd);
        registerListener(this.hlt);
        registerListener(this.htmlLoadMessageListener);
        if (SquareSearchActivityConfig.IS_SHOW_RECOMMEND_FORUM) {
            this.hlq = new HotForumModel(getPageContext(), this);
            this.hlq.bJO();
        }
        this.hlR = false;
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
        hideLoadingView(this.hlD);
        this.mHandler.removeCallbacks(this.hmb);
        bJS();
    }

    public void bJS() {
        this.mHandler.removeCallbacks(this.hmc);
        if (this.hlP != null) {
            this.hlP.cancel();
            this.hlP = null;
        }
    }

    private void init() {
        this.hlC = (LinearLayoutDetectsSoftKeyboard) findViewById(R.id.parent);
        this.hlC.setOnSoftKeyBoardShownListener(new LinearLayoutDetectsSoftKeyboard.a() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.24
            @Override // com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard.a
            public void aL(boolean z) {
                SquareSearchActivity.this.hlS = z;
            }
        });
        this.hlC.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.25
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    SquareSearchActivity.this.hlC.setFocusable(true);
                    SquareSearchActivity.this.hlC.setFocusableInTouchMode(true);
                    if (SquareSearchActivity.this.fhh.hasFocus()) {
                        l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.fhh);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        aJv();
        this.hlD = (FrameLayout) findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), null, null);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            this.hlT = (ScrollView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.home_searchbar_nodataview, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) this.hlT.findViewById(R.id.focusbar_nodata_root);
            this.hlU = (SearchPageFocusBar) linearLayout.findViewById(R.id.no_data_focusbar);
            linearLayout.addView(this.mNoDataView, 0);
            this.hlT.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.26
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.hlT);
                    return false;
                }
            });
            this.hlD.addView(this.hlT, this.hlD.getChildCount());
        } else {
            this.hlD.addView(this.mNoDataView, 0);
        }
        this.hlE = (FrameLayout) findViewById(R.id.home_search_list);
        bJQ();
        bJU();
        bJV();
        bJW();
        this.hlF = (BaseWebView) findViewById(R.id.search_result_webview);
        this.hlF.initCommonJsBridge(getPageContext().getPageActivity());
        this.hlF.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.27
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
                if (SquareSearchActivity.this.isProgressBarShown()) {
                    SquareSearchActivity.this.hideProgressBar();
                }
            }
        });
        this.hlF.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.28
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                com.baidu.tbadk.core.e.a.a("search", -1L, 0, "ReceivedError", 0, "", "requesturl", str2, "receiveerror", Integer.valueOf(i), "description", str);
            }
        });
        this.hlF.setOnReceivedSslErrorListener(new BaseWebView.g() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.g
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                if (sslError != null) {
                    com.baidu.tbadk.core.e.a.a("search", -1L, 0, "ReceivedSslError", 0, "", "requesturl", sslError.getUrl(), "receiveerror", sslError.toString());
                }
            }
        });
        this.hlF.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.3
            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.mainentrance.SquareSearchActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return ba.amO().a(SquareSearchActivity.this.getPageContext(), new String[]{str}) != 3;
            }
        });
        this.fhh.setText("");
        this.fhh.requestFocus();
        ShowSoftKeyPadDelay(this.fhh, 200);
        bJX();
        bJY();
    }

    private void aJv() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.dJZ = (ImageView) addCustomView.findViewById(R.id.search_bar_icon);
        this.fhh = (EditText) addCustomView.findViewById(R.id.home_et_search);
        this.eFi = (ImageView) addCustomView.findViewById(R.id.home_bt_search_del);
        this.eFj = (TextView) addCustomView.findViewById(R.id.home_bt_search_cancel_s);
        this.fhh.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    SquareSearchActivity.this.bJT();
                } else {
                    l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.fhh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.bJT();
            }
        });
        this.eFj.setText(getPageContext().getString(R.string.cancel));
        this.eFj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.fhh);
                com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SquareSearchActivity.this.finish();
                    }
                }, 200L);
            }
        });
        this.fhh.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.7
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (SquareSearchActivity.this.fsG == null || SquareSearchActivity.this.fsG.trim().length() < 1) {
                        l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.fhh);
                        if (SquareSearchActivity.this.bJR()) {
                            return true;
                        }
                        SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(R.string.write_keyword));
                        return true;
                    }
                    String trim = SquareSearchActivity.this.fhh.getText().toString().trim();
                    if (!StringUtils.isNull(trim)) {
                        SquareSearchActivity.this.am(trim, false);
                        return true;
                    }
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(R.string.write_keyword));
                    return true;
                }
                return false;
            }
        });
        this.eFi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.fhh.setText("");
            }
        });
        this.fhh.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.9
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SquareSearchActivity.this.hlZ) {
                    SquareSearchActivity.this.fsG = editable.toString();
                    if (StringUtils.isNull(SquareSearchActivity.this.fsG)) {
                        SquareSearchActivity.this.hlY = true;
                    }
                    SquareSearchActivity.this.bKb();
                }
                if (editable.toString().trim().length() == 0) {
                    SquareSearchActivity.this.eFi.setVisibility(8);
                } else {
                    SquareSearchActivity.this.eFi.setVisibility(0);
                }
                am.setViewTextColor(SquareSearchActivity.this.eFj, R.color.cp_link_tip_a, 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJT() {
        if (StringUtils.isNull(this.fhh.getText().toString())) {
            if (this.hlG.getVisibility() != 0) {
                bJZ();
            }
        } else if (this.hlL.getVisibility() != 0) {
            bKb();
        }
    }

    private void bJU() {
        this.hlG = (ScrollView) findViewById(R.id.search_history_scrollview);
        this.hlH = (LinearLayout) findViewById(R.id.search_history_linearlayout);
        if (this.hlK == null) {
            this.hlK = new LinearLayout(getPageContext().getPageActivity());
            this.hlK.setOrientation(1);
            this.hlK.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
        }
        this.hlH.addView(this.hlK);
    }

    private void bJV() {
        if (this.hlJ == null) {
            this.hlJ = new g(getPageContext());
            this.hlH.addView(this.hlJ.createView());
        }
    }

    private void bJW() {
        this.hlL = (BdListView) findViewById(R.id.home_lv_search_suggest);
        this.hlM = new com.baidu.tieba.mainentrance.a(this, null);
        this.hlN = new com.baidu.tieba.mainentrance.searchSuggestList.b(getPageContext().getPageActivity(), null);
        this.hlL.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.10
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ListAdapter adapter;
                ListView listView = (ListView) adapterView;
                if (listView != null && (adapter = listView.getAdapter()) != null && adapter.getCount() != 0 && i < adapter.getCount()) {
                    Object item = adapter.getItem(i);
                    if (item instanceof String) {
                        SquareSearchActivity.this.am((String) item, true);
                        TiebaStatic.eventStat(SquareSearchActivity.this.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
                    }
                }
            }
        });
        this.hlL.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.11
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

    public void bJX() {
        this.eFj.setText(getPageContext().getString(R.string.cancel));
        bJY();
        bJS();
        bKc();
        if (this.fsG.trim().length() > 0) {
            bKb();
        } else {
            bJZ();
        }
    }

    private void bJY() {
        if (this.mHotSearchInfo == null) {
            this.fhh.setHint(R.string.search_bar);
        } else {
            this.fhh.setHint(HanziToPinyin.Token.SEPARATOR + UtilHelper.getFixedText(this.mHotSearchInfo.bdL(), 15));
        }
    }

    private void bJQ() {
        HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.alP().getString(SharedPrefConfig.HOT_SEARCH_INFO, ""), HotSearchInfoData.class);
        if (hotSearchInfoData != null && hotSearchInfoData.getId() != 0) {
            this.mHotSearchInfo = hotSearchInfoData;
        }
    }

    private void bJZ() {
        this.hlF.setVisibility(8);
        this.hlL.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA));
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            nb(true);
            cn(this.hlU);
            cn(this.hlT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(ArrayList<String> arrayList) {
        NoDataViewFactory.d iK;
        if (aq(arrayList)) {
            bKg();
            if (j.isNetWorkAvailable()) {
                iK = NoDataViewFactory.d.iK(R.string.text_no_search_record);
            } else {
                iK = NoDataViewFactory.d.iK(R.string.neterror);
            }
            this.mNoDataView.setTextOption(iK);
            return;
        }
        bKf();
        ap(arrayList);
        W(true, arrayList == null || arrayList.size() == 0);
        bJY();
    }

    private void ap(final ArrayList<String> arrayList) {
        if (this.hlK != null) {
            this.hlK.removeAllViews();
            if (arrayList != null && !arrayList.isEmpty() && getActivity() != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                this.hlV = LayoutInflater.from(pageActivity).inflate(R.layout.square_search_recommand_fourm_header, (ViewGroup) null);
                this.hlV.findViewById(R.id.titleTopDivider).setVisibility(8);
                getLayoutMode().onModeChanged(this.hlV);
                this.hlK.addView(this.hlV, layoutParams);
                int size = arrayList.size();
                this.hlX.clear();
                for (int i = 0; i < size; i++) {
                    final String str = arrayList.get(i);
                    if (!TextUtils.isEmpty(str)) {
                        final View inflate = LayoutInflater.from(pageActivity).inflate(R.layout.home_dialog_search_item, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.home_lv_search_forum)).setText(str);
                        am.setViewTextColor((TextView) inflate.findViewById(R.id.home_lv_search_forum), R.color.cp_cont_b, 1);
                        inflate.findViewById(R.id.home_dialog_lv_search_forum_divider).setVisibility(8);
                        am.setBackgroundResource(inflate, R.drawable.square_search_item_bg);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        inflate.setOnClickListener(new b(str));
                        ImageView imageView = (ImageView) inflate.findViewById(R.id.del_search_history_btn);
                        am.setImageResource(imageView, R.drawable.icn_shop_order_close);
                        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                z.a(new y<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // com.baidu.tbadk.util.y
                                    public Boolean doInBackground() {
                                        com.baidu.tieba.tbadkCore.util.a.DY(str);
                                        return true;
                                    }
                                }, new com.baidu.tbadk.util.j<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.2
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.tbadk.util.j
                                    public void onReturnDataInUI(Boolean bool) {
                                        SquareSearchActivity.this.hlK.removeView(inflate);
                                        arrayList.remove(str);
                                        if (arrayList.size() <= 0) {
                                            SquareSearchActivity.this.ao(null);
                                        }
                                    }
                                });
                            }
                        });
                        this.hlX.add(inflate);
                        this.hlK.addView(inflate, layoutParams2);
                    }
                }
                this.hlW = LayoutInflater.from(pageActivity).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
                ((TextView) this.hlW.findViewById(R.id.home_bt_search_footer)).setTextColor(am.getColor(R.color.cp_link_tip_a));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                this.hlW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SquareSearchActivity.this.bKa();
                    }
                });
                this.hlK.addView(this.hlW, layoutParams3);
            }
        }
    }

    private void W(boolean z, boolean z2) {
        if (this.hlJ != null) {
            this.hlJ.clear();
            if (this.hlI != null && !this.hlI.isEmpty() && z) {
                this.hlJ.na(!z2);
                this.hlJ.setTitleText(this.mTopicInfoTitle);
                int size = this.hlI.size();
                if (size >= 1) {
                    if (size > 7) {
                        size = 7;
                    }
                    int i = size % 2 == 0 ? size - 1 : size;
                    for (int i2 = 0; i2 < i; i2++) {
                        c cVar = (c) v.getItem(this.hlI, i2);
                        if (cVar != null) {
                            this.hlJ.a(cVar, i2).setOnClickListener(this.hmf);
                        }
                    }
                    this.hlJ.a(null, i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.16
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.fhh);
                            if (!com.baidu.tbadk.plugins.b.f(SquareSearchActivity.this.getPageContext())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all")));
                            }
                        }
                    });
                    this.hlJ.show();
                }
            }
        }
    }

    private boolean aq(ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && (this.hlI == null || this.hlI.size() <= 2) && this.hlR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKa() {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).nn(getPageContext().getString(R.string.alert_clean_history)).a(getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                h.ga().submitTask(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.cpi();
                    }
                });
                if (SquareSearchActivity.this.hlI == null || SquareSearchActivity.this.hlI.size() < 2) {
                    SquareSearchActivity.this.cm(SquareSearchActivity.this.hlT);
                    SquareSearchActivity.this.cm(SquareSearchActivity.this.hlU);
                    SquareSearchActivity.this.hlE.setVisibility(8);
                    SquareSearchActivity.this.mNoDataView.setVisibility(0);
                    SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.iK(R.string.text_no_search_record));
                    return;
                }
                SquareSearchActivity.this.ao(null);
            }
        }).b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.17
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        }).b(getPageContext()).akM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKb() {
        if (this.fsG.trim().length() > 0) {
            bKd();
            return;
        }
        bJS();
        bJZ();
    }

    private void bKc() {
        if (this.hlL != null) {
            this.hlL.setNextPage(null);
        }
    }

    private void bKd() {
        if (!StringUtils.isNull(this.fsG)) {
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.fsG.trim();
            sendMessage(searchListNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        try {
            if (this.hlO != null) {
                if (this.hlO.forum_list != null && this.hlO.forum_list.size() > 0) {
                    bKe();
                    this.hlL.setAdapter((ListAdapter) this.hlM);
                    this.hlM.ze(this.fsG);
                    this.hlM.an(this.hlO.forum_list);
                    this.hlM.notifyDataSetInvalidated();
                } else {
                    cn(this.hlT);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKe() {
        this.hlE.setVisibility(0);
        this.hlL.setVisibility(0);
        this.hlG.setVisibility(8);
        this.hlF.setVisibility(8);
        cn(this.hlT);
        this.mNoDataView.setVisibility(8);
    }

    private void bKf() {
        this.hlE.setVisibility(0);
        this.hlG.setVisibility(0);
        this.hlL.setVisibility(8);
        this.hlF.setVisibility(8);
        cn(this.hlT);
        this.mNoDataView.setVisibility(8);
    }

    private void bKg() {
        this.hlE.setVisibility(8);
        this.hlL.setVisibility(8);
        this.hlG.setVisibility(8);
        this.hlF.setVisibility(8);
        cm(this.hlT);
        this.mNoDataView.setVisibility(0);
        cm(this.hlU);
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void zf(String str) {
        this.hlR = true;
        this.hlI = new ArrayList();
        bJZ();
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void a(List<com.baidu.tieba.mainentrance.b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str) {
        this.hlR = true;
        hideLoadingView(this.hlD);
        if (list2 == null) {
            this.hlI = new ArrayList();
        } else {
            this.hlI = list2;
        }
        if (!StringUtils.isNULL(str)) {
            this.mTopicInfoTitle = str;
        } else {
            this.mTopicInfoTitle = "";
        }
        a(hotSearchInfoData);
        this.mHotSearchInfo = hotSearchInfoData;
        bJZ();
    }

    private void a(HotSearchInfoData hotSearchInfoData) {
        if (hotSearchInfoData != null) {
            com.baidu.tbadk.core.sharedPref.b.alP().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData));
            return;
        }
        HotSearchInfoData hotSearchInfoData2 = new HotSearchInfoData();
        hotSearchInfoData2.setId(0L);
        hotSearchInfoData2.setName("");
        hotSearchInfoData2.zg("");
        hotSearchInfoData2.setType(0L);
        com.baidu.tbadk.core.sharedPref.b.alP().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData2));
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
        getLayoutMode().onModeChanged(this.hlC);
        am.setBgColor(this.hlC, i);
        if (this.hlM != null) {
            this.hlM.notifyDataSetChanged();
        }
        if (i == 2) {
            this.fhh.setHintTextColor(am.getColor(R.color.s_navbar_title_color));
        } else {
            this.fhh.setHintTextColor(am.getColor(R.color.cp_cont_e));
        }
        SvgManager.amL().a(this.eFi, R.drawable.icon_pure_search_empty_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setNavbarTitleColor(this.fhh, R.color.cp_cont_b, R.color.s_navbar_title_color);
        SvgManager.amL().a(this.dJZ, R.drawable.icon_pure_search_import_n_svg, R.color.cp_cont_d, null);
        am.setBackgroundResource(this.hlD, R.color.cp_bg_line_d);
        am.setViewTextColor(this.eFj, R.color.cp_link_tip_a, 1);
        if (this.hlJ != null) {
            this.hlJ.onChangeSkinType(i);
        }
        vx(i);
    }

    private void vx(int i) {
        if (this.hlK != null) {
            this.hlK.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
        }
        if (this.hlV != null) {
            getLayoutMode().onModeChanged(this.hlV);
        }
        if (this.hlW != null) {
            ((TextView) this.hlW.findViewById(R.id.home_bt_search_footer)).setTextColor(am.getColor(R.color.cp_link_tip_a));
        }
        if (this.hlX != null) {
            for (View view : this.hlX) {
                am.setViewTextColor((TextView) view.findViewById(R.id.home_lv_search_forum), R.color.cp_cont_b, 1);
                view.findViewById(R.id.home_dialog_lv_search_forum_divider).setBackgroundColor(am.getColor(R.color.cp_bg_line_c));
                am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (i == 4 && this.hlF.canGoBack()) {
                this.hlF.goBack();
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
            com.baidu.tbadk.core.f.b.m(getPageContext().getPageActivity(), 1);
        } else {
            com.baidu.tbadk.core.f.b.m(getPageContext().getPageActivity(), 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        setSkinType(3);
        if (this.mNoDataView != null) {
            this.mNoDataView.anE();
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
                SquareSearchActivity.this.fsG = this.mName;
                TiebaStatic.log(new an("c12034"));
                SquareSearchActivity.this.am(this.mName, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bKh() {
        if (!j.isNetWorkAvailable()) {
            cm(this.mNoDataView);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iK(R.string.neterror));
            return true;
        }
        cn(this.mNoDataView);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
        private BasicNameValuePair hmn;
        private x mNetwork = null;
        private String mUrl;

        public a(String str, BasicNameValuePair basicNameValuePair, boolean z) {
            this.mUrl = null;
            this.hmn = null;
            this.mUrl = str;
            this.hmn = basicNameValuePair;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!SquareSearchActivity.this.bKh()) {
                SquareSearchActivity.this.cn(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.hlD, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(R.dimen.ds320));
                SquareSearchActivity.this.hlE.setVisibility(8);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public ForumSuggestModel doInBackground(Object... objArr) {
            ForumSuggestModel forumSuggestModel = null;
            if (j.isNetWorkAvailable()) {
                try {
                    this.mNetwork = new x(this.mUrl);
                    this.mNetwork.addPostData(this.hmn);
                    String postNetData = this.mNetwork.postNetData();
                    if (postNetData != null) {
                        forumSuggestModel = ForumSuggestModel.parserJson(postNetData);
                        SquareSearchActivity.this.hlQ = this.hmn.getValue();
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
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.hlD);
            if (forumSuggestModel != null) {
                SquareSearchActivity.this.cn(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.hlO = forumSuggestModel;
                SquareSearchActivity.this.refresh();
            } else {
                SquareSearchActivity.this.cm(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.iK(R.string.text_no_search_record));
            }
            SquareSearchActivity.this.hlP = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.hlD);
            super.cancel(true);
        }
    }

    private void nb(boolean z) {
        if (TbadkCoreApplication.isLogin()) {
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(CmdConfigCustom.CMD_REQUEST_ENTER_FORUM_MESSAGE, true));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(CmdConfigCustom.CMD_REQUEST_ENTER_FORUM_MESSAGE, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cm(View view) {
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cn(View view) {
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SEARCH_RESULT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(final String str, boolean z) {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.hlZ = false;
                this.fhh.setText(str);
                this.fhh.setSelection(str.length());
                this.hlZ = true;
            }
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.fhh);
            this.hlG.setVisibility(8);
            this.hlL.setVisibility(8);
            this.hlF.setVisibility(0);
            showProgressBarWithOffset(0, 0);
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            this.hlF.loadUrl(str2);
            z.a(new y<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.y
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.DW(str);
                    return true;
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zh(String str) {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (!StringUtils.isNull(str)) {
            this.hma = str;
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CREATE_BAR)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), str)));
            }
        }
    }
}
