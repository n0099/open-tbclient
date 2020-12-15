package com.baidu.tieba.yuyinala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public d ojR;
    public C0919a ojS;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("red_packet_info");
        if (optJSONObject != null) {
            this.ojR = new d();
            this.ojR.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_cond");
        if (optJSONObject2 != null) {
            this.ojS = new C0919a();
            this.ojS.parserJson(optJSONObject2);
        }
    }

    public boolean bUJ() {
        return this.ojR != null && this.ojR.status == 5;
    }

    public boolean bUK() {
        return this.ojR != null && this.ojR.status == 4;
    }

    public boolean isValid() {
        return this.ojR != null && (this.ojR.status == 2 || this.ojR.status == 3);
    }

    public boolean bUL() {
        return this.ojR != null && this.ojS != null && this.ojR.status == 2 && this.ojR.startTime > this.ojR.gIT;
    }

    public boolean bUM() {
        return this.ojS != null && this.ojS.gIq == 1;
    }

    public long bUN() {
        if (this.ojS != null) {
            return this.ojS.gIr;
        }
        return 0L;
    }

    public boolean bUO() {
        return this.ojS != null && ((this.ojS.gIs && !this.ojS.isFollowed) || ((this.ojS.gIt && !this.ojS.gIu) || (this.ojS.ojT && !this.ojS.ojU)));
    }

    public boolean bUQ() {
        return (this.ojS == null || !this.ojS.gIs || this.ojS.isFollowed) ? false : true;
    }

    public boolean bUR() {
        return (this.ojS == null || !this.ojS.gIt || this.ojS.gIu) ? false : true;
    }

    public boolean ecT() {
        return (this.ojS == null || !this.ojS.ojT || this.ojS.ojU) ? false : true;
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
        public int gIq;
        public long gIr;
        public boolean gIs;
        public boolean gIt;
        public boolean gIu;
        public boolean gIv;
        public String gIw;
        public boolean gIx;
        public boolean isFollowed;
        public boolean ojT;
        public boolean ojU;

        public void parserJson(JSONObject jSONObject) {
            this.gIs = jSONObject.optInt("need_follow") == 1;
            this.gIt = jSONObject.optInt("need_send_gift") == 1;
            this.isFollowed = jSONObject.optInt("follow") == 1;
            this.gIu = jSONObject.optInt("send_gift") == 1;
            this.ojT = jSONObject.optInt("need_collect_room") == 1;
            this.ojU = jSONObject.optInt("collect_room") == 1;
            this.gIv = jSONObject.optInt("need_follow_sender") == 1;
            this.gIw = jSONObject.optString("sender_user_id");
            this.gIx = jSONObject.optInt("follow_sender") == 1;
            this.gIq = jSONObject.optInt("loot_result");
            this.gIr = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
