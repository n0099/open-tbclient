package com.baidu.tieba.tbadkCore.e;

import com.baidu.adp.lib.util.i;
import com.baidu.location.LocationClientOption;
/* loaded from: classes.dex */
public class a {
    private com.baidu.adp.lib.stats.d cZk;
    private final int cZl = 10;
    private final int cZm = LocationClientOption.MIN_SCAN_SPAN_NETWORK;
    public String cZn = null;
    public boolean acl = false;

    public a(String str) {
        I(str, false);
    }

    public void I(String str, boolean z) {
        this.cZn = str;
        this.acl = z;
        this.cZk = new com.baidu.adp.lib.stats.d("dbg");
        b.j(str, getNetType(), z);
    }

    public void start() {
        this.cZk.hy();
    }

    public void a(boolean z, boolean z2, int i, String str, long j) {
        long hz = this.cZk.hz();
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
        e awO;
        if (this.cZk != null && (awO = awO()) != null) {
            if (z) {
                if (awO.cZs != null) {
                    awO.cZs.num++;
                    if (z2) {
                        awO.cZs.cZp += j2;
                        awO.cZs.size += j;
                    } else {
                        awO.cZs.cZq++;
                    }
                } else {
                    return;
                }
            } else if (awO.cZt != null) {
                awO.cZt.num++;
                if (z2) {
                    awO.cZt.cZp += j3;
                    awO.cZt.size += j;
                    j2 = j3;
                } else {
                    awO.cZt.cZq++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.cZk = null;
            if (z2) {
                b.a(awO, 10);
            }
            if (this.cZn == "frsStat") {
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
        e awO;
        if (this.cZk != null && (awO = awO()) != null && awO.cZu != null) {
            long hz = this.cZk.hz();
            if (hz > 3000) {
                d dVar = awO.cZu;
                dVar.cZp = hz + dVar.cZp;
                awO.cZu.num++;
                b.a(awO, 10);
            }
        }
    }

    private e awO() {
        return b.k(this.cZn, getNetType(), this.acl);
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
