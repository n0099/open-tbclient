package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class r2b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull dd5 dd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, tbPageContext, editorTools, dd5Var) == null) {
            editorTools.d(new qd5(tbPageContext.getPageActivity(), 7));
            editorTools.setActionListener(16, dd5Var);
        }
    }

    public static void c(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull dd5 dd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, tbPageContext, editorTools, dd5Var) == null) {
            editorTools.d(new fd5(tbPageContext.getPageActivity(), 10));
            editorTools.setActionListener(59, dd5Var);
        }
    }

    public static void e(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull dd5 dd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, editorTools, dd5Var) == null) {
            editorTools.d(new wd5(tbPageContext.getPageActivity(), 12));
            editorTools.setActionListener(69, dd5Var);
        }
    }

    public static void f(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull dd5 dd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, tbPageContext, editorTools, dd5Var) == null) {
            editorTools.d(new be5(tbPageContext.getPageActivity(), 11));
            editorTools.setActionListener(61, dd5Var);
        }
    }

    public static ce5 g(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull dd5 dd5Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, tbPageContext, editorTools, dd5Var)) == null) {
            ce5 ce5Var = new ce5(tbPageContext.getPageActivity(), 4);
            editorTools.d(ce5Var);
            editorTools.setActionListener(21, dd5Var);
            return ce5Var;
        }
        return (ce5) invokeLLL.objValue;
    }

    public static void j(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull dd5 dd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, tbPageContext, editorTools, dd5Var) == null) {
            editorTools.d(new rf5(tbPageContext.getPageActivity(), 2));
            editorTools.setActionListener(60, dd5Var);
        }
    }

    public static void l(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull dd5 dd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, tbPageContext, editorTools, dd5Var) == null) {
            editorTools.d(new tf5(tbPageContext.getPageActivity(), 8));
            editorTools.setActionListener(22, dd5Var);
        }
    }

    public static void b(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull dd5 dd5Var) {
        CustomResponsedMessage runTask;
        od5 od5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, tbPageContext, editorTools, dd5Var) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, tbPageContext.getPageActivity()), od5.class)) != null && (od5Var = (od5) runTask.getData()) != null) {
            od5Var.o = true;
            od5Var.l = 9;
            editorTools.d(od5Var);
            editorTools.setActionListener(25, dd5Var);
        }
    }

    public static void d(@NonNull EditorTools editorTools, @NonNull dd5 dd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, editorTools, dd5Var) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            editorTools.h(arrayList);
            od5 p = editorTools.p(5);
            if (p != null) {
                p.l = 5;
                p.e(true);
            }
            editorTools.setActionListener(24, dd5Var);
            editorTools.setActionListener(3, dd5Var);
        }
    }

    public static void i(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools) {
        CustomResponsedMessage runTask;
        od5 od5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, tbPageContext, editorTools) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, tbPageContext.getPageActivity()), od5.class)) != null && (od5Var = (od5) runTask.getData()) != null) {
            od5Var.o = true;
            od5Var.l = 10;
            editorTools.d(od5Var);
        }
    }

    public static void h(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull dd5 dd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, tbPageContext, editorTools, dd5Var) == null) {
            editorTools.d(new zd5(tbPageContext.getPageActivity(), 1));
            editorTools.setActionListener(14, dd5Var);
            editorTools.setActionListener(12, dd5Var);
            editorTools.setActionListener(13, dd5Var);
            editorTools.setActionListener(15, dd5Var);
            editorTools.setActionListener(48, dd5Var);
            editorTools.setActionListener(46, dd5Var);
            editorTools.setActionListener(49, dd5Var);
            editorTools.setActionListener(47, dd5Var);
        }
    }

    public static void k(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull dd5 dd5Var) {
        od5 od5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65546, null, tbPageContext, editorTools, dd5Var) == null) && lga.a()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, tbPageContext.getPageActivity()), od5.class);
            if (runTask != null && (od5Var = (od5) runTask.getData()) != null) {
                od5Var.l = 3;
                editorTools.d(od5Var);
            }
            editorTools.setActionListener(10, dd5Var);
            editorTools.setActionListener(11, dd5Var);
        }
    }

    public static pwa m(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, String str, @NonNull dd5 dd5Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, tbPageContext, editorTools, str, dd5Var)) == null) {
            pwa pwaVar = new pwa(tbPageContext.getPageActivity(), str);
            pwaVar.m(0);
            editorTools.d(pwaVar);
            editorTools.setActionListener(43, dd5Var);
            editorTools.setActionListener(55, dd5Var);
            editorTools.setActionListener(66, dd5Var);
            editorTools.setActionListener(77, dd5Var);
            return pwaVar;
        }
        return (pwa) invokeLLLL.objValue;
    }
}
