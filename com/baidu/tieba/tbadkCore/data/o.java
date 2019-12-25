package com.baidu.tieba.tbadkCore.data;

import java.util.List;
import tbclient.RedpacketRain;
/* loaded from: classes.dex */
public class o {
    private String aoy;
    private long bDa;
    private String dUb;
    private String kcT;
    private List<String> kcU;
    private long mStartTime;
    private int mType;

    public void a(RedpacketRain redpacketRain) {
        if (redpacketRain != null) {
            this.mStartTime = redpacketRain.start_time.longValue() * 1000;
            this.bDa = redpacketRain.end_time.longValue() * 1000;
            this.dUb = redpacketRain.jump_url;
            this.kcT = redpacketRain.float_url;
            this.kcU = redpacketRain.dynamic_img;
            this.aoy = redpacketRain.activity_id;
            this.mType = redpacketRain.show_type.intValue();
        }
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getEndTime() {
        return this.bDa;
    }

    public String aVj() {
        return this.dUb;
    }

    public String cIH() {
        return this.kcT;
    }

    public List<String> cII() {
        return this.kcU;
    }

    public String cIJ() {
        return this.aoy;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void setEndTime(long j) {
        this.bDa = j;
    }

    public void IE(String str) {
        this.dUb = str;
    }

    public void IF(String str) {
        this.kcT = str;
    }

    public void ei(List<String> list) {
        this.kcU = list;
    }

    public void IG(String str) {
        this.aoy = str;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
