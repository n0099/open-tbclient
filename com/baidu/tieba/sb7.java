package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.entelechy.adapter.FrsGroupCardLayoutHolder;
import com.baidu.tieba.frs.view.FrsGroupCardLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class sb7 extends en<vc7, FrsGroupCardLayoutHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sb7(TbPageContext<?> pageContext) {
        super(pageContext.getPageActivity(), vc7.c.a());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        this.a = pageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.en
    /* renamed from: s */
    public FrsGroupCardLayoutHolder onCreateViewHolder(ViewGroup parent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, parent)) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Activity pageActivity = this.a.getPageActivity();
            Intrinsics.checkNotNullExpressionValue(pageActivity, "pageContext.pageActivity");
            return new FrsGroupCardLayoutHolder(new FrsGroupCardLayout(pageActivity, null, 2, null));
        }
        return (FrsGroupCardLayoutHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.en
    /* renamed from: t */
    public View onFillViewHolder(int i, View convertView, ViewGroup parent, vc7 data, FrsGroupCardLayoutHolder holder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), convertView, parent, data, holder})) == null) {
            Intrinsics.checkNotNullParameter(convertView, "convertView");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.a().setData(data);
            View view2 = holder.getView();
            Intrinsics.checkNotNullExpressionValue(view2, "holder.view");
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
