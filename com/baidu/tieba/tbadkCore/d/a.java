package com.baidu.tieba.tbadkCore.d;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.searchbox.ui.animview.praise.PraiseDataPassUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class a {

    /* loaded from: classes.dex */
    public static class b {
        public String OG;
        public int fJU;
        public String mPid;
    }

    public static C0604a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0604a c0604a = new C0604a(str, str2, str3, str4, str5);
        c0604a.l(str6, str7, str8, str9, str10);
        return c0604a;
    }

    public static C0604a d(String str, String str2, String str3, String str4, String str5, String str6) {
        C0604a c0604a = new C0604a("ad_tpoint", "PT", str, str2, "tpoint");
        c0604a.l(null, null, str3, str4, str5);
        if (!aq.isEmpty(str6)) {
            c0604a.ev("obj_ref", str6);
        }
        return c0604a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0604a c0604a = new C0604a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0604a.l(str2, str7, str3, str4, str5);
        c0604a.ev(TiebaInitialize.Params.OBJ_URL, str6);
        c0604a.save();
    }

    @Deprecated
    public static void eu(String str, String str2) {
        if (!aq.isEmpty(str)) {
            an anVar = new an(str);
            if (str2 != null) {
                anVar = anVar.cp("obj_type", str2);
            }
            TiebaStatic.log(anVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0604a {
        private final boolean cLk;
        private final an hUl;
        private final String key;
        private final String kgI;
        private final String kgJ;
        private final String kgK;
        private final String page;

        private C0604a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.kgI = str2;
            this.page = str3;
            this.kgJ = str4;
            this.kgK = str5;
            this.cLk = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.hUl = cJQ();
        }

        private an cJQ() {
            an anVar = new an(this.key);
            if (!StringUtils.isNull(this.kgI)) {
                anVar = anVar.cp("line", this.kgI);
            }
            if (!StringUtils.isNull(this.page)) {
                anVar = anVar.cp("page", this.page);
            }
            if (!StringUtils.isNull(this.kgJ)) {
                anVar = anVar.cp("locate", this.kgJ);
            }
            if (!StringUtils.isNull(this.kgK)) {
                return anVar.cp("task", this.kgK);
            }
            return anVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public an l(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.hUl.cp(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str);
            }
            if (!StringUtils.isNull(str2)) {
                this.hUl.cp("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.hUl.cp("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.hUl.cp("fname", str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.hUl.cp("tid", str5);
            }
            this.hUl.Z("obj_cpid", 0).Z("obj_good_id", 0).cp("obj_throw_type", "BY_POST").cp("client_type", "MOBILE_APP").cp("user_timestamp", String.valueOf(System.currentTimeMillis())).cp("os", PraiseDataPassUtil.KEY_FROM_OS).cp(BdStatsConstant.StatsKey.OS_VERSION, Build.VERSION.RELEASE).cp("log_ver", "1.1");
            return this.hUl;
        }

        public C0604a ev(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.hUl.cp(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.hUl);
            if (!this.cLk) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.hUl.delete(str);
        }
    }
}
