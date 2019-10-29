package com.baidu.tieba.tbadkCore.data;

import java.util.List;
import tbclient.RedpacketRain;
/* loaded from: classes.dex */
public class o {
    private String agP;
    private long baF;
    private String dhg;
    private String jjx;
    private List<String> jjy;
    private long mStartTime;
    private int mType;

    public void a(RedpacketRain redpacketRain) {
        if (redpacketRain != null) {
            this.mStartTime = redpacketRain.start_time.longValue() * 1000;
            this.baF = redpacketRain.end_time.longValue() * 1000;
            this.dhg = redpacketRain.jump_url;
            this.jjx = redpacketRain.float_url;
            this.jjy = redpacketRain.dynamic_img;
            this.agP = redpacketRain.activity_id;
            this.mType = redpacketRain.show_type.intValue();
        }
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getEndTime() {
        return this.baF;
    }

    public String aDs() {
        return this.dhg;
    }

    public String coD() {
        return this.jjx;
    }

    public List<String> coE() {
        return this.jjy;
    }

    public String coF() {
        return this.agP;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void setEndTime(long j) {
        this.baF = j;
    }

    public void DP(String str) {
        this.dhg = str;
    }

    public void DQ(String str) {
        this.jjx = str;
    }

    public void eq(List<String> list) {
        this.jjy = list;
    }

    public void DR(String str) {
        this.agP = str;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
