package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.d fhr;
    private final int fhs = 10;
    private final int fht = 3000;
    public String fhu = null;
    public boolean acT = false;

    public b(String str) {
        V(str, false);
    }

    public void V(String str, boolean z) {
        this.fhu = str;
        this.acT = z;
        this.fhr = new com.baidu.adp.lib.stats.d("dbg");
        c.i(str, getNetType(), z);
    }

    public void start() {
        this.fhr.eY();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        f bgp;
        if (this.fhr != null && (bgp = bgp()) != null) {
            if (z) {
                if (bgp.fhz != null) {
                    bgp.fhz.num++;
                    if (z2) {
                        bgp.fhz.fhw += j2;
                        bgp.fhz.size += j;
                    } else {
                        bgp.fhz.fhx++;
                    }
                } else {
                    return;
                }
            } else if (bgp.fhA != null) {
                bgp.fhA.num++;
                if (z2) {
                    bgp.fhA.fhw += j3;
                    bgp.fhA.size += j;
                    j2 = j3;
                } else {
                    bgp.fhA.fhx++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.fhr = null;
            if (z2) {
                c.a(bgp, 10);
            }
            if (this.fhu == "frsStat") {
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
        f bgp;
        if (this.fhr != null && (bgp = bgp()) != null && bgp.fhB != null) {
            long eZ = this.fhr.eZ();
            if (eZ > 3000) {
                e eVar = bgp.fhB;
                eVar.fhw = eZ + eVar.fhw;
                bgp.fhB.num++;
                c.a(bgp, 10);
            }
        }
    }

    private f bgp() {
        return c.j(this.fhu, getNetType(), this.acT);
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
