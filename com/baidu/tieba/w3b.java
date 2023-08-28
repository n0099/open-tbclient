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
/* loaded from: classes8.dex */
public class w3b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull ai5 ai5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, tbPageContext, editorTools, ai5Var) == null) {
            editorTools.d(new ni5(tbPageContext.getPageActivity(), 7));
            editorTools.setActionListener(16, ai5Var);
        }
    }

    public static void c(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull ai5 ai5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, tbPageContext, editorTools, ai5Var) == null) {
            editorTools.d(new ci5(tbPageContext.getPageActivity(), 10));
            editorTools.setActionListener(59, ai5Var);
        }
    }

    public static void e(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull ai5 ai5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, editorTools, ai5Var) == null) {
            editorTools.d(new ti5(tbPageContext.getPageActivity(), 12));
            editorTools.setActionListener(69, ai5Var);
        }
    }

    public static void f(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull ai5 ai5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, tbPageContext, editorTools, ai5Var) == null) {
            editorTools.d(new yi5(tbPageContext.getPageActivity(), 11));
            editorTools.setActionListener(61, ai5Var);
        }
    }

    public static zi5 g(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull ai5 ai5Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, tbPageContext, editorTools, ai5Var)) == null) {
            zi5 zi5Var = new zi5(tbPageContext.getPageActivity(), 4);
            editorTools.d(zi5Var);
            editorTools.setActionListener(21, ai5Var);
            return zi5Var;
        }
        return (zi5) invokeLLL.objValue;
    }

    public static void j(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull ai5 ai5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, tbPageContext, editorTools, ai5Var) == null) {
            editorTools.d(new ok5(tbPageContext.getPageActivity(), 2));
            editorTools.setActionListener(60, ai5Var);
        }
    }

    public static void l(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull ai5 ai5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, tbPageContext, editorTools, ai5Var) == null) {
            editorTools.d(new qk5(tbPageContext.getPageActivity(), 8));
            editorTools.setActionListener(22, ai5Var);
        }
    }

    public static void b(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull ai5 ai5Var) {
        CustomResponsedMessage runTask;
        li5 li5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, tbPageContext, editorTools, ai5Var) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, tbPageContext.getPageActivity()), li5.class)) != null && (li5Var = (li5) runTask.getData()) != null) {
            li5Var.o = true;
            li5Var.l = 9;
            editorTools.d(li5Var);
            editorTools.setActionListener(25, ai5Var);
        }
    }

    public static void d(@NonNull EditorTools editorTools, @NonNull ai5 ai5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, editorTools, ai5Var) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            editorTools.h(arrayList);
            li5 p = editorTools.p(5);
            if (p != null) {
                p.l = 5;
                p.d(true);
            }
            editorTools.setActionListener(24, ai5Var);
            editorTools.setActionListener(3, ai5Var);
        }
    }

    public static void i(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools) {
        CustomResponsedMessage runTask;
        li5 li5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, tbPageContext, editorTools) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, tbPageContext.getPageActivity()), li5.class)) != null && (li5Var = (li5) runTask.getData()) != null) {
            li5Var.o = true;
            li5Var.l = 10;
            editorTools.d(li5Var);
        }
    }

    public static void h(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull ai5 ai5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, tbPageContext, editorTools, ai5Var) == null) {
            editorTools.d(new wi5(tbPageContext.getPageActivity(), 1));
            editorTools.setActionListener(14, ai5Var);
            editorTools.setActionListener(12, ai5Var);
            editorTools.setActionListener(13, ai5Var);
            editorTools.setActionListener(15, ai5Var);
            editorTools.setActionListener(48, ai5Var);
            editorTools.setActionListener(46, ai5Var);
            editorTools.setActionListener(49, ai5Var);
            editorTools.setActionListener(47, ai5Var);
        }
    }

    public static void k(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull ai5 ai5Var) {
        li5 li5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65546, null, tbPageContext, editorTools, ai5Var) == null) && vha.a()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, tbPageContext.getPageActivity()), li5.class);
            if (runTask != null && (li5Var = (li5) runTask.getData()) != null) {
                li5Var.l = 3;
                editorTools.d(li5Var);
            }
            editorTools.setActionListener(10, ai5Var);
            editorTools.setActionListener(11, ai5Var);
        }
    }

    public static xxa m(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, String str, @NonNull ai5 ai5Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, tbPageContext, editorTools, str, ai5Var)) == null) {
            xxa xxaVar = new xxa(tbPageContext.getPageActivity(), str);
            boolean z = false;
            xxaVar.l(0);
            if (SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1) {
                z = true;
            }
            xxaVar.m(z);
            editorTools.d(xxaVar);
            editorTools.setActionListener(43, ai5Var);
            editorTools.setActionListener(55, ai5Var);
            editorTools.setActionListener(66, ai5Var);
            editorTools.setActionListener(77, ai5Var);
            return xxaVar;
        }
        return (xxa) invokeLLLL.objValue;
    }
}
