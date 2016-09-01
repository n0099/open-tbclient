package com.baidu.tieba.onlineDebugger.command;

import com.baidu.tieba.onlineDebugger.command.b;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ b egp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.egp = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        new b.a(this.egp, null).execute(new String[0]);
    }
}
