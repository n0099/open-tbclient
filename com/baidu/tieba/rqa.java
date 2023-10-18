package com.baidu.tieba;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class rqa extends ed5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* loaded from: classes8.dex */
    public interface b {
        void a(String str);
    }

    /* loaded from: classes8.dex */
    public class a implements dd5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qqa a;
        public final /* synthetic */ rqa b;

        public a(rqa rqaVar, qqa qqaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rqaVar, qqaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rqaVar;
            this.a = qqaVar;
        }

        @Override // com.baidu.tieba.dd5
        public void O(cd5 cd5Var) {
            qqa qqaVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, cd5Var) != null) || (qqaVar = this.a) == null || qqaVar.a() == null || cd5Var == null) {
                return;
            }
            int i = cd5Var.a;
            if (i != 4) {
                if (i != 7) {
                    if (i == 8) {
                        this.a.A();
                        if (!this.b.h(this.a.m(), 25066)) {
                            return;
                        }
                        this.a.q();
                        if (this.b.a != null) {
                            this.b.a.a(this.a.n());
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.a.m().showToast((int) R.string.over_limit_tip);
                return;
            }
            this.a.w((String) cd5Var.c);
        }
    }

    public rqa() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.ed5
    public gd5 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setHideBigEmotion(true);
            editorTools.setBarLauncherType(4);
            editorTools.setBackgroundColorId(R.color.CAM_X0207);
            return new qqa(editorTools);
        }
        return (gd5) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ed5
    public void c(gd5 gd5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gd5Var) != null) || !(gd5Var instanceof qqa)) {
            return;
        }
        EditorTools a2 = gd5Var.a();
        a aVar = new a(this, (qqa) gd5Var);
        a2.setActionListener(4, aVar);
        a2.setActionListener(7, aVar);
        a2.setActionListener(8, aVar);
    }

    @Override // com.baidu.tieba.ed5
    public void d(gd5 gd5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gd5Var) != null) || gd5Var == null) {
            return;
        }
        EditorTools a2 = gd5Var.a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        a2.h(arrayList);
        od5 p = a2.p(5);
        if (p != null) {
            p.f(false);
            p.d = 0;
        }
        a2.d(new sqa(a2.getContext()));
        a2.f();
        a2.D(new cd5(35, 5, Boolean.FALSE));
        a2.q();
    }

    public gd5 g(Context context, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, bVar)) == null) {
            this.a = bVar;
            return super.a(context);
        }
        return (gd5) invokeLL.objValue;
    }

    public final boolean h(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, tbPageContext, i)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                return true;
            }
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return invokeLI.booleanValue;
    }
}
