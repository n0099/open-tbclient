package com.baidu.tieba.tbadkCore.d;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
/* loaded from: classes.dex */
public class a {

    /* loaded from: classes.dex */
    public static class b {
        public String anU;
        public int iCb;
        public String mPid;
    }

    public static C0880a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0880a c0880a = new C0880a(str, str2, str3, str4, str5);
        c0880a.m(str6, str7, str8, str9, str10);
        return c0880a;
    }

    public static C0880a i(String str, String str2, String str3, String str4, String str5, String str6) {
        C0880a c0880a = new C0880a("ad_tpoint", "PT", str, str2, "tpoint");
        c0880a.m(null, null, str3, str4, str5);
        if (!au.isEmpty(str6)) {
            c0880a.gA("obj_ref", str6);
        }
        return c0880a;
    }

    @Deprecated
    public static void c(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0880a c0880a = new C0880a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0880a.m(str2, str7, str3, str4, str5);
        c0880a.gA(TiebaInitialize.Params.OBJ_URL, str6);
        c0880a.save();
    }

    @Deprecated
    public static void gz(String str, String str2) {
        if (!au.isEmpty(str)) {
            ar arVar = new ar(str);
            if (str2 != null) {
                arVar = arVar.dR("obj_type", str2);
            }
            TiebaStatic.log(arVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0880a {
        private final String ePK;
        private final boolean isValid;
        private final String key;
        private final ar lcj;
        private final String nAD;
        private final String nAE;
        private final String page;

        private C0880a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.nAD = str2;
            this.page = str3;
            this.ePK = str4;
            this.nAE = str5;
            this.isValid = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.lcj = dOf();
        }

        private ar dOf() {
            ar arVar = new ar(this.key);
            if (!StringUtils.isNull(this.nAD)) {
                arVar = arVar.dR("line", this.nAD);
            }
            if (!StringUtils.isNull(this.page)) {
                arVar = arVar.dR("page", this.page);
            }
            if (!StringUtils.isNull(this.ePK)) {
                arVar = arVar.dR("locate", this.ePK);
            }
            if (!StringUtils.isNull(this.nAE)) {
                return arVar.dR("task", this.nAE);
            }
            return arVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ar m(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.lcj.dR(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str);
            }
            if (!StringUtils.isNull(str2)) {
                this.lcj.dR("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.lcj.dR("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.lcj.dR("fname", str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.lcj.dR("tid", str5);
            }
            this.lcj.aq("obj_cpid", 0).aq("obj_good_id", 0).dR("obj_throw_type", "BY_POST").dR("client_type", "MOBILE_APP").dR("user_timestamp", String.valueOf(System.currentTimeMillis())).dR("os", HttpConstants.OS_TYPE_VALUE).dR("os_version", Build.VERSION.RELEASE).dR("log_ver", "1.1");
            return this.lcj;
        }

        public C0880a gA(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.lcj.dR(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.lcj);
            if (!this.isValid) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.lcj.delete(str);
        }
    }
}
