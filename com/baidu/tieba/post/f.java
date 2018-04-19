package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class f {
    public static void a(com.baidu.tbadk.j.g gVar, View.OnClickListener onClickListener, Context context, View view2, String str, boolean z) {
        if (!a(gVar) && context != null && view2 != null) {
            if (gVar == null) {
                gVar = new com.baidu.tbadk.j.g(context, onClickListener);
            }
            gVar.fa(context.getResources().getDimensionPixelSize(d.e.ds280));
            gVar.setSubText(str);
            gVar.d(view2, z);
            gVar.Fu();
            gVar.onChangeSkinType();
        }
    }

    private static boolean a(com.baidu.tbadk.j.g gVar) {
        if (gVar != null) {
            return gVar.Fm();
        }
        return false;
    }
}
