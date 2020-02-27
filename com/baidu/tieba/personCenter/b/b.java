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
/* loaded from: classes9.dex */
public class b implements c.a {
    private PersonCenterModel jgX;
    private com.baidu.tieba.personCenter.view.c jgY;
    PersonCenterModel.a jgZ = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(f fVar) {
            b.this.jgY.bcv();
            b.this.jgY.b(fVar);
            if (fVar != null && fVar.getUserData() != null) {
                e.a(fVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.jgX.mIsDataLoaded) {
                b.this.jgY.au(i, str);
            } else {
                b.this.jgY.bcu();
            }
        }
    };
    private CustomMessageListener jha = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                com.baidu.tieba.p.b bVar = (com.baidu.tieba.p.b) customResponsedMessage.getData();
                if (bVar.jON != null && bVar.jON.size() > 0) {
                    b.a aVar = bVar.jON.get(2);
                    b.a aVar2 = bVar.jON.get(3);
                    b.a aVar3 = bVar.jON.get(9);
                    b.a aVar4 = bVar.jON.get(10);
                    if (b.this.jgX.cvm() != null) {
                        if (aVar2 != null) {
                            b.this.jgX.cvm().ri(aVar2.dGg);
                        }
                        if (aVar != null) {
                            b.this.jgX.cvm().rl(aVar.dGg);
                        }
                        if (aVar3 != null) {
                            b.this.jgX.cvm().rk(aVar3.dGg);
                        }
                        if (aVar4 != null) {
                            b.this.jgX.cvm().rj(aVar4.dGg);
                        }
                    }
                    b.a aVar5 = bVar.jON.get(5);
                    if (aVar5 != null) {
                        b.this.jgY.P(5, aVar5.dGg);
                    }
                    b.a aVar6 = bVar.jON.get(6);
                    if (aVar6 != null) {
                        b.this.jgY.P(6, aVar6.dGg);
                    }
                    b.this.jgY.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener dXN = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.p.a.cDN().si(false);
            }
        }
    };
    private CustomMessageListener jhb = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            m mVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof m) && (mVar = (m) customResponsedMessage.getData()) != null) {
                if (b.this.jgX.cvm() != null) {
                    b.this.jgX.cvm().a(mVar);
                    b.this.jgY.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.jgY = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.jgY.a(this);
        this.jgX = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.jgX.a(this.jgZ);
        com.baidu.tieba.p.a.cDN();
        this.jha.setTag(bdUniqueId);
        this.dXN.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jha);
        MessageManager.getInstance().registerListener(this.dXN);
        this.jhb.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jhb);
    }

    public void GD(String str) {
        f cvm = this.jgX.cvm();
        if (cvm != null && cvm.getUserData() != null) {
            cvm.getUserData().setName_show(str);
            this.jgY.notifyDataSetChanged();
        }
    }

    public void GE(String str) {
        f cvm = this.jgX.cvm();
        if (cvm != null && cvm.getUserData() != null) {
            cvm.getUserData().setPortrait(str);
            this.jgY.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        this.jgX.LoadData();
    }

    public void initView() {
        this.jgY.initView();
    }

    public void rh(boolean z) {
        this.jgX.rh(z);
    }

    public void onDestroy() {
        this.jgY.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.jgY.onChangeSkinType(i);
    }

    public void cvd() {
        this.jgY.cvb();
    }

    public void cve() {
        this.jgY.cvc();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void cJ(View view) {
        this.jgX.LoadData();
    }
}
