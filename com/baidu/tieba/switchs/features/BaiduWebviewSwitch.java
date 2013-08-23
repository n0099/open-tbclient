package com.baidu.tieba.switchs.features;

import com.baidu.tieba.switchs.SwitchKey;
/* loaded from: classes.dex */
public class BaiduWebviewSwitch extends AbstractSwitch {
    public static final int BAIDU_WEBVIEW_DEFAULT_TYPE = 0;
    public static final int BAIDU_WEBVIEW_EXTERNAL_TYPE = 2;
    public static final int BAIDU_WEBVIEW_OFF_TYPE = 1;

    @Override // com.baidu.tieba.switchs.features.AbstractSwitch
    protected void initData() {
        this.mName = SwitchKey.BAIDU_WEBVIEW;
        this.mKey = SwitchKey.BAIDU_WEBVIEW_KEY;
    }

    @Override // com.baidu.tieba.switchs.features.AbstractSwitch
    protected void changeSettingByType(int i) {
    }
}
