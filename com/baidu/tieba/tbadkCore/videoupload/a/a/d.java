package com.baidu.tieba.tbadkCore.videoupload.a.a;

import com.baidu.adp.lib.util.StringUtils;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ b fAX;
    private final /* synthetic */ RandomAccessFile fAY;
    private final /* synthetic */ ArrayList fAZ;
    private final /* synthetic */ int fBa;
    private final /* synthetic */ int fBb;
    private final /* synthetic */ String fBc;
    private final /* synthetic */ int fBd;
    private final /* synthetic */ CountDownLatch fBe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, RandomAccessFile randomAccessFile, ArrayList arrayList, int i, int i2, String str, int i3, CountDownLatch countDownLatch) {
        this.fAX = bVar;
        this.fAY = randomAccessFile;
        this.fAZ = arrayList;
        this.fBa = i;
        this.fBb = i2;
        this.fBc = str;
        this.fBd = i3;
        this.fBe = countDownLatch;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        f fVar;
        f fVar2;
        f fVar3;
        f a = this.fAX.a(this.fAY, ((Integer) this.fAZ.get(this.fBa)).intValue(), this.fBb, this.fBc);
        if (a != null) {
            if (a.errorNo != 0) {
                fVar2 = this.fAX.fAV;
                fVar2.errorNo = a.errorNo;
                fVar3 = this.fAX.fAV;
                fVar3.errorMessage = a.errorMessage;
            }
            if (!StringUtils.isNull(a.videoUrl)) {
                fVar = this.fAX.fAV;
                fVar.videoUrl = a.videoUrl;
            }
            synchronized (this.fAX) {
                b bVar = this.fAX;
                i = bVar.dqj;
                bVar.dqj = i + 1;
                b bVar2 = this.fAX;
                i2 = this.fAX.dqj;
                bVar2.sk((int) (30.0f + ((50.0f * i2) / this.fBd)));
            }
        }
        this.fBe.countDown();
    }
}
