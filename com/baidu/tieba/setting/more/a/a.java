package com.baidu.tieba.setting.more.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.more.a.b;
import java.io.File;
/* loaded from: classes26.dex */
public class a {
    private Context context;
    private b mYb;
    private String mYc = null;
    private boolean mYd = false;
    private b.a mYe = new b.a() { // from class: com.baidu.tieba.setting.more.a.a.1
        @Override // com.baidu.tieba.setting.more.a.b.a
        public void dKz() {
            if (a.this.mYd) {
                a.this.mYd = false;
                e.mY().post(new Runnable() { // from class: com.baidu.tieba.setting.more.a.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BdToast.a(a.this.context, a.this.context.getString(R.string.logcat_collect_end), 0).brB();
                    }
                });
            }
        }
    };

    public a(Context context) {
        this.context = context;
    }

    public void dKv() {
        String dKy = dKy();
        if (!TextUtils.isEmpty(dKy)) {
            stop();
            if (c.SN(dKy) && E(dKy, "instant", true)) {
                this.mYd = true;
                BdToast.a(this.context, this.context.getString(R.string.logcat_collect_start), 0).brB();
            }
        }
    }

    public void dKw() {
        stop();
    }

    public boolean dKx() {
        return this.mYd;
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
            this.mYb.a(null);
            this.mYb = null;
        }
        if (this.mYb != null) {
            this.mYb.dKA();
        }
        this.mYd = false;
    }

    private boolean E(String str, String str2, boolean z) {
        if (this.mYb == null) {
            SM(str);
            this.mYb = new b(str, str2, z);
            this.mYb.a(this.mYe);
            try {
                this.mYb.start();
                return true;
            } catch (IllegalThreadStateException e) {
                return true;
            } catch (Exception e2) {
                this.mYb = null;
                BdLog.e(e2);
                return false;
            }
        }
        return true;
    }

    private void SM(String str) {
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

    private String dKy() {
        if (!TextUtils.isEmpty(this.mYc)) {
            return this.mYc;
        }
        this.mYc = c.dKC();
        if (TextUtils.isEmpty(this.mYc)) {
            this.mYc = c.dKD();
        } else if (!this.mYc.endsWith(File.separator)) {
            this.mYc += File.separator;
        }
        return this.mYc;
    }
}
