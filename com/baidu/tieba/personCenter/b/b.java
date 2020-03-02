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
    private PersonCenterModel jgZ;
    private com.baidu.tieba.personCenter.view.c jha;
    PersonCenterModel.a jhb = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(f fVar) {
            b.this.jha.bcx();
            b.this.jha.b(fVar);
            if (fVar != null && fVar.getUserData() != null) {
                e.a(fVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.jgZ.mIsDataLoaded) {
                b.this.jha.au(i, str);
            } else {
                b.this.jha.bcw();
            }
        }
    };
    private CustomMessageListener jhc = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                com.baidu.tieba.p.b bVar = (com.baidu.tieba.p.b) customResponsedMessage.getData();
                if (bVar.jOP != null && bVar.jOP.size() > 0) {
                    b.a aVar = bVar.jOP.get(2);
                    b.a aVar2 = bVar.jOP.get(3);
                    b.a aVar3 = bVar.jOP.get(9);
                    b.a aVar4 = bVar.jOP.get(10);
                    if (b.this.jgZ.cvo() != null) {
                        if (aVar2 != null) {
                            b.this.jgZ.cvo().ri(aVar2.dGh);
                        }
                        if (aVar != null) {
                            b.this.jgZ.cvo().rl(aVar.dGh);
                        }
                        if (aVar3 != null) {
                            b.this.jgZ.cvo().rk(aVar3.dGh);
                        }
                        if (aVar4 != null) {
                            b.this.jgZ.cvo().rj(aVar4.dGh);
                        }
                    }
                    b.a aVar5 = bVar.jOP.get(5);
                    if (aVar5 != null) {
                        b.this.jha.P(5, aVar5.dGh);
                    }
                    b.a aVar6 = bVar.jOP.get(6);
                    if (aVar6 != null) {
                        b.this.jha.P(6, aVar6.dGh);
                    }
                    b.this.jha.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener dXO = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.p.a.cDP().si(false);
            }
        }
    };
    private CustomMessageListener jhd = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            m mVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof m) && (mVar = (m) customResponsedMessage.getData()) != null) {
                if (b.this.jgZ.cvo() != null) {
                    b.this.jgZ.cvo().a(mVar);
                    b.this.jha.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.jha = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.jha.a(this);
        this.jgZ = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.jgZ.a(this.jhb);
        com.baidu.tieba.p.a.cDP();
        this.jhc.setTag(bdUniqueId);
        this.dXO.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jhc);
        MessageManager.getInstance().registerListener(this.dXO);
        this.jhd.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jhd);
    }

    public void GD(String str) {
        f cvo = this.jgZ.cvo();
        if (cvo != null && cvo.getUserData() != null) {
            cvo.getUserData().setName_show(str);
            this.jha.notifyDataSetChanged();
        }
    }

    public void GE(String str) {
        f cvo = this.jgZ.cvo();
        if (cvo != null && cvo.getUserData() != null) {
            cvo.getUserData().setPortrait(str);
            this.jha.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        this.jgZ.LoadData();
    }

    public void initView() {
        this.jha.initView();
    }

    public void rh(boolean z) {
        this.jgZ.rh(z);
    }

    public void onDestroy() {
        this.jha.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.jha.onChangeSkinType(i);
    }

    public void cvf() {
        this.jha.cvd();
    }

    public void cvg() {
        this.jha.cve();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void cJ(View view) {
        this.jgZ.LoadData();
    }
}
