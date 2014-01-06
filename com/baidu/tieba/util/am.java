package com.baidu.tieba.util;

import android.view.View;
/* loaded from: classes.dex */
class am implements bw {
    final /* synthetic */ String a;
    final /* synthetic */ al b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar, String str) {
        this.b = alVar;
        this.a = str;
    }

    @Override // com.baidu.tieba.util.bw
    public boolean a(View view) {
        if (this.a.equals(view.getTag())) {
            view.invalidate();
            return false;
        }
        return false;
    }
}
