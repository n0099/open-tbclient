package com.baidu.tieba.switchs.features;

import com.baidu.adp.lib.a.a;
import com.baidu.adp.lib.a.f;
/* loaded from: classes.dex */
public class ImgLogSwitchStatic extends a {
    public static final String IMG_LOG = "img_log";
    public static final int OFF_TYPE = 1;
    public static final int ON_TYPE = 0;

    static {
        f.a().a(ImgLogSwitchStatic.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void changeSettingByType(int i) {
    }

    @Override // com.baidu.adp.lib.a.a
    protected void initData() {
        this.mDefaultType = 1;
        this.mName = IMG_LOG;
    }
}
