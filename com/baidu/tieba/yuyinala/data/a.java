package com.baidu.tieba.yuyinala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public d oru;
    public C0919a orv;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("red_packet_info");
        if (optJSONObject != null) {
            this.oru = new d();
            this.oru.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_cond");
        if (optJSONObject2 != null) {
            this.orv = new C0919a();
            this.orv.parserJson(optJSONObject2);
        }
    }

    public boolean bUi() {
        return this.oru != null && this.oru.status == 5;
    }

    public boolean bUj() {
        return this.oru != null && this.oru.status == 4;
    }

    public boolean isValid() {
        return this.oru != null && (this.oru.status == 2 || this.oru.status == 3);
    }

    public boolean bUk() {
        return this.oru != null && this.orv != null && this.oru.status == 2 && this.oru.startTime > this.oru.gSX;
    }

    public boolean bUl() {
        return this.orv != null && this.orv.gSt == 1;
    }

    public long bUm() {
        if (this.orv != null) {
            return this.orv.gSu;
        }
        return 0L;
    }

    public boolean bUn() {
        return this.orv != null && ((this.orv.gSv && !this.orv.isFollowed) || ((this.orv.gSw && !this.orv.gSx) || (this.orv.orw && !this.orv.orx)));
    }

    public boolean bUp() {
        return (this.orv == null || !this.orv.gSv || this.orv.isFollowed) ? false : true;
    }

    public boolean bUq() {
        return (this.orv == null || !this.orv.gSw || this.orv.gSx) ? false : true;
    }

    public boolean ear() {
        return (this.orv == null || !this.orv.orw || this.orv.orx) ? false : true;
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
    public static class C0919a {
        public boolean gSA;
        public int gSt;
        public long gSu;
        public boolean gSv;
        public boolean gSw;
        public boolean gSx;
        public boolean gSy;
        public String gSz;
        public boolean isFollowed;
        public boolean orw;
        public boolean orx;

        public void parserJson(JSONObject jSONObject) {
            this.gSv = jSONObject.optInt("need_follow") == 1;
            this.gSw = jSONObject.optInt("need_send_gift") == 1;
            this.isFollowed = jSONObject.optInt("follow") == 1;
            this.gSx = jSONObject.optInt("send_gift") == 1;
            this.orw = jSONObject.optInt("need_collect_room") == 1;
            this.orx = jSONObject.optInt("collect_room") == 1;
            this.gSy = jSONObject.optInt("need_follow_sender") == 1;
            this.gSz = jSONObject.optString("sender_user_id");
            this.gSA = jSONObject.optInt("follow_sender") == 1;
            this.gSt = jSONObject.optInt("loot_result");
            this.gSu = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
