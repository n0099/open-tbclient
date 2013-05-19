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
        com.baidu.tieba.c.au auVar;
        com.baidu.tieba.a.k a;
        ArrayList b;
        int i2;
        int i3;
        String a2;
        String a3;
        try {
            auVar = this.a.i;
            com.baidu.tieba.a.al l = auVar.l();
            a = this.a.a(str, i);
            b = this.a.b(str, i);
            if (a != null) {
                boolean z = false;
                ArrayList arrayList = new ArrayList();
                if (a.g()) {
                    int size = l.d().size();
                    int i4 = 0;
                    int i5 = i;
                    while (i4 < size) {
                        ArrayList j = ((com.baidu.tieba.a.aq) l.d().get(i4)).j();
                        boolean z2 = j == b ? true : z;
                        if (j != null) {
                            int size2 = j.size();
                            int i6 = -1;
                            int i7 = 0;
                            while (i7 < size2) {
                                if (j.get(i7) != null && ((com.baidu.tieba.a.k) j.get(i7)).a() == 3) {
                                    i6++;
                                    if ((((com.baidu.tieba.a.k) j.get(i7)).b() < 50 && ((com.baidu.tieba.a.k) j.get(i7)).c() < 50) || !((com.baidu.tieba.a.k) j.get(i7)).g()) {
                                        if (j == b && i6 <= i) {
                                            i3 = i5 - 1;
                                            i2 = i6;
                                        }
                                    } else {
                                        a2 = this.a.a((com.baidu.tieba.a.k) j.get(i7));
                                        arrayList.add(a2);
                                        if (!z2) {
                                            i3 = i5 + 1;
                                            i2 = i6;
                                        }
                                    }
                                    i7++;
                                    i5 = i3;
                                    i6 = i2;
                                }
                                i2 = i6;
                                i3 = i5;
                                i7++;
                                i5 = i3;
                                i6 = i2;
                            }
                        }
                        i4++;
                        z = z2;
                    }
                    ImageActivity.a(this.a, arrayList, i5, l);
                    return;
                }
                a3 = this.a.a(a);
                arrayList.add(a3);
                ImageActivity.a(this.a, arrayList, 0, l);
            }
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b("PbAdapter", "ImageOnClickListener", "error = " + e.getMessage());
        }
    }
}
