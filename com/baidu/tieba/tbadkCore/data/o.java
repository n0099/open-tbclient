package com.baidu.tieba.tbadkCore.data;

import java.util.List;
import tbclient.RedpacketRain;
/* loaded from: classes.dex */
public class o {
    private String asD;
    private String dYp;
    private String khE;
    private List<String> khF;
    private long mEndTime;
    private long mStartTime;
    private int mType;

    public void a(RedpacketRain redpacketRain) {
        if (redpacketRain != null) {
            this.mStartTime = redpacketRain.start_time.longValue() * 1000;
            this.mEndTime = redpacketRain.end_time.longValue() * 1000;
            this.dYp = redpacketRain.jump_url;
            this.khE = redpacketRain.float_url;
            this.khF = redpacketRain.dynamic_img;
            this.asD = redpacketRain.activity_id;
            this.mType = redpacketRain.show_type.intValue();
        }
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public String aXT() {
        return this.dYp;
    }

    public String cLo() {
        return this.khE;
    }

    public List<String> cLp() {
        return this.khF;
    }

    public String gL() {
        return this.asD;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void Jc(String str) {
        this.dYp = str;
    }

    public void Jd(String str) {
        this.khE = str;
    }

    public void ee(List<String> list) {
        this.khF = list;
    }

    public void aC(String str) {
        this.asD = str;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
