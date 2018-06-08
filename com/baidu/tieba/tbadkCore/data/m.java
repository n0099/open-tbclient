package com.baidu.tieba.tbadkCore.data;

import java.util.List;
import tbclient.RedpacketRain;
/* loaded from: classes.dex */
public class m {
    private long aab;
    private String bkR;
    private String gJQ;
    private List<String> gJR;
    private String gJS;
    private long mStartTime;
    private int mType;

    public void a(RedpacketRain redpacketRain) {
        if (redpacketRain != null) {
            this.mStartTime = redpacketRain.start_time.longValue() * 1000;
            this.aab = redpacketRain.end_time.longValue() * 1000;
            this.bkR = redpacketRain.jump_url;
            this.gJQ = redpacketRain.float_url;
            this.gJR = redpacketRain.dynamic_img;
            this.gJS = redpacketRain.activity_id;
            this.mType = redpacketRain.show_type.intValue();
        }
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getEndTime() {
        return this.aab;
    }

    public String Qs() {
        return this.bkR;
    }

    public String bxo() {
        return this.gJQ;
    }

    public List<String> bxp() {
        return this.gJR;
    }

    public String bxq() {
        return this.gJS;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void db(long j) {
        this.aab = j;
    }

    public void tO(String str) {
        this.bkR = str;
    }

    public void tP(String str) {
        this.gJQ = str;
    }

    public void dw(List<String> list) {
        this.gJR = list;
    }

    public void tQ(String str) {
        this.gJS = str;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
