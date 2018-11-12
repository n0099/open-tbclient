package com.baidu.tieba.tbadkCore.d;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.searchbox.ng.ai.apps.network.WebSocketAction;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
/* loaded from: classes.dex */
public class a {

    /* loaded from: classes.dex */
    public static class b {
        public String beV;
        public int cRa;
        public String mPid;
    }

    public static C0305a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0305a c0305a = new C0305a(str, str2, str3, str4, str5);
        c0305a.e(str6, str7, str8, str9, str10);
        return c0305a;
    }

    public static C0305a f(String str, String str2, String str3, String str4, String str5, String str6) {
        C0305a c0305a = new C0305a("ad_tpoint", "PT", str, str2, "tpoint");
        c0305a.e(null, null, str3, str4, str5);
        if (!ao.isEmpty(str6)) {
            c0305a.cH("obj_ref", str6);
        }
        return c0305a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0305a c0305a = new C0305a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0305a.e(str2, str7, str3, str4, str5);
        c0305a.cH("obj_url", str6);
        c0305a.save();
    }

    @Deprecated
    public static void cG(String str, String str2) {
        if (!ao.isEmpty(str)) {
            am amVar = new am(str);
            if (str2 != null) {
                amVar = amVar.ax("obj_type", str2);
            }
            TiebaStatic.log(amVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0305a {
        private final boolean aol;
        private final am fes;
        private final String hfB;
        private final String hfC;
        private final String key;
        private final String line;
        private final String page;

        private C0305a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.line = str2;
            this.page = str3;
            this.hfB = str4;
            this.hfC = str5;
            this.aol = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.fes = bBO();
        }

        private am bBO() {
            am amVar = new am(this.key);
            if (!StringUtils.isNull(this.line)) {
                amVar = amVar.ax("line", this.line);
            }
            if (!StringUtils.isNull(this.page)) {
                amVar = amVar.ax(SystemScreenshotManager.PAGE, this.page);
            }
            if (!StringUtils.isNull(this.hfB)) {
                amVar = amVar.ax("locate", this.hfB);
            }
            if (!StringUtils.isNull(this.hfC)) {
                return amVar.ax(WebSocketAction.PARAM_KEY_TASK, this.hfC);
            }
            return amVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public am e(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.fes.ax(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str);
            }
            if (!StringUtils.isNull(str2)) {
                this.fes.ax(VideoPlayActivityConfig.OBJ_ID, str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.fes.ax(ImageViewerConfig.FORUM_ID, str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.fes.ax(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.fes.ax("tid", str5);
            }
            this.fes.x("obj_cpid", 0).x("obj_good_id", 0).ax("obj_throw_type", "BY_POST").ax("client_type", "MOBILE_APP").ax("user_timestamp", String.valueOf(System.currentTimeMillis())).ax("os", HttpConstants.OS_TYPE_VALUE).ax(StatisticConstants.OS_VERSION, Build.VERSION.RELEASE).ax("log_ver", "1.1");
            return this.fes;
        }

        public C0305a cH(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.fes.ax(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.fes);
            if (!this.aol) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.fes.delete(str);
        }
    }
}
