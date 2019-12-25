package com.baidu.tieba.pb.data;

import com.baidu.tbadk.core.atomData.CardBoxMemberPayActivityConfig;
import org.json.JSONObject;
import tbclient.SendCardInfo;
/* loaded from: classes6.dex */
public class c {
    public String card_logo;
    public String card_name;
    public String card_pro;
    public long ivV;
    public int ivW;
    public String ivX;

    public void a(SendCardInfo sendCardInfo) {
        if (sendCardInfo != null) {
            this.card_logo = sendCardInfo.card_logo;
            this.card_name = sendCardInfo.card_name;
            this.card_pro = sendCardInfo.card_pro;
            this.ivW = sendCardInfo.card_get_status.intValue();
            this.ivV = sendCardInfo.packet_id.longValue();
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.card_logo = jSONObject.optString("card_logo");
            this.card_name = jSONObject.optString("card_name");
            this.card_pro = jSONObject.optString("card_pro");
            this.ivW = jSONObject.optInt("card_get_status");
            this.ivV = jSONObject.optLong(CardBoxMemberPayActivityConfig.PACKET_ID);
            this.ivX = jSONObject.optString("card_num");
        }
    }

    public boolean chG() {
        return this.ivW == 3;
    }

    public boolean chH() {
        return this.ivW == 1;
    }
}
