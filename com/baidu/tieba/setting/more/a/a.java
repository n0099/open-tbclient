package com.baidu.tieba.setting.more.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.setting.more.a.b;
import java.io.File;
/* loaded from: classes7.dex */
public class a {
    private Context context;
    private b nld;
    private String nle = null;
    private boolean nlf = false;
    private b.a nlg = new b.a() { // from class: com.baidu.tieba.setting.more.a.a.1
        @Override // com.baidu.tieba.setting.more.a.b.a
        public void dIY() {
            if (a.this.nlf) {
                a.this.nlf = false;
            }
        }
    };

    public a(Context context) {
        this.context = context;
    }

    public void dIU() {
        String dIX = dIX();
        if (!TextUtils.isEmpty(dIX)) {
            stop();
            if (c.SD(dIX) && G(dIX, "instant", true)) {
                this.nlf = true;
            }
        }
    }

    public void dIV() {
        stop();
    }

    public boolean dIW() {
        return this.nlf;
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
            this.nld.a(null);
            this.nld = null;
        }
        if (this.nld != null) {
            this.nld.dIZ();
        }
        this.nlf = false;
    }

    private boolean G(String str, String str2, boolean z) {
        if (this.nld == null) {
            SC(str);
            this.nld = new b(str, str2, z);
            this.nld.a(this.nlg);
            try {
                this.nld.start();
                return true;
            } catch (IllegalThreadStateException e) {
                return true;
            } catch (Exception e2) {
                this.nld = null;
                BdLog.e(e2);
                return false;
            }
        }
        return true;
    }

    private void SC(String str) {
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

    private String dIX() {
        if (!TextUtils.isEmpty(this.nle)) {
            return this.nle;
        }
        this.nle = c.dJb();
        if (TextUtils.isEmpty(this.nle)) {
            this.nle = c.dJc();
        } else if (!this.nle.endsWith(File.separator)) {
            this.nle += File.separator;
        }
        return this.nle;
    }
}
