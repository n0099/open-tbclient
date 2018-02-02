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
        public String bBb;
        public String bBc;
        public int cXb;
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
            c0155a.cc("obj_ref", str6);
        }
        return c0155a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0155a c0155a = new C0155a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0155a.e(str2, str7, str3, str4, str5);
        c0155a.cc("obj_url", str6);
        c0155a.save();
    }

    @Deprecated
    public static void cb(String str, String str2) {
        if (!am.isEmpty(str)) {
            ak akVar = new ak(str);
            if (str2 != null) {
                akVar = akVar.aa("obj_type", str2);
            }
            TiebaStatic.log(akVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0155a {
        private final String aIP;
        private final boolean aLH;
        private final ak eTN;
        private final String gZG;
        private final String gZH;
        private final String key;
        private final String locate;

        private C0155a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.gZG = str2;
            this.aIP = str3;
            this.locate = str4;
            this.gZH = str5;
            this.aLH = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.eTN = bwc();
        }

        private ak bwc() {
            ak akVar = new ak(this.key);
            if (!StringUtils.isNull(this.gZG)) {
                akVar = akVar.aa("line", this.gZG);
            }
            if (!StringUtils.isNull(this.aIP)) {
                akVar = akVar.aa("page", this.aIP);
            }
            if (!StringUtils.isNull(this.locate)) {
                akVar = akVar.aa("locate", this.locate);
            }
            if (!StringUtils.isNull(this.gZH)) {
                return akVar.aa("task", this.gZH);
            }
            return akVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ak e(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.eTN.aa("action_type", str);
            }
            if (!StringUtils.isNull(str2)) {
                this.eTN.aa("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.eTN.aa(ImageViewerConfig.FORUM_ID, str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.eTN.aa(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.eTN.aa("tid", str5);
            }
            this.eTN.s("obj_cpid", 0).s("obj_good_id", 0).aa("obj_throw_type", "BY_POST").aa("client_type", "MOBILE_APP").aa("user_timestamp", String.valueOf(System.currentTimeMillis())).aa("os", "android").aa("os_version", Build.VERSION.RELEASE).aa("log_ver", "1.1");
            return this.eTN;
        }

        public C0155a cc(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.eTN.aa(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.eTN);
            if (!this.aLH) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void eb(String str) {
            this.eTN.eb(str);
        }
    }
}
