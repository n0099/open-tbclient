package com.baidu.tieba.pb.main;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfig;
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
        bj bjVar;
        com.baidu.tbadk.widget.richText.a a;
        int i2;
        String a2;
        try {
            TiebaStatic.eventStat(this.a, "pic_pb", "");
            bjVar = this.a.x;
            com.baidu.tieba.data.af p = bjVar.p();
            a = this.a.a(str, i);
            ArrayList<com.baidu.tbadk.widget.richText.c> a3 = a.a();
            i2 = this.a.ai;
            com.baidu.tbadk.widget.richText.c cVar = a3.get(i2);
            if (cVar != null) {
                ArrayList<String> arrayList = new ArrayList<>();
                if (cVar.c().d()) {
                    int size = p.e().size();
                    this.a.b = false;
                    String str2 = "";
                    int i3 = i;
                    for (int i4 = 0; i4 < size; i4++) {
                        com.baidu.tieba.data.ai aiVar = p.e().get(i4);
                        com.baidu.tbadk.widget.richText.a p2 = aiVar.p();
                        int size2 = arrayList.size();
                        i3 = this.a.a(p2, a, i3, i, arrayList);
                        int size3 = arrayList.size();
                        if (size2 != size3) {
                            str2 = arrayList.get(size3 - 1);
                        }
                        ArrayList<com.baidu.tieba.data.ai> k = aiVar.k();
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
                    if (p != null) {
                        if (p.c() != null) {
                            str3 = p.c().getName();
                            str4 = p.c().getId();
                        }
                        if (p.d() != null) {
                            str5 = p.d().p();
                        }
                        z = p.m() == 1;
                    }
                    this.a.sendMessage(new CustomMessage((int) CmdConfig.IMAGE_VIEWER_CUSTOM_CMD, new com.baidu.tbadk.core.atomData.w(this.a).a(arrayList, i3, str3, str4, str5, z, str2)));
                    return;
                }
                a2 = this.a.a(cVar);
                arrayList.add(a2);
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
                        str8 = p.d().p();
                    }
                    z2 = p.m() == 1;
                }
                this.a.sendMessage(new CustomMessage((int) CmdConfig.IMAGE_VIEWER_CUSTOM_CMD, new com.baidu.tbadk.core.atomData.w(this.a).a(arrayList, 0, str6, str7, str8, z2, arrayList.get(0))));
            }
        } catch (Exception e) {
            BdLog.e("PbAdapter", "ImageOnClickListener", "error = " + e.getMessage());
        }
    }
}
