package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a iHe;
    private final int iHf = 10;
    private final int iHg = 3000;
    public String iHh = null;
    public boolean bMu = false;

    public b(String str) {
        av(str, false);
    }

    public void av(String str, boolean z) {
        this.iHh = str;
        this.bMu = z;
        this.iHe = new com.baidu.adp.lib.stats.a("dbg");
        c.v(str, getNetType(), z);
    }

    public void start() {
        this.iHe.jL();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e ceI;
        if (this.iHe != null && (ceI = ceI()) != null) {
            if (z) {
                if (ceI.iHm != null) {
                    ceI.iHm.num++;
                    if (z2) {
                        ceI.iHm.iHj += j2;
                        ceI.iHm.size += j;
                    } else {
                        ceI.iHm.iHk++;
                    }
                } else {
                    return;
                }
            } else if (ceI.iHn != null) {
                ceI.iHn.num++;
                if (z2) {
                    ceI.iHn.iHj += j3;
                    ceI.iHn.size += j;
                    j2 = j3;
                } else {
                    ceI.iHn.iHk++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.iHe = null;
            if (z2) {
                c.a(ceI, 10);
            }
            if (this.iHh == "frsStat") {
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
        e ceI;
        if (this.iHe != null && (ceI = ceI()) != null && ceI.iHo != null) {
            long jM = this.iHe.jM();
            if (jM > 3000) {
                d dVar = ceI.iHo;
                dVar.iHj = jM + dVar.iHj;
                ceI.iHo.num++;
                c.a(ceI, 10);
            }
        }
    }

    private e ceI() {
        return c.w(this.iHh, getNetType(), this.bMu);
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
