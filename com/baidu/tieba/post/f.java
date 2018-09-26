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
            gVar.fs(context.getResources().getDimensionPixelSize(e.C0141e.ds280));
            gVar.hG(str);
            gVar.c(view, z);
            gVar.KA();
            gVar.onChangeSkinType();
        }
    }

    private static boolean a(com.baidu.tbadk.k.g gVar) {
        if (gVar != null) {
            return gVar.Ks();
        }
        return false;
    }
}
