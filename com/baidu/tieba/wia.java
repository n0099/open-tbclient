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
public class wia {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull vh5 vh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, tbPageContext, editorTools, vh5Var) == null) {
            editorTools.d(new ii5(tbPageContext.getPageActivity(), 7));
            editorTools.setActionListener(16, vh5Var);
        }
    }

    public static void c(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull vh5 vh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, tbPageContext, editorTools, vh5Var) == null) {
            editorTools.d(new xh5(tbPageContext.getPageActivity(), 10));
            editorTools.setActionListener(59, vh5Var);
        }
    }

    public static void e(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull vh5 vh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, editorTools, vh5Var) == null) {
            editorTools.d(new oi5(tbPageContext.getPageActivity(), 12));
            editorTools.setActionListener(69, vh5Var);
        }
    }

    public static void f(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull vh5 vh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, tbPageContext, editorTools, vh5Var) == null) {
            editorTools.d(new ti5(tbPageContext.getPageActivity(), 11));
            editorTools.setActionListener(61, vh5Var);
        }
    }

    public static ui5 g(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull vh5 vh5Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, tbPageContext, editorTools, vh5Var)) == null) {
            ui5 ui5Var = new ui5(tbPageContext.getPageActivity(), 4);
            editorTools.d(ui5Var);
            editorTools.setActionListener(21, vh5Var);
            return ui5Var;
        }
        return (ui5) invokeLLL.objValue;
    }

    public static void j(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull vh5 vh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, tbPageContext, editorTools, vh5Var) == null) {
            editorTools.d(new ik5(tbPageContext.getPageActivity(), 2));
            editorTools.setActionListener(60, vh5Var);
        }
    }

    public static void l(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull vh5 vh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, tbPageContext, editorTools, vh5Var) == null) {
            editorTools.d(new kk5(tbPageContext.getPageActivity(), 8));
            editorTools.setActionListener(22, vh5Var);
        }
    }

    public static void b(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull vh5 vh5Var) {
        CustomResponsedMessage runTask;
        gi5 gi5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, tbPageContext, editorTools, vh5Var) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, tbPageContext.getPageActivity()), gi5.class)) != null && (gi5Var = (gi5) runTask.getData()) != null) {
            gi5Var.o = true;
            gi5Var.l = 9;
            editorTools.d(gi5Var);
            editorTools.setActionListener(25, vh5Var);
        }
    }

    public static void d(@NonNull EditorTools editorTools, @NonNull vh5 vh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, editorTools, vh5Var) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            editorTools.h(arrayList);
            gi5 p = editorTools.p(5);
            if (p != null) {
                p.l = 5;
                p.d(true);
            }
            editorTools.setActionListener(24, vh5Var);
            editorTools.setActionListener(3, vh5Var);
        }
    }

    public static void i(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools) {
        CustomResponsedMessage runTask;
        gi5 gi5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, tbPageContext, editorTools) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, tbPageContext.getPageActivity()), gi5.class)) != null && (gi5Var = (gi5) runTask.getData()) != null) {
            gi5Var.o = true;
            gi5Var.l = 10;
            editorTools.d(gi5Var);
        }
    }

    public static void h(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull vh5 vh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, tbPageContext, editorTools, vh5Var) == null) {
            editorTools.d(new ri5(tbPageContext.getPageActivity(), 1));
            editorTools.setActionListener(14, vh5Var);
            editorTools.setActionListener(12, vh5Var);
            editorTools.setActionListener(13, vh5Var);
            editorTools.setActionListener(15, vh5Var);
            editorTools.setActionListener(48, vh5Var);
            editorTools.setActionListener(46, vh5Var);
            editorTools.setActionListener(49, vh5Var);
            editorTools.setActionListener(47, vh5Var);
        }
    }

    public static void k(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull vh5 vh5Var) {
        gi5 gi5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65546, null, tbPageContext, editorTools, vh5Var) == null) && d0a.a()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, tbPageContext.getPageActivity()), gi5.class);
            if (runTask != null && (gi5Var = (gi5) runTask.getData()) != null) {
                gi5Var.l = 3;
                editorTools.d(gi5Var);
            }
            editorTools.setActionListener(10, vh5Var);
            editorTools.setActionListener(11, vh5Var);
        }
    }

    public static bfa m(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, String str, @NonNull vh5 vh5Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, tbPageContext, editorTools, str, vh5Var)) == null) {
            bfa bfaVar = new bfa(tbPageContext.getPageActivity(), str);
            boolean z = false;
            bfaVar.k(0);
            if (SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1) {
                z = true;
            }
            bfaVar.l(z);
            editorTools.d(bfaVar);
            editorTools.setActionListener(43, vh5Var);
            editorTools.setActionListener(55, vh5Var);
            editorTools.setActionListener(66, vh5Var);
            editorTools.setActionListener(77, vh5Var);
            return bfaVar;
        }
        return (bfa) invokeLLLL.objValue;
    }
}
