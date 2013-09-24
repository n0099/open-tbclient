package com.baidu.tieba.pb;

import android.view.View;
import java.util.ArrayList;
/* loaded from: classes.dex */
class ax implements com.baidu.tbadk.widget.richText.m {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1543a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(NewPbActivity newPbActivity) {
        this.f1543a = newPbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void onClick(View view, String str, int i) {
        br brVar;
        com.baidu.tieba.model.bd bdVar;
        com.baidu.tbadk.widget.richText.a a2;
        int i2;
        int i3;
        int i4;
        String a3;
        String a4;
        try {
            brVar = this.f1543a.t;
            if (brVar.e(str) != null) {
                bdVar = this.f1543a.n;
                com.baidu.tieba.data.ao k = bdVar.k();
                a2 = this.f1543a.a(str, i);
                ArrayList<com.baidu.tbadk.widget.richText.c> a5 = a2.a();
                i2 = this.f1543a.O;
                com.baidu.tbadk.widget.richText.c cVar = a5.get(i2);
                if (cVar != null) {
                    ArrayList arrayList = new ArrayList();
                    if (cVar.c().c()) {
                        boolean z = false;
                        int size = k.d().size();
                        int i5 = 0;
                        int i6 = i;
                        while (i5 < size) {
                            com.baidu.tbadk.widget.richText.a h = k.d().get(i5).h();
                            boolean z2 = h == a2 ? true : z;
                            if (h != null) {
                                int size2 = h.a().size();
                                int i7 = -1;
                                int i8 = 0;
                                while (i8 < size2) {
                                    if (h.a().get(i8) != null && h.a().get(i8).a() == 8) {
                                        i7++;
                                        int b = h.a().get(i8).c().b();
                                        int a6 = h.a().get(i8).c().a();
                                        if ((b < 80 || a6 < 80 || a6 * b < 10000) || !h.a().get(i8).c().c()) {
                                            if (h == a2 && i7 <= i) {
                                                i4 = i6 - 1;
                                                i3 = i7;
                                            }
                                        } else {
                                            a3 = this.f1543a.a(h.a().get(i8));
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
                        ImageActivity.a(this.f1543a, arrayList, i6, k);
                        return;
                    }
                    a4 = this.f1543a.a(cVar);
                    arrayList.add(a4);
                    ImageActivity.a(this.f1543a, arrayList, 0, k);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.av.b("PbAdapter", "ImageOnClickListener", "error = " + e.getMessage());
        }
    }
}
