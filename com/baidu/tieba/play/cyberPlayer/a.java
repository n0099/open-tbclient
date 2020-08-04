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
    private boolean lcT;
    private boolean lcU;
    private HashMap<String, Integer> lcV;

    public void dN(JSONObject jSONObject) {
        if (jSONObject != null) {
            boolean z = this.lcT;
            this.lcT = jSONObject.optInt("switch", 0) == 1;
            this.lcU = jSONObject.optInt("p2p_config", 0) == 1;
            JSONArray optJSONArray = jSONObject.optJSONArray("domain_list");
            if (optJSONArray != null) {
                this.lcV = new HashMap<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString = optJSONArray.optString(i);
                    if (!StringUtils.isNull(optString)) {
                        this.lcV.put(optString, 0);
                    }
                }
            }
            if (this.lcT) {
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

    public boolean cZc() {
        if (this.lcT) {
            c.init();
        }
        return this.lcT;
    }

    public boolean cZd() {
        return this.lcU;
    }

    public boolean x(Uri uri) {
        if (this.lcV == null || uri == null) {
            return false;
        }
        return this.lcV.containsKey(uri.getHost());
    }
}
