package com.baidu.tieba.personPolymeric.tab.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.card.q;
import java.util.Iterator;
/* loaded from: classes23.dex */
public class b {
    private TbPageContext eGu;
    private int hBg;
    private BdUniqueId mBdUniqueId;
    private com.baidu.tieba.personPolymeric.tab.fragments.a mft;
    private final CustomMessageListener mfu = new CustomMessageListener(2921428) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bx) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == b.this.mBdUniqueId && b.this.mft != null && b.this.mft.dvM()) {
                b.this.aY((bx) customResponsedMessage.getData());
            }
        }
    };
    private final CustomMessageListener mfv = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                b.this.removeThread((String) customResponsedMessage.getData());
            }
        }
    };
    private final CustomMessageListener mfw = new CustomMessageListener(2921436) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                b.this.Qd((String) customResponsedMessage.getData());
            }
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.personPolymeric.tab.fragments.a aVar, int i) {
        this.eGu = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.mft = aVar;
        this.hBg = i;
        this.mfu.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mfu);
        this.mfv.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mfv);
        this.mfw.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mfw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(final bx bxVar) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
        cardPersonDynamicThreadData.evQ = bxVar;
        cardPersonDynamicThreadData.forumId = String.valueOf(bxVar.getFid());
        cardPersonDynamicThreadData.threadId = bxVar.tid;
        cardPersonDynamicThreadData.postId = bxVar.eFm;
        cardPersonDynamicThreadData.isPrivacy = bxVar.isPrivacy;
        if (bxVar != null && bxVar.getBaijiahaoData() != null) {
            cardPersonDynamicThreadData.ide = bxVar.getBaijiahaoData().oriUgcNid;
        }
        q qVar = new q(this.eGu);
        qVar.oy(this.hBg == 1);
        qVar.create();
        qVar.a(new q.a() { // from class: com.baidu.tieba.personPolymeric.tab.a.b.1
            @Override // com.baidu.tieba.card.q.a
            public void setPrivacy(boolean z) {
                if (z) {
                    l.showToast(b.this.eGu.getPageActivity(), R.string.thread_has_hide);
                }
                b.this.a(z, bxVar);
            }
        });
        qVar.a(cardPersonDynamicThreadData);
        qVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, bx bxVar) {
        bx i;
        boolean z2 = false;
        if (bxVar != null && this.mft != null && !y.isEmpty(this.mft.cLy()) && this.mft.dvL() != null && this.mft.dvL().dvN() != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.mft.cLy().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.q qVar = this.mft.cLy().get(i2);
                if (qVar != null && (i = com.baidu.tieba.personPolymeric.tab.b.a.i(qVar)) != null && !StringUtils.isNull(i.tid) && i.tid.equals(bxVar.tid)) {
                    i.isPrivacy = z;
                    com.baidu.tieba.card.data.b aC = com.baidu.tieba.personPolymeric.tab.b.a.aC(i);
                    if (aC != null) {
                        this.mft.cLy().set(i2, aC);
                        z2 = true;
                        break;
                    }
                }
                i2++;
            }
            if (z2) {
                this.mft.dvL().ft(this.mft.cLy());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qd(String str) {
        boolean z;
        bx i;
        if (!StringUtils.isNull(str) && this.mft != null && !y.isEmpty(this.mft.cLy()) && this.mft.dvL() != null && this.mft.dvL().dvN() != null) {
            Iterator<com.baidu.adp.widget.ListView.q> it = this.mft.cLy().iterator();
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
                this.mft.dvL().ft(this.mft.cLy());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeThread(String str) {
        boolean z;
        bx i;
        if (!StringUtils.isNull(str) && this.mft != null && !y.isEmpty(this.mft.cLy()) && this.mft.dvL() != null && this.mft.dvL().dvN() != null) {
            Iterator<com.baidu.adp.widget.ListView.q> it = this.mft.cLy().iterator();
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
                this.mft.dvL().ft(this.mft.cLy());
            }
        }
    }
}
