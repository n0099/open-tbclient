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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
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
    private ImageView fiW;
    private ImageView gZe;
    private EditText iRM;
    private TextView ioU;
    private String jcX;
    private FrameLayout lfA;
    private FrameLayout lfB;
    private BaseWebView lfC;
    private ScrollView lfD;
    private LinearLayout lfE;
    private List<c> lfF;
    private g lfG;
    private LinearLayout lfH;
    private BdListView lfI;
    private com.baidu.tieba.mainentrance.a lfJ;
    private com.baidu.tieba.mainentrance.searchSuggestList.b lfK;
    private ForumSuggestModel lfL;
    private a lfM;
    private String lfN;
    private boolean lfO;
    private ScrollView lfQ;
    private SearchPageFocusBar lfR;
    private View lfS;
    private View lfT;
    private String lfX;
    private HotForumModel lfm;
    private LinearLayoutDetectsSoftKeyboard lfz;
    private HotSearchInfoData mHotSearchInfo;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mTopicInfoTitle;
    private boolean lfP = true;
    private List<View> lfU = new ArrayList();
    private boolean lfk = false;
    private boolean lfV = true;
    private boolean lfW = true;
    private Runnable lfY = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.1
        @Override // java.lang.Runnable
        public void run() {
            SquareSearchActivity.this.iRM.requestFocus();
            l.showSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.iRM);
        }
    };
    private final Runnable lfZ = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.12
        @Override // java.lang.Runnable
        public void run() {
            if (!SquareSearchActivity.this.dfW()) {
                try {
                    if (SquareSearchActivity.this.jcX != null && SquareSearchActivity.this.jcX.length() > 0) {
                        StringBuffer stringBuffer = new StringBuffer(30);
                        stringBuffer.append(TbConfig.SERVER_ADDRESS);
                        stringBuffer.append(Config.SUGGEST_BAR_ADDRESS);
                        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", SquareSearchActivity.this.jcX.trim());
                        SquareSearchActivity.this.dfG();
                        SquareSearchActivity.this.lfM = new a(stringBuffer.toString(), basicNameValuePair, true);
                        SquareSearchActivity.this.lfM.setPriority(3);
                        SquareSearchActivity.this.lfM.execute(stringBuffer.toString(), basicNameValuePair);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a lga = new com.baidu.adp.framework.listener.a(1003196, CmdConfigSocket.CMD_SEARCH_LIST) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.22
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = ((responsedMessage instanceof SearchListHttpResMessage) || (responsedMessage instanceof SearchListSocketResMessage)) ? false : true;
            if (responsedMessage == null || z || responsedMessage.getError() != 0 || responsedMessage.hasError()) {
                if (j.isNetWorkAvailable() || !SquareSearchActivity.this.lfk) {
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(R.string.neterror));
                }
                if (!j.isNetWorkAvailable()) {
                    SquareSearchActivity.this.lfk = true;
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
            if (SquareSearchActivity.this.lfV && responsedMessage.getError() != 0) {
                SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(R.string.neterror));
                return;
            }
            if (list != null && list.size() > 0) {
                SquareSearchActivity.this.lfV = false;
            }
            SquareSearchActivity.this.dfT();
            SquareSearchActivity.this.lfI.setAdapter((ListAdapter) SquareSearchActivity.this.lfK);
            SquareSearchActivity.this.lfK.Oj(SquareSearchActivity.this.jcX.trim());
            SquareSearchActivity.this.lfK.setData(list);
            SquareSearchActivity.this.lfK.notifyDataSetInvalidated();
        }
    };
    private CustomMessageListener lfp = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_CREATE_BAR) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                SquareSearchActivity.this.Om(customResponsedMessage.getData().toString());
            }
        }
    };
    private CustomMessageListener lgb = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.13
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
    private View.OnClickListener lgc = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.iRM);
            if (view.getTag() instanceof c) {
                c cVar = (c) view.getTag();
                TiebaStatic.log(new aq("c10363").dX("obj_name", cVar.getName()));
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
                if (SquareSearchActivity.this.lfC.getUrl() != null && SquareSearchActivity.this.lfC.getUrl().contains(str)) {
                    SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.lfA);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dfF() {
        if (this.mHotSearchInfo == null) {
            return false;
        }
        if (this.mHotSearchInfo.getType() == 0) {
            aU(this.mHotSearchInfo.getName(), false);
        } else if (this.mHotSearchInfo.getType() == 1 && !com.baidu.tbadk.plugins.b.k(getPageContext())) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new aq("c10355").dX("obj_name", this.mHotSearchInfo.getName()).an("obj_type", this.mHotSearchInfo.getType() == 0 ? 2 : 1));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.home_dialog_search);
        init();
        getWindow().setSoftInputMode(1);
        registerListener(this.lgb);
        registerListener(this.lga);
        registerListener(this.lfp);
        registerListener(this.htmlLoadMessageListener);
        if (SquareSearchActivityConfig.IS_SHOW_RECOMMEND_FORUM) {
            this.lfm = new HotForumModel(getPageContext(), this);
            this.lfm.dfC();
        }
        this.lfO = false;
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
        hideLoadingView(this.lfA);
        this.mHandler.removeCallbacks(this.lfY);
        dfG();
    }

    public void dfG() {
        this.mHandler.removeCallbacks(this.lfZ);
        if (this.lfM != null) {
            this.lfM.cancel();
            this.lfM = null;
        }
    }

    private void init() {
        this.lfz = (LinearLayoutDetectsSoftKeyboard) findViewById(R.id.parent);
        this.lfz.setOnSoftKeyBoardShownListener(new LinearLayoutDetectsSoftKeyboard.a() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.24
            @Override // com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard.a
            public void de(boolean z) {
                SquareSearchActivity.this.lfP = z;
            }
        });
        this.lfz.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.25
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    SquareSearchActivity.this.lfz.setFocusable(true);
                    SquareSearchActivity.this.lfz.setFocusableInTouchMode(true);
                    if (SquareSearchActivity.this.iRM.hasFocus()) {
                        l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.iRM);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        bIk();
        this.lfA = (FrameLayout) findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), null, null);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            this.lfQ = (ScrollView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.home_searchbar_nodataview, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) this.lfQ.findViewById(R.id.focusbar_nodata_root);
            this.lfR = (SearchPageFocusBar) linearLayout.findViewById(R.id.no_data_focusbar);
            linearLayout.addView(this.mNoDataView, 0);
            this.lfQ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.26
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.lfQ);
                    return false;
                }
            });
            this.lfA.addView(this.lfQ, this.lfA.getChildCount());
        } else {
            this.lfA.addView(this.mNoDataView, 0);
        }
        this.lfB = (FrameLayout) findViewById(R.id.home_search_list);
        dfN();
        dfI();
        dfJ();
        dfK();
        this.lfC = (BaseWebView) findViewById(R.id.search_result_webview);
        this.lfC.initCommonJsBridge(getPageContext().getPageActivity());
        this.lfC.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.27
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
                if (SquareSearchActivity.this.isProgressBarShown()) {
                    SquareSearchActivity.this.hideProgressBar();
                }
            }
        });
        this.lfC.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.28
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedError", 0, "", "requesturl", str2, "receiveerror", Integer.valueOf(i), "description", str);
            }
        });
        this.lfC.setOnReceivedSslErrorListener(new BaseWebView.g() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.g
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                if (sslError != null) {
                    com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedSslError", 0, "", "requesturl", sslError.getUrl(), "receiveerror", sslError.toString());
                }
            }
        });
        this.lfC.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.3
            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.mainentrance.SquareSearchActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return be.bwu().a(SquareSearchActivity.this.getPageContext(), new String[]{str}) != 3;
            }
        });
        this.iRM.setText("");
        this.iRM.requestFocus();
        ShowSoftKeyPadDelay(this.iRM, 200);
        dfL();
        dfM();
    }

    private void bIk() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.gZe = (ImageView) addCustomView.findViewById(R.id.search_bar_icon);
        this.iRM = (EditText) addCustomView.findViewById(R.id.home_et_search);
        this.fiW = (ImageView) addCustomView.findViewById(R.id.home_bt_search_del);
        this.ioU = (TextView) addCustomView.findViewById(R.id.home_bt_search_cancel_s);
        this.iRM.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    SquareSearchActivity.this.dfH();
                } else {
                    l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.iRM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.dfH();
            }
        });
        this.ioU.setText(getPageContext().getString(R.string.cancel));
        this.ioU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.iRM);
                com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SquareSearchActivity.this.finish();
                    }
                }, 200L);
            }
        });
        this.iRM.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.7
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (SquareSearchActivity.this.jcX == null || SquareSearchActivity.this.jcX.trim().length() < 1) {
                        l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.iRM);
                        if (SquareSearchActivity.this.dfF()) {
                            return true;
                        }
                        SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(R.string.write_keyword));
                        return true;
                    }
                    String trim = SquareSearchActivity.this.iRM.getText().toString().trim();
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
        this.fiW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.iRM.setText("");
            }
        });
        this.iRM.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.9
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SquareSearchActivity.this.lfW) {
                    SquareSearchActivity.this.jcX = editable.toString();
                    if (StringUtils.isNull(SquareSearchActivity.this.jcX)) {
                        SquareSearchActivity.this.lfV = true;
                    }
                    SquareSearchActivity.this.dfQ();
                }
                if (editable.toString().trim().length() == 0) {
                    SquareSearchActivity.this.fiW.setVisibility(8);
                } else {
                    SquareSearchActivity.this.fiW.setVisibility(0);
                }
                ao.setViewTextColor(SquareSearchActivity.this.ioU, R.color.CAM_X0302, 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfH() {
        if (StringUtils.isNull(this.iRM.getText().toString())) {
            if (this.lfD.getVisibility() != 0) {
                dfO();
            }
        } else if (this.lfI.getVisibility() != 0) {
            dfQ();
        }
    }

    private void dfI() {
        this.lfD = (ScrollView) findViewById(R.id.search_history_scrollview);
        this.lfE = (LinearLayout) findViewById(R.id.search_history_linearlayout);
        if (this.lfH == null) {
            this.lfH = new LinearLayout(getPageContext().getPageActivity());
            this.lfH.setOrientation(1);
            this.lfH.setBackgroundColor(ao.getColor(R.color.CAM_X0201));
        }
        this.lfE.addView(this.lfH);
    }

    private void dfJ() {
        if (this.lfG == null) {
            this.lfG = new g(getPageContext());
            this.lfE.addView(this.lfG.createView());
        }
    }

    private void dfK() {
        this.lfI = (BdListView) findViewById(R.id.home_lv_search_suggest);
        this.lfJ = new com.baidu.tieba.mainentrance.a(this, null);
        this.lfK = new com.baidu.tieba.mainentrance.searchSuggestList.b(getPageContext().getPageActivity(), null);
        this.lfI.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.10
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
        this.lfI.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.11
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

    public void dfL() {
        this.ioU.setText(getPageContext().getString(R.string.cancel));
        dfM();
        dfG();
        dfR();
        if (this.jcX.trim().length() > 0) {
            dfQ();
        } else {
            dfO();
        }
    }

    private void dfM() {
        if (this.mHotSearchInfo == null) {
            this.iRM.setHint(R.string.search_bar);
        } else {
            this.iRM.setHint(" " + UtilHelper.getFixedText(this.mHotSearchInfo.cxL(), 15));
        }
    }

    private void dfN() {
        HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.bvq().getString(SharedPrefConfig.HOT_SEARCH_INFO, ""), HotSearchInfoData.class);
        if (hotSearchInfoData != null && hotSearchInfoData.getId() != 0) {
            this.mHotSearchInfo = hotSearchInfoData;
        }
    }

    private void dfO() {
        this.lfC.setVisibility(8);
        this.lfI.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA));
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            tH(true);
            dy(this.lfR);
            dy(this.lfQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(ArrayList<String> arrayList) {
        NoDataViewFactory.d ra;
        if (aT(arrayList)) {
            dfV();
            if (j.isNetWorkAvailable()) {
                ra = NoDataViewFactory.d.ra(R.string.text_no_search_record);
            } else {
                ra = NoDataViewFactory.d.ra(R.string.neterror);
            }
            this.mNoDataView.setTextOption(ra);
            return;
        }
        dfU();
        aS(arrayList);
        am(true, arrayList == null || arrayList.size() == 0);
        dfM();
    }

    private void aS(final ArrayList<String> arrayList) {
        if (this.lfH != null) {
            this.lfH.removeAllViews();
            if (arrayList != null && !arrayList.isEmpty() && getActivity() != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                this.lfS = LayoutInflater.from(pageActivity).inflate(R.layout.square_search_recommand_fourm_header, (ViewGroup) null);
                this.lfS.findViewById(R.id.titleTopDivider).setVisibility(8);
                getLayoutMode().onModeChanged(this.lfS);
                this.lfH.addView(this.lfS, layoutParams);
                int size = arrayList.size();
                this.lfU.clear();
                for (int i = 0; i < size; i++) {
                    final String str = arrayList.get(i);
                    if (!TextUtils.isEmpty(str)) {
                        final View inflate = LayoutInflater.from(pageActivity).inflate(R.layout.home_dialog_search_item, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.home_lv_search_forum)).setText(str);
                        ao.setViewTextColor((TextView) inflate.findViewById(R.id.home_lv_search_forum), R.color.CAM_X0105, 1);
                        inflate.findViewById(R.id.home_dialog_lv_search_forum_divider).setVisibility(8);
                        ao.setBackgroundResource(inflate, R.drawable.square_search_item_bg);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        inflate.setOnClickListener(new b(str));
                        ImageView imageView = (ImageView) inflate.findViewById(R.id.del_search_history_btn);
                        ao.setImageResource(imageView, R.drawable.icn_shop_order_close);
                        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                ac.a(new ab<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // com.baidu.tbadk.util.ab
                                    public Boolean doInBackground() {
                                        com.baidu.tieba.tbadkCore.util.a.TH(str);
                                        return true;
                                    }
                                }, new com.baidu.tbadk.util.l<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.2
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.tbadk.util.l
                                    public void onReturnDataInUI(Boolean bool) {
                                        SquareSearchActivity.this.lfH.removeView(inflate);
                                        arrayList.remove(str);
                                        if (arrayList.size() <= 0) {
                                            SquareSearchActivity.this.aR(null);
                                        }
                                    }
                                });
                            }
                        });
                        this.lfU.add(inflate);
                        this.lfH.addView(inflate, layoutParams2);
                    }
                }
                this.lfT = LayoutInflater.from(pageActivity).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
                ((TextView) this.lfT.findViewById(R.id.home_bt_search_footer)).setTextColor(ao.getColor(R.color.CAM_X0302));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                this.lfT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SquareSearchActivity.this.dfP();
                    }
                });
                this.lfH.addView(this.lfT, layoutParams3);
            }
        }
    }

    private void am(boolean z, boolean z2) {
        if (this.lfG != null) {
            this.lfG.clear();
            if (this.lfF != null && !this.lfF.isEmpty() && z) {
                this.lfG.tG(!z2);
                this.lfG.setTitleText(this.mTopicInfoTitle);
                int size = this.lfF.size();
                if (size >= 1) {
                    if (size > 7) {
                        size = 7;
                    }
                    int i = size % 2 == 0 ? size - 1 : size;
                    for (int i2 = 0; i2 < i; i2++) {
                        c cVar = (c) x.getItem(this.lfF, i2);
                        if (cVar != null) {
                            this.lfG.a(cVar, i2).setOnClickListener(this.lgc);
                        }
                    }
                    this.lfG.a(null, i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.16
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.iRM);
                            if (!com.baidu.tbadk.plugins.b.k(SquareSearchActivity.this.getPageContext())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all")));
                            }
                        }
                    });
                    this.lfG.show();
                }
            }
        }
    }

    private boolean aT(ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && (this.lfF == null || this.lfF.size() <= 2) && this.lfO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfP() {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).Bp(getPageContext().getString(R.string.alert_clean_history)).a(getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                h.mC().submitTask(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.dQe();
                    }
                });
                if (SquareSearchActivity.this.lfF == null || SquareSearchActivity.this.lfF.size() < 2) {
                    SquareSearchActivity.this.dx(SquareSearchActivity.this.lfQ);
                    SquareSearchActivity.this.dx(SquareSearchActivity.this.lfR);
                    SquareSearchActivity.this.lfB.setVisibility(8);
                    SquareSearchActivity.this.mNoDataView.setVisibility(0);
                    SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.ra(R.string.text_no_search_record));
                    return;
                }
                SquareSearchActivity.this.aR(null);
            }
        }).b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.17
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        }).b(getPageContext()).btX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfQ() {
        if (this.jcX.trim().length() > 0) {
            dfS();
            return;
        }
        dfG();
        dfO();
    }

    private void dfR() {
        if (this.lfI != null) {
            this.lfI.setNextPage(null);
        }
    }

    private void dfS() {
        if (!StringUtils.isNull(this.jcX)) {
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.jcX.trim();
            sendMessage(searchListNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        try {
            if (this.lfL != null) {
                if (this.lfL.forum_list != null && this.lfL.forum_list.size() > 0) {
                    dfT();
                    this.lfI.setAdapter((ListAdapter) this.lfJ);
                    this.lfJ.Oj(this.jcX);
                    this.lfJ.aQ(this.lfL.forum_list);
                    this.lfJ.notifyDataSetInvalidated();
                } else {
                    dy(this.lfQ);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfT() {
        this.lfB.setVisibility(0);
        this.lfI.setVisibility(0);
        this.lfD.setVisibility(8);
        this.lfC.setVisibility(8);
        dy(this.lfQ);
        this.mNoDataView.setVisibility(8);
    }

    private void dfU() {
        this.lfB.setVisibility(0);
        this.lfD.setVisibility(0);
        this.lfI.setVisibility(8);
        this.lfC.setVisibility(8);
        dy(this.lfQ);
        this.mNoDataView.setVisibility(8);
    }

    private void dfV() {
        this.lfB.setVisibility(8);
        this.lfI.setVisibility(8);
        this.lfD.setVisibility(8);
        this.lfC.setVisibility(8);
        dx(this.lfQ);
        this.mNoDataView.setVisibility(0);
        dx(this.lfR);
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void Ok(String str) {
        this.lfO = true;
        this.lfF = new ArrayList();
        dfO();
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void a(List<com.baidu.tieba.mainentrance.b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str) {
        this.lfO = true;
        hideLoadingView(this.lfA);
        if (list2 == null) {
            this.lfF = new ArrayList();
        } else {
            this.lfF = list2;
        }
        if (!StringUtils.isNULL(str)) {
            this.mTopicInfoTitle = str;
        } else {
            this.mTopicInfoTitle = "";
        }
        a(hotSearchInfoData);
        this.mHotSearchInfo = hotSearchInfoData;
        dfO();
    }

    private void a(HotSearchInfoData hotSearchInfoData) {
        if (hotSearchInfoData != null) {
            com.baidu.tbadk.core.sharedPref.b.bvq().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData));
            return;
        }
        HotSearchInfoData hotSearchInfoData2 = new HotSearchInfoData();
        hotSearchInfoData2.setId(0L);
        hotSearchInfoData2.setName("");
        hotSearchInfoData2.Ol("");
        hotSearchInfoData2.setType(0L);
        com.baidu.tbadk.core.sharedPref.b.bvq().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData2));
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
        getLayoutMode().onModeChanged(this.lfz);
        ao.setBgColor(this.lfz, i);
        if (this.lfJ != null) {
            this.lfJ.notifyDataSetChanged();
        }
        if (i == 2) {
            this.iRM.setHintTextColor(ao.getColor(R.color.s_navbar_title_color));
        } else {
            this.iRM.setHintTextColor(ao.getColor(R.color.CAM_X0110));
        }
        SvgManager.bwq().a(this.fiW, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ao.setNavbarTitleColor(this.iRM, R.color.CAM_X0105, R.color.s_navbar_title_color);
        SvgManager.bwq().a(this.gZe, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        ao.setBackgroundResource(this.lfA, R.color.CAM_X0201);
        ao.setViewTextColor(this.ioU, R.color.CAM_X0302, 1);
        if (this.lfG != null) {
            this.lfG.onChangeSkinType(i);
        }
        FA(i);
    }

    private void FA(int i) {
        if (this.lfH != null) {
            this.lfH.setBackgroundColor(ao.getColor(R.color.CAM_X0201));
        }
        if (this.lfS != null) {
            getLayoutMode().onModeChanged(this.lfS);
        }
        if (this.lfT != null) {
            ((TextView) this.lfT.findViewById(R.id.home_bt_search_footer)).setTextColor(ao.getColor(R.color.CAM_X0302));
        }
        if (this.lfU != null) {
            for (View view : this.lfU) {
                ao.setViewTextColor((TextView) view.findViewById(R.id.home_lv_search_forum), R.color.CAM_X0105, 1);
                view.findViewById(R.id.home_dialog_lv_search_forum_divider).setBackgroundColor(ao.getColor(R.color.CAM_X0204));
                ao.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (i == 4 && this.lfC.canGoBack()) {
                this.lfC.goBack();
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
            this.mNoDataView.bxw();
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
                SquareSearchActivity.this.jcX = this.mName;
                TiebaStatic.log(new aq("c12034"));
                SquareSearchActivity.this.aU(this.mName, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dfW() {
        if (!j.isNetWorkAvailable()) {
            dx(this.mNoDataView);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.ra(R.string.neterror));
            return true;
        }
        dy(this.mNoDataView);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
        private BasicNameValuePair lgk;
        private z mNetwork = null;
        private String mUrl;

        public a(String str, BasicNameValuePair basicNameValuePair, boolean z) {
            this.mUrl = null;
            this.lgk = null;
            this.mUrl = str;
            this.lgk = basicNameValuePair;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!SquareSearchActivity.this.dfW()) {
                SquareSearchActivity.this.dy(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.lfA, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(R.dimen.ds320));
                SquareSearchActivity.this.lfB.setVisibility(8);
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
                    this.mNetwork.addPostData(this.lgk);
                    String postNetData = this.mNetwork.postNetData();
                    if (postNetData != null) {
                        forumSuggestModel = ForumSuggestModel.parserJson(postNetData);
                        SquareSearchActivity.this.lfN = this.lgk.getValue();
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
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.lfA);
            if (forumSuggestModel != null) {
                SquareSearchActivity.this.dy(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.lfL = forumSuggestModel;
                SquareSearchActivity.this.refresh();
            } else {
                SquareSearchActivity.this.dx(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.ra(R.string.text_no_search_record));
            }
            SquareSearchActivity.this.lfM = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.lfA);
            super.cancel(true);
        }
    }

    private void tH(boolean z) {
        if (TbadkCoreApplication.isLogin()) {
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(CmdConfigCustom.CMD_REQUEST_ENTER_FORUM_MESSAGE, true));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(CmdConfigCustom.CMD_REQUEST_ENTER_FORUM_MESSAGE, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dx(View view) {
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dy(View view) {
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
                this.lfW = false;
                this.iRM.setText(str);
                this.iRM.setSelection(str.length());
                this.lfW = true;
            }
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.iRM);
            this.lfD.setVisibility(8);
            this.lfI.setVisibility(8);
            this.lfC.setVisibility(0);
            showProgressBarWithOffset(0, 0);
            String str2 = TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + TbConfig.SQUARE_SEARCH_PAGE + str;
            try {
                str2 = TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            this.lfC.loadUrl(str2);
            ac.a(new ab<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ab
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.TF(str);
                    return true;
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Om(String str) {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (!StringUtils.isNull(str)) {
            this.lfX = str;
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CREATE_BAR)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), str)));
            }
        }
    }
}
