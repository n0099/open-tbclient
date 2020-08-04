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
    private PersonCenterModel kOO;
    private com.baidu.tieba.personCenter.view.c kOP;
    PersonCenterModel.a kOQ = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(f fVar) {
            long currentTimeMillis = System.currentTimeMillis();
            b.this.kOP.bwX();
            b.this.kOP.b(fVar);
            if (fVar != null && fVar.getUserData() != null) {
                e.a(fVar.getUserData().getPersonPrivate());
            }
            com.baidu.tieba.personCenter.a.cVz().fw(System.currentTimeMillis() - currentTimeMillis);
            long cVB = com.baidu.tieba.personCenter.a.cVz().cVB();
            if (cVB > 0) {
                com.baidu.tieba.personCenter.a.cVz().setRefreshTime(System.currentTimeMillis() - cVB);
                com.baidu.tieba.personCenter.a.cVz().fx(0L);
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.kOO.mIsDataLoaded) {
                b.this.kOP.aT(i, str);
            } else {
                b.this.kOP.bwW();
            }
        }
    };
    private CustomMessageListener kOR = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                com.baidu.tieba.p.b bVar = (com.baidu.tieba.p.b) customResponsedMessage.getData();
                if (bVar.luw != null && bVar.luw.size() > 0) {
                    b.a aVar = bVar.luw.get(2);
                    b.a aVar2 = bVar.luw.get(3);
                    b.a aVar3 = bVar.luw.get(9);
                    b.a aVar4 = bVar.luw.get(10);
                    if (b.this.kOO.cVN() != null) {
                        if (aVar2 != null) {
                            b.this.kOO.cVN().tK(aVar2.czr);
                        }
                        if (aVar != null) {
                            b.this.kOO.cVN().tN(aVar.czr);
                        }
                        if (aVar3 != null) {
                            b.this.kOO.cVN().tM(aVar3.czr);
                        }
                        if (aVar4 != null) {
                            b.this.kOO.cVN().tL(aVar4.czr);
                        }
                    }
                    b.a aVar5 = bVar.luw.get(5);
                    if (aVar5 != null) {
                        b.this.kOP.ab(5, aVar5.czr);
                    }
                    b.a aVar6 = bVar.luw.get(6);
                    if (aVar6 != null) {
                        b.this.kOP.ab(6, aVar6.czr);
                    }
                    b.this.kOP.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener fbR = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.p.a.ddy().uG(false);
            }
        }
    };
    private CustomMessageListener mUpdatePendantListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            l lVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l) && (lVar = (l) customResponsedMessage.getData()) != null) {
                if (b.this.kOO.cVN() != null) {
                    b.this.kOO.cVN().a(lVar);
                    b.this.kOP.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.kOP = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.kOP.a(this);
        this.kOO = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.kOO.a(this.kOQ);
        com.baidu.tieba.p.a.ddy();
        this.kOR.setTag(bdUniqueId);
        this.fbR.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.kOR);
        MessageManager.getInstance().registerListener(this.fbR);
        this.mUpdatePendantListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUpdatePendantListener);
    }

    public void Lr(String str) {
        f cVN = this.kOO.cVN();
        if (cVN != null && cVN.getUserData() != null) {
            cVN.getUserData().setName_show(str);
            this.kOP.notifyDataSetChanged();
        }
    }

    public void Ls(String str) {
        f cVN = this.kOO.cVN();
        if (cVN != null && cVN.getUserData() != null) {
            cVN.getUserData().setPortrait(str);
            this.kOP.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        com.baidu.tieba.personCenter.a.cVz().fx(System.currentTimeMillis());
        this.kOO.LoadData();
    }

    public void initView() {
        this.kOP.initView();
    }

    public void tJ(boolean z) {
        this.kOO.tJ(z);
    }

    public void onDestroy() {
        this.kOP.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.kOP.onChangeSkinType(i);
    }

    public void cVE() {
        this.kOP.cVC();
    }

    public void cVF() {
        this.kOP.cVD();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void cZ(View view) {
        this.kOO.LoadData();
    }
}
