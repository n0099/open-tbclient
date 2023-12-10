package com.baidu.tieba;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.base.BdPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class n4a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(r1a processController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, processController) == null) {
            Intrinsics.checkNotNullParameter(processController, "processController");
            pdb e = processController.e();
            if (e != null) {
                if (!e.e()) {
                    processController.a(false);
                }
                e.l(false);
            }
        }
    }

    public static final void b(CharSequence s, int i, int i2, EditorTools mET, x2a x2aVar, BdPageContext<?> bdPageContext, ViewGroup parent) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{s, Integer.valueOf(i), Integer.valueOf(i2), mET, x2aVar, bdPageContext, parent}) == null) {
            Intrinsics.checkNotNullParameter(s, "s");
            Intrinsics.checkNotNullParameter(mET, "mET");
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (mET.getVisibility() == 0 && bdPageContext != null && s.length() >= (i3 = i2 + i)) {
                String substring = s.toString().substring(i, i3);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                if (TextUtils.isEmpty(substring)) {
                    return;
                }
                if (x2aVar == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(11);
                    layoutParams.addRule(2, mET.getId());
                    x2aVar = new x2a(bdPageContext, parent, layoutParams);
                    x2aVar.r(mET);
                }
                x2aVar.p(substring);
            }
        }
    }
}
