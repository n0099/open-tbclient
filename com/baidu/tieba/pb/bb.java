package com.baidu.tieba.pb;

import android.view.View;
import java.util.ArrayList;
/* loaded from: classes.dex */
final class bb implements com.baidu.tbadk.widget.richText.r {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.r
    public final void onClick(View view, String str, int i) {
        cu cuVar;
        com.baidu.tieba.model.bb bbVar;
        int i2;
        int i3;
        int i4;
        try {
            cuVar = this.a.C;
            if (cuVar.a(view, str) != null) {
                bbVar = this.a.w;
                com.baidu.tieba.data.am q = bbVar.q();
                com.baidu.tbadk.widget.richText.a a = NewPbActivity.a(this.a, str, i);
                ArrayList<com.baidu.tbadk.widget.richText.c> a2 = a.a();
                i2 = this.a.ab;
                com.baidu.tbadk.widget.richText.c cVar = a2.get(i2);
                if (cVar != null) {
                    ArrayList arrayList = new ArrayList();
                    if (!cVar.c().d()) {
                        arrayList.add(NewPbActivity.a(this.a, cVar));
                        ImageActivity.a(this.a, arrayList, 0, q);
                        return;
                    }
                    boolean z = false;
                    int size = q.e().size();
                    int i5 = 0;
                    int i6 = i;
                    while (i5 < size) {
                        com.baidu.tbadk.widget.richText.a h = q.e().get(i5).h();
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
                                    if ((c < 80 || b < 80 || b * c < 10000) || !h.a().get(i8).c().d()) {
                                        if (h == a && i7 <= i) {
                                            i4 = i6 - 1;
                                            i3 = i7;
                                        }
                                    } else {
                                        arrayList.add(NewPbActivity.a(this.a, h.a().get(i8)));
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
                    ImageActivity.a(this.a, arrayList, i6, q);
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b("PbAdapter", "ImageOnClickListener", "error = " + e.getMessage());
        }
    }
}
