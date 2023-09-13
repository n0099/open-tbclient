package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class wm<V extends TypeAdapter.ViewHolder> extends pm<vm, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pm<cn, V> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wm(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(context, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.pm
    public V onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            return onCreateViewHolder(viewGroup, new vm());
        }
        return (V) invokeL.objValue;
    }

    public void u(pm pmVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, pmVar) == null) {
            this.a = pmVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: s */
    public V onCreateViewHolder(ViewGroup viewGroup, vm vmVar) {
        InterceptResult invokeLL;
        V onCreateViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, viewGroup, vmVar)) == null) {
            pm<cn, V> pmVar = this.a;
            if (pmVar == null) {
                return null;
            }
            if (this.mType == pmVar.getHeaderId()) {
                onCreateViewHolder = this.a.onCreateHeaderViewHolder(viewGroup, vmVar.c());
            } else if (this.mType == this.a.getContentId()) {
                onCreateViewHolder = this.a.onCreateContentViewHolder(viewGroup, vmVar.c());
            } else if (this.mType == this.a.getExtendId()) {
                onCreateViewHolder = this.a.onCreateExtendViewHolder(viewGroup, vmVar.c());
            } else if (this.mType == this.a.getBottomId()) {
                onCreateViewHolder = this.a.onCreateBottomViewHolder(viewGroup, vmVar.c());
            } else {
                onCreateViewHolder = this.a.onCreateViewHolder(viewGroup);
            }
            if (onCreateViewHolder != null) {
                setOnAdapterItemClickListener(this.a.getOnAdapterItemClickListener());
                return onCreateViewHolder;
            }
            throw new NullPointerException("Order error or holder created is NullPointerException");
        }
        return (V) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: t */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, vm vmVar, V v) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, vmVar, v})) == null) {
            pm<cn, V> pmVar = this.a;
            if (pmVar == null) {
                return null;
            }
            if (this.mType == pmVar.getHeaderId()) {
                return this.a.onFillHeaderViewHolder(i, view2, viewGroup, vmVar.c(), v);
            }
            if (this.mType == this.a.getContentId()) {
                return this.a.onFillContentViewHolder(i, view2, viewGroup, vmVar.c(), v);
            }
            if (this.mType == this.a.getExtendId()) {
                return this.a.onFillExtendViewHolder(i, view2, viewGroup, vmVar.c(), v);
            }
            if (this.mType == this.a.getBottomId()) {
                return this.a.onFillBottomViewHolder(i, view2, viewGroup, vmVar.c(), v);
            }
            return this.a.onFillViewHolder(i, view2, viewGroup, (ViewGroup) vmVar.c(), (cn) v);
        }
        return (View) invokeCommon.objValue;
    }
}
