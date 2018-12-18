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
/* loaded from: classes5.dex */
public class b implements c.a {
    private PersonCenterModel grt;
    private com.baidu.tieba.personCenter.view.c gru;
    PersonCenterModel.a grv = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(e eVar) {
            b.this.gru.aaY();
            b.this.gru.b(eVar);
            if (eVar != null && eVar.getUserData() != null) {
                com.baidu.tbadk.core.a.e.a(eVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.grt.mIsDataLoaded) {
                b.this.gru.y(i, str);
            } else {
                b.this.gru.aaX();
            }
        }
    };
    private CustomMessageListener grw = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                com.baidu.tieba.o.b bVar = (com.baidu.tieba.o.b) customResponsedMessage.getData();
                if (bVar.gTD != null && bVar.gTD.size() > 0) {
                    b.a aVar = bVar.gTD.get(2);
                    b.a aVar2 = bVar.gTD.get(3);
                    b.a aVar3 = bVar.gTD.get(9);
                    b.a aVar4 = bVar.gTD.get(10);
                    if (b.this.grt.boI() != null) {
                        if (aVar2 != null) {
                            b.this.grt.boI().lY(aVar2.fsj);
                        }
                        if (aVar != null) {
                            b.this.grt.boI().mb(aVar.fsj);
                        }
                        if (aVar3 != null) {
                            b.this.grt.boI().ma(aVar3.fsj);
                        }
                        if (aVar4 != null) {
                            b.this.grt.boI().lZ(aVar4.fsj);
                        }
                    }
                    b.a aVar5 = bVar.gTD.get(5);
                    if (aVar5 != null) {
                        b.this.gru.C(5, aVar5.fsj);
                    }
                    b.a aVar6 = bVar.gTD.get(6);
                    if (aVar6 != null) {
                        b.this.gru.C(6, aVar6.fsj);
                    }
                    b.this.gru.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener bAD = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.o.a.bvI().mP(false);
            }
        }
    };
    private CustomMessageListener grx = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            j jVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof j) && (jVar = (j) customResponsedMessage.getData()) != null) {
                if (b.this.grt.boI() != null) {
                    b.this.grt.boI().b(jVar);
                    b.this.gru.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gru = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.gru.a(this);
        this.grt = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.grt.a(this.grv);
        com.baidu.tieba.o.a.bvI();
        this.grw.setTag(bdUniqueId);
        this.bAD.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.grw);
        MessageManager.getInstance().registerListener(this.bAD);
        this.grx.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.grx);
    }

    public void tz(String str) {
        e boI = this.grt.boI();
        if (boI != null && boI.getUserData() != null) {
            boI.getUserData().setName_show(str);
            this.gru.notifyDataSetChanged();
        }
    }

    public void tA(String str) {
        e boI = this.grt.boI();
        if (boI != null && boI.getUserData() != null) {
            boI.getUserData().setPortrait(str);
            this.gru.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        this.grt.LoadData();
    }

    public void initView() {
        this.gru.initView();
        this.grt.LoadData();
    }

    public void lX(boolean z) {
        this.grt.lX(z);
    }

    public void onDestroy() {
        this.gru.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.gru.onChangeSkinType(i);
    }

    public void boC() {
        this.gru.boA();
    }

    public void boD() {
        this.gru.boB();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void bI(View view) {
        this.grt.LoadData();
    }
}
