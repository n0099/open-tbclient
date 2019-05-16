package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class f {
    public static void a(com.baidu.tbadk.m.h hVar, View.OnClickListener onClickListener, Context context, View view, String str, boolean z) {
        if (!a(hVar) && context != null && view != null) {
            if (hVar == null) {
                hVar = new com.baidu.tbadk.m.h(context, onClickListener);
            }
            hVar.kE(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
            hVar.qx(str);
            hVar.attachView(view, z);
            hVar.asB();
            hVar.onChangeSkinType();
        }
    }

    private static boolean a(com.baidu.tbadk.m.h hVar) {
        if (hVar != null) {
            return hVar.isViewAttached();
        }
        return false;
    }
}
