package com.baidu.tieba.personCenter.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.a.f;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.h;
import com.baidu.tieba.m.b;
import com.baidu.tieba.personCenter.data.d;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import com.baidu.tieba.personCenter.view.c;
/* loaded from: classes.dex */
public class b implements c.a {
    private PersonCenterModel gfy;
    private com.baidu.tieba.personCenter.view.c gfz;
    PersonCenterModel.a gfA = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(d dVar) {
            b.this.gfz.WQ();
            b.this.gfz.b(dVar);
            if (dVar != null && dVar.getUserData() != null) {
                f.a(dVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.gfy.mIsDataLoaded) {
                b.this.gfz.aa(i, str);
            } else {
                b.this.gfz.Yb();
            }
        }
    };
    private CustomMessageListener gfB = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.m.b)) {
                com.baidu.tieba.m.b bVar = (com.baidu.tieba.m.b) customResponsedMessage.getData();
                if (bVar.gRK != null && bVar.gRK.size() > 0) {
                    b.a aVar = bVar.gRK.get(2);
                    b.a aVar2 = bVar.gRK.get(3);
                    b.a aVar3 = bVar.gRK.get(9);
                    b.a aVar4 = bVar.gRK.get(10);
                    if (b.this.gfy.bhA() != null) {
                        if (aVar2 != null) {
                            b.this.gfy.bhA().le(aVar2.eZU);
                        }
                        if (aVar != null) {
                            b.this.gfy.bhA().lh(aVar.eZU);
                        }
                        if (aVar3 != null) {
                            b.this.gfy.bhA().lg(aVar3.eZU);
                        }
                        if (aVar4 != null) {
                            b.this.gfy.bhA().lf(aVar4.eZU);
                        }
                    }
                    b.a aVar5 = bVar.gRK.get(5);
                    if (aVar5 != null) {
                        b.this.gfz.K(5, aVar5.eZU);
                    }
                    b.a aVar6 = bVar.gRK.get(6);
                    if (aVar6 != null) {
                        b.this.gfz.K(6, aVar6.eZU);
                    }
                    b.this.gfz.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener bPO = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.m.a.buv().mQ(false);
            }
        }
    };
    private CustomMessageListener gfC = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            h hVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof h) && (hVar = (h) customResponsedMessage.getData()) != null) {
                if (b.this.gfy.bhA() != null) {
                    b.this.gfy.bhA().setUserPendantData(hVar);
                    b.this.gfz.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gfz = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.gfz.a(this);
        this.gfy = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.gfy.a(this.gfA);
        com.baidu.tieba.m.a.buv();
        this.gfB.setTag(bdUniqueId);
        this.bPO.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gfB);
        MessageManager.getInstance().registerListener(this.bPO);
        this.gfC.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gfC);
    }

    public void refreshView() {
        this.gfy.LoadData();
    }

    public void initView() {
        this.gfz.initView();
        this.gfy.LoadData();
    }

    public void onDestroy() {
        this.gfz.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.gfz.onChangeSkinType(i);
    }

    public void bhw() {
        this.gfz.bhu();
    }

    public void bhx() {
        this.gfz.bhv();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void cF(View view) {
        this.gfy.LoadData();
    }
}
