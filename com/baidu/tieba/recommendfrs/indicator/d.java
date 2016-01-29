package com.baidu.tieba.recommendfrs.indicator;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.data.GodUserData;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends CustomMessageListener {
    final /* synthetic */ a dFk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(a aVar, int i) {
        super(i);
        this.dFk = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ArrayList arrayList;
        ArrayList arrayList2;
        com.baidu.tieba.recommendfrs.data.h hVar;
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            arrayList = this.dFk.dFf;
            if (!x.p(arrayList)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().CF && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    arrayList2 = this.dFk.dFf;
                    Iterator it = arrayList2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            hVar = null;
                            break;
                        }
                        hVar = (com.baidu.tieba.recommendfrs.data.h) it.next();
                        if (hVar != null && hVar.aFr() != null && hVar.aFr().tag_type.intValue() == com.baidu.tieba.recommendfrs.control.a.n.dEA) {
                            break;
                        }
                    }
                    if (hVar != null) {
                        for (Object obj : hVar.aFs()) {
                            if (obj instanceof com.baidu.tieba.card.a.j) {
                                com.baidu.tieba.card.a.j jVar = (com.baidu.tieba.card.a.j) obj;
                                if (jVar.aSd != null && jVar.aSd.aSc != null && jVar.aSd.aSc.getAuthor() != null && jVar.aSd.aSc.getAuthor().getUserId() != null && jVar.aSd.aSc.getAuthor().getGodUserData() != null) {
                                    GodUserData godUserData = jVar.aSd.aSc.getAuthor().getGodUserData();
                                    if (jVar.aSd.aSc.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid)) {
                                        godUserData.setFollowed(updateAttentionMessage.getData().akv ? 1 : 0);
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
