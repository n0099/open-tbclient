package com.baidu.tieba.setting.more.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.setting.more.a.b;
import java.io.File;
/* loaded from: classes8.dex */
public class a {
    private Context context;
    private b ndv;
    private String ndw = null;
    private boolean ndx = false;
    private b.a ndy = new b.a() { // from class: com.baidu.tieba.setting.more.a.a.1
        @Override // com.baidu.tieba.setting.more.a.b.a
        public void dKp() {
            if (a.this.ndx) {
                a.this.ndx = false;
            }
        }
    };

    public a(Context context) {
        this.context = context;
    }

    public void dKl() {
        String dKo = dKo();
        if (!TextUtils.isEmpty(dKo)) {
            stop();
            if (c.Sv(dKo) && G(dKo, "instant", true)) {
                this.ndx = true;
            }
        }
    }

    public void dKm() {
        stop();
    }

    public boolean dKn() {
        return this.ndx;
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
            this.ndv.a(null);
            this.ndv = null;
        }
        if (this.ndv != null) {
            this.ndv.dKq();
        }
        this.ndx = false;
    }

    private boolean G(String str, String str2, boolean z) {
        if (this.ndv == null) {
            Su(str);
            this.ndv = new b(str, str2, z);
            this.ndv.a(this.ndy);
            try {
                this.ndv.start();
                return true;
            } catch (IllegalThreadStateException e) {
                return true;
            } catch (Exception e2) {
                this.ndv = null;
                BdLog.e(e2);
                return false;
            }
        }
        return true;
    }

    private void Su(String str) {
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

    private String dKo() {
        if (!TextUtils.isEmpty(this.ndw)) {
            return this.ndw;
        }
        this.ndw = c.dKs();
        if (TextUtils.isEmpty(this.ndw)) {
            this.ndw = c.dKt();
        } else if (!this.ndw.endsWith(File.separator)) {
            this.ndw += File.separator;
        }
        return this.ndw;
    }
}
