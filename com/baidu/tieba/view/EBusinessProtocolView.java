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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
/* loaded from: classes4.dex */
public class EBusinessProtocolView extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f22198e;

    /* renamed from: f  reason: collision with root package name */
    public View f22199f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f22200g;

    /* renamed from: h  reason: collision with root package name */
    public WebView f22201h;

    /* renamed from: i  reason: collision with root package name */
    public TBSpecificationBtn f22202i;
    public TBSpecificationBtn j;
    public TextView k;
    public TBSpecificationBtn l;
    public boolean m;
    public String n;
    public CharSequence o;
    public String p;
    public final WindowType q;
    public int r;
    public f s;
    public WebViewClient t;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
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

        public WindowType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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

    /* loaded from: classes4.dex */
    public class a extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EBusinessProtocolView f22203a;

        public a(EBusinessProtocolView eBusinessProtocolView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eBusinessProtocolView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22203a = eBusinessProtocolView;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                String str2 = "javascript:setContentTextColor(" + this.f22203a.r + SmallTailInfo.EMOTION_SUFFIX;
                if (this.f22203a.f22201h != null) {
                    this.f22203a.f22201h.loadUrl(str2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EBusinessProtocolView f22204e;

        public b(EBusinessProtocolView eBusinessProtocolView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eBusinessProtocolView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22204e = eBusinessProtocolView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22204e.m = true;
                if (this.f22204e.s != null) {
                    this.f22204e.s.a(this.f22204e.m);
                }
                this.f22204e.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EBusinessProtocolView f22205e;

        public c(EBusinessProtocolView eBusinessProtocolView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eBusinessProtocolView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22205e = eBusinessProtocolView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22205e.m = false;
                if (this.f22205e.s != null) {
                    this.f22205e.s.a(this.f22205e.m);
                }
                this.f22205e.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EBusinessProtocolView f22206e;

        public d(EBusinessProtocolView eBusinessProtocolView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eBusinessProtocolView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22206e = eBusinessProtocolView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22206e.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f22207a;
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
            f22207a = iArr;
            try {
                iArr[WindowType.TIP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f22207a[WindowType.PROTOCOL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(boolean z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EBusinessProtocolView(@NonNull Context context, WindowType windowType) {
        super(context, R.style.e_business_protocol_dialog);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, windowType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = false;
        this.r = 0;
        this.t = new a(this);
        this.f22198e = context;
        this.q = windowType;
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        getWindow().setAttributes(attributes);
        this.f22199f = LayoutInflater.from(getContext()).inflate(R.layout.e_business_protocol_dialog, (ViewGroup) null);
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.j.setOnClickListener(new b(this));
            this.f22202i.setOnClickListener(new c(this));
            this.l.setOnClickListener(new d(this));
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f22200g = (TextView) this.f22199f.findViewById(R.id.protocol_title);
            this.f22201h = (WebView) this.f22199f.findViewById(R.id.protocol_content);
            this.j = (TBSpecificationBtn) this.f22199f.findViewById(R.id.agree_protocol);
            this.f22202i = (TBSpecificationBtn) this.f22199f.findViewById(R.id.cancel_protocol);
            this.k = (TextView) this.f22199f.findViewById(R.id.tip_content);
            this.l = (TBSpecificationBtn) findViewById(R.id.tip_known);
            h();
            f();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f22200g.setText(this.n);
            int i2 = e.f22207a[this.q.ordinal()];
            if (i2 == 1) {
                this.k.setVisibility(0);
                this.l.setVisibility(0);
                setCanceledOnTouchOutside(true);
                this.k.setText(this.o);
                this.l.setText(this.f22198e.getResources().getString(R.string.tip_known));
                d.a.p0.s.f0.n.c cVar = new d.a.p0.s.f0.n.c();
                cVar.o(R.color.CAM_X0302);
                this.l.setTextSize(R.dimen.T_X08);
                this.l.setConfig(cVar);
            } else if (i2 != 2) {
            } else {
                n();
                this.f22201h.setVisibility(0);
                this.j.setVisibility(0);
                this.f22202i.setVisibility(0);
                this.f22201h.loadUrl(this.p);
                d.a.p0.s.f0.n.c cVar2 = new d.a.p0.s.f0.n.c();
                cVar2.o(R.color.CAM_X0107);
                this.f22202i.setConfig(cVar2);
                this.f22202i.setTextSize(R.dimen.tbds42);
                this.f22202i.setText(this.f22198e.getResources().getString(R.string.protocol_cancel));
                this.j.setTextSize(R.dimen.tbds42);
                d.a.p0.s.f0.n.c cVar3 = new d.a.p0.s.f0.n.c();
                cVar3.o(R.color.CAM_X0302);
                this.j.setConfig(cVar3);
                this.j.setTextSize(R.dimen.tbds42);
                this.j.setText(this.f22198e.getResources().getString(R.string.protocol_agree));
            }
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.p = str;
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            l(i2);
            this.r = i2;
            SkinManager.setViewTextColor(this.f22200g, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.f22201h, R.color.CAM_X0211);
            SkinManager.setViewTextColor(this.f22202i, R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0303);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
        }
    }

    public void k(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, charSequence) == null) {
            this.o = charSequence;
        }
    }

    public final void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.tbds30);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(dimensionPixelSize);
            gradientDrawable.setColor(SkinManager.getColor(i2, R.color.CAM_X0211));
            this.f22199f.setBackgroundDrawable(gradientDrawable);
        }
    }

    public void m(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) {
            this.s = fVar;
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            WebSettings settings = this.f22201h.getSettings();
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            settings.setJavaScriptEnabled(true);
            this.f22201h.setWebViewClient(this.t);
            settings.setTextZoom(115);
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.n = str;
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onCreate(bundle);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.width = this.f22198e.getResources().getDisplayMetrics().widthPixels - l.g(this.f22198e, R.dimen.tbds90);
            layoutParams.height = l.g(this.f22198e, R.dimen.tbds879);
            setContentView(this.f22199f, layoutParams);
            setCanceledOnTouchOutside(true);
            g();
            j(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
