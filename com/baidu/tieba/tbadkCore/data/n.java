package com.baidu.tieba.tbadkCore.data;

import java.util.List;
import tbclient.RedpacketRain;
/* loaded from: classes.dex */
public class n {
    private long aEo;
    private String cNa;
    private String hgB;
    private String iHm;
    private List<String> iHn;
    private long mStartTime;
    private int mType;

    public void a(RedpacketRain redpacketRain) {
        if (redpacketRain != null) {
            this.mStartTime = redpacketRain.start_time.longValue() * 1000;
            this.aEo = redpacketRain.end_time.longValue() * 1000;
            this.cNa = redpacketRain.jump_url;
            this.iHm = redpacketRain.float_url;
            this.iHn = redpacketRain.dynamic_img;
            this.hgB = redpacketRain.activity_id;
            this.mType = redpacketRain.show_type.intValue();
        }
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getEndTime() {
        return this.aEo;
    }

    public String awy() {
        return this.cNa;
    }

    public String ceE() {
        return this.iHm;
    }

    public List<String> ceF() {
        return this.iHn;
    }

    public String ceG() {
        return this.hgB;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void setEndTime(long j) {
        this.aEo = j;
    }

    public void CB(String str) {
        this.cNa = str;
    }

    public void CC(String str) {
        this.iHm = str;
    }

    public void dV(List<String> list) {
        this.iHn = list;
    }

    public void CD(String str) {
        this.hgB = str;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
