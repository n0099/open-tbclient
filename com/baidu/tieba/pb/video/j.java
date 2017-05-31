package com.baidu.tieba.pb.video;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends CustomMessageListener {
    final /* synthetic */ h eAp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(h hVar, int i) {
        super(i);
        this.eAp = hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bl blVar;
        bl blVar2;
        bl blVar3;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.data.l)) {
            blVar = this.eAp.eAo;
            if (blVar != null) {
                blVar2 = this.eAp.eAo;
                if (blVar2.getId() != null) {
                    com.baidu.tieba.pb.data.l lVar = (com.baidu.tieba.pb.data.l) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(lVar.apb)) {
                        String str = lVar.apb;
                        blVar3 = this.eAp.eAo;
                        if (str.equals(blVar3.rK())) {
                            this.eAp.a(lVar.ejg == 0, lVar.ejh.getPraiseNum());
                        }
                    }
                }
            }
        }
    }
}
