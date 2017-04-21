package com.baidu.tieba.personPolymeric.d;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends CustomMessageListener {
    final /* synthetic */ b eIG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b bVar, int i) {
        super(i);
        this.eIG = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        com.baidu.tieba.personPolymeric.c.a aVar;
        com.baidu.tieba.personPolymeric.c.a aVar2;
        TextView textView;
        com.baidu.tieba.personPolymeric.c.a aVar3;
        if (customResponsedMessage != null) {
            z = this.eIG.bjz;
            if (!z) {
                Object data = customResponsedMessage.getData();
                if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                    long j = ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId;
                    aVar = this.eIG.eIF;
                    if (j == aVar.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            aVar2 = this.eIG.eIF;
                            aVar2.isAttention = false;
                            textView = this.eIG.coO;
                            textView.setVisibility(0);
                            b bVar = this.eIG;
                            aVar3 = this.eIG.eIF;
                            bVar.jx(aVar3.isAttention);
                            com.baidu.adp.lib.util.k.showToast(this.eIG.mContext, w.l.unlike_success);
                            return;
                        }
                        com.baidu.adp.lib.util.k.showToast(this.eIG.mContext, w.l.unlike_failure);
                    }
                }
            }
        }
    }
}
