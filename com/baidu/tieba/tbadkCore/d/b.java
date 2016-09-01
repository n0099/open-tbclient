package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.lib.stats.d ftB;
    private final int ftC = 10;
    private final int ftD = 3000;
    public String ftE = null;
    public boolean acR = false;

    public b(String str) {
        S(str, false);
    }

    public void S(String str, boolean z) {
        this.ftE = str;
        this.acR = z;
        this.ftB = new com.baidu.adp.lib.stats.d("dbg");
        c.i(str, getNetType(), z);
    }

    public void start() {
        this.ftB.eY();
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        f bjy;
        if (this.ftB != null && (bjy = bjy()) != null) {
            if (z) {
                if (bjy.ftJ != null) {
                    bjy.ftJ.num++;
                    if (z2) {
                        bjy.ftJ.ftG += j2;
                        bjy.ftJ.size += j;
                    } else {
                        bjy.ftJ.ftH++;
                    }
                } else {
                    return;
                }
            } else if (bjy.ftK != null) {
                bjy.ftK.num++;
                if (z2) {
                    bjy.ftK.ftG += j3;
                    bjy.ftK.size += j;
                    j2 = j3;
                } else {
                    bjy.ftK.ftH++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.ftB = null;
            if (z2) {
                c.a(bjy, 10);
            }
            if (this.ftE == "frsStat") {
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
        f bjy;
        if (this.ftB != null && (bjy = bjy()) != null && bjy.ftL != null) {
            long eZ = this.ftB.eZ();
            if (eZ > 3000) {
                e eVar = bjy.ftL;
                eVar.ftG = eZ + eVar.ftG;
                bjy.ftL.num++;
                c.a(bjy, 10);
            }
        }
    }

    private f bjy() {
        return c.j(this.ftE, getNetType(), this.acR);
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
