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
/* loaded from: classes7.dex */
public class p8b extends je5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* loaded from: classes7.dex */
    public interface b {
        void a(String str);
    }

    /* loaded from: classes7.dex */
    public class a implements ie5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o8b a;
        public final /* synthetic */ p8b b;

        public a(p8b p8bVar, o8b o8bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p8bVar, o8bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p8bVar;
            this.a = o8bVar;
        }

        @Override // com.baidu.tieba.ie5
        public void U(he5 he5Var) {
            o8b o8bVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, he5Var) != null) || (o8bVar = this.a) == null || o8bVar.a() == null || he5Var == null) {
                return;
            }
            int i = he5Var.a;
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
            this.a.w((String) he5Var.c);
        }
    }

    public p8b() {
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

    @Override // com.baidu.tieba.je5
    public le5 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setHideBigEmotion(true);
            editorTools.setBarLauncherType(4);
            editorTools.setBackgroundColorId(R.color.CAM_X0207);
            return new o8b(editorTools);
        }
        return (le5) invokeL.objValue;
    }

    @Override // com.baidu.tieba.je5
    public void c(le5 le5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, le5Var) != null) || !(le5Var instanceof o8b)) {
            return;
        }
        EditorTools a2 = le5Var.a();
        a aVar = new a(this, (o8b) le5Var);
        a2.setActionListener(4, aVar);
        a2.setActionListener(7, aVar);
        a2.setActionListener(8, aVar);
    }

    @Override // com.baidu.tieba.je5
    public void d(le5 le5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, le5Var) != null) || le5Var == null) {
            return;
        }
        EditorTools a2 = le5Var.a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        a2.k(arrayList);
        ue5 u = a2.u(5);
        if (u != null) {
            u.f(false);
            u.d = 0;
        }
        a2.f(new q8b(a2.getContext()));
        a2.h();
        a2.K(new he5(35, 5, Boolean.FALSE));
        a2.v();
    }

    public le5 g(Context context, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, bVar)) == null) {
            this.a = bVar;
            return super.a(context);
        }
        return (le5) invokeLL.objValue;
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
