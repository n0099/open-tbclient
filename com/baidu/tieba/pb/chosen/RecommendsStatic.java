package com.baidu.tieba.pb.chosen;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.util.bf;
/* loaded from: classes.dex */
public class RecommendsStatic {
    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(PbChosenActivityConfig.class, PbChosenActivity.class);
        IC();
    }

    private static void IC() {
        bf.vD().a(new ab());
    }
}
