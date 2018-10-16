package com.baidu.tieba.tbadkCore.data;

import java.util.List;
import tbclient.RedpacketRain;
/* loaded from: classes.dex */
public class m {
    private String bwU;
    private String hdR;
    private List<String> hdS;
    private String hdT;
    private long mEndTime;
    private long mStartTime;
    private int mType;

    public void a(RedpacketRain redpacketRain) {
        if (redpacketRain != null) {
            this.mStartTime = redpacketRain.start_time.longValue() * 1000;
            this.mEndTime = redpacketRain.end_time.longValue() * 1000;
            this.bwU = redpacketRain.jump_url;
            this.hdR = redpacketRain.float_url;
            this.hdS = redpacketRain.dynamic_img;
            this.hdT = redpacketRain.activity_id;
            this.mType = redpacketRain.show_type.intValue();
        }
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public String UL() {
        return this.bwU;
    }

    public String bCo() {
        return this.hdR;
    }

    public List<String> bCp() {
        return this.hdS;
    }

    public String bCq() {
        return this.hdT;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void uY(String str) {
        this.bwU = str;
    }

    public void uZ(String str) {
        this.hdR = str;
    }

    public void dL(List<String> list) {
        this.hdS = list;
    }

    public void va(String str) {
        this.hdT = str;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
