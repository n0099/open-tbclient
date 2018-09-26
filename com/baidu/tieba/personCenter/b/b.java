package com.baidu.tieba.personCenter.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.j;
import com.baidu.tieba.o.b;
import com.baidu.tieba.personCenter.data.e;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import com.baidu.tieba.personCenter.view.c;
/* loaded from: classes2.dex */
public class b implements c.a {
    private PersonCenterModel gbB;
    private com.baidu.tieba.personCenter.view.c gbC;
    PersonCenterModel.a gbD = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(e eVar) {
            b.this.gbC.Wa();
            b.this.gbC.b(eVar);
            if (eVar != null && eVar.getUserData() != null) {
                com.baidu.tbadk.core.a.e.a(eVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.gbB.mIsDataLoaded) {
                b.this.gbC.D(i, str);
            } else {
                b.this.gbC.VZ();
            }
        }
    };
    private CustomMessageListener gbE = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                com.baidu.tieba.o.b bVar = (com.baidu.tieba.o.b) customResponsedMessage.getData();
                if (bVar.gDP != null && bVar.gDP.size() > 0) {
                    b.a aVar = bVar.gDP.get(2);
                    b.a aVar2 = bVar.gDP.get(3);
                    b.a aVar3 = bVar.gDP.get(9);
                    b.a aVar4 = bVar.gDP.get(10);
                    if (b.this.gbB.bkk() != null) {
                        if (aVar2 != null) {
                            b.this.gbB.bkk().lt(aVar2.fco);
                        }
                        if (aVar != null) {
                            b.this.gbB.bkk().lw(aVar.fco);
                        }
                        if (aVar3 != null) {
                            b.this.gbB.bkk().lv(aVar3.fco);
                        }
                        if (aVar4 != null) {
                            b.this.gbB.bkk().lu(aVar4.fco);
                        }
                    }
                    b.a aVar5 = bVar.gDP.get(5);
                    if (aVar5 != null) {
                        b.this.gbC.C(5, aVar5.fco);
                    }
                    b.a aVar6 = bVar.gDP.get(6);
                    if (aVar6 != null) {
                        b.this.gbC.C(6, aVar6.fco);
                    }
                    b.this.gbC.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener bso = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.o.a.brf().mj(false);
            }
        }
    };
    private CustomMessageListener gbF = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            j jVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof j) && (jVar = (j) customResponsedMessage.getData()) != null) {
                if (b.this.gbB.bkk() != null) {
                    b.this.gbB.bkk().b(jVar);
                    b.this.gbC.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gbC = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.gbC.a(this);
        this.gbB = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.gbB.a(this.gbD);
        com.baidu.tieba.o.a.brf();
        this.gbE.setTag(bdUniqueId);
        this.bso.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gbE);
        MessageManager.getInstance().registerListener(this.bso);
        this.gbF.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gbF);
    }

    public void refreshView() {
        this.gbB.LoadData();
    }

    public void initView() {
        this.gbC.initView();
        this.gbB.LoadData();
    }

    public void ls(boolean z) {
        this.gbB.ls(z);
    }

    public void onDestroy() {
        this.gbC.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.gbC.onChangeSkinType(i);
    }

    public void bke() {
        this.gbC.bkc();
    }

    public void bkf() {
        this.gbC.bkd();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void bG(View view) {
        this.gbB.LoadData();
    }
}
