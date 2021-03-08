package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f3673a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, e eVar) {
        this.b = aVar;
        this.f3673a = eVar;
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
        this.f3673a.f3753a = !this.f3673a.f3753a;
        this.f3673a.a(this.f3673a.f3753a);
        if (this.f3673a.f3753a) {
            arrayList5 = this.b.d;
            arrayList5.add(this.f3673a.b());
            if (this.f3673a.b().contains("抄袭")) {
                this.b.f = 1;
            }
            if (this.f3673a.b().equals("播放问题")) {
                this.b.f = 2;
            }
        } else {
            arrayList = this.b.d;
            arrayList.remove(this.f3673a.b());
            if (this.f3673a.b().contains("抄袭")) {
                this.b.f = 3;
            }
            if (this.f3673a.b().equals("播放问题")) {
                this.b.f = 4;
            }
        }
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            StringBuilder sb = new StringBuilder("选中的原因：");
            arrayList4 = this.b.d;
            com.baidu.ufosdk.f.c.a(sb.append((String) arrayList4.get(i2)).toString());
        }
        dVar = this.b.e;
        if (dVar != null) {
            dVar2 = this.b.e;
            arrayList3 = this.b.d;
            i = this.b.f;
            dVar2.a(arrayList3, i);
        }
    }
}
