package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class nk9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull mb5 mb5Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, tbPageContext, editorTools, mb5Var, str) == null) {
            if ("e1".equals(str)) {
                vk9.h(tbPageContext, editorTools, mb5Var);
            } else if (Config.SESSTION_TRACK_END_TIME.equals(str)) {
                vk9.j(tbPageContext, editorTools, mb5Var);
            } else if ("e3".equals(str)) {
                vk9.k(tbPageContext, editorTools, mb5Var);
            } else if ("e4".equals(str)) {
                vk9.g(tbPageContext, editorTools, mb5Var);
            } else if ("e5".equals(str)) {
                vk9.d(editorTools, mb5Var);
            } else if ("e6".equals(str)) {
                vk9.a(tbPageContext, editorTools, mb5Var);
            } else if ("e7".equals(str)) {
                vk9.l(tbPageContext, editorTools, mb5Var);
            } else if ("e8".equals(str)) {
                vk9.b(tbPageContext, editorTools, mb5Var);
            } else if ("e9".equals(str)) {
                vk9.i(tbPageContext, editorTools);
            } else if ("e10".equals(str)) {
                vk9.c(tbPageContext, editorTools, mb5Var);
            } else if ("e11".equals(str)) {
                vk9.f(tbPageContext, editorTools, mb5Var);
            } else if ("e12".equals(str)) {
                vk9.e(tbPageContext, editorTools, mb5Var);
            }
        }
    }
}
