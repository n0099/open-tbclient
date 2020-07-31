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
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
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
/* loaded from: classes18.dex */
public class SquareSearchActivity extends BaseActivity<SquareSearchActivity> implements HotForumModel.a {
    private ImageView fNo;
    private ImageView gPR;
    private TextView gPS;
    private String hDo;
    private EditText hsb;
    private LinearLayoutDetectsSoftKeyboard jGD;
    private FrameLayout jGE;
    private FrameLayout jGF;
    private BaseWebView jGG;
    private ScrollView jGH;
    private LinearLayout jGI;
    private List<c> jGJ;
    private g jGK;
    private LinearLayout jGL;
    private BdListView jGM;
    private com.baidu.tieba.mainentrance.a jGN;
    private com.baidu.tieba.mainentrance.searchSuggestList.b jGO;
    private ForumSuggestModel jGP;
    private a jGQ;
    private String jGR;
    private boolean jGS;
    private ScrollView jGU;
    private SearchPageFocusBar jGV;
    private View jGW;
    private View jGX;
    private HotForumModel jGr;
    private String jHb;
    private HotSearchInfoData mHotSearchInfo;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mTopicInfoTitle;
    private boolean jGT = true;
    private List<View> jGY = new ArrayList();
    private boolean jGp = false;
    private boolean jGZ = true;
    private boolean jHa = true;
    private Runnable jHc = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.1
        @Override // java.lang.Runnable
        public void run() {
            SquareSearchActivity.this.hsb.requestFocus();
            l.showSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.hsb);
        }
    };
    private final Runnable jHd = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.12
        @Override // java.lang.Runnable
        public void run() {
            if (!SquareSearchActivity.this.cDJ()) {
                try {
                    if (SquareSearchActivity.this.hDo != null && SquareSearchActivity.this.hDo.length() > 0) {
                        StringBuffer stringBuffer = new StringBuffer(30);
                        stringBuffer.append(TbConfig.SERVER_ADDRESS);
                        stringBuffer.append(Config.SUGGEST_BAR_ADDRESS);
                        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", SquareSearchActivity.this.hDo.trim());
                        SquareSearchActivity.this.cDt();
                        SquareSearchActivity.this.jGQ = new a(stringBuffer.toString(), basicNameValuePair, true);
                        SquareSearchActivity.this.jGQ.setPriority(3);
                        SquareSearchActivity.this.jGQ.execute(stringBuffer.toString(), basicNameValuePair);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a jHe = new com.baidu.adp.framework.listener.a(1003196, CmdConfigSocket.CMD_SEARCH_LIST) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.22
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = ((responsedMessage instanceof SearchListHttpResMessage) || (responsedMessage instanceof SearchListSocketResMessage)) ? false : true;
            if (responsedMessage == null || z || responsedMessage.getError() != 0 || responsedMessage.hasError()) {
                if (j.isNetWorkAvailable() || !SquareSearchActivity.this.jGp) {
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(R.string.neterror));
                }
                if (!j.isNetWorkAvailable()) {
                    SquareSearchActivity.this.jGp = true;
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
            if (SquareSearchActivity.this.jGZ && responsedMessage.getError() != 0) {
                SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(R.string.neterror));
                return;
            }
            if (list != null && list.size() > 0) {
                SquareSearchActivity.this.jGZ = false;
            }
            SquareSearchActivity.this.cDG();
            SquareSearchActivity.this.jGM.setAdapter((ListAdapter) SquareSearchActivity.this.jGO);
            SquareSearchActivity.this.jGO.IX(SquareSearchActivity.this.hDo.trim());
            SquareSearchActivity.this.jGO.setData(list);
            SquareSearchActivity.this.jGO.notifyDataSetInvalidated();
        }
    };
    private CustomMessageListener jGu = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_CREATE_BAR) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                SquareSearchActivity.this.Ja(customResponsedMessage.getData().toString());
            }
        }
    };
    private CustomMessageListener jHf = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof ArrayList) {
                    SquareSearchActivity.this.aD((ArrayList) data);
                }
            }
        }
    };
    private View.OnClickListener jHg = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.hsb);
            if (view.getTag() instanceof c) {
                c cVar = (c) view.getTag();
                TiebaStatic.log(new ap("c10363").dn("obj_name", cVar.getName()));
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
                if (SquareSearchActivity.this.jGG.getUrl() != null && SquareSearchActivity.this.jGG.getUrl().contains(str)) {
                    SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.jGE);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cDs() {
        if (this.mHotSearchInfo == null) {
            return false;
        }
        if (this.mHotSearchInfo.getType() == 0) {
            aJ(this.mHotSearchInfo.getName(), false);
        } else if (this.mHotSearchInfo.getType() == 1 && !com.baidu.tbadk.plugins.b.k(getPageContext())) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new ap("c10355").dn("obj_name", this.mHotSearchInfo.getName()).ah("obj_type", this.mHotSearchInfo.getType() == 0 ? 2 : 1));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.home_dialog_search);
        init();
        getWindow().setSoftInputMode(1);
        registerListener(this.jHf);
        registerListener(this.jHe);
        registerListener(this.jGu);
        registerListener(this.htmlLoadMessageListener);
        if (SquareSearchActivityConfig.IS_SHOW_RECOMMEND_FORUM) {
            this.jGr = new HotForumModel(getPageContext(), this);
            this.jGr.cDp();
        }
        this.jGS = false;
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
        hideLoadingView(this.jGE);
        this.mHandler.removeCallbacks(this.jHc);
        cDt();
    }

    public void cDt() {
        this.mHandler.removeCallbacks(this.jHd);
        if (this.jGQ != null) {
            this.jGQ.cancel();
            this.jGQ = null;
        }
    }

    private void init() {
        this.jGD = (LinearLayoutDetectsSoftKeyboard) findViewById(R.id.parent);
        this.jGD.setOnSoftKeyBoardShownListener(new LinearLayoutDetectsSoftKeyboard.a() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.24
            @Override // com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard.a
            public void ck(boolean z) {
                SquareSearchActivity.this.jGT = z;
            }
        });
        this.jGD.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.25
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    SquareSearchActivity.this.jGD.setFocusable(true);
                    SquareSearchActivity.this.jGD.setFocusableInTouchMode(true);
                    if (SquareSearchActivity.this.hsb.hasFocus()) {
                        l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.hsb);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        bmb();
        this.jGE = (FrameLayout) findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), null, null);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            this.jGU = (ScrollView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.home_searchbar_nodataview, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) this.jGU.findViewById(R.id.focusbar_nodata_root);
            this.jGV = (SearchPageFocusBar) linearLayout.findViewById(R.id.no_data_focusbar);
            linearLayout.addView(this.mNoDataView, 0);
            this.jGU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.26
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.jGU);
                    return false;
                }
            });
            this.jGE.addView(this.jGU, this.jGE.getChildCount());
        } else {
            this.jGE.addView(this.mNoDataView, 0);
        }
        this.jGF = (FrameLayout) findViewById(R.id.home_search_list);
        cDA();
        cDv();
        cDw();
        cDx();
        this.jGG = (BaseWebView) findViewById(R.id.search_result_webview);
        this.jGG.initCommonJsBridge(getPageContext().getPageActivity());
        this.jGG.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.27
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
                if (SquareSearchActivity.this.isProgressBarShown()) {
                    SquareSearchActivity.this.hideProgressBar();
                }
            }
        });
        this.jGG.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.28
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedError", 0, "", "requesturl", str2, "receiveerror", Integer.valueOf(i), "description", str);
            }
        });
        this.jGG.setOnReceivedSslErrorListener(new BaseWebView.g() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.g
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                if (sslError != null) {
                    com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedSslError", 0, "", "requesturl", sslError.getUrl(), "receiveerror", sslError.toString());
                }
            }
        });
        this.jGG.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.3
            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.mainentrance.SquareSearchActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return bd.baV().a(SquareSearchActivity.this.getPageContext(), new String[]{str}) != 3;
            }
        });
        this.hsb.setText("");
        this.hsb.requestFocus();
        ShowSoftKeyPadDelay(this.hsb, 200);
        cDy();
        cDz();
    }

    private void bmb() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.fNo = (ImageView) addCustomView.findViewById(R.id.search_bar_icon);
        this.hsb = (EditText) addCustomView.findViewById(R.id.home_et_search);
        this.gPR = (ImageView) addCustomView.findViewById(R.id.home_bt_search_del);
        this.gPS = (TextView) addCustomView.findViewById(R.id.home_bt_search_cancel_s);
        this.hsb.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    SquareSearchActivity.this.cDu();
                } else {
                    l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.hsb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.cDu();
            }
        });
        this.gPS.setText(getPageContext().getString(R.string.cancel));
        this.gPS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.hsb);
                com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SquareSearchActivity.this.finish();
                    }
                }, 200L);
            }
        });
        this.hsb.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.7
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (SquareSearchActivity.this.hDo == null || SquareSearchActivity.this.hDo.trim().length() < 1) {
                        l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.hsb);
                        if (SquareSearchActivity.this.cDs()) {
                            return true;
                        }
                        SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(R.string.write_keyword));
                        return true;
                    }
                    String trim = SquareSearchActivity.this.hsb.getText().toString().trim();
                    if (!StringUtils.isNull(trim)) {
                        SquareSearchActivity.this.aJ(trim, false);
                        return true;
                    }
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(R.string.write_keyword));
                    return true;
                }
                return false;
            }
        });
        this.gPR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.hsb.setText("");
            }
        });
        this.hsb.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.9
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SquareSearchActivity.this.jHa) {
                    SquareSearchActivity.this.hDo = editable.toString();
                    if (StringUtils.isNull(SquareSearchActivity.this.hDo)) {
                        SquareSearchActivity.this.jGZ = true;
                    }
                    SquareSearchActivity.this.cDD();
                }
                if (editable.toString().trim().length() == 0) {
                    SquareSearchActivity.this.gPR.setVisibility(8);
                } else {
                    SquareSearchActivity.this.gPR.setVisibility(0);
                }
                ao.setViewTextColor(SquareSearchActivity.this.gPS, R.color.cp_link_tip_a, 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDu() {
        if (StringUtils.isNull(this.hsb.getText().toString())) {
            if (this.jGH.getVisibility() != 0) {
                cDB();
            }
        } else if (this.jGM.getVisibility() != 0) {
            cDD();
        }
    }

    private void cDv() {
        this.jGH = (ScrollView) findViewById(R.id.search_history_scrollview);
        this.jGI = (LinearLayout) findViewById(R.id.search_history_linearlayout);
        if (this.jGL == null) {
            this.jGL = new LinearLayout(getPageContext().getPageActivity());
            this.jGL.setOrientation(1);
            this.jGL.setBackgroundColor(ao.getColor(R.color.cp_bg_line_d));
        }
        this.jGI.addView(this.jGL);
    }

    private void cDw() {
        if (this.jGK == null) {
            this.jGK = new g(getPageContext());
            this.jGI.addView(this.jGK.createView());
        }
    }

    private void cDx() {
        this.jGM = (BdListView) findViewById(R.id.home_lv_search_suggest);
        this.jGN = new com.baidu.tieba.mainentrance.a(this, null);
        this.jGO = new com.baidu.tieba.mainentrance.searchSuggestList.b(getPageContext().getPageActivity(), null);
        this.jGM.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.10
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ListAdapter adapter;
                ListView listView = (ListView) adapterView;
                if (listView != null && (adapter = listView.getAdapter()) != null && adapter.getCount() != 0 && i < adapter.getCount()) {
                    Object item = adapter.getItem(i);
                    if (item instanceof String) {
                        SquareSearchActivity.this.aJ((String) item, true);
                        TiebaStatic.eventStat(SquareSearchActivity.this.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
                    }
                }
            }
        });
        this.jGM.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.11
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

    public void cDy() {
        this.gPS.setText(getPageContext().getString(R.string.cancel));
        cDz();
        cDt();
        cDE();
        if (this.hDo.trim().length() > 0) {
            cDD();
        } else {
            cDB();
        }
    }

    private void cDz() {
        if (this.mHotSearchInfo == null) {
            this.hsb.setHint(R.string.search_bar);
        } else {
            this.hsb.setHint(" " + UtilHelper.getFixedText(this.mHotSearchInfo.bUv(), 15));
        }
    }

    private void cDA() {
        HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.aZP().getString(SharedPrefConfig.HOT_SEARCH_INFO, ""), HotSearchInfoData.class);
        if (hotSearchInfoData != null && hotSearchInfoData.getId() != 0) {
            this.mHotSearchInfo = hotSearchInfoData;
        }
    }

    private void cDB() {
        this.jGG.setVisibility(8);
        this.jGM.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA));
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            rc(true);
            cD(this.jGV);
            cD(this.jGU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(ArrayList<String> arrayList) {
        NoDataViewFactory.d mF;
        if (aF(arrayList)) {
            cDI();
            if (j.isNetWorkAvailable()) {
                mF = NoDataViewFactory.d.mF(R.string.text_no_search_record);
            } else {
                mF = NoDataViewFactory.d.mF(R.string.neterror);
            }
            this.mNoDataView.setTextOption(mF);
            return;
        }
        cDH();
        aE(arrayList);
        ac(true, arrayList == null || arrayList.size() == 0);
        cDz();
    }

    private void aE(final ArrayList<String> arrayList) {
        if (this.jGL != null) {
            this.jGL.removeAllViews();
            if (arrayList != null && !arrayList.isEmpty() && getActivity() != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                this.jGW = LayoutInflater.from(pageActivity).inflate(R.layout.square_search_recommand_fourm_header, (ViewGroup) null);
                this.jGW.findViewById(R.id.titleTopDivider).setVisibility(8);
                getLayoutMode().onModeChanged(this.jGW);
                this.jGL.addView(this.jGW, layoutParams);
                int size = arrayList.size();
                this.jGY.clear();
                for (int i = 0; i < size; i++) {
                    final String str = arrayList.get(i);
                    if (!TextUtils.isEmpty(str)) {
                        final View inflate = LayoutInflater.from(pageActivity).inflate(R.layout.home_dialog_search_item, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.home_lv_search_forum)).setText(str);
                        ao.setViewTextColor((TextView) inflate.findViewById(R.id.home_lv_search_forum), R.color.cp_cont_b, 1);
                        inflate.findViewById(R.id.home_dialog_lv_search_forum_divider).setVisibility(8);
                        ao.setBackgroundResource(inflate, R.drawable.square_search_item_bg);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        inflate.setOnClickListener(new b(str));
                        ImageView imageView = (ImageView) inflate.findViewById(R.id.del_search_history_btn);
                        ao.setImageResource(imageView, R.drawable.icn_shop_order_close);
                        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                ad.a(new ac<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // com.baidu.tbadk.util.ac
                                    public Boolean doInBackground() {
                                        com.baidu.tieba.tbadkCore.util.a.NV(str);
                                        return true;
                                    }
                                }, new com.baidu.tbadk.util.l<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.2
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.tbadk.util.l
                                    public void onReturnDataInUI(Boolean bool) {
                                        SquareSearchActivity.this.jGL.removeView(inflate);
                                        arrayList.remove(str);
                                        if (arrayList.size() <= 0) {
                                            SquareSearchActivity.this.aD(null);
                                        }
                                    }
                                });
                            }
                        });
                        this.jGY.add(inflate);
                        this.jGL.addView(inflate, layoutParams2);
                    }
                }
                this.jGX = LayoutInflater.from(pageActivity).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
                ((TextView) this.jGX.findViewById(R.id.home_bt_search_footer)).setTextColor(ao.getColor(R.color.cp_link_tip_a));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                this.jGX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SquareSearchActivity.this.cDC();
                    }
                });
                this.jGL.addView(this.jGX, layoutParams3);
            }
        }
    }

    private void ac(boolean z, boolean z2) {
        if (this.jGK != null) {
            this.jGK.clear();
            if (this.jGJ != null && !this.jGJ.isEmpty() && z) {
                this.jGK.rb(!z2);
                this.jGK.setTitleText(this.mTopicInfoTitle);
                int size = this.jGJ.size();
                if (size >= 1) {
                    if (size > 7) {
                        size = 7;
                    }
                    int i = size % 2 == 0 ? size - 1 : size;
                    for (int i2 = 0; i2 < i; i2++) {
                        c cVar = (c) x.getItem(this.jGJ, i2);
                        if (cVar != null) {
                            this.jGK.a(cVar, i2).setOnClickListener(this.jHg);
                        }
                    }
                    this.jGK.a(null, i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.16
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.hsb);
                            if (!com.baidu.tbadk.plugins.b.k(SquareSearchActivity.this.getPageContext())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", SchemeCollecter.CLASSIFY_ALL)));
                            }
                        }
                    });
                    this.jGK.show();
                }
            }
        }
    }

    private boolean aF(ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && (this.jGJ == null || this.jGJ.size() <= 2) && this.jGS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDC() {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).xl(getPageContext().getString(R.string.alert_clean_history)).a(getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                h.lu().submitTask(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.dma();
                    }
                });
                if (SquareSearchActivity.this.jGJ == null || SquareSearchActivity.this.jGJ.size() < 2) {
                    SquareSearchActivity.this.cC(SquareSearchActivity.this.jGU);
                    SquareSearchActivity.this.cC(SquareSearchActivity.this.jGV);
                    SquareSearchActivity.this.jGF.setVisibility(8);
                    SquareSearchActivity.this.mNoDataView.setVisibility(0);
                    SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.mF(R.string.text_no_search_record));
                    return;
                }
                SquareSearchActivity.this.aD(null);
            }
        }).b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.17
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        }).b(getPageContext()).aYL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDD() {
        if (this.hDo.trim().length() > 0) {
            cDF();
            return;
        }
        cDt();
        cDB();
    }

    private void cDE() {
        if (this.jGM != null) {
            this.jGM.setNextPage(null);
        }
    }

    private void cDF() {
        if (!StringUtils.isNull(this.hDo)) {
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.hDo.trim();
            sendMessage(searchListNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        try {
            if (this.jGP != null) {
                if (this.jGP.forum_list != null && this.jGP.forum_list.size() > 0) {
                    cDG();
                    this.jGM.setAdapter((ListAdapter) this.jGN);
                    this.jGN.IX(this.hDo);
                    this.jGN.aC(this.jGP.forum_list);
                    this.jGN.notifyDataSetInvalidated();
                } else {
                    cD(this.jGU);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDG() {
        this.jGF.setVisibility(0);
        this.jGM.setVisibility(0);
        this.jGH.setVisibility(8);
        this.jGG.setVisibility(8);
        cD(this.jGU);
        this.mNoDataView.setVisibility(8);
    }

    private void cDH() {
        this.jGF.setVisibility(0);
        this.jGH.setVisibility(0);
        this.jGM.setVisibility(8);
        this.jGG.setVisibility(8);
        cD(this.jGU);
        this.mNoDataView.setVisibility(8);
    }

    private void cDI() {
        this.jGF.setVisibility(8);
        this.jGM.setVisibility(8);
        this.jGH.setVisibility(8);
        this.jGG.setVisibility(8);
        cC(this.jGU);
        this.mNoDataView.setVisibility(0);
        cC(this.jGV);
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void IY(String str) {
        this.jGS = true;
        this.jGJ = new ArrayList();
        cDB();
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void a(List<com.baidu.tieba.mainentrance.b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str) {
        this.jGS = true;
        hideLoadingView(this.jGE);
        if (list2 == null) {
            this.jGJ = new ArrayList();
        } else {
            this.jGJ = list2;
        }
        if (!StringUtils.isNULL(str)) {
            this.mTopicInfoTitle = str;
        } else {
            this.mTopicInfoTitle = "";
        }
        a(hotSearchInfoData);
        this.mHotSearchInfo = hotSearchInfoData;
        cDB();
    }

    private void a(HotSearchInfoData hotSearchInfoData) {
        if (hotSearchInfoData != null) {
            com.baidu.tbadk.core.sharedPref.b.aZP().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData));
            return;
        }
        HotSearchInfoData hotSearchInfoData2 = new HotSearchInfoData();
        hotSearchInfoData2.setId(0L);
        hotSearchInfoData2.setName("");
        hotSearchInfoData2.IZ("");
        hotSearchInfoData2.setType(0L);
        com.baidu.tbadk.core.sharedPref.b.aZP().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData2));
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
        getLayoutMode().onModeChanged(this.jGD);
        ao.setBgColor(this.jGD, i);
        if (this.jGN != null) {
            this.jGN.notifyDataSetChanged();
        }
        if (i == 2) {
            this.hsb.setHintTextColor(ao.getColor(R.color.s_navbar_title_color));
        } else {
            this.hsb.setHintTextColor(ao.getColor(R.color.cp_cont_e));
        }
        SvgManager.baR().a(this.gPR, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ao.setNavbarTitleColor(this.hsb, R.color.cp_cont_b, R.color.s_navbar_title_color);
        SvgManager.baR().a(this.fNo, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        ao.setBackgroundResource(this.jGE, R.color.cp_bg_line_d);
        ao.setViewTextColor(this.gPS, R.color.cp_link_tip_a, 1);
        if (this.jGK != null) {
            this.jGK.onChangeSkinType(i);
        }
        An(i);
    }

    private void An(int i) {
        if (this.jGL != null) {
            this.jGL.setBackgroundColor(ao.getColor(R.color.cp_bg_line_d));
        }
        if (this.jGW != null) {
            getLayoutMode().onModeChanged(this.jGW);
        }
        if (this.jGX != null) {
            ((TextView) this.jGX.findViewById(R.id.home_bt_search_footer)).setTextColor(ao.getColor(R.color.cp_link_tip_a));
        }
        if (this.jGY != null) {
            for (View view : this.jGY) {
                ao.setViewTextColor((TextView) view.findViewById(R.id.home_lv_search_forum), R.color.cp_cont_b, 1);
                view.findViewById(R.id.home_dialog_lv_search_forum_divider).setBackgroundColor(ao.getColor(R.color.cp_bg_line_c));
                ao.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (i == 4 && this.jGG.canGoBack()) {
                this.jGG.goBack();
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
            com.baidu.tbadk.core.e.b.q(getPageContext().getPageActivity(), 1);
        } else {
            com.baidu.tbadk.core.e.b.q(getPageContext().getPageActivity(), 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        setSkinType(3);
        if (this.mNoDataView != null) {
            this.mNoDataView.bbU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class b implements View.OnClickListener {
        private String mName;

        public b(String str) {
            this.mName = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(this.mName)) {
                SquareSearchActivity.this.hDo = this.mName;
                TiebaStatic.log(new ap("c12034"));
                SquareSearchActivity.this.aJ(this.mName, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cDJ() {
        if (!j.isNetWorkAvailable()) {
            cC(this.mNoDataView);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.mF(R.string.neterror));
            return true;
        }
        cD(this.mNoDataView);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class a extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
        private BasicNameValuePair jHo;
        private z mNetwork = null;
        private String mUrl;

        public a(String str, BasicNameValuePair basicNameValuePair, boolean z) {
            this.mUrl = null;
            this.jHo = null;
            this.mUrl = str;
            this.jHo = basicNameValuePair;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!SquareSearchActivity.this.cDJ()) {
                SquareSearchActivity.this.cD(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.jGE, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(R.dimen.ds320));
                SquareSearchActivity.this.jGF.setVisibility(8);
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
                    this.mNetwork = new z(this.mUrl);
                    this.mNetwork.addPostData(this.jHo);
                    String postNetData = this.mNetwork.postNetData();
                    if (postNetData != null) {
                        forumSuggestModel = ForumSuggestModel.parserJson(postNetData);
                        SquareSearchActivity.this.jGR = this.jHo.getValue();
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
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.jGE);
            if (forumSuggestModel != null) {
                SquareSearchActivity.this.cD(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.jGP = forumSuggestModel;
                SquareSearchActivity.this.refresh();
            } else {
                SquareSearchActivity.this.cC(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.mF(R.string.text_no_search_record));
            }
            SquareSearchActivity.this.jGQ = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.jGE);
            super.cancel(true);
        }
    }

    private void rc(boolean z) {
        if (TbadkCoreApplication.isLogin()) {
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(CmdConfigCustom.CMD_REQUEST_ENTER_FORUM_MESSAGE, true));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(CmdConfigCustom.CMD_REQUEST_ENTER_FORUM_MESSAGE, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cC(View view) {
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cD(View view) {
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SEARCH_RESULT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(final String str, boolean z) {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.jHa = false;
                this.hsb.setText(str);
                this.hsb.setSelection(str.length());
                this.jHa = true;
            }
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.hsb);
            this.jGH.setVisibility(8);
            this.jGM.setVisibility(8);
            this.jGG.setVisibility(0);
            showProgressBarWithOffset(0, 0);
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            this.jGG.loadUrl(str2);
            ad.a(new ac<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ac
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.NT(str);
                    return true;
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ja(String str) {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (!StringUtils.isNull(str)) {
            this.jHb = str;
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CREATE_BAR)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), str)));
            }
        }
    }
}
