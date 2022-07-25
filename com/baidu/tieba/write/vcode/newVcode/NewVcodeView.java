package com.baidu.tieba.write.vcode.newVcode;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bu4;
import com.repackage.du4;
import com.repackage.qg;
import com.repackage.xx8;
/* loaded from: classes4.dex */
public class NewVcodeView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public xx8 b;
    public BaseWebView c;
    public View d;
    public bu4 e;
    public TextView f;
    public du4 g;
    public boolean h;
    public Runnable i;
    public float j;

    public NewVcodeView(NewVcodeActivity newVcodeActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newVcodeActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = false;
        this.i = new Runnable(this) { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NewVcodeView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.c == null) {
                    return;
                }
                this.a.showWebView(true);
            }
        };
        this.a = newVcodeActivity;
        if (initUI(newVcodeActivity)) {
            return;
        }
        newVcodeActivity.finish();
    }

    @JavascriptInterface
    @SuppressLint({"SetJavaScriptEnabled"})
    private boolean initUI(NewVcodeActivity newVcodeActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, newVcodeActivity)) == null) {
            newVcodeActivity.setActivityBgTransparent();
            newVcodeActivity.setSwipeBackEnabled(false);
            newVcodeActivity.setContentView(R.layout.obfuscated_res_0x7f0d061d);
            View findViewById = newVcodeActivity.findViewById(R.id.obfuscated_res_0x7f091944);
            this.d = findViewById;
            TextView textView = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f09071b);
            this.f = textView;
            textView.setText(newVcodeActivity.getResources().getString(R.string.obfuscated_res_0x7f0f10d8));
            du4 du4Var = new du4();
            this.g = du4Var;
            du4Var.a = 1000L;
            if (this.c == null) {
                try {
                    this.c = (BaseWebView) newVcodeActivity.findViewById(R.id.obfuscated_res_0x7f0915b6);
                    UtilHelper.setSupportHeight(newVcodeActivity.getPageContext().getPageActivity(), this.c, 1.2631578f);
                    this.c.setBackgroundColor(newVcodeActivity.getResources().getColor(17170443));
                    this.c.setInitialScale(100);
                    this.c.getSettings().setJavaScriptEnabled(true);
                    this.c.removeJavascriptInterface("searchBoxJavaBridge_");
                    this.c.setWebViewClient(new WebViewClient(this) { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ NewVcodeView a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.a = this;
                        }

                        @Override // android.webkit.WebViewClient
                        public void onPageFinished(WebView webView, String str) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView, str) == null) {
                                super.onPageFinished(webView, str);
                                this.a.h = true;
                                if (this.a.b != null) {
                                    this.a.b.onPageFinished(webView, str);
                                }
                            }
                        }

                        @Override // android.webkit.WebViewClient
                        public void onReceivedError(WebView webView, int i, String str, String str2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, i, str, str2) == null) {
                                super.onReceivedError(webView, i, str, str2);
                                this.a.h(false);
                                this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c17);
                                this.a.a.finish();
                            }
                        }

                        @Override // android.webkit.WebViewClient
                        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                            InterceptResult invokeLL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str)) == null) {
                                if (StringUtils.isNull(str)) {
                                    return false;
                                }
                                if (!this.a.h) {
                                    this.a.h = true;
                                    qg.a().postDelayed(this.a.i, 500L);
                                    if (this.a.b != null) {
                                        this.a.b.onPageFinished(webView, str);
                                    }
                                }
                                if (this.a.b == null) {
                                    return false;
                                }
                                return this.a.b.b(webView, str);
                            }
                            return invokeLL.booleanValue;
                        }
                    });
                    return true;
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    TbadkCoreApplication.getInst().setNewVcodeWebviewCrashCount(TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() + 1);
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public BaseActivity getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (BaseActivity) invokeV.objValue;
    }

    public WebView getWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : (WebView) invokeV.objValue;
    }

    public final void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (this.e == null) {
                bu4 bu4Var = new bu4(this.a.getPageContext());
                this.e = bu4Var;
                bu4Var.e(new DialogInterface.OnCancelListener(this) { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ NewVcodeView a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                            this.a.a.finish();
                        }
                    }
                });
            }
            this.e.h(z);
        }
    }

    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            qg.a().removeCallbacks(this.i);
        }
    }

    public void runJsMethod(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) || this.c == null) {
            return;
        }
        this.c.loadUrl("javascript:window." + str + "(" + str2 + SmallTailInfo.EMOTION_SUFFIX);
    }

    public void setPresenter(xx8 xx8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, xx8Var) == null) {
            this.b = xx8Var;
            this.h = false;
        }
    }

    public void setRatio(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f) == null) {
            this.j = f;
        }
    }

    public void showPostThreadLoadingView(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || (view2 = this.d) == null) {
            return;
        }
        if (z) {
            view2.setVisibility(0);
        } else {
            view2.setVisibility(8);
        }
    }

    public void showToast(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z, str) == null) {
            if (z) {
                this.g.c(str);
            } else {
                this.g.b(str);
            }
        }
    }

    public void showWebView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            h(!z);
            BaseWebView baseWebView = this.c;
            if (baseWebView != null) {
                if (z) {
                    UtilHelper.setSupportHeight(this.a.getPageContext().getPageActivity(), this.c, this.j);
                    this.c.setVisibility(0);
                    return;
                }
                baseWebView.setVisibility(8);
            }
        }
    }

    public void showWebViewDelay(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            qg.a().postDelayed(this.i, i);
        }
    }
}
