package com.baidu.tieba.tbadkCore.data;

import java.util.List;
import tbclient.RedpacketRain;
/* loaded from: classes.dex */
public class m {
    private String bBS;
    private String fQo;
    private String hqD;
    private List<String> hqE;
    private long mEndTime;
    private long mStartTime;
    private int mType;

    public void a(RedpacketRain redpacketRain) {
        if (redpacketRain != null) {
            this.mStartTime = redpacketRain.start_time.longValue() * 1000;
            this.mEndTime = redpacketRain.end_time.longValue() * 1000;
            this.bBS = redpacketRain.jump_url;
            this.hqD = redpacketRain.float_url;
            this.hqE = redpacketRain.dynamic_img;
            this.fQo = redpacketRain.activity_id;
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
        return this.bBS;
    }

    public String bFf() {
        return this.hqD;
    }

    public List<String> bFg() {
        return this.hqE;
    }

    public String bFh() {
        return this.fQo;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void vX(String str) {
        this.bBS = str;
    }

    public void vY(String str) {
        this.hqD = str;
    }

    public void dP(List<String> list) {
        this.hqE = list;
    }

    public void vZ(String str) {
        this.fQo = str;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
