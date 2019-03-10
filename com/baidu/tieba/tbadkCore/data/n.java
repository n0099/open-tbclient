package com.baidu.tieba.tbadkCore.data;

import java.util.List;
import tbclient.RedpacketRain;
/* loaded from: classes.dex */
public class n {
    private long aEo;
    private String cNa;
    private String hgC;
    private String iHn;
    private List<String> iHo;
    private long mStartTime;
    private int mType;

    public void a(RedpacketRain redpacketRain) {
        if (redpacketRain != null) {
            this.mStartTime = redpacketRain.start_time.longValue() * 1000;
            this.aEo = redpacketRain.end_time.longValue() * 1000;
            this.cNa = redpacketRain.jump_url;
            this.iHn = redpacketRain.float_url;
            this.iHo = redpacketRain.dynamic_img;
            this.hgC = redpacketRain.activity_id;
            this.mType = redpacketRain.show_type.intValue();
        }
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getEndTime() {
        return this.aEo;
    }

    public String awz() {
        return this.cNa;
    }

    public String ceF() {
        return this.iHn;
    }

    public List<String> ceG() {
        return this.iHo;
    }

    public String ceH() {
        return this.hgC;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void setEndTime(long j) {
        this.aEo = j;
    }

    public void CC(String str) {
        this.cNa = str;
    }

    public void CD(String str) {
        this.iHn = str;
    }

    public void dV(List<String> list) {
        this.iHo = list;
    }

    public void CE(String str) {
        this.hgC = str;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
