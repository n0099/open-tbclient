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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
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
    private ImageView clt;
    private String dCP;
    private ImageView dCZ;
    private EditText drQ;
    private LinearLayout fhA;
    private BdListView fhB;
    private com.baidu.tieba.mainentrance.a fhC;
    private com.baidu.tieba.mainentrance.searchSuggestList.a fhD;
    private ForumSuggestModel fhE;
    private a fhF;
    private String fhG;
    private boolean fhH;
    private ScrollView fhJ;
    private SearchPageFocusBar fhK;
    private View fhL;
    private View fhM;
    private String fhQ;
    private HotForumModel fhe;
    private LinearLayoutDetectsSoftKeyboard fhr;
    private FrameLayout fhs;
    private FrameLayout fht;
    private TextView fhu;
    private BaseWebView fhv;
    private ScrollView fhw;
    private LinearLayout fhx;
    private List<c> fhy;
    private g fhz;
    private HotSearchInfoData mHotSearchInfo;
    private NavigationBar mNavigationBar;
    private h mNoDataView;
    private String mTopicInfoTitle;
    private boolean fhI = true;
    private List<View> fhN = new ArrayList();
    private boolean fhf = false;
    private boolean fhO = true;
    private boolean fhP = true;
    private Runnable fhR = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.1
        @Override // java.lang.Runnable
        public void run() {
            SquareSearchActivity.this.drQ.requestFocus();
            l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.drQ);
        }
    };
    private final Runnable fhS = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.12
        @Override // java.lang.Runnable
        public void run() {
            if (!SquareSearchActivity.this.aRK()) {
                try {
                    if (SquareSearchActivity.this.dCP != null && SquareSearchActivity.this.dCP.length() > 0) {
                        StringBuffer stringBuffer = new StringBuffer(30);
                        stringBuffer.append(TbConfig.SERVER_ADDRESS);
                        stringBuffer.append("c/f/forum/search");
                        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", SquareSearchActivity.this.dCP.trim());
                        SquareSearchActivity.this.aRv();
                        SquareSearchActivity.this.fhF = new a(stringBuffer.toString(), basicNameValuePair, true);
                        SquareSearchActivity.this.fhF.setPriority(3);
                        SquareSearchActivity.this.fhF.execute(stringBuffer.toString(), basicNameValuePair);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a fhT = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SEARCH_LIST, 309438) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.22
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = ((responsedMessage instanceof SearchListHttpResMessage) || (responsedMessage instanceof SearchListSocketResMessage)) ? false : true;
            if (responsedMessage == null || z || responsedMessage.getError() != 0 || responsedMessage.hasError()) {
                if (j.oJ() || !SquareSearchActivity.this.fhf) {
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(d.j.neterror));
                }
                if (!j.oJ()) {
                    SquareSearchActivity.this.fhf = true;
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
            if (SquareSearchActivity.this.fhO && responsedMessage.getError() != 0) {
                SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(d.j.neterror));
                return;
            }
            if (list != null && list.size() > 0) {
                SquareSearchActivity.this.fhO = false;
            }
            SquareSearchActivity.this.aRH();
            SquareSearchActivity.this.fhB.setAdapter((ListAdapter) SquareSearchActivity.this.fhD);
            SquareSearchActivity.this.fhD.oC(SquareSearchActivity.this.dCP.trim());
            SquareSearchActivity.this.fhD.setData(list);
            SquareSearchActivity.this.fhD.notifyDataSetInvalidated();
        }
    };
    private CustomMessageListener fhi = new CustomMessageListener(2001608) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                SquareSearchActivity.this.oF(customResponsedMessage.getData().toString());
            }
        }
    };
    private CustomMessageListener fhU = new CustomMessageListener(2009002) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof ArrayList) {
                    SquareSearchActivity.this.Y((ArrayList) data);
                }
            }
        }
    };
    private View.OnClickListener fhV = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.drQ);
            if (view.getTag() instanceof c) {
                c cVar = (c) view.getTag();
                TiebaStatic.log(new ak("c10363").ab("obj_name", cVar.getName()));
                if (!com.baidu.tbadk.plugins.a.e(SquareSearchActivity.this.getPageContext())) {
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
                if (SquareSearchActivity.this.fhv.getUrl() != null && SquareSearchActivity.this.fhv.getUrl().contains(str)) {
                    SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.fhs);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aRu() {
        if (this.mHotSearchInfo == null) {
            return false;
        }
        if (this.mHotSearchInfo.aRs() == 0) {
            L(this.mHotSearchInfo.getName(), false);
        } else if (this.mHotSearchInfo.aRs() == 1 && !com.baidu.tbadk.plugins.a.e(getPageContext())) {
            sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "")));
        }
        TiebaStatic.log(new ak("c10355").ab("obj_name", this.mHotSearchInfo.getName()).s("obj_type", this.mHotSearchInfo.aRs() == 0 ? 2 : 1));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.home_dialog_search);
        init();
        getWindow().setSoftInputMode(1);
        registerListener(this.fhU);
        registerListener(this.fhT);
        registerListener(this.fhi);
        registerListener(this.htmlLoadMessageListener);
        if (SquareSearchActivityConfig.IS_SHOW_RECOMMEND_FORUM) {
            this.fhe = new HotForumModel(getPageContext(), this);
            this.fhe.aRq();
        }
        this.fhH = false;
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
        hideLoadingView(this.fhs);
        this.mHandler.removeCallbacks(this.fhR);
        aRv();
    }

    public void aRv() {
        this.mHandler.removeCallbacks(this.fhS);
        if (this.fhF != null) {
            this.fhF.cancel();
            this.fhF = null;
        }
    }

    private void init() {
        this.fhr = (LinearLayoutDetectsSoftKeyboard) findViewById(d.g.parent);
        this.fhr.setOnSoftKeyBoardShownListener(new LinearLayoutDetectsSoftKeyboard.a() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.24
            @Override // com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard.a
            public void iE(boolean z) {
                SquareSearchActivity.this.fhI = z;
            }
        });
        this.fhr.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.25
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    SquareSearchActivity.this.fhr.setFocusable(true);
                    SquareSearchActivity.this.fhr.setFocusableInTouchMode(true);
                    if (SquareSearchActivity.this.drQ.hasFocus()) {
                        l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.drQ);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        awM();
        this.fhs = (FrameLayout) findViewById(d.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds200)), null, null);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            this.fhJ = (ScrollView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.h.home_searchbar_nodataview, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) this.fhJ.findViewById(d.g.focusbar_nodata_root);
            this.fhK = (SearchPageFocusBar) linearLayout.findViewById(d.g.no_data_focusbar);
            linearLayout.addView(this.mNoDataView, 0);
            this.fhJ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.26
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.fhJ);
                    return false;
                }
            });
            this.fhs.addView(this.fhJ, this.fhs.getChildCount());
        } else {
            this.fhs.addView(this.mNoDataView, 0);
        }
        this.fht = (FrameLayout) findViewById(d.g.home_search_list);
        aRt();
        aRx();
        aRy();
        aRz();
        this.fhv = (BaseWebView) findViewById(d.g.search_result_webview);
        this.fhv.initCommonJsBridge(getPageContext().getPageActivity());
        this.fhv.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.27
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
                if (SquareSearchActivity.this.isProgressBarShown()) {
                    SquareSearchActivity.this.hideProgressBar();
                }
            }
        });
        this.fhv.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.28
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedError", 0, "", "requesturl", str2, "receiveerror", Integer.valueOf(i), "description", str);
            }
        });
        this.fhv.setOnReceivedSslErrorListener(new BaseWebView.g() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.g
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                if (sslError != null) {
                    com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedSslError", 0, "", "requesturl", sslError.getUrl(), "receiveerror", sslError.toString());
                }
            }
        });
        this.fhv.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.3
            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.mainentrance.SquareSearchActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return aw.Dt().b(SquareSearchActivity.this.getPageContext(), new String[]{str}) != 3;
            }
        });
        this.drQ.setText("");
        this.drQ.requestFocus();
        ShowSoftKeyPadDelay(this.drQ, 200);
        aRA();
        aRB();
    }

    private void awM() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.h.square_search_navigation_view, (View.OnClickListener) null);
        this.clt = (ImageView) addCustomView.findViewById(d.g.search_bar_icon);
        this.drQ = (EditText) addCustomView.findViewById(d.g.home_et_search);
        this.dCZ = (ImageView) addCustomView.findViewById(d.g.home_bt_search_del);
        this.fhu = (TextView) addCustomView.findViewById(d.g.home_bt_search_cancel_s);
        this.drQ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    SquareSearchActivity.this.aRw();
                } else {
                    l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.drQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.aRw();
            }
        });
        this.fhu.setText(getPageContext().getString(d.j.cancel));
        this.fhu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.drQ);
                com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SquareSearchActivity.this.finish();
                    }
                }, 200L);
            }
        });
        this.drQ.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.7
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (SquareSearchActivity.this.dCP == null || SquareSearchActivity.this.dCP.trim().length() < 1) {
                        l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.drQ);
                        if (SquareSearchActivity.this.aRu()) {
                            return true;
                        }
                        SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(d.j.write_keyword));
                        return true;
                    }
                    String trim = SquareSearchActivity.this.drQ.getText().toString().trim();
                    if (!StringUtils.isNull(trim)) {
                        SquareSearchActivity.this.L(trim, false);
                        return true;
                    }
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(d.j.write_keyword));
                    return true;
                }
                return false;
            }
        });
        this.dCZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.drQ.setText("");
            }
        });
        this.drQ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.9
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SquareSearchActivity.this.fhP) {
                    SquareSearchActivity.this.dCP = editable.toString();
                    if (StringUtils.isNull(SquareSearchActivity.this.dCP)) {
                        SquareSearchActivity.this.fhO = true;
                    }
                    SquareSearchActivity.this.aRE();
                }
                if (editable.toString().trim().length() == 0) {
                    SquareSearchActivity.this.dCZ.setVisibility(8);
                } else {
                    SquareSearchActivity.this.dCZ.setVisibility(0);
                }
                aj.e(SquareSearchActivity.this.fhu, d.C0141d.cp_link_tip_a, 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRw() {
        if (StringUtils.isNull(this.drQ.getText().toString())) {
            if (this.fhw.getVisibility() != 0) {
                aRC();
            }
        } else if (this.fhB.getVisibility() != 0) {
            aRE();
        }
    }

    private void aRx() {
        this.fhw = (ScrollView) findViewById(d.g.search_history_scrollview);
        this.fhx = (LinearLayout) findViewById(d.g.search_history_linearlayout);
        if (this.fhA == null) {
            this.fhA = new LinearLayout(getPageContext().getPageActivity());
            this.fhA.setOrientation(1);
            this.fhA.setBackgroundColor(aj.getColor(d.C0141d.cp_bg_line_d));
        }
        this.fhx.addView(this.fhA);
    }

    private void aRy() {
        if (this.fhz == null) {
            this.fhz = new g(getPageContext());
            this.fhx.addView(this.fhz.st());
        }
    }

    private void aRz() {
        this.fhB = (BdListView) findViewById(d.g.home_lv_search_suggest);
        this.fhC = new com.baidu.tieba.mainentrance.a(this, null);
        this.fhD = new com.baidu.tieba.mainentrance.searchSuggestList.a(getPageContext().getPageActivity(), null);
        this.fhB.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.10
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ListAdapter adapter;
                ListView listView = (ListView) adapterView;
                if (listView != null && (adapter = listView.getAdapter()) != null && adapter.getCount() != 0 && i < adapter.getCount()) {
                    Object item = adapter.getItem(i);
                    if (item instanceof String) {
                        SquareSearchActivity.this.L((String) item, true);
                        TiebaStatic.eventStat(SquareSearchActivity.this.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
                    }
                }
            }
        });
        this.fhB.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.11
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

    public void aRA() {
        this.fhu.setText(getPageContext().getString(d.j.cancel));
        aRB();
        aRv();
        aRF();
        if (this.dCP.trim().length() > 0) {
            aRE();
        } else {
            aRC();
        }
    }

    private void aRB() {
        if (this.mHotSearchInfo == null) {
            this.drQ.setHint(d.j.search_bar);
        } else {
            this.drQ.setHint(" " + UtilHelper.getFixedText(this.mHotSearchInfo.aqm(), 15));
        }
    }

    private void aRt() {
        HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
        if (hotSearchInfoData != null && hotSearchInfoData.getId() != 0) {
            this.mHotSearchInfo = hotSearchInfoData;
        }
    }

    private void aRC() {
        this.fhv.setVisibility(8);
        this.fhB.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009002));
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            iD(true);
            cj(this.fhK);
            cj(this.fhJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(ArrayList<String> arrayList) {
        NoDataViewFactory.d gp;
        if (aa(arrayList)) {
            aRJ();
            if (j.oJ()) {
                gp = NoDataViewFactory.d.gp(d.j.text_no_search_record);
            } else {
                gp = NoDataViewFactory.d.gp(d.j.neterror);
            }
            this.mNoDataView.setTextOption(gp);
            return;
        }
        aRI();
        Z(arrayList);
        I(true, arrayList == null || arrayList.size() == 0);
        aRB();
    }

    private void Z(final ArrayList<String> arrayList) {
        if (this.fhA != null) {
            this.fhA.removeAllViews();
            if (arrayList != null && !arrayList.isEmpty() && getActivity() != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                this.fhL = LayoutInflater.from(pageActivity).inflate(d.h.square_search_recommand_fourm_header, (ViewGroup) null);
                this.fhL.findViewById(d.g.titleTopDivider).setVisibility(8);
                getLayoutMode().aM(this.fhL);
                this.fhA.addView(this.fhL, layoutParams);
                int size = arrayList.size();
                this.fhN.clear();
                for (int i = 0; i < size; i++) {
                    final String str = arrayList.get(i);
                    if (!TextUtils.isEmpty(str)) {
                        final View inflate = LayoutInflater.from(pageActivity).inflate(d.h.home_dialog_search_item, (ViewGroup) null);
                        ((TextView) inflate.findViewById(d.g.home_lv_search_forum)).setText(str);
                        aj.e((TextView) inflate.findViewById(d.g.home_lv_search_forum), d.C0141d.cp_cont_b, 1);
                        inflate.findViewById(d.g.home_dialog_lv_search_forum_divider).setVisibility(8);
                        aj.s(inflate, d.f.square_search_item_bg);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        inflate.setOnClickListener(new b(str));
                        ImageView imageView = (ImageView) inflate.findViewById(d.g.del_search_history_btn);
                        aj.c(imageView, d.f.icn_shop_order_close);
                        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                v.a(new u<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // com.baidu.tbadk.util.u
                                    public Boolean doInBackground() {
                                        com.baidu.tieba.tbadkCore.util.a.sS(str);
                                        return true;
                                    }
                                }, new com.baidu.tbadk.util.h<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.14.2
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.tbadk.util.h
                                    public void onReturnDataInUI(Boolean bool) {
                                        SquareSearchActivity.this.fhA.removeView(inflate);
                                        arrayList.remove(str);
                                        if (arrayList.size() <= 0) {
                                            SquareSearchActivity.this.Y(null);
                                        }
                                    }
                                });
                            }
                        });
                        this.fhN.add(inflate);
                        this.fhA.addView(inflate, layoutParams2);
                    }
                }
                this.fhM = LayoutInflater.from(pageActivity).inflate(d.h.home_dialog_search_footer, (ViewGroup) null);
                ((TextView) this.fhM.findViewById(d.g.home_bt_search_footer)).setTextColor(aj.getColor(d.C0141d.cp_link_tip_a));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                this.fhM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SquareSearchActivity.this.aRD();
                    }
                });
                this.fhA.addView(this.fhM, layoutParams3);
            }
        }
    }

    private void I(boolean z, boolean z2) {
        if (this.fhz != null) {
            this.fhz.clear();
            if (this.fhy != null && !this.fhy.isEmpty() && z) {
                this.fhz.iC(!z2);
                this.fhz.setTitleText(this.mTopicInfoTitle);
                int size = this.fhy.size();
                if (size >= 1) {
                    if (size > 7) {
                        size = 7;
                    }
                    int i = size % 2 == 0 ? size - 1 : size;
                    for (int i2 = 0; i2 < i; i2++) {
                        c cVar = (c) com.baidu.tbadk.core.util.v.f(this.fhy, i2);
                        if (cVar != null) {
                            this.fhz.a(cVar, i2).setOnClickListener(this.fhV);
                        }
                    }
                    this.fhz.a(null, i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.16
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.drQ);
                            if (!com.baidu.tbadk.plugins.a.e(SquareSearchActivity.this.getPageContext())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all")));
                            }
                        }
                    });
                    this.fhz.show();
                }
            }
        }
    }

    private boolean aa(ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && (this.fhy == null || this.fhy.size() <= 2) && this.fhH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRD() {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).dk(getPageContext().getString(d.j.alert_clean_history)).a(getPageContext().getString(d.j.clear_all_text), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                com.baidu.adp.lib.g.h.nt().e(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.bxK();
                    }
                });
                if (SquareSearchActivity.this.fhy == null || SquareSearchActivity.this.fhy.size() < 2) {
                    SquareSearchActivity.this.ci(SquareSearchActivity.this.fhJ);
                    SquareSearchActivity.this.ci(SquareSearchActivity.this.fhK);
                    SquareSearchActivity.this.fht.setVisibility(8);
                    SquareSearchActivity.this.mNoDataView.setVisibility(0);
                    SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.text_no_search_record));
                    return;
                }
                SquareSearchActivity.this.Y(null);
            }
        }).b(getPageContext().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.17
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        }).b(getPageContext()).AU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRE() {
        if (this.dCP.trim().length() > 0) {
            aRG();
            return;
        }
        aRv();
        aRC();
    }

    private void aRF() {
        if (this.fhB != null) {
            this.fhB.setNextPage(null);
        }
    }

    private void aRG() {
        if (!StringUtils.isNull(this.dCP)) {
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.dCP.trim();
            sendMessage(searchListNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        try {
            if (this.fhE != null) {
                if (this.fhE.forum_list != null && this.fhE.forum_list.size() > 0) {
                    aRH();
                    this.fhB.setAdapter((ListAdapter) this.fhC);
                    this.fhC.oC(this.dCP);
                    this.fhC.X(this.fhE.forum_list);
                    this.fhC.notifyDataSetInvalidated();
                } else {
                    cj(this.fhJ);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRH() {
        this.fht.setVisibility(0);
        this.fhB.setVisibility(0);
        this.fhw.setVisibility(8);
        this.fhv.setVisibility(8);
        cj(this.fhJ);
        this.mNoDataView.setVisibility(8);
    }

    private void aRI() {
        this.fht.setVisibility(0);
        this.fhw.setVisibility(0);
        this.fhB.setVisibility(8);
        this.fhv.setVisibility(8);
        cj(this.fhJ);
        this.mNoDataView.setVisibility(8);
    }

    private void aRJ() {
        this.fht.setVisibility(8);
        this.fhB.setVisibility(8);
        this.fhw.setVisibility(8);
        this.fhv.setVisibility(8);
        ci(this.fhJ);
        this.mNoDataView.setVisibility(0);
        ci(this.fhK);
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void oD(String str) {
        this.fhH = true;
        this.fhy = new ArrayList();
        aRC();
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void a(List<com.baidu.tieba.mainentrance.b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str) {
        this.fhH = true;
        hideLoadingView(this.fhs);
        if (list2 == null) {
            this.fhy = new ArrayList();
        } else {
            this.fhy = list2;
        }
        if (!StringUtils.isNULL(str)) {
            this.mTopicInfoTitle = str;
        } else {
            this.mTopicInfoTitle = "";
        }
        a(hotSearchInfoData);
        this.mHotSearchInfo = hotSearchInfoData;
        aRC();
    }

    private void a(HotSearchInfoData hotSearchInfoData) {
        if (hotSearchInfoData != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
            return;
        }
        HotSearchInfoData hotSearchInfoData2 = new HotSearchInfoData();
        hotSearchInfoData2.setId(0L);
        hotSearchInfoData2.setName("");
        hotSearchInfoData2.oE("");
        hotSearchInfoData2.cl(0L);
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
        getLayoutMode().aQ(i == 1);
        getLayoutMode().aM(this.fhr);
        aj.o(this.fhr, i);
        if (this.fhC != null) {
            this.fhC.notifyDataSetChanged();
        }
        if (i == 2) {
            this.drQ.setHintTextColor(aj.getColor(d.C0141d.s_navbar_title_color));
        } else {
            this.drQ.setHintTextColor(aj.getColor(d.C0141d.cp_cont_e));
        }
        aj.c(this.dCZ, d.f.del_search_btn);
        aj.d(this.drQ, d.C0141d.cp_cont_b, d.C0141d.s_navbar_title_color);
        aj.a(this.clt, d.f.icon_seach_n, d.f.icon_seach_n, d.f.icon_seach_n, i);
        aj.s(this.fhs, d.C0141d.cp_bg_line_d);
        aj.e(this.fhu, d.C0141d.cp_link_tip_a, 1);
        if (this.fhz != null) {
            this.fhz.onChangeSkinType(i);
        }
        rr(i);
    }

    private void rr(int i) {
        if (this.fhA != null) {
            this.fhA.setBackgroundColor(aj.getColor(d.C0141d.cp_bg_line_d));
        }
        if (this.fhL != null) {
            getLayoutMode().aM(this.fhL);
        }
        if (this.fhM != null) {
            ((TextView) this.fhM.findViewById(d.g.home_bt_search_footer)).setTextColor(aj.getColor(d.C0141d.cp_link_tip_a));
        }
        if (this.fhN != null) {
            for (View view : this.fhN) {
                aj.e((TextView) view.findViewById(d.g.home_lv_search_forum), d.C0141d.cp_cont_b, 1);
                view.findViewById(d.g.home_dialog_lv_search_forum_divider).setBackgroundColor(aj.getColor(d.C0141d.cp_bg_line_b));
                aj.s(view, d.f.addresslist_item_bg);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (i == 4 && this.fhv.canGoBack()) {
                this.fhv.goBack();
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
                SquareSearchActivity.this.dCP = this.mName;
                TiebaStatic.log(new ak("c12034"));
                SquareSearchActivity.this.L(this.mName, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aRK() {
        if (!j.oJ()) {
            ci(this.mNoDataView);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.neterror));
            return true;
        }
        cj(this.mNoDataView);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
        private BasicNameValuePair fie;
        private x mNetwork = null;
        private String mUrl;

        public a(String str, BasicNameValuePair basicNameValuePair, boolean z) {
            this.mUrl = null;
            this.fie = null;
            this.mUrl = str;
            this.fie = basicNameValuePair;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!SquareSearchActivity.this.aRK()) {
                SquareSearchActivity.this.cj(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.fhs, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(d.e.ds320));
                SquareSearchActivity.this.fht.setVisibility(8);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public ForumSuggestModel doInBackground(Object... objArr) {
            ForumSuggestModel forumSuggestModel = null;
            if (j.oJ()) {
                try {
                    this.mNetwork = new x(this.mUrl);
                    this.mNetwork.a(this.fie);
                    String Ca = this.mNetwork.Ca();
                    if (Ca != null) {
                        forumSuggestModel = ForumSuggestModel.parserJson(Ca);
                        SquareSearchActivity.this.fhG = this.fie.getValue();
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
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.fhs);
            if (forumSuggestModel != null) {
                SquareSearchActivity.this.cj(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.fhE = forumSuggestModel;
                SquareSearchActivity.this.refresh();
            } else {
                SquareSearchActivity.this.ci(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.text_no_search_record));
            }
            SquareSearchActivity.this.fhF = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.mS();
                this.mNetwork = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.fhs);
            super.cancel(true);
        }
    }

    private void iD(boolean z) {
        if (TbadkCoreApplication.isLogin()) {
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(2001323, true));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(2001323, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ci(View view) {
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cj(View view) {
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a026";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(final String str, boolean z) {
        if (!j.oJ()) {
            showToast(d.j.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.fhP = false;
                this.drQ.setText(str);
                this.drQ.setSelection(str.length());
                this.fhP = true;
            }
            l.a(getPageContext().getPageActivity(), this.drQ);
            this.fhw.setVisibility(8);
            this.fhB.setVisibility(8);
            this.fhv.setVisibility(0);
            showProgressBarWithOffset(0, 0);
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            this.fhv.loadUrl(str2);
            v.a(new u<Boolean>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.u
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.sQ(str);
                    return true;
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oF(String str) {
        if (!j.oJ()) {
            showToast(d.j.neterror);
        } else if (!StringUtils.isNull(str)) {
            this.fhQ = str;
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.j.login_to_use), true, (int) IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BIND_WIDGET)));
            } else {
                sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), str)));
            }
        }
    }
}
