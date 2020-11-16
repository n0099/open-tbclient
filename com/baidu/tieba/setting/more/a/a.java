package com.baidu.tieba.setting.more.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.more.a.b;
import java.io.File;
/* loaded from: classes25.dex */
public class a {
    private Context context;
    private b mJX;
    private String mJY = null;
    private boolean mJZ = false;
    private b.a mKa = new b.a() { // from class: com.baidu.tieba.setting.more.a.a.1
        @Override // com.baidu.tieba.setting.more.a.b.a
        public void dFn() {
            if (a.this.mJZ) {
                a.this.mJZ = false;
                e.mY().post(new Runnable() { // from class: com.baidu.tieba.setting.more.a.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BdToast.a(a.this.context, a.this.context.getString(R.string.logcat_collect_end), 0).bom();
                    }
                });
            }
        }
    };

    public a(Context context) {
        this.context = context;
    }

    public void dFj() {
        String dFm = dFm();
        if (!TextUtils.isEmpty(dFm)) {
            stop();
            if (c.Rz(dFm) && D(dFm, "instant", true)) {
                this.mJZ = true;
                BdToast.a(this.context, this.context.getString(R.string.logcat_collect_start), 0).bom();
            }
        }
    }

    public void dFk() {
        stop();
    }

    public boolean dFl() {
        return this.mJZ;
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
            this.mJX.a(null);
            this.mJX = null;
        }
        if (this.mJX != null) {
            this.mJX.dFo();
        }
        this.mJZ = false;
    }

    private boolean D(String str, String str2, boolean z) {
        if (this.mJX == null) {
            Ry(str);
            this.mJX = new b(str, str2, z);
            this.mJX.a(this.mKa);
            try {
                this.mJX.start();
                return true;
            } catch (IllegalThreadStateException e) {
                return true;
            } catch (Exception e2) {
                this.mJX = null;
                BdLog.e(e2);
                return false;
            }
        }
        return true;
    }

    private void Ry(String str) {
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

    private String dFm() {
        if (!TextUtils.isEmpty(this.mJY)) {
            return this.mJY;
        }
        this.mJY = c.dFp();
        if (TextUtils.isEmpty(this.mJY)) {
            this.mJY = c.dFq();
        } else if (!this.mJY.endsWith(File.separator)) {
            this.mJY += File.separator;
        }
        return this.mJY;
    }
}
