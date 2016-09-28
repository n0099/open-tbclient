package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.d fwh;
    private final int fwi = 10;
    private final int fwj = 3000;
    public String fwk = null;
    public boolean adc = false;

    public b(String str) {
        S(str, false);
    }

    public void S(String str, boolean z) {
        this.fwk = str;
        this.adc = z;
        this.fwh = new com.baidu.adp.lib.stats.d("dbg");
        c.i(str, getNetType(), z);
    }

    public void start() {
        this.fwh.eY();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        f bkk;
        if (this.fwh != null && (bkk = bkk()) != null) {
            if (z) {
                if (bkk.fwp != null) {
                    bkk.fwp.num++;
                    if (z2) {
                        bkk.fwp.fwm += j2;
                        bkk.fwp.size += j;
                    } else {
                        bkk.fwp.fwn++;
                    }
                } else {
                    return;
                }
            } else if (bkk.fwq != null) {
                bkk.fwq.num++;
                if (z2) {
                    bkk.fwq.fwm += j3;
                    bkk.fwq.size += j;
                    j2 = j3;
                } else {
                    bkk.fwq.fwn++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.fwh = null;
            if (z2) {
                c.a(bkk, 10);
            }
            if (this.fwk == "frsStat") {
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
        f bkk;
        if (this.fwh != null && (bkk = bkk()) != null && bkk.fwr != null) {
            long eZ = this.fwh.eZ();
            if (eZ > 3000) {
                e eVar = bkk.fwr;
                eVar.fwm = eZ + eVar.fwm;
                bkk.fwr.num++;
                c.a(bkk, 10);
            }
        }
    }

    private f bkk() {
        return c.j(this.fwk, getNetType(), this.adc);
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
