package com.baidu.tieba.personPolymeric.tab.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.card.q;
import java.util.Iterator;
/* loaded from: classes24.dex */
public class b {
    private TbPageContext eNx;
    private int hKL;
    private BdUniqueId mBdUniqueId;
    private final CustomMessageListener mtA = new CustomMessageListener(2921428) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof by) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == b.this.mBdUniqueId && b.this.mtz != null && b.this.mtz.dBe()) {
                b.this.aY((by) customResponsedMessage.getData());
            }
        }
    };
    private final CustomMessageListener mtB = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                b.this.removeThread((String) customResponsedMessage.getData());
            }
        }
    };
    private final CustomMessageListener mtC = new CustomMessageListener(2921436) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                b.this.Rm((String) customResponsedMessage.getData());
            }
        }
    };
    private com.baidu.tieba.personPolymeric.tab.fragments.a mtz;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.personPolymeric.tab.fragments.a aVar, int i) {
        this.eNx = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.mtz = aVar;
        this.hKL = i;
        this.mtA.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mtA);
        this.mtB.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mtB);
        this.mtC.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mtC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(final by byVar) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
        cardPersonDynamicThreadData.eCR = byVar;
        cardPersonDynamicThreadData.forumId = String.valueOf(byVar.getFid());
        cardPersonDynamicThreadData.threadId = byVar.tid;
        cardPersonDynamicThreadData.postId = byVar.eMo;
        cardPersonDynamicThreadData.isPrivacy = byVar.isPrivacy;
        if (byVar != null && byVar.getBaijiahaoData() != null) {
            cardPersonDynamicThreadData.ioc = byVar.getBaijiahaoData().oriUgcNid;
        }
        q qVar = new q(this.eNx);
        qVar.oU(this.hKL == 1);
        qVar.create();
        qVar.a(new q.a() { // from class: com.baidu.tieba.personPolymeric.tab.a.b.1
            @Override // com.baidu.tieba.card.q.a
            public void setPrivacy(boolean z) {
                if (z) {
                    l.showToast(b.this.eNx.getPageActivity(), R.string.thread_has_hide);
                }
                b.this.a(z, byVar);
            }
        });
        qVar.a(cardPersonDynamicThreadData);
        qVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, by byVar) {
        by i;
        boolean z2 = false;
        if (byVar != null && this.mtz != null && !y.isEmpty(this.mtz.cQM()) && this.mtz.dBd() != null && this.mtz.dBd().dBf() != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.mtz.cQM().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.q qVar = this.mtz.cQM().get(i2);
                if (qVar != null && (i = com.baidu.tieba.personPolymeric.tab.b.a.i(qVar)) != null && !StringUtils.isNull(i.tid) && i.tid.equals(byVar.tid)) {
                    i.isPrivacy = z;
                    com.baidu.tieba.card.data.b aC = com.baidu.tieba.personPolymeric.tab.b.a.aC(i);
                    if (aC != null) {
                        this.mtz.cQM().set(i2, aC);
                        z2 = true;
                        break;
                    }
                }
                i2++;
            }
            if (z2) {
                this.mtz.dBd().fF(this.mtz.cQM());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rm(String str) {
        boolean z;
        by i;
        if (!StringUtils.isNull(str) && this.mtz != null && !y.isEmpty(this.mtz.cQM()) && this.mtz.dBd() != null && this.mtz.dBd().dBf() != null) {
            Iterator<com.baidu.adp.widget.ListView.q> it = this.mtz.cQM().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.adp.widget.ListView.q next = it.next();
                if (next != null && (i = com.baidu.tieba.personPolymeric.tab.b.a.i(next)) != null && i.getBaijiahaoData() != null && !StringUtils.isNull(i.getBaijiahaoData().oriUgcNid) && i.getBaijiahaoData().oriUgcNid.equals(str)) {
                    it.remove();
                    z = true;
                    break;
                }
            }
            if (z) {
                this.mtz.dBd().fF(this.mtz.cQM());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeThread(String str) {
        boolean z;
        by i;
        if (!StringUtils.isNull(str) && this.mtz != null && !y.isEmpty(this.mtz.cQM()) && this.mtz.dBd() != null && this.mtz.dBd().dBf() != null) {
            Iterator<com.baidu.adp.widget.ListView.q> it = this.mtz.cQM().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.adp.widget.ListView.q next = it.next();
                if (next != null && (i = com.baidu.tieba.personPolymeric.tab.b.a.i(next)) != null && !StringUtils.isNull(i.tid) && i.tid.equals(str)) {
                    it.remove();
                    z = true;
                    break;
                }
            }
            if (z) {
                this.mtz.dBd().fF(this.mtz.cQM());
            }
        }
    }
}
