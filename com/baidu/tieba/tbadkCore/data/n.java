package com.baidu.tieba.tbadkCore.data;

import java.util.List;
import tbclient.RedpacketRain;
/* loaded from: classes.dex */
public class n {
    private long aEs;
    private String cMZ;
    private String hgo;
    private String iGP;
    private List<String> iGQ;
    private long mStartTime;
    private int mType;

    public void a(RedpacketRain redpacketRain) {
        if (redpacketRain != null) {
            this.mStartTime = redpacketRain.start_time.longValue() * 1000;
            this.aEs = redpacketRain.end_time.longValue() * 1000;
            this.cMZ = redpacketRain.jump_url;
            this.iGP = redpacketRain.float_url;
            this.iGQ = redpacketRain.dynamic_img;
            this.hgo = redpacketRain.activity_id;
            this.mType = redpacketRain.show_type.intValue();
        }
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getEndTime() {
        return this.aEs;
    }

    public String awv() {
        return this.cMZ;
    }

    public String ceD() {
        return this.iGP;
    }

    public List<String> ceE() {
        return this.iGQ;
    }

    public String ceF() {
        return this.hgo;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void setEndTime(long j) {
        this.aEs = j;
    }

    public void Cz(String str) {
        this.cMZ = str;
    }

    public void CA(String str) {
        this.iGP = str;
    }

    public void dS(List<String> list) {
        this.iGQ = list;
    }

    public void CB(String str) {
        this.hgo = str;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
