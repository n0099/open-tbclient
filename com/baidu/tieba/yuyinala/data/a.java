package com.baidu.tieba.yuyinala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public C0925a otA;
    public d otz;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("red_packet_info");
        if (optJSONObject != null) {
            this.otz = new d();
            this.otz.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_cond");
        if (optJSONObject2 != null) {
            this.otA = new C0925a();
            this.otA.parserJson(optJSONObject2);
        }
    }

    public boolean bUo() {
        return this.otz != null && this.otz.status == 5;
    }

    public boolean bUp() {
        return this.otz != null && this.otz.status == 4;
    }

    public boolean isValid() {
        return this.otz != null && (this.otz.status == 2 || this.otz.status == 3);
    }

    public boolean bUq() {
        return this.otz != null && this.otA != null && this.otz.status == 2 && this.otz.startTime > this.otz.gUG;
    }

    public boolean bUr() {
        return this.otA != null && this.otA.gUc == 1;
    }

    public long bUs() {
        if (this.otA != null) {
            return this.otA.gUd;
        }
        return 0L;
    }

    public boolean bUt() {
        return this.otA != null && ((this.otA.gUe && !this.otA.isFollowed) || ((this.otA.gUf && !this.otA.gUg) || (this.otA.otB && !this.otA.otC)));
    }

    public boolean bUv() {
        return (this.otA == null || !this.otA.gUe || this.otA.isFollowed) ? false : true;
    }

    public boolean bUw() {
        return (this.otA == null || !this.otA.gUf || this.otA.gUg) ? false : true;
    }

    public boolean eaz() {
        return (this.otA == null || !this.otA.otB || this.otA.otC) ? false : true;
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
    /* loaded from: classes10.dex */
    public static class C0925a {
        public int gUc;
        public long gUd;
        public boolean gUe;
        public boolean gUf;
        public boolean gUg;
        public boolean gUh;
        public String gUi;
        public boolean gUj;
        public boolean isFollowed;
        public boolean otB;
        public boolean otC;

        public void parserJson(JSONObject jSONObject) {
            this.gUe = jSONObject.optInt("need_follow") == 1;
            this.gUf = jSONObject.optInt("need_send_gift") == 1;
            this.isFollowed = jSONObject.optInt("follow") == 1;
            this.gUg = jSONObject.optInt("send_gift") == 1;
            this.otB = jSONObject.optInt("need_collect_room") == 1;
            this.otC = jSONObject.optInt("collect_room") == 1;
            this.gUh = jSONObject.optInt("need_follow_sender") == 1;
            this.gUi = jSONObject.optString("sender_user_id");
            this.gUj = jSONObject.optInt("follow_sender") == 1;
            this.gUc = jSONObject.optInt("loot_result");
            this.gUd = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
