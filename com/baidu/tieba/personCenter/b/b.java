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
    private PersonCenterModel jiL;
    private com.baidu.tieba.personCenter.view.c jiM;
    PersonCenterModel.a jiN = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(f fVar) {
            b.this.jiM.bcC();
            b.this.jiM.b(fVar);
            if (fVar != null && fVar.getUserData() != null) {
                e.a(fVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.jiL.mIsDataLoaded) {
                b.this.jiM.au(i, str);
            } else {
                b.this.jiM.bcB();
            }
        }
    };
    private CustomMessageListener jiO = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                com.baidu.tieba.p.b bVar = (com.baidu.tieba.p.b) customResponsedMessage.getData();
                if (bVar.jQD != null && bVar.jQD.size() > 0) {
                    b.a aVar = bVar.jQD.get(2);
                    b.a aVar2 = bVar.jQD.get(3);
                    b.a aVar3 = bVar.jQD.get(9);
                    b.a aVar4 = bVar.jQD.get(10);
                    if (b.this.jiL.cvI() != null) {
                        if (aVar2 != null) {
                            b.this.jiL.cvI().ro(aVar2.dGK);
                        }
                        if (aVar != null) {
                            b.this.jiL.cvI().rr(aVar.dGK);
                        }
                        if (aVar3 != null) {
                            b.this.jiL.cvI().rq(aVar3.dGK);
                        }
                        if (aVar4 != null) {
                            b.this.jiL.cvI().rp(aVar4.dGK);
                        }
                    }
                    b.a aVar5 = bVar.jQD.get(5);
                    if (aVar5 != null) {
                        b.this.jiM.P(5, aVar5.dGK);
                    }
                    b.a aVar6 = bVar.jQD.get(6);
                    if (aVar6 != null) {
                        b.this.jiM.P(6, aVar6.dGK);
                    }
                    b.this.jiM.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener dYr = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.p.a.cEk().so(false);
            }
        }
    };
    private CustomMessageListener jiP = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            m mVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof m) && (mVar = (m) customResponsedMessage.getData()) != null) {
                if (b.this.jiL.cvI() != null) {
                    b.this.jiL.cvI().a(mVar);
                    b.this.jiM.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.jiM = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.jiM.a(this);
        this.jiL = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.jiL.a(this.jiN);
        com.baidu.tieba.p.a.cEk();
        this.jiO.setTag(bdUniqueId);
        this.dYr.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jiO);
        MessageManager.getInstance().registerListener(this.dYr);
        this.jiP.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jiP);
    }

    public void GD(String str) {
        f cvI = this.jiL.cvI();
        if (cvI != null && cvI.getUserData() != null) {
            cvI.getUserData().setName_show(str);
            this.jiM.notifyDataSetChanged();
        }
    }

    public void GE(String str) {
        f cvI = this.jiL.cvI();
        if (cvI != null && cvI.getUserData() != null) {
            cvI.getUserData().setPortrait(str);
            this.jiM.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        this.jiL.LoadData();
    }

    public void initView() {
        this.jiM.initView();
    }

    public void rn(boolean z) {
        this.jiL.rn(z);
    }

    public void onDestroy() {
        this.jiM.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.jiM.onChangeSkinType(i);
    }

    public void cvz() {
        this.jiM.cvx();
    }

    public void cvA() {
        this.jiM.cvy();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void cJ(View view) {
        this.jiL.LoadData();
    }
}
