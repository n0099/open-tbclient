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
public class v5a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull qc5 qc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, tbPageContext, editorTools, qc5Var) == null) {
            editorTools.d(new cd5(tbPageContext.getPageActivity(), 7));
            editorTools.setActionListener(16, qc5Var);
        }
    }

    public static void c(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull qc5 qc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, tbPageContext, editorTools, qc5Var) == null) {
            editorTools.d(new sc5(tbPageContext.getPageActivity(), 10));
            editorTools.setActionListener(59, qc5Var);
        }
    }

    public static void e(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull qc5 qc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, editorTools, qc5Var) == null) {
            editorTools.d(new id5(tbPageContext.getPageActivity(), 12));
            editorTools.setActionListener(69, qc5Var);
        }
    }

    public static void f(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull qc5 qc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, tbPageContext, editorTools, qc5Var) == null) {
            editorTools.d(new nd5(tbPageContext.getPageActivity(), 11));
            editorTools.setActionListener(61, qc5Var);
        }
    }

    public static od5 g(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull qc5 qc5Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, tbPageContext, editorTools, qc5Var)) == null) {
            od5 od5Var = new od5(tbPageContext.getPageActivity(), 4);
            editorTools.d(od5Var);
            editorTools.setActionListener(21, qc5Var);
            return od5Var;
        }
        return (od5) invokeLLL.objValue;
    }

    public static void j(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull qc5 qc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, tbPageContext, editorTools, qc5Var) == null) {
            editorTools.d(new bf5(tbPageContext.getPageActivity(), 2));
            editorTools.setActionListener(60, qc5Var);
        }
    }

    public static void l(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull qc5 qc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, tbPageContext, editorTools, qc5Var) == null) {
            editorTools.d(new df5(tbPageContext.getPageActivity(), 8));
            editorTools.setActionListener(22, qc5Var);
        }
    }

    public static void b(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull qc5 qc5Var) {
        CustomResponsedMessage runTask;
        ad5 ad5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, tbPageContext, editorTools, qc5Var) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, tbPageContext.getPageActivity()), ad5.class)) != null && (ad5Var = (ad5) runTask.getData()) != null) {
            ad5Var.o = true;
            ad5Var.l = 9;
            editorTools.d(ad5Var);
            editorTools.setActionListener(25, qc5Var);
        }
    }

    public static void d(@NonNull EditorTools editorTools, @NonNull qc5 qc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, editorTools, qc5Var) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            editorTools.h(arrayList);
            ad5 p = editorTools.p(5);
            if (p != null) {
                p.l = 5;
                p.d(true);
            }
            editorTools.setActionListener(24, qc5Var);
            editorTools.setActionListener(3, qc5Var);
        }
    }

    public static void i(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools) {
        CustomResponsedMessage runTask;
        ad5 ad5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, tbPageContext, editorTools) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, tbPageContext.getPageActivity()), ad5.class)) != null && (ad5Var = (ad5) runTask.getData()) != null) {
            ad5Var.o = true;
            ad5Var.l = 10;
            editorTools.d(ad5Var);
        }
    }

    public static void h(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull qc5 qc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, tbPageContext, editorTools, qc5Var) == null) {
            editorTools.d(new ld5(tbPageContext.getPageActivity(), 1));
            editorTools.setActionListener(14, qc5Var);
            editorTools.setActionListener(12, qc5Var);
            editorTools.setActionListener(13, qc5Var);
            editorTools.setActionListener(15, qc5Var);
            editorTools.setActionListener(48, qc5Var);
            editorTools.setActionListener(46, qc5Var);
            editorTools.setActionListener(49, qc5Var);
            editorTools.setActionListener(47, qc5Var);
        }
    }

    public static void k(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull qc5 qc5Var) {
        ad5 ad5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65546, null, tbPageContext, editorTools, qc5Var) == null) && mn9.a()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, tbPageContext.getPageActivity()), ad5.class);
            if (runTask != null && (ad5Var = (ad5) runTask.getData()) != null) {
                ad5Var.l = 3;
                editorTools.d(ad5Var);
            }
            editorTools.setActionListener(10, qc5Var);
            editorTools.setActionListener(11, qc5Var);
        }
    }

    public static a2a m(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, String str, @NonNull qc5 qc5Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, tbPageContext, editorTools, str, qc5Var)) == null) {
            a2a a2aVar = new a2a(tbPageContext.getPageActivity(), str);
            boolean z = false;
            a2aVar.k(0);
            if (SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1) {
                z = true;
            }
            a2aVar.l(z);
            editorTools.d(a2aVar);
            editorTools.setActionListener(43, qc5Var);
            editorTools.setActionListener(55, qc5Var);
            editorTools.setActionListener(66, qc5Var);
            return a2aVar;
        }
        return (a2a) invokeLLLL.objValue;
    }
}
