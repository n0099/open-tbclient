package com.baidu.tieba;

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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tieba.pb.ejection.EjectionAnimationView;
import com.baidu.tieba.view.WaterRippleView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class ny4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;
    public int b;
    public FrameLayout c;
    public WaterRippleView d;
    public EjectionAnimationView e;
    public AgreeView f;
    public PopupWindow g;

    /* loaded from: classes5.dex */
    public class a implements cy7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ny4 a;

        @Override // com.baidu.tieba.cy7
        public /* synthetic */ void onStart() {
            by7.a(this);
        }

        public a(ny4 ny4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ny4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ny4Var;
        }

        @Override // com.baidu.tieba.cy7
        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.e.setVisibility(8);
                if (this.a.g != null && this.a.g.isShowing()) {
                    bh.d(this.a.g, this.a.a.getPageActivity());
                }
                if (this.a.f != null) {
                    this.a.f.R();
                }
            }
        }
    }

    public ny4(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        this.a = tbPageContext;
        f();
        g();
    }

    public void i(AgreeView agreeView) {
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

    public void j(boolean z) {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (popupWindow = this.g) != null) {
            popupWindow.setClippingEnabled(z);
        }
    }

    public final int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return UtilHelper.getImmersiveStickyBarHeight() + UtilHelper.getScreenHeight(this.a.getPageActivity());
        }
        return invokeV.intValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.e.l();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c = new FrameLayout(this.a.getPageActivity());
            this.e = new EjectionAnimationView(this.a.getPageActivity());
            this.c.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.e.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.e.setEjectionAnimationViewCallback(new a(this));
            this.c.addView(this.e);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            PopupWindow popupWindow = new PopupWindow();
            this.g = popupWindow;
            popupWindow.setContentView(this.c);
            this.g.setHeight(e());
            this.g.setWidth(-1);
            this.g.setOutsideTouchable(false);
            this.g.setFocusable(false);
            this.g.setTouchable(false);
        }
    }

    public final void h(View view2, Rect rect) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, view2, rect) == null) && bh.m(this.g, view2, this.b, 0, 0)) {
            this.e.setAnchorPosition((rect.right + rect.left) / 2, (rect.bottom + rect.top) / 2);
            this.e.k();
        }
    }

    public void k(View view2, List<Bitmap> list, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, view2, list, rect) == null) {
            this.e.setVisibility(0);
            this.e.setBitmaps(list);
            h(view2, rect);
        }
    }

    public void l(LinearLayout linearLayout, AgreeView agreeView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, linearLayout, agreeView) == null) && linearLayout != null && agreeView != null) {
            if (agreeView.getWidth() != 0 && agreeView.getHeight() != 0) {
                this.f = agreeView;
                WaterRippleView waterRippleView = this.d;
                if (waterRippleView == null) {
                    this.d = new WaterRippleView(this.a.getPageActivity());
                } else {
                    ViewParent parent = waterRippleView.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(this.d);
                    }
                }
                linearLayout.getGlobalVisibleRect(new Rect());
                Rect rect = new Rect();
                agreeView.getImgAgree().getGlobalVisibleRect(rect);
                int centerX = rect.centerX();
                int centerY = rect.centerY();
                int g = xi.g(this.a.getPageActivity(), R.dimen.tbds166);
                int i = centerX - g;
                int i2 = centerY - g;
                int i3 = g * 2;
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
