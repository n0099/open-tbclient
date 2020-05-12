package com.baidu.tieba.play.cyberPlayer;

import android.net.Uri;
import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean kiA;
    private boolean kiB;
    private HashMap<String, Integer> kiC;

    public void dp(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.kiA = jSONObject.optInt("switch", 0) == 1;
            this.kiB = jSONObject.optInt("p2p_config", 0) == 1;
            JSONArray optJSONArray = jSONObject.optJSONArray("domain_list");
            if (optJSONArray != null) {
                this.kiC = new HashMap<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString = optJSONArray.optString(i);
                    if (!StringUtils.isNull(optString)) {
                        this.kiC.put(optString, 0);
                    }
                }
            }
        }
    }

    public boolean cKr() {
        if (this.kiA) {
            c.init();
        }
        return this.kiA;
    }

    public boolean cKs() {
        return this.kiB;
    }

    public boolean v(Uri uri) {
        if (this.kiC == null || uri == null) {
            return false;
        }
        return this.kiC.containsKey(uri.getHost());
    }
}
