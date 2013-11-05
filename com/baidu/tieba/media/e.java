package com.baidu.tieba.media;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.baidu.tieba.media.MediaDownloadHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaDownloadHelper f1833a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MediaDownloadHelper mediaDownloadHelper) {
        this.f1833a = mediaDownloadHelper;
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
                aVar13 = this.f1833a.f1825a;
                aVar13.a(message.arg1, message.arg2);
                return;
            case 1:
                switch (message.arg1) {
                    case 1:
                    case 9:
                        aVar11 = this.f1833a.f1825a;
                        aVar11.h();
                        aVar12 = this.f1833a.f1825a;
                        aVar12.e();
                        return;
                    case 2:
                    case 3:
                    default:
                        return;
                    case 4:
                        aVar5 = this.f1833a.f1825a;
                        aVar5.h();
                        aVar6 = this.f1833a.f1825a;
                        aVar6.f();
                        return;
                    case 5:
                        this.f1833a.g = MediaDownloadHelper.DOWNLOAD_STAT.PAUSE;
                        aVar3 = this.f1833a.f1825a;
                        aVar3.a();
                        aVar4 = this.f1833a.f1825a;
                        onClickListener2 = this.f1833a.i;
                        aVar4.a(onClickListener2);
                        return;
                    case 6:
                        aVar9 = this.f1833a.f1825a;
                        aVar9.h();
                        aVar10 = this.f1833a.f1825a;
                        aVar10.c();
                        return;
                    case 7:
                        this.f1833a.g = MediaDownloadHelper.DOWNLOAD_STAT.PAUSE;
                        aVar = this.f1833a.f1825a;
                        aVar.g();
                        aVar2 = this.f1833a.f1825a;
                        onClickListener = this.f1833a.i;
                        aVar2.a(onClickListener);
                        return;
                    case 8:
                        aVar7 = this.f1833a.f1825a;
                        aVar7.h();
                        aVar8 = this.f1833a.f1825a;
                        aVar8.d();
                        return;
                }
            default:
                return;
        }
    }
}
