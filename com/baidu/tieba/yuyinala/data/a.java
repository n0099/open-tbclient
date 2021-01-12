package com.baidu.tieba.yuyinala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public d ogZ;
    public C0914a oha;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("red_packet_info");
        if (optJSONObject != null) {
            this.ogZ = new d();
            this.ogZ.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_cond");
        if (optJSONObject2 != null) {
            this.oha = new C0914a();
            this.oha.parserJson(optJSONObject2);
        }
    }

    public boolean bTw() {
        return this.ogZ != null && this.ogZ.status == 5;
    }

    public boolean bTx() {
        return this.ogZ != null && this.ogZ.status == 4;
    }

    public boolean isValid() {
        return this.ogZ != null && (this.ogZ.status == 2 || this.ogZ.status == 3);
    }

    public boolean bTy() {
        return this.ogZ != null && this.oha != null && this.ogZ.status == 2 && this.ogZ.startTime > this.ogZ.gPZ;
    }

    public boolean bTz() {
        return this.oha != null && this.oha.gPw == 1;
    }

    public long bTA() {
        if (this.oha != null) {
            return this.oha.gPx;
        }
        return 0L;
    }

    public boolean bTB() {
        return this.oha != null && ((this.oha.gPy && !this.oha.isFollowed) || ((this.oha.gPz && !this.oha.gPA) || (this.oha.ohb && !this.oha.ohc)));
    }

    public boolean bTD() {
        return (this.oha == null || !this.oha.gPy || this.oha.isFollowed) ? false : true;
    }

    public boolean bTE() {
        return (this.oha == null || !this.oha.gPz || this.oha.gPA) ? false : true;
    }

    public boolean dXY() {
        return (this.oha == null || !this.oha.ohb || this.oha.ohc) ? false : true;
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
    /* loaded from: classes10.dex */
    public static class C0914a {
        public boolean gPA;
        public boolean gPB;
        public String gPC;
        public boolean gPD;
        public int gPw;
        public long gPx;
        public boolean gPy;
        public boolean gPz;
        public boolean isFollowed;
        public boolean ohb;
        public boolean ohc;

        public void parserJson(JSONObject jSONObject) {
            this.gPy = jSONObject.optInt("need_follow") == 1;
            this.gPz = jSONObject.optInt("need_send_gift") == 1;
            this.isFollowed = jSONObject.optInt("follow") == 1;
            this.gPA = jSONObject.optInt("send_gift") == 1;
            this.ohb = jSONObject.optInt("need_collect_room") == 1;
            this.ohc = jSONObject.optInt("collect_room") == 1;
            this.gPB = jSONObject.optInt("need_follow_sender") == 1;
            this.gPC = jSONObject.optString("sender_user_id");
            this.gPD = jSONObject.optInt("follow_sender") == 1;
            this.gPw = jSONObject.optInt("loot_result");
            this.gPx = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
