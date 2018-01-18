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
    private PersonCenterModel gha;
    private com.baidu.tieba.personCenter.view.c ghb;
    PersonCenterModel.a ghc = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(d dVar) {
            b.this.ghb.WE();
            b.this.ghb.b(dVar);
            if (dVar != null && dVar.getUserData() != null) {
                f.a(dVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.gha.mIsDataLoaded) {
                b.this.ghb.ac(i, str);
            } else {
                b.this.ghb.XP();
            }
        }
    };
    private CustomMessageListener ghd = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.m.b)) {
                com.baidu.tieba.m.b bVar = (com.baidu.tieba.m.b) customResponsedMessage.getData();
                if (bVar.gGT != null && bVar.gGT.size() > 0) {
                    b.a aVar = bVar.gGT.get(2);
                    b.a aVar2 = bVar.gGT.get(3);
                    b.a aVar3 = bVar.gGT.get(9);
                    b.a aVar4 = bVar.gGT.get(10);
                    if (b.this.gha.bhB() != null) {
                        if (aVar2 != null) {
                            b.this.gha.bhB().lg(aVar2.fbu);
                        }
                        if (aVar != null) {
                            b.this.gha.bhB().lj(aVar.fbu);
                        }
                        if (aVar3 != null) {
                            b.this.gha.bhB().li(aVar3.fbu);
                        }
                        if (aVar4 != null) {
                            b.this.gha.bhB().lh(aVar4.fbu);
                        }
                    }
                    b.a aVar5 = bVar.gGT.get(5);
                    if (aVar5 != null) {
                        b.this.ghb.K(5, aVar5.fbu);
                    }
                    b.a aVar6 = bVar.gGT.get(6);
                    if (aVar6 != null) {
                        b.this.ghb.K(6, aVar6.fbu);
                    }
                    b.this.ghb.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener bPV = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.m.a.bnO().lS(false);
            }
        }
    };
    private CustomMessageListener ghe = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            h hVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof h) && (hVar = (h) customResponsedMessage.getData()) != null) {
                if (b.this.gha.bhB() != null) {
                    b.this.gha.bhB().setUserPendantData(hVar);
                    b.this.ghb.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.ghb = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.ghb.a(this);
        this.gha = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.gha.a(this.ghc);
        com.baidu.tieba.m.a.bnO();
        this.ghd.setTag(bdUniqueId);
        this.bPV.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ghd);
        MessageManager.getInstance().registerListener(this.bPV);
        this.ghe.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ghe);
    }

    public void refreshView() {
        this.gha.LoadData();
    }

    public void initView() {
        this.ghb.initView();
        this.gha.LoadData();
    }

    public void onDestroy() {
        this.ghb.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.ghb.onChangeSkinType(i);
    }

    public void bhx() {
        this.ghb.bhv();
    }

    public void bhy() {
        this.ghb.bhw();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void cH(View view) {
        this.gha.LoadData();
    }
}
