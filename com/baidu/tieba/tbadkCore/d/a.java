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
    public static C0076a a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0076a c0076a = new C0076a(str, str2, str3, str4, str5, null);
        c0076a.d(str6, str7, str8, str9, str10);
        return c0076a;
    }

    public static C0076a b(String str, String str2, String str3, String str4, String str5, String str6) {
        C0076a c0076a = new C0076a("ad_tpoint", "PT", str, str2, "tpoint", null);
        c0076a.d(null, null, str3, str4, str5);
        if (!ba.isEmpty(str6)) {
            c0076a.bR("obj_ref", str6);
        }
        return c0076a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0076a c0076a = new C0076a("ad_tpoint", "PT", str, "c0122", "ad_plat", null);
        c0076a.d(str2, str7, str3, str4, str5);
        c0076a.bR("obj_url", str6);
        c0076a.save();
    }

    @Deprecated
    public static void bQ(String str, String str2) {
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
    public static class C0076a {
        private final boolean OQ;
        private final ay doa;
        private final String flE;
        private final String flF;
        private final String flG;
        private final String key;
        private final String locate;

        private C0076a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.flE = str2;
            this.flF = str3;
            this.locate = str4;
            this.flG = str5;
            this.OQ = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.doa = bfW();
        }

        /* synthetic */ C0076a(String str, String str2, String str3, String str4, String str5, C0076a c0076a) {
            this(str, str2, str3, str4, str5);
        }

        private ay bfW() {
            ay ayVar = new ay(this.key);
            if (!StringUtils.isNull(this.flE)) {
                ayVar = ayVar.ab("line", this.flE);
            }
            if (!StringUtils.isNull(this.flF)) {
                ayVar = ayVar.ab("page", this.flF);
            }
            if (!StringUtils.isNull(this.locate)) {
                ayVar = ayVar.ab("locate", this.locate);
            }
            if (!StringUtils.isNull(this.flG)) {
                return ayVar.ab("task", this.flG);
            }
            return ayVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ay d(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.doa.ab("action_type", str);
            }
            if (!StringUtils.isNull(str2)) {
                this.doa.ab("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.doa.ab("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.doa.ab(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.doa.ab("tid", str5);
            }
            this.doa.s("obj_cpid", 0).s("obj_good_id", 0).ab("obj_throw_type", "BY_POST").ab(SocialConstants.PARAM_CLIENT_TYPE, "MOBILE_APP").ab("user_timestamp", String.valueOf(System.currentTimeMillis())).ab("os", SocialConstants.ANDROID_CLIENT_TYPE).ab("os_version", Build.VERSION.RELEASE).ab("log_ver", "1.1");
            return this.doa;
        }

        public C0076a bR(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.doa.ab(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.doa);
            if (!this.OQ) {
                if (TbadkCoreApplication.m10getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void dt(String str) {
            this.doa.dt(str);
        }
    }
}
