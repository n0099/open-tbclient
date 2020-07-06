package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a lHl;
    private final int lHm = 10;
    private final int lHn = 3000;
    public String mLogType = null;
    public boolean mIsJson = false;

    public b(String str) {
        aW(str, false);
    }

    public void aW(String str, boolean z) {
        this.mLogType = str;
        this.mIsJson = z;
        this.lHl = new com.baidu.adp.lib.stats.a("dbg");
        c.D(str, getNetType(), z);
    }

    public void start() {
        this.lHl.startTimer();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e dir;
        if (this.lHl != null && (dir = dir()) != null) {
            if (z) {
                if (dir.lHs != null) {
                    dir.lHs.num++;
                    if (z2) {
                        dir.lHs.lHp += j2;
                        dir.lHs.size += j;
                    } else {
                        dir.lHs.lHq++;
                    }
                } else {
                    return;
                }
            } else if (dir.lHt != null) {
                dir.lHt.num++;
                if (z2) {
                    dir.lHt.lHp += j3;
                    dir.lHt.size += j;
                    j2 = j3;
                } else {
                    dir.lHt.lHq++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.lHl = null;
            if (z2) {
                c.a(dir, 10);
            }
            if (this.mLogType == "frsStat") {
                if (!z2 || j2 > 3000) {
                    com.baidu.adp.lib.stats.a aVar = new com.baidu.adp.lib.stats.a("dbg");
                    aVar.append("act", "frs");
                    aVar.append("result", z2 ? "0" : "1");
                    aVar.append("isHttp", z ? "1" : "0");
                    aVar.append("timeCost", String.valueOf(j2));
                    aVar.append("errCode", String.valueOf(i));
                    aVar.append("errMsg", str);
                    aVar.append("down", String.valueOf(j));
                    BdStatisticsManager.getInstance().debug("frs", aVar);
                }
            }
        }
    }

    public void destory() {
        e dir;
        if (this.lHl != null && (dir = dir()) != null && dir.lHu != null) {
            long timeCost = this.lHl.getTimeCost();
            if (timeCost > 3000) {
                d dVar = dir.lHu;
                dVar.lHp = timeCost + dVar.lHp;
                dir.lHu.num++;
                c.a(dir, 10);
            }
        }
    }

    private e dir() {
        return c.E(this.mLogType, getNetType(), this.mIsJson);
    }

    private String getNetType() {
        int netType = j.netType();
        if (netType == 0) {
            return "N";
        }
        if (netType == 1) {
            return "WIFI";
        }
        if (netType == 3) {
            return "3G";
        }
        if (netType != 2) {
            return "N";
        }
        return "2G";
    }
}
