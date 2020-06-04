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
    private boolean kBB;
    private boolean kBC;
    private HashMap<String, Integer> kBD;

    public void dw(JSONObject jSONObject) {
        if (jSONObject != null) {
            boolean z = this.kBB;
            this.kBB = jSONObject.optInt("switch", 0) == 1;
            this.kBC = jSONObject.optInt("p2p_config", 0) == 1;
            JSONArray optJSONArray = jSONObject.optJSONArray("domain_list");
            if (optJSONArray != null) {
                this.kBD = new HashMap<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString = optJSONArray.optString(i);
                    if (!StringUtils.isNull(optString)) {
                        this.kBD.put(optString, 0);
                    }
                }
            }
            if (this.kBB) {
                c.init();
                if (!z) {
                    Intent intent = new Intent(TbadkCoreApplication.getInst().getContext(), CyberRemotePlayerService.class);
                    intent.putExtra("pcdn", true);
                    TbadkCoreApplication.getInst().getContext().startService(intent);
                    e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.play.cyberPlayer.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TbadkCoreApplication.getInst().getContext().stopService(new Intent(TbadkCoreApplication.getInst().getContext(), CyberRemotePlayerService.class));
                        }
                    }, 3000L);
                }
            }
        }
    }

    public boolean cRG() {
        if (this.kBB) {
            c.init();
        }
        return this.kBB;
    }

    public boolean cRH() {
        return this.kBC;
    }

    public boolean y(Uri uri) {
        if (this.kBD == null || uri == null) {
            return false;
        }
        return this.kBD.containsKey(uri.getHost());
    }
}
