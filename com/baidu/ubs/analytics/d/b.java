package com.baidu.ubs.analytics.d;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: classes.dex */
public final class b {
    private static boolean hxp;
    private static boolean hyp;
    private static StringBuffer hyq = new StringBuffer();

    static {
        if (com.baidu.ubs.analytics.d.bJP() != null) {
            hxp = !a.bKj();
            hyp = true;
            hyq.append("ABsdkLog-");
            hyq.append(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            hyq.append("_");
            try {
                hyq.append(a(com.baidu.ubs.analytics.c.i.k(com.baidu.ubs.analytics.d.bJP().getContext()).getBytes("UTF-8")));
            } catch (UnsupportedEncodingException e) {
                j.a(e);
            } catch (Exception e2) {
                j.a(e2);
            }
            hyq.append(".log");
        }
    }

    public static String bKl() {
        return hyq.toString();
    }

    public static void wg(String str) {
        if (hxp) {
            Log.w("BaiDuUbs", str);
        }
        a("w", "BaiDuUbs", str);
    }

    public static void wh(String str) {
        if (hxp) {
            Log.e("BaiDuUbs", str);
        }
        a("e", "BaiDuUbs", str);
    }

    private static void a(final String str, final String str2, final String str3) {
        if (hyp) {
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
                    g.L(stringBuffer.toString(), a.hym, b.hyq.toString());
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
