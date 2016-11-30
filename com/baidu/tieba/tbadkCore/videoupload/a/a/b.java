package com.baidu.tieba.tbadkCore.videoupload.a.a;

import com.baidu.adp.lib.util.StringUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class b extends a {
    private int dCS;
    private volatile boolean fFd;
    private volatile f fFf;

    public b(String str, int i, int i2, long j, String str2) {
        super(str, i, i2, j, str2);
        this.fFf = new f();
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.a.a
    public f b(ArrayList<Integer> arrayList, String str, int i) {
        int size = arrayList.size();
        CountDownLatch countDownLatch = new CountDownLatch(size);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 2L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new c(this));
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
            for (int i2 = 0; i2 < size; i2++) {
                threadPoolExecutor.execute(new d(this, randomAccessFile, arrayList, i2, i, str, size, countDownLatch));
            }
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadPoolExecutor.shutdown();
            try {
                randomAccessFile.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return this.fFf;
        } catch (FileNotFoundException e3) {
            return this.fFf;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.a.a
    public void cancel() {
        this.fFd = true;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.a.a
    public boolean isCancelled() {
        return (!this.fFd && this.fFf.errorNo == 0 && StringUtils.isNull(this.fFf.videoUrl)) ? false : true;
    }
}
