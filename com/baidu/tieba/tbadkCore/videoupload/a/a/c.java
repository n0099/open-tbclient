package com.baidu.tieba.tbadkCore.videoupload.a.a;

import java.util.concurrent.ThreadFactory;
/* loaded from: classes.dex */
class c implements ThreadFactory {
    private int fyG = 0;
    final /* synthetic */ b fyH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.fyH = bVar;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("VideoUploadThread@" + this.fyG);
        this.fyG++;
        return thread;
    }
}
