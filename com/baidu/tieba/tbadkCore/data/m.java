package com.baidu.tieba.tbadkCore.data;

import java.util.List;
import tbclient.RedpacketRain;
/* loaded from: classes.dex */
public class m {
    private String bxF;
    private String hfp;
    private List<String> hfq;
    private String hfr;
    private long mEndTime;
    private long mStartTime;
    private int mType;

    public void a(RedpacketRain redpacketRain) {
        if (redpacketRain != null) {
            this.mStartTime = redpacketRain.start_time.longValue() * 1000;
            this.mEndTime = redpacketRain.end_time.longValue() * 1000;
            this.bxF = redpacketRain.jump_url;
            this.hfp = redpacketRain.float_url;
            this.hfq = redpacketRain.dynamic_img;
            this.hfr = redpacketRain.activity_id;
            this.mType = redpacketRain.show_type.intValue();
        }
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public String UU() {
        return this.bxF;
    }

    public String bBK() {
        return this.hfp;
    }

    public List<String> bBL() {
        return this.hfq;
    }

    public String bBM() {
        return this.hfr;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void vd(String str) {
        this.bxF = str;
    }

    public void ve(String str) {
        this.hfp = str;
    }

    public void dJ(List<String> list) {
        this.hfq = list;
    }

    public void vf(String str) {
        this.hfr = str;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
