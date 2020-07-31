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
    private boolean lcR;
    private boolean lcS;
    private HashMap<String, Integer> lcT;

    public void dN(JSONObject jSONObject) {
        if (jSONObject != null) {
            boolean z = this.lcR;
            this.lcR = jSONObject.optInt("switch", 0) == 1;
            this.lcS = jSONObject.optInt("p2p_config", 0) == 1;
            JSONArray optJSONArray = jSONObject.optJSONArray("domain_list");
            if (optJSONArray != null) {
                this.lcT = new HashMap<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString = optJSONArray.optString(i);
                    if (!StringUtils.isNull(optString)) {
                        this.lcT.put(optString, 0);
                    }
                }
            }
            if (this.lcR) {
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
        if (this.lcR) {
            c.init();
        }
        return this.lcR;
    }

    public boolean cZd() {
        return this.lcS;
    }

    public boolean x(Uri uri) {
        if (this.lcT == null || uri == null) {
            return false;
        }
        return this.lcT.containsKey(uri.getHost());
    }
}
