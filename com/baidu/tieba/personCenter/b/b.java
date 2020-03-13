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
    private PersonCenterModel jhl;
    private com.baidu.tieba.personCenter.view.c jhm;
    PersonCenterModel.a jhn = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(f fVar) {
            b.this.jhm.bcy();
            b.this.jhm.b(fVar);
            if (fVar != null && fVar.getUserData() != null) {
                e.a(fVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.jhl.mIsDataLoaded) {
                b.this.jhm.au(i, str);
            } else {
                b.this.jhm.bcx();
            }
        }
    };
    private CustomMessageListener jho = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                com.baidu.tieba.p.b bVar = (com.baidu.tieba.p.b) customResponsedMessage.getData();
                if (bVar.jPb != null && bVar.jPb.size() > 0) {
                    b.a aVar = bVar.jPb.get(2);
                    b.a aVar2 = bVar.jPb.get(3);
                    b.a aVar3 = bVar.jPb.get(9);
                    b.a aVar4 = bVar.jPb.get(10);
                    if (b.this.jhl.cvp() != null) {
                        if (aVar2 != null) {
                            b.this.jhl.cvp().ri(aVar2.dGu);
                        }
                        if (aVar != null) {
                            b.this.jhl.cvp().rl(aVar.dGu);
                        }
                        if (aVar3 != null) {
                            b.this.jhl.cvp().rk(aVar3.dGu);
                        }
                        if (aVar4 != null) {
                            b.this.jhl.cvp().rj(aVar4.dGu);
                        }
                    }
                    b.a aVar5 = bVar.jPb.get(5);
                    if (aVar5 != null) {
                        b.this.jhm.P(5, aVar5.dGu);
                    }
                    b.a aVar6 = bVar.jPb.get(6);
                    if (aVar6 != null) {
                        b.this.jhm.P(6, aVar6.dGu);
                    }
                    b.this.jhm.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener dYb = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.p.a.cDQ().si(false);
            }
        }
    };
    private CustomMessageListener jhp = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            m mVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof m) && (mVar = (m) customResponsedMessage.getData()) != null) {
                if (b.this.jhl.cvp() != null) {
                    b.this.jhl.cvp().a(mVar);
                    b.this.jhm.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.jhm = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.jhm.a(this);
        this.jhl = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.jhl.a(this.jhn);
        com.baidu.tieba.p.a.cDQ();
        this.jho.setTag(bdUniqueId);
        this.dYb.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jho);
        MessageManager.getInstance().registerListener(this.dYb);
        this.jhp.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jhp);
    }

    public void GE(String str) {
        f cvp = this.jhl.cvp();
        if (cvp != null && cvp.getUserData() != null) {
            cvp.getUserData().setName_show(str);
            this.jhm.notifyDataSetChanged();
        }
    }

    public void GF(String str) {
        f cvp = this.jhl.cvp();
        if (cvp != null && cvp.getUserData() != null) {
            cvp.getUserData().setPortrait(str);
            this.jhm.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        this.jhl.LoadData();
    }

    public void initView() {
        this.jhm.initView();
    }

    public void rh(boolean z) {
        this.jhl.rh(z);
    }

    public void onDestroy() {
        this.jhm.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.jhm.onChangeSkinType(i);
    }

    public void cvg() {
        this.jhm.cve();
    }

    public void cvh() {
        this.jhm.cvf();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void cJ(View view) {
        this.jhl.LoadData();
    }
}
