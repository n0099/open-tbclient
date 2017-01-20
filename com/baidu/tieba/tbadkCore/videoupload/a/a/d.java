package com.baidu.tieba.tbadkCore.videoupload.a.a;

import com.baidu.adp.lib.util.StringUtils;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ b fsA;
    private final /* synthetic */ RandomAccessFile fsB;
    private final /* synthetic */ ArrayList fsC;
    private final /* synthetic */ int fsD;
    private final /* synthetic */ int fsE;
    private final /* synthetic */ String fsF;
    private final /* synthetic */ int fsG;
    private final /* synthetic */ CountDownLatch fsH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, RandomAccessFile randomAccessFile, ArrayList arrayList, int i, int i2, String str, int i3, CountDownLatch countDownLatch) {
        this.fsA = bVar;
        this.fsB = randomAccessFile;
        this.fsC = arrayList;
        this.fsD = i;
        this.fsE = i2;
        this.fsF = str;
        this.fsG = i3;
        this.fsH = countDownLatch;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        f fVar;
        f fVar2;
        f fVar3;
        f a = this.fsA.a(this.fsB, ((Integer) this.fsC.get(this.fsD)).intValue(), this.fsE, this.fsF);
        if (a != null) {
            if (a.errorNo != 0) {
                fVar2 = this.fsA.fsy;
                fVar2.errorNo = a.errorNo;
                fVar3 = this.fsA.fsy;
                fVar3.errorMessage = a.errorMessage;
            }
            if (!StringUtils.isNull(a.videoUrl)) {
                fVar = this.fsA.fsy;
                fVar.videoUrl = a.videoUrl;
            }
            synchronized (this.fsA) {
                b bVar = this.fsA;
                i = bVar.dmZ;
                bVar.dmZ = i + 1;
                b bVar2 = this.fsA;
                i2 = this.fsA.dmZ;
                bVar2.sh((int) (30.0f + ((50.0f * i2) / this.fsG)));
            }
        }
        this.fsH.countDown();
    }
}
