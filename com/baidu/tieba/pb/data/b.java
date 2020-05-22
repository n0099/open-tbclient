package com.baidu.tieba.pb.data;

import com.baidu.tbadk.core.atomData.CardBoxMemberPayActivityConfig;
import org.json.JSONObject;
import tbclient.SendCardInfo;
/* loaded from: classes9.dex */
public class b {
    public String card_logo;
    public String card_name;
    public String card_pro;
    public long jDL;
    public int jDM;
    public String jDN;

    public void a(SendCardInfo sendCardInfo) {
        if (sendCardInfo != null) {
            this.card_logo = sendCardInfo.card_logo;
            this.card_name = sendCardInfo.card_name;
            this.card_pro = sendCardInfo.card_pro;
            this.jDM = sendCardInfo.card_get_status.intValue();
            this.jDL = sendCardInfo.packet_id.longValue();
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.card_logo = jSONObject.optString("card_logo");
            this.card_name = jSONObject.optString("card_name");
            this.card_pro = jSONObject.optString("card_pro");
            this.jDM = jSONObject.optInt("card_get_status");
            this.jDL = jSONObject.optLong(CardBoxMemberPayActivityConfig.PACKET_ID);
            this.jDN = jSONObject.optString("card_num");
        }
    }

    public boolean cCe() {
        return this.jDM == 3;
    }

    public boolean cCf() {
        return this.jDM == 1;
    }
}
