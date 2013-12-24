package com.baidu.tieba.write;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.util.be;
import com.slidingmenu.lib.R;
import java.io.File;
/* loaded from: classes.dex */
public class bd {
    public static void a(Activity activity) {
        try {
            if (!com.baidu.tieba.util.y.a()) {
                if (activity instanceof com.baidu.tieba.j) {
                    ((com.baidu.tieba.j) activity).showToast(com.baidu.tieba.util.y.b());
                } else if (activity instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) activity).a(com.baidu.tieba.util.y.b());
                }
            } else {
                File f = com.baidu.tieba.util.y.f("camera.jpg");
                if (f != null) {
                    Uri fromFile = Uri.fromFile(f);
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra("output", fromFile);
                    activity.startActivityForResult(intent, 12001);
                } else if (activity instanceof com.baidu.tieba.j) {
                    ((com.baidu.tieba.j) activity).showToast(activity.getString(R.string.error_sd_error));
                } else if (activity instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) activity).a(activity.getString(R.string.error_sd_error));
                }
            }
        } catch (Exception e) {
            be.b("WriteUtil", "takePhoto", "error = " + e.getMessage());
        }
    }

    public static void b(Activity activity) {
        c(activity);
    }

    public static void c(Activity activity) {
        try {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction("android.intent.action.GET_CONTENT");
            activity.startActivityForResult(intent, 12002);
        } catch (Exception e) {
            be.b("WriteUtil", "getAlbumImage", "error = " + e.getMessage());
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
            com.baidu.adp.lib.h.e.a(e.getMessage());
            return 0;
        }
    }

    private static Bitmap a(int i) {
        Exception e;
        try {
            int a = a(com.baidu.tieba.util.y.c("camera.jpg"));
            Bitmap a2 = com.baidu.tieba.util.m.a("camera.jpg", i);
            if (a != 0 && a2 != null) {
                try {
                    return com.baidu.tieba.util.m.e(a2, a);
                } catch (Exception e2) {
                    e = e2;
                    be.b("WriteUtil", "photoResult", "error = " + e.getMessage());
                    return null;
                }
            }
            return a2;
        } catch (Exception e3) {
            e = e3;
        }
    }

    private static Bitmap a(Context context, Uri uri, int i) {
        try {
            return com.baidu.tieba.util.m.a(context, uri, i);
        } catch (Exception e) {
            be.b("WriteUtil", "AlbumImageResult", "error = " + e.getMessage());
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
