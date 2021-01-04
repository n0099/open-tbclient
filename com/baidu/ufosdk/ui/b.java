package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f5732a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f5733b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, e eVar) {
        this.f5733b = aVar;
        this.f5732a = eVar;
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
        this.f5732a.f5830a = !this.f5732a.f5830a;
        this.f5732a.a(this.f5732a.f5830a);
        if (this.f5732a.f5830a) {
            arrayList5 = this.f5733b.d;
            arrayList5.add(this.f5732a.b());
            if (this.f5732a.b().contains("抄袭")) {
                this.f5733b.f = 1;
            }
            if (this.f5732a.b().equals("播放问题")) {
                this.f5733b.f = 2;
            }
        } else {
            arrayList = this.f5733b.d;
            arrayList.remove(this.f5732a.b());
            if (this.f5732a.b().contains("抄袭")) {
                this.f5733b.f = 3;
            }
            if (this.f5732a.b().equals("播放问题")) {
                this.f5733b.f = 4;
            }
        }
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            StringBuilder sb = new StringBuilder("选中的原因：");
            arrayList4 = this.f5733b.d;
            com.baidu.ufosdk.f.c.a(sb.append((String) arrayList4.get(i2)).toString());
        }
        dVar = this.f5733b.e;
        if (dVar != null) {
            dVar2 = this.f5733b.e;
            arrayList3 = this.f5733b.d;
            i = this.f5733b.f;
            dVar2.a(arrayList3, i);
        }
    }
}
