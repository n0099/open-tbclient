package com.baidu.tieba.tbadkCore.e;

import com.baidu.adp.lib.util.i;
import com.baidu.location.LocationClientOption;
/* loaded from: classes.dex */
public class a {
    private com.baidu.adp.lib.stats.d cJg;
    private final int cJh = 10;
    private final int cJi = LocationClientOption.MIN_SCAN_SPAN_NETWORK;
    public String cJj = null;
    public boolean acc = false;

    public a(String str) {
        F(str, false);
    }

    public void F(String str, boolean z) {
        this.cJj = str;
        this.acc = z;
        this.cJg = new com.baidu.adp.lib.stats.d("dbg");
        b.g(str, getNetType(), z);
    }

    public void start() {
        this.cJg.hA();
    }

    public void a(boolean z, boolean z2, int i, String str, long j) {
        long hB = this.cJg.hB();
        long j2 = 0;
        long j3 = 0;
        if (z) {
            j2 = hB;
        } else {
            j3 = hB;
        }
        a(z, z2, i, str, j, j2, j3);
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e aql;
        if (this.cJg != null && (aql = aql()) != null) {
            if (z) {
                if (aql.cJo != null) {
                    aql.cJo.num++;
                    if (z2) {
                        aql.cJo.cJl += j2;
                        aql.cJo.size += j;
                    } else {
                        aql.cJo.cJm++;
                    }
                } else {
                    return;
                }
            } else if (aql.cJp != null) {
                aql.cJp.num++;
                if (z2) {
                    aql.cJp.cJl += j3;
                    aql.cJp.size += j;
                    j2 = j3;
                } else {
                    aql.cJp.cJm++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.cJg = null;
            if (z2) {
                b.a(aql, 10);
            }
            if (this.cJj == "frsStat") {
                if (!z2 || j2 > 3000) {
                    com.baidu.adp.lib.stats.d dVar = new com.baidu.adp.lib.stats.d("dbg");
                    dVar.q("act", "frs");
                    dVar.q("result", z2 ? "0" : "1");
                    dVar.q("isHttp", z ? "1" : "0");
                    dVar.q("timeCost", String.valueOf(j2));
                    dVar.q("errCode", String.valueOf(i));
                    dVar.q("errMsg", str);
                    dVar.q("down", String.valueOf(j));
                    com.baidu.adp.lib.stats.a.hk().b("frs", dVar);
                }
            }
        }
    }

    public void destory() {
        e aql;
        if (this.cJg != null && (aql = aql()) != null && aql.cJq != null) {
            long hB = this.cJg.hB();
            if (hB > 3000) {
                d dVar = aql.cJq;
                dVar.cJl = hB + dVar.cJl;
                aql.cJq.num++;
                b.a(aql, 10);
            }
        }
    }

    private e aql() {
        return b.h(this.cJj, getNetType(), this.acc);
    }

    private String getNetType() {
        int iU = i.iU();
        if (iU == 0) {
            return "N";
        }
        if (iU == 1) {
            return "WIFI";
        }
        if (iU == 3) {
            return "3G";
        }
        if (iU != 2) {
            return "N";
        }
        return "2G";
    }
}
