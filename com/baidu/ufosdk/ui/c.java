package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f22800a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f22801b;

    public c(a aVar, e eVar) {
        this.f22801b = aVar;
        this.f22800a = eVar;
    }

    /* JADX WARN: Incorrect condition in loop: B:19:0x0085 */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onClick(View view) {
        ArrayList arrayList;
        a aVar;
        int i;
        ArrayList arrayList2;
        d dVar;
        d dVar2;
        ArrayList arrayList3;
        int i2;
        ArrayList arrayList4;
        ArrayList arrayList5;
        e eVar = this.f22800a;
        boolean z = !eVar.f22893a;
        eVar.f22893a = z;
        eVar.a(z);
        if (this.f22800a.f22893a) {
            arrayList5 = this.f22801b.f22735d;
            arrayList5.add(this.f22800a.b());
            if (this.f22800a.b().contains("抄袭")) {
                this.f22801b.f22737f = 1;
            }
            if (this.f22800a.b().equals("播放问题")) {
                aVar = this.f22801b;
                i = 2;
                aVar.f22737f = i;
            }
        } else {
            arrayList = this.f22801b.f22735d;
            arrayList.remove(this.f22800a.b());
            if (this.f22800a.b().contains("抄袭")) {
                this.f22801b.f22737f = 3;
            }
            if (this.f22800a.b().equals("播放问题")) {
                aVar = this.f22801b;
                i = 4;
                aVar.f22737f = i;
            }
        }
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            StringBuilder sb = new StringBuilder("选中的原因：");
            arrayList4 = this.f22801b.f22735d;
            sb.append((String) arrayList4.get(i3));
            com.baidu.ufosdk.f.c.a(sb.toString());
        }
        dVar = this.f22801b.f22736e;
        if (dVar != null) {
            dVar2 = this.f22801b.f22736e;
            arrayList3 = this.f22801b.f22735d;
            i2 = this.f22801b.f22737f;
            dVar2.a(arrayList3, i2);
        }
    }
}
