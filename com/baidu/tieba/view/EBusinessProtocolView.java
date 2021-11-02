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
import b.a.e.e.p.l;
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
/* loaded from: classes9.dex */
public class EBusinessProtocolView extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f55249e;

    /* renamed from: f  reason: collision with root package name */
    public View f55250f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f55251g;

    /* renamed from: h  reason: collision with root package name */
    public WebView f55252h;

    /* renamed from: i  reason: collision with root package name */
    public TBSpecificationBtn f55253i;
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
    /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
    public class a extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EBusinessProtocolView f55254a;

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
            this.f55254a = eBusinessProtocolView;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                String str2 = "javascript:setContentTextColor(" + this.f55254a.r + SmallTailInfo.EMOTION_SUFFIX;
                if (this.f55254a.f55252h != null) {
                    this.f55254a.f55252h.loadUrl(str2);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EBusinessProtocolView f55255e;

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
            this.f55255e = eBusinessProtocolView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f55255e.m = true;
                if (this.f55255e.s != null) {
                    this.f55255e.s.a(this.f55255e.m);
                }
                this.f55255e.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EBusinessProtocolView f55256e;

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
            this.f55256e = eBusinessProtocolView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f55256e.m = false;
                if (this.f55256e.s != null) {
                    this.f55256e.s.a(this.f55256e.m);
                }
                this.f55256e.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EBusinessProtocolView f55257e;

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
            this.f55257e = eBusinessProtocolView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f55257e.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static /* synthetic */ class e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f55258a;
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
            f55258a = iArr;
            try {
                iArr[WindowType.TIP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f55258a[WindowType.PROTOCOL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes9.dex */
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
        this.f55249e = context;
        this.q = windowType;
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        getWindow().setAttributes(attributes);
        this.f55250f = LayoutInflater.from(getContext()).inflate(R.layout.e_business_protocol_dialog, (ViewGroup) null);
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.j.setOnClickListener(new b(this));
            this.f55253i.setOnClickListener(new c(this));
            this.l.setOnClickListener(new d(this));
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f55251g = (TextView) this.f55250f.findViewById(R.id.protocol_title);
            this.f55252h = (WebView) this.f55250f.findViewById(R.id.protocol_content);
            this.j = (TBSpecificationBtn) this.f55250f.findViewById(R.id.agree_protocol);
            this.f55253i = (TBSpecificationBtn) this.f55250f.findViewById(R.id.cancel_protocol);
            this.k = (TextView) this.f55250f.findViewById(R.id.tip_content);
            this.l = (TBSpecificationBtn) findViewById(R.id.tip_known);
            h();
            f();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f55251g.setText(this.n);
            int i2 = e.f55258a[this.q.ordinal()];
            if (i2 == 1) {
                this.k.setVisibility(0);
                this.l.setVisibility(0);
                setCanceledOnTouchOutside(true);
                this.k.setText(this.o);
                this.l.setText(this.f55249e.getResources().getString(R.string.tip_known));
                b.a.q0.s.g0.n.c cVar = new b.a.q0.s.g0.n.c();
                cVar.p(R.color.CAM_X0302);
                this.l.setTextSize(R.dimen.T_X08);
                this.l.setConfig(cVar);
            } else if (i2 != 2) {
            } else {
                j();
                this.f55252h.setVisibility(0);
                this.j.setVisibility(0);
                this.f55253i.setVisibility(0);
                this.f55252h.loadUrl(this.p);
                b.a.q0.s.g0.n.c cVar2 = new b.a.q0.s.g0.n.c();
                cVar2.p(R.color.CAM_X0107);
                this.f55253i.setConfig(cVar2);
                this.f55253i.setTextSize(R.dimen.tbds42);
                this.f55253i.setText(this.f55249e.getResources().getString(R.string.protocol_cancel));
                this.j.setTextSize(R.dimen.tbds42);
                b.a.q0.s.g0.n.c cVar3 = new b.a.q0.s.g0.n.c();
                cVar3.p(R.color.CAM_X0302);
                this.j.setConfig(cVar3);
                this.j.setTextSize(R.dimen.tbds42);
                this.j.setText(this.f55249e.getResources().getString(R.string.protocol_agree));
            }
        }
    }

    public final void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.tbds30);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(dimensionPixelSize);
            gradientDrawable.setColor(SkinManager.getColor(i2, R.color.CAM_X0211));
            this.f55250f.setBackgroundDrawable(gradientDrawable);
        }
    }

    public boolean isAgreeProtocol() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            WebSettings settings = this.f55252h.getSettings();
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            settings.setJavaScriptEnabled(true);
            this.f55252h.setWebViewClient(this.t);
            settings.setTextZoom(115);
        }
    }

    public void loadWebUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.p = str;
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            i(i2);
            this.r = i2;
            SkinManager.setViewTextColor(this.f55251g, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.f55252h, R.color.CAM_X0211);
            SkinManager.setViewTextColor(this.f55253i, R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0303);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.width = this.f55249e.getResources().getDisplayMetrics().widthPixels - l.g(this.f55249e, R.dimen.tbds90);
            layoutParams.height = l.g(this.f55249e, R.dimen.tbds879);
            setContentView(this.f55250f, layoutParams);
            setCanceledOnTouchOutside(true);
            g();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void setContent(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, charSequence) == null) {
            this.o = charSequence;
        }
    }

    public void setOnProtocolStateListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
            this.s = fVar;
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.n = str;
        }
    }
}
