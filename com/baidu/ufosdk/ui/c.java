package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f5481a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f5482b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, e eVar) {
        this.f5482b = aVar;
        this.f5481a = eVar;
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
        this.f5481a.f5548a = !this.f5481a.f5548a;
        this.f5481a.a(this.f5481a.f5548a);
        if (this.f5481a.f5548a) {
            arrayList5 = this.f5482b.d;
            arrayList5.add(this.f5481a.b());
            if (this.f5481a.b().contains("抄袭")) {
                this.f5482b.f = 1;
            }
            if (this.f5481a.b().equals("播放问题")) {
                this.f5482b.f = 2;
            }
        } else {
            arrayList = this.f5482b.d;
            arrayList.remove(this.f5481a.b());
            if (this.f5481a.b().contains("抄袭")) {
                this.f5482b.f = 3;
            }
            if (this.f5481a.b().equals("播放问题")) {
                this.f5482b.f = 4;
            }
        }
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            StringBuilder sb = new StringBuilder("选中的原因：");
            arrayList4 = this.f5482b.d;
            com.baidu.ufosdk.f.c.a(sb.append((String) arrayList4.get(i2)).toString());
        }
        dVar = this.f5482b.e;
        if (dVar != null) {
            dVar2 = this.f5482b.e;
            arrayList3 = this.f5482b.d;
            i = this.f5482b.f;
            dVar2.a(arrayList3, i);
        }
    }
}
