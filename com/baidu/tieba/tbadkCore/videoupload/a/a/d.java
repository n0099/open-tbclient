package com.baidu.tieba.tbadkCore.videoupload.a.a;

import com.baidu.adp.lib.util.StringUtils;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ b fPd;
    private final /* synthetic */ RandomAccessFile fPe;
    private final /* synthetic */ ArrayList fPf;
    private final /* synthetic */ int fPg;
    private final /* synthetic */ int fPh;
    private final /* synthetic */ String fPi;
    private final /* synthetic */ int fPj;
    private final /* synthetic */ CountDownLatch fPk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, RandomAccessFile randomAccessFile, ArrayList arrayList, int i, int i2, String str, int i3, CountDownLatch countDownLatch) {
        this.fPd = bVar;
        this.fPe = randomAccessFile;
        this.fPf = arrayList;
        this.fPg = i;
        this.fPh = i2;
        this.fPi = str;
        this.fPj = i3;
        this.fPk = countDownLatch;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        f fVar;
        f fVar2;
        f fVar3;
        f a = this.fPd.a(this.fPe, ((Integer) this.fPf.get(this.fPg)).intValue(), this.fPh, this.fPi);
        if (a != null) {
            if (a.errorNo != 0) {
                fVar2 = this.fPd.fPb;
                fVar2.errorNo = a.errorNo;
                fVar3 = this.fPd.fPb;
                fVar3.errorMessage = a.errorMessage;
            }
            if (!StringUtils.isNull(a.videoUrl)) {
                fVar = this.fPd.fPb;
                fVar.videoUrl = a.videoUrl;
            }
            synchronized (this.fPd) {
                b bVar = this.fPd;
                i = bVar.dxC;
                bVar.dxC = i + 1;
                b bVar2 = this.fPd;
                i2 = this.fPd.dxC;
                bVar2.sR((int) (30.0f + ((50.0f * i2) / this.fPj)));
            }
        }
        this.fPk.countDown();
    }
}
