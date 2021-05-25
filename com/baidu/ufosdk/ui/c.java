package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f22684a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f22685b;

    public c(a aVar, e eVar) {
        this.f22685b = aVar;
        this.f22684a = eVar;
    }

    /* JADX WARN: Incorrect condition in loop: B:19:0x0085 */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onClick(View view) {
        ArrayList arrayList;
        a aVar;
        int i2;
        ArrayList arrayList2;
        d dVar;
        d dVar2;
        ArrayList arrayList3;
        int i3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        e eVar = this.f22684a;
        boolean z = !eVar.f22778a;
        eVar.f22778a = z;
        eVar.a(z);
        if (this.f22684a.f22778a) {
            arrayList5 = this.f22685b.f22619d;
            arrayList5.add(this.f22684a.b());
            if (this.f22684a.b().contains("抄袭")) {
                this.f22685b.f22621f = 1;
            }
            if (this.f22684a.b().equals("播放问题")) {
                aVar = this.f22685b;
                i2 = 2;
                aVar.f22621f = i2;
            }
        } else {
            arrayList = this.f22685b.f22619d;
            arrayList.remove(this.f22684a.b());
            if (this.f22684a.b().contains("抄袭")) {
                this.f22685b.f22621f = 3;
            }
            if (this.f22684a.b().equals("播放问题")) {
                aVar = this.f22685b;
                i2 = 4;
                aVar.f22621f = i2;
            }
        }
        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
            StringBuilder sb = new StringBuilder("选中的原因：");
            arrayList4 = this.f22685b.f22619d;
            sb.append((String) arrayList4.get(i4));
            com.baidu.ufosdk.f.c.a(sb.toString());
        }
        dVar = this.f22685b.f22620e;
        if (dVar != null) {
            dVar2 = this.f22685b.f22620e;
            arrayList3 = this.f22685b.f22619d;
            i3 = this.f22685b.f22621f;
            dVar2.a(arrayList3, i3);
        }
    }
}
