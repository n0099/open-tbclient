package com.baidu.tieba.tbadkCore.videoupload.a.a;

import com.baidu.adp.lib.util.StringUtils;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ b fwX;
    private final /* synthetic */ RandomAccessFile fwY;
    private final /* synthetic */ ArrayList fwZ;
    private final /* synthetic */ int fxa;
    private final /* synthetic */ int fxb;
    private final /* synthetic */ String fxc;
    private final /* synthetic */ int fxd;
    private final /* synthetic */ CountDownLatch fxe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, RandomAccessFile randomAccessFile, ArrayList arrayList, int i, int i2, String str, int i3, CountDownLatch countDownLatch) {
        this.fwX = bVar;
        this.fwY = randomAccessFile;
        this.fwZ = arrayList;
        this.fxa = i;
        this.fxb = i2;
        this.fxc = str;
        this.fxd = i3;
        this.fxe = countDownLatch;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        f fVar;
        f fVar2;
        f fVar3;
        f a = this.fwX.a(this.fwY, ((Integer) this.fwZ.get(this.fxa)).intValue(), this.fxb, this.fxc);
        if (a != null) {
            if (a.errorNo != 0) {
                fVar2 = this.fwX.fwV;
                fVar2.errorNo = a.errorNo;
                fVar3 = this.fwX.fwV;
                fVar3.errorMessage = a.errorMessage;
            }
            if (!StringUtils.isNull(a.videoUrl)) {
                fVar = this.fwX.fwV;
                fVar.videoUrl = a.videoUrl;
            }
            synchronized (this.fwX) {
                b bVar = this.fwX;
                i = bVar.dpt;
                bVar.dpt = i + 1;
                b bVar2 = this.fwX;
                i2 = this.fwX.dpt;
                bVar2.sg((int) (30.0f + ((50.0f * i2) / this.fxd)));
            }
        }
        this.fxe.countDown();
    }
}
