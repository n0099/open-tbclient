package com.bytedance.sdk.openadsdk.b;

import com.bytedance.sdk.openadsdk.utils.u;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public class d extends b {

    /* renamed from: a  reason: collision with root package name */
    protected long f4193a;
    private volatile boolean b;

    public d() {
        this.f4193a = 83886080L;
        this.b = false;
    }

    public d(long j, boolean z) {
        this.f4193a = j;
        if (j <= 0) {
            this.f4193a = 83886080L;
        }
        this.b = z;
    }

    @Override // com.bytedance.sdk.openadsdk.b.b
    protected boolean a(long j, int i) {
        return j < this.f4193a;
    }

    @Override // com.bytedance.sdk.openadsdk.b.b
    protected boolean a(File file, long j, int i) {
        u.f("splashLoadAd", "缓存的最大内存 maxSize " + this.f4193a);
        return j < this.f4193a / 2;
    }

    @Override // com.bytedance.sdk.openadsdk.b.b
    public File a(String str, File file) throws IOException {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.b.b
    public void a(List<File> list) {
        if (this.b) {
            d(list);
        } else {
            c(list);
        }
    }

    private void c(List<File> list) {
        if (list != null && list.size() != 0) {
            long b = b(list);
            u.c("TotalSizeLruDiskUsage", "当前缓存文件的总size：" + ((b / 1024) / 1024) + "MB");
            int size = list.size();
            boolean a2 = a(b, size);
            if (a2) {
                u.c("TotalSizeLruDiskUsage", "不满足删除条件，不执行删除操作(true)" + a2);
            } else {
                u.c("TotalSizeLruDiskUsage", "满足删除条件，开始执行删除操作(false)" + a2);
            }
            Iterator<File> it = list.iterator();
            while (true) {
                int i = size;
                if (it.hasNext()) {
                    File next = it.next();
                    if (!a2) {
                        u.c("TotalSizeLruDiskUsage", "满足删除条件开始删除文件......................");
                        long length = next.length();
                        if (next.delete()) {
                            i--;
                            b -= length;
                            u.c("TotalSizeLruDiskUsage", "删除 一个 Cache file 当前总大小totalSize：" + ((b / 1024) / 1024) + "MB");
                        } else {
                            u.f("TotalSizeLruDiskUsage", "Error deleting file " + next + " for trimming cache");
                        }
                        boolean a3 = a(next, b, i);
                        if (a3) {
                            u.c("TotalSizeLruDiskUsage", "当前总大小totalSize：" + ((b / 1024) / 1024) + "MB，最大值存储上限maxSize=" + ((this.f4193a / 1024) / 1024) + "MB，当前文件的总大小totalSize已小于等于maxSize一半，停止删除操作：minStopDeleteCondition=" + a3);
                            return;
                        }
                    }
                    size = i;
                } else {
                    return;
                }
            }
        }
    }

    private void d(List<File> list) {
        int i;
        if (list != null) {
            try {
                if (list.size() != 0) {
                    long b = b(list);
                    int size = list.size();
                    boolean a2 = a(b, size);
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
                                u.f("splashLoadAd", "lruDeleteFile deleting fileTime " + ((Long) entry.getKey()).longValue());
                                File file2 = (File) entry.getValue();
                                long length = file2.length();
                                if (file2.delete()) {
                                    i = size - 1;
                                    b -= length;
                                    u.c("splashLoadAd", "删除 一个 Cache file 当前总大小totalSize：" + ((((float) b) / 1024.0f) / 1024.0f) + "MB");
                                } else {
                                    u.f("splashLoadAd", "Error deleting file " + file2 + " for trimming cache");
                                    i = size;
                                }
                                boolean a3 = a(b);
                                if (a3) {
                                    u.c("splashLoadAd", "当前总大小totalSize：" + ((((float) b) / 1024.0f) / 1024.0f) + "MB，最大值存储上限maxSize=" + ((((float) this.f4193a) / 1024.0f) / 1024.0f) + "MB，当前文件的总大小totalSize已小于等于maxSize的80%，停止删除操作：minStopDeleteCondition=" + a3);
                                    return;
                                }
                            }
                            size = i;
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    protected boolean a(long j) {
        u.f("splashLoadAd", "缓存的最大内存 maxSize " + this.f4193a + " 最小内存 minSize 18874368");
        return j <= 18874368;
    }
}
