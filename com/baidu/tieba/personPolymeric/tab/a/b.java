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
    private TbPageContext efn;
    private int gQW;
    private com.baidu.tieba.personPolymeric.tab.fragments.a lok;
    private final CustomMessageListener lol = new CustomMessageListener(2921428) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bw) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == b.this.mBdUniqueId && b.this.lok != null && b.this.lok.djj()) {
                b.this.aV((bw) customResponsedMessage.getData());
            }
        }
    };
    private final CustomMessageListener lom = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                b.this.removeThread((String) customResponsedMessage.getData());
            }
        }
    };
    private final CustomMessageListener loo = new CustomMessageListener(2921436) { // from class: com.baidu.tieba.personPolymeric.tab.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                b.this.OC((String) customResponsedMessage.getData());
            }
        }
    };
    private BdUniqueId mBdUniqueId;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.personPolymeric.tab.fragments.a aVar, int i) {
        this.efn = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.lok = aVar;
        this.gQW = i;
        this.lol.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.lol);
        this.lom.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.lom);
        this.loo.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.loo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aV(final bw bwVar) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
        cardPersonDynamicThreadData.dUS = bwVar;
        cardPersonDynamicThreadData.forumId = String.valueOf(bwVar.getFid());
        cardPersonDynamicThreadData.threadId = bwVar.tid;
        cardPersonDynamicThreadData.postId = bwVar.eel;
        cardPersonDynamicThreadData.isPrivacy = bwVar.isPrivacy;
        if (bwVar != null && bwVar.getBaijiahaoData() != null) {
            cardPersonDynamicThreadData.hnS = bwVar.getBaijiahaoData().oriUgcNid;
        }
        p pVar = new p(this.efn);
        pVar.nh(this.gQW == 1);
        pVar.create();
        pVar.a(new p.a() { // from class: com.baidu.tieba.personPolymeric.tab.a.b.1
            @Override // com.baidu.tieba.card.p.a
            public void setPrivacy(boolean z) {
                if (z) {
                    l.showToast(b.this.efn.getPageActivity(), R.string.thread_has_hide);
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
        if (bwVar != null && this.lok != null && !y.isEmpty(this.lok.cyS()) && this.lok.dji() != null && this.lok.dji().djk() != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.lok.cyS().size()) {
                    break;
                }
                q qVar = this.lok.cyS().get(i2);
                if (qVar != null && (i = com.baidu.tieba.personPolymeric.tab.b.a.i(qVar)) != null && !StringUtils.isNull(i.tid) && i.tid.equals(bwVar.tid)) {
                    i.isPrivacy = z;
                    c az = com.baidu.tieba.personPolymeric.tab.b.a.az(i);
                    if (az != null) {
                        this.lok.cyS().set(i2, az);
                        z2 = true;
                        break;
                    }
                }
                i2++;
            }
            if (z2) {
                this.lok.dji().eR(this.lok.cyS());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OC(String str) {
        boolean z;
        bw i;
        if (!StringUtils.isNull(str) && this.lok != null && !y.isEmpty(this.lok.cyS()) && this.lok.dji() != null && this.lok.dji().djk() != null) {
            Iterator<q> it = this.lok.cyS().iterator();
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
                this.lok.dji().eR(this.lok.cyS());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeThread(String str) {
        boolean z;
        bw i;
        if (!StringUtils.isNull(str) && this.lok != null && !y.isEmpty(this.lok.cyS()) && this.lok.dji() != null && this.lok.dji().djk() != null) {
            Iterator<q> it = this.lok.cyS().iterator();
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
                this.lok.dji().eR(this.lok.cyS());
            }
        }
    }
}
