package com.baidu.tieba.yuyinala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public d oqT;
    public C0917a oqU;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("red_packet_info");
        if (optJSONObject != null) {
            this.oqT = new d();
            this.oqT.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_cond");
        if (optJSONObject2 != null) {
            this.oqU = new C0917a();
            this.oqU.parserJson(optJSONObject2);
        }
    }

    public boolean bUb() {
        return this.oqT != null && this.oqT.status == 5;
    }

    public boolean bUc() {
        return this.oqT != null && this.oqT.status == 4;
    }

    public boolean isValid() {
        return this.oqT != null && (this.oqT.status == 2 || this.oqT.status == 3);
    }

    public boolean bUd() {
        return this.oqT != null && this.oqU != null && this.oqT.status == 2 && this.oqT.startTime > this.oqT.gSJ;
    }

    public boolean bUe() {
        return this.oqU != null && this.oqU.gSf == 1;
    }

    public long bUf() {
        if (this.oqU != null) {
            return this.oqU.gSg;
        }
        return 0L;
    }

    public boolean bUg() {
        return this.oqU != null && ((this.oqU.gSh && !this.oqU.isFollowed) || ((this.oqU.gSi && !this.oqU.gSj) || (this.oqU.oqV && !this.oqU.oqW)));
    }

    public boolean bUi() {
        return (this.oqU == null || !this.oqU.gSh || this.oqU.isFollowed) ? false : true;
    }

    public boolean bUj() {
        return (this.oqU == null || !this.oqU.gSi || this.oqU.gSj) ? false : true;
    }

    public boolean eaj() {
        return (this.oqU == null || !this.oqU.oqV || this.oqU.oqW) ? false : true;
    }

    public int fk(long j) {
        return 100 - ((int) (((j * 1.0d) / 180.0d) * 100.0d));
    }

    public String[] fl(long j) {
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
    public static class C0917a {
        public int gSf;
        public long gSg;
        public boolean gSh;
        public boolean gSi;
        public boolean gSj;
        public boolean gSk;
        public String gSl;
        public boolean gSm;
        public boolean isFollowed;
        public boolean oqV;
        public boolean oqW;

        public void parserJson(JSONObject jSONObject) {
            this.gSh = jSONObject.optInt("need_follow") == 1;
            this.gSi = jSONObject.optInt("need_send_gift") == 1;
            this.isFollowed = jSONObject.optInt("follow") == 1;
            this.gSj = jSONObject.optInt("send_gift") == 1;
            this.oqV = jSONObject.optInt("need_collect_room") == 1;
            this.oqW = jSONObject.optInt("collect_room") == 1;
            this.gSk = jSONObject.optInt("need_follow_sender") == 1;
            this.gSl = jSONObject.optString("sender_user_id");
            this.gSm = jSONObject.optInt("follow_sender") == 1;
            this.gSf = jSONObject.optInt("loot_result");
            this.gSg = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
