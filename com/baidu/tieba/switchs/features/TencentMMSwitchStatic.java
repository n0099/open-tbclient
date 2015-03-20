package com.baidu.tieba.switchs.features;

import com.baidu.adp.lib.b.a;
import com.baidu.adp.lib.b.f;
/* loaded from: classes.dex */
public class TencentMMSwitchStatic extends a {
    public static final String MM = "tencent_mm";
    public static final int MM_DEFAULT_TYPE = 0;
    public static final String[] MM_KEY;
    public static final int MM_OFF_TYPE = 1;

    static {
        f.gz().l(TencentMMSwitchStatic.class);
        MM_KEY = new String[]{"com.tencent.mm"};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.b.a
    public void changeSettingByType(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return MM;
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] getCrashKeys() {
        return MM_KEY;
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
        return 10;
    }
}
