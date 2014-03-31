package com.baidu.tieba.switchs.features;

import com.baidu.adp.lib.a.a;
import com.baidu.adp.lib.a.f;
/* loaded from: classes.dex */
public class BarDetailForDirSwitchStatic extends a {
    public static final String BAR_DETAIL_DIR = "bar_detail";
    public static final int DEFAULT_TYPE = 0;
    public static final int OFF_TYPE = 1;

    static {
        f.a();
        f.a(BarDetailForDirSwitchStatic.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void changeSettingByType(int i) {
    }

    @Override // com.baidu.adp.lib.a.a
    protected void initData() {
        this.mName = BAR_DETAIL_DIR;
    }
}
