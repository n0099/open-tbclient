package com.baidu.tieba.media;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.tieba.media.MediaPlayerActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaPlayerActivity f1843a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(MediaPlayerActivity mediaPlayerActivity, Looper looper) {
        super(looper);
        this.f1843a = mediaPlayerActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Object obj;
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
        MediaPlayerActivity.PLAYER_STATUS player_status;
        Object obj2;
        switch (message.what) {
            case 0:
                obj = this.f1843a.g;
                synchronized (obj) {
                    while (true) {
                        try {
                            player_status = this.f1843a.n;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (player_status != MediaPlayerActivity.PLAYER_STATUS.PLAYER_IDLE) {
                            obj2 = this.f1843a.g;
                            obj2.wait();
                        } else {
                            com.baidu.adp.lib.h.d.e("wait player status to idle");
                        }
                    }
                }
                lVar = this.f1843a.c;
                str = this.f1843a.d;
                if (lVar.b(str)) {
                    lVar2 = this.f1843a.c;
                    str3 = this.f1843a.d;
                    lVar2.a(str3);
                    qVar4 = this.f1843a.b;
                    StringBuilder append = new StringBuilder().append("p2p://");
                    lVar3 = this.f1843a.c;
                    qVar4.a(append.append(lVar3.d()).toString());
                } else {
                    qVar = this.f1843a.b;
                    str2 = this.f1843a.d;
                    qVar.a(str2);
                }
                i = this.f1843a.h;
                if (i > 0) {
                    qVar3 = this.f1843a.b;
                    i2 = this.f1843a.h;
                    qVar3.a(i2);
                    this.f1843a.h = 0;
                }
                qVar2 = this.f1843a.b;
                qVar2.e();
                this.f1843a.n = MediaPlayerActivity.PLAYER_STATUS.PLAYER_PREPARING;
                return;
            default:
                return;
        }
    }
}
