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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.card.data.c;
import com.baidu.tieba.card.p;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class b {
    private TbPageContext dPv;
    private int gyV;
    private com.baidu.tieba.personPolymeric.tab.fragments.a kPf;
    private final CustomMessageListener kPg = new CustomMessageListener(2921428) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bu) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == b.this.mBdUniqueId && b.this.kPf != null && b.this.kPf.cUq()) {
                b.this.aX((bu) customResponsedMessage.getData());
            }
        }
    };
    private final CustomMessageListener kPh = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                b.this.removeThread((String) customResponsedMessage.getData());
            }
        }
    };
    private final CustomMessageListener kPi = new CustomMessageListener(2921436) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                b.this.KV((String) customResponsedMessage.getData());
            }
        }
    };
    private BdUniqueId mBdUniqueId;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.personPolymeric.tab.fragments.a aVar, int i) {
        this.dPv = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.kPf = aVar;
        this.gyV = i;
        this.kPg.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.kPg);
        this.kPh.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.kPh);
        this.kPi.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.kPi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(final bu buVar) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
        cardPersonDynamicThreadData.dLi = buVar;
        cardPersonDynamicThreadData.forumId = String.valueOf(buVar.getFid());
        cardPersonDynamicThreadData.threadId = buVar.tid;
        cardPersonDynamicThreadData.postId = buVar.dOC;
        cardPersonDynamicThreadData.isPrivacy = buVar.isPrivacy;
        if (buVar != null && buVar.getBaijiahaoData() != null) {
            cardPersonDynamicThreadData.gVx = buVar.getBaijiahaoData().oriUgcNid;
        }
        p pVar = new p(this.dPv);
        pVar.lZ(this.gyV == 1);
        pVar.create();
        pVar.a(new p.a() { // from class: com.baidu.tieba.personPolymeric.tab.a.b.1
            @Override // com.baidu.tieba.card.p.a
            public void setPrivacy(boolean z) {
                if (z) {
                    l.showToast(b.this.dPv.getPageActivity(), (int) R.string.thread_has_hide);
                }
                b.this.a(z, buVar);
            }
        });
        pVar.a(cardPersonDynamicThreadData);
        pVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, bu buVar) {
        bu i;
        boolean z2 = false;
        if (buVar != null && this.kPf != null && !w.isEmpty(this.kPf.ckz()) && this.kPf.cUp() != null && this.kPf.cUp().cUr() != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.kPf.ckz().size()) {
                    break;
                }
                q qVar = this.kPf.ckz().get(i2);
                if (qVar != null && (i = com.baidu.tieba.personPolymeric.tab.b.a.i(qVar)) != null && !StringUtils.isNull(i.tid) && i.tid.equals(buVar.tid)) {
                    i.isPrivacy = z;
                    c aB = com.baidu.tieba.personPolymeric.tab.b.a.aB(i);
                    if (aB != null) {
                        this.kPf.ckz().set(i2, aB);
                        z2 = true;
                        break;
                    }
                }
                i2++;
            }
            if (z2) {
                this.kPf.cUp().eD(this.kPf.ckz());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KV(String str) {
        boolean z;
        bu i;
        if (!StringUtils.isNull(str) && this.kPf != null && !w.isEmpty(this.kPf.ckz()) && this.kPf.cUp() != null && this.kPf.cUp().cUr() != null) {
            Iterator<q> it = this.kPf.ckz().iterator();
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
                this.kPf.cUp().eD(this.kPf.ckz());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeThread(String str) {
        boolean z;
        bu i;
        if (!StringUtils.isNull(str) && this.kPf != null && !w.isEmpty(this.kPf.ckz()) && this.kPf.cUp() != null && this.kPf.cUp().cUr() != null) {
            Iterator<q> it = this.kPf.ckz().iterator();
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
                this.kPf.cUp().eD(this.kPf.ckz());
            }
        }
    }
}
