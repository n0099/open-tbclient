package com.baidu.tieba.pb;

import android.content.Intent;
import com.baidu.tieba.data.MarkData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements com.baidu.tieba.view.dialog.c {
    final /* synthetic */ NewPbActivity a;
    private final /* synthetic */ MarkData b;
    private final /* synthetic */ MarkData c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(NewPbActivity newPbActivity, MarkData markData, MarkData markData2) {
        this.a = newPbActivity;
        this.b = markData;
        this.c = markData2;
    }

    @Override // com.baidu.tieba.view.dialog.c
    public void onClick(com.baidu.tieba.view.dialog.a aVar) {
        com.baidu.tieba.model.av avVar;
        com.baidu.tieba.model.av avVar2;
        com.baidu.tieba.model.av avVar3;
        com.baidu.tieba.model.av avVar4;
        com.baidu.tieba.model.av avVar5;
        com.baidu.tieba.model.av avVar6;
        avVar = this.a.x;
        if (avVar.a()) {
            avVar5 = this.a.x;
            avVar5.e();
            avVar6 = this.a.x;
            avVar6.a(false);
        }
        avVar2 = this.a.x;
        avVar2.a(this.b);
        avVar3 = this.a.x;
        avVar3.a(true);
        avVar4 = this.a.x;
        avVar4.d();
        this.c.setPostId(this.b.getPostId());
        Intent intent = new Intent();
        intent.putExtra("mark", this.c);
        this.a.setResult(-1, intent);
        this.a.s();
    }
}
