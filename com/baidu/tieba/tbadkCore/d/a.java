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
        public String ais;
        public int gHb;
        public String mPid;
    }

    public static C0729a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0729a c0729a = new C0729a(str, str2, str3, str4, str5);
        c0729a.k(str6, str7, str8, str9, str10);
        return c0729a;
    }

    public static C0729a d(String str, String str2, String str3, String str4, String str5, String str6) {
        C0729a c0729a = new C0729a("ad_tpoint", "PT", str, str2, "tpoint");
        c0729a.k(null, null, str3, str4, str5);
        if (!aq.isEmpty(str6)) {
            c0729a.fs("obj_ref", str6);
        }
        return c0729a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0729a c0729a = new C0729a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0729a.k(str2, str7, str3, str4, str5);
        c0729a.fs(TiebaInitialize.Params.OBJ_URL, str6);
        c0729a.save();
    }

    @Deprecated
    public static void fr(String str, String str2) {
        if (!aq.isEmpty(str)) {
            an anVar = new an(str);
            if (str2 != null) {
                anVar = anVar.dh("obj_type", str2);
            }
            TiebaStatic.log(anVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0729a {
        private final boolean dCL;
        private final an iXF;
        private final String key;
        private final String lnt;
        private final String lnu;
        private final String lnv;
        private final String page;

        private C0729a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.lnt = str2;
            this.page = str3;
            this.lnu = str4;
            this.lnv = str5;
            this.dCL = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.iXF = ded();
        }

        private an ded() {
            an anVar = new an(this.key);
            if (!StringUtils.isNull(this.lnt)) {
                anVar = anVar.dh("line", this.lnt);
            }
            if (!StringUtils.isNull(this.page)) {
                anVar = anVar.dh("page", this.page);
            }
            if (!StringUtils.isNull(this.lnu)) {
                anVar = anVar.dh("locate", this.lnu);
            }
            if (!StringUtils.isNull(this.lnv)) {
                return anVar.dh("task", this.lnv);
            }
            return anVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public an k(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.iXF.dh(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str);
            }
            if (!StringUtils.isNull(str2)) {
                this.iXF.dh("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.iXF.dh("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.iXF.dh("fname", str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.iXF.dh("tid", str5);
            }
            this.iXF.ag("obj_cpid", 0).ag("obj_good_id", 0).dh("obj_throw_type", "BY_POST").dh("client_type", "MOBILE_APP").dh("user_timestamp", String.valueOf(System.currentTimeMillis())).dh("os", "android").dh("os_version", Build.VERSION.RELEASE).dh("log_ver", "1.1");
            return this.iXF;
        }

        public C0729a fs(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.iXF.dh(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.iXF);
            if (!this.dCL) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.iXF.delete(str);
        }
    }
}
