package com.baidu.tieba.switchs.features;

import com.baidu.adp.lib.a.a;
import com.baidu.adp.lib.a.f;
/* loaded from: classes.dex */
public class LogSwitchStatic extends a {
    public static final String LOG = "log_upload";
    public static final int OFF_TYPE = 1;
    public static final int ON_TYPE = 0;

    static {
        f.a();
        f.a(LogSwitchStatic.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void changeSettingByType(int i) {
    }

    @Override // com.baidu.adp.lib.a.a
    protected void initData() {
        this.mDefaultType = 1;
        this.mName = LOG;
    }
}
