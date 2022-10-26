package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.xf;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class k25 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wf a;
    public final Activity b;
    public final ViewGroup c;
    public vf d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final int i;
    public View j;
    public View k;
    public TextView l;
    public TextView m;
    public TbImageView n;
    public TBSpecificationBtn o;
    public ViewGroup p;
    public boolean q;
    public float r;
    public float s;
    public int t;
    public Runnable u;
    public final i v;
    public final h w;
    public final j x;
    public final k y;

    /* loaded from: classes4.dex */
    public interface h {
        void onClick();
    }

    /* loaded from: classes4.dex */
    public interface i {
        void onClick();
    }

    /* loaded from: classes4.dex */
    public interface j {
        void onDismiss();
    }

    /* loaded from: classes4.dex */
    public interface k {
        void onShow();
    }

    /* loaded from: classes4.dex */
    public class a implements xf.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k25 a;

        @Override // com.baidu.tieba.xf.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public a(k25 k25Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k25Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k25Var;
        }

        @Override // com.baidu.tieba.xf.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a = null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k25 a;

        public b(k25 k25Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k25Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k25Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.m();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements vf {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k25 a;

        @Override // com.baidu.tieba.vf
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 3;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.vf
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 32;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.vf
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.vf
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        public c(k25 k25Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k25Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k25Var;
        }

        @Override // com.baidu.tieba.vf
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) != null) {
                return (View) invokeL.objValue;
            }
            return this.a.l(layoutInflater);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k25 a;

        public d(k25 k25Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k25Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k25Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.m();
                if (this.a.w != null) {
                    this.a.w.onClick();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k25 a;

        public e(k25 k25Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k25Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k25Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.m();
                if (this.a.v != null) {
                    this.a.v.onClick();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k25 a;

        public f(k25 k25Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k25Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k25Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.a.r = motionEvent.getY();
                    this.a.q = false;
                } else {
                    boolean z = true;
                    if (action != 1) {
                        if (action == 2) {
                            if (this.a.r == 0.0f) {
                                this.a.r = motionEvent.getY();
                            }
                            this.a.s = motionEvent.getY() - this.a.r;
                            k25 k25Var = this.a;
                            if (k25Var.s >= -20.0f) {
                                z = false;
                            }
                            k25Var.q = z;
                        }
                    } else if (this.a.q) {
                        this.a.m();
                        return true;
                    }
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public final class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Activity a;
        public String b;
        public String c;
        public String d;
        public String e;
        public int f;
        public int g;
        public i h;
        public h i;
        public j j;
        public k k;

        public g(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = Integer.MAX_VALUE;
            this.a = activity;
        }

        public g m(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.d = str;
                return this;
            }
            return (g) invokeL.objValue;
        }

        public g n(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                this.f = i;
                return this;
            }
            return (g) invokeI.objValue;
        }

        public g o(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.c = str;
                return this;
            }
            return (g) invokeL.objValue;
        }

        public g p(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                this.g = i;
                return this;
            }
            return (g) invokeI.objValue;
        }

        public g q(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.e = str;
                return this;
            }
            return (g) invokeL.objValue;
        }

        public g r(h hVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, hVar)) == null) {
                this.i = hVar;
                return this;
            }
            return (g) invokeL.objValue;
        }

        public g s(i iVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, iVar)) == null) {
                this.h = iVar;
                return this;
            }
            return (g) invokeL.objValue;
        }

        public g t(j jVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jVar)) == null) {
                this.j = jVar;
                return this;
            }
            return (g) invokeL.objValue;
        }

        public g u(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                this.b = str;
                return this;
            }
            return (g) invokeL.objValue;
        }

        public k25 l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new k25(this, null);
            }
            return (k25) invokeV.objValue;
        }
    }

    public k25(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = false;
        this.s = 0.0f;
        this.b = gVar.a;
        this.e = gVar.b;
        this.f = gVar.c;
        this.h = gVar.e;
        this.i = gVar.f;
        this.g = gVar.d;
        this.v = gVar.h;
        this.w = gVar.i;
        this.x = gVar.j;
        this.y = gVar.k;
        this.t = gVar.g;
        this.c = n(this.b);
    }

    public /* synthetic */ k25(g gVar, a aVar) {
        this(gVar);
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (Activity) invokeV.objValue;
    }

    public final vf k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new c(this);
        }
        return (vf) invokeV.objValue;
    }

    public final View l(LayoutInflater layoutInflater) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0491, (ViewGroup) null);
            this.j = inflate;
            this.k = inflate.findViewById(R.id.obfuscated_res_0x7f0921f9);
            this.n = (TbImageView) this.j.findViewById(R.id.obfuscated_res_0x7f0921ef);
            this.l = (TextView) this.j.findViewById(R.id.obfuscated_res_0x7f0921fe);
            this.m = (TextView) this.j.findViewById(R.id.obfuscated_res_0x7f0921e8);
            this.o = (TBSpecificationBtn) this.j.findViewById(R.id.obfuscated_res_0x7f0921e3);
            this.l.setText(this.e);
            this.m.setText(this.f);
            this.o.setText(this.g);
            if (!TextUtils.isEmpty(this.h)) {
                this.n.L(this.h, 10, false);
                this.n.setPlaceHolder(1);
            } else {
                this.n.setDefaultBgResource(this.i);
            }
            this.n.setDrawCorner(true);
            this.n.setConrers(15);
            this.n.setRadiusById(R.string.J_X06);
            this.n.setDrawBorder(true);
            this.n.setBorderWidth(fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.n.setBorderSurroundContent(true);
            this.n.setBorderColor(SkinManager.getColor(R.color.CAM_X0602));
            this.n.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.o.setOnClickListener(new d(this));
            this.k.setOnClickListener(new e(this));
            this.k.setOnTouchListener(new f(this));
            o();
            return this.j;
        }
        return (View) invokeL.objValue;
    }

    public void m() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            wf wfVar = this.a;
            if (wfVar != null && (viewGroup = this.c) != null) {
                wfVar.e(viewGroup);
                this.c.setVisibility(8);
            }
            if (this.u != null) {
                hh.a().removeCallbacks(this.u);
                this.u = null;
            }
            j jVar = this.x;
            if (jVar != null) {
                jVar.onDismiss();
            }
        }
    }

    public final ViewGroup n(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, activity)) == null) {
            if (activity == null) {
                return null;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 48;
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X013);
            layoutParams.leftMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X003);
            layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X003);
            FrameLayout frameLayout = new FrameLayout(activity);
            this.p = frameLayout;
            ((FrameLayout) activity.findViewById(16908290)).addView(frameLayout, layoutParams);
            return this.p;
        }
        return (ViewGroup) invokeL.objValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0105);
            nv4.d(this.l).A(R.string.F_X02);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0107);
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0207).setShapeRadius(fj.f(this.b, R.dimen.tbds31)).setShadowColor(R.color.CAM_X0803).setShadowSide(ShadowDrawable.ALL).setShadowRadius(fj.f(this.b, R.dimen.tbds16)).setOffsetX(0).setOffsetY(0).into(this.k);
            ty4 ty4Var = new ty4();
            ty4Var.r(R.color.CAM_X0301);
            this.o.setConfig(ty4Var);
        }
    }

    public void p() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (viewGroup = this.c) == null) {
            return;
        }
        viewGroup.setVisibility(0);
        wf wfVar = this.a;
        if (wfVar != null) {
            wfVar.e(this.c);
        }
        xf xfVar = new xf();
        xfVar.d(true);
        xfVar.h(new a(this));
        if (this.d == null) {
            this.d = k();
        }
        xfVar.a(this.d);
        xfVar.e(R.anim.obfuscated_res_0x7f010102);
        xfVar.f(R.anim.obfuscated_res_0x7f010103);
        wf b2 = xfVar.b();
        this.a = b2;
        b2.q(this.b, this.c, false);
        if (this.t != Integer.MAX_VALUE) {
            if (this.u == null) {
                this.u = new b(this);
            }
            hh.a().postDelayed(this.u, this.t);
        }
        k kVar = this.y;
        if (kVar != null) {
            kVar.onShow();
        }
    }
}
