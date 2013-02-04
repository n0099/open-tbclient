package com.baidu.tieba.pb;

import android.content.Intent;
import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements android.support.v4.view.aj {
    final /* synthetic */ ImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ImageActivity imageActivity) {
        this.a = imageActivity;
    }

    @Override // android.support.v4.view.aj
    public void a(int i) {
        int i2;
        Intent intent = new Intent("com.baidu.tieba.broadcast.imagepb.pagechanged");
        intent.putExtra("index", i);
        this.a.sendBroadcast(intent);
        ImageActivity imageActivity = this.a;
        i2 = this.a.d;
        imageActivity.a(i2, i);
        this.a.d = i;
        this.a.l();
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
            j = this.a.u;
            if (nanoTime - j > 300000000) {
                arrayList = this.a.c;
                if (arrayList != null) {
                    i2 = this.a.d;
                    arrayList2 = this.a.c;
                    if (i2 < arrayList2.size()) {
                        hashMap = this.a.v;
                        arrayList3 = this.a.c;
                        i3 = this.a.d;
                        hashMap.put((String) arrayList3.get(i3), true);
                    }
                }
            }
        }
    }
}
