package com.baidu.tieba.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import java.io.File;
/* loaded from: classes.dex */
public class bt {
    private static bt a;

    public static synchronized bt a() {
        bt btVar;
        synchronized (bt.class) {
            if (a == null) {
                a = new bt();
            }
            btVar = a;
        }
        return btVar;
    }

    private String d(String str) {
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public Bitmap a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return ad.c(d(str), str);
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return ad.b(d(str), str);
    }

    public int c(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) ad.a(d(str), str);
    }

    public boolean a(String str, String str2) {
        String str3 = ad.a + "/tieba/";
        if (!ad.a(str3)) {
            ad.k(str3);
        }
        String str4 = str3 + d(str2);
        if (!ad.a(str4)) {
            ad.k(str4);
        }
        String str5 = str4 + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return ad.a(str, str5, true);
    }

    public void a(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            ad.a(d(str), str, bArr);
        }
    }

    private void a(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    a(file2);
                    file2.delete();
                } else if (!file2.delete()) {
                    com.baidu.adp.lib.g.e.b(getClass().getName(), "run", "list[i].delete error");
                }
            }
        }
    }

    public void b() {
        a(new File(ad.a + "/tieba/image"));
    }
}
