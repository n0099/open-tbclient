package com.baidu.tieba.media;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.tieba.media.MediaPlayerActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends Handler {
    final /* synthetic */ MediaPlayerActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(MediaPlayerActivity mediaPlayerActivity, Looper looper) {
        super(looper);
        this.a = mediaPlayerActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        MediaPlayerActivity.PLAYER_STATUS player_status;
        l lVar;
        String str;
        q qVar;
        String str2;
        int i;
        q qVar2;
        q qVar3;
        int i2;
        l lVar2;
        String str3;
        q qVar4;
        l lVar3;
        Object obj;
        Object obj2;
        switch (message.what) {
            case 0:
                player_status = this.a.n;
                if (player_status != MediaPlayerActivity.PLAYER_STATUS.PLAYER_IDLE) {
                    obj = this.a.g;
                    synchronized (obj) {
                        try {
                            obj2 = this.a.g;
                            obj2.wait();
                            com.baidu.adp.lib.c.b.d("wait player status to idle");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                lVar = this.a.c;
                str = this.a.d;
                if (!lVar.b(str)) {
                    qVar = this.a.b;
                    str2 = this.a.d;
                    qVar.a(str2);
                } else {
                    lVar2 = this.a.c;
                    str3 = this.a.d;
                    lVar2.a(str3);
                    qVar4 = this.a.b;
                    StringBuilder sb = new StringBuilder("p2p://");
                    lVar3 = this.a.c;
                    qVar4.a(sb.append(lVar3.d()).toString());
                }
                i = this.a.h;
                if (i > 0) {
                    qVar3 = this.a.b;
                    i2 = this.a.h;
                    qVar3.a(i2);
                    this.a.h = 0;
                }
                qVar2 = this.a.b;
                qVar2.e();
                this.a.n = MediaPlayerActivity.PLAYER_STATUS.PLAYER_PREPARING;
                return;
            default:
                return;
        }
    }
}
