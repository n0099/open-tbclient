package com.baidu.tieba.switchs.features;

import com.baidu.adp.lib.b.a;
import com.baidu.adp.lib.b.e;
/* loaded from: classes.dex */
public class ImgLogSwitchStatic extends a {
    public static final String IMG_LOG = "img_log";
    public static final int OFF_TYPE = 1;
    public static final int ON_TYPE = 0;

    static {
        e.gy().e(ImgLogSwitchStatic.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.b.a
    public void changeSettingByType(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return IMG_LOG;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int getDefaultType() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int getOffType() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] getCrashKeys() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int getMaxCrashTimes() {
        return 10;
    }
}
