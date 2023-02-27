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
public class vp9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull zc5 zc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, tbPageContext, editorTools, zc5Var) == null) {
            editorTools.d(new ld5(tbPageContext.getPageActivity(), 7));
            editorTools.setActionListener(16, zc5Var);
        }
    }

    public static void c(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull zc5 zc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, tbPageContext, editorTools, zc5Var) == null) {
            editorTools.d(new bd5(tbPageContext.getPageActivity(), 10));
            editorTools.setActionListener(59, zc5Var);
        }
    }

    public static void e(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull zc5 zc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, editorTools, zc5Var) == null) {
            editorTools.d(new rd5(tbPageContext.getPageActivity(), 12));
            editorTools.setActionListener(69, zc5Var);
        }
    }

    public static void f(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull zc5 zc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, tbPageContext, editorTools, zc5Var) == null) {
            editorTools.d(new wd5(tbPageContext.getPageActivity(), 11));
            editorTools.setActionListener(61, zc5Var);
        }
    }

    public static xd5 g(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull zc5 zc5Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, tbPageContext, editorTools, zc5Var)) == null) {
            xd5 xd5Var = new xd5(tbPageContext.getPageActivity(), 4);
            editorTools.d(xd5Var);
            editorTools.setActionListener(21, zc5Var);
            return xd5Var;
        }
        return (xd5) invokeLLL.objValue;
    }

    public static void j(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull zc5 zc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, tbPageContext, editorTools, zc5Var) == null) {
            editorTools.d(new kf5(tbPageContext.getPageActivity(), 2));
            editorTools.setActionListener(60, zc5Var);
        }
    }

    public static void l(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull zc5 zc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, tbPageContext, editorTools, zc5Var) == null) {
            editorTools.d(new mf5(tbPageContext.getPageActivity(), 8));
            editorTools.setActionListener(22, zc5Var);
        }
    }

    public static void b(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull zc5 zc5Var) {
        CustomResponsedMessage runTask;
        jd5 jd5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, tbPageContext, editorTools, zc5Var) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, tbPageContext.getPageActivity()), jd5.class)) != null && (jd5Var = (jd5) runTask.getData()) != null) {
            jd5Var.o = true;
            jd5Var.l = 9;
            editorTools.d(jd5Var);
            editorTools.setActionListener(25, zc5Var);
        }
    }

    public static void d(@NonNull EditorTools editorTools, @NonNull zc5 zc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, editorTools, zc5Var) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            editorTools.h(arrayList);
            jd5 p = editorTools.p(5);
            if (p != null) {
                p.l = 5;
                p.d(true);
            }
            editorTools.setActionListener(24, zc5Var);
            editorTools.setActionListener(3, zc5Var);
        }
    }

    public static void i(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools) {
        CustomResponsedMessage runTask;
        jd5 jd5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, tbPageContext, editorTools) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, tbPageContext.getPageActivity()), jd5.class)) != null && (jd5Var = (jd5) runTask.getData()) != null) {
            jd5Var.o = true;
            jd5Var.l = 10;
            editorTools.d(jd5Var);
        }
    }

    public static void h(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull zc5 zc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, tbPageContext, editorTools, zc5Var) == null) {
            editorTools.d(new ud5(tbPageContext.getPageActivity(), 1));
            editorTools.setActionListener(14, zc5Var);
            editorTools.setActionListener(12, zc5Var);
            editorTools.setActionListener(13, zc5Var);
            editorTools.setActionListener(15, zc5Var);
            editorTools.setActionListener(48, zc5Var);
            editorTools.setActionListener(46, zc5Var);
            editorTools.setActionListener(49, zc5Var);
            editorTools.setActionListener(47, zc5Var);
        }
    }

    public static void k(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull zc5 zc5Var) {
        jd5 jd5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65546, null, tbPageContext, editorTools, zc5Var) == null) && p79.a()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, tbPageContext.getPageActivity()), jd5.class);
            if (runTask != null && (jd5Var = (jd5) runTask.getData()) != null) {
                jd5Var.l = 3;
                editorTools.d(jd5Var);
            }
            editorTools.setActionListener(10, zc5Var);
            editorTools.setActionListener(11, zc5Var);
        }
    }

    public static am9 m(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, String str, @NonNull zc5 zc5Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, tbPageContext, editorTools, str, zc5Var)) == null) {
            am9 am9Var = new am9(tbPageContext.getPageActivity(), str);
            boolean z = false;
            am9Var.k(0);
            if (SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1) {
                z = true;
            }
            am9Var.l(z);
            editorTools.d(am9Var);
            editorTools.setActionListener(43, zc5Var);
            editorTools.setActionListener(55, zc5Var);
            editorTools.setActionListener(66, zc5Var);
            return am9Var;
        }
        return (am9) invokeLLLL.objValue;
    }
}
