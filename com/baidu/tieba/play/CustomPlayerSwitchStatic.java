package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class CustomPlayerSwitchStatic extends com.baidu.adp.lib.b.a {
    private static int fNG;

    static {
        com.baidu.adp.lib.b.d.eE().f(CustomPlayerSwitchStatic.class);
        fNG = 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected void Q(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_custom_player_enabled_2";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] ev() {
        return new String[0];
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ew() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ex() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ey() {
        return 10;
    }

    public static void rm(int i) {
        fNG = i;
    }

    public static int bfR() {
        return fNG;
    }
}
