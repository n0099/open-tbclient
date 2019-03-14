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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.util.z;
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
/* loaded from: classes6.dex */
public class SquareSearchActivity extends BaseActivity<SquareSearchActivity> implements HotForumModel.a {
    private ImageView dpO;
    private EditText eIa;
    private String eXh;
    private ImageView eXr;
    private ScrollView gNA;
    private LinearLayout gNB;
    private List<c> gNC;
    private g gND;
    private LinearLayout gNE;
    private BdListView gNF;
    private com.baidu.tieba.mainentrance.a gNG;
    private com.baidu.tieba.mainentrance.searchSuggestList.b gNH;
    private ForumSuggestModel gNI;
    private a gNJ;
    private String gNK;
    private boolean gNL;
    private ScrollView gNN;
    private SearchPageFocusBar gNO;
    private View gNP;
    private View gNQ;
    private String gNU;
    private HotForumModel gNh;
    private LinearLayoutDetectsSoftKeyboard gNv;
    private FrameLayout gNw;
    private FrameLayout gNx;
    private TextView gNy;
    private BaseWebView gNz;
    private HotSearchInfoData mHotSearchInfo;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mTopicInfoTitle;
    private boolean gNM = true;
    private List<View> gNR = new ArrayList();
    private boolean gNi = false;
    private boolean gNS = true;
    private boolean gNT = true;
    private Runnable gNV = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.1
        @Override // java.lang.Runnable
        public void run() {
            SquareSearchActivity.this.eIa.requestFocus();
            l.c(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.eIa);
        }
    };
    private final Runnable gNW = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.12
        @Override // java.lang.Runnable
        public void run() {
            if (!SquareSearchActivity.this.bBO()) {
                try {
                    if (SquareSearchActivity.this.eXh != null && SquareSearchActivity.this.eXh.length() > 0) {
                        StringBuffer stringBuffer = new StringBuffer(30);
                        stringBuffer.append(TbConfig.SERVER_ADDRESS);
                        stringBuffer.append("c/f/forum/search");
                        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", SquareSearchActivity.this.eXh.trim());
                        SquareSearchActivity.this.bBz();
                        SquareSearchActivity.this.gNJ = new a(stringBuffer.toString(), basicNameValuePair, true);
                        SquareSearchActivity.this.gNJ.setPriority(3);
                        SquareSearchActivity.this.gNJ.execute(stringBuffer.toString(), basicNameValuePair);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a gNX = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SEARCH_LIST, 309438) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.22
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = ((responsedMessage instanceof SearchListHttpResMessage) || (responsedMessage instanceof SearchListSocketResMessage)) ? false : true;
            if (responsedMessage == null || z || responsedMessage.getError() != 0 || responsedMessage.hasError()) {
                if (j.kY() || !SquareSearchActivity.this.gNi) {
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(d.j.neterror));
                }
                if (!j.kY()) {
                    SquareSearchActivity.this.gNi = true;
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
            if (SquareSearchActivity.this.gNS && responsedMessage.getError() != 0) {
                SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(d.j.neterror));
                return;
            }
            if (list != null && list.size() > 0) {
                SquareSearchActivity.this.gNS = false;
            }
            SquareSearchActivity.this.bBL();
            SquareSearchActivity.this.gNF.setAdapter((ListAdapter) SquareSearchActivity.this.gNH);
            SquareSearchActivity.this.gNH.yi(SquareSearchActivity.this.eXh.trim());
            SquareSearchActivity.this.gNH.setData(list);
            SquareSearchActivity.this.gNH.notifyDataSetInvalidated();
        }
    };
    private CustomMessageListener gNm = new CustomMessageListener(2001608) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                SquareSearchActivity.this.yl(customResponsedMessage.getData().toString());
            }
        }
    };
    private CustomMessageListener gNY = new CustomMessageListener(2009002) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof ArrayList) {
                    SquareSearchActivity.this.ag((ArrayList) data);
                }
            }
        }
    };
    private View.OnClickListener gNZ = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.eIa);
            if (view.getTag() instanceof c) {
                c cVar = (c) view.getTag();
                TiebaStatic.log(new am("c10363").bJ("obj_name", cVar.getName()));
                if (!com.baidu.tbadk.plugins.b.f(SquareSearchActivity.this.getPageContext())) {
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
                if (SquareSearchActivity.this.gNz.getUrl() != null && SquareSearchActivity.this.gNz.getUrl().contains(str)) {
                    SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.gNw);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bBy() {
        if (this.mHotSearchInfo == null) {
            return false;
        }
        if (this.mHotSearchInfo.bBw() == 0) {
            ak(this.mHotSearchInfo.getName(), false);
        } else if (this.mHotSearchInfo.bBw() == 1 && !com.baidu.tbadk.plugins.b.f(getPageContext())) {
            sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new am("c10355").bJ("obj_name", this.mHotSearchInfo.getName()).T("obj_type", this.mHotSearchInfo.bBw() == 0 ? 2 : 1));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.home_dialog_search);
        init();
        getWindow().setSoftInputMode(1);
        registerListener(this.gNY);
        registerListener(this.gNX);
        registerListener(this.gNm);
        registerListener(this.htmlLoadMessageListener);
        if (SquareSearchActivityConfig.IS_SHOW_RECOMMEND_FORUM) {
            this.gNh = new HotForumModel(getPageContext(), this);
            this.gNh.bBu();
        }
        this.gNL = false;
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
        hideLoadingView(this.gNw);
        this.mHandler.removeCallbacks(this.gNV);
        bBz();
    }

    public void bBz() {
        this.mHandler.removeCallbacks(this.gNW);
        if (this.gNJ != null) {
            this.gNJ.cancel();
            this.gNJ = null;
        }
    }

    private void init() {
        this.gNv = (LinearLayoutDetectsSoftKeyboard) findViewById(d.g.parent);
        this.gNv.setOnSoftKeyBoardShownListener(new LinearLayoutDetectsSoftKeyboard.a() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.24
            @Override // com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard.a
            public void mi(boolean z) {
                SquareSearchActivity.this.gNM = z;
            }
        });
        this.gNv.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.25
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    SquareSearchActivity.this.gNv.setFocusable(true);
                    SquareSearchActivity.this.gNv.setFocusableInTouchMode(true);
                    if (SquareSearchActivity.this.eIa.hasFocus()) {
                        l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.eIa);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        aBB();
        this.gNw = (FrameLayout) findViewById(d.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds200)), null, null);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            this.gNN = (ScrollView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.h.home_searchbar_nodataview, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) this.gNN.findViewById(d.g.focusbar_nodata_root);
            this.gNO = (SearchPageFocusBar) linearLayout.findViewById(d.g.no_data_focusbar);
            linearLayout.addView(this.mNoDataView, 0);
            this.gNN.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.26
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.gNN);
                    return false;
                }
            });
            this.gNw.addView(this.gNN, this.gNw.getChildCount());
        } else {
            this.gNw.addView(this.mNoDataView, 0);
        }
        this.gNx = (FrameLayout) findViewById(d.g.home_search_list);
        bBx();
        bBB();
        bBC();
        bBD();
        this.gNz = (BaseWebView) findViewById(d.g.search_result_webview);
        this.gNz.initCommonJsBridge(getPageContext().getPageActivity());
        this.gNz.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.27
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
                if (SquareSearchActivity.this.isProgressBarShown()) {
                    SquareSearchActivity.this.hideProgressBar();
                }
            }
        });
        this.gNz.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.28
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedError", 0, "", "requesturl", str2, "receiveerror", Integer.valueOf(i), SocialConstants.PARAM_COMMENT, str);
            }
        });
        this.gNz.setOnReceivedSslErrorListener(new BaseWebView.g() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.g
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                if (sslError != null) {
                    com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedSslError", 0, "", "requesturl", sslError.getUrl(), "receiveerror", sslError.toString());
                }
            }
        });
        this.gNz.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.3
            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.mainentrance.SquareSearchActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return ba.adD().b(SquareSearchActivity.this.getPageContext(), new String[]{str}) != 3;
            }
        });
        this.eIa.setText("");
        this.eIa.requestFocus();
        ShowSoftKeyPadDelay(this.eIa, 200);
        bBE();
        bBF();
    }

    private void aBB() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.h.square_search_navigation_view, (View.OnClickListener) null);
        this.dpO = (ImageView) addCustomView.findViewById(d.g.search_bar_icon);
        this.eIa = (EditText) addCustomView.findViewById(d.g.home_et_search);
        this.eXr = (ImageView) addCustomView.findViewById(d.g.home_bt_search_del);
        this.gNy = (TextView) addCustomView.findViewById(d.g.home_bt_search_cancel_s);
        this.eIa.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    SquareSearchActivity.this.bBA();
                } else {
                    l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.eIa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.bBA();
            }
        });
        this.gNy.setText(getPageContext().getString(d.j.cancel));
        this.gNy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.eIa);
                com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SquareSearchActivity.this.finish();
                    }
                }, 200L);
            }
        });
        this.eIa.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.7
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (SquareSearchActivity.this.eXh == null || SquareSearchActivity.this.eXh.trim().length() < 1) {
                        l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.eIa);
                        if (SquareSearchActivity.this.bBy()) {
                            return true;
                        }
                        SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(d.j.write_keyword));
                        return true;
                    }
                    String trim = SquareSearchActivity.this.eIa.getText().toString().trim();
                    if (!StringUtils.isNull(trim)) {
                        SquareSearchActivity.this.ak(trim, false);
                        return true;
                    }
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(d.j.write_keyword));
                    return true;
                }
                return false;
            }
        });
        this.eXr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.eIa.setText("");
            }
        });
        this.eIa.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.9
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SquareSearchActivity.this.gNT) {
                    SquareSearchActivity.this.eXh = editable.toString();
                    if (StringUtils.isNull(SquareSearchActivity.this.eXh)) {
                        SquareSearchActivity.this.gNS = true;
                    }
                    SquareSearchActivity.this.bBI();
                }
                if (editable.toString().trim().length() == 0) {
                    SquareSearchActivity.this.eXr.setVisibility(8);
                } else {
                    SquareSearchActivity.this.eXr.setVisibility(0);
                }
                al.d(SquareSearchActivity.this.gNy, d.C0277d.cp_link_tip_a, 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBA() {
        if (StringUtils.isNull(this.eIa.getText().toString())) {
            if (this.gNA.getVisibility() != 0) {
                bBG();
            }
        } else if (this.gNF.getVisibility() != 0) {
            bBI();
        }
    }

    private void bBB() {
        this.gNA = (ScrollView) findViewById(d.g.search_history_scrollview);
        this.gNB = (LinearLayout) findViewById(d.g.search_history_linearlayout);
        if (this.gNE == null) {
            this.gNE = new LinearLayout(getPageContext().getPageActivity());
            this.gNE.setOrientation(1);
            this.gNE.setBackgroundColor(al.getColor(d.C0277d.cp_bg_line_d));
        }
        this.gNB.addView(this.gNE);
    }

    private void bBC() {
        if (this.gND == null) {
            this.gND = new g(getPageContext());
            this.gNB.addView(this.gND.oM());
        }
    }

    private void bBD() {
        this.gNF = (BdListView) findViewById(d.g.home_lv_search_suggest);
        this.gNG = new com.baidu.tieba.mainentrance.a(this, null);
        this.gNH = new com.baidu.tieba.mainentrance.searchSuggestList.b(getPageContext().getPageActivity(), null);
        this.gNF.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.10
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ListAdapter adapter;
                ListView listView = (ListView) adapterView;
                if (listView != null && (adapter = listView.getAdapter()) != null && adapter.getCount() != 0 && i < adapter.getCount()) {
                    Object item = adapter.getItem(i);
                    if (item instanceof String) {
                        SquareSearchActivity.this.ak((String) item, true);
                        TiebaStatic.eventStat(SquareSearchActivity.this.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
                    }
                }
            }
        });
        this.gNF.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.11
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

    public void bBE() {
        this.gNy.setText(getPageContext().getString(d.j.cancel));
        bBF();
        bBz();
        bBJ();
        if (this.eXh.trim().length() > 0) {
            bBI();
        } else {
            bBG();
        }
    }

    private void bBF() {
        if (this.mHotSearchInfo == null) {
            this.eIa.setHint(d.j.search_bar);
        } else {
            this.eIa.setHint(" " + UtilHelper.getFixedText(this.mHotSearchInfo.aWi(), 15));
        }
    }

    private void bBx() {
        HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
        if (hotSearchInfoData != null && hotSearchInfoData.getId() != 0) {
            this.mHotSearchInfo = hotSearchInfoData;
        }
    }

    private void bBG() {
        this.gNz.setVisibility(8);
        this.gNF.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009002));
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            mh(true);
            ce(this.gNO);
            ce(this.gNN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ag(ArrayList<String> arrayList) {
        NoDataViewFactory.d hU;
        if (ai(arrayList)) {
            bBN();
            if (j.kY()) {
                hU = NoDataViewFactory.d.hU(d.j.text_no_search_record);
            } else {
                hU = NoDataViewFactory.d.hU(d.j.neterror);
            }
            this.mNoDataView.setTextOption(hU);
            return;
        }
        bBM();
        ah(arrayList);
        S(true, arrayList == null || arrayList.size() == 0);
        bBF();
    }

    private void ah(final ArrayList<String> arrayList) {
        if (this.gNE != null) {
            this.gNE.removeAllViews();
            if (arrayList != null && !arrayList.isEmpty() && getActivity() != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                this.gNP = LayoutInflater.from(pageActivity).inflate(d.h.square_search_recommand_fourm_header, (ViewGroup) null);
                this.gNP.findViewById(d.g.titleTopDivider).setVisibility(8);
                getLayoutMode().onModeChanged(this.gNP);
                this.gNE.addView(this.gNP, layoutParams);
                int size = arrayList.size();
                this.gNR.clear();
                for (int i = 0; i < size; i++) {
                    final String str = arrayList.get(i);
                    if (!TextUtils.isEmpty(str)) {
                        final View inflate = LayoutInflater.from(pageActivity).inflate(d.h.home_dialog_search_item, (ViewGroup) null);
                        ((TextView) inflate.findViewById(d.g.home_lv_search_forum)).setText(str);
                        al.d((TextView) inflate.findViewById(d.g.home_lv_search_forum), d.C0277d.cp_cont_b, 1);
                        inflate.findViewById(d.g.home_dialog_lv_search_forum_divider).setVisibility(8);
                        al.k(inflate, d.f.square_search_item_bg);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        inflate.setOnClickListener(new b(str));
                        ImageView imageView = (ImageView) inflate.findViewById(d.g.del_search_history_btn);
                        al.c(imageView, d.f.icn_shop_order_close);
                        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                aa.a(new z<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // com.baidu.tbadk.util.z
                                    public Boolean doInBackground() {
                                        com.baidu.tieba.tbadkCore.util.a.CJ(str);
                                        return true;
                                    }
                                }, new k<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.2
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.tbadk.util.k
                                    public void onReturnDataInUI(Boolean bool) {
                                        SquareSearchActivity.this.gNE.removeView(inflate);
                                        arrayList.remove(str);
                                        if (arrayList.size() <= 0) {
                                            SquareSearchActivity.this.ag(null);
                                        }
                                    }
                                });
                            }
                        });
                        this.gNR.add(inflate);
                        this.gNE.addView(inflate, layoutParams2);
                    }
                }
                this.gNQ = LayoutInflater.from(pageActivity).inflate(d.h.home_dialog_search_footer, (ViewGroup) null);
                ((TextView) this.gNQ.findViewById(d.g.home_bt_search_footer)).setTextColor(al.getColor(d.C0277d.cp_link_tip_a));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                this.gNQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SquareSearchActivity.this.bBH();
                    }
                });
                this.gNE.addView(this.gNQ, layoutParams3);
            }
        }
    }

    private void S(boolean z, boolean z2) {
        if (this.gND != null) {
            this.gND.clear();
            if (this.gNC != null && !this.gNC.isEmpty() && z) {
                this.gND.mg(!z2);
                this.gND.setTitleText(this.mTopicInfoTitle);
                int size = this.gNC.size();
                if (size >= 1) {
                    if (size > 7) {
                        size = 7;
                    }
                    int i = size % 2 == 0 ? size - 1 : size;
                    for (int i2 = 0; i2 < i; i2++) {
                        c cVar = (c) v.c(this.gNC, i2);
                        if (cVar != null) {
                            this.gND.a(cVar, i2).setOnClickListener(this.gNZ);
                        }
                    }
                    this.gND.a(null, i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.16
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.eIa);
                            if (!com.baidu.tbadk.plugins.b.f(SquareSearchActivity.this.getPageContext())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all")));
                            }
                        }
                    });
                    this.gND.show();
                }
            }
        }
    }

    private boolean ai(ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && (this.gNC == null || this.gNC.size() <= 2) && this.gNL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBH() {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).ly(getPageContext().getString(d.j.alert_clean_history)).a(getPageContext().getString(d.j.clear_all_text), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                h.jI().d(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.cfl();
                    }
                });
                if (SquareSearchActivity.this.gNC == null || SquareSearchActivity.this.gNC.size() < 2) {
                    SquareSearchActivity.this.cd(SquareSearchActivity.this.gNN);
                    SquareSearchActivity.this.cd(SquareSearchActivity.this.gNO);
                    SquareSearchActivity.this.gNx.setVisibility(8);
                    SquareSearchActivity.this.mNoDataView.setVisibility(0);
                    SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.hU(d.j.text_no_search_record));
                    return;
                }
                SquareSearchActivity.this.ag(null);
            }
        }).b(getPageContext().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.17
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        }).b(getPageContext()).aaZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBI() {
        if (this.eXh.trim().length() > 0) {
            bBK();
            return;
        }
        bBz();
        bBG();
    }

    private void bBJ() {
        if (this.gNF != null) {
            this.gNF.setNextPage(null);
        }
    }

    private void bBK() {
        if (!StringUtils.isNull(this.eXh)) {
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.eXh.trim();
            sendMessage(searchListNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        try {
            if (this.gNI != null) {
                if (this.gNI.forum_list != null && this.gNI.forum_list.size() > 0) {
                    bBL();
                    this.gNF.setAdapter((ListAdapter) this.gNG);
                    this.gNG.yi(this.eXh);
                    this.gNG.af(this.gNI.forum_list);
                    this.gNG.notifyDataSetInvalidated();
                } else {
                    ce(this.gNN);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBL() {
        this.gNx.setVisibility(0);
        this.gNF.setVisibility(0);
        this.gNA.setVisibility(8);
        this.gNz.setVisibility(8);
        ce(this.gNN);
        this.mNoDataView.setVisibility(8);
    }

    private void bBM() {
        this.gNx.setVisibility(0);
        this.gNA.setVisibility(0);
        this.gNF.setVisibility(8);
        this.gNz.setVisibility(8);
        ce(this.gNN);
        this.mNoDataView.setVisibility(8);
    }

    private void bBN() {
        this.gNx.setVisibility(8);
        this.gNF.setVisibility(8);
        this.gNA.setVisibility(8);
        this.gNz.setVisibility(8);
        cd(this.gNN);
        this.mNoDataView.setVisibility(0);
        cd(this.gNO);
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void yj(String str) {
        this.gNL = true;
        this.gNC = new ArrayList();
        bBG();
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void a(List<com.baidu.tieba.mainentrance.b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str) {
        this.gNL = true;
        hideLoadingView(this.gNw);
        if (list2 == null) {
            this.gNC = new ArrayList();
        } else {
            this.gNC = list2;
        }
        if (!StringUtils.isNULL(str)) {
            this.mTopicInfoTitle = str;
        } else {
            this.mTopicInfoTitle = "";
        }
        a(hotSearchInfoData);
        this.mHotSearchInfo = hotSearchInfoData;
        bBG();
    }

    private void a(HotSearchInfoData hotSearchInfoData) {
        if (hotSearchInfoData != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
            return;
        }
        HotSearchInfoData hotSearchInfoData2 = new HotSearchInfoData();
        hotSearchInfoData2.setId(0L);
        hotSearchInfoData2.setName("");
        hotSearchInfoData2.yk("");
        hotSearchInfoData2.dr(0L);
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
        getLayoutMode().onModeChanged(this.gNv);
        al.g(this.gNv, i);
        if (this.gNG != null) {
            this.gNG.notifyDataSetChanged();
        }
        if (i == 2) {
            this.eIa.setHintTextColor(al.getColor(d.C0277d.s_navbar_title_color));
        } else {
            this.eIa.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
        }
        al.c(this.eXr, d.f.del_search_btn);
        al.c(this.eIa, d.C0277d.cp_cont_b, d.C0277d.s_navbar_title_color);
        al.a(this.dpO, d.f.icon_seach_n, d.f.icon_seach_n, d.f.icon_seach_n, i);
        al.k(this.gNw, d.C0277d.cp_bg_line_d);
        al.d(this.gNy, d.C0277d.cp_link_tip_a, 1);
        if (this.gND != null) {
            this.gND.onChangeSkinType(i);
        }
        vg(i);
    }

    private void vg(int i) {
        if (this.gNE != null) {
            this.gNE.setBackgroundColor(al.getColor(d.C0277d.cp_bg_line_d));
        }
        if (this.gNP != null) {
            getLayoutMode().onModeChanged(this.gNP);
        }
        if (this.gNQ != null) {
            ((TextView) this.gNQ.findViewById(d.g.home_bt_search_footer)).setTextColor(al.getColor(d.C0277d.cp_link_tip_a));
        }
        if (this.gNR != null) {
            for (View view : this.gNR) {
                al.d((TextView) view.findViewById(d.g.home_lv_search_forum), d.C0277d.cp_cont_b, 1);
                view.findViewById(d.g.home_dialog_lv_search_forum_divider).setBackgroundColor(al.getColor(d.C0277d.cp_bg_line_b));
                al.k(view, d.f.addresslist_item_bg);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (i == 4 && this.gNz.canGoBack()) {
                this.gNz.goBack();
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
            com.baidu.tbadk.core.e.b.o(getPageContext().getPageActivity(), 1);
        } else {
            com.baidu.tbadk.core.e.b.o(getPageContext().getPageActivity(), 2);
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
    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        private String mName;

        public b(String str) {
            this.mName = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(this.mName)) {
                SquareSearchActivity.this.eXh = this.mName;
                TiebaStatic.log(new am("c12034"));
                SquareSearchActivity.this.ak(this.mName, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bBO() {
        if (!j.kY()) {
            cd(this.mNoDataView);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.hU(d.j.neterror));
            return true;
        }
        ce(this.mNoDataView);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
        private BasicNameValuePair gOh;
        private x mNetwork = null;
        private String mUrl;

        public a(String str, BasicNameValuePair basicNameValuePair, boolean z) {
            this.mUrl = null;
            this.gOh = null;
            this.mUrl = str;
            this.gOh = basicNameValuePair;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!SquareSearchActivity.this.bBO()) {
                SquareSearchActivity.this.ce(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.gNw, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(d.e.ds320));
                SquareSearchActivity.this.gNx.setVisibility(8);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public ForumSuggestModel doInBackground(Object... objArr) {
            ForumSuggestModel forumSuggestModel = null;
            if (j.kY()) {
                try {
                    this.mNetwork = new x(this.mUrl);
                    this.mNetwork.a(this.gOh);
                    String acj = this.mNetwork.acj();
                    if (acj != null) {
                        forumSuggestModel = ForumSuggestModel.parserJson(acj);
                        SquareSearchActivity.this.gNK = this.gOh.getValue();
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
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.gNw);
            if (forumSuggestModel != null) {
                SquareSearchActivity.this.ce(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.gNI = forumSuggestModel;
                SquareSearchActivity.this.refresh();
            } else {
                SquareSearchActivity.this.cd(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.hU(d.j.text_no_search_record));
            }
            SquareSearchActivity.this.gNJ = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.ji();
                this.mNetwork = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.gNw);
            super.cancel(true);
        }
    }

    private void mh(boolean z) {
        if (TbadkCoreApplication.isLogin()) {
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(2001323, true));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(2001323, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cd(View view) {
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ce(View view) {
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a026";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(final String str, boolean z) {
        if (!j.kY()) {
            showToast(d.j.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.gNT = false;
                this.eIa.setText(str);
                this.eIa.setSelection(str.length());
                this.gNT = true;
            }
            l.b(getPageContext().getPageActivity(), this.eIa);
            this.gNA.setVisibility(8);
            this.gNF.setVisibility(8);
            this.gNz.setVisibility(0);
            showProgressBarWithOffset(0, 0);
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            this.gNz.loadUrl(str2);
            aa.a(new z<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.z
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.CH(str);
                    return true;
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yl(String str) {
        if (!j.kY()) {
            showToast(d.j.neterror);
        } else if (!StringUtils.isNull(str)) {
            this.gNU = str;
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BIND_WIDGET)));
            } else {
                sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), str)));
            }
        }
    }
}
