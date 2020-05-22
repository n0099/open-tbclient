package com.baidu.tieba.play.cyberPlayer;

import android.net.Uri;
import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean kAv;
    private boolean kAw;
    private HashMap<String, Integer> kAx;

    public void dw(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.kAv = jSONObject.optInt("switch", 0) == 1;
            this.kAw = jSONObject.optInt("p2p_config", 0) == 1;
            JSONArray optJSONArray = jSONObject.optJSONArray("domain_list");
            if (optJSONArray != null) {
                this.kAx = new HashMap<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString = optJSONArray.optString(i);
                    if (!StringUtils.isNull(optString)) {
                        this.kAx.put(optString, 0);
                    }
                }
            }
        }
    }

    public boolean cRq() {
        if (this.kAv) {
            c.init();
        }
        return this.kAv;
    }

    public boolean cRr() {
        return this.kAw;
    }

    public boolean y(Uri uri) {
        if (this.kAx == null || uri == null) {
            return false;
        }
        return this.kAx.containsKey(uri.getHost());
    }
}
