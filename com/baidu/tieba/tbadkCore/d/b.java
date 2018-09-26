package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a gWK;
    private final int gWL = 10;
    private final int gWM = 3000;
    public String gWN = null;
    public boolean auS = false;

    public b(String str) {
        V(str, false);
    }

    public void V(String str, boolean z) {
        this.gWN = str;
        this.auS = z;
        this.gWK = new com.baidu.adp.lib.stats.a("dbg");
        c.j(str, getNetType(), z);
    }

    public void start() {
        this.gWK.jx();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e bze;
        if (this.gWK != null && (bze = bze()) != null) {
            if (z) {
                if (bze.gWS != null) {
                    bze.gWS.num++;
                    if (z2) {
                        bze.gWS.gWP += j2;
                        bze.gWS.size += j;
                    } else {
                        bze.gWS.gWQ++;
                    }
                } else {
                    return;
                }
            } else if (bze.gWT != null) {
                bze.gWT.num++;
                if (z2) {
                    bze.gWT.gWP += j3;
                    bze.gWT.size += j;
                    j2 = j3;
                } else {
                    bze.gWT.gWQ++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.gWK = null;
            if (z2) {
                c.a(bze, 10);
            }
            if (this.gWN == "frsStat") {
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
        e bze;
        if (this.gWK != null && (bze = bze()) != null && bze.gWU != null) {
            long jy = this.gWK.jy();
            if (jy > 3000) {
                d dVar = bze.gWU;
                dVar.gWP = jy + dVar.gWP;
                bze.gWU.num++;
                c.a(bze, 10);
            }
        }
    }

    private e bze() {
        return c.k(this.gWN, getNetType(), this.auS);
    }

    private String getNetType() {
        int kQ = j.kQ();
        if (kQ == 0) {
            return "N";
        }
        if (kQ == 1) {
            return "WIFI";
        }
        if (kQ == 3) {
            return "3G";
        }
        if (kQ != 2) {
            return "N";
        }
        return "2G";
    }
}
