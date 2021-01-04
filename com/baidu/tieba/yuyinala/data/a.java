package com.baidu.tieba.yuyinala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public d olF;
    public C0893a olG;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("red_packet_info");
        if (optJSONObject != null) {
            this.olF = new d();
            this.olF.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_cond");
        if (optJSONObject2 != null) {
            this.olG = new C0893a();
            this.olG.parserJson(optJSONObject2);
        }
    }

    public boolean bXn() {
        return this.olF != null && this.olF.status == 5;
    }

    public boolean bXo() {
        return this.olF != null && this.olF.status == 4;
    }

    public boolean isValid() {
        return this.olF != null && (this.olF.status == 2 || this.olF.status == 3);
    }

    public boolean bXp() {
        return this.olF != null && this.olG != null && this.olF.status == 2 && this.olF.startTime > this.olF.gUF;
    }

    public boolean bXq() {
        return this.olG != null && this.olG.gUc == 1;
    }

    public long bXr() {
        if (this.olG != null) {
            return this.olG.gUd;
        }
        return 0L;
    }

    public boolean bXs() {
        return this.olG != null && ((this.olG.gUe && !this.olG.isFollowed) || ((this.olG.gUf && !this.olG.gUg) || (this.olG.olH && !this.olG.olI)));
    }

    public boolean bXu() {
        return (this.olG == null || !this.olG.gUe || this.olG.isFollowed) ? false : true;
    }

    public boolean bXv() {
        return (this.olG == null || !this.olG.gUf || this.olG.gUg) ? false : true;
    }

    public boolean ebP() {
        return (this.olG == null || !this.olG.olH || this.olG.olI) ? false : true;
    }

    public int fe(long j) {
        return 100 - ((int) (((j * 1.0d) / 180.0d) * 100.0d));
    }

    public String[] ff(long j) {
        String[] strArr = new String[2];
        if (j <= 60) {
            if (j < 0) {
                j = 0;
            }
            strArr[0] = null;
            if (j < 10) {
                strArr[1] = "0" + j;
            } else {
                strArr[1] = String.valueOf(j);
            }
            return strArr;
        }
        int i = (int) (j / 60);
        int i2 = (int) (j % 60);
        if (i < 10) {
            strArr[0] = "0" + i;
        } else {
            strArr[0] = String.valueOf(i);
        }
        if (i2 < 10) {
            strArr[1] = "0" + i2;
        } else {
            strArr[1] = String.valueOf(i2);
        }
        return strArr;
    }

    /* renamed from: com.baidu.tieba.yuyinala.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0893a {
        public int gUc;
        public long gUd;
        public boolean gUe;
        public boolean gUf;
        public boolean gUg;
        public boolean gUh;
        public String gUi;
        public boolean gUj;
        public boolean isFollowed;
        public boolean olH;
        public boolean olI;

        public void parserJson(JSONObject jSONObject) {
            this.gUe = jSONObject.optInt("need_follow") == 1;
            this.gUf = jSONObject.optInt("need_send_gift") == 1;
            this.isFollowed = jSONObject.optInt("follow") == 1;
            this.gUg = jSONObject.optInt("send_gift") == 1;
            this.olH = jSONObject.optInt("need_collect_room") == 1;
            this.olI = jSONObject.optInt("collect_room") == 1;
            this.gUh = jSONObject.optInt("need_follow_sender") == 1;
            this.gUi = jSONObject.optString("sender_user_id");
            this.gUj = jSONObject.optInt("follow_sender") == 1;
            this.gUc = jSONObject.optInt("loot_result");
            this.gUd = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
