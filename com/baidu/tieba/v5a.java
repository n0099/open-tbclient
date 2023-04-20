package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class v5a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull rc5 rc5Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, tbPageContext, editorTools, rc5Var, str) == null) {
            if ("e1".equals(str)) {
                d6a.h(tbPageContext, editorTools, rc5Var);
            } else if (Config.SESSTION_TRACK_END_TIME.equals(str)) {
                d6a.j(tbPageContext, editorTools, rc5Var);
            } else if ("e3".equals(str)) {
                d6a.k(tbPageContext, editorTools, rc5Var);
            } else if ("e4".equals(str)) {
                d6a.g(tbPageContext, editorTools, rc5Var);
            } else if ("e5".equals(str)) {
                d6a.d(editorTools, rc5Var);
            } else if ("e6".equals(str)) {
                d6a.a(tbPageContext, editorTools, rc5Var);
            } else if ("e7".equals(str)) {
                d6a.l(tbPageContext, editorTools, rc5Var);
            } else if ("e8".equals(str)) {
                d6a.b(tbPageContext, editorTools, rc5Var);
            } else if ("e9".equals(str)) {
                d6a.i(tbPageContext, editorTools);
            } else if ("e10".equals(str)) {
                d6a.c(tbPageContext, editorTools, rc5Var);
            } else if ("e11".equals(str)) {
                d6a.f(tbPageContext, editorTools, rc5Var);
            } else if ("e12".equals(str)) {
                d6a.e(tbPageContext, editorTools, rc5Var);
            }
        }
    }
}
