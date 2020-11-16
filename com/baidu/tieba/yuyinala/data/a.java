package com.baidu.tieba.yuyinala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public d nUR;
    public C0902a nUS;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("red_packet_info");
        if (optJSONObject != null) {
            this.nUR = new d();
            this.nUR.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_cond");
        if (optJSONObject2 != null) {
            this.nUS = new C0902a();
            this.nUS.parserJson(optJSONObject2);
        }
    }

    public boolean bQY() {
        return this.nUR != null && this.nUR.status == 5;
    }

    public boolean bQZ() {
        return this.nUR != null && this.nUR.status == 4;
    }

    public boolean isValid() {
        return this.nUR != null && (this.nUR.status == 2 || this.nUR.status == 3);
    }

    public boolean bRa() {
        return this.nUR != null && this.nUS != null && this.nUR.status == 2 && this.nUR.startTime > this.nUR.gzU;
    }

    public boolean bRb() {
        return this.nUS != null && this.nUS.gzs == 1;
    }

    public long bRc() {
        if (this.nUS != null) {
            return this.nUS.gzt;
        }
        return 0L;
    }

    public boolean bRd() {
        return this.nUS != null && ((this.nUS.gzu && !this.nUS.isFollowed) || ((this.nUS.gzv && !this.nUS.gzw) || (this.nUS.nUT && !this.nUS.nUU)));
    }

    public boolean bRf() {
        return (this.nUS == null || !this.nUS.gzu || this.nUS.isFollowed) ? false : true;
    }

    public boolean bRg() {
        return (this.nUS == null || !this.nUS.gzv || this.nUS.gzw) ? false : true;
    }

    public boolean dXo() {
        return (this.nUS == null || !this.nUS.nUT || this.nUS.nUU) ? false : true;
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
    public static class C0902a {
        public int gzs;
        public long gzt;
        public boolean gzu;
        public boolean gzv;
        public boolean gzw;
        public boolean gzx;
        public String gzy;
        public boolean gzz;
        public boolean isFollowed;
        public boolean nUT;
        public boolean nUU;

        public void parserJson(JSONObject jSONObject) {
            this.gzu = jSONObject.optInt("need_follow") == 1;
            this.gzv = jSONObject.optInt("need_send_gift") == 1;
            this.isFollowed = jSONObject.optInt("follow") == 1;
            this.gzw = jSONObject.optInt("send_gift") == 1;
            this.nUT = jSONObject.optInt("need_collect_room") == 1;
            this.nUU = jSONObject.optInt("collect_room") == 1;
            this.gzx = jSONObject.optInt("need_follow_sender") == 1;
            this.gzy = jSONObject.optString("sender_user_id");
            this.gzz = jSONObject.optInt("follow_sender") == 1;
            this.gzs = jSONObject.optInt("loot_result");
            this.gzt = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
