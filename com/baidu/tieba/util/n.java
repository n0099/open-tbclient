package com.baidu.tieba.util;

import com.baidu.browser.explorer.share.BdSharer;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class n {
    private String a;
    private String b;
    private com.baidu.tieba.data.e c;
    private at d;
    private boolean e = false;

    public n(String str, com.baidu.tieba.data.e eVar, String str2) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.a = str;
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
        long j = b % BdSharer.IMAGE_MIN_SIZE_TO_SHARE == 0 ? b / BdSharer.IMAGE_MIN_SIZE_TO_SHARE : (b / BdSharer.IMAGE_MIN_SIZE_TO_SHARE) + 1;
        int c = this.c.c();
        if (c < j) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(aa.d(this.a), "r");
            bo.e("ChunkUploadHelper", "uploadChunkFile", String.format("start chunk : %d", Integer.valueOf(c)));
            if (randomAccessFile.skipBytes(c * 10240) >= c * 10240) {
                while (true) {
                    int i = c;
                    if (i < j) {
                        int i2 = 10240;
                        if (i == j - 1) {
                            i2 = (int) (b - (BdSharer.IMAGE_MIN_SIZE_TO_SHARE * (j - 1)));
                        }
                        byte[] bArr = new byte[i2];
                        int read = randomAccessFile.read(bArr, 0, i2);
                        if (read != -1) {
                            this.d = new at(this.b);
                            this.d.a("md5", this.c.a());
                            this.d.a("total_length", String.valueOf(b));
                            this.d.a("total_num", String.valueOf(j));
                            bo.e("ChunkUploadHelper", "uploadChunkFile", String.format("total length : %d, chunk_no : %d", Long.valueOf(b), Integer.valueOf(i)));
                            this.d.a("pic_chunk", bArr);
                            this.d.a("offset", String.valueOf(i * 10240));
                            this.d.a("chunk_no", String.valueOf(i + 1));
                            this.d.a("length", String.valueOf(read));
                            boolean z = false;
                            if (this.e) {
                                z = true;
                            } else {
                                String n = this.d.n();
                                bo.e("ChunkUploadHelper", "uploadChunkFile", "ret " + n);
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
