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
/* loaded from: classes5.dex */
public class n39 extends o65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* loaded from: classes5.dex */
    public interface b {
        void a(String str);
    }

    /* loaded from: classes5.dex */
    public class a implements n65 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m39 a;
        public final /* synthetic */ n39 b;

        public a(n39 n39Var, m39 m39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n39Var, m39Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n39Var;
            this.a = m39Var;
        }

        @Override // com.baidu.tieba.n65
        public void A(m65 m65Var) {
            m39 m39Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, m65Var) != null) || (m39Var = this.a) == null || m39Var.b() == null || m65Var == null) {
                return;
            }
            int i = m65Var.a;
            if (i != 4) {
                if (i != 7) {
                    if (i == 8) {
                        this.a.z();
                        if (!this.b.h(this.a.getContext(), 25066)) {
                            return;
                        }
                        this.a.p();
                        if (this.b.a != null) {
                            this.b.a.a(this.a.m());
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.a.getContext().showToast((int) R.string.over_limit_tip);
                return;
            }
            this.a.v((String) m65Var.c);
        }
    }

    public n39() {
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

    @Override // com.baidu.tieba.o65
    public q65 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setHideBigEmotion(true);
            editorTools.setBarLauncherType(4);
            editorTools.setBackgroundColorId(R.color.CAM_X0207);
            return new m39(editorTools);
        }
        return (q65) invokeL.objValue;
    }

    @Override // com.baidu.tieba.o65
    public void c(q65 q65Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q65Var) != null) || !(q65Var instanceof m39)) {
            return;
        }
        EditorTools b2 = q65Var.b();
        a aVar = new a(this, (m39) q65Var);
        b2.setActionListener(4, aVar);
        b2.setActionListener(7, aVar);
        b2.setActionListener(8, aVar);
    }

    @Override // com.baidu.tieba.o65
    public void d(q65 q65Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, q65Var) != null) || q65Var == null) {
            return;
        }
        EditorTools b2 = q65Var.b();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        b2.h(arrayList);
        x65 o = b2.o(5);
        if (o != null) {
            o.e(false);
            o.d = 0;
        }
        b2.d(new o39(b2.getContext()));
        b2.f();
        b2.B(new m65(35, 5, Boolean.FALSE));
        b2.p();
    }

    public q65 g(Context context, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, bVar)) == null) {
            this.a = bVar;
            return super.a(context);
        }
        return (q65) invokeLL.objValue;
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
