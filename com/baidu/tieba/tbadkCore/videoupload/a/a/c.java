package com.baidu.tieba.tbadkCore.videoupload.a.a;

import java.util.concurrent.ThreadFactory;
/* loaded from: classes.dex */
class c implements ThreadFactory {
    private int fPc = 0;
    final /* synthetic */ b fPd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.fPd = bVar;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("VideoUploadThread@" + this.fPc);
        this.fPc++;
        return thread;
    }
}
