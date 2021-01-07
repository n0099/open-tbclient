package com.baidu.tieba.newfaceshop;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
/* loaded from: classes9.dex */
public class a {
    private static volatile a lwm;
    private ThreadPoolExecutor mThreadPool;

    public static a dka() {
        if (lwm == null) {
            synchronized (a.class) {
                if (lwm == null) {
                    lwm = new a();
                }
            }
        }
        return lwm;
    }

    private a() {
        int numCores = getNumCores();
        numCores = numCores <= 0 ? 1 : numCores;
        int i = numCores <= 4 ? numCores : 4;
        this.mThreadPool = new ThreadPoolExecutor(i, i, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.mThreadPool.allowCoreThreadTimeOut(true);
    }

    public void execute(Runnable runnable) {
        this.mThreadPool.execute(runnable);
    }

    private int getNumCores() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new C0821a()).length;
        } catch (Exception e) {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.newfaceshop.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0821a implements FileFilter {
        C0821a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }
}
