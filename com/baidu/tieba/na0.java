package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.refresh.BdSwipeRefreshLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class na0 implements BdSwipeRefreshLayout.h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public boolean c;

    public abstract View a();

    public abstract void b(boolean z);

    public abstract void e();

    public abstract void f(boolean z);

    public abstract void g(boolean z);

    @Override // com.baidu.live.business.refresh.BdSwipeRefreshLayout.h
    public long getCompleteAnimTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    public abstract void h();

    public abstract void i();

    @Override // com.baidu.live.business.refresh.BdSwipeRefreshLayout.h
    public void onPullPercentChange(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
        }
    }

    public na0(Context context) {
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
        this.a = null;
        this.b = null;
        this.c = false;
        this.a = context;
    }

    public final void d(View view2) {
        int makeMeasureSpec;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -2);
            }
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
            int i = layoutParams.height;
            if (i > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view2.measure(childMeasureSpec, makeMeasureSpec);
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.a;
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.baidu.live.business.refresh.BdSwipeRefreshLayout.h
    public final View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.b == null) {
                View a = a();
                this.b = a;
                d(a);
            }
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.live.business.refresh.BdSwipeRefreshLayout.h
    public void onCompleteRefresh() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || this.c) {
            return;
        }
        e();
    }

    @Override // com.baidu.live.business.refresh.BdSwipeRefreshLayout.h
    public void onFinish() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || this.c) {
            return;
        }
        b(true);
    }

    @Override // com.baidu.live.business.refresh.BdSwipeRefreshLayout.h
    public void onPullToRefresh() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || this.c) {
            return;
        }
        g(false);
    }

    @Override // com.baidu.live.business.refresh.BdSwipeRefreshLayout.h
    public void onRefreshing() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || this.c) {
            return;
        }
        h();
        f(true);
    }

    @Override // com.baidu.live.business.refresh.BdSwipeRefreshLayout.h
    public void onReleaseToRefresh() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048593, this) != null) || this.c) {
            return;
        }
        i();
    }
}
