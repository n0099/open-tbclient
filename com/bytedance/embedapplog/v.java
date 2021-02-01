package com.bytedance.embedapplog;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobstat.Config;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class v extends ch {
    /* JADX INFO: Access modifiers changed from: package-private */
    public v() {
        super(true, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.ch
    public boolean a(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder(16);
        if (a()) {
            sb.append("MIUI-");
        } else if (b()) {
            sb.append("FLYME-");
        } else {
            String d = d();
            if (a(d)) {
                sb.append("EMUI-");
            }
            if (!TextUtils.isEmpty(d)) {
                sb.append(d).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            }
        }
        sb.append(Build.VERSION.INCREMENTAL);
        jSONObject.put(Config.ROM, sb.toString());
        return true;
    }

    private boolean a() {
        try {
            return Class.forName("miui.os.Build").getName().length() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean b() {
        return (!TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.contains("Flyme")) || "flyme".equals(Build.USER);
    }

    private boolean c() {
        return (!TextUtils.isEmpty(Build.BRAND) && Build.BRAND.toLowerCase().startsWith(RomUtils.MANUFACTURER_HUAWEI)) || (!TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith(RomUtils.MANUFACTURER_HUAWEI));
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = d();
        }
        if (TextUtils.isEmpty(str) || !str.toLowerCase().startsWith("emotionui")) {
            return c();
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [89=4] */
    private String d() {
        BufferedReader bufferedReader;
        String str;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.build.version.emui").getInputStream()), 1024);
            try {
                str = bufferedReader.readLine();
            } catch (Throwable th) {
                th = th;
                str = null;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
            str = null;
        }
        try {
            bufferedReader.close();
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                }
            }
        } catch (Throwable th3) {
            th = th3;
            try {
                au.a(th);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                    }
                }
                return str;
            } catch (Throwable th4) {
                BufferedReader bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e3) {
                    }
                }
                throw th4;
            }
        }
        return str;
    }
}
