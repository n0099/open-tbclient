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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.card.data.c;
import com.baidu.tieba.card.p;
import java.util.Iterator;
/* loaded from: classes18.dex */
public class b {
    private TbPageContext dVN;
    private int gEw;
    private com.baidu.tieba.personPolymeric.tab.fragments.a kYb;
    private final CustomMessageListener kYc = new CustomMessageListener(2921428) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bv) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == b.this.mBdUniqueId && b.this.kYb != null && b.this.kYb.cYg()) {
                b.this.aU((bv) customResponsedMessage.getData());
            }
        }
    };
    private final CustomMessageListener kYd = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                b.this.removeThread((String) customResponsedMessage.getData());
            }
        }
    };
    private final CustomMessageListener kYe = new CustomMessageListener(2921436) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                b.this.LJ((String) customResponsedMessage.getData());
            }
        }
    };
    private BdUniqueId mBdUniqueId;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.personPolymeric.tab.fragments.a aVar, int i) {
        this.dVN = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.kYb = aVar;
        this.gEw = i;
        this.kYc.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.kYc);
        this.kYd.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.kYd);
        this.kYe.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.kYe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aU(final bv bvVar) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
        cardPersonDynamicThreadData.dLK = bvVar;
        cardPersonDynamicThreadData.forumId = String.valueOf(bvVar.getFid());
        cardPersonDynamicThreadData.threadId = bvVar.tid;
        cardPersonDynamicThreadData.postId = bvVar.dUO;
        cardPersonDynamicThreadData.isPrivacy = bvVar.isPrivacy;
        if (bvVar != null && bvVar.getBaijiahaoData() != null) {
            cardPersonDynamicThreadData.hbb = bvVar.getBaijiahaoData().oriUgcNid;
        }
        p pVar = new p(this.dVN);
        pVar.mE(this.gEw == 1);
        pVar.create();
        pVar.a(new p.a() { // from class: com.baidu.tieba.personPolymeric.tab.a.b.1
            @Override // com.baidu.tieba.card.p.a
            public void setPrivacy(boolean z) {
                if (z) {
                    l.showToast(b.this.dVN.getPageActivity(), R.string.thread_has_hide);
                }
                b.this.a(z, bvVar);
            }
        });
        pVar.a(cardPersonDynamicThreadData);
        pVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, bv bvVar) {
        bv i;
        boolean z2 = false;
        if (bvVar != null && this.kYb != null && !x.isEmpty(this.kYb.cnZ()) && this.kYb.cYf() != null && this.kYb.cYf().cYh() != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.kYb.cnZ().size()) {
                    break;
                }
                q qVar = this.kYb.cnZ().get(i2);
                if (qVar != null && (i = com.baidu.tieba.personPolymeric.tab.b.a.i(qVar)) != null && !StringUtils.isNull(i.tid) && i.tid.equals(bvVar.tid)) {
                    i.isPrivacy = z;
                    c ay = com.baidu.tieba.personPolymeric.tab.b.a.ay(i);
                    if (ay != null) {
                        this.kYb.cnZ().set(i2, ay);
                        z2 = true;
                        break;
                    }
                }
                i2++;
            }
            if (z2) {
                this.kYb.cYf().eJ(this.kYb.cnZ());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LJ(String str) {
        boolean z;
        bv i;
        if (!StringUtils.isNull(str) && this.kYb != null && !x.isEmpty(this.kYb.cnZ()) && this.kYb.cYf() != null && this.kYb.cYf().cYh() != null) {
            Iterator<q> it = this.kYb.cnZ().iterator();
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
                this.kYb.cYf().eJ(this.kYb.cnZ());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeThread(String str) {
        boolean z;
        bv i;
        if (!StringUtils.isNull(str) && this.kYb != null && !x.isEmpty(this.kYb.cnZ()) && this.kYb.cYf() != null && this.kYb.cYf().cYh() != null) {
            Iterator<q> it = this.kYb.cnZ().iterator();
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
                this.kYb.cYf().eJ(this.kYb.cnZ());
            }
        }
    }
}
