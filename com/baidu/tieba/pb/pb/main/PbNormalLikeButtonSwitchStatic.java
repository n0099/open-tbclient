package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.switchs.BaseNormalSwitchStatic;
/* loaded from: classes.dex */
public class PbNormalLikeButtonSwitchStatic extends BaseNormalSwitchStatic {
    private static final PbNormalLikeButtonSwitchStatic eeC;
    private final String eeB = "android_pb_normal_like_btn";

    static {
        com.baidu.adp.lib.c.e.cS().n(PbNormalLikeButtonSwitchStatic.class);
        eeC = new PbNormalLikeButtonSwitchStatic();
    }

    public static boolean Fr() {
        return eeC.ec();
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitchStatic, com.baidu.adp.lib.c.a
    protected String getName() {
        return "android_pb_normal_like_btn";
    }
}
