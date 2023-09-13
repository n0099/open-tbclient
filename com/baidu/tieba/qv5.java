package com.baidu.tieba;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.tieba.sv5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class qv5 extends ov5<wn5, sv5.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> e;

    public qv5(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ov5
    /* renamed from: h */
    public wn5 f(ViewType viewType, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, viewType, viewGroup)) == null) {
            return new wn5(this.e.getPageActivity(), null);
        }
        return (wn5) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ov5
    /* renamed from: g */
    public void d(ViewType viewType, wn5 wn5Var, sv5.b bVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, viewType, wn5Var, bVar) == null) {
            if (bVar.b && !TextUtils.isEmpty(bVar.a)) {
                str = bVar.a;
            } else {
                str = bVar.g;
            }
            wn5Var.l(str);
            wn5Var.j(bVar.d);
            wn5Var.h(bVar.c);
            wn5Var.m(bVar.f);
            wn5Var.f(bVar.e);
            wn5Var.o();
            wn5Var.onChangeSkinType();
            wn5Var.b().setOnClickListener(bVar.h);
        }
    }
}
