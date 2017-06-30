package com.baidu.tieba.tbadkCore.d;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.aw;
/* loaded from: classes.dex */
public class a {

    /* loaded from: classes.dex */
    public static class b {
        public int bDR;
        public String bxL;
        public String bxN;
    }

    public static C0085a a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0085a c0085a = new C0085a(str, str2, str3, str4, str5, null);
        c0085a.e(str6, str7, str8, str9, str10);
        return c0085a;
    }

    public static C0085a d(String str, String str2, String str3, String str4, String str5, String str6) {
        C0085a c0085a = new C0085a("ad_tpoint", "PT", str, str2, "tpoint", null);
        c0085a.e(null, null, str3, str4, str5);
        if (!aw.isEmpty(str6)) {
            c0085a.cf("obj_ref", str6);
        }
        return c0085a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0085a c0085a = new C0085a("ad_tpoint", "PT", str, "c0122", "ad_plat", null);
        c0085a.e(str2, str7, str3, str4, str5);
        c0085a.cf("obj_url", str6);
        c0085a.save();
    }

    @Deprecated
    public static void ce(String str, String str2) {
        if (!aw.isEmpty(str)) {
            au auVar = new au(str);
            if (str2 != null) {
                auVar = auVar.Z("obj_type", str2);
            }
            TiebaStatic.log(auVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0085a {
        private final String Sz;
        private final boolean VP;
        private final au dBD;
        private final String fNg;
        private final String fNh;
        private final String key;
        private final String locate;

        private C0085a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.fNg = str2;
            this.Sz = str3;
            this.locate = str4;
            this.fNh = str5;
            this.VP = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.dBD = bmK();
        }

        /* synthetic */ C0085a(String str, String str2, String str3, String str4, String str5, C0085a c0085a) {
            this(str, str2, str3, str4, str5);
        }

        private au bmK() {
            au auVar = new au(this.key);
            if (!StringUtils.isNull(this.fNg)) {
                auVar = auVar.Z("line", this.fNg);
            }
            if (!StringUtils.isNull(this.Sz)) {
                auVar = auVar.Z("page", this.Sz);
            }
            if (!StringUtils.isNull(this.locate)) {
                auVar = auVar.Z("locate", this.locate);
            }
            if (!StringUtils.isNull(this.fNh)) {
                return auVar.Z("task", this.fNh);
            }
            return auVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public au e(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.dBD.Z("action_type", str);
            }
            if (!StringUtils.isNull(str2)) {
                this.dBD.Z("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.dBD.Z("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.dBD.Z(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.dBD.Z("tid", str5);
            }
            this.dBD.r("obj_cpid", 0).r("obj_good_id", 0).Z("obj_throw_type", "BY_POST").Z("client_type", "MOBILE_APP").Z("user_timestamp", String.valueOf(System.currentTimeMillis())).Z("os", "android").Z("os_version", Build.VERSION.RELEASE).Z("log_ver", "1.1");
            return this.dBD;
        }

        public C0085a cf(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.dBD.Z(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.dBD);
            if (!this.VP) {
                if (TbadkCoreApplication.m9getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.dBD.delete(str);
        }
    }
}
