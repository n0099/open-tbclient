package com.baidu.tieba.pb.pb.main;
/* loaded from: classes2.dex */
public class PbNormalLikeButtonSwitchStatic extends com.baidu.tbadk.o.j {
    private static final PbNormalLikeButtonSwitchStatic fSo;
    private final String fSn = "android_pb_normal_like_btn";

    static {
        com.baidu.adp.lib.b.d.mA().f(PbNormalLikeButtonSwitchStatic.class);
        fSo = new PbNormalLikeButtonSwitchStatic();
    }

    public static boolean OP() {
        return fSo.nv();
    }

    @Override // com.baidu.tbadk.o.j, com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_pb_normal_like_btn";
    }
}
