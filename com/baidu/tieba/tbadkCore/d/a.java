package com.baidu.tieba.tbadkCore.d;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes.dex */
public class a {

    /* loaded from: classes.dex */
    public static class b {
        public String bVL;
        public int eAv;
        public String mPid;
    }

    public static C0409a b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C0409a c0409a = new C0409a(str, str2, str3, str4, str5);
        c0409a.h(str6, str7, str8, str9, str10);
        return c0409a;
    }

    public static C0409a f(String str, String str2, String str3, String str4, String str5, String str6) {
        C0409a c0409a = new C0409a("ad_tpoint", "PT", str, str2, "tpoint");
        c0409a.h(null, null, str3, str4, str5);
        if (!ap.isEmpty(str6)) {
            c0409a.em("obj_ref", str6);
        }
        return c0409a;
    }

    @Deprecated
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0409a c0409a = new C0409a("ad_tpoint", "PT", str, "c0122", "ad_plat");
        c0409a.h(str2, str7, str3, str4, str5);
        c0409a.em("obj_url", str6);
        c0409a.save();
    }

    @Deprecated
    public static void el(String str, String str2) {
        if (!ap.isEmpty(str)) {
            am amVar = new am(str);
            if (str2 != null) {
                amVar = amVar.bT("obj_type", str2);
            }
            TiebaStatic.log(amVar);
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0409a {
        private final boolean bGu;
        private final am gWn;
        private final String iZW;
        private final String iZX;
        private final String iZY;
        private final String key;
        private final String page;

        private C0409a(String str, String str2, String str3, String str4, String str5) {
            this.key = str;
            this.iZW = str2;
            this.page = str3;
            this.iZX = str4;
            this.iZY = str5;
            this.bGu = StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5) ? false : true;
            this.gWn = cmO();
        }

        private am cmO() {
            am amVar = new am(this.key);
            if (!StringUtils.isNull(this.iZW)) {
                amVar = amVar.bT("line", this.iZW);
            }
            if (!StringUtils.isNull(this.page)) {
                amVar = amVar.bT("page", this.page);
            }
            if (!StringUtils.isNull(this.iZX)) {
                amVar = amVar.bT("locate", this.iZX);
            }
            if (!StringUtils.isNull(this.iZY)) {
                return amVar.bT("task", this.iZY);
            }
            return amVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public am h(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.gWn.bT("action_type", str);
            }
            if (!StringUtils.isNull(str2)) {
                this.gWn.bT(VideoPlayActivityConfig.OBJ_ID, str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.gWn.bT("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.gWn.bT(ImageViewerConfig.FORUM_NAME, str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.gWn.bT("tid", str5);
            }
            this.gWn.P("obj_cpid", 0).P("obj_good_id", 0).bT("obj_throw_type", "BY_POST").bT("client_type", "MOBILE_APP").bT("user_timestamp", String.valueOf(System.currentTimeMillis())).bT("os", "android").bT("os_version", Build.VERSION.RELEASE).bT("log_ver", "1.1");
            return this.gWn;
        }

        public C0409a em(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.gWn.bT(str, str2);
            }
            return this;
        }

        public void save() {
            TiebaStatic.log(this.gWn);
            if (!this.bGu) {
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException();
                }
                BdLog.e("Invalid parameter.");
            }
        }

        public void delete(String str) {
            this.gWn.delete(str);
        }
    }
}
