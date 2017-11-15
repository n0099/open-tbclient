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
        public String aMq;
        public String aMr;
        public int bUP;
    }

    public static C0129a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0129a c0129a = new C0129a(str, str2, str3, str4, str5);
        c0129a.e(str6, str7, str8, str9, str10);
        return c0129a;
    }

    public static C0129a d(String str, String str2, String str3, String str4, String str5, String str6) {
        C0129a c0129a = new C0129a("ad_tpoint", "PT", str, str2, "tpoint");
        c0129a.e(null, null, str3, str4, str5);
        if (!am.isEmpty(str6)) {
            c0129a.ce("obj_ref", str6);
        }
        return c0129a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0129a c0129a = new C0129a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0129a.e(str2, str7, str3, str4, str5);
        c0129a.ce("obj_url", str6);
        c0129a.save();
    }

    @Deprecated
    public static void cd(String str, String str2) {
        if (!am.isEmpty(str)) {
            ak akVar = new ak(str);
            if (str2 != null) {
                akVar = akVar.ac("obj_type", str2);
            }
            TiebaStatic.log(akVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0129a {
        private final String TL;
        private final boolean WU;
        private final ak dYL;
        private final String grn;
        private final String gro;
        private final String key;
        private final String locate;

        private C0129a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.grn = str2;
            this.TL = str3;
            this.locate = str4;
            this.gro = str5;
            this.WU = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.dYL = buW();
        }

        private ak buW() {
            ak akVar = new ak(this.key);
            if (!StringUtils.isNull(this.grn)) {
                akVar = akVar.ac("line", this.grn);
            }
            if (!StringUtils.isNull(this.TL)) {
                akVar = akVar.ac("page", this.TL);
            }
            if (!StringUtils.isNull(this.locate)) {
                akVar = akVar.ac("locate", this.locate);
            }
            if (!StringUtils.isNull(this.gro)) {
                return akVar.ac("task", this.gro);
            }
            return akVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ak e(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.dYL.ac("action_type", str);
            }
            if (!StringUtils.isNull(str2)) {
                this.dYL.ac("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.dYL.ac(ImageViewerConfig.FORUM_ID, str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.dYL.ac(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.dYL.ac("tid", str5);
            }
            this.dYL.r("obj_cpid", 0).r("obj_good_id", 0).ac("obj_throw_type", "BY_POST").ac("client_type", "MOBILE_APP").ac("user_timestamp", String.valueOf(System.currentTimeMillis())).ac("os", "android").ac("os_version", Build.VERSION.RELEASE).ac("log_ver", "1.1");
            return this.dYL;
        }

        public C0129a ce(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.dYL.ac(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.dYL);
            if (!this.WU) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void dM(String str) {
            this.dYL.dM(str);
        }
    }
}
