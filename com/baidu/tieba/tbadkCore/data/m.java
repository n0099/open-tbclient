package com.baidu.tieba.tbadkCore.data;

import java.util.List;
import tbclient.RedpacketRain;
/* loaded from: classes.dex */
public class m {
    private String bBc;
    private String hmj;
    private List<String> hmk;
    private String hml;
    private long mEndTime;
    private long mStartTime;
    private int mType;

    public void a(RedpacketRain redpacketRain) {
        if (redpacketRain != null) {
            this.mStartTime = redpacketRain.start_time.longValue() * 1000;
            this.mEndTime = redpacketRain.end_time.longValue() * 1000;
            this.bBc = redpacketRain.jump_url;
            this.hmj = redpacketRain.float_url;
            this.hmk = redpacketRain.dynamic_img;
            this.hml = redpacketRain.activity_id;
            this.mType = redpacketRain.show_type.intValue();
        }
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public String Wa() {
        return this.bBc;
    }

    public String bDF() {
        return this.hmj;
    }

    public List<String> bDG() {
        return this.hmk;
    }

    public String bDH() {
        return this.hml;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void vE(String str) {
        this.bBc = str;
    }

    public void vF(String str) {
        this.hmj = str;
    }

    public void dN(List<String> list) {
        this.hmk = list;
    }

    public void vG(String str) {
        this.hml = str;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
