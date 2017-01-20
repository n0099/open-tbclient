package com.baidu.tieba.personPolymeric.d;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends CustomMessageListener {
    final /* synthetic */ b eET;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b bVar, int i) {
        super(i);
        this.eET = bVar;
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
            z = this.eET.baK;
            if (!z) {
                Object data = customResponsedMessage.getData();
                if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                    long j = ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId;
                    aVar = this.eET.eES;
                    if (j == aVar.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            aVar2 = this.eET.eES;
                            aVar2.isAttention = false;
                            textView = this.eET.cmy;
                            textView.setVisibility(0);
                            b bVar = this.eET;
                            aVar3 = this.eET.eES;
                            bVar.jr(aVar3.isAttention);
                            com.baidu.adp.lib.util.k.showToast(this.eET.mContext, r.l.unlike_success);
                            return;
                        }
                        com.baidu.adp.lib.util.k.showToast(this.eET.mContext, r.l.unlike_failure);
                    }
                }
            }
        }
    }
}
