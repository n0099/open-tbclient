package com.baidu.tieba.motu_gallery;

import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
/* loaded from: classes.dex */
final class d implements Handler.Callback {
    final /* synthetic */ JigsawAlbumActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(JigsawAlbumActivity jigsawAlbumActivity) {
        this.a = jigsawAlbumActivity;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
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
                jVar3 = this.a.i;
                jVar3.a(null);
                jVar4 = this.a.i;
                jVar4.notifyDataSetChanged();
                runnable = this.a.w;
                new Thread(runnable).start();
                break;
            case 2:
                this.a.l = new l(this.a);
                lVar = this.a.l;
                lVar.setDaemon(true);
                lVar2 = this.a.l;
                lVar2.start();
                jVar = this.a.i;
                arrayList = this.a.f;
                jVar.a(arrayList);
                jVar2 = this.a.i;
                jVar2.notifyDataSetChanged();
                break;
        }
        return true;
    }
}
