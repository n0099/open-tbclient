package com.baidu.tieba.pb;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by implements View.OnClickListener {
    final /* synthetic */ bt a;
    private ArrayList b;
    private int c;
    private int d;

    public by(bt btVar, ArrayList arrayList, int i) {
        this.a = btVar;
        this.b = arrayList;
        this.c = i;
        this.d = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean a;
        ArrayList arrayList;
        Context context;
        com.baidu.tieba.b.n nVar;
        ArrayList arrayList2;
        int i;
        try {
            a = this.a.a(this.b, this.c);
            if (a) {
                boolean z = false;
                ArrayList arrayList3 = new ArrayList();
                arrayList = this.a.b;
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    arrayList2 = this.a.b;
                    ArrayList e = ((com.baidu.tieba.a.am) arrayList2.get(i2)).e();
                    boolean z2 = e == this.b ? true : z;
                    if (e != null) {
                        int size2 = e.size();
                        int i3 = -1;
                        int i4 = 0;
                        while (i4 < size2) {
                            if (e.get(i4) != null && ((com.baidu.tieba.a.j) e.get(i4)).a() == 3) {
                                i3++;
                                if (((com.baidu.tieba.a.j) e.get(i4)).b() >= 50 || ((com.baidu.tieba.a.j) e.get(i4)).c() >= 50) {
                                    StringBuffer stringBuffer = new StringBuffer(100);
                                    if (((com.baidu.tieba.a.j) e.get(i4)).b() * ((com.baidu.tieba.a.j) e.get(i4)).c() > com.baidu.tieba.a.h.g() * com.baidu.tieba.a.h.g()) {
                                        double sqrt = Math.sqrt((com.baidu.tieba.a.h.g() * com.baidu.tieba.a.h.g()) / (((com.baidu.tieba.a.j) e.get(i4)).b() * ((com.baidu.tieba.a.j) e.get(i4)).c()));
                                        stringBuffer.append("width=");
                                        stringBuffer.append(String.valueOf((int) (((com.baidu.tieba.a.j) e.get(i4)).b() * sqrt)));
                                        stringBuffer.append("&height=");
                                        stringBuffer.append(String.valueOf((int) (sqrt * ((com.baidu.tieba.a.j) e.get(i4)).c())));
                                    } else {
                                        float b = ((com.baidu.tieba.a.j) e.get(i4)).b() / ((com.baidu.tieba.a.j) e.get(i4)).c();
                                        double sqrt2 = Math.sqrt((com.baidu.tieba.a.h.g() * com.baidu.tieba.a.h.g()) / b);
                                        stringBuffer.append("width=");
                                        stringBuffer.append(String.valueOf((int) (b * sqrt2)));
                                        stringBuffer.append("&height=");
                                        stringBuffer.append(String.valueOf((int) sqrt2));
                                    }
                                    stringBuffer.append("&src=");
                                    stringBuffer.append(com.baidu.tieba.c.ad.f(((com.baidu.tieba.a.j) e.get(i4)).f()));
                                    arrayList3.add(stringBuffer.toString());
                                    if (!z2) {
                                        this.c++;
                                    }
                                } else if (e == this.b && i3 <= this.d) {
                                    this.c--;
                                    i = i3;
                                    i4++;
                                    i3 = i;
                                }
                            }
                            i = i3;
                            i4++;
                            i3 = i;
                        }
                    }
                    i2++;
                    z = z2;
                }
                context = this.a.a;
                int i5 = this.c;
                nVar = this.a.f;
                ImageActivity.a(context, arrayList3, i5, nVar);
            }
        } catch (Exception e2) {
            com.baidu.tieba.c.ae.b("PbAdapter", "ImageOnClickListener", "error = " + e2.getMessage());
        }
    }
}
