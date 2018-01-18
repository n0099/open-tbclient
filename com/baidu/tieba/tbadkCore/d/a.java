package com.baidu.tieba.tbadkCore.d;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes.dex */
public class a {

    /* loaded from: classes.dex */
    public static class b {
        public String bAT;
        public String bAU;
        public int cWG;
    }

    public static C0154a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0154a c0154a = new C0154a(str, str2, str3, str4, str5);
        c0154a.e(str6, str7, str8, str9, str10);
        return c0154a;
    }

    public static C0154a d(String str, String str2, String str3, String str4, String str5, String str6) {
        C0154a c0154a = new C0154a("ad_tpoint", "PT", str, str2, "tpoint");
        c0154a.e(null, null, str3, str4, str5);
        if (!am.isEmpty(str6)) {
            c0154a.cd("obj_ref", str6);
        }
        return c0154a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0154a c0154a = new C0154a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0154a.e(str2, str7, str3, str4, str5);
        c0154a.cd("obj_url", str6);
        c0154a.save();
    }

    @Deprecated
    public static void cc(String str, String str2) {
        if (!am.isEmpty(str)) {
            ak akVar = new ak(str);
            if (str2 != null) {
                akVar = akVar.ab("obj_type", str2);
            }
            TiebaStatic.log(akVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0154a {
        private final String aIM;
        private final boolean aLE;
        private final ak eTs;
        private final String gZm;
        private final String gZn;
        private final String key;
        private final String locate;

        private C0154a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.gZm = str2;
            this.aIM = str3;
            this.locate = str4;
            this.gZn = str5;
            this.aLE = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.eTs = bwa();
        }

        private ak bwa() {
            ak akVar = new ak(this.key);
            if (!StringUtils.isNull(this.gZm)) {
                akVar = akVar.ab("line", this.gZm);
            }
            if (!StringUtils.isNull(this.aIM)) {
                akVar = akVar.ab("page", this.aIM);
            }
            if (!StringUtils.isNull(this.locate)) {
                akVar = akVar.ab("locate", this.locate);
            }
            if (!StringUtils.isNull(this.gZn)) {
                return akVar.ab("task", this.gZn);
            }
            return akVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ak e(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.eTs.ab("action_type", str);
            }
            if (!StringUtils.isNull(str2)) {
                this.eTs.ab("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.eTs.ab(ImageViewerConfig.FORUM_ID, str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.eTs.ab(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.eTs.ab("tid", str5);
            }
            this.eTs.s("obj_cpid", 0).s("obj_good_id", 0).ab("obj_throw_type", "BY_POST").ab("client_type", "MOBILE_APP").ab("user_timestamp", String.valueOf(System.currentTimeMillis())).ab("os", "android").ab("os_version", Build.VERSION.RELEASE).ab("log_ver", "1.1");
            return this.eTs;
        }

        public C0154a cd(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.eTs.ab(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.eTs);
            if (!this.aLE) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void dV(String str) {
            this.eTs.dV(str);
        }
    }
}
