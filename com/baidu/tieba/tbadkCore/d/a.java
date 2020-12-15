package com.baidu.tieba.tbadkCore.d;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
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
        public String amY;
        public int imG;
        public String mPid;
    }

    public static C0870a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0870a c0870a = new C0870a(str, str2, str3, str4, str5);
        c0870a.m(str6, str7, str8, str9, str10);
        return c0870a;
    }

    public static C0870a g(String str, String str2, String str3, String str4, String str5, String str6) {
        C0870a c0870a = new C0870a("ad_tpoint", "PT", str, str2, "tpoint");
        c0870a.m(null, null, str3, str4, str5);
        if (!au.isEmpty(str6)) {
            c0870a.gw("obj_ref", str6);
        }
        return c0870a;
    }

    @Deprecated
    public static void c(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0870a c0870a = new C0870a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0870a.m(str2, str7, str3, str4, str5);
        c0870a.gw(TiebaInitialize.Params.OBJ_URL, str6);
        c0870a.save();
    }

    @Deprecated
    public static void gv(String str, String str2) {
        if (!au.isEmpty(str)) {
            ar arVar = new ar(str);
            if (str2 != null) {
                arVar = arVar.dY("obj_type", str2);
            }
            TiebaStatic.log(arVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0870a {
        private final boolean eGJ;
        private final ar kQQ;
        private final String key;
        private final String nng;
        private final String nnh;
        private final String nni;
        private final String page;

        private C0870a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.nng = str2;
            this.page = str3;
            this.nnh = str4;
            this.nni = str5;
            this.eGJ = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.kQQ = dPy();
        }

        private ar dPy() {
            ar arVar = new ar(this.key);
            if (!StringUtils.isNull(this.nng)) {
                arVar = arVar.dY("line", this.nng);
            }
            if (!StringUtils.isNull(this.page)) {
                arVar = arVar.dY("page", this.page);
            }
            if (!StringUtils.isNull(this.nnh)) {
                arVar = arVar.dY("locate", this.nnh);
            }
            if (!StringUtils.isNull(this.nni)) {
                return arVar.dY("task", this.nni);
            }
            return arVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ar m(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.kQQ.dY(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str);
            }
            if (!StringUtils.isNull(str2)) {
                this.kQQ.dY("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.kQQ.dY("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.kQQ.dY("fname", str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.kQQ.dY("tid", str5);
            }
            this.kQQ.al("obj_cpid", 0).al("obj_good_id", 0).dY("obj_throw_type", "BY_POST").dY("client_type", "MOBILE_APP").dY("user_timestamp", String.valueOf(System.currentTimeMillis())).dY("os", "android").dY("os_version", Build.VERSION.RELEASE).dY("log_ver", "1.1");
            return this.kQQ;
        }

        public C0870a gw(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.kQQ.dY(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.kQQ);
            if (!this.eGJ) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.kQQ.delete(str);
        }
    }
}
