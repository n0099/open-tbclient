package com.baidu.tieba.setting.more.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.setting.more.a.b;
import java.io.File;
/* loaded from: classes7.dex */
public class a {
    private Context context;
    private b mYQ;
    private String mYR = null;
    private boolean mYS = false;
    private b.a mYT = new b.a() { // from class: com.baidu.tieba.setting.more.a.a.1
        @Override // com.baidu.tieba.setting.more.a.b.a
        public void dGx() {
            if (a.this.mYS) {
                a.this.mYS = false;
            }
        }
    };

    public a(Context context) {
        this.context = context;
    }

    public void dGt() {
        String dGw = dGw();
        if (!TextUtils.isEmpty(dGw)) {
            stop();
            if (c.Rn(dGw) && G(dGw, "instant", true)) {
                this.mYS = true;
            }
        }
    }

    public void dGu() {
        stop();
    }

    public boolean dGv() {
        return this.mYS;
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
            this.mYQ.a(null);
            this.mYQ = null;
        }
        if (this.mYQ != null) {
            this.mYQ.dGy();
        }
        this.mYS = false;
    }

    private boolean G(String str, String str2, boolean z) {
        if (this.mYQ == null) {
            Rm(str);
            this.mYQ = new b(str, str2, z);
            this.mYQ.a(this.mYT);
            try {
                this.mYQ.start();
                return true;
            } catch (IllegalThreadStateException e) {
                return true;
            } catch (Exception e2) {
                this.mYQ = null;
                BdLog.e(e2);
                return false;
            }
        }
        return true;
    }

    private void Rm(String str) {
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

    private String dGw() {
        if (!TextUtils.isEmpty(this.mYR)) {
            return this.mYR;
        }
        this.mYR = c.dGA();
        if (TextUtils.isEmpty(this.mYR)) {
            this.mYR = c.dGB();
        } else if (!this.mYR.endsWith(File.separator)) {
            this.mYR += File.separator;
        }
        return this.mYR;
    }
}
