package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ng9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull a75 a75Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, tbPageContext, editorTools, a75Var, str) == null) {
            if ("e1".equals(str)) {
                vg9.h(tbPageContext, editorTools, a75Var);
            } else if (Config.SESSTION_TRACK_END_TIME.equals(str)) {
                vg9.j(tbPageContext, editorTools, a75Var);
            } else if ("e3".equals(str)) {
                vg9.k(tbPageContext, editorTools, a75Var);
            } else if ("e4".equals(str)) {
                vg9.g(tbPageContext, editorTools, a75Var);
            } else if ("e5".equals(str)) {
                vg9.d(editorTools, a75Var);
            } else if ("e6".equals(str)) {
                vg9.a(tbPageContext, editorTools, a75Var);
            } else if ("e7".equals(str)) {
                vg9.l(tbPageContext, editorTools, a75Var);
            } else if ("e8".equals(str)) {
                vg9.b(tbPageContext, editorTools, a75Var);
            } else if ("e9".equals(str)) {
                vg9.i(tbPageContext, editorTools);
            } else if ("e10".equals(str)) {
                vg9.c(tbPageContext, editorTools, a75Var);
            } else if ("e11".equals(str)) {
                vg9.f(tbPageContext, editorTools, a75Var);
            } else if ("e12".equals(str)) {
                vg9.e(tbPageContext, editorTools, a75Var);
            }
        }
    }
}
