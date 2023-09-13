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
/* loaded from: classes8.dex */
public class xm9 extends ui5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbEditorData.ThreadData a;
    public ti5 b;
    public boolean c;
    public boolean d;

    /* loaded from: classes8.dex */
    public class a implements ti5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wm9 a;
        public final /* synthetic */ xm9 b;

        public a(xm9 xm9Var, wm9 wm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xm9Var, wm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xm9Var;
            this.a = wm9Var;
        }

        @Override // com.baidu.tieba.ti5
        public void G(si5 si5Var) {
            wm9 wm9Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, si5Var) != null) || (wm9Var = this.a) == null || wm9Var.a() == null || si5Var == null) {
                return;
            }
            if (this.b.b != null) {
                this.b.b.G(si5Var);
            }
            int i = si5Var.a;
            if (i != 32) {
                if (i != 36) {
                    if (i == 43 && !bx5.c(this.a.getContext().getPageContext(), true, false)) {
                        HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(this.a.getContext().getActivity(), 25004, HotSelectActivityConfig.FROM_PB);
                        if (this.b.a != null) {
                            hotSelectActivityConfig.setForumExtra(JavaTypesHelper.toLong(this.b.a.getForumId(), 0L), this.b.a.getFirstDir(), this.b.a.getSecondDir());
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
            this.a.a().D(new si5(1, 11, null));
        }
    }

    public xm9() {
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

    public void k(ti5 ti5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ti5Var) == null) {
            this.b = ti5Var;
        }
    }

    public void l(PbEditorData.ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, threadData) == null) {
            this.a = threadData;
        }
    }

    @Override // com.baidu.tieba.ui5
    public wi5 b(Context context) {
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
            editorTools.G(true);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.F(true);
            return new wm9(editorTools);
        }
        return (wi5) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ui5
    public void c(wi5 wi5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wi5Var) != null) || !(wi5Var instanceof wm9)) {
            return;
        }
        EditorTools a2 = wi5Var.a();
        a aVar = new a(this, (wm9) wi5Var);
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

    @Override // com.baidu.tieba.ui5
    public void d(wi5 wi5Var) {
        String str;
        CustomResponsedMessage runTask;
        ej5 ej5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wi5Var) == null) {
            EditorTools a2 = wi5Var.a();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            if (!this.c) {
                arrayList.add(10);
                a2.d(new pj5(a2.getContext(), 1));
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
                if (pja.a() && sga.a(str, Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), ej5.class)) != null && (ej5Var = (ej5) runTask.getData()) != null) {
                    ej5Var.l = 2;
                    a2.d(ej5Var);
                }
                a2.d(new gj5(a2.getContext(), 4));
                if (!this.c) {
                    CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, a2.getContext()), ej5.class);
                    if (runTask2 != null && runTask2.getData() != null) {
                        ej5 ej5Var2 = (ej5) runTask2.getData();
                        ej5Var2.l = 6;
                        a2.d(ej5Var2);
                    }
                    CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, a2.getContext()), ej5.class);
                    if (runTask3 != null && runTask3.getData() != null) {
                        ej5 ej5Var3 = (ej5) runTask3.getData();
                        ej5Var3.l = 7;
                        a2.d(ej5Var3);
                    }
                }
                if (!"PbChosenActivity".equals(a2.getContext().getClass().getSimpleName()) && !this.c) {
                    a2.d(new nj5(a2.getContext(), 5));
                }
            }
            if (!this.c && !this.d) {
                arrayList.add(8);
            }
            a2.h(arrayList);
            ej5 p = a2.p(5);
            if (p != null) {
                p.l = 3;
                if (this.c || this.d) {
                    p.e(false);
                }
            }
            a2.f();
            if (this.c || this.d) {
                a2.D(new si5(35, 5, Boolean.FALSE));
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
