package com.baidu.tieba.switchs.features;

import com.baidu.adp.lib.a.a;
import com.baidu.adp.lib.a.f;
/* loaded from: classes.dex */
public class VoiceSwitchStatic extends a {
    public static final int DEFAULT_TYPE = 0;
    public static final int OFF_TYPE = 1;
    public static final String VOICE = "voice";
    public static final String[] VOICE_KEY;

    static {
        f.a();
        f.a(VoiceSwitchStatic.class);
        VOICE_KEY = new String[]{"com.baidu.tieba.voice"};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void changeSettingByType(int i) {
    }

    @Override // com.baidu.adp.lib.a.a
    protected void initData() {
        this.mName = VOICE;
        this.mKey = VOICE_KEY;
    }
}
