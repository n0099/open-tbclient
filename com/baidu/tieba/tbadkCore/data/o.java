package com.baidu.tieba.tbadkCore.data;

import java.util.List;
import tbclient.RedpacketRain;
/* loaded from: classes.dex */
public class o {
    private long aGl;
    private String cVl;
    private String hxH;
    private String iZJ;
    private List<String> iZK;
    private long mStartTime;
    private int mType;

    public void a(RedpacketRain redpacketRain) {
        if (redpacketRain != null) {
            this.mStartTime = redpacketRain.start_time.longValue() * 1000;
            this.aGl = redpacketRain.end_time.longValue() * 1000;
            this.cVl = redpacketRain.jump_url;
            this.iZJ = redpacketRain.float_url;
            this.iZK = redpacketRain.dynamic_img;
            this.hxH = redpacketRain.activity_id;
            this.mType = redpacketRain.show_type.intValue();
        }
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getEndTime() {
        return this.aGl;
    }

    public String aBB() {
        return this.cVl;
    }

    public String cmI() {
        return this.iZJ;
    }

    public List<String> cmJ() {
        return this.iZK;
    }

    public String cmK() {
        return this.hxH;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void setEndTime(long j) {
        this.aGl = j;
    }

    public void DV(String str) {
        this.cVl = str;
    }

    public void DW(String str) {
        this.iZJ = str;
    }

    public void ec(List<String> list) {
        this.iZK = list;
    }

    public void DX(String str) {
        this.hxH = str;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
