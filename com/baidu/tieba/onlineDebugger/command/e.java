package com.baidu.tieba.onlineDebugger.command;

import com.baidu.tieba.onlineDebugger.command.b;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ b dUj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.dUj = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        new b.a(this.dUj, null).execute(new String[0]);
    }
}
