package com.baidu.tieba.personPolymeric.d;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends CustomMessageListener {
    final /* synthetic */ b eNa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b bVar, int i) {
        super(i);
        this.eNa = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        com.baidu.tieba.personPolymeric.c.b bVar;
        com.baidu.tieba.personPolymeric.c.b bVar2;
        TextView textView;
        com.baidu.tieba.personPolymeric.c.b bVar3;
        if (customResponsedMessage != null) {
            z = this.eNa.bld;
            if (!z) {
                Object data = customResponsedMessage.getData();
                if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                    long j = ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId;
                    bVar = this.eNa.eMZ;
                    if (j == bVar.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            bVar2 = this.eNa.eMZ;
                            bVar2.isAttention = false;
                            textView = this.eNa.csj;
                            textView.setVisibility(0);
                            b bVar4 = this.eNa;
                            bVar3 = this.eNa.eMZ;
                            bVar4.jx(bVar3.isAttention);
                            com.baidu.adp.lib.util.k.showToast(this.eNa.mContext, w.l.unlike_success);
                            return;
                        }
                        com.baidu.adp.lib.util.k.showToast(this.eNa.mContext, w.l.unlike_failure);
                    }
                }
            }
        }
    }
}
