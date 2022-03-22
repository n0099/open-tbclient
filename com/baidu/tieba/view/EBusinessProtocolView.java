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
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class EBusinessProtocolView extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public View f36830b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f36831c;

    /* renamed from: d  reason: collision with root package name */
    public WebView f36832d;

    /* renamed from: e  reason: collision with root package name */
    public TBSpecificationBtn f36833e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f36834f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f36835g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f36836h;
    public boolean i;
    public String j;
    public CharSequence k;
    public String l;
    public final WindowType m;
    public int n;
    public f o;
    public WebViewClient p;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
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
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (WindowType) Enum.valueOf(WindowType.class, str) : (WindowType) invokeL.objValue;
        }

        public static WindowType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (WindowType[]) $VALUES.clone() : (WindowType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
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
                if (this.a.f36832d != null) {
                    this.a.f36832d.loadUrl(str2);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.i = true;
                if (this.a.o != null) {
                    this.a.o.a(this.a.i);
                }
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.i = false;
                if (this.a.o != null) {
                    this.a.o.a(this.a.i);
                }
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public interface f {
        void a(boolean z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EBusinessProtocolView(@NonNull Context context, WindowType windowType) {
        super(context, R.style.obfuscated_res_0x7f1003a9);
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
        this.f36830b = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0247, (ViewGroup) null);
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f36834f.setOnClickListener(new b(this));
            this.f36833e.setOnClickListener(new c(this));
            this.f36836h.setOnClickListener(new d(this));
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f36831c = (TextView) this.f36830b.findViewById(R.id.obfuscated_res_0x7f09194a);
            this.f36832d = (WebView) this.f36830b.findViewById(R.id.obfuscated_res_0x7f091945);
            this.f36834f = (TBSpecificationBtn) this.f36830b.findViewById(R.id.obfuscated_res_0x7f09015b);
            this.f36833e = (TBSpecificationBtn) this.f36830b.findViewById(R.id.obfuscated_res_0x7f090495);
            this.f36835g = (TextView) this.f36830b.findViewById(R.id.obfuscated_res_0x7f09200d);
            this.f36836h = (TBSpecificationBtn) findViewById(R.id.obfuscated_res_0x7f09201d);
            h();
            f();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f36831c.setText(this.j);
            int i = e.a[this.m.ordinal()];
            if (i == 1) {
                this.f36835g.setVisibility(0);
                this.f36836h.setVisibility(0);
                setCanceledOnTouchOutside(true);
                this.f36835g.setText(this.k);
                this.f36836h.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f13d6));
                c.a.o0.r.l0.n.c cVar = new c.a.o0.r.l0.n.c();
                cVar.p(R.color.CAM_X0302);
                this.f36836h.setTextSize(R.dimen.T_X08);
                this.f36836h.setConfig(cVar);
            } else if (i != 2) {
            } else {
                n();
                this.f36832d.setVisibility(0);
                this.f36834f.setVisibility(0);
                this.f36833e.setVisibility(0);
                this.f36832d.loadUrl(this.l);
                c.a.o0.r.l0.n.c cVar2 = new c.a.o0.r.l0.n.c();
                cVar2.p(R.color.CAM_X0107);
                this.f36833e.setConfig(cVar2);
                this.f36833e.setTextSize(R.dimen.tbds42);
                this.f36833e.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0eeb));
                this.f36834f.setTextSize(R.dimen.tbds42);
                c.a.o0.r.l0.n.c cVar3 = new c.a.o0.r.l0.n.c();
                cVar3.p(R.color.CAM_X0302);
                this.f36834f.setConfig(cVar3);
                this.f36834f.setTextSize(R.dimen.tbds42);
                this.f36834f.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0eea));
            }
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.l = str;
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            l(i);
            this.n = i;
            SkinManager.setViewTextColor(this.f36831c, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.f36832d, R.color.CAM_X0211);
            SkinManager.setViewTextColor(this.f36833e, (int) R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.f36834f, (int) R.color.CAM_X0303);
            SkinManager.setViewTextColor(this.f36835g, (int) R.color.CAM_X0105);
        }
    }

    public void k(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, charSequence) == null) {
            this.k = charSequence;
        }
    }

    public final void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.tbds30);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(dimensionPixelSize);
            gradientDrawable.setColor(SkinManager.getColor(i, (int) R.color.CAM_X0211));
            this.f36830b.setBackgroundDrawable(gradientDrawable);
        }
    }

    public void m(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) {
            this.o = fVar;
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            WebSettings settings = this.f36832d.getSettings();
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            settings.setJavaScriptEnabled(true);
            this.f36832d.setWebViewClient(this.p);
            settings.setTextZoom(115);
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.j = str;
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onCreate(bundle);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.width = this.a.getResources().getDisplayMetrics().widthPixels - n.f(this.a, R.dimen.tbds90);
            layoutParams.height = n.f(this.a, R.dimen.tbds879);
            setContentView(this.f36830b, layoutParams);
            setCanceledOnTouchOutside(true);
            g();
            j(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
