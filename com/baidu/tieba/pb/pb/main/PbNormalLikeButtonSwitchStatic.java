package com.baidu.tieba.pb.pb.main;
/* loaded from: classes2.dex */
public class PbNormalLikeButtonSwitchStatic extends com.baidu.tbadk.o.j {
    private static final PbNormalLikeButtonSwitchStatic fPb;
    private final String fPa = "android_pb_normal_like_btn";

    static {
        com.baidu.adp.lib.b.d.mA().f(PbNormalLikeButtonSwitchStatic.class);
        fPb = new PbNormalLikeButtonSwitchStatic();
    }

    public static boolean Ok() {
        return fPb.nv();
    }

    @Override // com.baidu.tbadk.o.j, com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_pb_normal_like_btn";
    }
}
