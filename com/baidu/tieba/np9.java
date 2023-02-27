package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class np9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull zc5 zc5Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, tbPageContext, editorTools, zc5Var, str) == null) {
            if ("e1".equals(str)) {
                vp9.h(tbPageContext, editorTools, zc5Var);
            } else if (Config.SESSTION_TRACK_END_TIME.equals(str)) {
                vp9.j(tbPageContext, editorTools, zc5Var);
            } else if ("e3".equals(str)) {
                vp9.k(tbPageContext, editorTools, zc5Var);
            } else if ("e4".equals(str)) {
                vp9.g(tbPageContext, editorTools, zc5Var);
            } else if ("e5".equals(str)) {
                vp9.d(editorTools, zc5Var);
            } else if ("e6".equals(str)) {
                vp9.a(tbPageContext, editorTools, zc5Var);
            } else if ("e7".equals(str)) {
                vp9.l(tbPageContext, editorTools, zc5Var);
            } else if ("e8".equals(str)) {
                vp9.b(tbPageContext, editorTools, zc5Var);
            } else if ("e9".equals(str)) {
                vp9.i(tbPageContext, editorTools);
            } else if ("e10".equals(str)) {
                vp9.c(tbPageContext, editorTools, zc5Var);
            } else if ("e11".equals(str)) {
                vp9.f(tbPageContext, editorTools, zc5Var);
            } else if ("e12".equals(str)) {
                vp9.e(tbPageContext, editorTools, zc5Var);
            }
        }
    }
}
