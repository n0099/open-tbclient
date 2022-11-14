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
/* loaded from: classes5.dex */
public class rn<V extends TypeAdapter.ViewHolder> extends kn<qn, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public kn<xn, V> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rn(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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

    @Override // com.baidu.tieba.kn
    public V onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            return onCreateViewHolder(viewGroup, new qn());
        }
        return (V) invokeL.objValue;
    }

    public void u(kn knVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, knVar) == null) {
            this.a = knVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: s */
    public V onCreateViewHolder(ViewGroup viewGroup, qn qnVar) {
        InterceptResult invokeLL;
        V onCreateViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, viewGroup, qnVar)) == null) {
            kn<xn, V> knVar = this.a;
            if (knVar == null) {
                return null;
            }
            if (this.mType == knVar.getHeaderId()) {
                onCreateViewHolder = this.a.onCreateHeaderViewHolder(viewGroup, qnVar.c());
            } else if (this.mType == this.a.getContentId()) {
                onCreateViewHolder = this.a.onCreateContentViewHolder(viewGroup, qnVar.c());
            } else if (this.mType == this.a.getExtendId()) {
                onCreateViewHolder = this.a.onCreateExtendViewHolder(viewGroup, qnVar.c());
            } else if (this.mType == this.a.getBottomId()) {
                onCreateViewHolder = this.a.onCreateBottomViewHolder(viewGroup, qnVar.c());
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
    @Override // com.baidu.tieba.kn
    /* renamed from: t */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, qn qnVar, V v) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, qnVar, v})) == null) {
            kn<xn, V> knVar = this.a;
            if (knVar == null) {
                return null;
            }
            if (this.mType == knVar.getHeaderId()) {
                return this.a.onFillHeaderViewHolder(i, view2, viewGroup, qnVar.c(), v);
            }
            if (this.mType == this.a.getContentId()) {
                return this.a.onFillContentViewHolder(i, view2, viewGroup, qnVar.c(), v);
            }
            if (this.mType == this.a.getExtendId()) {
                return this.a.onFillExtendViewHolder(i, view2, viewGroup, qnVar.c(), v);
            }
            if (this.mType == this.a.getBottomId()) {
                return this.a.onFillBottomViewHolder(i, view2, viewGroup, qnVar.c(), v);
            }
            return this.a.onFillViewHolder(i, view2, viewGroup, qnVar.c(), v);
        }
        return (View) invokeCommon.objValue;
    }
}
