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
        public String aNv;
        public String aNw;
        public int csJ;
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
        private final String Vp;
        private final boolean Ys;
        private final al euY;
        private final String gyA;
        private final String gyB;
        private final String gyC;
        private final String key;

        private C0217a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.gyA = str2;
            this.Vp = str3;
            this.gyB = str4;
            this.gyC = str5;
            this.Ys = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.euY = bsn();
        }

        private al bsn() {
            al alVar = new al(this.key);
            if (!StringUtils.isNull(this.gyA)) {
                alVar = alVar.ac("line", this.gyA);
            }
            if (!StringUtils.isNull(this.Vp)) {
                alVar = alVar.ac(WBPageConstants.ParamKey.PAGE, this.Vp);
            }
            if (!StringUtils.isNull(this.gyB)) {
                alVar = alVar.ac("locate", this.gyB);
            }
            if (!StringUtils.isNull(this.gyC)) {
                return alVar.ac("task", this.gyC);
            }
            return alVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public al e(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.euY.ac(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str);
            }
            if (!StringUtils.isNull(str2)) {
                this.euY.ac(VideoPlayActivityConfig.OBJ_ID, str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.euY.ac(ImageViewerConfig.FORUM_ID, str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.euY.ac(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.euY.ac("tid", str5);
            }
            this.euY.r("obj_cpid", 0).r("obj_good_id", 0).ac("obj_throw_type", "BY_POST").ac("client_type", "MOBILE_APP").ac("user_timestamp", String.valueOf(System.currentTimeMillis())).ac("os", Constants.OS_TYPE_VALUE).ac("os_version", Build.VERSION.RELEASE).ac("log_ver", "1.1");
            return this.euY;
        }

        public C0217a cd(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.euY.ac(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.euY);
            if (!this.Ys) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void ee(String str) {
            this.euY.ee(str);
        }
    }
}
