package com.baidu.tieba.tbadkCore.data;

import java.util.List;
import tbclient.RedpacketRain;
/* loaded from: classes.dex */
public class m {
    private long ZJ;
    private String bmZ;
    private String gOR;
    private List<String> gOS;
    private String gOT;
    private long mStartTime;
    private int mType;

    public void a(RedpacketRain redpacketRain) {
        if (redpacketRain != null) {
            this.mStartTime = redpacketRain.start_time.longValue() * 1000;
            this.ZJ = redpacketRain.end_time.longValue() * 1000;
            this.bmZ = redpacketRain.jump_url;
            this.gOR = redpacketRain.float_url;
            this.gOS = redpacketRain.dynamic_img;
            this.gOT = redpacketRain.activity_id;
            this.mType = redpacketRain.show_type.intValue();
        }
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getEndTime() {
        return this.ZJ;
    }

    public String Rb() {
        return this.bmZ;
    }

    public String bwv() {
        return this.gOR;
    }

    public List<String> bww() {
        return this.gOS;
    }

    public String bwx() {
        return this.gOT;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void cT(long j) {
        this.ZJ = j;
    }

    public void tP(String str) {
        this.bmZ = str;
    }

    public void tQ(String str) {
        this.gOR = str;
    }

    public void dw(List<String> list) {
        this.gOS = list;
    }

    public void tR(String str) {
        this.gOT = str;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
