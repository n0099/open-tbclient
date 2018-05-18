package com.baidu.tieba.mainentrance;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.d;
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
/* loaded from: classes3.dex */
public class SquareSearchActivity extends BaseActivity<SquareSearchActivity> implements HotForumModel.a {
    private ImageView bwq;
    private EditText cLO;
    private String cWR;
    private ImageView cXb;
    private LinearLayout eDA;
    private BdListView eDB;
    private com.baidu.tieba.mainentrance.a eDC;
    private com.baidu.tieba.mainentrance.searchSuggestList.a eDD;
    private ForumSuggestModel eDE;
    private a eDF;
    private String eDG;
    private boolean eDH;
    private ScrollView eDJ;
    private SearchPageFocusBar eDK;
    private View eDL;
    private View eDM;
    private String eDQ;
    private HotForumModel eDc;
    private LinearLayoutDetectsSoftKeyboard eDr;
    private FrameLayout eDs;
    private FrameLayout eDt;
    private TextView eDu;
    private BaseWebView eDv;
    private ScrollView eDw;
    private LinearLayout eDx;
    private List<c> eDy;
    private g eDz;
    private HotSearchInfoData mHotSearchInfo;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mTopicInfoTitle;
    private boolean eDI = true;
    private List<View> eDN = new ArrayList();
    private boolean eDd = false;
    private boolean eDO = true;
    private boolean eDP = true;
    private Runnable eDR = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.1
        @Override // java.lang.Runnable
        public void run() {
            SquareSearchActivity.this.cLO.requestFocus();
            l.c(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.cLO);
        }
    };
    private final Runnable eDS = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.12
        @Override // java.lang.Runnable
        public void run() {
            if (!SquareSearchActivity.this.aMG()) {
                try {
                    if (SquareSearchActivity.this.cWR != null && SquareSearchActivity.this.cWR.length() > 0) {
                        StringBuffer stringBuffer = new StringBuffer(30);
                        stringBuffer.append(TbConfig.SERVER_ADDRESS);
                        stringBuffer.append("c/f/forum/search");
                        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", SquareSearchActivity.this.cWR.trim());
                        SquareSearchActivity.this.aMr();
                        SquareSearchActivity.this.eDF = new a(stringBuffer.toString(), basicNameValuePair, true);
                        SquareSearchActivity.this.eDF.setPriority(3);
                        SquareSearchActivity.this.eDF.execute(stringBuffer.toString(), basicNameValuePair);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a eDT = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SEARCH_LIST, 309438) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.22
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = ((responsedMessage instanceof SearchListHttpResMessage) || (responsedMessage instanceof SearchListSocketResMessage)) ? false : true;
            if (responsedMessage == null || z || responsedMessage.getError() != 0 || responsedMessage.hasError()) {
                if (j.gP() || !SquareSearchActivity.this.eDd) {
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(d.k.neterror));
                }
                if (!j.gP()) {
                    SquareSearchActivity.this.eDd = true;
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
            if (SquareSearchActivity.this.eDO && responsedMessage.getError() != 0) {
                SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(d.k.neterror));
                return;
            }
            if (list != null && list.size() > 0) {
                SquareSearchActivity.this.eDO = false;
            }
            SquareSearchActivity.this.aMD();
            SquareSearchActivity.this.eDB.setAdapter((ListAdapter) SquareSearchActivity.this.eDD);
            SquareSearchActivity.this.eDD.oK(SquareSearchActivity.this.cWR.trim());
            SquareSearchActivity.this.eDD.setData(list);
            SquareSearchActivity.this.eDD.notifyDataSetInvalidated();
        }
    };
    private CustomMessageListener eDh = new CustomMessageListener(2001608) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                SquareSearchActivity.this.oN(customResponsedMessage.getData().toString());
            }
        }
    };
    private CustomMessageListener eDU = new CustomMessageListener(2009002) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof ArrayList) {
                    SquareSearchActivity.this.Z((ArrayList) data);
                }
            }
        }
    };
    private View.OnClickListener eDV = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.cLO);
            if (view2.getTag() instanceof c) {
                c cVar = (c) view2.getTag();
                TiebaStatic.log(new al("c10363").ac("obj_name", cVar.getName()));
                if (!com.baidu.tbadk.plugins.b.e(SquareSearchActivity.this.getPageContext())) {
                    SquareSearchActivity.this.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(SquareSearchActivity.this.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(cVar.getId()), cVar.getName(), "")));
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
                if (SquareSearchActivity.this.eDv.getUrl() != null && SquareSearchActivity.this.eDv.getUrl().contains(str)) {
                    SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.eDs);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aMq() {
        if (this.mHotSearchInfo == null) {
            return false;
        }
        if (this.mHotSearchInfo.aMo() == 0) {
            H(this.mHotSearchInfo.getName(), false);
        } else if (this.mHotSearchInfo.aMo() == 1 && !com.baidu.tbadk.plugins.b.e(getPageContext())) {
            sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "")));
        }
        TiebaStatic.log(new al("c10355").ac("obj_name", this.mHotSearchInfo.getName()).r("obj_type", this.mHotSearchInfo.aMo() == 0 ? 2 : 1));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.home_dialog_search);
        init();
        getWindow().setSoftInputMode(1);
        registerListener(this.eDU);
        registerListener(this.eDT);
        registerListener(this.eDh);
        registerListener(this.htmlLoadMessageListener);
        if (SquareSearchActivityConfig.IS_SHOW_RECOMMEND_FORUM) {
            this.eDc = new HotForumModel(getPageContext(), this);
            this.eDc.aMm();
        }
        this.eDH = false;
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
        hideLoadingView(this.eDs);
        this.mHandler.removeCallbacks(this.eDR);
        aMr();
    }

    public void aMr() {
        this.mHandler.removeCallbacks(this.eDS);
        if (this.eDF != null) {
            this.eDF.cancel();
            this.eDF = null;
        }
    }

    private void init() {
        this.eDr = (LinearLayoutDetectsSoftKeyboard) findViewById(d.g.parent);
        this.eDr.setOnSoftKeyBoardShownListener(new LinearLayoutDetectsSoftKeyboard.a() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.24
            @Override // com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard.a
            public void ih(boolean z) {
                SquareSearchActivity.this.eDI = z;
            }
        });
        this.eDr.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.25
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    SquareSearchActivity.this.eDr.setFocusable(true);
                    SquareSearchActivity.this.eDr.setFocusableInTouchMode(true);
                    if (SquareSearchActivity.this.cLO.hasFocus()) {
                        l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.cLO);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        ard();
        this.eDs = (FrameLayout) findViewById(d.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds200)), null, null);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            this.eDJ = (ScrollView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.i.home_searchbar_nodataview, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) this.eDJ.findViewById(d.g.focusbar_nodata_root);
            this.eDK = (SearchPageFocusBar) linearLayout.findViewById(d.g.no_data_focusbar);
            linearLayout.addView(this.mNoDataView, 0);
            this.eDJ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.26
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.eDJ);
                    return false;
                }
            });
            this.eDs.addView(this.eDJ, this.eDs.getChildCount());
        } else {
            this.eDs.addView(this.mNoDataView, 0);
        }
        this.eDt = (FrameLayout) findViewById(d.g.home_search_list);
        aMp();
        aMt();
        aMu();
        aMv();
        this.eDv = (BaseWebView) findViewById(d.g.search_result_webview);
        this.eDv.initCommonJsBridge(getPageContext().getPageActivity());
        this.eDv.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.27
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
                if (SquareSearchActivity.this.isProgressBarShown()) {
                    SquareSearchActivity.this.hideProgressBar();
                }
            }
        });
        this.eDv.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.28
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedError", 0, "", "requesturl", str2, "receiveerror", Integer.valueOf(i), "description", str);
            }
        });
        this.eDv.setOnReceivedSslErrorListener(new BaseWebView.g() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.g
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                if (sslError != null) {
                    com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedSslError", 0, "", "requesturl", sslError.getUrl(), "receiveerror", sslError.toString());
                }
            }
        });
        this.eDv.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.3
            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.mainentrance.SquareSearchActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return ax.wf().b(SquareSearchActivity.this.getPageContext(), new String[]{str}) != 3;
            }
        });
        this.cLO.setText("");
        this.cLO.requestFocus();
        ShowSoftKeyPadDelay(this.cLO, 200);
        aMw();
        aMx();
    }

    private void ard() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.i.square_search_navigation_view, (View.OnClickListener) null);
        this.bwq = (ImageView) addCustomView.findViewById(d.g.search_bar_icon);
        this.cLO = (EditText) addCustomView.findViewById(d.g.home_et_search);
        this.cXb = (ImageView) addCustomView.findViewById(d.g.home_bt_search_del);
        this.eDu = (TextView) addCustomView.findViewById(d.g.home_bt_search_cancel_s);
        this.cLO.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (z) {
                    SquareSearchActivity.this.aMs();
                } else {
                    l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), view2);
                }
            }
        });
        this.cLO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                SquareSearchActivity.this.aMs();
            }
        });
        this.eDu.setText(getPageContext().getString(d.k.cancel));
        this.eDu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.cLO);
                com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SquareSearchActivity.this.finish();
                    }
                }, 200L);
            }
        });
        this.cLO.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.7
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (SquareSearchActivity.this.cWR == null || SquareSearchActivity.this.cWR.trim().length() < 1) {
                        l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.cLO);
                        if (SquareSearchActivity.this.aMq()) {
                            return true;
                        }
                        SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(d.k.write_keyword));
                        return true;
                    }
                    String trim = SquareSearchActivity.this.cLO.getText().toString().trim();
                    if (!StringUtils.isNull(trim)) {
                        SquareSearchActivity.this.H(trim, false);
                        return true;
                    }
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(d.k.write_keyword));
                    return true;
                }
                return false;
            }
        });
        this.cXb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                SquareSearchActivity.this.cLO.setText("");
            }
        });
        this.cLO.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.9
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SquareSearchActivity.this.eDP) {
                    SquareSearchActivity.this.cWR = editable.toString();
                    if (StringUtils.isNull(SquareSearchActivity.this.cWR)) {
                        SquareSearchActivity.this.eDO = true;
                    }
                    SquareSearchActivity.this.aMA();
                }
                if (editable.toString().trim().length() == 0) {
                    SquareSearchActivity.this.cXb.setVisibility(8);
                } else {
                    SquareSearchActivity.this.cXb.setVisibility(0);
                }
                ak.c(SquareSearchActivity.this.eDu, d.C0126d.cp_link_tip_a, 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMs() {
        if (StringUtils.isNull(this.cLO.getText().toString())) {
            if (this.eDw.getVisibility() != 0) {
                aMy();
            }
        } else if (this.eDB.getVisibility() != 0) {
            aMA();
        }
    }

    private void aMt() {
        this.eDw = (ScrollView) findViewById(d.g.search_history_scrollview);
        this.eDx = (LinearLayout) findViewById(d.g.search_history_linearlayout);
        if (this.eDA == null) {
            this.eDA = new LinearLayout(getPageContext().getPageActivity());
            this.eDA.setOrientation(1);
            this.eDA.setBackgroundColor(ak.getColor(d.C0126d.cp_bg_line_d));
        }
        this.eDx.addView(this.eDA);
    }

    private void aMu() {
        if (this.eDz == null) {
            this.eDz = new g(getPageContext());
            this.eDx.addView(this.eDz.kz());
        }
    }

    private void aMv() {
        this.eDB = (BdListView) findViewById(d.g.home_lv_search_suggest);
        this.eDC = new com.baidu.tieba.mainentrance.a(this, null);
        this.eDD = new com.baidu.tieba.mainentrance.searchSuggestList.a(getPageContext().getPageActivity(), null);
        this.eDB.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.10
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
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
        this.eDB.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.11
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

    public void aMw() {
        this.eDu.setText(getPageContext().getString(d.k.cancel));
        aMx();
        aMr();
        aMB();
        if (this.cWR.trim().length() > 0) {
            aMA();
        } else {
            aMy();
        }
    }

    private void aMx() {
        if (this.mHotSearchInfo == null) {
            this.cLO.setHint(d.k.search_bar);
        } else {
            this.cLO.setHint(" " + UtilHelper.getFixedText(this.mHotSearchInfo.akw(), 15));
        }
    }

    private void aMp() {
        HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
        if (hotSearchInfoData != null && hotSearchInfoData.getId() != 0) {
            this.mHotSearchInfo = hotSearchInfoData;
        }
    }

    private void aMy() {
        this.eDv.setVisibility(8);
        this.eDB.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009002));
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            ig(true);
            aP(this.eDK);
            aP(this.eDJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(ArrayList<String> arrayList) {
        NoDataViewFactory.d dp;
        if (ab(arrayList)) {
            aMF();
            if (j.gP()) {
                dp = NoDataViewFactory.d.dp(d.k.text_no_search_record);
            } else {
                dp = NoDataViewFactory.d.dp(d.k.neterror);
            }
            this.mNoDataView.setTextOption(dp);
            return;
        }
        aME();
        aa(arrayList);
        D(true, arrayList == null || arrayList.size() == 0);
        aMx();
    }

    private void aa(final ArrayList<String> arrayList) {
        if (this.eDA != null) {
            this.eDA.removeAllViews();
            if (arrayList != null && !arrayList.isEmpty() && getActivity() != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                this.eDL = LayoutInflater.from(pageActivity).inflate(d.i.square_search_recommand_fourm_header, (ViewGroup) null);
                this.eDL.findViewById(d.g.titleTopDivider).setVisibility(8);
                getLayoutMode().u(this.eDL);
                this.eDA.addView(this.eDL, layoutParams);
                int size = arrayList.size();
                this.eDN.clear();
                for (int i = 0; i < size; i++) {
                    final String str = arrayList.get(i);
                    if (!TextUtils.isEmpty(str)) {
                        final View inflate = LayoutInflater.from(pageActivity).inflate(d.i.home_dialog_search_item, (ViewGroup) null);
                        ((TextView) inflate.findViewById(d.g.home_lv_search_forum)).setText(str);
                        ak.c((TextView) inflate.findViewById(d.g.home_lv_search_forum), d.C0126d.cp_cont_b, 1);
                        inflate.findViewById(d.g.home_dialog_lv_search_forum_divider).setVisibility(8);
                        ak.i(inflate, d.f.square_search_item_bg);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        inflate.setOnClickListener(new b(str));
                        ImageView imageView = (ImageView) inflate.findViewById(d.g.del_search_history_btn);
                        ak.c(imageView, d.f.icn_shop_order_close);
                        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                v.a(new u<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // com.baidu.tbadk.util.u
                                    public Boolean doInBackground() {
                                        com.baidu.tieba.tbadkCore.util.a.tc(str);
                                        return true;
                                    }
                                }, new h<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.2
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.tbadk.util.h
                                    public void onReturnDataInUI(Boolean bool) {
                                        SquareSearchActivity.this.eDA.removeView(inflate);
                                        arrayList.remove(str);
                                        if (arrayList.size() <= 0) {
                                            SquareSearchActivity.this.Z(null);
                                        }
                                    }
                                });
                            }
                        });
                        this.eDN.add(inflate);
                        this.eDA.addView(inflate, layoutParams2);
                    }
                }
                this.eDM = LayoutInflater.from(pageActivity).inflate(d.i.home_dialog_search_footer, (ViewGroup) null);
                ((TextView) this.eDM.findViewById(d.g.home_bt_search_footer)).setTextColor(ak.getColor(d.C0126d.cp_link_tip_a));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                this.eDM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        SquareSearchActivity.this.aMz();
                    }
                });
                this.eDA.addView(this.eDM, layoutParams3);
            }
        }
    }

    private void D(boolean z, boolean z2) {
        if (this.eDz != null) {
            this.eDz.clear();
            if (this.eDy != null && !this.eDy.isEmpty() && z) {
                this.eDz.m18if(!z2);
                this.eDz.setTitleText(this.mTopicInfoTitle);
                int size = this.eDy.size();
                if (size >= 1) {
                    if (size > 7) {
                        size = 7;
                    }
                    int i = size % 2 == 0 ? size - 1 : size;
                    for (int i2 = 0; i2 < i; i2++) {
                        c cVar = (c) com.baidu.tbadk.core.util.v.c(this.eDy, i2);
                        if (cVar != null) {
                            this.eDz.a(cVar, i2).setOnClickListener(this.eDV);
                        }
                    }
                    this.eDz.a(null, i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.16
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.cLO);
                            if (!com.baidu.tbadk.plugins.b.e(SquareSearchActivity.this.getPageContext())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(view2.getContext()).createNormalConfig("hotforum", "all")));
                            }
                        }
                    });
                    this.eDz.show();
                }
            }
        }
    }

    private boolean ab(ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && (this.eDy == null || this.eDy.size() <= 2) && this.eDH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMz() {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).dc(getPageContext().getString(d.k.alert_clean_history)).a(getPageContext().getString(d.k.clear_all_text), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                com.baidu.adp.lib.g.h.fx().d(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.bsN();
                    }
                });
                if (SquareSearchActivity.this.eDy == null || SquareSearchActivity.this.eDy.size() < 2) {
                    SquareSearchActivity.this.aO(SquareSearchActivity.this.eDJ);
                    SquareSearchActivity.this.aO(SquareSearchActivity.this.eDK);
                    SquareSearchActivity.this.eDt.setVisibility(8);
                    SquareSearchActivity.this.mNoDataView.setVisibility(0);
                    SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.k.text_no_search_record));
                    return;
                }
                SquareSearchActivity.this.Z(null);
            }
        }).b(getPageContext().getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.17
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        }).b(getPageContext()).tC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMA() {
        if (this.cWR.trim().length() > 0) {
            aMC();
            return;
        }
        aMr();
        aMy();
    }

    private void aMB() {
        if (this.eDB != null) {
            this.eDB.setNextPage(null);
        }
    }

    private void aMC() {
        if (!StringUtils.isNull(this.cWR)) {
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.cWR.trim();
            sendMessage(searchListNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        try {
            if (this.eDE != null) {
                if (this.eDE.forum_list != null && this.eDE.forum_list.size() > 0) {
                    aMD();
                    this.eDB.setAdapter((ListAdapter) this.eDC);
                    this.eDC.oK(this.cWR);
                    this.eDC.Y(this.eDE.forum_list);
                    this.eDC.notifyDataSetInvalidated();
                } else {
                    aP(this.eDJ);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMD() {
        this.eDt.setVisibility(0);
        this.eDB.setVisibility(0);
        this.eDw.setVisibility(8);
        this.eDv.setVisibility(8);
        aP(this.eDJ);
        this.mNoDataView.setVisibility(8);
    }

    private void aME() {
        this.eDt.setVisibility(0);
        this.eDw.setVisibility(0);
        this.eDB.setVisibility(8);
        this.eDv.setVisibility(8);
        aP(this.eDJ);
        this.mNoDataView.setVisibility(8);
    }

    private void aMF() {
        this.eDt.setVisibility(8);
        this.eDB.setVisibility(8);
        this.eDw.setVisibility(8);
        this.eDv.setVisibility(8);
        aO(this.eDJ);
        this.mNoDataView.setVisibility(0);
        aO(this.eDK);
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void oL(String str) {
        this.eDH = true;
        this.eDy = new ArrayList();
        aMy();
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void a(List<com.baidu.tieba.mainentrance.b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str) {
        this.eDH = true;
        hideLoadingView(this.eDs);
        if (list2 == null) {
            this.eDy = new ArrayList();
        } else {
            this.eDy = list2;
        }
        if (!StringUtils.isNULL(str)) {
            this.mTopicInfoTitle = str;
        } else {
            this.mTopicInfoTitle = "";
        }
        a(hotSearchInfoData);
        this.mHotSearchInfo = hotSearchInfoData;
        aMy();
    }

    private void a(HotSearchInfoData hotSearchInfoData) {
        if (hotSearchInfoData != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
            return;
        }
        HotSearchInfoData hotSearchInfoData2 = new HotSearchInfoData();
        hotSearchInfoData2.setId(0L);
        hotSearchInfoData2.setName("");
        hotSearchInfoData2.oM("");
        hotSearchInfoData2.cn(0L);
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
        getLayoutMode().u(this.eDr);
        ak.e(this.eDr, i);
        if (this.eDC != null) {
            this.eDC.notifyDataSetChanged();
        }
        if (i == 2) {
            this.cLO.setHintTextColor(ak.getColor(d.C0126d.s_navbar_title_color));
        } else {
            this.cLO.setHintTextColor(ak.getColor(d.C0126d.cp_cont_e));
        }
        ak.c(this.cXb, d.f.del_search_btn);
        ak.b(this.cLO, d.C0126d.cp_cont_b, d.C0126d.s_navbar_title_color);
        ak.a(this.bwq, d.f.icon_seach_n, d.f.icon_seach_n, d.f.icon_seach_n, i);
        ak.i(this.eDs, d.C0126d.cp_bg_line_d);
        ak.c(this.eDu, d.C0126d.cp_link_tip_a, 1);
        if (this.eDz != null) {
            this.eDz.onChangeSkinType(i);
        }
        oL(i);
    }

    private void oL(int i) {
        if (this.eDA != null) {
            this.eDA.setBackgroundColor(ak.getColor(d.C0126d.cp_bg_line_d));
        }
        if (this.eDL != null) {
            getLayoutMode().u(this.eDL);
        }
        if (this.eDM != null) {
            ((TextView) this.eDM.findViewById(d.g.home_bt_search_footer)).setTextColor(ak.getColor(d.C0126d.cp_link_tip_a));
        }
        if (this.eDN != null) {
            for (View view2 : this.eDN) {
                ak.c((TextView) view2.findViewById(d.g.home_lv_search_forum), d.C0126d.cp_cont_b, 1);
                view2.findViewById(d.g.home_dialog_lv_search_forum_divider).setBackgroundColor(ak.getColor(d.C0126d.cp_bg_line_b));
                ak.i(view2, d.f.addresslist_item_bg);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (i == 4 && this.eDv.canGoBack()) {
                this.eDv.goBack();
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
        public void onClick(View view2) {
            if (!TextUtils.isEmpty(this.mName)) {
                SquareSearchActivity.this.cWR = this.mName;
                TiebaStatic.log(new al("c12034"));
                SquareSearchActivity.this.H(this.mName, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aMG() {
        if (!j.gP()) {
            aO(this.mNoDataView);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.k.neterror));
            return true;
        }
        aP(this.mNoDataView);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
        private BasicNameValuePair eEd;
        private x mNetwork = null;
        private String mUrl;

        public a(String str, BasicNameValuePair basicNameValuePair, boolean z) {
            this.mUrl = null;
            this.eEd = null;
            this.mUrl = str;
            this.eEd = basicNameValuePair;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!SquareSearchActivity.this.aMG()) {
                SquareSearchActivity.this.aP(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.eDs, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(d.e.ds320));
                SquareSearchActivity.this.eDt.setVisibility(8);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public ForumSuggestModel doInBackground(Object... objArr) {
            ForumSuggestModel forumSuggestModel = null;
            if (j.gP()) {
                try {
                    this.mNetwork = new x(this.mUrl);
                    this.mNetwork.a(this.eEd);
                    String uK = this.mNetwork.uK();
                    if (uK != null) {
                        forumSuggestModel = ForumSuggestModel.parserJson(uK);
                        SquareSearchActivity.this.eDG = this.eEd.getValue();
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
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.eDs);
            if (forumSuggestModel != null) {
                SquareSearchActivity.this.aP(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.eDE = forumSuggestModel;
                SquareSearchActivity.this.refresh();
            } else {
                SquareSearchActivity.this.aO(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.k.text_no_search_record));
            }
            SquareSearchActivity.this.eDF = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.eW();
                this.mNetwork = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.eDs);
            super.cancel(true);
        }
    }

    private void ig(boolean z) {
        if (TbadkCoreApplication.isLogin()) {
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(2001323, true));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(2001323, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO(View view2) {
        if (view2 != null) {
            view2.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP(View view2) {
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a026";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(final String str, boolean z) {
        if (!j.gP()) {
            showToast(d.k.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.eDP = false;
                this.cLO.setText(str);
                this.cLO.setSelection(str.length());
                this.eDP = true;
            }
            l.b(getPageContext().getPageActivity(), this.cLO);
            this.eDw.setVisibility(8);
            this.eDB.setVisibility(8);
            this.eDv.setVisibility(0);
            showProgressBarWithOffset(0, 0);
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            this.eDv.loadUrl(str2);
            v.a(new u<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.u
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.ta(str);
                    return true;
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oN(String str) {
        if (!j.gP()) {
            showToast(d.k.neterror);
        } else if (!StringUtils.isNull(str)) {
            this.eDQ = str;
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.k.login_to_use), true, (int) IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BIND_WIDGET)));
            } else {
                sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), str)));
            }
        }
    }
}
