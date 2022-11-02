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
/* loaded from: classes6.dex */
public class wv5 extends jn<tv5, LiveTabConcernItemViewLineHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public jw5 b;
    public ow5 c;
    public String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wv5(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), tv5.d);
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
    @Override // com.baidu.tieba.jn
    /* renamed from: s */
    public LiveTabConcernItemViewLineHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            jw5 jw5Var = new jw5(this.a, viewGroup, this.d);
            this.b = jw5Var;
            ow5 ow5Var = this.c;
            if (ow5Var != null) {
                jw5Var.s(ow5Var);
            }
            return new LiveTabConcernItemViewLineHolder(this.b);
        }
        return (LiveTabConcernItemViewLineHolder) invokeL.objValue;
    }

    public void u(ow5 ow5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ow5Var) == null) {
            this.c = ow5Var;
            jw5 jw5Var = this.b;
            if (jw5Var != null) {
                jw5Var.s(ow5Var);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: t */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, tv5 tv5Var, LiveTabConcernItemViewLineHolder liveTabConcernItemViewLineHolder) {
        InterceptResult invokeCommon;
        jw5 jw5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, tv5Var, liveTabConcernItemViewLineHolder})) == null) {
            if (liveTabConcernItemViewLineHolder != null && (jw5Var = liveTabConcernItemViewLineHolder.a) != null) {
                jw5Var.l(tv5Var);
                return liveTabConcernItemViewLineHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
