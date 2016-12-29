package com.baidu.tieba.onlineDebugger.command;

import com.baidu.tieba.onlineDebugger.command.b;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ b dSO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.dSO = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        new b.a(this.dSO, null).execute(new String[0]);
    }
}
