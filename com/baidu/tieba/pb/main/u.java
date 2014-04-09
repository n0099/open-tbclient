package com.baidu.tieba.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
/* loaded from: classes.dex */
final class u implements com.baidu.tbadk.widget.richText.r {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.r
    public final void onClick(View view, String str, int i) {
        bm bmVar;
        bf bfVar;
        int i2;
        String a;
        try {
            bmVar = this.a.D;
            if (bmVar.a(view, str) != null) {
                TiebaStatic.a(this.a, "pic_pb", "");
                bfVar = this.a.x;
                com.baidu.tieba.data.ae p = bfVar.p();
                com.baidu.tbadk.widget.richText.a a2 = PbActivity.a(this.a, str, i);
                ArrayList<com.baidu.tbadk.widget.richText.c> a3 = a2.a();
                i2 = this.a.aj;
                com.baidu.tbadk.widget.richText.c cVar = a3.get(i2);
                if (cVar != null) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    if (!cVar.c().d()) {
                        PbActivity pbActivity = this.a;
                        a = PbActivity.a(cVar);
                        arrayList.add(a);
                        String str2 = null;
                        String str3 = null;
                        String str4 = null;
                        boolean z = false;
                        if (p != null) {
                            if (p.c() != null) {
                                str2 = p.c().getName();
                                str3 = p.c().getId();
                            }
                            if (p.d() != null) {
                                str4 = p.d().l();
                            }
                            z = p.m() == 1;
                        }
                        this.a.sendMessage(new com.baidu.adp.framework.message.a(2010000, new com.baidu.tbadk.core.b.t(this.a).a(arrayList, 0, str2, str3, str4, z, arrayList.get(0))));
                        return;
                    }
                    int size = p.e().size();
                    this.a.b = false;
                    String str5 = "";
                    int i3 = i;
                    for (int i4 = 0; i4 < size; i4++) {
                        com.baidu.tieba.data.ai aiVar = p.e().get(i4);
                        com.baidu.tbadk.widget.richText.a h = aiVar.h();
                        int size2 = arrayList.size();
                        i3 = PbActivity.a(this.a, h, a2, i3, i, arrayList);
                        int size3 = arrayList.size();
                        if (size2 != size3) {
                            str5 = arrayList.get(size3 - 1);
                        }
                        ArrayList<com.baidu.tieba.data.ai> c = aiVar.c();
                        int i5 = 0;
                        while (true) {
                            int i6 = i5;
                            if (i6 >= c.size()) {
                                break;
                            }
                            i3 = PbActivity.a(this.a, c.get(i6).h(), a2, i3, i, arrayList);
                            i5 = i6 + 1;
                        }
                    }
                    String str6 = null;
                    String str7 = null;
                    String str8 = null;
                    boolean z2 = false;
                    if (p != null) {
                        if (p.c() != null) {
                            str6 = p.c().getName();
                            str7 = p.c().getId();
                        }
                        if (p.d() != null) {
                            str8 = p.d().l();
                        }
                        z2 = p.m() == 1;
                    }
                    this.a.sendMessage(new com.baidu.adp.framework.message.a(2010000, new com.baidu.tbadk.core.b.t(this.a).a(arrayList, i3, str6, str7, str8, z2, str5)));
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("PbAdapter", "ImageOnClickListener", "error = " + e.getMessage());
        }
    }
}
