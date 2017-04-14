package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class CustomPlayerSwitchStatic extends com.baidu.adp.lib.b.a {
    private static int eTJ;

    static {
        com.baidu.adp.lib.b.e.eY().f(CustomPlayerSwitchStatic.class);
        eTJ = 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.b.a
    public void X(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_custom_player_enabled_2";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] eP() {
        return new String[0];
    }

    @Override // com.baidu.adp.lib.b.a
    protected int eQ() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int eR() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int eS() {
        return 10;
    }

    public static void qu(int i) {
        eTJ = i;
    }

    public static int aXK() {
        return eTJ;
    }
}
