package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class n36 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public boolean C;
    public boolean D;
    @Nullable
    public c E;
    public Runnable F;
    public Runnable G;
    public Handler a;
    public vf b;
    public TbPageContext c;
    public View d;
    public boolean e;
    public String f;
    public String g;
    public boolean h;
    public int i;
    public int j;
    public boolean k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public int p;
    public int q;
    public int r;
    public int s;
    public View.OnClickListener t;
    public boolean u;
    public boolean v;
    public int w;
    public boolean x;
    public int y;
    public int z;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n36 a;

        /* renamed from: com.baidu.tieba.n36$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0343a implements uf {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.baidu.tieba.n36$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class View$OnClickListenerC0344a implements View.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ C0343a a;

                public View$OnClickListenerC0344a(C0343a c0343a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0343a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = c0343a;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    String str;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                        try {
                            int skinType = TbadkCoreApplication.getInst().getSkinType();
                            if (skinType == 4) {
                                str = "&skin=dart";
                            } else if (skinType == 1) {
                                str = "&skin=night";
                            } else {
                                str = "";
                            }
                            UrlManager.getInstance().dealOneLink(this.a.a.a.c, new String[]{"https://tieba.baidu.com/mo/q/hybrid-main-service/virtualAvatar?customfullscreen=1&nonavigationbar=1" + str});
                        } catch (Exception e) {
                            BdLog.e("openPageByUrl fail:" + e.toString());
                        }
                    }
                }
            }

            public C0343a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.baidu.tieba.uf
            public int a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.a.s : invokeV.intValue;
            }

            @Override // com.baidu.tieba.uf
            public int b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.a.r : invokeV.intValue;
            }

            @Override // com.baidu.tieba.uf
            public View c(LayoutInflater layoutInflater) {
                InterceptResult invokeL;
                Drawable drawable;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                    View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0517, (ViewGroup) null);
                    TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09220f);
                    textView.setText(this.a.a.f);
                    if (this.a.a.A != 0) {
                        textView.setGravity(this.a.a.A);
                    } else {
                        textView.setGravity(17);
                    }
                    int i = this.a.a.y;
                    int i2 = R.color.CAM_X0101;
                    if (i != 0) {
                        SkinManager.setViewTextColor(textView, this.a.a.y);
                    } else {
                        SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
                    }
                    textView.setTextSize(0, this.a.a.z != 0 ? this.a.a.c.getResources().getDimensionPixelSize(this.a.a.z) : this.a.a.c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702b5));
                    textView.setLines(this.a.a.w);
                    if (this.a.a.x) {
                        textView.setEllipsize(TextUtils.TruncateAt.END);
                    }
                    if (this.a.a.B != 0) {
                        if (this.a.a.C) {
                            if (this.a.a.y != 0) {
                                i2 = this.a.a.y;
                            }
                            drawable = WebPManager.getPureDrawable(this.a.a.B, SkinManager.getColor(i2), WebPManager.ResourceStateType.NORMAL);
                        } else {
                            drawable = SkinManager.getDrawable(this.a.a.B);
                        }
                        int f = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                        drawable.setBounds(0, 0, f, f);
                        textView.setCompoundDrawablePadding(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds16));
                        textView.setCompoundDrawables(drawable, null, null, null);
                    }
                    SkinManager.setBackgroundResource(textView, this.a.a.i);
                    if (this.a.a.t != null) {
                        textView.setOnClickListener(this.a.a.t);
                    } else {
                        textView.setOnClickListener(new View$OnClickListenerC0344a(this));
                    }
                    return inflate;
                }
                return (View) invokeL.objValue;
            }

            @Override // com.baidu.tieba.uf
            public int getXOffset() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.a.p : invokeV.intValue;
            }

            @Override // com.baidu.tieba.uf
            public int getYOffset() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.a.q : invokeV.intValue;
            }
        }

        public a(n36 n36Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n36Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n36Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b == null && !StringUtils.isNull(this.a.f)) {
                if (!this.a.u || this.a.D()) {
                    wf wfVar = new wf();
                    wfVar.k(this.a.d);
                    wfVar.c(0);
                    wfVar.j(true);
                    wfVar.i(true);
                    wfVar.a(new C0343a(this));
                    this.a.b = wfVar.b();
                    this.a.b.k(false);
                    this.a.b.l(this.a.v);
                    this.a.b.n(this.a.c.getPageActivity(), this.a.o);
                    this.a.e = true;
                    this.a.F();
                    this.a.h = true;
                    if (this.a.D) {
                        return;
                    }
                    this.a.a.postDelayed(this.a.G, this.a.n);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n36 a;

        public b(n36 n36Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n36Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n36Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void onDismiss();
    }

    public n36(TbPageContext tbPageContext, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.i = R.drawable.pic_sign_tip;
        this.j = 0;
        this.k = false;
        this.l = 1;
        this.m = 1000;
        this.n = 3000;
        this.o = true;
        this.p = 5;
        this.q = 0;
        this.r = 48;
        this.s = 4;
        this.v = false;
        this.w = 1;
        this.x = false;
        this.y = 0;
        this.z = 0;
        this.A = 0;
        this.B = 0;
        this.C = false;
        this.D = false;
        this.F = new a(this);
        this.G = new b(this);
        this.c = tbPageContext;
        this.d = view2;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? bx4.k().l(this.g, 0) < this.l : invokeV.booleanValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            View view2 = this.d;
            return view2 != null && view2.getVisibility() == 0 && ((double) this.d.getAlpha()) >= 0.4d;
        }
        return invokeV.booleanValue;
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            vf vfVar = this.b;
            if (vfVar != null) {
                vfVar.d();
                this.b = null;
            }
            Handler handler = this.a;
            if (handler != null) {
                handler.removeCallbacks(this.F);
                this.a.removeCallbacks(this.G);
            }
            c cVar = this.E;
            if (cVar != null && this.h) {
                cVar.onDismiss();
            }
            this.h = false;
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.k) {
            return;
        }
        bx4.k().w(this.g, this.j + 1);
    }

    public void G(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.s = i;
        }
    }

    public void H(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.t = onClickListener;
        }
    }

    public void I(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i) == null) || i <= 0) {
            return;
        }
        this.n = i;
    }

    public void J(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.r = i;
        }
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.D = z;
        }
    }

    public void L(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i) == null) || i <= 0) {
            return;
        }
        this.l = i;
    }

    public void M(@Nullable c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.E = cVar;
        }
    }

    public void N(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.g = str;
        }
    }

    public void O(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i) == null) || i <= 0) {
            return;
        }
        this.m = i;
    }

    public void P(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.y = i;
        }
    }

    public void Q(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.z = i;
        }
    }

    public void R(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i) == null) || i <= 0) {
            return;
        }
        this.i = i;
    }

    public void S(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.v = z;
        }
    }

    public void T(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.p = i;
        }
    }

    public void U(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.q = i;
        }
    }

    public boolean V(String str, String str2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (this.e || StringUtils.isNull(str) || StringUtils.isNull(str2) || (view2 = this.d) == null || view2.getVisibility() != 0) {
                return false;
            }
            this.f = str;
            this.g = str2;
            this.k = z2;
            int l = bx4.k().l(str2, 0);
            this.j = l;
            if (l < this.l || this.k) {
                if (z) {
                    F();
                    this.e = true;
                }
                if (this.a == null) {
                    this.a = new Handler();
                }
                this.a.postDelayed(this.F, this.m);
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public boolean W(String str) {
        InterceptResult invokeL;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            if (StringUtils.isNull(str) || (view2 = this.d) == null || view2.getVisibility() != 0) {
                return false;
            }
            this.f = str;
            if (this.a == null) {
                this.a = new Handler();
            }
            this.a.postDelayed(this.F, this.m);
            return true;
        }
        return invokeL.booleanValue;
    }
}
