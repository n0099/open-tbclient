package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class xwa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull mh5 mh5Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, tbPageContext, editorTools, mh5Var, str) == null) {
            if ("e1".equals(str)) {
                fxa.h(tbPageContext, editorTools, mh5Var);
            } else if (Config.SESSTION_TRACK_END_TIME.equals(str)) {
                fxa.j(tbPageContext, editorTools, mh5Var);
            } else if ("e3".equals(str)) {
                fxa.k(tbPageContext, editorTools, mh5Var);
            } else if ("e4".equals(str)) {
                fxa.g(tbPageContext, editorTools, mh5Var);
            } else if ("e5".equals(str)) {
                fxa.d(editorTools, mh5Var);
            } else if ("e6".equals(str)) {
                fxa.a(tbPageContext, editorTools, mh5Var);
            } else if ("e7".equals(str)) {
                fxa.l(tbPageContext, editorTools, mh5Var);
            } else if ("e8".equals(str)) {
                fxa.b(tbPageContext, editorTools, mh5Var);
            } else if ("e9".equals(str)) {
                fxa.i(tbPageContext, editorTools);
            } else if ("e10".equals(str)) {
                fxa.c(tbPageContext, editorTools, mh5Var);
            } else if ("e11".equals(str)) {
                fxa.f(tbPageContext, editorTools, mh5Var);
            } else if ("e12".equals(str)) {
                fxa.e(tbPageContext, editorTools, mh5Var);
            }
        }
    }
}
