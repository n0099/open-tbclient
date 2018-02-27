package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class CustomPlayerSwitchStatic extends com.baidu.adp.lib.b.a {
    private static int gsK;

    static {
        com.baidu.adp.lib.b.d.mA().f(CustomPlayerSwitchStatic.class);
        gsK = 1;
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

    public static void tP(int i) {
        gsK = i;
    }

    public static int bkM() {
        return gsK;
    }
}
