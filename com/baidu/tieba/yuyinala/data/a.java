package com.baidu.tieba.yuyinala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public d nNu;
    public C0884a nNv;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("red_packet_info");
        if (optJSONObject != null) {
            this.nNu = new d();
            this.nNu.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_cond");
        if (optJSONObject2 != null) {
            this.nNv = new C0884a();
            this.nNv.parserJson(optJSONObject2);
        }
    }

    public boolean bPf() {
        return this.nNu != null && this.nNu.status == 5;
    }

    public boolean bPg() {
        return this.nNu != null && this.nNu.status == 4;
    }

    public boolean isValid() {
        return this.nNu != null && (this.nNu.status == 2 || this.nNu.status == 3);
    }

    public boolean bPh() {
        return this.nNu != null && this.nNv != null && this.nNu.status == 2 && this.nNu.startTime > this.nNu.guz;
    }

    public boolean bPi() {
        return this.nNv != null && this.nNv.gtX == 1;
    }

    public long bPj() {
        if (this.nNv != null) {
            return this.nNv.gtY;
        }
        return 0L;
    }

    public boolean bPk() {
        return this.nNv != null && ((this.nNv.gtZ && !this.nNv.isFollowed) || ((this.nNv.gua && !this.nNv.gub) || (this.nNv.nNw && !this.nNv.nNx)));
    }

    public boolean bPm() {
        return (this.nNv == null || !this.nNv.gtZ || this.nNv.isFollowed) ? false : true;
    }

    public boolean bPn() {
        return (this.nNv == null || !this.nNv.gua || this.nNv.gub) ? false : true;
    }

    public boolean dUP() {
        return (this.nNv == null || !this.nNv.nNw || this.nNv.nNx) ? false : true;
    }

    public int ee(long j) {
        return 100 - ((int) (((j * 1.0d) / 180.0d) * 100.0d));
    }

    public String[] ef(long j) {
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
    public static class C0884a {
        public int gtX;
        public long gtY;
        public boolean gtZ;
        public boolean gua;
        public boolean gub;
        public boolean guc;
        public String gud;
        public boolean gue;
        public boolean isFollowed;
        public boolean nNw;
        public boolean nNx;

        public void parserJson(JSONObject jSONObject) {
            this.gtZ = jSONObject.optInt("need_follow") == 1;
            this.gua = jSONObject.optInt("need_send_gift") == 1;
            this.isFollowed = jSONObject.optInt("follow") == 1;
            this.gub = jSONObject.optInt("send_gift") == 1;
            this.nNw = jSONObject.optInt("need_collect_room") == 1;
            this.nNx = jSONObject.optInt("collect_room") == 1;
            this.guc = jSONObject.optInt("need_follow_sender") == 1;
            this.gud = jSONObject.optString("sender_user_id");
            this.gue = jSONObject.optInt("follow_sender") == 1;
            this.gtX = jSONObject.optInt("loot_result");
            this.gtY = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
