package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class t extends ch {
    private final Context e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(Context context) {
        super(false, false);
        this.e = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.ch
    public boolean a(JSONObject jSONObject) {
        String str;
        try {
            str = Settings.Secure.getString(this.e.getContentResolver(), "android_id");
        } catch (Exception e) {
            au.c("", e);
            str = null;
        }
        if (!m.d(str) || "9774d56d682e549c".equals(str)) {
            SharedPreferences sharedPreferences = this.e.getSharedPreferences("snssdk_openudid", 0);
            str = sharedPreferences.getString("openudid", null);
            if (!m.d(str)) {
                str = new BigInteger(64, new SecureRandom()).toString(16);
                if (str.charAt(0) == '-') {
                    str = str.substring(1);
                }
                int length = 13 - str.length();
                if (length > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (length > 0) {
                        sb.append('F');
                        length--;
                    }
                    sb.append(str);
                    str = sb.toString();
                }
                try {
                    str = a("openudid.dat", str);
                } catch (Exception e2) {
                }
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("openudid", str);
                edit.apply();
            }
        }
        jSONObject.put("openudid", str);
        return true;
    }
}
