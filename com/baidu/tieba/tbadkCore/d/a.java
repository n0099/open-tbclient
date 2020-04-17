package com.baidu.tieba.tbadkCore.d;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class a {

    /* loaded from: classes.dex */
    public static class b {
        public String ahL;
        public int grV;
        public String mPid;
    }

    public static C0654a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0654a c0654a = new C0654a(str, str2, str3, str4, str5);
        c0654a.k(str6, str7, str8, str9, str10);
        return c0654a;
    }

    public static C0654a d(String str, String str2, String str3, String str4, String str5, String str6) {
        C0654a c0654a = new C0654a("ad_tpoint", "PT", str, str2, "tpoint");
        c0654a.k(null, null, str3, str4, str5);
        if (!aq.isEmpty(str6)) {
            c0654a.eR("obj_ref", str6);
        }
        return c0654a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0654a c0654a = new C0654a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0654a.k(str2, str7, str3, str4, str5);
        c0654a.eR(TiebaInitialize.Params.OBJ_URL, str6);
        c0654a.save();
    }

    @Deprecated
    public static void eQ(String str, String str2) {
        if (!aq.isEmpty(str)) {
            an anVar = new an(str);
            if (str2 != null) {
                anVar = anVar.cI("obj_type", str2);
            }
            TiebaStatic.log(anVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0654a {
        private final boolean doI;
        private final an iHO;
        private final String kTL;
        private final String kTM;
        private final String kTN;
        private final String key;
        private final String page;

        private C0654a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.kTL = str2;
            this.page = str3;
            this.kTM = str4;
            this.kTN = str5;
            this.doI = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.iHO = cWJ();
        }

        private an cWJ() {
            an anVar = new an(this.key);
            if (!StringUtils.isNull(this.kTL)) {
                anVar = anVar.cI("line", this.kTL);
            }
            if (!StringUtils.isNull(this.page)) {
                anVar = anVar.cI("page", this.page);
            }
            if (!StringUtils.isNull(this.kTM)) {
                anVar = anVar.cI("locate", this.kTM);
            }
            if (!StringUtils.isNull(this.kTN)) {
                return anVar.cI("task", this.kTN);
            }
            return anVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public an k(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.iHO.cI(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str);
            }
            if (!StringUtils.isNull(str2)) {
                this.iHO.cI("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.iHO.cI("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.iHO.cI("fname", str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.iHO.cI("tid", str5);
            }
            this.iHO.af("obj_cpid", 0).af("obj_good_id", 0).cI("obj_throw_type", "BY_POST").cI("client_type", "MOBILE_APP").cI("user_timestamp", String.valueOf(System.currentTimeMillis())).cI("os", "android").cI("os_version", Build.VERSION.RELEASE).cI("log_ver", "1.1");
            return this.iHO;
        }

        public C0654a eR(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.iHO.cI(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.iHO);
            if (!this.doI) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.iHO.delete(str);
        }
    }
}
