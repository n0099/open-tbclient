package com.baidu.tieba.tbadkCore.d;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
/* loaded from: classes.dex */
public class a {

    /* loaded from: classes.dex */
    public static class b {
        public String aRO;
        public String bNJ;
        public int beM;
    }

    public static C0080a a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0080a c0080a = new C0080a(str, str2, str3, str4, str5, null);
        c0080a.d(str6, str7, str8, str9, str10);
        return c0080a;
    }

    public static C0080a b(String str, String str2, String str3, String str4, String str5, String str6) {
        C0080a c0080a = new C0080a("ad_tpoint", "PT", str, str2, "tpoint", null);
        c0080a.d(null, null, str3, str4, str5);
        if (!ax.isEmpty(str6)) {
            c0080a.bV("obj_ref", str6);
        }
        return c0080a;
    }

    @Deprecated
    public static void b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0080a c0080a = new C0080a("ad_tpoint", "PT", str, "c0122", "ad_plat", null);
        c0080a.d(str2, str7, str3, str4, str5);
        c0080a.bV("obj_url", str6);
        c0080a.save();
    }

    @Deprecated
    public static void bU(String str, String str2) {
        if (!ax.isEmpty(str)) {
            av avVar = new av(str);
            if (str2 != null) {
                avVar = avVar.ab("obj_type", str2);
            }
            TiebaStatic.log(avVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0080a {
        private final String OS;
        private final boolean Se;
        private final av dGE;
        private final String fDl;
        private final String fDm;
        private final String key;
        private final String locate;

        private C0080a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.fDl = str2;
            this.OS = str3;
            this.locate = str4;
            this.fDm = str5;
            this.Se = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.dGE = bmz();
        }

        /* synthetic */ C0080a(String str, String str2, String str3, String str4, String str5, C0080a c0080a) {
            this(str, str2, str3, str4, str5);
        }

        private av bmz() {
            av avVar = new av(this.key);
            if (!StringUtils.isNull(this.fDl)) {
                avVar = avVar.ab("line", this.fDl);
            }
            if (!StringUtils.isNull(this.OS)) {
                avVar = avVar.ab("page", this.OS);
            }
            if (!StringUtils.isNull(this.locate)) {
                avVar = avVar.ab("locate", this.locate);
            }
            if (!StringUtils.isNull(this.fDm)) {
                return avVar.ab("task", this.fDm);
            }
            return avVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public av d(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.dGE.ab("action_type", str);
            }
            if (!StringUtils.isNull(str2)) {
                this.dGE.ab("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.dGE.ab("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.dGE.ab(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.dGE.ab("tid", str5);
            }
            this.dGE.s("obj_cpid", 0).s("obj_good_id", 0).ab("obj_throw_type", "BY_POST").ab(SocialConstants.PARAM_CLIENT_TYPE, "MOBILE_APP").ab("user_timestamp", String.valueOf(System.currentTimeMillis())).ab("os", SocialConstants.ANDROID_CLIENT_TYPE).ab("os_version", Build.VERSION.RELEASE).ab("log_ver", "1.1");
            return this.dGE;
        }

        public C0080a bV(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.dGE.ab(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.dGE);
            if (!this.Se) {
                if (TbadkCoreApplication.m9getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void dA(String str) {
            this.dGE.dA(str);
        }
    }
}
