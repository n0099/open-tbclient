package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class f {
    public static void a(com.baidu.tbadk.k.h hVar, View.OnClickListener onClickListener, Context context, View view, String str, boolean z) {
        if (!a(hVar) && context != null && view != null) {
            if (hVar == null) {
                hVar = new com.baidu.tbadk.k.h(context, onClickListener);
            }
            hVar.setLayoutMargin(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
            hVar.attachView(view, z);
            hVar.showRefreshButton();
            hVar.onChangeSkinType();
        }
    }

    private static boolean a(com.baidu.tbadk.k.h hVar) {
        if (hVar != null) {
            return hVar.isViewAttached();
        }
        return false;
    }
}
