package com.baidu.tieba.tbadkCore.videoupload.a.a;

import com.baidu.adp.lib.util.StringUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class b extends a {
    private int hTR;
    private volatile d kjM;
    private volatile boolean mCancelled;

    static /* synthetic */ int b(b bVar) {
        int i = bVar.hTR;
        bVar.hTR = i + 1;
        return i;
    }

    public b(String str, int i, int i2, long j, String str2) {
        super(str, i, i2, j, str2);
        this.kjM = new d();
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.a.a
    public d d(final ArrayList<Integer> arrayList, final String str, final int i) {
        final int size = arrayList.size();
        final CountDownLatch countDownLatch = new CountDownLatch(size);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 2L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadFactory() { // from class: com.baidu.tieba.tbadkCore.videoupload.a.a.b.1
            private int kjN = 0;

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setName("VideoUploadThread@" + this.kjN);
                this.kjN++;
                return thread;
            }
        });
        try {
            final RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
            for (final int i2 = 0; i2 < size; i2++) {
                threadPoolExecutor.execute(new Runnable() { // from class: com.baidu.tieba.tbadkCore.videoupload.a.a.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        d a = b.this.a(randomAccessFile, ((Integer) arrayList.get(i2)).intValue(), i, str);
                        if (a != null) {
                            if (a.errorNo != 0) {
                                b.this.kjM.errorNo = a.errorNo;
                                b.this.kjM.errorMessage = a.errorMessage;
                            }
                            if (!StringUtils.isNull(a.videoUrl)) {
                                b.this.kjM.videoUrl = a.videoUrl;
                            }
                            synchronized (b.this) {
                                b.b(b.this);
                                b.this.notifyProgress((int) (30.0f + ((50.0f * b.this.hTR) / size)));
                            }
                        }
                        countDownLatch.countDown();
                    }
                });
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
            return this.kjM;
        } catch (FileNotFoundException e3) {
            return this.kjM;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.a.a
    public void cancel() {
        this.mCancelled = true;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.a.a
    public boolean isCancelled() {
        return (!this.mCancelled && this.kjM.errorNo == 0 && StringUtils.isNull(this.kjM.videoUrl)) ? false : true;
    }
}
