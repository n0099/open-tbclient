package com.baidu.tieba.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import java.io.File;
/* loaded from: classes.dex */
public class br {
    private static br a;

    public static synchronized br a() {
        br brVar;
        synchronized (br.class) {
            if (a == null) {
                a = new br();
            }
            brVar = a;
        }
        return brVar;
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
        return af.c(d(str), str);
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return af.b(d(str), str);
    }

    public int c(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) af.a(d(str), str);
    }

    public boolean a(String str, String str2) {
        String str3 = af.a + "/" + com.baidu.tieba.data.i.k() + "/";
        if (!af.a(str3)) {
            af.l(str3);
        }
        String str4 = String.valueOf(str3) + d(str2);
        if (!af.a(str4)) {
            af.l(str4);
        }
        String str5 = String.valueOf(str4) + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return af.a(str, str5, true);
    }

    public void a(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            af.a(d(str), str, bArr);
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
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "run", "list[i].delete error");
                }
            }
        }
    }

    public void b() {
        a(new File(af.a + "/" + com.baidu.tieba.data.i.k() + "/image"));
    }
}
