package com.baidu.tieba.tbadkCore.d;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
/* loaded from: classes.dex */
public class a {

    /* loaded from: classes.dex */
    public static class b {
        public String alZ;
        public int ibH;
        public String mPid;
    }

    public static C0855a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0855a c0855a = new C0855a(str, str2, str3, str4, str5);
        c0855a.m(str6, str7, str8, str9, str10);
        return c0855a;
    }

    public static C0855a g(String str, String str2, String str3, String str4, String str5, String str6) {
        C0855a c0855a = new C0855a("ad_tpoint", "PT", str, str2, "tpoint");
        c0855a.m(null, null, str3, str4, str5);
        if (!au.isEmpty(str6)) {
            c0855a.gr("obj_ref", str6);
        }
        return c0855a;
    }

    @Deprecated
    public static void c(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0855a c0855a = new C0855a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0855a.m(str2, str7, str3, str4, str5);
        c0855a.gr(TiebaInitialize.Params.OBJ_URL, str6);
        c0855a.save();
    }

    @Deprecated
    public static void gq(String str, String str2) {
        if (!au.isEmpty(str)) {
            ar arVar = new ar(str);
            if (str2 != null) {
                arVar = arVar.dR("obj_type", str2);
            }
            TiebaStatic.log(arVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0855a {
        private final boolean ezK;
        private final ar kDw;
        private final String key;
        private final String mZf;
        private final String mZg;
        private final String mZh;
        private final String page;

        private C0855a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.mZf = str2;
            this.page = str3;
            this.mZg = str4;
            this.mZh = str5;
            this.ezK = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.kDw = dKh();
        }

        private ar dKh() {
            ar arVar = new ar(this.key);
            if (!StringUtils.isNull(this.mZf)) {
                arVar = arVar.dR("line", this.mZf);
            }
            if (!StringUtils.isNull(this.page)) {
                arVar = arVar.dR("page", this.page);
            }
            if (!StringUtils.isNull(this.mZg)) {
                arVar = arVar.dR("locate", this.mZg);
            }
            if (!StringUtils.isNull(this.mZh)) {
                return arVar.dR("task", this.mZh);
            }
            return arVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ar m(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.kDw.dR(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str);
            }
            if (!StringUtils.isNull(str2)) {
                this.kDw.dR("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.kDw.dR("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.kDw.dR("fname", str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.kDw.dR("tid", str5);
            }
            this.kDw.ak("obj_cpid", 0).ak("obj_good_id", 0).dR("obj_throw_type", "BY_POST").dR("client_type", "MOBILE_APP").dR("user_timestamp", String.valueOf(System.currentTimeMillis())).dR("os", "android").dR("os_version", Build.VERSION.RELEASE).dR("log_ver", "1.1");
            return this.kDw;
        }

        public C0855a gr(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.kDw.dR(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.kDw);
            if (!this.ezK) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.kDw.delete(str);
        }
    }
}
