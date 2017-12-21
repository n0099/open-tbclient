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
        public String aMX;
        public String aMY;
        public int cdB;
    }

    public static C0142a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0142a c0142a = new C0142a(str, str2, str3, str4, str5);
        c0142a.e(str6, str7, str8, str9, str10);
        return c0142a;
    }

    public static C0142a d(String str, String str2, String str3, String str4, String str5, String str6) {
        C0142a c0142a = new C0142a("ad_tpoint", "PT", str, str2, "tpoint");
        c0142a.e(null, null, str3, str4, str5);
        if (!am.isEmpty(str6)) {
            c0142a.cg("obj_ref", str6);
        }
        return c0142a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0142a c0142a = new C0142a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0142a.e(str2, str7, str3, str4, str5);
        c0142a.cg("obj_url", str6);
        c0142a.save();
    }

    @Deprecated
    public static void cf(String str, String str2) {
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
    public static class C0142a {
        private final String Uq;
        private final boolean Xk;
        private final ak efK;
        private final String gCX;
        private final String gCY;
        private final String key;
        private final String locate;

        private C0142a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.gCX = str2;
            this.Uq = str3;
            this.locate = str4;
            this.gCY = str5;
            this.Xk = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.efK = bxn();
        }

        private ak bxn() {
            ak akVar = new ak(this.key);
            if (!StringUtils.isNull(this.gCX)) {
                akVar = akVar.ac("line", this.gCX);
            }
            if (!StringUtils.isNull(this.Uq)) {
                akVar = akVar.ac("page", this.Uq);
            }
            if (!StringUtils.isNull(this.locate)) {
                akVar = akVar.ac("locate", this.locate);
            }
            if (!StringUtils.isNull(this.gCY)) {
                return akVar.ac("task", this.gCY);
            }
            return akVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ak e(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.efK.ac("action_type", str);
            }
            if (!StringUtils.isNull(str2)) {
                this.efK.ac("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.efK.ac(ImageViewerConfig.FORUM_ID, str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.efK.ac(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.efK.ac("tid", str5);
            }
            this.efK.r("obj_cpid", 0).r("obj_good_id", 0).ac("obj_throw_type", "BY_POST").ac("client_type", "MOBILE_APP").ac("user_timestamp", String.valueOf(System.currentTimeMillis())).ac("os", "android").ac("os_version", Build.VERSION.RELEASE).ac("log_ver", "1.1");
            return this.efK;
        }

        public C0142a cg(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.efK.ac(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.efK);
            if (!this.Xk) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void dO(String str) {
            this.efK.dO(str);
        }
    }
}
