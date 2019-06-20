package com.baidu.tieba.tbadkCore.data;

import java.util.List;
import tbclient.RedpacketRain;
/* loaded from: classes.dex */
public class o {
    private long aGl;
    private String cVn;
    private String hxL;
    private String iZP;
    private List<String> iZQ;
    private long mStartTime;
    private int mType;

    public void a(RedpacketRain redpacketRain) {
        if (redpacketRain != null) {
            this.mStartTime = redpacketRain.start_time.longValue() * 1000;
            this.aGl = redpacketRain.end_time.longValue() * 1000;
            this.cVn = redpacketRain.jump_url;
            this.iZP = redpacketRain.float_url;
            this.iZQ = redpacketRain.dynamic_img;
            this.hxL = redpacketRain.activity_id;
            this.mType = redpacketRain.show_type.intValue();
        }
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getEndTime() {
        return this.aGl;
    }

    public String aBE() {
        return this.cVn;
    }

    public String cmL() {
        return this.iZP;
    }

    public List<String> cmM() {
        return this.iZQ;
    }

    public String cmN() {
        return this.hxL;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void setEndTime(long j) {
        this.aGl = j;
    }

    public void DX(String str) {
        this.cVn = str;
    }

    public void DY(String str) {
        this.iZP = str;
    }

    public void ec(List<String> list) {
        this.iZQ = list;
    }

    public void DZ(String str) {
        this.hxL = str;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
