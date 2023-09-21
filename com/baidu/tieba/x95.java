package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.switchs.WindowGreySwitch;
import com.baidu.tieba.pb.ejection.EjectionAnimationView;
import com.baidu.tieba.view.WaterRippleView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class x95 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public int b;
    public FrameLayout c;
    public WaterRippleView d;
    public EjectionAnimationView e;
    public AgreeView f;
    public PopupWindow g;

    /* loaded from: classes8.dex */
    public class a implements kl9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x95 a;

        @Override // com.baidu.tieba.kl9
        public /* synthetic */ void onStart() {
            jl9.a(this);
        }

        public a(x95 x95Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x95Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x95Var;
        }

        @Override // com.baidu.tieba.kl9
        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.e.setVisibility(8);
                if (this.a.g != null && this.a.g.isShowing()) {
                    this.a.g.dismiss();
                }
                if (this.a.f != null) {
                    this.a.f.W();
                }
            }
        }
    }

    public x95(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.a = context;
        e();
        f();
    }

    public void h(AgreeView agreeView) {
        WaterRippleView waterRippleView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, agreeView) != null) || agreeView == null || (waterRippleView = this.d) == null) {
            return;
        }
        ViewParent parent = waterRippleView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.d);
        }
    }

    public void i(boolean z) {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (popupWindow = this.g) != null) {
            popupWindow.setClippingEnabled(z);
        }
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return UtilHelper.getImmersiveStickyBarHeight() + UtilHelper.getScreenHeight(this.a);
        }
        return invokeV.intValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.e.l();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c = new FrameLayout(this.a);
            this.e = new EjectionAnimationView(this.a);
            this.c.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.e.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.e.setEjectionAnimationViewCallback(new a(this));
            this.c.addView(this.e);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            PopupWindow popupWindow = new PopupWindow();
            this.g = popupWindow;
            popupWindow.setContentView(this.c);
            GreyUtil.grey(this.g);
            this.g.setHeight(d());
            this.g.setWidth(-1);
            this.g.setOutsideTouchable(false);
            this.g.setFocusable(false);
            this.g.setTouchable(false);
        }
    }

    public final void g(View view2, Rect rect) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, view2, rect) == null) && jg.m(this.g, view2, this.b, 0, 0)) {
            this.e.setAnchorPosition((rect.right + rect.left) / 2, (rect.bottom + rect.top) / 2);
            this.e.k();
        }
    }

    public void j(View view2, List<Bitmap> list, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, view2, list, rect) == null) {
            this.e.setVisibility(0);
            this.e.setBitmaps(list);
            g(view2, rect);
        }
    }

    public void k(LinearLayout linearLayout, AgreeView agreeView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, linearLayout, agreeView) == null) && linearLayout != null && agreeView != null) {
            if (agreeView.getWidth() != 0 && agreeView.getHeight() != 0) {
                this.f = agreeView;
                WaterRippleView waterRippleView = this.d;
                if (waterRippleView == null) {
                    this.d = new WaterRippleView(this.a);
                } else {
                    ViewParent parent = waterRippleView.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(this.d);
                    }
                }
                if (WindowGreySwitch.getIsOnNew()) {
                    j9.b(this.d);
                }
                linearLayout.getGlobalVisibleRect(new Rect());
                Rect rect = new Rect();
                agreeView.getImgAgree().getGlobalVisibleRect(rect);
                int centerX = rect.centerX();
                int centerY = rect.centerY();
                int dimens = BdUtilHelper.getDimens(this.a, R.dimen.tbds166);
                int i = centerX - dimens;
                int i2 = centerY - dimens;
                int i3 = dimens * 2;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i3);
                layoutParams.addRule(13, -1);
                layoutParams.setMargins(i, i2, 0, 0);
                this.c.addView(this.d, layoutParams);
                return;
            }
            BdLog.e("AgreeView not measured");
        }
    }
}
