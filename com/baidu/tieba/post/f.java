package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class f {
    public static void a(com.baidu.tbadk.k.g gVar, View.OnClickListener onClickListener, Context context, View view, String str, boolean z) {
        if (!a(gVar) && context != null && view != null) {
            if (gVar == null) {
                gVar = new com.baidu.tbadk.k.g(context, onClickListener);
            }
            gVar.fP(context.getResources().getDimensionPixelSize(e.C0200e.ds280));
            gVar.hV(str);
            gVar.attachView(view, z);
            gVar.MH();
            gVar.onChangeSkinType();
        }
    }

    private static boolean a(com.baidu.tbadk.k.g gVar) {
        if (gVar != null) {
            return gVar.isViewAttached();
        }
        return false;
    }
}
