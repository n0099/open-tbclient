package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.horizonalList.widget.ItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class ml8 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LayoutInflater a;
    public int b;
    public ItemViewHolder c;
    public List<nl8> d;
    public final ArrayList<ItemViewHolder> e;
    public View.OnClickListener f;

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public ml8(Context context, int i, ItemViewHolder itemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), itemViewHolder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new ArrayList<>();
        this.a = LayoutInflater.from(context);
        this.b = i;
        this.c = itemViewHolder;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                view2 = this.a.inflate(this.b, viewGroup, false);
                ItemViewHolder b = this.c.b(view2);
                b.d(this.f);
                view2.setTag(b);
                this.e.add(b);
            }
            ItemViewHolder itemViewHolder = (ItemViewHolder) view2.getTag();
            if (ListUtils.getItem(this.d, i) != null) {
                a(itemViewHolder, this.d.get(i));
            }
            return itemViewHolder.getView();
        }
        return (View) invokeILL.objValue;
    }

    public final void a(ItemViewHolder itemViewHolder, nl8 nl8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, itemViewHolder, nl8Var) == null) && nl8Var != null && itemViewHolder != null) {
            itemViewHolder.a(nl8Var);
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && ListUtils.getCount(this.e) > 0) {
            Iterator<ItemViewHolder> it = this.e.iterator();
            while (it.hasNext()) {
                it.next().c(i);
            }
        }
    }

    public void c(List<nl8> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.d = list;
        }
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f = onClickListener;
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return ListUtils.getItem(this.d, i);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (ListUtils.getItem(this.d, i) == null) {
                return -1L;
            }
            return ((nl8) ListUtils.getItem(this.d, i)).hashCode();
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return ListUtils.getCount(this.d);
        }
        return invokeV.intValue;
    }
}
