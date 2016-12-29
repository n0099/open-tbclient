package com.baidu.tieba.tbadkCore;
/* loaded from: classes.dex */
public class VoiceSwitchStatic extends com.baidu.adp.lib.c.a {
    public static final String[] ffB;

    static {
        com.baidu.adp.lib.c.e.dN().n(VoiceSwitchStatic.class);
        ffB = new String[]{"com.baidu.tieba.voice"};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.c.a
    public void changeSettingByType(int i) {
    }

    @Override // com.baidu.adp.lib.c.a
    protected void initData() {
        this.mName = "voice";
        this.mKey = ffB;
    }

    @Override // com.baidu.adp.lib.c.a
    protected String getName() {
        return "voice";
    }

    @Override // com.baidu.adp.lib.c.a
    protected String[] getCrashKeys() {
        return ffB;
    }

    @Override // com.baidu.adp.lib.c.a
    protected int getDefaultType() {
        return 0;
    }

    @Override // com.baidu.adp.lib.c.a
    protected int getOffType() {
        return 1;
    }

    @Override // com.baidu.adp.lib.c.a
    protected int getMaxCrashTimes() {
        return 10;
    }
}
