package com.baidu.tieba.pb.data;

import com.baidu.tbadk.core.atomData.CardBoxMemberPayActivityConfig;
import org.json.JSONObject;
import tbclient.SendCardInfo;
/* loaded from: classes9.dex */
public class b {
    public String card_logo;
    public String card_name;
    public String card_pro;
    public long iBr;
    public int iBs;
    public String iBt;

    public void a(SendCardInfo sendCardInfo) {
        if (sendCardInfo != null) {
            this.card_logo = sendCardInfo.card_logo;
            this.card_name = sendCardInfo.card_name;
            this.card_pro = sendCardInfo.card_pro;
            this.iBs = sendCardInfo.card_get_status.intValue();
            this.iBr = sendCardInfo.packet_id.longValue();
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.card_logo = jSONObject.optString("card_logo");
            this.card_name = jSONObject.optString("card_name");
            this.card_pro = jSONObject.optString("card_pro");
            this.iBs = jSONObject.optInt("card_get_status");
            this.iBr = jSONObject.optLong(CardBoxMemberPayActivityConfig.PACKET_ID);
            this.iBt = jSONObject.optString("card_num");
        }
    }

    public boolean cko() {
        return this.iBs == 3;
    }

    public boolean ckp() {
        return this.iBs == 1;
    }
}
