package com.baidu.tieba.pb.main;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
/* loaded from: classes.dex */
class u implements com.baidu.tbadk.widget.richText.s {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.s
    public void onClick(View view, String str, int i) {
        bm bmVar;
        com.baidu.tbadk.widget.richText.a a;
        int i2;
        bm bmVar2;
        String a2;
        bm bmVar3;
        try {
            TiebaStatic.eventStat(this.a, "pic_pb", "");
            bmVar = this.a.x;
            com.baidu.tieba.data.ai r = bmVar.r();
            a = this.a.a(str, i);
            ArrayList<com.baidu.tbadk.widget.richText.c> a3 = a.a();
            i2 = this.a.ai;
            com.baidu.tbadk.widget.richText.c cVar = a3.get(i2);
            if (cVar != null) {
                ArrayList<String> arrayList = new ArrayList<>();
                if (cVar.c().d()) {
                    int size = r.d().size();
                    this.a.b = false;
                    String str2 = "";
                    int i3 = i;
                    for (int i4 = 0; i4 < size; i4++) {
                        com.baidu.tieba.data.am amVar = r.d().get(i4);
                        com.baidu.tbadk.widget.richText.a p = amVar.p();
                        int size2 = arrayList.size();
                        i3 = this.a.a(p, a, i3, i, arrayList);
                        int size3 = arrayList.size();
                        if (size2 != size3) {
                            str2 = arrayList.get(size3 - 1);
                        }
                        ArrayList<com.baidu.tieba.data.am> k = amVar.k();
                        int i5 = 0;
                        while (true) {
                            int i6 = i5;
                            if (i6 >= k.size()) {
                                break;
                            }
                            i3 = this.a.a(k.get(i6).p(), a, i3, i, arrayList);
                            i5 = i6 + 1;
                        }
                    }
                    String str3 = null;
                    String str4 = null;
                    String str5 = null;
                    boolean z = false;
                    if (r != null) {
                        if (r.b() != null) {
                            str3 = r.b().getName();
                            str4 = r.b().getId();
                        }
                        if (r.c() != null) {
                            str5 = r.c().p();
                        }
                        z = r.l() == 1;
                    }
                    PbActivity pbActivity = this.a;
                    com.baidu.tbadk.core.atomData.ab abVar = new com.baidu.tbadk.core.atomData.ab(this.a);
                    bmVar2 = this.a.x;
                    pbActivity.sendMessage(new CustomMessage(2010000, abVar.a(arrayList, i3, str3, str4, str5, z, str2, bmVar2.z())));
                    return;
                }
                a2 = this.a.a(cVar);
                arrayList.add(a2);
                String str6 = null;
                String str7 = null;
                String str8 = null;
                boolean z2 = false;
                if (r != null) {
                    if (r.b() != null) {
                        str6 = r.b().getName();
                        str7 = r.b().getId();
                    }
                    if (r.c() != null) {
                        str8 = r.c().p();
                    }
                    z2 = r.l() == 1;
                }
                PbActivity pbActivity2 = this.a;
                bmVar3 = this.a.x;
                pbActivity2.sendMessage(new CustomMessage(2010000, new com.baidu.tbadk.core.atomData.ab(this.a).a(arrayList, 0, str6, str7, str8, z2, arrayList.get(0), bmVar3.z())));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
