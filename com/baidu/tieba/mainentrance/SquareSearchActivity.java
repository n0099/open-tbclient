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
import com.repackage.cf7;
import com.repackage.cr4;
import com.repackage.de5;
import com.repackage.df7;
import com.repackage.ef7;
import com.repackage.he5;
import com.repackage.id5;
import com.repackage.if7;
import com.repackage.jd5;
import com.repackage.jf7;
import com.repackage.mt4;
import com.repackage.ni;
import com.repackage.oj8;
import com.repackage.pi;
import com.repackage.qg;
import com.repackage.st4;
import com.repackage.tg;
import com.repackage.xt4;
import com.repackage.za;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
@SuppressLint({"ResourceAsColor"})
@Deprecated
/* loaded from: classes3.dex */
public class SquareSearchActivity extends BaseActivity<SquareSearchActivity> implements HotForumModel.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public ScrollView B;
    public SearchPageFocusBar C;
    public View D;
    public View E;
    public List<View> F;
    public boolean G;
    public boolean H;
    public boolean I;
    public Runnable J;
    public final Runnable K;
    public za L;
    public CustomMessageListener M;
    public CustomMessageListener N;
    public View.OnClickListener O;
    public CustomMessageListener P;
    public LinearLayoutDetectsSoftKeyboard a;
    public FrameLayout b;
    public FrameLayout c;
    public NavigationBar d;
    public EditText e;
    public ImageView f;
    public TextView g;
    public ImageView h;
    public NoDataView i;
    public BaseWebView j;
    public ScrollView k;
    public LinearLayout l;
    public List<ef7> m;
    public String n;
    public HotSearchInfoData o;
    public if7 p;
    public LinearLayout q;
    public BdListView r;
    public cf7 s;
    public jf7 t;
    public HotForumModel u;
    public ForumSuggestModel v;
    public c0 w;
    public String x;
    public String y;
    public boolean z;

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
            mt4.a("search", -1L, 0, "ReceivedSslError", 0, "", "requesturl", sslError.getUrl(), "receiveerror", sslError.toString());
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
                mt4.a("search", -1L, 0, "ReceivedError", 0, "", "requesturl", str2, "receiveerror", Integer.valueOf(i), "description", str);
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
                    pi.x(this.a.getPageContext().getPageActivity(), view2);
                } else {
                    this.a.p2();
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
                if (ni.z()) {
                    try {
                        NetWork netWork = new NetWork(this.b);
                        this.a = netWork;
                        netWork.addPostData(this.c);
                        String postNetData = this.a.postNetData();
                        if (postNetData != null) {
                            forumSuggestModel = ForumSuggestModel.parserJson(postNetData);
                            this.d.y = this.c.getValue();
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
                squareSearchActivity.hideLoadingView(squareSearchActivity.b);
                if (forumSuggestModel != null) {
                    SquareSearchActivity squareSearchActivity2 = this.d;
                    squareSearchActivity2.H2(squareSearchActivity2.i);
                    this.d.v = forumSuggestModel;
                    this.d.refresh();
                } else {
                    SquareSearchActivity squareSearchActivity3 = this.d;
                    squareSearchActivity3.I2(squareSearchActivity3.i);
                    this.d.i.setTextOption(NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f13c3));
                }
                this.d.w = null;
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
                squareSearchActivity.hideLoadingView(squareSearchActivity.b);
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.d.n2()) {
                return;
            }
            SquareSearchActivity squareSearchActivity = this.d;
            squareSearchActivity.H2(squareSearchActivity.i);
            SquareSearchActivity squareSearchActivity2 = this.d;
            squareSearchActivity2.showLoadingView(squareSearchActivity2.b, true, this.d.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702a0));
            this.d.c.setVisibility(8);
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
                this.a.p2();
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
            this.b.x = this.a;
            TiebaStatic.log(new StatisticItem("c12034"));
            this.b.q2(this.a, true);
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
                pi.x(this.a.getPageContext().getPageActivity(), this.a.e);
                qg.a().postDelayed(new a(this), 200L);
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
                    if (this.a.x == null || this.a.x.trim().length() < 1) {
                        pi.x(this.a.getPageContext().getPageActivity(), this.a.e);
                        if (!this.a.z2()) {
                            SquareSearchActivity squareSearchActivity = this.a;
                            squareSearchActivity.showToast(squareSearchActivity.getResources().getString(R.string.obfuscated_res_0x7f0f15d9));
                        }
                    } else {
                        String trim = this.a.e.getText().toString().trim();
                        if (!StringUtils.isNull(trim)) {
                            this.a.q2(trim, false);
                        } else {
                            SquareSearchActivity squareSearchActivity2 = this.a;
                            squareSearchActivity2.showToast(squareSearchActivity2.getResources().getString(R.string.obfuscated_res_0x7f0f15d9));
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
                this.a.e.setText("");
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
                if (this.a.I) {
                    this.a.x = editable.toString();
                    if (StringUtils.isNull(this.a.x)) {
                        this.a.H = true;
                    }
                    this.a.M2();
                }
                if (editable.toString().trim().length() == 0) {
                    this.a.f.setVisibility(8);
                } else {
                    this.a.f.setVisibility(0);
                }
                SkinManager.setViewTextColor(this.a.g, R.color.CAM_X0302, 1);
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
                this.a.q2((String) item, true);
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
                    pi.x(this.a.getPageContext().getPageActivity(), absListView);
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
                this.a.e.requestFocus();
                pi.M(this.a.getPageContext().getPageActivity(), this.a.e);
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
                this.a.L2((ArrayList) data);
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
        public class a extends de5<Boolean> {
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
            @Override // com.repackage.de5
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    oj8.h(this.a.a);
                    return Boolean.TRUE;
                }
                return (Boolean) invokeV.objValue;
            }
        }

        /* loaded from: classes3.dex */
        public class b implements jd5<Boolean> {
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
            @Override // com.repackage.jd5
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    this.a.d.q.removeView(this.a.b);
                    m mVar = this.a;
                    mVar.c.remove(mVar.a);
                    if (this.a.c.size() <= 0) {
                        this.a.d.L2(null);
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
                he5.b(new a(this), new b(this));
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
                this.a.K2();
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
                pi.x(this.a.getPageContext().getPageActivity(), this.a.e);
                if (id5.b(this.a.getPageContext())) {
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
                    oj8.b();
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
                tg.a().b(new a(this));
                if (this.a.m != null && this.a.m.size() >= 2) {
                    this.a.L2(null);
                    return;
                }
                SquareSearchActivity squareSearchActivity = this.a;
                squareSearchActivity.I2(squareSearchActivity.B);
                SquareSearchActivity squareSearchActivity2 = this.a;
                squareSearchActivity2.I2(squareSearchActivity2.C);
                this.a.c.setVisibility(8);
                this.a.i.setVisibility(0);
                this.a.i.setTextOption(NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f13c3));
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
                pi.x(this.a.getPageContext().getPageActivity(), this.a.e);
                if (view2.getTag() instanceof ef7) {
                    ef7 ef7Var = (ef7) view2.getTag();
                    TiebaStatic.log(new StatisticItem("c10363").param("obj_name", ef7Var.b()));
                    if (id5.b(this.a.getPageContext())) {
                        return;
                    }
                    this.a.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.a.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(ef7Var.a()), ef7Var.b(), "4")));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class s extends de5<Boolean> {
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
        @Override // com.repackage.de5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                oj8.o(this.a);
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
                if (this.a.j.getUrl() == null || !this.a.j.getUrl().contains(str)) {
                    return;
                }
                SquareSearchActivity squareSearchActivity = this.a;
                squareSearchActivity.hideLoadingView(squareSearchActivity.b);
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.n2()) {
                return;
            }
            try {
                if (this.a.x == null || this.a.x.length() <= 0) {
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer(30);
                stringBuffer.append(TbConfig.SERVER_ADDRESS);
                stringBuffer.append("c/f/forum/search");
                BasicNameValuePair basicNameValuePair = new BasicNameValuePair("query", this.a.x.trim());
                this.a.m2();
                this.a.w = new c0(this.a, stringBuffer.toString(), basicNameValuePair, true);
                this.a.w.setPriority(3);
                this.a.w.execute(stringBuffer.toString(), basicNameValuePair);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class v extends za {
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

        @Override // com.repackage.za
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
                    if (this.a.H && responsedMessage.getError() != 0) {
                        SquareSearchActivity squareSearchActivity = this.a;
                        squareSearchActivity.showToast(squareSearchActivity.getActivity().getString(R.string.obfuscated_res_0x7f0f0c2b));
                        return;
                    }
                    if (list != null && list.size() > 0) {
                        this.a.H = false;
                    }
                    this.a.G2();
                    this.a.r.setAdapter((ListAdapter) this.a.t);
                    this.a.t.d(this.a.x.trim());
                    this.a.t.c(list);
                    this.a.t.notifyDataSetInvalidated();
                    return;
                }
                if (ni.z() || !this.a.G) {
                    SquareSearchActivity squareSearchActivity2 = this.a;
                    squareSearchActivity2.showToast(squareSearchActivity2.getActivity().getString(R.string.obfuscated_res_0x7f0f0c2b));
                }
                if (ni.z()) {
                    return;
                }
                this.a.G = true;
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
                this.a.o2(customResponsedMessage.getData().toString());
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
                this.a.A = z;
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
                    this.a.a.setFocusable(true);
                    this.a.a.setFocusableInTouchMode(true);
                    if (this.a.e.hasFocus()) {
                        pi.x(this.a.getPageContext().getPageActivity(), this.a.e);
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
                pi.x(this.a.getPageContext().getPageActivity(), this.a.B);
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
        this.F = new ArrayList();
        this.G = false;
        this.H = true;
        this.I = true;
        this.J = new k(this);
        this.K = new u(this);
        this.L = new v(this, CmdConfigHttp.CMD_SEARCH_LIST, 309438);
        this.M = new w(this, 2001608);
        this.N = new l(this, 2009002);
        this.O = new r(this);
        this.P = new t(this, 2921023);
    }

    public final void A2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || StringUtils.isNull(this.x)) {
            return;
        }
        SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
        searchListNetMessage.mKey = this.x.trim();
        sendMessage(searchListNetMessage);
    }

    public final void B2() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdListView = this.r) == null) {
            return;
        }
        bdListView.setNextPage(null);
    }

    public final void C2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            LinearLayout linearLayout = this.q;
            if (linearLayout != null) {
                linearLayout.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            }
            if (this.D != null) {
                getLayoutMode().j(this.D);
            }
            View view2 = this.E;
            if (view2 != null) {
                ((TextView) view2.findViewById(R.id.obfuscated_res_0x7f090d20)).setTextColor(SkinManager.getColor(R.color.CAM_X0302));
            }
            List<View> list = this.F;
            if (list != null) {
                for (View view3 : list) {
                    SkinManager.setViewTextColor((TextView) view3.findViewById(R.id.obfuscated_res_0x7f090d37), R.color.CAM_X0105, 1);
                    view3.findViewById(R.id.obfuscated_res_0x7f090d2e).setBackgroundColor(SkinManager.getColor(R.color.CAM_X0204));
                    SkinManager.setBackgroundResource(view3, R.drawable.addresslist_item_bg);
                }
            }
        }
    }

    public final void D2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.o == null) {
                this.e.setHint(R.string.obfuscated_res_0x7f0f10be);
                return;
            }
            EditText editText = this.e;
            editText.setHint(" " + UtilHelper.getFixedText(this.o.A(), 15));
        }
    }

    public final void E2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.c.setVisibility(0);
            this.k.setVisibility(0);
            this.r.setVisibility(8);
            this.j.setVisibility(8);
            H2(this.B);
            this.i.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.b
    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.z = true;
            this.m = new ArrayList();
            r2();
        }
    }

    public final void F2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.c.setVisibility(8);
            this.r.setVisibility(8);
            this.k.setVisibility(8);
            this.j.setVisibility(8);
            I2(this.B);
            this.i.setVisibility(0);
            I2(this.C);
        }
    }

    public final void G2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.c.setVisibility(0);
            this.r.setVisibility(0);
            this.k.setVisibility(8);
            this.j.setVisibility(8);
            H2(this.B);
            this.i.setVisibility(8);
        }
    }

    public final void H2(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) || view2 == null) {
            return;
        }
        view2.setVisibility(8);
    }

    public final void I2(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, view2) == null) || view2 == null) {
            return;
        }
        view2.setVisibility(0);
    }

    public final boolean J2(ArrayList<String> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, arrayList)) == null) {
            if (arrayList == null || arrayList.isEmpty()) {
                List<ef7> list = this.m;
                return (list == null || list.size() <= 2) && this.z;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void K2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            new cr4(getPageContext().getPageActivity()).setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f0259)).setPositiveButton(getPageContext().getString(R.string.obfuscated_res_0x7f0f03d3), new q(this)).setNegativeButton(getPageContext().getString(R.string.obfuscated_res_0x7f0f036a), new p(this)).create(getPageContext()).show();
        }
    }

    public final void L2(ArrayList<String> arrayList) {
        NoDataViewFactory.e a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, arrayList) == null) {
            if (J2(arrayList)) {
                F2();
                if (ni.z()) {
                    a2 = NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f13c3);
                } else {
                    a2 = NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0c2b);
                }
                this.i.setTextOption(a2);
                return;
            }
            E2();
            O2(arrayList);
            P2(true, arrayList == null || arrayList.size() == 0);
            D2();
        }
    }

    public final void M2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.x.trim().length() > 0) {
                A2();
                return;
            }
            m2();
            r2();
        }
    }

    public final void N2(HotSearchInfoData hotSearchInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, hotSearchInfoData) == null) {
            if (hotSearchInfoData != null) {
                xt4.k().y("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
                return;
            }
            HotSearchInfoData hotSearchInfoData2 = new HotSearchInfoData();
            hotSearchInfoData2.setId(0L);
            hotSearchInfoData2.setName("");
            hotSearchInfoData2.C("");
            hotSearchInfoData2.D(0L);
            xt4.k().y("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData2));
        }
    }

    public final void O2(ArrayList<String> arrayList) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, arrayList) == null) || (linearLayout = this.q) == null) {
            return;
        }
        linearLayout.removeAllViews();
        if (arrayList == null || arrayList.isEmpty() || getActivity() == null) {
            return;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        View inflate = LayoutInflater.from(pageActivity).inflate(R.layout.obfuscated_res_0x7f0d07ad, (ViewGroup) null);
        this.D = inflate;
        inflate.findViewById(R.id.obfuscated_res_0x7f0920c2).setVisibility(8);
        getLayoutMode().j(this.D);
        this.q.addView(this.D, layoutParams);
        int size = arrayList.size();
        this.F.clear();
        for (int i2 = 0; i2 < size; i2++) {
            String str = arrayList.get(i2);
            if (!TextUtils.isEmpty(str)) {
                View inflate2 = LayoutInflater.from(pageActivity).inflate(R.layout.obfuscated_res_0x7f0d0388, (ViewGroup) null);
                ((TextView) inflate2.findViewById(R.id.obfuscated_res_0x7f090d37)).setText(str);
                SkinManager.setViewTextColor((TextView) inflate2.findViewById(R.id.obfuscated_res_0x7f090d37), R.color.CAM_X0105, 1);
                inflate2.findViewById(R.id.obfuscated_res_0x7f090d2e).setVisibility(8);
                SkinManager.setBackgroundResource(inflate2, R.drawable.square_search_item_bg);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                inflate2.setOnClickListener(new d0(this, str));
                ImageView imageView = (ImageView) inflate2.findViewById(R.id.obfuscated_res_0x7f090748);
                SkinManager.setImageResource(imageView, R.drawable.icn_shop_order_close);
                imageView.setOnClickListener(new m(this, str, inflate2, arrayList));
                this.F.add(inflate2);
                this.q.addView(inflate2, layoutParams2);
            }
        }
        View inflate3 = LayoutInflater.from(pageActivity).inflate(R.layout.obfuscated_res_0x7f0d0387, (ViewGroup) null);
        this.E = inflate3;
        ((TextView) inflate3.findViewById(R.id.obfuscated_res_0x7f090d20)).setTextColor(SkinManager.getColor(R.color.CAM_X0302));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        this.E.setOnClickListener(new n(this));
        this.q.addView(this.E, layoutParams3);
    }

    public final void P2(boolean z2, boolean z3) {
        if7 if7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || (if7Var = this.p) == null) {
            return;
        }
        if7Var.c();
        List<ef7> list = this.m;
        if (list == null || list.isEmpty() || !z2) {
            return;
        }
        this.p.i(!z3);
        this.p.h(this.n);
        int size = this.m.size();
        if (size >= 1) {
            if (size > 7) {
                size = 7;
            }
            if (size % 2 == 0) {
                size--;
            }
            for (int i2 = 0; i2 < size; i2++) {
                ef7 ef7Var = (ef7) ListUtils.getItem(this.m, i2);
                if (ef7Var != null) {
                    this.p.a(ef7Var, i2).setOnClickListener(this.O);
                }
            }
            this.p.a(null, size).setOnClickListener(new o(this));
            this.p.j();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (!getIntent().getBooleanExtra("back_special", false)) {
                finish();
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                st4.e(getPageContext().getPageActivity(), 1);
            } else {
                st4.e(getPageContext().getPageActivity(), 2);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.repackage.v85
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? "a026" : (String) invokeV.objValue;
    }

    public final void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            LinearLayoutDetectsSoftKeyboard linearLayoutDetectsSoftKeyboard = (LinearLayoutDetectsSoftKeyboard) findViewById(R.id.obfuscated_res_0x7f0916ba);
            this.a = linearLayoutDetectsSoftKeyboard;
            linearLayoutDetectsSoftKeyboard.setOnSoftKeyBoardShownListener(new x(this));
            this.a.setOnTouchListener(new y(this));
            s2();
            this.b = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f090a82);
            NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07026e)), null, null);
            this.i = a2;
            if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
                ScrollView scrollView = (ScrollView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0391, (ViewGroup) null);
                this.B = scrollView;
                LinearLayout linearLayout = (LinearLayout) scrollView.findViewById(R.id.obfuscated_res_0x7f0909cc);
                this.C = (SearchPageFocusBar) linearLayout.findViewById(R.id.obfuscated_res_0x7f0915f6);
                linearLayout.addView(this.i, 0);
                this.B.setOnTouchListener(new z(this));
                FrameLayout frameLayout = this.b;
                frameLayout.addView(this.B, frameLayout.getChildCount());
            } else {
                this.b.addView(a2, 0);
            }
            this.c = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f090d42);
            y2();
            u2();
            w2();
            v2();
            BaseWebView baseWebView = (BaseWebView) findViewById(R.id.obfuscated_res_0x7f091cc7);
            this.j = baseWebView;
            baseWebView.initCommonJsBridge(getPageContext().getPageActivity());
            this.j.setOnPageFinishedListener(new a0(this));
            this.j.setOnReceivedErrorListener(new b0(this));
            this.j.setOnReceivedSslErrorListener(new a(this));
            this.j.setOnLoadUrlListener(new b(this));
            this.e.setText("");
            this.e.requestFocus();
            ShowSoftKeyPadDelay(this.e, 200);
            t2();
            D2();
        }
    }

    public void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.mHandler.removeCallbacks(this.K);
            c0 c0Var = this.w;
            if (c0Var != null) {
                c0Var.cancel();
                this.w = null;
            }
        }
    }

    public final boolean n2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (!ni.z()) {
                I2(this.i);
                this.i.setTextOption(NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0c2b));
                return true;
            }
            H2(this.i);
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void o2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            if (!ni.z()) {
                showToast(R.string.obfuscated_res_0x7f0f0c2b);
            } else if (StringUtils.isNull(str)) {
            } else {
                if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                    TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11013)));
                } else {
                    sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), str)));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            super.onChangeSkinType(i2);
            NoDataView noDataView = this.i;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i2);
            }
            this.d.onChangeSkinType(getPageContext(), i2);
            getLayoutMode().k(i2 == 1);
            getLayoutMode().j(this.a);
            SkinManager.setBgColor(this.a, i2);
            cf7 cf7Var = this.s;
            if (cf7Var != null) {
                cf7Var.notifyDataSetChanged();
            }
            if (i2 == 2) {
                this.e.setHintTextColor(SkinManager.getColor(R.color.s_navbar_title_color));
            } else {
                this.e.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.obfuscated_res_0x7f08099e, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SkinManager.setNavbarTitleColor(this.e, R.color.CAM_X0105, R.color.s_navbar_title_color);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.h, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
            SkinManager.setBackgroundResource(this.b, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.g, R.color.CAM_X0302, 1);
            if7 if7Var = this.p;
            if (if7Var != null) {
                if7Var.f(i2);
            }
            C2(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0386);
            init();
            getWindow().setSoftInputMode(1);
            registerListener(this.N);
            registerListener(this.L);
            registerListener(this.M);
            registerListener(this.P);
            if (SquareSearchActivityConfig.IS_SHOW_RECOMMEND_FORUM) {
                HotForumModel hotForumModel = new HotForumModel(getPageContext(), this);
                this.u = hotForumModel;
                hotForumModel.L();
            }
            this.z = false;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onDestroy();
            hideLoadingView(this.b);
            this.mHandler.removeCallbacks(this.J);
            m2();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048602, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                if (i2 == 4 && this.j.canGoBack()) {
                    this.j.goBack();
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
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onResourceRecycle();
            setSkinType(3);
            NoDataView noDataView = this.i;
            if (noDataView != null) {
                noDataView.e();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onResume();
        }
    }

    public final void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if (StringUtils.isNull(this.e.getText().toString())) {
                if (this.k.getVisibility() == 0) {
                    return;
                }
                r2();
            } else if (this.r.getVisibility() == 0) {
            } else {
                M2();
            }
        }
    }

    public final void q2(String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048606, this, str, z2) == null) {
            if (!ni.z()) {
                showToast(R.string.obfuscated_res_0x7f0f0c2b);
            } else if (StringUtils.isNull(str)) {
            } else {
                if (z2) {
                    this.I = false;
                    this.e.setText(str);
                    this.e.setSelection(str.length());
                    this.I = true;
                }
                pi.x(getPageContext().getPageActivity(), this.e);
                this.k.setVisibility(8);
                this.r.setVisibility(8);
                this.j.setVisibility(0);
                showProgressBarWithOffset(0, 0);
                String str2 = TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + TbConfig.SQUARE_SEARCH_PAGE + str;
                try {
                    str2 = TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, IMAudioTransRequest.CHARSET);
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
                this.j.loadUrl(str2);
                he5.b(new s(this, str), null);
            }
        }
    }

    public final void r2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.j.setVisibility(8);
            this.r.setVisibility(8);
            MessageManager.getInstance().sendMessage(new CustomMessage(2009002));
            if (SquareSearchActivityConfig.IS_SHOW_LIKE_FORUM) {
                x2(true);
                H2(this.C);
                H2(this.B);
            }
        }
    }

    public final void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            try {
                if (this.v != null) {
                    if (this.v.forum_list != null && this.v.forum_list.size() > 0) {
                        G2();
                        this.r.setAdapter((ListAdapter) this.s);
                        this.s.e(this.x);
                        this.s.d(this.v.forum_list);
                        this.s.notifyDataSetInvalidated();
                        return;
                    }
                    H2(this.B);
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.b
    public void s(List<df7> list, List<ef7> list2, HotSearchInfoData hotSearchInfoData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048609, this, list, list2, hotSearchInfoData, str) == null) {
            this.z = true;
            hideLoadingView(this.b);
            if (list2 == null) {
                this.m = new ArrayList();
            } else {
                this.m = list2;
            }
            if (!StringUtils.isNULL(str)) {
                this.n = str;
            } else {
                this.n = "";
            }
            N2(hotSearchInfoData);
            this.o = hotSearchInfoData;
            r2();
        }
    }

    public final void s2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f092437);
            this.d = navigationBar;
            View addCustomView = navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.obfuscated_res_0x7f0d07ac, (View.OnClickListener) null);
            this.h = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f091c9e);
            this.e = (EditText) addCustomView.findViewById(R.id.obfuscated_res_0x7f090d2f);
            this.f = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f090d1f);
            this.g = (TextView) addCustomView.findViewById(R.id.obfuscated_res_0x7f090d1e);
            this.e.setOnFocusChangeListener(new c(this));
            this.e.setOnClickListener(new d(this));
            this.g.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f036a));
            this.g.setOnClickListener(new e(this));
            this.e.setOnEditorActionListener(new f(this));
            this.f.setOnClickListener(new g(this));
            this.e.addTextChangedListener(new h(this));
        }
    }

    public void t2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.g.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f036a));
            D2();
            m2();
            B2();
            if (this.x.trim().length() > 0) {
                M2();
            } else {
                r2();
            }
        }
    }

    public final void u2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.k = (ScrollView) findViewById(R.id.obfuscated_res_0x7f091cb5);
            this.l = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091cb4);
            if (this.q == null) {
                LinearLayout linearLayout = new LinearLayout(getPageContext().getPageActivity());
                this.q = linearLayout;
                linearLayout.setOrientation(1);
                this.q.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            }
            this.l.addView(this.q);
        }
    }

    public final void v2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.r = (BdListView) findViewById(R.id.obfuscated_res_0x7f090d38);
            this.s = new cf7(this, null);
            this.t = new jf7(getPageContext().getPageActivity(), null);
            this.r.setOnItemClickListener(new i(this));
            this.r.setOnScrollListener(new j(this));
        }
    }

    public final void w2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && this.p == null) {
            if7 if7Var = new if7(getPageContext());
            this.p = if7Var;
            this.l.addView(if7Var.d());
        }
    }

    public final void x2(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048615, this, z2) == null) && TbadkCoreApplication.isLogin()) {
            if (z2) {
                MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(2001323, Boolean.TRUE));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new RequestEnterForumDataMessage(2001323, Boolean.FALSE));
        }
    }

    public final void y2() {
        HotSearchInfoData hotSearchInfoData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || (hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(xt4.k().q("hot_search_info", ""), HotSearchInfoData.class)) == null || hotSearchInfoData.getId() == 0) {
            return;
        }
        this.o = hotSearchInfoData;
    }

    public final boolean z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            HotSearchInfoData hotSearchInfoData = this.o;
            if (hotSearchInfoData == null) {
                return false;
            }
            if (hotSearchInfoData.getType() == 0) {
                q2(this.o.getName(), false);
            } else if (this.o.getType() == 1 && !id5.b(getPageContext())) {
                sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.o.getId()), this.o.getName(), "4")));
            }
            TiebaStatic.log(new StatisticItem("c10355").param("obj_name", this.o.getName()).param("obj_type", this.o.getType() == 0 ? 2 : 1));
            return true;
        }
        return invokeV.booleanValue;
    }
}
