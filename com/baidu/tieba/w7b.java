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
public class w7b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull xi5 xi5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, tbPageContext, editorTools, xi5Var) == null) {
            editorTools.d(new kj5(tbPageContext.getPageActivity(), 7));
            editorTools.setActionListener(16, xi5Var);
        }
    }

    public static void c(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull xi5 xi5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, tbPageContext, editorTools, xi5Var) == null) {
            editorTools.d(new zi5(tbPageContext.getPageActivity(), 10));
            editorTools.setActionListener(59, xi5Var);
        }
    }

    public static void e(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull xi5 xi5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, editorTools, xi5Var) == null) {
            editorTools.d(new qj5(tbPageContext.getPageActivity(), 12));
            editorTools.setActionListener(69, xi5Var);
        }
    }

    public static void f(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull xi5 xi5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, tbPageContext, editorTools, xi5Var) == null) {
            editorTools.d(new vj5(tbPageContext.getPageActivity(), 11));
            editorTools.setActionListener(61, xi5Var);
        }
    }

    public static wj5 g(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull xi5 xi5Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, tbPageContext, editorTools, xi5Var)) == null) {
            wj5 wj5Var = new wj5(tbPageContext.getPageActivity(), 4);
            editorTools.d(wj5Var);
            editorTools.setActionListener(21, xi5Var);
            return wj5Var;
        }
        return (wj5) invokeLLL.objValue;
    }

    public static void j(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull xi5 xi5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, tbPageContext, editorTools, xi5Var) == null) {
            editorTools.d(new ll5(tbPageContext.getPageActivity(), 2));
            editorTools.setActionListener(60, xi5Var);
        }
    }

    public static void l(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull xi5 xi5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, tbPageContext, editorTools, xi5Var) == null) {
            editorTools.d(new nl5(tbPageContext.getPageActivity(), 8));
            editorTools.setActionListener(22, xi5Var);
        }
    }

    public static void b(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull xi5 xi5Var) {
        CustomResponsedMessage runTask;
        ij5 ij5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, tbPageContext, editorTools, xi5Var) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, tbPageContext.getPageActivity()), ij5.class)) != null && (ij5Var = (ij5) runTask.getData()) != null) {
            ij5Var.o = true;
            ij5Var.l = 9;
            editorTools.d(ij5Var);
            editorTools.setActionListener(25, xi5Var);
        }
    }

    public static void d(@NonNull EditorTools editorTools, @NonNull xi5 xi5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, editorTools, xi5Var) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            editorTools.h(arrayList);
            ij5 p = editorTools.p(5);
            if (p != null) {
                p.l = 5;
                p.d(true);
            }
            editorTools.setActionListener(24, xi5Var);
            editorTools.setActionListener(3, xi5Var);
        }
    }

    public static void i(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools) {
        CustomResponsedMessage runTask;
        ij5 ij5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, tbPageContext, editorTools) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, tbPageContext.getPageActivity()), ij5.class)) != null && (ij5Var = (ij5) runTask.getData()) != null) {
            ij5Var.o = true;
            ij5Var.l = 10;
            editorTools.d(ij5Var);
        }
    }

    public static void h(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull xi5 xi5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, tbPageContext, editorTools, xi5Var) == null) {
            editorTools.d(new tj5(tbPageContext.getPageActivity(), 1));
            editorTools.setActionListener(14, xi5Var);
            editorTools.setActionListener(12, xi5Var);
            editorTools.setActionListener(13, xi5Var);
            editorTools.setActionListener(15, xi5Var);
            editorTools.setActionListener(48, xi5Var);
            editorTools.setActionListener(46, xi5Var);
            editorTools.setActionListener(49, xi5Var);
            editorTools.setActionListener(47, xi5Var);
        }
    }

    public static void k(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull xi5 xi5Var) {
        ij5 ij5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65546, null, tbPageContext, editorTools, xi5Var) == null) && vla.a()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, tbPageContext.getPageActivity()), ij5.class);
            if (runTask != null && (ij5Var = (ij5) runTask.getData()) != null) {
                ij5Var.l = 3;
                editorTools.d(ij5Var);
            }
            editorTools.setActionListener(10, xi5Var);
            editorTools.setActionListener(11, xi5Var);
        }
    }

    public static u1b m(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, String str, @NonNull xi5 xi5Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, tbPageContext, editorTools, str, xi5Var)) == null) {
            u1b u1bVar = new u1b(tbPageContext.getPageActivity(), str);
            u1bVar.l(0);
            editorTools.d(u1bVar);
            editorTools.setActionListener(43, xi5Var);
            editorTools.setActionListener(55, xi5Var);
            editorTools.setActionListener(66, xi5Var);
            editorTools.setActionListener(77, xi5Var);
            return u1bVar;
        }
        return (u1b) invokeLLLL.objValue;
    }
}
