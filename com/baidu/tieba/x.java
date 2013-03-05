package com.baidu.tieba;

import android.database.ContentObserver;
import android.os.Handler;
/* loaded from: classes.dex */
class x extends ContentObserver {
    final /* synthetic */ TiebaApplication a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(TiebaApplication tiebaApplication, Handler handler) {
        super(handler);
        this.a = tiebaApplication;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        super.onChange(z);
        com.baidu.tieba.c.w.c();
    }
}
