package com.baidu.tieba.write;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import com.slidingmenu.lib.R;
import java.io.File;
/* loaded from: classes.dex */
public class bg {
    public static void a(com.baidu.tieba.j jVar) {
        try {
            if (!com.baidu.tieba.util.w.a()) {
                jVar.a(com.baidu.tieba.util.w.b());
            } else {
                File f = com.baidu.tieba.util.w.f("camera.jpg");
                if (f != null) {
                    Uri fromFile = Uri.fromFile(f);
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra("output", fromFile);
                    jVar.startActivityForResult(intent, 12001);
                } else {
                    jVar.a(jVar.getString(R.string.error_sd_error));
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.be.b("WriteUtil", "takePhoto", "error = " + e.getMessage());
        }
    }

    public static void b(com.baidu.tieba.j jVar) {
        try {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction("android.intent.action.GET_CONTENT");
            jVar.startActivityForResult(intent, 12002);
        } catch (Exception e) {
            com.baidu.tieba.util.be.b("WriteUtil", "getAlbumImage", "error = " + e.getMessage());
        }
    }

    public static int a(String str) {
        try {
            switch (new ExifInterface(str).getAttributeInt("Orientation", 1)) {
                case 3:
                    return 180;
                case 4:
                case 5:
                case 7:
                default:
                    return 0;
                case 6:
                    return 90;
                case 8:
                    return 270;
            }
        } catch (Exception e) {
            com.baidu.adp.lib.h.d.a(e.getMessage());
            return 0;
        }
    }

    private static Bitmap a(int i) {
        Exception e;
        try {
            int a2 = a(com.baidu.tieba.util.w.c("camera.jpg"));
            Bitmap a3 = com.baidu.tieba.util.e.a("camera.jpg", i);
            if (a2 != 0 && a3 != null) {
                try {
                    return com.baidu.tieba.util.e.e(a3, a2);
                } catch (Exception e2) {
                    e = e2;
                    com.baidu.tieba.util.be.b("WriteUtil", "photoResult", "error = " + e.getMessage());
                    return null;
                }
            }
            return a3;
        } catch (Exception e3) {
            e = e3;
        }
    }

    private static Bitmap a(Context context, Uri uri, int i) {
        try {
            return com.baidu.tieba.util.e.a(context, uri, i);
        } catch (Exception e) {
            com.baidu.tieba.util.be.b("WriteUtil", "AlbumImageResult", "error = " + e.getMessage());
            return null;
        }
    }

    public static Bitmap a(int i, Context context, Uri uri, int i2) {
        if (i == 12001) {
            return a(i2);
        }
        return a(context, uri, i2);
    }
}
