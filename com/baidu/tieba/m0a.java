package com.baidu.tieba;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
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
/* loaded from: classes7.dex */
public class m0a extends je5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbEditorData.ThreadData a;
    public ie5 b;
    public boolean c;
    public boolean d;

    /* loaded from: classes7.dex */
    public class a implements ie5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l0a a;
        public final /* synthetic */ m0a b;

        public a(m0a m0aVar, l0a l0aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m0aVar, l0aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m0aVar;
            this.a = l0aVar;
        }

        @Override // com.baidu.tieba.ie5
        public void U(he5 he5Var) {
            l0a l0aVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, he5Var) != null) || (l0aVar = this.a) == null || l0aVar.a() == null || he5Var == null) {
                return;
            }
            if (this.b.b != null) {
                this.b.b.U(he5Var);
            }
            int i = he5Var.a;
            if (i != 32) {
                if (i != 36) {
                    if (i == 43 && !rt5.c(this.a.b().getPageContext(), true, false)) {
                        HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(this.a.b().getActivity(), 25004, HotSelectActivityConfig.FROM_PB);
                        if (this.b.a != null) {
                            hotSelectActivityConfig.setForumExtra(JavaTypesHelper.toLong(this.b.a.getForumId(), 0L), this.b.a.getFirstDir(), this.b.a.getSecondDir());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
                        return;
                    }
                    return;
                } else if (!this.b.h(this.a.b().getPageContext(), 11040)) {
                    return;
                } else {
                    this.a.g();
                    return;
                }
            }
            this.a.a().K(new he5(1, 11, null));
        }
    }

    public m0a() {
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

    public void k(ie5 ie5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ie5Var) == null) {
            this.b = ie5Var;
        }
    }

    public void l(PbEditorData.ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, threadData) == null) {
            this.a = threadData;
        }
    }

    @Override // com.baidu.tieba.je5
    public le5 b(Context context) {
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
            editorTools.N(true);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.M(true);
            return new l0a(editorTools);
        }
        return (le5) invokeL.objValue;
    }

    @Override // com.baidu.tieba.je5
    public void c(le5 le5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, le5Var) != null) || !(le5Var instanceof l0a)) {
            return;
        }
        EditorTools a2 = le5Var.a();
        a aVar = new a(this, (l0a) le5Var);
        a2.setActionListener(16, aVar);
        a2.setActionListener(14, aVar);
        a2.setActionListener(15, aVar);
        a2.setActionListener(24, aVar);
        a2.setActionListener(3, aVar);
        a2.setActionListener(10, aVar);
        a2.setActionListener(11, aVar);
        a2.setActionListener(36, aVar);
        a2.setActionListener(32, aVar);
        a2.setActionListener(43, aVar);
        a2.setActionListener(45, aVar);
        a2.setActionListener(77, aVar);
    }

    @Override // com.baidu.tieba.je5
    public void d(le5 le5Var) {
        String str;
        CustomResponsedMessage runTask;
        ue5 ue5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, le5Var) == null) {
            EditorTools a2 = le5Var.a();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            if (!this.c) {
                arrayList.add(10);
                a2.f(new ff5(a2.getContext(), 1));
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
                if (jya.a() && mva.a(str, Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), ue5.class)) != null && (ue5Var = (ue5) runTask.getData()) != null) {
                    ue5Var.l = 2;
                    a2.f(ue5Var);
                }
                a2.f(new we5(a2.getContext(), 4));
                if (!this.c) {
                    CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, a2.getContext()), ue5.class);
                    if (runTask2 != null && runTask2.getData() != null) {
                        ue5 ue5Var2 = (ue5) runTask2.getData();
                        ue5Var2.l = 6;
                        a2.f(ue5Var2);
                    }
                    CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, a2.getContext()), ue5.class);
                    if (runTask3 != null && runTask3.getData() != null) {
                        ue5 ue5Var3 = (ue5) runTask3.getData();
                        ue5Var3.l = 7;
                        a2.f(ue5Var3);
                    }
                }
                if (!"PbChosenActivity".equals(a2.getContext().getClass().getSimpleName()) && !this.c) {
                    a2.f(new df5(a2.getContext(), 5));
                }
            }
            if (!this.c && !this.d) {
                arrayList.add(8);
            }
            a2.k(arrayList);
            ue5 u = a2.u(5);
            if (u != null) {
                u.l = 3;
                if (this.c || this.d) {
                    u.f(false);
                }
            }
            a2.h();
            if (this.c || this.d) {
                a2.K(new he5(35, 5, Boolean.FALSE));
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
