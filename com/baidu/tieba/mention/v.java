package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.bb;
import com.baidu.tieba.data.am;
import com.baidu.tieba.model.al;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ PostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(PostActivity postActivity) {
        this.a = postActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        al alVar;
        al alVar2;
        al alVar3;
        alVar = this.a.l;
        if (alVar != null) {
            alVar2 = this.a.l;
            if (alVar2.a() != null) {
                alVar3 = this.a.l;
                am amVar = alVar3.a().d().get(0);
                if (amVar != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new bb(this.a, amVar.o().getUserId(), amVar.o().getUserName())));
                }
            }
        }
    }
}
