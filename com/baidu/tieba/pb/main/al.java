package com.baidu.tieba.pb.main;

import android.content.Intent;
import com.baidu.tieba.data.MarkData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements com.baidu.tbadk.core.dialog.c {
    final /* synthetic */ PbActivity a;
    private final /* synthetic */ MarkData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(PbActivity pbActivity, MarkData markData) {
        this.a = pbActivity;
        this.b = markData;
    }

    @Override // com.baidu.tbadk.core.dialog.c
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        Intent intent = new Intent();
        intent.putExtra("mark", this.b);
        this.a.setResult(-1, intent);
        this.a.v();
    }
}
