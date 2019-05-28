package com.baidu.tieba.tbadkCore.data;

import java.util.List;
import tbclient.RedpacketRain;
/* loaded from: classes.dex */
public class o {
    private long aGl;
    private String cVm;
    private String hxK;
    private String iZL;
    private List<String> iZM;
    private long mStartTime;
    private int mType;

    public void a(RedpacketRain redpacketRain) {
        if (redpacketRain != null) {
            this.mStartTime = redpacketRain.start_time.longValue() * 1000;
            this.aGl = redpacketRain.end_time.longValue() * 1000;
            this.cVm = redpacketRain.jump_url;
            this.iZL = redpacketRain.float_url;
            this.iZM = redpacketRain.dynamic_img;
            this.hxK = redpacketRain.activity_id;
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
        return this.cVm;
    }

    public String cmK() {
        return this.iZL;
    }

    public List<String> cmL() {
        return this.iZM;
    }

    public String cmM() {
        return this.hxK;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void setEndTime(long j) {
        this.aGl = j;
    }

    public void DV(String str) {
        this.cVm = str;
    }

    public void DW(String str) {
        this.iZL = str;
    }

    public void ec(List<String> list) {
        this.iZM = list;
    }

    public void DX(String str) {
        this.hxK = str;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
