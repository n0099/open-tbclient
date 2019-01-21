package com.baidu.tieba.tbadkCore.data;

import java.util.List;
import tbclient.RedpacketRain;
/* loaded from: classes.dex */
public class m {
    private String bBT;
    private String fQp;
    private String hqE;
    private List<String> hqF;
    private long mEndTime;
    private long mStartTime;
    private int mType;

    public void a(RedpacketRain redpacketRain) {
        if (redpacketRain != null) {
            this.mStartTime = redpacketRain.start_time.longValue() * 1000;
            this.mEndTime = redpacketRain.end_time.longValue() * 1000;
            this.bBT = redpacketRain.jump_url;
            this.hqE = redpacketRain.float_url;
            this.hqF = redpacketRain.dynamic_img;
            this.fQp = redpacketRain.activity_id;
            this.mType = redpacketRain.show_type.intValue();
        }
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public String Wy() {
        return this.bBT;
    }

    public String bFf() {
        return this.hqE;
    }

    public List<String> bFg() {
        return this.hqF;
    }

    public String bFh() {
        return this.fQp;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void vX(String str) {
        this.bBT = str;
    }

    public void vY(String str) {
        this.hqE = str;
    }

    public void dP(List<String> list) {
        this.hqF = list;
    }

    public void vZ(String str) {
        this.fQp = str;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
