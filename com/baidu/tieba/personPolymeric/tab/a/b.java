package com.baidu.tieba.personPolymeric.tab.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.card.o;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class b {
    private TbPageContext cVg;
    private int frP;
    private com.baidu.tieba.personPolymeric.tab.fragments.a jqd;
    private final CustomMessageListener jqe = new CustomMessageListener(2921428) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == b.this.mBdUniqueId && b.this.jqd != null && b.this.jqd.cxF()) {
                b.this.aU((bj) customResponsedMessage.getData());
            }
        }
    };
    private final CustomMessageListener jqf = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                b.this.removeThread((String) customResponsedMessage.getData());
            }
        }
    };
    private final CustomMessageListener jqg = new CustomMessageListener(2921436) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                b.this.GW((String) customResponsedMessage.getData());
            }
        }
    };
    private BdUniqueId mBdUniqueId;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.personPolymeric.tab.fragments.a aVar, int i) {
        this.cVg = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.jqd = aVar;
        this.frP = i;
        this.jqe.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jqe);
        this.jqf.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jqf);
        this.jqg.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jqg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aU(final bj bjVar) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
        cardPersonDynamicThreadData.cRe = bjVar;
        cardPersonDynamicThreadData.forumId = String.valueOf(bjVar.getFid());
        cardPersonDynamicThreadData.threadId = bjVar.tid;
        cardPersonDynamicThreadData.postId = bjVar.cUt;
        cardPersonDynamicThreadData.isPrivacy = bjVar.isPrivacy;
        if (bjVar != null && bjVar.getBaijiahaoData() != null) {
            cardPersonDynamicThreadData.fNR = bjVar.getBaijiahaoData().oriUgcNid;
        }
        o oVar = new o(this.cVg);
        oVar.km(this.frP == 1);
        oVar.create();
        oVar.a(new o.a() { // from class: com.baidu.tieba.personPolymeric.tab.a.b.1
            @Override // com.baidu.tieba.card.o.a
            public void setPrivacy(boolean z) {
                if (z) {
                    l.showToast(b.this.cVg.getPageActivity(), (int) R.string.thread_has_hide);
                }
                b.this.a(z, bjVar);
            }
        });
        oVar.a(cardPersonDynamicThreadData);
        oVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, bj bjVar) {
        bj i;
        boolean z2 = false;
        if (bjVar != null && this.jqd != null && !v.isEmpty(this.jqd.ceM()) && this.jqd.cxE() != null && this.jqd.cxE().cxG() != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.jqd.ceM().size()) {
                    break;
                }
                m mVar = this.jqd.ceM().get(i2);
                if (mVar != null && (i = com.baidu.tieba.personPolymeric.tab.b.a.i(mVar)) != null && !StringUtils.isNull(i.tid) && i.tid.equals(bjVar.tid)) {
                    i.isPrivacy = z;
                    m aV = com.baidu.tieba.personPolymeric.tab.b.a.aV(i);
                    if (aV != null) {
                        this.jqd.ceM().set(i2, aV);
                        z2 = true;
                        break;
                    }
                }
                i2++;
            }
            if (z2) {
                this.jqd.cxE().dV(this.jqd.ceM());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GW(String str) {
        boolean z;
        bj i;
        if (!StringUtils.isNull(str) && this.jqd != null && !v.isEmpty(this.jqd.ceM()) && this.jqd.cxE() != null && this.jqd.cxE().cxG() != null) {
            Iterator<m> it = this.jqd.ceM().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                m next = it.next();
                if (next != null && (i = com.baidu.tieba.personPolymeric.tab.b.a.i(next)) != null && i.getBaijiahaoData() != null && !StringUtils.isNull(i.getBaijiahaoData().oriUgcNid) && i.getBaijiahaoData().oriUgcNid.equals(str)) {
                    it.remove();
                    z = true;
                    break;
                }
            }
            if (z) {
                this.jqd.cxE().dV(this.jqd.ceM());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeThread(String str) {
        boolean z;
        bj i;
        if (!StringUtils.isNull(str) && this.jqd != null && !v.isEmpty(this.jqd.ceM()) && this.jqd.cxE() != null && this.jqd.cxE().cxG() != null) {
            Iterator<m> it = this.jqd.ceM().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                m next = it.next();
                if (next != null && (i = com.baidu.tieba.personPolymeric.tab.b.a.i(next)) != null && !StringUtils.isNull(i.tid) && i.tid.equals(str)) {
                    it.remove();
                    z = true;
                    break;
                }
            }
            if (z) {
                this.jqd.cxE().dV(this.jqd.ceM());
            }
        }
    }
}
