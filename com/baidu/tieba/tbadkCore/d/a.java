package com.baidu.tieba.tbadkCore.d;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ar.util.Constants;
import com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.sina.weibo.sdk.constant.WBPageConstants;
/* loaded from: classes.dex */
public class a {

    /* loaded from: classes.dex */
    public static class b {
        public String aNu;
        public String aNv;
        public int crD;
    }

    public static C0217a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0217a c0217a = new C0217a(str, str2, str3, str4, str5);
        c0217a.e(str6, str7, str8, str9, str10);
        return c0217a;
    }

    public static C0217a d(String str, String str2, String str3, String str4, String str5, String str6) {
        C0217a c0217a = new C0217a("ad_tpoint", "PT", str, str2, "tpoint");
        c0217a.e(null, null, str3, str4, str5);
        if (!an.isEmpty(str6)) {
            c0217a.cd("obj_ref", str6);
        }
        return c0217a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0217a c0217a = new C0217a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0217a.e(str2, str7, str3, str4, str5);
        c0217a.cd("obj_url", str6);
        c0217a.save();
    }

    @Deprecated
    public static void cc(String str, String str2) {
        if (!an.isEmpty(str)) {
            al alVar = new al(str);
            if (str2 != null) {
                alVar = alVar.ac("obj_type", str2);
            }
            TiebaStatic.log(alVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0217a {
        private final String Vt;
        private final boolean Ys;
        private final al etT;
        private final String gxA;
        private final String gxB;
        private final String gxz;
        private final String key;

        private C0217a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.gxz = str2;
            this.Vt = str3;
            this.gxA = str4;
            this.gxB = str5;
            this.Ys = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.etT = bsp();
        }

        private al bsp() {
            al alVar = new al(this.key);
            if (!StringUtils.isNull(this.gxz)) {
                alVar = alVar.ac("line", this.gxz);
            }
            if (!StringUtils.isNull(this.Vt)) {
                alVar = alVar.ac(WBPageConstants.ParamKey.PAGE, this.Vt);
            }
            if (!StringUtils.isNull(this.gxA)) {
                alVar = alVar.ac("locate", this.gxA);
            }
            if (!StringUtils.isNull(this.gxB)) {
                return alVar.ac("task", this.gxB);
            }
            return alVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public al e(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.etT.ac(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str);
            }
            if (!StringUtils.isNull(str2)) {
                this.etT.ac(VideoPlayActivityConfig.OBJ_ID, str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.etT.ac(ImageViewerConfig.FORUM_ID, str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.etT.ac(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.etT.ac("tid", str5);
            }
            this.etT.r("obj_cpid", 0).r("obj_good_id", 0).ac("obj_throw_type", "BY_POST").ac("client_type", "MOBILE_APP").ac("user_timestamp", String.valueOf(System.currentTimeMillis())).ac("os", Constants.OS_TYPE_VALUE).ac("os_version", Build.VERSION.RELEASE).ac("log_ver", "1.1");
            return this.etT;
        }

        public C0217a cd(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.etT.ac(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.etT);
            if (!this.Ys) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void ee(String str) {
            this.etT.ee(str);
        }
    }
}
