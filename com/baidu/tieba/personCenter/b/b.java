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
    private PersonCenterModel gje;
    private com.baidu.tieba.personCenter.view.c gjf;
    PersonCenterModel.a gjg = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(e eVar) {
            b.this.gjf.ZI();
            b.this.gjf.b(eVar);
            if (eVar != null && eVar.getUserData() != null) {
                com.baidu.tbadk.core.a.e.a(eVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.gje.mIsDataLoaded) {
                b.this.gjf.D(i, str);
            } else {
                b.this.gjf.ZH();
            }
        }
    };
    private CustomMessageListener gjh = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                com.baidu.tieba.o.b bVar = (com.baidu.tieba.o.b) customResponsedMessage.getData();
                if (bVar.gLo != null && bVar.gLo.size() > 0) {
                    b.a aVar = bVar.gLo.get(2);
                    b.a aVar2 = bVar.gLo.get(3);
                    b.a aVar3 = bVar.gLo.get(9);
                    b.a aVar4 = bVar.gLo.get(10);
                    if (b.this.gje.bnv() != null) {
                        if (aVar2 != null) {
                            b.this.gje.bnv().lK(aVar2.fjY);
                        }
                        if (aVar != null) {
                            b.this.gje.bnv().lN(aVar.fjY);
                        }
                        if (aVar3 != null) {
                            b.this.gje.bnv().lM(aVar3.fjY);
                        }
                        if (aVar4 != null) {
                            b.this.gje.bnv().lL(aVar4.fjY);
                        }
                    }
                    b.a aVar5 = bVar.gLo.get(5);
                    if (aVar5 != null) {
                        b.this.gjf.C(5, aVar5.fjY);
                    }
                    b.a aVar6 = bVar.gLo.get(6);
                    if (aVar6 != null) {
                        b.this.gjf.C(6, aVar6.fjY);
                    }
                    b.this.gjf.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener bwv = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.o.a.buu().mB(false);
            }
        }
    };
    private CustomMessageListener gji = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            j jVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof j) && (jVar = (j) customResponsedMessage.getData()) != null) {
                if (b.this.gje.bnv() != null) {
                    b.this.gje.bnv().b(jVar);
                    b.this.gjf.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gjf = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.gjf.a(this);
        this.gje = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.gje.a(this.gjg);
        com.baidu.tieba.o.a.buu();
        this.gjh.setTag(bdUniqueId);
        this.bwv.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gjh);
        MessageManager.getInstance().registerListener(this.bwv);
        this.gji.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gji);
    }

    public void refreshView() {
        this.gje.LoadData();
    }

    public void initView() {
        this.gjf.initView();
        this.gje.LoadData();
    }

    public void lJ(boolean z) {
        this.gje.lJ(z);
    }

    public void onDestroy() {
        this.gjf.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.gjf.onChangeSkinType(i);
    }

    public void bnp() {
        this.gjf.bnn();
    }

    public void bnq() {
        this.gjf.bno();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void bG(View view) {
        this.gje.LoadData();
    }
}
