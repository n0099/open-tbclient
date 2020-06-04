package com.baidu.tieba.tbadkCore.data;

import java.util.List;
import tbclient.RedpacketRain;
/* loaded from: classes.dex */
public class p {
    private String aSi;
    private String eNF;
    private String lnf;
    private List<String> lnh;
    private long mEndTime;
    private long mStartTime;
    private int mType;

    public void a(RedpacketRain redpacketRain) {
        if (redpacketRain != null) {
            this.mStartTime = redpacketRain.start_time.longValue() * 1000;
            this.mEndTime = redpacketRain.end_time.longValue() * 1000;
            this.eNF = redpacketRain.jump_url;
            this.lnf = redpacketRain.float_url;
            this.lnh = redpacketRain.dynamic_img;
            this.aSi = redpacketRain.activity_id;
            this.mType = redpacketRain.show_type.intValue();
        }
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public String vX() {
        return this.eNF;
    }

    public String ddX() {
        return this.lnf;
    }

    public List<String> ddY() {
        return this.lnh;
    }

    public String lr() {
        return this.aSi;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void er(String str) {
        this.eNF = str;
    }

    public void MD(String str) {
        this.lnf = str;
    }

    public void eC(List<String> list) {
        this.lnh = list;
    }

    public void bS(String str) {
        this.aSi = str;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
