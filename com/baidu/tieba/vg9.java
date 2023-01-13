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
/* loaded from: classes6.dex */
public class vg9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull a75 a75Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, tbPageContext, editorTools, a75Var) == null) {
            editorTools.d(new m75(tbPageContext.getPageActivity(), 7));
            editorTools.setActionListener(16, a75Var);
        }
    }

    public static void c(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull a75 a75Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, tbPageContext, editorTools, a75Var) == null) {
            editorTools.d(new c75(tbPageContext.getPageActivity(), 10));
            editorTools.setActionListener(59, a75Var);
        }
    }

    public static void e(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull a75 a75Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, editorTools, a75Var) == null) {
            editorTools.d(new s75(tbPageContext.getPageActivity(), 12));
            editorTools.setActionListener(69, a75Var);
        }
    }

    public static void f(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull a75 a75Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, tbPageContext, editorTools, a75Var) == null) {
            editorTools.d(new x75(tbPageContext.getPageActivity(), 11));
            editorTools.setActionListener(61, a75Var);
        }
    }

    public static y75 g(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull a75 a75Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, tbPageContext, editorTools, a75Var)) == null) {
            y75 y75Var = new y75(tbPageContext.getPageActivity(), 4);
            editorTools.d(y75Var);
            editorTools.setActionListener(21, a75Var);
            return y75Var;
        }
        return (y75) invokeLLL.objValue;
    }

    public static void j(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull a75 a75Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, tbPageContext, editorTools, a75Var) == null) {
            editorTools.d(new l95(tbPageContext.getPageActivity(), 2));
            editorTools.setActionListener(60, a75Var);
        }
    }

    public static void l(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull a75 a75Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, tbPageContext, editorTools, a75Var) == null) {
            editorTools.d(new n95(tbPageContext.getPageActivity(), 8));
            editorTools.setActionListener(22, a75Var);
        }
    }

    public static void b(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull a75 a75Var) {
        CustomResponsedMessage runTask;
        k75 k75Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, tbPageContext, editorTools, a75Var) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, tbPageContext.getPageActivity()), k75.class)) != null && (k75Var = (k75) runTask.getData()) != null) {
            k75Var.o = true;
            k75Var.l = 9;
            editorTools.d(k75Var);
            editorTools.setActionListener(25, a75Var);
        }
    }

    public static void d(@NonNull EditorTools editorTools, @NonNull a75 a75Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, editorTools, a75Var) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            editorTools.h(arrayList);
            k75 p = editorTools.p(5);
            if (p != null) {
                p.l = 5;
                p.d(true);
            }
            editorTools.setActionListener(24, a75Var);
            editorTools.setActionListener(3, a75Var);
        }
    }

    public static void i(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools) {
        CustomResponsedMessage runTask;
        k75 k75Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, tbPageContext, editorTools) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, tbPageContext.getPageActivity()), k75.class)) != null && (k75Var = (k75) runTask.getData()) != null) {
            k75Var.o = true;
            k75Var.l = 10;
            editorTools.d(k75Var);
        }
    }

    public static void h(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull a75 a75Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, tbPageContext, editorTools, a75Var) == null) {
            editorTools.d(new v75(tbPageContext.getPageActivity(), 1));
            editorTools.setActionListener(14, a75Var);
            editorTools.setActionListener(12, a75Var);
            editorTools.setActionListener(13, a75Var);
            editorTools.setActionListener(15, a75Var);
            editorTools.setActionListener(48, a75Var);
            editorTools.setActionListener(46, a75Var);
            editorTools.setActionListener(49, a75Var);
            editorTools.setActionListener(47, a75Var);
        }
    }

    public static void k(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull a75 a75Var) {
        k75 k75Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65546, null, tbPageContext, editorTools, a75Var) == null) && bz8.a()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, tbPageContext.getPageActivity()), k75.class);
            if (runTask != null && (k75Var = (k75) runTask.getData()) != null) {
                k75Var.l = 3;
                editorTools.d(k75Var);
            }
            editorTools.setActionListener(10, a75Var);
            editorTools.setActionListener(11, a75Var);
        }
    }

    public static ad9 m(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, String str, @NonNull a75 a75Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, tbPageContext, editorTools, str, a75Var)) == null) {
            ad9 ad9Var = new ad9(tbPageContext.getPageActivity(), str);
            boolean z = false;
            ad9Var.k(0);
            if (SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1) {
                z = true;
            }
            ad9Var.l(z);
            editorTools.d(ad9Var);
            editorTools.setActionListener(43, a75Var);
            editorTools.setActionListener(55, a75Var);
            editorTools.setActionListener(66, a75Var);
            return ad9Var;
        }
        return (ad9) invokeLLLL.objValue;
    }
}
