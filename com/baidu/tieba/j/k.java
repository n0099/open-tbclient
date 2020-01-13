package com.baidu.tieba.j;

import android.os.SystemClock;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.util.af;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes.dex */
public class k {
    private static final String TAG = k.class.getName();
    private String boc = "";
    private boolean ioA;
    private long iox;
    private long ioy;
    private long ioz;

    public void cfo() {
        this.ioA = true;
        this.iox = SystemClock.elapsedRealtime();
    }

    public void cfp() {
        this.ioy = SystemClock.elapsedRealtime();
    }

    public void cfq() {
        this.ioz = SystemClock.elapsedRealtime();
    }

    public void a(String str, long j, long j2, com.baidu.tieba.play.a.a aVar) {
        a(str, j, j2, this.boc, aVar);
    }

    public void a(String str, long j, long j2, String str2, com.baidu.tieba.play.a.a aVar) {
        if (this.ioA) {
            this.ioA = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j3 = this.ioy - this.iox;
            long j4 = elapsedRealtime - this.ioz;
            long j5 = j4 + j3;
            if (com.baidu.adp.lib.util.j.netType() == 2 || j3 <= 17500) {
                an anVar = new an("c13171");
                anVar.cp("obj_source", str2);
                anVar.s("obj_param1", j3);
                anVar.s(TiebaInitialize.Params.OBJ_PARAM2, j4);
                anVar.s(TiebaInitialize.Params.OBJ_PARAM3, j5);
                anVar.s("obj_duration", j2);
                anVar.s("resource_id", j);
                anVar.Z("ptype", com.baidu.adp.lib.util.j.netType());
                anVar.cp("tid", str);
                anVar.cp("cuid", TbadkCoreApplication.getInst().getCuid());
                anVar.Z("obj_id", af.mC(ES(str2)) ? 1 : 0);
                anVar.s(ETAG.KEY_TIME_STAMP, System.currentTimeMillis());
                TiebaStatic.log(anVar);
                if (aVar != null) {
                    aVar.a(str2, j3, j4, j5, j2, j, str, af.mC(ES(str2)) ? 1 : 0);
                }
            }
        }
    }

    private int ES(String str) {
        if ("frs".equals(str)) {
            return 2;
        }
        if ("homepage".equals(str)) {
            return 1;
        }
        if ("middle".equals(str)) {
            return 4;
        }
        if ("pb".equals(str)) {
            return 3;
        }
        return 0;
    }

    public void setPageTypeForPerfStat(String str) {
        this.boc = str;
    }
}
