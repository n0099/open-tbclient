package com.baidu.ubs.analytics.d;

import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: classes6.dex */
public final class b {
    private static boolean kUW;
    private static boolean kVW;
    private static StringBuffer kVX = new StringBuffer();

    static {
        if (com.baidu.ubs.analytics.d.cVY() != null) {
            kUW = !a.cWx();
            kVW = true;
            kVX.append("ABsdkLog-");
            kVX.append(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            kVX.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            try {
                kVX.append(a(com.baidu.ubs.analytics.c.i.k(com.baidu.ubs.analytics.d.cVY().getContext()).getBytes("UTF-8")));
            } catch (UnsupportedEncodingException e) {
                j.a(e);
            } catch (Exception e2) {
                j.a(e2);
            }
            kVX.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
        }
    }

    public static String cWz() {
        return kVX.toString();
    }

    public static void Le(String str) {
        if (kUW) {
            Log.w("BaiDuUbs", str);
        }
        a("w", "BaiDuUbs", str);
    }

    public static void Lf(String str) {
        if (kUW) {
            Log.e("BaiDuUbs", str);
        }
        a("e", "BaiDuUbs", str);
    }

    private static void a(final String str, final String str2, final String str3) {
        if (kVW) {
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
                    g.b(stringBuffer.toString(), a.kVU, b.kVX.toString());
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
