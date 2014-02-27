package com.baidu.tieba.write;

import android.content.DialogInterface;
import com.baidu.tieba.data.WriteData;
/* loaded from: classes.dex */
final class ap implements DialogInterface.OnClickListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        WriteData writeData;
        writeData = this.a.b;
        ae.a(writeData.getForumId(), (WriteData) null);
        this.a.finish();
    }
}
