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
/* loaded from: classes8.dex */
public class sfb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull yd5 yd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, tbPageContext, editorTools, yd5Var) == null) {
            editorTools.f(new me5(tbPageContext.getPageActivity(), 7));
            editorTools.setActionListener(16, yd5Var);
        }
    }

    public static void c(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull yd5 yd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, tbPageContext, editorTools, yd5Var) == null) {
            editorTools.f(new ae5(tbPageContext.getPageActivity(), 10));
            editorTools.setActionListener(59, yd5Var);
        }
    }

    public static void e(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull yd5 yd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, editorTools, yd5Var) == null) {
            editorTools.f(new se5(tbPageContext.getPageActivity(), 12));
            editorTools.setActionListener(69, yd5Var);
        }
    }

    public static void f(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull yd5 yd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, tbPageContext, editorTools, yd5Var) == null) {
            editorTools.f(new xe5(tbPageContext.getPageActivity(), 11));
            editorTools.setActionListener(61, yd5Var);
        }
    }

    public static ye5 g(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull yd5 yd5Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, tbPageContext, editorTools, yd5Var)) == null) {
            ye5 ye5Var = new ye5(tbPageContext.getPageActivity(), 4);
            editorTools.f(ye5Var);
            editorTools.setActionListener(21, yd5Var);
            return ye5Var;
        }
        return (ye5) invokeLLL.objValue;
    }

    public static void j(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull yd5 yd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, tbPageContext, editorTools, yd5Var) == null) {
            editorTools.f(new eh5(tbPageContext.getPageActivity(), 2));
            editorTools.setActionListener(60, yd5Var);
        }
    }

    public static void l(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull yd5 yd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, tbPageContext, editorTools, yd5Var) == null) {
            editorTools.f(new gh5(tbPageContext.getPageActivity(), 8));
            editorTools.setActionListener(22, yd5Var);
        }
    }

    public static void b(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull yd5 yd5Var) {
        CustomResponsedMessage runTask;
        ke5 ke5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, tbPageContext, editorTools, yd5Var) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, tbPageContext.getPageActivity()), ke5.class)) != null && (ke5Var = (ke5) runTask.getData()) != null) {
            ke5Var.o = true;
            ke5Var.l = 9;
            editorTools.f(ke5Var);
            editorTools.setActionListener(25, yd5Var);
        }
    }

    public static void d(@NonNull EditorTools editorTools, @NonNull yd5 yd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, editorTools, yd5Var) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            editorTools.k(arrayList);
            ke5 u = editorTools.u(5);
            if (u != null) {
                u.l = 5;
                u.e(true);
            }
            editorTools.setActionListener(24, yd5Var);
            editorTools.setActionListener(3, yd5Var);
        }
    }

    public static void i(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools) {
        CustomResponsedMessage runTask;
        ke5 ke5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, tbPageContext, editorTools) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, tbPageContext.getPageActivity()), ke5.class)) != null && (ke5Var = (ke5) runTask.getData()) != null) {
            ke5Var.o = true;
            ke5Var.l = 10;
            editorTools.f(ke5Var);
        }
    }

    public static void h(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull yd5 yd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, tbPageContext, editorTools, yd5Var) == null) {
            editorTools.f(new ve5(tbPageContext.getPageActivity(), 1));
            editorTools.setActionListener(14, yd5Var);
            editorTools.setActionListener(12, yd5Var);
            editorTools.setActionListener(13, yd5Var);
            editorTools.setActionListener(15, yd5Var);
            editorTools.setActionListener(48, yd5Var);
            editorTools.setActionListener(46, yd5Var);
            editorTools.setActionListener(49, yd5Var);
            editorTools.setActionListener(47, yd5Var);
        }
    }

    public static void k(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull yd5 yd5Var) {
        ke5 ke5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65546, null, tbPageContext, editorTools, yd5Var) == null) && qta.a()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, tbPageContext.getPageActivity()), ke5.class);
            if (runTask != null && (ke5Var = (ke5) runTask.getData()) != null) {
                ke5Var.l = 3;
                editorTools.f(ke5Var);
            }
            editorTools.setActionListener(10, yd5Var);
            editorTools.setActionListener(11, yd5Var);
        }
    }

    public static q9b m(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, String str, @NonNull yd5 yd5Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, tbPageContext, editorTools, str, yd5Var)) == null) {
            q9b q9bVar = new q9b(tbPageContext.getPageActivity(), str);
            q9bVar.n(0);
            editorTools.f(q9bVar);
            editorTools.setActionListener(43, yd5Var);
            editorTools.setActionListener(55, yd5Var);
            editorTools.setActionListener(66, yd5Var);
            editorTools.setActionListener(77, yd5Var);
            return q9bVar;
        }
        return (q9b) invokeLLLL.objValue;
    }
}
