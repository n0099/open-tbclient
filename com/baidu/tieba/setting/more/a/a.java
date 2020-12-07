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
    private b mXZ;
    private String mYa = null;
    private boolean mYb = false;
    private b.a mYc = new b.a() { // from class: com.baidu.tieba.setting.more.a.a.1
        @Override // com.baidu.tieba.setting.more.a.b.a
        public void dKy() {
            if (a.this.mYb) {
                a.this.mYb = false;
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

    public void dKu() {
        String dKx = dKx();
        if (!TextUtils.isEmpty(dKx)) {
            stop();
            if (c.SN(dKx) && E(dKx, "instant", true)) {
                this.mYb = true;
                BdToast.a(this.context, this.context.getString(R.string.logcat_collect_start), 0).brB();
            }
        }
    }

    public void dKv() {
        stop();
    }

    public boolean dKw() {
        return this.mYb;
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
            this.mXZ.a(null);
            this.mXZ = null;
        }
        if (this.mXZ != null) {
            this.mXZ.dKz();
        }
        this.mYb = false;
    }

    private boolean E(String str, String str2, boolean z) {
        if (this.mXZ == null) {
            SM(str);
            this.mXZ = new b(str, str2, z);
            this.mXZ.a(this.mYc);
            try {
                this.mXZ.start();
                return true;
            } catch (IllegalThreadStateException e) {
                return true;
            } catch (Exception e2) {
                this.mXZ = null;
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

    private String dKx() {
        if (!TextUtils.isEmpty(this.mYa)) {
            return this.mYa;
        }
        this.mYa = c.dKB();
        if (TextUtils.isEmpty(this.mYa)) {
            this.mYa = c.dKC();
        } else if (!this.mYa.endsWith(File.separator)) {
            this.mYa += File.separator;
        }
        return this.mYa;
    }
}
