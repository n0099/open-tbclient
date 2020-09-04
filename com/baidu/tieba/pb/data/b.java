package com.baidu.tieba.pb.data;

import com.baidu.tbadk.core.atomData.CardBoxMemberPayActivityConfig;
import org.json.JSONObject;
import tbclient.SendCardInfo;
/* loaded from: classes16.dex */
public class b {
    public String card_logo;
    public String card_name;
    public String card_pro;
    public long kwD;
    public int kwE;
    public String kwF;

    public void a(SendCardInfo sendCardInfo) {
        if (sendCardInfo != null) {
            this.card_logo = sendCardInfo.card_logo;
            this.card_name = sendCardInfo.card_name;
            this.card_pro = sendCardInfo.card_pro;
            this.kwE = sendCardInfo.card_get_status.intValue();
            this.kwD = sendCardInfo.packet_id.longValue();
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.card_logo = jSONObject.optString("card_logo");
            this.card_name = jSONObject.optString("card_name");
            this.card_pro = jSONObject.optString("card_pro");
            this.kwE = jSONObject.optInt("card_get_status");
            this.kwD = jSONObject.optLong(CardBoxMemberPayActivityConfig.PACKET_ID);
            this.kwF = jSONObject.optString("card_num");
        }
    }

    public boolean cVj() {
        return this.kwE == 3;
    }

    public boolean cVk() {
        return this.kwE == 1;
    }
}
