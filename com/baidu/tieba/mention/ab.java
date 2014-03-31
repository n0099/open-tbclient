package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.model.am;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ab implements View.OnClickListener {
    final /* synthetic */ PostActivity a;
    private final ArrayList<com.baidu.tieba.data.f> b;
    private final int c;

    public ab(PostActivity postActivity, ArrayList<com.baidu.tieba.data.f> arrayList, int i) {
        this.a = postActivity;
        this.b = arrayList;
        this.c = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00a4 A[Catch: Exception -> 0x0106, TryCatch #0 {Exception -> 0x0106, blocks: (B:3:0x0003, B:4:0x0009, B:6:0x0011, B:8:0x0019, B:10:0x0025, B:12:0x0035, B:13:0x0059, B:15:0x0069, B:16:0x007b, B:20:0x008e, B:22:0x00a4, B:23:0x00b0, B:25:0x00bb, B:27:0x00ca, B:28:0x00fc), top: B:36:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0103  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onClick(View view) {
        am amVar;
        boolean z;
        String str;
        String str2;
        am amVar2;
        am amVar3;
        String str3;
        am amVar4;
        am amVar5;
        am amVar6;
        am amVar7;
        am amVar8;
        String str4 = null;
        try {
            ArrayList<String> arrayList = new ArrayList<>();
            for (int i = 0; i < this.b.size(); i++) {
                if (this.b.get(i).a() == 3) {
                    StringBuffer stringBuffer = new StringBuffer(100);
                    stringBuffer.append("size=");
                    stringBuffer.append(com.baidu.tbadk.core.data.n.u());
                    stringBuffer.append("&src=");
                    stringBuffer.append(bc.d(this.b.get(i).g()));
                    arrayList.add(stringBuffer.toString());
                }
            }
            amVar = this.a.l;
            if (amVar != null) {
                amVar2 = this.a.l;
                if (amVar2.a() != null) {
                    amVar3 = this.a.l;
                    if (amVar3.a().c() != null) {
                        amVar7 = this.a.l;
                        str3 = amVar7.a().c().getName();
                        amVar8 = this.a.l;
                        str = amVar8.a().c().getId();
                    } else {
                        str = null;
                        str3 = null;
                    }
                    amVar4 = this.a.l;
                    if (amVar4.a().d() != null) {
                        amVar6 = this.a.l;
                        str4 = amVar6.a().d().l();
                    }
                    amVar5 = this.a.l;
                    str2 = str3;
                    z = amVar5.a().m() == 1;
                    this.a.sendMessage(new com.baidu.adp.framework.message.a(2010000, new com.baidu.tbadk.core.b.t(this.a).a(arrayList, this.c, str2, str, str4, z, arrayList.size() <= 0 ? arrayList.get(arrayList.size() - 1) : "")));
                }
            }
            z = false;
            str = null;
            str2 = null;
            this.a.sendMessage(new com.baidu.adp.framework.message.a(2010000, new com.baidu.tbadk.core.b.t(this.a).a(arrayList, this.c, str2, str, str4, z, arrayList.size() <= 0 ? arrayList.get(arrayList.size() - 1) : "")));
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("PbAdapter", "ImageOnClickListener", "error = " + e.getMessage());
        }
    }
}
