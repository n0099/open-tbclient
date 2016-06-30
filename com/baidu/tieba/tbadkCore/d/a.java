package com.baidu.tieba.tbadkCore.d;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes.dex */
public class a {
    public static C0077a a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0077a c0077a = new C0077a(str, str2, str3, str4, str5, null);
        c0077a.d(str6, str7, str8, str9, str10);
        return c0077a;
    }

    public static C0077a a(String str, String str2, String str3, String str4, String str5, String str6) {
        C0077a c0077a = new C0077a("ad_tpoint", "PT", str, str2, "tpoint", null);
        c0077a.d(null, null, str3, str4, str5);
        if (!ba.isEmpty(str6)) {
            c0077a.bM("obj_ref", str6);
        }
        return c0077a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0077a c0077a = new C0077a("ad_tpoint", "PT", str, "c0122", "ad_plat", null);
        c0077a.d(str2, str7, str3, str4, str5);
        c0077a.bM("obj_url", str6);
        c0077a.save();
    }

    @Deprecated
    public static void bL(String str, String str2) {
        if (!ba.isEmpty(str)) {
            ay ayVar = new ay(str);
            if (str2 != null) {
                ayVar = ayVar.ab("obj_type", str2);
            }
            TiebaStatic.log(ayVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0077a {
        private final boolean OC;
        private final ay dla;
        private final String eYB;
        private final String eYC;
        private final String eYD;
        private final String key;
        private final String locate;

        private C0077a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.eYB = str2;
            this.eYC = str3;
            this.locate = str4;
            this.eYD = str5;
            this.OC = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.dla = bcH();
        }

        /* synthetic */ C0077a(String str, String str2, String str3, String str4, String str5, C0077a c0077a) {
            this(str, str2, str3, str4, str5);
        }

        private ay bcH() {
            ay ayVar = new ay(this.key);
            if (!StringUtils.isNull(this.eYB)) {
                ayVar = ayVar.ab("line", this.eYB);
            }
            if (!StringUtils.isNull(this.eYC)) {
                ayVar = ayVar.ab("page", this.eYC);
            }
            if (!StringUtils.isNull(this.locate)) {
                ayVar = ayVar.ab("locate", this.locate);
            }
            if (!StringUtils.isNull(this.eYD)) {
                return ayVar.ab("task", this.eYD);
            }
            return ayVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ay d(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.dla.ab("action_type", str);
            }
            if (!StringUtils.isNull(str2)) {
                this.dla.ab("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.dla.ab("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.dla.ab(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.dla.ab("tid", str5);
            }
            this.dla.s("obj_cpid", 0).s("obj_good_id", 0).ab("obj_throw_type", "BY_POST").ab(SocialConstants.PARAM_CLIENT_TYPE, "MOBILE_APP").ab("user_timestamp", String.valueOf(System.currentTimeMillis())).ab("os", SocialConstants.ANDROID_CLIENT_TYPE).ab("os_version", Build.VERSION.RELEASE).ab("log_ver", "1.1");
            return this.dla;
        }

        public C0077a bM(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.dla.ab(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.dla);
            if (!this.OC) {
                if (TbadkCoreApplication.m9getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void du(String str) {
            this.dla.du(str);
        }
    }
}
