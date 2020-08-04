package com.baidu.tieba.tbadkCore.d;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
/* loaded from: classes.dex */
public class a {

    /* loaded from: classes.dex */
    public static class b {
        public String ajJ;
        public int gZF;
        public String mPid;
    }

    public static C0755a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0755a c0755a = new C0755a(str, str2, str3, str4, str5);
        c0755a.l(str6, str7, str8, str9, str10);
        return c0755a;
    }

    public static C0755a d(String str, String str2, String str3, String str4, String str5, String str6) {
        C0755a c0755a = new C0755a("ad_tpoint", "PT", str, str2, "tpoint");
        c0755a.l(null, null, str3, str4, str5);
        if (!as.isEmpty(str6)) {
            c0755a.fB("obj_ref", str6);
        }
        return c0755a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0755a c0755a = new C0755a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0755a.l(str2, str7, str3, str4, str5);
        c0755a.fB(TiebaInitialize.Params.OBJ_URL, str6);
        c0755a.save();
    }

    @Deprecated
    public static void fA(String str, String str2) {
        if (!as.isEmpty(str)) {
            ap apVar = new ap(str);
            if (str2 != null) {
                apVar = apVar.dn("obj_type", str2);
            }
            TiebaStatic.log(apVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0755a {
        private final boolean dPr;
        private final ap jxv;
        private final String key;
        private final String lOA;
        private final String lOy;
        private final String lOz;
        private final String page;

        private C0755a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.lOy = str2;
            this.page = str3;
            this.lOz = str4;
            this.lOA = str5;
            this.dPr = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.jxv = dlz();
        }

        private ap dlz() {
            ap apVar = new ap(this.key);
            if (!StringUtils.isNull(this.lOy)) {
                apVar = apVar.dn("line", this.lOy);
            }
            if (!StringUtils.isNull(this.page)) {
                apVar = apVar.dn("page", this.page);
            }
            if (!StringUtils.isNull(this.lOz)) {
                apVar = apVar.dn("locate", this.lOz);
            }
            if (!StringUtils.isNull(this.lOA)) {
                return apVar.dn("task", this.lOA);
            }
            return apVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ap l(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.jxv.dn(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str);
            }
            if (!StringUtils.isNull(str2)) {
                this.jxv.dn("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.jxv.dn("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.jxv.dn("fname", str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.jxv.dn("tid", str5);
            }
            this.jxv.ah("obj_cpid", 0).ah("obj_good_id", 0).dn("obj_throw_type", "BY_POST").dn("client_type", "MOBILE_APP").dn("user_timestamp", String.valueOf(System.currentTimeMillis())).dn("os", "android").dn("os_version", Build.VERSION.RELEASE).dn("log_ver", "1.1");
            return this.jxv;
        }

        public C0755a fB(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.jxv.dn(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.jxv);
            if (!this.dPr) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.jxv.delete(str);
        }
    }
}
