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
    private boolean mkb;
    private boolean mkc;
    private HashMap<String, Integer> mkd;

    public void ew(JSONObject jSONObject) {
        if (jSONObject != null) {
            boolean z = this.mkb;
            this.mkb = jSONObject.optInt("switch", 0) == 1;
            this.mkc = jSONObject.optInt("p2p_config", 0) == 1;
            JSONArray optJSONArray = jSONObject.optJSONArray("domain_list");
            if (optJSONArray != null) {
                this.mkd = new HashMap<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString = optJSONArray.optString(i);
                    if (!StringUtils.isNull(optString)) {
                        this.mkd.put(optString, 0);
                    }
                }
            }
            if (this.mkb) {
                c.init();
                if (!z) {
                    Intent intent = new Intent(TbadkCoreApplication.getInst().getContext(), CyberRemotePlayerService.class);
                    intent.putExtra("pcdn", true);
                    TbadkCoreApplication.getInst().getContext().startService(intent);
                    e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.play.cyberPlayer.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TbadkCoreApplication.getInst().getContext().stopService(new Intent(TbadkCoreApplication.getInst().getContext(), CyberRemotePlayerService.class));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                }
            }
        }
    }

    public boolean dxj() {
        if (this.mkb) {
            c.init();
        }
        return this.mkb;
    }

    public boolean dxk() {
        return this.mkc;
    }

    public boolean y(Uri uri) {
        if (this.mkd == null || uri == null) {
            return false;
        }
        return this.mkd.containsKey(uri.getHost());
    }
}
