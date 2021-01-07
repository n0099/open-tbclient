package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f5764a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f5765b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, e eVar) {
        this.f5765b = aVar;
        this.f5764a = eVar;
    }

    /* JADX WARN: Incorrect condition in loop: B:14:0x005e */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onClick(View view) {
        ArrayList arrayList;
        ArrayList arrayList2;
        d dVar;
        d dVar2;
        ArrayList arrayList3;
        int i;
        ArrayList arrayList4;
        ArrayList arrayList5;
        this.f5764a.f5831a = !this.f5764a.f5831a;
        this.f5764a.a(this.f5764a.f5831a);
        if (this.f5764a.f5831a) {
            arrayList5 = this.f5765b.d;
            arrayList5.add(this.f5764a.b());
            if (this.f5764a.b().contains("抄袭")) {
                this.f5765b.f = 1;
            }
            if (this.f5764a.b().equals("播放问题")) {
                this.f5765b.f = 2;
            }
        } else {
            arrayList = this.f5765b.d;
            arrayList.remove(this.f5764a.b());
            if (this.f5764a.b().contains("抄袭")) {
                this.f5765b.f = 3;
            }
            if (this.f5764a.b().equals("播放问题")) {
                this.f5765b.f = 4;
            }
        }
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            StringBuilder sb = new StringBuilder("选中的原因：");
            arrayList4 = this.f5765b.d;
            com.baidu.ufosdk.f.c.a(sb.append((String) arrayList4.get(i2)).toString());
        }
        dVar = this.f5765b.e;
        if (dVar != null) {
            dVar2 = this.f5765b.e;
            arrayList3 = this.f5765b.d;
            i = this.f5765b.f;
            dVar2.a(arrayList3, i);
        }
    }
}
