package com.baidu.yuyinala.privatemessage.session.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/* loaded from: classes4.dex */
public class h {
    private static h oxr = null;
    private Map<String, String> oxs = new HashMap();
    private HashSet<String> oxt = new HashSet<>();

    public static h eeI() {
        if (oxr == null) {
            synchronized (h.class) {
                if (oxr == null) {
                    oxr = new h();
                }
            }
        }
        return oxr;
    }

    public Map<String, String> eeJ() {
        return this.oxs;
    }

    public static String encode(String str) {
        return ExtraParamsManager.getEncryptionUserId(str);
    }

    public void a(Context context, String str, int i, g gVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        sb.append("uk=");
        boolean z = false;
        if (!TextUtils.isEmpty(str)) {
            sb.append(str + Constants.ACCEPT_TIME_SEPARATOR_SP);
            z = true;
        }
        if (!z) {
            if (gVar != null) {
                gVar.aQr();
                return;
            }
            return;
        }
        hashMap.put("nicknameapi", sb.toString());
        a(context, hashMap, gVar);
    }

    private void a(Context context, HashMap<String, String> hashMap, g gVar) {
    }

    public String Xf(String str) {
        return this.oxs.get(str);
    }
}
