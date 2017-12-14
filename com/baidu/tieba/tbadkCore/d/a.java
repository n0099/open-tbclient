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
        public String aMU;
        public String aMV;
        public int cdx;
    }

    public static C0143a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0143a c0143a = new C0143a(str, str2, str3, str4, str5);
        c0143a.e(str6, str7, str8, str9, str10);
        return c0143a;
    }

    public static C0143a d(String str, String str2, String str3, String str4, String str5, String str6) {
        C0143a c0143a = new C0143a("ad_tpoint", "PT", str, str2, "tpoint");
        c0143a.e(null, null, str3, str4, str5);
        if (!am.isEmpty(str6)) {
            c0143a.cg("obj_ref", str6);
        }
        return c0143a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0143a c0143a = new C0143a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0143a.e(str2, str7, str3, str4, str5);
        c0143a.cg("obj_url", str6);
        c0143a.save();
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
    public static class C0143a {
        private final String Un;
        private final boolean Xh;
        private final ak efG;
        private final String gCS;
        private final String gCT;
        private final String key;
        private final String locate;

        private C0143a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.gCS = str2;
            this.Un = str3;
            this.locate = str4;
            this.gCT = str5;
            this.Xh = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.efG = bxn();
        }

        private ak bxn() {
            ak akVar = new ak(this.key);
            if (!StringUtils.isNull(this.gCS)) {
                akVar = akVar.ac("line", this.gCS);
            }
            if (!StringUtils.isNull(this.Un)) {
                akVar = akVar.ac("page", this.Un);
            }
            if (!StringUtils.isNull(this.locate)) {
                akVar = akVar.ac("locate", this.locate);
            }
            if (!StringUtils.isNull(this.gCT)) {
                return akVar.ac("task", this.gCT);
            }
            return akVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ak e(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.efG.ac("action_type", str);
            }
            if (!StringUtils.isNull(str2)) {
                this.efG.ac("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.efG.ac(ImageViewerConfig.FORUM_ID, str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.efG.ac(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.efG.ac("tid", str5);
            }
            this.efG.r("obj_cpid", 0).r("obj_good_id", 0).ac("obj_throw_type", "BY_POST").ac("client_type", "MOBILE_APP").ac("user_timestamp", String.valueOf(System.currentTimeMillis())).ac("os", "android").ac("os_version", Build.VERSION.RELEASE).ac("log_ver", "1.1");
            return this.efG;
        }

        public C0143a cg(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.efG.ac(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.efG);
            if (!this.Xh) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void dO(String str) {
            this.efG.dO(str);
        }
    }
}
