package com.baidu.tieba.play.c;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    private List<a> mList = new ArrayList();

    public void ad(String str, String str2, String str3) {
        this.mList.add(new a(str, str2, str3));
    }

    public String cdo() {
        JSONObject jSONObject = new JSONObject();
        try {
            int size = this.mList.size();
            for (int i = 0; i < size; i++) {
                jSONObject.put(i + "", this.mList.get(i).cdp());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* loaded from: classes.dex */
    private static class a {
        public final String error;
        public final String iAv;
        public final String uuid;

        public a(String str, String str2, String str3) {
            this.uuid = str;
            this.error = str2;
            this.iAv = str3;
        }

        public JSONObject cdp() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("uuid", this.uuid);
                jSONObject.put(BdStatsConstant.StatsType.ERROR, this.error);
                jSONObject.put("sub_error", this.iAv);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }
}
