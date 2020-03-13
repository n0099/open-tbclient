package com.baidu.tieba.tbadkCore.data;

import java.util.List;
import tbclient.RedpacketRain;
/* loaded from: classes.dex */
public class o {
    private String asE;
    private String dYC;
    private String khQ;
    private List<String> khR;
    private long mEndTime;
    private long mStartTime;
    private int mType;

    public void a(RedpacketRain redpacketRain) {
        if (redpacketRain != null) {
            this.mStartTime = redpacketRain.start_time.longValue() * 1000;
            this.mEndTime = redpacketRain.end_time.longValue() * 1000;
            this.dYC = redpacketRain.jump_url;
            this.khQ = redpacketRain.float_url;
            this.khR = redpacketRain.dynamic_img;
            this.asE = redpacketRain.activity_id;
            this.mType = redpacketRain.show_type.intValue();
        }
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public String aXU() {
        return this.dYC;
    }

    public String cLp() {
        return this.khQ;
    }

    public List<String> cLq() {
        return this.khR;
    }

    public String gL() {
        return this.asE;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void Jd(String str) {
        this.dYC = str;
    }

    public void Je(String str) {
        this.khQ = str;
    }

    public void ee(List<String> list) {
        this.khR = list;
    }

    public void aC(String str) {
        this.asE = str;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
