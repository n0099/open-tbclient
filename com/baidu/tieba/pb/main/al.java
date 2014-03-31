package com.baidu.tieba.pb.main;

import android.content.Intent;
import com.baidu.tieba.data.MarkData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class al implements com.baidu.tbadk.core.dialog.c {
    final /* synthetic */ PbActivity a;
    private final /* synthetic */ MarkData b;
    private final /* synthetic */ MarkData c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(PbActivity pbActivity, MarkData markData, MarkData markData2) {
        this.a = pbActivity;
        this.b = markData;
        this.c = markData2;
    }

    @Override // com.baidu.tbadk.core.dialog.c
    public final void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.model.ai aiVar;
        com.baidu.tieba.model.ai aiVar2;
        com.baidu.tieba.model.ai aiVar3;
        com.baidu.tieba.model.ai aiVar4;
        com.baidu.tieba.model.ai aiVar5;
        com.baidu.tieba.model.ai aiVar6;
        aiVar = this.a.y;
        if (aiVar.a()) {
            aiVar5 = this.a.y;
            aiVar5.e();
            aiVar6 = this.a.y;
            aiVar6.a(false);
        }
        aiVar2 = this.a.y;
        aiVar2.a(this.b);
        aiVar3 = this.a.y;
        aiVar3.a(true);
        aiVar4 = this.a.y;
        aiVar4.d();
        this.c.setPostId(this.b.getPostId());
        Intent intent = new Intent();
        intent.putExtra("mark", this.c);
        this.a.setResult(-1, intent);
        super/*com.baidu.tbadk.a*/.closeActivity();
    }
}
