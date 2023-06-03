package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes7.dex */
public class r95 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public boolean b;
    public View c;
    public int d;
    public ViewGroup.LayoutParams e;
    public int f;
    public Runnable g;
    public FrameLayout h;
    public int i;
    public boolean j;
    public ViewTreeObserver.OnGlobalLayoutListener k;
    public int l;
    public CustomMessageListener m;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r95 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(r95 r95Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r95Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r95Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.b = true;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r95 a;

        public b(r95 r95Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r95Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r95Var;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.m();
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r95 a;

        public c(r95 r95Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r95Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r95Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.n();
        }
    }

    public r95(Activity activity) {
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
        this.a = 3;
        this.i = R.color.CAM_X0201;
        this.j = false;
        this.k = null;
        this.l = 0;
        this.m = new a(this, 2921414);
        j(activity, R.color.CAM_X0201, true);
    }

    public r95(Activity activity, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.i = R.color.CAM_X0201;
        this.j = false;
        this.k = null;
        this.l = 0;
        this.m = new a(this, 2921414);
        j(activity, i, z);
    }

    public r95(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.i = R.color.CAM_X0201;
        this.j = false;
        this.k = null;
        this.l = 0;
        this.m = new a(this, 2921414);
        j(activity, R.color.CAM_X0201, z);
    }

    public static r95 f(Activity activity, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65544, null, activity, z)) == null) {
            return new r95(activity, z);
        }
        return (r95) invokeLZ.objValue;
    }

    public static r95 d(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, activity)) == null) {
            return new r95(activity);
        }
        return (r95) invokeL.objValue;
    }

    public final void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (this.g != null) {
                wg.a().removeCallbacks(this.g);
                this.g = null;
            }
            this.g = new c(this);
            wg.a().postDelayed(this.g, i);
        }
    }

    public final boolean i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (!this.b || Math.abs(i) <= 150) {
                return false;
            }
            this.b = false;
            return true;
        }
        return invokeI.booleanValue;
    }

    public void l(int i) {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048581, this, i) != null) || !this.j) {
            return;
        }
        if (i != this.a && (frameLayout = this.h) != null) {
            SkinManager.setBackgroundColor(frameLayout, this.i);
        }
        this.a = i;
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.l = i;
        }
    }

    public static r95 e(Activity activity, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{activity, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            return new r95(activity, i, z);
        }
        return (r95) invokeCommon.objValue;
    }

    public final int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Rect rect = new Rect();
            this.c.getWindowVisibleDisplayFrame(rect);
            return rect.bottom;
        }
        return invokeV.intValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.c.requestLayout();
        }
    }

    public final void j(Activity activity, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{activity, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.i = i;
            this.j = z;
            FrameLayout frameLayout = (FrameLayout) activity.findViewById(16908290);
            this.h = frameLayout;
            if (z) {
                SkinManager.setBackgroundColor(frameLayout, i);
            } else {
                SkinManager.setBackgroundColor(frameLayout, i, 0);
            }
            View childAt = this.h.getChildAt(0);
            this.c = childAt;
            if (childAt == null) {
                return;
            }
            this.k = new b(this);
            this.c.getViewTreeObserver().addOnGlobalLayoutListener(this.k);
            this.e = this.c.getLayoutParams();
            MessageManager.getInstance().registerListener(this.m);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.g != null) {
                wg.a().removeCallbacks(this.g);
                this.g = null;
            }
            View view2 = this.c;
            if (view2 != null) {
                view2.getViewTreeObserver().removeGlobalOnLayoutListener(this.k);
                this.k = null;
            }
            MessageManager.getInstance().unRegisterListener(this.m);
            this.c = null;
            this.h = null;
        }
    }

    public final void m() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (view2 = this.c) == null) {
            return;
        }
        int height = view2.getHeight();
        if (height > this.f) {
            this.f = height;
        }
        int g = g();
        int i = this.l;
        if (i > 0 && i <= this.e.height) {
            g -= i;
        }
        if (g != this.d) {
            int i2 = this.f;
            int i3 = i2 - g;
            if (i3 == 0) {
                this.e.height = i2;
                n();
            } else if (i3 > 200) {
                this.e.height = i2 - i3;
                h(200);
                if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i3) && i3 < (this.f * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i3) {
                    TbadkCoreApplication.getInst().setKeyboardHeight(i3);
                }
            } else if (i(i3)) {
                this.e.height = i2 - i3;
                h(200);
            }
            this.d = g;
        }
    }
}
