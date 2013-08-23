package com.baidu.tieba.switchs.features;

import com.baidu.tieba.switchs.SwitchKey;
/* loaded from: classes.dex */
public class TencentMMSwitch extends AbstractSwitch {
    public static final int MM_DEFAULT_TYPE = 0;
    public static final int MM_OFF_TYPE = 1;

    @Override // com.baidu.tieba.switchs.features.AbstractSwitch
    protected void initData() {
        this.mName = SwitchKey.MM;
        this.mKey = SwitchKey.MM_KEY;
    }

    @Override // com.baidu.tieba.switchs.features.AbstractSwitch
    protected void changeSettingByType(int i) {
    }
}
