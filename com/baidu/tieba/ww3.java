package com.baidu.tieba;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.ad.component.AdScrollView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ww3 extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* loaded from: classes8.dex */
    public interface c {
        void a(ww3 ww3Var, b bVar);
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public b a;
        public final ww3 b;
        public Context c;
        public boolean d;
        public int e;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-303923143, "Lcom/baidu/tieba/ww3$a;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-303923143, "Lcom/baidu/tieba/ww3$a;");
            }
        }

        /* renamed from: com.baidu.tieba.ww3$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class View$OnClickListenerC0496a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DialogInterface.OnClickListener a;
            public final /* synthetic */ a b;

            public View$OnClickListenerC0496a(a aVar, DialogInterface.OnClickListener onClickListener) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, onClickListener};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.b.b.b(-1);
                    this.b.b.dismiss();
                    DialogInterface.OnClickListener onClickListener = this.a;
                    if (onClickListener != null) {
                        onClickListener.onClick(this.b.b, -1);
                    }
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DialogInterface.OnClickListener a;
            public final /* synthetic */ a b;

            public b(a aVar, DialogInterface.OnClickListener onClickListener) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, onClickListener};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.b.b.b(-2);
                    this.b.b.dismiss();
                    DialogInterface.OnClickListener onClickListener = this.a;
                    if (onClickListener != null) {
                        onClickListener.onClick(this.b.b, -2);
                    }
                }
            }
        }

        public a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.d = false;
            ww3 e = e(context);
            this.b = e;
            e.c(this);
            this.c = context;
            this.e = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0707b4);
            if (this.b.getWindow() != null) {
                this.a = new b((ViewGroup) this.b.getWindow().getDecorView());
            }
        }

        public ww3 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.b.setCancelable(this.a.k.booleanValue());
                if (this.a.k.booleanValue()) {
                    this.b.setCanceledOnTouchOutside(false);
                }
                this.b.setOnCancelListener(this.a.l);
                this.b.setOnDismissListener(this.a.m);
                this.b.setOnShowListener(this.a.n);
                DialogInterface.OnKeyListener onKeyListener = this.a.p;
                if (onKeyListener != null) {
                    this.b.setOnKeyListener(onKeyListener);
                }
                q();
                b bVar = this.a;
                c cVar = bVar.z;
                if (cVar != null) {
                    cVar.a(this.b, bVar);
                }
                this.b.c(this);
                return this.b;
            }
            return (ww3) invokeV.objValue;
        }

        public Resources b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.c.getResources();
            }
            return (Resources) invokeV.objValue;
        }

        public final void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.e);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f09089a);
                this.a.t.setLayoutParams(layoutParams);
            }
        }

        public ww3 p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                ww3 a = a();
                if (this.d && a.getWindow() != null) {
                    a.getWindow().setType(2003);
                }
                try {
                    a.show();
                } catch (WindowManager.BadTokenException unused) {
                }
                return a;
            }
            return (ww3) invokeV.objValue;
        }

        public a c(boolean z) {
            InterceptResult invokeZ;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                LinearLayout linearLayout = this.a.a;
                if (z) {
                    i = 8;
                } else {
                    i = 0;
                }
                linearLayout.setVisibility(i);
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public ww3 e(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
                return new ww3(context, R.style.obfuscated_res_0x7f100000);
            }
            return (ww3) invokeL.objValue;
        }

        public a g(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                if (this.a.d.getVisibility() != 0) {
                    this.a.d.setVisibility(0);
                }
                if (str != null) {
                    this.a.c.setText(str);
                    h();
                }
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a k(DialogInterface.OnDismissListener onDismissListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, onDismissListener)) == null) {
                this.a.m = onDismissListener;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a n(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
                o(b().getColor(i));
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a o(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
                b bVar = this.a;
                bVar.w = i;
                bVar.e.setTextColor(i);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public TextView d() {
            InterceptResult invokeV;
            int i;
            TextView textView;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                TextView textView2 = this.a.e;
                if (textView2 != null && textView2.getVisibility() == 0) {
                    textView = this.a.e;
                    i = 1;
                } else {
                    i = 0;
                    textView = null;
                }
                TextView textView3 = this.a.f;
                if (textView3 != null && textView3.getVisibility() == 0) {
                    i++;
                    textView = this.a.f;
                }
                TextView textView4 = this.a.g;
                if (textView4 != null && textView4.getVisibility() == 0) {
                    i++;
                    textView = this.a.g;
                }
                if (i != 1) {
                    return null;
                }
                return textView;
            }
            return (TextView) invokeV.objValue;
        }

        public a f(int i, int i2, int i3, int i4) {
            InterceptResult invokeIIII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048581, this, i, i2, i3, i4)) == null) {
                this.a.A.setPadding(i, i2, i3, i4);
                return this;
            }
            return (a) invokeIIII.objValue;
        }

        public a i(int i, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, onClickListener)) == null) {
                j(this.c.getText(i), onClickListener);
                return this;
            }
            return (a) invokeIL.objValue;
        }

        public a l(int i, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048587, this, i, onClickListener)) == null) {
                m(this.c.getText(i), onClickListener);
                return this;
            }
            return (a) invokeIL.objValue;
        }

        public a j(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, charSequence, onClickListener)) == null) {
                if (TextUtils.isEmpty(charSequence)) {
                    this.a.f.setVisibility(8);
                    if (this.a.e.getVisibility() == 0) {
                        this.a.i.setVisibility(8);
                    }
                    return this;
                }
                this.a.f.setVisibility(0);
                if (this.a.e.getVisibility() == 0) {
                    this.a.i.setVisibility(0);
                }
                this.a.f.setText(charSequence);
                this.a.f.setOnClickListener(new b(this, onClickListener));
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a m(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, charSequence, onClickListener)) == null) {
                if (TextUtils.isEmpty(charSequence)) {
                    this.a.e.setVisibility(8);
                    if (this.a.f.getVisibility() == 0) {
                        this.a.i.setVisibility(8);
                    }
                    return this;
                }
                this.a.e.setVisibility(0);
                if (this.a.f.getVisibility() == 0) {
                    this.a.i.setVisibility(0);
                }
                this.a.e.setText(charSequence);
                this.a.e.setOnClickListener(new View$OnClickListenerC0496a(this, onClickListener));
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public final void q() {
            Drawable drawable;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
                int color = b().getColor(R.color.obfuscated_res_0x7f060a81);
                int color2 = b().getColor(R.color.obfuscated_res_0x7f060a7e);
                int color3 = b().getColor(R.color.obfuscated_res_0x7f060a7e);
                int color4 = b().getColor(R.color.obfuscated_res_0x7f060a7d);
                int color5 = b().getColor(R.color.obfuscated_res_0x7f060a7f);
                RelativeLayout relativeLayout = this.a.r;
                Resources b2 = b();
                int i = this.a.C;
                if (i == -1) {
                    i = R.drawable.obfuscated_res_0x7f08135d;
                }
                relativeLayout.setBackground(b2.getDrawable(i));
                this.a.b.setTextColor(color);
                this.a.c.setTextColor(color4);
                b bVar = this.a;
                TextView textView = bVar.e;
                int i2 = bVar.w;
                if (i2 != color3) {
                    color3 = i2;
                }
                textView.setTextColor(color3);
                b bVar2 = this.a;
                int i3 = bVar2.x;
                if (i3 != color2) {
                    bVar2.f.setTextColor(i3);
                } else {
                    int i4 = bVar2.y;
                    if (i4 != -1) {
                        bVar2.f.setTextColor(AppCompatResources.getColorStateList(this.c, i4));
                    } else {
                        bVar2.f.setTextColor(color2);
                    }
                }
                this.a.g.setTextColor(color2);
                if (this.a.D != -1) {
                    color5 = b().getColor(this.a.D);
                }
                this.a.h.setBackgroundColor(color5);
                this.a.i.setBackgroundColor(color5);
                this.a.j.setBackgroundColor(color5);
                this.a.e.setBackground(b().getDrawable(R.drawable.obfuscated_res_0x7f08135b));
                this.a.f.setBackground(b().getDrawable(R.drawable.obfuscated_res_0x7f08135a));
                this.a.g.setBackground(b().getDrawable(R.drawable.obfuscated_res_0x7f081359));
                TextView d = d();
                if (d != null) {
                    if (this.a.E) {
                        drawable = b().getDrawable(R.drawable.obfuscated_res_0x7f081359);
                    } else {
                        drawable = null;
                    }
                    d.setBackground(drawable);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FrameLayout A;
        public View B;
        public int C;
        public int D;
        public boolean E;
        public LinearLayout a;
        public TextView b;
        public TextView c;
        public LinearLayout d;
        public TextView e;
        public TextView f;
        public TextView g;
        public View h;
        public View i;
        public View j;
        public Boolean k;
        public DialogInterface.OnCancelListener l;
        public DialogInterface.OnDismissListener m;
        public DialogInterface.OnShowListener n;
        public FrameLayout o;
        public DialogInterface.OnKeyListener p;
        public ImageView q;
        public RelativeLayout r;
        public AdScrollView s;
        public LinearLayout t;
        public View u;
        public ViewGroup v;
        public int w;
        public int x;
        public int y;
        public c z;

        public b(ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = Boolean.TRUE;
            this.y = -1;
            this.C = -1;
            this.D = -1;
            this.E = true;
            this.v = viewGroup;
            this.a = (LinearLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f092490);
            this.b = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0908a4);
            this.c = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f090899);
            this.d = (LinearLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f09089a);
            this.e = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091c25);
            this.f = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091851);
            this.g = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091864);
            this.i = viewGroup.findViewById(R.id.obfuscated_res_0x7f0908d3);
            this.j = viewGroup.findViewById(R.id.obfuscated_res_0x7f0908d4);
            this.o = (FrameLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f09088f);
            this.q = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f090893);
            this.r = (RelativeLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f09203b);
            this.h = viewGroup.findViewById(R.id.obfuscated_res_0x7f0908d2);
            this.s = (AdScrollView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0916f3);
            this.t = (LinearLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f0904c8);
            this.u = viewGroup.findViewById(R.id.obfuscated_res_0x7f09088e);
            this.A = (FrameLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f0908a0);
            this.B = viewGroup.findViewById(R.id.obfuscated_res_0x7f0918a9);
            int color = this.v.getResources().getColor(R.color.obfuscated_res_0x7f060a7e);
            this.w = color;
            this.x = color;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ww3(Context context, int i) {
        super(context, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
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
        a();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d06db);
            Window window = getWindow();
            if (window != null) {
                window.setLayout(-1, -1);
            }
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.dismiss();
        }
    }

    public void c(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.a = aVar;
        }
    }

    public void d(String str) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && (aVar = this.a) != null) {
            aVar.g(str);
        }
    }
}
