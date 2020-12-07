package com.baidu.tieba.yuyinala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public d ojP;
    public C0919a ojQ;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("red_packet_info");
        if (optJSONObject != null) {
            this.ojP = new d();
            this.ojP.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_cond");
        if (optJSONObject2 != null) {
            this.ojQ = new C0919a();
            this.ojQ.parserJson(optJSONObject2);
        }
    }

    public boolean bUI() {
        return this.ojP != null && this.ojP.status == 5;
    }

    public boolean bUJ() {
        return this.ojP != null && this.ojP.status == 4;
    }

    public boolean isValid() {
        return this.ojP != null && (this.ojP.status == 2 || this.ojP.status == 3);
    }

    public boolean bUK() {
        return this.ojP != null && this.ojQ != null && this.ojP.status == 2 && this.ojP.startTime > this.ojP.gIR;
    }

    public boolean bUL() {
        return this.ojQ != null && this.ojQ.gIo == 1;
    }

    public long bUM() {
        if (this.ojQ != null) {
            return this.ojQ.gIp;
        }
        return 0L;
    }

    public boolean bUN() {
        return this.ojQ != null && ((this.ojQ.gIq && !this.ojQ.isFollowed) || ((this.ojQ.gIr && !this.ojQ.gIs) || (this.ojQ.ojR && !this.ojQ.ojS)));
    }

    public boolean bUP() {
        return (this.ojQ == null || !this.ojQ.gIq || this.ojQ.isFollowed) ? false : true;
    }

    public boolean bUQ() {
        return (this.ojQ == null || !this.ojQ.gIr || this.ojQ.gIs) ? false : true;
    }

    public boolean ecS() {
        return (this.ojQ == null || !this.ojQ.ojR || this.ojQ.ojS) ? false : true;
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
    /* loaded from: classes4.dex */
    public static class C0919a {
        public int gIo;
        public long gIp;
        public boolean gIq;
        public boolean gIr;
        public boolean gIs;
        public boolean gIt;
        public String gIu;
        public boolean gIv;
        public boolean isFollowed;
        public boolean ojR;
        public boolean ojS;

        public void parserJson(JSONObject jSONObject) {
            this.gIq = jSONObject.optInt("need_follow") == 1;
            this.gIr = jSONObject.optInt("need_send_gift") == 1;
            this.isFollowed = jSONObject.optInt("follow") == 1;
            this.gIs = jSONObject.optInt("send_gift") == 1;
            this.ojR = jSONObject.optInt("need_collect_room") == 1;
            this.ojS = jSONObject.optInt("collect_room") == 1;
            this.gIt = jSONObject.optInt("need_follow_sender") == 1;
            this.gIu = jSONObject.optString("sender_user_id");
            this.gIv = jSONObject.optInt("follow_sender") == 1;
            this.gIo = jSONObject.optInt("loot_result");
            this.gIp = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
