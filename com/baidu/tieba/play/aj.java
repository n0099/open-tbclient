package com.baidu.tieba.play;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tieba.play.a.b;
import com.baidu.tieba.play.v;
/* loaded from: classes.dex */
class aj implements b.InterfaceC0077b {
    final /* synthetic */ QuickVideoView fby;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(QuickVideoView quickVideoView) {
        this.fby = quickVideoView;
    }

    @Override // com.baidu.tieba.play.a.b.InterfaceC0077b
    public void bO(String str, String str2) {
        v.b bVar;
        v.b bVar2;
        v.b bVar3;
        v.b bVar4;
        Uri uri;
        Uri uri2;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                uri = this.fby.mUri;
                if (uri != null) {
                    uri2 = this.fby.mUri;
                    if (str2.equals(uri2.getHost())) {
                        this.fby.bN(str, str2);
                    }
                }
                this.fby.fbi = null;
            } else {
                bVar3 = this.fby.aRf;
                if (bVar3 != null) {
                    bVar4 = this.fby.aRf;
                    bVar4.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            bVar = this.fby.aRf;
            if (bVar != null) {
                bVar2 = this.fby.aRf;
                bVar2.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
            }
        }
    }
}
