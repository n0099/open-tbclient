package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.switchs.BaseNormalSwitchStatic;
/* loaded from: classes.dex */
public class PbNormalLikeButtonSwitchStatic extends BaseNormalSwitchStatic {
    private static final PbNormalLikeButtonSwitchStatic dSl;
    private final String dSk = "android_pb_normal_like_btn";

    static {
        com.baidu.adp.lib.c.e.cT().n(PbNormalLikeButtonSwitchStatic.class);
        dSl = new PbNormalLikeButtonSwitchStatic();
    }

    public static boolean Fq() {
        return dSl.ed();
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitchStatic, com.baidu.adp.lib.c.a
    protected String getName() {
        return "android_pb_normal_like_btn";
    }
}
