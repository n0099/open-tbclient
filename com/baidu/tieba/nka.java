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
/* loaded from: classes7.dex */
public class nka {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull zh5 zh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, tbPageContext, editorTools, zh5Var) == null) {
            editorTools.d(new mi5(tbPageContext.getPageActivity(), 7));
            editorTools.setActionListener(16, zh5Var);
        }
    }

    public static void c(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull zh5 zh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, tbPageContext, editorTools, zh5Var) == null) {
            editorTools.d(new bi5(tbPageContext.getPageActivity(), 10));
            editorTools.setActionListener(59, zh5Var);
        }
    }

    public static void e(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull zh5 zh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, editorTools, zh5Var) == null) {
            editorTools.d(new si5(tbPageContext.getPageActivity(), 12));
            editorTools.setActionListener(69, zh5Var);
        }
    }

    public static void f(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull zh5 zh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, tbPageContext, editorTools, zh5Var) == null) {
            editorTools.d(new xi5(tbPageContext.getPageActivity(), 11));
            editorTools.setActionListener(61, zh5Var);
        }
    }

    public static yi5 g(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull zh5 zh5Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, tbPageContext, editorTools, zh5Var)) == null) {
            yi5 yi5Var = new yi5(tbPageContext.getPageActivity(), 4);
            editorTools.d(yi5Var);
            editorTools.setActionListener(21, zh5Var);
            return yi5Var;
        }
        return (yi5) invokeLLL.objValue;
    }

    public static void j(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull zh5 zh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, tbPageContext, editorTools, zh5Var) == null) {
            editorTools.d(new mk5(tbPageContext.getPageActivity(), 2));
            editorTools.setActionListener(60, zh5Var);
        }
    }

    public static void l(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull zh5 zh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, tbPageContext, editorTools, zh5Var) == null) {
            editorTools.d(new ok5(tbPageContext.getPageActivity(), 8));
            editorTools.setActionListener(22, zh5Var);
        }
    }

    public static void b(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull zh5 zh5Var) {
        CustomResponsedMessage runTask;
        ki5 ki5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, tbPageContext, editorTools, zh5Var) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, tbPageContext.getPageActivity()), ki5.class)) != null && (ki5Var = (ki5) runTask.getData()) != null) {
            ki5Var.o = true;
            ki5Var.l = 9;
            editorTools.d(ki5Var);
            editorTools.setActionListener(25, zh5Var);
        }
    }

    public static void d(@NonNull EditorTools editorTools, @NonNull zh5 zh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, editorTools, zh5Var) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            editorTools.h(arrayList);
            ki5 p = editorTools.p(5);
            if (p != null) {
                p.l = 5;
                p.d(true);
            }
            editorTools.setActionListener(24, zh5Var);
            editorTools.setActionListener(3, zh5Var);
        }
    }

    public static void i(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools) {
        CustomResponsedMessage runTask;
        ki5 ki5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, tbPageContext, editorTools) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, tbPageContext.getPageActivity()), ki5.class)) != null && (ki5Var = (ki5) runTask.getData()) != null) {
            ki5Var.o = true;
            ki5Var.l = 10;
            editorTools.d(ki5Var);
        }
    }

    public static void h(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull zh5 zh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, tbPageContext, editorTools, zh5Var) == null) {
            editorTools.d(new vi5(tbPageContext.getPageActivity(), 1));
            editorTools.setActionListener(14, zh5Var);
            editorTools.setActionListener(12, zh5Var);
            editorTools.setActionListener(13, zh5Var);
            editorTools.setActionListener(15, zh5Var);
            editorTools.setActionListener(48, zh5Var);
            editorTools.setActionListener(46, zh5Var);
            editorTools.setActionListener(49, zh5Var);
            editorTools.setActionListener(47, zh5Var);
        }
    }

    public static void k(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull zh5 zh5Var) {
        ki5 ki5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65546, null, tbPageContext, editorTools, zh5Var) == null) && v1a.a()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, tbPageContext.getPageActivity()), ki5.class);
            if (runTask != null && (ki5Var = (ki5) runTask.getData()) != null) {
                ki5Var.l = 3;
                editorTools.d(ki5Var);
            }
            editorTools.setActionListener(10, zh5Var);
            editorTools.setActionListener(11, zh5Var);
        }
    }

    public static sga m(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, String str, @NonNull zh5 zh5Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, tbPageContext, editorTools, str, zh5Var)) == null) {
            sga sgaVar = new sga(tbPageContext.getPageActivity(), str);
            boolean z = false;
            sgaVar.k(0);
            if (SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1) {
                z = true;
            }
            sgaVar.l(z);
            editorTools.d(sgaVar);
            editorTools.setActionListener(43, zh5Var);
            editorTools.setActionListener(55, zh5Var);
            editorTools.setActionListener(66, zh5Var);
            editorTools.setActionListener(77, zh5Var);
            return sgaVar;
        }
        return (sga) invokeLLLL.objValue;
    }
}
