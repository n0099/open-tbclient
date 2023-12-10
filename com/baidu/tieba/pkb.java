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

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull ie5 ie5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, tbPageContext, editorTools, ie5Var) == null) {
            editorTools.f(new we5(tbPageContext.getPageActivity(), 7));
            editorTools.setActionListener(16, ie5Var);
        }
    }

    public static void c(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull ie5 ie5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, tbPageContext, editorTools, ie5Var) == null) {
            editorTools.f(new ke5(tbPageContext.getPageActivity(), 10));
            editorTools.setActionListener(59, ie5Var);
        }
    }

    public static void e(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull ie5 ie5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, editorTools, ie5Var) == null) {
            editorTools.f(new cf5(tbPageContext.getPageActivity(), 12));
            editorTools.setActionListener(69, ie5Var);
        }
    }

    public static void f(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull ie5 ie5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, tbPageContext, editorTools, ie5Var) == null) {
            editorTools.f(new hf5(tbPageContext.getPageActivity(), 11));
            editorTools.setActionListener(61, ie5Var);
        }
    }

    public static if5 g(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull ie5 ie5Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, tbPageContext, editorTools, ie5Var)) == null) {
            if5 if5Var = new if5(tbPageContext.getPageActivity(), 4);
            editorTools.f(if5Var);
            editorTools.setActionListener(21, ie5Var);
            return if5Var;
        }
        return (if5) invokeLLL.objValue;
    }

    public static void j(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull ie5 ie5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, tbPageContext, editorTools, ie5Var) == null) {
            editorTools.f(new oh5(tbPageContext.getPageActivity(), 2));
            editorTools.setActionListener(60, ie5Var);
        }
    }

    public static void l(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull ie5 ie5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, tbPageContext, editorTools, ie5Var) == null) {
            editorTools.f(new qh5(tbPageContext.getPageActivity(), 8));
            editorTools.setActionListener(22, ie5Var);
        }
    }

    public static void b(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull ie5 ie5Var) {
        CustomResponsedMessage runTask;
        ue5 ue5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, tbPageContext, editorTools, ie5Var) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, tbPageContext.getPageActivity()), ue5.class)) != null && (ue5Var = (ue5) runTask.getData()) != null) {
            ue5Var.o = true;
            ue5Var.l = 9;
            editorTools.f(ue5Var);
            editorTools.setActionListener(25, ie5Var);
        }
    }

    public static void d(@NonNull EditorTools editorTools, @NonNull ie5 ie5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, editorTools, ie5Var) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            editorTools.k(arrayList);
            ue5 u = editorTools.u(5);
            if (u != null) {
                u.l = 5;
                u.e(true);
            }
            editorTools.setActionListener(24, ie5Var);
            editorTools.setActionListener(3, ie5Var);
        }
    }

    public static void i(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools) {
        CustomResponsedMessage runTask;
        ue5 ue5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, tbPageContext, editorTools) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, tbPageContext.getPageActivity()), ue5.class)) != null && (ue5Var = (ue5) runTask.getData()) != null) {
            ue5Var.o = true;
            ue5Var.l = 10;
            editorTools.f(ue5Var);
        }
    }

    public static void h(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull ie5 ie5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, tbPageContext, editorTools, ie5Var) == null) {
            editorTools.f(new ff5(tbPageContext.getPageActivity(), 1));
            editorTools.setActionListener(14, ie5Var);
            editorTools.setActionListener(12, ie5Var);
            editorTools.setActionListener(13, ie5Var);
            editorTools.setActionListener(15, ie5Var);
            editorTools.setActionListener(48, ie5Var);
            editorTools.setActionListener(46, ie5Var);
            editorTools.setActionListener(49, ie5Var);
            editorTools.setActionListener(47, ie5Var);
        }
    }

    public static void k(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull ie5 ie5Var) {
        ue5 ue5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65546, null, tbPageContext, editorTools, ie5Var) == null) && kya.a()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, tbPageContext.getPageActivity()), ue5.class);
            if (runTask != null && (ue5Var = (ue5) runTask.getData()) != null) {
                ue5Var.l = 3;
                editorTools.f(ue5Var);
            }
            editorTools.setActionListener(10, ie5Var);
            editorTools.setActionListener(11, ie5Var);
        }
    }

    public static neb m(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, String str, @NonNull ie5 ie5Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, tbPageContext, editorTools, str, ie5Var)) == null) {
            neb nebVar = new neb(tbPageContext.getPageActivity(), str);
            nebVar.n(0);
            editorTools.f(nebVar);
            editorTools.setActionListener(43, ie5Var);
            editorTools.setActionListener(55, ie5Var);
            editorTools.setActionListener(66, ie5Var);
            editorTools.setActionListener(77, ie5Var);
            return nebVar;
        }
        return (neb) invokeLLLL.objValue;
    }
}
