package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.util.i;
import com.baidu.location.LocationClientOption;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.d eqE;
    private final int eqF = 10;
    private final int eqG = LocationClientOption.MIN_SCAN_SPAN_NETWORK;
    public String eqH = null;
    public boolean adE = false;

    public b(String str) {
        K(str, false);
    }

    public void K(String str, boolean z) {
        this.eqH = str;
        this.adE = z;
        this.eqE = new com.baidu.adp.lib.stats.d("dbg");
        c.h(str, getNetType(), z);
    }

    public void start() {
        this.eqE.hP();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        f aTO;
        if (this.eqE != null && (aTO = aTO()) != null) {
            if (z) {
                if (aTO.eqM != null) {
                    aTO.eqM.num++;
                    if (z2) {
                        aTO.eqM.eqJ += j2;
                        aTO.eqM.size += j;
                    } else {
                        aTO.eqM.eqK++;
                    }
                } else {
                    return;
                }
            } else if (aTO.eqN != null) {
                aTO.eqN.num++;
                if (z2) {
                    aTO.eqN.eqJ += j3;
                    aTO.eqN.size += j;
                    j2 = j3;
                } else {
                    aTO.eqN.eqK++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.eqE = null;
            if (z2) {
                c.a(aTO, 10);
            }
            if (this.eqH == "frsStat") {
                if (!z2 || j2 > 3000) {
                    com.baidu.adp.lib.stats.d dVar = new com.baidu.adp.lib.stats.d("dbg");
                    dVar.r("act", "frs");
                    dVar.r("result", z2 ? "0" : "1");
                    dVar.r("isHttp", z ? "1" : "0");
                    dVar.r("timeCost", String.valueOf(j2));
                    dVar.r("errCode", String.valueOf(i));
                    dVar.r("errMsg", str);
                    dVar.r("down", String.valueOf(j));
                    com.baidu.adp.lib.stats.a.hz().b("frs", dVar);
                }
            }
        }
    }

    public void destory() {
        f aTO;
        if (this.eqE != null && (aTO = aTO()) != null && aTO.eqO != null) {
            long hQ = this.eqE.hQ();
            if (hQ > 3000) {
                e eVar = aTO.eqO;
                eVar.eqJ = hQ + eVar.eqJ;
                aTO.eqO.num++;
                c.a(aTO, 10);
            }
        }
    }

    private f aTO() {
        return c.i(this.eqH, getNetType(), this.adE);
    }

    private String getNetType() {
        int jl = i.jl();
        if (jl == 0) {
            return "N";
        }
        if (jl == 1) {
            return "WIFI";
        }
        if (jl == 3) {
            return "3G";
        }
        if (jl != 2) {
            return "N";
        }
        return "2G";
    }
}
