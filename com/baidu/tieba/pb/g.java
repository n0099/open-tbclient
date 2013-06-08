package com.baidu.tieba.pb;

import android.content.Intent;
import com.baidu.tieba.view.MultiImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements android.support.v4.view.aj {
    final /* synthetic */ ImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ImageActivity imageActivity) {
        this.a = imageActivity;
    }

    @Override // android.support.v4.view.aj
    public void a(int i) {
        boolean z;
        a aVar;
        MultiImageView multiImageView;
        a aVar2;
        int i2;
        z = this.a.D;
        if (!z) {
            aVar = this.a.w;
            if (aVar != null) {
                multiImageView = this.a.o;
                if (i > multiImageView.getItemNum() - 5) {
                    aVar2 = this.a.w;
                    aVar2.a();
                }
            }
        } else {
            Intent intent = new Intent("com.baidu.tieba.broadcast.imagepb.pagechanged");
            intent.putExtra("index", i);
            this.a.sendBroadcast(intent);
        }
        ImageActivity imageActivity = this.a;
        i2 = this.a.f;
        imageActivity.b(i2, i);
        this.a.f = i;
        this.a.o();
    }

    @Override // android.support.v4.view.aj
    public void a(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.aj
    public void b(int i) {
        long j;
        ArrayList arrayList;
        int i2;
        ArrayList arrayList2;
        HashMap hashMap;
        ArrayList arrayList3;
        int i3;
        if (i == 1) {
            long nanoTime = System.nanoTime();
            j = this.a.x;
            if (nanoTime - j > 300000000) {
                arrayList = this.a.e;
                if (arrayList != null) {
                    i2 = this.a.f;
                    arrayList2 = this.a.e;
                    if (i2 < arrayList2.size()) {
                        hashMap = this.a.y;
                        arrayList3 = this.a.e;
                        i3 = this.a.f;
                        hashMap.put((String) arrayList3.get(i3), true);
                    }
                }
            }
        }
    }
}
