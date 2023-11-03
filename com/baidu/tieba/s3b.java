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
public class s3b extends zd5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* loaded from: classes8.dex */
    public interface b {
        void a(String str);
    }

    /* loaded from: classes8.dex */
    public class a implements yd5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r3b a;
        public final /* synthetic */ s3b b;

        public a(s3b s3bVar, r3b r3bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s3bVar, r3bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s3bVar;
            this.a = r3bVar;
        }

        @Override // com.baidu.tieba.yd5
        public void S(xd5 xd5Var) {
            r3b r3bVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, xd5Var) != null) || (r3bVar = this.a) == null || r3bVar.a() == null || xd5Var == null) {
                return;
            }
            int i = xd5Var.a;
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
            this.a.w((String) xd5Var.c);
        }
    }

    public s3b() {
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

    @Override // com.baidu.tieba.zd5
    public be5 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setHideBigEmotion(true);
            editorTools.setBarLauncherType(4);
            editorTools.setBackgroundColorId(R.color.CAM_X0207);
            return new r3b(editorTools);
        }
        return (be5) invokeL.objValue;
    }

    @Override // com.baidu.tieba.zd5
    public void c(be5 be5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, be5Var) != null) || !(be5Var instanceof r3b)) {
            return;
        }
        EditorTools a2 = be5Var.a();
        a aVar = new a(this, (r3b) be5Var);
        a2.setActionListener(4, aVar);
        a2.setActionListener(7, aVar);
        a2.setActionListener(8, aVar);
    }

    @Override // com.baidu.tieba.zd5
    public void d(be5 be5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, be5Var) != null) || be5Var == null) {
            return;
        }
        EditorTools a2 = be5Var.a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        a2.k(arrayList);
        ke5 u = a2.u(5);
        if (u != null) {
            u.f(false);
            u.d = 0;
        }
        a2.f(new t3b(a2.getContext()));
        a2.h();
        a2.K(new xd5(35, 5, Boolean.FALSE));
        a2.v();
    }

    public be5 g(Context context, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, bVar)) == null) {
            this.a = bVar;
            return super.a(context);
        }
        return (be5) invokeLL.objValue;
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
