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
    private static h oIo = null;
    private Map<String, String> oIp = new HashMap();
    private HashSet<String> oIq = new HashSet<>();

    public static h eiv() {
        if (oIo == null) {
            synchronized (h.class) {
                if (oIo == null) {
                    oIo = new h();
                }
            }
        }
        return oIo;
    }

    public Map<String, String> eiw() {
        return this.oIp;
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
                gVar.aSj();
                return;
            }
            return;
        }
        hashMap.put("nicknameapi", sb.toString());
        a(context, hashMap, gVar);
    }

    private void a(Context context, HashMap<String, String> hashMap, g gVar) {
    }

    public String Xu(String str) {
        return this.oIp.get(str);
    }
}
