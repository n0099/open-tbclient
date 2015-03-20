package com.baidu.tieba.switchs.features;

import com.baidu.adp.lib.b.a;
import com.baidu.adp.lib.b.f;
/* loaded from: classes.dex */
public class PushServiceSwitchStatic extends a {
    public static final int DEFAULT_TYPE = 0;
    public static final int OFF_TYPE = 1;
    public static final String PUSHSERVICE = "push_service_sdk";
    public static final String[] PUSHSERVICE_KEY;

    static {
        f.gz().l(PushServiceSwitchStatic.class);
        PUSHSERVICE_KEY = new String[]{"com.baidu.android.pushservice", "com.baidu.android.moplus", "com.baidu.android.nebula", "com.baidu.android.systemmonitor", "com.baidu.loc.strWebApp"};
    }

    @Override // com.baidu.adp.lib.b.a
    protected void initData() {
        this.mName = PUSHSERVICE;
        this.mKey = PUSHSERVICE_KEY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.b.a
    public void changeSettingByType(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return PUSHSERVICE;
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] getCrashKeys() {
        return PUSHSERVICE_KEY;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int getDefaultType() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int getOffType() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int getMaxCrashTimes() {
        return 20;
    }
}
