package com.baidu.tieba.pb.video;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements v.b {
    final /* synthetic */ d euY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(d dVar) {
        this.euY = dVar;
    }

    @Override // com.baidu.tieba.play.v.b
    public boolean onError(com.baidu.tieba.play.v vVar, int i, int i2) {
        String str;
        TiebaStatic.log(new as("c12029").s("errno", i).s("extra", i2));
        BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
        str = this.euY.mVideoUrl;
        bdStatisticsManager.newDebug("videoplay", 0L, null, "errno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", str);
        return true;
    }
}
