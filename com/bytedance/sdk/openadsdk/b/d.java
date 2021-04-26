package com.bytedance.sdk.openadsdk.b;

import com.bytedance.sdk.openadsdk.utils.u;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes5.dex */
public class d extends b {

    /* renamed from: a  reason: collision with root package name */
    public long f28050a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f28051b;

    public d() {
        this.f28050a = 83886080L;
        this.f28051b = false;
    }

    private void c(List<File> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        long b2 = b(list);
        u.c("TotalSizeLruDiskUsage", "当前缓存文件的总size：" + ((b2 / 1024) / 1024) + "MB");
        int size = list.size();
        boolean a2 = a(b2, size);
        if (a2) {
            u.c("TotalSizeLruDiskUsage", "不满足删除条件，不执行删除操作(true)" + a2);
        } else {
            u.c("TotalSizeLruDiskUsage", "满足删除条件，开始执行删除操作(false)" + a2);
        }
        for (File file : list) {
            if (!a2) {
                u.c("TotalSizeLruDiskUsage", "满足删除条件开始删除文件......................");
                long length = file.length();
                if (file.delete()) {
                    size--;
                    b2 -= length;
                    u.c("TotalSizeLruDiskUsage", "删除 一个 Cache file 当前总大小totalSize：" + ((b2 / 1024) / 1024) + "MB");
                } else {
                    u.f("TotalSizeLruDiskUsage", "Error deleting file " + file + " for trimming cache");
                }
                boolean a3 = a(file, b2, size);
                if (a3) {
                    u.c("TotalSizeLruDiskUsage", "当前总大小totalSize：" + ((b2 / 1024) / 1024) + "MB，最大值存储上限maxSize=" + ((this.f28050a / 1024) / 1024) + "MB，当前文件的总大小totalSize已小于等于maxSize一半，停止删除操作：minStopDeleteCondition=" + a3);
                    return;
                }
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
                boolean a2 = a(b2, list.size());
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
                        long longValue = ((Long) entry.getKey()).longValue();
                        u.f("splashLoadAd", "lruDeleteFile deleting fileTime " + longValue);
                        File file2 = (File) entry.getValue();
                        long length = file2.length();
                        if (file2.delete()) {
                            b2 -= length;
                            u.c("splashLoadAd", "删除 一个 Cache file 当前总大小totalSize：" + ((((float) b2) / 1024.0f) / 1024.0f) + "MB");
                        } else {
                            u.f("splashLoadAd", "Error deleting file " + file2 + " for trimming cache");
                        }
                        boolean a3 = a(b2);
                        if (a3) {
                            u.c("splashLoadAd", "当前总大小totalSize：" + ((((float) b2) / 1024.0f) / 1024.0f) + "MB，最大值存储上限maxSize=" + ((((float) this.f28050a) / 1024.0f) / 1024.0f) + "MB，当前文件的总大小totalSize已小于等于maxSize的80%，停止删除操作：minStopDeleteCondition=" + a3);
                            return;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.b.b
    public File a(String str, File file) throws IOException {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.b.b
    public boolean a(long j, int i2) {
        return j < this.f28050a;
    }

    @Override // com.bytedance.sdk.openadsdk.b.b
    public boolean a(File file, long j, int i2) {
        u.f("splashLoadAd", "缓存的最大内存 maxSize " + this.f28050a);
        return j < this.f28050a / 2;
    }

    public d(long j, boolean z) {
        this.f28050a = j;
        if (j <= 0) {
            this.f28050a = 83886080L;
        }
        this.f28051b = z;
    }

    @Override // com.bytedance.sdk.openadsdk.b.b
    public void a(List<File> list) {
        if (this.f28051b) {
            d(list);
        } else {
            c(list);
        }
    }

    public boolean a(long j) {
        u.f("splashLoadAd", "缓存的最大内存 maxSize " + this.f28050a + " 最小内存 minSize 18874368");
        return j <= 18874368;
    }
}
