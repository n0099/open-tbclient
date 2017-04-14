package com.baidu.tieba.tbadkCore.videoupload.a.a;

import com.baidu.adp.lib.util.StringUtils;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ b fyH;
    private final /* synthetic */ RandomAccessFile fyI;
    private final /* synthetic */ ArrayList fyJ;
    private final /* synthetic */ int fyK;
    private final /* synthetic */ int fyL;
    private final /* synthetic */ String fyM;
    private final /* synthetic */ int fyN;
    private final /* synthetic */ CountDownLatch fyO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, RandomAccessFile randomAccessFile, ArrayList arrayList, int i, int i2, String str, int i3, CountDownLatch countDownLatch) {
        this.fyH = bVar;
        this.fyI = randomAccessFile;
        this.fyJ = arrayList;
        this.fyK = i;
        this.fyL = i2;
        this.fyM = str;
        this.fyN = i3;
        this.fyO = countDownLatch;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        f fVar;
        f fVar2;
        f fVar3;
        f a = this.fyH.a(this.fyI, ((Integer) this.fyJ.get(this.fyK)).intValue(), this.fyL, this.fyM);
        if (a != null) {
            if (a.errorNo != 0) {
                fVar2 = this.fyH.fyF;
                fVar2.errorNo = a.errorNo;
                fVar3 = this.fyH.fyF;
                fVar3.errorMessage = a.errorMessage;
            }
            if (!StringUtils.isNull(a.videoUrl)) {
                fVar = this.fyH.fyF;
                fVar.videoUrl = a.videoUrl;
            }
            synchronized (this.fyH) {
                b bVar = this.fyH;
                i = bVar.dnR;
                bVar.dnR = i + 1;
                b bVar2 = this.fyH;
                i2 = this.fyH.dnR;
                bVar2.se((int) (30.0f + ((50.0f * i2) / this.fyN)));
            }
        }
        this.fyO.countDown();
    }
}
