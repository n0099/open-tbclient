package com.baidu.tieba.util;

import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private String f1763a;
    private String b;
    private com.baidu.tieba.data.d c;
    private u d;
    private boolean e = false;

    public f(String str, com.baidu.tieba.data.d dVar, String str2) {
        this.f1763a = null;
        this.b = null;
        this.c = null;
        this.f1763a = str;
        this.c = dVar;
        this.b = str2;
    }

    public void a() {
        if (this.d != null) {
            this.d.i();
        }
        this.e = true;
    }

    public com.baidu.tieba.data.e b() {
        com.baidu.tieba.data.e eVar = new com.baidu.tieba.data.e();
        long b = this.c.b();
        long j = b % 102400 == 0 ? b / 102400 : (b / 102400) + 1;
        int c = this.c.c();
        if (c < j) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(p.c(this.f1763a), "r");
            aj.e("ChunkUploadHelper", "uploadChunkFile", String.format("start chunk : %d", Integer.valueOf(c)));
            if (randomAccessFile.skipBytes(102400 * c) < 102400 * c) {
                eVar.a(false);
                randomAccessFile.close();
                return eVar;
            }
            while (true) {
                int i = c;
                if (i < j) {
                    int i2 = 102400;
                    if (i == j - 1) {
                        i2 = (int) (b - (102400 * (j - 1)));
                    }
                    byte[] bArr = new byte[i2];
                    int read = randomAccessFile.read(bArr, 0, i2);
                    if (read != -1) {
                        this.d = new u(this.b);
                        this.d.a("md5", this.c.a());
                        this.d.a("total_length", String.valueOf(b));
                        this.d.a("total_num", String.valueOf(j));
                        aj.e("ChunkUploadHelper", "uploadChunkFile", String.format("total length : %d, chunk_no : %d", Long.valueOf(b), Integer.valueOf(i)));
                        this.d.a("pic_chunk", bArr);
                        this.d.a("offset", String.valueOf(102400 * i));
                        this.d.a("chunk_no", String.valueOf(i + 1));
                        this.d.a("length", String.valueOf(read));
                        boolean z = false;
                        if (this.e) {
                            z = true;
                        } else {
                            String m = this.d.m();
                            aj.e("ChunkUploadHelper", "uploadChunkFile", "ret " + m);
                            if (m == null || !this.d.d()) {
                                this.c.a(i);
                                DatabaseService.a(this.c);
                                randomAccessFile.close();
                                z = true;
                            }
                        }
                        if (z) {
                            eVar.a(this.d.f());
                            eVar.a(this.d.h());
                            eVar.a(this.c);
                            eVar.a(false);
                            return eVar;
                        }
                    }
                    c = i + 1;
                } else {
                    randomAccessFile.close();
                    break;
                }
            }
        }
        eVar.a(true);
        return eVar;
    }
}
