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
/* loaded from: classes6.dex */
public class jsa extends bi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* loaded from: classes6.dex */
    public interface b {
        void a(String str);
    }

    /* loaded from: classes6.dex */
    public class a implements ai5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ isa a;
        public final /* synthetic */ jsa b;

        public a(jsa jsaVar, isa isaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jsaVar, isaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jsaVar;
            this.a = isaVar;
        }

        @Override // com.baidu.tieba.ai5
        public void E(zh5 zh5Var) {
            isa isaVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, zh5Var) != null) || (isaVar = this.a) == null || isaVar.a() == null || zh5Var == null) {
                return;
            }
            int i = zh5Var.a;
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
            this.a.v((String) zh5Var.c);
        }
    }

    public jsa() {
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

    @Override // com.baidu.tieba.bi5
    public di5 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setHideBigEmotion(true);
            editorTools.setBarLauncherType(4);
            editorTools.setBackgroundColorId(R.color.CAM_X0207);
            return new isa(editorTools);
        }
        return (di5) invokeL.objValue;
    }

    @Override // com.baidu.tieba.bi5
    public void c(di5 di5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, di5Var) != null) || !(di5Var instanceof isa)) {
            return;
        }
        EditorTools a2 = di5Var.a();
        a aVar = new a(this, (isa) di5Var);
        a2.setActionListener(4, aVar);
        a2.setActionListener(7, aVar);
        a2.setActionListener(8, aVar);
    }

    @Override // com.baidu.tieba.bi5
    public void d(di5 di5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, di5Var) != null) || di5Var == null) {
            return;
        }
        EditorTools a2 = di5Var.a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        a2.h(arrayList);
        li5 p = a2.p(5);
        if (p != null) {
            p.e(false);
            p.d = 0;
        }
        a2.d(new ksa(a2.getContext()));
        a2.f();
        a2.D(new zh5(35, 5, Boolean.FALSE));
        a2.q();
    }

    public di5 g(Context context, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, bVar)) == null) {
            this.a = bVar;
            return super.a(context);
        }
        return (di5) invokeLL.objValue;
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
