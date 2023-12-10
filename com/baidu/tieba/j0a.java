package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.pb.pb.main.PbFirstFloorEmptyHolder;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class j0a extends a0a<nwa, PbFirstFloorEmptyHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final PbFragment g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0a(PbFragment pbFragment, BdUniqueId type) {
        super(pbFragment, type);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, type};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((i6a) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pbFragment, "pbFragment");
        Intrinsics.checkNotNullParameter(type, "type");
        this.g = pbFragment;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: x */
    public PbFirstFloorEmptyHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            View view2 = new View(this.g.getContext());
            view2.setVisibility(8);
            return new PbFirstFloorEmptyHolder(view2);
        }
        return (PbFirstFloorEmptyHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.a0a, com.baidu.tieba.ci
    /* renamed from: y */
    public View onFillViewHolder(int i, View convertView, ViewGroup parent, nwa data, PbFirstFloorEmptyHolder viewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), convertView, parent, data, viewHolder})) == null) {
            Intrinsics.checkNotNullParameter(convertView, "convertView");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            View view2 = viewHolder.getView();
            Intrinsics.checkNotNullExpressionValue(view2, "viewHolder.view");
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
