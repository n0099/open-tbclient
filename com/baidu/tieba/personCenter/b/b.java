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
    private PersonCenterModel lCU;
    private com.baidu.tieba.personCenter.view.c lCV;
    PersonCenterModel.a lCW = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(f fVar) {
            long currentTimeMillis = System.currentTimeMillis();
            b.this.lCV.SK();
            b.this.lCV.b(fVar);
            if (fVar != null && fVar.getUserData() != null) {
                e.a(fVar.getUserData().getPersonPrivate());
            }
            com.baidu.tieba.personCenter.a.dnK().go(System.currentTimeMillis() - currentTimeMillis);
            long dnM = com.baidu.tieba.personCenter.a.dnK().dnM();
            if (dnM > 0) {
                com.baidu.tieba.personCenter.a.dnK().setRefreshTime(System.currentTimeMillis() - dnM);
                com.baidu.tieba.personCenter.a.dnK().gp(0L);
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.lCU.mIsDataLoaded) {
                b.this.lCV.bb(i, str);
            } else {
                b.this.lCV.bJY();
            }
        }
    };
    private CustomMessageListener lCX = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                com.baidu.tieba.p.b bVar = (com.baidu.tieba.p.b) customResponsedMessage.getData();
                if (bVar.mkx != null && bVar.mkx.size() > 0) {
                    b.a aVar = bVar.mkx.get(2);
                    b.a aVar2 = bVar.mkx.get(3);
                    b.a aVar3 = bVar.mkx.get(9);
                    b.a aVar4 = bVar.mkx.get(10);
                    if (b.this.lCU.doa() != null) {
                        if (aVar2 != null) {
                            b.this.lCU.doa().vl(aVar2.cVI);
                        }
                        if (aVar != null) {
                            b.this.lCU.doa().vo(aVar.cVI);
                        }
                        if (aVar3 != null) {
                            b.this.lCU.doa().vn(aVar3.cVI);
                        }
                        if (aVar4 != null) {
                            b.this.lCU.doa().vm(aVar4.cVI);
                        }
                    }
                    b.a aVar5 = bVar.mkx.get(5);
                    if (aVar5 != null) {
                        b.this.lCV.ag(5, aVar5.cVI);
                    }
                    b.a aVar6 = bVar.mkx.get(6);
                    if (aVar6 != null) {
                        b.this.lCV.ag(6, aVar6.cVI);
                    }
                    b.this.lCV.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener fCH = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.p.a.dwo().wm(false);
            }
        }
    };
    private CustomMessageListener mUpdatePendantListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            m mVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof m) && (mVar = (m) customResponsedMessage.getData()) != null) {
                if (b.this.lCU.doa() != null) {
                    b.this.lCU.doa().a(mVar);
                    b.this.lCV.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.lCV = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.lCV.a(this);
        this.lCU = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.lCU.a(this.lCW);
        com.baidu.tieba.p.a.dwo();
        this.lCX.setTag(bdUniqueId);
        this.fCH.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.lCX);
        MessageManager.getInstance().registerListener(this.fCH);
        this.mUpdatePendantListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUpdatePendantListener);
    }

    public void PB(String str) {
        f doa = this.lCU.doa();
        if (doa != null && doa.getUserData() != null) {
            doa.getUserData().setName_show(str);
            this.lCV.notifyDataSetChanged();
        }
    }

    public void PC(String str) {
        f doa = this.lCU.doa();
        if (doa != null && doa.getUserData() != null) {
            doa.getUserData().setPortrait(str);
            this.lCV.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        com.baidu.tieba.personCenter.a.dnK().gp(System.currentTimeMillis());
        this.lCU.LoadData();
    }

    public void initView() {
        this.lCV.initView();
    }

    public void vk(boolean z) {
        this.lCU.vk(z);
    }

    public void onDestroy() {
        this.lCV.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.lCV.onChangeSkinType(i);
    }

    public void dnR() {
        this.lCV.dnP();
    }

    public void dnS() {
        this.lCV.dnQ();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void dp(View view) {
        this.lCU.LoadData();
    }
}
