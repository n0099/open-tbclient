package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class lfb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull zd5 zd5Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, tbPageContext, editorTools, zd5Var, str) == null) {
            if ("e1".equals(str)) {
                tfb.h(tbPageContext, editorTools, zd5Var);
            } else if (Config.SESSTION_TRACK_END_TIME.equals(str)) {
                tfb.j(tbPageContext, editorTools, zd5Var);
            } else if ("e3".equals(str)) {
                tfb.k(tbPageContext, editorTools, zd5Var);
            } else if ("e4".equals(str)) {
                tfb.g(tbPageContext, editorTools, zd5Var);
            } else if ("e5".equals(str)) {
                tfb.d(editorTools, zd5Var);
            } else if ("e6".equals(str)) {
                tfb.a(tbPageContext, editorTools, zd5Var);
            } else if ("e7".equals(str)) {
                tfb.l(tbPageContext, editorTools, zd5Var);
            } else if ("e8".equals(str)) {
                tfb.b(tbPageContext, editorTools, zd5Var);
            } else if ("e9".equals(str)) {
                tfb.i(tbPageContext, editorTools);
            } else if ("e10".equals(str)) {
                tfb.c(tbPageContext, editorTools, zd5Var);
            } else if ("e11".equals(str)) {
                tfb.f(tbPageContext, editorTools, zd5Var);
            } else if ("e12".equals(str)) {
                tfb.e(tbPageContext, editorTools, zd5Var);
            }
        }
    }
}
