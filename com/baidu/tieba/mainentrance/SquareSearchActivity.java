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
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.e;
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
    private ImageView bWj;
    private ImageView dAe;
    private EditText dkN;
    private String dzU;
    private LinearLayoutDetectsSoftKeyboard fmN;
    private FrameLayout fmO;
    private FrameLayout fmP;
    private TextView fmQ;
    private BaseWebView fmR;
    private ScrollView fmS;
    private LinearLayout fmT;
    private List<c> fmU;
    private g fmV;
    private LinearLayout fmW;
    private BdListView fmX;
    private com.baidu.tieba.mainentrance.a fmY;
    private com.baidu.tieba.mainentrance.searchSuggestList.a fmZ;
    private HotForumModel fmz;
    private ForumSuggestModel fna;
    private a fnb;
    private String fnc;
    private boolean fnd;
    private ScrollView fnf;
    private SearchPageFocusBar fng;
    private View fnh;
    private View fni;
    private String fnm;
    private HotSearchInfoData mHotSearchInfo;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mTopicInfoTitle;
    private boolean fne = true;
    private List<View> fnj = new ArrayList();
    private boolean fmA = false;
    private boolean fnk = true;
    private boolean fnl = true;
    private Runnable fnn = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.1
        @Override // java.lang.Runnable
        public void run() {
            SquareSearchActivity.this.dkN.requestFocus();
            l.c(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.dkN);
        }
    };
    private final Runnable fno = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.12
        @Override // java.lang.Runnable
        public void run() {
            if (!SquareSearchActivity.this.aYg()) {
                try {
                    if (SquareSearchActivity.this.dzU != null && SquareSearchActivity.this.dzU.length() > 0) {
                        StringBuffer stringBuffer = new StringBuffer(30);
                        stringBuffer.append(TbConfig.SERVER_ADDRESS);
                        stringBuffer.append("c/f/forum/search");
                        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", SquareSearchActivity.this.dzU.trim());
                        SquareSearchActivity.this.aXR();
                        SquareSearchActivity.this.fnb = new a(stringBuffer.toString(), basicNameValuePair, true);
                        SquareSearchActivity.this.fnb.setPriority(3);
                        SquareSearchActivity.this.fnb.execute(stringBuffer.toString(), basicNameValuePair);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a fnp = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SEARCH_LIST, 309438) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.22
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = ((responsedMessage instanceof SearchListHttpResMessage) || (responsedMessage instanceof SearchListSocketResMessage)) ? false : true;
            if (responsedMessage == null || z || responsedMessage.getError() != 0 || responsedMessage.hasError()) {
                if (j.kV() || !SquareSearchActivity.this.fmA) {
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(e.j.neterror));
                }
                if (!j.kV()) {
                    SquareSearchActivity.this.fmA = true;
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
            if (SquareSearchActivity.this.fnk && responsedMessage.getError() != 0) {
                SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(e.j.neterror));
                return;
            }
            if (list != null && list.size() > 0) {
                SquareSearchActivity.this.fnk = false;
            }
            SquareSearchActivity.this.aYd();
            SquareSearchActivity.this.fmX.setAdapter((ListAdapter) SquareSearchActivity.this.fmZ);
            SquareSearchActivity.this.fmZ.qK(SquareSearchActivity.this.dzU.trim());
            SquareSearchActivity.this.fmZ.setData(list);
            SquareSearchActivity.this.fmZ.notifyDataSetInvalidated();
        }
    };
    private CustomMessageListener fmE = new CustomMessageListener(2001608) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                SquareSearchActivity.this.qN(customResponsedMessage.getData().toString());
            }
        }
    };
    private CustomMessageListener fnq = new CustomMessageListener(2009002) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof ArrayList) {
                    SquareSearchActivity.this.ac((ArrayList) data);
                }
            }
        }
    };
    private View.OnClickListener fnr = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.dkN);
            if (view.getTag() instanceof c) {
                c cVar = (c) view.getTag();
                TiebaStatic.log(new am("c10363").ax("obj_name", cVar.getName()));
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
                if (SquareSearchActivity.this.fmR.getUrl() != null && SquareSearchActivity.this.fmR.getUrl().contains(str)) {
                    SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.fmO);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aXQ() {
        if (this.mHotSearchInfo == null) {
            return false;
        }
        if (this.mHotSearchInfo.aXO() == 0) {
            P(this.mHotSearchInfo.getName(), false);
        } else if (this.mHotSearchInfo.aXO() == 1 && !com.baidu.tbadk.plugins.b.e(getPageContext())) {
            sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new am("c10355").ax("obj_name", this.mHotSearchInfo.getName()).x("obj_type", this.mHotSearchInfo.aXO() == 0 ? 2 : 1));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.home_dialog_search);
        init();
        getWindow().setSoftInputMode(1);
        registerListener(this.fnq);
        registerListener(this.fnp);
        registerListener(this.fmE);
        registerListener(this.htmlLoadMessageListener);
        if (SquareSearchActivityConfig.IS_SHOW_RECOMMEND_FORUM) {
            this.fmz = new HotForumModel(getPageContext(), this);
            this.fmz.aXM();
        }
        this.fnd = false;
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
        hideLoadingView(this.fmO);
        this.mHandler.removeCallbacks(this.fnn);
        aXR();
    }

    public void aXR() {
        this.mHandler.removeCallbacks(this.fno);
        if (this.fnb != null) {
            this.fnb.cancel();
            this.fnb = null;
        }
    }

    private void init() {
        this.fmN = (LinearLayoutDetectsSoftKeyboard) findViewById(e.g.parent);
        this.fmN.setOnSoftKeyBoardShownListener(new LinearLayoutDetectsSoftKeyboard.a() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.24
            @Override // com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard.a
            public void jB(boolean z) {
                SquareSearchActivity.this.fne = z;
            }
        });
        this.fmN.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.25
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    SquareSearchActivity.this.fmN.setFocusable(true);
                    SquareSearchActivity.this.fmN.setFocusableInTouchMode(true);
                    if (SquareSearchActivity.this.dkN.hasFocus()) {
                        l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.dkN);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        awU();
        this.fmO = (FrameLayout) findViewById(e.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(e.C0200e.ds200)), null, null);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            this.fnf = (ScrollView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(e.h.home_searchbar_nodataview, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) this.fnf.findViewById(e.g.focusbar_nodata_root);
            this.fng = (SearchPageFocusBar) linearLayout.findViewById(e.g.no_data_focusbar);
            linearLayout.addView(this.mNoDataView, 0);
            this.fnf.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.26
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.fnf);
                    return false;
                }
            });
            this.fmO.addView(this.fnf, this.fmO.getChildCount());
        } else {
            this.fmO.addView(this.mNoDataView, 0);
        }
        this.fmP = (FrameLayout) findViewById(e.g.home_search_list);
        aXP();
        aXT();
        aXU();
        aXV();
        this.fmR = (BaseWebView) findViewById(e.g.search_result_webview);
        this.fmR.initCommonJsBridge(getPageContext().getPageActivity());
        this.fmR.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.27
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
                if (SquareSearchActivity.this.isProgressBarShown()) {
                    SquareSearchActivity.this.hideProgressBar();
                }
            }
        });
        this.fmR.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.28
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedError", 0, "", "requesturl", str2, "receiveerror", Integer.valueOf(i), "description", str);
            }
        });
        this.fmR.setOnReceivedSslErrorListener(new BaseWebView.g() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.g
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                if (sslError != null) {
                    com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedSslError", 0, "", "requesturl", sslError.getUrl(), "receiveerror", sslError.toString());
                }
            }
        });
        this.fmR.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.3
            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.mainentrance.SquareSearchActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return ay.Db().b(SquareSearchActivity.this.getPageContext(), new String[]{str}) != 3;
            }
        });
        this.dkN.setText("");
        this.dkN.requestFocus();
        ShowSoftKeyPadDelay(this.dkN, 200);
        aXW();
        aXX();
    }

    private void awU() {
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, e.h.square_search_navigation_view, (View.OnClickListener) null);
        this.bWj = (ImageView) addCustomView.findViewById(e.g.search_bar_icon);
        this.dkN = (EditText) addCustomView.findViewById(e.g.home_et_search);
        this.dAe = (ImageView) addCustomView.findViewById(e.g.home_bt_search_del);
        this.fmQ = (TextView) addCustomView.findViewById(e.g.home_bt_search_cancel_s);
        this.dkN.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    SquareSearchActivity.this.aXS();
                } else {
                    l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.dkN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.aXS();
            }
        });
        this.fmQ.setText(getPageContext().getString(e.j.cancel));
        this.fmQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.dkN);
                com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SquareSearchActivity.this.finish();
                    }
                }, 200L);
            }
        });
        this.dkN.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.7
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (SquareSearchActivity.this.dzU == null || SquareSearchActivity.this.dzU.trim().length() < 1) {
                        l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.dkN);
                        if (SquareSearchActivity.this.aXQ()) {
                            return true;
                        }
                        SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(e.j.write_keyword));
                        return true;
                    }
                    String trim = SquareSearchActivity.this.dkN.getText().toString().trim();
                    if (!StringUtils.isNull(trim)) {
                        SquareSearchActivity.this.P(trim, false);
                        return true;
                    }
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(e.j.write_keyword));
                    return true;
                }
                return false;
            }
        });
        this.dAe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.dkN.setText("");
            }
        });
        this.dkN.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.9
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SquareSearchActivity.this.fnl) {
                    SquareSearchActivity.this.dzU = editable.toString();
                    if (StringUtils.isNull(SquareSearchActivity.this.dzU)) {
                        SquareSearchActivity.this.fnk = true;
                    }
                    SquareSearchActivity.this.aYa();
                }
                if (editable.toString().trim().length() == 0) {
                    SquareSearchActivity.this.dAe.setVisibility(8);
                } else {
                    SquareSearchActivity.this.dAe.setVisibility(0);
                }
                al.c(SquareSearchActivity.this.fmQ, e.d.cp_link_tip_a, 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXS() {
        if (StringUtils.isNull(this.dkN.getText().toString())) {
            if (this.fmS.getVisibility() != 0) {
                aXY();
            }
        } else if (this.fmX.getVisibility() != 0) {
            aYa();
        }
    }

    private void aXT() {
        this.fmS = (ScrollView) findViewById(e.g.search_history_scrollview);
        this.fmT = (LinearLayout) findViewById(e.g.search_history_linearlayout);
        if (this.fmW == null) {
            this.fmW = new LinearLayout(getPageContext().getPageActivity());
            this.fmW.setOrientation(1);
            this.fmW.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
        }
        this.fmT.addView(this.fmW);
    }

    private void aXU() {
        if (this.fmV == null) {
            this.fmV = new g(getPageContext());
            this.fmT.addView(this.fmV.oE());
        }
    }

    private void aXV() {
        this.fmX = (BdListView) findViewById(e.g.home_lv_search_suggest);
        this.fmY = new com.baidu.tieba.mainentrance.a(this, null);
        this.fmZ = new com.baidu.tieba.mainentrance.searchSuggestList.a(getPageContext().getPageActivity(), null);
        this.fmX.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.10
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ListAdapter adapter;
                ListView listView = (ListView) adapterView;
                if (listView != null && (adapter = listView.getAdapter()) != null && adapter.getCount() != 0 && i < adapter.getCount()) {
                    Object item = adapter.getItem(i);
                    if (item instanceof String) {
                        SquareSearchActivity.this.P((String) item, true);
                        TiebaStatic.eventStat(SquareSearchActivity.this.getPageContext().getPageActivity(), "search_bar_result_click", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    }
                }
            }
        });
        this.fmX.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.11
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

    public void aXW() {
        this.fmQ.setText(getPageContext().getString(e.j.cancel));
        aXX();
        aXR();
        aYb();
        if (this.dzU.trim().length() > 0) {
            aYa();
        } else {
            aXY();
        }
    }

    private void aXX() {
        if (this.mHotSearchInfo == null) {
            this.dkN.setHint(e.j.search_bar);
        } else {
            this.dkN.setHint(" " + UtilHelper.getFixedText(this.mHotSearchInfo.atg(), 15));
        }
    }

    private void aXP() {
        HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
        if (hotSearchInfoData != null && hotSearchInfoData.getId() != 0) {
            this.mHotSearchInfo = hotSearchInfoData;
        }
    }

    private void aXY() {
        this.fmR.setVisibility(8);
        this.fmX.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009002));
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            jA(true);
            bm(this.fng);
            bm(this.fnf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(ArrayList<String> arrayList) {
        NoDataViewFactory.d ec;
        if (ae(arrayList)) {
            aYf();
            if (j.kV()) {
                ec = NoDataViewFactory.d.ec(e.j.text_no_search_record);
            } else {
                ec = NoDataViewFactory.d.ec(e.j.neterror);
            }
            this.mNoDataView.setTextOption(ec);
            return;
        }
        aYe();
        ad(arrayList);
        L(true, arrayList == null || arrayList.size() == 0);
        aXX();
    }

    private void ad(final ArrayList<String> arrayList) {
        if (this.fmW != null) {
            this.fmW.removeAllViews();
            if (arrayList != null && !arrayList.isEmpty() && getActivity() != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                this.fnh = LayoutInflater.from(pageActivity).inflate(e.h.square_search_recommand_fourm_header, (ViewGroup) null);
                this.fnh.findViewById(e.g.titleTopDivider).setVisibility(8);
                getLayoutMode().onModeChanged(this.fnh);
                this.fmW.addView(this.fnh, layoutParams);
                int size = arrayList.size();
                this.fnj.clear();
                for (int i = 0; i < size; i++) {
                    final String str = arrayList.get(i);
                    if (!TextUtils.isEmpty(str)) {
                        final View inflate = LayoutInflater.from(pageActivity).inflate(e.h.home_dialog_search_item, (ViewGroup) null);
                        ((TextView) inflate.findViewById(e.g.home_lv_search_forum)).setText(str);
                        al.c((TextView) inflate.findViewById(e.g.home_lv_search_forum), e.d.cp_cont_b, 1);
                        inflate.findViewById(e.g.home_dialog_lv_search_forum_divider).setVisibility(8);
                        al.i(inflate, e.f.square_search_item_bg);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        inflate.setOnClickListener(new b(str));
                        ImageView imageView = (ImageView) inflate.findViewById(e.g.del_search_history_btn);
                        al.c(imageView, e.f.icn_shop_order_close);
                        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                x.a(new w<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // com.baidu.tbadk.util.w
                                    public Boolean doInBackground() {
                                        com.baidu.tieba.tbadkCore.util.a.vm(str);
                                        return true;
                                    }
                                }, new h<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.2
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.tbadk.util.h
                                    public void onReturnDataInUI(Boolean bool) {
                                        SquareSearchActivity.this.fmW.removeView(inflate);
                                        arrayList.remove(str);
                                        if (arrayList.size() <= 0) {
                                            SquareSearchActivity.this.ac(null);
                                        }
                                    }
                                });
                            }
                        });
                        this.fnj.add(inflate);
                        this.fmW.addView(inflate, layoutParams2);
                    }
                }
                this.fni = LayoutInflater.from(pageActivity).inflate(e.h.home_dialog_search_footer, (ViewGroup) null);
                ((TextView) this.fni.findViewById(e.g.home_bt_search_footer)).setTextColor(al.getColor(e.d.cp_link_tip_a));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                this.fni.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SquareSearchActivity.this.aXZ();
                    }
                });
                this.fmW.addView(this.fni, layoutParams3);
            }
        }
    }

    private void L(boolean z, boolean z2) {
        if (this.fmV != null) {
            this.fmV.clear();
            if (this.fmU != null && !this.fmU.isEmpty() && z) {
                this.fmV.jz(!z2);
                this.fmV.setTitleText(this.mTopicInfoTitle);
                int size = this.fmU.size();
                if (size >= 1) {
                    if (size > 7) {
                        size = 7;
                    }
                    int i = size % 2 == 0 ? size - 1 : size;
                    for (int i2 = 0; i2 < i; i2++) {
                        c cVar = (c) v.d(this.fmU, i2);
                        if (cVar != null) {
                            this.fmV.a(cVar, i2).setOnClickListener(this.fnr);
                        }
                    }
                    this.fmV.a(null, i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.16
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.dkN);
                            if (!com.baidu.tbadk.plugins.b.e(SquareSearchActivity.this.getPageContext())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all")));
                            }
                        }
                    });
                    this.fmV.show();
                }
            }
        }
    }

    private boolean ae(ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && (this.fmU == null || this.fmU.size() <= 2) && this.fnd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXZ() {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).ej(getPageContext().getString(e.j.alert_clean_history)).a(getPageContext().getString(e.j.clear_all_text), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                com.baidu.adp.lib.g.h.jH().d(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.bCo();
                    }
                });
                if (SquareSearchActivity.this.fmU == null || SquareSearchActivity.this.fmU.size() < 2) {
                    SquareSearchActivity.this.bl(SquareSearchActivity.this.fnf);
                    SquareSearchActivity.this.bl(SquareSearchActivity.this.fng);
                    SquareSearchActivity.this.fmP.setVisibility(8);
                    SquareSearchActivity.this.mNoDataView.setVisibility(0);
                    SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.ec(e.j.text_no_search_record));
                    return;
                }
                SquareSearchActivity.this.ac(null);
            }
        }).b(getPageContext().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.17
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        }).b(getPageContext()).AB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYa() {
        if (this.dzU.trim().length() > 0) {
            aYc();
            return;
        }
        aXR();
        aXY();
    }

    private void aYb() {
        if (this.fmX != null) {
            this.fmX.setNextPage(null);
        }
    }

    private void aYc() {
        if (!StringUtils.isNull(this.dzU)) {
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.dzU.trim();
            sendMessage(searchListNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        try {
            if (this.fna != null) {
                if (this.fna.forum_list != null && this.fna.forum_list.size() > 0) {
                    aYd();
                    this.fmX.setAdapter((ListAdapter) this.fmY);
                    this.fmY.qK(this.dzU);
                    this.fmY.ab(this.fna.forum_list);
                    this.fmY.notifyDataSetInvalidated();
                } else {
                    bm(this.fnf);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYd() {
        this.fmP.setVisibility(0);
        this.fmX.setVisibility(0);
        this.fmS.setVisibility(8);
        this.fmR.setVisibility(8);
        bm(this.fnf);
        this.mNoDataView.setVisibility(8);
    }

    private void aYe() {
        this.fmP.setVisibility(0);
        this.fmS.setVisibility(0);
        this.fmX.setVisibility(8);
        this.fmR.setVisibility(8);
        bm(this.fnf);
        this.mNoDataView.setVisibility(8);
    }

    private void aYf() {
        this.fmP.setVisibility(8);
        this.fmX.setVisibility(8);
        this.fmS.setVisibility(8);
        this.fmR.setVisibility(8);
        bl(this.fnf);
        this.mNoDataView.setVisibility(0);
        bl(this.fng);
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void qL(String str) {
        this.fnd = true;
        this.fmU = new ArrayList();
        aXY();
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void a(List<com.baidu.tieba.mainentrance.b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str) {
        this.fnd = true;
        hideLoadingView(this.fmO);
        if (list2 == null) {
            this.fmU = new ArrayList();
        } else {
            this.fmU = list2;
        }
        if (!StringUtils.isNULL(str)) {
            this.mTopicInfoTitle = str;
        } else {
            this.mTopicInfoTitle = "";
        }
        a(hotSearchInfoData);
        this.mHotSearchInfo = hotSearchInfoData;
        aXY();
    }

    private void a(HotSearchInfoData hotSearchInfoData) {
        if (hotSearchInfoData != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
            return;
        }
        HotSearchInfoData hotSearchInfoData2 = new HotSearchInfoData();
        hotSearchInfoData2.setId(0L);
        hotSearchInfoData2.setName("");
        hotSearchInfoData2.qM("");
        hotSearchInfoData2.cA(0L);
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
        getLayoutMode().onModeChanged(this.fmN);
        al.e(this.fmN, i);
        if (this.fmY != null) {
            this.fmY.notifyDataSetChanged();
        }
        if (i == 2) {
            this.dkN.setHintTextColor(al.getColor(e.d.s_navbar_title_color));
        } else {
            this.dkN.setHintTextColor(al.getColor(e.d.cp_cont_e));
        }
        al.c(this.dAe, e.f.del_search_btn);
        al.b(this.dkN, e.d.cp_cont_b, e.d.s_navbar_title_color);
        al.a(this.bWj, e.f.icon_seach_n, e.f.icon_seach_n, e.f.icon_seach_n, i);
        al.i(this.fmO, e.d.cp_bg_line_d);
        al.c(this.fmQ, e.d.cp_link_tip_a, 1);
        if (this.fmV != null) {
            this.fmV.onChangeSkinType(i);
        }
        qO(i);
    }

    private void qO(int i) {
        if (this.fmW != null) {
            this.fmW.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
        }
        if (this.fnh != null) {
            getLayoutMode().onModeChanged(this.fnh);
        }
        if (this.fni != null) {
            ((TextView) this.fni.findViewById(e.g.home_bt_search_footer)).setTextColor(al.getColor(e.d.cp_link_tip_a));
        }
        if (this.fnj != null) {
            for (View view : this.fnj) {
                al.c((TextView) view.findViewById(e.g.home_lv_search_forum), e.d.cp_cont_b, 1);
                view.findViewById(e.g.home_dialog_lv_search_forum_divider).setBackgroundColor(al.getColor(e.d.cp_bg_line_b));
                al.i(view, e.f.addresslist_item_bg);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (i == 4 && this.fmR.canGoBack()) {
                this.fmR.goBack();
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
            com.baidu.tbadk.core.e.b.k(getPageContext().getPageActivity(), 1);
        } else {
            com.baidu.tbadk.core.e.b.k(getPageContext().getPageActivity(), 2);
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
                SquareSearchActivity.this.dzU = this.mName;
                TiebaStatic.log(new am("c12034"));
                SquareSearchActivity.this.P(this.mName, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aYg() {
        if (!j.kV()) {
            bl(this.mNoDataView);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.ec(e.j.neterror));
            return true;
        }
        bm(this.mNoDataView);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
        private BasicNameValuePair fnz;
        private com.baidu.tbadk.core.util.x mNetwork = null;
        private String mUrl;

        public a(String str, BasicNameValuePair basicNameValuePair, boolean z) {
            this.mUrl = null;
            this.fnz = null;
            this.mUrl = str;
            this.fnz = basicNameValuePair;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!SquareSearchActivity.this.aYg()) {
                SquareSearchActivity.this.bm(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.fmO, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(e.C0200e.ds320));
                SquareSearchActivity.this.fmP.setVisibility(8);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public ForumSuggestModel doInBackground(Object... objArr) {
            ForumSuggestModel forumSuggestModel = null;
            if (j.kV()) {
                try {
                    this.mNetwork = new com.baidu.tbadk.core.util.x(this.mUrl);
                    this.mNetwork.a(this.fnz);
                    String BH = this.mNetwork.BH();
                    if (BH != null) {
                        forumSuggestModel = ForumSuggestModel.parserJson(BH);
                        SquareSearchActivity.this.fnc = this.fnz.getValue();
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
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.fmO);
            if (forumSuggestModel != null) {
                SquareSearchActivity.this.bm(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.fna = forumSuggestModel;
                SquareSearchActivity.this.refresh();
            } else {
                SquareSearchActivity.this.bl(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.ec(e.j.text_no_search_record));
            }
            SquareSearchActivity.this.fnb = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.jg();
                this.mNetwork = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.fmO);
            super.cancel(true);
        }
    }

    private void jA(boolean z) {
        if (TbadkCoreApplication.isLogin()) {
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(2001323, true));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(2001323, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bl(View view) {
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bm(View view) {
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a026";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(final String str, boolean z) {
        if (!j.kV()) {
            showToast(e.j.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.fnl = false;
                this.dkN.setText(str);
                this.dkN.setSelection(str.length());
                this.fnl = true;
            }
            l.b(getPageContext().getPageActivity(), this.dkN);
            this.fmS.setVisibility(8);
            this.fmX.setVisibility(8);
            this.fmR.setVisibility(0);
            showProgressBarWithOffset(0, 0);
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, IoUtils.UTF_8);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            this.fmR.loadUrl(str2);
            x.a(new w<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.w
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.vk(str);
                    return true;
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qN(String str) {
        if (!j.kV()) {
            showToast(e.j.neterror);
        } else if (!StringUtils.isNull(str)) {
            this.fnm = str;
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BIND_WIDGET)));
            } else {
                sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), str)));
            }
        }
    }
}
