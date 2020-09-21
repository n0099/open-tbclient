package com.baidu.tieba.play.cyberPlayer;

import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean lCp;
    private boolean lCq;
    private HashMap<String, Integer> lCr;

    public void eg(JSONObject jSONObject) {
        if (jSONObject != null) {
            boolean z = this.lCp;
            this.lCp = jSONObject.optInt("switch", 0) == 1;
            this.lCq = jSONObject.optInt("p2p_config", 0) == 1;
            JSONArray optJSONArray = jSONObject.optJSONArray("domain_list");
            if (optJSONArray != null) {
                this.lCr = new HashMap<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString = optJSONArray.optString(i);
                    if (!StringUtils.isNull(optString)) {
                        this.lCr.put(optString, 0);
                    }
                }
            }
            if (this.lCp) {
                c.init();
                if (!z) {
                    Intent intent = new Intent(TbadkCoreApplication.getInst().getContext(), CyberRemotePlayerService.class);
                    intent.putExtra("pcdn", true);
                    TbadkCoreApplication.getInst().getContext().startService(intent);
                    e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.play.cyberPlayer.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TbadkCoreApplication.getInst().getContext().stopService(new Intent(TbadkCoreApplication.getInst().getContext(), CyberRemotePlayerService.class));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                }
            }
        }
    }

    public boolean dnP() {
        if (this.lCp) {
            c.init();
        }
        return this.lCp;
    }

    public boolean dnQ() {
        return this.lCq;
    }

    public boolean y(Uri uri) {
        if (this.lCr == null || uri == null) {
            return false;
        }
        return this.lCr.containsKey(uri.getHost());
    }
}
