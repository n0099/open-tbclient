package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class j79 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull f65 f65Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, tbPageContext, editorTools, f65Var, str) == null) {
            if ("e1".equals(str)) {
                r79.h(tbPageContext, editorTools, f65Var);
            } else if (Config.SESSTION_TRACK_END_TIME.equals(str)) {
                r79.j(tbPageContext, editorTools, f65Var);
            } else if ("e3".equals(str)) {
                r79.k(tbPageContext, editorTools, f65Var);
            } else if ("e4".equals(str)) {
                r79.g(tbPageContext, editorTools, f65Var);
            } else if ("e5".equals(str)) {
                r79.d(editorTools, f65Var);
            } else if ("e6".equals(str)) {
                r79.a(tbPageContext, editorTools, f65Var);
            } else if ("e7".equals(str)) {
                r79.l(tbPageContext, editorTools, f65Var);
            } else if ("e8".equals(str)) {
                r79.b(tbPageContext, editorTools, f65Var);
            } else if ("e9".equals(str)) {
                r79.i(tbPageContext, editorTools);
            } else if ("e10".equals(str)) {
                r79.c(tbPageContext, editorTools, f65Var);
            } else if ("e11".equals(str)) {
                r79.f(tbPageContext, editorTools, f65Var);
            } else if ("e12".equals(str)) {
                r79.e(tbPageContext, editorTools, f65Var);
            }
        }
    }
}
