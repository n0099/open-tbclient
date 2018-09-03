package com.baidu.tieba.pb.pb.main;
/* loaded from: classes2.dex */
public class PbNormalLikeButtonSwitchStatic extends com.baidu.tbadk.p.j {
    private static final PbNormalLikeButtonSwitchStatic fCS;
    private final String fCR = "android_pb_normal_like_btn";

    static {
        com.baidu.adp.lib.b.d.hv().f(PbNormalLikeButtonSwitchStatic.class);
        fCS = new PbNormalLikeButtonSwitchStatic();
    }

    public static boolean Lb() {
        return fCS.iq();
    }

    @Override // com.baidu.tbadk.p.j, com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_pb_normal_like_btn";
    }
}
