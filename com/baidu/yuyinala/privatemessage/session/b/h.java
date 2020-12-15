package com.baidu.yuyinala.privatemessage.session.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/* loaded from: classes4.dex */
public class h {
    private static h oXw = null;
    private Map<String, String> oXx = new HashMap();
    private HashSet<String> oXy = new HashSet<>();

    public static h eom() {
        if (oXw == null) {
            synchronized (h.class) {
                if (oXw == null) {
                    oXw = new h();
                }
            }
        }
        return oXw;
    }

    public Map<String, String> eon() {
        return this.oXx;
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
            sb.append(str + ",");
            z = true;
        }
        if (!z) {
            if (gVar != null) {
                gVar.aVo();
                return;
            }
            return;
        }
        hashMap.put("nicknameapi", sb.toString());
        a(context, hashMap, gVar);
    }

    private void a(Context context, HashMap<String, String> hashMap, g gVar) {
    }

    public String YP(String str) {
        return this.oXx.get(str);
    }
}
