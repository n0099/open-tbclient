package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.at;
import com.baidu.tieba.data.ai;
import com.baidu.tieba.model.am;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ PostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PostActivity postActivity) {
        this.a = postActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        am amVar;
        am amVar2;
        am amVar3;
        amVar = this.a.l;
        if (amVar != null) {
            amVar2 = this.a.l;
            if (amVar2.a() != null) {
                amVar3 = this.a.l;
                ai aiVar = amVar3.a().e().get(0);
                if (aiVar != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003003, new at(this.a, aiVar.o().getUserId(), aiVar.o().getUserName())));
                }
            }
        }
    }
}
