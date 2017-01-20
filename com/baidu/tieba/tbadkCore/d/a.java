package com.baidu.tieba.tbadkCore.d;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.at;
/* loaded from: classes.dex */
public class a {

    /* loaded from: classes.dex */
    public static class b {
        public String bjS;
        public String bjU;
        public int bnY;
    }

    public static C0076a a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0076a c0076a = new C0076a(str, str2, str3, str4, str5, null);
        c0076a.d(str6, str7, str8, str9, str10);
        return c0076a;
    }

    public static C0076a d(String str, String str2, String str3, String str4, String str5, String str6) {
        C0076a c0076a = new C0076a("ad_tpoint", "PT", str, str2, "tpoint", null);
        c0076a.d(null, null, str3, str4, str5);
        if (!at.isEmpty(str6)) {
            c0076a.ch("obj_ref", str6);
        }
        return c0076a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0076a c0076a = new C0076a("ad_tpoint", "PT", str, "c0122", "ad_plat", null);
        c0076a.d(str2, str7, str3, str4, str5);
        c0076a.ch("obj_url", str6);
        c0076a.save();
    }

    @Deprecated
    public static void cg(String str, String str2) {
        if (!at.isEmpty(str)) {
            ar arVar = new ar(str);
            if (str2 != null) {
                arVar = arVar.ab("obj_type", str2);
            }
            TiebaStatic.log(arVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0076a {
        private final String Oa;
        private final boolean Ri;
        private final ar dqQ;
        private final String fqD;
        private final String fqE;
        private final String key;
        private final String locate;

        private C0076a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.fqD = str2;
            this.Oa = str3;
            this.locate = str4;
            this.fqE = str5;
            this.Ri = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.dqQ = bid();
        }

        /* synthetic */ C0076a(String str, String str2, String str3, String str4, String str5, C0076a c0076a) {
            this(str, str2, str3, str4, str5);
        }

        private ar bid() {
            ar arVar = new ar(this.key);
            if (!StringUtils.isNull(this.fqD)) {
                arVar = arVar.ab("line", this.fqD);
            }
            if (!StringUtils.isNull(this.Oa)) {
                arVar = arVar.ab("page", this.Oa);
            }
            if (!StringUtils.isNull(this.locate)) {
                arVar = arVar.ab("locate", this.locate);
            }
            if (!StringUtils.isNull(this.fqE)) {
                return arVar.ab("task", this.fqE);
            }
            return arVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ar d(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.dqQ.ab("action_type", str);
            }
            if (!StringUtils.isNull(str2)) {
                this.dqQ.ab("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.dqQ.ab("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.dqQ.ab(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.dqQ.ab("tid", str5);
            }
            this.dqQ.s("obj_cpid", 0).s("obj_good_id", 0).ab("obj_throw_type", "BY_POST").ab(SocialConstants.PARAM_CLIENT_TYPE, "MOBILE_APP").ab("user_timestamp", String.valueOf(System.currentTimeMillis())).ab("os", SocialConstants.ANDROID_CLIENT_TYPE).ab("os_version", Build.VERSION.RELEASE).ab("log_ver", "1.1");
            return this.dqQ;
        }

        public C0076a ch(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.dqQ.ab(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.dqQ);
            if (!this.Ri) {
                if (TbadkCoreApplication.m9getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void dv(String str) {
            this.dqQ.dv(str);
        }
    }
}
