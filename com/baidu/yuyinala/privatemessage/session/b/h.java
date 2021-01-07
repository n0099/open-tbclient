package com.baidu.yuyinala.privatemessage.session.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/* loaded from: classes11.dex */
public class h {
    private static h pdF = null;
    private Map<String, String> pdG = new HashMap();
    private HashSet<String> pdH = new HashSet<>();

    public static h eov() {
        if (pdF == null) {
            synchronized (h.class) {
                if (pdF == null) {
                    pdF = new h();
                }
            }
        }
        return pdF;
    }

    public Map<String, String> eow() {
        return this.pdG;
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
                gVar.aXJ();
                return;
            }
            return;
        }
        hashMap.put("nicknameapi", sb.toString());
        a(context, hashMap, gVar);
    }

    private void a(Context context, HashMap<String, String> hashMap, g gVar) {
    }

    public String Yy(String str) {
        return this.pdG.get(str);
    }
}
