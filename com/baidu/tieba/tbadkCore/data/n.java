package com.baidu.tieba.tbadkCore.data;

import java.util.List;
import tbclient.RedpacketRain;
/* loaded from: classes.dex */
public class n {
    private long aEp;
    private String cMX;
    private String hgB;
    private String iHf;
    private List<String> iHg;
    private long mStartTime;
    private int mType;

    public void a(RedpacketRain redpacketRain) {
        if (redpacketRain != null) {
            this.mStartTime = redpacketRain.start_time.longValue() * 1000;
            this.aEp = redpacketRain.end_time.longValue() * 1000;
            this.cMX = redpacketRain.jump_url;
            this.iHf = redpacketRain.float_url;
            this.iHg = redpacketRain.dynamic_img;
            this.hgB = redpacketRain.activity_id;
            this.mType = redpacketRain.show_type.intValue();
        }
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getEndTime() {
        return this.aEp;
    }

    public String awy() {
        return this.cMX;
    }

    public String ceH() {
        return this.iHf;
    }

    public List<String> ceI() {
        return this.iHg;
    }

    public String ceJ() {
        return this.hgB;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void setEndTime(long j) {
        this.aEp = j;
    }

    public void CA(String str) {
        this.cMX = str;
    }

    public void CB(String str) {
        this.iHf = str;
    }

    public void dV(List<String> list) {
        this.iHg = list;
    }

    public void CC(String str) {
        this.hgB = str;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
