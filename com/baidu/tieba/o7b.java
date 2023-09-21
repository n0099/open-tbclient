package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class o7b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull xi5 xi5Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, tbPageContext, editorTools, xi5Var, str) == null) {
            if ("e1".equals(str)) {
                w7b.h(tbPageContext, editorTools, xi5Var);
            } else if (Config.SESSTION_TRACK_END_TIME.equals(str)) {
                w7b.j(tbPageContext, editorTools, xi5Var);
            } else if ("e3".equals(str)) {
                w7b.k(tbPageContext, editorTools, xi5Var);
            } else if ("e4".equals(str)) {
                w7b.g(tbPageContext, editorTools, xi5Var);
            } else if ("e5".equals(str)) {
                w7b.d(editorTools, xi5Var);
            } else if ("e6".equals(str)) {
                w7b.a(tbPageContext, editorTools, xi5Var);
            } else if ("e7".equals(str)) {
                w7b.l(tbPageContext, editorTools, xi5Var);
            } else if ("e8".equals(str)) {
                w7b.b(tbPageContext, editorTools, xi5Var);
            } else if ("e9".equals(str)) {
                w7b.i(tbPageContext, editorTools);
            } else if ("e10".equals(str)) {
                w7b.c(tbPageContext, editorTools, xi5Var);
            } else if ("e11".equals(str)) {
                w7b.f(tbPageContext, editorTools, xi5Var);
            } else if ("e12".equals(str)) {
                w7b.e(tbPageContext, editorTools, xi5Var);
            }
        }
    }
}
