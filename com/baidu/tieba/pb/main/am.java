package com.baidu.tieba.pb.main;

import android.content.Intent;
import com.baidu.tieba.data.MarkData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity a;
    private final /* synthetic */ MarkData b;
    private final /* synthetic */ MarkData c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PbActivity pbActivity, MarkData markData, MarkData markData2) {
        this.a = pbActivity;
        this.b = markData;
        this.c = markData2;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.model.ah ahVar;
        com.baidu.tieba.model.ah ahVar2;
        com.baidu.tieba.model.ah ahVar3;
        com.baidu.tieba.model.ah ahVar4;
        com.baidu.tieba.model.ah ahVar5;
        com.baidu.tieba.model.ah ahVar6;
        ahVar = this.a.y;
        if (ahVar.a()) {
            ahVar5 = this.a.y;
            ahVar5.e();
            ahVar6 = this.a.y;
            ahVar6.a(false);
        }
        ahVar2 = this.a.y;
        ahVar2.a(this.b);
        ahVar3 = this.a.y;
        ahVar3.a(true);
        ahVar4 = this.a.y;
        ahVar4.d();
        this.c.setPostId(this.b.getPostId());
        Intent intent = new Intent();
        intent.putExtra("mark", this.c);
        this.a.setResult(-1, intent);
        this.a.w();
    }
}
