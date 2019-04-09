package com.baidu.tieba.tbadkCore.data;

import java.util.List;
import tbclient.RedpacketRain;
/* loaded from: classes.dex */
public class n {
    private long aEt;
    private String cNa;
    private String hgp;
    private String iGQ;
    private List<String> iGR;
    private long mStartTime;
    private int mType;

    public void a(RedpacketRain redpacketRain) {
        if (redpacketRain != null) {
            this.mStartTime = redpacketRain.start_time.longValue() * 1000;
            this.aEt = redpacketRain.end_time.longValue() * 1000;
            this.cNa = redpacketRain.jump_url;
            this.iGQ = redpacketRain.float_url;
            this.iGR = redpacketRain.dynamic_img;
            this.hgp = redpacketRain.activity_id;
            this.mType = redpacketRain.show_type.intValue();
        }
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getEndTime() {
        return this.aEt;
    }

    public String awv() {
        return this.cNa;
    }

    public String ceD() {
        return this.iGQ;
    }

    public List<String> ceE() {
        return this.iGR;
    }

    public String ceF() {
        return this.hgp;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void setEndTime(long j) {
        this.aEt = j;
    }

    public void Cz(String str) {
        this.cNa = str;
    }

    public void CA(String str) {
        this.iGQ = str;
    }

    public void dS(List<String> list) {
        this.iGR = list;
    }

    public void CB(String str) {
        this.hgp = str;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
