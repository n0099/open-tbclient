package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.switchs.BaseNormalSwitchStatic;
/* loaded from: classes.dex */
public class PbNormalLikeButtonSwitchStatic extends BaseNormalSwitchStatic {
    private static final PbNormalLikeButtonSwitchStatic esH;
    private final String esG = "android_pb_normal_like_btn";

    static {
        com.baidu.adp.lib.c.e.dN().n(PbNormalLikeButtonSwitchStatic.class);
        esH = new PbNormalLikeButtonSwitchStatic();
    }

    public static boolean GK() {
        return esH.eX();
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitchStatic, com.baidu.adp.lib.c.a
    protected String getName() {
        return "android_pb_normal_like_btn";
    }
}
