package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a jjX;
    private final int jjY = 10;
    private final int jjZ = 3000;
    public String jka = null;
    public boolean bVS = false;

    public b(String str) {
        aB(str, false);
    }

    public void aB(String str, boolean z) {
        this.jka = str;
        this.bVS = z;
        this.jjX = new com.baidu.adp.lib.stats.a("dbg");
        c.A(str, getNetType(), z);
    }

    public void start() {
        this.jjX.iO();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e cqS;
        if (this.jjX != null && (cqS = cqS()) != null) {
            if (z) {
                if (cqS.jkf != null) {
                    cqS.jkf.num++;
                    if (z2) {
                        cqS.jkf.jkc += j2;
                        cqS.jkf.size += j;
                    } else {
                        cqS.jkf.jkd++;
                    }
                } else {
                    return;
                }
            } else if (cqS.jkg != null) {
                cqS.jkg.num++;
                if (z2) {
                    cqS.jkg.jkc += j3;
                    cqS.jkg.size += j;
                    j2 = j3;
                } else {
                    cqS.jkg.jkd++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.jjX = null;
            if (z2) {
                c.a(cqS, 10);
            }
            if (this.jka == "frsStat") {
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
        e cqS;
        if (this.jjX != null && (cqS = cqS()) != null && cqS.jkh != null) {
            long iP = this.jjX.iP();
            if (iP > 3000) {
                d dVar = cqS.jkh;
                dVar.jkc = iP + dVar.jkc;
                cqS.jkh.num++;
                c.a(cqS, 10);
            }
        }
    }

    private e cqS() {
        return c.B(this.jka, getNetType(), this.bVS);
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
