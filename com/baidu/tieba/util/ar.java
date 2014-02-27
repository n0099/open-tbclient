package com.baidu.tieba.util;

import android.view.View;
/* loaded from: classes.dex */
final class ar implements cj {
    final /* synthetic */ aq a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(aq aqVar, String str) {
        this.a = aqVar;
        this.b = str;
    }

    @Override // com.baidu.tieba.util.cj
    public final boolean a(View view) {
        if (this.b.equals(view.getTag())) {
            view.invalidate();
            return false;
        }
        return false;
    }
}
