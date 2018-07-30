package com.baidu.tieba.personCenter.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.a.e;
import com.baidu.tbadk.data.i;
import com.baidu.tieba.o.b;
import com.baidu.tieba.personCenter.data.d;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import com.baidu.tieba.personCenter.view.c;
/* loaded from: classes2.dex */
public class b implements c.a {
    private PersonCenterModel fUs;
    private com.baidu.tieba.personCenter.view.c fUt;
    PersonCenterModel.a fUu = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(d dVar) {
            b.this.fUt.Uk();
            b.this.fUt.b(dVar);
            if (dVar != null && dVar.getUserData() != null) {
                e.a(dVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.fUs.mIsDataLoaded) {
                b.this.fUt.D(i, str);
            } else {
                b.this.fUt.Uj();
            }
        }
    };
    private CustomMessageListener fUv = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                com.baidu.tieba.o.b bVar = (com.baidu.tieba.o.b) customResponsedMessage.getData();
                if (bVar.gwv != null && bVar.gwv.size() > 0) {
                    b.a aVar = bVar.gwv.get(2);
                    b.a aVar2 = bVar.gwv.get(3);
                    b.a aVar3 = bVar.gwv.get(9);
                    b.a aVar4 = bVar.gwv.get(10);
                    if (b.this.fUs.bhM() != null) {
                        if (aVar2 != null) {
                            b.this.fUs.bhM().kX(aVar2.eUY);
                        }
                        if (aVar != null) {
                            b.this.fUs.bhM().la(aVar.eUY);
                        }
                        if (aVar3 != null) {
                            b.this.fUs.bhM().kZ(aVar3.eUY);
                        }
                        if (aVar4 != null) {
                            b.this.fUs.bhM().kY(aVar4.eUY);
                        }
                    }
                    b.a aVar5 = bVar.gwv.get(5);
                    if (aVar5 != null) {
                        b.this.fUt.B(5, aVar5.eUY);
                    }
                    b.a aVar6 = bVar.gwv.get(6);
                    if (aVar6 != null) {
                        b.this.fUt.B(6, aVar6.eUY);
                    }
                    b.this.fUt.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener bmw = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.o.a.box().lK(false);
            }
        }
    };
    private CustomMessageListener fUw = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            i iVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i) && (iVar = (i) customResponsedMessage.getData()) != null) {
                if (b.this.fUs.bhM() != null) {
                    b.this.fUs.bhM().b(iVar);
                    b.this.fUt.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.fUt = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.fUt.a(this);
        this.fUs = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.fUs.a(this.fUu);
        com.baidu.tieba.o.a.box();
        this.fUv.setTag(bdUniqueId);
        this.bmw.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fUv);
        MessageManager.getInstance().registerListener(this.bmw);
        this.fUw.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fUw);
    }

    public void refreshView() {
        this.fUs.LoadData();
    }

    public void initView() {
        this.fUt.initView();
        this.fUs.LoadData();
    }

    public void kW(boolean z) {
        this.fUs.kW(z);
    }

    public void onDestroy() {
        this.fUt.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.fUt.onChangeSkinType(i);
    }

    public void bhI() {
        this.fUt.bhG();
    }

    public void bhJ() {
        this.fUt.bhH();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void bt(View view) {
        this.fUs.LoadData();
    }
}
