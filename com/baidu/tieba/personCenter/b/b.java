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
    private PersonCenterModel moX;
    private com.baidu.tieba.personCenter.view.c moY;
    PersonCenterModel.a moZ = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(f fVar) {
            long currentTimeMillis = System.currentTimeMillis();
            b.this.moY.Zi();
            b.this.moY.b(fVar);
            if (fVar != null && fVar.getUserData() != null) {
                e.a(fVar.getUserData().getPersonPrivate());
            }
            com.baidu.tieba.personCenter.a.dyb().ho(System.currentTimeMillis() - currentTimeMillis);
            long dyd = com.baidu.tieba.personCenter.a.dyb().dyd();
            if (dyd > 0) {
                com.baidu.tieba.personCenter.a.dyb().setRefreshTime(System.currentTimeMillis() - dyd);
                com.baidu.tieba.personCenter.a.dyb().hp(0L);
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.moX.mIsDataLoaded) {
                b.this.moY.bh(i, str);
            } else {
                b.this.moY.bUH();
            }
        }
    };
    private CustomMessageListener mpa = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                com.baidu.tieba.p.b bVar = (com.baidu.tieba.p.b) customResponsedMessage.getData();
                if (bVar.mWX != null && bVar.mWX.size() > 0) {
                    b.a aVar = bVar.mWX.get(2);
                    b.a aVar2 = bVar.mWX.get(3);
                    b.a aVar3 = bVar.mWX.get(9);
                    b.a aVar4 = bVar.mWX.get(10);
                    if (b.this.moX.dyr() != null) {
                        if (aVar2 != null) {
                            b.this.moX.dyr().wt(aVar2.duv);
                        }
                        if (aVar != null) {
                            b.this.moX.dyr().ww(aVar.duv);
                        }
                        if (aVar3 != null) {
                            b.this.moX.dyr().wv(aVar3.duv);
                        }
                        if (aVar4 != null) {
                            b.this.moX.dyr().wu(aVar4.duv);
                        }
                    }
                    b.a aVar5 = bVar.mWX.get(5);
                    if (aVar5 != null) {
                        b.this.moY.ae(5, aVar5.duv);
                    }
                    b.a aVar6 = bVar.mWX.get(6);
                    if (aVar6 != null) {
                        b.this.moY.ae(6, aVar6.duv);
                    }
                    b.this.moY.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener git = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.p.a.dGD().xu(false);
            }
        }
    };
    private CustomMessageListener mUpdatePendantListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof n) && (nVar = (n) customResponsedMessage.getData()) != null) {
                if (b.this.moX.dyr() != null) {
                    b.this.moX.dyr().a(nVar);
                    b.this.moY.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.moY = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.moY.a(this);
        this.moX = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.moX.a(this.moZ);
        com.baidu.tieba.p.a.dGD();
        this.mpa.setTag(bdUniqueId);
        this.git.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mpa);
        MessageManager.getInstance().registerListener(this.git);
        this.mUpdatePendantListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUpdatePendantListener);
    }

    public void QA(String str) {
        f dyr = this.moX.dyr();
        if (dyr != null && dyr.getUserData() != null) {
            dyr.getUserData().setName_show(str);
            this.moY.notifyDataSetChanged();
        }
    }

    public void QB(String str) {
        f dyr = this.moX.dyr();
        if (dyr != null && dyr.getUserData() != null) {
            dyr.getUserData().setPortrait(str);
            this.moY.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        com.baidu.tieba.personCenter.a.dyb().hp(System.currentTimeMillis());
        this.moX.LoadData();
    }

    public void initView() {
        this.moY.initView();
    }

    public void ws(boolean z) {
        this.moX.ws(z);
    }

    public void onDestroy() {
        this.moY.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.moY.onChangeSkinType(i);
    }

    public void dyi() {
        this.moY.dyg();
    }

    public void dyj() {
        this.moY.dyh();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void dX(View view) {
        this.moX.LoadData();
    }
}
