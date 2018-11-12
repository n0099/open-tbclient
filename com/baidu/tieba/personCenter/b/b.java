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
    private PersonCenterModel gkD;
    private com.baidu.tieba.personCenter.view.c gkE;
    PersonCenterModel.a gkF = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(e eVar) {
            b.this.gkE.ZS();
            b.this.gkE.b(eVar);
            if (eVar != null && eVar.getUserData() != null) {
                com.baidu.tbadk.core.a.e.a(eVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.gkD.mIsDataLoaded) {
                b.this.gkE.y(i, str);
            } else {
                b.this.gkE.ZR();
            }
        }
    };
    private CustomMessageListener gkG = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                com.baidu.tieba.o.b bVar = (com.baidu.tieba.o.b) customResponsedMessage.getData();
                if (bVar.gMN != null && bVar.gMN.size() > 0) {
                    b.a aVar = bVar.gMN.get(2);
                    b.a aVar2 = bVar.gMN.get(3);
                    b.a aVar3 = bVar.gMN.get(9);
                    b.a aVar4 = bVar.gMN.get(10);
                    if (b.this.gkD.bmQ() != null) {
                        if (aVar2 != null) {
                            b.this.gkD.bmQ().lV(aVar2.flr);
                        }
                        if (aVar != null) {
                            b.this.gkD.bmQ().lY(aVar.flr);
                        }
                        if (aVar3 != null) {
                            b.this.gkD.bmQ().lX(aVar3.flr);
                        }
                        if (aVar4 != null) {
                            b.this.gkD.bmQ().lW(aVar4.flr);
                        }
                    }
                    b.a aVar5 = bVar.gMN.get(5);
                    if (aVar5 != null) {
                        b.this.gkE.C(5, aVar5.flr);
                    }
                    b.a aVar6 = bVar.gMN.get(6);
                    if (aVar6 != null) {
                        b.this.gkE.C(6, aVar6.flr);
                    }
                    b.this.gkE.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener bxg = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.o.a.btQ().mM(false);
            }
        }
    };
    private CustomMessageListener gkH = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            j jVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof j) && (jVar = (j) customResponsedMessage.getData()) != null) {
                if (b.this.gkD.bmQ() != null) {
                    b.this.gkD.bmQ().b(jVar);
                    b.this.gkE.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gkE = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.gkE.a(this);
        this.gkD = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.gkD.a(this.gkF);
        com.baidu.tieba.o.a.btQ();
        this.gkG.setTag(bdUniqueId);
        this.bxg.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gkG);
        MessageManager.getInstance().registerListener(this.bxg);
        this.gkH.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gkH);
    }

    public void sX(String str) {
        e bmQ = this.gkD.bmQ();
        if (bmQ != null && bmQ.getUserData() != null) {
            bmQ.getUserData().setName_show(str);
            this.gkE.notifyDataSetChanged();
        }
    }

    public void sY(String str) {
        e bmQ = this.gkD.bmQ();
        if (bmQ != null && bmQ.getUserData() != null) {
            bmQ.getUserData().setPortrait(str);
            this.gkE.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        this.gkD.LoadData();
    }

    public void initView() {
        this.gkE.initView();
        this.gkD.LoadData();
    }

    public void lU(boolean z) {
        this.gkD.lU(z);
    }

    public void onDestroy() {
        this.gkE.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.gkE.onChangeSkinType(i);
    }

    public void bmK() {
        this.gkE.bmI();
    }

    public void bmL() {
        this.gkE.bmJ();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void bI(View view) {
        this.gkD.LoadData();
    }
}
