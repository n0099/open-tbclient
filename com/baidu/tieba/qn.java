package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class qn<T, V extends TypeAdapter.ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public io<Cdo> mAdapter;
    public no mAdapterItemClickListener;
    public oo mAdapterItemLongClickListener;
    public Context mContext;
    public ln mImagePreloadSizeData;
    public BdUniqueId mPageId;
    public BdUniqueId mType;
    public V viewholder;

    public BdUniqueId getBottomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public BdUniqueId getContentId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public BdUniqueId getExtendId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public BdUniqueId getHeaderId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public V onCreateBottomViewHolder(ViewGroup viewGroup, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, viewGroup, t)) == null) {
            return null;
        }
        return (V) invokeLL.objValue;
    }

    public V onCreateContentViewHolder(ViewGroup viewGroup, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, viewGroup, t)) == null) {
            return null;
        }
        return (V) invokeLL.objValue;
    }

    public V onCreateExtendViewHolder(ViewGroup viewGroup, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, viewGroup, t)) == null) {
            return null;
        }
        return (V) invokeLL.objValue;
    }

    public V onCreateHeaderViewHolder(ViewGroup viewGroup, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, viewGroup, t)) == null) {
            return null;
        }
        return (V) invokeLL.objValue;
    }

    public abstract V onCreateViewHolder(ViewGroup viewGroup);

    public abstract View onFillViewHolder(int i, View view2, ViewGroup viewGroup, T t, V v);

    public void onFillViewHolder(int i, ViewGroup viewGroup, V v, T t, @NonNull List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Integer.valueOf(i), viewGroup, v, t, list}) == null) {
        }
    }

    public void setMulDel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
        }
    }

    public qn(Context context, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mType = bdUniqueId;
        this.mImagePreloadSizeData = new ln();
    }

    public qn(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mType = bdUniqueId;
        this.mPageId = bdUniqueId2;
        this.mImagePreloadSizeData = new ln();
    }

    private boolean needCreateNewHolder(View view2) {
        InterceptResult invokeL;
        V v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, view2)) == null) {
            if (view2 == null || view2.getTag() == null || (v = this.viewholder) == null || !v.getClass().isAssignableFrom(view2.getTag().getClass()) || !view2.getTag().getClass().isAssignableFrom(this.viewholder.getClass())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public ViewGroup.LayoutParams generateLayoutParamsByParent(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            if (viewGroup instanceof ListView) {
                return new AbsListView.LayoutParams(-1, -2);
            }
            if (viewGroup instanceof RecyclerView) {
                return new RecyclerView.LayoutParams(-1, -2);
            }
            return new ViewGroup.LayoutParams(-1, -2);
        }
        return (ViewGroup.LayoutParams) invokeL.objValue;
    }

    public Cdo getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            io<Cdo> ioVar = this.mAdapter;
            if (ioVar != null) {
                return ioVar.getItem(i);
            }
            return null;
        }
        return (Cdo) invokeI.objValue;
    }

    public int getPositionByType(int i) {
        InterceptResult invokeI;
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            io<Cdo> ioVar = this.mAdapter;
            if (ioVar != null && (bdUniqueId = this.mType) != null) {
                return ioVar.b(i, bdUniqueId.getId());
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public nn getPreloadSize(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            return this.mImagePreloadSizeData.a(i);
        }
        return (nn) invokeI.objValue;
    }

    public boolean isPreloadSizeReady(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            return this.mImagePreloadSizeData.b(i);
        }
        return invokeI.booleanValue;
    }

    public void notifyItemChanged(int i) {
        io<Cdo> ioVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048591, this, i) == null) && (ioVar = this.mAdapter) != null) {
            ioVar.notifyItemChanged(i);
        }
    }

    public void setAdapter(io<Cdo> ioVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, ioVar) == null) {
            this.mAdapter = ioVar;
        }
    }

    public void setOnAdapterItemClickListener(no noVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, noVar) == null) {
            this.mAdapterItemClickListener = noVar;
        }
    }

    public void setOnAdapterItemLongClickListener(oo ooVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, ooVar) == null) {
            this.mAdapterItemLongClickListener = ooVar;
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, bdUniqueId) == null) {
            this.mPageId = bdUniqueId;
        }
    }

    public void setType(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, bdUniqueId) == null) {
            this.mType = bdUniqueId;
        }
    }

    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            io<Cdo> ioVar = this.mAdapter;
            if (ioVar != null) {
                return ioVar.getCount();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public no getOnAdapterItemClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mAdapterItemClickListener;
        }
        return (no) invokeV.objValue;
    }

    public oo getOnAdapterItemLongClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mAdapterItemLongClickListener;
        }
        return (oo) invokeV.objValue;
    }

    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mType;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public void notifyDataSetChanged() {
        io<Cdo> ioVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (ioVar = this.mAdapter) != null) {
            ioVar.notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.baidu.tieba.qn<T, V extends com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder> */
    /* JADX WARN: Multi-variable type inference failed */
    public View getView(int i, View view2, ViewGroup viewGroup, T t) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), view2, viewGroup, t})) == null) {
            if (needCreateNewHolder(view2)) {
                V v = (V) onCreateViewHolder(viewGroup, t);
                this.viewholder = v;
                view2 = v.getView();
                if (BdBaseApplication.getInst().isDebugMode()) {
                    BdLog.i("convertView is creating" + this.viewholder.getClass().getName());
                }
            }
            View view3 = view2;
            return onFillViewHolder(i, view3, viewGroup, (ViewGroup) t, (T) ((TypeAdapter.ViewHolder) view3.getTag()));
        }
        return (View) invokeCommon.objValue;
    }

    public void notifyItemChanged(int i, @Nullable Object obj) {
        io<Cdo> ioVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048592, this, i, obj) == null) && (ioVar = this.mAdapter) != null) {
            ioVar.notifyItemChanged(i, obj);
        }
    }

    public V onCreateViewHolder(ViewGroup viewGroup, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, viewGroup, t)) == null) {
            return onCreateViewHolder(viewGroup);
        }
        return (V) invokeLL.objValue;
    }

    public View onFillBottomViewHolder(int i, View view2, ViewGroup viewGroup, T t, V v) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i), view2, viewGroup, t, v})) == null) {
            return onFillViewHolder(i, view2, viewGroup, (ViewGroup) t, (T) v);
        }
        return (View) invokeCommon.objValue;
    }

    public View onFillContentViewHolder(int i, View view2, ViewGroup viewGroup, T t, V v) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i), view2, viewGroup, t, v})) == null) {
            return onFillViewHolder(i, view2, viewGroup, (ViewGroup) t, (T) v);
        }
        return (View) invokeCommon.objValue;
    }

    public View onFillExtendViewHolder(int i, View view2, ViewGroup viewGroup, T t, V v) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i), view2, viewGroup, t, v})) == null) {
            return onFillViewHolder(i, view2, viewGroup, (ViewGroup) t, (T) v);
        }
        return (View) invokeCommon.objValue;
    }

    public View onFillHeaderViewHolder(int i, View view2, ViewGroup viewGroup, T t, V v) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048602, this, new Object[]{Integer.valueOf(i), view2, viewGroup, t, v})) == null) {
            return onFillViewHolder(i, view2, viewGroup, (ViewGroup) t, (T) v);
        }
        return (View) invokeCommon.objValue;
    }

    public void onFillViewHolder(int i, ViewGroup viewGroup, V v, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Integer.valueOf(i), viewGroup, v, t}) == null) {
            onFillViewHolder(i, v.getView(), viewGroup, (ViewGroup) t, (T) v);
        }
    }

    public boolean setPreloadSize(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048611, this, i, i2, i3)) == null) {
            return this.mImagePreloadSizeData.c(i, i2, i3);
        }
        return invokeIII.booleanValue;
    }
}
