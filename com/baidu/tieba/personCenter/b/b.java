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
    private PersonCenterModel ijJ;
    private com.baidu.tieba.personCenter.view.c ijK;
    PersonCenterModel.a ijL = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(f fVar) {
            b.this.ijK.aJh();
            b.this.ijK.b(fVar);
            if (fVar != null && fVar.getUserData() != null) {
                e.a(fVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.ijJ.mIsDataLoaded) {
                b.this.ijK.V(i, str);
            } else {
                b.this.ijK.aJg();
            }
        }
    };
    private CustomMessageListener ijM = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                com.baidu.tieba.o.b bVar = (com.baidu.tieba.o.b) customResponsedMessage.getData();
                if (bVar.iOk != null && bVar.iOk.size() > 0) {
                    b.a aVar = bVar.iOk.get(2);
                    b.a aVar2 = bVar.iOk.get(3);
                    b.a aVar3 = bVar.iOk.get(9);
                    b.a aVar4 = bVar.iOk.get(10);
                    if (b.this.ijJ.cbm() != null) {
                        if (aVar2 != null) {
                            b.this.ijJ.cbm().pC(aVar2.hjx);
                        }
                        if (aVar != null) {
                            b.this.ijJ.cbm().pF(aVar.hjx);
                        }
                        if (aVar3 != null) {
                            b.this.ijJ.cbm().pE(aVar3.hjx);
                        }
                        if (aVar4 != null) {
                            b.this.ijJ.cbm().pD(aVar4.hjx);
                        }
                    }
                    b.a aVar5 = bVar.iOk.get(5);
                    if (aVar5 != null) {
                        b.this.ijK.P(5, aVar5.hjx);
                    }
                    b.a aVar6 = bVar.iOk.get(6);
                    if (aVar6 != null) {
                        b.this.ijK.P(6, aVar6.hjx);
                    }
                    b.this.ijK.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener cWk = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.o.a.ciR().qx(false);
            }
        }
    };
    private CustomMessageListener ijN = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            l lVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l) && (lVar = (l) customResponsedMessage.getData()) != null) {
                if (b.this.ijJ.cbm() != null) {
                    b.this.ijJ.cbm().a(lVar);
                    b.this.ijK.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.ijK = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.ijK.a(this);
        this.ijJ = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.ijJ.a(this.ijL);
        com.baidu.tieba.o.a.ciR();
        this.ijM.setTag(bdUniqueId);
        this.cWk.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ijM);
        MessageManager.getInstance().registerListener(this.cWk);
        this.ijN.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ijN);
    }

    public void CB(String str) {
        f cbm = this.ijJ.cbm();
        if (cbm != null && cbm.getUserData() != null) {
            cbm.getUserData().setName_show(str);
            this.ijK.notifyDataSetChanged();
        }
    }

    public void CC(String str) {
        f cbm = this.ijJ.cbm();
        if (cbm != null && cbm.getUserData() != null) {
            cbm.getUserData().setPortrait(str);
            this.ijK.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        this.ijJ.LoadData();
    }

    public void initView() {
        this.ijK.initView();
    }

    public void pB(boolean z) {
        this.ijJ.pB(z);
    }

    public void onDestroy() {
        this.ijK.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.ijK.onChangeSkinType(i);
    }

    public void cbd() {
        this.ijK.cbb();
    }

    public void cbe() {
        this.ijK.cbc();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void cJ(View view) {
        this.ijJ.LoadData();
    }
}
