package com.baidu.tieba.personPolymeric.tab.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.o;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.card.data.c;
import com.baidu.tieba.card.p;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class b {
    private TbPageContext dIF;
    private int glW;
    private com.baidu.tieba.personPolymeric.tab.fragments.a kuc;
    private final CustomMessageListener kud = new CustomMessageListener(2921428) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bk) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == b.this.mBdUniqueId && b.this.kuc != null && b.this.kuc.cPI()) {
                b.this.aW((bk) customResponsedMessage.getData());
            }
        }
    };
    private final CustomMessageListener kue = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                b.this.removeThread((String) customResponsedMessage.getData());
            }
        }
    };
    private final CustomMessageListener kuf = new CustomMessageListener(2921436) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                b.this.Kt((String) customResponsedMessage.getData());
            }
        }
    };
    private BdUniqueId mBdUniqueId;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.personPolymeric.tab.fragments.a aVar, int i) {
        this.dIF = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.kuc = aVar;
        this.glW = i;
        this.kud.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.kud);
        this.kue.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.kue);
        this.kuf.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.kuf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(final bk bkVar) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
        cardPersonDynamicThreadData.dEA = bkVar;
        cardPersonDynamicThreadData.forumId = String.valueOf(bkVar.getFid());
        cardPersonDynamicThreadData.threadId = bkVar.tid;
        cardPersonDynamicThreadData.postId = bkVar.dHQ;
        cardPersonDynamicThreadData.isPrivacy = bkVar.isPrivacy;
        if (bkVar != null && bkVar.getBaijiahaoData() != null) {
            cardPersonDynamicThreadData.gIm = bkVar.getBaijiahaoData().oriUgcNid;
        }
        p pVar = new p(this.dIF);
        pVar.lQ(this.glW == 1);
        pVar.create();
        pVar.a(new p.a() { // from class: com.baidu.tieba.personPolymeric.tab.a.b.1
            @Override // com.baidu.tieba.card.p.a
            public void setPrivacy(boolean z) {
                if (z) {
                    l.showToast(b.this.dIF.getPageActivity(), (int) R.string.thread_has_hide);
                }
                b.this.a(z, bkVar);
            }
        });
        pVar.a(cardPersonDynamicThreadData);
        pVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, bk bkVar) {
        bk i;
        boolean z2 = false;
        if (bkVar != null && this.kuc != null && !v.isEmpty(this.kuc.cwr()) && this.kuc.cPH() != null && this.kuc.cPH().cPJ() != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.kuc.cwr().size()) {
                    break;
                }
                o oVar = this.kuc.cwr().get(i2);
                if (oVar != null && (i = com.baidu.tieba.personPolymeric.tab.b.a.i(oVar)) != null && !StringUtils.isNull(i.tid) && i.tid.equals(bkVar.tid)) {
                    i.isPrivacy = z;
                    c aB = com.baidu.tieba.personPolymeric.tab.b.a.aB(i);
                    if (aB != null) {
                        this.kuc.cwr().set(i2, aB);
                        z2 = true;
                        break;
                    }
                }
                i2++;
            }
            if (z2) {
                this.kuc.cPH().en(this.kuc.cwr());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kt(String str) {
        boolean z;
        bk i;
        if (!StringUtils.isNull(str) && this.kuc != null && !v.isEmpty(this.kuc.cwr()) && this.kuc.cPH() != null && this.kuc.cPH().cPJ() != null) {
            Iterator<o> it = this.kuc.cwr().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                o next = it.next();
                if (next != null && (i = com.baidu.tieba.personPolymeric.tab.b.a.i(next)) != null && i.getBaijiahaoData() != null && !StringUtils.isNull(i.getBaijiahaoData().oriUgcNid) && i.getBaijiahaoData().oriUgcNid.equals(str)) {
                    it.remove();
                    z = true;
                    break;
                }
            }
            if (z) {
                this.kuc.cPH().en(this.kuc.cwr());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeThread(String str) {
        boolean z;
        bk i;
        if (!StringUtils.isNull(str) && this.kuc != null && !v.isEmpty(this.kuc.cwr()) && this.kuc.cPH() != null && this.kuc.cPH().cPJ() != null) {
            Iterator<o> it = this.kuc.cwr().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                o next = it.next();
                if (next != null && (i = com.baidu.tieba.personPolymeric.tab.b.a.i(next)) != null && !StringUtils.isNull(i.tid) && i.tid.equals(str)) {
                    it.remove();
                    z = true;
                    break;
                }
            }
            if (z) {
                this.kuc.cPH().en(this.kuc.cwr());
            }
        }
    }
}
