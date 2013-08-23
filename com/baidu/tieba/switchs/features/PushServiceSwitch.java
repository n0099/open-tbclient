package com.baidu.tieba.switchs.features;

import com.baidu.tieba.switchs.SwitchKey;
/* loaded from: classes.dex */
public class PushServiceSwitch extends AbstractSwitch {
    public static final int DEFAULT_TYPE = 0;
    public static final int OFF_TYPE = 1;

    @Override // com.baidu.tieba.switchs.features.AbstractSwitch
    protected void initData() {
        this.mName = SwitchKey.PUSHSERVICE;
        this.mKey = SwitchKey.PUSHSERVICE_KEY;
        this.mCrashTimes = 20;
    }

    @Override // com.baidu.tieba.switchs.features.AbstractSwitch
    protected void changeSettingByType(int i) {
    }
}
