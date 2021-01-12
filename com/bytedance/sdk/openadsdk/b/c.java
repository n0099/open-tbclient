package com.bytedance.sdk.openadsdk.b;

import com.bytedance.sdk.openadsdk.utils.u;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes4.dex */
public class c extends b {

    /* renamed from: a  reason: collision with root package name */
    private int f6212a;

    /* renamed from: b  reason: collision with root package name */
    private int f6213b;
    private volatile boolean c;

    public c(int i, int i2) {
        this.f6212a = 15;
        this.f6213b = 3;
        if (i <= 0) {
            throw new IllegalArgumentException("Max count must be positive number!");
        }
        this.f6212a = i;
        this.f6213b = i2;
    }

    public c(int i, int i2, boolean z) {
        this.f6212a = 15;
        this.f6213b = 3;
        if (i <= 0) {
            throw new IllegalArgumentException("Max count must be positive number!");
        }
        this.f6212a = i;
        this.f6213b = i2;
        this.c = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.b.b
    public boolean a(long j, int i) {
        return i <= this.f6212a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.b.b
    public boolean a(File file, long j, int i) {
        return i <= this.f6213b;
    }

    @Override // com.bytedance.sdk.openadsdk.b.b
    protected void a(List<File> list) {
        if (this.c) {
            d(list);
            this.c = false;
            return;
        }
        c(list);
    }

    private void c(List<File> list) {
        long b2 = b(list);
        int size = list.size();
        if (!a(b2, size)) {
            int i = size;
            for (File file : list) {
                long length = file.length();
                if (file.delete()) {
                    i--;
                    b2 -= length;
                    u.c("TotalCountLruDiskFile", "Cache file " + file + " is deleted because it exceeds cache limit");
                } else {
                    u.c("TotalCountLruDiskFile", "Error deleting file " + file + " for trimming cache");
                }
                if (a(file, b2, i)) {
                    return;
                }
            }
        }
    }

    private void d(List<File> list) {
        int i;
        int i2;
        if (list != null) {
            try {
                if (list.size() != 0) {
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
                        if (entry != null) {
                            if (a2) {
                                i = size;
                            } else {
                                u.f("splashLoadAd", "LRUDeleteFile deleting fileTime " + ((Long) entry.getKey()).longValue());
                                File file2 = (File) entry.getValue();
                                long length = file2.length();
                                if (file2.delete()) {
                                    i2 = size - 1;
                                    b2 -= length;
                                    u.c("splashLoadAd", "删除 一个 Cache file 当前总个数：" + i2);
                                } else {
                                    u.f("splashLoadAd", "Error deleting file " + file2 + " for trimming cache");
                                    i2 = size;
                                }
                                if (a(file2, b2, i2)) {
                                    u.c("splashLoadAd", "停止删除 当前总个数 totalCount：" + i2 + " 最大值存储上限个数 maxCount " + this.f6212a + " 最小个数 " + this.f6213b);
                                    return;
                                }
                                i = i2;
                            }
                            size = i;
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
    }
}
