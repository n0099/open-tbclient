package com.bytedance.sdk.openadsdk.b;

import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.j.f;
import com.bytedance.sdk.openadsdk.j.g;
import com.bytedance.sdk.openadsdk.utils.l;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
/* loaded from: classes6.dex */
public abstract class b implements com.bytedance.sdk.openadsdk.b.a {
    protected abstract void a(List<File> list);

    protected abstract boolean a(long j, int i);

    protected abstract boolean a(File file, long j, int i);

    @Override // com.bytedance.sdk.openadsdk.b.a
    public void a(File file) throws IOException {
        final f fVar = new f(new a(file), 1, 2);
        e.a().execute(new g(fVar.a()) { // from class: com.bytedance.sdk.openadsdk.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                fVar.run();
            }
        });
    }

    public File a(String str, File file) throws IOException {
        return b(str, file);
    }

    private File b(String str, File file) {
        List<File> a2 = l.a(file);
        if (a2 != null && a2.size() > 0) {
            for (File file2 : a2) {
                if (file2 != null && str.equals(file2.getName())) {
                    u.f("TTFullScreenVideoAdImpl", "datastoreGet .........get cache video....");
                    return file2;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(File file) throws IOException {
        try {
            l.b(file);
        } catch (Throwable th) {
            u.a("LruDiskFile", "setLastModifiedNowError", th);
        }
        List<File> a2 = l.a(file.getParentFile());
        u.f("splashLoadAd", "LruDiskFile touchInBackground files.size() " + a2.size());
        a(a2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long b(List<File> list) {
        long j = 0;
        Iterator<File> it = list.iterator();
        while (true) {
            long j2 = j;
            if (it.hasNext()) {
                j = it.next().length() + j2;
            } else {
                return j2;
            }
        }
    }

    /* loaded from: classes6.dex */
    private class a implements Callable<Void> {
        private final File b;

        private a(File file) {
            this.b = file;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            b.this.b(this.b);
            return null;
        }
    }
}
