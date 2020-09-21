package com.baidu.tieba.tbadkCore.d;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
/* loaded from: classes.dex */
public class a {

    /* loaded from: classes.dex */
    public static class b {
        public String alA;
        public int htF;
        public String mPid;
    }

    public static C0805a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0805a c0805a = new C0805a(str, str2, str3, str4, str5);
        c0805a.m(str6, str7, str8, str9, str10);
        return c0805a;
    }

    public static C0805a f(String str, String str2, String str3, String str4, String str5, String str6) {
        C0805a c0805a = new C0805a("ad_tpoint", "PT", str, str2, "tpoint");
        c0805a.m(null, null, str3, str4, str5);
        if (!at.isEmpty(str6)) {
            c0805a.gf("obj_ref", str6);
        }
        return c0805a;
    }

    @Deprecated
    public static void c(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0805a c0805a = new C0805a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0805a.m(str2, str7, str3, str4, str5);
        c0805a.gf(TiebaInitialize.Params.OBJ_URL, str6);
        c0805a.save();
    }

    @Deprecated
    public static void ge(String str, String str2) {
        if (!at.isEmpty(str)) {
            aq aqVar = new aq(str);
            if (str2 != null) {
                aqVar = aqVar.dF("obj_type", str2);
            }
            TiebaStatic.log(aqVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0805a {
        private final boolean eaY;
        private final aq jVz;
        private final String key;
        private final String mpX;
        private final String mpY;
        private final String mpZ;
        private final String page;

        private C0805a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.mpX = str2;
            this.page = str3;
            this.mpY = str4;
            this.mpZ = str5;
            this.eaY = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.jVz = dAU();
        }

        private aq dAU() {
            aq aqVar = new aq(this.key);
            if (!StringUtils.isNull(this.mpX)) {
                aqVar = aqVar.dF("line", this.mpX);
            }
            if (!StringUtils.isNull(this.page)) {
                aqVar = aqVar.dF("page", this.page);
            }
            if (!StringUtils.isNull(this.mpY)) {
                aqVar = aqVar.dF("locate", this.mpY);
            }
            if (!StringUtils.isNull(this.mpZ)) {
                return aqVar.dF("task", this.mpZ);
            }
            return aqVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public aq m(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.jVz.dF(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str);
            }
            if (!StringUtils.isNull(str2)) {
                this.jVz.dF("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.jVz.dF("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.jVz.dF("fname", str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.jVz.dF("tid", str5);
            }
            this.jVz.ai("obj_cpid", 0).ai("obj_good_id", 0).dF("obj_throw_type", "BY_POST").dF("client_type", "MOBILE_APP").dF("user_timestamp", String.valueOf(System.currentTimeMillis())).dF("os", "android").dF("os_version", Build.VERSION.RELEASE).dF("log_ver", "1.1");
            return this.jVz;
        }

        public C0805a gf(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.jVz.dF(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.jVz);
            if (!this.eaY) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.jVz.delete(str);
        }
    }
}
