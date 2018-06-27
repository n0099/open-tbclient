package com.baidu.tieba.tbadkCore.data;

import java.util.List;
import tbclient.RedpacketRain;
/* loaded from: classes.dex */
public class m {
    private long aae;
    private String bmq;
    private String gNR;
    private List<String> gNS;
    private String gNT;
    private long mStartTime;
    private int mType;

    public void a(RedpacketRain redpacketRain) {
        if (redpacketRain != null) {
            this.mStartTime = redpacketRain.start_time.longValue() * 1000;
            this.aae = redpacketRain.end_time.longValue() * 1000;
            this.bmq = redpacketRain.jump_url;
            this.gNR = redpacketRain.float_url;
            this.gNS = redpacketRain.dynamic_img;
            this.gNT = redpacketRain.activity_id;
            this.mType = redpacketRain.show_type.intValue();
        }
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getEndTime() {
        return this.aae;
    }

    public String QP() {
        return this.bmq;
    }

    public String bxR() {
        return this.gNR;
    }

    public List<String> bxS() {
        return this.gNS;
    }

    public String bxT() {
        return this.gNT;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void cW(long j) {
        this.aae = j;
    }

    public void tN(String str) {
        this.bmq = str;
    }

    public void tO(String str) {
        this.gNR = str;
    }

    public void dA(List<String> list) {
        this.gNS = list;
    }

    public void tP(String str) {
        this.gNT = str;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
