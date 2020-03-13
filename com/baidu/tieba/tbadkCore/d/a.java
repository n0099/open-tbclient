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
        public String Pj;
        public int fMG;
        public String mPid;
    }

    public static C0612a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0612a c0612a = new C0612a(str, str2, str3, str4, str5);
        c0612a.k(str6, str7, str8, str9, str10);
        return c0612a;
    }

    public static C0612a d(String str, String str2, String str3, String str4, String str5, String str6) {
        C0612a c0612a = new C0612a("ad_tpoint", "PT", str, str2, "tpoint");
        c0612a.k(null, null, str3, str4, str5);
        if (!aq.isEmpty(str6)) {
            c0612a.eE("obj_ref", str6);
        }
        return c0612a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0612a c0612a = new C0612a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0612a.k(str2, str7, str3, str4, str5);
        c0612a.eE(TiebaInitialize.Params.OBJ_URL, str6);
        c0612a.save();
    }

    @Deprecated
    public static void eD(String str, String str2) {
        if (!aq.isEmpty(str)) {
            an anVar = new an(str);
            if (str2 != null) {
                anVar = anVar.cy("obj_type", str2);
            }
            TiebaStatic.log(anVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0612a {
        private final boolean cPp;
        private final an hWx;
        private final String key;
        private final String kic;
        private final String kie;
        private final String kif;
        private final String page;

        private C0612a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.kic = str2;
            this.page = str3;
            this.kie = str4;
            this.kif = str5;
            this.cPp = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.hWx = cLt();
        }

        private an cLt() {
            an anVar = new an(this.key);
            if (!StringUtils.isNull(this.kic)) {
                anVar = anVar.cy("line", this.kic);
            }
            if (!StringUtils.isNull(this.page)) {
                anVar = anVar.cy("page", this.page);
            }
            if (!StringUtils.isNull(this.kie)) {
                anVar = anVar.cy("locate", this.kie);
            }
            if (!StringUtils.isNull(this.kif)) {
                return anVar.cy("task", this.kif);
            }
            return anVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public an k(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.hWx.cy(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str);
            }
            if (!StringUtils.isNull(str2)) {
                this.hWx.cy("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.hWx.cy("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.hWx.cy("fname", str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.hWx.cy("tid", str5);
            }
            this.hWx.X("obj_cpid", 0).X("obj_good_id", 0).cy("obj_throw_type", "BY_POST").cy("client_type", "MOBILE_APP").cy("user_timestamp", String.valueOf(System.currentTimeMillis())).cy("os", PraiseDataPassUtil.KEY_FROM_OS).cy(BdStatsConstant.StatsKey.OS_VERSION, Build.VERSION.RELEASE).cy("log_ver", "1.1");
            return this.hWx;
        }

        public C0612a eE(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.hWx.cy(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.hWx);
            if (!this.cPp) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.hWx.delete(str);
        }
    }
}
