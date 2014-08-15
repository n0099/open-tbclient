package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ba;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {
    final /* synthetic */ PostActivity a;
    private final ArrayList<com.baidu.tieba.data.g> b;
    private final int c;

    public aj(PostActivity postActivity, ArrayList<com.baidu.tieba.data.g> arrayList, int i) {
        this.a = postActivity;
        this.b = arrayList;
        this.c = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00a4 A[Catch: Exception -> 0x010a, TryCatch #0 {Exception -> 0x010a, blocks: (B:3:0x0003, B:4:0x0009, B:6:0x0011, B:8:0x0019, B:10:0x0025, B:12:0x0035, B:13:0x0059, B:15:0x0069, B:16:0x007b, B:20:0x008e, B:22:0x00a4, B:23:0x00b0, B:25:0x00bc, B:27:0x00cb, B:28:0x00ff), top: B:36:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0106  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        com.baidu.tieba.model.am amVar;
        boolean z;
        String str;
        String str2;
        com.baidu.tieba.model.am amVar2;
        com.baidu.tieba.model.am amVar3;
        String str3;
        com.baidu.tieba.model.am amVar4;
        com.baidu.tieba.model.am amVar5;
        com.baidu.tieba.model.am amVar6;
        com.baidu.tieba.model.am amVar7;
        com.baidu.tieba.model.am amVar8;
        String str4 = null;
        try {
            ArrayList<String> arrayList = new ArrayList<>();
            for (int i = 0; i < this.b.size(); i++) {
                if (this.b.get(i).a() == 3) {
                    StringBuffer stringBuffer = new StringBuffer(100);
                    stringBuffer.append("size=");
                    stringBuffer.append(TbConfig.getThreadImageMaxWidth());
                    stringBuffer.append("&src=");
                    stringBuffer.append(ba.d(this.b.get(i).e()));
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
                        str4 = amVar6.a().d().h();
                    }
                    amVar5 = this.a.l;
                    str2 = str3;
                    z = amVar5.a().m() == 1;
                    this.a.sendMessage(new CustomMessage(2010000, new com.baidu.tbadk.core.atomData.af(this.a).a(arrayList, this.c, str2, str, str4, z, arrayList.size() <= 0 ? arrayList.get(arrayList.size() - 1) : "", true)));
                }
            }
            z = false;
            str = null;
            str2 = null;
            this.a.sendMessage(new CustomMessage(2010000, new com.baidu.tbadk.core.atomData.af(this.a).a(arrayList, this.c, str2, str, str4, z, arrayList.size() <= 0 ? arrayList.get(arrayList.size() - 1) : "", true)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
