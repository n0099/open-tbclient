package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a gPe;
    private final int gPf = 10;
    private final int gPg = 3000;
    public String gPh = null;
    public boolean ast = false;

    public b(String str) {
        U(str, false);
    }

    public void U(String str, boolean z) {
        this.gPh = str;
        this.ast = z;
        this.gPe = new com.baidu.adp.lib.stats.a("dbg");
        c.j(str, getNetType(), z);
    }

    public void start() {
        this.gPe.ir();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e bwz;
        if (this.gPe != null && (bwz = bwz()) != null) {
            if (z) {
                if (bwz.gPm != null) {
                    bwz.gPm.num++;
                    if (z2) {
                        bwz.gPm.gPj += j2;
                        bwz.gPm.size += j;
                    } else {
                        bwz.gPm.gPk++;
                    }
                } else {
                    return;
                }
            } else if (bwz.gPn != null) {
                bwz.gPn.num++;
                if (z2) {
                    bwz.gPn.gPj += j3;
                    bwz.gPn.size += j;
                    j2 = j3;
                } else {
                    bwz.gPn.gPk++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.gPe = null;
            if (z2) {
                c.a(bwz, 10);
            }
            if (this.gPh == "frsStat") {
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
        e bwz;
        if (this.gPe != null && (bwz = bwz()) != null && bwz.gPo != null) {
            long is = this.gPe.is();
            if (is > 3000) {
                d dVar = bwz.gPo;
                dVar.gPj = is + dVar.gPj;
                bwz.gPo.num++;
                c.a(bwz, 10);
            }
        }
    }

    private e bwz() {
        return c.k(this.gPh, getNetType(), this.ast);
    }

    private String getNetType() {
        int jK = j.jK();
        if (jK == 0) {
            return "N";
        }
        if (jK == 1) {
            return "WIFI";
        }
        if (jK == 3) {
            return "3G";
        }
        if (jK != 2) {
            return "N";
        }
        return "2G";
    }
}
