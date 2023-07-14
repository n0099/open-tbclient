package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.LiveTabConcernItemViewLineHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class vc6 extends ln<sc6, LiveTabConcernItemViewLineHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public id6 b;
    public nd6 c;
    public String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vc6(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), sc6.d);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str};
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
        this.d = "";
        this.a = tbPageContext;
        this.d = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: s */
    public LiveTabConcernItemViewLineHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            id6 id6Var = new id6(this.a, viewGroup, this.d);
            this.b = id6Var;
            nd6 nd6Var = this.c;
            if (nd6Var != null) {
                id6Var.s(nd6Var);
            }
            return new LiveTabConcernItemViewLineHolder(this.b);
        }
        return (LiveTabConcernItemViewLineHolder) invokeL.objValue;
    }

    public void u(nd6 nd6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, nd6Var) == null) {
            this.c = nd6Var;
            id6 id6Var = this.b;
            if (id6Var != null) {
                id6Var.s(nd6Var);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: t */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, sc6 sc6Var, LiveTabConcernItemViewLineHolder liveTabConcernItemViewLineHolder) {
        InterceptResult invokeCommon;
        id6 id6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, sc6Var, liveTabConcernItemViewLineHolder})) == null) {
            if (liveTabConcernItemViewLineHolder != null && (id6Var = liveTabConcernItemViewLineHolder.a) != null) {
                id6Var.i(sc6Var);
                return liveTabConcernItemViewLineHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
