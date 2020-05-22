package com.baidu.tieba.tbadkCore.data;

import java.util.List;
import tbclient.RedpacketRain;
/* loaded from: classes.dex */
public class p {
    private String aSi;
    private String eNu;
    private String llW;
    private List<String> llX;
    private long mEndTime;
    private long mStartTime;
    private int mType;

    public void a(RedpacketRain redpacketRain) {
        if (redpacketRain != null) {
            this.mStartTime = redpacketRain.start_time.longValue() * 1000;
            this.mEndTime = redpacketRain.end_time.longValue() * 1000;
            this.eNu = redpacketRain.jump_url;
            this.llW = redpacketRain.float_url;
            this.llX = redpacketRain.dynamic_img;
            this.aSi = redpacketRain.activity_id;
            this.mType = redpacketRain.show_type.intValue();
        }
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public String vX() {
        return this.eNu;
    }

    public String ddI() {
        return this.llW;
    }

    public List<String> ddJ() {
        return this.llX;
    }

    public String lr() {
        return this.aSi;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void er(String str) {
        this.eNu = str;
    }

    public void MC(String str) {
        this.llW = str;
    }

    public void eA(List<String> list) {
        this.llX = list;
    }

    public void bS(String str) {
        this.aSi = str;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
