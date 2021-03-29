package com.bytedance.sdk.openadsdk.b;

import com.bytedance.sdk.openadsdk.utils.u;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public class c extends b {

    /* renamed from: a  reason: collision with root package name */
    public int f27530a;

    /* renamed from: b  reason: collision with root package name */
    public int f27531b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f27532c;

    public c(int i, int i2) {
        this.f27530a = 15;
        this.f27531b = 3;
        if (i > 0) {
            this.f27530a = i;
            this.f27531b = i2;
            return;
        }
        throw new IllegalArgumentException("Max count must be positive number!");
    }

    private void c(List<File> list) {
        long b2 = b(list);
        int size = list.size();
        if (a(b2, size)) {
            return;
        }
        for (File file : list) {
            long length = file.length();
            if (file.delete()) {
                size--;
                b2 -= length;
                u.c("TotalCountLruDiskFile", "Cache file " + file + " is deleted because it exceeds cache limit");
            } else {
                u.c("TotalCountLruDiskFile", "Error deleting file " + file + " for trimming cache");
            }
            if (a(file, b2, size)) {
                return;
            }
        }
    }

    private void d(List<File> list) {
        if (list != null) {
            try {
                if (list.size() == 0) {
                    return;
                }
                long b2 = b(list);
                int size = list.size();
                boolean a2 = a(b2, size);
                if (a2) {
                    u.c("splashLoadAd", "不满足删除条件，不执行删除操作(true)" + a2);
                    return;
                }
                TreeMap treeMap = new TreeMap();
                for (File file : list) {
                    treeMap.put(Long.valueOf(file.lastModified()), file);
                }
                for (Map.Entry entry : treeMap.entrySet()) {
                    if (entry != null && !a2) {
                        u.f("splashLoadAd", "LRUDeleteFile deleting fileTime " + ((Long) entry.getKey()).longValue());
                        File file2 = (File) entry.getValue();
                        long length = file2.length();
                        if (file2.delete()) {
                            size--;
                            b2 -= length;
                            u.c("splashLoadAd", "删除 一个 Cache file 当前总个数：" + size);
                        } else {
                            u.f("splashLoadAd", "Error deleting file " + file2 + " for trimming cache");
                        }
                        if (a(file2, b2, size)) {
                            u.c("splashLoadAd", "停止删除 当前总个数 totalCount：" + size + " 最大值存储上限个数 maxCount " + this.f27530a + " 最小个数 " + this.f27531b);
                            return;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.b.b
    public boolean a(long j, int i) {
        return i <= this.f27530a;
    }

    @Override // com.bytedance.sdk.openadsdk.b.b
    public boolean a(File file, long j, int i) {
        return i <= this.f27531b;
    }

    @Override // com.bytedance.sdk.openadsdk.b.b
    public void a(List<File> list) {
        if (this.f27532c) {
            d(list);
            this.f27532c = false;
            return;
        }
        c(list);
    }

    public c(int i, int i2, boolean z) {
        this.f27530a = 15;
        this.f27531b = 3;
        if (i > 0) {
            this.f27530a = i;
            this.f27531b = i2;
            this.f27532c = z;
            return;
        }
        throw new IllegalArgumentException("Max count must be positive number!");
    }
}
