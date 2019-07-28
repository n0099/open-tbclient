package com.baidu.ubs.analytics.d;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public final class b {
    private static boolean jWi;
    private static boolean jXi;
    private static StringBuffer jXj = new StringBuffer();

    static {
        if (com.baidu.ubs.analytics.d.cDk() != null) {
            jWi = !a.cDG();
            jXi = true;
            jXj.append("ABsdkLog-");
            jXj.append(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            jXj.append("_");
            try {
                jXj.append(a(com.baidu.ubs.analytics.c.i.k(com.baidu.ubs.analytics.d.cDk().getContext()).getBytes(HTTP.UTF_8)));
            } catch (UnsupportedEncodingException e) {
                j.a(e);
            } catch (Exception e2) {
                j.a(e2);
            }
            jXj.append(".log");
        }
    }

    public static String cDI() {
        return jXj.toString();
    }

    public static void Hm(String str) {
        if (jWi) {
            Log.w("BaiDuUbs", str);
        }
        a("w", "BaiDuUbs", str);
    }

    public static void Hn(String str) {
        if (jWi) {
            Log.e("BaiDuUbs", str);
        }
        a("e", "BaiDuUbs", str);
    }

    private static void a(final String str, final String str2, final String str3) {
        if (jXi) {
            c.a(new d() { // from class: com.baidu.ubs.analytics.d.b.1
                @Override // com.baidu.ubs.analytics.d.d
                protected final void a() {
                    StringBuffer stringBuffer = new StringBuffer();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss:SSS");
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
                    stringBuffer.append(simpleDateFormat.format(new Date()));
                    stringBuffer.append("\t");
                    stringBuffer.append(str);
                    stringBuffer.append("\t");
                    stringBuffer.append(str2);
                    stringBuffer.append("\t");
                    stringBuffer.append(str3);
                    g.b(stringBuffer.toString(), a.jXf, b.jXj.toString());
                }
            });
        }
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }
}
