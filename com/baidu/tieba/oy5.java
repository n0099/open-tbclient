package com.baidu.tieba;

import android.app.Activity;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.mf;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class oy5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lf a;
    public Activity b;
    public ViewGroup c;
    public h d;
    public g e;
    public kf f;
    public final Handler g;
    public Runnable h;
    public String i;
    public String j;
    public String k;
    public String l;
    public TextView m;
    public TextView n;
    public TbImageView o;
    public View p;
    public ImageView q;
    public TBSpecificationBtn r;
    public int s;
    public int t;

    /* loaded from: classes7.dex */
    public interface g {
        void dismiss();
    }

    /* loaded from: classes7.dex */
    public interface h {
        void onClick(int i);
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oy5 a;

        public a(oy5 oy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oy5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oy5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null) {
                this.a.a.e(this.a.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements mf.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oy5 a;

        @Override // com.baidu.tieba.mf.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public b(oy5 oy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oy5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oy5Var;
        }

        @Override // com.baidu.tieba.mf.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.a = null;
            this.a.g.removeCallbacks(this.a.h);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements kf {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oy5 a;

        @Override // com.baidu.tieba.kf
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 3;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.kf
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 32;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.kf
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.kf
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        public c(oy5 oy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oy5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oy5Var;
        }

        @Override // com.baidu.tieba.kf
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) != null) {
                return (View) invokeL.objValue;
            }
            return this.a.k(layoutInflater);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oy5 a;

        public d(oy5 oy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oy5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oy5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.d != null) {
                    this.a.d.onClick(1);
                }
                this.a.r.setClickable(false);
                if (this.a.h != null) {
                    this.a.g.removeCallbacks(this.a.h);
                    this.a.g.postDelayed(this.a.h, 1000L);
                }
                this.a.c = null;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oy5 a;

        public e(oy5 oy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oy5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oy5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.d != null) {
                this.a.d.onClick(3);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oy5 a;

        public f(oy5 oy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oy5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oy5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.l();
                if (this.a.d != null) {
                    this.a.d.onClick(2);
                }
            }
        }
    }

    public oy5(Activity activity, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new Handler();
        this.s = 0;
        this.t = 80;
        this.b = activity;
        this.c = m(activity, i);
    }

    public final ViewGroup m(Activity activity, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, activity, i)) == null) {
            if (activity == null) {
                return null;
            }
            this.t = i;
            FrameLayout frameLayout = (FrameLayout) activity.findViewById(16908290);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = i;
            if (i == 80) {
                layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds146) + UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
            } else if (i == 48) {
                layoutParams.topMargin = UtilHelper.getStatusBarHeight();
            }
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            layoutParams.leftMargin = dimenPixelSize;
            layoutParams.rightMargin = dimenPixelSize2;
            FrameLayout frameLayout2 = new FrameLayout(activity);
            frameLayout.addView(frameLayout2, layoutParams);
            return frameLayout2;
        }
        return (ViewGroup) invokeLI.objValue;
    }

    public oy5 o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            this.s = i;
            return this;
        }
        return (oy5) invokeI.objValue;
    }

    public oy5 p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.j = str;
            return this;
        }
        return (oy5) invokeL.objValue;
    }

    public void q(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, gVar) == null) {
            this.e = gVar;
        }
    }

    public oy5 r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            this.k = str;
            return this;
        }
        return (oy5) invokeL.objValue;
    }

    public oy5 s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            this.l = str;
            return this;
        }
        return (oy5) invokeL.objValue;
    }

    public void t(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, hVar) == null) {
            this.d = hVar;
        }
    }

    public oy5 u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            this.i = str;
            return this;
        }
        return (oy5) invokeL.objValue;
    }

    public final kf j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new c(this);
        }
        return (kf) invokeV.objValue;
    }

    public void l() {
        lf lfVar;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (lfVar = this.a) != null && (viewGroup = this.c) != null) {
            lfVar.e(viewGroup);
            this.c.setVisibility(8);
            this.c = null;
            g gVar = this.e;
            if (gVar != null) {
                gVar.dismiss();
            }
        }
    }

    @NonNull
    public final View k(LayoutInflater layoutInflater) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layoutInflater)) == null) {
            View inflate = layoutInflater.inflate(R.layout.float_tips_layout, (ViewGroup) null);
            this.p = inflate.findViewById(R.id.float_tips_layout);
            this.m = (TextView) inflate.findViewById(R.id.float_tips_content);
            this.n = (TextView) inflate.findViewById(R.id.float_tips_title);
            this.o = (TbImageView) inflate.findViewById(R.id.float_tips_bar_icon);
            this.q = (ImageView) inflate.findViewById(R.id.float_tips_close_btn);
            this.r = (TBSpecificationBtn) inflate.findViewById(R.id.float_tips_right_btn);
            this.o.N(this.k, 10, false);
            this.n.setText(this.i);
            this.m.setText(this.j);
            this.r.setText(this.l);
            this.r.setOnClickListener(new d(this));
            this.p.setOnClickListener(new e(this));
            ImageView imageView = this.q;
            if (imageView != null) {
                imageView.setVisibility(this.s);
                this.q.setOnClickListener(new f(this));
            }
            n();
            return inflate;
        }
        return (View) invokeL.objValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0105);
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0207).setShapeRadius(vi.g(this.b, R.dimen.tbds31)).setShadowColor(R.color.CAM_X0803).setShadowSide(ShadowDrawable.ALL).setShadowRadius(vi.g(this.b, R.dimen.tbds10)).setOffsetX(0).setOffsetY(vi.g(this.b, R.dimen.tbds5)).into(this.p);
            View view2 = this.p;
            if (view2 != null) {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                    layoutParams2.leftMargin = -vi.g(this.b, R.dimen.tbds10);
                    layoutParams2.rightMargin = -vi.g(this.b, R.dimen.tbds10);
                }
            }
            ka5 ka5Var = new ka5();
            ka5Var.q(R.color.CAM_X0302);
            this.r.setConfig(ka5Var);
            ImageView imageView = this.q;
            if (imageView != null) {
                WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_card_close22, R.color.CAM_X0111, null);
            }
        }
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ViewGroup viewGroup = this.c;
            if (viewGroup == null) {
                return false;
            }
            viewGroup.setVisibility(0);
            lf lfVar = this.a;
            if (lfVar != null) {
                lfVar.e(this.c);
            }
            this.h = new a(this);
            mf mfVar = new mf();
            mfVar.d(true);
            mfVar.h(new b(this));
            if (this.f == null) {
                this.f = j();
            }
            mfVar.a(this.f);
            int i = this.t;
            if (i == 80) {
                mfVar.e(R.anim.push_open_tip_enter);
                mfVar.f(R.anim.push_open_tip_out);
            } else if (i == 48) {
                mfVar.e(R.anim.push_top_in);
                mfVar.f(R.anim.push_top_out);
            }
            lf b2 = mfVar.b();
            this.a = b2;
            b2.p(this.b, this.c, false);
            return true;
        }
        return invokeV.booleanValue;
    }
}
