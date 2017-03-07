package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
public class PbNormalLikeButtonSwitchStatic extends com.baidu.tbadk.switchs.i {
    private static final PbNormalLikeButtonSwitchStatic epa;
    private final String eoZ = "android_pb_normal_like_btn";

    static {
        com.baidu.adp.lib.b.e.eT().m(PbNormalLikeButtonSwitchStatic.class);
        epa = new PbNormalLikeButtonSwitchStatic();
    }

    public static boolean GB() {
        return epa.fP();
    }

    @Override // com.baidu.tbadk.switchs.i, com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_pb_normal_like_btn";
    }
}
