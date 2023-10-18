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
/* loaded from: classes6.dex */
public class k84 implements hn1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<ok3> a;
    public FrameLayout b;
    public boolean c;
    public boolean d;

    public k84(@NonNull FrameLayout frameLayout) {
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

    @Override // com.baidu.tieba.hn1
    public boolean a(View view2, vv2 vv2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, vv2Var)) == null) {
            if (!d(view2)) {
                return false;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(vv2Var.f(), vv2Var.c());
            layoutParams.leftMargin = vv2Var.d();
            layoutParams.topMargin = vv2Var.e();
            this.b.updateViewLayout(view2, layoutParams);
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.hn1
    public boolean c(View view2, vv2 vv2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, vv2Var)) == null) {
            if (view2 != null && vv2Var != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(vv2Var.f(), vv2Var.c());
                layoutParams.leftMargin = vv2Var.d();
                layoutParams.topMargin = vv2Var.e();
                this.b.addView(view2, layoutParams);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.hn1
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.hn1
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b.getContext();
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hn1
    public FrameLayout getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.b;
        }
        return (FrameLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hn1
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

    public final synchronized ok3[] j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            synchronized (this) {
                if (this.a.isEmpty()) {
                    return null;
                }
                ok3[] ok3VarArr = new ok3[this.a.size()];
                this.a.toArray(ok3VarArr);
                return ok3VarArr;
            }
        }
        return (ok3[]) invokeV.objValue;
    }

    public void k() {
        ok3[] j;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (j = j()) != null) {
            for (ok3 ok3Var : j) {
                ok3Var.d();
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            ok3[] j = j();
            if (j != null) {
                for (ok3 ok3Var : j) {
                    ok3Var.onViewDestroy();
                }
            }
            i();
        }
    }

    public void m() {
        ok3[] j;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (j = j()) != null) {
            for (ok3 ok3Var : j) {
                ok3Var.k();
            }
        }
    }

    @Override // com.baidu.tieba.hn1
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

    @Override // com.baidu.tieba.hn1
    public synchronized void e(ok3 ok3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ok3Var) == null) {
            synchronized (this) {
                if (ok3Var == null) {
                    return;
                }
                if (!this.a.contains(ok3Var)) {
                    this.a.add(ok3Var);
                }
            }
        }
    }

    @Override // com.baidu.tieba.hn1
    public synchronized void f(ok3 ok3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ok3Var) == null) {
            synchronized (this) {
                if (ok3Var == null) {
                    return;
                }
                this.a.remove(ok3Var);
            }
        }
    }

    @Override // com.baidu.tieba.hn1
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

    @Override // com.baidu.tieba.hn1
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
