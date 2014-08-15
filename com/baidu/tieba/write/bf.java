package com.baidu.tieba.write;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes.dex */
class bf implements View.OnClickListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.ae(this.a)));
    }
}
