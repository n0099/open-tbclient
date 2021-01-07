package com.baidu.tieba.yuyinala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public d olE;
    public C0931a olF;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("red_packet_info");
        if (optJSONObject != null) {
            this.olE = new d();
            this.olE.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_cond");
        if (optJSONObject2 != null) {
            this.olF = new C0931a();
            this.olF.parserJson(optJSONObject2);
        }
    }

    public boolean bXo() {
        return this.olE != null && this.olE.status == 5;
    }

    public boolean bXp() {
        return this.olE != null && this.olE.status == 4;
    }

    public boolean isValid() {
        return this.olE != null && (this.olE.status == 2 || this.olE.status == 3);
    }

    public boolean bXq() {
        return this.olE != null && this.olF != null && this.olE.status == 2 && this.olE.startTime > this.olE.gUF;
    }

    public boolean bXr() {
        return this.olF != null && this.olF.gUc == 1;
    }

    public long bXs() {
        if (this.olF != null) {
            return this.olF.gUd;
        }
        return 0L;
    }

    public boolean bXt() {
        return this.olF != null && ((this.olF.gUe && !this.olF.isFollowed) || ((this.olF.gUf && !this.olF.gUg) || (this.olF.olG && !this.olF.olH)));
    }

    public boolean bXv() {
        return (this.olF == null || !this.olF.gUe || this.olF.isFollowed) ? false : true;
    }

    public boolean bXw() {
        return (this.olF == null || !this.olF.gUf || this.olF.gUg) ? false : true;
    }

    public boolean ebQ() {
        return (this.olF == null || !this.olF.olG || this.olF.olH) ? false : true;
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
    public static class C0931a {
        public int gUc;
        public long gUd;
        public boolean gUe;
        public boolean gUf;
        public boolean gUg;
        public boolean gUh;
        public String gUi;
        public boolean gUj;
        public boolean isFollowed;
        public boolean olG;
        public boolean olH;

        public void parserJson(JSONObject jSONObject) {
            this.gUe = jSONObject.optInt("need_follow") == 1;
            this.gUf = jSONObject.optInt("need_send_gift") == 1;
            this.isFollowed = jSONObject.optInt("follow") == 1;
            this.gUg = jSONObject.optInt("send_gift") == 1;
            this.olG = jSONObject.optInt("need_collect_room") == 1;
            this.olH = jSONObject.optInt("collect_room") == 1;
            this.gUh = jSONObject.optInt("need_follow_sender") == 1;
            this.gUi = jSONObject.optString("sender_user_id");
            this.gUj = jSONObject.optInt("follow_sender") == 1;
            this.gUc = jSONObject.optInt("loot_result");
            this.gUd = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
