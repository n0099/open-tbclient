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
    private PersonCenterModel ikL;
    private com.baidu.tieba.personCenter.view.c ikM;
    PersonCenterModel.a ikN = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(f fVar) {
            b.this.ikM.aJj();
            b.this.ikM.b(fVar);
            if (fVar != null && fVar.getUserData() != null) {
                e.a(fVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.ikL.mIsDataLoaded) {
                b.this.ikM.V(i, str);
            } else {
                b.this.ikM.aJi();
            }
        }
    };
    private CustomMessageListener ikO = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                com.baidu.tieba.o.b bVar = (com.baidu.tieba.o.b) customResponsedMessage.getData();
                if (bVar.iPo != null && bVar.iPo.size() > 0) {
                    b.a aVar = bVar.iPo.get(2);
                    b.a aVar2 = bVar.iPo.get(3);
                    b.a aVar3 = bVar.iPo.get(9);
                    b.a aVar4 = bVar.iPo.get(10);
                    if (b.this.ikL.cbE() != null) {
                        if (aVar2 != null) {
                            b.this.ikL.cbE().pD(aVar2.hkp);
                        }
                        if (aVar != null) {
                            b.this.ikL.cbE().pG(aVar.hkp);
                        }
                        if (aVar3 != null) {
                            b.this.ikL.cbE().pF(aVar3.hkp);
                        }
                        if (aVar4 != null) {
                            b.this.ikL.cbE().pE(aVar4.hkp);
                        }
                    }
                    b.a aVar5 = bVar.iPo.get(5);
                    if (aVar5 != null) {
                        b.this.ikM.P(5, aVar5.hkp);
                    }
                    b.a aVar6 = bVar.iPo.get(6);
                    if (aVar6 != null) {
                        b.this.ikM.P(6, aVar6.hkp);
                    }
                    b.this.ikM.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener cWr = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.o.a.cjj().qy(false);
            }
        }
    };
    private CustomMessageListener ikP = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            l lVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l) && (lVar = (l) customResponsedMessage.getData()) != null) {
                if (b.this.ikL.cbE() != null) {
                    b.this.ikL.cbE().a(lVar);
                    b.this.ikM.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.ikM = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.ikM.a(this);
        this.ikL = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.ikL.a(this.ikN);
        com.baidu.tieba.o.a.cjj();
        this.ikO.setTag(bdUniqueId);
        this.cWr.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ikO);
        MessageManager.getInstance().registerListener(this.cWr);
        this.ikP.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ikP);
    }

    public void CC(String str) {
        f cbE = this.ikL.cbE();
        if (cbE != null && cbE.getUserData() != null) {
            cbE.getUserData().setName_show(str);
            this.ikM.notifyDataSetChanged();
        }
    }

    public void CD(String str) {
        f cbE = this.ikL.cbE();
        if (cbE != null && cbE.getUserData() != null) {
            cbE.getUserData().setPortrait(str);
            this.ikM.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        this.ikL.LoadData();
    }

    public void initView() {
        this.ikM.initView();
    }

    public void pC(boolean z) {
        this.ikL.pC(z);
    }

    public void onDestroy() {
        this.ikM.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.ikM.onChangeSkinType(i);
    }

    public void cbv() {
        this.ikM.cbt();
    }

    public void cbw() {
        this.ikM.cbu();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void cL(View view) {
        this.ikL.LoadData();
    }
}
