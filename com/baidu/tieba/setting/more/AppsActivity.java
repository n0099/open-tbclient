package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
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
import com.repackage.sg;
import com.repackage.vt4;
/* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AppsActivity a;

        public a(AppsActivity appsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {appsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = appsActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.refresh();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AppsActivity a;

        public b(AppsActivity appsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {appsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = appsActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.refresh();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AppsActivity a;

        public c(AppsActivity appsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {appsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = appsActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends BdAsyncTask<Object, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public String b;
        public final /* synthetic */ AppsActivity c;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            public a(d dVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    TbadkCoreApplication.getInst().cashNoAccountData(this.a, 7);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = appsActivity;
            this.a = null;
            this.b = null;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                String str = this.b;
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

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.c.mProcess.setVisibility(8);
                this.c.mTask = null;
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.c.mProcess.setVisibility(0);
                this.c.mFailView.setVisibility(8);
                this.c.mWebView.setVisibility(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.c.mProcess.setVisibility(8);
                NetWork netWork = this.a;
                if (netWork == null || !netWork.isNetSuccess() || str == null || str.length() <= 0) {
                    if (!this.c.loadCacheData() && str == null) {
                        this.c.mWebView.setVisibility(8);
                        this.c.mFailView.setVisibility(0);
                        AppsActivity appsActivity = this.c;
                        appsActivity.showToast(appsActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c17));
                        return;
                    }
                    this.c.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f10f0), SapiWebView.DATA_MIME_TYPE, IMAudioTransRequest.CHARSET, "");
                    return;
                }
                sg.a().b(new a(this, str));
                vt4.k().x("app_inverval", System.currentTimeMillis());
                this.c.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, SapiWebView.DATA_MIME_TYPE, IMAudioTransRequest.CHARSET, "");
            }
        }
    }

    public AppsActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            if (System.currentTimeMillis() - vt4.k().m("app_inverval", 0L) > 86400000) {
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
            this.mParent = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091642);
            this.mTitle = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f092013);
            this.mTitleText = (TextView) findViewById(R.id.obfuscated_res_0x7f09203f);
            BaseWebView baseWebView = (BaseWebView) findViewById(R.id.obfuscated_res_0x7f09029e);
            this.mWebView = baseWebView;
            baseWebView.setDownloadEnabled(true);
            this.mProcess = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f090298);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09242d);
            this.mFailView = linearLayout;
            linearLayout.setOnClickListener(new a(this));
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091a1c);
            this.mRefresh = imageView;
            imageView.setOnClickListener(new b(this));
            ImageView imageView2 = (ImageView) findViewById(R.id.obfuscated_res_0x7f0902f9);
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
            this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, noAccountData, SapiWebView.DATA_MIME_TYPE, IMAudioTransRequest.CHARSET, "");
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
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.onChangeSkinType(i);
            SkinManager.setBgColor(this.mParent, i);
            SkinManager.setBgColor(this.mWebView, i);
            SkinManager.setTopBarBgImage(this.mTitle, i);
            SkinManager.setTopBarBackBgImage(this.mBack, i);
            SkinManager.setTopBarTitleColor(this.mTitleText, i);
            SkinManager.setTopBarRefrshBgImage(this.mRefresh, i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0122);
            InitUI();
            InitData(bundle);
        }
    }
}
