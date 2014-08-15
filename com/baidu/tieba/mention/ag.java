package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    final /* synthetic */ PostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PostActivity postActivity) {
        this.a = postActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.model.am amVar;
        com.baidu.tieba.model.am amVar2;
        com.baidu.tieba.model.am amVar3;
        amVar = this.a.l;
        if (amVar != null) {
            amVar2 = this.a.l;
            if (amVar2.a() != null) {
                amVar3 = this.a.l;
                com.baidu.tieba.data.an anVar = amVar3.a().e().get(0);
                if (anVar != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new bg(this.a, anVar.g().getUserId(), anVar.g().getUserName())));
                }
            }
        }
    }
}
