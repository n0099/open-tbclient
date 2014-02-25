package com.baidu.tieba.img;

import android.graphics.Bitmap;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.img.effects.ImageOperation;
import com.baidu.tieba.util.af;
import com.baidu.tieba.util.ba;
import com.baidu.tieba.util.bs;
import com.baidu.tieba.util.cb;
import com.slidingmenu.lib.R;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class h {
    private int b;
    private int c;
    private int d;
    private int e;
    private String f;
    private boolean g;
    private e j;
    private i k;
    private Object l;
    private int a = 102400;
    private String h = SocialConstants.TRUE;
    private ba i = null;

    public h(String str) {
        this.f = str;
    }

    public void a(int i, int i2, int i3, int i4) {
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
    }

    public void a(i iVar, Object obj) {
        this.k = iVar;
        this.l = obj;
        if (iVar != null) {
            this.a = 10240;
        }
    }

    public void a() {
        this.g = true;
        if (this.i != null) {
            this.i.k();
        }
    }

    public void a(WriteImagesInfo writeImagesInfo) {
        UploadedImageInfo uploadedPicInfo;
        if (writeImagesInfo != null && writeImagesInfo.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < chosedFiles.size()) {
                    ImageFileInfo imageFileInfo = chosedFiles.get(i2);
                    if (!imageFileInfo.isAlreadyUploadedToServer()) {
                        if (!this.g) {
                            ImageUploadResult a = a(imageFileInfo);
                            if (a != null && (uploadedPicInfo = a.getUploadedPicInfo()) != null) {
                                imageFileInfo.setServerImageCode(uploadedPicInfo.toPostString());
                            }
                        } else {
                            return;
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public ImageUploadResult a(ImageFileInfo imageFileInfo) {
        Bitmap b;
        if (this.j == null) {
            this.j = new e(TiebaApplication.g().b());
        }
        LinkedList<ImageOperation> pageActionsList = imageFileInfo.getPageActionsList();
        imageFileInfo.setPageActionsList(null);
        com.baidu.adp.widget.ImageView.b a = this.j.a(imageFileInfo, true);
        if (a != null) {
            b = a.h();
        } else {
            b = this.j.b(imageFileInfo, true);
        }
        imageFileInfo.setPageActionsList(pageActionsList);
        if (b != null && af.a((String) null, "tieba_resized_image", b, 80) != null) {
            return a(af.c("tieba_resized_image"));
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x038a, code lost:
        r3 = r10;
        r4 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x013f, code lost:
        r19.append("|startChunk=");
        r19.append(r6);
        r4 = r3;
        r3 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x022b, code lost:
        r19.append("|startChunk=");
        r19.append(r6);
        r19.append("|picNull=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x023e, code lost:
        if (r11 != null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0240, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0241, code lost:
        r19.append(r3);
        r19.append("|picErrNo=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x024d, code lost:
        if (r11 == null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x024f, code lost:
        r19.append(r11.error_code);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0256, code lost:
        r3 = r10;
        r4 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x02e7, code lost:
        r3 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02ac A[Catch: all -> 0x035a, TryCatch #6 {all -> 0x035a, blocks: (B:15:0x00cc, B:22:0x0139, B:24:0x013f, B:25:0x014f, B:28:0x0158, B:30:0x0182, B:31:0x0190, B:33:0x0196, B:35:0x019c, B:36:0x01be, B:38:0x01c4, B:40:0x01ca, B:41:0x01ec, B:43:0x020a, B:44:0x0213, B:46:0x0221, B:48:0x0225, B:78:0x02ea, B:80:0x02f0, B:82:0x02f4, B:87:0x0309, B:88:0x030c, B:90:0x0317, B:85:0x02f9, B:72:0x02a6, B:74:0x02ac, B:75:0x02b3, B:95:0x0351, B:91:0x0332, B:93:0x033d, B:50:0x022b, B:53:0x0241, B:55:0x024f, B:68:0x0290, B:59:0x025f, B:61:0x0265, B:64:0x026a, B:63:0x0268, B:65:0x027c, B:67:0x0281), top: B:122:0x00cc }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0351 A[Catch: all -> 0x035a, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x035a, blocks: (B:15:0x00cc, B:22:0x0139, B:24:0x013f, B:25:0x014f, B:28:0x0158, B:30:0x0182, B:31:0x0190, B:33:0x0196, B:35:0x019c, B:36:0x01be, B:38:0x01c4, B:40:0x01ca, B:41:0x01ec, B:43:0x020a, B:44:0x0213, B:46:0x0221, B:48:0x0225, B:78:0x02ea, B:80:0x02f0, B:82:0x02f4, B:87:0x0309, B:88:0x030c, B:90:0x0317, B:85:0x02f9, B:72:0x02a6, B:74:0x02ac, B:75:0x02b3, B:95:0x0351, B:91:0x0332, B:93:0x033d, B:50:0x022b, B:53:0x0241, B:55:0x024f, B:68:0x0290, B:59:0x025f, B:61:0x0265, B:64:0x026a, B:63:0x0268, B:65:0x027c, B:67:0x0281), top: B:122:0x00cc }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ImageUploadResult a(String str) {
        RandomAccessFile randomAccessFile;
        Exception e;
        ImageUploadResult imageUploadResult;
        Throwable th;
        int i;
        byte[] bArr;
        long j;
        ImageUploadResult imageUploadResult2 = null;
        RandomAccessFile randomAccessFile2 = null;
        StringBuilder sb = new StringBuilder();
        try {
            try {
                File file = new File(str);
                long length = file.length();
                String a = bs.a(af.a(file));
                sb.append("path=");
                sb.append(str);
                sb.append("|length=");
                sb.append(length);
                sb.append("|md5=");
                sb.append(a);
                if (length == 0 || a == null) {
                    imageUploadResult = new ImageUploadResult();
                    try {
                        imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_FILE_ERROR;
                        imageUploadResult.error_msg = TiebaApplication.g().b().getString(R.string.file_not_exist);
                        cb.a("", -1007, "file error: " + imageUploadResult.error_msg, sb.toString());
                    } catch (Exception e2) {
                        randomAccessFile = null;
                        e = e2;
                        if (!this.g) {
                            sb.append("|request cancelled.");
                        } else {
                            com.baidu.adp.lib.util.f.b(e.getMessage());
                        }
                        cb.a("", -1002, String.valueOf(this.f) + "ex: " + e.getMessage(), sb.toString());
                        com.baidu.adp.lib.f.a.a(randomAccessFile);
                        this.i = null;
                        return imageUploadResult;
                    }
                } else {
                    String str2 = String.valueOf(a) + this.a;
                    long j2 = length % ((long) this.a) == 0 ? length / this.a : (length / this.a) + 1;
                    sb.append("|chunkNo=");
                    sb.append(j2);
                    randomAccessFile = new RandomAccessFile(str, "r");
                    byte[] bArr2 = null;
                    try {
                        try {
                            sb.append("|width=");
                            sb.append(this.b);
                            sb.append("|height=");
                            sb.append(this.c);
                            sb.append("|smallWidth=");
                            sb.append(this.d);
                            sb.append("|smallHeight=");
                            sb.append(this.e);
                            sb.append("|groupId=");
                            sb.append(this.h);
                            int i2 = 1;
                            int i3 = 0;
                            long j3 = 0;
                            while (true) {
                                i = i2;
                                randomAccessFile2 = imageUploadResult2;
                                if (i > j2) {
                                    imageUploadResult = randomAccessFile2;
                                    randomAccessFile2 = randomAccessFile;
                                    break;
                                }
                                try {
                                    if (!this.g) {
                                        int i4 = 0;
                                        if (i > j2) {
                                            i4 = 0;
                                            bArr = null;
                                        } else {
                                            if (i < j2) {
                                                i4 = this.a;
                                            } else if (i == j2) {
                                                i4 = (int) (length - (this.a * (j2 - 1)));
                                            }
                                            if (bArr2 == null || bArr2.length != i4) {
                                                bArr2 = new byte[i4];
                                            }
                                            randomAccessFile.seek(this.a * (i - 1));
                                            randomAccessFile.read(bArr2, 0, i4);
                                            bArr = bArr2;
                                        }
                                        this.i = new ba(com.baidu.tieba.im.g.g);
                                        this.i.a("resourceId", str2);
                                        this.i.a("chunkNo", String.valueOf(i));
                                        if (i >= j2) {
                                            this.i.a("isFinish", String.valueOf(1));
                                        } else {
                                            this.i.a("isFinish", String.valueOf(0));
                                        }
                                        if (this.b > 0 && this.c > 0) {
                                            this.i.a("width", String.valueOf(this.b));
                                            this.i.a("height", String.valueOf(this.c));
                                        }
                                        if (this.d > 0 && this.e > 0) {
                                            this.i.a("smallWidth", String.valueOf(this.d));
                                            this.i.a("smallHeight", String.valueOf(this.e));
                                        }
                                        this.i.a("groupId", String.valueOf(this.h));
                                        this.i.a("alt", "json");
                                        if (bArr != null) {
                                            this.i.a("chunk", bArr);
                                        }
                                        imageUploadResult2 = ImageUploadResult.parser(this.i.n());
                                        if (imageUploadResult2 == null) {
                                            break;
                                        }
                                        try {
                                            if (imageUploadResult2.error_code != 0 && imageUploadResult2.error_code != ImageUploadResult.CHUNK_ERROR) {
                                                break;
                                            }
                                            if (imageUploadResult2.error_code == ImageUploadResult.CHUNK_ERROR) {
                                                if (i == imageUploadResult2.chunkNo || imageUploadResult2.chunkNo <= 0) {
                                                    break;
                                                }
                                                i2 = imageUploadResult2.chunkNo;
                                                j = j3;
                                            } else {
                                                int i5 = i + 1;
                                                long j4 = j3 + i4;
                                                if (this.k != null) {
                                                    this.k.a(str, this.l, j4, length);
                                                }
                                                i2 = i5;
                                                j = j4;
                                            }
                                            int i6 = i3 + 1;
                                            if (i6 > 2 * j2) {
                                                sb.append("|possbile dead loop found. tryCount=").append(i6).append(", chunkNo=").append(j2);
                                                randomAccessFile2 = randomAccessFile;
                                                imageUploadResult = imageUploadResult2;
                                                break;
                                            }
                                            i3 = i6;
                                            j3 = j;
                                            bArr2 = bArr;
                                        } catch (Exception e3) {
                                            e = e3;
                                            imageUploadResult = imageUploadResult2;
                                        }
                                    } else {
                                        break;
                                    }
                                } catch (Exception e4) {
                                    imageUploadResult = randomAccessFile2;
                                    e = e4;
                                }
                            }
                            try {
                                sb.append("|startChunk=");
                                sb.append(i);
                                imageUploadResult = null;
                                randomAccessFile2 = randomAccessFile;
                            } catch (Exception e5) {
                                imageUploadResult = null;
                                e = e5;
                                if (!this.g) {
                                }
                                cb.a("", -1002, String.valueOf(this.f) + "ex: " + e.getMessage(), sb.toString());
                                com.baidu.adp.lib.f.a.a(randomAccessFile);
                                this.i = null;
                                return imageUploadResult;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            com.baidu.adp.lib.f.a.a(randomAccessFile);
                            this.i = null;
                            throw th;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        imageUploadResult = null;
                    }
                }
                com.baidu.adp.lib.f.a.a(randomAccessFile2);
                this.i = null;
            } catch (Throwable th3) {
                randomAccessFile = null;
                th = th3;
            }
        } catch (Exception e7) {
            randomAccessFile = null;
            e = e7;
            imageUploadResult = null;
        }
        return imageUploadResult;
    }

    public void b(String str) {
        this.h = str;
    }
}
