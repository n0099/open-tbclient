package com.baidu.ufosdk.f;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.StatFs;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes5.dex */
public final class f {

    /* renamed from: c  reason: collision with root package name */
    public static String f22643c = Environment.getExternalStorageDirectory().getPath() + "/image_cache";

    /* renamed from: d  reason: collision with root package name */
    public static f f22644d = null;

    /* renamed from: b  reason: collision with root package name */
    public final String f22646b = "ufo";

    /* renamed from: a  reason: collision with root package name */
    public final int f22645a = 1209600000;

    public static Bitmap a(String str) {
        Bitmap decodeFile;
        String b2 = b(str);
        if (new File(b2).exists() && (decodeFile = BitmapFactory.decodeFile(b2, null)) != null) {
            new File(f22643c + "/cache/image/", b2).setLastModified(System.currentTimeMillis());
            return decodeFile;
        }
        return null;
    }

    public static f a() {
        if (f22644d == null) {
            f22644d = new f();
        }
        return f22644d;
    }

    public static String b(String str) {
        return f22643c + "/cache/image/" + str;
    }

    public static void b() {
        String str = f22643c + "/cache/image/";
        File[] listFiles = new File(str).listFiles();
        if (listFiles == null) {
            return;
        }
        c.b("ufo ->Clear all cache files,dir=" + str);
        for (File file : listFiles) {
            file.delete();
        }
    }

    public static int c() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return (int) ((statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1048576.0d);
        }
        c.a("sdCard is not exist");
        return 0;
    }

    private void c(String str) {
        File[] listFiles = new File(str).listFiles();
        if (listFiles == null) {
            return;
        }
        int i = 0;
        for (File file : listFiles) {
            i = (int) (i + file.length());
        }
        if (i > 20971520 || 20 > c()) {
            int length = (int) ((listFiles.length * 0.4d) + 1.0d);
            Arrays.sort(listFiles, new g(this));
            c.b("ufo ->Clear some expiredcache files");
            for (int i2 = 0; i2 < length; i2++) {
                listFiles[i2].delete();
            }
        }
    }

    public final void a(Bitmap bitmap, String str) {
        try {
            boolean equals = Environment.getExternalStorageState().equals("mounted");
            if (equals) {
                File file = new File(b(str));
                if (20 > c()) {
                    c.c("ufo ->Low free space onsd, do not cache");
                    return;
                }
                c(f22643c + "/cache/image/");
                if (equals) {
                    File file2 = new File(f22643c);
                    File file3 = new File(f22643c + "/cache");
                    File file4 = new File(f22643c + "/cache/image");
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    if (!file3.exists()) {
                        file3.mkdir();
                    }
                    if (!file4.exists()) {
                        file4.mkdir();
                    }
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                }
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream);
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
