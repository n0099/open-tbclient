package com.baidu.tieba;

import android.app.Activity;
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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.funad.view.FunAdAgreeView;
import com.baidu.tieba.pb.ejection.EjectionAnimationView;
import com.baidu.tieba.view.WaterRippleView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class vu6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity a;
    public int b;
    public FrameLayout c;
    public WaterRippleView d;
    public EjectionAnimationView e;
    public PopupWindow f;

    /* loaded from: classes6.dex */
    public class a implements uv7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vu6 a;

        public a(vu6 vu6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vu6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vu6Var;
        }

        @Override // com.baidu.tieba.uv7
        public /* synthetic */ void onStart() {
            tv7.a(this);
        }

        @Override // com.baidu.tieba.uv7
        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.e.setVisibility(8);
                if (this.a.f == null || !this.a.f.isShowing()) {
                    return;
                }
                ih.d(this.a.f, this.a.a);
            }
        }
    }

    public vu6(Activity activity) {
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
        this.b = 0;
        this.a = activity;
        e();
        f();
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? UtilHelper.getImmersiveStickyBarHeight() + UtilHelper.getScreenHeight(this.a) : invokeV.intValue;
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
            this.f = popupWindow;
            popupWindow.setContentView(this.c);
            this.f.setHeight(d());
            this.f.setWidth(-1);
            this.f.setOutsideTouchable(false);
            this.f.setFocusable(false);
            this.f.setTouchable(false);
        }
    }

    public final void g(View view2, Rect rect) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, view2, rect) == null) && ih.m(this.f, view2, this.b, 0, 0)) {
            this.e.setAnchorPosition((rect.right + rect.left) / 2, (rect.bottom + rect.top) / 2);
            this.e.k();
        }
    }

    public void h(FunAdAgreeView funAdAgreeView) {
        WaterRippleView waterRippleView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, funAdAgreeView) == null) || funAdAgreeView == null || (waterRippleView = this.d) == null) {
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
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (popupWindow = this.f) == null) {
            return;
        }
        popupWindow.setClippingEnabled(z);
    }

    public void j(View view2, List<Bitmap> list, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, view2, list, rect) == null) {
            this.e.setVisibility(0);
            this.e.setBitmaps(list);
            g(view2, rect);
        }
    }

    public void k(LinearLayout linearLayout, FunAdAgreeView funAdAgreeView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, linearLayout, funAdAgreeView) == null) || linearLayout == null || funAdAgreeView == null) {
            return;
        }
        if (funAdAgreeView.getWidth() != 0 && funAdAgreeView.getHeight() != 0) {
            WaterRippleView waterRippleView = this.d;
            if (waterRippleView == null) {
                this.d = new WaterRippleView(this.a);
            } else {
                ViewParent parent = waterRippleView.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.d);
                }
            }
            linearLayout.getGlobalVisibleRect(new Rect());
            Rect rect = new Rect();
            funAdAgreeView.getImgAgree().getGlobalVisibleRect(rect);
            int centerX = rect.centerX();
            int centerY = rect.centerY();
            int f = ej.f(this.a, R.dimen.tbds166);
            int i = centerX - f;
            int i2 = centerY - f;
            int i3 = f * 2;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i3);
            layoutParams.addRule(13, -1);
            layoutParams.setMargins(i, i2, 0, 0);
            this.c.addView(this.d, layoutParams);
            return;
        }
        BdLog.e("FunAdAgreeView not measured");
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.e.l();
        }
    }
}
