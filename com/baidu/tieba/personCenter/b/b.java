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
    private PersonCenterModel gjd;
    private com.baidu.tieba.personCenter.view.c gje;
    PersonCenterModel.a gjf = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(e eVar) {
            b.this.gje.ZH();
            b.this.gje.b(eVar);
            if (eVar != null && eVar.getUserData() != null) {
                com.baidu.tbadk.core.a.e.a(eVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.gjd.mIsDataLoaded) {
                b.this.gje.D(i, str);
            } else {
                b.this.gje.ZG();
            }
        }
    };
    private CustomMessageListener gjg = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                com.baidu.tieba.o.b bVar = (com.baidu.tieba.o.b) customResponsedMessage.getData();
                if (bVar.gLn != null && bVar.gLn.size() > 0) {
                    b.a aVar = bVar.gLn.get(2);
                    b.a aVar2 = bVar.gLn.get(3);
                    b.a aVar3 = bVar.gLn.get(9);
                    b.a aVar4 = bVar.gLn.get(10);
                    if (b.this.gjd.bnv() != null) {
                        if (aVar2 != null) {
                            b.this.gjd.bnv().lK(aVar2.fjX);
                        }
                        if (aVar != null) {
                            b.this.gjd.bnv().lN(aVar.fjX);
                        }
                        if (aVar3 != null) {
                            b.this.gjd.bnv().lM(aVar3.fjX);
                        }
                        if (aVar4 != null) {
                            b.this.gjd.bnv().lL(aVar4.fjX);
                        }
                    }
                    b.a aVar5 = bVar.gLn.get(5);
                    if (aVar5 != null) {
                        b.this.gje.C(5, aVar5.fjX);
                    }
                    b.a aVar6 = bVar.gLn.get(6);
                    if (aVar6 != null) {
                        b.this.gje.C(6, aVar6.fjX);
                    }
                    b.this.gje.notifyDataSetChanged();
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
    private CustomMessageListener gjh = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            j jVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof j) && (jVar = (j) customResponsedMessage.getData()) != null) {
                if (b.this.gjd.bnv() != null) {
                    b.this.gjd.bnv().b(jVar);
                    b.this.gje.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gje = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.gje.a(this);
        this.gjd = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.gjd.a(this.gjf);
        com.baidu.tieba.o.a.buu();
        this.gjg.setTag(bdUniqueId);
        this.bwv.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gjg);
        MessageManager.getInstance().registerListener(this.bwv);
        this.gjh.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gjh);
    }

    public void refreshView() {
        this.gjd.LoadData();
    }

    public void initView() {
        this.gje.initView();
        this.gjd.LoadData();
    }

    public void lJ(boolean z) {
        this.gjd.lJ(z);
    }

    public void onDestroy() {
        this.gje.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.gje.onChangeSkinType(i);
    }

    public void bnp() {
        this.gje.bnn();
    }

    public void bnq() {
        this.gje.bno();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void bG(View view) {
        this.gjd.LoadData();
    }
}
