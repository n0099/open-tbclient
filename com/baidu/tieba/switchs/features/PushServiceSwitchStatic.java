package com.baidu.tieba.switchs.features;

import com.baidu.adp.lib.a.a;
import com.baidu.adp.lib.a.f;
/* loaded from: classes.dex */
public class PushServiceSwitchStatic extends a {
    public static final int DEFAULT_TYPE = 0;
    public static final int OFF_TYPE = 1;
    public static final String PUSHSERVICE = "push_service_sdk";
    public static final String[] PUSHSERVICE_KEY;

    static {
        f.a();
        f.a(PushServiceSwitchStatic.class);
        PUSHSERVICE_KEY = new String[]{"com.baidu.android.pushservice", "com.baidu.android.moplus", "com.baidu.android.nebula", "com.baidu.android.systemmonitor", "com.baidu.loc.strWebApp"};
    }

    @Override // com.baidu.adp.lib.a.a
    protected void initData() {
        this.mName = PUSHSERVICE;
        this.mKey = PUSHSERVICE_KEY;
        this.mCrashTimes = 20;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void changeSettingByType(int i) {
    }
}
