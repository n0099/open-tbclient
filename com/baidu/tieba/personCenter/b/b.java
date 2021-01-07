package com.baidu.tieba.personCenter.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.a.e;
import com.baidu.tbadk.data.n;
import com.baidu.tieba.p.b;
import com.baidu.tieba.personCenter.c.f;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import com.baidu.tieba.personCenter.view.c;
/* loaded from: classes2.dex */
public class b implements c.a {
    private PersonCenterModel moW;
    private com.baidu.tieba.personCenter.view.c moX;
    PersonCenterModel.a moY = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(f fVar) {
            long currentTimeMillis = System.currentTimeMillis();
            b.this.moX.Zj();
            b.this.moX.b(fVar);
            if (fVar != null && fVar.getUserData() != null) {
                e.a(fVar.getUserData().getPersonPrivate());
            }
            com.baidu.tieba.personCenter.a.dyc().ho(System.currentTimeMillis() - currentTimeMillis);
            long dye = com.baidu.tieba.personCenter.a.dyc().dye();
            if (dye > 0) {
                com.baidu.tieba.personCenter.a.dyc().setRefreshTime(System.currentTimeMillis() - dye);
                com.baidu.tieba.personCenter.a.dyc().hp(0L);
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.moW.mIsDataLoaded) {
                b.this.moX.bh(i, str);
            } else {
                b.this.moX.bUI();
            }
        }
    };
    private CustomMessageListener moZ = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                com.baidu.tieba.p.b bVar = (com.baidu.tieba.p.b) customResponsedMessage.getData();
                if (bVar.mWW != null && bVar.mWW.size() > 0) {
                    b.a aVar = bVar.mWW.get(2);
                    b.a aVar2 = bVar.mWW.get(3);
                    b.a aVar3 = bVar.mWW.get(9);
                    b.a aVar4 = bVar.mWW.get(10);
                    if (b.this.moW.dys() != null) {
                        if (aVar2 != null) {
                            b.this.moW.dys().wt(aVar2.duv);
                        }
                        if (aVar != null) {
                            b.this.moW.dys().ww(aVar.duv);
                        }
                        if (aVar3 != null) {
                            b.this.moW.dys().wv(aVar3.duv);
                        }
                        if (aVar4 != null) {
                            b.this.moW.dys().wu(aVar4.duv);
                        }
                    }
                    b.a aVar5 = bVar.mWW.get(5);
                    if (aVar5 != null) {
                        b.this.moX.ae(5, aVar5.duv);
                    }
                    b.a aVar6 = bVar.mWW.get(6);
                    if (aVar6 != null) {
                        b.this.moX.ae(6, aVar6.duv);
                    }
                    b.this.moX.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener git = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.p.a.dGE().xu(false);
            }
        }
    };
    private CustomMessageListener mUpdatePendantListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof n) && (nVar = (n) customResponsedMessage.getData()) != null) {
                if (b.this.moW.dys() != null) {
                    b.this.moW.dys().a(nVar);
                    b.this.moX.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.moX = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.moX.a(this);
        this.moW = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.moW.a(this.moY);
        com.baidu.tieba.p.a.dGE();
        this.moZ.setTag(bdUniqueId);
        this.git.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.moZ);
        MessageManager.getInstance().registerListener(this.git);
        this.mUpdatePendantListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUpdatePendantListener);
    }

    public void Qz(String str) {
        f dys = this.moW.dys();
        if (dys != null && dys.getUserData() != null) {
            dys.getUserData().setName_show(str);
            this.moX.notifyDataSetChanged();
        }
    }

    public void QA(String str) {
        f dys = this.moW.dys();
        if (dys != null && dys.getUserData() != null) {
            dys.getUserData().setPortrait(str);
            this.moX.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        com.baidu.tieba.personCenter.a.dyc().hp(System.currentTimeMillis());
        this.moW.LoadData();
    }

    public void initView() {
        this.moX.initView();
    }

    public void ws(boolean z) {
        this.moW.ws(z);
    }

    public void onDestroy() {
        this.moX.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.moX.onChangeSkinType(i);
    }

    public void dyj() {
        this.moX.dyh();
    }

    public void dyk() {
        this.moX.dyi();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void dX(View view) {
        this.moW.LoadData();
    }
}
