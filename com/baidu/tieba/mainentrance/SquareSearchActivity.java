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
/* loaded from: classes9.dex */
public class SquareSearchActivity extends BaseActivity<SquareSearchActivity> implements HotForumModel.a {
    private ImageView ezA;
    private ImageView fAr;
    private TextView fAs;
    private EditText fYS;
    private String gkm;
    private HotForumModel icU;
    private ScrollView idB;
    private SearchPageFocusBar idC;
    private View idD;
    private View idE;
    private String idI;
    private LinearLayoutDetectsSoftKeyboard idg;
    private FrameLayout idh;
    private FrameLayout idi;
    private BaseWebView idj;
    private ScrollView idk;
    private LinearLayout idm;
    private List<c> idn;
    private g ido;
    private LinearLayout idp;
    private BdListView idq;
    private com.baidu.tieba.mainentrance.a idr;
    private com.baidu.tieba.mainentrance.searchSuggestList.b idu;
    private ForumSuggestModel idv;
    private a idw;
    private String idy;
    private boolean idz;
    private HotSearchInfoData mHotSearchInfo;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mTopicInfoTitle;
    private boolean idA = true;
    private List<View> idF = new ArrayList();
    private boolean icS = false;
    private boolean idG = true;
    private boolean idH = true;
    private Runnable idJ = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.1
        @Override // java.lang.Runnable
        public void run() {
            SquareSearchActivity.this.fYS.requestFocus();
            l.showSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.fYS);
        }
    };
    private final Runnable idK = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.12
        @Override // java.lang.Runnable
        public void run() {
            if (!SquareSearchActivity.this.ccE()) {
                try {
                    if (SquareSearchActivity.this.gkm != null && SquareSearchActivity.this.gkm.length() > 0) {
                        StringBuffer stringBuffer = new StringBuffer(30);
                        stringBuffer.append(TbConfig.SERVER_ADDRESS);
                        stringBuffer.append(Config.SUGGEST_BAR_ADDRESS);
                        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", SquareSearchActivity.this.gkm.trim());
                        SquareSearchActivity.this.cco();
                        SquareSearchActivity.this.idw = new a(stringBuffer.toString(), basicNameValuePair, true);
                        SquareSearchActivity.this.idw.setPriority(3);
                        SquareSearchActivity.this.idw.execute(stringBuffer.toString(), basicNameValuePair);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a idL = new com.baidu.adp.framework.listener.a(1003196, CmdConfigSocket.CMD_SEARCH_LIST) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.22
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = ((responsedMessage instanceof SearchListHttpResMessage) || (responsedMessage instanceof SearchListSocketResMessage)) ? false : true;
            if (responsedMessage == null || z || responsedMessage.getError() != 0 || responsedMessage.hasError()) {
                if (j.isNetWorkAvailable() || !SquareSearchActivity.this.icS) {
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(R.string.neterror));
                }
                if (!j.isNetWorkAvailable()) {
                    SquareSearchActivity.this.icS = true;
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
            if (SquareSearchActivity.this.idG && responsedMessage.getError() != 0) {
                SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(R.string.neterror));
                return;
            }
            if (list != null && list.size() > 0) {
                SquareSearchActivity.this.idG = false;
            }
            SquareSearchActivity.this.ccB();
            SquareSearchActivity.this.idq.setAdapter((ListAdapter) SquareSearchActivity.this.idu);
            SquareSearchActivity.this.idu.DW(SquareSearchActivity.this.gkm.trim());
            SquareSearchActivity.this.idu.setData(list);
            SquareSearchActivity.this.idu.notifyDataSetInvalidated();
        }
    };
    private CustomMessageListener icX = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_CREATE_BAR) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                SquareSearchActivity.this.DZ(customResponsedMessage.getData().toString());
            }
        }
    };
    private CustomMessageListener idM = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.13
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
    private View.OnClickListener idN = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.fYS);
            if (view.getTag() instanceof c) {
                c cVar = (c) view.getTag();
                TiebaStatic.log(new an("c10363").cp("obj_name", cVar.getName()));
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
                if (SquareSearchActivity.this.idj.getUrl() != null && SquareSearchActivity.this.idj.getUrl().contains(str)) {
                    SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.idh);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ccn() {
        if (this.mHotSearchInfo == null) {
            return false;
        }
        if (this.mHotSearchInfo.getType() == 0) {
            aq(this.mHotSearchInfo.getName(), false);
        } else if (this.mHotSearchInfo.getType() == 1 && !com.baidu.tbadk.plugins.b.h(getPageContext())) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new an("c10355").cp("obj_name", this.mHotSearchInfo.getName()).Z("obj_type", this.mHotSearchInfo.getType() == 0 ? 2 : 1));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.home_dialog_search);
        init();
        getWindow().setSoftInputMode(1);
        registerListener(this.idM);
        registerListener(this.idL);
        registerListener(this.icX);
        registerListener(this.htmlLoadMessageListener);
        if (SquareSearchActivityConfig.IS_SHOW_RECOMMEND_FORUM) {
            this.icU = new HotForumModel(getPageContext(), this);
            this.icU.cck();
        }
        this.idz = false;
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
        hideLoadingView(this.idh);
        this.mHandler.removeCallbacks(this.idJ);
        cco();
    }

    public void cco() {
        this.mHandler.removeCallbacks(this.idK);
        if (this.idw != null) {
            this.idw.cancel();
            this.idw = null;
        }
    }

    private void init() {
        this.idg = (LinearLayoutDetectsSoftKeyboard) findViewById(R.id.parent);
        this.idg.setOnSoftKeyBoardShownListener(new LinearLayoutDetectsSoftKeyboard.a() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.24
            @Override // com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard.a
            public void bg(boolean z) {
                SquareSearchActivity.this.idA = z;
            }
        });
        this.idg.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.25
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    SquareSearchActivity.this.idg.setFocusable(true);
                    SquareSearchActivity.this.idg.setFocusableInTouchMode(true);
                    if (SquareSearchActivity.this.fYS.hasFocus()) {
                        l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.fYS);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        bas();
        this.idh = (FrameLayout) findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), null, null);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            this.idB = (ScrollView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.home_searchbar_nodataview, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) this.idB.findViewById(R.id.focusbar_nodata_root);
            this.idC = (SearchPageFocusBar) linearLayout.findViewById(R.id.no_data_focusbar);
            linearLayout.addView(this.mNoDataView, 0);
            this.idB.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.26
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.idB);
                    return false;
                }
            });
            this.idh.addView(this.idB, this.idh.getChildCount());
        } else {
            this.idh.addView(this.mNoDataView, 0);
        }
        this.idi = (FrameLayout) findViewById(R.id.home_search_list);
        ccv();
        ccq();
        ccr();
        ccs();
        this.idj = (BaseWebView) findViewById(R.id.search_result_webview);
        this.idj.initCommonJsBridge(getPageContext().getPageActivity());
        this.idj.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.27
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
                if (SquareSearchActivity.this.isProgressBarShown()) {
                    SquareSearchActivity.this.hideProgressBar();
                }
            }
        });
        this.idj.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.28
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedError", 0, "", "requesturl", str2, "receiveerror", Integer.valueOf(i), "description", str);
            }
        });
        this.idj.setOnReceivedSslErrorListener(new BaseWebView.g() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.g
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                if (sslError != null) {
                    com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedSslError", 0, "", "requesturl", sslError.getUrl(), "receiveerror", sslError.toString());
                }
            }
        });
        this.idj.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.3
            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.mainentrance.SquareSearchActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return ba.aEt().a(SquareSearchActivity.this.getPageContext(), new String[]{str}) != 3;
            }
        });
        this.fYS.setText("");
        this.fYS.requestFocus();
        ShowSoftKeyPadDelay(this.fYS, 200);
        cct();
        ccu();
    }

    private void bas() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.ezA = (ImageView) addCustomView.findViewById(R.id.search_bar_icon);
        this.fYS = (EditText) addCustomView.findViewById(R.id.home_et_search);
        this.fAr = (ImageView) addCustomView.findViewById(R.id.home_bt_search_del);
        this.fAs = (TextView) addCustomView.findViewById(R.id.home_bt_search_cancel_s);
        this.fYS.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    SquareSearchActivity.this.ccp();
                } else {
                    l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.fYS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.ccp();
            }
        });
        this.fAs.setText(getPageContext().getString(R.string.cancel));
        this.fAs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.fYS);
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SquareSearchActivity.this.finish();
                    }
                }, 200L);
            }
        });
        this.fYS.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.7
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (SquareSearchActivity.this.gkm == null || SquareSearchActivity.this.gkm.trim().length() < 1) {
                        l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.fYS);
                        if (SquareSearchActivity.this.ccn()) {
                            return true;
                        }
                        SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(R.string.write_keyword));
                        return true;
                    }
                    String trim = SquareSearchActivity.this.fYS.getText().toString().trim();
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
        this.fAr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.fYS.setText("");
            }
        });
        this.fYS.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.9
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SquareSearchActivity.this.idH) {
                    SquareSearchActivity.this.gkm = editable.toString();
                    if (StringUtils.isNull(SquareSearchActivity.this.gkm)) {
                        SquareSearchActivity.this.idG = true;
                    }
                    SquareSearchActivity.this.ccy();
                }
                if (editable.toString().trim().length() == 0) {
                    SquareSearchActivity.this.fAr.setVisibility(8);
                } else {
                    SquareSearchActivity.this.fAr.setVisibility(0);
                }
                am.setViewTextColor(SquareSearchActivity.this.fAs, R.color.cp_link_tip_a, 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccp() {
        if (StringUtils.isNull(this.fYS.getText().toString())) {
            if (this.idk.getVisibility() != 0) {
                ccw();
            }
        } else if (this.idq.getVisibility() != 0) {
            ccy();
        }
    }

    private void ccq() {
        this.idk = (ScrollView) findViewById(R.id.search_history_scrollview);
        this.idm = (LinearLayout) findViewById(R.id.search_history_linearlayout);
        if (this.idp == null) {
            this.idp = new LinearLayout(getPageContext().getPageActivity());
            this.idp.setOrientation(1);
            this.idp.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
        }
        this.idm.addView(this.idp);
    }

    private void ccr() {
        if (this.ido == null) {
            this.ido = new g(getPageContext());
            this.idm.addView(this.ido.createView());
        }
    }

    private void ccs() {
        this.idq = (BdListView) findViewById(R.id.home_lv_search_suggest);
        this.idr = new com.baidu.tieba.mainentrance.a(this, null);
        this.idu = new com.baidu.tieba.mainentrance.searchSuggestList.b(getPageContext().getPageActivity(), null);
        this.idq.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.10
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
        this.idq.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.11
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

    public void cct() {
        this.fAs.setText(getPageContext().getString(R.string.cancel));
        ccu();
        cco();
        ccz();
        if (this.gkm.trim().length() > 0) {
            ccy();
        } else {
            ccw();
        }
    }

    private void ccu() {
        if (this.mHotSearchInfo == null) {
            this.fYS.setHint(R.string.search_bar);
        } else {
            this.fYS.setHint(HanziToPinyin.Token.SEPARATOR + UtilHelper.getFixedText(this.mHotSearchInfo.bwj(), 15));
        }
    }

    private void ccv() {
        HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.aDr().getString(SharedPrefConfig.HOT_SEARCH_INFO, ""), HotSearchInfoData.class);
        if (hotSearchInfoData != null && hotSearchInfoData.getId() != 0) {
            this.mHotSearchInfo = hotSearchInfoData;
        }
    }

    private void ccw() {
        this.idj.setVisibility(8);
        this.idq.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA));
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            oC(true);
            co(this.idC);
            co(this.idB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az(ArrayList<String> arrayList) {
        NoDataViewFactory.d kQ;
        if (aB(arrayList)) {
            ccD();
            if (j.isNetWorkAvailable()) {
                kQ = NoDataViewFactory.d.kQ(R.string.text_no_search_record);
            } else {
                kQ = NoDataViewFactory.d.kQ(R.string.neterror);
            }
            this.mNoDataView.setTextOption(kQ);
            return;
        }
        ccC();
        aA(arrayList);
        V(true, arrayList == null || arrayList.size() == 0);
        ccu();
    }

    private void aA(final ArrayList<String> arrayList) {
        if (this.idp != null) {
            this.idp.removeAllViews();
            if (arrayList != null && !arrayList.isEmpty() && getActivity() != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                this.idD = LayoutInflater.from(pageActivity).inflate(R.layout.square_search_recommand_fourm_header, (ViewGroup) null);
                this.idD.findViewById(R.id.titleTopDivider).setVisibility(8);
                getLayoutMode().onModeChanged(this.idD);
                this.idp.addView(this.idD, layoutParams);
                int size = arrayList.size();
                this.idF.clear();
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
                                        com.baidu.tieba.tbadkCore.util.a.IX(str);
                                        return true;
                                    }
                                }, new com.baidu.tbadk.util.l<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.2
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.tbadk.util.l
                                    public void onReturnDataInUI(Boolean bool) {
                                        SquareSearchActivity.this.idp.removeView(inflate);
                                        arrayList.remove(str);
                                        if (arrayList.size() <= 0) {
                                            SquareSearchActivity.this.az(null);
                                        }
                                    }
                                });
                            }
                        });
                        this.idF.add(inflate);
                        this.idp.addView(inflate, layoutParams2);
                    }
                }
                this.idE = LayoutInflater.from(pageActivity).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
                ((TextView) this.idE.findViewById(R.id.home_bt_search_footer)).setTextColor(am.getColor(R.color.cp_link_tip_a));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                this.idE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SquareSearchActivity.this.ccx();
                    }
                });
                this.idp.addView(this.idE, layoutParams3);
            }
        }
    }

    private void V(boolean z, boolean z2) {
        if (this.ido != null) {
            this.ido.clear();
            if (this.idn != null && !this.idn.isEmpty() && z) {
                this.ido.oB(!z2);
                this.ido.setTitleText(this.mTopicInfoTitle);
                int size = this.idn.size();
                if (size >= 1) {
                    if (size > 7) {
                        size = 7;
                    }
                    int i = size % 2 == 0 ? size - 1 : size;
                    for (int i2 = 0; i2 < i; i2++) {
                        c cVar = (c) v.getItem(this.idn, i2);
                        if (cVar != null) {
                            this.ido.a(cVar, i2).setOnClickListener(this.idN);
                        }
                    }
                    this.ido.a(null, i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.16
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            l.hideSoftKeyPad(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.fYS);
                            if (!com.baidu.tbadk.plugins.b.h(SquareSearchActivity.this.getPageContext())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", SchemeCollecter.CLASSIFY_ALL)));
                            }
                        }
                    });
                    this.ido.show();
                }
            }
        }
    }

    private boolean aB(ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && (this.idn == null || this.idn.size() <= 2) && this.idz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccx() {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).sC(getPageContext().getString(R.string.alert_clean_history)).a(getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                h.gy().submitTask(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.cKu();
                    }
                });
                if (SquareSearchActivity.this.idn == null || SquareSearchActivity.this.idn.size() < 2) {
                    SquareSearchActivity.this.cn(SquareSearchActivity.this.idB);
                    SquareSearchActivity.this.cn(SquareSearchActivity.this.idC);
                    SquareSearchActivity.this.idi.setVisibility(8);
                    SquareSearchActivity.this.mNoDataView.setVisibility(0);
                    SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.kQ(R.string.text_no_search_record));
                    return;
                }
                SquareSearchActivity.this.az(null);
            }
        }).b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.17
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        }).b(getPageContext()).aCp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccy() {
        if (this.gkm.trim().length() > 0) {
            ccA();
            return;
        }
        cco();
        ccw();
    }

    private void ccz() {
        if (this.idq != null) {
            this.idq.setNextPage(null);
        }
    }

    private void ccA() {
        if (!StringUtils.isNull(this.gkm)) {
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.gkm.trim();
            sendMessage(searchListNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        try {
            if (this.idv != null) {
                if (this.idv.forum_list != null && this.idv.forum_list.size() > 0) {
                    ccB();
                    this.idq.setAdapter((ListAdapter) this.idr);
                    this.idr.DW(this.gkm);
                    this.idr.ay(this.idv.forum_list);
                    this.idr.notifyDataSetInvalidated();
                } else {
                    co(this.idB);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccB() {
        this.idi.setVisibility(0);
        this.idq.setVisibility(0);
        this.idk.setVisibility(8);
        this.idj.setVisibility(8);
        co(this.idB);
        this.mNoDataView.setVisibility(8);
    }

    private void ccC() {
        this.idi.setVisibility(0);
        this.idk.setVisibility(0);
        this.idq.setVisibility(8);
        this.idj.setVisibility(8);
        co(this.idB);
        this.mNoDataView.setVisibility(8);
    }

    private void ccD() {
        this.idi.setVisibility(8);
        this.idq.setVisibility(8);
        this.idk.setVisibility(8);
        this.idj.setVisibility(8);
        cn(this.idB);
        this.mNoDataView.setVisibility(0);
        cn(this.idC);
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void DX(String str) {
        this.idz = true;
        this.idn = new ArrayList();
        ccw();
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void a(List<com.baidu.tieba.mainentrance.b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str) {
        this.idz = true;
        hideLoadingView(this.idh);
        if (list2 == null) {
            this.idn = new ArrayList();
        } else {
            this.idn = list2;
        }
        if (!StringUtils.isNULL(str)) {
            this.mTopicInfoTitle = str;
        } else {
            this.mTopicInfoTitle = "";
        }
        a(hotSearchInfoData);
        this.mHotSearchInfo = hotSearchInfoData;
        ccw();
    }

    private void a(HotSearchInfoData hotSearchInfoData) {
        if (hotSearchInfoData != null) {
            com.baidu.tbadk.core.sharedPref.b.aDr().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData));
            return;
        }
        HotSearchInfoData hotSearchInfoData2 = new HotSearchInfoData();
        hotSearchInfoData2.setId(0L);
        hotSearchInfoData2.setName("");
        hotSearchInfoData2.DY("");
        hotSearchInfoData2.setType(0L);
        com.baidu.tbadk.core.sharedPref.b.aDr().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData2));
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
        getLayoutMode().onModeChanged(this.idg);
        am.setBgColor(this.idg, i);
        if (this.idr != null) {
            this.idr.notifyDataSetChanged();
        }
        if (i == 2) {
            this.fYS.setHintTextColor(am.getColor(R.color.s_navbar_title_color));
        } else {
            this.fYS.setHintTextColor(am.getColor(R.color.cp_cont_e));
        }
        SvgManager.aEp().a(this.fAr, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setNavbarTitleColor(this.fYS, R.color.cp_cont_b, R.color.s_navbar_title_color);
        SvgManager.aEp().a(this.ezA, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        am.setBackgroundResource(this.idh, R.color.cp_bg_line_d);
        am.setViewTextColor(this.fAs, R.color.cp_link_tip_a, 1);
        if (this.ido != null) {
            this.ido.onChangeSkinType(i);
        }
        xE(i);
    }

    private void xE(int i) {
        if (this.idp != null) {
            this.idp.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
        }
        if (this.idD != null) {
            getLayoutMode().onModeChanged(this.idD);
        }
        if (this.idE != null) {
            ((TextView) this.idE.findViewById(R.id.home_bt_search_footer)).setTextColor(am.getColor(R.color.cp_link_tip_a));
        }
        if (this.idF != null) {
            for (View view : this.idF) {
                am.setViewTextColor((TextView) view.findViewById(R.id.home_lv_search_forum), R.color.cp_cont_b, 1);
                view.findViewById(R.id.home_dialog_lv_search_forum_divider).setBackgroundColor(am.getColor(R.color.cp_bg_line_c));
                am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (i == 4 && this.idj.canGoBack()) {
                this.idj.goBack();
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
            this.mNoDataView.aFn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        private String mName;

        public b(String str) {
            this.mName = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(this.mName)) {
                SquareSearchActivity.this.gkm = this.mName;
                TiebaStatic.log(new an("c12034"));
                SquareSearchActivity.this.aq(this.mName, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ccE() {
        if (!j.isNetWorkAvailable()) {
            cn(this.mNoDataView);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.kQ(R.string.neterror));
            return true;
        }
        co(this.mNoDataView);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
        private BasicNameValuePair idV;
        private x mNetwork = null;
        private String mUrl;

        public a(String str, BasicNameValuePair basicNameValuePair, boolean z) {
            this.mUrl = null;
            this.idV = null;
            this.mUrl = str;
            this.idV = basicNameValuePair;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!SquareSearchActivity.this.ccE()) {
                SquareSearchActivity.this.co(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.idh, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(R.dimen.ds320));
                SquareSearchActivity.this.idi.setVisibility(8);
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
                    this.mNetwork.addPostData(this.idV);
                    String postNetData = this.mNetwork.postNetData();
                    if (postNetData != null) {
                        forumSuggestModel = ForumSuggestModel.parserJson(postNetData);
                        SquareSearchActivity.this.idy = this.idV.getValue();
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
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.idh);
            if (forumSuggestModel != null) {
                SquareSearchActivity.this.co(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.idv = forumSuggestModel;
                SquareSearchActivity.this.refresh();
            } else {
                SquareSearchActivity.this.cn(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.kQ(R.string.text_no_search_record));
            }
            SquareSearchActivity.this.idw = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.idh);
            super.cancel(true);
        }
    }

    private void oC(boolean z) {
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
                this.idH = false;
                this.fYS.setText(str);
                this.fYS.setSelection(str.length());
                this.idH = true;
            }
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.fYS);
            this.idk.setVisibility(8);
            this.idq.setVisibility(8);
            this.idj.setVisibility(0);
            showProgressBarWithOffset(0, 0);
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            this.idj.loadUrl(str2);
            ac.a(new ab<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ab
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.IV(str);
                    return true;
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DZ(String str) {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (!StringUtils.isNull(str)) {
            this.idI = str;
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CREATE_BAR)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), str)));
            }
        }
    }
}
