package com.baidu.tieba.pb.video;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements v.b {
    final /* synthetic */ l eKu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar) {
        this.eKu = lVar;
    }

    @Override // com.baidu.tieba.play.v.b
    public boolean onError(com.baidu.tieba.play.v vVar, int i, int i2) {
        String str;
        TiebaStatic.log(new au("c12029").r("verrno", i).r("extra", i2));
        BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
        str = this.eKu.mVideoUrl;
        bdStatisticsManager.newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", str);
        return true;
    }
}
