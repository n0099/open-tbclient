package com.baidu.tieba.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.io.File;
/* loaded from: classes.dex */
public class UtilHelper {
    public static int dip2px(Context context, float dipValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) ((dipValue * scale) + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) ((pxValue / scale) + 0.5f);
    }

    public static int getEquipmentWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getEquipmentHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static void install_apk(Context context, String file_name) {
        if (file_name != null && file_name.length() > 0) {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction("android.intent.action.VIEW");
            File file = FileHelper.GetFile(file_name);
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            context.startActivity(intent);
        }
    }
}
