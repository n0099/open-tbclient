package com.baidu.yuyinala.privatemessage.session.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/* loaded from: classes11.dex */
public class h {
    private static h pjR = null;
    private Map<String, String> pjS = new HashMap();
    private HashSet<String> pjT = new HashSet<>();

    public static h emZ() {
        if (pjR == null) {
            synchronized (h.class) {
                if (pjR == null) {
                    pjR = new h();
                }
            }
        }
        return pjR;
    }

    public Map<String, String> ena() {
        return this.pjS;
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
                gVar.aUb();
                return;
            }
            return;
        }
        hashMap.put("nicknameapi", sb.toString());
        a(context, hashMap, gVar);
    }

    private void a(Context context, HashMap<String, String> hashMap, g gVar) {
    }

    public String YE(String str) {
        return this.pjS.get(str);
    }
}
