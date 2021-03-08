package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class q extends ch {
    private final Context e;
    private final cn ppe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(Context context, cn cnVar) {
        super(true, false);
        this.e = context;
        this.ppe = cnVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.ch
    public boolean a(JSONObject jSONObject) {
        String mac = b.enN() != null ? b.enN().eoh().getMac() : "";
        if (!TextUtils.isEmpty(mac)) {
            jSONObject.put(Config.DEVICE_MAC_ID, mac);
            return true;
        }
        return true;
    }
}
