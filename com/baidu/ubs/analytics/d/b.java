package com.baidu.ubs.analytics.d;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: classes2.dex */
public final class b {
    private static boolean hBw;
    private static boolean hCw;
    private static StringBuffer hCx = new StringBuffer();

    static {
        if (com.baidu.ubs.analytics.d.bKq() != null) {
            hBw = !a.bKK();
            hCw = true;
            hCx.append("ABsdkLog-");
            hCx.append(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            hCx.append("_");
            try {
                hCx.append(a(com.baidu.ubs.analytics.c.i.k(com.baidu.ubs.analytics.d.bKq().getContext()).getBytes("UTF-8")));
            } catch (UnsupportedEncodingException e) {
                j.a(e);
            } catch (Exception e2) {
                j.a(e2);
            }
            hCx.append(".log");
        }
    }

    public static String bKM() {
        return hCx.toString();
    }

    public static void wc(String str) {
        if (hBw) {
            Log.w("BaiDuUbs", str);
        }
        a("w", "BaiDuUbs", str);
    }

    public static void wd(String str) {
        if (hBw) {
            Log.e("BaiDuUbs", str);
        }
        a("e", "BaiDuUbs", str);
    }

    private static void a(final String str, final String str2, final String str3) {
        if (hCw) {
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
                    g.J(stringBuffer.toString(), a.hCt, b.hCx.toString());
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
