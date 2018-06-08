package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class CustomPlayerSwitchStatic extends com.baidu.adp.lib.b.a {
    private static int fZY;

    static {
        com.baidu.adp.lib.b.d.hv().f(CustomPlayerSwitchStatic.class);
        fZY = 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected void R(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_custom_player_enabled_2";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] hm() {
        return new String[0];
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hn() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ho() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hp() {
        return 10;
    }

    public static void rx(int i) {
        fZY = i;
    }

    public static int bkP() {
        return fZY;
    }
}
