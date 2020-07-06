package com.baidu.tieba.play.cyberPlayer;

import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private HashMap<String, Integer> kVA;
    private boolean kVy;
    private boolean kVz;

    public void dG(JSONObject jSONObject) {
        if (jSONObject != null) {
            boolean z = this.kVy;
            this.kVy = jSONObject.optInt("switch", 0) == 1;
            this.kVz = jSONObject.optInt("p2p_config", 0) == 1;
            JSONArray optJSONArray = jSONObject.optJSONArray("domain_list");
            if (optJSONArray != null) {
                this.kVA = new HashMap<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString = optJSONArray.optString(i);
                    if (!StringUtils.isNull(optString)) {
                        this.kVA.put(optString, 0);
                    }
                }
            }
            if (this.kVy) {
                c.init();
                if (!z) {
                    Intent intent = new Intent(TbadkCoreApplication.getInst().getContext(), CyberRemotePlayerService.class);
                    intent.putExtra("pcdn", true);
                    TbadkCoreApplication.getInst().getContext().startService(intent);
                    e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.play.cyberPlayer.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TbadkCoreApplication.getInst().getContext().stopService(new Intent(TbadkCoreApplication.getInst().getContext(), CyberRemotePlayerService.class));
                        }
                    }, 3000L);
                }
            }
        }
    }

    public boolean cVY() {
        if (this.kVy) {
            c.init();
        }
        return this.kVy;
    }

    public boolean cVZ() {
        return this.kVz;
    }

    public boolean y(Uri uri) {
        if (this.kVA == null || uri == null) {
            return false;
        }
        return this.kVA.containsKey(uri.getHost());
    }
}
