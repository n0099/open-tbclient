package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.switchs.BaseNormalSwitchStatic;
/* loaded from: classes.dex */
public class PbNormalLikeButtonSwitchStatic extends BaseNormalSwitchStatic {
    private static final PbNormalLikeButtonSwitchStatic edk;
    private final String edj = "android_pb_normal_like_btn";

    static {
        com.baidu.adp.lib.c.e.dN().n(PbNormalLikeButtonSwitchStatic.class);
        edk = new PbNormalLikeButtonSwitchStatic();
    }

    public static boolean Gj() {
        return edk.eX();
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitchStatic, com.baidu.adp.lib.c.a
    protected String getName() {
        return "android_pb_normal_like_btn";
    }
}
