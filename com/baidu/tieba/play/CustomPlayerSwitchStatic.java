package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class CustomPlayerSwitchStatic extends com.baidu.adp.lib.b.a {
    private static int gBN;

    static {
        com.baidu.adp.lib.b.d.mz().f(CustomPlayerSwitchStatic.class);
        gBN = 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected void cQ(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_custom_player_enabled_2";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] mq() {
        return new String[0];
    }

    @Override // com.baidu.adp.lib.b.a
    protected int mr() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ms() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int mt() {
        return 10;
    }

    public static void vp(int i) {
        gBN = i;
    }

    public static int bqj() {
        return gBN;
    }
}
