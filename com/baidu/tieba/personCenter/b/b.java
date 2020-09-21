package com.baidu.tieba.personCenter.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.a.e;
import com.baidu.tbadk.data.m;
import com.baidu.tieba.p.b;
import com.baidu.tieba.personCenter.c.f;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import com.baidu.tieba.personCenter.view.c;
/* loaded from: classes21.dex */
public class b implements c.a {
    private PersonCenterModel lnD;
    private com.baidu.tieba.personCenter.view.c lnE;
    PersonCenterModel.a lnF = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(f fVar) {
            long currentTimeMillis = System.currentTimeMillis();
            b.this.lnE.bHn();
            b.this.lnE.b(fVar);
            if (fVar != null && fVar.getUserData() != null) {
                e.a(fVar.getUserData().getPersonPrivate());
            }
            com.baidu.tieba.personCenter.a.dka().fW(System.currentTimeMillis() - currentTimeMillis);
            long dkc = com.baidu.tieba.personCenter.a.dka().dkc();
            if (dkc > 0) {
                com.baidu.tieba.personCenter.a.dka().setRefreshTime(System.currentTimeMillis() - dkc);
                com.baidu.tieba.personCenter.a.dka().fX(0L);
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.lnD.mIsDataLoaded) {
                b.this.lnE.aR(i, str);
            } else {
                b.this.lnE.bHm();
            }
        }
    };
    private CustomMessageListener lnG = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                com.baidu.tieba.p.b bVar = (com.baidu.tieba.p.b) customResponsedMessage.getData();
                if (bVar.lUQ != null && bVar.lUQ.size() > 0) {
                    b.a aVar = bVar.lUQ.get(2);
                    b.a aVar2 = bVar.lUQ.get(3);
                    b.a aVar3 = bVar.lUQ.get(9);
                    b.a aVar4 = bVar.lUQ.get(10);
                    if (b.this.lnD.dkq() != null) {
                        if (aVar2 != null) {
                            b.this.lnD.dkq().uE(aVar2.cJF);
                        }
                        if (aVar != null) {
                            b.this.lnD.dkq().uH(aVar.cJF);
                        }
                        if (aVar3 != null) {
                            b.this.lnD.dkq().uG(aVar3.cJF);
                        }
                        if (aVar4 != null) {
                            b.this.lnD.dkq().uF(aVar4.cJF);
                        }
                    }
                    b.a aVar5 = bVar.lUQ.get(5);
                    if (aVar5 != null) {
                        b.this.lnE.ae(5, aVar5.cJF);
                    }
                    b.a aVar6 = bVar.lUQ.get(6);
                    if (aVar6 != null) {
                        b.this.lnE.ae(6, aVar6.cJF);
                    }
                    b.this.lnE.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener fqu = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.p.a.dsD().vF(false);
            }
        }
    };
    private CustomMessageListener mUpdatePendantListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            m mVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof m) && (mVar = (m) customResponsedMessage.getData()) != null) {
                if (b.this.lnD.dkq() != null) {
                    b.this.lnD.dkq().a(mVar);
                    b.this.lnE.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.lnE = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.lnE.a(this);
        this.lnD = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.lnD.a(this.lnF);
        com.baidu.tieba.p.a.dsD();
        this.lnG.setTag(bdUniqueId);
        this.fqu.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.lnG);
        MessageManager.getInstance().registerListener(this.fqu);
        this.mUpdatePendantListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUpdatePendantListener);
    }

    public void OM(String str) {
        f dkq = this.lnD.dkq();
        if (dkq != null && dkq.getUserData() != null) {
            dkq.getUserData().setName_show(str);
            this.lnE.notifyDataSetChanged();
        }
    }

    public void ON(String str) {
        f dkq = this.lnD.dkq();
        if (dkq != null && dkq.getUserData() != null) {
            dkq.getUserData().setPortrait(str);
            this.lnE.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        com.baidu.tieba.personCenter.a.dka().fX(System.currentTimeMillis());
        this.lnD.LoadData();
    }

    public void initView() {
        this.lnE.initView();
    }

    public void uD(boolean z) {
        this.lnD.uD(z);
    }

    public void onDestroy() {
        this.lnE.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.lnE.onChangeSkinType(i);
    }

    public void dkh() {
        this.lnE.dkf();
    }

    public void dki() {
        this.lnE.dkg();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void dl(View view) {
        this.lnD.LoadData();
    }
}
