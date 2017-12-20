package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class CustomPlayerSwitchStatic extends com.baidu.adp.lib.b.a {
    private static int fOM;

    static {
        com.baidu.adp.lib.b.d.eV().f(CustomPlayerSwitchStatic.class);
        fOM = 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected void W(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_custom_player_enabled_2";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] eM() {
        return new String[0];
    }

    @Override // com.baidu.adp.lib.b.a
    protected int eN() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int eO() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int eP() {
        return 10;
    }

    public static void sv(int i) {
        fOM = i;
    }

    public static int biP() {
        return fOM;
    }
}
