package com.baidu.ubs.analytics.d;

import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.searchbox.ng.ai.apps.util.AiAppDateTimeUtil;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: classes6.dex */
public final class b {
    private static boolean icn;
    private static boolean idn;
    private static StringBuffer ido = new StringBuffer();

    static {
        if (com.baidu.ubs.analytics.d.bRJ() != null) {
            icn = !a.bSa();
            idn = true;
            ido.append("ABsdkLog-");
            ido.append(new SimpleDateFormat(AiAppDateTimeUtil.DATE_FORMAT).format(new Date()));
            ido.append(BaseRequestAction.SPLITE);
            try {
                ido.append(a(com.baidu.ubs.analytics.c.i.k(com.baidu.ubs.analytics.d.bRJ().getContext()).getBytes("UTF-8")));
            } catch (UnsupportedEncodingException e) {
                j.a(e);
            } catch (Exception e2) {
                j.a(e2);
            }
            ido.append(".log");
        }
    }

    public static String bSc() {
        return ido.toString();
    }

    public static void yA(String str) {
        if (icn) {
            Log.w("BaiDuUbs", str);
        }
        a(Config.DEVICE_WIDTH, "BaiDuUbs", str);
    }

    public static void yB(String str) {
        if (icn) {
            Log.e("BaiDuUbs", str);
        }
        a("e", "BaiDuUbs", str);
    }

    private static void a(final String str, final String str2, final String str3) {
        if (idn) {
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
                    g.n(stringBuffer.toString(), a.idj, b.ido.toString());
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
