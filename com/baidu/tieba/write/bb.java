package com.baidu.tieba.write;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import com.slidingmenu.lib.R;
import java.io.File;
/* loaded from: classes.dex */
public class bb {
    public static void a(com.baidu.tieba.e eVar) {
        try {
            if (!com.baidu.tieba.d.o.a()) {
                eVar.a(com.baidu.tieba.d.o.b());
            } else {
                File e = com.baidu.tieba.d.o.e("camera.jpg");
                if (e != null) {
                    Uri fromFile = Uri.fromFile(e);
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra("output", fromFile);
                    eVar.startActivityForResult(intent, 1200001);
                } else {
                    eVar.a(eVar.getString(R.string.error_sd_error));
                }
            }
        } catch (Exception e2) {
            com.baidu.tieba.d.ae.b("WriteUtil", "takePhoto", "error = " + e2.getMessage());
        }
    }

    public static void b(com.baidu.tieba.e eVar) {
        try {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction("android.intent.action.GET_CONTENT");
            eVar.startActivityForResult(intent, 1200002);
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b("WriteUtil", "getAlbumImage", "error = " + e.getMessage());
        }
    }

    private static Bitmap a(int i) {
        try {
            return com.baidu.tieba.d.d.a("camera.jpg", i);
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b("WriteUtil", "photoResult", "error = " + e.getMessage());
            return null;
        }
    }

    private static Bitmap a(Context context, Uri uri, int i) {
        try {
            return com.baidu.tieba.d.d.a(context, uri, i);
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b("WriteUtil", "AlbumImageResult", "error = " + e.getMessage());
            return null;
        }
    }

    public static Bitmap a(int i, Context context, Uri uri, int i2) {
        if (i == 1200001) {
            return a(i2);
        }
        return a(context, uri, i2);
    }
}
