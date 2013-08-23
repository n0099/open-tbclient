package com.baidu.tieba.switchs.features;

import com.baidu.tieba.switchs.SwitchKey;
/* loaded from: classes.dex */
public class MotuSwitch extends AbstractSwitch {
    public static final int DEFAULT_TYPE = 0;
    public static final int OFF_TYPE = 1;

    @Override // com.baidu.tieba.switchs.features.AbstractSwitch
    protected void changeSettingByType(int i) {
    }

    @Override // com.baidu.tieba.switchs.features.AbstractSwitch
    protected void initData() {
        this.mName = SwitchKey.MOTU;
        this.mKey = SwitchKey.MOTU_KEY;
    }
}
