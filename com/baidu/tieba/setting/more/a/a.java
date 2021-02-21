package com.baidu.tieba.setting.more.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.setting.more.a.b;
import java.io.File;
/* loaded from: classes8.dex */
public class a {
    private Context context;
    private b niZ;
    private String nja = null;
    private boolean njb = false;
    private b.a njc = new b.a() { // from class: com.baidu.tieba.setting.more.a.a.1
        @Override // com.baidu.tieba.setting.more.a.b.a
        public void dIQ() {
            if (a.this.njb) {
                a.this.njb = false;
            }
        }
    };

    public a(Context context) {
        this.context = context;
    }

    public void dIM() {
        String dIP = dIP();
        if (!TextUtils.isEmpty(dIP)) {
            stop();
            if (c.Sx(dIP) && G(dIP, "instant", true)) {
                this.njb = true;
            }
        }
    }

    public void dIN() {
        stop();
    }

    public boolean dIO() {
        return this.njb;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.baidu.tieba.setting.more.a.b */
    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.setting.more.a.b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.baidu.tieba.setting.more.a.b$a, com.baidu.tieba.setting.more.a.b] */
    private void stop() {
        try {
        } catch (Exception e) {
            BdLog.e(e);
        } finally {
            this.niZ.a(null);
            this.niZ = null;
        }
        if (this.niZ != null) {
            this.niZ.dIR();
        }
        this.njb = false;
    }

    private boolean G(String str, String str2, boolean z) {
        if (this.niZ == null) {
            Sw(str);
            this.niZ = new b(str, str2, z);
            this.niZ.a(this.njc);
            try {
                this.niZ.start();
                return true;
            } catch (IllegalThreadStateException e) {
                return true;
            } catch (Exception e2) {
                this.niZ = null;
                BdLog.e(e2);
                return false;
            }
        }
        return true;
    }

    private void Sw(String str) {
        File file = new File(str);
        if (!file.exists()) {
            if (file.mkdirs()) {
                BdLog.d("folder mkdir success: " + str);
            } else if (!file.exists()) {
                BdLog.d("folder mkdir failed");
            }
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("The logcat folder path is not a directory: " + str);
        }
    }

    private String dIP() {
        if (!TextUtils.isEmpty(this.nja)) {
            return this.nja;
        }
        this.nja = c.dIT();
        if (TextUtils.isEmpty(this.nja)) {
            this.nja = c.dIU();
        } else if (!this.nja.endsWith(File.separator)) {
            this.nja += File.separator;
        }
        return this.nja;
    }
}
