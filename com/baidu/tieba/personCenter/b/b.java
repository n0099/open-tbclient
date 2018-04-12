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
    private PersonCenterModel fDG;
    private com.baidu.tieba.personCenter.view.c fDH;
    PersonCenterModel.a fDI = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(d dVar) {
            b.this.fDH.Qn();
            b.this.fDH.b(dVar);
            if (dVar != null && dVar.getUserData() != null) {
                f.a(dVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.fDG.mIsDataLoaded) {
                b.this.fDH.B(i, str);
            } else {
                b.this.fDH.Qm();
            }
        }
    };
    private CustomMessageListener fDJ = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.n.b)) {
                com.baidu.tieba.n.b bVar = (com.baidu.tieba.n.b) customResponsedMessage.getData();
                if (bVar.geU != null && bVar.geU.size() > 0) {
                    b.a aVar = bVar.geU.get(2);
                    b.a aVar2 = bVar.geU.get(3);
                    b.a aVar3 = bVar.geU.get(9);
                    b.a aVar4 = bVar.geU.get(10);
                    if (b.this.fDG.bdN() != null) {
                        if (aVar2 != null) {
                            b.this.fDG.bdN().kU(aVar2.eAN);
                        }
                        if (aVar != null) {
                            b.this.fDG.bdN().kX(aVar.eAN);
                        }
                        if (aVar3 != null) {
                            b.this.fDG.bdN().kW(aVar3.eAN);
                        }
                        if (aVar4 != null) {
                            b.this.fDG.bdN().kV(aVar4.eAN);
                        }
                    }
                    b.a aVar5 = bVar.geU.get(5);
                    if (aVar5 != null) {
                        b.this.fDH.C(5, aVar5.eAN);
                    }
                    b.a aVar6 = bVar.geU.get(6);
                    if (aVar6 != null) {
                        b.this.fDH.C(6, aVar6.eAN);
                    }
                    b.this.fDH.notifyDataSetChanged();
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
    private CustomMessageListener fDK = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            h hVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof h) && (hVar = (h) customResponsedMessage.getData()) != null) {
                if (b.this.fDG.bdN() != null) {
                    b.this.fDG.bdN().b(hVar);
                    b.this.fDH.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view2, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.fDH = new com.baidu.tieba.personCenter.view.c(view2, tbPageContext, bdUniqueId);
        this.fDH.a(this);
        this.fDG = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.fDG.a(this.fDI);
        com.baidu.tieba.n.a.bkt();
        this.fDJ.setTag(bdUniqueId);
        this.bcg.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fDJ);
        MessageManager.getInstance().registerListener(this.bcg);
        this.fDK.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fDK);
    }

    public void refreshView() {
        this.fDG.LoadData();
    }

    public void initView() {
        this.fDH.initView();
        this.fDG.LoadData();
    }

    public void kT(boolean z) {
        this.fDG.kT(z);
    }

    public void onDestroy() {
        this.fDH.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.fDH.onChangeSkinType(i);
    }

    public void bdJ() {
        this.fDH.bdH();
    }

    public void bdK() {
        this.fDH.bdI();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void bm(View view2) {
        this.fDG.LoadData();
    }
}
