package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class CustomPlayerSwitchStatic extends com.baidu.adp.lib.c.a {
    private static int eYm;

    static {
        com.baidu.adp.lib.c.e.dN().n(CustomPlayerSwitchStatic.class);
        eYm = 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.c.a
    public void changeSettingByType(int i) {
    }

    @Override // com.baidu.adp.lib.c.a
    protected String getName() {
        return "android_custom_player_enabled";
    }

    @Override // com.baidu.adp.lib.c.a
    protected String[] getCrashKeys() {
        return new String[0];
    }

    @Override // com.baidu.adp.lib.c.a
    protected int getDefaultType() {
        return 1;
    }

    @Override // com.baidu.adp.lib.c.a
    protected int getOffType() {
        return 0;
    }

    @Override // com.baidu.adp.lib.c.a
    protected int getMaxCrashTimes() {
        return 10;
    }

    public static void qu(int i) {
        eYm = i;
    }

    public static int bah() {
        return eYm;
    }
}
