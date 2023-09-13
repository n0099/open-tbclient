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
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.ff;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class yf5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final j A;
    public final k B;
    public ef a;
    public final Activity b;
    public final ViewGroup c;
    public df d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final int j;
    public View k;
    public View l;
    public TextView m;
    public TextView n;
    public HeadImageView o;
    public EMTextView p;
    @NonNull
    public final xf5 q;
    public TBSpecificationBtn r;
    public ViewGroup s;
    public boolean t;
    public float u;
    public float v;
    public int w;
    public Runnable x;
    public final i y;
    public final h z;

    /* loaded from: classes8.dex */
    public interface h {
        void onClick();
    }

    /* loaded from: classes8.dex */
    public interface i {
        void onClick();
    }

    /* loaded from: classes8.dex */
    public interface j {
        void onDismiss();
    }

    /* loaded from: classes8.dex */
    public interface k {
        void onShow();
    }

    /* loaded from: classes8.dex */
    public class a implements ff.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yf5 a;

        @Override // com.baidu.tieba.ff.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public a(yf5 yf5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yf5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yf5Var;
        }

        @Override // com.baidu.tieba.ff.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a = null;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yf5 a;

        public b(yf5 yf5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yf5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yf5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.n();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements df {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yf5 a;

        @Override // com.baidu.tieba.df
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 3;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.df
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 32;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.df
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.df
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        public c(yf5 yf5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yf5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yf5Var;
        }

        @Override // com.baidu.tieba.df
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) != null) {
                return (View) invokeL.objValue;
            }
            return this.a.l(layoutInflater);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yf5 a;

        public d(yf5 yf5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yf5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yf5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.n();
                if (this.a.z != null) {
                    this.a.z.onClick();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yf5 a;

        public e(yf5 yf5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yf5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yf5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.n();
                if (this.a.y != null) {
                    this.a.y.onClick();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yf5 a;

        public f(yf5 yf5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yf5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yf5Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.a.u = motionEvent.getY();
                    this.a.t = false;
                } else {
                    boolean z = true;
                    if (action != 1) {
                        if (action == 2) {
                            if (this.a.u == 0.0f) {
                                this.a.u = motionEvent.getY();
                            }
                            this.a.v = motionEvent.getY() - this.a.u;
                            yf5 yf5Var = this.a;
                            if (yf5Var.v >= -20.0f) {
                                z = false;
                            }
                            yf5Var.t = z;
                        }
                    } else if (this.a.t) {
                        this.a.n();
                        return true;
                    }
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Activity a;
        public xf5 b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public int h;
        public int i;
        public i j;
        public h k;
        public j l;
        public k m;

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
            this.i = Integer.MAX_VALUE;
            this.a = activity;
        }

        public g o(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.e = str;
                return this;
            }
            return (g) invokeL.objValue;
        }

        public g p(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                this.h = i;
                return this;
            }
            return (g) invokeI.objValue;
        }

        public g q(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.d = str;
                return this;
            }
            return (g) invokeL.objValue;
        }

        public g r(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                this.i = i;
                return this;
            }
            return (g) invokeI.objValue;
        }

        public g s(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.g = str;
                return this;
            }
            return (g) invokeL.objValue;
        }

        public g t(h hVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, hVar)) == null) {
                this.k = hVar;
                return this;
            }
            return (g) invokeL.objValue;
        }

        public g u(i iVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, iVar)) == null) {
                this.j = iVar;
                return this;
            }
            return (g) invokeL.objValue;
        }

        public g v(j jVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jVar)) == null) {
                this.l = jVar;
                return this;
            }
            return (g) invokeL.objValue;
        }

        public <T extends xf5> g w(T t) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, t)) == null) {
                qx5.c(t, "必须先绑定弹窗样式配置BaseCommonStrategy");
                this.b = t;
                return this;
            }
            return (g) invokeL.objValue;
        }

        public g x(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
                this.f = str;
                return this;
            }
            return (g) invokeL.objValue;
        }

        public g y(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                this.c = str;
                return this;
            }
            return (g) invokeL.objValue;
        }

        public yf5 n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new yf5(this, null);
            }
            return (yf5) invokeV.objValue;
        }
    }

    public yf5(g gVar) {
        xf5 xf5Var;
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
        this.t = false;
        this.v = 0.0f;
        qx5.c(gVar.b, "必须先绑定弹窗样式配置BaseCommonStrategy");
        if (gVar.b == null) {
            xf5Var = m();
        } else {
            xf5Var = gVar.b;
        }
        this.q = xf5Var;
        this.b = gVar.a;
        this.e = gVar.c;
        this.f = gVar.d;
        this.i = gVar.g;
        this.j = gVar.h;
        this.g = gVar.e;
        this.h = gVar.f;
        this.y = gVar.j;
        this.z = gVar.k;
        this.A = gVar.l;
        this.B = gVar.m;
        this.w = gVar.i;
        this.c = o(this.b);
    }

    @NonNull
    public final View l(LayoutInflater layoutInflater) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
            View inflate = layoutInflater.inflate(R.layout.layout_common_top_tip_view, (ViewGroup) null);
            this.k = inflate;
            this.l = inflate.findViewById(R.id.tip_root_container);
            this.o = (HeadImageView) this.k.findViewById(R.id.tip_icon);
            this.p = (EMTextView) this.k.findViewById(R.id.tip_tag_icon);
            this.m = (TextView) this.k.findViewById(R.id.tip_title);
            this.n = (TextView) this.k.findViewById(R.id.tip_desc);
            this.r = (TBSpecificationBtn) this.k.findViewById(R.id.tip_btn);
            this.m.setText(this.e);
            this.n.setText(this.f);
            this.r.setText(this.g);
            q();
            p(this.q.b());
            if (!TextUtils.isEmpty(this.i)) {
                this.o.startLoad(this.i, 10, false);
            } else {
                this.o.setDefaultResource(this.j);
            }
            this.r.setOnClickListener(new d(this));
            this.l.setOnClickListener(new e(this));
            this.l.setOnTouchListener(new f(this));
            r();
            return this.k;
        }
        return (View) invokeL.objValue;
    }

    public /* synthetic */ yf5(g gVar, a aVar) {
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

    public final df k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new c(this);
        }
        return (df) invokeV.objValue;
    }

    public final xf5 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return zf5.a("SCENE_HOT_EVENT");
        }
        return (xf5) invokeV.objValue;
    }

    public void n() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ef efVar = this.a;
            if (efVar != null && (viewGroup = this.c) != null) {
                efVar.e(viewGroup);
                this.c.setVisibility(8);
            }
            if (this.x != null) {
                SafeHandler.getInst().removeCallbacks(this.x);
                this.x = null;
            }
            j jVar = this.A;
            if (jVar != null) {
                jVar.onDismiss();
            }
        }
    }

    public final void q() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int i2 = 0;
            if (this.q.e() && StringUtils.isNotNull(this.h)) {
                z = true;
            } else {
                z = false;
            }
            EMTextView eMTextView = this.p;
            if (!z) {
                i2 = 8;
            }
            eMTextView.setVisibility(i2);
            if (z) {
                this.p.setText(this.h);
            }
        }
    }

    public final ViewGroup o(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, activity)) == null) {
            if (activity == null) {
                return null;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 48;
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X013);
            layoutParams.leftMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X003);
            layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X003);
            FrameLayout frameLayout = new FrameLayout(activity);
            this.s = frameLayout;
            ((FrameLayout) activity.findViewById(16908290)).addView(frameLayout, layoutParams);
            return this.s;
        }
        return (ViewGroup) invokeL.objValue;
    }

    public final void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.o.setDrawCorner(true);
            this.o.setDrawBorder(true);
            this.o.setBorderSurroundContent(true);
            this.o.setBorderWidth(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.o.setBorderColor(SkinManager.getColor(R.color.CAM_X0602));
            this.o.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.o.setPlaceHolder(1);
            if (i2 == 1) {
                this.o.setConrers(15);
                this.o.setRadiusById(R.string.J_X06);
                return;
            }
            this.o.setIsRound(true);
            this.o.setRadius(this.q.c());
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0105);
            EMManager.from(this.m).setTextStyle(R.string.F_X02);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0107);
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0207).setShapeRadius(BdUtilHelper.getDimens(this.b, R.dimen.tbds31)).setShadowColor(R.color.CAM_X0803).setShadowSide(ShadowDrawable.ALL).setShadowRadius(BdUtilHelper.getDimens(this.b, R.dimen.tbds16)).setOffsetX(0).setOffsetY(0).into(this.l);
            oa5 oa5Var = new oa5();
            oa5Var.u(this.q.a());
            this.r.setConfig(oa5Var);
            ViewGroup.LayoutParams layoutParams = this.r.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = this.q.d();
                this.r.setLayoutParams(layoutParams);
            }
            EMManager.from(this.p).setCorner(R.string.J_X04).setTextColor(R.color.CAM_X0302).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X10).setAlpha(R.string.obfuscated_res_0x7f0f000e).setBackGroundColor(R.color.CAM_X0302);
        }
    }

    public void s() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || (viewGroup = this.c) == null) {
            return;
        }
        viewGroup.setVisibility(0);
        ef efVar = this.a;
        if (efVar != null) {
            efVar.e(this.c);
        }
        ff ffVar = new ff();
        ffVar.d(true);
        ffVar.h(new a(this));
        if (this.d == null) {
            this.d = k();
        }
        ffVar.a(this.d);
        ffVar.e(R.anim.push_top_in);
        ffVar.f(R.anim.push_top_out);
        ef b2 = ffVar.b();
        this.a = b2;
        b2.p(this.b, this.c, false);
        if (this.w != Integer.MAX_VALUE) {
            if (this.x == null) {
                this.x = new b(this);
            }
            SafeHandler.getInst().postDelayed(this.x, this.w);
        }
        k kVar = this.B;
        if (kVar != null) {
            kVar.onShow();
        }
    }
}
