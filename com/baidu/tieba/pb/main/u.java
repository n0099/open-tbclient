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
        bl blVar;
        com.baidu.tbadk.widget.richText.a a;
        int i2;
        bl blVar2;
        String a2;
        bl blVar3;
        try {
            TiebaStatic.eventStat(this.a, "pic_pb", "");
            blVar = this.a.x;
            com.baidu.tieba.data.aj r = blVar.r();
            a = this.a.a(str, i);
            ArrayList<com.baidu.tbadk.widget.richText.c> a3 = a.a();
            i2 = this.a.aj;
            com.baidu.tbadk.widget.richText.c cVar = a3.get(i2);
            if (cVar != null) {
                ArrayList<String> arrayList = new ArrayList<>();
                if (cVar.c().d()) {
                    int size = r.e().size();
                    this.a.b = false;
                    String str2 = "";
                    int i3 = i;
                    for (int i4 = 0; i4 < size; i4++) {
                        com.baidu.tieba.data.an anVar = r.e().get(i4);
                        com.baidu.tbadk.widget.richText.a h = anVar.h();
                        int size2 = arrayList.size();
                        i3 = this.a.a(h, a, i3, i, arrayList);
                        int size3 = arrayList.size();
                        if (size2 != size3) {
                            str2 = arrayList.get(size3 - 1);
                        }
                        ArrayList<com.baidu.tieba.data.an> c = anVar.c();
                        int i5 = 0;
                        while (true) {
                            int i6 = i5;
                            if (i6 >= c.size()) {
                                break;
                            }
                            i3 = this.a.a(c.get(i6).h(), a, i3, i, arrayList);
                            i5 = i6 + 1;
                        }
                    }
                    String str3 = null;
                    String str4 = null;
                    String str5 = null;
                    boolean z = false;
                    if (r != null) {
                        if (r.c() != null) {
                            str3 = r.c().getName();
                            str4 = r.c().getId();
                        }
                        if (r.d() != null) {
                            str5 = r.d().h();
                        }
                        z = r.m() == 1;
                    }
                    PbActivity pbActivity = this.a;
                    com.baidu.tbadk.core.atomData.af afVar = new com.baidu.tbadk.core.atomData.af(this.a);
                    blVar2 = this.a.x;
                    pbActivity.sendMessage(new CustomMessage(2010000, afVar.a(arrayList, i3, str3, str4, str5, z, str2, blVar2.z())));
                    return;
                }
                a2 = this.a.a(cVar);
                arrayList.add(a2);
                String str6 = null;
                String str7 = null;
                String str8 = null;
                boolean z2 = false;
                if (r != null) {
                    if (r.c() != null) {
                        str6 = r.c().getName();
                        str7 = r.c().getId();
                    }
                    if (r.d() != null) {
                        str8 = r.d().h();
                    }
                    z2 = r.m() == 1;
                }
                PbActivity pbActivity2 = this.a;
                blVar3 = this.a.x;
                pbActivity2.sendMessage(new CustomMessage(2010000, new com.baidu.tbadk.core.atomData.af(this.a).a(arrayList, 0, str6, str7, str8, z2, arrayList.get(0), blVar3.z())));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
