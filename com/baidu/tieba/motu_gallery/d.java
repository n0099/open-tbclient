package com.baidu.tieba.motu_gallery;

import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class d implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ JigsawAlbumActivity f2023a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(JigsawAlbumActivity jigsawAlbumActivity) {
        this.f2023a = jigsawAlbumActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        l lVar;
        l lVar2;
        j jVar;
        ArrayList arrayList;
        j jVar2;
        j jVar3;
        j jVar4;
        Runnable runnable;
        switch (message.what) {
            case 1:
                jVar3 = this.f2023a.i;
                jVar3.a((List<c>) null);
                jVar4 = this.f2023a.i;
                jVar4.notifyDataSetChanged();
                runnable = this.f2023a.w;
                new Thread(runnable).start();
                break;
            case 2:
                this.f2023a.l = new l(this.f2023a);
                lVar = this.f2023a.l;
                lVar.setDaemon(true);
                lVar2 = this.f2023a.l;
                lVar2.start();
                jVar = this.f2023a.i;
                arrayList = this.f2023a.f;
                jVar.a(arrayList);
                jVar2 = this.f2023a.i;
                jVar2.notifyDataSetChanged();
                break;
        }
        return true;
    }
}
