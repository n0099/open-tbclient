package com.baidu.tieba.tbadkCore.d;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
/* loaded from: classes.dex */
public class a {
    public static C0083a a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0083a c0083a = new C0083a(str, str2, str3, str4, str5, null);
        c0083a.c(str6, str7, str8, str9, str10);
        return c0083a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        aw awVar = new aw("ad_tpoint");
        if (str != null) {
            awVar = awVar.ac("page", str);
        }
        if (str2 != null) {
            awVar = awVar.ac("loc_param", str2);
        }
        if (str3 != null) {
            awVar = awVar.ac("action_type", str3);
        }
        if (str4 != null) {
            awVar = awVar.ac("fid", str4);
        }
        if (str5 != null) {
            awVar = awVar.ac(ImageViewerConfig.FORUM_NAME, str5);
        }
        if (str6 != null) {
            awVar = awVar.ac("tid", str6);
        }
        if (str8 != null) {
            awVar = awVar.ac("obj_url", str8);
        }
        if (str9 != null) {
            awVar = awVar.ac("obj_id", str9);
        }
        aw ac = awVar.ac("task", "ad_plat").ac("line", "PT").ac("locate", "c0122").r("obj_cpid", 0).r("obj_good_id", 0).ac("obj_throw_type", "BY_POST").ac(SocialConstants.PARAM_CLIENT_TYPE, "MOBILE_APP").ac("user_timestamp", String.valueOf(System.currentTimeMillis())).ac("os", SocialConstants.ANDROID_CLIENT_TYPE).ac("os_version", Build.VERSION.RELEASE).ac("log_ver", "1.1");
        if (str7 != null) {
            ac = ac.ac("link", str7);
        }
        TiebaStatic.log(ac);
    }

    @Deprecated
    public static void bE(String str, String str2) {
        if (!ay.isEmpty(str)) {
            aw awVar = new aw(str);
            if (str2 != null) {
                awVar = awVar.ac("obj_type", str2);
            }
            TiebaStatic.log(awVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0083a {
        private final String eqA;
        private final String eqB;
        private final boolean eqC;
        private final aw eqD;
        private final String eqz;
        private final String key;
        private final String locate;

        private C0083a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.eqz = str2;
            this.eqA = str3;
            this.locate = str4;
            this.eqB = str5;
            this.eqC = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.eqD = aTN();
        }

        /* synthetic */ C0083a(String str, String str2, String str3, String str4, String str5, C0083a c0083a) {
            this(str, str2, str3, str4, str5);
        }

        private aw aTN() {
            aw awVar = new aw(this.key);
            if (!StringUtils.isNull(this.eqz)) {
                awVar = awVar.ac("line", this.eqz);
            }
            if (!StringUtils.isNull(this.eqA)) {
                awVar = awVar.ac("page", this.eqA);
            }
            if (!StringUtils.isNull(this.locate)) {
                awVar = awVar.ac("locate", this.locate);
            }
            if (!StringUtils.isNull(this.eqB)) {
                return awVar.ac("task", this.eqB);
            }
            return awVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public aw c(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.eqD.ac("action_type", str);
            }
            if (!StringUtils.isNull(str2)) {
                this.eqD.ac("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.eqD.ac("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.eqD.ac(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.eqD.ac("tid", str5);
            }
            this.eqD.ac("uid", TbadkCoreApplication.getCurrentAccount()).ac("uname", TbadkCoreApplication.getCurrentAccountName()).r("obj_cpid", 0).r("obj_good_id", 0).ac("obj_throw_type", "BY_POST").ac(SocialConstants.PARAM_CLIENT_TYPE, "MOBILE_APP").ac("user_timestamp", String.valueOf(System.currentTimeMillis())).ac("os", SocialConstants.ANDROID_CLIENT_TYPE).ac("os_version", Build.VERSION.RELEASE).ac("log_ver", "1.1");
            return this.eqD;
        }

        public C0083a bF(String str, String str2) {
            this.eqD.ac(str, str2);
            return this;
        }

        public void save() {
            TiebaStatic.log(this.eqD);
            if (!this.eqC) {
                if (TbadkCoreApplication.m411getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }
    }
}
