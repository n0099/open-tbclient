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
public class tfb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull zd5 zd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, tbPageContext, editorTools, zd5Var) == null) {
            editorTools.f(new ne5(tbPageContext.getPageActivity(), 7));
            editorTools.setActionListener(16, zd5Var);
        }
    }

    public static void c(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull zd5 zd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, tbPageContext, editorTools, zd5Var) == null) {
            editorTools.f(new be5(tbPageContext.getPageActivity(), 10));
            editorTools.setActionListener(59, zd5Var);
        }
    }

    public static void e(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull zd5 zd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, editorTools, zd5Var) == null) {
            editorTools.f(new te5(tbPageContext.getPageActivity(), 12));
            editorTools.setActionListener(69, zd5Var);
        }
    }

    public static void f(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull zd5 zd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, tbPageContext, editorTools, zd5Var) == null) {
            editorTools.f(new ye5(tbPageContext.getPageActivity(), 11));
            editorTools.setActionListener(61, zd5Var);
        }
    }

    public static ze5 g(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull zd5 zd5Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, tbPageContext, editorTools, zd5Var)) == null) {
            ze5 ze5Var = new ze5(tbPageContext.getPageActivity(), 4);
            editorTools.f(ze5Var);
            editorTools.setActionListener(21, zd5Var);
            return ze5Var;
        }
        return (ze5) invokeLLL.objValue;
    }

    public static void j(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull zd5 zd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, tbPageContext, editorTools, zd5Var) == null) {
            editorTools.f(new fh5(tbPageContext.getPageActivity(), 2));
            editorTools.setActionListener(60, zd5Var);
        }
    }

    public static void l(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull zd5 zd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, tbPageContext, editorTools, zd5Var) == null) {
            editorTools.f(new hh5(tbPageContext.getPageActivity(), 8));
            editorTools.setActionListener(22, zd5Var);
        }
    }

    public static void b(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull zd5 zd5Var) {
        CustomResponsedMessage runTask;
        le5 le5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, tbPageContext, editorTools, zd5Var) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, tbPageContext.getPageActivity()), le5.class)) != null && (le5Var = (le5) runTask.getData()) != null) {
            le5Var.o = true;
            le5Var.l = 9;
            editorTools.f(le5Var);
            editorTools.setActionListener(25, zd5Var);
        }
    }

    public static void d(@NonNull EditorTools editorTools, @NonNull zd5 zd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, editorTools, zd5Var) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            editorTools.k(arrayList);
            le5 u = editorTools.u(5);
            if (u != null) {
                u.l = 5;
                u.e(true);
            }
            editorTools.setActionListener(24, zd5Var);
            editorTools.setActionListener(3, zd5Var);
        }
    }

    public static void i(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools) {
        CustomResponsedMessage runTask;
        le5 le5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, tbPageContext, editorTools) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, tbPageContext.getPageActivity()), le5.class)) != null && (le5Var = (le5) runTask.getData()) != null) {
            le5Var.o = true;
            le5Var.l = 10;
            editorTools.f(le5Var);
        }
    }

    public static void h(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull zd5 zd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, tbPageContext, editorTools, zd5Var) == null) {
            editorTools.f(new we5(tbPageContext.getPageActivity(), 1));
            editorTools.setActionListener(14, zd5Var);
            editorTools.setActionListener(12, zd5Var);
            editorTools.setActionListener(13, zd5Var);
            editorTools.setActionListener(15, zd5Var);
            editorTools.setActionListener(48, zd5Var);
            editorTools.setActionListener(46, zd5Var);
            editorTools.setActionListener(49, zd5Var);
            editorTools.setActionListener(47, zd5Var);
        }
    }

    public static void k(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull zd5 zd5Var) {
        le5 le5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65546, null, tbPageContext, editorTools, zd5Var) == null) && rta.a()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, tbPageContext.getPageActivity()), le5.class);
            if (runTask != null && (le5Var = (le5) runTask.getData()) != null) {
                le5Var.l = 3;
                editorTools.f(le5Var);
            }
            editorTools.setActionListener(10, zd5Var);
            editorTools.setActionListener(11, zd5Var);
        }
    }

    public static r9b m(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, String str, @NonNull zd5 zd5Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, tbPageContext, editorTools, str, zd5Var)) == null) {
            r9b r9bVar = new r9b(tbPageContext.getPageActivity(), str);
            r9bVar.n(0);
            editorTools.f(r9bVar);
            editorTools.setActionListener(43, zd5Var);
            editorTools.setActionListener(55, zd5Var);
            editorTools.setActionListener(66, zd5Var);
            editorTools.setActionListener(77, zd5Var);
            return r9bVar;
        }
        return (r9b) invokeLLLL.objValue;
    }
}
