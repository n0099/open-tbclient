package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class CustomPlayerSwitchStatic extends com.baidu.adp.lib.b.a {
    private static int gFr;

    static {
        com.baidu.adp.lib.b.d.iQ().i(CustomPlayerSwitchStatic.class);
        gFr = 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected void aq(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_custom_player_enabled_2";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] iG() {
        return new String[0];
    }

    @Override // com.baidu.adp.lib.b.a
    protected int iH() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int iI() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int iJ() {
        return 10;
    }

    public static void tB(int i) {
        gFr = i;
    }

    public static int bse() {
        return gFr;
    }
}
