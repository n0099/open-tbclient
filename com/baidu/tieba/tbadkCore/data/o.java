package com.baidu.tieba.tbadkCore.data;

import java.util.List;
import tbclient.RedpacketRain;
/* loaded from: classes.dex */
public class o {
    private String agx;
    private long ban;
    private String dgp;
    private String jiG;
    private List<String> jiH;
    private long mStartTime;
    private int mType;

    public void a(RedpacketRain redpacketRain) {
        if (redpacketRain != null) {
            this.mStartTime = redpacketRain.start_time.longValue() * 1000;
            this.ban = redpacketRain.end_time.longValue() * 1000;
            this.dgp = redpacketRain.jump_url;
            this.jiG = redpacketRain.float_url;
            this.jiH = redpacketRain.dynamic_img;
            this.agx = redpacketRain.activity_id;
            this.mType = redpacketRain.show_type.intValue();
        }
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getEndTime() {
        return this.ban;
    }

    public String aDq() {
        return this.dgp;
    }

    public String coB() {
        return this.jiG;
    }

    public List<String> coC() {
        return this.jiH;
    }

    public String coD() {
        return this.agx;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void setEndTime(long j) {
        this.ban = j;
    }

    public void DP(String str) {
        this.dgp = str;
    }

    public void DQ(String str) {
        this.jiG = str;
    }

    public void eq(List<String> list) {
        this.jiH = list;
    }

    public void DR(String str) {
        this.agx = str;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
