package com.baidu.tieba.play.cyberPlayer;

import android.net.Uri;
import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean kiw;
    private boolean kix;
    private HashMap<String, Integer> kiy;

    public void dp(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.kiw = jSONObject.optInt("switch", 0) == 1;
            this.kix = jSONObject.optInt("p2p_config", 0) == 1;
            JSONArray optJSONArray = jSONObject.optJSONArray("domain_list");
            if (optJSONArray != null) {
                this.kiy = new HashMap<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString = optJSONArray.optString(i);
                    if (!StringUtils.isNull(optString)) {
                        this.kiy.put(optString, 0);
                    }
                }
            }
        }
    }

    public boolean cKt() {
        if (this.kiw) {
            c.init();
        }
        return this.kiw;
    }

    public boolean cKu() {
        return this.kix;
    }

    public boolean v(Uri uri) {
        if (this.kiy == null || uri == null) {
            return false;
        }
        return this.kiy.containsKey(uri.getHost());
    }
}
