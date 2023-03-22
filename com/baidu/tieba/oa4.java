package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class oa4 implements kp1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<sm3> a;
    public FrameLayout b;
    public boolean c;
    public boolean d;

    public oa4(@NonNull FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frameLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList<>();
        this.d = false;
        this.b = frameLayout;
    }

    @Override // com.baidu.tieba.kp1
    public boolean a(View view2, zx2 zx2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, zx2Var)) == null) {
            if (!d(view2)) {
                return false;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(zx2Var.f(), zx2Var.c());
            layoutParams.leftMargin = zx2Var.d();
            layoutParams.topMargin = zx2Var.e();
            this.b.updateViewLayout(view2, layoutParams);
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.kp1
    public boolean c(View view2, zx2 zx2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, zx2Var)) == null) {
            if (view2 != null && zx2Var != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(zx2Var.f(), zx2Var.c());
                layoutParams.leftMargin = zx2Var.d();
                layoutParams.topMargin = zx2Var.e();
                this.b.addView(view2, layoutParams);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.kp1
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.kp1
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b.getContext();
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kp1
    public FrameLayout getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.b;
        }
        return (FrameLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kp1
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    public final synchronized void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this) {
                this.a.clear();
            }
        }
    }

    public final synchronized sm3[] j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            synchronized (this) {
                if (this.a.isEmpty()) {
                    return null;
                }
                sm3[] sm3VarArr = new sm3[this.a.size()];
                this.a.toArray(sm3VarArr);
                return sm3VarArr;
            }
        }
        return (sm3[]) invokeV.objValue;
    }

    public void k() {
        sm3[] j;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (j = j()) != null) {
            for (sm3 sm3Var : j) {
                sm3Var.e();
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            sm3[] j = j();
            if (j != null) {
                for (sm3 sm3Var : j) {
                    sm3Var.onViewDestroy();
                }
            }
            i();
        }
    }

    public void m() {
        sm3[] j;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (j = j()) != null) {
            for (sm3 sm3Var : j) {
                sm3Var.l();
            }
        }
    }

    @Override // com.baidu.tieba.kp1
    public boolean d(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view2)) == null) {
            if (view2 == null) {
                return false;
            }
            ViewParent parent = view2.getParent();
            FrameLayout frameLayout = this.b;
            if (parent != frameLayout || frameLayout.indexOfChild(view2) < 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.kp1
    public synchronized void e(sm3 sm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, sm3Var) == null) {
            synchronized (this) {
                if (sm3Var == null) {
                    return;
                }
                if (!this.a.contains(sm3Var)) {
                    this.a.add(sm3Var);
                }
            }
        }
    }

    @Override // com.baidu.tieba.kp1
    public synchronized void f(sm3 sm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sm3Var) == null) {
            synchronized (this) {
                if (sm3Var == null) {
                    return;
                }
                this.a.remove(sm3Var);
            }
        }
    }

    @Override // com.baidu.tieba.kp1
    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.d = z;
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.c = z;
        }
    }

    @Override // com.baidu.tieba.kp1
    public boolean removeView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, view2)) == null) {
            if (!d(view2)) {
                return false;
            }
            this.b.removeView(view2);
            return true;
        }
        return invokeL.booleanValue;
    }
}
