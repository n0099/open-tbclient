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
    private ImageView clw;
    private String dCS;
    private ImageView dDc;
    private EditText drT;
    private LinearLayoutDetectsSoftKeyboard fhH;
    private FrameLayout fhI;
    private FrameLayout fhJ;
    private TextView fhK;
    private BaseWebView fhL;
    private ScrollView fhM;
    private LinearLayout fhN;
    private List<c> fhO;
    private g fhP;
    private LinearLayout fhQ;
    private BdListView fhR;
    private com.baidu.tieba.mainentrance.a fhS;
    private com.baidu.tieba.mainentrance.searchSuggestList.a fhT;
    private ForumSuggestModel fhU;
    private a fhV;
    private String fhW;
    private boolean fhX;
    private ScrollView fhZ;
    private HotForumModel fhs;
    private SearchPageFocusBar fia;
    private View fib;
    private View fic;
    private String fih;
    private HotSearchInfoData mHotSearchInfo;
    private NavigationBar mNavigationBar;
    private h mNoDataView;
    private String mTopicInfoTitle;
    private boolean fhY = true;
    private List<View> fie = new ArrayList();
    private boolean fht = false;
    private boolean fif = true;
    private boolean fig = true;
    private Runnable fii = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.1
        @Override // java.lang.Runnable
        public void run() {
            SquareSearchActivity.this.drT.requestFocus();
            l.b(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.drT);
        }
    };
    private final Runnable fij = new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.12
        @Override // java.lang.Runnable
        public void run() {
            if (!SquareSearchActivity.this.aRL()) {
                try {
                    if (SquareSearchActivity.this.dCS != null && SquareSearchActivity.this.dCS.length() > 0) {
                        StringBuffer stringBuffer = new StringBuffer(30);
                        stringBuffer.append(TbConfig.SERVER_ADDRESS);
                        stringBuffer.append("c/f/forum/search");
                        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", SquareSearchActivity.this.dCS.trim());
                        SquareSearchActivity.this.aRw();
                        SquareSearchActivity.this.fhV = new a(stringBuffer.toString(), basicNameValuePair, true);
                        SquareSearchActivity.this.fhV.setPriority(3);
                        SquareSearchActivity.this.fhV.execute(stringBuffer.toString(), basicNameValuePair);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a fik = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SEARCH_LIST, 309438) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.22
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = ((responsedMessage instanceof SearchListHttpResMessage) || (responsedMessage instanceof SearchListSocketResMessage)) ? false : true;
            if (responsedMessage == null || z || responsedMessage.getError() != 0 || responsedMessage.hasError()) {
                if (j.oJ() || !SquareSearchActivity.this.fht) {
                    SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(d.j.neterror));
                }
                if (!j.oJ()) {
                    SquareSearchActivity.this.fht = true;
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
            if (SquareSearchActivity.this.fif && responsedMessage.getError() != 0) {
                SquareSearchActivity.this.showToast(SquareSearchActivity.this.getActivity().getString(d.j.neterror));
                return;
            }
            if (list != null && list.size() > 0) {
                SquareSearchActivity.this.fif = false;
            }
            SquareSearchActivity.this.aRI();
            SquareSearchActivity.this.fhR.setAdapter((ListAdapter) SquareSearchActivity.this.fhT);
            SquareSearchActivity.this.fhT.oC(SquareSearchActivity.this.dCS.trim());
            SquareSearchActivity.this.fhT.setData(list);
            SquareSearchActivity.this.fhT.notifyDataSetInvalidated();
        }
    };
    private CustomMessageListener fhx = new CustomMessageListener(2001608) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                SquareSearchActivity.this.oF(customResponsedMessage.getData().toString());
            }
        }
    };
    private CustomMessageListener fil = new CustomMessageListener(2009002) { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.13
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
    private View.OnClickListener fim = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.drT);
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
                if (SquareSearchActivity.this.fhL.getUrl() != null && SquareSearchActivity.this.fhL.getUrl().contains(str)) {
                    SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.fhI);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aRv() {
        if (this.mHotSearchInfo == null) {
            return false;
        }
        if (this.mHotSearchInfo.aRt() == 0) {
            L(this.mHotSearchInfo.getName(), false);
        } else if (this.mHotSearchInfo.aRt() == 1 && !com.baidu.tbadk.plugins.a.e(getPageContext())) {
            sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "")));
        }
        TiebaStatic.log(new ak("c10355").ab("obj_name", this.mHotSearchInfo.getName()).s("obj_type", this.mHotSearchInfo.aRt() == 0 ? 2 : 1));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.home_dialog_search);
        init();
        getWindow().setSoftInputMode(1);
        registerListener(this.fil);
        registerListener(this.fik);
        registerListener(this.fhx);
        registerListener(this.htmlLoadMessageListener);
        if (SquareSearchActivityConfig.IS_SHOW_RECOMMEND_FORUM) {
            this.fhs = new HotForumModel(getPageContext(), this);
            this.fhs.aRr();
        }
        this.fhX = false;
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
        hideLoadingView(this.fhI);
        this.mHandler.removeCallbacks(this.fii);
        aRw();
    }

    public void aRw() {
        this.mHandler.removeCallbacks(this.fij);
        if (this.fhV != null) {
            this.fhV.cancel();
            this.fhV = null;
        }
    }

    private void init() {
        this.fhH = (LinearLayoutDetectsSoftKeyboard) findViewById(d.g.parent);
        this.fhH.setOnSoftKeyBoardShownListener(new LinearLayoutDetectsSoftKeyboard.a() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.24
            @Override // com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard.a
            public void iJ(boolean z) {
                SquareSearchActivity.this.fhY = z;
            }
        });
        this.fhH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.25
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    SquareSearchActivity.this.fhH.setFocusable(true);
                    SquareSearchActivity.this.fhH.setFocusableInTouchMode(true);
                    if (SquareSearchActivity.this.drT.hasFocus()) {
                        l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.drT);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        awO();
        this.fhI = (FrameLayout) findViewById(d.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds200)), null, null);
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            this.fhZ = (ScrollView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.h.home_searchbar_nodataview, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) this.fhZ.findViewById(d.g.focusbar_nodata_root);
            this.fia = (SearchPageFocusBar) linearLayout.findViewById(d.g.no_data_focusbar);
            linearLayout.addView(this.mNoDataView, 0);
            this.fhZ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.26
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.fhZ);
                    return false;
                }
            });
            this.fhI.addView(this.fhZ, this.fhI.getChildCount());
        } else {
            this.fhI.addView(this.mNoDataView, 0);
        }
        this.fhJ = (FrameLayout) findViewById(d.g.home_search_list);
        aRu();
        aRy();
        aRz();
        aRA();
        this.fhL = (BaseWebView) findViewById(d.g.search_result_webview);
        this.fhL.initCommonJsBridge(getPageContext().getPageActivity());
        this.fhL.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.27
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
                if (SquareSearchActivity.this.isProgressBarShown()) {
                    SquareSearchActivity.this.hideProgressBar();
                }
            }
        });
        this.fhL.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.28
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedError", 0, "", "requesturl", str2, "receiveerror", Integer.valueOf(i), "description", str);
            }
        });
        this.fhL.setOnReceivedSslErrorListener(new BaseWebView.g() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.g
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                if (sslError != null) {
                    com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedSslError", 0, "", "requesturl", sslError.getUrl(), "receiveerror", sslError.toString());
                }
            }
        });
        this.fhL.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.3
            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.mainentrance.SquareSearchActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return aw.Du().b(SquareSearchActivity.this.getPageContext(), new String[]{str}) != 3;
            }
        });
        this.drT.setText("");
        this.drT.requestFocus();
        ShowSoftKeyPadDelay(this.drT, 200);
        aRB();
        aRC();
    }

    private void awO() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.h.square_search_navigation_view, (View.OnClickListener) null);
        this.clw = (ImageView) addCustomView.findViewById(d.g.search_bar_icon);
        this.drT = (EditText) addCustomView.findViewById(d.g.home_et_search);
        this.dDc = (ImageView) addCustomView.findViewById(d.g.home_bt_search_del);
        this.fhK = (TextView) addCustomView.findViewById(d.g.home_bt_search_cancel_s);
        this.drT.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    SquareSearchActivity.this.aRx();
                } else {
                    l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.drT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.aRx();
            }
        });
        this.fhK.setText(getPageContext().getString(d.j.cancel));
        this.fhK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.drT);
                com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SquareSearchActivity.this.finish();
                    }
                }, 200L);
            }
        });
        this.drT.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.7
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (SquareSearchActivity.this.dCS == null || SquareSearchActivity.this.dCS.trim().length() < 1) {
                        l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.drT);
                        if (SquareSearchActivity.this.aRv()) {
                            return true;
                        }
                        SquareSearchActivity.this.showToast(SquareSearchActivity.this.getResources().getString(d.j.write_keyword));
                        return true;
                    }
                    String trim = SquareSearchActivity.this.drT.getText().toString().trim();
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
        this.dDc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareSearchActivity.this.drT.setText("");
            }
        });
        this.drT.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.9
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SquareSearchActivity.this.fig) {
                    SquareSearchActivity.this.dCS = editable.toString();
                    if (StringUtils.isNull(SquareSearchActivity.this.dCS)) {
                        SquareSearchActivity.this.fif = true;
                    }
                    SquareSearchActivity.this.aRF();
                }
                if (editable.toString().trim().length() == 0) {
                    SquareSearchActivity.this.dDc.setVisibility(8);
                } else {
                    SquareSearchActivity.this.dDc.setVisibility(0);
                }
                aj.e(SquareSearchActivity.this.fhK, d.C0141d.cp_link_tip_a, 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRx() {
        if (StringUtils.isNull(this.drT.getText().toString())) {
            if (this.fhM.getVisibility() != 0) {
                aRD();
            }
        } else if (this.fhR.getVisibility() != 0) {
            aRF();
        }
    }

    private void aRy() {
        this.fhM = (ScrollView) findViewById(d.g.search_history_scrollview);
        this.fhN = (LinearLayout) findViewById(d.g.search_history_linearlayout);
        if (this.fhQ == null) {
            this.fhQ = new LinearLayout(getPageContext().getPageActivity());
            this.fhQ.setOrientation(1);
            this.fhQ.setBackgroundColor(aj.getColor(d.C0141d.cp_bg_line_d));
        }
        this.fhN.addView(this.fhQ);
    }

    private void aRz() {
        if (this.fhP == null) {
            this.fhP = new g(getPageContext());
            this.fhN.addView(this.fhP.st());
        }
    }

    private void aRA() {
        this.fhR = (BdListView) findViewById(d.g.home_lv_search_suggest);
        this.fhS = new com.baidu.tieba.mainentrance.a(this, null);
        this.fhT = new com.baidu.tieba.mainentrance.searchSuggestList.a(getPageContext().getPageActivity(), null);
        this.fhR.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.10
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
        this.fhR.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.11
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

    public void aRB() {
        this.fhK.setText(getPageContext().getString(d.j.cancel));
        aRC();
        aRw();
        aRG();
        if (this.dCS.trim().length() > 0) {
            aRF();
        } else {
            aRD();
        }
    }

    private void aRC() {
        if (this.mHotSearchInfo == null) {
            this.drT.setHint(d.j.search_bar);
        } else {
            this.drT.setHint(" " + UtilHelper.getFixedText(this.mHotSearchInfo.aqn(), 15));
        }
    }

    private void aRu() {
        HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
        if (hotSearchInfoData != null && hotSearchInfoData.getId() != 0) {
            this.mHotSearchInfo = hotSearchInfoData;
        }
    }

    private void aRD() {
        this.fhL.setVisibility(8);
        this.fhR.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009002));
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            iI(true);
            cj(this.fia);
            cj(this.fhZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(ArrayList<String> arrayList) {
        NoDataViewFactory.d gp;
        if (aa(arrayList)) {
            aRK();
            if (j.oJ()) {
                gp = NoDataViewFactory.d.gp(d.j.text_no_search_record);
            } else {
                gp = NoDataViewFactory.d.gp(d.j.neterror);
            }
            this.mNoDataView.setTextOption(gp);
            return;
        }
        aRJ();
        Z(arrayList);
        I(true, arrayList == null || arrayList.size() == 0);
        aRC();
    }

    private void Z(final ArrayList<String> arrayList) {
        if (this.fhQ != null) {
            this.fhQ.removeAllViews();
            if (arrayList != null && !arrayList.isEmpty() && getActivity() != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                this.fib = LayoutInflater.from(pageActivity).inflate(d.h.square_search_recommand_fourm_header, (ViewGroup) null);
                this.fib.findViewById(d.g.titleTopDivider).setVisibility(8);
                getLayoutMode().aM(this.fib);
                this.fhQ.addView(this.fib, layoutParams);
                int size = arrayList.size();
                this.fie.clear();
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
                                        SquareSearchActivity.this.fhQ.removeView(inflate);
                                        arrayList.remove(str);
                                        if (arrayList.size() <= 0) {
                                            SquareSearchActivity.this.Y(null);
                                        }
                                    }
                                });
                            }
                        });
                        this.fie.add(inflate);
                        this.fhQ.addView(inflate, layoutParams2);
                    }
                }
                this.fic = LayoutInflater.from(pageActivity).inflate(d.h.home_dialog_search_footer, (ViewGroup) null);
                ((TextView) this.fic.findViewById(d.g.home_bt_search_footer)).setTextColor(aj.getColor(d.C0141d.cp_link_tip_a));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                this.fic.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SquareSearchActivity.this.aRE();
                    }
                });
                this.fhQ.addView(this.fic, layoutParams3);
            }
        }
    }

    private void I(boolean z, boolean z2) {
        if (this.fhP != null) {
            this.fhP.clear();
            if (this.fhO != null && !this.fhO.isEmpty() && z) {
                this.fhP.iH(!z2);
                this.fhP.setTitleText(this.mTopicInfoTitle);
                int size = this.fhO.size();
                if (size >= 1) {
                    if (size > 7) {
                        size = 7;
                    }
                    int i = size % 2 == 0 ? size - 1 : size;
                    for (int i2 = 0; i2 < i; i2++) {
                        c cVar = (c) com.baidu.tbadk.core.util.v.f(this.fhO, i2);
                        if (cVar != null) {
                            this.fhP.a(cVar, i2).setOnClickListener(this.fim);
                        }
                    }
                    this.fhP.a(null, i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.16
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            l.a(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.drT);
                            if (!com.baidu.tbadk.plugins.a.e(SquareSearchActivity.this.getPageContext())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all")));
                            }
                        }
                    });
                    this.fhP.show();
                }
            }
        }
    }

    private boolean aa(ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && (this.fhO == null || this.fhO.size() <= 2) && this.fhX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRE() {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).dk(getPageContext().getString(d.j.alert_clean_history)).a(getPageContext().getString(d.j.clear_all_text), new a.b() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                com.baidu.adp.lib.g.h.nt().e(new Runnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivity.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.bxP();
                    }
                });
                if (SquareSearchActivity.this.fhO == null || SquareSearchActivity.this.fhO.size() < 2) {
                    SquareSearchActivity.this.ci(SquareSearchActivity.this.fhZ);
                    SquareSearchActivity.this.ci(SquareSearchActivity.this.fia);
                    SquareSearchActivity.this.fhJ.setVisibility(8);
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
        }).b(getPageContext()).AV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRF() {
        if (this.dCS.trim().length() > 0) {
            aRH();
            return;
        }
        aRw();
        aRD();
    }

    private void aRG() {
        if (this.fhR != null) {
            this.fhR.setNextPage(null);
        }
    }

    private void aRH() {
        if (!StringUtils.isNull(this.dCS)) {
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.dCS.trim();
            sendMessage(searchListNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        try {
            if (this.fhU != null) {
                if (this.fhU.forum_list != null && this.fhU.forum_list.size() > 0) {
                    aRI();
                    this.fhR.setAdapter((ListAdapter) this.fhS);
                    this.fhS.oC(this.dCS);
                    this.fhS.X(this.fhU.forum_list);
                    this.fhS.notifyDataSetInvalidated();
                } else {
                    cj(this.fhZ);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRI() {
        this.fhJ.setVisibility(0);
        this.fhR.setVisibility(0);
        this.fhM.setVisibility(8);
        this.fhL.setVisibility(8);
        cj(this.fhZ);
        this.mNoDataView.setVisibility(8);
    }

    private void aRJ() {
        this.fhJ.setVisibility(0);
        this.fhM.setVisibility(0);
        this.fhR.setVisibility(8);
        this.fhL.setVisibility(8);
        cj(this.fhZ);
        this.mNoDataView.setVisibility(8);
    }

    private void aRK() {
        this.fhJ.setVisibility(8);
        this.fhR.setVisibility(8);
        this.fhM.setVisibility(8);
        this.fhL.setVisibility(8);
        ci(this.fhZ);
        this.mNoDataView.setVisibility(0);
        ci(this.fia);
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void oD(String str) {
        this.fhX = true;
        this.fhO = new ArrayList();
        aRD();
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void a(List<com.baidu.tieba.mainentrance.b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str) {
        this.fhX = true;
        hideLoadingView(this.fhI);
        if (list2 == null) {
            this.fhO = new ArrayList();
        } else {
            this.fhO = list2;
        }
        if (!StringUtils.isNULL(str)) {
            this.mTopicInfoTitle = str;
        } else {
            this.mTopicInfoTitle = "";
        }
        a(hotSearchInfoData);
        this.mHotSearchInfo = hotSearchInfoData;
        aRD();
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
        getLayoutMode().aM(this.fhH);
        aj.o(this.fhH, i);
        if (this.fhS != null) {
            this.fhS.notifyDataSetChanged();
        }
        if (i == 2) {
            this.drT.setHintTextColor(aj.getColor(d.C0141d.s_navbar_title_color));
        } else {
            this.drT.setHintTextColor(aj.getColor(d.C0141d.cp_cont_e));
        }
        aj.c(this.dDc, d.f.del_search_btn);
        aj.d(this.drT, d.C0141d.cp_cont_b, d.C0141d.s_navbar_title_color);
        aj.a(this.clw, d.f.icon_seach_n, d.f.icon_seach_n, d.f.icon_seach_n, i);
        aj.s(this.fhI, d.C0141d.cp_bg_line_d);
        aj.e(this.fhK, d.C0141d.cp_link_tip_a, 1);
        if (this.fhP != null) {
            this.fhP.onChangeSkinType(i);
        }
        rr(i);
    }

    private void rr(int i) {
        if (this.fhQ != null) {
            this.fhQ.setBackgroundColor(aj.getColor(d.C0141d.cp_bg_line_d));
        }
        if (this.fib != null) {
            getLayoutMode().aM(this.fib);
        }
        if (this.fic != null) {
            ((TextView) this.fic.findViewById(d.g.home_bt_search_footer)).setTextColor(aj.getColor(d.C0141d.cp_link_tip_a));
        }
        if (this.fie != null) {
            for (View view : this.fie) {
                aj.e((TextView) view.findViewById(d.g.home_lv_search_forum), d.C0141d.cp_cont_b, 1);
                view.findViewById(d.g.home_dialog_lv_search_forum_divider).setBackgroundColor(aj.getColor(d.C0141d.cp_bg_line_b));
                aj.s(view, d.f.addresslist_item_bg);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (i == 4 && this.fhL.canGoBack()) {
                this.fhL.goBack();
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
                SquareSearchActivity.this.dCS = this.mName;
                TiebaStatic.log(new ak("c12034"));
                SquareSearchActivity.this.L(this.mName, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aRL() {
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
        private BasicNameValuePair fiu;
        private x mNetwork = null;
        private String mUrl;

        public a(String str, BasicNameValuePair basicNameValuePair, boolean z) {
            this.mUrl = null;
            this.fiu = null;
            this.mUrl = str;
            this.fiu = basicNameValuePair;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!SquareSearchActivity.this.aRL()) {
                SquareSearchActivity.this.cj(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.showLoadingView(SquareSearchActivity.this.fhI, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(d.e.ds320));
                SquareSearchActivity.this.fhJ.setVisibility(8);
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
                    this.mNetwork.a(this.fiu);
                    String Cb = this.mNetwork.Cb();
                    if (Cb != null) {
                        forumSuggestModel = ForumSuggestModel.parserJson(Cb);
                        SquareSearchActivity.this.fhW = this.fiu.getValue();
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
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.fhI);
            if (forumSuggestModel != null) {
                SquareSearchActivity.this.cj(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.fhU = forumSuggestModel;
                SquareSearchActivity.this.refresh();
            } else {
                SquareSearchActivity.this.ci(SquareSearchActivity.this.mNoDataView);
                SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.text_no_search_record));
            }
            SquareSearchActivity.this.fhV = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.mS();
                this.mNetwork = null;
            }
            SquareSearchActivity.this.hideLoadingView(SquareSearchActivity.this.fhI);
            super.cancel(true);
        }
    }

    private void iI(boolean z) {
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
                this.fig = false;
                this.drT.setText(str);
                this.drT.setSelection(str.length());
                this.fig = true;
            }
            l.a(getPageContext().getPageActivity(), this.drT);
            this.fhM.setVisibility(8);
            this.fhR.setVisibility(8);
            this.fhL.setVisibility(0);
            showProgressBarWithOffset(0, 0);
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            this.fhL.loadUrl(str2);
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
            this.fih = str;
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.j.login_to_use), true, (int) IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BIND_WIDGET)));
            } else {
                sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), str)));
            }
        }
    }
}
