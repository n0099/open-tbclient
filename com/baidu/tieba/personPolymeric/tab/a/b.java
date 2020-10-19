package com.baidu.tieba.personPolymeric.tab.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.card.data.c;
import com.baidu.tieba.card.p;
import java.util.Iterator;
/* loaded from: classes24.dex */
public class b {
    private TbPageContext etO;
    private int hjG;
    private com.baidu.tieba.personPolymeric.tab.fragments.a lMF;
    private final CustomMessageListener lMG = new CustomMessageListener(2921428) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bw) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == b.this.mBdUniqueId && b.this.lMF != null && b.this.lMF.dqD()) {
                b.this.aW((bw) customResponsedMessage.getData());
            }
        }
    };
    private final CustomMessageListener lMH = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                b.this.removeThread((String) customResponsedMessage.getData());
            }
        }
    };
    private final CustomMessageListener lMI = new CustomMessageListener(2921436) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                b.this.PT((String) customResponsedMessage.getData());
            }
        }
    };
    private BdUniqueId mBdUniqueId;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.personPolymeric.tab.fragments.a aVar, int i) {
        this.etO = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.lMF = aVar;
        this.hjG = i;
        this.lMG.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.lMG);
        this.lMH.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.lMH);
        this.lMI.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.lMI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(final bw bwVar) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
        cardPersonDynamicThreadData.eji = bwVar;
        cardPersonDynamicThreadData.forumId = String.valueOf(bwVar.getFid());
        cardPersonDynamicThreadData.threadId = bwVar.tid;
        cardPersonDynamicThreadData.postId = bwVar.esF;
        cardPersonDynamicThreadData.isPrivacy = bwVar.isPrivacy;
        if (bwVar != null && bwVar.getBaijiahaoData() != null) {
            cardPersonDynamicThreadData.hJV = bwVar.getBaijiahaoData().oriUgcNid;
        }
        p pVar = new p(this.etO);
        pVar.nU(this.hjG == 1);
        pVar.create();
        pVar.a(new p.a() { // from class: com.baidu.tieba.personPolymeric.tab.a.b.1
            @Override // com.baidu.tieba.card.p.a
            public void setPrivacy(boolean z) {
                if (z) {
                    l.showToast(b.this.etO.getPageActivity(), R.string.thread_has_hide);
                }
                b.this.a(z, bwVar);
            }
        });
        pVar.a(cardPersonDynamicThreadData);
        pVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, bw bwVar) {
        bw i;
        boolean z2 = false;
        if (bwVar != null && this.lMF != null && !y.isEmpty(this.lMF.cGj()) && this.lMF.dqC() != null && this.lMF.dqC().dqE() != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.lMF.cGj().size()) {
                    break;
                }
                q qVar = this.lMF.cGj().get(i2);
                if (qVar != null && (i = com.baidu.tieba.personPolymeric.tab.b.a.i(qVar)) != null && !StringUtils.isNull(i.tid) && i.tid.equals(bwVar.tid)) {
                    i.isPrivacy = z;
                    c aA = com.baidu.tieba.personPolymeric.tab.b.a.aA(i);
                    if (aA != null) {
                        this.lMF.cGj().set(i2, aA);
                        z2 = true;
                        break;
                    }
                }
                i2++;
            }
            if (z2) {
                this.lMF.dqC().fc(this.lMF.cGj());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PT(String str) {
        boolean z;
        bw i;
        if (!StringUtils.isNull(str) && this.lMF != null && !y.isEmpty(this.lMF.cGj()) && this.lMF.dqC() != null && this.lMF.dqC().dqE() != null) {
            Iterator<q> it = this.lMF.cGj().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                q next = it.next();
                if (next != null && (i = com.baidu.tieba.personPolymeric.tab.b.a.i(next)) != null && i.getBaijiahaoData() != null && !StringUtils.isNull(i.getBaijiahaoData().oriUgcNid) && i.getBaijiahaoData().oriUgcNid.equals(str)) {
                    it.remove();
                    z = true;
                    break;
                }
            }
            if (z) {
                this.lMF.dqC().fc(this.lMF.cGj());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeThread(String str) {
        boolean z;
        bw i;
        if (!StringUtils.isNull(str) && this.lMF != null && !y.isEmpty(this.lMF.cGj()) && this.lMF.dqC() != null && this.lMF.dqC().dqE() != null) {
            Iterator<q> it = this.lMF.cGj().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                q next = it.next();
                if (next != null && (i = com.baidu.tieba.personPolymeric.tab.b.a.i(next)) != null && !StringUtils.isNull(i.tid) && i.tid.equals(str)) {
                    it.remove();
                    z = true;
                    break;
                }
            }
            if (z) {
                this.lMF.dqC().fc(this.lMF.cGj());
            }
        }
    }
}
