package com.bytedance.sdk.adnet.b;

import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.baidu.webkit.net.BdNetTask;
import com.baidubce.http.Headers;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.l;
import com.bytedance.sdk.adnet.core.p;
import com.bytedance.sdk.adnet.err.VAdError;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class c extends Request<File> {
    private File c;
    private File d;
    private final Object e;
    @Nullable
    @GuardedBy("mLock")
    private p.a<File> poP;

    /* loaded from: classes4.dex */
    public interface a extends p.a<File> {
        void a(long j, long j2);
    }

    public c(String str, String str2, p.a<File> aVar) {
        super(str2, aVar);
        this.e = new Object();
        this.poP = aVar;
        this.c = new File(str);
        this.d = new File(str + ".tmp");
        try {
            if (this.c != null && this.c.getParentFile() != null && !this.c.getParentFile().exists()) {
                this.c.getParentFile().mkdirs();
            }
        } catch (Throwable th) {
        }
        setRetryPolicy(new com.bytedance.sdk.adnet.core.g(BdNetTask.TIMEOUT_READ, 1, 1.0f));
        setShouldCache(false);
    }

    public File f() {
        return this.c;
    }

    public File g() {
        return this.d;
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public void cancel() {
        super.cancel();
        synchronized (this.e) {
            this.poP = null;
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public Map<String, String> getHeaders() throws com.bytedance.sdk.adnet.err.a {
        HashMap hashMap = new HashMap();
        hashMap.put(Headers.RANGE, "bytes=" + this.d.length() + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        hashMap.put(Headers.ACCEPT_ENCODING, "identity");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.adnet.core.Request
    public p<File> a(l lVar) {
        if (!isCanceled()) {
            if (this.d.canRead() && this.d.length() > 0) {
                if (this.d.renameTo(this.c)) {
                    return p.a((Object) null, com.bytedance.sdk.adnet.d.c.c(lVar));
                }
                h();
                return p.c(new VAdError("Can't rename the download temporary file!"));
            }
            h();
            return p.c(new VAdError("Download temporary file was invalid!"));
        }
        h();
        return p.c(new VAdError("Request was Canceled!"));
    }

    private void h() {
        try {
            this.c.delete();
        } catch (Throwable th) {
        }
        try {
            this.c.delete();
        } catch (Throwable th2) {
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
    public byte[] a(com.bytedance.sdk.adnet.core.b r15) throws java.io.IOException, com.bytedance.sdk.adnet.err.f {
        /*
            r14 = this;
            r13 = -1
            r2 = 0
            r5 = 0
            r12 = 0
            int r0 = r15.getContentLength()
            long r6 = (long) r0
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 > 0) goto L16
            java.lang.String r0 = "Response doesn't present Content-Length!"
            java.lang.Object[] r1 = new java.lang.Object[r12]
            com.bytedance.sdk.adnet.core.r.b(r0, r1)
        L16:
            java.io.File r0 = r14.g()
            long r0 = r0.length()
            boolean r8 = r14.c(r15)
            if (r8 == 0) goto L96
            long r6 = r6 + r0
            java.lang.String r4 = "Content-Range"
            java.lang.String r4 = r14.a(r15, r4)
            boolean r9 = android.text.TextUtils.isEmpty(r4)
            if (r9 != 0) goto L96
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "bytes "
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.StringBuilder r9 = r9.append(r0)
            java.lang.String r10 = "-"
            java.lang.StringBuilder r9 = r9.append(r10)
            r10 = 1
            long r10 = r6 - r10
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.String r9 = r9.toString()
            int r10 = android.text.TextUtils.indexOf(r4, r9)
            if (r10 != r13) goto L96
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "The Content-Range Header is invalid Assume["
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r9)
            java.lang.String r2 = "] vs Real["
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r4)
            java.lang.String r2 = "], please remove the temporary file ["
            java.lang.StringBuilder r1 = r1.append(r2)
            java.io.File r2 = r14.g()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = "]."
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L96:
            int r4 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r4 <= 0) goto Lb5
            java.io.File r4 = r14.f()
            long r10 = r4.length()
            int r4 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r4 != 0) goto Lb5
            java.io.File r0 = r14.f()
            java.io.File r1 = r14.g()
            r0.renameTo(r1)
            r14.a(r6, r6)
        Lb4:
            return r5
        Lb5:
            java.io.File r4 = r14.f()
            if (r4 == 0) goto Lcc
            java.io.File r4 = r14.f()
            boolean r4 = r4.exists()
            if (r4 == 0) goto Lcc
            java.io.File r4 = r14.f()
            r4.delete()
        Lcc:
            java.io.RandomAccessFile r4 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L1b5
            java.io.File r9 = r14.g()     // Catch: java.lang.Throwable -> L1b5
            java.lang.String r10 = "rw"
            r4.<init>(r9, r10)     // Catch: java.lang.Throwable -> L1b5
            if (r8 == 0) goto L126
            r4.seek(r0)     // Catch: java.lang.Throwable -> L1b9
        Ldd:
            r2 = r4
        Lde:
            java.io.InputStream r3 = r15.getContent()     // Catch: java.lang.Throwable -> L141
            boolean r4 = r14.b(r15)     // Catch: java.lang.Throwable -> L1af
            if (r4 == 0) goto Lf2
            boolean r4 = r3 instanceof java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L1af
            if (r4 != 0) goto Lf2
            java.util.zip.GZIPInputStream r4 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L1af
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L1af
            r3 = r4
        Lf2:
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L1b2
            r14.a(r0, r6)     // Catch: java.lang.Throwable -> L1b2
        Lf9:
            int r8 = r3.read(r4)     // Catch: java.lang.Throwable -> L1b2
            if (r8 == r13) goto L10e
            r9 = 0
            r2.write(r4, r9, r8)     // Catch: java.lang.Throwable -> L1b2
            long r8 = (long) r8     // Catch: java.lang.Throwable -> L1b2
            long r0 = r0 + r8
            r14.a(r0, r6)     // Catch: java.lang.Throwable -> L1b2
            boolean r8 = r14.isCanceled()     // Catch: java.lang.Throwable -> L1b2
            if (r8 == 0) goto Lf9
        L10e:
            if (r3 == 0) goto L113
            r3.close()     // Catch: java.lang.Throwable -> L12d
        L113:
            if (r3 == 0) goto L118
            r3.close()     // Catch: java.lang.Throwable -> L137
        L118:
            r2.close()     // Catch: java.lang.Throwable -> L11c
            goto Lb4
        L11c:
            r0 = move-exception
            java.lang.String r0 = "Error occured when calling tmpFile.close"
            java.lang.Object[] r1 = new java.lang.Object[r12]
            com.bytedance.sdk.adnet.core.r.a(r0, r1)
            goto Lb4
        L126:
            r8 = 0
            r4.setLength(r8)     // Catch: java.lang.Throwable -> L1b9
            r0 = r2
            goto Ldd
        L12d:
            r0 = move-exception
            java.lang.String r0 = "Error occured when calling InputStream.close"
            java.lang.Object[] r1 = new java.lang.Object[r12]
            com.bytedance.sdk.adnet.core.r.a(r0, r1)
            goto L113
        L137:
            r0 = move-exception
            java.lang.String r0 = "Error occured when calling consumingContent"
            java.lang.Object[] r1 = new java.lang.Object[r12]
            com.bytedance.sdk.adnet.core.r.a(r0, r1)
            goto L118
        L141:
            r0 = move-exception
            r0 = r5
        L143:
            java.lang.String r1 = "Error occured when FileRequest.parseHttpResponse"
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L1ac
            com.bytedance.sdk.adnet.core.r.a(r1, r3)     // Catch: java.lang.Throwable -> L1ac
            if (r0 == 0) goto L151
            r0.close()     // Catch: java.lang.Throwable -> L166
        L151:
            if (r0 == 0) goto L156
            r0.close()     // Catch: java.lang.Throwable -> L170
        L156:
            r2.close()     // Catch: java.lang.Throwable -> L15b
            goto Lb4
        L15b:
            r0 = move-exception
            java.lang.String r0 = "Error occured when calling tmpFile.close"
            java.lang.Object[] r1 = new java.lang.Object[r12]
            com.bytedance.sdk.adnet.core.r.a(r0, r1)
            goto Lb4
        L166:
            r1 = move-exception
            java.lang.String r1 = "Error occured when calling InputStream.close"
            java.lang.Object[] r3 = new java.lang.Object[r12]
            com.bytedance.sdk.adnet.core.r.a(r1, r3)
            goto L151
        L170:
            r0 = move-exception
            java.lang.String r0 = "Error occured when calling consumingContent"
            java.lang.Object[] r1 = new java.lang.Object[r12]
            com.bytedance.sdk.adnet.core.r.a(r0, r1)
            goto L156
        L17a:
            r0 = move-exception
            r1 = r0
            r3 = r5
        L17d:
            if (r3 == 0) goto L182
            r3.close()     // Catch: java.lang.Throwable -> L18b
        L182:
            if (r3 == 0) goto L187
            r3.close()     // Catch: java.lang.Throwable -> L195
        L187:
            r2.close()     // Catch: java.lang.Throwable -> L19f
        L18a:
            throw r1
        L18b:
            r0 = move-exception
            java.lang.String r0 = "Error occured when calling InputStream.close"
            java.lang.Object[] r4 = new java.lang.Object[r12]
            com.bytedance.sdk.adnet.core.r.a(r0, r4)
            goto L182
        L195:
            r0 = move-exception
            java.lang.String r0 = "Error occured when calling consumingContent"
            java.lang.Object[] r3 = new java.lang.Object[r12]
            com.bytedance.sdk.adnet.core.r.a(r0, r3)
            goto L187
        L19f:
            r0 = move-exception
            java.lang.String r0 = "Error occured when calling tmpFile.close"
            java.lang.Object[] r2 = new java.lang.Object[r12]
            com.bytedance.sdk.adnet.core.r.a(r0, r2)
            goto L18a
        L1a9:
            r0 = move-exception
            r1 = r0
            goto L17d
        L1ac:
            r1 = move-exception
            r3 = r0
            goto L17d
        L1af:
            r0 = move-exception
            r0 = r3
            goto L143
        L1b2:
            r0 = move-exception
            r0 = r3
            goto L143
        L1b5:
            r2 = move-exception
            r2 = r5
            goto Lde
        L1b9:
            r2 = move-exception
            r2 = r4
            goto Lde
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.adnet.b.c.a(com.bytedance.sdk.adnet.core.b):byte[]");
    }

    private boolean b(com.bytedance.sdk.adnet.core.b bVar) {
        return TextUtils.equals(a(bVar, "Content-Encoding"), "gzip");
    }

    private boolean c(com.bytedance.sdk.adnet.core.b bVar) {
        if (TextUtils.equals(a(bVar, "Accept-Ranges"), "bytes")) {
            return true;
        }
        String a2 = a(bVar, Headers.CONTENT_RANGE);
        return a2 != null && a2.startsWith("bytes");
    }

    private String a(com.bytedance.sdk.adnet.core.b bVar, String str) {
        if (bVar != null && bVar.esm() != null && !bVar.esm().isEmpty()) {
            for (com.bytedance.sdk.adnet.core.a aVar : bVar.esm()) {
                if (aVar != null && TextUtils.equals(aVar.getName(), str)) {
                    return aVar.getValue();
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.adnet.core.Request
    public void a(p<File> pVar) {
        p.a<File> aVar;
        synchronized (this.e) {
            aVar = this.poP;
        }
        if (aVar != null) {
            aVar.a(p.a(this.c, pVar.ppE));
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    protected void a(long j, long j2) {
        p.a<File> aVar;
        synchronized (this.e) {
            aVar = this.poP;
        }
        if (aVar instanceof a) {
            ((a) aVar).a(j, j2);
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public Request.b getPriority() {
        return Request.b.LOW;
    }
}
