package com.baidu.tieba.setting.more.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.setting.more.a.b;
import java.io.File;
/* loaded from: classes8.dex */
public class a {
    private Context context;
    private String niA = null;
    private boolean niB = false;
    private b.a niC = new b.a() { // from class: com.baidu.tieba.setting.more.a.a.1
        @Override // com.baidu.tieba.setting.more.a.b.a
        public void dII() {
            if (a.this.niB) {
                a.this.niB = false;
            }
        }
    };
    private b niz;

    public a(Context context) {
        this.context = context;
    }

    public void dIE() {
        String dIH = dIH();
        if (!TextUtils.isEmpty(dIH)) {
            stop();
            if (c.Sl(dIH) && G(dIH, "instant", true)) {
                this.niB = true;
            }
        }
    }

    public void dIF() {
        stop();
    }

    public boolean dIG() {
        return this.niB;
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
            this.niz.a(null);
            this.niz = null;
        }
        if (this.niz != null) {
            this.niz.dIJ();
        }
        this.niB = false;
    }

    private boolean G(String str, String str2, boolean z) {
        if (this.niz == null) {
            Sk(str);
            this.niz = new b(str, str2, z);
            this.niz.a(this.niC);
            try {
                this.niz.start();
                return true;
            } catch (IllegalThreadStateException e) {
                return true;
            } catch (Exception e2) {
                this.niz = null;
                BdLog.e(e2);
                return false;
            }
        }
        return true;
    }

    private void Sk(String str) {
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

    private String dIH() {
        if (!TextUtils.isEmpty(this.niA)) {
            return this.niA;
        }
        this.niA = c.dIL();
        if (TextUtils.isEmpty(this.niA)) {
            this.niA = c.dIM();
        } else if (!this.niA.endsWith(File.separator)) {
            this.niA += File.separator;
        }
        return this.niA;
    }
}
