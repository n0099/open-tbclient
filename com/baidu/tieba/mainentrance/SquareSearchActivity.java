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
import com.baidu.ar.util.IoUtils;
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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.util.w;
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
    private ImageView bEt;
    private EditText cUU;
    private String dge;
    private ImageView dgo;
    private LinearLayoutDetectsSoftKeyboard eOL;
    private FrameLayout eOM;
    private FrameLayout eON;
    private TextView eOO;
    private BaseWebView eOP;
    private ScrollView eOQ;
    private LinearLayout eOR;
    private List<c> eOS;
    private g eOT;
    private LinearLayout eOU;
    private BdListView eOV;
    private com.baidu.tieba.mainentrance.a eOW;
    private com.baidu.tieba.mainentrance.searchSuggestList.a eOX;
    private ForumSuggestModel eOY;
    private a eOZ;
    private HotForumModel eOw;
    private String ePa;
    private boolean ePb;
    private ScrollView ePd;
    private SearchPageFocusBar ePe;
    private View ePf;
    private View ePg;
    private String ePk;
    private HotSearchInfoData mHotSearchInfo;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mTopicInfoTitle;
    private boolean ePc = true;
    private List<View> ePh = new ArrayList();
    private boolean eOx = false;
    private boolean ePi = true;
    private boolean ePj = true;
    private Runnable ePl = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.1
        @Override // java.lang.Runnable
        public void run() {
            SquareSearchActivity.this.cUU.requestFocus();
            l.c(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.cUU);
        }
    };
    private final Runnable ePm = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.12
        @Override // java.lang.Runnable
        public void run() {
            if (!SquareSearchActivity.this.aRD()) {
                try {
                    if (SquareSearchActivity.this.dge != null && SquareSearchActivity.this.dge.length() > 0) {
                        StringBuffer stringBuffer = new StringBuffer(30);
                        stringBuffer.append(TbConfig.SERVER_ADDRESS);
                        stringBuffer.append("c/f/forum/search");
                        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", SquareSearchActivity.this.dge.trim());
                        SquareSearchActivity.this.aRo();
                        SquareSearchActivity.this.eOZ = new a(stringBuffer.toString(), basicNameValuePair, true);
                        SquareSearchActivity.this.eOZ.setPriority(3);
                        SquareSearchActivity.this.eOZ.execute(stringBuffer.toString(), basicNameValuePair);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a ePn = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SEARCH_LIST, 309438) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.22
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = ((responsedMessage instanceof SearchListHttpResMessage) || (responsedMessage instanceof SearchListSocketResMessage)) ? false : true;
            if (responsedMessage == null || z || responsedMessage.getError() != 0 || responsedMessage.hasError()) {
                if (j.jD() || !SquareSearchActivity.this.eOx) {
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(d.k.neterror));
                }
                if (!j.jD()) {
                    SquareSearchActivity.this.eOx = true;
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
            if (SquareSearchActivity.this.ePi && responsedMessage.getError() != 0) {
                SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(d.k.neterror));
                return;
            }
            if (list != null && list.size() > 0) {
                SquareSearchActivity.this.ePi = false;
            }
            SquareSearchActivity.this.aRA();
            SquareSearchActivity.this.eOV.setAdapter((ListAdapter) SquareSearchActivity.this.eOX);
            SquareSearchActivity.this.eOX.py(SquareSearchActivity.this.dge.trim());
            SquareSearchActivity.this.eOX.setData(list);
            SquareSearchActivity.this.eOX.notifyDataSetInvalidated();
        }
    };
    private CustomMessageListener eOB = new CustomMessageListener(2001608) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                SquareSearchActivity.this.pB(customResponsedMessage.getData().toString());
            }
        }
    };
    private CustomMessageListener ePo = new CustomMessageListener(2009002) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.13
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
    private View.OnClickListener ePp = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.cUU);
            if (view.getTag() instanceof c) {
                c cVar = (c) view.getTag();
                TiebaStatic.log(new am("c10363").ah("obj_name", cVar.getName()));
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
                if (SquareSearchActivity.this.eOP.getUrl() != null && SquareSearchActivity.this.eOP.getUrl().contains(str)) {
                    SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.eOM);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aRn() {
        if (this.mHotSearchInfo == null) {
            return false;
        }
        if (this.mHotSearchInfo.aRl() == 0) {
            H(this.mHotSearchInfo.getName(), false);
        } else if (this.mHotSearchInfo.aRl() == 1 && !com.baidu.tbadk.plugins.b.e(getPageContext())) {
            sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new am("c10355").ah("obj_name", this.mHotSearchInfo.getName()).r("obj_type", this.mHotSearchInfo.aRl() == 0 ? 2 : 1));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.home_dialog_search);
        init();
        getWindow().setSoftInputMode(1);
        registerListener(this.ePo);
        registerListener(this.ePn);
        registerListener(this.eOB);
        registerListener(this.htmlLoadMessageListener);
        if (SquareSearchActivityConfig.IS_SHOW_RECOMMEND_FORUM) {
            this.eOw = new HotForumModel(getPageContext(), this);
            this.eOw.aRj();
        }
        this.ePb = false;
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
        hideLoadingView(this.eOM);
        this.mHandler.removeCallbacks(this.ePl);
        aRo();
    }

    public void aRo() {
        this.mHandler.removeCallbacks(this.ePm);
        if (this.eOZ != null) {
            this.eOZ.cancel();
            this.eOZ = null;
        }
    }

    private void init() {
        this.eOL = (LinearLayoutDetectsSoftKeyboard) findViewById(d.g.parent);
        this.eOL.setOnSoftKeyBoardShownListener(new LinearLayoutDetectsSoftKeyboard.a() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.24
            @Override // com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard.a
            public void in(boolean z) {
                SquareSearchActivity.this.ePc = z;
            }
        });
        this.eOL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.25
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    SquareSearchActivity.this.eOL.setFocusable(true);
                    SquareSearchActivity.this.eOL.setFocusableInTouchMode(true);
                    if (SquareSearchActivity.this.cUU.hasFocus()) {
                        l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.cUU);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        avi();
        this.eOM = (FrameLayout) findViewById(d.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds200)), null, null);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            this.ePd = (ScrollView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.i.home_searchbar_nodataview, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) this.ePd.findViewById(d.g.focusbar_nodata_root);
            this.ePe = (SearchPageFocusBar) linearLayout.findViewById(d.g.no_data_focusbar);
            linearLayout.addView(this.mNoDataView, 0);
            this.ePd.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.26
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.ePd);
                    return false;
                }
            });
            this.eOM.addView(this.ePd, this.eOM.getChildCount());
        } else {
            this.eOM.addView(this.mNoDataView, 0);
        }
        this.eON = (FrameLayout) findViewById(d.g.home_search_list);
        aRm();
        aRq();
        aRr();
        aRs();
        this.eOP = (BaseWebView) findViewById(d.g.search_result_webview);
        this.eOP.initCommonJsBridge(getPageContext().getPageActivity());
        this.eOP.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.27
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
                if (SquareSearchActivity.this.isProgressBarShown()) {
                    SquareSearchActivity.this.hideProgressBar();
                }
            }
        });
        this.eOP.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.28
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedError", 0, "", "requesturl", str2, "receiveerror", Integer.valueOf(i), "description", str);
            }
        });
        this.eOP.setOnReceivedSslErrorListener(new BaseWebView.g() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.g
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                if (sslError != null) {
                    com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedSslError", 0, "", "requesturl", sslError.getUrl(), "receiveerror", sslError.toString());
                }
            }
        });
        this.eOP.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.3
            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.mainentrance.SquareSearchActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return ay.zG().b(SquareSearchActivity.this.getPageContext(), new String[]{str}) != 3;
            }
        });
        this.cUU.setText("");
        this.cUU.requestFocus();
        ShowSoftKeyPadDelay(this.cUU, 200);
        aRt();
        aRu();
    }

    private void avi() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.i.square_search_navigation_view, (View.OnClickListener) null);
        this.bEt = (ImageView) addCustomView.findViewById(d.g.search_bar_icon);
        this.cUU = (EditText) addCustomView.findViewById(d.g.home_et_search);
        this.dgo = (ImageView) addCustomView.findViewById(d.g.home_bt_search_del);
        this.eOO = (TextView) addCustomView.findViewById(d.g.home_bt_search_cancel_s);
        this.cUU.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    SquareSearchActivity.this.aRp();
                } else {
                    l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.cUU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.aRp();
            }
        });
        this.eOO.setText(getPageContext().getString(d.k.cancel));
        this.eOO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.cUU);
                com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SquareSearchActivity.this.finish();
                    }
                }, 200L);
            }
        });
        this.cUU.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.7
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (SquareSearchActivity.this.dge == null || SquareSearchActivity.this.dge.trim().length() < 1) {
                        l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.cUU);
                        if (SquareSearchActivity.this.aRn()) {
                            return true;
                        }
                        SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(d.k.write_keyword));
                        return true;
                    }
                    String trim = SquareSearchActivity.this.cUU.getText().toString().trim();
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
        this.dgo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.cUU.setText("");
            }
        });
        this.cUU.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.9
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SquareSearchActivity.this.ePj) {
                    SquareSearchActivity.this.dge = editable.toString();
                    if (StringUtils.isNull(SquareSearchActivity.this.dge)) {
                        SquareSearchActivity.this.ePi = true;
                    }
                    SquareSearchActivity.this.aRx();
                }
                if (editable.toString().trim().length() == 0) {
                    SquareSearchActivity.this.dgo.setVisibility(8);
                } else {
                    SquareSearchActivity.this.dgo.setVisibility(0);
                }
                al.c(SquareSearchActivity.this.eOO, d.C0141d.cp_link_tip_a, 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRp() {
        if (StringUtils.isNull(this.cUU.getText().toString())) {
            if (this.eOQ.getVisibility() != 0) {
                aRv();
            }
        } else if (this.eOV.getVisibility() != 0) {
            aRx();
        }
    }

    private void aRq() {
        this.eOQ = (ScrollView) findViewById(d.g.search_history_scrollview);
        this.eOR = (LinearLayout) findViewById(d.g.search_history_linearlayout);
        if (this.eOU == null) {
            this.eOU = new LinearLayout(getPageContext().getPageActivity());
            this.eOU.setOrientation(1);
            this.eOU.setBackgroundColor(al.getColor(d.C0141d.cp_bg_line_d));
        }
        this.eOR.addView(this.eOU);
    }

    private void aRr() {
        if (this.eOT == null) {
            this.eOT = new g(getPageContext());
            this.eOR.addView(this.eOT.nn());
        }
    }

    private void aRs() {
        this.eOV = (BdListView) findViewById(d.g.home_lv_search_suggest);
        this.eOW = new com.baidu.tieba.mainentrance.a(this, null);
        this.eOX = new com.baidu.tieba.mainentrance.searchSuggestList.a(getPageContext().getPageActivity(), null);
        this.eOV.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.10
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
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
        this.eOV.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.11
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

    public void aRt() {
        this.eOO.setText(getPageContext().getString(d.k.cancel));
        aRu();
        aRo();
        aRy();
        if (this.dge.trim().length() > 0) {
            aRx();
        } else {
            aRv();
        }
    }

    private void aRu() {
        if (this.mHotSearchInfo == null) {
            this.cUU.setHint(d.k.search_bar);
        } else {
            this.cUU.setHint(" " + UtilHelper.getFixedText(this.mHotSearchInfo.aoC(), 15));
        }
    }

    private void aRm() {
        HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
        if (hotSearchInfoData != null && hotSearchInfoData.getId() != 0) {
            this.mHotSearchInfo = hotSearchInfoData;
        }
    }

    private void aRv() {
        this.eOP.setVisibility(8);
        this.eOV.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009002));
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            im(true);
            aS(this.ePe);
            aS(this.ePd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(ArrayList<String> arrayList) {
        NoDataViewFactory.d dr;
        if (ab(arrayList)) {
            aRC();
            if (j.jD()) {
                dr = NoDataViewFactory.d.dr(d.k.text_no_search_record);
            } else {
                dr = NoDataViewFactory.d.dr(d.k.neterror);
            }
            this.mNoDataView.setTextOption(dr);
            return;
        }
        aRB();
        aa(arrayList);
        D(true, arrayList == null || arrayList.size() == 0);
        aRu();
    }

    private void aa(final ArrayList<String> arrayList) {
        if (this.eOU != null) {
            this.eOU.removeAllViews();
            if (arrayList != null && !arrayList.isEmpty() && getActivity() != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                this.ePf = LayoutInflater.from(pageActivity).inflate(d.i.square_search_recommand_fourm_header, (ViewGroup) null);
                this.ePf.findViewById(d.g.titleTopDivider).setVisibility(8);
                getLayoutMode().onModeChanged(this.ePf);
                this.eOU.addView(this.ePf, layoutParams);
                int size = arrayList.size();
                this.ePh.clear();
                for (int i = 0; i < size; i++) {
                    final String str = arrayList.get(i);
                    if (!TextUtils.isEmpty(str)) {
                        final View inflate = LayoutInflater.from(pageActivity).inflate(d.i.home_dialog_search_item, (ViewGroup) null);
                        ((TextView) inflate.findViewById(d.g.home_lv_search_forum)).setText(str);
                        al.c((TextView) inflate.findViewById(d.g.home_lv_search_forum), d.C0141d.cp_cont_b, 1);
                        inflate.findViewById(d.g.home_dialog_lv_search_forum_divider).setVisibility(8);
                        al.i(inflate, d.f.square_search_item_bg);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        inflate.setOnClickListener(new b(str));
                        ImageView imageView = (ImageView) inflate.findViewById(d.g.del_search_history_btn);
                        al.c(imageView, d.f.icn_shop_order_close);
                        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                w.a(new v<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // com.baidu.tbadk.util.v
                                    public Boolean doInBackground() {
                                        com.baidu.tieba.tbadkCore.util.a.tW(str);
                                        return true;
                                    }
                                }, new h<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.2
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.tbadk.util.h
                                    public void onReturnDataInUI(Boolean bool) {
                                        SquareSearchActivity.this.eOU.removeView(inflate);
                                        arrayList.remove(str);
                                        if (arrayList.size() <= 0) {
                                            SquareSearchActivity.this.Z(null);
                                        }
                                    }
                                });
                            }
                        });
                        this.ePh.add(inflate);
                        this.eOU.addView(inflate, layoutParams2);
                    }
                }
                this.ePg = LayoutInflater.from(pageActivity).inflate(d.i.home_dialog_search_footer, (ViewGroup) null);
                ((TextView) this.ePg.findViewById(d.g.home_bt_search_footer)).setTextColor(al.getColor(d.C0141d.cp_link_tip_a));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                this.ePg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SquareSearchActivity.this.aRw();
                    }
                });
                this.eOU.addView(this.ePg, layoutParams3);
            }
        }
    }

    private void D(boolean z, boolean z2) {
        if (this.eOT != null) {
            this.eOT.clear();
            if (this.eOS != null && !this.eOS.isEmpty() && z) {
                this.eOT.il(!z2);
                this.eOT.setTitleText(this.mTopicInfoTitle);
                int size = this.eOS.size();
                if (size >= 1) {
                    if (size > 7) {
                        size = 7;
                    }
                    int i = size % 2 == 0 ? size - 1 : size;
                    for (int i2 = 0; i2 < i; i2++) {
                        c cVar = (c) com.baidu.tbadk.core.util.w.c(this.eOS, i2);
                        if (cVar != null) {
                            this.eOT.a(cVar, i2).setOnClickListener(this.ePp);
                        }
                    }
                    this.eOT.a(null, i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.16
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.cUU);
                            if (!com.baidu.tbadk.plugins.b.e(SquareSearchActivity.this.getPageContext())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all")));
                            }
                        }
                    });
                    this.eOT.show();
                }
            }
        }
    }

    private boolean ab(ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && (this.eOS == null || this.eOS.size() <= 2) && this.ePb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRw() {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).dB(getPageContext().getString(d.k.alert_clean_history)).a(getPageContext().getString(d.k.clear_all_text), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                com.baidu.adp.lib.g.h.in().d(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.bxS();
                    }
                });
                if (SquareSearchActivity.this.eOS == null || SquareSearchActivity.this.eOS.size() < 2) {
                    SquareSearchActivity.this.aR(SquareSearchActivity.this.ePd);
                    SquareSearchActivity.this.aR(SquareSearchActivity.this.ePe);
                    SquareSearchActivity.this.eON.setVisibility(8);
                    SquareSearchActivity.this.mNoDataView.setVisibility(0);
                    SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.dr(d.k.text_no_search_record));
                    return;
                }
                SquareSearchActivity.this.Z(null);
            }
        }).b(getPageContext().getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.17
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        }).b(getPageContext()).xa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRx() {
        if (this.dge.trim().length() > 0) {
            aRz();
            return;
        }
        aRo();
        aRv();
    }

    private void aRy() {
        if (this.eOV != null) {
            this.eOV.setNextPage(null);
        }
    }

    private void aRz() {
        if (!StringUtils.isNull(this.dge)) {
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.dge.trim();
            sendMessage(searchListNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        try {
            if (this.eOY != null) {
                if (this.eOY.forum_list != null && this.eOY.forum_list.size() > 0) {
                    aRA();
                    this.eOV.setAdapter((ListAdapter) this.eOW);
                    this.eOW.py(this.dge);
                    this.eOW.Y(this.eOY.forum_list);
                    this.eOW.notifyDataSetInvalidated();
                } else {
                    aS(this.ePd);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRA() {
        this.eON.setVisibility(0);
        this.eOV.setVisibility(0);
        this.eOQ.setVisibility(8);
        this.eOP.setVisibility(8);
        aS(this.ePd);
        this.mNoDataView.setVisibility(8);
    }

    private void aRB() {
        this.eON.setVisibility(0);
        this.eOQ.setVisibility(0);
        this.eOV.setVisibility(8);
        this.eOP.setVisibility(8);
        aS(this.ePd);
        this.mNoDataView.setVisibility(8);
    }

    private void aRC() {
        this.eON.setVisibility(8);
        this.eOV.setVisibility(8);
        this.eOQ.setVisibility(8);
        this.eOP.setVisibility(8);
        aR(this.ePd);
        this.mNoDataView.setVisibility(0);
        aR(this.ePe);
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void pz(String str) {
        this.ePb = true;
        this.eOS = new ArrayList();
        aRv();
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void a(List<com.baidu.tieba.mainentrance.b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str) {
        this.ePb = true;
        hideLoadingView(this.eOM);
        if (list2 == null) {
            this.eOS = new ArrayList();
        } else {
            this.eOS = list2;
        }
        if (!StringUtils.isNULL(str)) {
            this.mTopicInfoTitle = str;
        } else {
            this.mTopicInfoTitle = "";
        }
        a(hotSearchInfoData);
        this.mHotSearchInfo = hotSearchInfoData;
        aRv();
    }

    private void a(HotSearchInfoData hotSearchInfoData) {
        if (hotSearchInfoData != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
            return;
        }
        HotSearchInfoData hotSearchInfoData2 = new HotSearchInfoData();
        hotSearchInfoData2.setId(0L);
        hotSearchInfoData2.setName("");
        hotSearchInfoData2.pA("");
        hotSearchInfoData2.ct(0L);
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
        getLayoutMode().onModeChanged(this.eOL);
        al.e(this.eOL, i);
        if (this.eOW != null) {
            this.eOW.notifyDataSetChanged();
        }
        if (i == 2) {
            this.cUU.setHintTextColor(al.getColor(d.C0141d.s_navbar_title_color));
        } else {
            this.cUU.setHintTextColor(al.getColor(d.C0141d.cp_cont_e));
        }
        al.c(this.dgo, d.f.del_search_btn);
        al.b(this.cUU, d.C0141d.cp_cont_b, d.C0141d.s_navbar_title_color);
        al.a(this.bEt, d.f.icon_seach_n, d.f.icon_seach_n, d.f.icon_seach_n, i);
        al.i(this.eOM, d.C0141d.cp_bg_line_d);
        al.c(this.eOO, d.C0141d.cp_link_tip_a, 1);
        if (this.eOT != null) {
            this.eOT.onChangeSkinType(i);
        }
        oX(i);
    }

    private void oX(int i) {
        if (this.eOU != null) {
            this.eOU.setBackgroundColor(al.getColor(d.C0141d.cp_bg_line_d));
        }
        if (this.ePf != null) {
            getLayoutMode().onModeChanged(this.ePf);
        }
        if (this.ePg != null) {
            ((TextView) this.ePg.findViewById(d.g.home_bt_search_footer)).setTextColor(al.getColor(d.C0141d.cp_link_tip_a));
        }
        if (this.ePh != null) {
            for (View view : this.ePh) {
                al.c((TextView) view.findViewById(d.g.home_lv_search_forum), d.C0141d.cp_cont_b, 1);
                view.findViewById(d.g.home_dialog_lv_search_forum_divider).setBackgroundColor(al.getColor(d.C0141d.cp_bg_line_b));
                al.i(view, d.f.addresslist_item_bg);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (i == 4 && this.eOP.canGoBack()) {
                this.eOP.goBack();
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
        public void onClick(View view) {
            if (!TextUtils.isEmpty(this.mName)) {
                SquareSearchActivity.this.dge = this.mName;
                TiebaStatic.log(new am("c12034"));
                SquareSearchActivity.this.H(this.mName, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aRD() {
        if (!j.jD()) {
            aR(this.mNoDataView);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dr(d.k.neterror));
            return true;
        }
        aS(this.mNoDataView);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
        private BasicNameValuePair ePx;
        private y mNetwork = null;
        private String mUrl;

        public a(String str, BasicNameValuePair basicNameValuePair, boolean z) {
            this.mUrl = null;
            this.ePx = null;
            this.mUrl = str;
            this.ePx = basicNameValuePair;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!SquareSearchActivity.this.aRD()) {
                SquareSearchActivity.this.aS(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.eOM, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(d.e.ds320));
                SquareSearchActivity.this.eON.setVisibility(8);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public ForumSuggestModel doInBackground(Object... objArr) {
            ForumSuggestModel forumSuggestModel = null;
            if (j.jD()) {
                try {
                    this.mNetwork = new y(this.mUrl);
                    this.mNetwork.a(this.ePx);
                    String yl = this.mNetwork.yl();
                    if (yl != null) {
                        forumSuggestModel = ForumSuggestModel.parserJson(yl);
                        SquareSearchActivity.this.ePa = this.ePx.getValue();
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
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.eOM);
            if (forumSuggestModel != null) {
                SquareSearchActivity.this.aS(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.eOY = forumSuggestModel;
                SquareSearchActivity.this.refresh();
            } else {
                SquareSearchActivity.this.aR(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.dr(d.k.text_no_search_record));
            }
            SquareSearchActivity.this.eOZ = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.hN();
                this.mNetwork = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.eOM);
            super.cancel(true);
        }
    }

    private void im(boolean z) {
        if (TbadkCoreApplication.isLogin()) {
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(2001323, true));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(2001323, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(View view) {
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(View view) {
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a026";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(final String str, boolean z) {
        if (!j.jD()) {
            showToast(d.k.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.ePj = false;
                this.cUU.setText(str);
                this.cUU.setSelection(str.length());
                this.ePj = true;
            }
            l.b(getPageContext().getPageActivity(), this.cUU);
            this.eOQ.setVisibility(8);
            this.eOV.setVisibility(8);
            this.eOP.setVisibility(0);
            showProgressBarWithOffset(0, 0);
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, IoUtils.UTF_8);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            this.eOP.loadUrl(str2);
            w.a(new v<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.v
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.tU(str);
                    return true;
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pB(String str) {
        if (!j.jD()) {
            showToast(d.k.neterror);
        } else if (!StringUtils.isNull(str)) {
            this.ePk = str;
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.k.login_to_use), true, (int) IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BIND_WIDGET)));
            } else {
                sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), str)));
            }
        }
    }
}
