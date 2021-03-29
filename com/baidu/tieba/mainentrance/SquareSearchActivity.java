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
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateBarGuideActivityConfig;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.RequestEnterForumDataMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.mainentrance.HotForumModel;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListHttpResMessage;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListNetMessage;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListSocketResMessage;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import d.b.h0.r.s.a;
import d.b.h0.z0.f0;
import d.b.h0.z0.h0;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
@SuppressLint({"ResourceAsColor"})
@Deprecated
/* loaded from: classes3.dex */
public class SquareSearchActivity extends BaseActivity<SquareSearchActivity> implements HotForumModel.b {
    public static final int HOT_FORUM_TOPIC_COLUMN_COUNT = 2;
    public static final int MAX_SEARCH_HINT_SIZE = 15;
    public static final String SEARCHURL = "mo/q/hybrid/search?keyword=";
    public static final int TOPIC_MAX_SIZE = 7;
    public boolean isRequestHotForumData;
    public String lastSearchBarKey;
    public TextView mButtonCancelSearch;
    public ImageView mButtonDel;
    public String mCreatBarName;
    public EditText mEditSearch;
    public d.b.i0.n1.a mForumSuggestAdapter;
    public HotForumModel mHotForumModel;
    public HotSearchInfoData mHotSearchInfo;
    public List<d.b.i0.n1.c> mHotTopicList;
    public FrameLayout mListLayout;
    public BdListView mListSearchSuggest;
    public FrameLayout mMainLayout;
    public ForumSuggestModel mModelSuggest;
    public NavigationBar mNavigationBar;
    public SearchPageFocusBar mNoDataFocusBar;
    public NoDataView mNoDataView;
    public ScrollView mScrollNoDataView;
    public LinearLayout mSearchHistoryLayout;
    public ImageView mSearchIcon;
    public String mSearchKey;
    public d.b.i0.n1.h.b mSearchSuggestAdapter;
    public d.b.i0.n1.g mSearchTopicViewHolder;
    public c0 mSuggestTask;
    public String mTopicInfoTitle;
    public LinearLayoutDetectsSoftKeyboard parent;
    public View searchHistoryClearButton;
    public View searchHistoryView;
    public LinearLayout search_history_linearlayout;
    public ScrollView search_history_scrollview;
    public BaseWebView search_result_webview;
    public boolean mShouldShowKeyboard = true;
    public List<View> searchHistoryiktems = new ArrayList();
    public boolean hasRemindSearchResultForNet = false;
    public boolean isFirstSearch = true;
    public boolean isNeedToShowSuggest = true;
    public Runnable showKeyBoard = new k();
    public final Runnable mSuggestRunnble = new u();
    public d.b.b.c.g.a mSearchListListener = new v(CmdConfigHttp.CMD_SEARCH_LIST, 309438);
    public CustomMessageListener mCreateBarListener = new w(2001608);
    public CustomMessageListener mBarDatalistener = new l(2009002);
    public View.OnClickListener mSearchTopicClickListener = new r();
    public CustomMessageListener htmlLoadMessageListener = new t(2921023);

    /* loaded from: classes3.dex */
    public class a implements BaseWebView.i {
        public a() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.i
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (sslError != null) {
                d.b.h0.r.z.a.a("search", -1L, 0, "ReceivedSslError", 0, "", "requesturl", sslError.getUrl(), "receiveerror", sslError.toString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a0 implements BaseWebView.e {
        public a0() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
        public void onPageFinished(WebView webView, String str) {
            if (SquareSearchActivity.this.isProgressBarShown()) {
                SquareSearchActivity.this.hideProgressBar();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements BaseWebView.d {
        public b() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return UrlManager.getInstance().dealOneLinkWithOutJumpWebView(SquareSearchActivity.this.getPageContext(), new String[]{str}) != 3;
        }
    }

    /* loaded from: classes3.dex */
    public class b0 implements BaseWebView.h {
        public b0() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.h
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            d.b.h0.r.z.a.a("search", -1L, 0, "ReceivedError", 0, "", "requesturl", str2, "receiveerror", Integer.valueOf(i), "description", str);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnFocusChangeListener {
        public c() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (!z) {
                d.b.b.e.p.l.w(SquareSearchActivity.this.getPageContext().getPageActivity(), view);
            } else {
                SquareSearchActivity.this.dealOnClickSearchData();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c0 extends BdAsyncTask<Object, Integer, ForumSuggestModel> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f18807a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f18808b;

        /* renamed from: c  reason: collision with root package name */
        public BasicNameValuePair f18809c;

        public c0(String str, BasicNameValuePair basicNameValuePair, boolean z) {
            this.f18808b = null;
            this.f18809c = null;
            this.f18808b = str;
            this.f18809c = basicNameValuePair;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ForumSuggestModel doInBackground(Object... objArr) {
            ForumSuggestModel forumSuggestModel = null;
            if (d.b.b.e.p.j.z()) {
                try {
                    NetWork netWork = new NetWork(this.f18808b);
                    this.f18807a = netWork;
                    netWork.addPostData(this.f18809c);
                    String postNetData = this.f18807a.postNetData();
                    if (postNetData != null) {
                        forumSuggestModel = ForumSuggestModel.parserJson(postNetData);
                        SquareSearchActivity.this.lastSearchBarKey = this.f18809c.getValue();
                        return forumSuggestModel;
                    }
                    return null;
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    return forumSuggestModel;
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForumSuggestModel forumSuggestModel) {
            SquareSearchActivity squareSearchActivity = SquareSearchActivity.this;
            squareSearchActivity.hideLoadingView(squareSearchActivity.mMainLayout);
            if (forumSuggestModel != null) {
                SquareSearchActivity squareSearchActivity2 = SquareSearchActivity.this;
                squareSearchActivity2.setViewGone(squareSearchActivity2.mNoDataView);
                SquareSearchActivity.this.mModelSuggest = forumSuggestModel;
                SquareSearchActivity.this.refresh();
            } else {
                SquareSearchActivity squareSearchActivity3 = SquareSearchActivity.this;
                squareSearchActivity3.setViewVisible(squareSearchActivity3.mNoDataView);
                SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.e.a(R.string.text_no_search_record));
            }
            SquareSearchActivity.this.mSuggestTask = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NetWork netWork = this.f18807a;
            if (netWork != null) {
                netWork.cancelNetConnect();
                this.f18807a = null;
            }
            SquareSearchActivity squareSearchActivity = SquareSearchActivity.this;
            squareSearchActivity.hideLoadingView(squareSearchActivity.mMainLayout);
            super.cancel(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (SquareSearchActivity.this.checkNetworkAbailableAndSetNetworkErrPrompt()) {
                return;
            }
            SquareSearchActivity squareSearchActivity = SquareSearchActivity.this;
            squareSearchActivity.setViewGone(squareSearchActivity.mNoDataView);
            SquareSearchActivity squareSearchActivity2 = SquareSearchActivity.this;
            squareSearchActivity2.showLoadingView(squareSearchActivity2.mMainLayout, true, SquareSearchActivity.this.getResources().getDimensionPixelSize(R.dimen.ds320));
            SquareSearchActivity.this.mListLayout.setVisibility(8);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SquareSearchActivity.this.dealOnClickSearchData();
        }
    }

    /* loaded from: classes3.dex */
    public class d0 implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public String f18812e;

        public d0(String str) {
            this.f18812e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(this.f18812e)) {
                return;
            }
            SquareSearchActivity.this.mSearchKey = this.f18812e;
            TiebaStatic.log(new StatisticItem("c12034"));
            SquareSearchActivity.this.doSearch(this.f18812e, true);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SquareSearchActivity.this.finish();
            }
        }

        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.b.e.p.l.w(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.mEditSearch);
            d.b.b.e.m.e.a().postDelayed(new a(), 200L);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements TextView.OnEditorActionListener {
        public f() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == 3) {
                if (SquareSearchActivity.this.mSearchKey == null || SquareSearchActivity.this.mSearchKey.trim().length() < 1) {
                    d.b.b.e.p.l.w(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.mEditSearch);
                    if (!SquareSearchActivity.this.navigateToHotSearch()) {
                        SquareSearchActivity squareSearchActivity = SquareSearchActivity.this;
                        squareSearchActivity.showToast(squareSearchActivity.getResources().getString(R.string.write_keyword));
                    }
                } else {
                    String trim = SquareSearchActivity.this.mEditSearch.getText().toString().trim();
                    if (!StringUtils.isNull(trim)) {
                        SquareSearchActivity.this.doSearch(trim, false);
                    } else {
                        SquareSearchActivity squareSearchActivity2 = SquareSearchActivity.this;
                        squareSearchActivity2.showToast(squareSearchActivity2.getResources().getString(R.string.write_keyword));
                    }
                }
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SquareSearchActivity.this.mEditSearch.setText("");
        }
    }

    /* loaded from: classes3.dex */
    public class h implements TextWatcher {
        public h() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (SquareSearchActivity.this.isNeedToShowSuggest) {
                SquareSearchActivity.this.mSearchKey = editable.toString();
                if (StringUtils.isNull(SquareSearchActivity.this.mSearchKey)) {
                    SquareSearchActivity.this.isFirstSearch = true;
                }
                SquareSearchActivity.this.showSuggest();
            }
            if (editable.toString().trim().length() == 0) {
                SquareSearchActivity.this.mButtonDel.setVisibility(8);
            } else {
                SquareSearchActivity.this.mButtonDel.setVisibility(0);
            }
            SkinManager.setViewTextColor(SquareSearchActivity.this.mButtonCancelSearch, R.color.CAM_X0302, 1);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes3.dex */
    public class i implements AdapterView.OnItemClickListener {
        public i() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ListAdapter adapter;
            ListView listView = (ListView) adapterView;
            if (listView == null || (adapter = listView.getAdapter()) == null || adapter.getCount() == 0 || i >= adapter.getCount()) {
                return;
            }
            Object item = adapter.getItem(i);
            if (item instanceof String) {
                SquareSearchActivity.this.doSearch((String) item, true);
                TiebaStatic.eventStat(SquareSearchActivity.this.getPageContext().getPageActivity(), "search_bar_result_click", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements AbsListView.OnScrollListener {
        public j() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 2 || i == 1) {
                d.b.b.e.p.l.w(SquareSearchActivity.this.getPageContext().getPageActivity(), absListView);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SquareSearchActivity.this.mEditSearch.requestFocus();
            d.b.b.e.p.l.J(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.mEditSearch);
        }
    }

    /* loaded from: classes3.dex */
    public class l extends CustomMessageListener {
        public l(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof ArrayList) {
                    SquareSearchActivity.this.showHistoryResult((ArrayList) data);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f18823e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f18824f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ArrayList f18825g;

        /* loaded from: classes3.dex */
        public class a extends f0<Boolean> {
            public a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.b.h0.z0.f0
            public Boolean doInBackground() {
                d.b.i0.c3.n0.a.h(m.this.f18823e);
                return Boolean.TRUE;
            }
        }

        /* loaded from: classes3.dex */
        public class b implements d.b.h0.z0.n<Boolean> {
            public b() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                SquareSearchActivity.this.mSearchHistoryLayout.removeView(m.this.f18824f);
                m mVar = m.this;
                mVar.f18825g.remove(mVar.f18823e);
                if (m.this.f18825g.size() <= 0) {
                    SquareSearchActivity.this.showHistoryResult(null);
                }
            }
        }

        public m(String str, View view, ArrayList arrayList) {
            this.f18823e = str;
            this.f18824f = view;
            this.f18825g = arrayList;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h0.b(new a(), new b());
        }
    }

    /* loaded from: classes3.dex */
    public class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SquareSearchActivity.this.showClearHistoryDialog();
        }
    }

    /* loaded from: classes3.dex */
    public class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.b.e.p.l.w(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.mEditSearch);
            if (d.b.h0.p0.b.b(SquareSearchActivity.this.getPageContext())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all")));
        }
    }

    /* loaded from: classes3.dex */
    public class p implements a.e {
        public p() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class q implements a.e {

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a(q qVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.i0.c3.n0.a.b();
            }
        }

        public q() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
            d.b.b.e.m.h.a().b(new a(this));
            if (SquareSearchActivity.this.mHotTopicList != null && SquareSearchActivity.this.mHotTopicList.size() >= 2) {
                SquareSearchActivity.this.showHistoryResult(null);
                return;
            }
            SquareSearchActivity squareSearchActivity = SquareSearchActivity.this;
            squareSearchActivity.setViewVisible(squareSearchActivity.mScrollNoDataView);
            SquareSearchActivity squareSearchActivity2 = SquareSearchActivity.this;
            squareSearchActivity2.setViewVisible(squareSearchActivity2.mNoDataFocusBar);
            SquareSearchActivity.this.mListLayout.setVisibility(8);
            SquareSearchActivity.this.mNoDataView.setVisibility(0);
            SquareSearchActivity.this.mNoDataView.setTextOption(NoDataViewFactory.e.a(R.string.text_no_search_record));
        }
    }

    /* loaded from: classes3.dex */
    public class r implements View.OnClickListener {
        public r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.b.e.p.l.w(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.mEditSearch);
            if (view.getTag() instanceof d.b.i0.n1.c) {
                d.b.i0.n1.c cVar = (d.b.i0.n1.c) view.getTag();
                TiebaStatic.log(new StatisticItem("c10363").param("obj_name", cVar.b()));
                if (d.b.h0.p0.b.b(SquareSearchActivity.this.getPageContext())) {
                    return;
                }
                SquareSearchActivity.this.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(SquareSearchActivity.this.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(cVar.a()), cVar.b(), "4")));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class s extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f18834a;

        public s(String str) {
            this.f18834a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.b.h0.z0.f0
        public Boolean doInBackground() {
            d.b.i0.c3.n0.a.o(this.f18834a);
            return Boolean.TRUE;
        }
    }

    /* loaded from: classes3.dex */
    public class t extends CustomMessageListener {
        public t(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921023 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (SquareSearchActivity.this.search_result_webview.getUrl() == null || !SquareSearchActivity.this.search_result_webview.getUrl().contains(str)) {
                    return;
                }
                SquareSearchActivity squareSearchActivity = SquareSearchActivity.this;
                squareSearchActivity.hideLoadingView(squareSearchActivity.mMainLayout);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class u implements Runnable {
        public u() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SquareSearchActivity.this.checkNetworkAbailableAndSetNetworkErrPrompt()) {
                return;
            }
            try {
                if (SquareSearchActivity.this.mSearchKey == null || SquareSearchActivity.this.mSearchKey.length() <= 0) {
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer(30);
                stringBuffer.append(TbConfig.SERVER_ADDRESS);
                stringBuffer.append("c/f/forum/search");
                BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", SquareSearchActivity.this.mSearchKey.trim());
                SquareSearchActivity.this.cancelAsyncTask();
                SquareSearchActivity.this.mSuggestTask = new c0(stringBuffer.toString(), basicNameValuePair, true);
                SquareSearchActivity.this.mSuggestTask.setPriority(3);
                SquareSearchActivity.this.mSuggestTask.execute(stringBuffer.toString(), basicNameValuePair);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class v extends d.b.b.c.g.a {
        public v(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = responsedMessage instanceof SearchListHttpResMessage;
            boolean z2 = (z || (responsedMessage instanceof SearchListSocketResMessage)) ? false : true;
            if (responsedMessage != null && !z2 && responsedMessage.getError() == 0 && !responsedMessage.hasError()) {
                List<String> list = null;
                if (z) {
                    list = ((SearchListHttpResMessage) responsedMessage).suggests;
                } else if (responsedMessage instanceof SearchListSocketResMessage) {
                    list = ((SearchListSocketResMessage) responsedMessage).suggests;
                }
                if (SquareSearchActivity.this.isFirstSearch && responsedMessage.getError() != 0) {
                    SquareSearchActivity squareSearchActivity = SquareSearchActivity.this;
                    squareSearchActivity.showToast(squareSearchActivity.getActivity().getString(R.string.neterror));
                    return;
                }
                if (list != null && list.size() > 0) {
                    SquareSearchActivity.this.isFirstSearch = false;
                }
                SquareSearchActivity.this.setSuggestListVisible();
                SquareSearchActivity.this.mListSearchSuggest.setAdapter((ListAdapter) SquareSearchActivity.this.mSearchSuggestAdapter);
                SquareSearchActivity.this.mSearchSuggestAdapter.d(SquareSearchActivity.this.mSearchKey.trim());
                SquareSearchActivity.this.mSearchSuggestAdapter.c(list);
                SquareSearchActivity.this.mSearchSuggestAdapter.notifyDataSetInvalidated();
                return;
            }
            if (d.b.b.e.p.j.z() || !SquareSearchActivity.this.hasRemindSearchResultForNet) {
                SquareSearchActivity squareSearchActivity2 = SquareSearchActivity.this;
                squareSearchActivity2.showToast(squareSearchActivity2.getActivity().getString(R.string.neterror));
            }
            if (d.b.b.e.p.j.z()) {
                return;
            }
            SquareSearchActivity.this.hasRemindSearchResultForNet = true;
        }
    }

    /* loaded from: classes3.dex */
    public class w extends CustomMessageListener {
        public w(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            SquareSearchActivity.this.creatBar(customResponsedMessage.getData().toString());
        }
    }

    /* loaded from: classes3.dex */
    public class x implements LinearLayoutDetectsSoftKeyboard.a {
        public x() {
        }

        @Override // com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard.a
        public void a(boolean z) {
            SquareSearchActivity.this.mShouldShowKeyboard = z;
        }
    }

    /* loaded from: classes3.dex */
    public class y implements View.OnTouchListener {
        public y() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                SquareSearchActivity.this.parent.setFocusable(true);
                SquareSearchActivity.this.parent.setFocusableInTouchMode(true);
                if (SquareSearchActivity.this.mEditSearch.hasFocus()) {
                    d.b.b.e.p.l.w(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.mEditSearch);
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class z implements View.OnTouchListener {
        public z() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            d.b.b.e.p.l.w(SquareSearchActivity.this.getPageContext().getPageActivity(), SquareSearchActivity.this.mScrollNoDataView);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkNetworkAbailableAndSetNetworkErrPrompt() {
        if (!d.b.b.e.p.j.z()) {
            setViewVisible(this.mNoDataView);
            this.mNoDataView.setTextOption(NoDataViewFactory.e.a(R.string.neterror));
            return true;
        }
        setViewGone(this.mNoDataView);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void creatBar(String str) {
        if (!d.b.b.e.p.j.z()) {
            showToast(R.string.neterror);
        } else if (StringUtils.isNull(str)) {
        } else {
            this.mCreatBarName = str;
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11013)));
            } else {
                sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), str)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealOnClickSearchData() {
        if (StringUtils.isNull(this.mEditSearch.getText().toString())) {
            if (this.search_history_scrollview.getVisibility() == 0) {
                return;
            }
            getLocalForumHistory();
        } else if (this.mListSearchSuggest.getVisibility() == 0) {
        } else {
            showSuggest();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSearch(String str, boolean z2) {
        if (!d.b.b.e.p.j.z()) {
            showToast(R.string.neterror);
        } else if (StringUtils.isNull(str)) {
        } else {
            if (z2) {
                this.isNeedToShowSuggest = false;
                this.mEditSearch.setText(str);
                this.mEditSearch.setSelection(str.length());
                this.isNeedToShowSuggest = true;
            }
            d.b.b.e.p.l.w(getPageContext().getPageActivity(), this.mEditSearch);
            this.search_history_scrollview.setVisibility(8);
            this.mListSearchSuggest.setVisibility(8);
            this.search_result_webview.setVisibility(0);
            showProgressBarWithOffset(0, 0);
            String str2 = TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + "mo/q/hybrid/search?keyword=" + str;
            try {
                str2 = TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + "mo/q/hybrid/search?keyword=" + URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            this.search_result_webview.loadUrl(str2);
            h0.b(new s(str), null);
        }
    }

    private void getLocalForumHistory() {
        this.search_result_webview.setVisibility(8);
        this.mListSearchSuggest.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009002));
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            loadFoucsBarData(true);
            setViewGone(this.mNoDataFocusBar);
            setViewGone(this.mScrollNoDataView);
        }
    }

    private void init() {
        LinearLayoutDetectsSoftKeyboard linearLayoutDetectsSoftKeyboard = (LinearLayoutDetectsSoftKeyboard) findViewById(R.id.parent);
        this.parent = linearLayoutDetectsSoftKeyboard;
        linearLayoutDetectsSoftKeyboard.setOnSoftKeyBoardShownListener(new x());
        this.parent.setOnTouchListener(new y());
        initNavigationBar();
        this.mMainLayout = (FrameLayout) findViewById(R.id.frame_layout);
        NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), null, null);
        this.mNoDataView = a2;
        if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
            ScrollView scrollView = (ScrollView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.home_searchbar_nodataview, (ViewGroup) null);
            this.mScrollNoDataView = scrollView;
            LinearLayout linearLayout = (LinearLayout) scrollView.findViewById(R.id.focusbar_nodata_root);
            this.mNoDataFocusBar = (SearchPageFocusBar) linearLayout.findViewById(R.id.no_data_focusbar);
            linearLayout.addView(this.mNoDataView, 0);
            this.mScrollNoDataView.setOnTouchListener(new z());
            FrameLayout frameLayout = this.mMainLayout;
            frameLayout.addView(this.mScrollNoDataView, frameLayout.getChildCount());
        } else {
            this.mMainLayout.addView(a2, 0);
        }
        this.mListLayout = (FrameLayout) findViewById(R.id.home_search_list);
        loadHotSearchCache();
        initSearchHistoryListView();
        initSearchTopicList();
        initSearchSuggestListView();
        BaseWebView baseWebView = (BaseWebView) findViewById(R.id.search_result_webview);
        this.search_result_webview = baseWebView;
        baseWebView.initCommonJsBridge(getPageContext().getPageActivity());
        this.search_result_webview.setOnPageFinishedListener(new a0());
        this.search_result_webview.setOnReceivedErrorListener(new b0());
        this.search_result_webview.setOnReceivedSslErrorListener(new a());
        this.search_result_webview.setOnLoadUrlListener(new b());
        this.mEditSearch.setText("");
        this.mEditSearch.requestFocus();
        ShowSoftKeyPadDelay(this.mEditSearch, 200);
        initSearch();
        setForumSearchHint();
    }

    private void initNavigationBar() {
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar = navigationBar;
        View addCustomView = navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.mSearchIcon = (ImageView) addCustomView.findViewById(R.id.search_bar_icon);
        this.mEditSearch = (EditText) addCustomView.findViewById(R.id.home_et_search);
        this.mButtonDel = (ImageView) addCustomView.findViewById(R.id.home_bt_search_del);
        this.mButtonCancelSearch = (TextView) addCustomView.findViewById(R.id.home_bt_search_cancel_s);
        this.mEditSearch.setOnFocusChangeListener(new c());
        this.mEditSearch.setOnClickListener(new d());
        this.mButtonCancelSearch.setText(getPageContext().getString(R.string.cancel));
        this.mButtonCancelSearch.setOnClickListener(new e());
        this.mEditSearch.setOnEditorActionListener(new f());
        this.mButtonDel.setOnClickListener(new g());
        this.mEditSearch.addTextChangedListener(new h());
    }

    private void initSearchHistoryListView() {
        this.search_history_scrollview = (ScrollView) findViewById(R.id.search_history_scrollview);
        this.search_history_linearlayout = (LinearLayout) findViewById(R.id.search_history_linearlayout);
        if (this.mSearchHistoryLayout == null) {
            LinearLayout linearLayout = new LinearLayout(getPageContext().getPageActivity());
            this.mSearchHistoryLayout = linearLayout;
            linearLayout.setOrientation(1);
            this.mSearchHistoryLayout.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
        }
        this.search_history_linearlayout.addView(this.mSearchHistoryLayout);
    }

    private void initSearchSuggestListView() {
        this.mListSearchSuggest = (BdListView) findViewById(R.id.home_lv_search_suggest);
        this.mForumSuggestAdapter = new d.b.i0.n1.a(this, null);
        this.mSearchSuggestAdapter = new d.b.i0.n1.h.b(getPageContext().getPageActivity(), null);
        this.mListSearchSuggest.setOnItemClickListener(new i());
        this.mListSearchSuggest.setOnScrollListener(new j());
    }

    private void initSearchTopicList() {
        if (this.mSearchTopicViewHolder == null) {
            d.b.i0.n1.g gVar = new d.b.i0.n1.g(getPageContext());
            this.mSearchTopicViewHolder = gVar;
            this.search_history_linearlayout.addView(gVar.d());
        }
    }

    private void loadFoucsBarData(boolean z2) {
        if (TbadkCoreApplication.isLogin()) {
            if (z2) {
                MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(2001323, Boolean.TRUE));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(2001323, Boolean.FALSE));
        }
    }

    private void loadHotSearchCache() {
        HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(d.b.h0.r.d0.b.i().o("hot_search_info", ""), HotSearchInfoData.class);
        if (hotSearchInfoData == null || hotSearchInfoData.getId() == 0) {
            return;
        }
        this.mHotSearchInfo = hotSearchInfoData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean navigateToHotSearch() {
        HotSearchInfoData hotSearchInfoData = this.mHotSearchInfo;
        if (hotSearchInfoData == null) {
            return false;
        }
        if (hotSearchInfoData.t() == 0) {
            doSearch(this.mHotSearchInfo.getName(), false);
        } else if (this.mHotSearchInfo.t() == 1 && !d.b.h0.p0.b.b(getPageContext())) {
            sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new StatisticItem("c10355").param("obj_name", this.mHotSearchInfo.getName()).param("obj_type", this.mHotSearchInfo.t() == 0 ? 2 : 1));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        try {
            if (this.mModelSuggest != null) {
                if (this.mModelSuggest.forum_list != null && this.mModelSuggest.forum_list.size() > 0) {
                    setSuggestListVisible();
                    this.mListSearchSuggest.setAdapter((ListAdapter) this.mForumSuggestAdapter);
                    this.mForumSuggestAdapter.e(this.mSearchKey);
                    this.mForumSuggestAdapter.d(this.mModelSuggest.forum_list);
                    this.mForumSuggestAdapter.notifyDataSetInvalidated();
                } else {
                    setViewGone(this.mScrollNoDataView);
                }
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    private void requestSuggestList() {
        if (StringUtils.isNull(this.mSearchKey)) {
            return;
        }
        SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
        searchListNetMessage.mKey = this.mSearchKey.trim();
        sendMessage(searchListNetMessage);
    }

    private void resetListSearchSuggest() {
        BdListView bdListView = this.mListSearchSuggest;
        if (bdListView != null) {
            bdListView.setNextPage(null);
        }
    }

    private void searchHistoryLayoutChangeSkinType(int i2) {
        LinearLayout linearLayout = this.mSearchHistoryLayout;
        if (linearLayout != null) {
            linearLayout.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
        }
        if (this.searchHistoryView != null) {
            getLayoutMode().j(this.searchHistoryView);
        }
        View view = this.searchHistoryClearButton;
        if (view != null) {
            ((TextView) view.findViewById(R.id.home_bt_search_footer)).setTextColor(SkinManager.getColor(R.color.CAM_X0302));
        }
        List<View> list = this.searchHistoryiktems;
        if (list != null) {
            for (View view2 : list) {
                SkinManager.setViewTextColor((TextView) view2.findViewById(R.id.home_lv_search_forum), R.color.CAM_X0105, 1);
                view2.findViewById(R.id.home_dialog_lv_search_forum_divider).setBackgroundColor(SkinManager.getColor(R.color.CAM_X0204));
                SkinManager.setBackgroundResource(view2, R.drawable.addresslist_item_bg);
            }
        }
    }

    private void setForumSearchHint() {
        if (this.mHotSearchInfo == null) {
            this.mEditSearch.setHint(R.string.search_bar);
            return;
        }
        EditText editText = this.mEditSearch;
        editText.setHint(" " + UtilHelper.getFixedText(this.mHotSearchInfo.s(), 15));
    }

    private void setHistoryListVisible() {
        this.mListLayout.setVisibility(0);
        this.search_history_scrollview.setVisibility(0);
        this.mListSearchSuggest.setVisibility(8);
        this.search_result_webview.setVisibility(8);
        setViewGone(this.mScrollNoDataView);
        this.mNoDataView.setVisibility(8);
    }

    private void setNoDataViewVisible() {
        this.mListLayout.setVisibility(8);
        this.mListSearchSuggest.setVisibility(8);
        this.search_history_scrollview.setVisibility(8);
        this.search_result_webview.setVisibility(8);
        setViewVisible(this.mScrollNoDataView);
        this.mNoDataView.setVisibility(0);
        setViewVisible(this.mNoDataFocusBar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSuggestListVisible() {
        this.mListLayout.setVisibility(0);
        this.mListSearchSuggest.setVisibility(0);
        this.search_history_scrollview.setVisibility(8);
        this.search_result_webview.setVisibility(8);
        setViewGone(this.mScrollNoDataView);
        this.mNoDataView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewGone(View view) {
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewVisible(View view) {
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private boolean shouldShowNoDataView(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            List<d.b.i0.n1.c> list = this.mHotTopicList;
            return (list == null || list.size() <= 2) && this.isRequestHotForumData;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showClearHistoryDialog() {
        new d.b.h0.r.s.a(getPageContext().getPageActivity()).setMessage(getPageContext().getString(R.string.alert_clean_history)).setPositiveButton(getPageContext().getString(R.string.clear_all_text), new q()).setNegativeButton(getPageContext().getString(R.string.cancel), new p()).create(getPageContext()).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showHistoryResult(ArrayList<String> arrayList) {
        NoDataViewFactory.e a2;
        if (shouldShowNoDataView(arrayList)) {
            setNoDataViewVisible();
            if (d.b.b.e.p.j.z()) {
                a2 = NoDataViewFactory.e.a(R.string.text_no_search_record);
            } else {
                a2 = NoDataViewFactory.e.a(R.string.neterror);
            }
            this.mNoDataView.setTextOption(a2);
            return;
        }
        setHistoryListVisible();
        updateSearchHistory(arrayList);
        updateSearchTopic(true, arrayList == null || arrayList.size() == 0);
        setForumSearchHint();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSuggest() {
        if (this.mSearchKey.trim().length() > 0) {
            requestSuggestList();
            return;
        }
        cancelAsyncTask();
        getLocalForumHistory();
    }

    private void updateHotSearchCache(HotSearchInfoData hotSearchInfoData) {
        if (hotSearchInfoData != null) {
            d.b.h0.r.d0.b.i().w("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
            return;
        }
        HotSearchInfoData hotSearchInfoData2 = new HotSearchInfoData();
        hotSearchInfoData2.setId(0L);
        hotSearchInfoData2.setName("");
        hotSearchInfoData2.v("");
        hotSearchInfoData2.w(0L);
        d.b.h0.r.d0.b.i().w("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData2));
    }

    private void updateSearchHistory(ArrayList<String> arrayList) {
        LinearLayout linearLayout = this.mSearchHistoryLayout;
        if (linearLayout == null) {
            return;
        }
        linearLayout.removeAllViews();
        if (arrayList == null || arrayList.isEmpty() || getActivity() == null) {
            return;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        View inflate = LayoutInflater.from(pageActivity).inflate(R.layout.square_search_recommand_fourm_header, (ViewGroup) null);
        this.searchHistoryView = inflate;
        inflate.findViewById(R.id.titleTopDivider).setVisibility(8);
        getLayoutMode().j(this.searchHistoryView);
        this.mSearchHistoryLayout.addView(this.searchHistoryView, layoutParams);
        int size = arrayList.size();
        this.searchHistoryiktems.clear();
        for (int i2 = 0; i2 < size; i2++) {
            String str = arrayList.get(i2);
            if (!TextUtils.isEmpty(str)) {
                View inflate2 = LayoutInflater.from(pageActivity).inflate(R.layout.home_dialog_search_item, (ViewGroup) null);
                ((TextView) inflate2.findViewById(R.id.home_lv_search_forum)).setText(str);
                SkinManager.setViewTextColor((TextView) inflate2.findViewById(R.id.home_lv_search_forum), R.color.CAM_X0105, 1);
                inflate2.findViewById(R.id.home_dialog_lv_search_forum_divider).setVisibility(8);
                SkinManager.setBackgroundResource(inflate2, R.drawable.square_search_item_bg);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                inflate2.setOnClickListener(new d0(str));
                ImageView imageView = (ImageView) inflate2.findViewById(R.id.del_search_history_btn);
                SkinManager.setImageResource(imageView, R.drawable.icn_shop_order_close);
                imageView.setOnClickListener(new m(str, inflate2, arrayList));
                this.searchHistoryiktems.add(inflate2);
                this.mSearchHistoryLayout.addView(inflate2, layoutParams2);
            }
        }
        View inflate3 = LayoutInflater.from(pageActivity).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.searchHistoryClearButton = inflate3;
        ((TextView) inflate3.findViewById(R.id.home_bt_search_footer)).setTextColor(SkinManager.getColor(R.color.CAM_X0302));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        this.searchHistoryClearButton.setOnClickListener(new n());
        this.mSearchHistoryLayout.addView(this.searchHistoryClearButton, layoutParams3);
    }

    private void updateSearchTopic(boolean z2, boolean z3) {
        d.b.i0.n1.g gVar = this.mSearchTopicViewHolder;
        if (gVar == null) {
            return;
        }
        gVar.c();
        List<d.b.i0.n1.c> list = this.mHotTopicList;
        if (list == null || list.isEmpty() || !z2) {
            return;
        }
        this.mSearchTopicViewHolder.i(!z3);
        this.mSearchTopicViewHolder.h(this.mTopicInfoTitle);
        int size = this.mHotTopicList.size();
        if (size >= 1) {
            if (size > 7) {
                size = 7;
            }
            if (size % 2 == 0) {
                size--;
            }
            for (int i2 = 0; i2 < size; i2++) {
                d.b.i0.n1.c cVar = (d.b.i0.n1.c) ListUtils.getItem(this.mHotTopicList, i2);
                if (cVar != null) {
                    this.mSearchTopicViewHolder.a(cVar, i2).setOnClickListener(this.mSearchTopicClickListener);
                }
            }
            this.mSearchTopicViewHolder.a(null, size).setOnClickListener(new o());
            this.mSearchTopicViewHolder.j();
        }
    }

    public void cancelAsyncTask() {
        this.mHandler.removeCallbacks(this.mSuggestRunnble);
        c0 c0Var = this.mSuggestTask;
        if (c0Var != null) {
            c0Var.cancel();
            this.mSuggestTask = null;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        if (!getIntent().getBooleanExtra("back_special", false)) {
            finish();
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            d.b.h0.r.a0.b.e(getPageContext().getPageActivity(), 1);
        } else {
            d.b.h0.r.a0.b.e(getPageContext().getPageActivity(), 2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, d.b.h0.k0.a
    public String getCurrentPageKey() {
        return "a026";
    }

    public void initSearch() {
        this.mButtonCancelSearch.setText(getPageContext().getString(R.string.cancel));
        setForumSearchHint();
        cancelAsyncTask();
        resetListSearchSuggest();
        if (this.mSearchKey.trim().length() > 0) {
            showSuggest();
        } else {
            getLocalForumHistory();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        NoDataView noDataView = this.mNoDataView;
        if (noDataView != null) {
            noDataView.f(getPageContext(), i2);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
        getLayoutMode().k(i2 == 1);
        getLayoutMode().j(this.parent);
        SkinManager.setBgColor(this.parent, i2);
        d.b.i0.n1.a aVar = this.mForumSuggestAdapter;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
        if (i2 == 2) {
            this.mEditSearch.setHintTextColor(SkinManager.getColor(R.color.s_navbar_title_color));
        } else {
            this.mEditSearch.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mButtonDel, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SkinManager.setNavbarTitleColor(this.mEditSearch, R.color.CAM_X0105, R.color.s_navbar_title_color);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mSearchIcon, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
        SkinManager.setBackgroundResource(this.mMainLayout, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.mButtonCancelSearch, R.color.CAM_X0302, 1);
        d.b.i0.n1.g gVar = this.mSearchTopicViewHolder;
        if (gVar != null) {
            gVar.f(i2);
        }
        searchHistoryLayoutChangeSkinType(i2);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.home_dialog_search);
        init();
        getWindow().setSoftInputMode(1);
        registerListener(this.mBarDatalistener);
        registerListener(this.mSearchListListener);
        registerListener(this.mCreateBarListener);
        registerListener(this.htmlLoadMessageListener);
        if (SquareSearchActivityConfig.IS_SHOW_RECOMMEND_FORUM) {
            HotForumModel hotForumModel = new HotForumModel(getPageContext(), this);
            this.mHotForumModel = hotForumModel;
            hotForumModel.D();
        }
        this.isRequestHotForumData = false;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        hideLoadingView(this.mMainLayout);
        this.mHandler.removeCallbacks(this.showKeyBoard);
        cancelAsyncTask();
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.b
    public void onHotForumDataFailed(String str) {
        this.isRequestHotForumData = true;
        this.mHotTopicList = new ArrayList();
        getLocalForumHistory();
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.b
    public void onHotForumDataSuccess(List<d.b.i0.n1.b> list, List<d.b.i0.n1.c> list2, HotSearchInfoData hotSearchInfoData, String str) {
        this.isRequestHotForumData = true;
        hideLoadingView(this.mMainLayout);
        if (list2 == null) {
            this.mHotTopicList = new ArrayList();
        } else {
            this.mHotTopicList = list2;
        }
        if (!StringUtils.isNULL(str)) {
            this.mTopicInfoTitle = str;
        } else {
            this.mTopicInfoTitle = "";
        }
        updateHotSearchCache(hotSearchInfoData);
        this.mHotSearchInfo = hotSearchInfoData;
        getLocalForumHistory();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            if (i2 == 4 && this.search_result_webview.canGoBack()) {
                this.search_result_webview.goBack();
                return true;
            }
            closeActivity();
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        setSkinType(3);
        NoDataView noDataView = this.mNoDataView;
        if (noDataView != null) {
            noDataView.e();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
