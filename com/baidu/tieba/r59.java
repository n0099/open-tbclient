package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.switchs.RepostToDynamicDefaultSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class r59 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull i55 i55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, tbPageContext, editorTools, i55Var) == null) {
            editorTools.d(new u55(tbPageContext.getPageActivity(), 7));
            editorTools.setActionListener(16, i55Var);
        }
    }

    public static void b(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull i55 i55Var) {
        CustomResponsedMessage runTask;
        s55 s55Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, null, tbPageContext, editorTools, i55Var) == null) || (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, tbPageContext.getPageActivity()), s55.class)) == null || (s55Var = (s55) runTask.getData()) == null) {
            return;
        }
        s55Var.o = true;
        s55Var.l = 9;
        editorTools.d(s55Var);
        editorTools.setActionListener(25, i55Var);
    }

    public static void c(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull i55 i55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, tbPageContext, editorTools, i55Var) == null) {
            editorTools.d(new k55(tbPageContext.getPageActivity(), 10));
            editorTools.setActionListener(59, i55Var);
        }
    }

    public static void d(@NonNull EditorTools editorTools, @NonNull i55 i55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, editorTools, i55Var) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            editorTools.h(arrayList);
            s55 n = editorTools.n(5);
            if (n != null) {
                n.l = 5;
                n.d(true);
            }
            editorTools.setActionListener(24, i55Var);
            editorTools.setActionListener(3, i55Var);
        }
    }

    public static void e(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull i55 i55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, editorTools, i55Var) == null) {
            editorTools.d(new a65(tbPageContext.getPageActivity(), 12));
            editorTools.setActionListener(69, i55Var);
        }
    }

    public static void f(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull i55 i55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, tbPageContext, editorTools, i55Var) == null) {
            editorTools.d(new f65(tbPageContext.getPageActivity(), 11));
            editorTools.setActionListener(61, i55Var);
        }
    }

    public static g65 g(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull i55 i55Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, tbPageContext, editorTools, i55Var)) == null) {
            g65 g65Var = new g65(tbPageContext.getPageActivity(), 4);
            editorTools.d(g65Var);
            editorTools.setActionListener(21, i55Var);
            return g65Var;
        }
        return (g65) invokeLLL.objValue;
    }

    public static void h(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull i55 i55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, tbPageContext, editorTools, i55Var) == null) {
            editorTools.d(new d65(tbPageContext.getPageActivity(), 1));
            editorTools.setActionListener(14, i55Var);
            editorTools.setActionListener(12, i55Var);
            editorTools.setActionListener(13, i55Var);
            editorTools.setActionListener(15, i55Var);
            editorTools.setActionListener(48, i55Var);
            editorTools.setActionListener(46, i55Var);
            editorTools.setActionListener(49, i55Var);
            editorTools.setActionListener(47, i55Var);
        }
    }

    public static void i(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools) {
        CustomResponsedMessage runTask;
        s55 s55Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65544, null, tbPageContext, editorTools) == null) || (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, tbPageContext.getPageActivity()), s55.class)) == null || (s55Var = (s55) runTask.getData()) == null) {
            return;
        }
        s55Var.o = true;
        s55Var.l = 10;
        editorTools.d(s55Var);
    }

    public static void j(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull i55 i55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, tbPageContext, editorTools, i55Var) == null) {
            editorTools.d(new s75(tbPageContext.getPageActivity(), 2));
            editorTools.setActionListener(60, i55Var);
        }
    }

    public static void k(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull i55 i55Var) {
        s55 s55Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65546, null, tbPageContext, editorTools, i55Var) == null) && cp8.a()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, tbPageContext.getPageActivity()), s55.class);
            if (runTask != null && (s55Var = (s55) runTask.getData()) != null) {
                s55Var.l = 3;
                editorTools.d(s55Var);
            }
            editorTools.setActionListener(10, i55Var);
            editorTools.setActionListener(11, i55Var);
        }
    }

    public static void l(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull i55 i55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, tbPageContext, editorTools, i55Var) == null) {
            editorTools.d(new u75(tbPageContext.getPageActivity(), 8));
            editorTools.setActionListener(22, i55Var);
        }
    }

    public static n29 m(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, String str, @NonNull i55 i55Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, tbPageContext, editorTools, str, i55Var)) == null) {
            n29 n29Var = new n29(tbPageContext.getPageActivity(), str);
            n29Var.k(0);
            n29Var.l(SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1);
            editorTools.d(n29Var);
            editorTools.setActionListener(43, i55Var);
            editorTools.setActionListener(55, i55Var);
            editorTools.setActionListener(66, i55Var);
            return n29Var;
        }
        return (n29) invokeLLLL.objValue;
    }
}
