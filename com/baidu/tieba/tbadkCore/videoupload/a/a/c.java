package com.baidu.tieba.tbadkCore.videoupload.a.a;

import java.util.concurrent.ThreadFactory;
/* loaded from: classes.dex */
class c implements ThreadFactory {
    private int fEX = 0;
    final /* synthetic */ b fEY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.fEY = bVar;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("VideoUploadThread@" + this.fEX);
        this.fEX++;
        return thread;
    }
}
