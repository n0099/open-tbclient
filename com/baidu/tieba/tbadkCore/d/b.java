package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a iZZ;
    private final int jaa = 10;
    private final int jab = 3000;
    public String jac = null;
    public boolean bUf = false;

    public b(String str) {
        ax(str, false);
    }

    public void ax(String str, boolean z) {
        this.jac = str;
        this.bUf = z;
        this.iZZ = new com.baidu.adp.lib.stats.a("dbg");
        c.y(str, getNetType(), z);
    }

    public void start() {
        this.iZZ.iF();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e cmP;
        if (this.iZZ != null && (cmP = cmP()) != null) {
            if (z) {
                if (cmP.jah != null) {
                    cmP.jah.num++;
                    if (z2) {
                        cmP.jah.jae += j2;
                        cmP.jah.size += j;
                    } else {
                        cmP.jah.jaf++;
                    }
                } else {
                    return;
                }
            } else if (cmP.jai != null) {
                cmP.jai.num++;
                if (z2) {
                    cmP.jai.jae += j3;
                    cmP.jai.size += j;
                    j2 = j3;
                } else {
                    cmP.jai.jaf++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.iZZ = null;
            if (z2) {
                c.a(cmP, 10);
            }
            if (this.jac == "frsStat") {
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
        e cmP;
        if (this.iZZ != null && (cmP = cmP()) != null && cmP.jaj != null) {
            long iG = this.iZZ.iG();
            if (iG > 3000) {
                d dVar = cmP.jaj;
                dVar.jae = iG + dVar.jae;
                cmP.jaj.num++;
                c.a(cmP, 10);
            }
        }
    }

    private e cmP() {
        return c.z(this.jac, getNetType(), this.bUf);
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
