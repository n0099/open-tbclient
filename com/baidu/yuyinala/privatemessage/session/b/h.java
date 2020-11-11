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
    private static h oGK = null;
    private Map<String, String> oGL = new HashMap();
    private HashSet<String> oGM = new HashSet<>();

    public static h eix() {
        if (oGK == null) {
            synchronized (h.class) {
                if (oGK == null) {
                    oGK = new h();
                }
            }
        }
        return oGK;
    }

    public Map<String, String> eiy() {
        return this.oGL;
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
                gVar.aSR();
                return;
            }
            return;
        }
        hashMap.put("nicknameapi", sb.toString());
        a(context, hashMap, gVar);
    }

    private void a(Context context, HashMap<String, String> hashMap, g gVar) {
    }

    public String XJ(String str) {
        return this.oGL.get(str);
    }
}
