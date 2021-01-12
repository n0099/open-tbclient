package com.baidu.yuyinala.privatemessage.session.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/* loaded from: classes10.dex */
public class h {
    private static h oZa = null;
    private Map<String, String> oZb = new HashMap();
    private HashSet<String> oZc = new HashSet<>();

    public static h ekz() {
        if (oZa == null) {
            synchronized (h.class) {
                if (oZa == null) {
                    oZa = new h();
                }
            }
        }
        return oZa;
    }

    public Map<String, String> ekA() {
        return this.oZb;
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
                gVar.aTP();
                return;
            }
            return;
        }
        hashMap.put("nicknameapi", sb.toString());
        a(context, hashMap, gVar);
    }

    private void a(Context context, HashMap<String, String> hashMap, g gVar) {
    }

    public String Xq(String str) {
        return this.oZb.get(str);
    }
}
