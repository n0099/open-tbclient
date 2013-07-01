package com.baidu.tieba.pb;

import android.view.View;
import java.util.ArrayList;
/* loaded from: classes.dex */
class au implements com.baidu.tbadk.widget.richText.m {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1212a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(NewPbActivity newPbActivity) {
        this.f1212a = newPbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void onClick(View view, String str, int i) {
        bk bkVar;
        com.baidu.tieba.model.ax axVar;
        com.baidu.tbadk.widget.richText.a a2;
        int i2;
        int i3;
        int i4;
        String a3;
        String a4;
        try {
            bkVar = this.f1212a.p;
            if (bkVar.e(str) != null) {
                axVar = this.f1212a.j;
                com.baidu.tieba.data.aj j = axVar.j();
                a2 = this.f1212a.a(str, i);
                ArrayList a5 = a2.a();
                i2 = this.f1212a.H;
                com.baidu.tbadk.widget.richText.c cVar = (com.baidu.tbadk.widget.richText.c) a5.get(i2);
                if (cVar != null) {
                    ArrayList arrayList = new ArrayList();
                    if (cVar.c().c()) {
                        boolean z = false;
                        int size = j.d().size();
                        int i5 = 0;
                        int i6 = i;
                        while (i5 < size) {
                            com.baidu.tbadk.widget.richText.a i7 = ((com.baidu.tieba.data.an) j.d().get(i5)).i();
                            boolean z2 = i7 == a2 ? true : z;
                            if (i7 != null) {
                                int size2 = i7.a().size();
                                int i8 = -1;
                                int i9 = 0;
                                while (i9 < size2) {
                                    if (i7.a().get(i9) != null && ((com.baidu.tbadk.widget.richText.c) i7.a().get(i9)).a() == 8) {
                                        i8++;
                                        int b = ((com.baidu.tbadk.widget.richText.c) i7.a().get(i9)).c().b();
                                        int a6 = ((com.baidu.tbadk.widget.richText.c) i7.a().get(i9)).c().a();
                                        if ((b < 80 || a6 < 80 || a6 * b < 10000) || !((com.baidu.tbadk.widget.richText.c) i7.a().get(i9)).c().c()) {
                                            if (i7 == a2 && i8 <= i) {
                                                i4 = i6 - 1;
                                                i3 = i8;
                                            }
                                        } else {
                                            a3 = this.f1212a.a((com.baidu.tbadk.widget.richText.c) i7.a().get(i9));
                                            arrayList.add(a3);
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
                        ImageActivity.a(this.f1212a, arrayList, i6, j);
                        return;
                    }
                    a4 = this.f1212a.a(cVar);
                    arrayList.add(a4);
                    ImageActivity.a(this.f1212a, arrayList, 0, j);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.z.b("PbAdapter", "ImageOnClickListener", "error = " + e.getMessage());
        }
    }
}
