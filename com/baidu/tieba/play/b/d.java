package com.baidu.tieba.play.b;

import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d implements b {
    public final int fRE;
    public final int fRF;
    public final String msg;
    public final int what;

    public d(int i, int i2, int i3) {
        this.fRE = i;
        this.what = i2;
        this.fRF = i3;
        this.msg = "";
    }

    public d(int i, int i2, int i3, String str) {
        this.fRE = i;
        this.what = i2;
        this.fRF = i3;
        this.msg = str;
    }

    @Override // com.baidu.tieba.play.b.b
    public JSONObject bjQ() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.fRE == -100) {
                str = "system";
            } else if (this.fRE == -200) {
                str = "ijkplayer";
            } else {
                str = "unknown";
            }
            jSONObject.put("player", str);
            jSONObject.put("what", this.what);
            jSONObject.put(ISapiAccount.SAPI_ACCOUNT_EXTRA, this.fRF);
            jSONObject.put(AddFriendActivityConfig.MSG, this.msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
