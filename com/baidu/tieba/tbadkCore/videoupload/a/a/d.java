package com.baidu.tieba.tbadkCore.videoupload.a.a;

import com.baidu.adp.lib.util.StringUtils;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ b fEY;
    private final /* synthetic */ RandomAccessFile fEZ;
    private final /* synthetic */ ArrayList fFa;
    private final /* synthetic */ int fFb;
    private final /* synthetic */ int fFc;
    private final /* synthetic */ String fFd;
    private final /* synthetic */ int fFe;
    private final /* synthetic */ CountDownLatch fFf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, RandomAccessFile randomAccessFile, ArrayList arrayList, int i, int i2, String str, int i3, CountDownLatch countDownLatch) {
        this.fEY = bVar;
        this.fEZ = randomAccessFile;
        this.fFa = arrayList;
        this.fFb = i;
        this.fFc = i2;
        this.fFd = str;
        this.fFe = i3;
        this.fFf = countDownLatch;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        f fVar;
        f fVar2;
        f fVar3;
        f a = this.fEY.a(this.fEZ, ((Integer) this.fFa.get(this.fFb)).intValue(), this.fFc, this.fFd);
        if (a != null) {
            if (a.errorNo != 0) {
                fVar2 = this.fEY.fEW;
                fVar2.errorNo = a.errorNo;
                fVar3 = this.fEY.fEW;
                fVar3.errorMessage = a.errorMessage;
            }
            if (!StringUtils.isNull(a.videoUrl)) {
                fVar = this.fEY.fEW;
                fVar.videoUrl = a.videoUrl;
            }
            synchronized (this.fEY) {
                b bVar = this.fEY;
                i = bVar.dpH;
                bVar.dpH = i + 1;
                b bVar2 = this.fEY;
                i2 = this.fEY.dpH;
                bVar2.sy((int) (30.0f + ((50.0f * i2) / this.fFe)));
            }
        }
        this.fFf.countDown();
    }
}
