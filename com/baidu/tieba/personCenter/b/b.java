package com.baidu.tieba.personCenter.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.a.e;
import com.baidu.tbadk.data.l;
import com.baidu.tieba.p.b;
import com.baidu.tieba.personCenter.c.f;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import com.baidu.tieba.personCenter.view.c;
/* loaded from: classes16.dex */
public class b implements c.a {
    private PersonCenterModel leL;
    private com.baidu.tieba.personCenter.view.c leM;
    PersonCenterModel.a leN = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(f fVar) {
            long currentTimeMillis = System.currentTimeMillis();
            b.this.leM.bFX();
            b.this.leM.b(fVar);
            if (fVar != null && fVar.getUserData() != null) {
                e.a(fVar.getUserData().getPersonPrivate());
            }
            com.baidu.tieba.personCenter.a.dgx().fI(System.currentTimeMillis() - currentTimeMillis);
            long dgz = com.baidu.tieba.personCenter.a.dgx().dgz();
            if (dgz > 0) {
                com.baidu.tieba.personCenter.a.dgx().setRefreshTime(System.currentTimeMillis() - dgz);
                com.baidu.tieba.personCenter.a.dgx().fJ(0L);
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.leL.mIsDataLoaded) {
                b.this.leM.aQ(i, str);
            } else {
                b.this.leM.bFW();
            }
        }
    };
    private CustomMessageListener leO = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                com.baidu.tieba.p.b bVar = (com.baidu.tieba.p.b) customResponsedMessage.getData();
                if (bVar.lLW != null && bVar.lLW.size() > 0) {
                    b.a aVar = bVar.lLW.get(2);
                    b.a aVar2 = bVar.lLW.get(3);
                    b.a aVar3 = bVar.lLW.get(9);
                    b.a aVar4 = bVar.lLW.get(10);
                    if (b.this.leL.dgL() != null) {
                        if (aVar2 != null) {
                            b.this.leL.dgL().uw(aVar2.cHF);
                        }
                        if (aVar != null) {
                            b.this.leL.dgL().uz(aVar.cHF);
                        }
                        if (aVar3 != null) {
                            b.this.leL.dgL().uy(aVar3.cHF);
                        }
                        if (aVar4 != null) {
                            b.this.leL.dgL().ux(aVar4.cHF);
                        }
                    }
                    b.a aVar5 = bVar.lLW.get(5);
                    if (aVar5 != null) {
                        b.this.leM.ad(5, aVar5.cHF);
                    }
                    b.a aVar6 = bVar.lLW.get(6);
                    if (aVar6 != null) {
                        b.this.leM.ad(6, aVar6.cHF);
                    }
                    b.this.leM.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener fnp = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.p.a.doT().vx(false);
            }
        }
    };
    private CustomMessageListener mUpdatePendantListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            l lVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l) && (lVar = (l) customResponsedMessage.getData()) != null) {
                if (b.this.leL.dgL() != null) {
                    b.this.leL.dgL().a(lVar);
                    b.this.leM.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.leM = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.leM.a(this);
        this.leL = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.leL.a(this.leN);
        com.baidu.tieba.p.a.doT();
        this.leO.setTag(bdUniqueId);
        this.fnp.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.leO);
        MessageManager.getInstance().registerListener(this.fnp);
        this.mUpdatePendantListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUpdatePendantListener);
    }

    public void Ol(String str) {
        f dgL = this.leL.dgL();
        if (dgL != null && dgL.getUserData() != null) {
            dgL.getUserData().setName_show(str);
            this.leM.notifyDataSetChanged();
        }
    }

    public void Om(String str) {
        f dgL = this.leL.dgL();
        if (dgL != null && dgL.getUserData() != null) {
            dgL.getUserData().setPortrait(str);
            this.leM.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        com.baidu.tieba.personCenter.a.dgx().fJ(System.currentTimeMillis());
        this.leL.LoadData();
    }

    public void initView() {
        this.leM.initView();
    }

    public void uv(boolean z) {
        this.leL.uv(z);
    }

    public void onDestroy() {
        this.leM.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.leM.onChangeSkinType(i);
    }

    public void dgC() {
        this.leM.dgA();
    }

    public void dgD() {
        this.leM.dgB();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void dd(View view) {
        this.leL.LoadData();
    }
}
