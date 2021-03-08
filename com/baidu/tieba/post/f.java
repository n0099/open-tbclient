package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class f {
    public static void a(com.baidu.tbadk.l.h hVar, View.OnClickListener onClickListener, Context context, View view, String str, boolean z) {
        if (!b(hVar) && context != null && view != null) {
            if (hVar == null) {
                hVar = new com.baidu.tbadk.l.h(context, onClickListener);
            }
            hVar.setLayoutMargin(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
            hVar.attachView(view, z);
            hVar.showRefreshButton();
            hVar.onChangeSkinType();
        }
    }

    private static boolean b(com.baidu.tbadk.l.h hVar) {
        if (hVar != null) {
            return hVar.isViewAttached();
        }
        return false;
    }
}
