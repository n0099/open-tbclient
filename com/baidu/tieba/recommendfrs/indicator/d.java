package com.baidu.tieba.recommendfrs.indicator;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.data.GodUserData;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends CustomMessageListener {
    final /* synthetic */ a eas;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(a aVar, int i) {
        super(i);
        this.eas = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ArrayList arrayList;
        ArrayList arrayList2;
        com.baidu.tieba.recommendfrs.data.l lVar;
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            arrayList = this.eas.eao;
            if (!y.s(arrayList)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().sZ && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    arrayList2 = this.eas.eao;
                    Iterator it = arrayList2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            lVar = null;
                            break;
                        }
                        lVar = (com.baidu.tieba.recommendfrs.data.l) it.next();
                        if (lVar != null && lVar.aMt() != null && lVar.aMt().tag_type.intValue() == 3) {
                            break;
                        }
                    }
                    if (lVar != null) {
                        for (Object obj : lVar.aMu()) {
                            if (obj instanceof com.baidu.tieba.card.a.g) {
                                com.baidu.tieba.card.a.g gVar = (com.baidu.tieba.card.a.g) obj;
                                if (gVar.aRH != null && gVar.aRH.aRG != null && gVar.aRH.aRG.getAuthor() != null && gVar.aRH.aRG.getAuthor().getUserId() != null && gVar.aRH.aRG.getAuthor().getGodUserData() != null) {
                                    GodUserData godUserData = gVar.aRH.aRG.getAuthor().getGodUserData();
                                    if (gVar.aRH.aRG.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid)) {
                                        godUserData.setFollowed(updateAttentionMessage.getData().agz ? 1 : 0);
                                    }
                                } else {
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
