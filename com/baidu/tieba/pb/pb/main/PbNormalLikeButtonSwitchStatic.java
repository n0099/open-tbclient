package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.switchs.BaseNormalSwitchStatic;
/* loaded from: classes.dex */
public class PbNormalLikeButtonSwitchStatic extends BaseNormalSwitchStatic {
    private static final PbNormalLikeButtonSwitchStatic eyZ;
    private final String eyY = "android_pb_normal_like_btn";

    static {
        com.baidu.adp.lib.c.e.dN().n(PbNormalLikeButtonSwitchStatic.class);
        eyZ = new PbNormalLikeButtonSwitchStatic();
    }

    public static boolean GN() {
        return eyZ.eX();
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitchStatic, com.baidu.adp.lib.c.a
    protected String getName() {
        return "android_pb_normal_like_btn";
    }
}
