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
public class vl8 extends BdBaseView<BaseFragmentActivity> implements tl8, View.OnClickListener {
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
    public final yl8 i;
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
    public rl8 y;
    public Runnable z;

    /* loaded from: classes8.dex */
    public class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vl8 a;

        public a(vl8 vl8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vl8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vl8Var;
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
        public final /* synthetic */ vl8 a;

        public b(vl8 vl8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vl8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vl8Var;
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
        public final /* synthetic */ vl8 a;

        public c(vl8 vl8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vl8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vl8Var;
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
        public final /* synthetic */ vl8 a;

        public d(vl8 vl8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vl8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vl8Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948244743, "Lcom/baidu/tieba/vl8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948244743, "Lcom/baidu/tieba/vl8;");
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

    public void T() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.r != null) {
            EMManager.from(this.t).setTextColor(R.color.CAM_X0107).setTextSize(R.dimen.T_X09);
        }
    }

    @Override // com.baidu.tieba.tl8
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            U(0L);
        }
    }

    @Override // com.baidu.tieba.tl8
    public void q() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && (linearLayout = this.r) != null) {
            linearLayout.setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vl8(@NonNull BdPageContext<BaseFragmentActivity> bdPageContext) {
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
        yl8 yl8Var = new yl8(this);
        this.i = yl8Var;
        yl8Var.b(this.c);
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

    public final void M(boolean z) {
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

    public final void N(@Nullable Map<String, Object> map) {
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

    public final void O(boolean z) {
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

    public final void P(@Nullable Map<String, Object> map) {
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

    public final void Q(boolean z) {
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

    public final void R(boolean z) {
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

    public void U(long j) {
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
            N(map);
            P(map);
            Q(false);
            O(false);
            R(true);
        }
    }

    public void Z(@Nullable String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, str) == null) && !StringUtils.isNull(str)) {
            this.s.startLoad(str, 12, false);
        }
    }

    @Override // com.baidu.tieba.ql8
    public void g(@NonNull List<Reaction> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, list) == null) {
            this.i.c(list);
        }
    }

    @Override // com.baidu.tieba.tl8
    public void o(@NonNull rl8 rl8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, rl8Var) == null) {
            this.y = rl8Var;
        }
    }

    @SuppressLint({"InflateParams"})
    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0897, (ViewGroup) null);
            this.c = inflate;
            this.d = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090eb7);
            this.e = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090eb0);
            this.f = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090eb4);
            TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090eb3);
            this.g = textView;
            textView.setMaxLines(1);
            this.g.setEllipsize(TextUtils.TruncateAt.END);
            this.h = (FlowLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090e96);
            EMTextView eMTextView = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090ea9);
            this.j = eMTextView;
            eMTextView.setOnClickListener(this);
            EMTextView eMTextView2 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090eae);
            this.l = eMTextView2;
            eMTextView2.setOnClickListener(this);
            EMTextView eMTextView3 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090eab);
            this.m = eMTextView3;
            eMTextView3.setOnClickListener(this);
            EMTextView eMTextView4 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090ead);
            this.n = eMTextView4;
            eMTextView4.setOnClickListener(this);
            EMTextView eMTextView5 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e93);
            this.w = eMTextView5;
            eMTextView5.setOnClickListener(this);
            EMTextView eMTextView6 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090eac);
            this.k = eMTextView6;
            eMTextView6.setOnClickListener(this);
            EMTextView eMTextView7 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090ea8);
            this.p = eMTextView7;
            eMTextView7.setOnClickListener(this);
            EMTextView eMTextView8 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090eaa);
            this.o = eMTextView8;
            eMTextView8.setOnClickListener(this);
            EMTextView eMTextView9 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090ea7);
            this.q = eMTextView9;
            eMTextView9.setOnClickListener(this);
            this.x = this.c.findViewById(R.id.obfuscated_res_0x7f090417);
            if (!G()) {
                L();
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

    @Override // com.baidu.tieba.tl8
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
                        N(map);
                        P(map);
                        Q(true);
                        O(false);
                        R(true);
                        return;
                    }
                    return;
                }
                N(map);
                P(map);
                Q(true);
                O(false);
                R(false);
                return;
            }
            N(map);
            P(map);
            Q(true);
            O(true);
            R(true);
        }
    }

    public final void I(int i, @Nullable Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, map) == null) {
            if (i == 0 || i == 1 || i == 2 || i == 64) {
                N(map);
                P(map);
                Q(true);
                O(false);
                R(false);
            }
        }
    }

    public final void S(TextView textView, int i) {
        Drawable pureDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048592, this, textView, i) != null) || textView == null || (pureDrawable = WebPManager.getPureDrawable(i, SkinManager.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS)) == null) {
            return;
        }
        int i2 = D;
        pureDrawable.setBounds(0, 0, i2, i2);
        textView.setCompoundDrawables(null, pureDrawable, null, null);
    }

    @Override // com.baidu.tieba.tl8
    @SuppressLint({"SetTextI18n"})
    public void n(@NonNull String str, @NonNull CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, str, charSequence) == null) {
            TextView textView = this.f;
            textView.setText(str + ZeusCrashHandler.NAME_SEPERATOR);
            this.g.setText(charSequence);
        }
    }

    @Override // com.baidu.tieba.tl8
    public void s(@NonNull String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, str, str2) == null) {
            this.t.setText(str);
            Z(str2);
            this.r.setVisibility(0);
        }
    }

    public final void L() {
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
                    N(map);
                    Q(true);
                    P(map);
                    O(false);
                    R(true);
                    return;
                }
                return;
            }
            N(map);
            Q(true);
            P(map);
            O(true);
            R(true);
        }
    }

    @Override // com.baidu.tieba.tl8
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
            T();
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
            S(this.q, R.drawable.obfuscated_res_0x7f0800e2);
            S(this.j, R.drawable.obfuscated_res_0x7f0804d3);
            S(this.l, R.drawable.obfuscated_res_0x7f0804d7);
            S(this.m, R.drawable.obfuscated_res_0x7f0804d4);
            S(this.n, R.drawable.obfuscated_res_0x7f0804d6);
            S(this.k, R.drawable.obfuscated_res_0x7f0804d5);
            S(this.p, R.drawable.obfuscated_res_0x7f080ba4);
            EMTextView eMTextView = this.o;
            if (this.C) {
                i2 = R.drawable.obfuscated_res_0x7f0804d8;
            } else {
                i2 = R.drawable.obfuscated_res_0x7f0804d9;
            }
            S(eMTextView, i2);
            TBAlertBuilder tBAlertBuilder = this.B;
            if (tBAlertBuilder != null) {
                tBAlertBuilder.onChangeSkinType();
            }
            this.i.onChangeSkinType(TbadkApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.tl8
    public void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            new BdTopToast(this.mContext.getContext()).setIcon(true).setContent(str).show((ViewGroup) this.mContext.getPageActivity().findViewById(16908290));
        }
    }

    @Override // com.baidu.tieba.tl8
    public void m(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            if (this.B == null) {
                this.B = new TBAlertBuilder(this.a.get());
            }
            this.B.setTitle(R.string.obfuscated_res_0x7f0f0945);
            this.B.setDescStr(str);
            this.B.setDescLightStyle(true);
            this.B.setOperateBtn(new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f058d, TBAlertConfig.OperateBtnStyle.SECONDARY), new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f0945, TBAlertConfig.OperateBtnStyle.MAIN, new d(this)));
            this.B.setAutoClose();
            this.B.setCancelable(false);
            this.B.show();
        }
    }

    @Override // com.baidu.tieba.tl8
    public void p(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, obj) == null) {
            View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0197, (ViewGroup) null);
            this.u = inflate;
            this.r = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091f7e);
            this.s = (HeadImageView) this.u.findViewById(R.id.obfuscated_res_0x7f091f82);
            this.t = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f091f94);
            T();
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
        rl8 rl8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, view2) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f090ea9) {
                rl8 rl8Var2 = this.y;
                if (rl8Var2 != null) {
                    rl8Var2.a(19, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090eae) {
                rl8 rl8Var3 = this.y;
                if (rl8Var3 != null) {
                    rl8Var3.a(18, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090eab) {
                rl8 rl8Var4 = this.y;
                if (rl8Var4 != null) {
                    rl8Var4.a(17, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090ead) {
                rl8 rl8Var5 = this.y;
                if (rl8Var5 != null) {
                    rl8Var5.a(20, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090eac) {
                rl8 rl8Var6 = this.y;
                if (rl8Var6 != null) {
                    rl8Var6.a(21, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090e93) {
                rl8 rl8Var7 = this.y;
                if (rl8Var7 != null) {
                    rl8Var7.a(22, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090ea8) {
                rl8 rl8Var8 = this.y;
                if (rl8Var8 != null) {
                    rl8Var8.a(23, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f091f7e) {
                if (this.y != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("robot_tag", view2.getTag());
                    this.y.a(24, hashMap);
                }
            } else if (id == R.id.obfuscated_res_0x7f090eaa) {
                rl8 rl8Var9 = this.y;
                if (rl8Var9 != null) {
                    rl8Var9.a(33, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090ea7) {
                rl8 rl8Var10 = this.y;
                if (rl8Var10 != null) {
                    rl8Var10.a(32, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f0917a1 && (rl8Var = this.y) != null) {
                rl8Var.a(34, null);
            }
            A();
        }
    }

    @Override // com.baidu.tieba.tl8
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
                M(true);
                oc8.a(1, 1, j, j2);
            } else {
                M(false);
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
            int i5 = R.string.obfuscated_res_0x7f0f0417;
            int i6 = R.drawable.obfuscated_res_0x7f0804d9;
            if (map != null && map.containsKey("is_excellent_msg")) {
                boolean booleanValue3 = ((Boolean) map.get("is_excellent_msg")).booleanValue();
                this.C = booleanValue3;
                EMTextView eMTextView3 = this.o;
                if (booleanValue3) {
                    i6 = R.drawable.obfuscated_res_0x7f0804d8;
                }
                S(eMTextView3, i6);
                EMTextView eMTextView4 = this.o;
                if (this.C) {
                    i5 = R.string.obfuscated_res_0x7f0f0416;
                }
                eMTextView4.setText(i5);
                return;
            }
            S(this.o, R.drawable.obfuscated_res_0x7f0804d9);
            this.o.setText(R.string.obfuscated_res_0x7f0f0417);
        }
    }

    @Override // com.baidu.tieba.tl8
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
                        i3 = R.drawable.obfuscated_res_0x7f0804d8;
                    } else {
                        i3 = R.drawable.obfuscated_res_0x7f0804d9;
                    }
                    S(eMTextView, i3);
                    b(str);
                }
            } else if (i2 == 1) {
                b(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0949));
            }
        }
    }
}
