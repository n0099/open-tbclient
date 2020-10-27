package com.baidu.tieba.pb.data;

import com.baidu.tbadk.core.atomData.CardBoxMemberPayActivityConfig;
import org.json.JSONObject;
import tbclient.SendCardInfo;
/* loaded from: classes22.dex */
public class b {
    public String card_logo;
    public String card_name;
    public String card_pro;
    public long lgM;
    public int lgN;
    public String lgO;

    public void a(SendCardInfo sendCardInfo) {
        if (sendCardInfo != null) {
            this.card_logo = sendCardInfo.card_logo;
            this.card_name = sendCardInfo.card_name;
            this.card_pro = sendCardInfo.card_pro;
            this.lgN = sendCardInfo.card_get_status.intValue();
            this.lgM = sendCardInfo.packet_id.longValue();
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.card_logo = jSONObject.optString("card_logo");
            this.card_name = jSONObject.optString("card_name");
            this.card_pro = jSONObject.optString("card_pro");
            this.lgN = jSONObject.optInt("card_get_status");
            this.lgM = jSONObject.optLong(CardBoxMemberPayActivityConfig.PACKET_ID);
            this.lgO = jSONObject.optString("card_num");
        }
    }

    public boolean dfF() {
        return this.lgN == 3;
    }

    public boolean dfG() {
        return this.lgN == 1;
    }
}
