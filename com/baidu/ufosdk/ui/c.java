package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f22792a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f22793b;

    public c(a aVar, e eVar) {
        this.f22793b = aVar;
        this.f22792a = eVar;
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
        e eVar = this.f22792a;
        boolean z = !eVar.f22885a;
        eVar.f22885a = z;
        eVar.a(z);
        if (this.f22792a.f22885a) {
            arrayList5 = this.f22793b.f22727d;
            arrayList5.add(this.f22792a.b());
            if (this.f22792a.b().contains("抄袭")) {
                this.f22793b.f22729f = 1;
            }
            if (this.f22792a.b().equals("播放问题")) {
                aVar = this.f22793b;
                i = 2;
                aVar.f22729f = i;
            }
        } else {
            arrayList = this.f22793b.f22727d;
            arrayList.remove(this.f22792a.b());
            if (this.f22792a.b().contains("抄袭")) {
                this.f22793b.f22729f = 3;
            }
            if (this.f22792a.b().equals("播放问题")) {
                aVar = this.f22793b;
                i = 4;
                aVar.f22729f = i;
            }
        }
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            StringBuilder sb = new StringBuilder("选中的原因：");
            arrayList4 = this.f22793b.f22727d;
            sb.append((String) arrayList4.get(i3));
            com.baidu.ufosdk.f.c.a(sb.toString());
        }
        dVar = this.f22793b.f22728e;
        if (dVar != null) {
            dVar2 = this.f22793b.f22728e;
            arrayList3 = this.f22793b.f22727d;
            i2 = this.f22793b.f22729f;
            dVar2.a(arrayList3, i2);
        }
    }
}
