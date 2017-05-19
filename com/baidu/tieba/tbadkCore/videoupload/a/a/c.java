package com.baidu.tieba.tbadkCore.videoupload.a.a;

import java.util.concurrent.ThreadFactory;
/* loaded from: classes.dex */
class c implements ThreadFactory {
    private int fxf = 0;
    final /* synthetic */ b fxg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.fxg = bVar;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("VideoUploadThread@" + this.fxf);
        this.fxf++;
        return thread;
    }
}
