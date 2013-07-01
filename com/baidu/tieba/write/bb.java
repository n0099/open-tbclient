package com.baidu.tieba.write;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import com.slidingmenu.lib.R;
import java.io.File;
/* loaded from: classes.dex */
public class bb {
    public static void a(com.baidu.tieba.g gVar) {
        try {
            if (!com.baidu.tieba.util.m.a()) {
                gVar.a(com.baidu.tieba.util.m.b());
            } else {
                File e = com.baidu.tieba.util.m.e("camera.jpg");
                if (e != null) {
                    Uri fromFile = Uri.fromFile(e);
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra("output", fromFile);
                    gVar.startActivityForResult(intent, 1200001);
                } else {
                    gVar.a(gVar.getString(R.string.error_sd_error));
                }
            }
        } catch (Exception e2) {
            com.baidu.tieba.util.z.b("WriteUtil", "takePhoto", "error = " + e2.getMessage());
        }
    }

    public static void b(com.baidu.tieba.g gVar) {
        try {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction("android.intent.action.GET_CONTENT");
            gVar.startActivityForResult(intent, 1200002);
        } catch (Exception e) {
            com.baidu.tieba.util.z.b("WriteUtil", "getAlbumImage", "error = " + e.getMessage());
        }
    }

    private static Bitmap a(int i) {
        try {
            return com.baidu.tieba.util.d.a("camera.jpg", i);
        } catch (Exception e) {
            com.baidu.tieba.util.z.b("WriteUtil", "photoResult", "error = " + e.getMessage());
            return null;
        }
    }

    private static Bitmap a(Context context, Uri uri, int i) {
        try {
            return com.baidu.tieba.util.d.a(context, uri, i);
        } catch (Exception e) {
            com.baidu.tieba.util.z.b("WriteUtil", "AlbumImageResult", "error = " + e.getMessage());
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
