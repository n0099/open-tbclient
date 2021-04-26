package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f23510a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f23511b;

    public c(a aVar, e eVar) {
        this.f23511b = aVar;
        this.f23510a = eVar;
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
        e eVar = this.f23510a;
        boolean z = !eVar.f23604a;
        eVar.f23604a = z;
        eVar.a(z);
        if (this.f23510a.f23604a) {
            arrayList5 = this.f23511b.f23445d;
            arrayList5.add(this.f23510a.b());
            if (this.f23510a.b().contains("抄袭")) {
                this.f23511b.f23447f = 1;
            }
            if (this.f23510a.b().equals("播放问题")) {
                aVar = this.f23511b;
                i2 = 2;
                aVar.f23447f = i2;
            }
        } else {
            arrayList = this.f23511b.f23445d;
            arrayList.remove(this.f23510a.b());
            if (this.f23510a.b().contains("抄袭")) {
                this.f23511b.f23447f = 3;
            }
            if (this.f23510a.b().equals("播放问题")) {
                aVar = this.f23511b;
                i2 = 4;
                aVar.f23447f = i2;
            }
        }
        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
            StringBuilder sb = new StringBuilder("选中的原因：");
            arrayList4 = this.f23511b.f23445d;
            sb.append((String) arrayList4.get(i4));
            com.baidu.ufosdk.f.c.a(sb.toString());
        }
        dVar = this.f23511b.f23446e;
        if (dVar != null) {
            dVar2 = this.f23511b.f23446e;
            arrayList3 = this.f23511b.f23445d;
            i3 = this.f23511b.f23447f;
            dVar2.a(arrayList3, i3);
        }
    }
}
