package com.baidu.tieba.tbadkCore.data;

import java.util.List;
import tbclient.RedpacketRain;
/* loaded from: classes.dex */
public class m {
    private long ZI;
    private String bmW;
    private String gOP;
    private List<String> gOQ;
    private String gOR;
    private long mStartTime;
    private int mType;

    public void a(RedpacketRain redpacketRain) {
        if (redpacketRain != null) {
            this.mStartTime = redpacketRain.start_time.longValue() * 1000;
            this.ZI = redpacketRain.end_time.longValue() * 1000;
            this.bmW = redpacketRain.jump_url;
            this.gOP = redpacketRain.float_url;
            this.gOQ = redpacketRain.dynamic_img;
            this.gOR = redpacketRain.activity_id;
            this.mType = redpacketRain.show_type.intValue();
        }
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getEndTime() {
        return this.ZI;
    }

    public String QW() {
        return this.bmW;
    }

    public String bwu() {
        return this.gOP;
    }

    public List<String> bwv() {
        return this.gOQ;
    }

    public String bww() {
        return this.gOR;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void cT(long j) {
        this.ZI = j;
    }

    public void tL(String str) {
        this.bmW = str;
    }

    public void tM(String str) {
        this.gOP = str;
    }

    public void dw(List<String> list) {
        this.gOQ = list;
    }

    public void tN(String str) {
        this.gOR = str;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
