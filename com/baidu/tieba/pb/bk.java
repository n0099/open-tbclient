package com.baidu.tieba.pb;

import android.view.View;
import java.util.ArrayList;
/* loaded from: classes.dex */
class bk implements com.baidu.tbadk.widget.richText.n {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2078a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(NewPbActivity newPbActivity) {
        this.f2078a = newPbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.n
    public void onClick(View view, String str, int i) {
        cr crVar;
        com.baidu.tieba.model.bm bmVar;
        com.baidu.tbadk.widget.richText.a a2;
        int i2;
        int i3;
        int i4;
        String a3;
        String a4;
        try {
            crVar = this.f2078a.y;
            if (crVar.a(view, str) != null) {
                bmVar = this.f2078a.s;
                com.baidu.tieba.data.an l = bmVar.l();
                a2 = this.f2078a.a(str, i);
                ArrayList<com.baidu.tbadk.widget.richText.c> a5 = a2.a();
                i2 = this.f2078a.W;
                com.baidu.tbadk.widget.richText.c cVar = a5.get(i2);
                if (cVar != null) {
                    ArrayList arrayList = new ArrayList();
                    if (!cVar.c().d()) {
                        a4 = this.f2078a.a(cVar);
                        arrayList.add(a4);
                        ImageActivity.a(this.f2078a, arrayList, 0, l);
                        return;
                    }
                    boolean z = false;
                    int size = l.e().size();
                    int i5 = 0;
                    int i6 = i;
                    while (i5 < size) {
                        com.baidu.tbadk.widget.richText.a h = l.e().get(i5).h();
                        boolean z2 = h == a2 ? true : z;
                        if (h != null) {
                            int size2 = h.a().size();
                            int i7 = -1;
                            int i8 = 0;
                            while (i8 < size2) {
                                if (h.a().get(i8) != null && h.a().get(i8).a() == 8) {
                                    i7++;
                                    int c = h.a().get(i8).c().c();
                                    int b = h.a().get(i8).c().b();
                                    if (!(c < 80 || b < 80 || b * c < 10000) && h.a().get(i8).c().d()) {
                                        a3 = this.f2078a.a(h.a().get(i8));
                                        arrayList.add(a3);
                                        if (!z2) {
                                            i4 = i6 + 1;
                                            i3 = i7;
                                        }
                                    } else if (h == a2 && i7 <= i) {
                                        i4 = i6 - 1;
                                        i3 = i7;
                                    }
                                    i8++;
                                    i6 = i4;
                                    i7 = i3;
                                }
                                i3 = i7;
                                i4 = i6;
                                i8++;
                                i6 = i4;
                                i7 = i3;
                            }
                        }
                        i5++;
                        z = z2;
                    }
                    ImageActivity.a(this.f2078a, arrayList, i6, l);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.bg.b("PbAdapter", "ImageOnClickListener", "error = " + e.getMessage());
        }
    }
}
