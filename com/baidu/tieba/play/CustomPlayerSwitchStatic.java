package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class CustomPlayerSwitchStatic extends com.baidu.adp.lib.b.a {
    private static int gtg;

    static {
        com.baidu.adp.lib.b.d.iR().i(CustomPlayerSwitchStatic.class);
        gtg = 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected void Z(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_custom_player_enabled_2";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] iH() {
        return new String[0];
    }

    @Override // com.baidu.adp.lib.b.a
    protected int iI() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int iJ() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int iK() {
        return 10;
    }

    public static void sx(int i) {
        gtg = i;
    }

    public static int bpw() {
        return gtg;
    }
}
