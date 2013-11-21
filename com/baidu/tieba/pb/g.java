package com.baidu.tieba.pb;

import android.content.Intent;
import com.baidu.tieba.view.MultiImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements android.support.v4.view.bq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImageActivity f2162a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ImageActivity imageActivity) {
        this.f2162a = imageActivity;
    }

    @Override // android.support.v4.view.bq
    public void onPageSelected(int i) {
        boolean z;
        a aVar;
        MultiImageView multiImageView;
        a aVar2;
        int i2;
        z = this.f2162a.B;
        if (!z) {
            aVar = this.f2162a.u;
            if (aVar != null) {
                multiImageView = this.f2162a.m;
                if (i > multiImageView.getItemNum() - 5) {
                    aVar2 = this.f2162a.u;
                    aVar2.a();
                }
            }
        } else {
            Intent intent = new Intent("com.baidu.tieba.broadcast.imagepb.pagechanged");
            intent.putExtra("index", i);
            this.f2162a.sendBroadcast(intent);
        }
        ImageActivity imageActivity = this.f2162a;
        i2 = this.f2162a.d;
        imageActivity.a(i2, i);
        this.f2162a.d = i;
        this.f2162a.f();
    }

    @Override // android.support.v4.view.bq
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.bq
    public void onPageScrollStateChanged(int i) {
        long j;
        ArrayList arrayList;
        int i2;
        ArrayList arrayList2;
        HashMap hashMap;
        ArrayList arrayList3;
        int i3;
        if (i == 1) {
            long nanoTime = System.nanoTime();
            j = this.f2162a.v;
            if (nanoTime - j > 300000000) {
                arrayList = this.f2162a.c;
                if (arrayList != null) {
                    i2 = this.f2162a.d;
                    arrayList2 = this.f2162a.c;
                    if (i2 < arrayList2.size()) {
                        hashMap = this.f2162a.w;
                        arrayList3 = this.f2162a.c;
                        i3 = this.f2162a.d;
                        hashMap.put(arrayList3.get(i3), true);
                    }
                }
            }
        }
    }
}
