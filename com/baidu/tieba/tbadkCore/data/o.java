package com.baidu.tieba.tbadkCore.data;

import java.util.List;
import tbclient.RedpacketRain;
/* loaded from: classes.dex */
public class o {
    private String aMc;
    private String eyP;
    private List<String> kTA;
    private String kTz;
    private long mEndTime;
    private long mStartTime;
    private int mType;

    public void a(RedpacketRain redpacketRain) {
        if (redpacketRain != null) {
            this.mStartTime = redpacketRain.start_time.longValue() * 1000;
            this.mEndTime = redpacketRain.end_time.longValue() * 1000;
            this.eyP = redpacketRain.jump_url;
            this.kTz = redpacketRain.float_url;
            this.kTA = redpacketRain.dynamic_img;
            this.aMc = redpacketRain.activity_id;
            this.mType = redpacketRain.show_type.intValue();
        }
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public String bgd() {
        return this.eyP;
    }

    public String cWF() {
        return this.kTz;
    }

    public List<String> cWG() {
        return this.kTA;
    }

    public String lp() {
        return this.aMc;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void KM(String str) {
        this.eyP = str;
    }

    public void KN(String str) {
        this.kTz = str;
    }

    public void et(List<String> list) {
        this.kTA = list;
    }

    public void bR(String str) {
        this.aMc = str;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
