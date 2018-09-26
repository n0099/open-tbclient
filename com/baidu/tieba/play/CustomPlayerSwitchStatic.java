package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class CustomPlayerSwitchStatic extends com.baidu.adp.lib.b.a {
    private static int glG;

    static {
        com.baidu.adp.lib.b.d.iB().i(CustomPlayerSwitchStatic.class);
        glG = 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected void Z(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_custom_player_enabled_2";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] ir() {
        return new String[0];
    }

    @Override // com.baidu.adp.lib.b.a
    protected int is() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int it() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int iu() {
        return 10;
    }

    public static void sa(int i) {
        glG = i;
    }

    public static int bml() {
        return glG;
    }
}
