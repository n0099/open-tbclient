package com.baidu.tieba.tbadkCore.videoupload.a.a;

import java.util.concurrent.ThreadFactory;
/* loaded from: classes.dex */
class c implements ThreadFactory {
    private int fjn = 0;
    final /* synthetic */ b fjo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.fjo = bVar;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("VideoUploadThread@" + this.fjn);
        this.fjn++;
        return thread;
    }
}
