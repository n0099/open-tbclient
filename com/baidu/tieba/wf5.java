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
/* loaded from: classes8.dex */
public class wf5 extends je5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final of5 a;

    @Override // com.baidu.tieba.je5
    public void c(le5 le5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, le5Var) == null) {
        }
    }

    public wf5(of5 of5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {of5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = of5Var;
    }

    @Override // com.baidu.tieba.je5
    public le5 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setBarLauncherType(6);
            editorTools.setBackgroundColorId(R.color.CAM_X0602);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
            editorTools.setMoreDeskBgColorId(R.color.CAM_X0206);
            editorTools.N(false);
            return new vf5(editorTools);
        }
        return (le5) invokeL.objValue;
    }

    @Override // com.baidu.tieba.je5
    public void d(le5 le5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, le5Var) == null) {
            EditorTools a = le5Var.a();
            a.setHideBigEmotion(true);
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            a.k(arrayList);
            a.f(new xf5(a.getContext(), this.a));
            ue5 u = a.u(5);
            u.d = 0;
            u.f(false);
            a.setClearEbPadding(true);
            a.h();
        }
    }
}
