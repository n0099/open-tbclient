package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jia {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull th5 th5Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, tbPageContext, editorTools, th5Var, str) == null) {
            if ("e1".equals(str)) {
                ria.h(tbPageContext, editorTools, th5Var);
            } else if (Config.SESSTION_TRACK_END_TIME.equals(str)) {
                ria.j(tbPageContext, editorTools, th5Var);
            } else if ("e3".equals(str)) {
                ria.k(tbPageContext, editorTools, th5Var);
            } else if ("e4".equals(str)) {
                ria.g(tbPageContext, editorTools, th5Var);
            } else if ("e5".equals(str)) {
                ria.d(editorTools, th5Var);
            } else if ("e6".equals(str)) {
                ria.a(tbPageContext, editorTools, th5Var);
            } else if ("e7".equals(str)) {
                ria.l(tbPageContext, editorTools, th5Var);
            } else if ("e8".equals(str)) {
                ria.b(tbPageContext, editorTools, th5Var);
            } else if ("e9".equals(str)) {
                ria.i(tbPageContext, editorTools);
            } else if ("e10".equals(str)) {
                ria.c(tbPageContext, editorTools, th5Var);
            } else if ("e11".equals(str)) {
                ria.f(tbPageContext, editorTools, th5Var);
            } else if ("e12".equals(str)) {
                ria.e(tbPageContext, editorTools, th5Var);
            }
        }
    }
}
