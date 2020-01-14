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
/* loaded from: classes9.dex */
public class b {
    private TbPageContext cRe;
    private int fpl;
    private com.baidu.tieba.personPolymeric.tab.fragments.a jph;
    private final CustomMessageListener jpi = new CustomMessageListener(2921428) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == b.this.mBdUniqueId && b.this.jph != null && b.this.jph.cwj()) {
                b.this.aR((bj) customResponsedMessage.getData());
            }
        }
    };
    private final CustomMessageListener jpj = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                b.this.removeThread((String) customResponsedMessage.getData());
            }
        }
    };
    private final CustomMessageListener jpk = new CustomMessageListener(2921436) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                b.this.GI((String) customResponsedMessage.getData());
            }
        }
    };
    private BdUniqueId mBdUniqueId;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.personPolymeric.tab.fragments.a aVar, int i) {
        this.cRe = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.jph = aVar;
        this.fpl = i;
        this.jpi.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jpi);
        this.jpj.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jpj);
        this.jpk.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jpk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(final bj bjVar) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
        cardPersonDynamicThreadData.cNb = bjVar;
        cardPersonDynamicThreadData.forumId = String.valueOf(bjVar.getFid());
        cardPersonDynamicThreadData.threadId = bjVar.tid;
        cardPersonDynamicThreadData.postId = bjVar.cQr;
        cardPersonDynamicThreadData.isPrivacy = bjVar.isPrivacy;
        if (bjVar != null && bjVar.getBaijiahaoData() != null) {
            cardPersonDynamicThreadData.fLv = bjVar.getBaijiahaoData().oriUgcNid;
        }
        o oVar = new o(this.cRe);
        oVar.kk(this.fpl == 1);
        oVar.create();
        oVar.a(new o.a() { // from class: com.baidu.tieba.personPolymeric.tab.a.b.1
            @Override // com.baidu.tieba.card.o.a
            public void setPrivacy(boolean z) {
                if (z) {
                    l.showToast(b.this.cRe.getPageActivity(), (int) R.string.thread_has_hide);
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
        if (bjVar != null && this.jph != null && !v.isEmpty(this.jph.cdi()) && this.jph.cwi() != null && this.jph.cwi().cwk() != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.jph.cdi().size()) {
                    break;
                }
                m mVar = this.jph.cdi().get(i2);
                if (mVar != null && (i = com.baidu.tieba.personPolymeric.tab.b.a.i(mVar)) != null && !StringUtils.isNull(i.tid) && i.tid.equals(bjVar.tid)) {
                    i.isPrivacy = z;
                    m aS = com.baidu.tieba.personPolymeric.tab.b.a.aS(i);
                    if (aS != null) {
                        this.jph.cdi().set(i2, aS);
                        z2 = true;
                        break;
                    }
                }
                i2++;
            }
            if (z2) {
                this.jph.cwi().dY(this.jph.cdi());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GI(String str) {
        boolean z;
        bj i;
        if (!StringUtils.isNull(str) && this.jph != null && !v.isEmpty(this.jph.cdi()) && this.jph.cwi() != null && this.jph.cwi().cwk() != null) {
            Iterator<m> it = this.jph.cdi().iterator();
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
                this.jph.cwi().dY(this.jph.cdi());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeThread(String str) {
        boolean z;
        bj i;
        if (!StringUtils.isNull(str) && this.jph != null && !v.isEmpty(this.jph.cdi()) && this.jph.cwi() != null && this.jph.cwi().cwk() != null) {
            Iterator<m> it = this.jph.cdi().iterator();
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
                this.jph.cwi().dY(this.jph.cdi());
            }
        }
    }
}
