package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.d fDn;
    private final int fDo = 10;
    private final int fDp = 3000;
    public String fDq = null;
    public boolean adB = false;

    public b(String str) {
        S(str, false);
    }

    public void S(String str, boolean z) {
        this.fDq = str;
        this.adB = z;
        this.fDn = new com.baidu.adp.lib.stats.d("dbg");
        c.i(str, getNetType(), z);
    }

    public void start() {
        this.fDn.eY();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        f bmA;
        if (this.fDn != null && (bmA = bmA()) != null) {
            if (z) {
                if (bmA.fDv != null) {
                    bmA.fDv.num++;
                    if (z2) {
                        bmA.fDv.fDs += j2;
                        bmA.fDv.size += j;
                    } else {
                        bmA.fDv.fDt++;
                    }
                } else {
                    return;
                }
            } else if (bmA.fDw != null) {
                bmA.fDw.num++;
                if (z2) {
                    bmA.fDw.fDs += j3;
                    bmA.fDw.size += j;
                    j2 = j3;
                } else {
                    bmA.fDw.fDt++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.fDn = null;
            if (z2) {
                c.a(bmA, 10);
            }
            if (this.fDq == "frsStat") {
                if (!z2 || j2 > 3000) {
                    com.baidu.adp.lib.stats.d dVar = new com.baidu.adp.lib.stats.d("dbg");
                    dVar.q("act", "frs");
                    dVar.q("result", z2 ? "0" : "1");
                    dVar.q("isHttp", z ? "1" : "0");
                    dVar.q("timeCost", String.valueOf(j2));
                    dVar.q("errCode", String.valueOf(i));
                    dVar.q("errMsg", str);
                    dVar.q("down", String.valueOf(j));
                    com.baidu.adp.lib.stats.a.eI().b("frs", dVar);
                }
            }
        }
    }

    public void destory() {
        f bmA;
        if (this.fDn != null && (bmA = bmA()) != null && bmA.fDx != null) {
            long eZ = this.fDn.eZ();
            if (eZ > 3000) {
                e eVar = bmA.fDx;
                eVar.fDs = eZ + eVar.fDs;
                bmA.fDx.num++;
                c.a(bmA, 10);
            }
        }
    }

    private f bmA() {
        return c.j(this.fDq, getNetType(), this.adB);
    }

    private String getNetType() {
        int gs = i.gs();
        if (gs == 0) {
            return "N";
        }
        if (gs == 1) {
            return "WIFI";
        }
        if (gs == 3) {
            return "3G";
        }
        if (gs != 2) {
            return "N";
        }
        return "2G";
    }
}
