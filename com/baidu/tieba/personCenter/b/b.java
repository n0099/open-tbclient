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
    private PersonCenterModel fUf;
    private com.baidu.tieba.personCenter.view.c fUg;
    PersonCenterModel.a fUh = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(d dVar) {
            b.this.fUg.Uc();
            b.this.fUg.b(dVar);
            if (dVar != null && dVar.getUserData() != null) {
                e.a(dVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.fUf.mIsDataLoaded) {
                b.this.fUg.B(i, str);
            } else {
                b.this.fUg.Ub();
            }
        }
    };
    private CustomMessageListener fUi = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                com.baidu.tieba.o.b bVar = (com.baidu.tieba.o.b) customResponsedMessage.getData();
                if (bVar.gvi != null && bVar.gvi.size() > 0) {
                    b.a aVar = bVar.gvi.get(2);
                    b.a aVar2 = bVar.gvi.get(3);
                    b.a aVar3 = bVar.gvi.get(9);
                    b.a aVar4 = bVar.gvi.get(10);
                    if (b.this.fUf.bjt() != null) {
                        if (aVar2 != null) {
                            b.this.fUf.bjt().ll(aVar2.eRd);
                        }
                        if (aVar != null) {
                            b.this.fUf.bjt().lo(aVar.eRd);
                        }
                        if (aVar3 != null) {
                            b.this.fUf.bjt().ln(aVar3.eRd);
                        }
                        if (aVar4 != null) {
                            b.this.fUf.bjt().lm(aVar4.eRd);
                        }
                    }
                    b.a aVar5 = bVar.gvi.get(5);
                    if (aVar5 != null) {
                        b.this.fUg.C(5, aVar5.eRd);
                    }
                    b.a aVar6 = bVar.gvi.get(6);
                    if (aVar6 != null) {
                        b.this.fUg.C(6, aVar6.eRd);
                    }
                    b.this.fUg.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener blQ = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.o.a.bpR().lZ(false);
            }
        }
    };
    private CustomMessageListener fUj = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            i iVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i) && (iVar = (i) customResponsedMessage.getData()) != null) {
                if (b.this.fUf.bjt() != null) {
                    b.this.fUf.bjt().b(iVar);
                    b.this.fUg.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.fUg = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.fUg.a(this);
        this.fUf = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.fUf.a(this.fUh);
        com.baidu.tieba.o.a.bpR();
        this.fUi.setTag(bdUniqueId);
        this.blQ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fUi);
        MessageManager.getInstance().registerListener(this.blQ);
        this.fUj.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fUj);
    }

    public void refreshView() {
        this.fUf.LoadData();
    }

    public void initView() {
        this.fUg.initView();
        this.fUf.LoadData();
    }

    public void lk(boolean z) {
        this.fUf.lk(z);
    }

    public void onDestroy() {
        this.fUg.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.fUg.onChangeSkinType(i);
    }

    public void bjp() {
        this.fUg.bjn();
    }

    public void bjq() {
        this.fUg.bjo();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void bq(View view) {
        this.fUf.LoadData();
    }
}
