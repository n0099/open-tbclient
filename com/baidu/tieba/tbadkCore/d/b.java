package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a iHz;
    private final int iHA = 10;
    private final int iHB = 3000;
    public String iHC = null;
    public boolean bMq = false;

    public b(String str) {
        au(str, false);
    }

    public void au(String str, boolean z) {
        this.iHC = str;
        this.bMq = z;
        this.iHz = new com.baidu.adp.lib.stats.a("dbg");
        c.v(str, getNetType(), z);
    }

    public void start() {
        this.iHz.jL();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e ceJ;
        if (this.iHz != null && (ceJ = ceJ()) != null) {
            if (z) {
                if (ceJ.iHH != null) {
                    ceJ.iHH.num++;
                    if (z2) {
                        ceJ.iHH.iHE += j2;
                        ceJ.iHH.size += j;
                    } else {
                        ceJ.iHH.iHF++;
                    }
                } else {
                    return;
                }
            } else if (ceJ.iHI != null) {
                ceJ.iHI.num++;
                if (z2) {
                    ceJ.iHI.iHE += j3;
                    ceJ.iHI.size += j;
                    j2 = j3;
                } else {
                    ceJ.iHI.iHF++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.iHz = null;
            if (z2) {
                c.a(ceJ, 10);
            }
            if (this.iHC == "frsStat") {
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
        e ceJ;
        if (this.iHz != null && (ceJ = ceJ()) != null && ceJ.iHJ != null) {
            long jM = this.iHz.jM();
            if (jM > 3000) {
                d dVar = ceJ.iHJ;
                dVar.iHE = jM + dVar.iHE;
                ceJ.iHJ.num++;
                c.a(ceJ, 10);
            }
        }
    }

    private e ceJ() {
        return c.w(this.iHC, getNetType(), this.bMq);
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
