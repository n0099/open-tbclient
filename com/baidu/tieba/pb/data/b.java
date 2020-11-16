package com.baidu.tieba.pb.data;

import com.baidu.tbadk.core.atomData.CardBoxMemberPayActivityConfig;
import org.json.JSONObject;
import tbclient.SendCardInfo;
/* loaded from: classes21.dex */
public class b {
    public String card_logo;
    public String card_name;
    public String card_pro;
    public long lmY;
    public int lmZ;
    public String lna;

    public void a(SendCardInfo sendCardInfo) {
        if (sendCardInfo != null) {
            this.card_logo = sendCardInfo.card_logo;
            this.card_name = sendCardInfo.card_name;
            this.card_pro = sendCardInfo.card_pro;
            this.lmZ = sendCardInfo.card_get_status.intValue();
            this.lmY = sendCardInfo.packet_id.longValue();
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.card_logo = jSONObject.optString("card_logo");
            this.card_name = jSONObject.optString("card_name");
            this.card_pro = jSONObject.optString("card_pro");
            this.lmZ = jSONObject.optInt("card_get_status");
            this.lmY = jSONObject.optLong(CardBoxMemberPayActivityConfig.PACKET_ID);
            this.lna = jSONObject.optString("card_num");
        }
    }

    public boolean dhE() {
        return this.lmZ == 3;
    }

    public boolean dhF() {
        return this.lmZ == 1;
    }
}
