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
import androidx.core.view.InputDeviceCompat;
import c.a.p0.b1.h0;
import c.a.p0.b1.k0;
import c.a.p0.s.s.a;
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
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.tieba.mainentrance.searchsuggestlist.SearchListHttpResMessage;
import com.baidu.tieba.mainentrance.searchsuggestlist.SearchListNetMessage;
import com.baidu.tieba.mainentrance.searchsuggestlist.SearchListSocketResMessage;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
@SuppressLint({"ResourceAsColor"})
@Deprecated
/* loaded from: classes7.dex */
public class SquareSearchActivity extends BaseActivity<SquareSearchActivity> implements HotForumModel.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HOT_FORUM_TOPIC_COLUMN_COUNT = 2;
    public static final int MAX_SEARCH_HINT_SIZE = 15;
    public static final String SEARCHURL = "mo/q/hybrid/search?keyword=";
    public static final int TOPIC_MAX_SIZE = 7;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasRemindSearchResultForNet;
    public CustomMessageListener htmlLoadMessageListener;
    public boolean isFirstSearch;
    public boolean isNeedToShowSuggest;
    public boolean isRequestHotForumData;
    public String lastSearchBarKey;
    public CustomMessageListener mBarDatalistener;
    public TextView mButtonCancelSearch;
    public ImageView mButtonDel;
    public String mCreatBarName;
    public CustomMessageListener mCreateBarListener;
    public EditText mEditSearch;
    public c.a.q0.t1.a mForumSuggestAdapter;
    public HotForumModel mHotForumModel;
    public HotSearchInfoData mHotSearchInfo;
    public List<c.a.q0.t1.c> mHotTopicList;
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
    public c.a.e.c.g.a mSearchListListener;
    public c.a.q0.t1.h.a mSearchSuggestAdapter;
    public View.OnClickListener mSearchTopicClickListener;
    public c.a.q0.t1.g mSearchTopicViewHolder;
    public boolean mShouldShowKeyboard;
    public final Runnable mSuggestRunnble;
    public c0 mSuggestTask;
    public String mTopicInfoTitle;
    public LinearLayoutDetectsSoftKeyboard parent;
    public View searchHistoryClearButton;
    public View searchHistoryView;
    public List<View> searchHistoryiktems;
    public LinearLayout search_history_linearlayout;
    public ScrollView search_history_scrollview;
    public BaseWebView search_result_webview;
    public Runnable showKeyBoard;

    /* loaded from: classes7.dex */
    public class a implements BaseWebView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SquareSearchActivity f53922a;

        public a(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53922a = squareSearchActivity;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.i
        public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, webView, sslErrorHandler, sslError) == null) || sslError == null) {
                return;
            }
            c.a.p0.s.z.a.a("search", -1L, 0, "ReceivedSslError", 0, "", "requesturl", sslError.getUrl(), "receiveerror", sslError.toString());
        }
    }

    /* loaded from: classes7.dex */
    public class a0 implements BaseWebView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SquareSearchActivity f53923e;

        public a0(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53923e = squareSearchActivity;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) && this.f53923e.isProgressBarShown()) {
                this.f53923e.hideProgressBar();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements BaseWebView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SquareSearchActivity f53924e;

        public b(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53924e = squareSearchActivity;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, webView, str)) == null) ? UrlManager.getInstance().dealOneLinkWithOutJumpWebView(this.f53924e.getPageContext(), new String[]{str}) != 3 : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b0 implements BaseWebView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SquareSearchActivity f53925a;

        public b0(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53925a = squareSearchActivity;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.h
        public void a(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, webView, i2, str, str2) == null) {
                c.a.p0.s.z.a.a("search", -1L, 0, "ReceivedError", 0, "", "requesturl", str2, "receiveerror", Integer.valueOf(i2), "description", str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SquareSearchActivity f53926e;

        public c(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53926e = squareSearchActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                if (!z) {
                    c.a.e.e.p.l.x(this.f53926e.getPageContext().getPageActivity(), view);
                } else {
                    this.f53926e.dealOnClickSearchData();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c0 extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f53927a;

        /* renamed from: b  reason: collision with root package name */
        public String f53928b;

        /* renamed from: c  reason: collision with root package name */
        public BasicNameValuePair f53929c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SquareSearchActivity f53930d;

        public c0(SquareSearchActivity squareSearchActivity, String str, BasicNameValuePair basicNameValuePair, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity, str, basicNameValuePair, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53930d = squareSearchActivity;
            this.f53927a = null;
            this.f53928b = null;
            this.f53929c = null;
            this.f53928b = str;
            this.f53929c = basicNameValuePair;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ForumSuggestModel doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                ForumSuggestModel forumSuggestModel = null;
                if (c.a.e.e.p.j.z()) {
                    try {
                        NetWork netWork = new NetWork(this.f53928b);
                        this.f53927a = netWork;
                        netWork.addPostData(this.f53929c);
                        String postNetData = this.f53927a.postNetData();
                        if (postNetData != null) {
                            forumSuggestModel = ForumSuggestModel.parserJson(postNetData);
                            this.f53930d.lastSearchBarKey = this.f53929c.getValue();
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
            return (ForumSuggestModel) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForumSuggestModel forumSuggestModel) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forumSuggestModel) == null) {
                SquareSearchActivity squareSearchActivity = this.f53930d;
                squareSearchActivity.hideLoadingView(squareSearchActivity.mMainLayout);
                if (forumSuggestModel != null) {
                    SquareSearchActivity squareSearchActivity2 = this.f53930d;
                    squareSearchActivity2.setViewGone(squareSearchActivity2.mNoDataView);
                    this.f53930d.mModelSuggest = forumSuggestModel;
                    this.f53930d.refresh();
                } else {
                    SquareSearchActivity squareSearchActivity3 = this.f53930d;
                    squareSearchActivity3.setViewVisible(squareSearchActivity3.mNoDataView);
                    this.f53930d.mNoDataView.setTextOption(NoDataViewFactory.e.a(R.string.text_no_search_record));
                }
                this.f53930d.mSuggestTask = null;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                NetWork netWork = this.f53927a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                    this.f53927a = null;
                }
                SquareSearchActivity squareSearchActivity = this.f53930d;
                squareSearchActivity.hideLoadingView(squareSearchActivity.mMainLayout);
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f53930d.checkNetworkAbailableAndSetNetworkErrPrompt()) {
                return;
            }
            SquareSearchActivity squareSearchActivity = this.f53930d;
            squareSearchActivity.setViewGone(squareSearchActivity.mNoDataView);
            SquareSearchActivity squareSearchActivity2 = this.f53930d;
            squareSearchActivity2.showLoadingView(squareSearchActivity2.mMainLayout, true, this.f53930d.getResources().getDimensionPixelSize(R.dimen.ds320));
            this.f53930d.mListLayout.setVisibility(8);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SquareSearchActivity f53931e;

        public d(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53931e = squareSearchActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f53931e.dealOnClickSearchData();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f53932e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SquareSearchActivity f53933f;

        public d0(SquareSearchActivity squareSearchActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53933f = squareSearchActivity;
            this.f53932e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f53932e)) {
                return;
            }
            this.f53933f.mSearchKey = this.f53932e;
            TiebaStatic.log(new StatisticItem("c12034"));
            this.f53933f.doSearch(this.f53932e, true);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SquareSearchActivity f53934e;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f53935e;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53935e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f53935e.f53934e.finish();
                }
            }
        }

        public e(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53934e = squareSearchActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.e.e.p.l.x(this.f53934e.getPageContext().getPageActivity(), this.f53934e.mEditSearch);
                c.a.e.e.m.e.a().postDelayed(new a(this), 200L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SquareSearchActivity f53936a;

        public f(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53936a = squareSearchActivity;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) {
                if (i2 == 3) {
                    if (this.f53936a.mSearchKey == null || this.f53936a.mSearchKey.trim().length() < 1) {
                        c.a.e.e.p.l.x(this.f53936a.getPageContext().getPageActivity(), this.f53936a.mEditSearch);
                        if (!this.f53936a.navigateToHotSearch()) {
                            SquareSearchActivity squareSearchActivity = this.f53936a;
                            squareSearchActivity.showToast(squareSearchActivity.getResources().getString(R.string.write_keyword));
                        }
                    } else {
                        String trim = this.f53936a.mEditSearch.getText().toString().trim();
                        if (!StringUtils.isNull(trim)) {
                            this.f53936a.doSearch(trim, false);
                        } else {
                            SquareSearchActivity squareSearchActivity2 = this.f53936a;
                            squareSearchActivity2.showToast(squareSearchActivity2.getResources().getString(R.string.write_keyword));
                        }
                    }
                    return true;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SquareSearchActivity f53937e;

        public g(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53937e = squareSearchActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f53937e.mEditSearch.setText("");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SquareSearchActivity f53938e;

        public h(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53938e = squareSearchActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (this.f53938e.isNeedToShowSuggest) {
                    this.f53938e.mSearchKey = editable.toString();
                    if (StringUtils.isNull(this.f53938e.mSearchKey)) {
                        this.f53938e.isFirstSearch = true;
                    }
                    this.f53938e.showSuggest();
                }
                if (editable.toString().trim().length() == 0) {
                    this.f53938e.mButtonDel.setVisibility(8);
                } else {
                    this.f53938e.mButtonDel.setVisibility(0);
                }
                SkinManager.setViewTextColor(this.f53938e.mButtonCancelSearch, R.color.CAM_X0302, 1);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SquareSearchActivity f53939e;

        public i(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53939e = squareSearchActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            ListView listView;
            ListAdapter adapter;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (listView = (ListView) adapterView) == null || (adapter = listView.getAdapter()) == null || adapter.getCount() == 0 || i2 >= adapter.getCount()) {
                return;
            }
            Object item = adapter.getItem(i2);
            if (item instanceof String) {
                this.f53939e.doSearch((String) item, true);
                TiebaStatic.eventStat(this.f53939e.getPageContext().getPageActivity(), "search_bar_result_click", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SquareSearchActivity f53940e;

        public j(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53940e = squareSearchActivity;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) {
                if (i2 == 2 || i2 == 1) {
                    c.a.e.e.p.l.x(this.f53940e.getPageContext().getPageActivity(), absListView);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SquareSearchActivity f53941e;

        public k(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53941e = squareSearchActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53941e.mEditSearch.requestFocus();
                c.a.e.e.p.l.K(this.f53941e.getPageContext().getPageActivity(), this.f53941e.mEditSearch);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SquareSearchActivity f53942a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(SquareSearchActivity squareSearchActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53942a = squareSearchActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof ArrayList) {
                this.f53942a.showHistoryResult((ArrayList) data);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f53943e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f53944f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ArrayList f53945g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ SquareSearchActivity f53946h;

        /* loaded from: classes7.dex */
        public class a extends h0<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ m f53947a;

            public a(m mVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53947a = mVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // c.a.p0.b1.h0
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    c.a.q0.i3.o0.a.h(this.f53947a.f53943e);
                    return Boolean.TRUE;
                }
                return (Boolean) invokeV.objValue;
            }
        }

        /* loaded from: classes7.dex */
        public class b implements c.a.p0.b1.n<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ m f53948a;

            public b(m mVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53948a = mVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.b1.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    this.f53948a.f53946h.mSearchHistoryLayout.removeView(this.f53948a.f53944f);
                    m mVar = this.f53948a;
                    mVar.f53945g.remove(mVar.f53943e);
                    if (this.f53948a.f53945g.size() <= 0) {
                        this.f53948a.f53946h.showHistoryResult(null);
                    }
                }
            }
        }

        public m(SquareSearchActivity squareSearchActivity, String str, View view, ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity, str, view, arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53946h = squareSearchActivity;
            this.f53943e = str;
            this.f53944f = view;
            this.f53945g = arrayList;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                k0.b(new a(this), new b(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SquareSearchActivity f53949e;

        public n(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53949e = squareSearchActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f53949e.showClearHistoryDialog();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SquareSearchActivity f53950e;

        public o(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53950e = squareSearchActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.e.e.p.l.x(this.f53950e.getPageContext().getPageActivity(), this.f53950e.mEditSearch);
                if (c.a.p0.r0.b.b(this.f53950e.getPageContext())) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all")));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SquareSearchActivity f53951e;

        public p(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53951e = squareSearchActivity;
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SquareSearchActivity f53952e;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(q qVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.q0.i3.o0.a.b();
                }
            }
        }

        public q(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53952e = squareSearchActivity;
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                c.a.e.e.m.h.a().b(new a(this));
                if (this.f53952e.mHotTopicList != null && this.f53952e.mHotTopicList.size() >= 2) {
                    this.f53952e.showHistoryResult(null);
                    return;
                }
                SquareSearchActivity squareSearchActivity = this.f53952e;
                squareSearchActivity.setViewVisible(squareSearchActivity.mScrollNoDataView);
                SquareSearchActivity squareSearchActivity2 = this.f53952e;
                squareSearchActivity2.setViewVisible(squareSearchActivity2.mNoDataFocusBar);
                this.f53952e.mListLayout.setVisibility(8);
                this.f53952e.mNoDataView.setVisibility(0);
                this.f53952e.mNoDataView.setTextOption(NoDataViewFactory.e.a(R.string.text_no_search_record));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SquareSearchActivity f53953e;

        public r(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53953e = squareSearchActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.e.e.p.l.x(this.f53953e.getPageContext().getPageActivity(), this.f53953e.mEditSearch);
                if (view.getTag() instanceof c.a.q0.t1.c) {
                    c.a.q0.t1.c cVar = (c.a.q0.t1.c) view.getTag();
                    TiebaStatic.log(new StatisticItem("c10363").param("obj_name", cVar.b()));
                    if (c.a.p0.r0.b.b(this.f53953e.getPageContext())) {
                        return;
                    }
                    this.f53953e.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.f53953e.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(cVar.a()), cVar.b(), "4")));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s extends h0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f53954a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SquareSearchActivity f53955b;

        public s(SquareSearchActivity squareSearchActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53955b = squareSearchActivity;
            this.f53954a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.a.p0.b1.h0
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.q0.i3.o0.a.o(this.f53954a);
                return Boolean.TRUE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SquareSearchActivity f53956a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(SquareSearchActivity squareSearchActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53956a = squareSearchActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921023 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (this.f53956a.search_result_webview.getUrl() == null || !this.f53956a.search_result_webview.getUrl().contains(str)) {
                    return;
                }
                SquareSearchActivity squareSearchActivity = this.f53956a;
                squareSearchActivity.hideLoadingView(squareSearchActivity.mMainLayout);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SquareSearchActivity f53957e;

        public u(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53957e = squareSearchActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f53957e.checkNetworkAbailableAndSetNetworkErrPrompt()) {
                return;
            }
            try {
                if (this.f53957e.mSearchKey == null || this.f53957e.mSearchKey.length() <= 0) {
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer(30);
                stringBuffer.append(TbConfig.SERVER_ADDRESS);
                stringBuffer.append("c/f/forum/search");
                BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", this.f53957e.mSearchKey.trim());
                this.f53957e.cancelAsyncTask();
                this.f53957e.mSuggestTask = new c0(this.f53957e, stringBuffer.toString(), basicNameValuePair, true);
                this.f53957e.mSuggestTask.setPriority(3);
                this.f53957e.mSuggestTask.execute(stringBuffer.toString(), basicNameValuePair);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SquareSearchActivity f53958a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(SquareSearchActivity squareSearchActivity, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53958a = squareSearchActivity;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z = responsedMessage instanceof SearchListHttpResMessage;
                boolean z2 = (z || (responsedMessage instanceof SearchListSocketResMessage)) ? false : true;
                if (responsedMessage != null && !z2 && responsedMessage.getError() == 0 && !responsedMessage.hasError()) {
                    List<String> list = null;
                    if (z) {
                        list = ((SearchListHttpResMessage) responsedMessage).suggests;
                    } else if (responsedMessage instanceof SearchListSocketResMessage) {
                        list = ((SearchListSocketResMessage) responsedMessage).suggests;
                    }
                    if (this.f53958a.isFirstSearch && responsedMessage.getError() != 0) {
                        SquareSearchActivity squareSearchActivity = this.f53958a;
                        squareSearchActivity.showToast(squareSearchActivity.getActivity().getString(R.string.neterror));
                        return;
                    }
                    if (list != null && list.size() > 0) {
                        this.f53958a.isFirstSearch = false;
                    }
                    this.f53958a.setSuggestListVisible();
                    this.f53958a.mListSearchSuggest.setAdapter((ListAdapter) this.f53958a.mSearchSuggestAdapter);
                    this.f53958a.mSearchSuggestAdapter.d(this.f53958a.mSearchKey.trim());
                    this.f53958a.mSearchSuggestAdapter.c(list);
                    this.f53958a.mSearchSuggestAdapter.notifyDataSetInvalidated();
                    return;
                }
                if (c.a.e.e.p.j.z() || !this.f53958a.hasRemindSearchResultForNet) {
                    SquareSearchActivity squareSearchActivity2 = this.f53958a;
                    squareSearchActivity2.showToast(squareSearchActivity2.getActivity().getString(R.string.neterror));
                }
                if (c.a.e.e.p.j.z()) {
                    return;
                }
                this.f53958a.hasRemindSearchResultForNet = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SquareSearchActivity f53959a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(SquareSearchActivity squareSearchActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53959a = squareSearchActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.f53959a.creatBar(customResponsedMessage.getData().toString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x implements LinearLayoutDetectsSoftKeyboard.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SquareSearchActivity f53960a;

        public x(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53960a = squareSearchActivity;
        }

        @Override // com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f53960a.mShouldShowKeyboard = z;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SquareSearchActivity f53961e;

        public y(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53961e = squareSearchActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 0) {
                    this.f53961e.parent.setFocusable(true);
                    this.f53961e.parent.setFocusableInTouchMode(true);
                    if (this.f53961e.mEditSearch.hasFocus()) {
                        c.a.e.e.p.l.x(this.f53961e.getPageContext().getPageActivity(), this.f53961e.mEditSearch);
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class z implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SquareSearchActivity f53962e;

        public z(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53962e = squareSearchActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                c.a.e.e.p.l.x(this.f53962e.getPageContext().getPageActivity(), this.f53962e.mScrollNoDataView);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    public SquareSearchActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mShouldShowKeyboard = true;
        this.searchHistoryiktems = new ArrayList();
        this.hasRemindSearchResultForNet = false;
        this.isFirstSearch = true;
        this.isNeedToShowSuggest = true;
        this.showKeyBoard = new k(this);
        this.mSuggestRunnble = new u(this);
        this.mSearchListListener = new v(this, CmdConfigHttp.CMD_SEARCH_LIST, 309438);
        this.mCreateBarListener = new w(this, 2001608);
        this.mBarDatalistener = new l(this, 2009002);
        this.mSearchTopicClickListener = new r(this);
        this.htmlLoadMessageListener = new t(this, 2921023);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkNetworkAbailableAndSetNetworkErrPrompt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, this)) == null) {
            if (!c.a.e.e.p.j.z()) {
                setViewVisible(this.mNoDataView);
                this.mNoDataView.setTextOption(NoDataViewFactory.e.a(R.string.neterror));
                return true;
            }
            setViewGone(this.mNoDataView);
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void creatBar(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65576, this, str) == null) {
            if (!c.a.e.e.p.j.z()) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealOnClickSearchData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65577, this) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSearch(String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65578, this, str, z2) == null) {
            if (!c.a.e.e.p.j.z()) {
                showToast(R.string.neterror);
            } else if (StringUtils.isNull(str)) {
            } else {
                if (z2) {
                    this.isNeedToShowSuggest = false;
                    this.mEditSearch.setText(str);
                    this.mEditSearch.setSelection(str.length());
                    this.isNeedToShowSuggest = true;
                }
                c.a.e.e.p.l.x(getPageContext().getPageActivity(), this.mEditSearch);
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
                k0.b(new s(this, str), null);
            }
        }
    }

    private void getLocalForumHistory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65579, this) == null) {
            this.search_result_webview.setVisibility(8);
            this.mListSearchSuggest.setVisibility(8);
            MessageManager.getInstance().sendMessage(new CustomMessage(2009002));
            if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
                loadFoucsBarData(true);
                setViewGone(this.mNoDataFocusBar);
                setViewGone(this.mScrollNoDataView);
            }
        }
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65580, this) == null) {
            LinearLayoutDetectsSoftKeyboard linearLayoutDetectsSoftKeyboard = (LinearLayoutDetectsSoftKeyboard) findViewById(R.id.parent);
            this.parent = linearLayoutDetectsSoftKeyboard;
            linearLayoutDetectsSoftKeyboard.setOnSoftKeyBoardShownListener(new x(this));
            this.parent.setOnTouchListener(new y(this));
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
                this.mScrollNoDataView.setOnTouchListener(new z(this));
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
            this.search_result_webview.setOnPageFinishedListener(new a0(this));
            this.search_result_webview.setOnReceivedErrorListener(new b0(this));
            this.search_result_webview.setOnReceivedSslErrorListener(new a(this));
            this.search_result_webview.setOnLoadUrlListener(new b(this));
            this.mEditSearch.setText("");
            this.mEditSearch.requestFocus();
            ShowSoftKeyPadDelay(this.mEditSearch, 200);
            initSearch();
            setForumSearchHint();
        }
    }

    private void initNavigationBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65581, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.mNavigationBar = navigationBar;
            View addCustomView = navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
            this.mSearchIcon = (ImageView) addCustomView.findViewById(R.id.search_bar_icon);
            this.mEditSearch = (EditText) addCustomView.findViewById(R.id.home_et_search);
            this.mButtonDel = (ImageView) addCustomView.findViewById(R.id.home_bt_search_del);
            this.mButtonCancelSearch = (TextView) addCustomView.findViewById(R.id.home_bt_search_cancel_s);
            this.mEditSearch.setOnFocusChangeListener(new c(this));
            this.mEditSearch.setOnClickListener(new d(this));
            this.mButtonCancelSearch.setText(getPageContext().getString(R.string.cancel));
            this.mButtonCancelSearch.setOnClickListener(new e(this));
            this.mEditSearch.setOnEditorActionListener(new f(this));
            this.mButtonDel.setOnClickListener(new g(this));
            this.mEditSearch.addTextChangedListener(new h(this));
        }
    }

    private void initSearchHistoryListView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65582, this) == null) {
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
    }

    private void initSearchSuggestListView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65583, this) == null) {
            this.mListSearchSuggest = (BdListView) findViewById(R.id.home_lv_search_suggest);
            this.mForumSuggestAdapter = new c.a.q0.t1.a(this, null);
            this.mSearchSuggestAdapter = new c.a.q0.t1.h.a(getPageContext().getPageActivity(), null);
            this.mListSearchSuggest.setOnItemClickListener(new i(this));
            this.mListSearchSuggest.setOnScrollListener(new j(this));
        }
    }

    private void initSearchTopicList() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65584, this) == null) && this.mSearchTopicViewHolder == null) {
            c.a.q0.t1.g gVar = new c.a.q0.t1.g(getPageContext());
            this.mSearchTopicViewHolder = gVar;
            this.search_history_linearlayout.addView(gVar.d());
        }
    }

    private void loadFoucsBarData(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65585, this, z2) == null) && TbadkCoreApplication.isLogin()) {
            if (z2) {
                MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(2001323, Boolean.TRUE));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(2001323, Boolean.FALSE));
        }
    }

    private void loadHotSearchCache() {
        HotSearchInfoData hotSearchInfoData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65586, this) == null) || (hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(c.a.p0.s.d0.b.j().p("hot_search_info", ""), HotSearchInfoData.class)) == null || hotSearchInfoData.getId() == 0) {
            return;
        }
        this.mHotSearchInfo = hotSearchInfoData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean navigateToHotSearch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65587, this)) == null) {
            HotSearchInfoData hotSearchInfoData = this.mHotSearchInfo;
            if (hotSearchInfoData == null) {
                return false;
            }
            if (hotSearchInfoData.x() == 0) {
                doSearch(this.mHotSearchInfo.getName(), false);
            } else if (this.mHotSearchInfo.x() == 1 && !c.a.p0.r0.b.b(getPageContext())) {
                sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
            }
            TiebaStatic.log(new StatisticItem("c10355").param("obj_name", this.mHotSearchInfo.getName()).param("obj_type", this.mHotSearchInfo.x() == 0 ? 2 : 1));
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65588, this) == null) {
            try {
                if (this.mModelSuggest != null) {
                    if (this.mModelSuggest.forum_list != null && this.mModelSuggest.forum_list.size() > 0) {
                        setSuggestListVisible();
                        this.mListSearchSuggest.setAdapter((ListAdapter) this.mForumSuggestAdapter);
                        this.mForumSuggestAdapter.e(this.mSearchKey);
                        this.mForumSuggestAdapter.d(this.mModelSuggest.forum_list);
                        this.mForumSuggestAdapter.notifyDataSetInvalidated();
                        return;
                    }
                    setViewGone(this.mScrollNoDataView);
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    private void requestSuggestList() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65589, this) == null) || StringUtils.isNull(this.mSearchKey)) {
            return;
        }
        SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
        searchListNetMessage.mKey = this.mSearchKey.trim();
        sendMessage(searchListNetMessage);
    }

    private void resetListSearchSuggest() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65590, this) == null) || (bdListView = this.mListSearchSuggest) == null) {
            return;
        }
        bdListView.setNextPage(null);
    }

    private void searchHistoryLayoutChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65591, this, i2) == null) {
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
    }

    private void setForumSearchHint() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65592, this) == null) {
            if (this.mHotSearchInfo == null) {
                this.mEditSearch.setHint(R.string.search_bar);
                return;
            }
            EditText editText = this.mEditSearch;
            editText.setHint(" " + UtilHelper.getFixedText(this.mHotSearchInfo.w(), 15));
        }
    }

    private void setHistoryListVisible() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65593, this) == null) {
            this.mListLayout.setVisibility(0);
            this.search_history_scrollview.setVisibility(0);
            this.mListSearchSuggest.setVisibility(8);
            this.search_result_webview.setVisibility(8);
            setViewGone(this.mScrollNoDataView);
            this.mNoDataView.setVisibility(8);
        }
    }

    private void setNoDataViewVisible() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65594, this) == null) {
            this.mListLayout.setVisibility(8);
            this.mListSearchSuggest.setVisibility(8);
            this.search_history_scrollview.setVisibility(8);
            this.search_result_webview.setVisibility(8);
            setViewVisible(this.mScrollNoDataView);
            this.mNoDataView.setVisibility(0);
            setViewVisible(this.mNoDataFocusBar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSuggestListVisible() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65595, this) == null) {
            this.mListLayout.setVisibility(0);
            this.mListSearchSuggest.setVisibility(0);
            this.search_history_scrollview.setVisibility(8);
            this.search_result_webview.setVisibility(8);
            setViewGone(this.mScrollNoDataView);
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewGone(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65596, this, view) == null) || view == null) {
            return;
        }
        view.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewVisible(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65597, this, view) == null) || view == null) {
            return;
        }
        view.setVisibility(0);
    }

    private boolean shouldShowNoDataView(ArrayList<String> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65598, this, arrayList)) == null) {
            if (arrayList == null || arrayList.isEmpty()) {
                List<c.a.q0.t1.c> list = this.mHotTopicList;
                return (list == null || list.size() <= 2) && this.isRequestHotForumData;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showClearHistoryDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65599, this) == null) {
            new c.a.p0.s.s.a(getPageContext().getPageActivity()).setMessage(getPageContext().getString(R.string.alert_clean_history)).setPositiveButton(getPageContext().getString(R.string.clear_all_text), new q(this)).setNegativeButton(getPageContext().getString(R.string.cancel), new p(this)).create(getPageContext()).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showHistoryResult(ArrayList<String> arrayList) {
        NoDataViewFactory.e a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65600, this, arrayList) == null) {
            if (shouldShowNoDataView(arrayList)) {
                setNoDataViewVisible();
                if (c.a.e.e.p.j.z()) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSuggest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65601, this) == null) {
            if (this.mSearchKey.trim().length() > 0) {
                requestSuggestList();
                return;
            }
            cancelAsyncTask();
            getLocalForumHistory();
        }
    }

    private void updateHotSearchCache(HotSearchInfoData hotSearchInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65602, this, hotSearchInfoData) == null) {
            if (hotSearchInfoData != null) {
                c.a.p0.s.d0.b.j().x("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
                return;
            }
            HotSearchInfoData hotSearchInfoData2 = new HotSearchInfoData();
            hotSearchInfoData2.setId(0L);
            hotSearchInfoData2.setName("");
            hotSearchInfoData2.z("");
            hotSearchInfoData2.A(0L);
            c.a.p0.s.d0.b.j().x("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData2));
        }
    }

    private void updateSearchHistory(ArrayList<String> arrayList) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65603, this, arrayList) == null) || (linearLayout = this.mSearchHistoryLayout) == null) {
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
                inflate2.setOnClickListener(new d0(this, str));
                ImageView imageView = (ImageView) inflate2.findViewById(R.id.del_search_history_btn);
                SkinManager.setImageResource(imageView, R.drawable.icn_shop_order_close);
                imageView.setOnClickListener(new m(this, str, inflate2, arrayList));
                this.searchHistoryiktems.add(inflate2);
                this.mSearchHistoryLayout.addView(inflate2, layoutParams2);
            }
        }
        View inflate3 = LayoutInflater.from(pageActivity).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.searchHistoryClearButton = inflate3;
        ((TextView) inflate3.findViewById(R.id.home_bt_search_footer)).setTextColor(SkinManager.getColor(R.color.CAM_X0302));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        this.searchHistoryClearButton.setOnClickListener(new n(this));
        this.mSearchHistoryLayout.addView(this.searchHistoryClearButton, layoutParams3);
    }

    private void updateSearchTopic(boolean z2, boolean z3) {
        c.a.q0.t1.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65604, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || (gVar = this.mSearchTopicViewHolder) == null) {
            return;
        }
        gVar.c();
        List<c.a.q0.t1.c> list = this.mHotTopicList;
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
                c.a.q0.t1.c cVar = (c.a.q0.t1.c) ListUtils.getItem(this.mHotTopicList, i2);
                if (cVar != null) {
                    this.mSearchTopicViewHolder.a(cVar, i2).setOnClickListener(this.mSearchTopicClickListener);
                }
            }
            this.mSearchTopicViewHolder.a(null, size).setOnClickListener(new o(this));
            this.mSearchTopicViewHolder.j();
        }
    }

    public void cancelAsyncTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mHandler.removeCallbacks(this.mSuggestRunnble);
            c0 c0Var = this.mSuggestTask;
            if (c0Var != null) {
                c0Var.cancel();
                this.mSuggestTask = null;
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!getIntent().getBooleanExtra("back_special", false)) {
                finish();
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                c.a.p0.s.a0.b.e(getPageContext().getPageActivity(), 1);
            } else {
                c.a.p0.s.a0.b.e(getPageContext().getPageActivity(), 2);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, c.a.p0.m0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "a026" : (String) invokeV.objValue;
    }

    public void initSearch() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
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
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            super.onChangeSkinType(i2);
            NoDataView noDataView = this.mNoDataView;
            if (noDataView != null) {
                noDataView.onChangeSkinType(getPageContext(), i2);
            }
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            getLayoutMode().k(i2 == 1);
            getLayoutMode().j(this.parent);
            SkinManager.setBgColor(this.parent, i2);
            c.a.q0.t1.a aVar = this.mForumSuggestAdapter;
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
            c.a.q0.t1.g gVar = this.mSearchTopicViewHolder;
            if (gVar != null) {
                gVar.f(i2);
            }
            searchHistoryLayoutChangeSkinType(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
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
                hotForumModel.H();
            }
            this.isRequestHotForumData = false;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            hideLoadingView(this.mMainLayout);
            this.mHandler.removeCallbacks(this.showKeyBoard);
            cancelAsyncTask();
        }
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.b
    public void onHotForumDataFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.isRequestHotForumData = true;
            this.mHotTopicList = new ArrayList();
            getLocalForumHistory();
        }
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.b
    public void onHotForumDataSuccess(List<c.a.q0.t1.b> list, List<c.a.q0.t1.c> list2, HotSearchInfoData hotSearchInfoData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, list2, hotSearchInfoData, str) == null) {
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
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i2, keyEvent)) == null) {
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
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onResourceRecycle();
            setSkinType(3);
            NoDataView noDataView = this.mNoDataView;
            if (noDataView != null) {
                noDataView.onActivityStop();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
        }
    }
}
