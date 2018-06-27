package com.baidu.tieba.pb.pb.main;
/* loaded from: classes2.dex */
public class PbNormalLikeButtonSwitchStatic extends com.baidu.tbadk.o.j {
    private static final PbNormalLikeButtonSwitchStatic fCM;
    private final String fCL = "android_pb_normal_like_btn";

    static {
        com.baidu.adp.lib.b.d.hv().f(PbNormalLikeButtonSwitchStatic.class);
        fCM = new PbNormalLikeButtonSwitchStatic();
    }

    public static boolean Lc() {
        return fCM.ip();
    }

    @Override // com.baidu.tbadk.o.j, com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_pb_normal_like_btn";
    }
}
