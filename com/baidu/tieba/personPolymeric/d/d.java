package com.baidu.tieba.personPolymeric.d;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends CustomMessageListener {
    final /* synthetic */ b eIZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b bVar, int i) {
        super(i);
        this.eIZ = bVar;
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
            z = this.eIZ.bcA;
            if (!z) {
                Object data = customResponsedMessage.getData();
                if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                    long j = ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId;
                    aVar = this.eIZ.eIY;
                    if (j == aVar.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            aVar2 = this.eIZ.eIY;
                            aVar2.akW = false;
                            textView = this.eIZ.cvn;
                            textView.setVisibility(0);
                            b bVar = this.eIZ;
                            aVar3 = this.eIZ.eIY;
                            bVar.iR(aVar3.akW);
                            com.baidu.adp.lib.util.k.showToast(this.eIZ.mContext, t.j.person_polymeric_unattention_success);
                            return;
                        }
                        com.baidu.adp.lib.util.k.showToast(this.eIZ.mContext, t.j.person_polymeric_unattention_faild);
                    }
                }
            }
        }
    }
}
