package com.baidu.tieba.tbadkCore.d;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.az;
/* loaded from: classes.dex */
public class a {

    /* loaded from: classes.dex */
    public static class b {
        public String aPH;
        public String bKQ;
        public int bbO;
    }

    public static C0079a a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0079a c0079a = new C0079a(str, str2, str3, str4, str5, null);
        c0079a.d(str6, str7, str8, str9, str10);
        return c0079a;
    }

    public static C0079a b(String str, String str2, String str3, String str4, String str5, String str6) {
        C0079a c0079a = new C0079a("ad_tpoint", "PT", str, str2, "tpoint", null);
        c0079a.d(null, null, str3, str4, str5);
        if (!az.isEmpty(str6)) {
            c0079a.bT("obj_ref", str6);
        }
        return c0079a;
    }

    @Deprecated
    public static void b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0079a c0079a = new C0079a("ad_tpoint", "PT", str, "c0122", "ad_plat", null);
        c0079a.d(str2, str7, str3, str4, str5);
        c0079a.bT("obj_url", str6);
        c0079a.save();
    }

    @Deprecated
    public static void bS(String str, String str2) {
        if (!az.isEmpty(str)) {
            ax axVar = new ax(str);
            if (str2 != null) {
                axVar = axVar.ab("obj_type", str2);
            }
            TiebaStatic.log(axVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0079a {
        private final boolean RH;
        private final ax dAZ;
        private final String fwe;
        private final String fwf;
        private final String fwg;
        private final String key;
        private final String locate;

        private C0079a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.fwe = str2;
            this.fwf = str3;
            this.locate = str4;
            this.fwg = str5;
            this.RH = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.dAZ = bkj();
        }

        /* synthetic */ C0079a(String str, String str2, String str3, String str4, String str5, C0079a c0079a) {
            this(str, str2, str3, str4, str5);
        }

        private ax bkj() {
            ax axVar = new ax(this.key);
            if (!StringUtils.isNull(this.fwe)) {
                axVar = axVar.ab("line", this.fwe);
            }
            if (!StringUtils.isNull(this.fwf)) {
                axVar = axVar.ab("page", this.fwf);
            }
            if (!StringUtils.isNull(this.locate)) {
                axVar = axVar.ab("locate", this.locate);
            }
            if (!StringUtils.isNull(this.fwg)) {
                return axVar.ab("task", this.fwg);
            }
            return axVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ax d(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.dAZ.ab("action_type", str);
            }
            if (!StringUtils.isNull(str2)) {
                this.dAZ.ab("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.dAZ.ab("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.dAZ.ab(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.dAZ.ab("tid", str5);
            }
            this.dAZ.s("obj_cpid", 0).s("obj_good_id", 0).ab("obj_throw_type", "BY_POST").ab(SocialConstants.PARAM_CLIENT_TYPE, "MOBILE_APP").ab("user_timestamp", String.valueOf(System.currentTimeMillis())).ab("os", SocialConstants.ANDROID_CLIENT_TYPE).ab("os_version", Build.VERSION.RELEASE).ab("log_ver", "1.1");
            return this.dAZ;
        }

        public C0079a bT(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.dAZ.ab(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.dAZ);
            if (!this.RH) {
                if (TbadkCoreApplication.m9getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void dy(String str) {
            this.dAZ.dy(str);
        }
    }
}
