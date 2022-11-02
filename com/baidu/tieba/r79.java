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
public class r79 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull f65 f65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, tbPageContext, editorTools, f65Var) == null) {
            editorTools.d(new r65(tbPageContext.getPageActivity(), 7));
            editorTools.setActionListener(16, f65Var);
        }
    }

    public static void c(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull f65 f65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, tbPageContext, editorTools, f65Var) == null) {
            editorTools.d(new h65(tbPageContext.getPageActivity(), 10));
            editorTools.setActionListener(59, f65Var);
        }
    }

    public static void e(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull f65 f65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, editorTools, f65Var) == null) {
            editorTools.d(new x65(tbPageContext.getPageActivity(), 12));
            editorTools.setActionListener(69, f65Var);
        }
    }

    public static void f(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull f65 f65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, tbPageContext, editorTools, f65Var) == null) {
            editorTools.d(new c75(tbPageContext.getPageActivity(), 11));
            editorTools.setActionListener(61, f65Var);
        }
    }

    public static d75 g(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull f65 f65Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, tbPageContext, editorTools, f65Var)) == null) {
            d75 d75Var = new d75(tbPageContext.getPageActivity(), 4);
            editorTools.d(d75Var);
            editorTools.setActionListener(21, f65Var);
            return d75Var;
        }
        return (d75) invokeLLL.objValue;
    }

    public static void j(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull f65 f65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, tbPageContext, editorTools, f65Var) == null) {
            editorTools.d(new p85(tbPageContext.getPageActivity(), 2));
            editorTools.setActionListener(60, f65Var);
        }
    }

    public static void l(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull f65 f65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, tbPageContext, editorTools, f65Var) == null) {
            editorTools.d(new r85(tbPageContext.getPageActivity(), 8));
            editorTools.setActionListener(22, f65Var);
        }
    }

    public static void b(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull f65 f65Var) {
        CustomResponsedMessage runTask;
        p65 p65Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, tbPageContext, editorTools, f65Var) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, tbPageContext.getPageActivity()), p65.class)) != null && (p65Var = (p65) runTask.getData()) != null) {
            p65Var.o = true;
            p65Var.l = 9;
            editorTools.d(p65Var);
            editorTools.setActionListener(25, f65Var);
        }
    }

    public static void d(@NonNull EditorTools editorTools, @NonNull f65 f65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, editorTools, f65Var) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            editorTools.h(arrayList);
            p65 n = editorTools.n(5);
            if (n != null) {
                n.l = 5;
                n.d(true);
            }
            editorTools.setActionListener(24, f65Var);
            editorTools.setActionListener(3, f65Var);
        }
    }

    public static void i(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools) {
        CustomResponsedMessage runTask;
        p65 p65Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, tbPageContext, editorTools) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, tbPageContext.getPageActivity()), p65.class)) != null && (p65Var = (p65) runTask.getData()) != null) {
            p65Var.o = true;
            p65Var.l = 10;
            editorTools.d(p65Var);
        }
    }

    public static void h(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull f65 f65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, tbPageContext, editorTools, f65Var) == null) {
            editorTools.d(new a75(tbPageContext.getPageActivity(), 1));
            editorTools.setActionListener(14, f65Var);
            editorTools.setActionListener(12, f65Var);
            editorTools.setActionListener(13, f65Var);
            editorTools.setActionListener(15, f65Var);
            editorTools.setActionListener(48, f65Var);
            editorTools.setActionListener(46, f65Var);
            editorTools.setActionListener(49, f65Var);
            editorTools.setActionListener(47, f65Var);
        }
    }

    public static void k(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull f65 f65Var) {
        p65 p65Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65546, null, tbPageContext, editorTools, f65Var) == null) && tq8.a()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, tbPageContext.getPageActivity()), p65.class);
            if (runTask != null && (p65Var = (p65) runTask.getData()) != null) {
                p65Var.l = 3;
                editorTools.d(p65Var);
            }
            editorTools.setActionListener(10, f65Var);
            editorTools.setActionListener(11, f65Var);
        }
    }

    public static c49 m(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, String str, @NonNull f65 f65Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, tbPageContext, editorTools, str, f65Var)) == null) {
            c49 c49Var = new c49(tbPageContext.getPageActivity(), str);
            boolean z = false;
            c49Var.k(0);
            if (SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1) {
                z = true;
            }
            c49Var.l(z);
            editorTools.d(c49Var);
            editorTools.setActionListener(43, f65Var);
            editorTools.setActionListener(55, f65Var);
            editorTools.setActionListener(66, f65Var);
            return c49Var;
        }
        return (c49) invokeLLLL.objValue;
    }
}
