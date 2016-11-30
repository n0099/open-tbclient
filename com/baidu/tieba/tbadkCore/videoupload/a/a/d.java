package com.baidu.tieba.tbadkCore.videoupload.a.a;

import com.baidu.adp.lib.util.StringUtils;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ b fFh;
    private final /* synthetic */ RandomAccessFile fFi;
    private final /* synthetic */ ArrayList fFj;
    private final /* synthetic */ int fFk;
    private final /* synthetic */ int fFl;
    private final /* synthetic */ String fFm;
    private final /* synthetic */ int fFn;
    private final /* synthetic */ CountDownLatch fFo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, RandomAccessFile randomAccessFile, ArrayList arrayList, int i, int i2, String str, int i3, CountDownLatch countDownLatch) {
        this.fFh = bVar;
        this.fFi = randomAccessFile;
        this.fFj = arrayList;
        this.fFk = i;
        this.fFl = i2;
        this.fFm = str;
        this.fFn = i3;
        this.fFo = countDownLatch;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        f fVar;
        f fVar2;
        f fVar3;
        f a = this.fFh.a(this.fFi, ((Integer) this.fFj.get(this.fFk)).intValue(), this.fFl, this.fFm);
        if (a != null) {
            if (a.errorNo != 0) {
                fVar2 = this.fFh.fFf;
                fVar2.errorNo = a.errorNo;
                fVar3 = this.fFh.fFf;
                fVar3.errorMessage = a.errorMessage;
            }
            if (!StringUtils.isNull(a.videoUrl)) {
                fVar = this.fFh.fFf;
                fVar.videoUrl = a.videoUrl;
            }
            synchronized (this.fFh) {
                b bVar = this.fFh;
                i = bVar.dCS;
                bVar.dCS = i + 1;
                b bVar2 = this.fFh;
                i2 = this.fFh.dCS;
                bVar2.st((int) (30.0f + ((50.0f * i2) / this.fFn)));
            }
        }
        this.fFo.countDown();
    }
}
