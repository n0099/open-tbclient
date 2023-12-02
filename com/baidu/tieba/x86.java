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
/* loaded from: classes9.dex */
public class x86 extends ci<u86, LiveTabConcernItemViewLineHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public k96 b;
    public p96 c;
    public String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x86(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), u86.d);
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
    @Override // com.baidu.tieba.ci
    /* renamed from: t */
    public LiveTabConcernItemViewLineHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            k96 k96Var = new k96(this.a, viewGroup, this.d);
            this.b = k96Var;
            p96 p96Var = this.c;
            if (p96Var != null) {
                k96Var.r(p96Var);
            }
            return new LiveTabConcernItemViewLineHolder(this.b);
        }
        return (LiveTabConcernItemViewLineHolder) invokeL.objValue;
    }

    public void x(p96 p96Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, p96Var) == null) {
            this.c = p96Var;
            k96 k96Var = this.b;
            if (k96Var != null) {
                k96Var.r(p96Var);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: u */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, u86 u86Var, LiveTabConcernItemViewLineHolder liveTabConcernItemViewLineHolder) {
        InterceptResult invokeCommon;
        k96 k96Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, u86Var, liveTabConcernItemViewLineHolder})) == null) {
            if (liveTabConcernItemViewLineHolder != null && (k96Var = liveTabConcernItemViewLineHolder.a) != null) {
                k96Var.j(u86Var);
                return liveTabConcernItemViewLineHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
