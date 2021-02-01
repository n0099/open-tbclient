package com.baidu.tieba.newfaceshop.facemake;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.gif.a;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.img.ImageFileInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/* loaded from: classes9.dex */
public class b {
    public static Bitmap c(ImageFileInfo imageFileInfo) {
        Bitmap b2;
        com.baidu.tbadk.img.b bVar = new com.baidu.tbadk.img.b();
        com.baidu.adp.widget.ImageView.a a2 = bVar.a(imageFileInfo, true);
        if (a2 != null) {
            b2 = a2.getRawBitmap();
        } else {
            b2 = bVar.b(imageFileInfo, true);
        }
        if (b2 == null) {
            return OR(imageFileInfo.getFilePath());
        }
        return b2;
    }

    public static Bitmap OR(String str) {
        Bitmap bitmap = null;
        try {
            File file = new File(str);
            if (file.exists()) {
                if (ae(file)) {
                    com.baidu.adp.widget.ImageView.a bs = a.C0013a.ld().bs(str);
                    if (bs != null) {
                        bitmap = bs.getRawBitmap();
                    }
                } else {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(str, options);
                    bitmap = BitmapHelper.loadResizedBitmap(str, options.outWidth, options.outHeight);
                }
            }
        } catch (OutOfMemoryError e) {
        }
        return bitmap;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [138=4, 139=4, 141=4, 142=4] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x004b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean ae(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[7];
                    r0 = fileInputStream.read(bArr, 0, 6) == 6 ? l.isGif(bArr) : false;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    } else {
                        fileInputStream2 = fileInputStream;
                    }
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    return r0;
                } catch (IOException e4) {
                    e = e4;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                    }
                    return r0;
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e7) {
            e = e7;
            fileInputStream = null;
        } catch (IOException e8) {
            e = e8;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            throw th;
        }
        return r0;
    }
}
