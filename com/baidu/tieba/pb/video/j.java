package com.baidu.tieba.pb.video;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bm;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends CustomMessageListener {
    final /* synthetic */ h eJN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(h hVar, int i) {
        super(i);
        this.eJN = hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bm bmVar;
        bm bmVar2;
        bm bmVar3;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.data.l)) {
            bmVar = this.eJN.eJM;
            if (bmVar != null) {
                bmVar2 = this.eJN.eJM;
                if (bmVar2.getId() != null) {
                    com.baidu.tieba.pb.data.l lVar = (com.baidu.tieba.pb.data.l) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(lVar.pid)) {
                        String str = lVar.pid;
                        bmVar3 = this.eJN.eJM;
                        if (str.equals(bmVar3.rH())) {
                            this.eJN.a(lVar.ese == 0, lVar.esf.getPraiseNum());
                        }
                    }
                }
            }
        }
    }
}
