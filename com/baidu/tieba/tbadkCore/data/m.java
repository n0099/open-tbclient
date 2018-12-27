package com.baidu.tieba.tbadkCore.data;

import java.util.List;
import tbclient.RedpacketRain;
/* loaded from: classes.dex */
public class m {
    private String bBf;
    private String hpu;
    private List<String> hpv;
    private String hpw;
    private long mEndTime;
    private long mStartTime;
    private int mType;

    public void a(RedpacketRain redpacketRain) {
        if (redpacketRain != null) {
            this.mStartTime = redpacketRain.start_time.longValue() * 1000;
            this.mEndTime = redpacketRain.end_time.longValue() * 1000;
            this.bBf = redpacketRain.jump_url;
            this.hpu = redpacketRain.float_url;
            this.hpv = redpacketRain.dynamic_img;
            this.hpw = redpacketRain.activity_id;
            this.mType = redpacketRain.show_type.intValue();
        }
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public String Wc() {
        return this.bBf;
    }

    public String bEw() {
        return this.hpu;
    }

    public List<String> bEx() {
        return this.hpv;
    }

    public String bEy() {
        return this.hpw;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void vH(String str) {
        this.bBf = str;
    }

    public void vI(String str) {
        this.hpu = str;
    }

    public void dO(List<String> list) {
        this.hpv = list;
    }

    public void vJ(String str) {
        this.hpw = str;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
