package com.baidu.tieba.pb.data;

import com.baidu.tbadk.core.atomData.CardBoxMemberPayActivityConfig;
import org.json.JSONObject;
import tbclient.SendCardInfo;
/* loaded from: classes16.dex */
public class b {
    public String card_logo;
    public String card_name;
    public String card_pro;
    public long khd;
    public int khe;
    public String khf;

    public void a(SendCardInfo sendCardInfo) {
        if (sendCardInfo != null) {
            this.card_logo = sendCardInfo.card_logo;
            this.card_name = sendCardInfo.card_name;
            this.card_pro = sendCardInfo.card_pro;
            this.khe = sendCardInfo.card_get_status.intValue();
            this.khd = sendCardInfo.packet_id.longValue();
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.card_logo = jSONObject.optString("card_logo");
            this.card_name = jSONObject.optString("card_name");
            this.card_pro = jSONObject.optString("card_pro");
            this.khe = jSONObject.optInt("card_get_status");
            this.khd = jSONObject.optLong(CardBoxMemberPayActivityConfig.PACKET_ID);
            this.khf = jSONObject.optString("card_num");
        }
    }

    public boolean cKu() {
        return this.khe == 3;
    }

    public boolean cKv() {
        return this.khe == 1;
    }
}
