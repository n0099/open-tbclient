package com.baidu.tieba.personPolymeric.tab.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.card.p;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class b {
    private TbPageContext eXu;
    private int hWZ;
    private BdUniqueId mBdUniqueId;
    private com.baidu.tieba.personPolymeric.tab.fragments.a myN;
    private final CustomMessageListener myO = new CustomMessageListener(2921428) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bz) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == b.this.mBdUniqueId && b.this.myN != null && b.this.myN.dAV()) {
                b.this.aZ((bz) customResponsedMessage.getData());
            }
        }
    };
    private final CustomMessageListener myP = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                b.this.removeThread((String) customResponsedMessage.getData());
            }
        }
    };
    private final CustomMessageListener myQ = new CustomMessageListener(2921436) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                b.this.QR((String) customResponsedMessage.getData());
            }
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.personPolymeric.tab.fragments.a aVar, int i) {
        this.eXu = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.myN = aVar;
        this.hWZ = i;
        this.myO.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.myO);
        this.myP.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.myP);
        this.myQ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.myQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZ(final bz bzVar) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
        cardPersonDynamicThreadData.eMv = bzVar;
        cardPersonDynamicThreadData.forumId = String.valueOf(bzVar.getFid());
        cardPersonDynamicThreadData.threadId = bzVar.tid;
        cardPersonDynamicThreadData.postId = bzVar.eWj;
        cardPersonDynamicThreadData.isPrivacy = bzVar.isPrivacy;
        if (bzVar != null && bzVar.getBaijiahaoData() != null) {
            cardPersonDynamicThreadData.iAy = bzVar.getBaijiahaoData().oriUgcNid;
        }
        p pVar = new p(this.eXu);
        pVar.ps(this.hWZ == 1);
        pVar.create();
        pVar.a(new p.a() { // from class: com.baidu.tieba.personPolymeric.tab.a.b.1
            @Override // com.baidu.tieba.card.p.a
            public void setPrivacy(boolean z) {
                if (z) {
                    l.showToast(b.this.eXu.getPageActivity(), R.string.thread_has_hide);
                }
                b.this.a(z, bzVar);
            }
        });
        pVar.a(cardPersonDynamicThreadData);
        pVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, bz bzVar) {
        bz i;
        boolean z2 = false;
        if (bzVar != null && this.myN != null && !x.isEmpty(this.myN.cTU()) && this.myN.dAU() != null && this.myN.dAU().dAW() != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.myN.cTU().size()) {
                    break;
                }
                n nVar = this.myN.cTU().get(i2);
                if (nVar != null && (i = com.baidu.tieba.personPolymeric.tab.b.a.i(nVar)) != null && !StringUtils.isNull(i.tid) && i.tid.equals(bzVar.tid)) {
                    i.isPrivacy = z;
                    com.baidu.tieba.card.data.b aD = com.baidu.tieba.personPolymeric.tab.b.a.aD(i);
                    if (aD != null) {
                        this.myN.cTU().set(i2, aD);
                        z2 = true;
                        break;
                    }
                }
                i2++;
            }
            if (z2) {
                this.myN.dAU().fF(this.myN.cTU());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QR(String str) {
        boolean z;
        bz i;
        if (!StringUtils.isNull(str) && this.myN != null && !x.isEmpty(this.myN.cTU()) && this.myN.dAU() != null && this.myN.dAU().dAW() != null) {
            Iterator<n> it = this.myN.cTU().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                n next = it.next();
                if (next != null && (i = com.baidu.tieba.personPolymeric.tab.b.a.i(next)) != null && i.getBaijiahaoData() != null && !StringUtils.isNull(i.getBaijiahaoData().oriUgcNid) && i.getBaijiahaoData().oriUgcNid.equals(str)) {
                    it.remove();
                    z = true;
                    break;
                }
            }
            if (z) {
                this.myN.dAU().fF(this.myN.cTU());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeThread(String str) {
        boolean z;
        bz i;
        if (!StringUtils.isNull(str) && this.myN != null && !x.isEmpty(this.myN.cTU()) && this.myN.dAU() != null && this.myN.dAU().dAW() != null) {
            Iterator<n> it = this.myN.cTU().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                n next = it.next();
                if (next != null && (i = com.baidu.tieba.personPolymeric.tab.b.a.i(next)) != null && !StringUtils.isNull(i.tid) && i.tid.equals(str)) {
                    it.remove();
                    z = true;
                    break;
                }
            }
            if (z) {
                this.myN.dAU().fF(this.myN.cTU());
            }
        }
    }
}
