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
/* loaded from: classes18.dex */
public class b {
    private TbPageContext efr;
    private int gRa;
    private com.baidu.tieba.personPolymeric.tab.fragments.a lox;
    private BdUniqueId mBdUniqueId;
    private final CustomMessageListener loy = new CustomMessageListener(2921428) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bw) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == b.this.mBdUniqueId && b.this.lox != null && b.this.lox.djm()) {
                b.this.aV((bw) customResponsedMessage.getData());
            }
        }
    };
    private final CustomMessageListener loz = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                b.this.removeThread((String) customResponsedMessage.getData());
            }
        }
    };
    private final CustomMessageListener loA = new CustomMessageListener(2921436) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                b.this.OD((String) customResponsedMessage.getData());
            }
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.personPolymeric.tab.fragments.a aVar, int i) {
        this.efr = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.lox = aVar;
        this.gRa = i;
        this.loy.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.loy);
        this.loz.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.loz);
        this.loA.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.loA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aV(final bw bwVar) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
        cardPersonDynamicThreadData.dUW = bwVar;
        cardPersonDynamicThreadData.forumId = String.valueOf(bwVar.getFid());
        cardPersonDynamicThreadData.threadId = bwVar.tid;
        cardPersonDynamicThreadData.postId = bwVar.eep;
        cardPersonDynamicThreadData.isPrivacy = bwVar.isPrivacy;
        if (bwVar != null && bwVar.getBaijiahaoData() != null) {
            cardPersonDynamicThreadData.hnW = bwVar.getBaijiahaoData().oriUgcNid;
        }
        p pVar = new p(this.efr);
        pVar.nj(this.gRa == 1);
        pVar.create();
        pVar.a(new p.a() { // from class: com.baidu.tieba.personPolymeric.tab.a.b.1
            @Override // com.baidu.tieba.card.p.a
            public void setPrivacy(boolean z) {
                if (z) {
                    l.showToast(b.this.efr.getPageActivity(), (int) R.string.thread_has_hide);
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
        if (bwVar != null && this.lox != null && !y.isEmpty(this.lox.cyT()) && this.lox.djl() != null && this.lox.djl().djn() != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.lox.cyT().size()) {
                    break;
                }
                q qVar = this.lox.cyT().get(i2);
                if (qVar != null && (i = com.baidu.tieba.personPolymeric.tab.b.a.i(qVar)) != null && !StringUtils.isNull(i.tid) && i.tid.equals(bwVar.tid)) {
                    i.isPrivacy = z;
                    c az = com.baidu.tieba.personPolymeric.tab.b.a.az(i);
                    if (az != null) {
                        this.lox.cyT().set(i2, az);
                        z2 = true;
                        break;
                    }
                }
                i2++;
            }
            if (z2) {
                this.lox.djl().eR(this.lox.cyT());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OD(String str) {
        boolean z;
        bw i;
        if (!StringUtils.isNull(str) && this.lox != null && !y.isEmpty(this.lox.cyT()) && this.lox.djl() != null && this.lox.djl().djn() != null) {
            Iterator<q> it = this.lox.cyT().iterator();
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
                this.lox.djl().eR(this.lox.cyT());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeThread(String str) {
        boolean z;
        bw i;
        if (!StringUtils.isNull(str) && this.lox != null && !y.isEmpty(this.lox.cyT()) && this.lox.djl() != null && this.lox.djl().djn() != null) {
            Iterator<q> it = this.lox.cyT().iterator();
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
                this.lox.djl().eR(this.lox.cyT());
            }
        }
    }
}
