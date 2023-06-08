package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class oia {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull vh5 vh5Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, tbPageContext, editorTools, vh5Var, str) == null) {
            if ("e1".equals(str)) {
                wia.h(tbPageContext, editorTools, vh5Var);
            } else if (Config.SESSTION_TRACK_END_TIME.equals(str)) {
                wia.j(tbPageContext, editorTools, vh5Var);
            } else if ("e3".equals(str)) {
                wia.k(tbPageContext, editorTools, vh5Var);
            } else if ("e4".equals(str)) {
                wia.g(tbPageContext, editorTools, vh5Var);
            } else if ("e5".equals(str)) {
                wia.d(editorTools, vh5Var);
            } else if ("e6".equals(str)) {
                wia.a(tbPageContext, editorTools, vh5Var);
            } else if ("e7".equals(str)) {
                wia.l(tbPageContext, editorTools, vh5Var);
            } else if ("e8".equals(str)) {
                wia.b(tbPageContext, editorTools, vh5Var);
            } else if ("e9".equals(str)) {
                wia.i(tbPageContext, editorTools);
            } else if ("e10".equals(str)) {
                wia.c(tbPageContext, editorTools, vh5Var);
            } else if ("e11".equals(str)) {
                wia.f(tbPageContext, editorTools, vh5Var);
            } else if ("e12".equals(str)) {
                wia.e(tbPageContext, editorTools, vh5Var);
            }
        }
    }
}
