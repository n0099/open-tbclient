package com.baidu.tieba.pb;

import android.view.View;
import java.util.ArrayList;
/* loaded from: classes.dex */
class au implements com.baidu.tbadk.widget.richText.m {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1460a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(NewPbActivity newPbActivity) {
        this.f1460a = newPbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void onClick(View view, String str, int i) {
        bn bnVar;
        com.baidu.tieba.model.bc bcVar;
        com.baidu.tbadk.widget.richText.a a2;
        int i2;
        int i3;
        int i4;
        String a3;
        String a4;
        try {
            bnVar = this.f1460a.p;
            if (bnVar.e(str) != null) {
                bcVar = this.f1460a.j;
                com.baidu.tieba.data.as j = bcVar.j();
                a2 = this.f1460a.a(str, i);
                ArrayList a5 = a2.a();
                i2 = this.f1460a.J;
                com.baidu.tbadk.widget.richText.c cVar = (com.baidu.tbadk.widget.richText.c) a5.get(i2);
                if (cVar != null) {
                    ArrayList arrayList = new ArrayList();
                    if (cVar.c().c()) {
                        boolean z = false;
                        int size = j.c().size();
                        int i5 = 0;
                        int i6 = i;
                        while (i5 < size) {
                            com.baidu.tbadk.widget.richText.a h = ((com.baidu.tieba.data.aw) j.c().get(i5)).h();
                            boolean z2 = h == a2 ? true : z;
                            if (h != null) {
                                int size2 = h.a().size();
                                int i7 = -1;
                                int i8 = 0;
                                while (i8 < size2) {
                                    if (h.a().get(i8) != null && ((com.baidu.tbadk.widget.richText.c) h.a().get(i8)).a() == 8) {
                                        i7++;
                                        int b = ((com.baidu.tbadk.widget.richText.c) h.a().get(i8)).c().b();
                                        int a6 = ((com.baidu.tbadk.widget.richText.c) h.a().get(i8)).c().a();
                                        if ((b < 80 || a6 < 80 || a6 * b < 10000) || !((com.baidu.tbadk.widget.richText.c) h.a().get(i8)).c().c()) {
                                            if (h == a2 && i7 <= i) {
                                                i4 = i6 - 1;
                                                i3 = i7;
                                            }
                                        } else {
                                            a3 = this.f1460a.a((com.baidu.tbadk.widget.richText.c) h.a().get(i8));
                                            arrayList.add(a3);
                                            if (!z2) {
                                                i4 = i6 + 1;
                                                i3 = i7;
                                            }
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
                        ImageActivity.a(this.f1460a, arrayList, i6, j);
                        return;
                    }
                    a4 = this.f1460a.a(cVar);
                    arrayList.add(a4);
                    ImageActivity.a(this.f1460a, arrayList, 0, j);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b("PbAdapter", "ImageOnClickListener", "error = " + e.getMessage());
        }
    }
}
