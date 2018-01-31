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
    private PersonCenterModel ghv;
    private com.baidu.tieba.personCenter.view.c ghw;
    PersonCenterModel.a ghx = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(d dVar) {
            b.this.ghw.WG();
            b.this.ghw.b(dVar);
            if (dVar != null && dVar.getUserData() != null) {
                f.a(dVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.ghv.mIsDataLoaded) {
                b.this.ghw.ae(i, str);
            } else {
                b.this.ghw.XR();
            }
        }
    };
    private CustomMessageListener ghy = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.m.b)) {
                com.baidu.tieba.m.b bVar = (com.baidu.tieba.m.b) customResponsedMessage.getData();
                if (bVar.gHo != null && bVar.gHo.size() > 0) {
                    b.a aVar = bVar.gHo.get(2);
                    b.a aVar2 = bVar.gHo.get(3);
                    b.a aVar3 = bVar.gHo.get(9);
                    b.a aVar4 = bVar.gHo.get(10);
                    if (b.this.ghv.bhC() != null) {
                        if (aVar2 != null) {
                            b.this.ghv.bhC().li(aVar2.fbP);
                        }
                        if (aVar != null) {
                            b.this.ghv.bhC().ll(aVar.fbP);
                        }
                        if (aVar3 != null) {
                            b.this.ghv.bhC().lk(aVar3.fbP);
                        }
                        if (aVar4 != null) {
                            b.this.ghv.bhC().lj(aVar4.fbP);
                        }
                    }
                    b.a aVar5 = bVar.gHo.get(5);
                    if (aVar5 != null) {
                        b.this.ghw.K(5, aVar5.fbP);
                    }
                    b.a aVar6 = bVar.gHo.get(6);
                    if (aVar6 != null) {
                        b.this.ghw.K(6, aVar6.fbP);
                    }
                    b.this.ghw.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener bQd = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.m.a.bnP().lU(false);
            }
        }
    };
    private CustomMessageListener ghz = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            h hVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof h) && (hVar = (h) customResponsedMessage.getData()) != null) {
                if (b.this.ghv.bhC() != null) {
                    b.this.ghv.bhC().setUserPendantData(hVar);
                    b.this.ghw.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.ghw = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.ghw.a(this);
        this.ghv = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.ghv.a(this.ghx);
        com.baidu.tieba.m.a.bnP();
        this.ghy.setTag(bdUniqueId);
        this.bQd.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ghy);
        MessageManager.getInstance().registerListener(this.bQd);
        this.ghz.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ghz);
    }

    public void refreshView() {
        this.ghv.LoadData();
    }

    public void initView() {
        this.ghw.initView();
        this.ghv.LoadData();
    }

    public void onDestroy() {
        this.ghw.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.ghw.onChangeSkinType(i);
    }

    public void bhy() {
        this.ghw.bhw();
    }

    public void bhz() {
        this.ghw.bhx();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void cH(View view) {
        this.ghv.LoadData();
    }
}
