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
        public String ahO;
        public int gsb;
        public String mPid;
    }

    public static C0675a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0675a c0675a = new C0675a(str, str2, str3, str4, str5);
        c0675a.k(str6, str7, str8, str9, str10);
        return c0675a;
    }

    public static C0675a d(String str, String str2, String str3, String str4, String str5, String str6) {
        C0675a c0675a = new C0675a("ad_tpoint", "PT", str, str2, "tpoint");
        c0675a.k(null, null, str3, str4, str5);
        if (!aq.isEmpty(str6)) {
            c0675a.eR("obj_ref", str6);
        }
        return c0675a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0675a c0675a = new C0675a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0675a.k(str2, str7, str3, str4, str5);
        c0675a.eR(TiebaInitialize.Params.OBJ_URL, str6);
        c0675a.save();
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
    public static class C0675a {
        private final boolean doM;
        private final an iHS;
        private final String kTP;
        private final String kTQ;
        private final String kTR;
        private final String key;
        private final String page;

        private C0675a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.kTP = str2;
            this.page = str3;
            this.kTQ = str4;
            this.kTR = str5;
            this.doM = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.iHS = cWH();
        }

        private an cWH() {
            an anVar = new an(this.key);
            if (!StringUtils.isNull(this.kTP)) {
                anVar = anVar.cI("line", this.kTP);
            }
            if (!StringUtils.isNull(this.page)) {
                anVar = anVar.cI("page", this.page);
            }
            if (!StringUtils.isNull(this.kTQ)) {
                anVar = anVar.cI("locate", this.kTQ);
            }
            if (!StringUtils.isNull(this.kTR)) {
                return anVar.cI("task", this.kTR);
            }
            return anVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public an k(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.iHS.cI(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str);
            }
            if (!StringUtils.isNull(str2)) {
                this.iHS.cI("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.iHS.cI("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.iHS.cI("fname", str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.iHS.cI("tid", str5);
            }
            this.iHS.af("obj_cpid", 0).af("obj_good_id", 0).cI("obj_throw_type", "BY_POST").cI("client_type", "MOBILE_APP").cI("user_timestamp", String.valueOf(System.currentTimeMillis())).cI("os", "android").cI("os_version", Build.VERSION.RELEASE).cI("log_ver", "1.1");
            return this.iHS;
        }

        public C0675a eR(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.iHS.cI(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.iHS);
            if (!this.doM) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.iHS.delete(str);
        }
    }
}
