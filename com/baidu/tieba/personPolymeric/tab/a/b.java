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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.card.q;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class b {
    private TbPageContext eUY;
    private int hXb;
    private BdUniqueId mBdUniqueId;
    private com.baidu.tieba.personPolymeric.tab.fragments.a mDC;
    private final CustomMessageListener mDD = new CustomMessageListener(2921428) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof cb) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == b.this.mBdUniqueId && b.this.mDC != null && b.this.mDC.dzt()) {
                b.this.ba((cb) customResponsedMessage.getData());
            }
        }
    };
    private final CustomMessageListener mDE = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                b.this.removeThread((String) customResponsedMessage.getData());
            }
        }
    };
    private final CustomMessageListener mDF = new CustomMessageListener(2921436) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                b.this.QC((String) customResponsedMessage.getData());
            }
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.personPolymeric.tab.fragments.a aVar, int i) {
        this.eUY = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.mDC = aVar;
        this.hXb = i;
        this.mDD.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mDD);
        this.mDE.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mDE);
        this.mDF.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mDF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba(final cb cbVar) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
        cardPersonDynamicThreadData.eJQ = cbVar;
        cardPersonDynamicThreadData.forumId = String.valueOf(cbVar.getFid());
        cardPersonDynamicThreadData.threadId = cbVar.tid;
        cardPersonDynamicThreadData.postId = cbVar.eTM;
        cardPersonDynamicThreadData.isPrivacy = cbVar.isPrivacy;
        if (cbVar != null && cbVar.getBaijiahaoData() != null) {
            cardPersonDynamicThreadData.iBP = cbVar.getBaijiahaoData().oriUgcNid;
        }
        q qVar = new q(this.eUY);
        qVar.py(this.hXb == 1);
        qVar.create();
        qVar.a(new q.a() { // from class: com.baidu.tieba.personPolymeric.tab.a.b.1
            @Override // com.baidu.tieba.card.q.a
            public void setPrivacy(boolean z) {
                if (z) {
                    l.showToast(b.this.eUY.getPageActivity(), R.string.thread_has_hide);
                }
                b.this.a(z, cbVar);
            }
        });
        qVar.a(cardPersonDynamicThreadData, false);
        qVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, cb cbVar) {
        cb i;
        boolean z2 = false;
        if (cbVar != null && this.mDC != null && !y.isEmpty(this.mDC.cSi()) && this.mDC.dzs() != null && this.mDC.dzs().dzu() != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.mDC.cSi().size()) {
                    break;
                }
                n nVar = this.mDC.cSi().get(i2);
                if (nVar != null && (i = com.baidu.tieba.personPolymeric.tab.b.a.i(nVar)) != null && !StringUtils.isNull(i.tid) && i.tid.equals(cbVar.tid)) {
                    i.isPrivacy = z;
                    com.baidu.tieba.card.data.b aE = com.baidu.tieba.personPolymeric.tab.b.a.aE(i);
                    if (aE != null) {
                        this.mDC.cSi().set(i2, aE);
                        z2 = true;
                        break;
                    }
                }
                i2++;
            }
            if (z2) {
                this.mDC.dzs().fD(this.mDC.cSi());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QC(String str) {
        boolean z;
        cb i;
        if (!StringUtils.isNull(str) && this.mDC != null && !y.isEmpty(this.mDC.cSi()) && this.mDC.dzs() != null && this.mDC.dzs().dzu() != null) {
            Iterator<n> it = this.mDC.cSi().iterator();
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
                this.mDC.dzs().fD(this.mDC.cSi());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeThread(String str) {
        boolean z;
        cb i;
        if (!StringUtils.isNull(str) && this.mDC != null && !y.isEmpty(this.mDC.cSi()) && this.mDC.dzs() != null && this.mDC.dzs().dzu() != null) {
            Iterator<n> it = this.mDC.cSi().iterator();
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
                this.mDC.dzs().fD(this.mDC.cSi());
            }
        }
    }
}
