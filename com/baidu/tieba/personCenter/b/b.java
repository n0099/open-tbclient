package com.baidu.tieba.personCenter.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.a.e;
import com.baidu.tbadk.data.l;
import com.baidu.tieba.o.b;
import com.baidu.tieba.personCenter.data.f;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import com.baidu.tieba.personCenter.view.c;
/* loaded from: classes4.dex */
public class b implements c.a {
    private PersonCenterModel idr;
    private com.baidu.tieba.personCenter.view.c idu;
    PersonCenterModel.a idv = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(f fVar) {
            b.this.idu.aHK();
            b.this.idu.b(fVar);
            if (fVar != null && fVar.getUserData() != null) {
                e.a(fVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.idr.mIsDataLoaded) {
                b.this.idu.V(i, str);
            } else {
                b.this.idu.aHJ();
            }
        }
    };
    private CustomMessageListener idw = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                com.baidu.tieba.o.b bVar = (com.baidu.tieba.o.b) customResponsedMessage.getData();
                if (bVar.iHO != null && bVar.iHO.size() > 0) {
                    b.a aVar = bVar.iHO.get(2);
                    b.a aVar2 = bVar.iHO.get(3);
                    b.a aVar3 = bVar.iHO.get(9);
                    b.a aVar4 = bVar.iHO.get(10);
                    if (b.this.idr.bYw() != null) {
                        if (aVar2 != null) {
                            b.this.idr.bYw().pn(aVar2.hdj);
                        }
                        if (aVar != null) {
                            b.this.idr.bYw().pq(aVar.hdj);
                        }
                        if (aVar3 != null) {
                            b.this.idr.bYw().pp(aVar3.hdj);
                        }
                        if (aVar4 != null) {
                            b.this.idr.bYw().po(aVar4.hdj);
                        }
                    }
                    b.a aVar5 = bVar.iHO.get(5);
                    if (aVar5 != null) {
                        b.this.idu.N(5, aVar5.hdj);
                    }
                    b.a aVar6 = bVar.iHO.get(6);
                    if (aVar6 != null) {
                        b.this.idu.N(6, aVar6.hdj);
                    }
                    b.this.idu.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener cUN = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.o.a.cfZ().qh(false);
            }
        }
    };
    private CustomMessageListener idx = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            l lVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l) && (lVar = (l) customResponsedMessage.getData()) != null) {
                if (b.this.idr.bYw() != null) {
                    b.this.idr.bYw().a(lVar);
                    b.this.idu.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.idu = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.idu.a(this);
        this.idr = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.idr.a(this.idv);
        com.baidu.tieba.o.a.cfZ();
        this.idw.setTag(bdUniqueId);
        this.cUN.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.idw);
        MessageManager.getInstance().registerListener(this.cUN);
        this.idx.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.idx);
    }

    public void BM(String str) {
        f bYw = this.idr.bYw();
        if (bYw != null && bYw.getUserData() != null) {
            bYw.getUserData().setName_show(str);
            this.idu.notifyDataSetChanged();
        }
    }

    public void BN(String str) {
        f bYw = this.idr.bYw();
        if (bYw != null && bYw.getUserData() != null) {
            bYw.getUserData().setPortrait(str);
            this.idu.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        this.idr.LoadData();
    }

    public void initView() {
        this.idu.initView();
    }

    public void pm(boolean z) {
        this.idr.pm(z);
    }

    public void onDestroy() {
        this.idu.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.idu.onChangeSkinType(i);
    }

    public void bYn() {
        this.idu.bYl();
    }

    public void bYo() {
        this.idu.bYm();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void cG(View view) {
        this.idr.LoadData();
    }
}
