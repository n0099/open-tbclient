package com.baidu.webkit.internal.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes9.dex */
public final class d {
    private static d a;
    private ZipEntry b = null;

    /* loaded from: classes9.dex */
    class a extends ZipInputStream {
        public a(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.util.zip.ZipInputStream, java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream
        public final long skip(long j) throws IOException {
            long j2 = 0;
            if (j < 0) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = new byte[(int) Math.min(j, 4096L)];
            while (j2 != j) {
                long j3 = j - j2;
                if (bArr.length <= j3) {
                    j3 = bArr.length;
                }
                int read = read(bArr, 0, (int) j3);
                if (read <= 0) {
                    return j2;
                }
                j2 += read;
            }
            return j2;
        }
    }

    private d() {
    }

    public static d a() {
        if (a == null) {
            a = new d();
        }
        return a;
    }

    private void a(ZipInputStream zipInputStream) {
        try {
            try {
                this.b = zipInputStream.getNextEntry();
                while (this.b != null && this.b.isDirectory()) {
                    this.b = zipInputStream.getNextEntry();
                }
                if (this.b == null) {
                    b(zipInputStream);
                }
            } catch (IOException e) {
                throw new RuntimeException("could not get next zip entry", e);
            } catch (RuntimeException e2) {
                if (this.b == null) {
                    b(zipInputStream);
                }
            }
        } catch (Throwable th) {
            if (this.b == null) {
                b(zipInputStream);
            }
            throw th;
        }
    }

    private static void b(ZipInputStream zipInputStream) {
        if (zipInputStream != null) {
            try {
                zipInputStream.close();
            } catch (IOException e) {
                com.a.a.a.a.a.a.a.a(e);
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
    public final boolean a(java.lang.String r11, java.lang.String r12, java.lang.String r13) {
        /*
            r10 = this;
            r0 = 1
            r4 = 0
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> Leb
            r2.<init>(r11)     // Catch: java.lang.Throwable -> Leb
            com.baidu.webkit.internal.utils.d$a r5 = new com.baidu.webkit.internal.utils.d$a     // Catch: java.lang.Throwable -> Leb
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> Leb
            r3.<init>(r2)     // Catch: java.lang.Throwable -> Leb
            r5.<init>(r3)     // Catch: java.lang.Throwable -> Leb
            r10.a(r5)     // Catch: java.lang.Throwable -> Lef
            java.util.zip.ZipEntry r2 = r10.b     // Catch: java.lang.Throwable -> Lef
            if (r2 != 0) goto Lfc
            r2 = r4
            r6 = r0
        L1b:
            java.util.zip.ZipEntry r3 = r10.b     // Catch: java.lang.Throwable -> L35
            if (r3 == 0) goto Lae
            r3 = 4096(0x1000, float:5.74E-42)
            byte[] r7 = new byte[r3]     // Catch: java.lang.Throwable -> L35
            java.util.zip.ZipEntry r3 = r10.b     // Catch: java.lang.Throwable -> L35
            java.lang.String r3 = r3.getName()     // Catch: java.lang.Throwable -> L35
            if (r13 == 0) goto L4e
            boolean r8 = r3.startsWith(r13)     // Catch: java.lang.Throwable -> L35
            if (r8 != 0) goto L46
            r10.a(r5)     // Catch: java.lang.Throwable -> L35
            goto L1b
        L35:
            r0 = move-exception
            r4 = r5
        L37:
            com.a.a.a.a.a.a.a.a(r0)     // Catch: java.lang.Throwable -> Le8
            if (r4 == 0) goto L3f
            r2.close()     // Catch: java.lang.Throwable -> Ldb
        L3f:
            if (r2 == 0) goto Lf9
            r2.close()     // Catch: java.lang.Throwable -> Lc0
            r0 = r1
        L45:
            return r0
        L46:
            int r8 = r13.length()     // Catch: java.lang.Throwable -> L35
            java.lang.String r3 = r3.substring(r8)     // Catch: java.lang.Throwable -> L35
        L4e:
            java.io.File r8 = new java.io.File     // Catch: java.lang.Throwable -> L35
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L35
            r9.<init>()     // Catch: java.lang.Throwable -> L35
            java.lang.StringBuilder r9 = r9.append(r12)     // Catch: java.lang.Throwable -> L35
            java.lang.StringBuilder r3 = r9.append(r3)     // Catch: java.lang.Throwable -> L35
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L35
            r8.<init>(r3)     // Catch: java.lang.Throwable -> L35
            java.lang.String r3 = r8.getAbsolutePath()     // Catch: java.lang.Throwable -> L35
            com.baidu.webkit.internal.utils.a.a(r3)     // Catch: java.lang.Throwable -> L35
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L35
            java.lang.String r9 = r8.getParent()     // Catch: java.lang.Throwable -> L35
            r3.<init>(r9)     // Catch: java.lang.Throwable -> L35
            boolean r9 = r3.exists()     // Catch: java.lang.Throwable -> L35
            if (r9 != 0) goto L7d
            r3.mkdirs()     // Catch: java.lang.Throwable -> L35
        L7d:
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L35
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L35
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L35
            r8 = 4096(0x1000, float:5.74E-42)
            r3.<init>(r9, r8)     // Catch: java.lang.Throwable -> L35
            r2 = 0
            r8 = 4096(0x1000, float:5.74E-42)
            int r2 = r5.read(r7, r2, r8)     // Catch: java.lang.Throwable -> Lf4
        L90:
            if (r2 <= 0) goto L9e
            r8 = 0
            r3.write(r7, r8, r2)     // Catch: java.lang.Throwable -> Lf4
            r2 = 0
            r8 = 4096(0x1000, float:5.74E-42)
            int r2 = r5.read(r7, r2, r8)     // Catch: java.lang.Throwable -> Lf4
            goto L90
        L9e:
            r10.a(r5)     // Catch: java.lang.Throwable -> Lf4
            r3.close()     // Catch: java.lang.Throwable -> La7
            r2 = r4
            goto L1b
        La7:
            r2 = move-exception
            com.a.a.a.a.a.a.a.a(r2)     // Catch: java.lang.Throwable -> Lf4
            r2 = r3
            goto L1b
        Lae:
            if (r6 != 0) goto Lbe
        Lb0:
            r2.close()     // Catch: java.lang.Throwable -> Ld9
        Lb3:
            if (r2 == 0) goto L45
            r2.close()     // Catch: java.lang.Throwable -> Lb9
            goto L45
        Lb9:
            r1 = move-exception
            com.a.a.a.a.a.a.a.a(r1)
            goto L45
        Lbe:
            r0 = r1
            goto Lb0
        Lc0:
            r0 = move-exception
            com.a.a.a.a.a.a.a.a(r0)
            r0 = r1
            goto L45
        Lc6:
            r0 = move-exception
            r2 = r4
            r5 = r4
        Lc9:
            if (r5 == 0) goto Lce
            r2.close()     // Catch: java.lang.Throwable -> Lde
        Lce:
            if (r2 == 0) goto Ld3
            r2.close()     // Catch: java.lang.Throwable -> Ld4
        Ld3:
            throw r0
        Ld4:
            r1 = move-exception
            com.a.a.a.a.a.a.a.a(r1)
            goto Ld3
        Ld9:
            r1 = move-exception
            goto Lb3
        Ldb:
            r0 = move-exception
            goto L3f
        Lde:
            r1 = move-exception
            goto Lce
        Le0:
            r0 = move-exception
            r2 = r4
            goto Lc9
        Le3:
            r0 = move-exception
            r2 = r3
            goto Lc9
        Le6:
            r0 = move-exception
            goto Lc9
        Le8:
            r0 = move-exception
            r5 = r4
            goto Lc9
        Leb:
            r0 = move-exception
            r2 = r4
            goto L37
        Lef:
            r0 = move-exception
            r2 = r4
            r4 = r5
            goto L37
        Lf4:
            r0 = move-exception
            r2 = r3
            r4 = r5
            goto L37
        Lf9:
            r0 = r1
            goto L45
        Lfc:
            r2 = r4
            r6 = r1
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.webkit.internal.utils.d.a(java.lang.String, java.lang.String, java.lang.String):boolean");
    }
}
