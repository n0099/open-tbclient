package com.baidu.tieba.play;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.v;
/* loaded from: classes.dex */
class af implements v.d {
    final /* synthetic */ QuickVideoView fby;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(QuickVideoView quickVideoView) {
        this.fby = quickVideoView;
    }

    @Override // com.baidu.tieba.play.v.d
    public void onPrepared(v vVar) {
        v.d dVar;
        QuickVideoView.a aVar;
        boolean z;
        ao aoVar;
        String str;
        Uri uri;
        Uri uri2;
        String uri3;
        String str2;
        Uri uri4;
        Uri uri5;
        String uri6;
        String str3;
        ao aoVar2;
        int i;
        QuickVideoView.a aVar2;
        v.d dVar2;
        dVar = this.fby.aRe;
        if (dVar != null) {
            dVar2 = this.fby.aRe;
            dVar2.onPrepared(vVar);
        }
        aVar = this.fby.fbm;
        if (aVar != null) {
            aVar2 = this.fby.fbm;
            aVar2.Ji();
        }
        z = this.fby.fbl;
        if (z) {
            this.fby.start();
        }
        aoVar = this.fby.fbh;
        if (aoVar != null && vVar != null) {
            aoVar2 = this.fby.fbh;
            int videoWidth = vVar.getVideoWidth();
            int videoHeight = vVar.getVideoHeight();
            i = this.fby.fbo;
            aoVar2.N(videoWidth, videoHeight, i);
        }
        str = this.fby.fbi;
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c12199");
            uri = this.fby.mUri;
            if (uri == null) {
                uri3 = "null";
            } else {
                uri2 = this.fby.mUri;
                uri3 = uri2.toString();
            }
            com.baidu.tbadk.core.util.as Z = asVar.Z("obj_param1", uri3);
            str2 = this.fby.fbi;
            TiebaStatic.log(Z.Z("obj_param2", str2).Z("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
            BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
            Object[] objArr = new Object[6];
            objArr[0] = "url";
            uri4 = this.fby.mUri;
            if (uri4 == null) {
                uri6 = "null";
            } else {
                uri5 = this.fby.mUri;
                uri6 = uri5.toString();
            }
            objArr[1] = uri6;
            objArr[2] = "dnsIP";
            str3 = this.fby.fbi;
            objArr[3] = str3;
            objArr[4] = "clientip";
            objArr[5] = com.baidu.tbadk.core.util.d.getIp();
            bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
        }
    }
}
