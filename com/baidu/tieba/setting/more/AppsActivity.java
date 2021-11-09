package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.e.e.m.h;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AppsActivity f53840e;

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
            this.f53840e = appsActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f53840e.refresh();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AppsActivity f53841e;

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
            this.f53841e = appsActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f53841e.refresh();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AppsActivity f53842e;

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
            this.f53842e = appsActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f53842e.finish();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends BdAsyncTask<Object, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f53843a;

        /* renamed from: b  reason: collision with root package name */
        public String f53844b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AppsActivity f53845c;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f53846e;

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
                this.f53846e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    TbadkCoreApplication.getInst().cashNoAccountData(this.f53846e, 7);
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
            this.f53845c = appsActivity;
            this.f53843a = null;
            this.f53844b = null;
            this.f53844b = str;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NetWork netWork = this.f53843a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f53845c.mProcess.setVisibility(8);
                this.f53845c.mTask = null;
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f53845c.mProcess.setVisibility(0);
                this.f53845c.mFailView.setVisibility(8);
                this.f53845c.mWebView.setVisibility(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, objArr)) == null) {
                String str = this.f53844b;
                if (str == null) {
                    return null;
                }
                NetWork netWork = new NetWork(str);
                this.f53843a = netWork;
                netWork.getNetContext().getRequest().getNetWorkParam().mIsJson = false;
                this.f53843a.addPostData("client", "android");
                return this.f53843a.postNetData();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.f53845c.mProcess.setVisibility(8);
                NetWork netWork = this.f53843a;
                if (netWork == null || !netWork.isNetSuccess() || str == null || str.length() <= 0) {
                    if (!this.f53845c.loadCacheData() && str == null) {
                        this.f53845c.mWebView.setVisibility(8);
                        this.f53845c.mFailView.setVisibility(0);
                        AppsActivity appsActivity = this.f53845c;
                        appsActivity.showToast(appsActivity.getPageContext().getString(R.string.neterror));
                        return;
                    }
                    this.f53845c.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, this.f53845c.getPageContext().getString(R.string.server_404), SapiWebView.DATA_MIME_TYPE, "utf-8", "");
                    return;
                }
                h.a().b(new a(this, str));
                b.a.q0.s.e0.b.j().w("app_inverval", System.currentTimeMillis());
                this.f53845c.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, SapiWebView.DATA_MIME_TYPE, "utf-8", "");
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
            if (System.currentTimeMillis() - b.a.q0.s.e0.b.j().l("app_inverval", 0L) > 86400000) {
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
            this.mParent = (RelativeLayout) findViewById(R.id.parent);
            this.mTitle = (RelativeLayout) findViewById(R.id.title);
            this.mTitleText = (TextView) findViewById(R.id.title_text);
            BaseWebView baseWebView = (BaseWebView) findViewById(R.id.app_webView);
            this.mWebView = baseWebView;
            baseWebView.setDownloadEnabled(true);
            this.mProcess = (ProgressBar) findViewById(R.id.app_progress);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.webview_fail_imageview);
            this.mFailView = linearLayout;
            linearLayout.setOnClickListener(new a(this));
            ImageView imageView = (ImageView) findViewById(R.id.refresh);
            this.mRefresh = imageView;
            imageView.setOnClickListener(new b(this));
            ImageView imageView2 = (ImageView) findViewById(R.id.back);
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
            setContentView(R.layout.app_activity);
            InitUI();
            InitData(bundle);
        }
    }
}
