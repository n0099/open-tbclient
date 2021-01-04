package com.baidu.tieba.setting.more.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.setting.more.a.b;
import java.io.File;
/* loaded from: classes8.dex */
public class a {
    private Context context;
    private b ndw;
    private String ndx = null;
    private boolean ndy = false;
    private b.a ndz = new b.a() { // from class: com.baidu.tieba.setting.more.a.a.1
        @Override // com.baidu.tieba.setting.more.a.b.a
        public void dKo() {
            if (a.this.ndy) {
                a.this.ndy = false;
            }
        }
    };

    public a(Context context) {
        this.context = context;
    }

    public void dKk() {
        String dKn = dKn();
        if (!TextUtils.isEmpty(dKn)) {
            stop();
            if (c.Sw(dKn) && G(dKn, "instant", true)) {
                this.ndy = true;
            }
        }
    }

    public void dKl() {
        stop();
    }

    public boolean dKm() {
        return this.ndy;
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
            this.ndw.a(null);
            this.ndw = null;
        }
        if (this.ndw != null) {
            this.ndw.dKp();
        }
        this.ndy = false;
    }

    private boolean G(String str, String str2, boolean z) {
        if (this.ndw == null) {
            Sv(str);
            this.ndw = new b(str, str2, z);
            this.ndw.a(this.ndz);
            try {
                this.ndw.start();
                return true;
            } catch (IllegalThreadStateException e) {
                return true;
            } catch (Exception e2) {
                this.ndw = null;
                BdLog.e(e2);
                return false;
            }
        }
        return true;
    }

    private void Sv(String str) {
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

    private String dKn() {
        if (!TextUtils.isEmpty(this.ndx)) {
            return this.ndx;
        }
        this.ndx = c.dKr();
        if (TextUtils.isEmpty(this.ndx)) {
            this.ndx = c.dKs();
        } else if (!this.ndx.endsWith(File.separator)) {
            this.ndx += File.separator;
        }
        return this.ndx;
    }
}
