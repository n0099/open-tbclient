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
    private PersonCenterModel kkR;
    private com.baidu.tieba.personCenter.view.c kkS;
    PersonCenterModel.a kkT = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(f fVar) {
            long currentTimeMillis = System.currentTimeMillis();
            b.this.kkS.bqO();
            b.this.kkS.b(fVar);
            if (fVar != null && fVar.getUserData() != null) {
                e.a(fVar.getUserData().getPersonPrivate());
            }
            com.baidu.tieba.personCenter.a.cNb().ff(System.currentTimeMillis() - currentTimeMillis);
            long cNd = com.baidu.tieba.personCenter.a.cNb().cNd();
            if (cNd > 0) {
                com.baidu.tieba.personCenter.a.cNb().setRefreshTime(System.currentTimeMillis() - cNd);
                com.baidu.tieba.personCenter.a.cNb().fg(0L);
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.kkR.mIsDataLoaded) {
                b.this.kkS.aO(i, str);
            } else {
                b.this.kkS.bqN();
            }
        }
    };
    private CustomMessageListener kkU = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                com.baidu.tieba.p.b bVar = (com.baidu.tieba.p.b) customResponsedMessage.getData();
                if (bVar.kRX != null && bVar.kRX.size() > 0) {
                    b.a aVar = bVar.kRX.get(2);
                    b.a aVar2 = bVar.kRX.get(3);
                    b.a aVar3 = bVar.kRX.get(9);
                    b.a aVar4 = bVar.kRX.get(10);
                    if (b.this.kkR.cNp() != null) {
                        if (aVar2 != null) {
                            b.this.kkR.cNp().sQ(aVar2.euK);
                        }
                        if (aVar != null) {
                            b.this.kkR.cNp().sT(aVar.euK);
                        }
                        if (aVar3 != null) {
                            b.this.kkR.cNp().sS(aVar3.euK);
                        }
                        if (aVar4 != null) {
                            b.this.kkR.cNp().sR(aVar4.euK);
                        }
                    }
                    b.a aVar5 = bVar.kRX.get(5);
                    if (aVar5 != null) {
                        b.this.kkS.Z(5, aVar5.euK);
                    }
                    b.a aVar6 = bVar.kRX.get(6);
                    if (aVar6 != null) {
                        b.this.kkS.Z(6, aVar6.euK);
                    }
                    b.this.kkS.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener eMT = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.p.a.cVL().tN(false);
            }
        }
    };
    private CustomMessageListener kkV = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            l lVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l) && (lVar = (l) customResponsedMessage.getData()) != null) {
                if (b.this.kkR.cNp() != null) {
                    b.this.kkR.cNp().a(lVar);
                    b.this.kkS.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.kkS = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.kkS.a(this);
        this.kkR = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.kkR.a(this.kkT);
        com.baidu.tieba.p.a.cVL();
        this.kkU.setTag(bdUniqueId);
        this.eMT.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.kkU);
        MessageManager.getInstance().registerListener(this.eMT);
        this.kkV.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.kkV);
    }

    public void Ka(String str) {
        f cNp = this.kkR.cNp();
        if (cNp != null && cNp.getUserData() != null) {
            cNp.getUserData().setName_show(str);
            this.kkS.notifyDataSetChanged();
        }
    }

    public void Kb(String str) {
        f cNp = this.kkR.cNp();
        if (cNp != null && cNp.getUserData() != null) {
            cNp.getUserData().setPortrait(str);
            this.kkS.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        com.baidu.tieba.personCenter.a.cNb().fg(System.currentTimeMillis());
        this.kkR.LoadData();
    }

    public void initView() {
        this.kkS.initView();
    }

    public void sP(boolean z) {
        this.kkR.sP(z);
    }

    public void onDestroy() {
        this.kkS.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.kkS.onChangeSkinType(i);
    }

    public void cNg() {
        this.kkS.cNe();
    }

    public void cNh() {
        this.kkS.cNf();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void cS(View view) {
        this.kkR.LoadData();
    }
}
