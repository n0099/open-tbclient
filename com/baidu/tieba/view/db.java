package com.baidu.tieba.view;

import android.view.View;
/* loaded from: classes.dex */
final class db implements com.baidu.tieba.util.cj {
    final /* synthetic */ da a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public db(da daVar, String str) {
        this.a = daVar;
        this.b = str;
    }

    @Override // com.baidu.tieba.util.cj
    public final boolean a(View view) {
        Object tag = view.getTag();
        if (tag != null && this.b.equals(tag)) {
            view.invalidate();
            return false;
        }
        return false;
    }
}
