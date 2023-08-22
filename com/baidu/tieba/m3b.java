package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class m3b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull ai5 ai5Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, tbPageContext, editorTools, ai5Var, str) == null) {
            if ("e1".equals(str)) {
                u3b.h(tbPageContext, editorTools, ai5Var);
            } else if (Config.SESSTION_TRACK_END_TIME.equals(str)) {
                u3b.j(tbPageContext, editorTools, ai5Var);
            } else if ("e3".equals(str)) {
                u3b.k(tbPageContext, editorTools, ai5Var);
            } else if ("e4".equals(str)) {
                u3b.g(tbPageContext, editorTools, ai5Var);
            } else if ("e5".equals(str)) {
                u3b.d(editorTools, ai5Var);
            } else if ("e6".equals(str)) {
                u3b.a(tbPageContext, editorTools, ai5Var);
            } else if ("e7".equals(str)) {
                u3b.l(tbPageContext, editorTools, ai5Var);
            } else if ("e8".equals(str)) {
                u3b.b(tbPageContext, editorTools, ai5Var);
            } else if ("e9".equals(str)) {
                u3b.i(tbPageContext, editorTools);
            } else if ("e10".equals(str)) {
                u3b.c(tbPageContext, editorTools, ai5Var);
            } else if ("e11".equals(str)) {
                u3b.f(tbPageContext, editorTools, ai5Var);
            } else if ("e12".equals(str)) {
                u3b.e(tbPageContext, editorTools, ai5Var);
            }
        }
    }
}
