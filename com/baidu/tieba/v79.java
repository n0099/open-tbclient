package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class v79 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull m65 m65Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, tbPageContext, editorTools, m65Var, str) == null) {
            if ("e1".equals(str)) {
                d89.h(tbPageContext, editorTools, m65Var);
            } else if (Config.SESSTION_TRACK_END_TIME.equals(str)) {
                d89.j(tbPageContext, editorTools, m65Var);
            } else if ("e3".equals(str)) {
                d89.k(tbPageContext, editorTools, m65Var);
            } else if ("e4".equals(str)) {
                d89.g(tbPageContext, editorTools, m65Var);
            } else if ("e5".equals(str)) {
                d89.d(editorTools, m65Var);
            } else if ("e6".equals(str)) {
                d89.a(tbPageContext, editorTools, m65Var);
            } else if ("e7".equals(str)) {
                d89.l(tbPageContext, editorTools, m65Var);
            } else if ("e8".equals(str)) {
                d89.b(tbPageContext, editorTools, m65Var);
            } else if ("e9".equals(str)) {
                d89.i(tbPageContext, editorTools);
            } else if ("e10".equals(str)) {
                d89.c(tbPageContext, editorTools, m65Var);
            } else if ("e11".equals(str)) {
                d89.f(tbPageContext, editorTools, m65Var);
            } else if ("e12".equals(str)) {
                d89.e(tbPageContext, editorTools, m65Var);
            }
        }
    }
}
