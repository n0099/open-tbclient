package com.baidu.tieba;

import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.BlueCircleProgressDialog;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.write.accountAccess.AccountAccessActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class zdb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public BaseActivity b;
    public ydb c;
    public View d;
    public BaseWebView e;
    public View f;
    public TextView g;
    public BlueCircleProgressDialog h;
    public l55 i;
    public boolean j;
    public float k;
    public Runnable l;
    public Runnable m;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zdb a;

        public a(zdb zdbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zdbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zdbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.e != null) {
                this.a.q(false);
                this.a.t();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zdb a;

        public b(zdb zdbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zdbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zdbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b != null) {
                this.a.b.ShowSoftKeyPadDelay(this.a.e);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zdb a;

        public c(zdb zdbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zdbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zdbVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.c.e();
                this.a.b.finish();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zdb a;

        public d(zdb zdbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zdbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zdbVar;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                this.a.j = true;
                if (this.a.c != null) {
                    this.a.c.d();
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, i, str, str2) == null) {
                super.onReceivedError(webView, i, str, str2);
                this.a.q(false);
                this.a.b.showToast(R.string.obfuscated_res_0x7f0f0e70);
                this.a.b.finish();
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str)) == null) {
                if (StringUtils.isNull(str) || this.a.c == null) {
                    return false;
                }
                if (!this.a.j) {
                    this.a.j = true;
                    this.a.q(false);
                    this.a.t();
                    this.a.c.d();
                    return true;
                }
                return this.a.c.f(str);
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class e implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zdb a;

        public e(zdb zdbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zdbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zdbVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.b.finish();
            }
        }
    }

    public zdb(AccountAccessActivity accountAccessActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {accountAccessActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = false;
        this.k = 1.2631578f;
        this.l = new a(this);
        this.m = new b(this);
        if (accountAccessActivity == null) {
            return;
        }
        this.b = accountAccessActivity;
        if (!k(accountAccessActivity)) {
            accountAccessActivity.finish();
        }
    }

    public void m(ydb ydbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, ydbVar) == null) {
            this.c = ydbVar;
        }
    }

    public void n(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f) == null) {
            this.k = f;
            UtilHelper.setSupportHeight(this.b.getPageContext().getPageActivity(), this.e, f);
        }
    }

    public void p(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && (view2 = this.f) != null) {
            if (z) {
                view2.setVisibility(0);
            } else {
                view2.setVisibility(8);
            }
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            if (this.h == null) {
                BlueCircleProgressDialog blueCircleProgressDialog = new BlueCircleProgressDialog(this.b.getPageContext());
                this.h = blueCircleProgressDialog;
                blueCircleProgressDialog.setCancelListener(new e(this));
            }
            this.h.setDialogVisiable(z);
        }
    }

    public void r(boolean z) {
        BaseWebView baseWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && (baseWebView = this.e) != null) {
            if (z) {
                baseWebView.setVisibility(0);
            } else {
                baseWebView.setVisibility(4);
            }
        }
    }

    public void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            SafeHandler.getInst().postDelayed(this.l, i);
        }
    }

    public Animation f(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, f, f2);
            translateAnimation.setFillAfter(true);
            translateAnimation.setDuration(300L);
            return translateAnimation;
        }
        return (Animation) invokeCommon.objValue;
    }

    public BaseActivity g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (BaseActivity) invokeV.objValue;
    }

    public float h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return invokeV.floatValue;
    }

    public float i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.k;
        }
        return invokeV.floatValue;
    }

    public WebView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return (WebView) invokeV.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SafeHandler.getInst().removeCallbacks(this.l);
            SafeHandler.getInst().removeCallbacks(this.m);
            this.h = null;
        }
    }

    public final boolean k(AccountAccessActivity accountAccessActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, accountAccessActivity)) == null) {
            accountAccessActivity.setActivityBgTransparent();
            accountAccessActivity.setSwipeBackEnabled(false);
            accountAccessActivity.setContentView(R.layout.obfuscated_res_0x7f0d001e);
            View findViewById = accountAccessActivity.findViewById(R.id.obfuscated_res_0x7f090078);
            this.d = findViewById;
            findViewById.setOnClickListener(new c(this));
            View findViewById2 = accountAccessActivity.findViewById(R.id.obfuscated_res_0x7f090036);
            this.f = findViewById2;
            TextView textView = (TextView) findViewById2.findViewById(R.id.custom_loading_text);
            this.g = textView;
            textView.setText(accountAccessActivity.getResources().getString(R.string.obfuscated_res_0x7f0f13c0));
            l55 l55Var = new l55();
            this.i = l55Var;
            l55Var.a = 1000L;
            this.a = BdUtilHelper.getEquipmentWidth(accountAccessActivity.getBaseContext()) / BdUtilHelper.getEquipmentHeight(accountAccessActivity.getBaseContext());
            if (this.e != null) {
                return true;
            }
            try {
                this.e = (BaseWebView) accountAccessActivity.findViewById(R.id.obfuscated_res_0x7f090079);
                UtilHelper.setSupportHeight(accountAccessActivity.getPageContext().getPageActivity(), this.e, this.k);
                this.e.setBackgroundColor(accountAccessActivity.getResources().getColor(17170443));
                this.e.setWebViewClient(new d(this));
                return true;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                TbadkCoreApplication.getInst().setNewVcodeWebviewCrashCount(TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() + 1);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void o(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(1048585, this, i, i2, i3, i4) == null) && (this.e.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.e.getLayoutParams();
            marginLayoutParams.setMargins(i, i2, i3, i4);
            this.e.setLayoutParams(marginLayoutParams);
        }
    }

    public void t() {
        BaseActivity baseActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (baseActivity = this.b) != null) {
            if (this.k == this.a) {
                int equipmentHeight = BdUtilHelper.getEquipmentHeight(baseActivity.getBaseContext());
                BaseWebView baseWebView = this.e;
                baseWebView.startAnimation(f(equipmentHeight - (baseWebView.getWidth() * 1.2631578f), 0.0f));
                SafeHandler.getInst().postDelayed(this.m, 800L);
                return;
            }
            BaseWebView baseWebView2 = this.e;
            baseWebView2.startAnimation(f(baseWebView2.getHeight(), 0.0f));
        }
    }
}
