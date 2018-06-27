package com.baidu.tieba.tbadkCore.d;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes.dex */
public class a {

    /* loaded from: classes.dex */
    public static class b {
        public String aWo;
        public int czg;
        public String mPid;
    }

    public static C0236a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0236a c0236a = new C0236a(str, str2, str3, str4, str5);
        c0236a.e(str6, str7, str8, str9, str10);
        return c0236a;
    }

    public static C0236a d(String str, String str2, String str3, String str4, String str5, String str6) {
        C0236a c0236a = new C0236a("ad_tpoint", "PT", str, str2, "tpoint");
        c0236a.e(null, null, str3, str4, str5);
        if (!ap.isEmpty(str6)) {
            c0236a.cp("obj_ref", str6);
        }
        return c0236a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0236a c0236a = new C0236a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0236a.e(str2, str7, str3, str4, str5);
        c0236a.cp("obj_url", str6);
        c0236a.save();
    }

    @Deprecated
    public static void co(String str, String str2) {
        if (!ap.isEmpty(str)) {
            an anVar = new an(str);
            if (str2 != null) {
                anVar = anVar.ah("obj_type", str2);
            }
            TiebaStatic.log(anVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0236a {
        private final String adE;
        private final boolean agJ;
        private final an eKf;
        private final String gOd;
        private final String gOe;
        private final String gOf;
        private final String key;

        private C0236a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.gOd = str2;
            this.adE = str3;
            this.gOe = str4;
            this.gOf = str5;
            this.agJ = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.eKf = bxV();
        }

        private an bxV() {
            an anVar = new an(this.key);
            if (!StringUtils.isNull(this.gOd)) {
                anVar = anVar.ah("line", this.gOd);
            }
            if (!StringUtils.isNull(this.adE)) {
                anVar = anVar.ah("page", this.adE);
            }
            if (!StringUtils.isNull(this.gOe)) {
                anVar = anVar.ah("locate", this.gOe);
            }
            if (!StringUtils.isNull(this.gOf)) {
                return anVar.ah("task", this.gOf);
            }
            return anVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public an e(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.eKf.ah(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str);
            }
            if (!StringUtils.isNull(str2)) {
                this.eKf.ah(VideoPlayActivityConfig.OBJ_ID, str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.eKf.ah(ImageViewerConfig.FORUM_ID, str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.eKf.ah(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.eKf.ah("tid", str5);
            }
            this.eKf.r("obj_cpid", 0).r("obj_good_id", 0).ah("obj_throw_type", "BY_POST").ah("client_type", "MOBILE_APP").ah("user_timestamp", String.valueOf(System.currentTimeMillis())).ah("os", HttpConstants.OS_TYPE_VALUE).ah(StatisticConstants.OS_VERSION, Build.VERSION.RELEASE).ah("log_ver", "1.1");
            return this.eKf;
        }

        public C0236a cp(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.eKf.ah(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.eKf);
            if (!this.agJ) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.eKf.delete(str);
        }
    }
}
