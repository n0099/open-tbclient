package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a iHs;
    private final int iHt = 10;
    private final int iHu = 3000;
    public String iHv = null;
    public boolean bMr = false;

    public b(String str) {
        av(str, false);
    }

    public void av(String str, boolean z) {
        this.iHv = str;
        this.bMr = z;
        this.iHs = new com.baidu.adp.lib.stats.a("dbg");
        c.v(str, getNetType(), z);
    }

    public void start() {
        this.iHs.jL();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e ceM;
        if (this.iHs != null && (ceM = ceM()) != null) {
            if (z) {
                if (ceM.iHA != null) {
                    ceM.iHA.num++;
                    if (z2) {
                        ceM.iHA.iHx += j2;
                        ceM.iHA.size += j;
                    } else {
                        ceM.iHA.iHy++;
                    }
                } else {
                    return;
                }
            } else if (ceM.iHB != null) {
                ceM.iHB.num++;
                if (z2) {
                    ceM.iHB.iHx += j3;
                    ceM.iHB.size += j;
                    j2 = j3;
                } else {
                    ceM.iHB.iHy++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.iHs = null;
            if (z2) {
                c.a(ceM, 10);
            }
            if (this.iHv == "frsStat") {
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
        e ceM;
        if (this.iHs != null && (ceM = ceM()) != null && ceM.iHC != null) {
            long jM = this.iHs.jM();
            if (jM > 3000) {
                d dVar = ceM.iHC;
                dVar.iHx = jM + dVar.iHx;
                ceM.iHC.num++;
                c.a(ceM, 10);
            }
        }
    }

    private e ceM() {
        return c.w(this.iHv, getNetType(), this.bMr);
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
