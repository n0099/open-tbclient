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
import com.baidu.adp.base.BdBaseView;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.data.Reaction;
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
/* loaded from: classes8.dex */
public class wh8 extends BdBaseView<BaseFragmentActivity> implements uh8, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int D;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable A;
    public TBAlertBuilder B;
    public boolean C;
    public final WeakReference<Activity> a;
    @Nullable
    public AlertDialog b;
    public View c;
    public LinearLayout d;
    public LinearLayout e;
    public TextView f;
    public TextView g;
    public FlowLayout h;
    @NonNull
    public final zh8 i;
    public EMTextView j;
    public EMTextView k;
    public EMTextView l;
    public EMTextView m;
    public EMTextView n;
    public EMTextView o;
    public EMTextView p;
    public EMTextView q;
    public LinearLayout r;
    public HeadImageView s;
    public TextView t;
    public View u;
    public List<View> v;
    public EMTextView w;
    public View x;
    @NonNull
    public sh8 y;
    public Runnable z;

    /* loaded from: classes8.dex */
    public class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wh8 a;

        public a(wh8 wh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wh8Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
                this.a.J();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wh8 a;

        public b(wh8 wh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wh8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.W();
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wh8 a;

        public c(wh8 wh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wh8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                jg.a(this.a.b, this.a.mContext.getPageActivity());
                this.a.J();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wh8 a;

        public d(wh8 wh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wh8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.y != null) {
                this.a.y.a(25, null);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948270690, "Lcom/baidu/tieba/wh8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948270690, "Lcom/baidu/tieba/wh8;");
                return;
            }
        }
        D = UtilHelper.getDimenPixelSize(R.dimen.tbds78);
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            D(0L);
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            AlertDialog create = new AlertDialog.Builder(this.mContext.getPageActivity(), R.style.obfuscated_res_0x7f10010d).create();
            this.b = create;
            create.setCanceledOnTouchOutside(true);
            this.b.setOnDismissListener(new a(this));
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048583, this) != null) {
            return;
        }
        while (true) {
            List<View> list = this.v;
            if (list != null && list.size() > 0) {
                this.h.removeView(this.v.get(0));
                this.v.remove(0);
            } else {
                return;
            }
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.r != null) {
            EMManager.from(this.t).setTextColor(R.color.CAM_X0107).setTextSize(R.dimen.T_X09);
        }
    }

    @Override // com.baidu.tieba.uh8
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            V(0L);
        }
    }

    @Override // com.baidu.tieba.uh8
    public void q() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && (linearLayout = this.r) != null) {
            linearLayout.setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wh8(@NonNull BdPageContext<BaseFragmentActivity> bdPageContext) {
        super(bdPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.v = new ArrayList();
        this.C = false;
        this.a = new WeakReference<>(bdPageContext.getPageActivity());
        E();
        F();
        zh8 zh8Var = new zh8(this);
        this.i = zh8Var;
        zh8Var.b(this.c);
    }

    public void D(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            if (this.z == null) {
                this.z = new c(this);
            }
            SafeHandler.getInst().postDelayed(this.z, j);
        }
    }

    public void K(@NonNull Reaction reaction) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, reaction) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("ext_reaction", reaction);
            this.y.a(26, hashMap);
        }
    }

    public final void N(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            EMTextView eMTextView = this.q;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public final void O(@Nullable Map<String, Object> map) {
        boolean z;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, map) == null) {
            if (map != null && map.containsKey("is_show_copy")) {
                z = ((Boolean) map.get("is_show_copy")).booleanValue();
            } else {
                z = true;
            }
            EMTextView eMTextView = this.j;
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
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            EMTextView eMTextView = this.m;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public final void Q(@Nullable Map<String, Object> map) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, map) == null) {
            int i = 0;
            if (map != null && map.containsKey("is_show_reply")) {
                z = ((Boolean) map.get("is_show_reply")).booleanValue();
            } else {
                z = false;
            }
            EMTextView eMTextView = this.k;
            if (!z) {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public final void R(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            EMTextView eMTextView = this.n;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public final void S(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            EMTextView eMTextView = this.l;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public void V(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j) == null) {
            if (this.A == null) {
                this.A = new b(this);
            }
            SafeHandler.getInst().postDelayed(this.A, j);
        }
    }

    public final void Y(@Nullable Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, map) == null) {
            O(map);
            Q(map);
            R(false);
            P(false);
            S(true);
        }
    }

    public void Z(@Nullable String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, str) == null) && !StringUtils.isNull(str)) {
            this.s.startLoad(str, 12, false);
        }
    }

    @Override // com.baidu.tieba.rh8
    public void g(@NonNull List<Reaction> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, list) == null) {
            this.i.c(list);
        }
    }

    @Override // com.baidu.tieba.uh8
    public void o(@NonNull sh8 sh8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, sh8Var) == null) {
            this.y = sh8Var;
        }
    }

    @SuppressLint({"InflateParams"})
    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0891, (ViewGroup) null);
            this.c = inflate;
            this.d = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090eaa);
            this.e = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090ea3);
            this.f = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090ea7);
            TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090ea6);
            this.g = textView;
            textView.setMaxLines(1);
            this.g.setEllipsize(TextUtils.TruncateAt.END);
            this.h = (FlowLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090e89);
            EMTextView eMTextView = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e9c);
            this.j = eMTextView;
            eMTextView.setOnClickListener(this);
            EMTextView eMTextView2 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090ea1);
            this.l = eMTextView2;
            eMTextView2.setOnClickListener(this);
            EMTextView eMTextView3 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e9e);
            this.m = eMTextView3;
            eMTextView3.setOnClickListener(this);
            EMTextView eMTextView4 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090ea0);
            this.n = eMTextView4;
            eMTextView4.setOnClickListener(this);
            EMTextView eMTextView5 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e86);
            this.w = eMTextView5;
            eMTextView5.setOnClickListener(this);
            EMTextView eMTextView6 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e9f);
            this.k = eMTextView6;
            eMTextView6.setOnClickListener(this);
            EMTextView eMTextView7 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e9b);
            this.p = eMTextView7;
            eMTextView7.setOnClickListener(this);
            EMTextView eMTextView8 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e9d);
            this.o = eMTextView8;
            eMTextView8.setOnClickListener(this);
            EMTextView eMTextView9 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e9a);
            this.q = eMTextView9;
            eMTextView9.setOnClickListener(this);
            this.x = this.c.findViewById(R.id.obfuscated_res_0x7f090415);
            if (!G()) {
                M();
            }
        }
    }

    public final boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) this.mContext.getPageActivity().getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW)).getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.densityDpi;
            if (i % 160 != 0 && (i * 1.0f) / 160.0f != 1.5d) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.uh8
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            if (this.b != null) {
                this.b = null;
            }
            if (this.A != null) {
                SafeHandler.getInst().removeCallbacks(this.A);
                this.A = null;
            }
            if (this.z != null) {
                SafeHandler.getInst().removeCallbacks(this.z);
                this.z = null;
            }
        }
    }

    public final void H(int i, @Nullable Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, map) == null) {
            if (i != 0) {
                if (i != 1 && i != 2 && i != 3) {
                    if (i == 64) {
                        O(map);
                        Q(map);
                        R(true);
                        P(false);
                        S(true);
                        return;
                    }
                    return;
                }
                O(map);
                Q(map);
                R(true);
                P(false);
                S(false);
                return;
            }
            O(map);
            Q(map);
            R(true);
            P(true);
            S(true);
        }
    }

    public final void I(int i, @Nullable Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, map) == null) {
            if (i == 0 || i == 1 || i == 2 || i == 64) {
                O(map);
                Q(map);
                R(true);
                P(false);
                S(false);
            }
        }
    }

    public final void T(TextView textView, int i) {
        Drawable pureDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048592, this, textView, i) != null) || textView == null || (pureDrawable = WebPManager.getPureDrawable(i, SkinManager.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS)) == null) {
            return;
        }
        int i2 = D;
        pureDrawable.setBounds(0, 0, i2, i2);
        textView.setCompoundDrawables(null, pureDrawable, null, null);
    }

    @Override // com.baidu.tieba.uh8
    @SuppressLint({"SetTextI18n"})
    public void n(@NonNull String str, @NonNull CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, str, charSequence) == null) {
            TextView textView = this.f;
            textView.setText(str + ZeusCrashHandler.NAME_SEPERATOR);
            this.g.setText(charSequence);
        }
    }

    @Override // com.baidu.tieba.uh8
    public void s(@NonNull String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, str, str2) == null) {
            this.t.setText(str);
            Z(str2);
            this.r.setVisibility(0);
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.q.getLayoutParams().width = 201;
            this.j.getLayoutParams().width = 201;
            this.k.getLayoutParams().width = 201;
            this.l.getLayoutParams().width = 201;
            this.m.getLayoutParams().width = 201;
            this.n.getLayoutParams().width = 201;
            this.o.getLayoutParams().width = 201;
            LinearLayout linearLayout = this.r;
            if (linearLayout != null) {
                linearLayout.getLayoutParams().width = 201;
            }
        }
    }

    public final boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            AlertDialog alertDialog = this.b;
            if (alertDialog == null) {
                return false;
            }
            boolean i = jg.i(alertDialog, this.mContext.getPageActivity());
            Window window = this.b.getWindow();
            window.addFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.obfuscated_res_0x7f10041b);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.c);
            window.setDimAmount(0.33f);
            return i;
        }
        return invokeV.booleanValue;
    }

    public final void X(int i, @Nullable Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048596, this, i, map) == null) {
            if (i != 0) {
                if (i == 1 || i == 2 || i == 64) {
                    O(map);
                    R(true);
                    Q(map);
                    P(false);
                    S(true);
                    return;
                }
                return;
            }
            O(map);
            R(true);
            Q(map);
            P(true);
            S(true);
        }
    }

    @Override // com.baidu.tieba.uh8
    public void a() {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            EMManager.from(this.d).setCorner(R.string.J_X14).setBackGroundColor(R.color.CAM_X0213);
            EMManager.from(this.e).setCorner(R.string.J_X14).setBackGroundColor(R.color.CAM_X0209);
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0213);
            SkinManager.setBackgroundResource(this.x, R.color.CAM_X0213);
            SkinManager.setBackgroundResource(this.w, R.color.CAM_X0213);
            EMManager.from(this.f).setTextColor(R.color.CAM_X0109).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X01);
            EMManager.from(this.g).setTextColor(R.color.CAM_X0107).setTextSize(R.dimen.T_X08);
            U();
            SkinManager.setViewTextColorSelector(this.w, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0107, 1);
            int width = ((WindowManager) this.mContext.getPageActivity().getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW)).getDefaultDisplay().getWidth() - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2);
            if (G()) {
                i = (width - (UtilHelper.getDimenPixelSize(R.dimen.tbds201) * 5)) / 4;
            } else {
                i = (width - 1005) / 4;
            }
            this.h.setHorizontalSpacing(i);
            T(this.q, R.drawable.obfuscated_res_0x7f0800e2);
            T(this.j, R.drawable.obfuscated_res_0x7f0804d2);
            T(this.l, R.drawable.obfuscated_res_0x7f0804d6);
            T(this.m, R.drawable.obfuscated_res_0x7f0804d3);
            T(this.n, R.drawable.obfuscated_res_0x7f0804d5);
            T(this.k, R.drawable.obfuscated_res_0x7f0804d4);
            T(this.p, R.drawable.obfuscated_res_0x7f080b96);
            EMTextView eMTextView = this.o;
            if (this.C) {
                i2 = R.drawable.obfuscated_res_0x7f0804d7;
            } else {
                i2 = R.drawable.obfuscated_res_0x7f0804d8;
            }
            T(eMTextView, i2);
            TBAlertBuilder tBAlertBuilder = this.B;
            if (tBAlertBuilder != null) {
                tBAlertBuilder.onChangeSkinType();
            }
            this.i.onChangeSkinType(TbadkApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.uh8
    public void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            new BdTopToast(this.mContext.getContext()).setIcon(true).setContent(str).show((ViewGroup) this.mContext.getPageActivity().findViewById(16908290));
        }
    }

    @Override // com.baidu.tieba.uh8
    public void m(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            if (this.B == null) {
                this.B = new TBAlertBuilder(this.a.get());
            }
            this.B.setTitle(R.string.obfuscated_res_0x7f0f093d);
            this.B.setDescStr(str);
            this.B.setDescLightStyle(true);
            this.B.setOperateBtn(new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f058b, TBAlertConfig.OperateBtnStyle.SECONDARY), new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f093d, TBAlertConfig.OperateBtnStyle.MAIN, new d(this)));
            this.B.setAutoClose();
            this.B.setCancelable(false);
            this.B.show();
        }
    }

    @Override // com.baidu.tieba.uh8
    public void p(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, obj) == null) {
            View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0194, (ViewGroup) null);
            this.u = inflate;
            this.r = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091f5a);
            this.s = (HeadImageView) this.u.findViewById(R.id.obfuscated_res_0x7f091f5e);
            this.t = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f091f6f);
            U();
            this.s.setIsRound(true);
            this.s.setDrawBorder(false);
            this.s.setPlaceHolder(1);
            this.r.setOnClickListener(this);
            this.r.setTag(obj);
            this.h.addView(this.u);
            this.v.add(this.u);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        sh8 sh8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, view2) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f090e9c) {
                sh8 sh8Var2 = this.y;
                if (sh8Var2 != null) {
                    sh8Var2.a(19, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090ea1) {
                sh8 sh8Var3 = this.y;
                if (sh8Var3 != null) {
                    sh8Var3.a(18, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090e9e) {
                sh8 sh8Var4 = this.y;
                if (sh8Var4 != null) {
                    sh8Var4.a(17, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090ea0) {
                sh8 sh8Var5 = this.y;
                if (sh8Var5 != null) {
                    sh8Var5.a(20, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090e9f) {
                sh8 sh8Var6 = this.y;
                if (sh8Var6 != null) {
                    sh8Var6.a(21, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090e86) {
                sh8 sh8Var7 = this.y;
                if (sh8Var7 != null) {
                    sh8Var7.a(22, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090e9b) {
                sh8 sh8Var8 = this.y;
                if (sh8Var8 != null) {
                    sh8Var8.a(23, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f091f5a) {
                if (this.y != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("robot_tag", view2.getTag());
                    this.y.a(24, hashMap);
                }
            } else if (id == R.id.obfuscated_res_0x7f090e9d) {
                sh8 sh8Var9 = this.y;
                if (sh8Var9 != null) {
                    sh8Var9.a(33, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090e9a) {
                sh8 sh8Var10 = this.y;
                if (sh8Var10 != null) {
                    sh8Var10.a(32, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f09178a && (sh8Var = this.y) != null) {
                sh8Var.a(34, null);
            }
            A();
        }
    }

    @Override // com.baidu.tieba.uh8
    public void r(boolean z, int i, int i2, @Nullable Map<String, Object> map, boolean z2, long j, long j2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), map, Boolean.valueOf(z2), Long.valueOf(j), Long.valueOf(j2)}) == null) {
            if (z) {
                Y(map);
            } else if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        X(i, map);
                    }
                } else {
                    H(i, map);
                }
            } else {
                I(i, map);
            }
            int i4 = 0;
            if (map != null && map.containsKey("is_show_bubble")) {
                boolean booleanValue = ((Boolean) map.get("is_show_bubble")).booleanValue();
                EMTextView eMTextView = this.p;
                if (booleanValue) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                eMTextView.setVisibility(i3);
            } else {
                this.p.setVisibility(8);
            }
            if (map != null && map.containsKey("is_show_emoji_reply")) {
                this.i.d(((Boolean) map.get("is_show_emoji_reply")).booleanValue());
            } else {
                this.i.d(true);
            }
            if (z2) {
                N(true);
                u98.a(1, 1, j, j2);
            } else {
                N(false);
            }
            if (map != null && map.containsKey("is_show_excellent_btn")) {
                boolean booleanValue2 = ((Boolean) map.get("is_show_excellent_btn")).booleanValue();
                EMTextView eMTextView2 = this.o;
                if (!booleanValue2) {
                    i4 = 8;
                }
                eMTextView2.setVisibility(i4);
            } else {
                this.o.setVisibility(8);
            }
            int i5 = R.string.obfuscated_res_0x7f0f0416;
            int i6 = R.drawable.obfuscated_res_0x7f0804d8;
            if (map != null && map.containsKey("is_excellent_msg")) {
                boolean booleanValue3 = ((Boolean) map.get("is_excellent_msg")).booleanValue();
                this.C = booleanValue3;
                EMTextView eMTextView3 = this.o;
                if (booleanValue3) {
                    i6 = R.drawable.obfuscated_res_0x7f0804d7;
                }
                T(eMTextView3, i6);
                EMTextView eMTextView4 = this.o;
                if (this.C) {
                    i5 = R.string.obfuscated_res_0x7f0f0415;
                }
                eMTextView4.setText(i5);
                return;
            }
            T(this.o, R.drawable.obfuscated_res_0x7f0804d8);
            this.o.setText(R.string.obfuscated_res_0x7f0f0416);
        }
    }

    @Override // com.baidu.tieba.uh8
    public void t(int i, int i2, @Nullable String str) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048612, this, i, i2, str) == null) {
            if (i != 1) {
                if (i == 3 && i2 == 1) {
                    boolean z = !this.C;
                    this.C = z;
                    EMTextView eMTextView = this.o;
                    if (z) {
                        i3 = R.drawable.obfuscated_res_0x7f0804d7;
                    } else {
                        i3 = R.drawable.obfuscated_res_0x7f0804d8;
                    }
                    T(eMTextView, i3);
                    b(str);
                }
            } else if (i2 == 1) {
                b(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0941));
            }
        }
    }
}
