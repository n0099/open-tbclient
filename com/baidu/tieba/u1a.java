package com.baidu.tieba;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class u1a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public HeadImageView b;
    public ValueAnimator c;
    public boolean d;
    public int e;
    public boolean f;
    public Runnable g;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u1a a;

        public a(u1a u1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u1aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.c != null) {
                    this.a.c.cancel();
                }
                this.a.f = false;
                this.a.e = 3;
                this.a.a.setVisibility(0);
                if (this.a.b != null) {
                    this.a.b.setVisibility(4);
                }
                WebPManager.setPureDrawable(this.a.a, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Interpolator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(u1a u1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
                return (float) ((Math.sin((f * 18.84955592153876d) - 1.5707963267948966d) * 0.075d) + 1.075d);
            }
            return invokeF.floatValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u1a a;

        public c(u1a u1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u1aVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                View view2 = (bb5.c() <= 0 || this.a.b == null) ? this.a.a : this.a.b;
                if (view2 != null) {
                    view2.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    view2.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        }
    }

    public u1a(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = false;
        this.e = 3;
        this.f = false;
        this.g = new a(this);
        this.a = imageView;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.c = valueAnimator;
        valueAnimator.setDuration(4000L);
        this.c.setFloatValues(0.0f, 1.0f);
        this.c.setInterpolator(new b(this));
        this.c.addUpdateListener(new c(this));
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.d = true;
            this.e = i;
            int b2 = bb5.b();
            if (b2 > 0) {
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.a, b2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                long c2 = bb5.c();
                if (c2 > 0 && this.b != null) {
                    this.a.setVisibility(4);
                    this.b.setVisibility(0);
                    ImMessageCenterPojo h = ts8.n().h(String.valueOf(c2), 2);
                    if (h != null) {
                        this.b.startLoad(h.getGroup_head(), 12, false);
                    }
                }
                ValueAnimator valueAnimator = this.c;
                if (valueAnimator != null) {
                    valueAnimator.start();
                }
                this.f = true;
                SafeHandler.getInst().postDelayed(this.g, 10000L);
            }
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.d = z;
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f = z;
        }
    }

    public void m(HeadImageView headImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, headImageView) == null) {
            this.b = headImageView;
        }
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SafeHandler.getInst().removeCallbacks(this.g);
            ValueAnimator valueAnimator = this.c;
            if (valueAnimator != null) {
                valueAnimator.removeAllListeners();
                this.c.removeAllUpdateListeners();
                this.c.cancel();
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.d && TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().b()) {
            int b2 = bb5.b();
            if (bb5.c() > 0) {
                WebPManager.setPureDrawable(this.a, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            } else if (b2 > 0) {
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.a, b2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
    }
}
