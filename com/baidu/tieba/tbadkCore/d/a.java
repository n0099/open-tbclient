package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.util.i;
import com.baidu.location.LocationClientOption;
/* loaded from: classes.dex */
public class a {
    private com.baidu.adp.lib.stats.d dAi;
    private final int dAj = 10;
    private final int dAk = LocationClientOption.MIN_SCAN_SPAN_NETWORK;
    public String dAl = null;
    public boolean adk = false;

    public a(String str) {
        K(str, false);
    }

    public void K(String str, boolean z) {
        this.dAl = str;
        this.adk = z;
        this.dAi = new com.baidu.adp.lib.stats.d("dbg");
        b.j(str, getNetType(), z);
    }

    public void start() {
        this.dAi.hB();
    }

    public void a(boolean z, boolean z2, int i, String str, long j) {
        long hC = this.dAi.hC();
        long j2 = 0;
        long j3 = 0;
        if (z) {
            j2 = hC;
        } else {
            j3 = hC;
        }
        a(z, z2, i, str, j, j2, j3);
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e aDv;
        if (this.dAi != null && (aDv = aDv()) != null) {
            if (z) {
                if (aDv.dAq != null) {
                    aDv.dAq.num++;
                    if (z2) {
                        aDv.dAq.dAn += j2;
                        aDv.dAq.size += j;
                    } else {
                        aDv.dAq.dAo++;
                    }
                } else {
                    return;
                }
            } else if (aDv.dAr != null) {
                aDv.dAr.num++;
                if (z2) {
                    aDv.dAr.dAn += j3;
                    aDv.dAr.size += j;
                    j2 = j3;
                } else {
                    aDv.dAr.dAo++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.dAi = null;
            if (z2) {
                b.a(aDv, 10);
            }
            if (this.dAl == "frsStat") {
                if (!z2 || j2 > 3000) {
                    com.baidu.adp.lib.stats.d dVar = new com.baidu.adp.lib.stats.d("dbg");
                    dVar.q("act", "frs");
                    dVar.q("result", z2 ? "0" : "1");
                    dVar.q("isHttp", z ? "1" : "0");
                    dVar.q("timeCost", String.valueOf(j2));
                    dVar.q("errCode", String.valueOf(i));
                    dVar.q("errMsg", str);
                    dVar.q("down", String.valueOf(j));
                    com.baidu.adp.lib.stats.a.hl().b("frs", dVar);
                }
            }
        }
    }

    public void destory() {
        e aDv;
        if (this.dAi != null && (aDv = aDv()) != null && aDv.dAs != null) {
            long hC = this.dAi.hC();
            if (hC > 3000) {
                d dVar = aDv.dAs;
                dVar.dAn = hC + dVar.dAn;
                aDv.dAs.num++;
                b.a(aDv, 10);
            }
        }
    }

    private e aDv() {
        return b.k(this.dAl, getNetType(), this.adk);
    }

    private String getNetType() {
        int iV = i.iV();
        if (iV == 0) {
            return "N";
        }
        if (iV == 1) {
            return "WIFI";
        }
        if (iV == 3) {
            return "3G";
        }
        if (iV != 2) {
            return "N";
        }
        return "2G";
    }
}
