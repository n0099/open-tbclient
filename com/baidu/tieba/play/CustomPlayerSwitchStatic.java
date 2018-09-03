package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class CustomPlayerSwitchStatic extends com.baidu.adp.lib.b.a {
    private static int geq;

    static {
        com.baidu.adp.lib.b.d.hv().f(CustomPlayerSwitchStatic.class);
        geq = 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected void R(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_custom_player_enabled_2";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] hl() {
        return new String[0];
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hm() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hn() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ho() {
        return 10;
    }

    public static void rD(int i) {
        geq = i;
    }

    public static int bjK() {
        return geq;
    }
}
