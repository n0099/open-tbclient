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
    private PersonCenterModel leE;
    private com.baidu.tieba.personCenter.view.c leF;
    PersonCenterModel.a leG = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(f fVar) {
            long currentTimeMillis = System.currentTimeMillis();
            b.this.leF.bFW();
            b.this.leF.b(fVar);
            if (fVar != null && fVar.getUserData() != null) {
                e.a(fVar.getUserData().getPersonPrivate());
            }
            com.baidu.tieba.personCenter.a.dgw().fI(System.currentTimeMillis() - currentTimeMillis);
            long dgy = com.baidu.tieba.personCenter.a.dgw().dgy();
            if (dgy > 0) {
                com.baidu.tieba.personCenter.a.dgw().setRefreshTime(System.currentTimeMillis() - dgy);
                com.baidu.tieba.personCenter.a.dgw().fJ(0L);
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.leE.mIsDataLoaded) {
                b.this.leF.aR(i, str);
            } else {
                b.this.leF.bFV();
            }
        }
    };
    private CustomMessageListener leH = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                com.baidu.tieba.p.b bVar = (com.baidu.tieba.p.b) customResponsedMessage.getData();
                if (bVar.lLJ != null && bVar.lLJ.size() > 0) {
                    b.a aVar = bVar.lLJ.get(2);
                    b.a aVar2 = bVar.lLJ.get(3);
                    b.a aVar3 = bVar.lLJ.get(9);
                    b.a aVar4 = bVar.lLJ.get(10);
                    if (b.this.leE.dgK() != null) {
                        if (aVar2 != null) {
                            b.this.leE.dgK().uu(aVar2.cHB);
                        }
                        if (aVar != null) {
                            b.this.leE.dgK().ux(aVar.cHB);
                        }
                        if (aVar3 != null) {
                            b.this.leE.dgK().uw(aVar3.cHB);
                        }
                        if (aVar4 != null) {
                            b.this.leE.dgK().uv(aVar4.cHB);
                        }
                    }
                    b.a aVar5 = bVar.lLJ.get(5);
                    if (aVar5 != null) {
                        b.this.leF.ad(5, aVar5.cHB);
                    }
                    b.a aVar6 = bVar.lLJ.get(6);
                    if (aVar6 != null) {
                        b.this.leF.ad(6, aVar6.cHB);
                    }
                    b.this.leF.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener fnl = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.p.a.doQ().vv(false);
            }
        }
    };
    private CustomMessageListener mUpdatePendantListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            l lVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l) && (lVar = (l) customResponsedMessage.getData()) != null) {
                if (b.this.leE.dgK() != null) {
                    b.this.leE.dgK().a(lVar);
                    b.this.leF.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.leF = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.leF.a(this);
        this.leE = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.leE.a(this.leG);
        com.baidu.tieba.p.a.doQ();
        this.leH.setTag(bdUniqueId);
        this.fnl.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.leH);
        MessageManager.getInstance().registerListener(this.fnl);
        this.mUpdatePendantListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUpdatePendantListener);
    }

    public void Ok(String str) {
        f dgK = this.leE.dgK();
        if (dgK != null && dgK.getUserData() != null) {
            dgK.getUserData().setName_show(str);
            this.leF.notifyDataSetChanged();
        }
    }

    public void Ol(String str) {
        f dgK = this.leE.dgK();
        if (dgK != null && dgK.getUserData() != null) {
            dgK.getUserData().setPortrait(str);
            this.leF.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        com.baidu.tieba.personCenter.a.dgw().fJ(System.currentTimeMillis());
        this.leE.LoadData();
    }

    public void initView() {
        this.leF.initView();
    }

    public void ut(boolean z) {
        this.leE.ut(z);
    }

    public void onDestroy() {
        this.leF.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.leF.onChangeSkinType(i);
    }

    public void dgB() {
        this.leF.dgz();
    }

    public void dgC() {
        this.leF.dgA();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void dd(View view) {
        this.leE.LoadData();
    }
}
