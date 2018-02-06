package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class CustomPlayerSwitchStatic extends com.baidu.adp.lib.b.a {
    private static int gsV;

    static {
        com.baidu.adp.lib.b.d.mA().f(CustomPlayerSwitchStatic.class);
        gsV = 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected void cQ(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_custom_player_enabled_2";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] mr() {
        return new String[0];
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ms() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int mt() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int mu() {
        return 10;
    }

    public static void tO(int i) {
        gsV = i;
    }

    public static int bkN() {
        return gsV;
    }
}
