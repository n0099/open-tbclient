package com.baidu.tieba.util;

import android.view.View;
/* loaded from: classes.dex */
class ap implements cg {
    final /* synthetic */ String a;
    final /* synthetic */ ao b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar, String str) {
        this.b = aoVar;
        this.a = str;
    }

    @Override // com.baidu.tieba.util.cg
    public boolean a(View view) {
        if (this.a.equals(view.getTag())) {
            view.invalidate();
            return false;
        }
        return false;
    }
}
