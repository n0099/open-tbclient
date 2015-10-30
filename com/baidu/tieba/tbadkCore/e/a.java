package com.baidu.tieba.tbadkCore.e;

import com.baidu.adp.lib.util.i;
import com.baidu.location.LocationClientOption;
/* loaded from: classes.dex */
public class a {
    private com.baidu.adp.lib.stats.d cZK;
    private final int cZL = 10;
    private final int cZM = LocationClientOption.MIN_SCAN_SPAN_NETWORK;
    public String cZN = null;
    public boolean acm = false;

    public a(String str) {
        I(str, false);
    }

    public void I(String str, boolean z) {
        this.cZN = str;
        this.acm = z;
        this.cZK = new com.baidu.adp.lib.stats.d("dbg");
        b.j(str, getNetType(), z);
    }

    public void start() {
        this.cZK.hy();
    }

    public void a(boolean z, boolean z2, int i, String str, long j) {
        long hz = this.cZK.hz();
        long j2 = 0;
        long j3 = 0;
        if (z) {
            j2 = hz;
        } else {
            j3 = hz;
        }
        a(z, z2, i, str, j, j2, j3);
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e awU;
        if (this.cZK != null && (awU = awU()) != null) {
            if (z) {
                if (awU.cZS != null) {
                    awU.cZS.num++;
                    if (z2) {
                        awU.cZS.cZP += j2;
                        awU.cZS.size += j;
                    } else {
                        awU.cZS.cZQ++;
                    }
                } else {
                    return;
                }
            } else if (awU.cZT != null) {
                awU.cZT.num++;
                if (z2) {
                    awU.cZT.cZP += j3;
                    awU.cZT.size += j;
                    j2 = j3;
                } else {
                    awU.cZT.cZQ++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.cZK = null;
            if (z2) {
                b.a(awU, 10);
            }
            if (this.cZN == "frsStat") {
                if (!z2 || j2 > 3000) {
                    com.baidu.adp.lib.stats.d dVar = new com.baidu.adp.lib.stats.d("dbg");
                    dVar.q("act", "frs");
                    dVar.q("result", z2 ? "0" : "1");
                    dVar.q("isHttp", z ? "1" : "0");
                    dVar.q("timeCost", String.valueOf(j2));
                    dVar.q("errCode", String.valueOf(i));
                    dVar.q("errMsg", str);
                    dVar.q("down", String.valueOf(j));
                    com.baidu.adp.lib.stats.a.hi().b("frs", dVar);
                }
            }
        }
    }

    public void destory() {
        e awU;
        if (this.cZK != null && (awU = awU()) != null && awU.cZU != null) {
            long hz = this.cZK.hz();
            if (hz > 3000) {
                d dVar = awU.cZU;
                dVar.cZP = hz + dVar.cZP;
                awU.cZU.num++;
                b.a(awU, 10);
            }
        }
    }

    private e awU() {
        return b.k(this.cZN, getNetType(), this.acm);
    }

    private String getNetType() {
        int iS = i.iS();
        if (iS == 0) {
            return "N";
        }
        if (iS == 1) {
            return "WIFI";
        }
        if (iS == 3) {
            return "3G";
        }
        if (iS != 2) {
            return "N";
        }
        return "2G";
    }
}
