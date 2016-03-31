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
    final /* synthetic */ a dXj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(a aVar, int i) {
        super(i);
        this.dXj = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ArrayList arrayList;
        ArrayList arrayList2;
        com.baidu.tieba.recommendfrs.data.l lVar;
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            arrayList = this.dXj.dXf;
            if (!y.q(arrayList)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().CK && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    arrayList2 = this.dXj.dXf;
                    Iterator it = arrayList2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            lVar = null;
                            break;
                        }
                        lVar = (com.baidu.tieba.recommendfrs.data.l) it.next();
                        if (lVar != null && lVar.aMf() != null && lVar.aMf().tag_type.intValue() == 3) {
                            break;
                        }
                    }
                    if (lVar != null) {
                        for (Object obj : lVar.aMg()) {
                            if (obj instanceof com.baidu.tieba.card.a.j) {
                                com.baidu.tieba.card.a.j jVar = (com.baidu.tieba.card.a.j) obj;
                                if (jVar.aVK != null && jVar.aVK.aVJ != null && jVar.aVK.aVJ.getAuthor() != null && jVar.aVK.aVJ.getAuthor().getUserId() != null && jVar.aVK.aVJ.getAuthor().getGodUserData() != null) {
                                    GodUserData godUserData = jVar.aVK.aVJ.getAuthor().getGodUserData();
                                    if (jVar.aVK.aVJ.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid)) {
                                        godUserData.setFollowed(updateAttentionMessage.getData().akM ? 1 : 0);
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
