package com.baidu.tieba.personPolymeric.tab.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.card.data.c;
import com.baidu.tieba.card.q;
import java.util.Iterator;
/* loaded from: classes24.dex */
public class b {
    private TbPageContext eIc;
    private int hBz;
    private BdUniqueId mBdUniqueId;
    private com.baidu.tieba.personPolymeric.tab.fragments.a mfb;
    private final CustomMessageListener mfc = new CustomMessageListener(2921428) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bw) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == b.this.mBdUniqueId && b.this.mfb != null && b.this.mfb.dwm()) {
                b.this.aW((bw) customResponsedMessage.getData());
            }
        }
    };
    private final CustomMessageListener mfd = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                b.this.removeThread((String) customResponsedMessage.getData());
            }
        }
    };
    private final CustomMessageListener mfe = new CustomMessageListener(2921436) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                b.this.QI((String) customResponsedMessage.getData());
            }
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.personPolymeric.tab.fragments.a aVar, int i) {
        this.eIc = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.mfb = aVar;
        this.hBz = i;
        this.mfc.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mfc);
        this.mfd.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mfd);
        this.mfe.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mfe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(final bw bwVar) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
        cardPersonDynamicThreadData.exA = bwVar;
        cardPersonDynamicThreadData.forumId = String.valueOf(bwVar.getFid());
        cardPersonDynamicThreadData.threadId = bwVar.tid;
        cardPersonDynamicThreadData.postId = bwVar.eGU;
        cardPersonDynamicThreadData.isPrivacy = bwVar.isPrivacy;
        if (bwVar != null && bwVar.getBaijiahaoData() != null) {
            cardPersonDynamicThreadData.icp = bwVar.getBaijiahaoData().oriUgcNid;
        }
        q qVar = new q(this.eIc);
        qVar.ov(this.hBz == 1);
        qVar.create();
        qVar.a(new q.a() { // from class: com.baidu.tieba.personPolymeric.tab.a.b.1
            @Override // com.baidu.tieba.card.q.a
            public void setPrivacy(boolean z) {
                if (z) {
                    l.showToast(b.this.eIc.getPageActivity(), (int) R.string.thread_has_hide);
                }
                b.this.a(z, bwVar);
            }
        });
        qVar.a(cardPersonDynamicThreadData);
        qVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, bw bwVar) {
        bw i;
        boolean z2 = false;
        if (bwVar != null && this.mfb != null && !y.isEmpty(this.mfb.cLR()) && this.mfb.dwl() != null && this.mfb.dwl().dwn() != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.mfb.cLR().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.q qVar = this.mfb.cLR().get(i2);
                if (qVar != null && (i = com.baidu.tieba.personPolymeric.tab.b.a.i(qVar)) != null && !StringUtils.isNull(i.tid) && i.tid.equals(bwVar.tid)) {
                    i.isPrivacy = z;
                    c aA = com.baidu.tieba.personPolymeric.tab.b.a.aA(i);
                    if (aA != null) {
                        this.mfb.cLR().set(i2, aA);
                        z2 = true;
                        break;
                    }
                }
                i2++;
            }
            if (z2) {
                this.mfb.dwl().ft(this.mfb.cLR());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QI(String str) {
        boolean z;
        bw i;
        if (!StringUtils.isNull(str) && this.mfb != null && !y.isEmpty(this.mfb.cLR()) && this.mfb.dwl() != null && this.mfb.dwl().dwn() != null) {
            Iterator<com.baidu.adp.widget.ListView.q> it = this.mfb.cLR().iterator();
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
                this.mfb.dwl().ft(this.mfb.cLR());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeThread(String str) {
        boolean z;
        bw i;
        if (!StringUtils.isNull(str) && this.mfb != null && !y.isEmpty(this.mfb.cLR()) && this.mfb.dwl() != null && this.mfb.dwl().dwn() != null) {
            Iterator<com.baidu.adp.widget.ListView.q> it = this.mfb.cLR().iterator();
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
                this.mfb.dwl().ft(this.mfb.cLR());
            }
        }
    }
}
