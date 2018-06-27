package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.a gOg;
    private final int gOh = 10;
    private final int gOi = 3000;
    public String gOj = null;
    public boolean asQ = false;

    public b(String str) {
        V(str, false);
    }

    public void V(String str, boolean z) {
        this.gOj = str;
        this.asQ = z;
        this.gOg = new com.baidu.adp.lib.stats.a("dbg");
        c.k(str, getNetType(), z);
    }

    public void start() {
        this.gOg.iq();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e bxW;
        if (this.gOg != null && (bxW = bxW()) != null) {
            if (z) {
                if (bxW.gOo != null) {
                    bxW.gOo.num++;
                    if (z2) {
                        bxW.gOo.gOl += j2;
                        bxW.gOo.size += j;
                    } else {
                        bxW.gOo.gOm++;
                    }
                } else {
                    return;
                }
            } else if (bxW.gOp != null) {
                bxW.gOp.num++;
                if (z2) {
                    bxW.gOp.gOl += j3;
                    bxW.gOp.size += j;
                    j2 = j3;
                } else {
                    bxW.gOp.gOm++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.gOg = null;
            if (z2) {
                c.a(bxW, 10);
            }
            if (this.gOj == "frsStat") {
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
        e bxW;
        if (this.gOg != null && (bxW = bxW()) != null && bxW.gOq != null) {
            long ir = this.gOg.ir();
            if (ir > 3000) {
                d dVar = bxW.gOq;
                dVar.gOl = ir + dVar.gOl;
                bxW.gOq.num++;
                c.a(bxW, 10);
            }
        }
    }

    private e bxW() {
        return c.l(this.gOj, getNetType(), this.asQ);
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
