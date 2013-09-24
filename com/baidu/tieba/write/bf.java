package com.baidu.tieba.write;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import com.slidingmenu.lib.R;
import java.io.File;
/* loaded from: classes.dex */
public class bf {
    public static void a(com.baidu.tieba.j jVar) {
        try {
            if (!com.baidu.tieba.util.p.a()) {
                jVar.a(com.baidu.tieba.util.p.b());
            } else {
                File e = com.baidu.tieba.util.p.e("camera.jpg");
                if (e != null) {
                    Uri fromFile = Uri.fromFile(e);
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra("output", fromFile);
                    jVar.startActivityForResult(intent, 12001);
                } else {
                    jVar.a(jVar.getString(R.string.error_sd_error));
                }
            }
        } catch (Exception e2) {
            com.baidu.tieba.util.av.b("WriteUtil", "takePhoto", "error = " + e2.getMessage());
        }
    }

    public static void b(com.baidu.tieba.j jVar) {
        try {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction("android.intent.action.GET_CONTENT");
            jVar.startActivityForResult(intent, 12002);
        } catch (Exception e) {
            com.baidu.tieba.util.av.b("WriteUtil", "getAlbumImage", "error = " + e.getMessage());
        }
    }

    private static Bitmap a(int i) {
        try {
            return com.baidu.tieba.util.e.a("camera.jpg", i);
        } catch (Exception e) {
            com.baidu.tieba.util.av.b("WriteUtil", "photoResult", "error = " + e.getMessage());
            return null;
        }
    }

    private static Bitmap a(Context context, Uri uri, int i) {
        try {
            return com.baidu.tieba.util.e.a(context, uri, i);
        } catch (Exception e) {
            com.baidu.tieba.util.av.b("WriteUtil", "AlbumImageResult", "error = " + e.getMessage());
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
