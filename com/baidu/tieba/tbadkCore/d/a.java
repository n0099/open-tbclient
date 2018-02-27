package com.baidu.tieba.tbadkCore.d;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ar.util.Constants;
import com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.sina.weibo.sdk.constant.WBPageConstants;
/* loaded from: classes.dex */
public class a {

    /* loaded from: classes.dex */
    public static class b {
        public String bCS;
        public String bCT;
        public int cZC;
    }

    public static C0236a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0236a c0236a = new C0236a(str, str2, str3, str4, str5);
        c0236a.e(str6, str7, str8, str9, str10);
        return c0236a;
    }

    public static C0236a d(String str, String str2, String str3, String str4, String str5, String str6) {
        C0236a c0236a = new C0236a("ad_tpoint", "PT", str, str2, "tpoint");
        c0236a.e(null, null, str3, str4, str5);
        if (!am.isEmpty(str6)) {
            c0236a.ce("obj_ref", str6);
        }
        return c0236a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0236a c0236a = new C0236a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0236a.e(str2, str7, str3, str4, str5);
        c0236a.ce("obj_url", str6);
        c0236a.save();
    }

    @Deprecated
    public static void cd(String str, String str2) {
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
    public static class C0236a {
        private final String aJX;
        private final boolean aMP;
        private final ak eYY;
        private final String hbF;
        private final String hbG;
        private final String key;
        private final String locate;

        private C0236a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.hbF = str2;
            this.aJX = str3;
            this.locate = str4;
            this.hbG = str5;
            this.aMP = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.eYY = bxk();
        }

        private ak bxk() {
            ak akVar = new ak(this.key);
            if (!StringUtils.isNull(this.hbF)) {
                akVar = akVar.ab("line", this.hbF);
            }
            if (!StringUtils.isNull(this.aJX)) {
                akVar = akVar.ab(WBPageConstants.ParamKey.PAGE, this.aJX);
            }
            if (!StringUtils.isNull(this.locate)) {
                akVar = akVar.ab("locate", this.locate);
            }
            if (!StringUtils.isNull(this.hbG)) {
                return akVar.ab("task", this.hbG);
            }
            return akVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ak e(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.eYY.ab(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str);
            }
            if (!StringUtils.isNull(str2)) {
                this.eYY.ab("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.eYY.ab(ImageViewerConfig.FORUM_ID, str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.eYY.ab(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.eYY.ab("tid", str5);
            }
            this.eYY.s("obj_cpid", 0).s("obj_good_id", 0).ab("obj_throw_type", "BY_POST").ab("client_type", "MOBILE_APP").ab("user_timestamp", String.valueOf(System.currentTimeMillis())).ab("os", Constants.OS_TYPE_VALUE).ab("os_version", Build.VERSION.RELEASE).ab("log_ver", "1.1");
            return this.eYY;
        }

        public C0236a ce(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.eYY.ab(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.eYY);
            if (!this.aMP) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void em(String str) {
            this.eYY.em(str);
        }
    }
}
