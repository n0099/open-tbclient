package com.baidu.tieba.media;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.tieba.media.MediaPlayerActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaPlayerActivity f1933a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(MediaPlayerActivity mediaPlayerActivity, Looper looper) {
        super(looper);
        this.f1933a = mediaPlayerActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Object obj;
        c cVar;
        String str;
        h hVar;
        String str2;
        int i;
        h hVar2;
        h hVar3;
        int i2;
        c cVar2;
        String str3;
        h hVar4;
        c cVar3;
        MediaPlayerActivity.PLAYER_STATUS player_status;
        Object obj2;
        switch (message.what) {
            case 0:
                obj = this.f1933a.g;
                synchronized (obj) {
                    while (true) {
                        try {
                            player_status = this.f1933a.n;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (player_status != MediaPlayerActivity.PLAYER_STATUS.PLAYER_IDLE) {
                            obj2 = this.f1933a.g;
                            obj2.wait();
                        } else {
                            com.baidu.adp.lib.h.e.e("wait player status to idle");
                        }
                    }
                }
                cVar = this.f1933a.c;
                str = this.f1933a.d;
                if (cVar.b(str)) {
                    cVar2 = this.f1933a.c;
                    str3 = this.f1933a.d;
                    cVar2.a(str3);
                    hVar4 = this.f1933a.b;
                    StringBuilder append = new StringBuilder().append("p2p://");
                    cVar3 = this.f1933a.c;
                    hVar4.a(append.append(cVar3.d()).toString());
                } else {
                    hVar = this.f1933a.b;
                    str2 = this.f1933a.d;
                    hVar.a(str2);
                }
                i = this.f1933a.h;
                if (i > 0) {
                    hVar3 = this.f1933a.b;
                    i2 = this.f1933a.h;
                    hVar3.a(i2);
                    this.f1933a.h = 0;
                }
                hVar2 = this.f1933a.b;
                hVar2.e();
                this.f1933a.n = MediaPlayerActivity.PLAYER_STATUS.PLAYER_PREPARING;
                return;
            default:
                return;
        }
    }
}
