package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class CustomPlayerSwitchStatic extends com.baidu.adp.lib.b.a {
    private static int fAT;

    static {
        com.baidu.adp.lib.b.d.fh().f(CustomPlayerSwitchStatic.class);
        fAT = 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected void aa(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_custom_player_enabled_2";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] eY() {
        return new String[0];
    }

    @Override // com.baidu.adp.lib.b.a
    protected int eZ() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int fa() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int fb() {
        return 10;
    }

    public static void rJ(int i) {
        fAT = i;
    }

    public static int bfZ() {
        return fAT;
    }
}
