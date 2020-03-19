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
import com.baidu.android.imsdk.utils.HanziToPinyin;
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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes11.dex */
public class SquareSearchActivity extends BaseActivity<SquareSearchActivity> implements HotForumModel.a {
    private ImageView eEr;
    private ImageView fDM;
    private TextView fDN;
    private EditText gbP;
    private String gnk;
    private HotForumModel igJ;
    private LinearLayoutDetectsSoftKeyboard igV;
    private FrameLayout igW;
    private FrameLayout igX;
    private BaseWebView igY;
    private ScrollView igZ;
    private LinearLayout iha;
    private List<c> ihb;
    private g ihc;
    private LinearLayout ihd;
    private BdListView ihe;
    private com.baidu.tieba.mainentrance.a ihf;
    private com.baidu.tieba.mainentrance.searchSuggestList.b ihg;
    private ForumSuggestModel ihh;
    private a ihi;
    private String ihj;
    private boolean ihk;
    private ScrollView ihm;
    private SearchPageFocusBar ihn;
    private View iho;
    private View ihp;
    private String iht;
    private HotSearchInfoData mHotSearchInfo;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mTopicInfoTitle;
    private boolean ihl = true;
    private List<View> ihq = new ArrayList();
    private boolean igH = false;
    private boolean ihr = true;
    private boolean ihs = true;
    private Runnable ihu = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.1
        @Override // java.lang.Runnable
        public void run() {
            SquareSearchActivity.this.gbP.requestFocus();
            l.showSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.gbP);
        }
    };
    private final Runnable ihv = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.12
        @Override // java.lang.Runnable
        public void run() {
            if (!SquareSearchActivity.this.ceE()) {
                try {
                    if (SquareSearchActivity.this.gnk != null && SquareSearchActivity.this.gnk.length() > 0) {
                        StringBuffer stringBuffer = new StringBuffer(30);
                        stringBuffer.append(TbConfig.SERVER_ADDRESS);
                        stringBuffer.append(Config.SUGGEST_BAR_ADDRESS);
                        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", SquareSearchActivity.this.gnk.trim());
                        SquareSearchActivity.this.ceo();
                        SquareSearchActivity.this.ihi = new a(stringBuffer.toString(), basicNameValuePair, true);
                        SquareSearchActivity.this.ihi.setPriority(3);
                        SquareSearchActivity.this.ihi.execute(stringBuffer.toString(), basicNameValuePair);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a ihw = new com.baidu.adp.framework.listener.a(1003196, CmdConfigSocket.CMD_SEARCH_LIST) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.22
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = ((responsedMessage instanceof SearchListHttpResMessage) || (responsedMessage instanceof SearchListSocketResMessage)) ? false : true;
            if (responsedMessage == null || z || responsedMessage.getError() != 0 || responsedMessage.hasError()) {
                if (j.isNetWorkAvailable() || !SquareSearchActivity.this.igH) {
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(R.string.neterror));
                }
                if (!j.isNetWorkAvailable()) {
                    SquareSearchActivity.this.igH = true;
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
            if (SquareSearchActivity.this.ihr && responsedMessage.getError() != 0) {
                SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(R.string.neterror));
                return;
            }
            if (list != null && list.size() > 0) {
                SquareSearchActivity.this.ihr = false;
            }
            SquareSearchActivity.this.ceB();
            SquareSearchActivity.this.ihe.setAdapter((ListAdapter) SquareSearchActivity.this.ihg);
            SquareSearchActivity.this.ihg.En(SquareSearchActivity.this.gnk.trim());
            SquareSearchActivity.this.ihg.setData(list);
            SquareSearchActivity.this.ihg.notifyDataSetInvalidated();
        }
    };
    private CustomMessageListener igM = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_CREATE_BAR) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                SquareSearchActivity.this.Eq(customResponsedMessage.getData().toString());
            }
        }
    };
    private CustomMessageListener ihx = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof ArrayList) {
                    SquareSearchActivity.this.az((ArrayList) data);
                }
            }
        }
    };
    private View.OnClickListener ihy = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.gbP);
            if (view.getTag() instanceof c) {
                c cVar = (c) view.getTag();
                TiebaStatic.log(new an("c10363").cx("obj_name", cVar.getName()));
                if (!com.baidu.tbadk.plugins.b.h(SquareSearchActivity.this.getPageContext())) {
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
                if (SquareSearchActivity.this.igY.getUrl() != null && SquareSearchActivity.this.igY.getUrl().contains(str)) {
                    SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.igW);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cen() {
        if (this.mHotSearchInfo == null) {
            return false;
        }
        if (this.mHotSearchInfo.getType() == 0) {
            aq(this.mHotSearchInfo.getName(), false);
        } else if (this.mHotSearchInfo.getType() == 1 && !com.baidu.tbadk.plugins.b.h(getPageContext())) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new an("c10355").cx("obj_name", this.mHotSearchInfo.getName()).X("obj_type", this.mHotSearchInfo.getType() == 0 ? 2 : 1));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.home_dialog_search);
        init();
        getWindow().setSoftInputMode(1);
        registerListener(this.ihx);
        registerListener(this.ihw);
        registerListener(this.igM);
        registerListener(this.htmlLoadMessageListener);
        if (SquareSearchActivityConfig.IS_SHOW_RECOMMEND_FORUM) {
            this.igJ = new HotForumModel(getPageContext(), this);
            this.igJ.cek();
        }
        this.ihk = false;
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
        hideLoadingView(this.igW);
        this.mHandler.removeCallbacks(this.ihu);
        ceo();
    }

    public void ceo() {
        this.mHandler.removeCallbacks(this.ihv);
        if (this.ihi != null) {
            this.ihi.cancel();
            this.ihi = null;
        }
    }

    private void init() {
        this.igV = (LinearLayoutDetectsSoftKeyboard) findViewById(R.id.parent);
        this.igV.setOnSoftKeyBoardShownListener(new LinearLayoutDetectsSoftKeyboard.a() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.24
            @Override // com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard.a
            public void bp(boolean z) {
                SquareSearchActivity.this.ihl = z;
            }
        });
        this.igV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.25
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    SquareSearchActivity.this.igV.setFocusable(true);
                    SquareSearchActivity.this.igV.setFocusableInTouchMode(true);
                    if (SquareSearchActivity.this.gbP.hasFocus()) {
                        l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.gbP);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        bcO();
        this.igW = (FrameLayout) findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), null, null);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            this.ihm = (ScrollView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.home_searchbar_nodataview, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) this.ihm.findViewById(R.id.focusbar_nodata_root);
            this.ihn = (SearchPageFocusBar) linearLayout.findViewById(R.id.no_data_focusbar);
            linearLayout.addView(this.mNoDataView, 0);
            this.ihm.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.26
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.ihm);
                    return false;
                }
            });
            this.igW.addView(this.ihm, this.igW.getChildCount());
        } else {
            this.igW.addView(this.mNoDataView, 0);
        }
        this.igX = (FrameLayout) findViewById(R.id.home_search_list);
        cev();
        ceq();
        cer();
        ces();
        this.igY = (BaseWebView) findViewById(R.id.search_result_webview);
        this.igY.initCommonJsBridge(getPageContext().getPageActivity());
        this.igY.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.27
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
                if (SquareSearchActivity.this.isProgressBarShown()) {
                    SquareSearchActivity.this.hideProgressBar();
                }
            }
        });
        this.igY.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.28
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedError", 0, "", "requesturl", str2, "receiveerror", Integer.valueOf(i), "description", str);
            }
        });
        this.igY.setOnReceivedSslErrorListener(new BaseWebView.g() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.g
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                if (sslError != null) {
                    com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedSslError", 0, "", "requesturl", sslError.getUrl(), "receiveerror", sslError.toString());
                }
            }
        });
        this.igY.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.3
            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.mainentrance.SquareSearchActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return ba.aGK().a(SquareSearchActivity.this.getPageContext(), new String[]{str}) != 3;
            }
        });
        this.gbP.setText("");
        this.gbP.requestFocus();
        ShowSoftKeyPadDelay(this.gbP, 200);
        cet();
        ceu();
    }

    private void bcO() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.eEr = (ImageView) addCustomView.findViewById(R.id.search_bar_icon);
        this.gbP = (EditText) addCustomView.findViewById(R.id.home_et_search);
        this.fDM = (ImageView) addCustomView.findViewById(R.id.home_bt_search_del);
        this.fDN = (TextView) addCustomView.findViewById(R.id.home_bt_search_cancel_s);
        this.gbP.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    SquareSearchActivity.this.cep();
                } else {
                    l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.gbP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.cep();
            }
        });
        this.fDN.setText(getPageContext().getString(R.string.cancel));
        this.fDN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.gbP);
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SquareSearchActivity.this.finish();
                    }
                }, 200L);
            }
        });
        this.gbP.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.7
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (SquareSearchActivity.this.gnk == null || SquareSearchActivity.this.gnk.trim().length() < 1) {
                        l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.gbP);
                        if (SquareSearchActivity.this.cen()) {
                            return true;
                        }
                        SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(R.string.write_keyword));
                        return true;
                    }
                    String trim = SquareSearchActivity.this.gbP.getText().toString().trim();
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
        this.fDM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.gbP.setText("");
            }
        });
        this.gbP.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.9
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SquareSearchActivity.this.ihs) {
                    SquareSearchActivity.this.gnk = editable.toString();
                    if (StringUtils.isNull(SquareSearchActivity.this.gnk)) {
                        SquareSearchActivity.this.ihr = true;
                    }
                    SquareSearchActivity.this.cey();
                }
                if (editable.toString().trim().length() == 0) {
                    SquareSearchActivity.this.fDM.setVisibility(8);
                } else {
                    SquareSearchActivity.this.fDM.setVisibility(0);
                }
                am.setViewTextColor(SquareSearchActivity.this.fDN, R.color.cp_link_tip_a, 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cep() {
        if (StringUtils.isNull(this.gbP.getText().toString())) {
            if (this.igZ.getVisibility() != 0) {
                cew();
            }
        } else if (this.ihe.getVisibility() != 0) {
            cey();
        }
    }

    private void ceq() {
        this.igZ = (ScrollView) findViewById(R.id.search_history_scrollview);
        this.iha = (LinearLayout) findViewById(R.id.search_history_linearlayout);
        if (this.ihd == null) {
            this.ihd = new LinearLayout(getPageContext().getPageActivity());
            this.ihd.setOrientation(1);
            this.ihd.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
        }
        this.iha.addView(this.ihd);
    }

    private void cer() {
        if (this.ihc == null) {
            this.ihc = new g(getPageContext());
            this.iha.addView(this.ihc.createView());
        }
    }

    private void ces() {
        this.ihe = (BdListView) findViewById(R.id.home_lv_search_suggest);
        this.ihf = new com.baidu.tieba.mainentrance.a(this, null);
        this.ihg = new com.baidu.tieba.mainentrance.searchSuggestList.b(getPageContext().getPageActivity(), null);
        this.ihe.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.10
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
        this.ihe.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.11
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

    public void cet() {
        this.fDN.setText(getPageContext().getString(R.string.cancel));
        ceu();
        ceo();
        cez();
        if (this.gnk.trim().length() > 0) {
            cey();
        } else {
            cew();
        }
    }

    private void ceu() {
        if (this.mHotSearchInfo == null) {
            this.gbP.setHint(R.string.search_bar);
        } else {
            this.gbP.setHint(HanziToPinyin.Token.SEPARATOR + UtilHelper.getFixedText(this.mHotSearchInfo.bxU(), 15));
        }
    }

    private void cev() {
        HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.aFH().getString(SharedPrefConfig.HOT_SEARCH_INFO, ""), HotSearchInfoData.class);
        if (hotSearchInfoData != null && hotSearchInfoData.getId() != 0) {
            this.mHotSearchInfo = hotSearchInfoData;
        }
    }

    private void cew() {
        this.igY.setVisibility(8);
        this.ihe.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA));
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            oK(true);
            co(this.ihn);
            co(this.ihm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az(ArrayList<String> arrayList) {
        NoDataViewFactory.d lh;
        if (aB(arrayList)) {
            ceD();
            if (j.isNetWorkAvailable()) {
                lh = NoDataViewFactory.d.lh(R.string.text_no_search_record);
            } else {
                lh = NoDataViewFactory.d.lh(R.string.neterror);
            }
            this.mNoDataView.setTextOption(lh);
            return;
        }
        ceC();
        aA(arrayList);
        X(true, arrayList == null || arrayList.size() == 0);
        ceu();
    }

    private void aA(final ArrayList<String> arrayList) {
        if (this.ihd != null) {
            this.ihd.removeAllViews();
            if (arrayList != null && !arrayList.isEmpty() && getActivity() != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                this.iho = LayoutInflater.from(pageActivity).inflate(R.layout.square_search_recommand_fourm_header, (ViewGroup) null);
                this.iho.findViewById(R.id.titleTopDivider).setVisibility(8);
                getLayoutMode().onModeChanged(this.iho);
                this.ihd.addView(this.iho, layoutParams);
                int size = arrayList.size();
                this.ihq.clear();
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
                                ac.a(new ab<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // com.baidu.tbadk.util.ab
                                    public Boolean doInBackground() {
                                        com.baidu.tieba.tbadkCore.util.a.Jl(str);
                                        return true;
                                    }
                                }, new com.baidu.tbadk.util.l<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.2
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.tbadk.util.l
                                    public void onReturnDataInUI(Boolean bool) {
                                        SquareSearchActivity.this.ihd.removeView(inflate);
                                        arrayList.remove(str);
                                        if (arrayList.size() <= 0) {
                                            SquareSearchActivity.this.az(null);
                                        }
                                    }
                                });
                            }
                        });
                        this.ihq.add(inflate);
                        this.ihd.addView(inflate, layoutParams2);
                    }
                }
                this.ihp = LayoutInflater.from(pageActivity).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
                ((TextView) this.ihp.findViewById(R.id.home_bt_search_footer)).setTextColor(am.getColor(R.color.cp_link_tip_a));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                this.ihp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SquareSearchActivity.this.cex();
                    }
                });
                this.ihd.addView(this.ihp, layoutParams3);
            }
        }
    }

    private void X(boolean z, boolean z2) {
        if (this.ihc != null) {
            this.ihc.clear();
            if (this.ihb != null && !this.ihb.isEmpty() && z) {
                this.ihc.oJ(!z2);
                this.ihc.setTitleText(this.mTopicInfoTitle);
                int size = this.ihb.size();
                if (size >= 1) {
                    if (size > 7) {
                        size = 7;
                    }
                    int i = size % 2 == 0 ? size - 1 : size;
                    for (int i2 = 0; i2 < i; i2++) {
                        c cVar = (c) v.getItem(this.ihb, i2);
                        if (cVar != null) {
                            this.ihc.a(cVar, i2).setOnClickListener(this.ihy);
                        }
                    }
                    this.ihc.a(null, i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.16
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.gbP);
                            if (!com.baidu.tbadk.plugins.b.h(SquareSearchActivity.this.getPageContext())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", SchemeCollecter.CLASSIFY_ALL)));
                            }
                        }
                    });
                    this.ihc.show();
                }
            }
        }
    }

    private boolean aB(ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && (this.ihb == null || this.ihb.size() <= 2) && this.ihk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cex() {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).sS(getPageContext().getString(R.string.alert_clean_history)).a(getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                h.gy().submitTask(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.cMp();
                    }
                });
                if (SquareSearchActivity.this.ihb == null || SquareSearchActivity.this.ihb.size() < 2) {
                    SquareSearchActivity.this.cn(SquareSearchActivity.this.ihm);
                    SquareSearchActivity.this.cn(SquareSearchActivity.this.ihn);
                    SquareSearchActivity.this.igX.setVisibility(8);
                    SquareSearchActivity.this.mNoDataView.setVisibility(0);
                    SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.lh(R.string.text_no_search_record));
                    return;
                }
                SquareSearchActivity.this.az(null);
            }
        }).b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.17
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        }).b(getPageContext()).aEG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cey() {
        if (this.gnk.trim().length() > 0) {
            ceA();
            return;
        }
        ceo();
        cew();
    }

    private void cez() {
        if (this.ihe != null) {
            this.ihe.setNextPage(null);
        }
    }

    private void ceA() {
        if (!StringUtils.isNull(this.gnk)) {
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.gnk.trim();
            sendMessage(searchListNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        try {
            if (this.ihh != null) {
                if (this.ihh.forum_list != null && this.ihh.forum_list.size() > 0) {
                    ceB();
                    this.ihe.setAdapter((ListAdapter) this.ihf);
                    this.ihf.En(this.gnk);
                    this.ihf.ay(this.ihh.forum_list);
                    this.ihf.notifyDataSetInvalidated();
                } else {
                    co(this.ihm);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceB() {
        this.igX.setVisibility(0);
        this.ihe.setVisibility(0);
        this.igZ.setVisibility(8);
        this.igY.setVisibility(8);
        co(this.ihm);
        this.mNoDataView.setVisibility(8);
    }

    private void ceC() {
        this.igX.setVisibility(0);
        this.igZ.setVisibility(0);
        this.ihe.setVisibility(8);
        this.igY.setVisibility(8);
        co(this.ihm);
        this.mNoDataView.setVisibility(8);
    }

    private void ceD() {
        this.igX.setVisibility(8);
        this.ihe.setVisibility(8);
        this.igZ.setVisibility(8);
        this.igY.setVisibility(8);
        cn(this.ihm);
        this.mNoDataView.setVisibility(0);
        cn(this.ihn);
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void Eo(String str) {
        this.ihk = true;
        this.ihb = new ArrayList();
        cew();
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void a(List<com.baidu.tieba.mainentrance.b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str) {
        this.ihk = true;
        hideLoadingView(this.igW);
        if (list2 == null) {
            this.ihb = new ArrayList();
        } else {
            this.ihb = list2;
        }
        if (!StringUtils.isNULL(str)) {
            this.mTopicInfoTitle = str;
        } else {
            this.mTopicInfoTitle = "";
        }
        a(hotSearchInfoData);
        this.mHotSearchInfo = hotSearchInfoData;
        cew();
    }

    private void a(HotSearchInfoData hotSearchInfoData) {
        if (hotSearchInfoData != null) {
            com.baidu.tbadk.core.sharedPref.b.aFH().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData));
            return;
        }
        HotSearchInfoData hotSearchInfoData2 = new HotSearchInfoData();
        hotSearchInfoData2.setId(0L);
        hotSearchInfoData2.setName("");
        hotSearchInfoData2.Ep("");
        hotSearchInfoData2.setType(0L);
        com.baidu.tbadk.core.sharedPref.b.aFH().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData2));
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
        getLayoutMode().onModeChanged(this.igV);
        am.setBgColor(this.igV, i);
        if (this.ihf != null) {
            this.ihf.notifyDataSetChanged();
        }
        if (i == 2) {
            this.gbP.setHintTextColor(am.getColor(R.color.s_navbar_title_color));
        } else {
            this.gbP.setHintTextColor(am.getColor(R.color.cp_cont_e));
        }
        SvgManager.aGG().a(this.fDM, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setNavbarTitleColor(this.gbP, R.color.cp_cont_b, R.color.s_navbar_title_color);
        SvgManager.aGG().a(this.eEr, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        am.setBackgroundResource(this.igW, R.color.cp_bg_line_d);
        am.setViewTextColor(this.fDN, R.color.cp_link_tip_a, 1);
        if (this.ihc != null) {
            this.ihc.onChangeSkinType(i);
        }
        xS(i);
    }

    private void xS(int i) {
        if (this.ihd != null) {
            this.ihd.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
        }
        if (this.iho != null) {
            getLayoutMode().onModeChanged(this.iho);
        }
        if (this.ihp != null) {
            ((TextView) this.ihp.findViewById(R.id.home_bt_search_footer)).setTextColor(am.getColor(R.color.cp_link_tip_a));
        }
        if (this.ihq != null) {
            for (View view : this.ihq) {
                am.setViewTextColor((TextView) view.findViewById(R.id.home_lv_search_forum), R.color.cp_cont_b, 1);
                view.findViewById(R.id.home_dialog_lv_search_forum_divider).setBackgroundColor(am.getColor(R.color.cp_bg_line_c));
                am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (i == 4 && this.igY.canGoBack()) {
                this.igY.goBack();
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
            com.baidu.tbadk.core.e.b.v(getPageContext().getPageActivity(), 1);
        } else {
            com.baidu.tbadk.core.e.b.v(getPageContext().getPageActivity(), 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        setSkinType(3);
        if (this.mNoDataView != null) {
            this.mNoDataView.aHG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b implements View.OnClickListener {
        private String mName;

        public b(String str) {
            this.mName = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(this.mName)) {
                SquareSearchActivity.this.gnk = this.mName;
                TiebaStatic.log(new an("c12034"));
                SquareSearchActivity.this.aq(this.mName, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ceE() {
        if (!j.isNetWorkAvailable()) {
            cn(this.mNoDataView);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.lh(R.string.neterror));
            return true;
        }
        co(this.mNoDataView);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
        private BasicNameValuePair ihG;
        private x mNetwork = null;
        private String mUrl;

        public a(String str, BasicNameValuePair basicNameValuePair, boolean z) {
            this.mUrl = null;
            this.ihG = null;
            this.mUrl = str;
            this.ihG = basicNameValuePair;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!SquareSearchActivity.this.ceE()) {
                SquareSearchActivity.this.co(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.igW, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(R.dimen.ds320));
                SquareSearchActivity.this.igX.setVisibility(8);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public ForumSuggestModel doInBackground(Object... objArr) {
            ForumSuggestModel forumSuggestModel = null;
            if (j.isNetWorkAvailable()) {
                try {
                    this.mNetwork = new x(this.mUrl);
                    this.mNetwork.addPostData(this.ihG);
                    String postNetData = this.mNetwork.postNetData();
                    if (postNetData != null) {
                        forumSuggestModel = ForumSuggestModel.parserJson(postNetData);
                        SquareSearchActivity.this.ihj = this.ihG.getValue();
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
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.igW);
            if (forumSuggestModel != null) {
                SquareSearchActivity.this.co(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.ihh = forumSuggestModel;
                SquareSearchActivity.this.refresh();
            } else {
                SquareSearchActivity.this.cn(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.lh(R.string.text_no_search_record));
            }
            SquareSearchActivity.this.ihi = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.igW);
            super.cancel(true);
        }
    }

    private void oK(boolean z) {
        if (TbadkCoreApplication.isLogin()) {
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(CmdConfigCustom.CMD_REQUEST_ENTER_FORUM_MESSAGE, true));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(CmdConfigCustom.CMD_REQUEST_ENTER_FORUM_MESSAGE, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cn(View view) {
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void co(View view) {
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SEARCH_RESULT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(final String str, boolean z) {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.ihs = false;
                this.gbP.setText(str);
                this.gbP.setSelection(str.length());
                this.ihs = true;
            }
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.gbP);
            this.igZ.setVisibility(8);
            this.ihe.setVisibility(8);
            this.igY.setVisibility(0);
            showProgressBarWithOffset(0, 0);
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            this.igY.loadUrl(str2);
            ac.a(new ab<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ab
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.Jj(str);
                    return true;
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eq(String str) {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (!StringUtils.isNull(str)) {
            this.iht = str;
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CREATE_BAR)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), str)));
            }
        }
    }
}
