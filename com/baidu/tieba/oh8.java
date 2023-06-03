package com.baidu.tieba;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class oh8 extends GridLayoutManager.SpanSizeLookup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final RecyclerView a;
    public final int b;
    public final SparseIntArray c;
    public final int d;

    public oh8(RecyclerView recyclerView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {recyclerView, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new SparseIntArray();
        this.a = recyclerView;
        this.b = Math.max(1, d());
        this.d = i;
        setSpanIndexCacheEnabled(true);
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return Math.max(Resources.getSystem().getDisplayMetrics().heightPixels, Resources.getSystem().getDisplayMetrics().widthPixels);
        }
        return invokeV.intValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int measuredWidth = this.a.getMeasuredWidth();
            if (measuredWidth == 0) {
                measuredWidth = this.a.getWidth();
            }
            return (measuredWidth - this.a.getPaddingLeft()) - this.a.getPaddingRight();
        }
        return invokeV.intValue;
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public float c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (a() * 1.0f) / this.b;
        }
        return invokeV.floatValue;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
    public void invalidateSpanIndexCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.c.clear();
            super.invalidateSpanIndexCache();
        }
    }

    public final int e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (a() <= 0) {
                return 1;
            }
            return ((int) Math.floor(f(i) / c())) + 1;
        }
        return invokeI.intValue;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
    public int getSpanSize(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return Math.min(this.b, e(i));
        }
        return invokeI.intValue;
    }

    public final int f(int i) {
        InterceptResult invokeI;
        RecyclerView.ViewHolder createViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            RecyclerView.Adapter adapter = this.a.getAdapter();
            int i2 = this.c.get(i, -1);
            if (i2 != -1) {
                return i2;
            }
            if (adapter == null || (createViewHolder = adapter.createViewHolder(this.a, adapter.getItemViewType(i))) == null) {
                return 0;
            }
            adapter.onBindViewHolder(createViewHolder, i);
            createViewHolder.itemView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            int measuredWidth = createViewHolder.itemView.getMeasuredWidth() + this.d;
            adapter.onViewRecycled(createViewHolder);
            this.c.put(i, measuredWidth);
            return measuredWidth;
        }
        return invokeI.intValue;
    }
}
