package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class y38 extends y8<BaseFragmentActivity> implements w38, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int z;
    public transient /* synthetic */ FieldHolder $fh;
    public final WeakReference<Activity> a;
    @Nullable
    public AlertDialog b;
    public View c;
    public LinearLayout d;
    public LinearLayout e;
    public TextView f;
    public TextView g;
    public FlowLayout h;
    public EMTextView i;
    public EMTextView j;
    public EMTextView k;
    public EMTextView l;
    public EMTextView m;
    public EMTextView n;
    public LinearLayout o;
    public HeadImageView p;
    public TextView q;
    public View r;
    public List<View> s;
    public EMTextView t;
    public View u;
    @Nullable
    public u38 v;
    public Runnable w;
    public Runnable x;
    public TBAlertBuilder y;

    /* loaded from: classes7.dex */
    public class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y38 a;

        public a(y38 y38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y38Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
                this.a.H();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y38 a;

        public b(y38 y38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y38Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.S();
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y38 a;

        public c(y38 y38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y38Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                lg.a(this.a.b, this.a.mContext.getPageActivity());
                this.a.H();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y38 a;

        public d(y38 y38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y38Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.v != null) {
                this.a.v.a(25);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948279339, "Lcom/baidu/tieba/y38;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948279339, "Lcom/baidu/tieba/y38;");
                return;
            }
        }
        z = UtilHelper.getDimenPixelSize(R.dimen.tbds78);
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            B(0L);
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            AlertDialog create = new AlertDialog.Builder(this.mContext.getPageActivity(), R.style.obfuscated_res_0x7f100108).create();
            this.b = create;
            create.setCanceledOnTouchOutside(true);
            this.b.setOnDismissListener(new a(this));
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048583, this) != null) {
            return;
        }
        while (true) {
            List<View> list = this.s;
            if (list != null && list.size() > 0) {
                this.h.removeView(this.s.get(0));
                this.s.remove(0);
            } else {
                return;
            }
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.o != null) {
            q25 d2 = q25.d(this.q);
            d2.w(R.color.CAM_X0107);
            d2.B(R.dimen.T_X09);
        }
    }

    @Override // com.baidu.tieba.w38
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            R(0L);
        }
    }

    @Override // com.baidu.tieba.w38
    public void o() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && (linearLayout = this.o) != null) {
            linearLayout.setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y38(@NonNull a9<BaseFragmentActivity> a9Var) {
        super(a9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((a9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.s = new ArrayList();
        this.a = new WeakReference<>(a9Var.getPageActivity());
        C();
        D();
    }

    public void B(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            if (this.w == null) {
                this.w = new c(this);
            }
            jg.a().postDelayed(this.w, j);
        }
    }

    public final void J(boolean z2) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z2) == null) {
            EMTextView eMTextView = this.i;
            if (z2) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public final void K(boolean z2) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z2) == null) {
            EMTextView eMTextView = this.l;
            if (z2) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public final void M(@Nullable Map<String, Object> map) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, map) == null) {
            int i = 0;
            if (map != null && map.containsKey("is_show_reply")) {
                z2 = ((Boolean) map.get("is_show_reply")).booleanValue();
            } else {
                z2 = false;
            }
            EMTextView eMTextView = this.j;
            if (!z2) {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public final void N(boolean z2) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z2) == null) {
            EMTextView eMTextView = this.m;
            if (z2) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public final void O(boolean z2) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z2) == null) {
            EMTextView eMTextView = this.k;
            if (z2) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public void R(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j) == null) {
            if (this.x == null) {
                this.x = new b(this);
            }
            jg.a().postDelayed(this.x, j);
        }
    }

    public final void U(@Nullable Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, map) == null) {
            J(true);
            M(map);
            N(false);
            K(false);
            O(true);
        }
    }

    public void V(@Nullable String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, str) == null) && !StringUtils.isNull(str)) {
            this.p.N(str, 12, false);
        }
    }

    @Override // com.baidu.tieba.w38
    public void n(@NonNull u38 u38Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, u38Var) == null) {
            this.v = u38Var;
        }
    }

    @SuppressLint({"InflateParams"})
    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0807, (ViewGroup) null);
            this.c = inflate;
            this.d = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090e37);
            this.e = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090e30);
            this.f = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e34);
            TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e33);
            this.g = textView;
            textView.setMaxLines(1);
            this.g.setEllipsize(TextUtils.TruncateAt.END);
            this.h = (FlowLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090e18);
            EMTextView eMTextView = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e2a);
            this.i = eMTextView;
            eMTextView.setOnClickListener(this);
            EMTextView eMTextView2 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e2e);
            this.k = eMTextView2;
            eMTextView2.setOnClickListener(this);
            EMTextView eMTextView3 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e2b);
            this.l = eMTextView3;
            eMTextView3.setOnClickListener(this);
            EMTextView eMTextView4 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e2d);
            this.m = eMTextView4;
            eMTextView4.setOnClickListener(this);
            EMTextView eMTextView5 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e16);
            this.t = eMTextView5;
            eMTextView5.setOnClickListener(this);
            EMTextView eMTextView6 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e2c);
            this.j = eMTextView6;
            eMTextView6.setOnClickListener(this);
            EMTextView eMTextView7 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e29);
            this.n = eMTextView7;
            eMTextView7.setOnClickListener(this);
            this.u = this.c.findViewById(R.id.obfuscated_res_0x7f090400);
            if (!E()) {
                I();
            }
        }
    }

    @Override // com.baidu.tieba.w38
    public void a() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            q25 d2 = q25.d(this.d);
            d2.o(R.string.J_X14);
            d2.f(R.color.CAM_X0213);
            q25 d3 = q25.d(this.e);
            d3.o(R.string.J_X14);
            d3.f(R.color.CAM_X0209);
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0213);
            SkinManager.setBackgroundResource(this.u, R.color.CAM_X0213);
            SkinManager.setBackgroundResource(this.t, R.color.CAM_X0213);
            q25 d4 = q25.d(this.f);
            d4.w(R.color.CAM_X0109);
            d4.B(R.dimen.T_X08);
            d4.C(R.string.F_X01);
            q25 d5 = q25.d(this.g);
            d5.w(R.color.CAM_X0107);
            d5.B(R.dimen.T_X08);
            Q();
            SkinManager.setViewTextColorSelector(this.t, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0107, 1);
            int width = ((WindowManager) this.mContext.getPageActivity().getSystemService("window")).getDefaultDisplay().getWidth() - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2);
            if (E()) {
                i = (width - (UtilHelper.getDimenPixelSize(R.dimen.tbds201) * 5)) / 4;
            } else {
                i = (width - 1005) / 4;
            }
            this.h.setHorizontalSpacing(i);
            P(this.i, R.drawable.obfuscated_res_0x7f080469);
            P(this.k, R.drawable.obfuscated_res_0x7f08046d);
            P(this.l, R.drawable.obfuscated_res_0x7f08046a);
            P(this.m, R.drawable.obfuscated_res_0x7f08046c);
            P(this.j, R.drawable.obfuscated_res_0x7f08046b);
            P(this.n, R.drawable.obfuscated_res_0x7f080a00);
            TBAlertBuilder tBAlertBuilder = this.y;
            if (tBAlertBuilder != null) {
                tBAlertBuilder.g();
            }
        }
    }

    public final boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) this.mContext.getPageActivity().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.densityDpi;
            if (i % 160 != 0 && (i * 1.0f) / 160.0f != 1.5d) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.i.getLayoutParams().width = 201;
            this.j.getLayoutParams().width = 201;
            this.k.getLayoutParams().width = 201;
            this.l.getLayoutParams().width = 201;
            this.m.getLayoutParams().width = 201;
            LinearLayout linearLayout = this.o;
            if (linearLayout != null) {
                linearLayout.getLayoutParams().width = 201;
            }
        }
    }

    @Override // com.baidu.tieba.w38
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            if (this.b != null) {
                this.b = null;
            }
            if (this.x != null) {
                jg.a().removeCallbacks(this.x);
                this.x = null;
            }
            if (this.w != null) {
                jg.a().removeCallbacks(this.w);
                this.w = null;
            }
        }
    }

    public final void F(int i, @Nullable Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, map) == null) {
            if (i != 0) {
                if (i != 1 && i != 2 && i != 3) {
                    if (i == 64) {
                        J(true);
                        M(map);
                        N(true);
                        K(false);
                        O(true);
                        return;
                    }
                    return;
                }
                J(true);
                M(map);
                N(true);
                K(false);
                O(false);
                return;
            }
            J(true);
            M(map);
            N(true);
            K(true);
            O(true);
        }
    }

    public final void G(int i, @Nullable Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, map) == null) {
            if (i == 0 || i == 1 || i == 2 || i == 64) {
                J(true);
                M(map);
                N(true);
                K(false);
                O(false);
            }
        }
    }

    public final void P(TextView textView, int i) {
        Drawable pureDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048590, this, textView, i) != null) || textView == null || (pureDrawable = WebPManager.getPureDrawable(i, SkinManager.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS)) == null) {
            return;
        }
        int i2 = z;
        pureDrawable.setBounds(0, 0, i2, i2);
        textView.setCompoundDrawables(null, pureDrawable, null, null);
    }

    @Override // com.baidu.tieba.w38
    @SuppressLint({"SetTextI18n"})
    public void m(@NonNull String str, @NonNull CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, str, charSequence) == null) {
            TextView textView = this.f;
            textView.setText(str + ZeusCrashHandler.NAME_SEPERATOR);
            this.g.setText(charSequence);
        }
    }

    @Override // com.baidu.tieba.w38
    public void q(@NonNull String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048608, this, str, str2) == null) {
            this.q.setText(str);
            V(str2);
            this.o.setVisibility(0);
        }
    }

    public final boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            AlertDialog alertDialog = this.b;
            if (alertDialog == null) {
                return false;
            }
            boolean i = lg.i(alertDialog, this.mContext.getPageActivity());
            Window window = this.b.getWindow();
            window.addFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = ii.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.obfuscated_res_0x7f100404);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.c);
            window.setDimAmount(0.33f);
            return i;
        }
        return invokeV.booleanValue;
    }

    public final void T(int i, @Nullable Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048594, this, i, map) == null) {
            if (i != 0) {
                if (i == 1 || i == 2 || i == 64) {
                    J(true);
                    N(true);
                    M(map);
                    K(false);
                    O(true);
                    return;
                }
                return;
            }
            J(true);
            N(true);
            M(map);
            K(true);
            O(true);
        }
    }

    @Override // com.baidu.tieba.w38
    public void c(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            BdTopToast bdTopToast = new BdTopToast(this.mContext.getContext());
            bdTopToast.h(true);
            bdTopToast.g(str);
            bdTopToast.i((ViewGroup) this.mContext.getPageActivity().findViewById(16908290));
        }
    }

    @Override // com.baidu.tieba.w38
    public void k(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            if (this.y == null) {
                this.y = new TBAlertBuilder(this.a.get());
            }
            this.y.w(R.string.obfuscated_res_0x7f0f0877);
            this.y.q(str);
            this.y.o(true);
            this.y.u(new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0519, TBAlertConfig.OperateBtnStyle.SECONDARY), new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0877, TBAlertConfig.OperateBtnStyle.MAIN, new d(this)));
            this.y.i();
            this.y.j(false);
            this.y.z();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        u38 u38Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, view2) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f090e2a) {
                u38 u38Var2 = this.v;
                if (u38Var2 != null) {
                    u38Var2.a(19);
                }
            } else if (id == R.id.obfuscated_res_0x7f090e2e) {
                u38 u38Var3 = this.v;
                if (u38Var3 != null) {
                    u38Var3.a(18);
                }
            } else if (id == R.id.obfuscated_res_0x7f090e2b) {
                u38 u38Var4 = this.v;
                if (u38Var4 != null) {
                    u38Var4.a(17);
                }
            } else if (id == R.id.obfuscated_res_0x7f090e2d) {
                u38 u38Var5 = this.v;
                if (u38Var5 != null) {
                    u38Var5.a(20);
                }
            } else if (id == R.id.obfuscated_res_0x7f090e2c) {
                u38 u38Var6 = this.v;
                if (u38Var6 != null) {
                    u38Var6.a(21);
                }
            } else if (id == R.id.obfuscated_res_0x7f090e16) {
                u38 u38Var7 = this.v;
                if (u38Var7 != null) {
                    u38Var7.a(22);
                }
            } else if (id == R.id.obfuscated_res_0x7f090e29) {
                u38 u38Var8 = this.v;
                if (u38Var8 != null) {
                    u38Var8.a(23);
                }
            } else if (id == R.id.obfuscated_res_0x7f091e09 && (u38Var = this.v) != null) {
                u38Var.a(24);
            }
            A();
        }
    }

    @Override // com.baidu.tieba.w38
    public void l(boolean z2, int i, int i2, @Nullable Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), map}) == null) {
            if (z2) {
                U(map);
            } else if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        T(i, map);
                    }
                } else {
                    F(i, map);
                }
            } else {
                G(i, map);
            }
            int i3 = 8;
            if (map != null && map.containsKey("is_show_bubble")) {
                boolean booleanValue = ((Boolean) map.get("is_show_bubble")).booleanValue();
                EMTextView eMTextView = this.n;
                if (booleanValue) {
                    i3 = 0;
                }
                eMTextView.setVisibility(i3);
                return;
            }
            this.n.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.w38
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0181, (ViewGroup) null);
            this.r = inflate;
            this.o = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091e09);
            this.p = (HeadImageView) this.r.findViewById(R.id.obfuscated_res_0x7f091e0d);
            this.q = (TextView) this.r.findViewById(R.id.obfuscated_res_0x7f091e1b);
            Q();
            this.p.setIsRound(true);
            this.p.setDrawBorder(false);
            this.p.setPlaceHolder(1);
            this.o.setOnClickListener(this);
            this.h.addView(this.r);
            this.s.add(this.r);
        }
    }

    @Override // com.baidu.tieba.w38
    public void r(int i, int i2, @Nullable String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048609, this, i, i2, str) == null) && i == 1 && i2 == 1) {
            c(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f087b));
        }
    }
}
