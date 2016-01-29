package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.util.i;
import com.baidu.location.LocationClientOption;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.d dXN;
    private final int dXO = 10;
    private final int dXP = LocationClientOption.MIN_SCAN_SPAN_NETWORK;
    public String dXQ = null;
    public boolean aeo = false;

    public b(String str) {
        J(str, false);
    }

    public void J(String str, boolean z) {
        this.dXQ = str;
        this.aeo = z;
        this.dXN = new com.baidu.adp.lib.stats.d("dbg");
        c.h(str, getNetType(), z);
    }

    public void start() {
        this.dXN.hJ();
    }

    public void a(boolean z, boolean z2, int i, String str, long j) {
        long hK = this.dXN.hK();
        long j2 = 0;
        long j3 = 0;
        if (z) {
            j2 = hK;
        } else {
            j3 = hK;
        }
        a(z, z2, i, str, j, j2, j3);
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        f aMN;
        if (this.dXN != null && (aMN = aMN()) != null) {
            if (z) {
                if (aMN.dXV != null) {
                    aMN.dXV.num++;
                    if (z2) {
                        aMN.dXV.dXS += j2;
                        aMN.dXV.size += j;
                    } else {
                        aMN.dXV.dXT++;
                    }
                } else {
                    return;
                }
            } else if (aMN.dXW != null) {
                aMN.dXW.num++;
                if (z2) {
                    aMN.dXW.dXS += j3;
                    aMN.dXW.size += j;
                    j2 = j3;
                } else {
                    aMN.dXW.dXT++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.dXN = null;
            if (z2) {
                c.a(aMN, 10);
            }
            if (this.dXQ == "frsStat") {
                if (!z2 || j2 > 3000) {
                    com.baidu.adp.lib.stats.d dVar = new com.baidu.adp.lib.stats.d("dbg");
                    dVar.r("act", "frs");
                    dVar.r("result", z2 ? "0" : "1");
                    dVar.r("isHttp", z ? "1" : "0");
                    dVar.r("timeCost", String.valueOf(j2));
                    dVar.r("errCode", String.valueOf(i));
                    dVar.r("errMsg", str);
                    dVar.r("down", String.valueOf(j));
                    com.baidu.adp.lib.stats.a.ht().b("frs", dVar);
                }
            }
        }
    }

    public void destory() {
        f aMN;
        if (this.dXN != null && (aMN = aMN()) != null && aMN.dXX != null) {
            long hK = this.dXN.hK();
            if (hK > 3000) {
                e eVar = aMN.dXX;
                eVar.dXS = hK + eVar.dXS;
                aMN.dXX.num++;
                c.a(aMN, 10);
            }
        }
    }

    private f aMN() {
        return c.i(this.dXQ, getNetType(), this.aeo);
    }

    private String getNetType() {
        int jf = i.jf();
        if (jf == 0) {
            return "N";
        }
        if (jf == 1) {
            return "WIFI";
        }
        if (jf == 3) {
            return "3G";
        }
        if (jf != 2) {
            return "N";
        }
        return "2G";
    }
}
