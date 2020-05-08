package com.baidu.tieba.tbadkCore.data;

import java.util.List;
import tbclient.RedpacketRain;
/* loaded from: classes.dex */
public class o {
    private String aMi;
    private String eyU;
    private String kTD;
    private List<String> kTE;
    private long mEndTime;
    private long mStartTime;
    private int mType;

    public void a(RedpacketRain redpacketRain) {
        if (redpacketRain != null) {
            this.mStartTime = redpacketRain.start_time.longValue() * 1000;
            this.mEndTime = redpacketRain.end_time.longValue() * 1000;
            this.eyU = redpacketRain.jump_url;
            this.kTD = redpacketRain.float_url;
            this.kTE = redpacketRain.dynamic_img;
            this.aMi = redpacketRain.activity_id;
            this.mType = redpacketRain.show_type.intValue();
        }
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public String bgb() {
        return this.eyU;
    }

    public String cWC() {
        return this.kTD;
    }

    public List<String> cWD() {
        return this.kTE;
    }

    public String lp() {
        return this.aMi;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void KP(String str) {
        this.eyU = str;
    }

    public void KQ(String str) {
        this.kTD = str;
    }

    public void et(List<String> list) {
        this.kTE = list;
    }

    public void bR(String str) {
        this.aMi = str;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
