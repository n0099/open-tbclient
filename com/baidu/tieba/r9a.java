package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class r9a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull kd5 kd5Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, tbPageContext, editorTools, kd5Var, str) == null) {
            if ("e1".equals(str)) {
                z9a.h(tbPageContext, editorTools, kd5Var);
            } else if (Config.SESSTION_TRACK_END_TIME.equals(str)) {
                z9a.j(tbPageContext, editorTools, kd5Var);
            } else if ("e3".equals(str)) {
                z9a.k(tbPageContext, editorTools, kd5Var);
            } else if ("e4".equals(str)) {
                z9a.g(tbPageContext, editorTools, kd5Var);
            } else if ("e5".equals(str)) {
                z9a.d(editorTools, kd5Var);
            } else if ("e6".equals(str)) {
                z9a.a(tbPageContext, editorTools, kd5Var);
            } else if ("e7".equals(str)) {
                z9a.l(tbPageContext, editorTools, kd5Var);
            } else if ("e8".equals(str)) {
                z9a.b(tbPageContext, editorTools, kd5Var);
            } else if ("e9".equals(str)) {
                z9a.i(tbPageContext, editorTools);
            } else if ("e10".equals(str)) {
                z9a.c(tbPageContext, editorTools, kd5Var);
            } else if ("e11".equals(str)) {
                z9a.f(tbPageContext, editorTools, kd5Var);
            } else if ("e12".equals(str)) {
                z9a.e(tbPageContext, editorTools, kd5Var);
            }
        }
    }
}
