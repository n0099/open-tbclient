package com.baidu.tieba.pb.pb.main;
/* loaded from: classes4.dex */
public class PbNormalLikeButtonSwitchStatic extends com.baidu.tbadk.s.j {
    private static final PbNormalLikeButtonSwitchStatic hub;
    private final String hua = "android_pb_normal_like_btn";

    static {
        com.baidu.adp.lib.b.d.iQ().i(PbNormalLikeButtonSwitchStatic.class);
        hub = new PbNormalLikeButtonSwitchStatic();
    }

    public static boolean apE() {
        return hub.jK();
    }

    @Override // com.baidu.tbadk.s.j, com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_pb_normal_like_btn";
    }
}
