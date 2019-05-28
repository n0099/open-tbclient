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
    private static boolean jPg;
    private static boolean jQe;
    private static StringBuffer jQf = new StringBuffer();

    static {
        if (com.baidu.ubs.analytics.d.cAn() != null) {
            jPg = !a.cAI();
            jQe = true;
            jQf.append("ABsdkLog-");
            jQf.append(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            jQf.append("_");
            try {
                jQf.append(a(com.baidu.ubs.analytics.c.i.k(com.baidu.ubs.analytics.d.cAn().getContext()).getBytes(HTTP.UTF_8)));
            } catch (UnsupportedEncodingException e) {
                j.a(e);
            } catch (Exception e2) {
                j.a(e2);
            }
            jQf.append(".log");
        }
    }

    public static String cAK() {
        return jQf.toString();
    }

    public static void Gq(String str) {
        if (jPg) {
            Log.w("BaiDuUbs", str);
        }
        a(Config.DEVICE_WIDTH, "BaiDuUbs", str);
    }

    public static void Gr(String str) {
        if (jPg) {
            Log.e("BaiDuUbs", str);
        }
        a("e", "BaiDuUbs", str);
    }

    private static void a(final String str, final String str2, final String str3) {
        if (jQe) {
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
                    g.b(stringBuffer.toString(), a.jQb, b.jQf.toString());
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
