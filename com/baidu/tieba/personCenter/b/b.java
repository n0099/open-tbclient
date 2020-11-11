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
    private PersonCenterModel lVn;
    private com.baidu.tieba.personCenter.view.c lVo;
    PersonCenterModel.a lVp = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(f fVar) {
            long currentTimeMillis = System.currentTimeMillis();
            b.this.lVo.Wk();
            b.this.lVo.b(fVar);
            if (fVar != null && fVar.getUserData() != null) {
                e.a(fVar.getUserData().getPersonPrivate());
            }
            com.baidu.tieba.personCenter.a.dtt().gL(System.currentTimeMillis() - currentTimeMillis);
            long dtv = com.baidu.tieba.personCenter.a.dtt().dtv();
            if (dtv > 0) {
                com.baidu.tieba.personCenter.a.dtt().setRefreshTime(System.currentTimeMillis() - dtv);
                com.baidu.tieba.personCenter.a.dtt().gM(0L);
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.lVn.mIsDataLoaded) {
                b.this.lVo.bh(i, str);
            } else {
                b.this.lVo.bPa();
            }
        }
    };
    private CustomMessageListener lVq = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                com.baidu.tieba.p.b bVar = (com.baidu.tieba.p.b) customResponsedMessage.getData();
                if (bVar.mCW != null && bVar.mCW.size() > 0) {
                    b.a aVar = bVar.mCW.get(2);
                    b.a aVar2 = bVar.mCW.get(3);
                    b.a aVar3 = bVar.mCW.get(9);
                    b.a aVar4 = bVar.mCW.get(10);
                    if (b.this.lVn.dtJ() != null) {
                        if (aVar2 != null) {
                            b.this.lVn.dtJ().vL(aVar2.dke);
                        }
                        if (aVar != null) {
                            b.this.lVn.dtJ().vO(aVar.dke);
                        }
                        if (aVar3 != null) {
                            b.this.lVn.dtJ().vN(aVar3.dke);
                        }
                        if (aVar4 != null) {
                            b.this.lVn.dtJ().vM(aVar4.dke);
                        }
                    }
                    b.a aVar5 = bVar.mCW.get(5);
                    if (aVar5 != null) {
                        b.this.lVo.ag(5, aVar5.dke);
                    }
                    b.a aVar6 = bVar.mCW.get(6);
                    if (aVar6 != null) {
                        b.this.lVo.ag(6, aVar6.dke);
                    }
                    b.this.lVo.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener fQS = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.p.a.dBY().wM(false);
            }
        }
    };
    private CustomMessageListener mUpdatePendantListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            m mVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof m) && (mVar = (m) customResponsedMessage.getData()) != null) {
                if (b.this.lVn.dtJ() != null) {
                    b.this.lVn.dtJ().a(mVar);
                    b.this.lVo.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.lVo = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.lVo.a(this);
        this.lVn = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.lVn.a(this.lVp);
        com.baidu.tieba.p.a.dBY();
        this.lVq.setTag(bdUniqueId);
        this.fQS.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.lVq);
        MessageManager.getInstance().registerListener(this.fQS);
        this.mUpdatePendantListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUpdatePendantListener);
    }

    public void Qq(String str) {
        f dtJ = this.lVn.dtJ();
        if (dtJ != null && dtJ.getUserData() != null) {
            dtJ.getUserData().setName_show(str);
            this.lVo.notifyDataSetChanged();
        }
    }

    public void Qr(String str) {
        f dtJ = this.lVn.dtJ();
        if (dtJ != null && dtJ.getUserData() != null) {
            dtJ.getUserData().setPortrait(str);
            this.lVo.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        com.baidu.tieba.personCenter.a.dtt().gM(System.currentTimeMillis());
        this.lVn.LoadData();
    }

    public void initView() {
        this.lVo.initView();
    }

    public void vK(boolean z) {
        this.lVn.vK(z);
    }

    public void onDestroy() {
        this.lVo.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.lVo.onChangeSkinType(i);
    }

    public void dtA() {
        this.lVo.dty();
    }

    public void dtB() {
        this.lVo.dtz();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void dy(View view) {
        this.lVn.LoadData();
    }
}
