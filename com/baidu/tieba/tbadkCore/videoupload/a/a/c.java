package com.baidu.tieba.tbadkCore.videoupload.a.a;

import java.util.concurrent.ThreadFactory;
/* loaded from: classes.dex */
class c implements ThreadFactory {
    private int fAW = 0;
    final /* synthetic */ b fAX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.fAX = bVar;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("VideoUploadThread@" + this.fAW);
        this.fAW++;
        return thread;
    }
}
