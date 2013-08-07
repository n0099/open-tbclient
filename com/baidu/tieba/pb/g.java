package com.baidu.tieba.pb;

import android.content.Intent;
import com.baidu.tieba.view.MultiImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements android.support.v4.view.bq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImageActivity f1529a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ImageActivity imageActivity) {
        this.f1529a = imageActivity;
    }

    @Override // android.support.v4.view.bq
    public void a_(int i) {
        boolean z;
        a aVar;
        MultiImageView multiImageView;
        a aVar2;
        int i2;
        z = this.f1529a.D;
        if (!z) {
            aVar = this.f1529a.w;
            if (aVar != null) {
                multiImageView = this.f1529a.o;
                if (i > multiImageView.getItemNum() - 5) {
                    aVar2 = this.f1529a.w;
                    aVar2.a();
                }
            }
        } else {
            Intent intent = new Intent("com.baidu.tieba.broadcast.imagepb.pagechanged");
            intent.putExtra("index", i);
            this.f1529a.sendBroadcast(intent);
        }
        ImageActivity imageActivity = this.f1529a;
        i2 = this.f1529a.d;
        imageActivity.a(i2, i);
        this.f1529a.d = i;
        this.f1529a.m();
    }

    @Override // android.support.v4.view.bq
    public void a(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.bq
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
            j = this.f1529a.x;
            if (nanoTime - j > 300000000) {
                arrayList = this.f1529a.c;
                if (arrayList != null) {
                    i2 = this.f1529a.d;
                    arrayList2 = this.f1529a.c;
                    if (i2 < arrayList2.size()) {
                        hashMap = this.f1529a.y;
                        arrayList3 = this.f1529a.c;
                        i3 = this.f1529a.d;
                        hashMap.put((String) arrayList3.get(i3), true);
                    }
                }
            }
        }
    }
}
