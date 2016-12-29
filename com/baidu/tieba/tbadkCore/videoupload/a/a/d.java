package com.baidu.tieba.tbadkCore.videoupload.a.a;

import com.baidu.adp.lib.util.StringUtils;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ b fjo;
    private final /* synthetic */ RandomAccessFile fjp;
    private final /* synthetic */ ArrayList fjq;
    private final /* synthetic */ int fjr;
    private final /* synthetic */ int fjs;
    private final /* synthetic */ String fjt;
    private final /* synthetic */ int fju;
    private final /* synthetic */ CountDownLatch fjv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, RandomAccessFile randomAccessFile, ArrayList arrayList, int i, int i2, String str, int i3, CountDownLatch countDownLatch) {
        this.fjo = bVar;
        this.fjp = randomAccessFile;
        this.fjq = arrayList;
        this.fjr = i;
        this.fjs = i2;
        this.fjt = str;
        this.fju = i3;
        this.fjv = countDownLatch;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        f fVar;
        f fVar2;
        f fVar3;
        f a = this.fjo.a(this.fjp, ((Integer) this.fjq.get(this.fjr)).intValue(), this.fjs, this.fjt);
        if (a != null) {
            if (a.errorNo != 0) {
                fVar2 = this.fjo.fjm;
                fVar2.errorNo = a.errorNo;
                fVar3 = this.fjo.fjm;
                fVar3.errorMessage = a.errorMessage;
            }
            if (!StringUtils.isNull(a.videoUrl)) {
                fVar = this.fjo.fjm;
                fVar.videoUrl = a.videoUrl;
            }
            synchronized (this.fjo) {
                b bVar = this.fjo;
                i = bVar.dfQ;
                bVar.dfQ = i + 1;
                b bVar2 = this.fjo;
                i2 = this.fjo.dfQ;
                bVar2.rw((int) (30.0f + ((50.0f * i2) / this.fju)));
            }
        }
        this.fjv.countDown();
    }
}
