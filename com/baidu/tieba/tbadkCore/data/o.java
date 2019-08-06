package com.baidu.tieba.tbadkCore.data;

import java.util.List;
import tbclient.RedpacketRain;
/* loaded from: classes.dex */
public class o {
    private long aGT;
    private String cWQ;
    private String hEP;
    private String jhn;
    private List<String> jho;
    private long mStartTime;
    private int mType;

    public void a(RedpacketRain redpacketRain) {
        if (redpacketRain != null) {
            this.mStartTime = redpacketRain.start_time.longValue() * 1000;
            this.aGT = redpacketRain.end_time.longValue() * 1000;
            this.cWQ = redpacketRain.jump_url;
            this.jhn = redpacketRain.float_url;
            this.jho = redpacketRain.dynamic_img;
            this.hEP = redpacketRain.activity_id;
            this.mType = redpacketRain.show_type.intValue();
        }
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getEndTime() {
        return this.aGT;
    }

    public String aCV() {
        return this.cWQ;
    }

    public String cpZ() {
        return this.jhn;
    }

    public List<String> cqa() {
        return this.jho;
    }

    public String cqb() {
        return this.hEP;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void setEndTime(long j) {
        this.aGT = j;
    }

    public void EL(String str) {
        this.cWQ = str;
    }

    public void EM(String str) {
        this.jhn = str;
    }

    public void ed(List<String> list) {
        this.jho = list;
    }

    public void EN(String str) {
        this.hEP = str;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
