package com.baidu.tieba.pb.data;

import com.baidu.tbadk.core.atomData.CardBoxMemberPayActivityConfig;
import org.json.JSONObject;
import tbclient.SendCardInfo;
/* loaded from: classes2.dex */
public class b {
    public String card_logo;
    public String card_name;
    public String card_pro;
    public long lMd;
    public int lMe;
    public String lMf;

    public void a(SendCardInfo sendCardInfo) {
        if (sendCardInfo != null) {
            this.card_logo = sendCardInfo.card_logo;
            this.card_name = sendCardInfo.card_name;
            this.card_pro = sendCardInfo.card_pro;
            this.lMe = sendCardInfo.card_get_status.intValue();
            this.lMd = sendCardInfo.packet_id.longValue();
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.card_logo = jSONObject.optString("card_logo");
            this.card_name = jSONObject.optString("card_name");
            this.card_pro = jSONObject.optString("card_pro");
            this.lMe = jSONObject.optInt("card_get_status");
            this.lMd = jSONObject.optLong(CardBoxMemberPayActivityConfig.PACKET_ID);
            this.lMf = jSONObject.optString("card_num");
        }
    }

    public boolean dlm() {
        return this.lMe == 3;
    }

    public boolean dln() {
        return this.lMe == 1;
    }
}
