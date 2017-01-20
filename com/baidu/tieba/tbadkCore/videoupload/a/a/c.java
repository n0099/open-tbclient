package com.baidu.tieba.tbadkCore.videoupload.a.a;

import java.util.concurrent.ThreadFactory;
/* loaded from: classes.dex */
class c implements ThreadFactory {
    final /* synthetic */ b fsA;
    private int fsz = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.fsA = bVar;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("VideoUploadThread@" + this.fsz);
        this.fsz++;
        return thread;
    }
}
