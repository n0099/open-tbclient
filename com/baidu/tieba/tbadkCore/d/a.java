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
        public String OC;
        public int fGK;
        public String mPid;
    }

    public static C0599a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0599a c0599a = new C0599a(str, str2, str3, str4, str5);
        c0599a.l(str6, str7, str8, str9, str10);
        return c0599a;
    }

    public static C0599a d(String str, String str2, String str3, String str4, String str5, String str6) {
        C0599a c0599a = new C0599a("ad_tpoint", "PT", str, str2, "tpoint");
        c0599a.l(null, null, str3, str4, str5);
        if (!aq.isEmpty(str6)) {
            c0599a.et("obj_ref", str6);
        }
        return c0599a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0599a c0599a = new C0599a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0599a.l(str2, str7, str3, str4, str5);
        c0599a.et(TiebaInitialize.Params.OBJ_URL, str6);
        c0599a.save();
    }

    @Deprecated
    public static void es(String str, String str2) {
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
    public static class C0599a {
        private final boolean cKZ;
        private final an hQH;
        private final String kdf;
        private final String kdg;
        private final String kdh;
        private final String key;
        private final String page;

        private C0599a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.kdf = str2;
            this.page = str3;
            this.kdg = str4;
            this.kdh = str5;
            this.cKZ = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.hQH = cIM();
        }

        private an cIM() {
            an anVar = new an(this.key);
            if (!StringUtils.isNull(this.kdf)) {
                anVar = anVar.cp("line", this.kdf);
            }
            if (!StringUtils.isNull(this.page)) {
                anVar = anVar.cp("page", this.page);
            }
            if (!StringUtils.isNull(this.kdg)) {
                anVar = anVar.cp("locate", this.kdg);
            }
            if (!StringUtils.isNull(this.kdh)) {
                return anVar.cp("task", this.kdh);
            }
            return anVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public an l(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.hQH.cp(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str);
            }
            if (!StringUtils.isNull(str2)) {
                this.hQH.cp("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.hQH.cp("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.hQH.cp("fname", str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.hQH.cp("tid", str5);
            }
            this.hQH.Z("obj_cpid", 0).Z("obj_good_id", 0).cp("obj_throw_type", "BY_POST").cp("client_type", "MOBILE_APP").cp("user_timestamp", String.valueOf(System.currentTimeMillis())).cp("os", PraiseDataPassUtil.KEY_FROM_OS).cp(BdStatsConstant.StatsKey.OS_VERSION, Build.VERSION.RELEASE).cp("log_ver", "1.1");
            return this.hQH;
        }

        public C0599a et(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.hQH.cp(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.hQH);
            if (!this.cKZ) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.hQH.delete(str);
        }
    }
}
