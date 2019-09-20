package com.baidu.tieba.personCenter.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.a.e;
import com.baidu.tbadk.data.l;
import com.baidu.tieba.o.b;
import com.baidu.tieba.personCenter.data.f;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import com.baidu.tieba.personCenter.view.c;
/* loaded from: classes4.dex */
public class b implements c.a {
    private PersonCenterModel imL;
    private com.baidu.tieba.personCenter.view.c imM;
    PersonCenterModel.a imN = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(f fVar) {
            b.this.imM.aJN();
            b.this.imM.b(fVar);
            if (fVar != null && fVar.getUserData() != null) {
                e.a(fVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.imL.mIsDataLoaded) {
                b.this.imM.V(i, str);
            } else {
                b.this.imM.aJM();
            }
        }
    };
    private CustomMessageListener imO = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                com.baidu.tieba.o.b bVar = (com.baidu.tieba.o.b) customResponsedMessage.getData();
                if (bVar.iRK != null && bVar.iRK.size() > 0) {
                    b.a aVar = bVar.iRK.get(2);
                    b.a aVar2 = bVar.iRK.get(3);
                    b.a aVar3 = bVar.iRK.get(9);
                    b.a aVar4 = bVar.iRK.get(10);
                    if (b.this.imL.ccs() != null) {
                        if (aVar2 != null) {
                            b.this.imL.ccs().pG(aVar2.hmj);
                        }
                        if (aVar != null) {
                            b.this.imL.ccs().pJ(aVar.hmj);
                        }
                        if (aVar3 != null) {
                            b.this.imL.ccs().pI(aVar3.hmj);
                        }
                        if (aVar4 != null) {
                            b.this.imL.ccs().pH(aVar4.hmj);
                        }
                    }
                    b.a aVar5 = bVar.iRK.get(5);
                    if (aVar5 != null) {
                        b.this.imM.Q(5, aVar5.hmj);
                    }
                    b.a aVar6 = bVar.iRK.get(6);
                    if (aVar6 != null) {
                        b.this.imM.Q(6, aVar6.hmj);
                    }
                    b.this.imM.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener cXk = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.o.a.cjV().qB(false);
            }
        }
    };
    private CustomMessageListener imP = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            l lVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l) && (lVar = (l) customResponsedMessage.getData()) != null) {
                if (b.this.imL.ccs() != null) {
                    b.this.imL.ccs().a(lVar);
                    b.this.imM.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.imM = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.imM.a(this);
        this.imL = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.imL.a(this.imN);
        com.baidu.tieba.o.a.cjV();
        this.imO.setTag(bdUniqueId);
        this.cXk.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.imO);
        MessageManager.getInstance().registerListener(this.cXk);
        this.imP.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.imP);
    }

    public void Db(String str) {
        f ccs = this.imL.ccs();
        if (ccs != null && ccs.getUserData() != null) {
            ccs.getUserData().setName_show(str);
            this.imM.notifyDataSetChanged();
        }
    }

    public void Dc(String str) {
        f ccs = this.imL.ccs();
        if (ccs != null && ccs.getUserData() != null) {
            ccs.getUserData().setPortrait(str);
            this.imM.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        this.imL.LoadData();
    }

    public void initView() {
        this.imM.initView();
    }

    public void pF(boolean z) {
        this.imL.pF(z);
    }

    public void onDestroy() {
        this.imM.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.imM.onChangeSkinType(i);
    }

    public void ccj() {
        this.imM.cch();
    }

    public void cck() {
        this.imM.cci();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void cL(View view) {
        this.imL.LoadData();
    }
}
