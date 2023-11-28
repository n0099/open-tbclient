package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class pkb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull fe5 fe5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, tbPageContext, editorTools, fe5Var) == null) {
            editorTools.f(new te5(tbPageContext.getPageActivity(), 7));
            editorTools.setActionListener(16, fe5Var);
        }
    }

    public static void c(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull fe5 fe5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, tbPageContext, editorTools, fe5Var) == null) {
            editorTools.f(new he5(tbPageContext.getPageActivity(), 10));
            editorTools.setActionListener(59, fe5Var);
        }
    }

    public static void e(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull fe5 fe5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, editorTools, fe5Var) == null) {
            editorTools.f(new ze5(tbPageContext.getPageActivity(), 12));
            editorTools.setActionListener(69, fe5Var);
        }
    }

    public static void f(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull fe5 fe5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, tbPageContext, editorTools, fe5Var) == null) {
            editorTools.f(new ef5(tbPageContext.getPageActivity(), 11));
            editorTools.setActionListener(61, fe5Var);
        }
    }

    public static ff5 g(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull fe5 fe5Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, tbPageContext, editorTools, fe5Var)) == null) {
            ff5 ff5Var = new ff5(tbPageContext.getPageActivity(), 4);
            editorTools.f(ff5Var);
            editorTools.setActionListener(21, fe5Var);
            return ff5Var;
        }
        return (ff5) invokeLLL.objValue;
    }

    public static void j(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull fe5 fe5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, tbPageContext, editorTools, fe5Var) == null) {
            editorTools.f(new lh5(tbPageContext.getPageActivity(), 2));
            editorTools.setActionListener(60, fe5Var);
        }
    }

    public static void l(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull fe5 fe5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, tbPageContext, editorTools, fe5Var) == null) {
            editorTools.f(new nh5(tbPageContext.getPageActivity(), 8));
            editorTools.setActionListener(22, fe5Var);
        }
    }

    public static void b(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull fe5 fe5Var) {
        CustomResponsedMessage runTask;
        re5 re5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, tbPageContext, editorTools, fe5Var) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, tbPageContext.getPageActivity()), re5.class)) != null && (re5Var = (re5) runTask.getData()) != null) {
            re5Var.o = true;
            re5Var.l = 9;
            editorTools.f(re5Var);
            editorTools.setActionListener(25, fe5Var);
        }
    }

    public static void d(@NonNull EditorTools editorTools, @NonNull fe5 fe5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, editorTools, fe5Var) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            editorTools.k(arrayList);
            re5 u = editorTools.u(5);
            if (u != null) {
                u.l = 5;
                u.e(true);
            }
            editorTools.setActionListener(24, fe5Var);
            editorTools.setActionListener(3, fe5Var);
        }
    }

    public static void i(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools) {
        CustomResponsedMessage runTask;
        re5 re5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, tbPageContext, editorTools) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, tbPageContext.getPageActivity()), re5.class)) != null && (re5Var = (re5) runTask.getData()) != null) {
            re5Var.o = true;
            re5Var.l = 10;
            editorTools.f(re5Var);
        }
    }

    public static void h(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull fe5 fe5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, tbPageContext, editorTools, fe5Var) == null) {
            editorTools.f(new cf5(tbPageContext.getPageActivity(), 1));
            editorTools.setActionListener(14, fe5Var);
            editorTools.setActionListener(12, fe5Var);
            editorTools.setActionListener(13, fe5Var);
            editorTools.setActionListener(15, fe5Var);
            editorTools.setActionListener(48, fe5Var);
            editorTools.setActionListener(46, fe5Var);
            editorTools.setActionListener(49, fe5Var);
            editorTools.setActionListener(47, fe5Var);
        }
    }

    public static void k(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull fe5 fe5Var) {
        re5 re5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65546, null, tbPageContext, editorTools, fe5Var) == null) && kya.a()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, tbPageContext.getPageActivity()), re5.class);
            if (runTask != null && (re5Var = (re5) runTask.getData()) != null) {
                re5Var.l = 3;
                editorTools.f(re5Var);
            }
            editorTools.setActionListener(10, fe5Var);
            editorTools.setActionListener(11, fe5Var);
        }
    }

    public static neb m(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, String str, @NonNull fe5 fe5Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, tbPageContext, editorTools, str, fe5Var)) == null) {
            neb nebVar = new neb(tbPageContext.getPageActivity(), str);
            nebVar.n(0);
            editorTools.f(nebVar);
            editorTools.setActionListener(43, fe5Var);
            editorTools.setActionListener(55, fe5Var);
            editorTools.setActionListener(66, fe5Var);
            editorTools.setActionListener(77, fe5Var);
            return nebVar;
        }
        return (neb) invokeLLLL.objValue;
    }
}
