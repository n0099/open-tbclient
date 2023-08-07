package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class wwa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull mh5 mh5Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, tbPageContext, editorTools, mh5Var, str) == null) {
            if ("e1".equals(str)) {
                exa.h(tbPageContext, editorTools, mh5Var);
            } else if (Config.SESSTION_TRACK_END_TIME.equals(str)) {
                exa.j(tbPageContext, editorTools, mh5Var);
            } else if ("e3".equals(str)) {
                exa.k(tbPageContext, editorTools, mh5Var);
            } else if ("e4".equals(str)) {
                exa.g(tbPageContext, editorTools, mh5Var);
            } else if ("e5".equals(str)) {
                exa.d(editorTools, mh5Var);
            } else if ("e6".equals(str)) {
                exa.a(tbPageContext, editorTools, mh5Var);
            } else if ("e7".equals(str)) {
                exa.l(tbPageContext, editorTools, mh5Var);
            } else if ("e8".equals(str)) {
                exa.b(tbPageContext, editorTools, mh5Var);
            } else if ("e9".equals(str)) {
                exa.i(tbPageContext, editorTools);
            } else if ("e10".equals(str)) {
                exa.c(tbPageContext, editorTools, mh5Var);
            } else if ("e11".equals(str)) {
                exa.f(tbPageContext, editorTools, mh5Var);
            } else if ("e12".equals(str)) {
                exa.e(tbPageContext, editorTools, mh5Var);
            }
        }
    }
}
