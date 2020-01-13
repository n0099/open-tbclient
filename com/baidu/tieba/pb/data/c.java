package com.baidu.tieba.pb.data;

import com.baidu.tbadk.core.atomData.CardBoxMemberPayActivityConfig;
import org.json.JSONObject;
import tbclient.SendCardInfo;
/* loaded from: classes7.dex */
public class c {
    public String card_logo;
    public String card_name;
    public String card_pro;
    public int izA;
    public String izB;
    public long izz;

    public void a(SendCardInfo sendCardInfo) {
        if (sendCardInfo != null) {
            this.card_logo = sendCardInfo.card_logo;
            this.card_name = sendCardInfo.card_name;
            this.card_pro = sendCardInfo.card_pro;
            this.izA = sendCardInfo.card_get_status.intValue();
            this.izz = sendCardInfo.packet_id.longValue();
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.card_logo = jSONObject.optString("card_logo");
            this.card_name = jSONObject.optString("card_name");
            this.card_pro = jSONObject.optString("card_pro");
            this.izA = jSONObject.optInt("card_get_status");
            this.izz = jSONObject.optLong(CardBoxMemberPayActivityConfig.PACKET_ID);
            this.izB = jSONObject.optString("card_num");
        }
    }

    public boolean ciO() {
        return this.izA == 3;
    }

    public boolean ciP() {
        return this.izA == 1;
    }
}
