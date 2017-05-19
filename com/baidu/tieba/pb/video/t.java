package com.baidu.tieba.pb.video;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements v.b {
    final /* synthetic */ g esY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(g gVar) {
        this.esY = gVar;
    }

    @Override // com.baidu.tieba.play.v.b
    public boolean onError(com.baidu.tieba.play.v vVar, int i, int i2) {
        String str;
        TiebaStatic.log(new as("c12029").s("verrno", i).s("extra", i2));
        BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
        str = this.esY.mVideoUrl;
        bdStatisticsManager.newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", str);
        return true;
    }
}
