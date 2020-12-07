package com.baidu.webkit.internal.utils;

import android.content.Context;
import com.baidu.webkit.internal.INoProGuard;
import java.io.IOException;
import java.io.InputStream;
import java.util.Stack;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes12.dex */
public class ZipUtils implements INoProGuard {
    private static ZipUtils singleton;
    private ZipEntry nextEntry;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a extends ZipInputStream {
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

    private ZipUtils() {
    }

    public static ZipUtils getInstance() {
        if (singleton == null) {
            singleton = new ZipUtils();
        }
        return singleton;
    }

    private void getNextEntry(ZipInputStream zipInputStream) {
        try {
            try {
                this.nextEntry = zipInputStream.getNextEntry();
                while (this.nextEntry != null && this.nextEntry.isDirectory()) {
                    this.nextEntry = zipInputStream.getNextEntry();
                }
                if (this.nextEntry == null) {
                    safeClose(zipInputStream);
                }
            } catch (IOException e) {
                throw new RuntimeException("could not get next zip entry", e);
            } catch (RuntimeException e2) {
                if (this.nextEntry == null) {
                    safeClose(zipInputStream);
                }
            }
        } catch (Throwable th) {
            if (this.nextEntry == null) {
                safeClose(zipInputStream);
            }
            throw th;
        }
    }

    private void pushEntry(Stack<String> stack, String str, String[] strArr) {
        if (str != null) {
            str = str + "/";
        }
        for (int i = 0; i < strArr.length; i++) {
            if (str != null) {
                stack.push(str + strArr[i]);
            } else {
                stack.push(strArr[i]);
            }
        }
    }

    private void safeClose(ZipInputStream zipInputStream) {
        if (zipInputStream != null) {
            try {
                zipInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
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
    public boolean unZip(android.content.Context r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, boolean r13) {
        /*
            r8 = this;
            r0 = 0
            r2 = 0
            r1 = 0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> Led
            r4.<init>(r10)     // Catch: java.lang.Throwable -> Led
            com.baidu.webkit.internal.utils.ZipUtils$a r3 = new com.baidu.webkit.internal.utils.ZipUtils$a     // Catch: java.lang.Throwable -> Led
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> Led
            r5.<init>(r4)     // Catch: java.lang.Throwable -> Led
            r3.<init>(r5)     // Catch: java.lang.Throwable -> Led
            r8.getNextEntry(r3)     // Catch: java.lang.Throwable -> L35
            java.util.zip.ZipEntry r2 = r8.nextEntry     // Catch: java.lang.Throwable -> L35
            if (r2 != 0) goto Lf5
            r0 = 1
            r4 = r0
        L1b:
            java.util.zip.ZipEntry r0 = r8.nextEntry     // Catch: java.lang.Throwable -> L35
            if (r0 == 0) goto Lb3
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r5 = new byte[r0]     // Catch: java.lang.Throwable -> L35
            java.util.zip.ZipEntry r0 = r8.nextEntry     // Catch: java.lang.Throwable -> L35
            java.lang.String r0 = r0.getName()     // Catch: java.lang.Throwable -> L35
            if (r12 == 0) goto L4e
            boolean r2 = r0.startsWith(r12)     // Catch: java.lang.Throwable -> L35
            if (r2 != 0) goto L46
            r8.getNextEntry(r3)     // Catch: java.lang.Throwable -> L35
            goto L1b
        L35:
            r0 = move-exception
            r2 = r3
        L37:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> Lea
            r0 = 0
            if (r2 == 0) goto L40
            r1.close()     // Catch: java.lang.Throwable -> Le0
        L40:
            if (r1 == 0) goto L45
            r1.close()     // Catch: java.lang.Throwable -> Lc6
        L45:
            return r0
        L46:
            int r2 = r12.length()     // Catch: java.lang.Throwable -> L35
            java.lang.String r0 = r0.substring(r2)     // Catch: java.lang.Throwable -> L35
        L4e:
            java.io.File r6 = new java.io.File     // Catch: java.lang.Throwable -> L35
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L35
            r2.<init>()     // Catch: java.lang.Throwable -> L35
            java.lang.StringBuilder r2 = r2.append(r11)     // Catch: java.lang.Throwable -> L35
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch: java.lang.Throwable -> L35
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L35
            r6.<init>(r0)     // Catch: java.lang.Throwable -> L35
            java.lang.String r0 = r6.getAbsolutePath()     // Catch: java.lang.Throwable -> L35
            com.baidu.webkit.internal.utils.a.a(r0)     // Catch: java.lang.Throwable -> L35
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L35
            java.lang.String r2 = r6.getParent()     // Catch: java.lang.Throwable -> L35
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L35
            boolean r2 = r0.exists()     // Catch: java.lang.Throwable -> L35
            if (r2 != 0) goto L7d
            r0.mkdirs()     // Catch: java.lang.Throwable -> L35
        L7d:
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L35
            r0.<init>(r6)     // Catch: java.lang.Throwable -> L35
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L35
            r7 = 4096(0x1000, float:5.74E-42)
            r2.<init>(r0, r7)     // Catch: java.lang.Throwable -> L35
            r0 = 0
            r1 = 4096(0x1000, float:5.74E-42)
            int r0 = r3.read(r5, r0, r1)     // Catch: java.lang.Throwable -> Lf0
        L90:
            if (r0 <= 0) goto L9e
            r1 = 0
            r2.write(r5, r1, r0)     // Catch: java.lang.Throwable -> Lf0
            r0 = 0
            r1 = 4096(0x1000, float:5.74E-42)
            int r0 = r3.read(r5, r0, r1)     // Catch: java.lang.Throwable -> Lf0
            goto L90
        L9e:
            r8.getNextEntry(r3)     // Catch: java.lang.Throwable -> Lf0
            if (r13 == 0) goto La6
            com.baidu.webkit.internal.utils.a.a(r6)     // Catch: java.lang.Throwable -> Lf0
        La6:
            r2.close()     // Catch: java.lang.Throwable -> Lac
            r1 = 0
            goto L1b
        Lac:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> Lf0
            r1 = r2
            goto L1b
        Lb3:
            if (r4 != 0) goto Lc4
            r0 = 1
        Lb6:
            r1.close()     // Catch: java.lang.Throwable -> Lde
        Lb9:
            if (r1 == 0) goto L45
            r1.close()     // Catch: java.lang.Throwable -> Lbf
            goto L45
        Lbf:
            r1 = move-exception
            r1.printStackTrace()
            goto L45
        Lc4:
            r0 = 0
            goto Lb6
        Lc6:
            r1 = move-exception
            r1.printStackTrace()
            goto L45
        Lcc:
            r0 = move-exception
            r3 = r2
        Lce:
            if (r3 == 0) goto Ld3
            r1.close()     // Catch: java.lang.Throwable -> Le3
        Ld3:
            if (r1 == 0) goto Ld8
            r1.close()     // Catch: java.lang.Throwable -> Ld9
        Ld8:
            throw r0
        Ld9:
            r1 = move-exception
            r1.printStackTrace()
            goto Ld8
        Lde:
            r2 = move-exception
            goto Lb9
        Le0:
            r2 = move-exception
            goto L40
        Le3:
            r2 = move-exception
            goto Ld3
        Le5:
            r0 = move-exception
            goto Lce
        Le7:
            r0 = move-exception
            r1 = r2
            goto Lce
        Lea:
            r0 = move-exception
            r3 = r2
            goto Lce
        Led:
            r0 = move-exception
            goto L37
        Lf0:
            r0 = move-exception
            r1 = r2
            r2 = r3
            goto L37
        Lf5:
            r4 = r0
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.webkit.internal.utils.ZipUtils.unZip(android.content.Context, java.lang.String, java.lang.String, java.lang.String, boolean):boolean");
    }

    public boolean unZip(Context context, String str, String str2, boolean z) {
        return unZip(context, str, str2, null, z);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public boolean zip(java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String[] r15) {
        /*
            r11 = this;
            r1 = 1
            r0 = 512(0x200, float:7.17E-43)
            byte[] r6 = new byte[r0]
            r4 = 0
            r3 = 0
            java.util.Stack r7 = new java.util.Stack
            r7.<init>()
            if (r12 == 0) goto L10
            if (r13 != 0) goto L12
        L10:
            r0 = 0
        L11:
            return r0
        L12:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L129
            r0.<init>()     // Catch: java.lang.Throwable -> L129
            java.lang.StringBuilder r0 = r0.append(r12)     // Catch: java.lang.Throwable -> L129
            java.lang.String r2 = "/"
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> L129
            java.lang.String r8 = r0.toString()     // Catch: java.lang.Throwable -> L129
            java.util.zip.ZipOutputStream r2 = new java.util.zip.ZipOutputStream     // Catch: java.lang.Throwable -> L129
            java.io.BufferedOutputStream r0 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L129
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L129
            r5.<init>(r14)     // Catch: java.lang.Throwable -> L129
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L129
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L129
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L12e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L12e
            r3.<init>()     // Catch: java.lang.Throwable -> L12e
            java.lang.StringBuilder r3 = r3.append(r8)     // Catch: java.lang.Throwable -> L12e
            java.lang.StringBuilder r3 = r3.append(r13)     // Catch: java.lang.Throwable -> L12e
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L12e
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L12e
            boolean r3 = r0.isDirectory()     // Catch: java.lang.Throwable -> L12e
            if (r3 == 0) goto Ld0
            r3 = 0
            java.lang.String[] r0 = r0.list()     // Catch: java.lang.Throwable -> L12e
            r11.pushEntry(r7, r3, r0)     // Catch: java.lang.Throwable -> L12e
            r3 = r4
        L5a:
            int r0 = r7.size()     // Catch: java.lang.Throwable -> Lbb
            if (r0 <= 0) goto Lfc
            java.lang.Object r0 = r7.pop()     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> Lbb
            r4 = 0
            if (r15 == 0) goto L76
            int r9 = r15.length     // Catch: java.lang.Throwable -> Lbb
            r5 = 0
        L6b:
            if (r5 >= r9) goto L76
            r10 = r15[r5]     // Catch: java.lang.Throwable -> Lbb
            boolean r10 = r10.equals(r0)     // Catch: java.lang.Throwable -> Lbb
            if (r10 == 0) goto Ld5
            r4 = 1
        L76:
            if (r4 != 0) goto L5a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lbb
            r4.<init>()     // Catch: java.lang.Throwable -> Lbb
            java.lang.StringBuilder r4 = r4.append(r8)     // Catch: java.lang.Throwable -> Lbb
            java.lang.StringBuilder r4 = r4.append(r0)     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r5 = r4.toString()     // Catch: java.lang.Throwable -> Lbb
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> Lbb
            r4.<init>(r5)     // Catch: java.lang.Throwable -> Lbb
            boolean r9 = r4.isDirectory()     // Catch: java.lang.Throwable -> Lbb
            if (r9 == 0) goto Ld8
            java.util.zip.ZipEntry r5 = new java.util.zip.ZipEntry     // Catch: java.lang.Throwable -> Lbb
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lbb
            r9.<init>()     // Catch: java.lang.Throwable -> Lbb
            java.lang.StringBuilder r9 = r9.append(r0)     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r10 = "/"
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> Lbb
            r5.<init>(r9)     // Catch: java.lang.Throwable -> Lbb
            r2.putNextEntry(r5)     // Catch: java.lang.Throwable -> Lbb
            java.lang.String[] r4 = r4.list()     // Catch: java.lang.Throwable -> Lbb
            r11.pushEntry(r7, r0, r4)     // Catch: java.lang.Throwable -> Lbb
        Lb7:
            r2.closeEntry()     // Catch: java.lang.Throwable -> Lbb
            goto L5a
        Lbb:
            r0 = move-exception
            r1 = r0
        Lbd:
            r0 = 0
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L127
            if (r3 == 0) goto Lc6
            r3.close()     // Catch: java.lang.Throwable -> L11b
        Lc6:
            if (r2 == 0) goto L11
            r2.close()     // Catch: java.lang.Throwable -> Lcd
            goto L11
        Lcd:
            r1 = move-exception
            goto L11
        Ld0:
            r7.push(r13)     // Catch: java.lang.Throwable -> L12e
            r3 = r4
            goto L5a
        Ld5:
            int r5 = r5 + 1
            goto L6b
        Ld8:
            java.util.zip.ZipEntry r4 = new java.util.zip.ZipEntry     // Catch: java.lang.Throwable -> Lbb
            r4.<init>(r0)     // Catch: java.lang.Throwable -> Lbb
            r2.putNextEntry(r4)     // Catch: java.lang.Throwable -> Lbb
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> Lbb
            r4.<init>(r5)     // Catch: java.lang.Throwable -> Lbb
        Le5:
            int r0 = r4.read(r6)     // Catch: java.lang.Throwable -> Lf0
            if (r0 <= 0) goto Lf4
            r3 = 0
            r2.write(r6, r3, r0)     // Catch: java.lang.Throwable -> Lf0
            goto Le5
        Lf0:
            r0 = move-exception
            r1 = r0
            r3 = r4
            goto Lbd
        Lf4:
            r4.close()     // Catch: java.lang.Throwable -> Lf9
            r3 = 0
            goto Lb7
        Lf9:
            r0 = move-exception
            r3 = r4
            goto Lb7
        Lfc:
            if (r3 == 0) goto L101
            r3.close()     // Catch: java.lang.Throwable -> L119
        L101:
            r2.close()     // Catch: java.lang.Throwable -> L107
            r0 = r1
            goto L11
        L107:
            r0 = move-exception
            r0 = r1
            goto L11
        L10b:
            r0 = move-exception
            r2 = r3
            r3 = r4
        L10e:
            if (r3 == 0) goto L113
            r3.close()     // Catch: java.lang.Throwable -> L11d
        L113:
            if (r2 == 0) goto L118
            r2.close()     // Catch: java.lang.Throwable -> L11f
        L118:
            throw r0
        L119:
            r0 = move-exception
            goto L101
        L11b:
            r1 = move-exception
            goto Lc6
        L11d:
            r1 = move-exception
            goto L113
        L11f:
            r1 = move-exception
            goto L118
        L121:
            r0 = move-exception
            r3 = r4
            goto L10e
        L124:
            r0 = move-exception
            r3 = r4
            goto L10e
        L127:
            r0 = move-exception
            goto L10e
        L129:
            r0 = move-exception
            r1 = r0
            r2 = r3
            r3 = r4
            goto Lbd
        L12e:
            r0 = move-exception
            r1 = r0
            r3 = r4
            goto Lbd
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.webkit.internal.utils.ZipUtils.zip(java.lang.String, java.lang.String, java.lang.String, java.lang.String[]):boolean");
    }
}
