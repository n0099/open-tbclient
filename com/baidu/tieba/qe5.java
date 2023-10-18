package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class qe5 extends ed5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ie5 a;

    @Override // com.baidu.tieba.ed5
    public void c(gd5 gd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gd5Var) == null) {
        }
    }

    public qe5(ie5 ie5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ie5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ie5Var;
    }

    @Override // com.baidu.tieba.ed5
    public gd5 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setBarLauncherType(6);
            editorTools.setBackgroundColorId(R.color.CAM_X0602);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
            editorTools.setMoreDeskBgColorId(R.color.CAM_X0206);
            editorTools.G(false);
            return new pe5(editorTools);
        }
        return (gd5) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ed5
    public void d(gd5 gd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gd5Var) == null) {
            EditorTools a = gd5Var.a();
            a.setHideBigEmotion(true);
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            a.h(arrayList);
            a.d(new re5(a.getContext(), this.a));
            od5 p = a.p(5);
            p.d = 0;
            p.f(false);
            a.setClearEbPadding(true);
            a.f();
        }
    }
}
