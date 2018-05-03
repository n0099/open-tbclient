package com.baidu.tieba.personCenter.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.a.f;
import com.baidu.tbadk.data.h;
import com.baidu.tieba.n.b;
import com.baidu.tieba.personCenter.data.d;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import com.baidu.tieba.personCenter.view.c;
/* loaded from: classes2.dex */
public class b implements c.a {
    private PersonCenterModel fDD;
    private com.baidu.tieba.personCenter.view.c fDE;
    PersonCenterModel.a fDF = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(d dVar) {
            b.this.fDE.Qn();
            b.this.fDE.b(dVar);
            if (dVar != null && dVar.getUserData() != null) {
                f.a(dVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.fDD.mIsDataLoaded) {
                b.this.fDE.B(i, str);
            } else {
                b.this.fDE.Qm();
            }
        }
    };
    private CustomMessageListener fDG = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.n.b)) {
                com.baidu.tieba.n.b bVar = (com.baidu.tieba.n.b) customResponsedMessage.getData();
                if (bVar.geR != null && bVar.geR.size() > 0) {
                    b.a aVar = bVar.geR.get(2);
                    b.a aVar2 = bVar.geR.get(3);
                    b.a aVar3 = bVar.geR.get(9);
                    b.a aVar4 = bVar.geR.get(10);
                    if (b.this.fDD.bdN() != null) {
                        if (aVar2 != null) {
                            b.this.fDD.bdN().kU(aVar2.eAK);
                        }
                        if (aVar != null) {
                            b.this.fDD.bdN().kX(aVar.eAK);
                        }
                        if (aVar3 != null) {
                            b.this.fDD.bdN().kW(aVar3.eAK);
                        }
                        if (aVar4 != null) {
                            b.this.fDD.bdN().kV(aVar4.eAK);
                        }
                    }
                    b.a aVar5 = bVar.geR.get(5);
                    if (aVar5 != null) {
                        b.this.fDE.C(5, aVar5.eAK);
                    }
                    b.a aVar6 = bVar.geR.get(6);
                    if (aVar6 != null) {
                        b.this.fDE.C(6, aVar6.eAK);
                    }
                    b.this.fDE.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener bcg = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.n.a.bkt().lI(false);
            }
        }
    };
    private CustomMessageListener fDH = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            h hVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof h) && (hVar = (h) customResponsedMessage.getData()) != null) {
                if (b.this.fDD.bdN() != null) {
                    b.this.fDD.bdN().b(hVar);
                    b.this.fDE.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view2, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.fDE = new com.baidu.tieba.personCenter.view.c(view2, tbPageContext, bdUniqueId);
        this.fDE.a(this);
        this.fDD = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.fDD.a(this.fDF);
        com.baidu.tieba.n.a.bkt();
        this.fDG.setTag(bdUniqueId);
        this.bcg.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fDG);
        MessageManager.getInstance().registerListener(this.bcg);
        this.fDH.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fDH);
    }

    public void refreshView() {
        this.fDD.LoadData();
    }

    public void initView() {
        this.fDE.initView();
        this.fDD.LoadData();
    }

    public void kT(boolean z) {
        this.fDD.kT(z);
    }

    public void onDestroy() {
        this.fDE.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.fDE.onChangeSkinType(i);
    }

    public void bdJ() {
        this.fDE.bdH();
    }

    public void bdK() {
        this.fDE.bdI();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void bm(View view2) {
        this.fDD.LoadData();
    }
}
