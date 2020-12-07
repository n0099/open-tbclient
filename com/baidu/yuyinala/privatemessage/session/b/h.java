package com.baidu.yuyinala.privatemessage.session.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/* loaded from: classes4.dex */
public class h {
    private static h oXu = null;
    private Map<String, String> oXv = new HashMap();
    private HashSet<String> oXw = new HashSet<>();

    public static h eol() {
        if (oXu == null) {
            synchronized (h.class) {
                if (oXu == null) {
                    oXu = new h();
                }
            }
        }
        return oXu;
    }

    public Map<String, String> eom() {
        return this.oXv;
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
        return this.oXv.get(str);
    }
}
