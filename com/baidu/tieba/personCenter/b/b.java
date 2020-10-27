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
import com.baidu.tieba.p.b;
import com.baidu.tieba.personCenter.c.f;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import com.baidu.tieba.personCenter.view.c;
/* loaded from: classes22.dex */
public class b implements c.a {
    private PersonCenterModel lPr;
    private com.baidu.tieba.personCenter.view.c lPs;
    PersonCenterModel.a lPt = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(f fVar) {
            long currentTimeMillis = System.currentTimeMillis();
            b.this.lPs.TK();
            b.this.lPs.b(fVar);
            if (fVar != null && fVar.getUserData() != null) {
                e.a(fVar.getUserData().getPersonPrivate());
            }
            com.baidu.tieba.personCenter.a.dqR().gp(System.currentTimeMillis() - currentTimeMillis);
            long dqT = com.baidu.tieba.personCenter.a.dqR().dqT();
            if (dqT > 0) {
                com.baidu.tieba.personCenter.a.dqR().setRefreshTime(System.currentTimeMillis() - dqT);
                com.baidu.tieba.personCenter.a.dqR().gq(0L);
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.lPr.mIsDataLoaded) {
                b.this.lPs.bd(i, str);
            } else {
                b.this.lPs.bMA();
            }
        }
    };
    private CustomMessageListener lPu = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                com.baidu.tieba.p.b bVar = (com.baidu.tieba.p.b) customResponsedMessage.getData();
                if (bVar.mwY != null && bVar.mwY.size() > 0) {
                    b.a aVar = bVar.mwY.get(2);
                    b.a aVar2 = bVar.mwY.get(3);
                    b.a aVar3 = bVar.mwY.get(9);
                    b.a aVar4 = bVar.mwY.get(10);
                    if (b.this.lPr.drh() != null) {
                        if (aVar2 != null) {
                            b.this.lPr.drh().vC(aVar2.dei);
                        }
                        if (aVar != null) {
                            b.this.lPr.drh().vF(aVar.dei);
                        }
                        if (aVar3 != null) {
                            b.this.lPr.drh().vE(aVar3.dei);
                        }
                        if (aVar4 != null) {
                            b.this.lPr.drh().vD(aVar4.dei);
                        }
                    }
                    b.a aVar5 = bVar.mwY.get(5);
                    if (aVar5 != null) {
                        b.this.lPs.ag(5, aVar5.dei);
                    }
                    b.a aVar6 = bVar.mwY.get(6);
                    if (aVar6 != null) {
                        b.this.lPs.ag(6, aVar6.dei);
                    }
                    b.this.lPs.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener fLc = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.p.a.dzw().wD(false);
            }
        }
    };
    private CustomMessageListener mUpdatePendantListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            m mVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof m) && (mVar = (m) customResponsedMessage.getData()) != null) {
                if (b.this.lPr.drh() != null) {
                    b.this.lPr.drh().a(mVar);
                    b.this.lPs.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.lPs = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.lPs.a(this);
        this.lPr = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.lPr.a(this.lPt);
        com.baidu.tieba.p.a.dzw();
        this.lPu.setTag(bdUniqueId);
        this.fLc.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.lPu);
        MessageManager.getInstance().registerListener(this.fLc);
        this.mUpdatePendantListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUpdatePendantListener);
    }

    public void PZ(String str) {
        f drh = this.lPr.drh();
        if (drh != null && drh.getUserData() != null) {
            drh.getUserData().setName_show(str);
            this.lPs.notifyDataSetChanged();
        }
    }

    public void Qa(String str) {
        f drh = this.lPr.drh();
        if (drh != null && drh.getUserData() != null) {
            drh.getUserData().setPortrait(str);
            this.lPs.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        com.baidu.tieba.personCenter.a.dqR().gq(System.currentTimeMillis());
        this.lPr.LoadData();
    }

    public void initView() {
        this.lPs.initView();
    }

    public void vB(boolean z) {
        this.lPr.vB(z);
    }

    public void onDestroy() {
        this.lPs.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.lPs.onChangeSkinType(i);
    }

    public void dqY() {
        this.lPs.dqW();
    }

    public void dqZ() {
        this.lPs.dqX();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void dt(View view) {
        this.lPr.LoadData();
    }
}
