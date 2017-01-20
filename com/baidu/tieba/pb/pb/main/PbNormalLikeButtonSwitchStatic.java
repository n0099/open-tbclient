package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.switchs.BaseNormalSwitchStatic;
/* loaded from: classes.dex */
public class PbNormalLikeButtonSwitchStatic extends BaseNormalSwitchStatic {
    private static final PbNormalLikeButtonSwitchStatic emd;
    private final String emc = "android_pb_normal_like_btn";

    static {
        com.baidu.adp.lib.b.e.dL().n(PbNormalLikeButtonSwitchStatic.class);
        emd = new PbNormalLikeButtonSwitchStatic();
    }

    public static boolean Gc() {
        return emd.eV();
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitchStatic, com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_pb_normal_like_btn";
    }
}
