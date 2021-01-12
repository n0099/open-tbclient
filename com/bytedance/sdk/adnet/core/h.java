package com.bytedance.sdk.adnet.core;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.baidubce.services.bos.BosClientConfiguration;
import com.bytedance.sdk.adnet.e.b;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class h implements com.bytedance.sdk.adnet.e.b {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, a> f6027a;

    /* renamed from: b  reason: collision with root package name */
    private long f6028b;
    private final File c;
    private final int d;

    public h(File file, int i) {
        this.f6027a = new LinkedHashMap(16, 0.75f, true);
        this.f6028b = 0L;
        this.c = file;
        this.d = i;
    }

    public h(File file) {
        this(file, BosClientConfiguration.DEFAULT_STREAM_BUFFER_SIZE);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [171=4, 172=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0073 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:64:0x0009 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.bytedance.sdk.adnet.e.b$a */
    /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: com.bytedance.sdk.adnet.e.b$a */
    /* JADX DEBUG: Multi-variable search result rejected for r0v16, resolved type: com.bytedance.sdk.adnet.e.b$a */
    /* JADX DEBUG: Multi-variable search result rejected for r0v17, resolved type: com.bytedance.sdk.adnet.e.b$a */
    /* JADX DEBUG: Multi-variable search result rejected for r0v18, resolved type: com.bytedance.sdk.adnet.e.b$a */
    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.bytedance.sdk.adnet.e.b$a */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.adnet.e.b
    public synchronized b.a XO(String str) {
        b bVar;
        b.a aVar;
        Throwable th = null;
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                aVar = 0;
            } else {
                a aVar2 = this.f6027a.get(str);
                if (aVar2 == null) {
                    aVar = 0;
                } else {
                    File c = c(str);
                    try {
                        bVar = new b(new BufferedInputStream(a(c)), c.length());
                    } catch (Throwable th2) {
                        th = th2;
                        bVar = null;
                    }
                    try {
                        a c2 = a.c(bVar);
                        if (TextUtils.equals(str, c2.f6030b)) {
                            aVar = aVar2.aj(a(bVar, bVar.a()));
                            bVar.close();
                            if (bVar != null) {
                                try {
                                    bVar.close();
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            }
                        } else {
                            r.b("%s: key=%s, found=%s", c.getAbsolutePath(), str, c2.f6030b);
                            e(str);
                            bVar.close();
                            if (bVar != null) {
                                try {
                                    bVar.close();
                                } catch (Throwable th4) {
                                }
                            }
                            aVar = 0;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        r.b("%s: %s", c.getAbsolutePath(), th.toString());
                        b(str);
                        if (bVar != null) {
                            try {
                                bVar.close();
                            } catch (Throwable th6) {
                            }
                        }
                        aVar = th;
                        return aVar;
                    }
                }
            }
        }
        return aVar;
    }

    @Override // com.bytedance.sdk.adnet.e.b
    public synchronized void a() {
        if (!this.c.exists()) {
            if (!this.c.mkdirs()) {
                r.c("Unable to create cache dir %s", this.c.getAbsolutePath());
            }
        } else {
            File[] listFiles = this.c.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    long length = file.length();
                    b bVar = new b(new BufferedInputStream(a(file)), length);
                    a c = a.c(bVar);
                    c.f6029a = length;
                    a(c.f6030b, c);
                    bVar.close();
                }
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @Override // com.bytedance.sdk.adnet.e.b
    public synchronized void a(java.lang.String r7, com.bytedance.sdk.adnet.e.b.a r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.f6028b     // Catch: java.lang.Throwable -> L6f
            byte[] r2 = r8.f6062b     // Catch: java.lang.Throwable -> L6f
            int r2 = r2.length     // Catch: java.lang.Throwable -> L6f
            long r2 = (long) r2     // Catch: java.lang.Throwable -> L6f
            long r0 = r0 + r2
            int r2 = r6.d     // Catch: java.lang.Throwable -> L6f
            long r2 = (long) r2     // Catch: java.lang.Throwable -> L6f
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L20
            byte[] r0 = r8.f6062b     // Catch: java.lang.Throwable -> L6f
            int r0 = r0.length     // Catch: java.lang.Throwable -> L6f
            float r0 = (float) r0     // Catch: java.lang.Throwable -> L6f
            int r1 = r6.d     // Catch: java.lang.Throwable -> L6f
            float r1 = (float) r1
            r2 = 1063675494(0x3f666666, float:0.9)
            float r1 = r1 * r2
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L20
        L1e:
            monitor-exit(r6)
            return
        L20:
            java.io.File r2 = r6.c(r7)     // Catch: java.lang.Throwable -> L6f
            r1 = 0
            java.io.BufferedOutputStream r0 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L9c
            java.io.OutputStream r3 = r6.am(r2)     // Catch: java.lang.Throwable -> L9c
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L9c
            com.bytedance.sdk.adnet.core.h$a r1 = new com.bytedance.sdk.adnet.core.h$a     // Catch: java.lang.Throwable -> L52
            r1.<init>(r7, r8)     // Catch: java.lang.Throwable -> L52
            boolean r3 = r1.a(r0)     // Catch: java.lang.Throwable -> L52
            if (r3 != 0) goto L72
            r0.close()     // Catch: java.lang.Throwable -> L52
            java.lang.String r1 = "Failed to write header for %s"
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L52
            r4 = 0
            java.lang.String r5 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> L52
            r3[r4] = r5     // Catch: java.lang.Throwable -> L52
            com.bytedance.sdk.adnet.core.r.b(r1, r3)     // Catch: java.lang.Throwable -> L52
            java.io.IOException r1 = new java.io.IOException     // Catch: java.lang.Throwable -> L52
            r1.<init>()     // Catch: java.lang.Throwable -> L52
            throw r1     // Catch: java.lang.Throwable -> L52
        L52:
            r1 = move-exception
        L53:
            if (r0 == 0) goto L58
            r0.close()     // Catch: java.lang.Throwable -> L94
        L58:
            boolean r0 = r2.delete()     // Catch: java.lang.Throwable -> L6f
            if (r0 != 0) goto L1e
            java.lang.String r0 = "Could not clean up file %s"
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L6f
            r3 = 0
            java.lang.String r2 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> L6f
            r1[r3] = r2     // Catch: java.lang.Throwable -> L6f
            com.bytedance.sdk.adnet.core.r.b(r0, r1)     // Catch: java.lang.Throwable -> L6f
            goto L1e
        L6f:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        L72:
            byte[] r3 = r8.f6062b     // Catch: java.lang.Throwable -> L52
            r0.write(r3)     // Catch: java.lang.Throwable -> L52
            long r4 = r2.length()     // Catch: java.lang.Throwable -> L52
            r1.f6029a = r4     // Catch: java.lang.Throwable -> L52
            r6.a(r7, r1)     // Catch: java.lang.Throwable -> L52
            r6.b()     // Catch: java.lang.Throwable -> L52
            if (r0 == 0) goto L1e
            r0.close()     // Catch: java.lang.Throwable -> L89
            goto L1e
        L89:
            r0 = move-exception
            goto L1e
        L8b:
            r0 = move-exception
            r2 = r0
            r3 = r1
        L8e:
            if (r3 == 0) goto L93
            r3.close()     // Catch: java.lang.Throwable -> L96
        L93:
            throw r2     // Catch: java.lang.Throwable -> L6f
        L94:
            r0 = move-exception
            goto L58
        L96:
            r0 = move-exception
            goto L93
        L98:
            r1 = move-exception
            r2 = r1
            r3 = r0
            goto L8e
        L9c:
            r0 = move-exception
            r0 = r1
            goto L53
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.adnet.core.h.a(java.lang.String, com.bytedance.sdk.adnet.e.b$a):void");
    }

    public synchronized void b(String str) {
        boolean delete = c(str).delete();
        e(str);
        if (!delete) {
            r.b("Could not delete cache entry for key=%s, filename=%s", str, d(str));
        }
    }

    private String d(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    public File c(String str) {
        return new File(this.c, d(str));
    }

    private void b() {
        int i;
        if (this.f6028b >= this.d) {
            if (r.f6046a) {
                r.a("Pruning old cache entries.", new Object[0]);
            }
            long j = this.f6028b;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator<Map.Entry<String, a>> it = this.f6027a.entrySet().iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = i2;
                    break;
                }
                a value = it.next().getValue();
                if (c(value.f6030b).delete()) {
                    this.f6028b -= value.f6029a;
                } else {
                    r.b("Could not delete cache entry for key=%s, filename=%s", value.f6030b, d(value.f6030b));
                }
                it.remove();
                i = i2 + 1;
                if (((float) this.f6028b) < this.d * 0.9f) {
                    break;
                }
                i2 = i;
            }
            if (r.f6046a) {
                r.a("pruned %d files, %d bytes, %d ms", Integer.valueOf(i), Long.valueOf(this.f6028b - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
    }

    private void a(String str, a aVar) {
        if (!this.f6027a.containsKey(str)) {
            this.f6028b += aVar.f6029a;
        } else {
            this.f6028b = (aVar.f6029a - this.f6027a.get(str).f6029a) + this.f6028b;
        }
        this.f6027a.put(str, aVar);
    }

    private void e(String str) {
        a remove = this.f6027a.remove(str);
        if (remove != null) {
            this.f6028b -= remove.f6029a;
        }
    }

    @VisibleForTesting
    static byte[] a(b bVar, long j) throws Throwable {
        long a2 = bVar.a();
        if (j < 0 || j > a2 || ((int) j) != j) {
            throw new IOException("streamToBytes length=" + j + ", maxLength=" + a2);
        }
        byte[] bArr = new byte[(int) j];
        new DataInputStream(bVar).readFully(bArr);
        return bArr;
    }

    @VisibleForTesting
    InputStream a(File file) throws Throwable {
        return new FileInputStream(file);
    }

    @VisibleForTesting
    OutputStream am(File file) throws Throwable {
        return new FileOutputStream(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        long f6029a;

        /* renamed from: b  reason: collision with root package name */
        final String f6030b;
        final String c;
        final long d;
        final long e;
        final long f;
        final long g;
        final List<com.bytedance.sdk.adnet.core.a> h;

        private a(String str, String str2, long j, long j2, long j3, long j4, List<com.bytedance.sdk.adnet.core.a> list) {
            this.f6030b = str;
            this.c = "".equals(str2) ? null : str2;
            this.d = j;
            this.e = j2;
            this.f = j3;
            this.g = j4;
            this.h = list;
        }

        a(String str, b.a aVar) {
            this(str, aVar.c, aVar.d, aVar.e, aVar.f, aVar.g, b(aVar));
        }

        private static List<com.bytedance.sdk.adnet.core.a> b(b.a aVar) {
            return aVar.i != null ? aVar.i : com.bytedance.sdk.adnet.d.c.I(aVar.h);
        }

        static a c(b bVar) throws Throwable {
            if (h.a((InputStream) bVar) != 538247942) {
                throw new IOException();
            }
            return new a(h.a(bVar), h.a(bVar), h.b((InputStream) bVar), h.b((InputStream) bVar), h.b((InputStream) bVar), h.b((InputStream) bVar), h.b(bVar));
        }

        b.a aj(byte[] bArr) {
            b.a aVar = new b.a();
            aVar.f6062b = bArr;
            aVar.c = this.c;
            aVar.d = this.d;
            aVar.e = this.e;
            aVar.f = this.f;
            aVar.g = this.g;
            aVar.h = com.bytedance.sdk.adnet.d.c.a(this.h);
            aVar.i = Collections.unmodifiableList(this.h);
            return aVar;
        }

        boolean a(OutputStream outputStream) {
            try {
                h.a(outputStream, 538247942);
                h.a(outputStream, this.f6030b);
                h.a(outputStream, this.c == null ? "" : this.c);
                h.a(outputStream, this.d);
                h.a(outputStream, this.e);
                h.a(outputStream, this.f);
                h.a(outputStream, this.g);
                h.a(this.h, outputStream);
                outputStream.flush();
                return true;
            } catch (Throwable th) {
                r.b("%s", th.toString());
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes4.dex */
    public static class b extends FilterInputStream {

        /* renamed from: a  reason: collision with root package name */
        private final long f6031a;

        /* renamed from: b  reason: collision with root package name */
        private long f6032b;

        b(InputStream inputStream, long j) {
            super(inputStream);
            this.f6031a = j;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.f6032b++;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.f6032b += read;
            }
            return read;
        }

        long a() {
            return this.f6031a - this.f6032b;
        }
    }

    private static int t(InputStream inputStream) throws Throwable {
        int read = inputStream.read();
        if (read == -1) {
            throw new EOFException();
        }
        return read;
    }

    static void a(OutputStream outputStream, int i) throws Throwable {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static int a(InputStream inputStream) throws Throwable {
        return 0 | (t(inputStream) << 0) | (t(inputStream) << 8) | (t(inputStream) << 16) | (t(inputStream) << 24);
    }

    static void a(OutputStream outputStream, long j) throws Throwable {
        outputStream.write((byte) (j >>> 0));
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    static long b(InputStream inputStream) throws Throwable {
        return 0 | ((t(inputStream) & 255) << 0) | ((t(inputStream) & 255) << 8) | ((t(inputStream) & 255) << 16) | ((t(inputStream) & 255) << 24) | ((t(inputStream) & 255) << 32) | ((t(inputStream) & 255) << 40) | ((t(inputStream) & 255) << 48) | ((t(inputStream) & 255) << 56);
    }

    static void a(OutputStream outputStream, String str) throws Throwable {
        byte[] bytes = str.getBytes("UTF-8");
        a(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    static String a(b bVar) throws Throwable {
        return new String(a(bVar, b((InputStream) bVar)), "UTF-8");
    }

    static void a(List<com.bytedance.sdk.adnet.core.a> list, OutputStream outputStream) throws Throwable {
        if (list != null) {
            a(outputStream, list.size());
            for (com.bytedance.sdk.adnet.core.a aVar : list) {
                a(outputStream, aVar.getName());
                a(outputStream, aVar.getValue());
            }
            return;
        }
        a(outputStream, 0);
    }

    static List<com.bytedance.sdk.adnet.core.a> b(b bVar) throws Throwable {
        int a2 = a((InputStream) bVar);
        if (a2 < 0) {
            throw new IOException("readHeaderList size=" + a2);
        }
        List<com.bytedance.sdk.adnet.core.a> emptyList = a2 == 0 ? Collections.emptyList() : new ArrayList<>();
        for (int i = 0; i < a2; i++) {
            emptyList.add(new com.bytedance.sdk.adnet.core.a(a(bVar).intern(), a(bVar).intern()));
        }
        return emptyList;
    }
}
