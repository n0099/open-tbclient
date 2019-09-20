package com.baidu.tieba.tbadkCore.data;

import java.util.List;
import tbclient.RedpacketRain;
/* loaded from: classes.dex */
public class o {
    private long aHr;
    private String cXJ;
    private String hGL;
    private String jjJ;
    private List<String> jjK;
    private long mStartTime;
    private int mType;

    public void a(RedpacketRain redpacketRain) {
        if (redpacketRain != null) {
            this.mStartTime = redpacketRain.start_time.longValue() * 1000;
            this.aHr = redpacketRain.end_time.longValue() * 1000;
            this.cXJ = redpacketRain.jump_url;
            this.jjJ = redpacketRain.float_url;
            this.jjK = redpacketRain.dynamic_img;
            this.hGL = redpacketRain.activity_id;
            this.mType = redpacketRain.show_type.intValue();
        }
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getEndTime() {
        return this.aHr;
    }

    public String aDj() {
        return this.cXJ;
    }

    public String cqN() {
        return this.jjJ;
    }

    public List<String> cqO() {
        return this.jjK;
    }

    public String cqP() {
        return this.hGL;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void setEndTime(long j) {
        this.aHr = j;
    }

    public void Fl(String str) {
        this.cXJ = str;
    }

    public void Fm(String str) {
        this.jjJ = str;
    }

    public void ed(List<String> list) {
        this.jjK = list;
    }

    public void Fn(String str) {
        this.hGL = str;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
