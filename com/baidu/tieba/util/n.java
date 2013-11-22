package com.baidu.tieba.util;

import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private String f2497a;
    private String b;
    private com.baidu.tieba.data.e c;
    private ap d;
    private boolean e = false;

    public n(String str, com.baidu.tieba.data.e eVar, String str2) {
        this.f2497a = null;
        this.b = null;
        this.c = null;
        this.f2497a = str;
        this.c = eVar;
        this.b = str2;
    }

    public void a() {
        if (this.d != null) {
            this.d.j();
        }
        this.e = true;
    }

    public com.baidu.tieba.data.f b() {
        com.baidu.tieba.data.f fVar = new com.baidu.tieba.data.f();
        long b = this.c.b();
        long j = b % 102400 == 0 ? b / 102400 : (b / 102400) + 1;
        int c = this.c.c();
        if (c < j) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(af.d(this.f2497a), "r");
            bg.e("ChunkUploadHelper", "uploadChunkFile", String.format("start chunk : %d", Integer.valueOf(c)));
            if (randomAccessFile.skipBytes(102400 * c) >= 102400 * c) {
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
                            this.d = new ap(this.b);
                            this.d.a("md5", this.c.a());
                            this.d.a("total_length", String.valueOf(b));
                            this.d.a("total_num", String.valueOf(j));
                            bg.e("ChunkUploadHelper", "uploadChunkFile", String.format("total length : %d, chunk_no : %d", Long.valueOf(b), Integer.valueOf(i)));
                            this.d.a("pic_chunk", bArr);
                            this.d.a("offset", String.valueOf(102400 * i));
                            this.d.a("chunk_no", String.valueOf(i + 1));
                            this.d.a("length", String.valueOf(read));
                            boolean z = false;
                            if (this.e) {
                                z = true;
                            } else {
                                String n = this.d.n();
                                bg.e("ChunkUploadHelper", "uploadChunkFile", "ret " + n);
                                if (n == null || !this.d.c()) {
                                    this.c.a(i);
                                    DatabaseService.a(this.c);
                                    randomAccessFile.close();
                                    z = true;
                                }
                            }
                            if (z) {
                                fVar.a(this.d.e());
                                fVar.a(this.d.i());
                                fVar.a(this.c);
                                fVar.a(false);
                                return fVar;
                            }
                        }
                        c = i + 1;
                    } else {
                        randomAccessFile.close();
                        break;
                    }
                }
            } else {
                fVar.a(false);
                randomAccessFile.close();
                return fVar;
            }
        }
        fVar.a(true);
        return fVar;
    }
}
