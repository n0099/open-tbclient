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
        public String bAK;
        public String bAL;
        public int cSe;
    }

    public static C0155a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0155a c0155a = new C0155a(str, str2, str3, str4, str5);
        c0155a.e(str6, str7, str8, str9, str10);
        return c0155a;
    }

    public static C0155a d(String str, String str2, String str3, String str4, String str5, String str6) {
        C0155a c0155a = new C0155a("ad_tpoint", "PT", str, str2, "tpoint");
        c0155a.e(null, null, str3, str4, str5);
        if (!am.isEmpty(str6)) {
            c0155a.ch("obj_ref", str6);
        }
        return c0155a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0155a c0155a = new C0155a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0155a.e(str2, str7, str3, str4, str5);
        c0155a.ch("obj_url", str6);
        c0155a.save();
    }

    @Deprecated
    public static void cg(String str, String str2) {
        if (!am.isEmpty(str)) {
            ak akVar = new ak(str);
            if (str2 != null) {
                akVar = akVar.ab("obj_type", str2);
            }
            TiebaStatic.log(akVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0155a {
        private final String aIO;
        private final boolean aLI;
        private final ak eRR;
        private final String hjM;
        private final String hjN;
        private final String key;
        private final String locate;

        private C0155a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.hjM = str2;
            this.aIO = str3;
            this.locate = str4;
            this.hjN = str5;
            this.aLI = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.eRR = bCE();
        }

        private ak bCE() {
            ak akVar = new ak(this.key);
            if (!StringUtils.isNull(this.hjM)) {
                akVar = akVar.ab("line", this.hjM);
            }
            if (!StringUtils.isNull(this.aIO)) {
                akVar = akVar.ab("page", this.aIO);
            }
            if (!StringUtils.isNull(this.locate)) {
                akVar = akVar.ab("locate", this.locate);
            }
            if (!StringUtils.isNull(this.hjN)) {
                return akVar.ab("task", this.hjN);
            }
            return akVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ak e(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.eRR.ab("action_type", str);
            }
            if (!StringUtils.isNull(str2)) {
                this.eRR.ab("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.eRR.ab(ImageViewerConfig.FORUM_ID, str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.eRR.ab(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.eRR.ab("tid", str5);
            }
            this.eRR.s("obj_cpid", 0).s("obj_good_id", 0).ab("obj_throw_type", "BY_POST").ab("client_type", "MOBILE_APP").ab("user_timestamp", String.valueOf(System.currentTimeMillis())).ab("os", "android").ab("os_version", Build.VERSION.RELEASE).ab("log_ver", "1.1");
            return this.eRR;
        }

        public C0155a ch(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.eRR.ab(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.eRR);
            if (!this.aLI) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void dV(String str) {
            this.eRR.dV(str);
        }
    }
}
