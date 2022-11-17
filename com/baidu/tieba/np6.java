package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public abstract class np6 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rp6 a;
    public boolean b;

    public abstract int b();

    public abstract Object c(int i);

    public abstract int d();

    public abstract long e(int i);

    public abstract View g(int i, View view2, ViewGroup viewGroup);

    public abstract void j(int i);

    public np6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = true;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (h()) {
                return 2;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            rp6 rp6Var = this.a;
            if (rp6Var != null && rp6Var.b() && b() - 1 > this.a.getArrowIndex()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final View a(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
            rp6 rp6Var = this.a;
            if (rp6Var == null) {
                return view2;
            }
            if (view2 == null || view2 != rp6Var.getArrowView()) {
                view2 = this.a.getArrowView();
                if (view2.getLayoutParams() == null) {
                    view2.setLayoutParams(new AbsListView.LayoutParams(-1, d()));
                }
            }
            this.a.a(view2);
            return view2;
        }
        return (View) invokeL.objValue;
    }

    public int f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            rp6 rp6Var = this.a;
            if (rp6Var != null && rp6Var.b()) {
                int arrowIndex = this.a.getArrowIndex();
                if (i < arrowIndex) {
                    return i;
                }
                if (i == arrowIndex) {
                    return -1;
                }
                return i - 1;
            }
            return i;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            if (h()) {
                int f = f(i);
                if (f >= 0) {
                    return c(f);
                }
                return c(i);
            }
            return c(i);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            if (h()) {
                int f = f(i);
                if (f >= 0) {
                    return e(f);
                }
                return e(i);
            }
            return e(i);
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        int arrowIndex;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            if (!h() || (arrowIndex = this.a.getArrowIndex()) <= 0 || i != arrowIndex) {
                return 0;
            }
            return 1;
        }
        return invokeI.intValue;
    }

    public void i(rp6 rp6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, rp6Var) == null) {
            this.a = rp6Var;
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.b = z;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        int b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (h()) {
                if (this.b) {
                    b = this.a.getArrowIndex();
                } else {
                    rp6 rp6Var = this.a;
                    if (rp6Var != null && rp6Var.b()) {
                        b = b();
                    } else {
                        return b();
                    }
                }
                return b + 1;
            }
            return b();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048587, this, i, view2, viewGroup)) == null) {
            if (getItemViewType(i) == 0) {
                return g(f(i), view2, viewGroup);
            }
            return a(view2);
        }
        return (View) invokeILL.objValue;
    }
}
