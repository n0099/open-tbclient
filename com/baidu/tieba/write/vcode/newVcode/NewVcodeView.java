package com.baidu.tieba.write.vcode.newVcode;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.BlueCircleProgressDialog;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.e95;
import com.baidu.tieba.zta;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class NewVcodeView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public int b;
    public zta c;
    public BaseWebView d;
    public View e;
    public BlueCircleProgressDialog f;
    public TextView g;
    public e95 h;
    public boolean i;
    public Runnable j;
    public float k;

    public NewVcodeView(NewVcodeActivity newVcodeActivity, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newVcodeActivity, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = false;
        this.j = new Runnable(this) { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.1
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
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
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.a.d != null) {
                    this.a.showWebView(true);
                }
            }
        };
        this.a = newVcodeActivity;
        this.b = i;
        if (!initUI(newVcodeActivity)) {
            newVcodeActivity.finish();
        }
    }

    public final void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (this.f == null) {
                BlueCircleProgressDialog blueCircleProgressDialog = new BlueCircleProgressDialog(this.a.getPageContext());
                this.f = blueCircleProgressDialog;
                blueCircleProgressDialog.setCancelListener(new DialogInterface.OnCancelListener(this) { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.3
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
            this.f.setDialogVisiable(z);
        }
    }

    public void setPresenter(zta ztaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ztaVar) == null) {
            this.c = ztaVar;
            this.i = false;
        }
    }

    public void setRatio(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f) == null) {
            this.k = f;
        }
    }

    public void showPostThreadLoadingView(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (view2 = this.e) != null) {
            if (z) {
                view2.setVisibility(0);
            } else {
                view2.setVisibility(8);
            }
        }
    }

    public void showWebViewDelay(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            SafeHandler.getInst().postDelayed(this.j, i);
        }
    }

    public void showToast(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z, str) == null) {
            if (z) {
                this.h.d(str);
            } else {
                this.h.c(str);
            }
        }
    }

    @JavascriptInterface
    @SuppressLint({"SetJavaScriptEnabled"})
    private boolean initUI(NewVcodeActivity newVcodeActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, newVcodeActivity)) == null) {
            newVcodeActivity.setActivityBgTransparent();
            newVcodeActivity.setSwipeBackEnabled(false);
            if (this.b == JavaTypesHelper.toInt("6", 0)) {
                newVcodeActivity.setContentView(R.layout.new_vcode_center_activity);
            } else {
                newVcodeActivity.setContentView(R.layout.new_vcode_activity);
            }
            View findViewById = newVcodeActivity.findViewById(R.id.post_thread_loading_view);
            this.e = findViewById;
            TextView textView = (TextView) findViewById.findViewById(R.id.custom_loading_text);
            this.g = textView;
            textView.setText(newVcodeActivity.getResources().getString(R.string.obfuscated_res_0x7f0f1363));
            e95 e95Var = new e95();
            this.h = e95Var;
            e95Var.a = 1000L;
            if (this.d != null) {
                return true;
            }
            try {
                this.d = (BaseWebView) newVcodeActivity.findViewById(R.id.new_vcode_webview);
                if (this.b != JavaTypesHelper.toInt("6", 0)) {
                    UtilHelper.setSupportHeight(newVcodeActivity.getPageContext().getPageActivity(), this.d, 1.2631578f);
                }
                this.d.setBackgroundColor(newVcodeActivity.getResources().getColor(17170443));
                this.d.setInitialScale(100);
                this.d.getSettings().setJavaScriptEnabled(true);
                this.d.removeJavascriptInterface("searchBoxJavaBridge_");
                this.d.setWebViewClient(new WebViewClient(this) { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.2
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
                            this.a.i = true;
                            if (this.a.c != null) {
                                this.a.c.onPageFinished(webView, str);
                            }
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, i, str, str2) == null) {
                            super.onReceivedError(webView, i, str, str2);
                            this.a.h(false);
                            this.a.a.showToast(R.string.obfuscated_res_0x7f0f0e21);
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
                            if (!this.a.i) {
                                this.a.i = true;
                                SafeHandler.getInst().postDelayed(this.a.j, 500L);
                                if (this.a.c != null) {
                                    this.a.c.onPageFinished(webView, str);
                                }
                            }
                            if (this.a.c == null) {
                                return false;
                            }
                            return this.a.c.b(webView, str);
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
        return invokeL.booleanValue;
    }

    public BaseActivity getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (BaseActivity) invokeV.objValue;
    }

    public WebView getWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (WebView) invokeV.objValue;
    }

    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SafeHandler.getInst().removeCallbacks(this.j);
        }
    }

    public void runJsMethod(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) && this.d != null) {
            this.d.loadUrl("javascript:window." + str + "(" + str2 + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    public void showWebView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            h(!z);
            BaseWebView baseWebView = this.d;
            if (baseWebView != null) {
                if (z) {
                    if (this.b != JavaTypesHelper.toInt("6", 0)) {
                        UtilHelper.setSupportHeight(this.a.getPageContext().getPageActivity(), this.d, this.k);
                    }
                    this.d.setVisibility(0);
                    return;
                }
                baseWebView.setVisibility(8);
            }
        }
    }
}
