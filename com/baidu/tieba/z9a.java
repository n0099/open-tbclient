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
public class z9a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull kd5 kd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, tbPageContext, editorTools, kd5Var) == null) {
            editorTools.d(new wd5(tbPageContext.getPageActivity(), 7));
            editorTools.setActionListener(16, kd5Var);
        }
    }

    public static void c(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull kd5 kd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, tbPageContext, editorTools, kd5Var) == null) {
            editorTools.d(new md5(tbPageContext.getPageActivity(), 10));
            editorTools.setActionListener(59, kd5Var);
        }
    }

    public static void e(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull kd5 kd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, editorTools, kd5Var) == null) {
            editorTools.d(new ce5(tbPageContext.getPageActivity(), 12));
            editorTools.setActionListener(69, kd5Var);
        }
    }

    public static void f(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull kd5 kd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, tbPageContext, editorTools, kd5Var) == null) {
            editorTools.d(new he5(tbPageContext.getPageActivity(), 11));
            editorTools.setActionListener(61, kd5Var);
        }
    }

    public static ie5 g(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull kd5 kd5Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, tbPageContext, editorTools, kd5Var)) == null) {
            ie5 ie5Var = new ie5(tbPageContext.getPageActivity(), 4);
            editorTools.d(ie5Var);
            editorTools.setActionListener(21, kd5Var);
            return ie5Var;
        }
        return (ie5) invokeLLL.objValue;
    }

    public static void j(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull kd5 kd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, tbPageContext, editorTools, kd5Var) == null) {
            editorTools.d(new vf5(tbPageContext.getPageActivity(), 2));
            editorTools.setActionListener(60, kd5Var);
        }
    }

    public static void l(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull kd5 kd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, tbPageContext, editorTools, kd5Var) == null) {
            editorTools.d(new xf5(tbPageContext.getPageActivity(), 8));
            editorTools.setActionListener(22, kd5Var);
        }
    }

    public static void b(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull kd5 kd5Var) {
        CustomResponsedMessage runTask;
        ud5 ud5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, tbPageContext, editorTools, kd5Var) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, tbPageContext.getPageActivity()), ud5.class)) != null && (ud5Var = (ud5) runTask.getData()) != null) {
            ud5Var.o = true;
            ud5Var.l = 9;
            editorTools.d(ud5Var);
            editorTools.setActionListener(25, kd5Var);
        }
    }

    public static void d(@NonNull EditorTools editorTools, @NonNull kd5 kd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, editorTools, kd5Var) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            editorTools.h(arrayList);
            ud5 p = editorTools.p(5);
            if (p != null) {
                p.l = 5;
                p.d(true);
            }
            editorTools.setActionListener(24, kd5Var);
            editorTools.setActionListener(3, kd5Var);
        }
    }

    public static void i(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools) {
        CustomResponsedMessage runTask;
        ud5 ud5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, tbPageContext, editorTools) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, tbPageContext.getPageActivity()), ud5.class)) != null && (ud5Var = (ud5) runTask.getData()) != null) {
            ud5Var.o = true;
            ud5Var.l = 10;
            editorTools.d(ud5Var);
        }
    }

    public static void h(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull kd5 kd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, tbPageContext, editorTools, kd5Var) == null) {
            editorTools.d(new fe5(tbPageContext.getPageActivity(), 1));
            editorTools.setActionListener(14, kd5Var);
            editorTools.setActionListener(12, kd5Var);
            editorTools.setActionListener(13, kd5Var);
            editorTools.setActionListener(15, kd5Var);
            editorTools.setActionListener(48, kd5Var);
            editorTools.setActionListener(46, kd5Var);
            editorTools.setActionListener(49, kd5Var);
            editorTools.setActionListener(47, kd5Var);
        }
    }

    public static void k(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull kd5 kd5Var) {
        ud5 ud5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65546, null, tbPageContext, editorTools, kd5Var) == null) && jr9.a()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, tbPageContext.getPageActivity()), ud5.class);
            if (runTask != null && (ud5Var = (ud5) runTask.getData()) != null) {
                ud5Var.l = 3;
                editorTools.d(ud5Var);
            }
            editorTools.setActionListener(10, kd5Var);
            editorTools.setActionListener(11, kd5Var);
        }
    }

    public static e6a m(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, String str, @NonNull kd5 kd5Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, tbPageContext, editorTools, str, kd5Var)) == null) {
            e6a e6aVar = new e6a(tbPageContext.getPageActivity(), str);
            boolean z = false;
            e6aVar.k(0);
            if (SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1) {
                z = true;
            }
            e6aVar.l(z);
            editorTools.d(e6aVar);
            editorTools.setActionListener(43, kd5Var);
            editorTools.setActionListener(55, kd5Var);
            editorTools.setActionListener(66, kd5Var);
            return e6aVar;
        }
        return (e6a) invokeLLLL.objValue;
    }
}
