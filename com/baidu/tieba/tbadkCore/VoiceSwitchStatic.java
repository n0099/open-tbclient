package com.baidu.tieba.tbadkCore;
/* loaded from: classes.dex */
public class VoiceSwitchStatic extends com.baidu.adp.lib.b.a {
    public static final String[] cQL;

    static {
        com.baidu.adp.lib.b.e.gv().e(VoiceSwitchStatic.class);
        cQL = new String[]{"com.baidu.tieba.voice"};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.b.a
    public void changeSettingByType(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected void initData() {
        this.mName = "voice";
        this.mKey = cQL;
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "voice";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] getCrashKeys() {
        return cQL;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int getDefaultType() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int getOffType() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int getMaxCrashTimes() {
        return 10;
    }
}
