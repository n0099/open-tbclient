package com.baidu.tieba.yuyinala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public d oha;
    public C0914a ohb;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("red_packet_info");
        if (optJSONObject != null) {
            this.oha = new d();
            this.oha.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_cond");
        if (optJSONObject2 != null) {
            this.ohb = new C0914a();
            this.ohb.parserJson(optJSONObject2);
        }
    }

    public boolean bTw() {
        return this.oha != null && this.oha.status == 5;
    }

    public boolean bTx() {
        return this.oha != null && this.oha.status == 4;
    }

    public boolean isValid() {
        return this.oha != null && (this.oha.status == 2 || this.oha.status == 3);
    }

    public boolean bTy() {
        return this.oha != null && this.ohb != null && this.oha.status == 2 && this.oha.startTime > this.oha.gPZ;
    }

    public boolean bTz() {
        return this.ohb != null && this.ohb.gPw == 1;
    }

    public long bTA() {
        if (this.ohb != null) {
            return this.ohb.gPx;
        }
        return 0L;
    }

    public boolean bTB() {
        return this.ohb != null && ((this.ohb.gPy && !this.ohb.isFollowed) || ((this.ohb.gPz && !this.ohb.gPA) || (this.ohb.ohc && !this.ohb.ohd)));
    }

    public boolean bTD() {
        return (this.ohb == null || !this.ohb.gPy || this.ohb.isFollowed) ? false : true;
    }

    public boolean bTE() {
        return (this.ohb == null || !this.ohb.gPz || this.ohb.gPA) ? false : true;
    }

    public boolean dXY() {
        return (this.ohb == null || !this.ohb.ohc || this.ohb.ohd) ? false : true;
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
        public boolean ohc;
        public boolean ohd;

        public void parserJson(JSONObject jSONObject) {
            this.gPy = jSONObject.optInt("need_follow") == 1;
            this.gPz = jSONObject.optInt("need_send_gift") == 1;
            this.isFollowed = jSONObject.optInt("follow") == 1;
            this.gPA = jSONObject.optInt("send_gift") == 1;
            this.ohc = jSONObject.optInt("need_collect_room") == 1;
            this.ohd = jSONObject.optInt("collect_room") == 1;
            this.gPB = jSONObject.optInt("need_follow_sender") == 1;
            this.gPC = jSONObject.optString("sender_user_id");
            this.gPD = jSONObject.optInt("follow_sender") == 1;
            this.gPw = jSONObject.optInt("loot_result");
            this.gPx = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
