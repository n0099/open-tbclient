package com.baidu.tieba.tbadkCore.videoupload.a.a;

import com.baidu.adp.lib.util.StringUtils;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ b fxg;
    private final /* synthetic */ RandomAccessFile fxh;
    private final /* synthetic */ ArrayList fxi;
    private final /* synthetic */ int fxj;
    private final /* synthetic */ int fxl;
    private final /* synthetic */ String fxm;
    private final /* synthetic */ int fxn;
    private final /* synthetic */ CountDownLatch fxo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, RandomAccessFile randomAccessFile, ArrayList arrayList, int i, int i2, String str, int i3, CountDownLatch countDownLatch) {
        this.fxg = bVar;
        this.fxh = randomAccessFile;
        this.fxi = arrayList;
        this.fxj = i;
        this.fxl = i2;
        this.fxm = str;
        this.fxn = i3;
        this.fxo = countDownLatch;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        f fVar;
        f fVar2;
        f fVar3;
        f a = this.fxg.a(this.fxh, ((Integer) this.fxi.get(this.fxj)).intValue(), this.fxl, this.fxm);
        if (a != null) {
            if (a.errorNo != 0) {
                fVar2 = this.fxg.fxe;
                fVar2.errorNo = a.errorNo;
                fVar3 = this.fxg.fxe;
                fVar3.errorMessage = a.errorMessage;
            }
            if (!StringUtils.isNull(a.videoUrl)) {
                fVar = this.fxg.fxe;
                fVar.videoUrl = a.videoUrl;
            }
            synchronized (this.fxg) {
                b bVar = this.fxg;
                i = bVar.dkn;
                bVar.dkn = i + 1;
                b bVar2 = this.fxg;
                i2 = this.fxg.dkn;
                bVar2.sc((int) (30.0f + ((50.0f * i2) / this.fxn)));
            }
        }
        this.fxo.countDown();
    }
}
