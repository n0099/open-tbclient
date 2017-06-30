package com.baidu.tieba.play;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tieba.play.a.b;
import com.baidu.tieba.play.v;
/* loaded from: classes.dex */
class aj implements b.InterfaceC0080b {
    final /* synthetic */ QuickVideoView flO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(QuickVideoView quickVideoView) {
        this.flO = quickVideoView;
    }

    @Override // com.baidu.tieba.play.a.b.InterfaceC0080b
    public void bS(String str, String str2) {
        v.b bVar;
        v.b bVar2;
        v.b bVar3;
        v.b bVar4;
        Uri uri;
        Uri uri2;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                uri = this.flO.mUri;
                if (uri != null) {
                    uri2 = this.flO.mUri;
                    if (str2.equals(uri2.getHost())) {
                        this.flO.bR(str, str2);
                    }
                }
                this.flO.fly = null;
            } else {
                bVar3 = this.flO.aSy;
                if (bVar3 != null) {
                    bVar4 = this.flO.aSy;
                    bVar4.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            bVar = this.flO.aSy;
            if (bVar != null) {
                bVar2 = this.flO.aSy;
                bVar2.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
            }
        }
    }
}
