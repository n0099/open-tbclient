package com.baidu.tieba.pb;

import android.content.Intent;
import com.baidu.tieba.data.MarkData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements com.baidu.tieba.view.dialog.c {
    final /* synthetic */ NewPbActivity a;
    private final /* synthetic */ MarkData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(NewPbActivity newPbActivity, MarkData markData) {
        this.a = newPbActivity;
        this.b = markData;
    }

    @Override // com.baidu.tieba.view.dialog.c
    public void onClick(com.baidu.tieba.view.dialog.a aVar) {
        Intent intent = new Intent();
        intent.putExtra("mark", this.b);
        this.a.setResult(-1, intent);
        this.a.s();
    }
}
