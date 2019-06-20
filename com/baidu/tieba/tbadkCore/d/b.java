package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a jad;
    private final int jae = 10;
    private final int jaf = 3000;
    public String jag = null;
    public boolean bUg = false;

    public b(String str) {
        ax(str, false);
    }

    public void ax(String str, boolean z) {
        this.jag = str;
        this.bUg = z;
        this.jad = new com.baidu.adp.lib.stats.a("dbg");
        c.y(str, getNetType(), z);
    }

    public void start() {
        this.jad.iF();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e cmQ;
        if (this.jad != null && (cmQ = cmQ()) != null) {
            if (z) {
                if (cmQ.jal != null) {
                    cmQ.jal.num++;
                    if (z2) {
                        cmQ.jal.jai += j2;
                        cmQ.jal.size += j;
                    } else {
                        cmQ.jal.jaj++;
                    }
                } else {
                    return;
                }
            } else if (cmQ.jam != null) {
                cmQ.jam.num++;
                if (z2) {
                    cmQ.jam.jai += j3;
                    cmQ.jam.size += j;
                    j2 = j3;
                } else {
                    cmQ.jam.jaj++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.jad = null;
            if (z2) {
                c.a(cmQ, 10);
            }
            if (this.jag == "frsStat") {
                if (!z2 || j2 > 3000) {
                    com.baidu.adp.lib.stats.a aVar = new com.baidu.adp.lib.stats.a("dbg");
                    aVar.append(SocialConstants.PARAM_ACT, "frs");
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
        e cmQ;
        if (this.jad != null && (cmQ = cmQ()) != null && cmQ.jan != null) {
            long iG = this.jad.iG();
            if (iG > 3000) {
                d dVar = cmQ.jan;
                dVar.jai = iG + dVar.jai;
                cmQ.jan.num++;
                c.a(cmQ, 10);
            }
        }
    }

    private e cmQ() {
        return c.z(this.jag, getNetType(), this.bUg);
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
