package com.baidu.tieba.yuyinala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public d nTo;
    public C0899a nTp;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("red_packet_info");
        if (optJSONObject != null) {
            this.nTo = new d();
            this.nTo.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_cond");
        if (optJSONObject2 != null) {
            this.nTp = new C0899a();
            this.nTp.parserJson(optJSONObject2);
        }
    }

    public boolean bRF() {
        return this.nTo != null && this.nTo.status == 5;
    }

    public boolean bRG() {
        return this.nTo != null && this.nTo.status == 4;
    }

    public boolean isValid() {
        return this.nTo != null && (this.nTo.status == 2 || this.nTo.status == 3);
    }

    public boolean bRH() {
        return this.nTo != null && this.nTp != null && this.nTo.status == 2 && this.nTo.startTime > this.nTo.gAn;
    }

    public boolean bRI() {
        return this.nTp != null && this.nTp.gzL == 1;
    }

    public long bRJ() {
        if (this.nTp != null) {
            return this.nTp.gzM;
        }
        return 0L;
    }

    public boolean bRK() {
        return this.nTp != null && ((this.nTp.gzN && !this.nTp.isFollowed) || ((this.nTp.gzO && !this.nTp.gzP) || (this.nTp.nTq && !this.nTp.nTr)));
    }

    public boolean bRM() {
        return (this.nTp == null || !this.nTp.gzN || this.nTp.isFollowed) ? false : true;
    }

    public boolean bRN() {
        return (this.nTp == null || !this.nTp.gzO || this.nTp.gzP) ? false : true;
    }

    public boolean dXp() {
        return (this.nTp == null || !this.nTp.nTq || this.nTp.nTr) ? false : true;
    }

    public int eA(long j) {
        return 100 - ((int) (((j * 1.0d) / 180.0d) * 100.0d));
    }

    public String[] eB(long j) {
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
    public static class C0899a {
        public int gzL;
        public long gzM;
        public boolean gzN;
        public boolean gzO;
        public boolean gzP;
        public boolean gzQ;
        public String gzR;
        public boolean gzS;
        public boolean isFollowed;
        public boolean nTq;
        public boolean nTr;

        public void parserJson(JSONObject jSONObject) {
            this.gzN = jSONObject.optInt("need_follow") == 1;
            this.gzO = jSONObject.optInt("need_send_gift") == 1;
            this.isFollowed = jSONObject.optInt("follow") == 1;
            this.gzP = jSONObject.optInt("send_gift") == 1;
            this.nTq = jSONObject.optInt("need_collect_room") == 1;
            this.nTr = jSONObject.optInt("collect_room") == 1;
            this.gzQ = jSONObject.optInt("need_follow_sender") == 1;
            this.gzR = jSONObject.optString("sender_user_id");
            this.gzS = jSONObject.optInt("follow_sender") == 1;
            this.gzL = jSONObject.optInt("loot_result");
            this.gzM = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
