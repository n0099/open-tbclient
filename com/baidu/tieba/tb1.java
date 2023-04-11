package com.baidu.tieba;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.dialog.BoxScrollView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class tb1 extends sb1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* loaded from: classes6.dex */
    public interface c {
        void a(tb1 tb1Var, b bVar);
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final b a;
        public final tb1 b;
        public Context c;
        public boolean d;
        public int e;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-409264119, "Lcom/baidu/tieba/tb1$a;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-409264119, "Lcom/baidu/tieba/tb1$a;");
            }
        }

        /* renamed from: com.baidu.tieba.tb1$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class View$OnClickListenerC0438a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DialogInterface.OnClickListener a;
            public final /* synthetic */ a b;

            public View$OnClickListenerC0438a(a aVar, DialogInterface.OnClickListener onClickListener) {
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
                    this.b.b.c(-1);
                    this.b.b.dismiss();
                    DialogInterface.OnClickListener onClickListener = this.a;
                    if (onClickListener != null) {
                        onClickListener.onClick(this.b.b, -1);
                    }
                }
            }
        }

        /* loaded from: classes6.dex */
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
                    this.b.b.c(-2);
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
            this.d = false;
            tb1 f = f(context);
            this.b = f;
            f.d(this);
            this.a = new b((ViewGroup) this.b.getWindow().getDecorView());
            this.c = context;
            this.e = context.getResources().getDimensionPixelSize(R.dimen.nad_dialog_btns_height);
        }

        public tb1 a() {
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
                DialogInterface.OnKeyListener onKeyListener = this.a.q;
                if (onKeyListener != null) {
                    this.b.setOnKeyListener(onKeyListener);
                }
                u();
                b bVar = this.a;
                c cVar = bVar.y;
                if (cVar != null) {
                    cVar.a(this.b, bVar);
                }
                this.b.d(this);
                return this.b;
            }
            return (tb1) invokeV.objValue;
        }

        public Resources b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.c.getResources();
            }
            return (Resources) invokeV.objValue;
        }

        public ViewGroup c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.a.p;
            }
            return (ViewGroup) invokeV.objValue;
        }

        public final void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.e);
                layoutParams.addRule(3, R.id.nad_dialog_message_content);
                this.a.u.setLayoutParams(layoutParams);
            }
        }

        public tb1 t() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                tb1 a = a();
                if (this.d) {
                    a.getWindow().setType(2003);
                }
                try {
                    a.show();
                } catch (WindowManager.BadTokenException unused) {
                }
                return a;
            }
            return (tb1) invokeV.objValue;
        }

        public a d(boolean z) {
            InterceptResult invokeZ;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
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

        public tb1 f(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
                return new tb1(context, R.style.obfuscated_res_0x7f10013c);
            }
            return (tb1) invokeL.objValue;
        }

        public a g(boolean z) {
            InterceptResult invokeZ;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                LinearLayout linearLayout = this.a.u;
                if (z) {
                    i = 0;
                } else {
                    i = 8;
                }
                linearLayout.setVisibility(i);
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public void h(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
                if (z) {
                    this.a.h.setVisibility(0);
                } else {
                    this.a.h.setVisibility(8);
                }
            }
        }

        public a i(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
                this.a.r.setImageResource(i);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a j(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                if (this.a.d.getVisibility() != 0) {
                    this.a.d.setVisibility(0);
                }
                if (str != null) {
                    this.a.c.setText(str);
                    k();
                }
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a n(DialogInterface.OnCancelListener onCancelListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, onCancelListener)) == null) {
                this.a.l = onCancelListener;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a q(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
                this.a.b.setText(this.c.getText(i));
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a r(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, charSequence)) == null) {
                if (!TextUtils.isEmpty(charSequence)) {
                    this.a.b.setText(charSequence);
                } else {
                    d(true);
                }
                return this;
            }
            return (a) invokeL.objValue;
        }

        public TextView e() {
            InterceptResult invokeV;
            int i;
            TextView textView;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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

        public a l(int i, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048587, this, i, onClickListener)) == null) {
                m(this.c.getText(i), onClickListener);
                return this;
            }
            return (a) invokeIL.objValue;
        }

        public a o(int i, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048590, this, i, onClickListener)) == null) {
                p(this.c.getText(i), onClickListener);
                return this;
            }
            return (a) invokeIL.objValue;
        }

        public a m(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, charSequence, onClickListener)) == null) {
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

        public a p(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, charSequence, onClickListener)) == null) {
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
                this.a.e.setOnClickListener(new View$OnClickListenerC0438a(this, onClickListener));
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a s(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, view2)) == null) {
                this.a.p.removeAllViews();
                this.a.p.addView(view2);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.e);
                layoutParams.addRule(3, R.id.dialog_customPanel);
                this.a.u.setLayoutParams(layoutParams);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final void u() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
                int color = b().getColor(R.color.nad_dialog_title_text_color);
                int color2 = b().getColor(R.color.nad_dialog_btn_text_color);
                int color3 = b().getColor(R.color.nad_dialog_btn_text_color);
                int color4 = b().getColor(R.color.nad_box_dialog_message_text_color);
                int color5 = b().getColor(R.color.nad_dialog_gray);
                this.a.s.setBackground(b().getDrawable(R.drawable.nad_custom_dialog_corner_bg));
                this.a.b.setTextColor(color);
                this.a.c.setTextColor(color4);
                b bVar = this.a;
                TextView textView = bVar.e;
                int i = bVar.w;
                if (i != -1) {
                    color3 = i;
                }
                textView.setTextColor(color3);
                b bVar2 = this.a;
                TextView textView2 = bVar2.f;
                int i2 = bVar2.x;
                if (i2 == -1) {
                    i2 = color2;
                }
                textView2.setTextColor(i2);
                this.a.g.setTextColor(color2);
                this.a.h.setBackgroundColor(color5);
                this.a.i.setBackgroundColor(color5);
                this.a.j.setBackgroundColor(color5);
                this.a.e.setBackground(b().getDrawable(R.drawable.nad_custom_dialog_btn_right_corner_bg_selector));
                this.a.f.setBackground(b().getDrawable(R.drawable.nad_custom_dialog_btn_left_corner_bg_selector));
                this.a.g.setBackgroundColor(b().getColor(R.color.nad_custom_dialog_btn_bg_selector));
                TextView e = e();
                if (e != null) {
                    e.setBackground(b().getDrawable(R.drawable.nad_custom_dialog_btn_corner_bg_selector));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
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
        public View o;
        public FrameLayout p;
        public DialogInterface.OnKeyListener q;
        public ImageView r;
        public RelativeLayout s;
        public BoxScrollView t;
        public LinearLayout u;
        public ViewGroup v;
        public int w;
        public int x;
        public c y;

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
            this.w = -1;
            this.x = -1;
            this.v = viewGroup;
            this.a = (LinearLayout) viewGroup.findViewById(R.id.nad_title_panel);
            this.b = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f090884);
            this.c = (TextView) viewGroup.findViewById(R.id.dialog_message);
            this.d = (LinearLayout) viewGroup.findViewById(R.id.nad_dialog_message_content);
            this.e = (TextView) viewGroup.findViewById(R.id.positive_button);
            this.f = (TextView) viewGroup.findViewById(R.id.negative_button);
            this.g = (TextView) viewGroup.findViewById(R.id.neutral_button);
            this.i = viewGroup.findViewById(R.id.obfuscated_res_0x7f0908b3);
            this.j = viewGroup.findViewById(R.id.obfuscated_res_0x7f0908b4);
            this.o = viewGroup.findViewById(R.id.dialog_customPanel);
            this.p = (FrameLayout) viewGroup.findViewById(R.id.dialog_custom_content);
            this.r = (ImageView) viewGroup.findViewById(R.id.dialog_icon);
            this.s = (RelativeLayout) viewGroup.findViewById(R.id.searchbox_alert_dialog);
            this.h = viewGroup.findViewById(R.id.obfuscated_res_0x7f0908b2);
            this.t = (BoxScrollView) viewGroup.findViewById(R.id.message_scrollview);
            this.u = (LinearLayout) viewGroup.findViewById(R.id.nad_btn_panel);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tb1(Context context, int i) {
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
        b();
    }

    public a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (a) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setContentView(R.layout.nad_custom_dialog_layout);
            getWindow().setLayout(-1, -1);
        }
    }

    public void d(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.a = aVar;
        }
    }
}
