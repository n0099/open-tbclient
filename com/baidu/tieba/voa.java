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
public class voa extends bj5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* loaded from: classes8.dex */
    public interface b {
        void a(String str);
    }

    /* loaded from: classes8.dex */
    public class a implements aj5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uoa a;
        public final /* synthetic */ voa b;

        public a(voa voaVar, uoa uoaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voaVar, uoaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = voaVar;
            this.a = uoaVar;
        }

        @Override // com.baidu.tieba.aj5
        public void B(zi5 zi5Var) {
            uoa uoaVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, zi5Var) != null) || (uoaVar = this.a) == null || uoaVar.b() == null || zi5Var == null) {
                return;
            }
            int i = zi5Var.a;
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
            this.a.v((String) zi5Var.c);
        }
    }

    public voa() {
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

    @Override // com.baidu.tieba.bj5
    public dj5 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setHideBigEmotion(true);
            editorTools.setBarLauncherType(4);
            editorTools.setBackgroundColorId(R.color.CAM_X0207);
            return new uoa(editorTools);
        }
        return (dj5) invokeL.objValue;
    }

    @Override // com.baidu.tieba.bj5
    public void c(dj5 dj5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dj5Var) != null) || !(dj5Var instanceof uoa)) {
            return;
        }
        EditorTools b2 = dj5Var.b();
        a aVar = new a(this, (uoa) dj5Var);
        b2.setActionListener(4, aVar);
        b2.setActionListener(7, aVar);
        b2.setActionListener(8, aVar);
    }

    @Override // com.baidu.tieba.bj5
    public void d(dj5 dj5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dj5Var) != null) || dj5Var == null) {
            return;
        }
        EditorTools b2 = dj5Var.b();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        b2.h(arrayList);
        lj5 p = b2.p(5);
        if (p != null) {
            p.e(false);
            p.d = 0;
        }
        b2.d(new woa(b2.getContext()));
        b2.f();
        b2.D(new zi5(35, 5, Boolean.FALSE));
        b2.q();
    }

    public dj5 g(Context context, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, bVar)) == null) {
            this.a = bVar;
            return super.a(context);
        }
        return (dj5) invokeLL.objValue;
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
