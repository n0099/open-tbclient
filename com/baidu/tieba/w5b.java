package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class w5b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull ti5 ti5Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, tbPageContext, editorTools, ti5Var, str) == null) {
            if ("e1".equals(str)) {
                e6b.h(tbPageContext, editorTools, ti5Var);
            } else if (Config.SESSTION_TRACK_END_TIME.equals(str)) {
                e6b.j(tbPageContext, editorTools, ti5Var);
            } else if ("e3".equals(str)) {
                e6b.k(tbPageContext, editorTools, ti5Var);
            } else if ("e4".equals(str)) {
                e6b.g(tbPageContext, editorTools, ti5Var);
            } else if ("e5".equals(str)) {
                e6b.d(editorTools, ti5Var);
            } else if ("e6".equals(str)) {
                e6b.a(tbPageContext, editorTools, ti5Var);
            } else if ("e7".equals(str)) {
                e6b.l(tbPageContext, editorTools, ti5Var);
            } else if ("e8".equals(str)) {
                e6b.b(tbPageContext, editorTools, ti5Var);
            } else if ("e9".equals(str)) {
                e6b.i(tbPageContext, editorTools);
            } else if ("e10".equals(str)) {
                e6b.c(tbPageContext, editorTools, ti5Var);
            } else if ("e11".equals(str)) {
                e6b.f(tbPageContext, editorTools, ti5Var);
            } else if ("e12".equals(str)) {
                e6b.e(tbPageContext, editorTools, ti5Var);
            }
        }
    }
}
