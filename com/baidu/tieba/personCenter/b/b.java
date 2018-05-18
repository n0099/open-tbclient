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
    private PersonCenterModel fEJ;
    private com.baidu.tieba.personCenter.view.c fEK;
    PersonCenterModel.a fEL = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(d dVar) {
            b.this.fEK.Qk();
            b.this.fEK.b(dVar);
            if (dVar != null && dVar.getUserData() != null) {
                f.a(dVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.fEJ.mIsDataLoaded) {
                b.this.fEK.B(i, str);
            } else {
                b.this.fEK.Qj();
            }
        }
    };
    private CustomMessageListener fEM = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.n.b)) {
                com.baidu.tieba.n.b bVar = (com.baidu.tieba.n.b) customResponsedMessage.getData();
                if (bVar.gfX != null && bVar.gfX.size() > 0) {
                    b.a aVar = bVar.gfX.get(2);
                    b.a aVar2 = bVar.gfX.get(3);
                    b.a aVar3 = bVar.gfX.get(9);
                    b.a aVar4 = bVar.gfX.get(10);
                    if (b.this.fEJ.bdN() != null) {
                        if (aVar2 != null) {
                            b.this.fEJ.bdN().kV(aVar2.eBS);
                        }
                        if (aVar != null) {
                            b.this.fEJ.bdN().kY(aVar.eBS);
                        }
                        if (aVar3 != null) {
                            b.this.fEJ.bdN().kX(aVar3.eBS);
                        }
                        if (aVar4 != null) {
                            b.this.fEJ.bdN().kW(aVar4.eBS);
                        }
                    }
                    b.a aVar5 = bVar.gfX.get(5);
                    if (aVar5 != null) {
                        b.this.fEK.C(5, aVar5.eBS);
                    }
                    b.a aVar6 = bVar.gfX.get(6);
                    if (aVar6 != null) {
                        b.this.fEK.C(6, aVar6.eBS);
                    }
                    b.this.fEK.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener bch = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.n.a.bks().lJ(false);
            }
        }
    };
    private CustomMessageListener fEN = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            h hVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof h) && (hVar = (h) customResponsedMessage.getData()) != null) {
                if (b.this.fEJ.bdN() != null) {
                    b.this.fEJ.bdN().b(hVar);
                    b.this.fEK.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view2, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.fEK = new com.baidu.tieba.personCenter.view.c(view2, tbPageContext, bdUniqueId);
        this.fEK.a(this);
        this.fEJ = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.fEJ.a(this.fEL);
        com.baidu.tieba.n.a.bks();
        this.fEM.setTag(bdUniqueId);
        this.bch.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fEM);
        MessageManager.getInstance().registerListener(this.bch);
        this.fEN.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fEN);
    }

    public void refreshView() {
        this.fEJ.LoadData();
    }

    public void initView() {
        this.fEK.initView();
        this.fEJ.LoadData();
    }

    public void kU(boolean z) {
        this.fEJ.kU(z);
    }

    public void onDestroy() {
        this.fEK.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.fEK.onChangeSkinType(i);
    }

    public void bdJ() {
        this.fEK.bdH();
    }

    public void bdK() {
        this.fEK.bdI();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void bm(View view2) {
        this.fEJ.LoadData();
    }
}
