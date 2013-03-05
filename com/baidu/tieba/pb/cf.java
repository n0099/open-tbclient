package com.baidu.tieba.pb;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cf implements View.OnClickListener {
    final /* synthetic */ ca a;
    private ArrayList b;
    private int c;
    private int d;

    public cf(ca caVar, ArrayList arrayList, int i) {
        this.a = caVar;
        this.b = arrayList;
        this.c = i;
        this.d = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.a.k a;
        ArrayList arrayList;
        Context context;
        com.baidu.tieba.b.q qVar;
        ArrayList arrayList2;
        String b;
        String b2;
        Context context2;
        com.baidu.tieba.b.q qVar2;
        try {
            a = this.a.a(this.b, this.c);
            if (a != null) {
                ArrayList arrayList3 = new ArrayList();
                if (a.g()) {
                    arrayList = this.a.b;
                    int size = arrayList.size();
                    int i = 0;
                    boolean z = false;
                    while (i < size) {
                        arrayList2 = this.a.b;
                        ArrayList f = ((com.baidu.tieba.a.al) arrayList2.get(i)).f();
                        boolean z2 = f == this.b ? true : z;
                        if (f != null) {
                            int size2 = f.size();
                            int i2 = -1;
                            int i3 = 0;
                            while (i3 < size2) {
                                if (f.get(i3) != null && ((com.baidu.tieba.a.k) f.get(i3)).a() == 3) {
                                    i2++;
                                    if ((((com.baidu.tieba.a.k) f.get(i3)).b() < 50 && ((com.baidu.tieba.a.k) f.get(i3)).c() < 50) || !((com.baidu.tieba.a.k) f.get(i3)).g()) {
                                        if (f == this.b && i2 <= this.d) {
                                            this.c--;
                                        }
                                    } else {
                                        b = this.a.b((com.baidu.tieba.a.k) f.get(i3));
                                        arrayList3.add(b);
                                        if (!z2) {
                                            this.c++;
                                        }
                                    }
                                }
                                i3++;
                                i2 = i2;
                            }
                        }
                        i++;
                        z = z2;
                    }
                    context = this.a.a;
                    int i4 = this.c;
                    qVar = this.a.f;
                    ImageActivity.a(context, arrayList3, i4, qVar);
                    return;
                }
                b2 = this.a.b(a);
                arrayList3.add(b2);
                context2 = this.a.a;
                qVar2 = this.a.f;
                ImageActivity.a(context2, arrayList3, 0, qVar2);
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b("PbAdapter", "ImageOnClickListener", "error = " + e.getMessage());
        }
    }
}
