package com.baidu.tieba.pb;

import android.view.View;
import java.util.ArrayList;
/* loaded from: classes.dex */
class au implements com.baidu.tbadk.widget.richText.m {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void onClick(View view, String str, int i) {
        bk bkVar;
        com.baidu.tieba.c.ax axVar;
        com.baidu.tbadk.widget.richText.a a;
        int i2;
        int i3;
        int i4;
        String a2;
        String a3;
        try {
            bkVar = this.a.p;
            if (bkVar.e(str) != null) {
                axVar = this.a.j;
                com.baidu.tieba.a.am m = axVar.m();
                a = this.a.a(str, i);
                ArrayList a4 = a.a();
                i2 = this.a.H;
                com.baidu.tbadk.widget.richText.c cVar = (com.baidu.tbadk.widget.richText.c) a4.get(i2);
                if (cVar != null) {
                    ArrayList arrayList = new ArrayList();
                    if (cVar.c().c()) {
                        boolean z = false;
                        int size = m.d().size();
                        int i5 = 0;
                        int i6 = i;
                        while (i5 < size) {
                            com.baidu.tbadk.widget.richText.a i7 = ((com.baidu.tieba.a.ar) m.d().get(i5)).i();
                            boolean z2 = i7 == a ? true : z;
                            if (i7 != null) {
                                int size2 = i7.a().size();
                                int i8 = -1;
                                int i9 = 0;
                                while (i9 < size2) {
                                    if (i7.a().get(i9) != null && ((com.baidu.tbadk.widget.richText.c) i7.a().get(i9)).a() == 8) {
                                        i8++;
                                        int b = ((com.baidu.tbadk.widget.richText.c) i7.a().get(i9)).c().b();
                                        int a5 = ((com.baidu.tbadk.widget.richText.c) i7.a().get(i9)).c().a();
                                        if ((b < 80 || a5 < 80 || a5 * b < 10000) || !((com.baidu.tbadk.widget.richText.c) i7.a().get(i9)).c().c()) {
                                            if (i7 == a && i8 <= i) {
                                                i4 = i6 - 1;
                                                i3 = i8;
                                            }
                                        } else {
                                            a2 = this.a.a((com.baidu.tbadk.widget.richText.c) i7.a().get(i9));
                                            arrayList.add(a2);
                                            if (!z2) {
                                                i4 = i6 + 1;
                                                i3 = i8;
                                            }
                                        }
                                        i9++;
                                        i6 = i4;
                                        i8 = i3;
                                    }
                                    i3 = i8;
                                    i4 = i6;
                                    i9++;
                                    i6 = i4;
                                    i8 = i3;
                                }
                            }
                            i5++;
                            z = z2;
                        }
                        ImageActivity.a(this.a, arrayList, i6, m);
                        return;
                    }
                    a3 = this.a.a(cVar);
                    arrayList.add(a3);
                    ImageActivity.a(this.a, arrayList, 0, m);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b("PbAdapter", "ImageOnClickListener", "error = " + e.getMessage());
        }
    }
}
