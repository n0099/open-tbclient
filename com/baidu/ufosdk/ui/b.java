package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f22723a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f22724b;

    public b(a aVar, e eVar) {
        this.f22724b = aVar;
        this.f22723a = eVar;
    }

    /* JADX WARN: Incorrect condition in loop: B:19:0x0083 */
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
        e eVar = this.f22723a;
        boolean z = !eVar.f22849a;
        eVar.f22849a = z;
        eVar.a(z);
        if (this.f22723a.f22849a) {
            arrayList5 = this.f22724b.f22690d;
            arrayList5.add(this.f22723a.b());
            if (this.f22723a.b().contains("抄袭")) {
                this.f22724b.f22692f = 1;
            }
            if (this.f22723a.b().equals("播放问题")) {
                aVar = this.f22724b;
                i2 = 2;
                aVar.f22692f = i2;
            }
        } else {
            arrayList = this.f22724b.f22690d;
            arrayList.remove(this.f22723a.b());
            if (this.f22723a.b().contains("抄袭")) {
                this.f22724b.f22692f = 3;
            }
            if (this.f22723a.b().equals("播放问题")) {
                aVar = this.f22724b;
                i2 = 4;
                aVar.f22692f = i2;
            }
        }
        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
            StringBuilder sb = new StringBuilder("选中的原因：");
            arrayList4 = this.f22724b.f22690d;
            sb.append((String) arrayList4.get(i4));
            com.baidu.ufosdk.f.c.a(sb.toString());
        }
        dVar = this.f22724b.f22691e;
        if (dVar != null) {
            dVar2 = this.f22724b.f22691e;
            arrayList3 = this.f22724b.f22690d;
            i3 = this.f22724b.f22692f;
            dVar2.a(arrayList3, i3);
        }
    }
}
