package com.baidu.ubs.analytics.d;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: classes2.dex */
public final class b {
    private static boolean hCb;
    private static boolean hDb;
    private static StringBuffer hDc = new StringBuffer();

    static {
        if (com.baidu.ubs.analytics.d.bIU() != null) {
            hCb = !a.bJo();
            hDb = true;
            hDc.append("ABsdkLog-");
            hDc.append(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            hDc.append("_");
            try {
                hDc.append(a(com.baidu.ubs.analytics.c.i.k(com.baidu.ubs.analytics.d.bIU().getContext()).getBytes("UTF-8")));
            } catch (UnsupportedEncodingException e) {
                j.a(e);
            } catch (Exception e2) {
                j.a(e2);
            }
            hDc.append(".log");
        }
    }

    public static String bJq() {
        return hDc.toString();
    }

    public static void wd(String str) {
        if (hCb) {
            Log.w("BaiDuUbs", str);
        }
        a("w", "BaiDuUbs", str);
    }

    public static void we(String str) {
        if (hCb) {
            Log.e("BaiDuUbs", str);
        }
        a("e", "BaiDuUbs", str);
    }

    private static void a(final String str, final String str2, final String str3) {
        if (hDb) {
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
                    g.k(stringBuffer.toString(), a.hCY, b.hDc.toString());
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
