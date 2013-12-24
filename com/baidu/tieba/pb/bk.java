package com.baidu.tieba.pb;

import android.view.View;
import java.util.ArrayList;
/* loaded from: classes.dex */
class bk implements com.baidu.tbadk.widget.richText.o {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.o
    public void onClick(View view, String str, int i) {
        cr crVar;
        com.baidu.tieba.model.bm bmVar;
        com.baidu.tbadk.widget.richText.a a;
        int i2;
        int i3;
        int i4;
        String a2;
        String a3;
        try {
            crVar = this.a.x;
            if (crVar.a(view, str) != null) {
                bmVar = this.a.r;
                com.baidu.tieba.data.an l = bmVar.l();
                a = this.a.a(str, i);
                ArrayList<com.baidu.tbadk.widget.richText.c> a4 = a.a();
                i2 = this.a.V;
                com.baidu.tbadk.widget.richText.c cVar = a4.get(i2);
                if (cVar != null) {
                    ArrayList arrayList = new ArrayList();
                    if (!cVar.c().d()) {
                        a3 = this.a.a(cVar);
                        arrayList.add(a3);
                        ImageActivity.a(this.a, arrayList, 0, l);
                        return;
                    }
                    boolean z = false;
                    int size = l.e().size();
                    int i5 = 0;
                    int i6 = i;
                    while (i5 < size) {
                        com.baidu.tbadk.widget.richText.a h = l.e().get(i5).h();
                        boolean z2 = h == a ? true : z;
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
                                        a2 = this.a.a(h.a().get(i8));
                                        arrayList.add(a2);
                                        if (!z2) {
                                            i4 = i6 + 1;
                                            i3 = i7;
                                        }
                                    } else if (h == a && i7 <= i) {
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
                    ImageActivity.a(this.a, arrayList, i6, l);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.be.b("PbAdapter", "ImageOnClickListener", "error = " + e.getMessage());
        }
    }
}
