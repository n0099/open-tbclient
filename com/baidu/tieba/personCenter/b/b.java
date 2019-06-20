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
    private PersonCenterModel idu;
    private com.baidu.tieba.personCenter.view.c idv;
    PersonCenterModel.a idw = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(f fVar) {
            b.this.idv.aHK();
            b.this.idv.b(fVar);
            if (fVar != null && fVar.getUserData() != null) {
                e.a(fVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.idu.mIsDataLoaded) {
                b.this.idv.V(i, str);
            } else {
                b.this.idv.aHJ();
            }
        }
    };
    private CustomMessageListener idx = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                com.baidu.tieba.o.b bVar = (com.baidu.tieba.o.b) customResponsedMessage.getData();
                if (bVar.iHS != null && bVar.iHS.size() > 0) {
                    b.a aVar = bVar.iHS.get(2);
                    b.a aVar2 = bVar.iHS.get(3);
                    b.a aVar3 = bVar.iHS.get(9);
                    b.a aVar4 = bVar.iHS.get(10);
                    if (b.this.idu.bYx() != null) {
                        if (aVar2 != null) {
                            b.this.idu.bYx().po(aVar2.hdk);
                        }
                        if (aVar != null) {
                            b.this.idu.bYx().pr(aVar.hdk);
                        }
                        if (aVar3 != null) {
                            b.this.idu.bYx().pq(aVar3.hdk);
                        }
                        if (aVar4 != null) {
                            b.this.idu.bYx().pp(aVar4.hdk);
                        }
                    }
                    b.a aVar5 = bVar.iHS.get(5);
                    if (aVar5 != null) {
                        b.this.idv.N(5, aVar5.hdk);
                    }
                    b.a aVar6 = bVar.iHS.get(6);
                    if (aVar6 != null) {
                        b.this.idv.N(6, aVar6.hdk);
                    }
                    b.this.idv.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener cUO = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.o.a.cga().qi(false);
            }
        }
    };
    private CustomMessageListener idy = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            l lVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l) && (lVar = (l) customResponsedMessage.getData()) != null) {
                if (b.this.idu.bYx() != null) {
                    b.this.idu.bYx().a(lVar);
                    b.this.idv.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.idv = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.idv.a(this);
        this.idu = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.idu.a(this.idw);
        com.baidu.tieba.o.a.cga();
        this.idx.setTag(bdUniqueId);
        this.cUO.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.idx);
        MessageManager.getInstance().registerListener(this.cUO);
        this.idy.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.idy);
    }

    public void BO(String str) {
        f bYx = this.idu.bYx();
        if (bYx != null && bYx.getUserData() != null) {
            bYx.getUserData().setName_show(str);
            this.idv.notifyDataSetChanged();
        }
    }

    public void BP(String str) {
        f bYx = this.idu.bYx();
        if (bYx != null && bYx.getUserData() != null) {
            bYx.getUserData().setPortrait(str);
            this.idv.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        this.idu.LoadData();
    }

    public void initView() {
        this.idv.initView();
    }

    public void pn(boolean z) {
        this.idu.pn(z);
    }

    public void onDestroy() {
        this.idv.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.idv.onChangeSkinType(i);
    }

    public void bYo() {
        this.idv.bYm();
    }

    public void bYp() {
        this.idv.bYn();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void cG(View view) {
        this.idu.LoadData();
    }
}
