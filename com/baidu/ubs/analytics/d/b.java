package com.baidu.ubs.analytics.d;

import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: classes3.dex */
public final class b {
    private static boolean oJo;
    private static boolean oKj;
    private static StringBuffer oKk = new StringBuffer();

    static {
        if (com.baidu.ubs.analytics.d.efH() != null) {
            oJo = !a.efU();
            oKj = true;
            oKk.append("ABsdkLog-");
            oKk.append(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            oKk.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            try {
                oKk.append(a(com.baidu.ubs.analytics.c.i.k(com.baidu.ubs.analytics.d.efH().getContext()).getBytes("UTF-8")));
            } catch (UnsupportedEncodingException e) {
                j.a(e);
            } catch (Exception e2) {
                j.a(e2);
            }
            oKk.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
        }
    }

    public static String efW() {
        return oKk.toString();
    }

    public static void WE(String str) {
        if (oJo) {
            Log.w("BaiDuUbs", str);
        }
        a("w", "BaiDuUbs", str);
    }

    public static void I(String str) {
        if (oJo) {
            Log.e("BaiDuUbs", str);
        }
        a("e", "BaiDuUbs", str);
    }

    private static void a(final String str, final String str2, final String str3) {
        if (oKj) {
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
                    g.b(stringBuffer.toString(), a.oKi, b.oKk.toString());
                }
            });
        }
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }
}
