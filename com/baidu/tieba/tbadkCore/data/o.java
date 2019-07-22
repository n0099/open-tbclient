package com.baidu.tieba.tbadkCore.data;

import java.util.List;
import tbclient.RedpacketRain;
/* loaded from: classes.dex */
public class o {
    private long aGT;
    private String cWJ;
    private String hDX;
    private String jgg;
    private List<String> jgh;
    private long mStartTime;
    private int mType;

    public void a(RedpacketRain redpacketRain) {
        if (redpacketRain != null) {
            this.mStartTime = redpacketRain.start_time.longValue() * 1000;
            this.aGT = redpacketRain.end_time.longValue() * 1000;
            this.cWJ = redpacketRain.jump_url;
            this.jgg = redpacketRain.float_url;
            this.jgh = redpacketRain.dynamic_img;
            this.hDX = redpacketRain.activity_id;
            this.mType = redpacketRain.show_type.intValue();
        }
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getEndTime() {
        return this.aGT;
    }

    public String aCT() {
        return this.cWJ;
    }

    public String cpD() {
        return this.jgg;
    }

    public List<String> cpE() {
        return this.jgh;
    }

    public String cpF() {
        return this.hDX;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void setEndTime(long j) {
        this.aGT = j;
    }

    public void EK(String str) {
        this.cWJ = str;
    }

    public void EL(String str) {
        this.jgg = str;
    }

    public void ee(List<String> list) {
        this.jgh = list;
    }

    public void EM(String str) {
        this.hDX = str;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
