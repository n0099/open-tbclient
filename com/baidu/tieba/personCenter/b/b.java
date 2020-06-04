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
/* loaded from: classes9.dex */
public class b implements c.a {
    private PersonCenterModel klX;
    private com.baidu.tieba.personCenter.view.c klY;
    PersonCenterModel.a klZ = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(f fVar) {
            long currentTimeMillis = System.currentTimeMillis();
            b.this.klY.bqQ();
            b.this.klY.b(fVar);
            if (fVar != null && fVar.getUserData() != null) {
                e.a(fVar.getUserData().getPersonPrivate());
            }
            com.baidu.tieba.personCenter.a.cNr().ff(System.currentTimeMillis() - currentTimeMillis);
            long cNt = com.baidu.tieba.personCenter.a.cNr().cNt();
            if (cNt > 0) {
                com.baidu.tieba.personCenter.a.cNr().setRefreshTime(System.currentTimeMillis() - cNt);
                com.baidu.tieba.personCenter.a.cNr().fg(0L);
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.klX.mIsDataLoaded) {
                b.this.klY.aO(i, str);
            } else {
                b.this.klY.bqP();
            }
        }
    };
    private CustomMessageListener kma = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                com.baidu.tieba.p.b bVar = (com.baidu.tieba.p.b) customResponsedMessage.getData();
                if (bVar.kTg != null && bVar.kTg.size() > 0) {
                    b.a aVar = bVar.kTg.get(2);
                    b.a aVar2 = bVar.kTg.get(3);
                    b.a aVar3 = bVar.kTg.get(9);
                    b.a aVar4 = bVar.kTg.get(10);
                    if (b.this.klX.cNF() != null) {
                        if (aVar2 != null) {
                            b.this.klX.cNF().sQ(aVar2.euK);
                        }
                        if (aVar != null) {
                            b.this.klX.cNF().sT(aVar.euK);
                        }
                        if (aVar3 != null) {
                            b.this.klX.cNF().sS(aVar3.euK);
                        }
                        if (aVar4 != null) {
                            b.this.klX.cNF().sR(aVar4.euK);
                        }
                    }
                    b.a aVar5 = bVar.kTg.get(5);
                    if (aVar5 != null) {
                        b.this.klY.Z(5, aVar5.euK);
                    }
                    b.a aVar6 = bVar.kTg.get(6);
                    if (aVar6 != null) {
                        b.this.klY.Z(6, aVar6.euK);
                    }
                    b.this.klY.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener eNe = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.p.a.cWb().tN(false);
            }
        }
    };
    private CustomMessageListener kmb = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            l lVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l) && (lVar = (l) customResponsedMessage.getData()) != null) {
                if (b.this.klX.cNF() != null) {
                    b.this.klX.cNF().a(lVar);
                    b.this.klY.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.klY = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.klY.a(this);
        this.klX = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.klX.a(this.klZ);
        com.baidu.tieba.p.a.cWb();
        this.kma.setTag(bdUniqueId);
        this.eNe.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.kma);
        MessageManager.getInstance().registerListener(this.eNe);
        this.kmb.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.kmb);
    }

    public void Kb(String str) {
        f cNF = this.klX.cNF();
        if (cNF != null && cNF.getUserData() != null) {
            cNF.getUserData().setName_show(str);
            this.klY.notifyDataSetChanged();
        }
    }

    public void Kc(String str) {
        f cNF = this.klX.cNF();
        if (cNF != null && cNF.getUserData() != null) {
            cNF.getUserData().setPortrait(str);
            this.klY.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        com.baidu.tieba.personCenter.a.cNr().fg(System.currentTimeMillis());
        this.klX.LoadData();
    }

    public void initView() {
        this.klY.initView();
    }

    public void sP(boolean z) {
        this.klX.sP(z);
    }

    public void onDestroy() {
        this.klY.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.klY.onChangeSkinType(i);
    }

    public void cNw() {
        this.klY.cNu();
    }

    public void cNx() {
        this.klY.cNv();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void cS(View view) {
        this.klX.LoadData();
    }
}
