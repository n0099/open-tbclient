package com.baidu.tieba.personCenter.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.a.f;
import com.baidu.tbadk.data.i;
import com.baidu.tieba.o.b;
import com.baidu.tieba.personCenter.data.d;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import com.baidu.tieba.personCenter.view.c;
/* loaded from: classes2.dex */
public class b implements c.a {
    private PersonCenterModel fQd;
    private com.baidu.tieba.personCenter.view.c fQe;
    PersonCenterModel.a fQf = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(d dVar) {
            b.this.fQe.TI();
            b.this.fQe.b(dVar);
            if (dVar != null && dVar.getUserData() != null) {
                f.a(dVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.fQd.mIsDataLoaded) {
                b.this.fQe.B(i, str);
            } else {
                b.this.fQe.TH();
            }
        }
    };
    private CustomMessageListener fQg = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                com.baidu.tieba.o.b bVar = (com.baidu.tieba.o.b) customResponsedMessage.getData();
                if (bVar.grr != null && bVar.grr.size() > 0) {
                    b.a aVar = bVar.grr.get(2);
                    b.a aVar2 = bVar.grr.get(3);
                    b.a aVar3 = bVar.grr.get(9);
                    b.a aVar4 = bVar.grr.get(10);
                    if (b.this.fQd.biN() != null) {
                        if (aVar2 != null) {
                            b.this.fQd.biN().lb(aVar2.eNm);
                        }
                        if (aVar != null) {
                            b.this.fQd.biN().le(aVar.eNm);
                        }
                        if (aVar3 != null) {
                            b.this.fQd.biN().ld(aVar3.eNm);
                        }
                        if (aVar4 != null) {
                            b.this.fQd.biN().lc(aVar4.eNm);
                        }
                    }
                    b.a aVar5 = bVar.grr.get(5);
                    if (aVar5 != null) {
                        b.this.fQe.C(5, aVar5.eNm);
                    }
                    b.a aVar6 = bVar.grr.get(6);
                    if (aVar6 != null) {
                        b.this.fQe.C(6, aVar6.eNm);
                    }
                    b.this.fQe.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener bkr = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.o.a.bpq().lP(false);
            }
        }
    };
    private CustomMessageListener fQh = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            i iVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i) && (iVar = (i) customResponsedMessage.getData()) != null) {
                if (b.this.fQd.biN() != null) {
                    b.this.fQd.biN().b(iVar);
                    b.this.fQe.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.fQe = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.fQe.a(this);
        this.fQd = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.fQd.a(this.fQf);
        com.baidu.tieba.o.a.bpq();
        this.fQg.setTag(bdUniqueId);
        this.bkr.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fQg);
        MessageManager.getInstance().registerListener(this.bkr);
        this.fQh.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fQh);
    }

    public void refreshView() {
        this.fQd.LoadData();
    }

    public void initView() {
        this.fQe.initView();
        this.fQd.LoadData();
    }

    public void la(boolean z) {
        this.fQd.la(z);
    }

    public void onDestroy() {
        this.fQe.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.fQe.onChangeSkinType(i);
    }

    public void biJ() {
        this.fQe.biH();
    }

    public void biK() {
        this.fQe.biI();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void bp(View view) {
        this.fQd.LoadData();
    }
}
