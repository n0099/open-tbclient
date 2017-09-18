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
        public String bHy;
        public String bHz;
        public int bNG;
    }

    public static C0123a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0123a c0123a = new C0123a(str, str2, str3, str4, str5);
        c0123a.e(str6, str7, str8, str9, str10);
        return c0123a;
    }

    public static C0123a d(String str, String str2, String str3, String str4, String str5, String str6) {
        C0123a c0123a = new C0123a("ad_tpoint", "PT", str, str2, "tpoint");
        c0123a.e(null, null, str3, str4, str5);
        if (!am.isEmpty(str6)) {
            c0123a.cj("obj_ref", str6);
        }
        return c0123a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0123a c0123a = new C0123a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0123a.e(str2, str7, str3, str4, str5);
        c0123a.cj("obj_url", str6);
        c0123a.save();
    }

    @Deprecated
    public static void ci(String str, String str2) {
        if (!am.isEmpty(str)) {
            ak akVar = new ak(str);
            if (str2 != null) {
                akVar = akVar.ad("obj_type", str2);
            }
            TiebaStatic.log(akVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0123a {
        private final String Tr;
        private final boolean WN;
        private final ak dVa;
        private final String gkd;
        private final String gke;
        private final String key;
        private final String locate;

        private C0123a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.gkd = str2;
            this.Tr = str3;
            this.locate = str4;
            this.gke = str5;
            this.WN = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.dVa = bsP();
        }

        private ak bsP() {
            ak akVar = new ak(this.key);
            if (!StringUtils.isNull(this.gkd)) {
                akVar = akVar.ad("line", this.gkd);
            }
            if (!StringUtils.isNull(this.Tr)) {
                akVar = akVar.ad("page", this.Tr);
            }
            if (!StringUtils.isNull(this.locate)) {
                akVar = akVar.ad("locate", this.locate);
            }
            if (!StringUtils.isNull(this.gke)) {
                return akVar.ad("task", this.gke);
            }
            return akVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ak e(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.dVa.ad("action_type", str);
            }
            if (!StringUtils.isNull(str2)) {
                this.dVa.ad("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.dVa.ad("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.dVa.ad(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.dVa.ad("tid", str5);
            }
            this.dVa.r("obj_cpid", 0).r("obj_good_id", 0).ad("obj_throw_type", "BY_POST").ad("client_type", "MOBILE_APP").ad("user_timestamp", String.valueOf(System.currentTimeMillis())).ad("os", "android").ad("os_version", Build.VERSION.RELEASE).ad("log_ver", "1.1");
            return this.dVa;
        }

        public C0123a cj(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.dVa.ad(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.dVa);
            if (!this.WN) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void dO(String str) {
            this.dVa.dO(str);
        }
    }
}
