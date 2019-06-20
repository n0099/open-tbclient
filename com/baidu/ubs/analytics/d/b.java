package com.baidu.ubs.analytics.d;

import android.util.Log;
import com.baidu.mobstat.Config;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public final class b {
    private static boolean jPj;
    private static boolean jQh;
    private static StringBuffer jQi = new StringBuffer();

    static {
        if (com.baidu.ubs.analytics.d.cAm() != null) {
            jPj = !a.cAH();
            jQh = true;
            jQi.append("ABsdkLog-");
            jQi.append(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            jQi.append("_");
            try {
                jQi.append(a(com.baidu.ubs.analytics.c.i.k(com.baidu.ubs.analytics.d.cAm().getContext()).getBytes(HTTP.UTF_8)));
            } catch (UnsupportedEncodingException e) {
                j.a(e);
            } catch (Exception e2) {
                j.a(e2);
            }
            jQi.append(".log");
        }
    }

    public static String cAJ() {
        return jQi.toString();
    }

    public static void Gs(String str) {
        if (jPj) {
            Log.w("BaiDuUbs", str);
        }
        a(Config.DEVICE_WIDTH, "BaiDuUbs", str);
    }

    public static void Gt(String str) {
        if (jPj) {
            Log.e("BaiDuUbs", str);
        }
        a("e", "BaiDuUbs", str);
    }

    private static void a(final String str, final String str2, final String str3) {
        if (jQh) {
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
                    g.b(stringBuffer.toString(), a.jQe, b.jQi.toString());
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
