package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class pn7 extends fi7<gq6, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean l;

    /* loaded from: classes7.dex */
    public class a extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public zo6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(pn7 pn7Var, zo6 zo6Var) {
            super(zo6Var.h());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pn7Var, zo6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zo6Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pn7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: G */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            zo6 zo6Var = new zo6(this.c);
            zo6Var.u(null, TbadkCoreStatisticKey.FRS_HOT_TOPIC_ITEM_CLICK);
            return new a(this, zo6Var);
        }
        return (a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.fi7, com.baidu.tieba.pm
    /* renamed from: H */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, gq6 gq6Var, a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, gq6Var, aVar})) == null) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FRS_HOT_TOPIC_CARD_SHOW));
            if (gq6Var != null) {
                gq6Var.f = i + 1;
                aVar.a.x(BdUtilHelper.dip2px(this.c.getPageActivity(), 7.0f));
                aVar.a.z(this.l);
                aVar.a.j(this.c, TbadkCoreApplication.getInst().getSkinType());
            }
            aVar.a.i(gq6Var);
            return aVar.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
