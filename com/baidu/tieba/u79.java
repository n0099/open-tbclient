package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class u79 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull l65 l65Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, tbPageContext, editorTools, l65Var, str) == null) {
            if ("e1".equals(str)) {
                c89.h(tbPageContext, editorTools, l65Var);
            } else if (Config.SESSTION_TRACK_END_TIME.equals(str)) {
                c89.j(tbPageContext, editorTools, l65Var);
            } else if ("e3".equals(str)) {
                c89.k(tbPageContext, editorTools, l65Var);
            } else if ("e4".equals(str)) {
                c89.g(tbPageContext, editorTools, l65Var);
            } else if ("e5".equals(str)) {
                c89.d(editorTools, l65Var);
            } else if ("e6".equals(str)) {
                c89.a(tbPageContext, editorTools, l65Var);
            } else if ("e7".equals(str)) {
                c89.l(tbPageContext, editorTools, l65Var);
            } else if ("e8".equals(str)) {
                c89.b(tbPageContext, editorTools, l65Var);
            } else if ("e9".equals(str)) {
                c89.i(tbPageContext, editorTools);
            } else if ("e10".equals(str)) {
                c89.c(tbPageContext, editorTools, l65Var);
            } else if ("e11".equals(str)) {
                c89.f(tbPageContext, editorTools, l65Var);
            } else if ("e12".equals(str)) {
                c89.e(tbPageContext, editorTools, l65Var);
            }
        }
    }
}
