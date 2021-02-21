package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class q extends ch {
    private final Context e;
    private final cn pmW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(Context context, cn cnVar) {
        super(true, false);
        this.e = context;
        this.pmW = cnVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.ch
    public boolean a(JSONObject jSONObject) {
        String mac = b.enD() != null ? b.enD().enW().getMac() : "";
        if (!TextUtils.isEmpty(mac)) {
            jSONObject.put(Config.DEVICE_MAC_ID, mac);
            return true;
        }
        return true;
    }
}
