package com.baidu.tieba.personCenter.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.a.e;
import com.baidu.tbadk.data.m;
import com.baidu.tieba.personCenter.c.f;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import com.baidu.tieba.personCenter.view.c;
import com.baidu.tieba.q.b;
/* loaded from: classes21.dex */
public class b implements c.a {
    private PersonCenterModel lVF;
    private com.baidu.tieba.personCenter.view.c lVG;
    PersonCenterModel.a lVH = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(f fVar) {
            long currentTimeMillis = System.currentTimeMillis();
            b.this.lVG.VB();
            b.this.lVG.b(fVar);
            if (fVar != null && fVar.getUserData() != null) {
                e.a(fVar.getUserData().getPersonPrivate());
            }
            com.baidu.tieba.personCenter.a.dsT().gO(System.currentTimeMillis() - currentTimeMillis);
            long dsV = com.baidu.tieba.personCenter.a.dsT().dsV();
            if (dsV > 0) {
                com.baidu.tieba.personCenter.a.dsT().setRefreshTime(System.currentTimeMillis() - dsV);
                com.baidu.tieba.personCenter.a.dsT().gP(0L);
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.lVF.mIsDataLoaded) {
                b.this.lVG.bf(i, str);
            } else {
                b.this.lVG.bOt();
            }
        }
    };
    private CustomMessageListener lVI = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.q.b)) {
                com.baidu.tieba.q.b bVar = (com.baidu.tieba.q.b) customResponsedMessage.getData();
                if (bVar.mDu != null && bVar.mDu.size() > 0) {
                    b.a aVar = bVar.mDu.get(2);
                    b.a aVar2 = bVar.mDu.get(3);
                    b.a aVar3 = bVar.mDu.get(9);
                    b.a aVar4 = bVar.mDu.get(10);
                    if (b.this.lVF.dtj() != null) {
                        if (aVar2 != null) {
                            b.this.lVF.dtj().vO(aVar2.dix);
                        }
                        if (aVar != null) {
                            b.this.lVF.dtj().vR(aVar.dix);
                        }
                        if (aVar3 != null) {
                            b.this.lVF.dtj().vQ(aVar3.dix);
                        }
                        if (aVar4 != null) {
                            b.this.lVF.dtj().vP(aVar4.dix);
                        }
                    }
                    b.a aVar5 = bVar.mDu.get(5);
                    if (aVar5 != null) {
                        b.this.lVG.ag(5, aVar5.dix);
                    }
                    b.a aVar6 = bVar.mDu.get(6);
                    if (aVar6 != null) {
                        b.this.lVG.ag(6, aVar6.dix);
                    }
                    b.this.lVG.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener fQB = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.q.a.dBC().wP(false);
            }
        }
    };
    private CustomMessageListener mUpdatePendantListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            m mVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof m) && (mVar = (m) customResponsedMessage.getData()) != null) {
                if (b.this.lVF.dtj() != null) {
                    b.this.lVF.dtj().a(mVar);
                    b.this.lVG.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.lVG = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.lVG.a(this);
        this.lVF = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.lVF.a(this.lVH);
        com.baidu.tieba.q.a.dBC();
        this.lVI.setTag(bdUniqueId);
        this.fQB.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.lVI);
        MessageManager.getInstance().registerListener(this.fQB);
        this.mUpdatePendantListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUpdatePendantListener);
    }

    public void PL(String str) {
        f dtj = this.lVF.dtj();
        if (dtj != null && dtj.getUserData() != null) {
            dtj.getUserData().setName_show(str);
            this.lVG.notifyDataSetChanged();
        }
    }

    public void PM(String str) {
        f dtj = this.lVF.dtj();
        if (dtj != null && dtj.getUserData() != null) {
            dtj.getUserData().setPortrait(str);
            this.lVG.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        com.baidu.tieba.personCenter.a.dsT().gP(System.currentTimeMillis());
        this.lVF.LoadData();
    }

    public void initView() {
        this.lVG.initView();
    }

    public void vN(boolean z) {
        this.lVF.vN(z);
    }

    public void onDestroy() {
        this.lVG.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.lVG.onChangeSkinType(i);
    }

    public void dta() {
        this.lVG.dsY();
    }

    public void dtb() {
        this.lVG.dsZ();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void dC(View view) {
        this.lVF.LoadData();
    }
}
