package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.m.h;
import c.a.t0.m3.e;
import c.a.t0.m3.f;
import c.a.t0.m3.g;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class AppsActivity extends BaseActivity<AppsActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long PULL_INVERVAL = 86400000;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView mBack;
    public LinearLayout mFailView;
    public RelativeLayout mParent;
    public ProgressBar mProcess;
    public ImageView mRefresh;
    public d mTask;
    public RelativeLayout mTitle;
    public TextView mTitleText;
    public String mUrl;
    public BaseWebView mWebView;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AppsActivity f47807e;

        public a(AppsActivity appsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {appsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47807e = appsActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f47807e.refresh();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AppsActivity f47808e;

        public b(AppsActivity appsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {appsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47808e = appsActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f47808e.refresh();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AppsActivity f47809e;

        public c(AppsActivity appsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {appsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47809e = appsActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f47809e.finish();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d extends BdAsyncTask<Object, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;

        /* renamed from: b  reason: collision with root package name */
        public String f47810b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AppsActivity f47811c;

        /* loaded from: classes12.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f47812e;

            public a(d dVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47812e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    TbadkCoreApplication.getInst().cashNoAccountData(this.f47812e, 7);
                }
            }
        }

        public d(AppsActivity appsActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {appsActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47811c = appsActivity;
            this.a = null;
            this.f47810b = null;
            this.f47810b = str;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f47811c.mProcess.setVisibility(8);
                this.f47811c.mTask = null;
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f47811c.mProcess.setVisibility(0);
                this.f47811c.mFailView.setVisibility(8);
                this.f47811c.mWebView.setVisibility(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, objArr)) == null) {
                String str = this.f47810b;
                if (str == null) {
                    return null;
                }
                NetWork netWork = new NetWork(str);
                this.a = netWork;
                netWork.getNetContext().getRequest().getNetWorkParam().mIsJson = false;
                this.a.addPostData("client", "android");
                return this.a.postNetData();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.f47811c.mProcess.setVisibility(8);
                NetWork netWork = this.a;
                if (netWork == null || !netWork.isNetSuccess() || str == null || str.length() <= 0) {
                    if (!this.f47811c.loadCacheData() && str == null) {
                        this.f47811c.mWebView.setVisibility(8);
                        this.f47811c.mFailView.setVisibility(0);
                        AppsActivity appsActivity = this.f47811c;
                        appsActivity.showToast(appsActivity.getPageContext().getString(g.neterror));
                        return;
                    }
                    this.f47811c.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, this.f47811c.getPageContext().getString(g.server_404), SapiWebView.DATA_MIME_TYPE, "utf-8", "");
                    return;
                }
                h.a().b(new a(this, str));
                c.a.s0.s.h0.b.k().x("app_inverval", System.currentTimeMillis());
                this.f47811c.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, SapiWebView.DATA_MIME_TYPE, "utf-8", "");
            }
        }
    }

    public AppsActivity() {
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
        this.mUrl = null;
        this.mWebView = null;
        this.mBack = null;
        this.mTask = null;
        this.mFailView = null;
        this.mProcess = null;
        this.mRefresh = null;
        this.mParent = null;
        this.mTitle = null;
        this.mTitleText = null;
    }

    private void InitData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, bundle) == null) {
            if (bundle != null) {
                this.mUrl = bundle.getString("url");
            } else {
                this.mUrl = getIntent().getStringExtra("url");
            }
            if (System.currentTimeMillis() - c.a.s0.s.h0.b.k().m("app_inverval", 0L) > 86400000) {
                refresh();
            } else if (loadCacheData()) {
            } else {
                refresh();
            }
        }
    }

    private void InitUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.mParent = (RelativeLayout) findViewById(e.parent);
            this.mTitle = (RelativeLayout) findViewById(e.title);
            this.mTitleText = (TextView) findViewById(e.title_text);
            BaseWebView baseWebView = (BaseWebView) findViewById(e.app_webView);
            this.mWebView = baseWebView;
            baseWebView.setDownloadEnabled(true);
            this.mProcess = (ProgressBar) findViewById(e.app_progress);
            LinearLayout linearLayout = (LinearLayout) findViewById(e.webview_fail_imageview);
            this.mFailView = linearLayout;
            linearLayout.setOnClickListener(new a(this));
            ImageView imageView = (ImageView) findViewById(e.refresh);
            this.mRefresh = imageView;
            imageView.setOnClickListener(new b(this));
            ImageView imageView2 = (ImageView) findViewById(e.back);
            this.mBack = imageView2;
            imageView2.setOnClickListener(new c(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean loadCacheData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            String noAccountData = TbadkCoreApplication.getInst().getNoAccountData(7);
            if (noAccountData == null || noAccountData.length() <= 1) {
                return false;
            }
            this.mProcess.setVisibility(8);
            this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, noAccountData, SapiWebView.DATA_MIME_TYPE, "utf-8", "");
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            d dVar = this.mTask;
            if (dVar != null) {
                dVar.cancel();
            }
            d dVar2 = new d(this, this.mUrl);
            this.mTask = dVar2;
            dVar2.setPriority(3);
            this.mTask.execute(new Object[0]);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            SkinManager.setBgColor(this.mParent, i2);
            SkinManager.setBgColor(this.mWebView, i2);
            SkinManager.setTopBarBgImage(this.mTitle, i2);
            SkinManager.setTopBarBackBgImage(this.mBack, i2);
            SkinManager.setTopBarTitleColor(this.mTitleText, i2);
            SkinManager.setTopBarRefrshBgImage(this.mRefresh, i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(f.app_activity);
            InitUI();
            InitData(bundle);
        }
    }
}
