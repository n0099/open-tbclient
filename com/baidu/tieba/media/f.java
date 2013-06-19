package com.baidu.tieba.media;

import android.os.Handler;
import android.os.Message;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends Handler {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.a = eVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar;
        a aVar2;
        View.OnClickListener onClickListener;
        a aVar3;
        a aVar4;
        View.OnClickListener onClickListener2;
        a aVar5;
        a aVar6;
        a aVar7;
        a aVar8;
        a aVar9;
        a aVar10;
        a aVar11;
        a aVar12;
        a aVar13;
        switch (message.what) {
            case 0:
                aVar13 = this.a.a;
                aVar13.a(message.arg1, message.arg2);
                return;
            case 1:
                switch (message.arg1) {
                    case 1:
                    case 9:
                        aVar11 = this.a.a;
                        aVar11.h();
                        aVar12 = this.a.a;
                        aVar12.e();
                        return;
                    case 2:
                    case 3:
                    default:
                        return;
                    case 4:
                        aVar5 = this.a.a;
                        aVar5.h();
                        aVar6 = this.a.a;
                        aVar6.f();
                        return;
                    case 5:
                        this.a.g = m.PAUSE;
                        aVar3 = this.a.a;
                        aVar3.a();
                        aVar4 = this.a.a;
                        onClickListener2 = this.a.i;
                        aVar4.a(onClickListener2);
                        return;
                    case 6:
                        aVar9 = this.a.a;
                        aVar9.h();
                        aVar10 = this.a.a;
                        aVar10.c();
                        return;
                    case 7:
                        this.a.g = m.PAUSE;
                        aVar = this.a.a;
                        aVar.g();
                        aVar2 = this.a.a;
                        onClickListener = this.a.i;
                        aVar2.a(onClickListener);
                        return;
                    case 8:
                        aVar7 = this.a.a;
                        aVar7.h();
                        aVar8 = this.a.a;
                        aVar8.d();
                        return;
                }
            default:
                return;
        }
    }
}
