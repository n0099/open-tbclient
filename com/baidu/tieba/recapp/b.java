package com.baidu.tieba.recapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
/* loaded from: classes.dex */
public class b {
    public static boolean b(Context context, Uri uri) {
        Intent intent = new Intent();
        intent.setData(uri);
        try {
            if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
                return false;
            }
        } catch (Exception e) {
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e2) {
            return false;
        }
    }
}
