package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class CustomPlayerSwitchStatic extends com.baidu.adp.lib.b.a {
    private static int fAj;

    static {
        com.baidu.adp.lib.b.d.eW().f(CustomPlayerSwitchStatic.class);
        fAj = 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected void X(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_custom_player_enabled_2";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] eN() {
        return new String[0];
    }

    @Override // com.baidu.adp.lib.b.a
    protected int eO() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int eP() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int eQ() {
        return 10;
    }

    public static void rL(int i) {
        fAj = i;
    }

    public static int bfv() {
        return fAj;
    }
}
