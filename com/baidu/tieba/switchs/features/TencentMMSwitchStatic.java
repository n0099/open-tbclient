package com.baidu.tieba.switchs.features;

import com.baidu.adp.lib.a.a;
import com.baidu.adp.lib.a.f;
/* loaded from: classes.dex */
public class TencentMMSwitchStatic extends a {
    public static final String MM = "tencent_mm";
    public static final int MM_DEFAULT_TYPE = 0;
    public static final String[] MM_KEY;
    public static final int MM_OFF_TYPE = 1;

    static {
        f.a().a(TencentMMSwitchStatic.class);
        MM_KEY = new String[]{"com.tencent.mm"};
    }

    @Override // com.baidu.adp.lib.a.a
    protected void initData() {
        this.mName = MM;
        this.mKey = MM_KEY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void changeSettingByType(int i) {
    }
}
