package com.baidu.tieba;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class jl8 extends nb5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbEditorData.ThreadData a;
    public mb5 b;
    public boolean c;
    public boolean d;

    /* loaded from: classes5.dex */
    public class a implements mb5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ il8 a;
        public final /* synthetic */ jl8 b;

        public a(jl8 jl8Var, il8 il8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jl8Var, il8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jl8Var;
            this.a = il8Var;
        }

        @Override // com.baidu.tieba.mb5
        public void C(lb5 lb5Var) {
            il8 il8Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, lb5Var) != null) || (il8Var = this.a) == null || il8Var.b() == null || lb5Var == null) {
                return;
            }
            if (this.b.b != null) {
                this.b.b.C(lb5Var);
            }
            int i = lb5Var.a;
            if (i != 32) {
                if (i != 36) {
                    if (i == 43 && !yo5.c(this.a.getContext().getPageContext(), true, false)) {
                        HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(this.a.getContext().getActivity(), 25004, HotSelectActivityConfig.FROM_PB);
                        if (this.b.a != null) {
                            hotSelectActivityConfig.setForumExtra(gg.g(this.b.a.getForumId(), 0L), this.b.a.getFirstDir(), this.b.a.getSecondDir());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
                        return;
                    }
                    return;
                } else if (!this.b.h(this.a.getContext().getPageContext(), 11040)) {
                    return;
                } else {
                    this.a.f();
                    return;
                }
            }
            this.a.b().C(new lb5(1, 11, null));
        }
    }

    public jl8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = false;
        this.d = false;
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.d = z;
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.c = z;
        }
    }

    public void k(mb5 mb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, mb5Var) == null) {
            this.b = mb5Var;
        }
    }

    public void l(PbEditorData.ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, threadData) == null) {
            this.a = threadData;
        }
    }

    @Override // com.baidu.tieba.nb5
    public pb5 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setIsFromPb(true);
            editorTools.setBarMaxLauCount(5);
            if (this.c) {
                editorTools.setBarLauncherType(2);
            } else if (this.d) {
                editorTools.setBarLauncherType(5);
            } else {
                editorTools.setBarLauncherType(3);
            }
            editorTools.setBackgroundColorId(0);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
            editorTools.F(true);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.E(true);
            return new il8(editorTools);
        }
        return (pb5) invokeL.objValue;
    }

    @Override // com.baidu.tieba.nb5
    public void c(pb5 pb5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pb5Var) != null) || !(pb5Var instanceof il8)) {
            return;
        }
        EditorTools b = pb5Var.b();
        a aVar = new a(this, (il8) pb5Var);
        b.setActionListener(16, aVar);
        b.setActionListener(14, aVar);
        b.setActionListener(15, aVar);
        b.setActionListener(24, aVar);
        b.setActionListener(3, aVar);
        b.setActionListener(10, aVar);
        b.setActionListener(11, aVar);
        b.setActionListener(36, aVar);
        b.setActionListener(32, aVar);
        b.setActionListener(43, aVar);
        b.setActionListener(45, aVar);
    }

    @Override // com.baidu.tieba.nb5
    public void d(pb5 pb5Var) {
        String str;
        CustomResponsedMessage runTask;
        wb5 wb5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pb5Var) == null) {
            EditorTools b = pb5Var.b();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            if (!this.c) {
                arrayList.add(10);
                b.d(new hc5(b.getContext(), 1));
            }
            if (!this.d) {
                arrayList.add(6);
                arrayList.add(9);
                PbEditorData.ThreadData threadData = this.a;
                if (threadData != null) {
                    str = threadData.getForumName();
                } else {
                    str = "";
                }
                if (vd9.a() && za9.a(str, Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, b.getContext()), wb5.class)) != null && (wb5Var = (wb5) runTask.getData()) != null) {
                    wb5Var.l = 2;
                    b.d(wb5Var);
                }
                b.d(new yb5(b.getContext(), 4));
                if (!this.c) {
                    CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, b.getContext()), wb5.class);
                    if (runTask2 != null && runTask2.getData() != null) {
                        wb5 wb5Var2 = (wb5) runTask2.getData();
                        wb5Var2.l = 6;
                        b.d(wb5Var2);
                    }
                    CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, b.getContext()), wb5.class);
                    if (runTask3 != null && runTask3.getData() != null) {
                        wb5 wb5Var3 = (wb5) runTask3.getData();
                        wb5Var3.l = 7;
                        b.d(wb5Var3);
                    }
                }
                if (!"PbChosenActivity".equals(b.getContext().getClass().getSimpleName()) && !this.c) {
                    b.d(new fc5(b.getContext(), 5));
                }
            }
            if (!this.c && !this.d) {
                arrayList.add(8);
            }
            b.h(arrayList);
            wb5 p = b.p(5);
            if (p != null) {
                p.l = 3;
                if (this.c || this.d) {
                    p.e(false);
                }
            }
            b.f();
            if (this.c || this.d) {
                b.C(new lb5(35, 5, Boolean.FALSE));
            }
        }
    }

    public final boolean h(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, tbPageContext, i)) == null) {
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
