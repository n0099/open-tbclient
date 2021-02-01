package com.baidu.yuyinala.privatemessage.session.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/* loaded from: classes11.dex */
public class h {
    private static h pjr = null;
    private Map<String, String> pjs = new HashMap();
    private HashSet<String> pjt = new HashSet<>();

    public static h emR() {
        if (pjr == null) {
            synchronized (h.class) {
                if (pjr == null) {
                    pjr = new h();
                }
            }
        }
        return pjr;
    }

    public Map<String, String> emS() {
        return this.pjs;
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

    public String Ys(String str) {
        return this.pjs.get(str);
    }
}
