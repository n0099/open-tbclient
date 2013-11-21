package com.baidu.tieba.switchs.features;

import com.baidu.tieba.switchs.SwitchKey;
/* loaded from: classes.dex */
public class LogSwitch extends AbstractSwitch {
    public static final int OFF_TYPE = 1;
    public static final int ON_TYPE = 0;

    @Override // com.baidu.tieba.switchs.features.AbstractSwitch
    protected void changeSettingByType(int i) {
    }

    @Override // com.baidu.tieba.switchs.features.AbstractSwitch
    protected void initData() {
        this.mDefaultType = 1;
        this.mName = SwitchKey.LOG;
    }
}
