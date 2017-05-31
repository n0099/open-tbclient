package com.baidu.tieba.pb.video;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements v.b {
    final /* synthetic */ l eAW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar) {
        this.eAW = lVar;
    }

    @Override // com.baidu.tieba.play.v.b
    public boolean onError(com.baidu.tieba.play.v vVar, int i, int i2) {
        String str;
        TiebaStatic.log(new as("c12029").r("verrno", i).r("extra", i2));
        BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
        str = this.eAW.mVideoUrl;
        bdStatisticsManager.newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", str);
        return true;
    }
}
