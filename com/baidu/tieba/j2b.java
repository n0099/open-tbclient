package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class j2b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull dd5 dd5Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, tbPageContext, editorTools, dd5Var, str) == null) {
            if ("e1".equals(str)) {
                r2b.h(tbPageContext, editorTools, dd5Var);
            } else if (Config.SESSTION_TRACK_END_TIME.equals(str)) {
                r2b.j(tbPageContext, editorTools, dd5Var);
            } else if ("e3".equals(str)) {
                r2b.k(tbPageContext, editorTools, dd5Var);
            } else if ("e4".equals(str)) {
                r2b.g(tbPageContext, editorTools, dd5Var);
            } else if ("e5".equals(str)) {
                r2b.d(editorTools, dd5Var);
            } else if ("e6".equals(str)) {
                r2b.a(tbPageContext, editorTools, dd5Var);
            } else if ("e7".equals(str)) {
                r2b.l(tbPageContext, editorTools, dd5Var);
            } else if ("e8".equals(str)) {
                r2b.b(tbPageContext, editorTools, dd5Var);
            } else if ("e9".equals(str)) {
                r2b.i(tbPageContext, editorTools);
            } else if ("e10".equals(str)) {
                r2b.c(tbPageContext, editorTools, dd5Var);
            } else if ("e11".equals(str)) {
                r2b.f(tbPageContext, editorTools, dd5Var);
            } else if ("e12".equals(str)) {
                r2b.e(tbPageContext, editorTools, dd5Var);
            }
        }
    }
}
