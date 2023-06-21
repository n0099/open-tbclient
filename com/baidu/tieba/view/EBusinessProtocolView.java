package com.baidu.tieba.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.na5;
import com.baidu.tieba.wi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class EBusinessProtocolView extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public TextView c;
    public WebView d;
    public TBSpecificationBtn e;
    public TBSpecificationBtn f;
    public TextView g;
    public TBSpecificationBtn h;
    public boolean i;
    public String j;
    public CharSequence k;
    public String l;
    public final WindowType m;
    public int n;
    public f o;
    public WebViewClient p;

    /* loaded from: classes8.dex */
    public interface f {
        void a(boolean z);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class WindowType {
        public static final /* synthetic */ WindowType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final WindowType PROTOCOL;
        public static final WindowType TIP;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(683313139, "Lcom/baidu/tieba/view/EBusinessProtocolView$WindowType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(683313139, "Lcom/baidu/tieba/view/EBusinessProtocolView$WindowType;");
                    return;
                }
            }
            TIP = new WindowType("TIP", 0);
            WindowType windowType = new WindowType("PROTOCOL", 1);
            PROTOCOL = windowType;
            $VALUES = new WindowType[]{TIP, windowType};
        }

        public WindowType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static WindowType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (WindowType) Enum.valueOf(WindowType.class, str);
            }
            return (WindowType) invokeL.objValue;
        }

        public static WindowType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (WindowType[]) $VALUES.clone();
            }
            return (WindowType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class a extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EBusinessProtocolView a;

        public a(EBusinessProtocolView eBusinessProtocolView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eBusinessProtocolView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eBusinessProtocolView;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                String str2 = "javascript:setContentTextColor(" + this.a.n + SmallTailInfo.EMOTION_SUFFIX;
                if (this.a.d != null) {
                    this.a.d.loadUrl(str2);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EBusinessProtocolView a;

        public b(EBusinessProtocolView eBusinessProtocolView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eBusinessProtocolView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eBusinessProtocolView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.i = true;
            if (this.a.o != null) {
                this.a.o.a(this.a.i);
            }
            this.a.dismiss();
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EBusinessProtocolView a;

        public c(EBusinessProtocolView eBusinessProtocolView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eBusinessProtocolView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eBusinessProtocolView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.i = false;
            if (this.a.o != null) {
                this.a.o.a(this.a.i);
            }
            this.a.dismiss();
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EBusinessProtocolView a;

        public d(EBusinessProtocolView eBusinessProtocolView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eBusinessProtocolView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eBusinessProtocolView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static /* synthetic */ class e {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-342480812, "Lcom/baidu/tieba/view/EBusinessProtocolView$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-342480812, "Lcom/baidu/tieba/view/EBusinessProtocolView$e;");
                    return;
                }
            }
            int[] iArr = new int[WindowType.values().length];
            a = iArr;
            try {
                iArr[WindowType.TIP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[WindowType.PROTOCOL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EBusinessProtocolView(@NonNull Context context, WindowType windowType) {
        super(context, R.style.obfuscated_res_0x7f1003ca);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, windowType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = false;
        this.n = 0;
        this.p = new a(this);
        this.a = context;
        this.m = windowType;
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        getWindow().setAttributes(attributes);
        this.b = LayoutInflater.from(getContext()).inflate(R.layout.e_business_protocol_dialog, (ViewGroup) null);
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.l = str;
        }
    }

    public void l(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            this.o = fVar;
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.j = str;
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f.setOnClickListener(new b(this));
            this.e.setOnClickListener(new c(this));
            this.h.setOnClickListener(new d(this));
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            WebSettings settings = this.d.getSettings();
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            settings.setJavaScriptEnabled(true);
            this.d.setWebViewClient(this.p);
            settings.setTextZoom(115);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c = (TextView) this.b.findViewById(R.id.protocol_title);
            this.d = (WebView) this.b.findViewById(R.id.protocol_content);
            this.f = (TBSpecificationBtn) this.b.findViewById(R.id.agree_protocol);
            this.e = (TBSpecificationBtn) this.b.findViewById(R.id.cancel_protocol);
            this.g = (TextView) this.b.findViewById(R.id.tip_content);
            this.h = (TBSpecificationBtn) findViewById(R.id.tip_known);
            h();
            f();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c.setText(this.j);
            int i = e.a[this.m.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    m();
                    this.d.setVisibility(0);
                    this.f.setVisibility(0);
                    this.e.setVisibility(0);
                    this.d.loadUrl(this.l);
                    na5 na5Var = new na5();
                    na5Var.q(R.color.CAM_X0107);
                    this.e.setConfig(na5Var);
                    this.e.setTextSize(R.dimen.tbds42);
                    this.e.setText(this.a.getResources().getString(R.string.protocol_cancel));
                    this.f.setTextSize(R.dimen.tbds42);
                    na5 na5Var2 = new na5();
                    na5Var2.q(R.color.CAM_X0302);
                    this.f.setConfig(na5Var2);
                    this.f.setTextSize(R.dimen.tbds42);
                    this.f.setText(this.a.getResources().getString(R.string.protocol_agree));
                    return;
                }
                return;
            }
            this.g.setVisibility(0);
            this.h.setVisibility(0);
            setCanceledOnTouchOutside(true);
            this.g.setText(this.k);
            this.h.setText(this.a.getResources().getString(R.string.tip_known));
            na5 na5Var3 = new na5();
            na5Var3.q(R.color.CAM_X0302);
            this.h.setTextSize(R.dimen.T_X08);
            this.h.setConfig(na5Var3);
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            k(i);
            this.n = i;
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0211);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0303);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0105);
        }
    }

    public final void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.tbds30);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(dimensionPixelSize);
            gradientDrawable.setColor(SkinManager.getColor(i, (int) R.color.CAM_X0211));
            this.b.setBackgroundDrawable(gradientDrawable);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.width = this.a.getResources().getDisplayMetrics().widthPixels - wi.g(this.a, R.dimen.tbds90);
            layoutParams.height = wi.g(this.a, R.dimen.tbds879);
            setContentView(this.b, layoutParams);
            setCanceledOnTouchOutside(true);
            g();
            j(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
