package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f23107a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f23108b;

    public c(a aVar, e eVar) {
        this.f23108b = aVar;
        this.f23107a = eVar;
    }

    /* JADX WARN: Incorrect condition in loop: B:19:0x0083 */
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
        e eVar = this.f23107a;
        boolean z = !eVar.f23200a;
        eVar.f23200a = z;
        eVar.a(z);
        if (this.f23107a.f23200a) {
            arrayList5 = this.f23108b.f23042d;
            arrayList5.add(this.f23107a.b());
            if (this.f23107a.b().contains("抄袭")) {
                this.f23108b.f23044f = 1;
            }
            if (this.f23107a.b().equals("播放问题")) {
                aVar = this.f23108b;
                i = 2;
                aVar.f23044f = i;
            }
        } else {
            arrayList = this.f23108b.f23042d;
            arrayList.remove(this.f23107a.b());
            if (this.f23107a.b().contains("抄袭")) {
                this.f23108b.f23044f = 3;
            }
            if (this.f23107a.b().equals("播放问题")) {
                aVar = this.f23108b;
                i = 4;
                aVar.f23044f = i;
            }
        }
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            StringBuilder sb = new StringBuilder("选中的原因：");
            arrayList4 = this.f23108b.f23042d;
            sb.append((String) arrayList4.get(i3));
            com.baidu.ufosdk.f.c.a(sb.toString());
        }
        dVar = this.f23108b.f23043e;
        if (dVar != null) {
            dVar2 = this.f23108b.f23043e;
            arrayList3 = this.f23108b.f23042d;
            i2 = this.f23108b.f23044f;
            dVar2.a(arrayList3, i2);
        }
    }
}
