package com.baidu.tieba.tbadkCore.d;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.av;
/* loaded from: classes.dex */
public class a {

    /* loaded from: classes.dex */
    public static class b {
        public String aRf;
        public String bae;
        public int bed;
    }

    public static C0074a a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0074a c0074a = new C0074a(str, str2, str3, str4, str5, null);
        c0074a.d(str6, str7, str8, str9, str10);
        return c0074a;
    }

    public static C0074a b(String str, String str2, String str3, String str4, String str5, String str6) {
        C0074a c0074a = new C0074a("ad_tpoint", "PT", str, str2, "tpoint", null);
        c0074a.d(null, null, str3, str4, str5);
        if (!av.isEmpty(str6)) {
            c0074a.bY("obj_ref", str6);
        }
        return c0074a;
    }

    @Deprecated
    public static void b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0074a c0074a = new C0074a("ad_tpoint", "PT", str, "c0122", "ad_plat", null);
        c0074a.d(str2, str7, str3, str4, str5);
        c0074a.bY("obj_url", str6);
        c0074a.save();
    }

    @Deprecated
    public static void bX(String str, String str2) {
        if (!av.isEmpty(str)) {
            at atVar = new at(str);
            if (str2 != null) {
                atVar = atVar.ab("obj_type", str2);
            }
            TiebaStatic.log(atVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0074a {
        private final String OO;
        private final boolean RZ;
        private final at djF;
        private final String fhp;
        private final String fhq;
        private final String key;
        private final String locate;

        private C0074a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.fhp = str2;
            this.OO = str3;
            this.locate = str4;
            this.fhq = str5;
            this.RZ = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.djF = bgo();
        }

        /* synthetic */ C0074a(String str, String str2, String str3, String str4, String str5, C0074a c0074a) {
            this(str, str2, str3, str4, str5);
        }

        private at bgo() {
            at atVar = new at(this.key);
            if (!StringUtils.isNull(this.fhp)) {
                atVar = atVar.ab("line", this.fhp);
            }
            if (!StringUtils.isNull(this.OO)) {
                atVar = atVar.ab("page", this.OO);
            }
            if (!StringUtils.isNull(this.locate)) {
                atVar = atVar.ab("locate", this.locate);
            }
            if (!StringUtils.isNull(this.fhq)) {
                return atVar.ab("task", this.fhq);
            }
            return atVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public at d(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.djF.ab("action_type", str);
            }
            if (!StringUtils.isNull(str2)) {
                this.djF.ab("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.djF.ab("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.djF.ab(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.djF.ab("tid", str5);
            }
            this.djF.s("obj_cpid", 0).s("obj_good_id", 0).ab("obj_throw_type", "BY_POST").ab(SocialConstants.PARAM_CLIENT_TYPE, "MOBILE_APP").ab("user_timestamp", String.valueOf(System.currentTimeMillis())).ab("os", SocialConstants.ANDROID_CLIENT_TYPE).ab("os_version", Build.VERSION.RELEASE).ab("log_ver", "1.1");
            return this.djF;
        }

        public C0074a bY(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.djF.ab(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.djF);
            if (!this.RZ) {
                if (TbadkCoreApplication.m9getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void dx(String str) {
            this.djF.dx(str);
        }
    }
}
