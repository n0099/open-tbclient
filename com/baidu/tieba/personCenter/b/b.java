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
    private PersonCenterModel ido;
    private com.baidu.tieba.personCenter.view.c idp;
    PersonCenterModel.a idq = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(f fVar) {
            b.this.idp.aHH();
            b.this.idp.b(fVar);
            if (fVar != null && fVar.getUserData() != null) {
                e.a(fVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.ido.mIsDataLoaded) {
                b.this.idp.V(i, str);
            } else {
                b.this.idp.aHG();
            }
        }
    };
    private CustomMessageListener idr = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                com.baidu.tieba.o.b bVar = (com.baidu.tieba.o.b) customResponsedMessage.getData();
                if (bVar.iHM != null && bVar.iHM.size() > 0) {
                    b.a aVar = bVar.iHM.get(2);
                    b.a aVar2 = bVar.iHM.get(3);
                    b.a aVar3 = bVar.iHM.get(9);
                    b.a aVar4 = bVar.iHM.get(10);
                    if (b.this.ido.bYt() != null) {
                        if (aVar2 != null) {
                            b.this.ido.bYt().pn(aVar2.hdg);
                        }
                        if (aVar != null) {
                            b.this.ido.bYt().pq(aVar.hdg);
                        }
                        if (aVar3 != null) {
                            b.this.ido.bYt().pp(aVar3.hdg);
                        }
                        if (aVar4 != null) {
                            b.this.ido.bYt().po(aVar4.hdg);
                        }
                    }
                    b.a aVar5 = bVar.iHM.get(5);
                    if (aVar5 != null) {
                        b.this.idp.N(5, aVar5.hdg);
                    }
                    b.a aVar6 = bVar.iHM.get(6);
                    if (aVar6 != null) {
                        b.this.idp.N(6, aVar6.hdg);
                    }
                    b.this.idp.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener cUM = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.o.a.cfX().qh(false);
            }
        }
    };
    private CustomMessageListener idu = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            l lVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l) && (lVar = (l) customResponsedMessage.getData()) != null) {
                if (b.this.ido.bYt() != null) {
                    b.this.ido.bYt().a(lVar);
                    b.this.idp.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.idp = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.idp.a(this);
        this.ido = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.ido.a(this.idq);
        com.baidu.tieba.o.a.cfX();
        this.idr.setTag(bdUniqueId);
        this.cUM.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.idr);
        MessageManager.getInstance().registerListener(this.cUM);
        this.idu.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.idu);
    }

    public void BM(String str) {
        f bYt = this.ido.bYt();
        if (bYt != null && bYt.getUserData() != null) {
            bYt.getUserData().setName_show(str);
            this.idp.notifyDataSetChanged();
        }
    }

    public void BN(String str) {
        f bYt = this.ido.bYt();
        if (bYt != null && bYt.getUserData() != null) {
            bYt.getUserData().setPortrait(str);
            this.idp.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        this.ido.LoadData();
    }

    public void initView() {
        this.idp.initView();
        this.ido.LoadData();
    }

    public void pm(boolean z) {
        this.ido.pm(z);
    }

    public void onDestroy() {
        this.idp.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.idp.onChangeSkinType(i);
    }

    public void bYk() {
        this.idp.bYi();
    }

    public void bYl() {
        this.idp.bYj();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void cG(View view) {
        this.ido.LoadData();
    }
}
