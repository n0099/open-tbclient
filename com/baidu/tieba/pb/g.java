package com.baidu.tieba.pb;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import com.baidu.tieba.view.MultiImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements ViewPager.OnPageChangeListener {
    final /* synthetic */ ImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ImageActivity imageActivity) {
        this.a = imageActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        boolean z;
        a aVar;
        MultiImageView multiImageView;
        a aVar2;
        int i2;
        z = this.a.B;
        if (!z) {
            aVar = this.a.u;
            if (aVar != null) {
                multiImageView = this.a.m;
                if (i > multiImageView.getItemNum() - 5) {
                    aVar2 = this.a.u;
                    aVar2.a();
                }
            }
        } else {
            Intent intent = new Intent(com.baidu.tieba.data.i.c());
            intent.putExtra("index", i);
            this.a.sendBroadcast(intent);
        }
        ImageActivity imageActivity = this.a;
        i2 = this.a.d;
        imageActivity.a(i2, i);
        this.a.d = i;
        this.a.f();
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
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
            j = this.a.v;
            if (nanoTime - j > 300000000) {
                arrayList = this.a.c;
                if (arrayList != null) {
                    i2 = this.a.d;
                    arrayList2 = this.a.c;
                    if (i2 < arrayList2.size()) {
                        hashMap = this.a.w;
                        arrayList3 = this.a.c;
                        i3 = this.a.d;
                        hashMap.put((String) arrayList3.get(i3), true);
                    }
                }
            }
        }
    }
}
