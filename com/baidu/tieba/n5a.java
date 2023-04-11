package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class n5a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull qc5 qc5Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, tbPageContext, editorTools, qc5Var, str) == null) {
            if ("e1".equals(str)) {
                v5a.h(tbPageContext, editorTools, qc5Var);
            } else if (Config.SESSTION_TRACK_END_TIME.equals(str)) {
                v5a.j(tbPageContext, editorTools, qc5Var);
            } else if ("e3".equals(str)) {
                v5a.k(tbPageContext, editorTools, qc5Var);
            } else if ("e4".equals(str)) {
                v5a.g(tbPageContext, editorTools, qc5Var);
            } else if ("e5".equals(str)) {
                v5a.d(editorTools, qc5Var);
            } else if ("e6".equals(str)) {
                v5a.a(tbPageContext, editorTools, qc5Var);
            } else if ("e7".equals(str)) {
                v5a.l(tbPageContext, editorTools, qc5Var);
            } else if ("e8".equals(str)) {
                v5a.b(tbPageContext, editorTools, qc5Var);
            } else if ("e9".equals(str)) {
                v5a.i(tbPageContext, editorTools);
            } else if ("e10".equals(str)) {
                v5a.c(tbPageContext, editorTools, qc5Var);
            } else if ("e11".equals(str)) {
                v5a.f(tbPageContext, editorTools, qc5Var);
            } else if ("e12".equals(str)) {
                v5a.e(tbPageContext, editorTools, qc5Var);
            }
        }
    }
}
