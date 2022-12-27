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
public class nb9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull n65 n65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, tbPageContext, editorTools, n65Var) == null) {
            editorTools.d(new z65(tbPageContext.getPageActivity(), 7));
            editorTools.setActionListener(16, n65Var);
        }
    }

    public static void c(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull n65 n65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, tbPageContext, editorTools, n65Var) == null) {
            editorTools.d(new p65(tbPageContext.getPageActivity(), 10));
            editorTools.setActionListener(59, n65Var);
        }
    }

    public static void e(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull n65 n65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, editorTools, n65Var) == null) {
            editorTools.d(new f75(tbPageContext.getPageActivity(), 12));
            editorTools.setActionListener(69, n65Var);
        }
    }

    public static void f(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull n65 n65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, tbPageContext, editorTools, n65Var) == null) {
            editorTools.d(new k75(tbPageContext.getPageActivity(), 11));
            editorTools.setActionListener(61, n65Var);
        }
    }

    public static l75 g(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull n65 n65Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, tbPageContext, editorTools, n65Var)) == null) {
            l75 l75Var = new l75(tbPageContext.getPageActivity(), 4);
            editorTools.d(l75Var);
            editorTools.setActionListener(21, n65Var);
            return l75Var;
        }
        return (l75) invokeLLL.objValue;
    }

    public static void j(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull n65 n65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, tbPageContext, editorTools, n65Var) == null) {
            editorTools.d(new x85(tbPageContext.getPageActivity(), 2));
            editorTools.setActionListener(60, n65Var);
        }
    }

    public static void l(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull n65 n65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, tbPageContext, editorTools, n65Var) == null) {
            editorTools.d(new z85(tbPageContext.getPageActivity(), 8));
            editorTools.setActionListener(22, n65Var);
        }
    }

    public static void b(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull n65 n65Var) {
        CustomResponsedMessage runTask;
        x65 x65Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, tbPageContext, editorTools, n65Var) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, tbPageContext.getPageActivity()), x65.class)) != null && (x65Var = (x65) runTask.getData()) != null) {
            x65Var.o = true;
            x65Var.l = 9;
            editorTools.d(x65Var);
            editorTools.setActionListener(25, n65Var);
        }
    }

    public static void d(@NonNull EditorTools editorTools, @NonNull n65 n65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, editorTools, n65Var) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            editorTools.h(arrayList);
            x65 o = editorTools.o(5);
            if (o != null) {
                o.l = 5;
                o.d(true);
            }
            editorTools.setActionListener(24, n65Var);
            editorTools.setActionListener(3, n65Var);
        }
    }

    public static void i(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools) {
        CustomResponsedMessage runTask;
        x65 x65Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, tbPageContext, editorTools) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, tbPageContext.getPageActivity()), x65.class)) != null && (x65Var = (x65) runTask.getData()) != null) {
            x65Var.o = true;
            x65Var.l = 10;
            editorTools.d(x65Var);
        }
    }

    public static void h(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull n65 n65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, tbPageContext, editorTools, n65Var) == null) {
            editorTools.d(new i75(tbPageContext.getPageActivity(), 1));
            editorTools.setActionListener(14, n65Var);
            editorTools.setActionListener(12, n65Var);
            editorTools.setActionListener(13, n65Var);
            editorTools.setActionListener(15, n65Var);
            editorTools.setActionListener(48, n65Var);
            editorTools.setActionListener(46, n65Var);
            editorTools.setActionListener(49, n65Var);
            editorTools.setActionListener(47, n65Var);
        }
    }

    public static void k(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull n65 n65Var) {
        x65 x65Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65546, null, tbPageContext, editorTools, n65Var) == null) && fu8.a()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, tbPageContext.getPageActivity()), x65.class);
            if (runTask != null && (x65Var = (x65) runTask.getData()) != null) {
                x65Var.l = 3;
                editorTools.d(x65Var);
            }
            editorTools.setActionListener(10, n65Var);
            editorTools.setActionListener(11, n65Var);
        }
    }

    public static y79 m(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, String str, @NonNull n65 n65Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, tbPageContext, editorTools, str, n65Var)) == null) {
            y79 y79Var = new y79(tbPageContext.getPageActivity(), str);
            boolean z = false;
            y79Var.k(0);
            if (SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1) {
                z = true;
            }
            y79Var.l(z);
            editorTools.d(y79Var);
            editorTools.setActionListener(43, n65Var);
            editorTools.setActionListener(55, n65Var);
            editorTools.setActionListener(66, n65Var);
            return y79Var;
        }
        return (y79) invokeLLLL.objValue;
    }
}
