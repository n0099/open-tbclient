package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class tba {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull te5 te5Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, tbPageContext, editorTools, te5Var, str) == null) {
            if ("e1".equals(str)) {
                bca.h(tbPageContext, editorTools, te5Var);
            } else if (Config.SESSTION_TRACK_END_TIME.equals(str)) {
                bca.j(tbPageContext, editorTools, te5Var);
            } else if ("e3".equals(str)) {
                bca.k(tbPageContext, editorTools, te5Var);
            } else if ("e4".equals(str)) {
                bca.g(tbPageContext, editorTools, te5Var);
            } else if ("e5".equals(str)) {
                bca.d(editorTools, te5Var);
            } else if ("e6".equals(str)) {
                bca.a(tbPageContext, editorTools, te5Var);
            } else if ("e7".equals(str)) {
                bca.l(tbPageContext, editorTools, te5Var);
            } else if ("e8".equals(str)) {
                bca.b(tbPageContext, editorTools, te5Var);
            } else if ("e9".equals(str)) {
                bca.i(tbPageContext, editorTools);
            } else if ("e10".equals(str)) {
                bca.c(tbPageContext, editorTools, te5Var);
            } else if ("e11".equals(str)) {
                bca.f(tbPageContext, editorTools, te5Var);
            } else if ("e12".equals(str)) {
                bca.e(tbPageContext, editorTools, te5Var);
            }
        }
    }
}
