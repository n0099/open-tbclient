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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class n78 extends e9<BaseFragmentActivity> implements l78, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int C;
    public transient /* synthetic */ FieldHolder $fh;
    public TBAlertBuilder A;
    public boolean B;
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
    public EMTextView o;
    public EMTextView p;
    public LinearLayout q;
    public HeadImageView r;
    public TextView s;
    public View t;
    public List<View> u;
    public EMTextView v;
    public View w;
    @Nullable
    public j78 x;
    public Runnable y;
    public Runnable z;

    /* loaded from: classes6.dex */
    public class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n78 a;

        public a(n78 n78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n78Var;
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

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n78 a;

        public b(n78 n78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n78Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.T();
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n78 a;

        public c(n78 n78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n78Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ug.a(this.a.b, this.a.mContext.getPageActivity());
                this.a.H();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n78 a;

        public d(n78 n78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n78Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.x != null) {
                this.a.x.a(25, null);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947955482, "Lcom/baidu/tieba/n78;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947955482, "Lcom/baidu/tieba/n78;");
                return;
            }
        }
        C = UtilHelper.getDimenPixelSize(R.dimen.tbds78);
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
            AlertDialog create = new AlertDialog.Builder(this.mContext.getPageActivity(), R.style.obfuscated_res_0x7f10010a).create();
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
            List<View> list = this.u;
            if (list != null && list.size() > 0) {
                this.h.removeView(this.u.get(0));
                this.u.remove(0);
            } else {
                return;
            }
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.q != null) {
            p45 d2 = p45.d(this.s);
            d2.w(R.color.CAM_X0107);
            d2.B(R.dimen.T_X09);
        }
    }

    @Override // com.baidu.tieba.l78
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            S(0L);
        }
    }

    @Override // com.baidu.tieba.l78
    public void p() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && (linearLayout = this.q) != null) {
            linearLayout.setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n78(@NonNull g9<BaseFragmentActivity> g9Var) {
        super(g9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {g9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((g9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.u = new ArrayList();
        this.B = false;
        this.a = new WeakReference<>(g9Var.getPageActivity());
        C();
        D();
    }

    public void B(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            if (this.y == null) {
                this.y = new c(this);
            }
            sg.a().postDelayed(this.y, j);
        }
    }

    public final void J(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            EMTextView eMTextView = this.p;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public final void K(@Nullable Map<String, Object> map) {
        boolean z;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, map) == null) {
            if (map != null && map.containsKey("is_show_copy")) {
                z = ((Boolean) map.get("is_show_copy")).booleanValue();
            } else {
                z = true;
            }
            EMTextView eMTextView = this.i;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public final void M(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            EMTextView eMTextView = this.l;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public final void N(@Nullable Map<String, Object> map) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, map) == null) {
            int i = 0;
            if (map != null && map.containsKey("is_show_reply")) {
                z = ((Boolean) map.get("is_show_reply")).booleanValue();
            } else {
                z = false;
            }
            EMTextView eMTextView = this.j;
            if (!z) {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public final void O(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            EMTextView eMTextView = this.m;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public final void P(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            EMTextView eMTextView = this.k;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public void S(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048593, this, j) == null) {
            if (this.z == null) {
                this.z = new b(this);
            }
            sg.a().postDelayed(this.z, j);
        }
    }

    public final void V(@Nullable Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, map) == null) {
            K(map);
            N(map);
            O(false);
            M(false);
            P(true);
        }
    }

    public void W(@Nullable String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, str) == null) && !StringUtils.isNull(str)) {
            this.r.N(str, 12, false);
        }
    }

    @Override // com.baidu.tieba.l78
    public void n(@NonNull j78 j78Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, j78Var) == null) {
            this.x = j78Var;
        }
    }

    @SuppressLint({"InflateParams"})
    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0844, (ViewGroup) null);
            this.c = inflate;
            this.d = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090e6f);
            this.e = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090e68);
            this.f = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e6c);
            TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e6b);
            this.g = textView;
            textView.setMaxLines(1);
            this.g.setEllipsize(TextUtils.TruncateAt.END);
            this.h = (FlowLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090e4e);
            EMTextView eMTextView = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e61);
            this.i = eMTextView;
            eMTextView.setOnClickListener(this);
            EMTextView eMTextView2 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e66);
            this.k = eMTextView2;
            eMTextView2.setOnClickListener(this);
            EMTextView eMTextView3 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e63);
            this.l = eMTextView3;
            eMTextView3.setOnClickListener(this);
            EMTextView eMTextView4 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e65);
            this.m = eMTextView4;
            eMTextView4.setOnClickListener(this);
            EMTextView eMTextView5 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e4c);
            this.v = eMTextView5;
            eMTextView5.setOnClickListener(this);
            EMTextView eMTextView6 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e64);
            this.j = eMTextView6;
            eMTextView6.setOnClickListener(this);
            EMTextView eMTextView7 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e60);
            this.o = eMTextView7;
            eMTextView7.setOnClickListener(this);
            EMTextView eMTextView8 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e62);
            this.n = eMTextView8;
            eMTextView8.setOnClickListener(this);
            EMTextView eMTextView9 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e5f);
            this.p = eMTextView9;
            eMTextView9.setOnClickListener(this);
            this.w = this.c.findViewById(R.id.obfuscated_res_0x7f090413);
            if (!E()) {
                I();
            }
        }
    }

    @Override // com.baidu.tieba.l78
    public void a() {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            p45 d2 = p45.d(this.d);
            d2.o(R.string.J_X14);
            d2.f(R.color.CAM_X0213);
            p45 d3 = p45.d(this.e);
            d3.o(R.string.J_X14);
            d3.f(R.color.CAM_X0209);
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0213);
            SkinManager.setBackgroundResource(this.w, R.color.CAM_X0213);
            SkinManager.setBackgroundResource(this.v, R.color.CAM_X0213);
            p45 d4 = p45.d(this.f);
            d4.w(R.color.CAM_X0109);
            d4.B(R.dimen.T_X08);
            d4.C(R.string.F_X01);
            p45 d5 = p45.d(this.g);
            d5.w(R.color.CAM_X0107);
            d5.B(R.dimen.T_X08);
            R();
            SkinManager.setViewTextColorSelector(this.v, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0107, 1);
            int width = ((WindowManager) this.mContext.getPageActivity().getSystemService("window")).getDefaultDisplay().getWidth() - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2);
            if (E()) {
                i = (width - (UtilHelper.getDimenPixelSize(R.dimen.tbds201) * 5)) / 4;
            } else {
                i = (width - 1005) / 4;
            }
            this.h.setHorizontalSpacing(i);
            Q(this.p, R.drawable.obfuscated_res_0x7f0800e2);
            Q(this.i, R.drawable.obfuscated_res_0x7f0804bf);
            Q(this.k, R.drawable.obfuscated_res_0x7f0804c3);
            Q(this.l, R.drawable.obfuscated_res_0x7f0804c0);
            Q(this.m, R.drawable.obfuscated_res_0x7f0804c2);
            Q(this.j, R.drawable.obfuscated_res_0x7f0804c1);
            Q(this.o, R.drawable.obfuscated_res_0x7f080b54);
            EMTextView eMTextView = this.n;
            if (this.B) {
                i2 = R.drawable.obfuscated_res_0x7f0804c4;
            } else {
                i2 = R.drawable.obfuscated_res_0x7f0804c5;
            }
            Q(eMTextView, i2);
            TBAlertBuilder tBAlertBuilder = this.A;
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

    @Override // com.baidu.tieba.l78
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            if (this.b != null) {
                this.b = null;
            }
            if (this.z != null) {
                sg.a().removeCallbacks(this.z);
                this.z = null;
            }
            if (this.y != null) {
                sg.a().removeCallbacks(this.y);
                this.y = null;
            }
        }
    }

    public final void F(int i, @Nullable Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, map) == null) {
            if (i != 0) {
                if (i != 1 && i != 2 && i != 3) {
                    if (i == 64) {
                        K(map);
                        N(map);
                        O(true);
                        M(false);
                        P(true);
                        return;
                    }
                    return;
                }
                K(map);
                N(map);
                O(true);
                M(false);
                P(false);
                return;
            }
            K(map);
            N(map);
            O(true);
            M(true);
            P(true);
        }
    }

    public final void G(int i, @Nullable Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, map) == null) {
            if (i == 0 || i == 1 || i == 2 || i == 64) {
                K(map);
                N(map);
                O(true);
                M(false);
                P(false);
            }
        }
    }

    public final void Q(TextView textView, int i) {
        Drawable pureDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048591, this, textView, i) != null) || textView == null || (pureDrawable = WebPManager.getPureDrawable(i, SkinManager.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS)) == null) {
            return;
        }
        int i2 = C;
        pureDrawable.setBounds(0, 0, i2, i2);
        textView.setCompoundDrawables(null, pureDrawable, null, null);
    }

    @Override // com.baidu.tieba.l78
    @SuppressLint({"SetTextI18n"})
    public void m(@NonNull String str, @NonNull CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, str, charSequence) == null) {
            TextView textView = this.f;
            textView.setText(str + ZeusCrashHandler.NAME_SEPERATOR);
            this.g.setText(charSequence);
        }
    }

    @Override // com.baidu.tieba.l78
    public void r(@NonNull String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, str, str2) == null) {
            this.s.setText(str);
            W(str2);
            this.q.setVisibility(0);
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.p.getLayoutParams().width = 201;
            this.i.getLayoutParams().width = 201;
            this.j.getLayoutParams().width = 201;
            this.k.getLayoutParams().width = 201;
            this.l.getLayoutParams().width = 201;
            this.m.getLayoutParams().width = 201;
            this.n.getLayoutParams().width = 201;
            LinearLayout linearLayout = this.q;
            if (linearLayout != null) {
                linearLayout.getLayoutParams().width = 201;
            }
        }
    }

    public final boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            AlertDialog alertDialog = this.b;
            if (alertDialog == null) {
                return false;
            }
            boolean i = ug.i(alertDialog, this.mContext.getPageActivity());
            Window window = this.b.getWindow();
            window.addFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = ri.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.obfuscated_res_0x7f100417);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.c);
            window.setDimAmount(0.33f);
            return i;
        }
        return invokeV.booleanValue;
    }

    public final void U(int i, @Nullable Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048595, this, i, map) == null) {
            if (i != 0) {
                if (i == 1 || i == 2 || i == 64) {
                    K(map);
                    O(true);
                    N(map);
                    M(false);
                    P(true);
                    return;
                }
                return;
            }
            K(map);
            O(true);
            N(map);
            M(true);
            P(true);
        }
    }

    @Override // com.baidu.tieba.l78
    public void c(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            BdTopToast bdTopToast = new BdTopToast(this.mContext.getContext());
            bdTopToast.h(true);
            bdTopToast.g(str);
            bdTopToast.i((ViewGroup) this.mContext.getPageActivity().findViewById(16908290));
        }
    }

    @Override // com.baidu.tieba.l78
    public void l(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            if (this.A == null) {
                this.A = new TBAlertBuilder(this.a.get());
            }
            this.A.w(R.string.obfuscated_res_0x7f0f08f5);
            this.A.q(str);
            this.A.o(true);
            this.A.u(new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f057a, TBAlertConfig.OperateBtnStyle.SECONDARY), new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f08f5, TBAlertConfig.OperateBtnStyle.MAIN, new d(this)));
            this.A.i();
            this.A.j(false);
            this.A.z();
        }
    }

    @Override // com.baidu.tieba.l78
    public void o(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, obj) == null) {
            View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d018b, (ViewGroup) null);
            this.t = inflate;
            this.q = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091e75);
            this.r = (HeadImageView) this.t.findViewById(R.id.obfuscated_res_0x7f091e79);
            this.s = (TextView) this.t.findViewById(R.id.obfuscated_res_0x7f091e8a);
            R();
            this.r.setIsRound(true);
            this.r.setDrawBorder(false);
            this.r.setPlaceHolder(1);
            this.q.setOnClickListener(this);
            this.q.setTag(obj);
            this.h.addView(this.t);
            this.u.add(this.t);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        j78 j78Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, view2) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f090e61) {
                j78 j78Var2 = this.x;
                if (j78Var2 != null) {
                    j78Var2.a(19, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090e66) {
                j78 j78Var3 = this.x;
                if (j78Var3 != null) {
                    j78Var3.a(18, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090e63) {
                j78 j78Var4 = this.x;
                if (j78Var4 != null) {
                    j78Var4.a(17, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090e65) {
                j78 j78Var5 = this.x;
                if (j78Var5 != null) {
                    j78Var5.a(20, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090e64) {
                j78 j78Var6 = this.x;
                if (j78Var6 != null) {
                    j78Var6.a(21, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090e4c) {
                j78 j78Var7 = this.x;
                if (j78Var7 != null) {
                    j78Var7.a(22, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090e60) {
                j78 j78Var8 = this.x;
                if (j78Var8 != null) {
                    j78Var8.a(23, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f091e75) {
                if (this.x != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("robot_tag", view2.getTag());
                    this.x.a(24, hashMap);
                }
            } else if (id == R.id.obfuscated_res_0x7f090e62) {
                j78 j78Var9 = this.x;
                if (j78Var9 != null) {
                    j78Var9.a(33, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090e5f && (j78Var = this.x) != null) {
                j78Var.a(32, null);
            }
            A();
        }
    }

    @Override // com.baidu.tieba.l78
    public void q(boolean z, int i, int i2, @Nullable Map<String, Object> map, boolean z2, long j, long j2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), map, Boolean.valueOf(z2), Long.valueOf(j), Long.valueOf(j2)}) == null) {
            if (z) {
                V(map);
            } else if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        U(i, map);
                    }
                } else {
                    F(i, map);
                }
            } else {
                G(i, map);
            }
            int i4 = 0;
            if (map != null && map.containsKey("is_show_bubble")) {
                boolean booleanValue = ((Boolean) map.get("is_show_bubble")).booleanValue();
                EMTextView eMTextView = this.o;
                if (booleanValue) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                eMTextView.setVisibility(i3);
            } else {
                this.o.setVisibility(8);
            }
            if (z2) {
                J(true);
                r08.a(1, 1, j, j2);
            } else {
                J(false);
            }
            if (map != null && map.containsKey("is_show_excellent_btn")) {
                boolean booleanValue2 = ((Boolean) map.get("is_show_excellent_btn")).booleanValue();
                EMTextView eMTextView2 = this.n;
                if (!booleanValue2) {
                    i4 = 8;
                }
                eMTextView2.setVisibility(i4);
            } else {
                this.n.setVisibility(8);
            }
            int i5 = R.string.obfuscated_res_0x7f0f040a;
            int i6 = R.drawable.obfuscated_res_0x7f0804c5;
            if (map != null && map.containsKey("is_excellent_msg")) {
                boolean booleanValue3 = ((Boolean) map.get("is_excellent_msg")).booleanValue();
                this.B = booleanValue3;
                EMTextView eMTextView3 = this.n;
                if (booleanValue3) {
                    i6 = R.drawable.obfuscated_res_0x7f0804c4;
                }
                Q(eMTextView3, i6);
                EMTextView eMTextView4 = this.n;
                if (this.B) {
                    i5 = R.string.obfuscated_res_0x7f0f0409;
                }
                eMTextView4.setText(i5);
                return;
            }
            Q(this.n, R.drawable.obfuscated_res_0x7f0804c5);
            this.n.setText(R.string.obfuscated_res_0x7f0f040a);
        }
    }

    @Override // com.baidu.tieba.l78
    public void s(int i, int i2, @Nullable String str) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048610, this, i, i2, str) == null) {
            if (i != 1) {
                if (i == 3 && i2 == 1) {
                    boolean z = !this.B;
                    this.B = z;
                    EMTextView eMTextView = this.n;
                    if (z) {
                        i3 = R.drawable.obfuscated_res_0x7f0804c4;
                    } else {
                        i3 = R.drawable.obfuscated_res_0x7f0804c5;
                    }
                    Q(eMTextView, i3);
                    c(str);
                }
            } else if (i2 == 1) {
                c(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f08f9));
            }
        }
    }
}
