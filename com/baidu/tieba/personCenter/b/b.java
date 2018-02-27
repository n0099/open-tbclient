package com.baidu.tieba.personCenter.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.a.f;
import com.baidu.tbadk.data.h;
import com.baidu.tieba.m.b;
import com.baidu.tieba.personCenter.data.d;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import com.baidu.tieba.personCenter.view.c;
/* loaded from: classes.dex */
public class b implements c.a {
    private PersonCenterModel giU;
    private com.baidu.tieba.personCenter.view.c giV;
    PersonCenterModel.a giW = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(d dVar) {
            b.this.giV.XM();
            b.this.giV.b(dVar);
            if (dVar != null && dVar.getUserData() != null) {
                f.a(dVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.giU.mIsDataLoaded) {
                b.this.giV.ac(i, str);
            } else {
                b.this.giV.XL();
            }
        }
    };
    private CustomMessageListener giX = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.m.b)) {
                com.baidu.tieba.m.b bVar = (com.baidu.tieba.m.b) customResponsedMessage.getData();
                if (bVar.gJE != null && bVar.gJE.size() > 0) {
                    b.a aVar = bVar.gJE.get(2);
                    b.a aVar2 = bVar.gJE.get(3);
                    b.a aVar3 = bVar.gJE.get(9);
                    b.a aVar4 = bVar.gJE.get(10);
                    if (b.this.giU.biL() != null) {
                        if (aVar2 != null) {
                            b.this.giU.biL().lq(aVar2.ffU);
                        }
                        if (aVar != null) {
                            b.this.giU.biL().lt(aVar.ffU);
                        }
                        if (aVar3 != null) {
                            b.this.giU.biL().ls(aVar3.ffU);
                        }
                        if (aVar4 != null) {
                            b.this.giU.biL().lr(aVar4.ffU);
                        }
                    }
                    b.a aVar5 = bVar.gJE.get(5);
                    if (aVar5 != null) {
                        b.this.giV.Q(5, aVar5.ffU);
                    }
                    b.a aVar6 = bVar.gJE.get(6);
                    if (aVar6 != null) {
                        b.this.giV.Q(6, aVar6.ffU);
                    }
                    b.this.giV.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener bRZ = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.m.a.bpl().mc(false);
            }
        }
    };
    private CustomMessageListener giY = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            h hVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof h) && (hVar = (h) customResponsedMessage.getData()) != null) {
                if (b.this.giU.biL() != null) {
                    b.this.giU.biL().setUserPendantData(hVar);
                    b.this.giV.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.giV = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.giV.a(this);
        this.giU = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.giU.a(this.giW);
        com.baidu.tieba.m.a.bpl();
        this.giX.setTag(bdUniqueId);
        this.bRZ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.giX);
        MessageManager.getInstance().registerListener(this.bRZ);
        this.giY.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.giY);
    }

    public void refreshView() {
        this.giU.LoadData();
    }

    public void initView() {
        this.giV.initView();
        this.giU.LoadData();
    }

    public void onDestroy() {
        this.giV.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.giV.onChangeSkinType(i);
    }

    public void biH() {
        this.giV.biF();
    }

    public void biI() {
        this.giV.biG();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void cG(View view) {
        this.giU.LoadData();
    }
}
