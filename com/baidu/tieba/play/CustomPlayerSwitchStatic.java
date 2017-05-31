package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class CustomPlayerSwitchStatic extends com.baidu.adp.lib.b.a {
    private static int faK;

    static {
        com.baidu.adp.lib.b.e.eZ().f(CustomPlayerSwitchStatic.class);
        faK = 1;
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
    protected String[] eQ() {
        return new String[0];
    }

    @Override // com.baidu.adp.lib.b.a
    protected int eR() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int eS() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int eT() {
        return 10;
    }

    public static void qR(int i) {
        faK = i;
    }

    public static int aXB() {
        return faK;
    }
}
