package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f23106a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f23107b;

    public c(a aVar, e eVar) {
        this.f23107b = aVar;
        this.f23106a = eVar;
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
        e eVar = this.f23106a;
        boolean z = !eVar.f23199a;
        eVar.f23199a = z;
        eVar.a(z);
        if (this.f23106a.f23199a) {
            arrayList5 = this.f23107b.f23041d;
            arrayList5.add(this.f23106a.b());
            if (this.f23106a.b().contains("抄袭")) {
                this.f23107b.f23043f = 1;
            }
            if (this.f23106a.b().equals("播放问题")) {
                aVar = this.f23107b;
                i = 2;
                aVar.f23043f = i;
            }
        } else {
            arrayList = this.f23107b.f23041d;
            arrayList.remove(this.f23106a.b());
            if (this.f23106a.b().contains("抄袭")) {
                this.f23107b.f23043f = 3;
            }
            if (this.f23106a.b().equals("播放问题")) {
                aVar = this.f23107b;
                i = 4;
                aVar.f23043f = i;
            }
        }
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            StringBuilder sb = new StringBuilder("选中的原因：");
            arrayList4 = this.f23107b.f23041d;
            sb.append((String) arrayList4.get(i3));
            com.baidu.ufosdk.f.c.a(sb.toString());
        }
        dVar = this.f23107b.f23042e;
        if (dVar != null) {
            dVar2 = this.f23107b.f23042e;
            arrayList3 = this.f23107b.f23041d;
            i2 = this.f23107b.f23043f;
            dVar2.a(arrayList3, i2);
        }
    }
}
