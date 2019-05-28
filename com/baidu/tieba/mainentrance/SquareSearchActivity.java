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
    private ImageView dAy;
    private EditText eXX;
    private ImageView eqA;
    private TextView eqB;
    private String fmZ;
    private LinearLayoutDetectsSoftKeyboard heF;
    private FrameLayout heG;
    private FrameLayout heH;
    private BaseWebView heI;
    private ScrollView heJ;
    private LinearLayout heK;
    private List<c> heL;
    private g heM;
    private LinearLayout heN;
    private BdListView heO;
    private com.baidu.tieba.mainentrance.a heP;
    private com.baidu.tieba.mainentrance.searchSuggestList.b heQ;
    private ForumSuggestModel heR;
    private a heS;
    private String heT;
    private boolean heU;
    private ScrollView heW;
    private SearchPageFocusBar heX;
    private View heY;
    private View heZ;
    private HotForumModel heu;
    private String hfd;
    private HotSearchInfoData mHotSearchInfo;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mTopicInfoTitle;
    private boolean heV = true;
    private List<View> hfa = new ArrayList();
    private boolean hes = false;
    private boolean hfb = true;
    private boolean hfc = true;
    private Runnable hfe = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.1
        @Override // java.lang.Runnable
        public void run() {
            SquareSearchActivity.this.eXX.requestFocus();
            l.c(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.eXX);
        }
    };
    private final Runnable hff = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.12
        @Override // java.lang.Runnable
        public void run() {
            if (!SquareSearchActivity.this.bJy()) {
                try {
                    if (SquareSearchActivity.this.fmZ != null && SquareSearchActivity.this.fmZ.length() > 0) {
                        StringBuffer stringBuffer = new StringBuffer(30);
                        stringBuffer.append(TbConfig.SERVER_ADDRESS);
                        stringBuffer.append("c/f/forum/search");
                        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", SquareSearchActivity.this.fmZ.trim());
                        SquareSearchActivity.this.bJj();
                        SquareSearchActivity.this.heS = new a(stringBuffer.toString(), basicNameValuePair, true);
                        SquareSearchActivity.this.heS.setPriority(3);
                        SquareSearchActivity.this.heS.execute(stringBuffer.toString(), basicNameValuePair);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a hfg = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SEARCH_LIST, 309438) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.22
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = ((responsedMessage instanceof SearchListHttpResMessage) || (responsedMessage instanceof SearchListSocketResMessage)) ? false : true;
            if (responsedMessage == null || z || responsedMessage.getError() != 0 || responsedMessage.hasError()) {
                if (j.jS() || !SquareSearchActivity.this.hes) {
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(R.string.neterror));
                }
                if (!j.jS()) {
                    SquareSearchActivity.this.hes = true;
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
            if (SquareSearchActivity.this.hfb && responsedMessage.getError() != 0) {
                SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(R.string.neterror));
                return;
            }
            if (list != null && list.size() > 0) {
                SquareSearchActivity.this.hfb = false;
            }
            SquareSearchActivity.this.bJv();
            SquareSearchActivity.this.heO.setAdapter((ListAdapter) SquareSearchActivity.this.heQ);
            SquareSearchActivity.this.heQ.zx(SquareSearchActivity.this.fmZ.trim());
            SquareSearchActivity.this.heQ.setData(list);
            SquareSearchActivity.this.heQ.notifyDataSetInvalidated();
        }
    };
    private CustomMessageListener hex = new CustomMessageListener(2001608) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                SquareSearchActivity.this.zA(customResponsedMessage.getData().toString());
            }
        }
    };
    private CustomMessageListener hfh = new CustomMessageListener(2009002) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof ArrayList) {
                    SquareSearchActivity.this.ak((ArrayList) data);
                }
            }
        }
    };
    private View.OnClickListener hfi = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.eXX);
            if (view.getTag() instanceof c) {
                c cVar = (c) view.getTag();
                TiebaStatic.log(new am("c10363").bT("obj_name", cVar.getName()));
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
                if (SquareSearchActivity.this.heI.getUrl() != null && SquareSearchActivity.this.heI.getUrl().contains(str)) {
                    SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.heG);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bJi() {
        if (this.mHotSearchInfo == null) {
            return false;
        }
        if (this.mHotSearchInfo.bJg() == 0) {
            am(this.mHotSearchInfo.getName(), false);
        } else if (this.mHotSearchInfo.bJg() == 1 && !com.baidu.tbadk.plugins.b.f(getPageContext())) {
            sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new am("c10355").bT("obj_name", this.mHotSearchInfo.getName()).P("obj_type", this.mHotSearchInfo.bJg() == 0 ? 2 : 1));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.home_dialog_search);
        init();
        getWindow().setSoftInputMode(1);
        registerListener(this.hfh);
        registerListener(this.hfg);
        registerListener(this.hex);
        registerListener(this.htmlLoadMessageListener);
        if (SquareSearchActivityConfig.IS_SHOW_RECOMMEND_FORUM) {
            this.heu = new HotForumModel(getPageContext(), this);
            this.heu.bJe();
        }
        this.heU = false;
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
        hideLoadingView(this.heG);
        this.mHandler.removeCallbacks(this.hfe);
        bJj();
    }

    public void bJj() {
        this.mHandler.removeCallbacks(this.hff);
        if (this.heS != null) {
            this.heS.cancel();
            this.heS = null;
        }
    }

    private void init() {
        this.heF = (LinearLayoutDetectsSoftKeyboard) findViewById(R.id.parent);
        this.heF.setOnSoftKeyBoardShownListener(new LinearLayoutDetectsSoftKeyboard.a() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.24
            @Override // com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard.a
            public void mX(boolean z) {
                SquareSearchActivity.this.heV = z;
            }
        });
        this.heF.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.25
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    SquareSearchActivity.this.heF.setFocusable(true);
                    SquareSearchActivity.this.heF.setFocusableInTouchMode(true);
                    if (SquareSearchActivity.this.eXX.hasFocus()) {
                        l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.eXX);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        aHR();
        this.heG = (FrameLayout) findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), null, null);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            this.heW = (ScrollView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.home_searchbar_nodataview, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) this.heW.findViewById(R.id.focusbar_nodata_root);
            this.heX = (SearchPageFocusBar) linearLayout.findViewById(R.id.no_data_focusbar);
            linearLayout.addView(this.mNoDataView, 0);
            this.heW.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.26
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.heW);
                    return false;
                }
            });
            this.heG.addView(this.heW, this.heG.getChildCount());
        } else {
            this.heG.addView(this.mNoDataView, 0);
        }
        this.heH = (FrameLayout) findViewById(R.id.home_search_list);
        bJh();
        bJl();
        bJm();
        bJn();
        this.heI = (BaseWebView) findViewById(R.id.search_result_webview);
        this.heI.initCommonJsBridge(getPageContext().getPageActivity());
        this.heI.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.27
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
                if (SquareSearchActivity.this.isProgressBarShown()) {
                    SquareSearchActivity.this.hideProgressBar();
                }
            }
        });
        this.heI.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.28
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedError", 0, "", "requesturl", str2, "receiveerror", Integer.valueOf(i), "description", str);
            }
        });
        this.heI.setOnReceivedSslErrorListener(new BaseWebView.g() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.g
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                if (sslError != null) {
                    com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedSslError", 0, "", "requesturl", sslError.getUrl(), "receiveerror", sslError.toString());
                }
            }
        });
        this.heI.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.3
            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.mainentrance.SquareSearchActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return ba.aiz().b(SquareSearchActivity.this.getPageContext(), new String[]{str}) != 3;
            }
        });
        this.eXX.setText("");
        this.eXX.requestFocus();
        ShowSoftKeyPadDelay(this.eXX, 200);
        bJo();
        bJp();
    }

    private void aHR() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.dAy = (ImageView) addCustomView.findViewById(R.id.search_bar_icon);
        this.eXX = (EditText) addCustomView.findViewById(R.id.home_et_search);
        this.eqA = (ImageView) addCustomView.findViewById(R.id.home_bt_search_del);
        this.eqB = (TextView) addCustomView.findViewById(R.id.home_bt_search_cancel_s);
        this.eXX.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    SquareSearchActivity.this.bJk();
                } else {
                    l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.eXX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.bJk();
            }
        });
        this.eqB.setText(getPageContext().getString(R.string.cancel));
        this.eqB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.eXX);
                com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SquareSearchActivity.this.finish();
                    }
                }, 200L);
            }
        });
        this.eXX.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.7
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (SquareSearchActivity.this.fmZ == null || SquareSearchActivity.this.fmZ.trim().length() < 1) {
                        l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.eXX);
                        if (SquareSearchActivity.this.bJi()) {
                            return true;
                        }
                        SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(R.string.write_keyword));
                        return true;
                    }
                    String trim = SquareSearchActivity.this.eXX.getText().toString().trim();
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
        this.eqA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.eXX.setText("");
            }
        });
        this.eXX.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.9
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SquareSearchActivity.this.hfc) {
                    SquareSearchActivity.this.fmZ = editable.toString();
                    if (StringUtils.isNull(SquareSearchActivity.this.fmZ)) {
                        SquareSearchActivity.this.hfb = true;
                    }
                    SquareSearchActivity.this.bJs();
                }
                if (editable.toString().trim().length() == 0) {
                    SquareSearchActivity.this.eqA.setVisibility(8);
                } else {
                    SquareSearchActivity.this.eqA.setVisibility(0);
                }
                al.f(SquareSearchActivity.this.eqB, R.color.cp_link_tip_a, 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJk() {
        if (StringUtils.isNull(this.eXX.getText().toString())) {
            if (this.heJ.getVisibility() != 0) {
                bJq();
            }
        } else if (this.heO.getVisibility() != 0) {
            bJs();
        }
    }

    private void bJl() {
        this.heJ = (ScrollView) findViewById(R.id.search_history_scrollview);
        this.heK = (LinearLayout) findViewById(R.id.search_history_linearlayout);
        if (this.heN == null) {
            this.heN = new LinearLayout(getPageContext().getPageActivity());
            this.heN.setOrientation(1);
            this.heN.setBackgroundColor(al.getColor(R.color.cp_bg_line_d));
        }
        this.heK.addView(this.heN);
    }

    private void bJm() {
        if (this.heM == null) {
            this.heM = new g(getPageContext());
            this.heK.addView(this.heM.nG());
        }
    }

    private void bJn() {
        this.heO = (BdListView) findViewById(R.id.home_lv_search_suggest);
        this.heP = new com.baidu.tieba.mainentrance.a(this, null);
        this.heQ = new com.baidu.tieba.mainentrance.searchSuggestList.b(getPageContext().getPageActivity(), null);
        this.heO.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.10
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
        this.heO.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.11
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

    public void bJo() {
        this.eqB.setText(getPageContext().getString(R.string.cancel));
        bJp();
        bJj();
        bJt();
        if (this.fmZ.trim().length() > 0) {
            bJs();
        } else {
            bJq();
        }
    }

    private void bJp() {
        if (this.mHotSearchInfo == null) {
            this.eXX.setHint(R.string.search_bar);
        } else {
            this.eXX.setHint(" " + UtilHelper.getFixedText(this.mHotSearchInfo.bdl(), 15));
        }
    }

    private void bJh() {
        HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.agM().getString("hot_search_info", ""), HotSearchInfoData.class);
        if (hotSearchInfoData != null && hotSearchInfoData.getId() != 0) {
            this.mHotSearchInfo = hotSearchInfoData;
        }
    }

    private void bJq() {
        this.heI.setVisibility(8);
        this.heO.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009002));
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            mW(true);
            cm(this.heX);
            cm(this.heW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(ArrayList<String> arrayList) {
        NoDataViewFactory.d iH;
        if (am(arrayList)) {
            bJx();
            if (j.jS()) {
                iH = NoDataViewFactory.d.iH(R.string.text_no_search_record);
            } else {
                iH = NoDataViewFactory.d.iH(R.string.neterror);
            }
            this.mNoDataView.setTextOption(iH);
            return;
        }
        bJw();
        al(arrayList);
        R(true, arrayList == null || arrayList.size() == 0);
        bJp();
    }

    private void al(final ArrayList<String> arrayList) {
        if (this.heN != null) {
            this.heN.removeAllViews();
            if (arrayList != null && !arrayList.isEmpty() && getActivity() != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                this.heY = LayoutInflater.from(pageActivity).inflate(R.layout.square_search_recommand_fourm_header, (ViewGroup) null);
                this.heY.findViewById(R.id.titleTopDivider).setVisibility(8);
                getLayoutMode().onModeChanged(this.heY);
                this.heN.addView(this.heY, layoutParams);
                int size = arrayList.size();
                this.hfa.clear();
                for (int i = 0; i < size; i++) {
                    final String str = arrayList.get(i);
                    if (!TextUtils.isEmpty(str)) {
                        final View inflate = LayoutInflater.from(pageActivity).inflate(R.layout.home_dialog_search_item, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.home_lv_search_forum)).setText(str);
                        al.f((TextView) inflate.findViewById(R.id.home_lv_search_forum), R.color.cp_cont_b, 1);
                        inflate.findViewById(R.id.home_dialog_lv_search_forum_divider).setVisibility(8);
                        al.k(inflate, R.drawable.square_search_item_bg);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        inflate.setOnClickListener(new b(str));
                        ImageView imageView = (ImageView) inflate.findViewById(R.id.del_search_history_btn);
                        al.c(imageView, (int) R.drawable.icn_shop_order_close);
                        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                aa.a(new z<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // com.baidu.tbadk.util.z
                                    public Boolean doInBackground() {
                                        com.baidu.tieba.tbadkCore.util.a.Ee(str);
                                        return true;
                                    }
                                }, new k<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.2
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.tbadk.util.k
                                    public void onReturnDataInUI(Boolean bool) {
                                        SquareSearchActivity.this.heN.removeView(inflate);
                                        arrayList.remove(str);
                                        if (arrayList.size() <= 0) {
                                            SquareSearchActivity.this.ak(null);
                                        }
                                    }
                                });
                            }
                        });
                        this.hfa.add(inflate);
                        this.heN.addView(inflate, layoutParams2);
                    }
                }
                this.heZ = LayoutInflater.from(pageActivity).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
                ((TextView) this.heZ.findViewById(R.id.home_bt_search_footer)).setTextColor(al.getColor(R.color.cp_link_tip_a));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                this.heZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SquareSearchActivity.this.bJr();
                    }
                });
                this.heN.addView(this.heZ, layoutParams3);
            }
        }
    }

    private void R(boolean z, boolean z2) {
        if (this.heM != null) {
            this.heM.clear();
            if (this.heL != null && !this.heL.isEmpty() && z) {
                this.heM.mV(!z2);
                this.heM.setTitleText(this.mTopicInfoTitle);
                int size = this.heL.size();
                if (size >= 1) {
                    if (size > 7) {
                        size = 7;
                    }
                    int i = size % 2 == 0 ? size - 1 : size;
                    for (int i2 = 0; i2 < i; i2++) {
                        c cVar = (c) v.c(this.heL, i2);
                        if (cVar != null) {
                            this.heM.a(cVar, i2).setOnClickListener(this.hfi);
                        }
                    }
                    this.heM.a(null, i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.16
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.eXX);
                            if (!com.baidu.tbadk.plugins.b.f(SquareSearchActivity.this.getPageContext())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all")));
                            }
                        }
                    });
                    this.heM.show();
                }
            }
        }
    }

    private boolean am(ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && (this.heL == null || this.heL.size() <= 2) && this.heU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJr() {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).mE(getPageContext().getString(R.string.alert_clean_history)).a(getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                h.iC().d(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.cnn();
                    }
                });
                if (SquareSearchActivity.this.heL == null || SquareSearchActivity.this.heL.size() < 2) {
                    SquareSearchActivity.this.cl(SquareSearchActivity.this.heW);
                    SquareSearchActivity.this.cl(SquareSearchActivity.this.heX);
                    SquareSearchActivity.this.heH.setVisibility(8);
                    SquareSearchActivity.this.mNoDataView.setVisibility(0);
                    SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(R.string.text_no_search_record));
                    return;
                }
                SquareSearchActivity.this.ak(null);
            }
        }).b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.17
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        }).b(getPageContext()).afG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJs() {
        if (this.fmZ.trim().length() > 0) {
            bJu();
            return;
        }
        bJj();
        bJq();
    }

    private void bJt() {
        if (this.heO != null) {
            this.heO.setNextPage(null);
        }
    }

    private void bJu() {
        if (!StringUtils.isNull(this.fmZ)) {
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.fmZ.trim();
            sendMessage(searchListNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        try {
            if (this.heR != null) {
                if (this.heR.forum_list != null && this.heR.forum_list.size() > 0) {
                    bJv();
                    this.heO.setAdapter((ListAdapter) this.heP);
                    this.heP.zx(this.fmZ);
                    this.heP.aj(this.heR.forum_list);
                    this.heP.notifyDataSetInvalidated();
                } else {
                    cm(this.heW);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJv() {
        this.heH.setVisibility(0);
        this.heO.setVisibility(0);
        this.heJ.setVisibility(8);
        this.heI.setVisibility(8);
        cm(this.heW);
        this.mNoDataView.setVisibility(8);
    }

    private void bJw() {
        this.heH.setVisibility(0);
        this.heJ.setVisibility(0);
        this.heO.setVisibility(8);
        this.heI.setVisibility(8);
        cm(this.heW);
        this.mNoDataView.setVisibility(8);
    }

    private void bJx() {
        this.heH.setVisibility(8);
        this.heO.setVisibility(8);
        this.heJ.setVisibility(8);
        this.heI.setVisibility(8);
        cl(this.heW);
        this.mNoDataView.setVisibility(0);
        cl(this.heX);
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void zy(String str) {
        this.heU = true;
        this.heL = new ArrayList();
        bJq();
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void a(List<com.baidu.tieba.mainentrance.b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str) {
        this.heU = true;
        hideLoadingView(this.heG);
        if (list2 == null) {
            this.heL = new ArrayList();
        } else {
            this.heL = list2;
        }
        if (!StringUtils.isNULL(str)) {
            this.mTopicInfoTitle = str;
        } else {
            this.mTopicInfoTitle = "";
        }
        a(hotSearchInfoData);
        this.mHotSearchInfo = hotSearchInfoData;
        bJq();
    }

    private void a(HotSearchInfoData hotSearchInfoData) {
        if (hotSearchInfoData != null) {
            com.baidu.tbadk.core.sharedPref.b.agM().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
            return;
        }
        HotSearchInfoData hotSearchInfoData2 = new HotSearchInfoData();
        hotSearchInfoData2.setId(0L);
        hotSearchInfoData2.setName("");
        hotSearchInfoData2.zz("");
        hotSearchInfoData2.dO(0L);
        com.baidu.tbadk.core.sharedPref.b.agM().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData2));
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
        getLayoutMode().onModeChanged(this.heF);
        al.g(this.heF, i);
        if (this.heP != null) {
            this.heP.notifyDataSetChanged();
        }
        if (i == 2) {
            this.eXX.setHintTextColor(al.getColor(R.color.s_navbar_title_color));
        } else {
            this.eXX.setHintTextColor(al.getColor(R.color.cp_cont_e));
        }
        al.c(this.eqA, (int) R.drawable.del_search_btn);
        al.e(this.eXX, R.color.cp_cont_b, R.color.s_navbar_title_color);
        al.a(this.dAy, (int) R.drawable.icon_seach_n, (int) R.drawable.icon_seach_n, (int) R.drawable.icon_seach_n, i);
        al.k(this.heG, R.color.cp_bg_line_d);
        al.f(this.eqB, R.color.cp_link_tip_a, 1);
        if (this.heM != null) {
            this.heM.onChangeSkinType(i);
        }
        wj(i);
    }

    private void wj(int i) {
        if (this.heN != null) {
            this.heN.setBackgroundColor(al.getColor(R.color.cp_bg_line_d));
        }
        if (this.heY != null) {
            getLayoutMode().onModeChanged(this.heY);
        }
        if (this.heZ != null) {
            ((TextView) this.heZ.findViewById(R.id.home_bt_search_footer)).setTextColor(al.getColor(R.color.cp_link_tip_a));
        }
        if (this.hfa != null) {
            for (View view : this.hfa) {
                al.f((TextView) view.findViewById(R.id.home_lv_search_forum), R.color.cp_cont_b, 1);
                view.findViewById(R.id.home_dialog_lv_search_forum_divider).setBackgroundColor(al.getColor(R.color.cp_bg_line_b));
                al.k(view, R.drawable.addresslist_item_bg);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (i == 4 && this.heI.canGoBack()) {
                this.heI.goBack();
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
                SquareSearchActivity.this.fmZ = this.mName;
                TiebaStatic.log(new am("c12034"));
                SquareSearchActivity.this.am(this.mName, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bJy() {
        if (!j.jS()) {
            cl(this.mNoDataView);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(R.string.neterror));
            return true;
        }
        cm(this.mNoDataView);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
        private BasicNameValuePair hfq;
        private x mNetwork = null;
        private String mUrl;

        public a(String str, BasicNameValuePair basicNameValuePair, boolean z) {
            this.mUrl = null;
            this.hfq = null;
            this.mUrl = str;
            this.hfq = basicNameValuePair;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!SquareSearchActivity.this.bJy()) {
                SquareSearchActivity.this.cm(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.heG, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(R.dimen.ds320));
                SquareSearchActivity.this.heH.setVisibility(8);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public ForumSuggestModel doInBackground(Object... objArr) {
            ForumSuggestModel forumSuggestModel = null;
            if (j.jS()) {
                try {
                    this.mNetwork = new x(this.mUrl);
                    this.mNetwork.a(this.hfq);
                    String ahe = this.mNetwork.ahe();
                    if (ahe != null) {
                        forumSuggestModel = ForumSuggestModel.parserJson(ahe);
                        SquareSearchActivity.this.heT = this.hfq.getValue();
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
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.heG);
            if (forumSuggestModel != null) {
                SquareSearchActivity.this.cm(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.heR = forumSuggestModel;
                SquareSearchActivity.this.refresh();
            } else {
                SquareSearchActivity.this.cl(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(R.string.text_no_search_record));
            }
            SquareSearchActivity.this.heS = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.ia();
                this.mNetwork = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.heG);
            super.cancel(true);
        }
    }

    private void mW(boolean z) {
        if (TbadkCoreApplication.isLogin()) {
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(2001323, true));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(2001323, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cl(View view) {
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cm(View view) {
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a026";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(final String str, boolean z) {
        if (!j.jS()) {
            showToast(R.string.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.hfc = false;
                this.eXX.setText(str);
                this.eXX.setSelection(str.length());
                this.hfc = true;
            }
            l.b(getPageContext().getPageActivity(), this.eXX);
            this.heJ.setVisibility(8);
            this.heO.setVisibility(8);
            this.heI.setVisibility(0);
            showProgressBarWithOffset(0, 0);
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            this.heI.loadUrl(str2);
            aa.a(new z<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.z
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.Ec(str);
                    return true;
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zA(String str) {
        if (!j.jS()) {
            showToast(R.string.neterror);
        } else if (!StringUtils.isNull(str)) {
            this.hfd = str;
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BIND_WIDGET)));
            } else {
                sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), str)));
            }
        }
    }
}
