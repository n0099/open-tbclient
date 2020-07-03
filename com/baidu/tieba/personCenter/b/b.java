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
    private PersonCenterModel kFK;
    private com.baidu.tieba.personCenter.view.c kFL;
    PersonCenterModel.a kFM = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(f fVar) {
            long currentTimeMillis = System.currentTimeMillis();
            b.this.kFL.btN();
            b.this.kFL.b(fVar);
            if (fVar != null && fVar.getUserData() != null) {
                e.a(fVar.getUserData().getPersonPrivate());
            }
            com.baidu.tieba.personCenter.a.cRI().fi(System.currentTimeMillis() - currentTimeMillis);
            long cRK = com.baidu.tieba.personCenter.a.cRI().cRK();
            if (cRK > 0) {
                com.baidu.tieba.personCenter.a.cRI().setRefreshTime(System.currentTimeMillis() - cRK);
                com.baidu.tieba.personCenter.a.cRI().fj(0L);
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.kFK.mIsDataLoaded) {
                b.this.kFL.aR(i, str);
            } else {
                b.this.kFL.btM();
            }
        }
    };
    private CustomMessageListener kFN = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                com.baidu.tieba.p.b bVar = (com.baidu.tieba.p.b) customResponsedMessage.getData();
                if (bVar.lmY != null && bVar.lmY.size() > 0) {
                    b.a aVar = bVar.lmY.get(2);
                    b.a aVar2 = bVar.lmY.get(3);
                    b.a aVar3 = bVar.lmY.get(9);
                    b.a aVar4 = bVar.lmY.get(10);
                    if (b.this.kFK.cRW() != null) {
                        if (aVar2 != null) {
                            b.this.kFK.cRW().te(aVar2.eDO);
                        }
                        if (aVar != null) {
                            b.this.kFK.cRW().th(aVar.eDO);
                        }
                        if (aVar3 != null) {
                            b.this.kFK.cRW().tg(aVar3.eDO);
                        }
                        if (aVar4 != null) {
                            b.this.kFK.cRW().tf(aVar4.eDO);
                        }
                    }
                    b.a aVar5 = bVar.lmY.get(5);
                    if (aVar5 != null) {
                        b.this.kFL.ac(5, aVar5.eDO);
                    }
                    b.a aVar6 = bVar.lmY.get(6);
                    if (aVar6 != null) {
                        b.this.kFL.ac(6, aVar6.eDO);
                    }
                    b.this.kFL.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener eXq = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.p.a.daq().uc(false);
            }
        }
    };
    private CustomMessageListener kFO = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            l lVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l) && (lVar = (l) customResponsedMessage.getData()) != null) {
                if (b.this.kFK.cRW() != null) {
                    b.this.kFK.cRW().a(lVar);
                    b.this.kFL.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.kFL = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.kFL.a(this);
        this.kFK = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.kFK.a(this.kFM);
        com.baidu.tieba.p.a.daq();
        this.kFN.setTag(bdUniqueId);
        this.eXq.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.kFN);
        MessageManager.getInstance().registerListener(this.eXq);
        this.kFO.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.kFO);
    }

    public void KD(String str) {
        f cRW = this.kFK.cRW();
        if (cRW != null && cRW.getUserData() != null) {
            cRW.getUserData().setName_show(str);
            this.kFL.notifyDataSetChanged();
        }
    }

    public void KE(String str) {
        f cRW = this.kFK.cRW();
        if (cRW != null && cRW.getUserData() != null) {
            cRW.getUserData().setPortrait(str);
            this.kFL.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        com.baidu.tieba.personCenter.a.cRI().fj(System.currentTimeMillis());
        this.kFK.LoadData();
    }

    public void initView() {
        this.kFL.initView();
    }

    public void td(boolean z) {
        this.kFK.td(z);
    }

    public void onDestroy() {
        this.kFL.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.kFL.onChangeSkinType(i);
    }

    public void cRN() {
        this.kFL.cRL();
    }

    public void cRO() {
        this.kFL.cRM();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void cT(View view) {
        this.kFK.LoadData();
    }
}
