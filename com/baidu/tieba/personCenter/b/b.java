package com.baidu.tieba.personCenter.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.l;
import com.baidu.tieba.o.b;
import com.baidu.tieba.personCenter.data.e;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import com.baidu.tieba.personCenter.view.c;
/* loaded from: classes4.dex */
public class b implements c.a {
    private PersonCenterModel hLA;
    private com.baidu.tieba.personCenter.view.c hLB;
    PersonCenterModel.a hLC = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(e eVar) {
            b.this.hLB.aBt();
            b.this.hLB.b(eVar);
            if (eVar != null && eVar.getUserData() != null) {
                com.baidu.tbadk.core.a.e.a(eVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.hLA.mIsDataLoaded) {
                b.this.hLB.Q(i, str);
            } else {
                b.this.hLB.aBs();
            }
        }
    };
    private CustomMessageListener hLD = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                com.baidu.tieba.o.b bVar = (com.baidu.tieba.o.b) customResponsedMessage.getData();
                if (bVar.ipn != null && bVar.ipn.size() > 0) {
                    b.a aVar = bVar.ipn.get(2);
                    b.a aVar2 = bVar.ipn.get(3);
                    b.a aVar3 = bVar.ipn.get(9);
                    b.a aVar4 = bVar.ipn.get(10);
                    if (b.this.hLA.bQC() != null) {
                        if (aVar2 != null) {
                            b.this.hLA.bQC().oy(aVar2.gLZ);
                        }
                        if (aVar != null) {
                            b.this.hLA.bQC().oB(aVar.gLZ);
                        }
                        if (aVar3 != null) {
                            b.this.hLA.bQC().oA(aVar3.gLZ);
                        }
                        if (aVar4 != null) {
                            b.this.hLA.bQC().oz(aVar4.gLZ);
                        }
                    }
                    b.a aVar5 = bVar.ipn.get(5);
                    if (aVar5 != null) {
                        b.this.hLB.I(5, aVar5.gLZ);
                    }
                    b.a aVar6 = bVar.ipn.get(6);
                    if (aVar6 != null) {
                        b.this.hLB.I(6, aVar6.gLZ);
                    }
                    b.this.hLB.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener cMy = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.o.a.bXW().ps(false);
            }
        }
    };
    private CustomMessageListener hLE = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            l lVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l) && (lVar = (l) customResponsedMessage.getData()) != null) {
                if (b.this.hLA.bQC() != null) {
                    b.this.hLA.bQC().a(lVar);
                    b.this.hLB.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.hLB = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.hLB.a(this);
        this.hLA = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.hLA.a(this.hLC);
        com.baidu.tieba.o.a.bXW();
        this.hLD.setTag(bdUniqueId);
        this.cMy.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hLD);
        MessageManager.getInstance().registerListener(this.cMy);
        this.hLE.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hLE);
    }

    public void Ax(String str) {
        e bQC = this.hLA.bQC();
        if (bQC != null && bQC.getUserData() != null) {
            bQC.getUserData().setName_show(str);
            this.hLB.notifyDataSetChanged();
        }
    }

    public void Ay(String str) {
        e bQC = this.hLA.bQC();
        if (bQC != null && bQC.getUserData() != null) {
            bQC.getUserData().setPortrait(str);
            this.hLB.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        this.hLA.LoadData();
    }

    public void initView() {
        this.hLB.initView();
        this.hLA.LoadData();
    }

    public void ox(boolean z) {
        this.hLA.ox(z);
    }

    public void onDestroy() {
        this.hLB.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.hLB.onChangeSkinType(i);
    }

    public void bQv() {
        this.hLB.bQt();
    }

    public void bQw() {
        this.hLB.bQu();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void cy(View view) {
        this.hLA.LoadData();
    }
}
