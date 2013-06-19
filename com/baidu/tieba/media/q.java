package com.baidu.tieba.media;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends Handler {
    final /* synthetic */ MediaPlayerActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(MediaPlayerActivity mediaPlayerActivity, Looper looper) {
        super(looper);
        this.a = mediaPlayerActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        s sVar;
        n nVar;
        String str;
        t tVar;
        String str2;
        int i;
        t tVar2;
        t tVar3;
        int i2;
        n nVar2;
        String str3;
        t tVar4;
        n nVar3;
        Object obj;
        Object obj2;
        switch (message.what) {
            case 0:
                sVar = this.a.n;
                if (sVar != s.PLAYER_IDLE) {
                    obj = this.a.g;
                    synchronized (obj) {
                        try {
                            obj2 = this.a.g;
                            obj2.wait();
                            com.baidu.adp.lib.e.b.d("wait player status to idle");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                nVar = this.a.c;
                str = this.a.d;
                if (!nVar.b(str)) {
                    tVar = this.a.b;
                    str2 = this.a.d;
                    tVar.a(str2);
                } else {
                    nVar2 = this.a.c;
                    str3 = this.a.d;
                    nVar2.a(str3);
                    tVar4 = this.a.b;
                    StringBuilder sb = new StringBuilder("p2p://");
                    nVar3 = this.a.c;
                    tVar4.a(sb.append(nVar3.d()).toString());
                }
                i = this.a.h;
                if (i > 0) {
                    tVar3 = this.a.b;
                    i2 = this.a.h;
                    tVar3.a(i2);
                    this.a.h = 0;
                }
                tVar2 = this.a.b;
                tVar2.e();
                this.a.n = s.PLAYER_PREPARING;
                return;
            default:
                return;
        }
    }
}
