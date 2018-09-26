package com.baidu.tieba.tbadkCore.data;

import java.util.List;
import tbclient.RedpacketRain;
/* loaded from: classes.dex */
public class m {
    private long ack;
    private String bsN;
    private String gWw;
    private List<String> gWx;
    private String gWy;
    private long mStartTime;
    private int mType;

    public void a(RedpacketRain redpacketRain) {
        if (redpacketRain != null) {
            this.mStartTime = redpacketRain.start_time.longValue() * 1000;
            this.ack = redpacketRain.end_time.longValue() * 1000;
            this.bsN = redpacketRain.jump_url;
            this.gWw = redpacketRain.float_url;
            this.gWx = redpacketRain.dynamic_img;
            this.gWy = redpacketRain.activity_id;
            this.mType = redpacketRain.show_type.intValue();
        }
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getEndTime() {
        return this.ack;
    }

    public String SP() {
        return this.bsN;
    }

    public String byZ() {
        return this.gWw;
    }

    public List<String> bza() {
        return this.gWx;
    }

    public String bzb() {
        return this.gWy;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void setEndTime(long j) {
        this.ack = j;
    }

    public void uw(String str) {
        this.bsN = str;
    }

    public void ux(String str) {
        this.gWw = str;
    }

    public void dx(List<String> list) {
        this.gWx = list;
    }

    public void uy(String str) {
        this.gWy = str;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
