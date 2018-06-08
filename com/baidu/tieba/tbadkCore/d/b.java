package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a gKf;
    private final int gKg = 10;
    private final int gKh = 3000;
    public String gKi = null;
    public boolean asn = false;

    public b(String str) {
        U(str, false);
    }

    public void U(String str, boolean z) {
        this.gKi = str;
        this.asn = z;
        this.gKf = new com.baidu.adp.lib.stats.a("dbg");
        c.k(str, getNetType(), z);
    }

    public void start() {
        this.gKf.iq();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e bxt;
        if (this.gKf != null && (bxt = bxt()) != null) {
            if (z) {
                if (bxt.gKn != null) {
                    bxt.gKn.num++;
                    if (z2) {
                        bxt.gKn.gKk += j2;
                        bxt.gKn.size += j;
                    } else {
                        bxt.gKn.gKl++;
                    }
                } else {
                    return;
                }
            } else if (bxt.gKo != null) {
                bxt.gKo.num++;
                if (z2) {
                    bxt.gKo.gKk += j3;
                    bxt.gKo.size += j;
                    j2 = j3;
                } else {
                    bxt.gKo.gKl++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.gKf = null;
            if (z2) {
                c.a(bxt, 10);
            }
            if (this.gKi == "frsStat") {
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
        e bxt;
        if (this.gKf != null && (bxt = bxt()) != null && bxt.gKp != null) {
            long ir = this.gKf.ir();
            if (ir > 3000) {
                d dVar = bxt.gKp;
                dVar.gKk = ir + dVar.gKk;
                bxt.gKp.num++;
                c.a(bxt, 10);
            }
        }
    }

    private e bxt() {
        return c.l(this.gKi, getNetType(), this.asn);
    }

    private String getNetType() {
        int jJ = j.jJ();
        if (jJ == 0) {
            return "N";
        }
        if (jJ == 1) {
            return "WIFI";
        }
        if (jJ == 3) {
            return "3G";
        }
        if (jJ != 2) {
            return "N";
        }
        return "2G";
    }
}
