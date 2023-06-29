package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class voa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull di5 di5Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, tbPageContext, editorTools, di5Var, str) == null) {
            if ("e1".equals(str)) {
                dpa.h(tbPageContext, editorTools, di5Var);
            } else if (Config.SESSTION_TRACK_END_TIME.equals(str)) {
                dpa.j(tbPageContext, editorTools, di5Var);
            } else if ("e3".equals(str)) {
                dpa.k(tbPageContext, editorTools, di5Var);
            } else if ("e4".equals(str)) {
                dpa.g(tbPageContext, editorTools, di5Var);
            } else if ("e5".equals(str)) {
                dpa.d(editorTools, di5Var);
            } else if ("e6".equals(str)) {
                dpa.a(tbPageContext, editorTools, di5Var);
            } else if ("e7".equals(str)) {
                dpa.l(tbPageContext, editorTools, di5Var);
            } else if ("e8".equals(str)) {
                dpa.b(tbPageContext, editorTools, di5Var);
            } else if ("e9".equals(str)) {
                dpa.i(tbPageContext, editorTools);
            } else if ("e10".equals(str)) {
                dpa.c(tbPageContext, editorTools, di5Var);
            } else if ("e11".equals(str)) {
                dpa.f(tbPageContext, editorTools, di5Var);
            } else if ("e12".equals(str)) {
                dpa.e(tbPageContext, editorTools, di5Var);
            }
        }
    }
}
