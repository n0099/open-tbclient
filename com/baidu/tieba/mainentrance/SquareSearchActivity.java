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
import com.tencent.open.SocialConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
@SuppressLint({"ResourceAsColor"})
@Deprecated
/* loaded from: classes3.dex */
public class SquareSearchActivity extends BaseActivity<SquareSearchActivity> implements HotForumModel.a {
    private ImageView bMT;
    private EditText dby;
    private String dqC;
    private ImageView dqM;
    private LinearLayoutDetectsSoftKeyboard fdM;
    private FrameLayout fdN;
    private FrameLayout fdO;
    private TextView fdP;
    private BaseWebView fdQ;
    private ScrollView fdR;
    private LinearLayout fdS;
    private List<c> fdT;
    private g fdU;
    private LinearLayout fdV;
    private BdListView fdW;
    private com.baidu.tieba.mainentrance.a fdX;
    private com.baidu.tieba.mainentrance.searchSuggestList.a fdY;
    private ForumSuggestModel fdZ;
    private HotForumModel fdy;
    private a fea;
    private String feb;
    private boolean fec;
    private ScrollView fee;
    private SearchPageFocusBar fef;
    private View feg;
    private View feh;
    private String fel;
    private HotSearchInfoData mHotSearchInfo;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mTopicInfoTitle;
    private boolean fed = true;
    private List<View> fei = new ArrayList();
    private boolean fdz = false;
    private boolean fej = true;
    private boolean fek = true;
    private Runnable fem = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.1
        @Override // java.lang.Runnable
        public void run() {
            SquareSearchActivity.this.dby.requestFocus();
            l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.dby);
        }
    };
    private final Runnable fen = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.12
        @Override // java.lang.Runnable
        public void run() {
            if (!SquareSearchActivity.this.aVw()) {
                try {
                    if (SquareSearchActivity.this.dqC != null && SquareSearchActivity.this.dqC.length() > 0) {
                        StringBuffer stringBuffer = new StringBuffer(30);
                        stringBuffer.append(TbConfig.SERVER_ADDRESS);
                        stringBuffer.append("c/f/forum/search");
                        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", SquareSearchActivity.this.dqC.trim());
                        SquareSearchActivity.this.aVh();
                        SquareSearchActivity.this.fea = new a(stringBuffer.toString(), basicNameValuePair, true);
                        SquareSearchActivity.this.fea.setPriority(3);
                        SquareSearchActivity.this.fea.execute(stringBuffer.toString(), basicNameValuePair);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a feo = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SEARCH_LIST, 309438) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.22
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = ((responsedMessage instanceof SearchListHttpResMessage) || (responsedMessage instanceof SearchListSocketResMessage)) ? false : true;
            if (responsedMessage == null || z || responsedMessage.getError() != 0 || responsedMessage.hasError()) {
                if (j.kK() || !SquareSearchActivity.this.fdz) {
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(e.j.neterror));
                }
                if (!j.kK()) {
                    SquareSearchActivity.this.fdz = true;
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
            if (SquareSearchActivity.this.fej && responsedMessage.getError() != 0) {
                SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(e.j.neterror));
                return;
            }
            if (list != null && list.size() > 0) {
                SquareSearchActivity.this.fej = false;
            }
            SquareSearchActivity.this.aVt();
            SquareSearchActivity.this.fdW.setAdapter((ListAdapter) SquareSearchActivity.this.fdY);
            SquareSearchActivity.this.fdY.qh(SquareSearchActivity.this.dqC.trim());
            SquareSearchActivity.this.fdY.setData(list);
            SquareSearchActivity.this.fdY.notifyDataSetInvalidated();
        }
    };
    private CustomMessageListener fdD = new CustomMessageListener(2001608) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                SquareSearchActivity.this.qk(customResponsedMessage.getData().toString());
            }
        }
    };
    private CustomMessageListener fep = new CustomMessageListener(2009002) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof ArrayList) {
                    SquareSearchActivity.this.ad((ArrayList) data);
                }
            }
        }
    };
    private View.OnClickListener feq = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.dby);
            if (view.getTag() instanceof c) {
                c cVar = (c) view.getTag();
                TiebaStatic.log(new am("c10363").al("obj_name", cVar.getName()));
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
                if (SquareSearchActivity.this.fdQ.getUrl() != null && SquareSearchActivity.this.fdQ.getUrl().contains(str)) {
                    SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.fdN);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aVg() {
        if (this.mHotSearchInfo == null) {
            return false;
        }
        if (this.mHotSearchInfo.aVe() == 0) {
            I(this.mHotSearchInfo.getName(), false);
        } else if (this.mHotSearchInfo.aVe() == 1 && !com.baidu.tbadk.plugins.b.e(getPageContext())) {
            sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new am("c10355").al("obj_name", this.mHotSearchInfo.getName()).w("obj_type", this.mHotSearchInfo.aVe() == 0 ? 2 : 1));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.home_dialog_search);
        init();
        getWindow().setSoftInputMode(1);
        registerListener(this.fep);
        registerListener(this.feo);
        registerListener(this.fdD);
        registerListener(this.htmlLoadMessageListener);
        if (SquareSearchActivityConfig.IS_SHOW_RECOMMEND_FORUM) {
            this.fdy = new HotForumModel(getPageContext(), this);
            this.fdy.aVc();
        }
        this.fec = false;
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
        hideLoadingView(this.fdN);
        this.mHandler.removeCallbacks(this.fem);
        aVh();
    }

    public void aVh() {
        this.mHandler.removeCallbacks(this.fen);
        if (this.fea != null) {
            this.fea.cancel();
            this.fea = null;
        }
    }

    private void init() {
        this.fdM = (LinearLayoutDetectsSoftKeyboard) findViewById(e.g.parent);
        this.fdM.setOnSoftKeyBoardShownListener(new LinearLayoutDetectsSoftKeyboard.a() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.24
            @Override // com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard.a
            public void iZ(boolean z) {
                SquareSearchActivity.this.fed = z;
            }
        });
        this.fdM.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.25
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    SquareSearchActivity.this.fdM.setFocusable(true);
                    SquareSearchActivity.this.fdM.setFocusableInTouchMode(true);
                    if (SquareSearchActivity.this.dby.hasFocus()) {
                        l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.dby);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        atZ();
        this.fdN = (FrameLayout) findViewById(e.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(e.C0141e.ds200)), null, null);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            this.fee = (ScrollView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(e.h.home_searchbar_nodataview, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) this.fee.findViewById(e.g.focusbar_nodata_root);
            this.fef = (SearchPageFocusBar) linearLayout.findViewById(e.g.no_data_focusbar);
            linearLayout.addView(this.mNoDataView, 0);
            this.fee.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.26
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.fee);
                    return false;
                }
            });
            this.fdN.addView(this.fee, this.fdN.getChildCount());
        } else {
            this.fdN.addView(this.mNoDataView, 0);
        }
        this.fdO = (FrameLayout) findViewById(e.g.home_search_list);
        aVf();
        aVj();
        aVk();
        aVl();
        this.fdQ = (BaseWebView) findViewById(e.g.search_result_webview);
        this.fdQ.initCommonJsBridge(getPageContext().getPageActivity());
        this.fdQ.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.27
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
                if (SquareSearchActivity.this.isProgressBarShown()) {
                    SquareSearchActivity.this.hideProgressBar();
                }
            }
        });
        this.fdQ.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.28
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedError", 0, "", "requesturl", str2, "receiveerror", Integer.valueOf(i), SocialConstants.PARAM_COMMENT, str);
            }
        });
        this.fdQ.setOnReceivedSslErrorListener(new BaseWebView.g() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.g
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                if (sslError != null) {
                    com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedSslError", 0, "", "requesturl", sslError.getUrl(), "receiveerror", sslError.toString());
                }
            }
        });
        this.fdQ.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.3
            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.mainentrance.SquareSearchActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return ay.AN().b(SquareSearchActivity.this.getPageContext(), new String[]{str}) != 3;
            }
        });
        this.dby.setText("");
        this.dby.requestFocus();
        ShowSoftKeyPadDelay(this.dby, 200);
        aVm();
        aVn();
    }

    private void atZ() {
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, e.h.square_search_navigation_view, (View.OnClickListener) null);
        this.bMT = (ImageView) addCustomView.findViewById(e.g.search_bar_icon);
        this.dby = (EditText) addCustomView.findViewById(e.g.home_et_search);
        this.dqM = (ImageView) addCustomView.findViewById(e.g.home_bt_search_del);
        this.fdP = (TextView) addCustomView.findViewById(e.g.home_bt_search_cancel_s);
        this.dby.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    SquareSearchActivity.this.aVi();
                } else {
                    l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.dby.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.aVi();
            }
        });
        this.fdP.setText(getPageContext().getString(e.j.cancel));
        this.fdP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.dby);
                com.baidu.adp.lib.g.e.jt().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SquareSearchActivity.this.finish();
                    }
                }, 200L);
            }
        });
        this.dby.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.7
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (SquareSearchActivity.this.dqC == null || SquareSearchActivity.this.dqC.trim().length() < 1) {
                        l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.dby);
                        if (SquareSearchActivity.this.aVg()) {
                            return true;
                        }
                        SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(e.j.write_keyword));
                        return true;
                    }
                    String trim = SquareSearchActivity.this.dby.getText().toString().trim();
                    if (!StringUtils.isNull(trim)) {
                        SquareSearchActivity.this.I(trim, false);
                        return true;
                    }
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(e.j.write_keyword));
                    return true;
                }
                return false;
            }
        });
        this.dqM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.dby.setText("");
            }
        });
        this.dby.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.9
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SquareSearchActivity.this.fek) {
                    SquareSearchActivity.this.dqC = editable.toString();
                    if (StringUtils.isNull(SquareSearchActivity.this.dqC)) {
                        SquareSearchActivity.this.fej = true;
                    }
                    SquareSearchActivity.this.aVq();
                }
                if (editable.toString().trim().length() == 0) {
                    SquareSearchActivity.this.dqM.setVisibility(8);
                } else {
                    SquareSearchActivity.this.dqM.setVisibility(0);
                }
                al.c(SquareSearchActivity.this.fdP, e.d.cp_link_tip_a, 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVi() {
        if (StringUtils.isNull(this.dby.getText().toString())) {
            if (this.fdR.getVisibility() != 0) {
                aVo();
            }
        } else if (this.fdW.getVisibility() != 0) {
            aVq();
        }
    }

    private void aVj() {
        this.fdR = (ScrollView) findViewById(e.g.search_history_scrollview);
        this.fdS = (LinearLayout) findViewById(e.g.search_history_linearlayout);
        if (this.fdV == null) {
            this.fdV = new LinearLayout(getPageContext().getPageActivity());
            this.fdV.setOrientation(1);
            this.fdV.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
        }
        this.fdS.addView(this.fdV);
    }

    private void aVk() {
        if (this.fdU == null) {
            this.fdU = new g(getPageContext());
            this.fdS.addView(this.fdU.ov());
        }
    }

    private void aVl() {
        this.fdW = (BdListView) findViewById(e.g.home_lv_search_suggest);
        this.fdX = new com.baidu.tieba.mainentrance.a(this, null);
        this.fdY = new com.baidu.tieba.mainentrance.searchSuggestList.a(getPageContext().getPageActivity(), null);
        this.fdW.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.10
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ListAdapter adapter;
                ListView listView = (ListView) adapterView;
                if (listView != null && (adapter = listView.getAdapter()) != null && adapter.getCount() != 0 && i < adapter.getCount()) {
                    Object item = adapter.getItem(i);
                    if (item instanceof String) {
                        SquareSearchActivity.this.I((String) item, true);
                        TiebaStatic.eventStat(SquareSearchActivity.this.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
                    }
                }
            }
        });
        this.fdW.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.11
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), absListView);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    public void aVm() {
        this.fdP.setText(getPageContext().getString(e.j.cancel));
        aVn();
        aVh();
        aVr();
        if (this.dqC.trim().length() > 0) {
            aVq();
        } else {
            aVo();
        }
    }

    private void aVn() {
        if (this.mHotSearchInfo == null) {
            this.dby.setHint(e.j.search_bar);
        } else {
            this.dby.setHint(" " + UtilHelper.getFixedText(this.mHotSearchInfo.aqk(), 15));
        }
    }

    private void aVf() {
        HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
        if (hotSearchInfoData != null && hotSearchInfoData.getId() != 0) {
            this.mHotSearchInfo = hotSearchInfoData;
        }
    }

    private void aVo() {
        this.fdQ.setVisibility(8);
        this.fdW.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009002));
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            iY(true);
            bk(this.fef);
            bk(this.fee);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(ArrayList<String> arrayList) {
        NoDataViewFactory.d dE;
        if (af(arrayList)) {
            aVv();
            if (j.kK()) {
                dE = NoDataViewFactory.d.dE(e.j.text_no_search_record);
            } else {
                dE = NoDataViewFactory.d.dE(e.j.neterror);
            }
            this.mNoDataView.setTextOption(dE);
            return;
        }
        aVu();
        ae(arrayList);
        I(true, arrayList == null || arrayList.size() == 0);
        aVn();
    }

    private void ae(final ArrayList<String> arrayList) {
        if (this.fdV != null) {
            this.fdV.removeAllViews();
            if (arrayList != null && !arrayList.isEmpty() && getActivity() != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                this.feg = LayoutInflater.from(pageActivity).inflate(e.h.square_search_recommand_fourm_header, (ViewGroup) null);
                this.feg.findViewById(e.g.titleTopDivider).setVisibility(8);
                getLayoutMode().onModeChanged(this.feg);
                this.fdV.addView(this.feg, layoutParams);
                int size = arrayList.size();
                this.fei.clear();
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
                                        com.baidu.tieba.tbadkCore.util.a.uF(str);
                                        return true;
                                    }
                                }, new h<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.2
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.tbadk.util.h
                                    public void onReturnDataInUI(Boolean bool) {
                                        SquareSearchActivity.this.fdV.removeView(inflate);
                                        arrayList.remove(str);
                                        if (arrayList.size() <= 0) {
                                            SquareSearchActivity.this.ad(null);
                                        }
                                    }
                                });
                            }
                        });
                        this.fei.add(inflate);
                        this.fdV.addView(inflate, layoutParams2);
                    }
                }
                this.feh = LayoutInflater.from(pageActivity).inflate(e.h.home_dialog_search_footer, (ViewGroup) null);
                ((TextView) this.feh.findViewById(e.g.home_bt_search_footer)).setTextColor(al.getColor(e.d.cp_link_tip_a));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                this.feh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SquareSearchActivity.this.aVp();
                    }
                });
                this.fdV.addView(this.feh, layoutParams3);
            }
        }
    }

    private void I(boolean z, boolean z2) {
        if (this.fdU != null) {
            this.fdU.clear();
            if (this.fdT != null && !this.fdT.isEmpty() && z) {
                this.fdU.iX(!z2);
                this.fdU.setTitleText(this.mTopicInfoTitle);
                int size = this.fdT.size();
                if (size >= 1) {
                    if (size > 7) {
                        size = 7;
                    }
                    int i = size % 2 == 0 ? size - 1 : size;
                    for (int i2 = 0; i2 < i; i2++) {
                        c cVar = (c) v.d(this.fdT, i2);
                        if (cVar != null) {
                            this.fdU.a(cVar, i2).setOnClickListener(this.feq);
                        }
                    }
                    this.fdU.a(null, i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.16
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.dby);
                            if (!com.baidu.tbadk.plugins.b.e(SquareSearchActivity.this.getPageContext())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all")));
                            }
                        }
                    });
                    this.fdU.show();
                }
            }
        }
    }

    private boolean af(ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && (this.fdT == null || this.fdT.size() <= 2) && this.fec;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVp() {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).dT(getPageContext().getString(e.j.alert_clean_history)).a(getPageContext().getString(e.j.clear_all_text), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                com.baidu.adp.lib.g.h.ju().d(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.bzE();
                    }
                });
                if (SquareSearchActivity.this.fdT == null || SquareSearchActivity.this.fdT.size() < 2) {
                    SquareSearchActivity.this.bj(SquareSearchActivity.this.fee);
                    SquareSearchActivity.this.bj(SquareSearchActivity.this.fef);
                    SquareSearchActivity.this.fdO.setVisibility(8);
                    SquareSearchActivity.this.mNoDataView.setVisibility(0);
                    SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(e.j.text_no_search_record));
                    return;
                }
                SquareSearchActivity.this.ad(null);
            }
        }).b(getPageContext().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.17
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        }).b(getPageContext()).yl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVq() {
        if (this.dqC.trim().length() > 0) {
            aVs();
            return;
        }
        aVh();
        aVo();
    }

    private void aVr() {
        if (this.fdW != null) {
            this.fdW.setNextPage(null);
        }
    }

    private void aVs() {
        if (!StringUtils.isNull(this.dqC)) {
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.dqC.trim();
            sendMessage(searchListNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        try {
            if (this.fdZ != null) {
                if (this.fdZ.forum_list != null && this.fdZ.forum_list.size() > 0) {
                    aVt();
                    this.fdW.setAdapter((ListAdapter) this.fdX);
                    this.fdX.qh(this.dqC);
                    this.fdX.ac(this.fdZ.forum_list);
                    this.fdX.notifyDataSetInvalidated();
                } else {
                    bk(this.fee);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVt() {
        this.fdO.setVisibility(0);
        this.fdW.setVisibility(0);
        this.fdR.setVisibility(8);
        this.fdQ.setVisibility(8);
        bk(this.fee);
        this.mNoDataView.setVisibility(8);
    }

    private void aVu() {
        this.fdO.setVisibility(0);
        this.fdR.setVisibility(0);
        this.fdW.setVisibility(8);
        this.fdQ.setVisibility(8);
        bk(this.fee);
        this.mNoDataView.setVisibility(8);
    }

    private void aVv() {
        this.fdO.setVisibility(8);
        this.fdW.setVisibility(8);
        this.fdR.setVisibility(8);
        this.fdQ.setVisibility(8);
        bj(this.fee);
        this.mNoDataView.setVisibility(0);
        bj(this.fef);
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void qi(String str) {
        this.fec = true;
        this.fdT = new ArrayList();
        aVo();
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void a(List<com.baidu.tieba.mainentrance.b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str) {
        this.fec = true;
        hideLoadingView(this.fdN);
        if (list2 == null) {
            this.fdT = new ArrayList();
        } else {
            this.fdT = list2;
        }
        if (!StringUtils.isNULL(str)) {
            this.mTopicInfoTitle = str;
        } else {
            this.mTopicInfoTitle = "";
        }
        a(hotSearchInfoData);
        this.mHotSearchInfo = hotSearchInfoData;
        aVo();
    }

    private void a(HotSearchInfoData hotSearchInfoData) {
        if (hotSearchInfoData != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
            return;
        }
        HotSearchInfoData hotSearchInfoData2 = new HotSearchInfoData();
        hotSearchInfoData2.setId(0L);
        hotSearchInfoData2.setName("");
        hotSearchInfoData2.qj("");
        hotSearchInfoData2.cy(0L);
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
        getLayoutMode().onModeChanged(this.fdM);
        al.e(this.fdM, i);
        if (this.fdX != null) {
            this.fdX.notifyDataSetChanged();
        }
        if (i == 2) {
            this.dby.setHintTextColor(al.getColor(e.d.s_navbar_title_color));
        } else {
            this.dby.setHintTextColor(al.getColor(e.d.cp_cont_e));
        }
        al.c(this.dqM, e.f.del_search_btn);
        al.b(this.dby, e.d.cp_cont_b, e.d.s_navbar_title_color);
        al.a(this.bMT, e.f.icon_seach_n, e.f.icon_seach_n, e.f.icon_seach_n, i);
        al.i(this.fdN, e.d.cp_bg_line_d);
        al.c(this.fdP, e.d.cp_link_tip_a, 1);
        if (this.fdU != null) {
            this.fdU.onChangeSkinType(i);
        }
        pX(i);
    }

    private void pX(int i) {
        if (this.fdV != null) {
            this.fdV.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
        }
        if (this.feg != null) {
            getLayoutMode().onModeChanged(this.feg);
        }
        if (this.feh != null) {
            ((TextView) this.feh.findViewById(e.g.home_bt_search_footer)).setTextColor(al.getColor(e.d.cp_link_tip_a));
        }
        if (this.fei != null) {
            for (View view : this.fei) {
                al.c((TextView) view.findViewById(e.g.home_lv_search_forum), e.d.cp_cont_b, 1);
                view.findViewById(e.g.home_dialog_lv_search_forum_divider).setBackgroundColor(al.getColor(e.d.cp_bg_line_b));
                al.i(view, e.f.addresslist_item_bg);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (i == 4 && this.fdQ.canGoBack()) {
                this.fdQ.goBack();
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
            com.baidu.tbadk.core.e.b.j(getPageContext().getPageActivity(), 1);
        } else {
            com.baidu.tbadk.core.e.b.j(getPageContext().getPageActivity(), 2);
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
                SquareSearchActivity.this.dqC = this.mName;
                TiebaStatic.log(new am("c12034"));
                SquareSearchActivity.this.I(this.mName, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aVw() {
        if (!j.kK()) {
            bj(this.mNoDataView);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(e.j.neterror));
            return true;
        }
        bk(this.mNoDataView);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
        private BasicNameValuePair fey;
        private com.baidu.tbadk.core.util.x mNetwork = null;
        private String mUrl;

        public a(String str, BasicNameValuePair basicNameValuePair, boolean z) {
            this.mUrl = null;
            this.fey = null;
            this.mUrl = str;
            this.fey = basicNameValuePair;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!SquareSearchActivity.this.aVw()) {
                SquareSearchActivity.this.bk(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.fdN, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(e.C0141e.ds320));
                SquareSearchActivity.this.fdO.setVisibility(8);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public ForumSuggestModel doInBackground(Object... objArr) {
            ForumSuggestModel forumSuggestModel = null;
            if (j.kK()) {
                try {
                    this.mNetwork = new com.baidu.tbadk.core.util.x(this.mUrl);
                    this.mNetwork.a(this.fey);
                    String zt = this.mNetwork.zt();
                    if (zt != null) {
                        forumSuggestModel = ForumSuggestModel.parserJson(zt);
                        SquareSearchActivity.this.feb = this.fey.getValue();
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
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.fdN);
            if (forumSuggestModel != null) {
                SquareSearchActivity.this.bk(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.fdZ = forumSuggestModel;
                SquareSearchActivity.this.refresh();
            } else {
                SquareSearchActivity.this.bj(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(e.j.text_no_search_record));
            }
            SquareSearchActivity.this.fea = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.iT();
                this.mNetwork = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.fdN);
            super.cancel(true);
        }
    }

    private void iY(boolean z) {
        if (TbadkCoreApplication.isLogin()) {
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(2001323, true));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(2001323, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bj(View view) {
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bk(View view) {
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a026";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(final String str, boolean z) {
        if (!j.kK()) {
            showToast(e.j.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.fek = false;
                this.dby.setText(str);
                this.dby.setSelection(str.length());
                this.fek = true;
            }
            l.a(getPageContext().getPageActivity(), this.dby);
            this.fdR.setVisibility(8);
            this.fdW.setVisibility(8);
            this.fdQ.setVisibility(0);
            showProgressBarWithOffset(0, 0);
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, IoUtils.UTF_8);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            this.fdQ.loadUrl(str2);
            x.a(new w<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.w
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.uD(str);
                    return true;
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qk(String str) {
        if (!j.kK()) {
            showToast(e.j.neterror);
        } else if (!StringUtils.isNull(str)) {
            this.fel = str;
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BIND_WIDGET)));
            } else {
                sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), str)));
            }
        }
    }
}
