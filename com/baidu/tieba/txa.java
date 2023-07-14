package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class txa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull aj5 aj5Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, tbPageContext, editorTools, aj5Var, str) == null) {
            if ("e1".equals(str)) {
                bya.h(tbPageContext, editorTools, aj5Var);
            } else if (Config.SESSTION_TRACK_END_TIME.equals(str)) {
                bya.j(tbPageContext, editorTools, aj5Var);
            } else if ("e3".equals(str)) {
                bya.k(tbPageContext, editorTools, aj5Var);
            } else if ("e4".equals(str)) {
                bya.g(tbPageContext, editorTools, aj5Var);
            } else if ("e5".equals(str)) {
                bya.d(editorTools, aj5Var);
            } else if ("e6".equals(str)) {
                bya.a(tbPageContext, editorTools, aj5Var);
            } else if ("e7".equals(str)) {
                bya.l(tbPageContext, editorTools, aj5Var);
            } else if ("e8".equals(str)) {
                bya.b(tbPageContext, editorTools, aj5Var);
            } else if ("e9".equals(str)) {
                bya.i(tbPageContext, editorTools);
            } else if ("e10".equals(str)) {
                bya.c(tbPageContext, editorTools, aj5Var);
            } else if ("e11".equals(str)) {
                bya.f(tbPageContext, editorTools, aj5Var);
            } else if ("e12".equals(str)) {
                bya.e(tbPageContext, editorTools, aj5Var);
            }
        }
    }
}
