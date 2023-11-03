package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class kfb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull yd5 yd5Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, tbPageContext, editorTools, yd5Var, str) == null) {
            if ("e1".equals(str)) {
                sfb.h(tbPageContext, editorTools, yd5Var);
            } else if (Config.SESSTION_TRACK_END_TIME.equals(str)) {
                sfb.j(tbPageContext, editorTools, yd5Var);
            } else if ("e3".equals(str)) {
                sfb.k(tbPageContext, editorTools, yd5Var);
            } else if ("e4".equals(str)) {
                sfb.g(tbPageContext, editorTools, yd5Var);
            } else if ("e5".equals(str)) {
                sfb.d(editorTools, yd5Var);
            } else if ("e6".equals(str)) {
                sfb.a(tbPageContext, editorTools, yd5Var);
            } else if ("e7".equals(str)) {
                sfb.l(tbPageContext, editorTools, yd5Var);
            } else if ("e8".equals(str)) {
                sfb.b(tbPageContext, editorTools, yd5Var);
            } else if ("e9".equals(str)) {
                sfb.i(tbPageContext, editorTools);
            } else if ("e10".equals(str)) {
                sfb.c(tbPageContext, editorTools, yd5Var);
            } else if ("e11".equals(str)) {
                sfb.f(tbPageContext, editorTools, yd5Var);
            } else if ("e12".equals(str)) {
                sfb.e(tbPageContext, editorTools, yd5Var);
            }
        }
    }
}
