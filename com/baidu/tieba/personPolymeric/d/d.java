package com.baidu.tieba.personPolymeric.d;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends CustomMessageListener {
    final /* synthetic */ b eLc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b bVar, int i) {
        super(i);
        this.eLc = bVar;
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
            z = this.eLc.bcU;
            if (!z) {
                Object data = customResponsedMessage.getData();
                if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                    long j = ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId;
                    aVar = this.eLc.eLb;
                    if (j == aVar.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            aVar2 = this.eLc.eLb;
                            aVar2.akC = false;
                            textView = this.eLc.cvK;
                            textView.setVisibility(0);
                            b bVar = this.eLc;
                            aVar3 = this.eLc.eLb;
                            bVar.iU(aVar3.akC);
                            com.baidu.adp.lib.util.k.showToast(this.eLc.mContext, r.j.person_polymeric_unattention_success);
                            return;
                        }
                        com.baidu.adp.lib.util.k.showToast(this.eLc.mContext, r.j.person_polymeric_unattention_faild);
                    }
                }
            }
        }
    }
}
