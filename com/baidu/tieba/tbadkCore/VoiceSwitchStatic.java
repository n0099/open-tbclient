package com.baidu.tieba.tbadkCore;
/* loaded from: classes.dex */
public class VoiceSwitchStatic extends com.baidu.adp.lib.c.a {
    public static final String[] eoJ;

    static {
        com.baidu.adp.lib.c.e.gE().f(VoiceSwitchStatic.class);
        eoJ = new String[]{"com.baidu.tieba.voice"};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.c.a
    public void changeSettingByType(int i) {
    }

    @Override // com.baidu.adp.lib.c.a
    protected void initData() {
        this.mName = "voice";
        this.mKey = eoJ;
    }

    @Override // com.baidu.adp.lib.c.a
    protected String getName() {
        return "voice";
    }

    @Override // com.baidu.adp.lib.c.a
    protected String[] getCrashKeys() {
        return eoJ;
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
