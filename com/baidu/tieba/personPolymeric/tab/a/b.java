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
/* loaded from: classes8.dex */
public class b {
    private TbPageContext cQU;
    private int fmc;
    private final CustomMessageListener jlA = new CustomMessageListener(2921428) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == b.this.mBdUniqueId && b.this.jlz != null && b.this.jlz.cva()) {
                b.this.aQ((bj) customResponsedMessage.getData());
            }
        }
    };
    private final CustomMessageListener jlB = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                b.this.removeThread((String) customResponsedMessage.getData());
            }
        }
    };
    private final CustomMessageListener jlC = new CustomMessageListener(2921436) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                b.this.Gy((String) customResponsedMessage.getData());
            }
        }
    };
    private com.baidu.tieba.personPolymeric.tab.fragments.a jlz;
    private BdUniqueId mBdUniqueId;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.personPolymeric.tab.fragments.a aVar, int i) {
        this.cQU = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.jlz = aVar;
        this.fmc = i;
        this.jlA.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jlA);
        this.jlB.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jlB);
        this.jlC.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jlC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQ(final bj bjVar) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
        cardPersonDynamicThreadData.cMR = bjVar;
        cardPersonDynamicThreadData.forumId = String.valueOf(bjVar.getFid());
        cardPersonDynamicThreadData.threadId = bjVar.tid;
        cardPersonDynamicThreadData.postId = bjVar.cQh;
        cardPersonDynamicThreadData.isPrivacy = bjVar.isPrivacy;
        if (bjVar != null && bjVar.getBaijiahaoData() != null) {
            cardPersonDynamicThreadData.fIl = bjVar.getBaijiahaoData().oriUgcNid;
        }
        o oVar = new o(this.cQU);
        oVar.jZ(this.fmc == 1);
        oVar.create();
        oVar.a(new o.a() { // from class: com.baidu.tieba.personPolymeric.tab.a.b.1
            @Override // com.baidu.tieba.card.o.a
            public void setPrivacy(boolean z) {
                if (z) {
                    l.showToast(b.this.cQU.getPageActivity(), (int) R.string.thread_has_hide);
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
        if (bjVar != null && this.jlz != null && !v.isEmpty(this.jlz.cbZ()) && this.jlz.cuZ() != null && this.jlz.cuZ().cvb() != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.jlz.cbZ().size()) {
                    break;
                }
                m mVar = this.jlz.cbZ().get(i2);
                if (mVar != null && (i = com.baidu.tieba.personPolymeric.tab.b.a.i(mVar)) != null && !StringUtils.isNull(i.tid) && i.tid.equals(bjVar.tid)) {
                    i.isPrivacy = z;
                    m aR = com.baidu.tieba.personPolymeric.tab.b.a.aR(i);
                    if (aR != null) {
                        this.jlz.cbZ().set(i2, aR);
                        z2 = true;
                        break;
                    }
                }
                i2++;
            }
            if (z2) {
                this.jlz.cuZ().dY(this.jlz.cbZ());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gy(String str) {
        boolean z;
        bj i;
        if (!StringUtils.isNull(str) && this.jlz != null && !v.isEmpty(this.jlz.cbZ()) && this.jlz.cuZ() != null && this.jlz.cuZ().cvb() != null) {
            Iterator<m> it = this.jlz.cbZ().iterator();
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
                this.jlz.cuZ().dY(this.jlz.cbZ());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeThread(String str) {
        boolean z;
        bj i;
        if (!StringUtils.isNull(str) && this.jlz != null && !v.isEmpty(this.jlz.cbZ()) && this.jlz.cuZ() != null && this.jlz.cuZ().cvb() != null) {
            Iterator<m> it = this.jlz.cbZ().iterator();
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
                this.jlz.cuZ().dY(this.jlz.cbZ());
            }
        }
    }
}
