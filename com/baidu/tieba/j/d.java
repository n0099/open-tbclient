package com.baidu.tieba.j;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.j.g;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class d {
    public static boolean c(File file, String str) {
        return a(file, str, true);
    }

    public static boolean a(File file, String str, boolean z) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                fileOutputStream = new FileOutputStream(file, z);
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(str.getBytes());
            fileOutputStream.flush();
            com.baidu.adp.lib.g.a.close((OutputStream) fileOutputStream);
            return true;
        } catch (Exception e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            com.baidu.adp.lib.g.a.close((OutputStream) fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            com.baidu.adp.lib.g.a.close((OutputStream) fileOutputStream2);
            throw th;
        }
    }

    public static void zL(String str) {
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
    }

    public static String x(File file) {
        FileInputStream fileInputStream;
        StringBuilder sb = new StringBuilder();
        try {
            fileInputStream = new FileInputStream(file);
            try {
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        sb.append(new String(bArr, 0, read));
                    }
                    com.baidu.adp.lib.g.a.close((InputStream) fileInputStream);
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    com.baidu.adp.lib.g.a.close((InputStream) fileInputStream);
                    return sb.toString();
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.adp.lib.g.a.close((InputStream) fileInputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            com.baidu.adp.lib.g.a.close((InputStream) fileInputStream);
            throw th;
        }
        return sb.toString();
    }

    public static JSONArray zM(String str) {
        JSONArray jSONArray = new JSONArray();
        if (StringUtils.isNull(str)) {
            return jSONArray;
        }
        File file = new File(str);
        if (file.exists()) {
            String x = x(file);
            String[] split = x.split("\n");
            if (split.length > 0) {
                for (String str2 : split) {
                    b(str2, jSONArray);
                }
            } else {
                b(x, jSONArray);
            }
            com.baidu.tbadk.core.util.m.deleteFile(file);
            return jSONArray;
        }
        return jSONArray;
    }

    private static void b(String str, JSONArray jSONArray) {
        if (!StringUtils.isNull(str) && jSONArray != null) {
            try {
                JSONArray jSONArray2 = new JSONArray(str);
                for (int i = 0; i < jSONArray2.length(); i++) {
                    jSONArray.put(jSONArray2.optJSONObject(i));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void zN(String str) {
        if (!StringUtils.isNull(str)) {
            com.baidu.tbadk.core.util.m.deleteFileOrDir(new File(g.a.hwk + g.a.hwb + str));
        }
    }
}
