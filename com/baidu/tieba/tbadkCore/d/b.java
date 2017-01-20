package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.d fqF;
    private final int fqG = 10;
    private final int fqH = 3000;
    public String fqI = null;
    public boolean acf = false;

    public b(String str) {
        V(str, false);
    }

    public void V(String str, boolean z) {
        this.fqI = str;
        this.acf = z;
        this.fqF = new com.baidu.adp.lib.stats.d("dbg");
        c.j(str, getNetType(), z);
    }

    public void start() {
        this.fqF.eW();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        f bie;
        if (this.fqF != null && (bie = bie()) != null) {
            if (z) {
                if (bie.fqN != null) {
                    bie.fqN.num++;
                    if (z2) {
                        bie.fqN.fqK += j2;
                        bie.fqN.size += j;
                    } else {
                        bie.fqN.fqL++;
                    }
                } else {
                    return;
                }
            } else if (bie.fqO != null) {
                bie.fqO.num++;
                if (z2) {
                    bie.fqO.fqK += j3;
                    bie.fqO.size += j;
                    j2 = j3;
                } else {
                    bie.fqO.fqL++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.fqF = null;
            if (z2) {
                c.a(bie, 10);
            }
            if (this.fqI == "frsStat") {
                if (!z2 || j2 > 3000) {
                    com.baidu.adp.lib.stats.d dVar = new com.baidu.adp.lib.stats.d("dbg");
                    dVar.q("act", "frs");
                    dVar.q("result", z2 ? "0" : "1");
                    dVar.q("isHttp", z ? "1" : "0");
                    dVar.q("timeCost", String.valueOf(j2));
                    dVar.q("errCode", String.valueOf(i));
                    dVar.q("errMsg", str);
                    dVar.q("down", String.valueOf(j));
                    com.baidu.adp.lib.stats.a.eG().b("frs", dVar);
                }
            }
        }
    }

    public void destory() {
        f bie;
        if (this.fqF != null && (bie = bie()) != null && bie.fqP != null) {
            long eX = this.fqF.eX();
            if (eX > 3000) {
                e eVar = bie.fqP;
                eVar.fqK = eX + eVar.fqK;
                bie.fqP.num++;
                c.a(bie, 10);
            }
        }
    }

    private f bie() {
        return c.k(this.fqI, getNetType(), this.acf);
    }

    private String getNetType() {
        int gq = i.gq();
        if (gq == 0) {
            return "N";
        }
        if (gq == 1) {
            return "WIFI";
        }
        if (gq == 3) {
            return "3G";
        }
        if (gq != 2) {
            return "N";
        }
        return "2G";
    }
}
