package com.baidu.tieba.tbadkCore.data;

import java.util.List;
import tbclient.RedpacketRain;
/* loaded from: classes.dex */
public class o {
    private String asO;
    private String dYS;
    private String kjt;
    private List<String> kju;
    private long mEndTime;
    private long mStartTime;
    private int mType;

    public void a(RedpacketRain redpacketRain) {
        if (redpacketRain != null) {
            this.mStartTime = redpacketRain.start_time.longValue() * 1000;
            this.mEndTime = redpacketRain.end_time.longValue() * 1000;
            this.dYS = redpacketRain.jump_url;
            this.kjt = redpacketRain.float_url;
            this.kju = redpacketRain.dynamic_img;
            this.asO = redpacketRain.activity_id;
            this.mType = redpacketRain.show_type.intValue();
        }
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public String aXY() {
        return this.dYS;
    }

    public String cLJ() {
        return this.kjt;
    }

    public List<String> cLK() {
        return this.kju;
    }

    public String gL() {
        return this.asO;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void Jd(String str) {
        this.dYS = str;
    }

    public void Je(String str) {
        this.kjt = str;
    }

    public void ee(List<String> list) {
        this.kju = list;
    }

    public void aC(String str) {
        this.asO = str;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
