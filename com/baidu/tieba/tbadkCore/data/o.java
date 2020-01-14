package com.baidu.tieba.tbadkCore.data;

import java.util.List;
import tbclient.RedpacketRain;
/* loaded from: classes.dex */
public class o {
    private String apk;
    private long bDL;
    private String dUk;
    private String kgB;
    private List<String> kgC;
    private long mStartTime;
    private int mType;

    public void a(RedpacketRain redpacketRain) {
        if (redpacketRain != null) {
            this.mStartTime = redpacketRain.start_time.longValue() * 1000;
            this.bDL = redpacketRain.end_time.longValue() * 1000;
            this.dUk = redpacketRain.jump_url;
            this.kgB = redpacketRain.float_url;
            this.kgC = redpacketRain.dynamic_img;
            this.apk = redpacketRain.activity_id;
            this.mType = redpacketRain.show_type.intValue();
        }
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getEndTime() {
        return this.bDL;
    }

    public String aVC() {
        return this.dUk;
    }

    public String cJN() {
        return this.kgB;
    }

    public List<String> cJO() {
        return this.kgC;
    }

    public String cJP() {
        return this.apk;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void setEndTime(long j) {
        this.bDL = j;
    }

    public void IO(String str) {
        this.dUk = str;
    }

    public void IP(String str) {
        this.kgB = str;
    }

    public void ei(List<String> list) {
        this.kgC = list;
    }

    public void IQ(String str) {
        this.apk = str;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
