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
public class ria {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull th5 th5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, tbPageContext, editorTools, th5Var) == null) {
            editorTools.d(new gi5(tbPageContext.getPageActivity(), 7));
            editorTools.setActionListener(16, th5Var);
        }
    }

    public static void c(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull th5 th5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, tbPageContext, editorTools, th5Var) == null) {
            editorTools.d(new vh5(tbPageContext.getPageActivity(), 10));
            editorTools.setActionListener(59, th5Var);
        }
    }

    public static void e(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull th5 th5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, editorTools, th5Var) == null) {
            editorTools.d(new mi5(tbPageContext.getPageActivity(), 12));
            editorTools.setActionListener(69, th5Var);
        }
    }

    public static void f(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull th5 th5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, tbPageContext, editorTools, th5Var) == null) {
            editorTools.d(new ri5(tbPageContext.getPageActivity(), 11));
            editorTools.setActionListener(61, th5Var);
        }
    }

    public static si5 g(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull th5 th5Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, tbPageContext, editorTools, th5Var)) == null) {
            si5 si5Var = new si5(tbPageContext.getPageActivity(), 4);
            editorTools.d(si5Var);
            editorTools.setActionListener(21, th5Var);
            return si5Var;
        }
        return (si5) invokeLLL.objValue;
    }

    public static void j(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull th5 th5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, tbPageContext, editorTools, th5Var) == null) {
            editorTools.d(new gk5(tbPageContext.getPageActivity(), 2));
            editorTools.setActionListener(60, th5Var);
        }
    }

    public static void l(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull th5 th5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, tbPageContext, editorTools, th5Var) == null) {
            editorTools.d(new ik5(tbPageContext.getPageActivity(), 8));
            editorTools.setActionListener(22, th5Var);
        }
    }

    public static void b(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull th5 th5Var) {
        CustomResponsedMessage runTask;
        ei5 ei5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, tbPageContext, editorTools, th5Var) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, tbPageContext.getPageActivity()), ei5.class)) != null && (ei5Var = (ei5) runTask.getData()) != null) {
            ei5Var.o = true;
            ei5Var.l = 9;
            editorTools.d(ei5Var);
            editorTools.setActionListener(25, th5Var);
        }
    }

    public static void d(@NonNull EditorTools editorTools, @NonNull th5 th5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, editorTools, th5Var) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            editorTools.h(arrayList);
            ei5 p = editorTools.p(5);
            if (p != null) {
                p.l = 5;
                p.d(true);
            }
            editorTools.setActionListener(24, th5Var);
            editorTools.setActionListener(3, th5Var);
        }
    }

    public static void i(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools) {
        CustomResponsedMessage runTask;
        ei5 ei5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, tbPageContext, editorTools) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, tbPageContext.getPageActivity()), ei5.class)) != null && (ei5Var = (ei5) runTask.getData()) != null) {
            ei5Var.o = true;
            ei5Var.l = 10;
            editorTools.d(ei5Var);
        }
    }

    public static void h(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull th5 th5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, tbPageContext, editorTools, th5Var) == null) {
            editorTools.d(new pi5(tbPageContext.getPageActivity(), 1));
            editorTools.setActionListener(14, th5Var);
            editorTools.setActionListener(12, th5Var);
            editorTools.setActionListener(13, th5Var);
            editorTools.setActionListener(15, th5Var);
            editorTools.setActionListener(48, th5Var);
            editorTools.setActionListener(46, th5Var);
            editorTools.setActionListener(49, th5Var);
            editorTools.setActionListener(47, th5Var);
        }
    }

    public static void k(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull th5 th5Var) {
        ei5 ei5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65546, null, tbPageContext, editorTools, th5Var) == null) && yz9.a()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, tbPageContext.getPageActivity()), ei5.class);
            if (runTask != null && (ei5Var = (ei5) runTask.getData()) != null) {
                ei5Var.l = 3;
                editorTools.d(ei5Var);
            }
            editorTools.setActionListener(10, th5Var);
            editorTools.setActionListener(11, th5Var);
        }
    }

    public static wea m(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, String str, @NonNull th5 th5Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, tbPageContext, editorTools, str, th5Var)) == null) {
            wea weaVar = new wea(tbPageContext.getPageActivity(), str);
            boolean z = false;
            weaVar.k(0);
            if (SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1) {
                z = true;
            }
            weaVar.l(z);
            editorTools.d(weaVar);
            editorTools.setActionListener(43, th5Var);
            editorTools.setActionListener(55, th5Var);
            editorTools.setActionListener(66, th5Var);
            editorTools.setActionListener(77, th5Var);
            return weaVar;
        }
        return (wea) invokeLLLL.objValue;
    }
}
