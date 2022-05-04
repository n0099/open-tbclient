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
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
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
import com.repackage.ad5;
import com.repackage.cm8;
import com.repackage.cr4;
import com.repackage.dd5;
import com.repackage.hc5;
import com.repackage.ic5;
import com.repackage.if7;
import com.repackage.jf7;
import com.repackage.kf7;
import com.repackage.kt4;
import com.repackage.mi;
import com.repackage.of7;
import com.repackage.oi;
import com.repackage.pf7;
import com.repackage.pg;
import com.repackage.qt4;
import com.repackage.sg;
import com.repackage.vt4;
import com.repackage.wa;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
@SuppressLint({"ResourceAsColor"})
@Deprecated
/* loaded from: classes3.dex */
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
    public if7 mForumSuggestAdapter;
    public HotForumModel mHotForumModel;
    public HotSearchInfoData mHotSearchInfo;
    public List<kf7> mHotTopicList;
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
    public wa mSearchListListener;
    public pf7 mSearchSuggestAdapter;
    public View.OnClickListener mSearchTopicClickListener;
    public of7 mSearchTopicViewHolder;
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

    /* loaded from: classes3.dex */
    public class a implements BaseWebView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareSearchActivity a;

        public a(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareSearchActivity;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.i
        public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, webView, sslErrorHandler, sslError) == null) || sslError == null) {
                return;
            }
            kt4.a("search", -1L, 0, "ReceivedSslError", 0, "", "requesturl", sslError.getUrl(), "receiveerror", sslError.toString());
        }
    }

    /* loaded from: classes3.dex */
    public class a0 implements BaseWebView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareSearchActivity a;

        public a0(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareSearchActivity;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) && this.a.isProgressBarShown()) {
                this.a.hideProgressBar();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements BaseWebView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareSearchActivity a;

        public b(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareSearchActivity;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, webView, str)) == null) ? UrlManager.getInstance().dealOneLinkWithOutJumpWebView(this.a.getPageContext(), new String[]{str}) != 3 : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b0 implements BaseWebView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareSearchActivity a;

        public b0(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareSearchActivity;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.h
        public void a(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, webView, i, str, str2) == null) {
                kt4.a("search", -1L, 0, "ReceivedError", 0, "", "requesturl", str2, "receiveerror", Integer.valueOf(i), "description", str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareSearchActivity a;

        public c(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareSearchActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (!z) {
                    oi.w(this.a.getPageContext().getPageActivity(), view2);
                } else {
                    this.a.dealOnClickSearchData();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c0 extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public String b;
        public BasicNameValuePair c;
        public final /* synthetic */ SquareSearchActivity d;

        public c0(SquareSearchActivity squareSearchActivity, String str, BasicNameValuePair basicNameValuePair, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity, str, basicNameValuePair, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = squareSearchActivity;
            this.a = null;
            this.b = null;
            this.c = null;
            this.b = str;
            this.c = basicNameValuePair;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ForumSuggestModel doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                ForumSuggestModel forumSuggestModel = null;
                if (mi.z()) {
                    try {
                        NetWork netWork = new NetWork(this.b);
                        this.a = netWork;
                        netWork.addPostData(this.c);
                        String postNetData = this.a.postNetData();
                        if (postNetData != null) {
                            forumSuggestModel = ForumSuggestModel.parserJson(postNetData);
                            this.d.lastSearchBarKey = this.c.getValue();
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
            return (ForumSuggestModel) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForumSuggestModel forumSuggestModel) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forumSuggestModel) == null) {
                SquareSearchActivity squareSearchActivity = this.d;
                squareSearchActivity.hideLoadingView(squareSearchActivity.mMainLayout);
                if (forumSuggestModel != null) {
                    SquareSearchActivity squareSearchActivity2 = this.d;
                    squareSearchActivity2.setViewGone(squareSearchActivity2.mNoDataView);
                    this.d.mModelSuggest = forumSuggestModel;
                    this.d.refresh();
                } else {
                    SquareSearchActivity squareSearchActivity3 = this.d;
                    squareSearchActivity3.setViewVisible(squareSearchActivity3.mNoDataView);
                    this.d.mNoDataView.setTextOption(NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f1389));
                }
                this.d.mSuggestTask = null;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                    this.a = null;
                }
                SquareSearchActivity squareSearchActivity = this.d;
                squareSearchActivity.hideLoadingView(squareSearchActivity.mMainLayout);
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.d.checkNetworkAbailableAndSetNetworkErrPrompt()) {
                return;
            }
            SquareSearchActivity squareSearchActivity = this.d;
            squareSearchActivity.setViewGone(squareSearchActivity.mNoDataView);
            SquareSearchActivity squareSearchActivity2 = this.d;
            squareSearchActivity2.showLoadingView(squareSearchActivity2.mMainLayout, true, this.d.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702a1));
            this.d.mListLayout.setVisibility(8);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareSearchActivity a;

        public d(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareSearchActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.dealOnClickSearchData();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public final /* synthetic */ SquareSearchActivity b;

        public d0(SquareSearchActivity squareSearchActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = squareSearchActivity;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || TextUtils.isEmpty(this.a)) {
                return;
            }
            this.b.mSearchKey = this.a;
            TiebaStatic.log(new StatisticItem("c12034"));
            this.b.doSearch(this.a, true);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareSearchActivity a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.finish();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareSearchActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                oi.w(this.a.getPageContext().getPageActivity(), this.a.mEditSearch);
                pg.a().postDelayed(new a(this), 200L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareSearchActivity a;

        public f(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareSearchActivity;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i, keyEvent)) == null) {
                if (i == 3) {
                    if (this.a.mSearchKey == null || this.a.mSearchKey.trim().length() < 1) {
                        oi.w(this.a.getPageContext().getPageActivity(), this.a.mEditSearch);
                        if (!this.a.navigateToHotSearch()) {
                            SquareSearchActivity squareSearchActivity = this.a;
                            squareSearchActivity.showToast(squareSearchActivity.getResources().getString(R.string.obfuscated_res_0x7f0f1589));
                        }
                    } else {
                        String trim = this.a.mEditSearch.getText().toString().trim();
                        if (!StringUtils.isNull(trim)) {
                            this.a.doSearch(trim, false);
                        } else {
                            SquareSearchActivity squareSearchActivity2 = this.a;
                            squareSearchActivity2.showToast(squareSearchActivity2.getResources().getString(R.string.obfuscated_res_0x7f0f1589));
                        }
                    }
                    return true;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareSearchActivity a;

        public g(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareSearchActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.mEditSearch.setText("");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareSearchActivity a;

        public h(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareSearchActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (this.a.isNeedToShowSuggest) {
                    this.a.mSearchKey = editable.toString();
                    if (StringUtils.isNull(this.a.mSearchKey)) {
                        this.a.isFirstSearch = true;
                    }
                    this.a.showSuggest();
                }
                if (editable.toString().trim().length() == 0) {
                    this.a.mButtonDel.setVisibility(8);
                } else {
                    this.a.mButtonDel.setVisibility(0);
                }
                SkinManager.setViewTextColor(this.a.mButtonCancelSearch, R.color.CAM_X0302, 1);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareSearchActivity a;

        public i(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareSearchActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            ListView listView;
            ListAdapter adapter;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || (listView = (ListView) adapterView) == null || (adapter = listView.getAdapter()) == null || adapter.getCount() == 0 || i >= adapter.getCount()) {
                return;
            }
            Object item = adapter.getItem(i);
            if (item instanceof String) {
                this.a.doSearch((String) item, true);
                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareSearchActivity a;

        public j(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareSearchActivity;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) {
                if (i == 2 || i == 1) {
                    oi.w(this.a.getPageContext().getPageActivity(), absListView);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareSearchActivity a;

        public k(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareSearchActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.mEditSearch.requestFocus();
                oi.L(this.a.getPageContext().getPageActivity(), this.a.mEditSearch);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareSearchActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(SquareSearchActivity squareSearchActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareSearchActivity;
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
                this.a.showHistoryResult((ArrayList) data);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ View b;
        public final /* synthetic */ ArrayList c;
        public final /* synthetic */ SquareSearchActivity d;

        /* loaded from: classes3.dex */
        public class a extends ad5<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m a;

            public a(m mVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = mVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.repackage.ad5
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    cm8.h(this.a.a);
                    return Boolean.TRUE;
                }
                return (Boolean) invokeV.objValue;
            }
        }

        /* loaded from: classes3.dex */
        public class b implements ic5<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m a;

            public b(m mVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = mVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.ic5
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    this.a.d.mSearchHistoryLayout.removeView(this.a.b);
                    m mVar = this.a;
                    mVar.c.remove(mVar.a);
                    if (this.a.c.size() <= 0) {
                        this.a.d.showHistoryResult(null);
                    }
                }
            }
        }

        public m(SquareSearchActivity squareSearchActivity, String str, View view2, ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity, str, view2, arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = squareSearchActivity;
            this.a = str;
            this.b = view2;
            this.c = arrayList;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                dd5.b(new a(this), new b(this));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareSearchActivity a;

        public n(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareSearchActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.showClearHistoryDialog();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareSearchActivity a;

        public o(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareSearchActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                oi.w(this.a.getPageContext().getPageActivity(), this.a.mEditSearch);
                if (hc5.b(this.a.getPageContext())) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(view2.getContext()).createNormalConfig("hotforum", "all")));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareSearchActivity a;

        public p(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareSearchActivity;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareSearchActivity a;

        /* loaded from: classes3.dex */
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    cm8.b();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareSearchActivity;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
                sg.a().b(new a(this));
                if (this.a.mHotTopicList != null && this.a.mHotTopicList.size() >= 2) {
                    this.a.showHistoryResult(null);
                    return;
                }
                SquareSearchActivity squareSearchActivity = this.a;
                squareSearchActivity.setViewVisible(squareSearchActivity.mScrollNoDataView);
                SquareSearchActivity squareSearchActivity2 = this.a;
                squareSearchActivity2.setViewVisible(squareSearchActivity2.mNoDataFocusBar);
                this.a.mListLayout.setVisibility(8);
                this.a.mNoDataView.setVisibility(0);
                this.a.mNoDataView.setTextOption(NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f1389));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareSearchActivity a;

        public r(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareSearchActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                oi.w(this.a.getPageContext().getPageActivity(), this.a.mEditSearch);
                if (view2.getTag() instanceof kf7) {
                    kf7 kf7Var = (kf7) view2.getTag();
                    TiebaStatic.log(new StatisticItem("c10363").param("obj_name", kf7Var.b()));
                    if (hc5.b(this.a.getPageContext())) {
                        return;
                    }
                    this.a.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.a.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(kf7Var.a()), kf7Var.b(), "4")));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class s extends ad5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ SquareSearchActivity b;

        public s(SquareSearchActivity squareSearchActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = squareSearchActivity;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.repackage.ad5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                cm8.o(this.a);
                return Boolean.TRUE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareSearchActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(SquareSearchActivity squareSearchActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareSearchActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921023 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (this.a.search_result_webview.getUrl() == null || !this.a.search_result_webview.getUrl().contains(str)) {
                    return;
                }
                SquareSearchActivity squareSearchActivity = this.a;
                squareSearchActivity.hideLoadingView(squareSearchActivity.mMainLayout);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class u implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareSearchActivity a;

        public u(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareSearchActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.checkNetworkAbailableAndSetNetworkErrPrompt()) {
                return;
            }
            try {
                if (this.a.mSearchKey == null || this.a.mSearchKey.length() <= 0) {
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer(30);
                stringBuffer.append(TbConfig.SERVER_ADDRESS);
                stringBuffer.append("c/f/forum/search");
                BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", this.a.mSearchKey.trim());
                this.a.cancelAsyncTask();
                this.a.mSuggestTask = new c0(this.a, stringBuffer.toString(), basicNameValuePair, true);
                this.a.mSuggestTask.setPriority(3);
                this.a.mSuggestTask.execute(stringBuffer.toString(), basicNameValuePair);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class v extends wa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareSearchActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(SquareSearchActivity squareSearchActivity, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareSearchActivity;
        }

        @Override // com.repackage.wa
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
                    if (this.a.isFirstSearch && responsedMessage.getError() != 0) {
                        SquareSearchActivity squareSearchActivity = this.a;
                        squareSearchActivity.showToast(squareSearchActivity.getActivity().getString(R.string.obfuscated_res_0x7f0f0c17));
                        return;
                    }
                    if (list != null && list.size() > 0) {
                        this.a.isFirstSearch = false;
                    }
                    this.a.setSuggestListVisible();
                    this.a.mListSearchSuggest.setAdapter((ListAdapter) this.a.mSearchSuggestAdapter);
                    this.a.mSearchSuggestAdapter.d(this.a.mSearchKey.trim());
                    this.a.mSearchSuggestAdapter.c(list);
                    this.a.mSearchSuggestAdapter.notifyDataSetInvalidated();
                    return;
                }
                if (mi.z() || !this.a.hasRemindSearchResultForNet) {
                    SquareSearchActivity squareSearchActivity2 = this.a;
                    squareSearchActivity2.showToast(squareSearchActivity2.getActivity().getString(R.string.obfuscated_res_0x7f0f0c17));
                }
                if (mi.z()) {
                    return;
                }
                this.a.hasRemindSearchResultForNet = true;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class w extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareSearchActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(SquareSearchActivity squareSearchActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareSearchActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.creatBar(customResponsedMessage.getData().toString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class x implements LinearLayoutDetectsSoftKeyboard.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareSearchActivity a;

        public x(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareSearchActivity;
        }

        @Override // com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.mShouldShowKeyboard = z;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class y implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareSearchActivity a;

        public y(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareSearchActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 0) {
                    this.a.parent.setFocusable(true);
                    this.a.parent.setFocusableInTouchMode(true);
                    if (this.a.mEditSearch.hasFocus()) {
                        oi.w(this.a.getPageContext().getPageActivity(), this.a.mEditSearch);
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class z implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareSearchActivity a;

        public z(SquareSearchActivity squareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareSearchActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                oi.w(this.a.getPageContext().getPageActivity(), this.a.mScrollNoDataView);
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
            if (!mi.z()) {
                setViewVisible(this.mNoDataView);
                this.mNoDataView.setTextOption(NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0c17));
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
            if (!mi.z()) {
                showToast(R.string.obfuscated_res_0x7f0f0c17);
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
            if (!mi.z()) {
                showToast(R.string.obfuscated_res_0x7f0f0c17);
            } else if (StringUtils.isNull(str)) {
            } else {
                if (z2) {
                    this.isNeedToShowSuggest = false;
                    this.mEditSearch.setText(str);
                    this.mEditSearch.setSelection(str.length());
                    this.isNeedToShowSuggest = true;
                }
                oi.w(getPageContext().getPageActivity(), this.mEditSearch);
                this.search_history_scrollview.setVisibility(8);
                this.mListSearchSuggest.setVisibility(8);
                this.search_result_webview.setVisibility(0);
                showProgressBarWithOffset(0, 0);
                String str2 = TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + "mo/q/hybrid/search?keyword=" + str;
                try {
                    str2 = TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + "mo/q/hybrid/search?keyword=" + URLEncoder.encode(str, IMAudioTransRequest.CHARSET);
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
                this.search_result_webview.loadUrl(str2);
                dd5.b(new s(this, str), null);
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
            LinearLayoutDetectsSoftKeyboard linearLayoutDetectsSoftKeyboard = (LinearLayoutDetectsSoftKeyboard) findViewById(R.id.obfuscated_res_0x7f091642);
            this.parent = linearLayoutDetectsSoftKeyboard;
            linearLayoutDetectsSoftKeyboard.setOnSoftKeyBoardShownListener(new x(this));
            this.parent.setOnTouchListener(new y(this));
            initNavigationBar();
            this.mMainLayout = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f090aaf);
            NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f070270)), null, null);
            this.mNoDataView = a2;
            if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
                ScrollView scrollView = (ScrollView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d03a1, (ViewGroup) null);
                this.mScrollNoDataView = scrollView;
                LinearLayout linearLayout = (LinearLayout) scrollView.findViewById(R.id.obfuscated_res_0x7f0909f3);
                this.mNoDataFocusBar = (SearchPageFocusBar) linearLayout.findViewById(R.id.obfuscated_res_0x7f09157e);
                linearLayout.addView(this.mNoDataView, 0);
                this.mScrollNoDataView.setOnTouchListener(new z(this));
                FrameLayout frameLayout = this.mMainLayout;
                frameLayout.addView(this.mScrollNoDataView, frameLayout.getChildCount());
            } else {
                this.mMainLayout.addView(a2, 0);
            }
            this.mListLayout = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f090d8f);
            loadHotSearchCache();
            initSearchHistoryListView();
            initSearchTopicList();
            initSearchSuggestListView();
            BaseWebView baseWebView = (BaseWebView) findViewById(R.id.obfuscated_res_0x7f091c34);
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
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0923ad);
            this.mNavigationBar = navigationBar;
            View addCustomView = navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.obfuscated_res_0x7f0d07a4, (View.OnClickListener) null);
            this.mSearchIcon = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f091c0c);
            this.mEditSearch = (EditText) addCustomView.findViewById(R.id.obfuscated_res_0x7f090d7e);
            this.mButtonDel = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f090d6e);
            this.mButtonCancelSearch = (TextView) addCustomView.findViewById(R.id.obfuscated_res_0x7f090d6d);
            this.mEditSearch.setOnFocusChangeListener(new c(this));
            this.mEditSearch.setOnClickListener(new d(this));
            this.mButtonCancelSearch.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f036e));
            this.mButtonCancelSearch.setOnClickListener(new e(this));
            this.mEditSearch.setOnEditorActionListener(new f(this));
            this.mButtonDel.setOnClickListener(new g(this));
            this.mEditSearch.addTextChangedListener(new h(this));
        }
    }

    private void initSearchHistoryListView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65582, this) == null) {
            this.search_history_scrollview = (ScrollView) findViewById(R.id.obfuscated_res_0x7f091c23);
            this.search_history_linearlayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091c22);
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
            this.mListSearchSuggest = (BdListView) findViewById(R.id.obfuscated_res_0x7f090d87);
            this.mForumSuggestAdapter = new if7(this, null);
            this.mSearchSuggestAdapter = new pf7(getPageContext().getPageActivity(), null);
            this.mListSearchSuggest.setOnItemClickListener(new i(this));
            this.mListSearchSuggest.setOnScrollListener(new j(this));
        }
    }

    private void initSearchTopicList() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65584, this) == null) && this.mSearchTopicViewHolder == null) {
            of7 of7Var = new of7(getPageContext());
            this.mSearchTopicViewHolder = of7Var;
            this.search_history_linearlayout.addView(of7Var.d());
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
        if (!(interceptable == null || interceptable.invokeV(65586, this) == null) || (hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(vt4.k().q("hot_search_info", ""), HotSearchInfoData.class)) == null || hotSearchInfoData.getId() == 0) {
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
            if (hotSearchInfoData.getType() == 0) {
                doSearch(this.mHotSearchInfo.getName(), false);
            } else if (this.mHotSearchInfo.getType() == 1 && !hc5.b(getPageContext())) {
                sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
            }
            TiebaStatic.log(new StatisticItem("c10355").param("obj_name", this.mHotSearchInfo.getName()).param("obj_type", this.mHotSearchInfo.getType() == 0 ? 2 : 1));
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
            View view2 = this.searchHistoryClearButton;
            if (view2 != null) {
                ((TextView) view2.findViewById(R.id.obfuscated_res_0x7f090d6f)).setTextColor(SkinManager.getColor(R.color.CAM_X0302));
            }
            List<View> list = this.searchHistoryiktems;
            if (list != null) {
                for (View view3 : list) {
                    SkinManager.setViewTextColor((TextView) view3.findViewById(R.id.obfuscated_res_0x7f090d86), R.color.CAM_X0105, 1);
                    view3.findViewById(R.id.obfuscated_res_0x7f090d7d).setBackgroundColor(SkinManager.getColor(R.color.CAM_X0204));
                    SkinManager.setBackgroundResource(view3, R.drawable.addresslist_item_bg);
                }
            }
        }
    }

    private void setForumSearchHint() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65592, this) == null) {
            if (this.mHotSearchInfo == null) {
                this.mEditSearch.setHint(R.string.obfuscated_res_0x7f0f1094);
                return;
            }
            EditText editText = this.mEditSearch;
            editText.setHint(" " + UtilHelper.getFixedText(this.mHotSearchInfo.y(), 15));
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
    public void setViewGone(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65596, this, view2) == null) || view2 == null) {
            return;
        }
        view2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewVisible(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65597, this, view2) == null) || view2 == null) {
            return;
        }
        view2.setVisibility(0);
    }

    private boolean shouldShowNoDataView(ArrayList<String> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65598, this, arrayList)) == null) {
            if (arrayList == null || arrayList.isEmpty()) {
                List<kf7> list = this.mHotTopicList;
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
            new cr4(getPageContext().getPageActivity()).setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f0254)).setPositiveButton(getPageContext().getString(R.string.obfuscated_res_0x7f0f03d3), new q(this)).setNegativeButton(getPageContext().getString(R.string.obfuscated_res_0x7f0f036e), new p(this)).create(getPageContext()).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showHistoryResult(ArrayList<String> arrayList) {
        NoDataViewFactory.e a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65600, this, arrayList) == null) {
            if (shouldShowNoDataView(arrayList)) {
                setNoDataViewVisible();
                if (mi.z()) {
                    a2 = NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f1389);
                } else {
                    a2 = NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0c17);
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
                vt4.k().y("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
                return;
            }
            HotSearchInfoData hotSearchInfoData2 = new HotSearchInfoData();
            hotSearchInfoData2.setId(0L);
            hotSearchInfoData2.setName("");
            hotSearchInfoData2.A("");
            hotSearchInfoData2.B(0L);
            vt4.k().y("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData2));
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
        View inflate = LayoutInflater.from(pageActivity).inflate(R.layout.obfuscated_res_0x7f0d07a5, (ViewGroup) null);
        this.searchHistoryView = inflate;
        inflate.findViewById(R.id.obfuscated_res_0x7f092019).setVisibility(8);
        getLayoutMode().j(this.searchHistoryView);
        this.mSearchHistoryLayout.addView(this.searchHistoryView, layoutParams);
        int size = arrayList.size();
        this.searchHistoryiktems.clear();
        for (int i2 = 0; i2 < size; i2++) {
            String str = arrayList.get(i2);
            if (!TextUtils.isEmpty(str)) {
                View inflate2 = LayoutInflater.from(pageActivity).inflate(R.layout.obfuscated_res_0x7f0d0398, (ViewGroup) null);
                ((TextView) inflate2.findViewById(R.id.obfuscated_res_0x7f090d86)).setText(str);
                SkinManager.setViewTextColor((TextView) inflate2.findViewById(R.id.obfuscated_res_0x7f090d86), R.color.CAM_X0105, 1);
                inflate2.findViewById(R.id.obfuscated_res_0x7f090d7d).setVisibility(8);
                SkinManager.setBackgroundResource(inflate2, R.drawable.square_search_item_bg);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                inflate2.setOnClickListener(new d0(this, str));
                ImageView imageView = (ImageView) inflate2.findViewById(R.id.obfuscated_res_0x7f090775);
                SkinManager.setImageResource(imageView, R.drawable.icn_shop_order_close);
                imageView.setOnClickListener(new m(this, str, inflate2, arrayList));
                this.searchHistoryiktems.add(inflate2);
                this.mSearchHistoryLayout.addView(inflate2, layoutParams2);
            }
        }
        View inflate3 = LayoutInflater.from(pageActivity).inflate(R.layout.obfuscated_res_0x7f0d0397, (ViewGroup) null);
        this.searchHistoryClearButton = inflate3;
        ((TextView) inflate3.findViewById(R.id.obfuscated_res_0x7f090d6f)).setTextColor(SkinManager.getColor(R.color.CAM_X0302));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        this.searchHistoryClearButton.setOnClickListener(new n(this));
        this.mSearchHistoryLayout.addView(this.searchHistoryClearButton, layoutParams3);
    }

    private void updateSearchTopic(boolean z2, boolean z3) {
        of7 of7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65604, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || (of7Var = this.mSearchTopicViewHolder) == null) {
            return;
        }
        of7Var.c();
        List<kf7> list = this.mHotTopicList;
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
                kf7 kf7Var = (kf7) ListUtils.getItem(this.mHotTopicList, i2);
                if (kf7Var != null) {
                    this.mSearchTopicViewHolder.a(kf7Var, i2).setOnClickListener(this.mSearchTopicClickListener);
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
                qt4.e(getPageContext().getPageActivity(), 1);
            } else {
                qt4.e(getPageContext().getPageActivity(), 2);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.repackage.v75
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "a026" : (String) invokeV.objValue;
    }

    public void initSearch() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mButtonCancelSearch.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f036e));
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
                noDataView.f(getPageContext(), i2);
            }
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            getLayoutMode().k(i2 == 1);
            getLayoutMode().j(this.parent);
            SkinManager.setBgColor(this.parent, i2);
            if7 if7Var = this.mForumSuggestAdapter;
            if (if7Var != null) {
                if7Var.notifyDataSetChanged();
            }
            if (i2 == 2) {
                this.mEditSearch.setHintTextColor(SkinManager.getColor(R.color.s_navbar_title_color));
            } else {
                this.mEditSearch.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mButtonDel, R.drawable.obfuscated_res_0x7f080989, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SkinManager.setNavbarTitleColor(this.mEditSearch, R.color.CAM_X0105, R.color.s_navbar_title_color);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mSearchIcon, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
            SkinManager.setBackgroundResource(this.mMainLayout, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.mButtonCancelSearch, R.color.CAM_X0302, 1);
            of7 of7Var = this.mSearchTopicViewHolder;
            if (of7Var != null) {
                of7Var.f(i2);
            }
            searchHistoryLayoutChangeSkinType(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0396);
            init();
            getWindow().setSoftInputMode(1);
            registerListener(this.mBarDatalistener);
            registerListener(this.mSearchListListener);
            registerListener(this.mCreateBarListener);
            registerListener(this.htmlLoadMessageListener);
            if (SquareSearchActivityConfig.IS_SHOW_RECOMMEND_FORUM) {
                HotForumModel hotForumModel = new HotForumModel(getPageContext(), this);
                this.mHotForumModel = hotForumModel;
                hotForumModel.J();
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
    public void onHotForumDataSuccess(List<jf7> list, List<kf7> list2, HotSearchInfoData hotSearchInfoData, String str) {
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
                noDataView.e();
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
